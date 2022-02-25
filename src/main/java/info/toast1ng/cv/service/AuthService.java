package info.toast1ng.cv.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AuthService {
    private final PasswordEncoder passwordEncoder;

    @Value("${app.password}")
    private String originPassword;

    private String correctPw = "";

    public AuthService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init(){
        correctPw = passwordEncoder.encode(originPassword);
    }

    public boolean passwordIsCorrect(String password) {
        //TODO user id password db 에서 불러오기
        return passwordEncoder.matches(password, correctPw);
    }
}
