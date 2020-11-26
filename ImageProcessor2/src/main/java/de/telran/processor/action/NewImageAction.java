package de.telran.processor.action;

import java.awt.image.BufferedImage;

public class NewImageAction implements ImageAction {
    @Override
    public String getName() {
        return "NEW ACTION";
    }

    @Override
    public BufferedImage doAction(BufferedImage image) throws Exception {
        System.out.println("executing new action");
        return image;
    }
}
