package info.toast1ng.cv.service;

import info.toast1ng.cv.dao.TechStackDao;
import info.toast1ng.cv.dto.TechStackDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechStackService {
    private final TechStackDao techStackDao;

    @Autowired
    public TechStackService(TechStackDao techStackDao) {
        this.techStackDao = techStackDao;
    }

    public TechStackDto getSingleTechStack() {
        return techStackDao.getSingleTechStack();
    }

    public TechStackDto setTechStack(TechStackDto techStack) throws Exception {
        techStack.setDescription(techStack.getDescription().replaceAll("\\\n","<br/>"));
        return techStackDao.setTechStack(techStack);
    }
}
