package info.toast1ng.cv.controller;

import info.toast1ng.cv.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController {
    @Autowired
    private InformationService informationService;

    @RequestMapping(value = {"/", "/index"})
    public String mainPage(Model model) {
        model.addAttribute("greeting", informationService.getGreeting());
        model.addAttribute("detailInfos", informationService.getInformations());
        return "slideView";
    }

    @RequestMapping(value = {"/common"})
    public String commonPage(Model model) {
        model.addAttribute("greeting", informationService.getGreeting());
        model.addAttribute("detailInfos", informationService.getInformations());
        return "commonView";
    }
}
