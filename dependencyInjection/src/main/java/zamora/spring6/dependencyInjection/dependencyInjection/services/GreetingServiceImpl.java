package zamora.spring6.dependencyInjection.dependencyInjection.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello Everyone from base service";
    }
}
