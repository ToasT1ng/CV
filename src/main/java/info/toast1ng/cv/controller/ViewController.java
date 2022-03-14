package info.toast1ng.cv.controller;

import info.toast1ng.cv.service.HistoryService;
import info.toast1ng.cv.service.InformationService;
import info.toast1ng.cv.service.ThingsDoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @Autowired
    private InformationService informationService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private ThingsDoneService thingsDoneService;

    @GetMapping(value = {"/", "/index", "/common"})
    public String commonPage(Model model) {
        model.addAttribute("greeting", informationService.getGreeting());
        model.addAttribute("detailInfos", informationService.getInformations());
        model.addAttribute("careerAndAwards", historyService.getEveryInformation());
        model.addAttribute("thingsDone", thingsDoneService.getThingsDone());

        return "commonView";
    }

    @GetMapping(value = {"/slide"})
    public String mainPage(Model model) {
        model.addAttribute("greeting", informationService.getGreeting());
        model.addAttribute("detailInfos", informationService.getInformations());
        model.addAttribute("careerAndAwards", historyService.getEveryInformation());
        model.addAttribute("thingsDone", thingsDoneService.getThingsDone());

        return "slideView";
    }
}
