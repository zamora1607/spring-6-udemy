package zamora.spring6.dependencyInjection.dependencyInjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import zamora.spring6.dependencyInjection.dependencyInjection.controllers.MyController;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DependencyInjectionApplication.class, args);

		MyController controller = ctx.getBean(MyController.class);

		System.out.println("I am in the main method");

		System.out.println(controller.sayHello());
	}

}
