package info.toast1ng.cv.dto;

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
}
