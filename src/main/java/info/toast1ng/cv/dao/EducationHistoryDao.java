package info.toast1ng.cv.dao;

import info.toast1ng.cv.dto.EducationHistoryDto;
import info.toast1ng.cv.util.CustomDateUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EducationHistoryDao {
    public List<EducationHistoryDto> getEducationHistory() {
        List<EducationHistoryDto> educationHistoryDtos = new ArrayList<>();
        educationHistoryDtos.add(EducationHistoryDto.dateBuilder()
                .educationalId(1L)
                .schoolName("한양대학교 에리카캠퍼스")
                .description("소프트웨어학과 컴퓨터전공 ( 3.77 / 4.5 )")
                .startDate(CustomDateUtil.makeDate(2016,3))
                .endDate(CustomDateUtil.makeDate(2021,8))
                .build());
        educationHistoryDtos.add(EducationHistoryDto.dateBuilder()
                .educationalId(2L)
                .schoolName("신도림고등학교")
                .description("인문계")
                .startDate(CustomDateUtil.makeDate(2013,3))
                .endDate(CustomDateUtil.makeDate(2016,2))
                .build());

        return educationHistoryDtos;
    }
}
