package info.toast1ng.cv.dto;

import info.toast1ng.cv.entities.History;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CareerDto {
    private long careerId;
    private String companyName;
    private String description;
    private String dateInformation;

    @Builder
    public CareerDto(long careerId, String companyName, String description, String dateInformation) {
        this.careerId = careerId;
        this.companyName = companyName;
        this.description = description;
        this.dateInformation = dateInformation;
    }


    public History toEntity() {
        return History.builder()
                .historyId(careerId)
                .type(HistoryType.CAREER)
                .name(companyName)
                .description(description)
                .moreDescription(dateInformation)
                .build();
    }
}
