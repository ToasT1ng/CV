package info.toast1ng.cv.dto;

import info.toast1ng.cv.entities.History;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EducationHistoryDto {
    private long educationId;
    private String schoolName;
    private String description;
    private String dateInformation;

    @Builder
    public EducationHistoryDto(long educationId, String schoolName, String description, String dateInformation) {
        this.educationId = educationId;
        this.schoolName = schoolName;
        this.description = description;
        this.dateInformation = dateInformation;
    }


    public History toEntity() {
        return History.builder()
                .historyId(educationId)
                .type(HistoryType.EDUCATION_HISTORY)
                .name(schoolName)
                .description(description)
                .moreDescription(dateInformation)
                .build();
    }
}
