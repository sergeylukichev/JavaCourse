import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.ProxyAsyncConfiguration;

public class Main {
//    авг 30, 2020 1:29:53 AM org.springframework.context.support.AbstractApplicationContext refresh
//    WARNING: Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.context.annotation.internalAsyncAnnotationProcessor' defined in class path resource [org/springframework/scheduling/annotation/ProxyAsyncConfiguration .class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.scheduling.annotation.AsyncAnnotationBeanPostProcessor]: Factory method 'asyncAdvisor' threw exception; nested exception is java.lang.IllegalArgumentException: @EnableAsync
//    annotation metadata was not injected
//    Exception in thread "main" org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.context.annotation.internalAsyncAnnotationProcessor' defined in class path resource [org/springframework/scheduling/annotation/ProxyAsyncConfiguration.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.scheduling.annotation.AsyncAnnotationBeanPostProcessor]: Factory method 'asyncAdvisor' threw exception; nested exception is java.lang.IllegalArgumentException: @EnableAsync annotation metadata was not injected


    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

//        KeyboardGuess source = new KeyboardGuess();
//        ConsoleOutput output = new ConsoleOutput();
//        int secretNumber = 15;
//        int attemptsCount = 3;
//
//        GuessNumberGame game = new GuessNumberGame(
//                secretNumber,
//                attemptsCount,
//                source,
//                output);
        GuessNumberGame game = context.getBean("guessNumberGame", GuessNumberGame.class);

        game.play();
    }


}
