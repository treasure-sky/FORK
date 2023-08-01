package ms.twentythree.addefender.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ms.twentythree.addefender.dto.DatabaseDto;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Setter
@Getter
@Table(name = "data_table")
public class DataEntity {

    @Id //pk지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long id;

    @Column
    private String url;

    @Column(columnDefinition = "TINYINT(1)")
    @ColumnDefault("false")
    private boolean includesAd;
    @Column
    private String summary;



    public static DataEntity toMemberEntity(DatabaseDto databaseDto) {
        DataEntity dataEntity = new DataEntity();

        //DTO에 담긴걸 Entity로 전달
        dataEntity.setUrl(databaseDto.getUrl());
        dataEntity.setIncludesAd(databaseDto.isIncludesAd());
        dataEntity.setSummary(databaseDto.getSummary());
        return dataEntity;
    }
}
