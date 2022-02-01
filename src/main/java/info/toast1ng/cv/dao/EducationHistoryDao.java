package info.toast1ng.cv.dao;

import info.toast1ng.cv.dto.EducationHistoryDto;
import info.toast1ng.cv.entities.EducationHistory;
import info.toast1ng.cv.repository.EducationHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EducationHistoryDao {
    @Autowired
    private EducationHistoryRepository educationHistoryRepository;

    public List<EducationHistoryDto> getEducationHistory() {
        List<EducationHistory> entities = educationHistoryRepository.findAll();
        List<EducationHistoryDto> dtos = new ArrayList<>();
        for (EducationHistory entity : entities) {
            dtos.add(entity.toDto());
        }

        return dtos;
    }
}
