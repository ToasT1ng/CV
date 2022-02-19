package info.toast1ng.cv.controller;

import info.toast1ng.cv.service.HistoryService;
import info.toast1ng.cv.service.InformationService;
import info.toast1ng.cv.service.TechStackService;
import info.toast1ng.cv.service.ThingsDoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/settings")
public class SettingsController {
    @Autowired
    private InformationService informationService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private ThingsDoneService thingsDoneService;

    @Autowired
    private TechStackService techStackService;

    @GetMapping("/index")
    public String settings() {
        return "settings";
    }

    @GetMapping("/whoAmI")
    public String whoAmI(Model model) {
        model.addAttribute("greeting", informationService.getGreeting());
        model.addAttribute("detailInfos", informationService.getInformations());
        return "whoAmI";
    }

    @GetMapping("/history")
    public String history(Model model) {
        model.addAttribute("careerAndAwards", historyService.getEveryInformation());
        return "history";
    }

    @GetMapping("/whatDidYouDo")
    public String whatDidYouDo(Model model) {
        model.addAttribute("thingsDone", thingsDoneService.getThingsDone());
        return "whatDidYouDo";
    }

    @GetMapping("/techStack")
    public String techStack(Model model) {
        model.addAttribute("techStack", techStackService.getSingleTechStack());
        return "techStack";
    }
}
