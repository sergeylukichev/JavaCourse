import de.telran.game.GuessNumberGame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

//        de.telran.game.GuessSource source = context.getBean("keyboardGuess", de.telran.game.KeyboardGuess.class);
//        de.telran.game.ResultOutput output = context.getBean("consoleOutput", de.telran.game.ConsoleOutput.class);
        GuessNumberGame game = context.getBean("guessNumberGame", GuessNumberGame.class);


//        de.telran.game.GuessNumberGame game = new de.telran.game.GuessNumberGame(15,
//                3,
//                source,
//                output);

        game.play();
    }


}
