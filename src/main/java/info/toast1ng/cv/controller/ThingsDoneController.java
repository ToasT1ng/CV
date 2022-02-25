package info.toast1ng.cv.controller;

import info.toast1ng.cv.controller.util.MakeReturn;
import info.toast1ng.cv.dto.ThingsDoneDto;
import info.toast1ng.cv.service.ThingsDoneService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/thingsDone")
@RestController
public class ThingsDoneController {
    private final ThingsDoneService thingsDoneService;

    public ThingsDoneController(ThingsDoneService thingsDoneService) {
        this.thingsDoneService = thingsDoneService;
    }

    @GetMapping(value = "/getThingsDones")
    public ResponseEntity<String> getThingsDones() {
        List<ThingsDoneDto> result = thingsDoneService.getThingsDones();
        return MakeReturn.makeHttpStatusOk(result);
    }

    @PostMapping("/setThingsDone")
    public ResponseEntity<String> setThingsDone(@Validated @RequestBody ThingsDoneDto thingsDone) {
        ThingsDoneDto result = thingsDoneService.setThingsDone(thingsDone);
        return MakeReturn.makeHttpStatusOk(result);
    }

    @PostMapping("/setThingsDones")
    public ResponseEntity<String> setThingsDones(@Validated @RequestBody List<ThingsDoneDto> thingsDones) {
        List<ThingsDoneDto> result = thingsDoneService.setThingsDones(thingsDones);
        return MakeReturn.makeHttpStatusOk(result);
    }

    @PostMapping("/deleteThingsDone")
    public ResponseEntity<String> deleteThingsDone(@RequestParam long id) {
        long returnId = thingsDoneService.deleteThingsDone(id);
        return MakeReturn.makeHttpStatusOk(returnId);
    }
}
