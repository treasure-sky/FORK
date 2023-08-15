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

    //HTTP 응답을 위한 RestTemplate 선언
    private static RestTemplate restTemplate = new RestTemplate();


    //Headers Content-Type 등을 설정하여 외부 API 호출
    public HttpEntity<ChatRequest> buildHttpEntity(ChatRequest requestDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(ChatGptConfig.MEDIA_TYPE));
        headers.add(ChatGptConfig.AUTHORIZATION, ChatGptConfig.BEARER + API_KEY);
        return new HttpEntity<>(requestDto, headers);
    }


    //Chat gpt api에 요청 보내고 응답 반환
    public ChatResponse getResponse(HttpEntity<ChatRequest> chatGptRequestDtoHttpEntity) {
        ResponseEntity<ChatResponse> responseEntity = restTemplate.postForEntity(
                ChatGptConfig.URL,
                chatGptRequestDtoHttpEntity,
                ChatResponse.class);

        return responseEntity.getBody();
    }

    // 질문을 담은 메시지를 구성하고 ChatGPT API에 전송하여 응답 받기
    public ChatResponse askQuestion(QuestionRequestDto requestDto) {
        List<Message> messages = new ArrayList<>();

        // 질문을 담은 메시지 생성
        Message questionMessage = Message.builder()
                .role(ChatGptConfig.ROLE)
                .content(requestDto.getQuestion())
                .build();

        messages.add(questionMessage);

        // 질문 메시지와 추가 설정을 포함한 채팅 요청 구성
        ChatRequest chatRequest = ChatRequest.builder()
                .model(selectModelByRequestDto(requestDto))
                .messages(messages)
                .maxTokens(ChatGptConfig.MAX_TOKEN)
                .temperature(ChatGptConfig.TEMPERATURE)
                .topP(ChatGptConfig.TOP_P)
                .build();

        // ChatGPT API에 요청을 보내고 응답을 반환
        return this.getResponse(this.buildHttpEntity(chatRequest));
    }

    // 크롤링한 글자수에 따른 모델의 차등선정
    private String selectModelByRequestDto(QuestionRequestDto requestDto) {
        int dataLength = requestDto.getQuestion().length();

        if (dataLength < 2000) {
            return "gpt-3.5-turbo";
        } else {
            return "gpt-3.5-turbo-16k";
        }
    }

}