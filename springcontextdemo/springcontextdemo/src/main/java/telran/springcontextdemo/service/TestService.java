package telran.springcontextdemo.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class TestService implements InitializingBean {
	
	public void helloWorld() {
		System.out.println("Hello from TestService");
	}
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("This method is called when all properties are set ");
		
	}

}
