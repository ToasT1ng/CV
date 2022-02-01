package info.toast1ng.cv.service;

import info.toast1ng.cv.dao.EducationHistoryDao;
import info.toast1ng.cv.dto.EducationHistoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationHistoryService {
    private EducationHistoryDao educationHistoryDao;

    @Autowired
    public EducationHistoryService(EducationHistoryDao educationHistoryDao) {
        this.educationHistoryDao = educationHistoryDao;
    }

    public List<EducationHistoryDto> getEducationHistories() {
        return educationHistoryDao.getEducationHistory();
    }
}
