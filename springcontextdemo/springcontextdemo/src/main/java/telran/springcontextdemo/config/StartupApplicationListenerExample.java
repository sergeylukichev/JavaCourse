package telran.springcontextdemo.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListenerExample implements
		ApplicationListener<ContextRefreshedEvent> {

	/*
	 * is called when context is refreshed
	 * 
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("ContextRefreshedEvent Received");
	}
}
