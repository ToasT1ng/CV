package info.toast1ng.cv.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import info.toast1ng.cv.util.CustomDateUtil;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@NoArgsConstructor
@Data
public class EducationHistoryDto {
    private long educationalId;
    private String schoolName;
    private String description;

    @JsonIgnore
    private Date startDate;
    private String startDateString;

    @JsonIgnore
    private Date endDate;
    private String endDateString;

    @Builder(builderMethodName = "dateBuilder")
    public EducationHistoryDto(long educationalId, String schoolName, String description, Date startDate, Date endDate) {
        this.educationalId = educationalId;
        this.schoolName = schoolName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;

        setDateString(startDate, endDate);
    }

    @Builder(builderMethodName = "dateStringBuilder")
    public EducationHistoryDto(long educationalId, String schoolName, String description, String startDateString, String endDateString) {
        this.educationalId = educationalId;
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


}
