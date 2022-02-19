package info.toast1ng.cv.config;

import ch.qos.logback.access.tomcat.LogbackValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

@Configuration
public class TomcatLogConfiguration {
    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${tomcat.config.file}")
    private String configFile;

    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        LogbackValve logbackValve = new LogbackValve();
        logbackValve.setQuiet(true);
        logbackValve.setFilename("src/main/resources/" + configFile);
        tomcat.addContextValves(logbackValve);
        return tomcat;
    }

}
