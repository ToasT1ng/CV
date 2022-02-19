package info.toast1ng.cv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CareerAndAwardsSectionService {
    @Autowired
    private CareerAndEducationService careerAndEducationHistoryService;

    @Autowired
    private AwardsService awardsService;


    public Map<String, Object> getEveryInformation() {
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("educationHistory", careerAndEducationHistoryService.getEducationHistories());
        returnMap.put("awards", awardsService.getAwards());
        returnMap.put("career", careerAndEducationHistoryService.getCareers());
        return returnMap;
    }
}
