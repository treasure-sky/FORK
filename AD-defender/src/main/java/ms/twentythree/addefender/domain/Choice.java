package ms.twentythree.addefender.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
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
}
