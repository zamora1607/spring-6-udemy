package zamora.spring6.dependencyInjection.dependencyInjection.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class GreetingsServicePrimary implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello from the primary service";
    }
}
