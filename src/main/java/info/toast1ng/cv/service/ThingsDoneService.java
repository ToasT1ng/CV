package info.toast1ng.cv.service;

import info.toast1ng.cv.dao.ThingsDoneDao;
import info.toast1ng.cv.dto.ThingsDoneDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ThingsDoneService {
    private ThingsDoneDao thingsDoneDao;

    @Autowired
    public ThingsDoneService(ThingsDoneDao thingsDoneDao) {
        this.thingsDoneDao = thingsDoneDao;
    }

    public Map<String, List<ThingsDoneDto>> getThingsDone() {
        Map<String, List<ThingsDoneDto>> returnMap = new HashMap<>();
        List<ThingsDoneDto> result = thingsDoneDao.getThingsDone();
        for (ThingsDoneDto thingsDoneDto : result) {
            if (returnMap.containsKey(thingsDoneDto.getEra())) {
                returnMap.get(thingsDoneDto.getEra()).add(thingsDoneDto);
            } else {
                List<ThingsDoneDto> mapInsideList = new ArrayList<>();
                mapInsideList.add(thingsDoneDto);
                returnMap.put(thingsDoneDto.getEra(), mapInsideList);
            }
        }
        return returnMap;
    }
}
