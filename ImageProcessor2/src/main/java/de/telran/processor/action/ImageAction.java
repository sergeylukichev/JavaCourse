package de.telran.processor.action;

import java.awt.image.BufferedImage;

public interface ImageAction {
    String getName();
    BufferedImage doAction(BufferedImage image) throws Exception;
}
