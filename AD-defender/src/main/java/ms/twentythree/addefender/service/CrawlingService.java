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
            String mainUrl = url.substring(8);
            Document doc = Jsoup.connect("https://m."+mainUrl).get();
            String responseText = doc.select("#viewTypeSelector > div > div.se-main-container").text();
            return Optional.of(responseText);
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}