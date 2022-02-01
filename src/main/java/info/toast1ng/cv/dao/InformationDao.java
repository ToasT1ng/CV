package info.toast1ng.cv.dao;

import info.toast1ng.cv.dto.InformationDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InformationDao {
    public List<InformationDto> getInformations() {
        List<InformationDto> result = new ArrayList<>();
        result.add(InformationDto.builder()
                .informationId(1L)
                .category("Name")
                .description("Jane Sung")
//                .description("Jinah Sung")
                .greetingOrNot(false)
                .build());
        result.add(InformationDto.builder()
                .informationId(2L)
                .category("Age")
                .description("1997.11 ~ (만24세)")
                .greetingOrNot(false)
                .build());
        result.add(InformationDto.builder()
                .informationId(3L)
                .category("Contact")
                .description("jrainboww9@gmail.com")
                .greetingOrNot(false)
                .build());
        result.add(InformationDto.builder()
                .informationId(4L)
                .category("Git")
                .description("<a href=\"https://github.com/ToasT1ng/\">GitHub</a>")
                .greetingOrNot(false)
                .build());
        result.add(InformationDto.builder()
                .informationId(5L)
                .category("Blog")
                .description("<a href=\"https://toast1ng.tistory.com/\">Tistory Blog</a>")
                .greetingOrNot(false)
                .build());
        // ....
        return result;
    }

    public InformationDto getGreeting() {
        return InformationDto.builder()
                .informationId(0L)
                .category("Greeting")
                .description("안녕하세요, 주니어 백엔드 개발자 입니다. 현재 스타트업 회사에 재직하고 있습니다.")
//                .description("안녕하세요, 주니어 백엔드 개발자 성진아 입니다. 현재 (주) 엔씽에 재직하고 있습니다.")
                .greetingOrNot(true)
                .build();
    }
}
