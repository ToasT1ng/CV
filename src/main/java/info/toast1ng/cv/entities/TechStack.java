package info.toast1ng.cv.entities;

import info.toast1ng.cv.dto.TechStackDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Entity
public class TechStack {
    @Id
    @Column(name = "tech_stack_id")
    private long techStackId;
    private String description;

    @Builder
    public TechStack(long techStackId, String description) {
        setTechStackId(techStackId);
        this.description = description;
    }

    public void setTechStackId(long techStackId) {
        if (techStackId == 0) {
            techStackId = new Date().getTime();
        }
        this.techStackId = techStackId;
    }

    public TechStackDto toDto() {
        return TechStackDto.builder()
                .techStackId(techStackId)
                .description(description)
                .build();
    }
}
