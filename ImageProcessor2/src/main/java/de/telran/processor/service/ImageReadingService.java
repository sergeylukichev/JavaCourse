package de.telran.processor.service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageReadingService {

    public BufferedImage readImageFromURL(URL url) throws IOException {
        return ImageIO.read(url);
    }
}
