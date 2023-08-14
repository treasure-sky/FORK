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


    //https://api.openai.com/v1/chat/completions/question
    // 클라이언트로부터 수신한 질문에 대한 ChatGptService 호출 및 응답 반환
    @PostMapping("/question")
    public ResponseEntity<ChatResponse> sendQuestion(@RequestBody QuestionRequestDto requestDto) {

        ChatResponse chatResponse = chatGptService.askQuestion(requestDto);


        //Choice에서 필요한 Message 부분만을 가져오기 위해 재설정
        Choice choice = chatResponse.getChoices().get(0);
        Message assistantMessage = choice.getMessage();
        String content = assistantMessage.getContent();
        String role = assistantMessage.getRole();


        //Choice에서 필요한 Message 부분만을 가져오기 응답 방식 수정
        Message newMessage = Message.builder()
                .role(role)
                .content(content)
                .build();

        // 새로운 선택 사항이 포함된 객체 생성
        Choice newChoice = Choice.builder()
                .message(newMessage)
                .index(0)
                .finishReason("complete")
                .build();


        // 응답을 ChatResponse 형태로 가공하여 반환 (Dto)
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
