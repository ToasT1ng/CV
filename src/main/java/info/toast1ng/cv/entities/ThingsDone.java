package info.toast1ng.cv.entities;

import info.toast1ng.cv.dto.ThingsDoneDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class ThingsDone {
    @Id
    @Column(name = "things_done_id")
    private long thingsDoneId;
    private String era;
    private String category;
    private String description;

    @Builder
    public ThingsDone(long thingsDoneId, String era, String category, String description) {
        this.thingsDoneId = thingsDoneId;
        this.era = era;
        this.category = category;
        this.description = description;
    }

    public ThingsDoneDto toDto() {
        return ThingsDoneDto.builder()
                .thingsDoneId(thingsDoneId)
                .era(era)
                .category(category)
                .description(description)
                .build();
    }
}
