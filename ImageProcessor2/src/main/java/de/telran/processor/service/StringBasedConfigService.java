package de.telran.processor.service;

import java.util.Arrays;
import java.util.List;

public class StringBasedConfigService implements ActionsConfigServiceInt {
    @Override
    public String getActionPackage() {
        return "de.telran.processor.action";
    }

    @Override
    public List<String> getActionClassNames() {
        return Arrays.asList("GrayscaleImageAction","DefaultImageAction","PreviewImageAction","NewImageAction");
    }
}
