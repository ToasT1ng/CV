package info.toast1ng.cv.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("local")
@SpringBootTest
public class AuthServiceTests {
    @Autowired
    private AuthService authService;

    @Test
    public void passwordIsCorrect() {
        // given
        String correct = "hello";
        String wrong = "hi";

        // when - then
        assertTrue(authService.passwordIsCorrect(correct));
        assertFalse(authService.passwordIsCorrect(wrong));
    }

}
