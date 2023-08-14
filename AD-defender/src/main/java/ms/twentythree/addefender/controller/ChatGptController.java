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


    //chat-gpt 와 간단한 채팅
    @PostMapping("/question")
    public ResponseEntity<ChatResponse> sendQuestion(@RequestBody QuestionRequestDto requestDto) {

        String response = String.valueOf(chatGptService.askQuestion(requestDto));

        Message message = Message.builder()
                .role("user")
                .content(response)
                .build();

        Choice choice = Choice.builder()
                .message(message)
                .index(0)
                .finishReason("complete")
                .build();

        // 응답을 ChatGptResponseDto 형태로 가공하여 반환
        ChatResponse responseDto = ChatResponse.builder()
                .id("unique_id")
                .object("chat_response")
                .created(LocalDate.now())
                .model("gpt-3.5-turbo")
                .choices(List.of(choice))
                .build();

        return ResponseEntity.ok(responseDto);
    }
}
