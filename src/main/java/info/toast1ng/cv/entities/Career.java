package info.toast1ng.cv.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import info.toast1ng.cv.dto.CareerDto;
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
public class Career {
    @Id
    @Column(name = "career_id")
    private long careerId;

    @Column(name = "company_name")
    private String companyName;
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
    public Career(long careerId, String companyName, String description, Date startDate, Date endDate, boolean currentWorkOrNot) {
        this.careerId = careerId;
        this.companyName = companyName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currentWorkOrNot = currentWorkOrNot;
    }

    public CareerDto toDto() {
        return CareerDto.dateBuilder()
                .careerId(careerId)
                .companyName(companyName)
                .description(description)
                .startDate(startDate)
                .endDate(endDate)
                .currentWorkOrNot(currentWorkOrNot)
                .build();
    }
}
