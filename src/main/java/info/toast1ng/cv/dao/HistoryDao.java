package info.toast1ng.cv.dao;

import info.toast1ng.cv.dto.*;
import info.toast1ng.cv.entities.History;
import info.toast1ng.cv.repository.HistoryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HistoryDao {
    private final HistoryRepository repository;

    public HistoryDao(HistoryRepository repository) {
        this.repository = repository;
    }

    public List<HistoryDto> getHistories() {
        List<History> entities = repository.findAll();
        List<HistoryDto> dtos = new ArrayList<>();
        for (History entity : entities) {
            dtos.add(entity.toDto());
        }
        return dtos;
    }

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

    public HistoryDto setHistory(HistoryDto history) {
        return repository.save(history.toEntity()).toDto();
    }

    public List<HistoryDto> setHistories(List<HistoryDto> histories) {
        List<History> entities = new ArrayList<>();
        for (HistoryDto dto : histories) {
            entities.add(dto.toEntity());
        }
        List<HistoryDto> results = new ArrayList<>();
        List<History> resultEntities = repository.saveAll(entities);
        for (History entity : resultEntities) {
            results.add(entity.toDto());
        }
        return results;
    }

    public long deleteHistory(long id) {
        repository.deleteById(id);
        return id;
    }
}
