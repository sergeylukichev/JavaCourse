import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

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
