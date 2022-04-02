package info.toast1ng.cv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    @Bean
    public Map<String, String> getSessionMap() {
        return new HashMap<>();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object sessionId = request.getSession().getAttribute("sessionId");
        if (sessionId == null || !getSessionMap().containsKey(sessionId.toString())) {
            response.sendRedirect("/settings/login");
            return false;
        }
        return true;
    }


}
