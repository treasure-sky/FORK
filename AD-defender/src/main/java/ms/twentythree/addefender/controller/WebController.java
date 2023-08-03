package ms.twentythree.addefender.controller;

import ms.twentythree.addefender.service.CrawlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;



@Controller
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



    @PostMapping("/")
    public String result(@RequestParam("url") String url) {
        Optional<String> extractedContent = crawlingService.extractContent(url);

        if (extractedContent.isPresent()) {
            System.out.println(extractedContent.toString());
            // html에 출력 하는 기능 추가 필요
            return "redirect:/";
        } else {
            // 크롤링 실패 처리 추가 필요
            return "redirect:/";
        }
    }
}
