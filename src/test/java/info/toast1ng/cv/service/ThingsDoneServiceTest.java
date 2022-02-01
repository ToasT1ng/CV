package info.toast1ng.cv.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThingsDoneServiceTest {
    @Autowired
    private ThingsDoneService thingsDoneService;

    @Test
    void getThingsDone() {
        System.out.println(thingsDoneService.getThingsDone());
    }
}