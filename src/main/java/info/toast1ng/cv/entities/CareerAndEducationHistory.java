package info.toast1ng.cv.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import info.toast1ng.cv.dto.CareerDto;
import info.toast1ng.cv.dto.CareerOrEducationType;
import info.toast1ng.cv.dto.EducationHistoryDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Entity
public class CareerAndEducationHistory {
    @Id
    @Column(name = "history_id")
    private long historyId;

    @Enumerated(EnumType.STRING)
    private CareerOrEducationType type;
    private String name;
    private String description;

    @JsonIgnore
    @Column(name = "start_date")
    private Date startDate;

    @JsonIgnore
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "current_work_or_not")
    private boolean currentWorkOrNot;

    @Builder(builderMethodName = "dateBuilder")
    public CareerAndEducationHistory(long historyId, CareerOrEducationType type, String name, String description, Date startDate, Date endDate, boolean currentWorkOrNot) {
        this.historyId = historyId;
        this.type = type;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currentWorkOrNot = currentWorkOrNot;
    }

    public CareerDto toCareerDto() {
        return CareerDto.dateBuilder()
                .careerId(historyId)
                .companyName(name)
                .description(description)
                .startDate(startDate)
                .endDate(endDate)
                .currentWorkOrNot(currentWorkOrNot)
                .build();
    }

    public EducationHistoryDto toEducationHistoryDto() {
        return EducationHistoryDto.dateBuilder()
                .educationId(historyId)
                .schoolName(name)
                .description(description)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
