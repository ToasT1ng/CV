package info.toast1ng.cv.service;

import info.toast1ng.cv.dao.CareerAndEducationHistoryDao;
import info.toast1ng.cv.dto.CareerDto;
import info.toast1ng.cv.dto.EducationHistoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerAndEducationService {
    private final CareerAndEducationHistoryDao dao;

    @Autowired
    public CareerAndEducationService(CareerAndEducationHistoryDao dao) {
        this.dao = dao;
    }

    public List<CareerDto> getCareers() {
        return dao.getCareers();
    }

    public List<EducationHistoryDto> getEducationHistories() {
        return dao.getEducationHistory();
    }
}
