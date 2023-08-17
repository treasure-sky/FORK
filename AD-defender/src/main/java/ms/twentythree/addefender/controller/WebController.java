package ms.twentythree.addefender.controller;

import lombok.extern.slf4j.Slf4j;
import ms.twentythree.addefender.domain.Choice;
import ms.twentythree.addefender.domain.Message;
import ms.twentythree.addefender.dto.ChatResponse;
import ms.twentythree.addefender.dto.DatabaseDto;
import ms.twentythree.addefender.dto.QuestionRequestDto;
import ms.twentythree.addefender.repository.DatabaseRepository;
import ms.twentythree.addefender.service.CrawlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;


@RestController
@Slf4j
public class WebController {

    private final CrawlingService crawlingService;

    @Autowired
    public WebController(CrawlingService crawlingService) {

        this.crawlingService = crawlingService;
    }

    @GetMapping("/")
    public String main() {
        return "main";
    }


    @PostMapping("/result")
    public String result(@RequestBody DatabaseDto databaseDto, Model model) {
        String url = databaseDto.getLink();
        Optional<String> extractedContent = crawlingService.extractContent(url);
        if (extractedContent.isPresent()) {
            String content = extractedContent.get();

            // content를 가지고 ChatGptController로 POST 요청 보내기
            QuestionRequestDto requestDto = new QuestionRequestDto();
            requestDto.setQuestion(content + "다음 글이 광고성 글이면 '예'를 반환하고, 광고성 글이 아니면 '아니요'만 반환해. 그 외 말은 하지마");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<QuestionRequestDto> requestEntity = new HttpEntity<>(requestDto, headers);
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<ChatResponse> response = restTemplate.postForEntity("http://localhost:8080/chat-gpt/question", requestEntity, ChatResponse.class);

            log.info("response = {}", response);
            //결과값
            ChatResponse chatResponse = response.getBody();

            model.addAttribute("chatResponse", chatResponse);

            return "/result";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/result")
    public String Result(@ModelAttribute("chatResponse") ChatResponse chatResponse) {
        return "content";
    }
}
