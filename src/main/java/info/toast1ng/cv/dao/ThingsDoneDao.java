package info.toast1ng.cv.dao;

import info.toast1ng.cv.dto.ThingsDoneDto;
import info.toast1ng.cv.entities.ThingsDone;
import info.toast1ng.cv.repository.ThingsDoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ThingsDoneDao {
    @Autowired
    private ThingsDoneRepository thingsDoneRepository;

    public List<ThingsDoneDto> getThingsDone() {
        List<ThingsDone> entities = thingsDoneRepository.findAll();
        List<ThingsDoneDto> dtos = new ArrayList<>();
        for (ThingsDone entity : entities) {
            dtos.add(entity.toDto());
        }

        return dtos;
    }
}
