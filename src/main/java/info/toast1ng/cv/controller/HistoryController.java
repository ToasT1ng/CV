package info.toast1ng.cv.controller;

import info.toast1ng.cv.controller.util.MakeReturn;
import info.toast1ng.cv.dto.AwardsDto;
import info.toast1ng.cv.dto.CareerDto;
import info.toast1ng.cv.dto.EducationHistoryDto;
import info.toast1ng.cv.dto.HistoryDto;
import info.toast1ng.cv.service.HistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/history")
@RestController
public class HistoryController {
    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping(value = "/getHistories")
    public ResponseEntity<String> getHistories() {
        List<HistoryDto> result = historyService.getHistories();
        return MakeReturn.makeHttpStatusOk(result);
    }

    @GetMapping(value = "/getEducationHistories")
    public ResponseEntity<String> getEducationHistories() {
        List<EducationHistoryDto> result = historyService.getEducationHistories();
        return MakeReturn.makeHttpStatusOk(result);
    }

    @GetMapping(value = "/getAwards")
    public ResponseEntity<String> getAwards() {
        List<AwardsDto> result = historyService.getAwards();
        return info.toast1ng.cv.controller.util.MakeReturn.makeHttpStatusOk(result);
    }

    @GetMapping(value = "/getCareers")
    public ResponseEntity<String> getCareers() {
        List<CareerDto> result = historyService.getCareers();
        return MakeReturn.makeHttpStatusOk(result);
    }

    @PostMapping("/setHistory")
    public ResponseEntity<String> setHistory(@Validated @RequestBody HistoryDto history) {
        HistoryDto historyDto = historyService.setHistory(history);
        return MakeReturn.makeHttpStatusOk(historyDto);
    }

    @PostMapping("/setHistories")
    public ResponseEntity<String> setHistories(@Validated @RequestBody List<HistoryDto> histories) {
        List<HistoryDto> historyDto = historyService.setHistories(histories);
        return MakeReturn.makeHttpStatusOk(historyDto);
    }

    @PostMapping("/deleteHistory")
    public ResponseEntity<String> deleteHistory(@RequestParam long id) {
        long returnId = historyService.deleteHistory(id);
        return MakeReturn.makeHttpStatusOk(returnId);
    }

}
