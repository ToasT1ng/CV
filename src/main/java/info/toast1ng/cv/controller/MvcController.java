package info.toast1ng.cv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController {
    @RequestMapping(value = {"/", "/index"})
    public String mainPage(Model model) {
        return "slideView";
    }

    @RequestMapping(value = {"/common"})
    public String commonPage(Model model) {
        return "commonView";
    }
}
