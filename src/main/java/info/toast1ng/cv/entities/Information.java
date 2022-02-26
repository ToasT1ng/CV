package info.toast1ng.cv.entities;

import info.toast1ng.cv.dto.InformationDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Entity
public class Information {
    @Id
    @Column(name = "information_id")
    private long informationId;
    private String category;
    private String description;

    @Column(name = "greeting_or_not")
    private boolean greetingOrNot;

    @Builder
    public Information(long informationId, String category, String description, boolean greetingOrNot) {
        setInformationId(informationId, greetingOrNot);
        this.category = category;
        this.description = description;
        this.greetingOrNot = greetingOrNot;
    }

    public InformationDto toDto() {
        return InformationDto.builder()
                .informationId(informationId)
                .category(category)
                .description(description)
                .greetingOrNot(greetingOrNot)
                .build();
    }

    public void setInformationId(long informationId, boolean greetingOrNot) {
        if (informationId == 0 && !greetingOrNot) {
            informationId = new Date().getTime();
        }
        this.informationId = informationId;
    }
}
