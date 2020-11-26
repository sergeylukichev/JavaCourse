package de.telran.processor;

import de.telran.processor.entity.DownloadedImage;
import de.telran.processor.entity.ImageDescriptor;
import de.telran.processor.factory.ImageActionFactory;
import de.telran.processor.service.*;

import java.util.List;
import java.util.stream.Collectors;

public class ImageProcessor {

    private FileService fileService;
    private DownloadService downloadService;
    private ImageService imageService;

    public static void main(String[] args) throws Exception {

        String csvFile = args[0];

        FileService fs = new FileService(new FileConfigService(), new FileNameGenertorService());
        DownloadService ds =  new DownloadService(new ImageReadingService());
        ImageService is = new ImageService(new ImageActionFactory(new ActionsConfigService()));
        ImageProcessor processor = new ImageProcessor(fs, ds, is);
        processor.process(csvFile);

    }

    public ImageProcessor(FileService fileService,
                          DownloadService downloadService,
                          ImageService imageService) {
        this.fileService = fileService;
        this.downloadService = downloadService;
        this.imageService = imageService;
    }

    public void process(String fileName){
        //main logic is here

        //reading CSV file to get image data like urls and actions
        List<ImageDescriptor> imageDescriptors = fileService.readImageDescriptors(fileName);

        //download images
        List<DownloadedImage> downloadedImages = downloadService.downloadImages(imageDescriptors);

        //filter successfully downloaded images
        List<DownloadedImage> successfullyDownloadedImages = downloadedImages
                .stream()
                .filter(DownloadedImage::isSuccessful)
                .collect(Collectors.toList());


        //apply action to every downloaded image
        List<DownloadedImage> processedImages = successfullyDownloadedImages
                .stream()
                .map(di -> imageService.processImage(di))
                .collect(Collectors.toList());


        //save transformed images to disk
        processedImages
                .stream()
                .filter(di -> !di.isSuccessful())
                .forEach(f -> fileService.saveImageAsFile(f));

        //where do we save an image? - use some config service - FileConfigService

        //generate a file name. how?
        //file naming strategy: 1. action_name+random_number.jpg -> which target format to use?
        //                      2. use a file name from original URL.
        //lukaroundimg/beelitz2017/1a.jpg -> lukaroundimg_beelitz2017_1a_TRULALA.jpg
        //lukaroundimg/beelitz2017/1a.jpg -> lukaroundimg_beelitz2017_1a_GRAYSCALE.jpg
        //lukaroundimg_beelitz2017_1a.jpg -> lukaroundimg_beelitz2017_1a02.jpg

    }

}
