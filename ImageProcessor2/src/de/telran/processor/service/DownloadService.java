package de.telran.processor.service;

import de.telran.processor.entity.DownloadedImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DownloadService {
    public List<DownloadedImage> downloadImages(List<String> imageUrls) {
        List<DownloadedImage> imageList = new ArrayList<>();
        for(String urlName: imageUrls) {
            try {
                URL url = new URL(urlName);
                BufferedImage image = ImageIO.read(url);
                imageList.add(new DownloadedImage(image, true));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                imageList.add(new DownloadedImage(null, false));
            }
        }
        return imageList;
    }
}
