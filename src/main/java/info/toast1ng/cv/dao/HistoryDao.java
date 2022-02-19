package info.toast1ng.cv.dao;

import info.toast1ng.cv.dto.AwardsDto;
import info.toast1ng.cv.dto.CareerDto;
import info.toast1ng.cv.dto.HistoryType;
import info.toast1ng.cv.dto.EducationHistoryDto;
import info.toast1ng.cv.entities.History;
import info.toast1ng.cv.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HistoryDao {
    @Autowired
    private HistoryRepository repository;

    public List<CareerDto> getCareers() {
        List<History> entities = repository.getCareerAndEducationHistoriesByType(HistoryType.CAREER);
        List<CareerDto> dtos = new ArrayList<>();
        for (History entity : entities) {
            dtos.add(entity.toCareerDto());
        }

        return dtos;
    }

    public List<EducationHistoryDto> getEducationHistory() {
        List<History> entities = repository.getCareerAndEducationHistoriesByType(HistoryType.EDUCATION_HISTORY);
        List<EducationHistoryDto> dtos = new ArrayList<>();
        for (History entity : entities) {
            dtos.add(entity.toEducationHistoryDto());
        }

        return dtos;
    }

    public List<AwardsDto> getAwards() {
        List<History> entities = repository.getCareerAndEducationHistoriesByType(HistoryType.AWARDS);
        List<AwardsDto> dtos = new ArrayList<>();
        for (History entity : entities) {
            dtos.add(entity.toAwardsDto());
        }

        return dtos;
    }
}
