package ms.twentythree.addefender.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatGptConfig {
    public static final Double TOP_P = 0.5;
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";

    public static final Integer MAX_TOKEN = 1000;
    public static final String ROLE = "user";
    public static final Double TEMPERATURE = 0.0;
    public static final String MEDIA_TYPE = "application/json; charset=UTF-8";
    public static final String URL = "https://api.openai.com/v1/chat/completions";
}
