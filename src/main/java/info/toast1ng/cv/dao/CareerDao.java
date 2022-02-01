package info.toast1ng.cv.dao;

import info.toast1ng.cv.dto.CareerDto;
import info.toast1ng.cv.util.CustomDateUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CareerDao {
    public List<CareerDto> getCareers() {
        List<CareerDto> result = new ArrayList<>();
        result.add(CareerDto.dateBuilder()
                .careerId(2L)
                .companyName("(주) 엔씽")
                .description("S/W Backend Engineer")
                .startDate(CustomDateUtil.makeDate(2021,3))
                .endDate(CustomDateUtil.makeDate(2030,8))
                .currentWorkOrNot(true)
                .build());
        return result;
    }
}
