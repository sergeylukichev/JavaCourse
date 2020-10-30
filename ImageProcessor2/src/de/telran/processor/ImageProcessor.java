package de.telran.processor;

import de.telran.processor.entity.ImageDescriptor;
import de.telran.processor.service.FileService;

import java.util.List;

public class ImageProcessor {

    private FileService fileService;

    public static void main(String[] args) {

        String csvFile = args[0];

        FileService fs = new FileService();
        ImageProcessor processor = new ImageProcessor(fs);
        processor.process(csvFile);

    }

    public ImageProcessor(FileService fileService) {
        this.fileService = fileService;
    }

    public void process(String fileName) {
        //main logic is here

        List<ImageDescriptor> imageDescriptors = fileService.readImageDescriptors(fileName);

        //
        //


    }

}
