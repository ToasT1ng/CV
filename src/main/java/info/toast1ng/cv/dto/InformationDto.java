package info.toast1ng.cv.dto;

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
}
