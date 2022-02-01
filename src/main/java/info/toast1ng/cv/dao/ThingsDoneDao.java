package info.toast1ng.cv.dao;

import info.toast1ng.cv.dto.ThingsDoneDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ThingsDoneDao {
    public List<ThingsDoneDto> getThingsDone() {
        List<ThingsDoneDto> result = new ArrayList<>();
        result.add(ThingsDoneDto.builder()
                .thingsDoneId(1L)
                .era("학부생 시절")
                .category("창업동아리")
                .description("프로젝트<br>수상")
                .build());
        result.add(ThingsDoneDto.builder()
                .thingsDoneId(2L)
                .era("학부생 시절")
                .category("졸업작품")
                .description("음식 ㄴㄹㅁㄹㄴㄹ<br>Spring Boot")
                .build());
        result.add(ThingsDoneDto.builder()
                .thingsDoneId(3L)
                .era("재직 후")
                .category("Backend Engineer")
                .description("뭐했는지 말해~~")
                .build());
        return result;
    }
}
