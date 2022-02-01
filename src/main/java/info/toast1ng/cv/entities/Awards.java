package info.toast1ng.cv.entities;

import info.toast1ng.cv.dto.AwardsDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
@Getter
public class Awards {
    @Id
    @Column(name = "award_id")
    private long awardsId;

    @Column(name = "award_name")
    private String awardName;
    private String description;
    private String award;

    @Builder
    public Awards(long awardsId, String awardName, String description, String award) {
        this.awardsId = awardsId;
        this.awardName = awardName;
        this.description = description;
        this.award = award;
    }

    public AwardsDto toDto() {
        return AwardsDto.builder()
                .awardsId(awardsId)
                .awardName(awardName)
                .description(description)
                .award(award)
                .build();
    }
}
