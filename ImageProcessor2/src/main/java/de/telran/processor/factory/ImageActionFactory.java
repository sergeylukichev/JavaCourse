package de.telran.processor.factory;

import de.telran.processor.action.DefaultImageAction;
import de.telran.processor.action.ImageAction;
import de.telran.processor.service.ActionsConfigServiceInt;
import de.telran.processor.service.StringBasedConfigService;

import java.util.*;

public class ImageActionFactory {

    private ActionsConfigServiceInt configService;

    private Map<String, ImageAction> imageActionsMap = new HashMap<>();

    public ImageActionFactory(ActionsConfigServiceInt configService) throws Exception {
        this.configService = configService;

        List<String> actionClassNames = configService.getActionClassNames();
        String actionPackage = configService.getActionPackage();

        for(String className:actionClassNames) {
            ImageAction imageAction = (ImageAction) Class.forName(actionPackage + "." + className)
                    .getConstructor()
                    .newInstance();
            imageActionsMap.put(imageAction.getName(), imageAction);
        }
    }

    public ImageAction getAction(String actionName) {
        ImageAction imageAction = imageActionsMap.get(actionName);
        if(imageAction == null) {
            return new DefaultImageAction();
        }
        return imageAction;
    }
/*
    public static void main(String[] args) throws Exception{

        ImageActionFactory factory = new ImageActionFactory(new StringBasedConfigService());

        ImageAction preview = factory.getAction("PREVIEW");
        preview.doAction(null);
        ImageAction grasc = factory.getAction("GRAYSCALE");
        grasc.doAction(null);

        ImageAction newAction = factory.getAction("NEW ACTION");
        newAction.doAction(null);

        ImageAction aDefault = factory.getAction("DEFAULT");
        aDefault.doAction(null);
    }

    */
}
