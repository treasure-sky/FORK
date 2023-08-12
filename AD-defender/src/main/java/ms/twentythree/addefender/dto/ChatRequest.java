package ms.twentythree.addefender.dto;

import lombok.*;
import ms.twentythree.addefender.domain.Message;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatRequest implements Serializable {

    private String model;
    private List<Message> messages;
}




