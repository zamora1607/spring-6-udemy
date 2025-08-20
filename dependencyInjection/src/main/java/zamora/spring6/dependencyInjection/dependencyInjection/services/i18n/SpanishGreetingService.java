package zamora.spring6.dependencyInjection.dependencyInjection.services.i18n;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import zamora.spring6.dependencyInjection.dependencyInjection.services.GreetingService;

@Profile("ES")
@Service("i18nService")
public class SpanishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hola Mundo - Es";
    }
}
