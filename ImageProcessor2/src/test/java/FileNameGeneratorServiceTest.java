import de.telran.processor.entity.ImageDescriptor;
import de.telran.processor.service.FileNameGenertorService;
import org.junit.Test;

import java.net.MalformedURLException;

public class FileNameGeneratorServiceTest {

    @Test(expected = MalformedURLException.class)
    public void testGenerateImageName() throws Exception {
        ImageDescriptor descriptor = new ImageDescriptor("test", "TEST");
        FileNameGenertorService service = new FileNameGenertorService();
        service.generateImageName(descriptor);
    }
}
