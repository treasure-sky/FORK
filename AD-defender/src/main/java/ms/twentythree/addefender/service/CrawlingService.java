package ms.twentythree.addefender.service;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class CrawlingService {

    public Optional<String> extractContent(String url) {

        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36";

        try {
            String responseText;
            String domain = url.substring(8);

            // 네이버 블로그의 경우 모바일 사이트로 접속하여 본문만 가져옴
            if (domain.startsWith("m.blog.naver.com") || domain.startsWith("blog.naver.com")) {
                String baseUrl = domain.startsWith("m.blog.naver.com") ? url : "https://m." + domain;
                Document doc = Jsoup.connect(baseUrl).get();
                responseText = doc.select("#viewTypeSelector > div > div.se-main-container, #viewTypeSelector > div > div > div.se-main-container").text();
            }
            else {
                Document doc = Jsoup.connect(url)
                        .userAgent(userAgent) //User-Agent 우회
                        .header("X-Requested-With", "XMLHttpRequest") // X-Requested-With 헤더 설정
                        .get();
                responseText = doc.body().text();
            }
            return Optional.of(responseText);
        } catch (HttpStatusException e) {
            int statusCode = e.getStatusCode();
            if (statusCode == 404) {
                System.err.println("Page not found: "+statusCode);
                return Optional.empty();
            } else {
                // 다른 상태 코드 처리
                System.err.println("Unhandled status code: " + statusCode);
                return Optional.empty();
            }
        } catch (IOException e) {
            // 다른 I/O 예외 처리
            System.err.println("I/O error: " + e.getMessage());
            return Optional.empty();
        }
    }
}