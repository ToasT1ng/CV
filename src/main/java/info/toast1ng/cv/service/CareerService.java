package info.toast1ng.cv.service;

import info.toast1ng.cv.dao.CareerDao;
import info.toast1ng.cv.dto.CareerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerService {
    private CareerDao careerDao;

    @Autowired
    public CareerService(CareerDao careerDao) {
        this.careerDao = careerDao;
    }

    public List<CareerDto> getCareers() {
        return careerDao.getCareers();
    }
}
