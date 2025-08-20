package zamora.spring6.dependencyInjection.dependencyInjection.controllers.i18n;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("ES")
@SpringBootTest
public class myi18nControllerTestES {

    @Autowired
    Myi18nController myi18nController;

    @Test
    void sayHello() {
        System.out.println(myi18nController.sayHello());
    }
}
