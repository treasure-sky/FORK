package ms.twentythree.addefender.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class CrawlingService {

    public Optional<String> extractContent(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            Element body = doc.body();

            // HTML에서 body 내 텍스트 크롤링
            // 파싱 규칙 수정 필요
            String responseText = body.text();
            return Optional.of(responseText);
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}