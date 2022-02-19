package info.toast1ng.cv.dto;

import com.sun.istack.NotNull;
import info.toast1ng.cv.entities.History;
import lombok.Builder;
import lombok.Data;

@Data
public class HistoryDto {
    private long historyId;

    @NotNull
    private HistoryType type;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String moreDescription;

    @Builder
    public HistoryDto(long historyId, HistoryType type, String name, String description, String moreDescription) {
        this.historyId = historyId;
        this.type = type;
        this.name = name;
        this.description = description;
        this.moreDescription = moreDescription;
    }

    public History toEntity() {
        return History.builder()
                .historyId(historyId)
                .type(type)
                .name(name)
                .description(description)
                .moreDescription(moreDescription)
                .build();
    }
}
