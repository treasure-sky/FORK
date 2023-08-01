package ms.twentythree.addefender.dto;
import lombok.*;
//import ms.twentythree.addefender.entity.DataEntity;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class DatabaseDto {

    private Long id;
    private String url;
    private boolean includesAd;
    private String summary;

//    public static DatabaseDto toDatabaseDto(DataEntity dataEntity) {
//        DatabaseDto dataDTO = new DatabaseDto();
//
//        dataDTO.setId(dataEntity.getId());
//        dataDTO.setUrl(dataEntity.getUrl());
//        dataDTO.setIncludesAd(dataEntity.isIncludesAd());
//        dataDTO.setSummary(dataEntity.getSummary());
//        return dataDTO;
//    }
}
