package zamora.spring6.dependencyInjection.dependencyInjection.controllers;

import org.springframework.stereotype.Controller;
import zamora.spring6.dependencyInjection.dependencyInjection.services.GreetingService;
import zamora.spring6.dependencyInjection.dependencyInjection.services.GreetingServiceImpl;

@Controller
public class MyController {

    private final GreetingService greetingService;

    public MyController() {
        this.greetingService = new GreetingServiceImpl();
    }

    public String sayHello() {
        System.out.println("Hello I'm in the controller");

        return greetingService.sayGreeting();
    }
}
