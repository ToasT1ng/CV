package info.toast1ng.cv.service;

import info.toast1ng.cv.dao.HistoryDao;
import info.toast1ng.cv.dto.AwardsDto;
import info.toast1ng.cv.dto.CareerDto;
import info.toast1ng.cv.dto.EducationHistoryDto;
import info.toast1ng.cv.dto.HistoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HistoryService {
    private final HistoryDao dao;

    @Autowired
    public HistoryService(HistoryDao dao) {
        this.dao = dao;
    }

    public List<CareerDto> getCareers() {
        return dao.getCareers();
    }

    public List<EducationHistoryDto> getEducationHistories() {
        return dao.getEducationHistory();
    }

    public List<AwardsDto> getAwards() {
        return dao.getAwards();
    }

    public Map<String, Object> getEveryInformation() {
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("educationHistory", getEducationHistories());
        returnMap.put("awards", getAwards());
        returnMap.put("career", getCareers());
        return returnMap;
    }

    public HistoryDto setHistory(HistoryDto history) {
        return dao.setHistory(history);
    }

    public List<HistoryDto> setHistories(List<HistoryDto> histories) {
        return dao.setHistories(histories);
    }

    public long deleteHistory(long id) {
        return dao.deleteHistory(id);
    }

    public List<HistoryDto> getHistories() {
        return dao.getHistories();
    }
}
