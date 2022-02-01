package info.toast1ng.cv.dao;

import info.toast1ng.cv.dto.CareerDto;
import info.toast1ng.cv.entities.Career;
import info.toast1ng.cv.repository.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CareerDao {
    @Autowired
    private CareerRepository careerRepository;

    public List<CareerDto> getCareers() {
        List<Career> entities = careerRepository.findAll();
        List<CareerDto> dtos = new ArrayList<>();
        for (Career entity : entities) {
            dtos.add(entity.toDto());
        }

        return dtos;
    }
}
