package de.telran.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");
		PersonService personService = new PersonService();
		PersonService service = context.getBean("personService", PersonService.class);
		String sayHello = service.sayHello();
		
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for(String name: beanDefinitionNames) {
			System.out.println(name);
		}

		System.out.println(sayHello);
		ConfigurableApplicationContext context2 = SpringApplication.run(DemoApplication.class, args);
		String[] beanDefinitionNames2 = context2.getBeanDefinitionNames();
		for(String s:beanDefinitionNames2) {
			System.out.println(s);
		}
		
	}
}
