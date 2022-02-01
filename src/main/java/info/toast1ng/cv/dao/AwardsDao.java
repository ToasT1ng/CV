package info.toast1ng.cv.dao;

import info.toast1ng.cv.dto.AwardsDto;
import info.toast1ng.cv.entities.Awards;
import info.toast1ng.cv.repository.AwardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AwardsDao {
    @Autowired
    private AwardsRepository awardsRepository;

    public List<AwardsDto> getAwards() {
        List<Awards> entities = awardsRepository.findAll();
        List<AwardsDto> dtos = new ArrayList<>();
        for (Awards entity : entities) {
            dtos.add(entity.toDto());
        }

        return dtos;
    }
}
