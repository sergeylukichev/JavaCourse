package de.telran.processor.entity;

public class ImageDescriptor {
    private String imageURL;
    private String actionName;

    public ImageDescriptor(String imageURL, String actionName) {
        this.imageURL = imageURL;
        this.actionName = actionName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getActionName() {
        return actionName;
    }

    @Override
    public String toString() {
        return "ImageDescriptor{" +
                "imageURL='" + imageURL + '\'' +
                ", actionName='" + actionName + '\'' +
                '}';
    }
}
