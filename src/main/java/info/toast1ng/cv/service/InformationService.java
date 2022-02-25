package info.toast1ng.cv.service;

import info.toast1ng.cv.dao.InformationDao;
import info.toast1ng.cv.dto.InformationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationService {
    private final InformationDao informationDao;

    @Autowired
    public InformationService(InformationDao informationDao) {
        this.informationDao = informationDao;
    }

    public List<InformationDto> getInformations() {
        return informationDao.getInformations();
    }

    public InformationDto getGreeting() {
        return informationDao.getGreeting();
    }

    public InformationDto setInformation(InformationDto information) {
        return informationDao.setInformation(information);
    }

    public List<InformationDto> setInformations(List<InformationDto> informations) {
        return informationDao.setInformations(informations);
    }

    public long deleteInformation(long id) {
        return informationDao.deleteInformation(id);
    }
}
