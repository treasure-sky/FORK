package ms.twentythree.addefender.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import ms.twentythree.addefender.domain.Message;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@NoArgsConstructor
public class ChatRequest implements Serializable {

    private String model;
    private List<Message> messages;
    @JsonProperty("max_tokens")
    private Integer maxTokens;
    private Double temperature;
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




