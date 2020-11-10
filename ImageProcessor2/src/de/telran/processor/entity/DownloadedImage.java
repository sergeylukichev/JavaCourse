package de.telran.processor.entity;

import java.awt.image.BufferedImage;

public class DownloadedImage {
    private BufferedImage image;
    private boolean isSuccessful;

    public DownloadedImage(BufferedImage image, boolean isSuccessful) {
        this.image = image;
        this.isSuccessful = isSuccessful;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }
}
