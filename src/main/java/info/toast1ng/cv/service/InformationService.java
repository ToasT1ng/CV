package info.toast1ng.cv.service;

import info.toast1ng.cv.dao.InformationDao;
import info.toast1ng.cv.dto.InformationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationService {
    @Autowired
    private InformationDao informationDao;

    public List<InformationDto> getInformations() {
        return informationDao.getInformations();
    }

    public InformationDto getGreeting() {
        return informationDao.getGreeting();
    }
}
