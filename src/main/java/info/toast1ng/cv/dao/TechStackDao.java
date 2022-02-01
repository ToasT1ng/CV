package info.toast1ng.cv.dao;

import info.toast1ng.cv.dto.TechStackDto;
import org.springframework.stereotype.Repository;

@Repository
public class TechStackDao {
    public TechStackDto getSingleTechStack() {
        return TechStackDto.builder()
                .description("<p>이 Page 는 Spring Boot & MySQL & AWS EC2 를 사용해 만들어졌습니다. PC 화면에 최적화 되어있어 모바일에서는 조금 불편할 수 있습니다.</p>\n" +
                        "            <p>소스코드 : </p>\n" +
                        "            <p>만든 과정 기록 : </p>")
                .build();
    }
}
