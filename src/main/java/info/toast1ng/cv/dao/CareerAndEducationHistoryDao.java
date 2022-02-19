package info.toast1ng.cv.dao;

import info.toast1ng.cv.dto.CareerDto;
import info.toast1ng.cv.dto.CareerOrEducationType;
import info.toast1ng.cv.dto.EducationHistoryDto;
import info.toast1ng.cv.entities.CareerAndEducationHistory;
import info.toast1ng.cv.repository.CareerAndEducationHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CareerAndEducationHistoryDao {
    @Autowired
    private CareerAndEducationHistoryRepository repository;

    public List<CareerDto> getCareers() {
        List<CareerAndEducationHistory> entities = repository.getCareerAndEducationHistoriesByType(CareerOrEducationType.CAREER);
        List<CareerDto> dtos = new ArrayList<>();
        for (CareerAndEducationHistory entity : entities) {
            dtos.add(entity.toCareerDto());
        }

        return dtos;
    }

    public List<EducationHistoryDto> getEducationHistory() {
        List<CareerAndEducationHistory> entities = repository.getCareerAndEducationHistoriesByType(CareerOrEducationType.EDUCATION_HISTORY);
        List<EducationHistoryDto> dtos = new ArrayList<>();
        for (CareerAndEducationHistory entity : entities) {
            dtos.add(entity.toEducationHistoryDto());
        }

        return dtos;
    }
}
