package info.toast1ng.cv.dto;

import info.toast1ng.cv.entities.Information;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class InformationDto {
    private long informationId;
    private String category;
    private String description;
    private boolean greetingOrNot;

    @Builder
    public InformationDto(long informationId, String category, String description, boolean greetingOrNot) {
        this.informationId = informationId;
        this.category = category;
        this.description = description;
        this.greetingOrNot = greetingOrNot;
    }

    public Information toEntity() {
        return Information.builder()
                .informationId(informationId)
                .category(category)
                .description(description)
                .greetingOrNot(greetingOrNot)
                .build();
    }
}
