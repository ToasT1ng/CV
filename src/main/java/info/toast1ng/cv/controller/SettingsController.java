package info.toast1ng.cv.controller;

import info.toast1ng.cv.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

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

    @Autowired
    private AuthService authService;

    private final String sessionId = UUID.randomUUID().toString();

    @GetMapping("/index")
    public String settings(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("sessionId") == null) {
            return "redirect:/settings/login";
        }
        return "settings";
    }

    @GetMapping("/login")
    public String settingsLogin(Model model) {
        return "login";
    }

    @PostMapping("/check")
    public String settingsLogin(@RequestParam String password, HttpServletRequest request, Model model) {
        if (authService.passwordIsCorrect(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("sessionId", sessionId);
            return "settings";
        }

        return "redirect:/settings/index";
    }

    @GetMapping("/logout")
    public String settingsLogOut(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

    @GetMapping("/whoAmI")
    public String introduce(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("sessionId") == null) {
            return "redirect:/settings/login";
        }
        model.addAttribute("greeting", informationService.getGreeting());
        model.addAttribute("detailInfos", informationService.getInformations());
        return "introduce";
    }

    @GetMapping("/history")
    public String history(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("sessionId") == null) {
            return "redirect:/settings/login";
        }
        model.addAttribute("careerAndAwards", historyService.getEveryInformation());
        return "history";
    }

    @GetMapping("/whatDidYouDo")
    public String experiences(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("sessionId") == null) {
            return "redirect:/settings/login";
        }
        model.addAttribute("thingsDone", thingsDoneService.getThingsDone());
        return "experiences";
    }

    @GetMapping("/techStack")
    public String techStack(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("sessionId") == null) {
            return "redirect:/settings/login";
        }
        model.addAttribute("techStack", techStackService.getSingleTechStack());
        return "techStack";
    }
}
