package telran.springcontextdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App 
{
	/*
	 * When the application starts we:
	 * 1. call a method helloWorld() in TestService when its bean is created
	 * 2. call StartupApplicationListenerExample.onApplicationEvent() when context is refreshed
	 * 3. call TestService.afterPropertiesSet() when all properties are set
	 *    because TestService implements InitializingBean.
	 * 4. there are more ways to tell spring app about context status.
	 */
    public static void main( String[] args )
    {
    	ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
    	String[] beanDefinitionNames = context.getBeanDefinitionNames();
    	for(String beanName: beanDefinitionNames) {
    		System.out.println(beanName);
    	}
    }
}
