package info.toast1ng.cv.controller;

import com.google.gson.Gson;
import info.toast1ng.cv.dto.EducationHistoryDto;
import info.toast1ng.cv.dto.HistoryDto;
import info.toast1ng.cv.service.HistoryService;
import info.toast1ng.cv.service.InformationService;
import info.toast1ng.cv.service.TechStackService;
import info.toast1ng.cv.service.ThingsDoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private InformationService informationService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private ThingsDoneService thingsDoneService;

    @Autowired
    private TechStackService techStackService;

    @GetMapping(value = "/history/getHistories")
    public ResponseEntity<String> getHistories() {
        List<EducationHistoryDto> educationHistories = historyService.getEducationHistories();
        return makeReturn(educationHistories);
    }

    @PostMapping("/history/setHistory")
    public ResponseEntity<String> setHistory(@Validated @RequestBody HistoryDto history) {
        HistoryDto historyDto = historyService.setHistory(history);
        return makeReturn(historyDto);
    }

    @PostMapping("/history/setHistories")
    public ResponseEntity<String> setHistories(@Validated @RequestBody List<HistoryDto> histories) {
        List<HistoryDto> historyDto = historyService.setHistories(histories);
        return makeReturn(historyDto);
    }

    @PostMapping("/history/deleteHistory")
    public ResponseEntity<String> deleteHistory(@RequestParam long id) {
        long returnId = historyService.deleteHistory(id);
        return makeReturn(returnId);
    }
    
    public <T> ResponseEntity<String> makeReturn(T object) {
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(new Gson().toJson(object), httpHeaders, HttpStatus.OK);
    }
}
