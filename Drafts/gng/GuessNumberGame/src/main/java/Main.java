import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

//        GuessSource source = context.getBean("keyboardGuess", KeyboardGuess.class);
//        ResultOutput output = context.getBean("consoleOutput", ConsoleOutput.class);
        GuessNumberGame game = context.getBean("game", GuessNumberGame.class);


//        GuessNumberGame game = new GuessNumberGame(15,
//                3,
//                source,
//                output);

        game.play();
    }


}
