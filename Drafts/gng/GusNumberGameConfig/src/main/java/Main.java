import game.GameConfig;
import game.GuessNumberGame;
import game.GuessSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);

        GuessNumberGame game = context.getBean("game", GuessNumberGame.class);
        GuessSource s1 = context.getBean("getGuessSource", GuessSource.class);
        System.out.println(s1);
        GuessSource s2 = context.getBean("getGuessSource", GuessSource.class);
        System.out.println(s2);

//        game.play();
    }


}
