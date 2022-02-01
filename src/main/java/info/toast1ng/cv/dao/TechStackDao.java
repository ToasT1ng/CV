package info.toast1ng.cv.dao;

import info.toast1ng.cv.dto.TechStackDto;
import info.toast1ng.cv.entities.TechStack;
import info.toast1ng.cv.repository.TechStackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TechStackDao {
    @Autowired
    private TechStackRepository techStackRepository;

    public TechStackDto getSingleTechStack() {
        List<TechStack> entities = techStackRepository.findAll();
        if (entities.size() > 0) {
            return entities.get(0).toDto();
        } else {
            return null;
        }
    }
}
