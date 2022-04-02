package info.toast1ng.cv.controller;

import info.toast1ng.cv.service.AuthService;
import info.toast1ng.cv.service.HistoryService;
import info.toast1ng.cv.service.InformationService;
import info.toast1ng.cv.service.ThingsDoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
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
    private AuthService authService;

    @Autowired
    private Map<String, String> sessionMap;

    @GetMapping("/index")
    public String settings() {
        return "settings";
    }

    @GetMapping("/login")
    public String settingsLogin() {
        return "login";
    }

    @PostMapping("/check")
    public String settingsLogin(@RequestParam String password, HttpServletRequest request) {
        if (authService.passwordIsCorrect(password)) {
            HttpSession session = request.getSession();
            String sessionId = UUID.randomUUID().toString();
            sessionMap.put(sessionId, password);
            session.setAttribute("sessionId", sessionId);
            return "settings";
        }

        return "redirect:/settings/index";
    }

    @GetMapping("/logout")
    public String settingsLogOut(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            sessionMap.remove(session.getAttribute("sessionId").toString());
            session.invalidate();
        }
        return "redirect:/";
    }

    @GetMapping("/whoAmI")
    public String introduce(Model model) {
        model.addAttribute("greeting", informationService.getGreeting());
        model.addAttribute("detailInfos", informationService.getInformations());
        return "introduce";
    }

    @GetMapping("/history")
    public String history(Model model) {
        model.addAttribute("careerAndAwards", historyService.getEveryInformation());
        return "history";
    }

    @GetMapping("/whatDidYouDo")
    public String experiences(Model model) {
        model.addAttribute("thingsDone", thingsDoneService.getThingsDone());
        return "experiences";
    }
}
