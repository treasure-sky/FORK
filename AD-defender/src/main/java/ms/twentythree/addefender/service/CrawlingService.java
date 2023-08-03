package ms.twentythree.addefender.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class CrawlingService {

    public Optional<String> extractContent(String url) {
        try {
            String responseText;
            String domain = url.substring(8);

            // 네이버 블로그의 경우 모바일 사이트로 접속하여 본문만 가져옴
            if (domain.startsWith("m.blog.naver.com") || domain.startsWith("blog.naver.com")) {
                String baseUrl = domain.startsWith("m.blog.naver.com") ? url : "https://m." + domain;
                Document doc = Jsoup.connect(baseUrl).get();
                responseText = doc.select("#viewTypeSelector > div > div.se-main-container").text();
            }

            // 타 블로그는 body의 전체 텍스트를 가져옴
            // 추후에 파싱 규칙 추가 요망
            else{
                Document doc = Jsoup.connect(url).get();
                responseText = doc.body().text();
            }
            return Optional.of(responseText);
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}