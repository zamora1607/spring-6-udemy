package zamora.spring6.dependencyInjection.dependencyInjection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import zamora.spring6.dependencyInjection.dependencyInjection.controllers.MyController;

@SpringBootTest
class DependencyInjectionApplicationTests {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	MyController controller;

	@Test
	void testGEtControllerFromContext() {
		MyController controller = applicationContext.getBean(MyController.class);
		System.out.println(controller.sayHello());
	}

	@Test
	void testAutowireOfController() {
		System.out.println(controller.sayHello());
	}

	@Test
	void contextLoads() {}

}
