package info.toast1ng.cv.entities;

import info.toast1ng.cv.dto.AwardsDto;
import info.toast1ng.cv.dto.CareerDto;
import info.toast1ng.cv.dto.HistoryType;
import info.toast1ng.cv.dto.EducationHistoryDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class History {
    @Id
    @Column(name = "history_id")
    private long historyId;

    @Enumerated(EnumType.STRING)
    private HistoryType type;
    private String name;
    private String description;

    @Column(name = "more_description")
    private String moreDescription;

    @Builder
    public History(long historyId, HistoryType type, String name, String description, String moreDescription) {
        this.historyId = historyId;
        this.type = type;
        this.name = name;
        this.description = description;
        this.moreDescription = moreDescription;
    }

    public CareerDto toCareerDto() {
        return CareerDto.builder()
                .careerId(historyId)
                .companyName(name)
                .description(description)
                .dateInformation(moreDescription)
                .build();
    }

    public EducationHistoryDto toEducationHistoryDto() {
        return EducationHistoryDto.builder()
                .educationId(historyId)
                .schoolName(name)
                .description(description)
                .dateInformation(moreDescription)
                .build();
    }

    public AwardsDto toAwardsDto() {
        return AwardsDto.builder()
                .awardsId(historyId)
                .awardName(name)
                .description(description)
                .award(moreDescription)
                .build();
    }
}
