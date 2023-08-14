package ms.twentythree.addefender.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ms.twentythree.addefender.domain.Choice;
import ms.twentythree.addefender.domain.Usage;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Data
@Getter
@NoArgsConstructor
public class ChatResponse implements Serializable {

    private String id;
    private String object;
    private LocalDate created;
    private String model;
    private Usage usage;
    private List<Choice> choices;

    @Builder
    public ChatResponse(String id, String object,
                              LocalDate created, String model,
                              List<Choice> choices) {
        this.id = id;
        this.object = object;
        this.created = created;
        this.model = model;
        this.choices = choices;
    }
}

