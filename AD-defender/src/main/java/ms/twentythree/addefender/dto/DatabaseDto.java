package ms.twentythree.addefender.dto;
import lombok.Data;

@Data
public class DatabaseDto {
    private int id;
    private String url;
    private boolean includesAd;
    private String summary;
}
