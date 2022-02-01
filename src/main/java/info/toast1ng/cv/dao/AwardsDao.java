package info.toast1ng.cv.dao;

import info.toast1ng.cv.dto.AwardsDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AwardsDao {
    public List<AwardsDto> getAwards() {
        List<AwardsDto> awardsDtos = new ArrayList<>();
        awardsDtos.add(AwardsDto.builder()
                .awardsId(1L)
                .awardName("2019 Erica Software-Up 창업아이디어 톤")
                .description("Thir-Key : 안전과 프라이버시를 보장하는, 키 없는 IoT 도어락 시스템")
                .award("우수상")
                .build());
        awardsDtos.add(AwardsDto.builder()
                .awardsId(2L)
                .awardName("2020 안산 메이커 창업 페스티벌")
                .description("FingerPrint : Online For Offline 클라우드 프린팅 서비스")
                .award("전시우수상")
                .build());
        return awardsDtos;
    }
}
