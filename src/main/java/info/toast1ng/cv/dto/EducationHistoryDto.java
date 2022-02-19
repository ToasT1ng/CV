package info.toast1ng.cv.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import info.toast1ng.cv.entities.CareerAndEducationHistory;
import info.toast1ng.cv.util.CustomDateUtil;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@NoArgsConstructor
@Data
public class EducationHistoryDto {
    private long educationId;
    private String schoolName;
    private String description;

    @JsonIgnore
    private Date startDate;
    private String startDateString;

    @JsonIgnore
    private Date endDate;
    private String endDateString;

    @Builder(builderMethodName = "dateBuilder")
    public EducationHistoryDto(long educationId, String schoolName, String description, Date startDate, Date endDate) {
        this.educationId = educationId;
        this.schoolName = schoolName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;

        setDateString(startDate, endDate);
    }

    @Builder(builderMethodName = "dateStringBuilder")
    public EducationHistoryDto(long educationId, String schoolName, String description, String startDateString, String endDateString) {
        this.educationId = educationId;
        this.schoolName = schoolName;
        this.description = description;
        this.startDateString = startDateString;
        this.endDateString = endDateString;
    }

    private void setDateString(Date startDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(startDate);
        setStartDateString(CustomDateUtil.getDateString(calendar));

        calendar.setTime(endDate);
        setEndDateString(CustomDateUtil.getDateString(calendar));
    }


    public CareerAndEducationHistory toEntity() {
        return CareerAndEducationHistory.dateBuilder()
                .historyId(educationId)
                .type(CareerOrEducationType.EDUCATION_HISTORY)
                .name(schoolName)
                .description(description)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
