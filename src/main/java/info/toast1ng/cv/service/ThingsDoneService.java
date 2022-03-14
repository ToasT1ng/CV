package info.toast1ng.cv.service;

import info.toast1ng.cv.dao.ThingsDoneDao;
import info.toast1ng.cv.dto.ThingsDoneDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ThingsDoneService {
    private final ThingsDoneDao thingsDoneDao;

    @Autowired
    public ThingsDoneService(ThingsDoneDao thingsDoneDao) {
        this.thingsDoneDao = thingsDoneDao;
    }

    public Map<String, List<ThingsDoneDto>> getThingsDone() {
        Map<String, List<ThingsDoneDto>> returnMap = new TreeMap<>();
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

    public List<ThingsDoneDto> getThingsDones() {
        return thingsDoneDao.getThingsDone();
    }

    public ThingsDoneDto setThingsDone(ThingsDoneDto thingsDone) {
        thingsDone.setDescription(thingsDone.getDescription().replaceAll("\\\n","<br/>"));
        return thingsDoneDao.setThingsDone(thingsDone);
    }

    public List<ThingsDoneDto> setThingsDones(List<ThingsDoneDto> thingsDones) {
        for (ThingsDoneDto thingsDoneDto : thingsDones) {
            thingsDoneDto.setDescription(thingsDoneDto.getDescription().replaceAll("\\\n","<br/>"));
        }
        return thingsDoneDao.setThingsDones(thingsDones);
    }

    public long deleteThingsDone(long id) {
        return thingsDoneDao.deleteThingsDone(id);
    }
}
