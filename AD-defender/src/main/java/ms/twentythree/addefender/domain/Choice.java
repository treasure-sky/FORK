package ms.twentythree.addefender.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Getter
@NoArgsConstructor
@Data

public class Choice implements Serializable {

    private Integer index;
    private Message message;

    @JsonProperty("finish_reason")
    private String finishReason;

    @Builder
    public Choice(Message message, Integer index, String finishReason) {
        this.index = index;
        this.message = message;
        this.finishReason = finishReason;
    }
}
