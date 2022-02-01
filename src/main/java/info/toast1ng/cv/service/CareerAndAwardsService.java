package info.toast1ng.cv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CareerAndAwardsService {
    @Autowired
    private EducationHistoryService educationHistoryService;

    @Autowired
    private AwardsService awardsService;

    @Autowired
    private CareerService careerService;

    public Map<String, Object> getEveryInformation() {
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("educationHistory", educationHistoryService.getEducationHistories());
        returnMap.put("awards", awardsService.getAwards());
        returnMap.put("career", careerService.getCareers());
        return returnMap;
    }
}
