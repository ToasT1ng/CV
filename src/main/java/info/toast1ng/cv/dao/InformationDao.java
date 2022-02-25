package info.toast1ng.cv.dao;

import info.toast1ng.cv.dto.InformationDto;
import info.toast1ng.cv.entities.Information;
import info.toast1ng.cv.repository.InformationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InformationDao {
    private final InformationRepository informationRepository;

    public InformationDao(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    public List<InformationDto> getInformations() {
        List<Information> entities = informationRepository.findAllByGreetingOrNotFalse();
        List<InformationDto> dtos = new ArrayList<>();
        for (Information entity : entities) {
            dtos.add(entity.toDto());
        }

        return dtos;
    }

    public InformationDto getGreeting() {
        Information geeting = informationRepository.findGeeting();
        if (geeting != null) {
            return geeting.toDto();
        } else {
            return new InformationDto();
        }
    }

    public InformationDto setInformation(InformationDto information) {
        Information entity = informationRepository.save(information.toEntity());
        return entity.toDto();
    }

    public List<InformationDto> setInformations(List<InformationDto> informations) {
        List<Information> entities = new ArrayList<>();
        for (InformationDto dto : informations) {
            entities.add(dto.toEntity());
        }
        List<InformationDto> results = new ArrayList<>();
        List<Information> resultEntities = informationRepository.saveAll(entities);
        for (Information entity : resultEntities) {
            results.add(entity.toDto());
        }
        return results;
    }

    public long deleteInformation(long id) {
        informationRepository.deleteById(id);
        return id;
    }
}
