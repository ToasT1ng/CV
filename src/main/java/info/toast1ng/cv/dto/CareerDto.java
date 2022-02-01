package info.toast1ng.cv.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import info.toast1ng.cv.entities.Career;
import info.toast1ng.cv.util.CustomDateUtil;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@NoArgsConstructor
@Data
public class CareerDto {
    private long careerId;
    private String companyName;
    private String description;
    @JsonIgnore
    private Date startDate;
    private String startDateString;

    @JsonIgnore
    private Date endDate;
    private String endDateString;
    private boolean currentWorkOrNot;

    @Builder(builderMethodName = "dateBuilder")
    public CareerDto(long careerId, String companyName, String description, Date startDate, Date endDate, boolean currentWorkOrNot) {
        this.careerId = careerId;
        this.companyName = companyName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currentWorkOrNot = currentWorkOrNot;

        setDateString(startDate, endDate);
    }

    @Builder(builderMethodName = "dateStringBuilder")
    public CareerDto(long careerId, String companyName, String description, String startDateString, String endDateString, boolean currentWorkOrNot) {
        this.careerId = careerId;
        this.companyName = companyName;
        this.description = description;
        this.startDateString = startDateString;
        this.endDateString = endDateString;
        this.currentWorkOrNot = currentWorkOrNot;
    }

    private void setDateString(Date startDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(startDate);
        setStartDateString(CustomDateUtil.getDateString(calendar));

        calendar.setTime(endDate);
        setEndDateString(CustomDateUtil.getDateString(calendar));
    }

    public Career toEntity() {
        return Career.dateBuilder()
                .careerId(careerId)
                .companyName(companyName)
                .description(description)
                .startDate(startDate)
                .endDate(endDate)
                .currentWorkOrNot(currentWorkOrNot)
                .build();
    }
}
