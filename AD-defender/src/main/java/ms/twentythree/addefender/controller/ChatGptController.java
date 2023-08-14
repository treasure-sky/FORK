package ms.twentythree.addefender.controller;


import lombok.RequiredArgsConstructor;
import ms.twentythree.addefender.domain.Choice;
import ms.twentythree.addefender.domain.Message;
import ms.twentythree.addefender.dto.ChatResponse;
import ms.twentythree.addefender.dto.QuestionRequestDto;
import ms.twentythree.addefender.service.ChatGptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@RequestMapping("/chat-gpt")
@RestController
@RequiredArgsConstructor
public class ChatGptController {

    private final ChatGptService chatGptService;


    @PostMapping("/question")
    public ResponseEntity<ChatResponse> sendQuestion(@RequestBody QuestionRequestDto requestDto) {

        ChatResponse chatResponse = chatGptService.askQuestion(requestDto);

        Choice choice = chatResponse.getChoices().get(0);
        Message assistantMessage = choice.getMessage();
        String content = assistantMessage.getContent();
        String role = assistantMessage.getRole();


        Message newMessage = Message.builder()
                .role(role)
                .content(content)
                .build();

        Choice newChoice = Choice.builder()
                .message(newMessage)
                .index(0)
                .finishReason("complete")
                .build();

        // 응답을 ChatGptResponseDto 형태로 가공하여 반환
        ChatResponse responseDto = ChatResponse.builder()
                .id("unique_id")
                .object("chat_response")
                .created(LocalDate.now())
                .model("gpt-3.5-turbo")
                .choices(List.of(newChoice))
                .build();

        return ResponseEntity.ok(responseDto);
    }
}
