package zamora.spring6.dependencyInjection.dependencyInjection.services;

import org.springframework.stereotype.Service;

@Service("setterGreetingBean")
public class GreetingServiceSetterInjection implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hey im setting a greeting!!";
    }
}
