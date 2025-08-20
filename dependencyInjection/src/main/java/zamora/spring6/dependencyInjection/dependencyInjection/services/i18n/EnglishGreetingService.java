package zamora.spring6.dependencyInjection.dependencyInjection.services.i18n;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import zamora.spring6.dependencyInjection.dependencyInjection.services.GreetingService;

@Profile({"EN", "default"})
@Service("i18nService")
public class EnglishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello world - EN";
    }
}
