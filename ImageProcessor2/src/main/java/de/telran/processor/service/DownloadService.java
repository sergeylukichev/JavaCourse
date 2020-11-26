package de.telran.processor.service;

import de.telran.processor.entity.DownloadedImage;
import de.telran.processor.entity.ImageDescriptor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class DownloadService {

    private ImageReadingService imageReadingService;

    public DownloadService(ImageReadingService imageReadingService) {
        this.imageReadingService = imageReadingService;
    }

    public List<DownloadedImage> downloadImages(List<ImageDescriptor> descriptors) {
        List<DownloadedImage> imageList = new ArrayList<>();
        for(ImageDescriptor descriptor: descriptors) {
            try {
                URL url = new URL(descriptor.getImageURL());
                BufferedImage image = imageReadingService.readImageFromURL(url);
                imageList.add(new DownloadedImage(image, true, descriptor));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                imageList.add(new DownloadedImage(null, false, descriptor));
            }
        }
        return imageList;
    }
}
