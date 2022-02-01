package info.toast1ng.cv.dto;

import info.toast1ng.cv.entities.TechStack;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TechStackDto {
    private long techStackId;
    private String description;

    @Builder
    public TechStackDto(long techStackId, String description) {
        this.techStackId = techStackId;
        this.description = description;
    }

    public TechStack toEntity() {
        return TechStack.builder()
                .techStackId(techStackId)
                .description(description)
                .build();
    }
}
