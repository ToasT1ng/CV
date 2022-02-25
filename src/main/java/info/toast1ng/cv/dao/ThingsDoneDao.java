package info.toast1ng.cv.dao;

import info.toast1ng.cv.dto.ThingsDoneDto;
import info.toast1ng.cv.entities.ThingsDone;
import info.toast1ng.cv.repository.ThingsDoneRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ThingsDoneDao {
    private final ThingsDoneRepository thingsDoneRepository;

    public ThingsDoneDao(ThingsDoneRepository thingsDoneRepository) {
        this.thingsDoneRepository = thingsDoneRepository;
    }

    public List<ThingsDoneDto> getThingsDone() {
        List<ThingsDone> entities = thingsDoneRepository.findAll();
        List<ThingsDoneDto> dtos = new ArrayList<>();
        for (ThingsDone entity : entities) {
            dtos.add(entity.toDto());
        }

        return dtos;
    }

    public ThingsDoneDto setThingsDone(ThingsDoneDto thingsDone) {
        ThingsDone entity = thingsDoneRepository.save(thingsDone.toEntity());
        return entity.toDto();
    }

    public List<ThingsDoneDto> setThingsDones(List<ThingsDoneDto> thingsDones) {
        List<ThingsDone> entities = new ArrayList<>();
        for (ThingsDoneDto dto : thingsDones) {
            entities.add(dto.toEntity());
        }
        List<ThingsDoneDto> results = new ArrayList<>();
        List<ThingsDone> resultEntities = thingsDoneRepository.saveAll(entities);
        for (ThingsDone entity : resultEntities) {
            results.add(entity.toDto());
        }
        return results;
    }

    public long deleteThingsDone(long id) {
        thingsDoneRepository.deleteById(id);
        return id;
    }
}
