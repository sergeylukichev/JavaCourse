package de.telran.processor.action;

import java.awt.image.BufferedImage;

public class DefaultImageAction implements ImageAction {

    @Override
    public String getName() {
        return "DEFAULT";
    }

    @Override
    public BufferedImage doAction(BufferedImage image) throws Exception {
        System.out.println("default action - not supported");
        return image;
    }
}
