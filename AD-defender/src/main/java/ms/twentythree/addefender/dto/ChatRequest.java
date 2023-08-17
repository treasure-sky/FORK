package ms.twentythree.addefender.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import ms.twentythree.addefender.domain.Message;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@NoArgsConstructor
public class    ChatRequest implements Serializable {

    private String model;

    //대화 메시지 리스트
    private List<Message> messages;

    // 최대 생성 토큰 수
    @JsonProperty("max_tokens")
    private Integer maxTokens;

    // 생성 과정의 다양성을 조절하는 온도 값
    private Double temperature;

    //다양성 조절을 위한 top-p 확률 값
    @JsonProperty("top_p")
    private Double topP;

    @Builder
    public ChatRequest(String model, List<Message> messages,
                       Integer maxTokens, Double temperature, Double topP) {
        this.model = model;
        this.messages = messages;
        this.maxTokens = maxTokens;
        this.temperature = temperature;
        this.topP = topP;
    }
}




