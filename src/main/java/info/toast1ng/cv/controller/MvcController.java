package info.toast1ng.cv.controller;

import info.toast1ng.cv.service.CareerAndAwardsSectionService;
import info.toast1ng.cv.service.InformationService;
import info.toast1ng.cv.service.TechStackService;
import info.toast1ng.cv.service.ThingsDoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController {
    @Autowired
    private InformationService informationService;

    @Autowired
    private CareerAndAwardsSectionService careerAndAwardsSectionService;

    @Autowired
    private ThingsDoneService thingsDoneService;

    @Autowired
    private TechStackService techStackService;

    @RequestMapping(value = {"/", "/index"})
    public String commonPage(Model model) {
        model.addAttribute("greeting", informationService.getGreeting());
        model.addAttribute("detailInfos", informationService.getInformations());
        model.addAttribute("careerAndAwards", careerAndAwardsSectionService.getEveryInformation());
        model.addAttribute("thingsDone", thingsDoneService.getThingsDone());
        model.addAttribute("techStack", techStackService.getSingleTechStack());

        return "commonView";
    }

    @RequestMapping(value = {"/common"})
    public String mainPage(Model model) {
        model.addAttribute("greeting", informationService.getGreeting());
        model.addAttribute("detailInfos", informationService.getInformations());
        model.addAttribute("careerAndAwards", careerAndAwardsSectionService.getEveryInformation());
        model.addAttribute("thingsDone", thingsDoneService.getThingsDone());
        model.addAttribute("techStack", techStackService.getSingleTechStack());

        return "slideView";
    }
}
