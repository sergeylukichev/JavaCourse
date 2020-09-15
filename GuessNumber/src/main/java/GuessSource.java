import org.springframework.stereotype.Component;

@Component
public interface GuessSource {
    public int guess();
}
