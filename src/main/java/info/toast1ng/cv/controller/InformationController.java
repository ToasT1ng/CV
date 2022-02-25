package info.toast1ng.cv.controller;

import info.toast1ng.cv.controller.util.MakeReturn;
import info.toast1ng.cv.dto.InformationDto;
import info.toast1ng.cv.service.InformationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/information")
@RestController
public class InformationController {
    private final InformationService informationService;

    public InformationController(InformationService informationService) {
        this.informationService = informationService;
    }

    @GetMapping(value = "/getInformations")
    public ResponseEntity<String> getInformations() {
        List<InformationDto> result = informationService.getInformations();
        return MakeReturn.makeHttpStatusOk(result);
    }

    @PostMapping("/setInformation")
    public ResponseEntity<String> setInformation(@Validated @RequestBody InformationDto information) {
        InformationDto result = informationService.setInformation(information);
        return MakeReturn.makeHttpStatusOk(result);
    }

    @PostMapping("/setInformations")
    public ResponseEntity<String> setInformations(@Validated @RequestBody List<InformationDto> informations) {
        List<InformationDto> result = informationService.setInformations(informations);
        return MakeReturn.makeHttpStatusOk(result);
    }

    @PostMapping("/deleteInformation")
    public ResponseEntity<String> deleteInformation(@RequestParam long id) {
        long returnId = informationService.deleteInformation(id);
        return MakeReturn.makeHttpStatusOk(returnId);
    }
}
