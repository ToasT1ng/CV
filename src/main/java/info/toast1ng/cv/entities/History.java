package info.toast1ng.cv.entities;

import info.toast1ng.cv.dto.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
        setHistoryId(historyId);
        this.type = type;
        this.name = name;
        this.description = description;
        this.moreDescription = moreDescription;
    }

    public void setHistoryId(long historyId) {
        if (historyId == 0) {
            historyId = new Date().getTime();
        }
        this.historyId = historyId;
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

    public HistoryDto toDto() {
        return HistoryDto.builder()
                .historyId(historyId)
                .type(type)
                .name(name)
                .description(description)
                .moreDescription(moreDescription)
                .build();
    }
}
