package de.telran.processor.action;

import java.awt.image.BufferedImage;

public class GrayscaleImageAction implements ImageAction {
    @Override
    public String getName() {
        return "GRAYSCALE";
    }

    @Override
    public BufferedImage doAction(BufferedImage image) throws Exception {
        System.out.println("Grayscaling an image");
        //tranformation
        return null;
    }
}
