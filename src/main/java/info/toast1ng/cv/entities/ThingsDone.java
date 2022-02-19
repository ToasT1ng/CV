package info.toast1ng.cv.entities;

import info.toast1ng.cv.dto.ThingsDoneDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
        setThingsDoneId(thingsDoneId);
        this.era = era;
        this.category = category;
        this.description = description;
    }

    public void setThingsDoneId(long thingsDoneId) {
        if (thingsDoneId == 0) {
            thingsDoneId = new Date().getTime();
        }
        this.thingsDoneId = thingsDoneId;
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
