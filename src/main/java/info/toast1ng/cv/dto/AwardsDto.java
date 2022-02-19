package info.toast1ng.cv.dto;

import info.toast1ng.cv.entities.History;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AwardsDto {
    private long awardsId;
    private String awardName;
    private String description;
    private String award;

    @Builder
    public AwardsDto(long awardsId, String awardName, String description, String award) {
        this.awardsId = awardsId;
        this.awardName = awardName;
        this.description = description;
        this.award = award;
    }

    public History toEntity() {
        return History.builder()
                .historyId(awardsId)
                .type(HistoryType.AWARDS)
                .name(awardName)
                .description(description)
                .moreDescription(award)
                .build();
    }
}
