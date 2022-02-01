package info.toast1ng.cv.entities;

import info.toast1ng.cv.dto.TechStackDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
        this.techStackId = techStackId;
        this.description = description;
    }

    public TechStackDto toDto() {
        return TechStackDto.builder()
                .techStackId(techStackId)
                .description(description)
                .build();
    }
}
