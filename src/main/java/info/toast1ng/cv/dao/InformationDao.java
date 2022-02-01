package info.toast1ng.cv.dao;

import info.toast1ng.cv.dto.InformationDto;
import info.toast1ng.cv.entities.Information;
import info.toast1ng.cv.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InformationDao {
    @Autowired
    private InformationRepository informationRepository;

    public List<InformationDto> getInformations() {
        List<Information> entities = informationRepository.findAllByGreetingOrNotFalse();
        List<InformationDto> dtos = new ArrayList<>();
        for (Information entity : entities) {
            dtos.add(entity.toDto());
        }

        return dtos;
    }

    public InformationDto getGreeting() {
        return informationRepository.findGeeting().toDto();
    }
}
