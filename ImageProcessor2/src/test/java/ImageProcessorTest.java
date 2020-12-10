import de.telran.processor.ImageProcessor;
import de.telran.processor.entity.DownloadedImage;
import de.telran.processor.entity.ImageDescriptor;
import de.telran.processor.service.DownloadService;
import de.telran.processor.service.FileService;
import de.telran.processor.service.ImageService;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ImageProcessorTest {
    private FileService fileService = mock(FileService.class);
    private DownloadService downloadService = mock(DownloadService.class);
    private ImageService imageService = mock(ImageService.class);


    @Test
    public void testOneDescriptorList() {
        //programming the mocks
        when(fileService.readImageDescriptors(any()))
                .thenReturn(createListWithOneImageDescriptor());
        when(downloadService.downloadImages(any()))
                .thenReturn(createListWithOneDownloadedImage());

        when(imageService.processImage(any()))
                .thenReturn(createSuccessfullDownloadedImage());

        doNothing().when(fileService).saveImageAsFile(any());

        //execute test method
        ImageProcessor processor = new ImageProcessor(fileService, downloadService, imageService);

        processor.process("test_file_name.csv");

        //verify results
        verify(fileService, times(1)).readImageDescriptors(any());
        verify(downloadService, times(1)).downloadImages(any());
        verify(imageService, times(1)).processImage(any());
        verify(fileService, times(1)).saveImageAsFile(any());
    }

    @Test
    public void testEmptyDescriptorList() {
        //programming the mocks
        when(fileService.readImageDescriptors(any()))
                .thenReturn(Collections.emptyList());
        when(downloadService.downloadImages(any()))
                .thenReturn(Collections.emptyList());

        //execute test method
        ImageProcessor processor = new ImageProcessor(fileService, downloadService, imageService);

        processor.process("test_file_name.csv");

        //verify results
        verify(fileService, times(1)).readImageDescriptors(any());
        verify(downloadService, times(1)).downloadImages(any());
        verify(imageService, never()).processImage(any());
        verify(fileService, never()).saveImageAsFile(any());
    }

    private List<ImageDescriptor> createListWithOneImageDescriptor() {
        return Arrays.asList(new ImageDescriptor("url1", "GRAYSCALE"));
    }

    private List<DownloadedImage> createListWithOneDownloadedImage() {
        return Arrays.asList(new DownloadedImage(null, true, null));
    }

    private DownloadedImage createSuccessfullDownloadedImage() {
        return new DownloadedImage(null, true, null);
    }

}
