package info.toast1ng.cv.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import info.toast1ng.cv.dto.EducationHistoryDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@NoArgsConstructor
@Getter
@Entity
public class EducationHistory {
    @Id
    @Column(name = "education_id")
    private long educationId;

    @Column(name = "school_name")
    private String schoolName;
    private String description;

    @JsonIgnore
    @Column(name = "start_date")
    private Date startDate;

    @JsonIgnore
    @Column(name = "end_date")
    private Date endDate;

    @Builder(builderMethodName = "dateBuilder")
    public EducationHistory(long educationId, String schoolName, String description, Date startDate, Date endDate) {
        this.educationId = educationId;
        this.schoolName = schoolName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public EducationHistoryDto toDto() {
        return EducationHistoryDto.dateBuilder()
                .educationId(educationId)
                .schoolName(schoolName)
                .description(description)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
