import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    Map<String, Integer> map = new HashMap<>();

    AtomicInteger counter = new AtomicInteger(0);

    public void inc() {
            counter.incrementAndGet();
    }

    public void dec() {
            counter.decrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }

    public void updateMap(String key) {
        synchronized (map) {
            map.put(key, map.get(key)+1);
        }
    }
}
