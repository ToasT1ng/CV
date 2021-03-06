package info.toast1ng.cv.dto;

import info.toast1ng.cv.entities.ThingsDone;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ThingsDoneDto {
    private long thingsDoneId;
    private String era;
    private String category;
    private String description;

    @Builder
    public ThingsDoneDto(long thingsDoneId, String era, String category, String description) {
        this.thingsDoneId = thingsDoneId;
        this.era = era;
        this.category = category;
        this.description = description;
    }

    public ThingsDone toEntity() {
        return ThingsDone.builder()
                .thingsDoneId(thingsDoneId)
                .era(era)
                .category(category)
                .description(description)
                .build();
    }
}
