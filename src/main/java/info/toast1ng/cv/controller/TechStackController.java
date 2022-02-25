package info.toast1ng.cv.controller;

import info.toast1ng.cv.controller.util.MakeReturn;
import info.toast1ng.cv.dto.TechStackDto;
import info.toast1ng.cv.service.TechStackService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/techStack")
@RestController
public class TechStackController {
    private final TechStackService techStackService;

    public TechStackController(TechStackService techStackService) {
        this.techStackService = techStackService;
    }

    @GetMapping(value = "/getTechStack")
    public ResponseEntity<String> getTechStack() {
        TechStackDto result = techStackService.getSingleTechStack();
        return MakeReturn.makeHttpStatusOk(result);
    }

    @PostMapping("/setTechStack")
    public ResponseEntity<String> setTechStack(@Validated @RequestBody TechStackDto techStack) throws Exception {
        TechStackDto result = techStackService.setTechStack(techStack);
        return MakeReturn.makeHttpStatusOk(result);
    }
}
