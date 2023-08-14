package ms.twentythree.addefender.service;

import ms.twentythree.addefender.config.ChatGptConfig;
import ms.twentythree.addefender.domain.Message;
import ms.twentythree.addefender.dto.ChatRequest;
import ms.twentythree.addefender.dto.ChatResponse;
import ms.twentythree.addefender.dto.QuestionRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//Service
@Service
public class ChatGptService {

    @Value("${apikey}")
    private String API_KEY;

    private static RestTemplate restTemplate = new RestTemplate();

    public HttpEntity<ChatRequest> buildHttpEntity(ChatRequest requestDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(ChatGptConfig.MEDIA_TYPE));
        headers.add(ChatGptConfig.AUTHORIZATION, ChatGptConfig.BEARER + API_KEY);
        return new HttpEntity<>(requestDto, headers);
    }

    public ChatResponse getResponse(HttpEntity<ChatRequest> chatGptRequestDtoHttpEntity) {
        ResponseEntity<ChatResponse> responseEntity = restTemplate.postForEntity(
                ChatGptConfig.URL,
                chatGptRequestDtoHttpEntity,
                ChatResponse.class);

        return responseEntity.getBody();
    }

    public ChatResponse askQuestion(QuestionRequestDto requestDto) {
        List<Message> messages = new ArrayList<>();  // Create a list for messages

        Message questionMessage = Message.builder()  // Create a message for the question
                .role(ChatGptConfig.ROLE)  // Or any appropriate role value
                .content(requestDto.getQuestion())  // Use the question as content
                .build();

        messages.add(questionMessage);

        ChatRequest chatRequest = ChatRequest.builder()
                .model(ChatGptConfig.MODEL)
                .messages(messages)
                .maxTokens(ChatGptConfig.MAX_TOKEN)
                .temperature(ChatGptConfig.TEMPERATURE)
                .topP(ChatGptConfig.TOP_P)
                .build();

        return this.getResponse(this.buildHttpEntity(chatRequest));
    }

}