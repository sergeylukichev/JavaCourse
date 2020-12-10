import de.telran.processor.action.ImageAction;
import de.telran.processor.factory.ImageActionFactory;
import de.telran.processor.service.ActionsConfigService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;


public class ImageActionFactoryTest {

    //mock creation
    ActionsConfigService configService = mock(ActionsConfigService.class);

    @Test
    public void testImageAction() throws Exception {
        //configure mocks
        when(configService.getActionPackage()).thenReturn("de.telran.processor.action");
        when(configService.getActionClassNames()).thenReturn(getClassNames());

        //execute testing method
        ImageActionFactory factory = new ImageActionFactory(configService);
        ImageAction preview = factory.getAction("PREVIEW");

        //assert results
        assertNotNull(preview);
        assertEquals("PREVIEW", preview.getName());

        verify(configService, times(1)).getActionPackage();
        verify(configService, times(1)).getActionClassNames();

    }

    private static List<String> getClassNames() {
        return Arrays.asList("GrayscaleImageAction","DefaultImageAction","PreviewImageAction","NewImageAction");
    }
}
