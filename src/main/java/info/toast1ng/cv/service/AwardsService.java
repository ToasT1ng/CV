package info.toast1ng.cv.service;

import info.toast1ng.cv.dao.AwardsDao;
import info.toast1ng.cv.dto.AwardsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardsService {
    private AwardsDao awardsDao;

    @Autowired
    public AwardsService(AwardsDao awardsDao) {
        this.awardsDao = awardsDao;
    }

    public List<AwardsDto> getAwards() {
        return awardsDao.getAwards();
    }
}
