import de.telran.processor.entity.DownloadedImage;
import de.telran.processor.entity.ImageDescriptor;
import de.telran.processor.service.FileConfigService;
import de.telran.processor.service.FileNameGenertorService;
import de.telran.processor.service.FileService;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class FileServiceTest {

    private FileConfigService configService = mock(FileConfigService.class);
    private FileNameGenertorService nameGeneratorService = mock(FileNameGenertorService.class);

    //https://s3-eu-west-1.amazonaws.com/lukaroundimg/beelitz2017?param1=123&param2=567
    @Test
    public void generateImageNameTest() throws Exception {
        ImageDescriptor descriptor = new ImageDescriptor("https://s3-eu-west-1.amazonaws.com/lukaroundimg/beelitz2017/1a.jpg", "GRAYSCALE");
        String expected = "GRAYSCALE_lukaroundimg_beelitz2017_1a.jpg";

        FileNameGenertorService service = new FileNameGenertorService();
        String actual = service.generateImageName(descriptor);

        assertEquals(expected, actual);
    }

    @Test
    public void testSaveImageAsFile () throws Exception{

        when(configService.getPathToSavedImages()).thenReturn("some_path");
        when(nameGeneratorService.generateImageName(any())).thenThrow(new MalformedURLException());

        FileService service = new FileService(configService, nameGeneratorService);
        service.saveImageAsFile(new DownloadedImage(null, true, null));

        verify(nameGeneratorService).generateImageName(any());
    }


}
