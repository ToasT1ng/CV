package info.toast1ng.cv.dao;

import info.toast1ng.cv.dto.TechStackDto;
import info.toast1ng.cv.entities.TechStack;
import info.toast1ng.cv.repository.TechStackRepository;
import info.toast1ng.cv.util.UpdateUtil;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class TechStackDao {
    private final TechStackRepository techStackRepository;

    public TechStackDao(TechStackRepository techStackRepository) {
        this.techStackRepository = techStackRepository;
    }

    public TechStackDto getSingleTechStack() {
        List<TechStack> entities = techStackRepository.findAll();
        if (entities.size() > 0) {
            return entities.get(0).toDto();
        } else {
            return new TechStackDto();
        }
    }

    @Transactional
    public TechStackDto setTechStack(TechStackDto techStack) throws Exception {
        TechStack entity = null;
        Optional<TechStack> oldTechStack = techStackRepository.findById(techStack.getTechStackId());
        if (oldTechStack.isPresent()) {
            TechStack origin = oldTechStack.get();
            UpdateUtil.update(origin, techStack.toEntity());
            entity = origin;
        } else {
            entity = techStack.toEntity();
        }
        TechStack result = techStackRepository.save(entity);
        return result.toDto();

    }

}
