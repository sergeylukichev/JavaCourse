package telran.springcontextdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import telran.springcontextdemo.service.TestService;

@Configuration
public class TestServiceConfiguration {
	
	
	/* check context init log in console and see helloWorld() 
	 * method is called when init is completed
	 */
	
	@Bean(initMethod = "helloWorld")
	public TestService getTestService() {
		return new TestService();
	}	

}
