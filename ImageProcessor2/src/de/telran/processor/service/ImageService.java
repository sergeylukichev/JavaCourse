package de.telran.processor.service;

import de.telran.processor.action.DefaultImageAction;
import de.telran.processor.action.GrayscaleImageAction;
import de.telran.processor.action.ImageAction;
import de.telran.processor.action.PreviewImageAction;
import de.telran.processor.factory.ImageActionFactory;

import java.awt.image.BufferedImage;

public class ImageService {

    ImageActionFactory factory;

    public ImageService(ImageActionFactory factory) {
        this.factory = factory;
    }

    public BufferedImage processImage(BufferedImage image, String actionName) throws Exception {
        ImageAction action = factory.getAction(actionName);
        return action.doAction(image);
    }
}
