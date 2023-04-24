package pages;

import core.BasePageAction;
import org.openqa.selenium.By;
import utils.PropertiesReader;

import java.io.IOException;

public class Home extends BasePageAction {

    /**
     * Go to the home page
     */
    public static void goTo() throws IOException {
        String configFilePath = "src/main/resources/config.properties";
        openUrl(PropertiesReader.getUrl(configFilePath));
    }

}
