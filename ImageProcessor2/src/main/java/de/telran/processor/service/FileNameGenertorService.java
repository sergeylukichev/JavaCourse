package de.telran.processor.service;

import de.telran.processor.entity.ImageDescriptor;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class FileNameGenertorService {

    public String generateImageName(ImageDescriptor descriptor) throws MalformedURLException {
        String imageURL = descriptor.getImageURL();
        String actionName = descriptor.getActionName();
        String path = new URL(imageURL).getPath(); //lukaroundimg/beelitz2017/1a.jpg
        File file = new File(path);
        String fileName = actionName + file.getAbsolutePath().replace("/", "_");
        return fileName;
    }

}
