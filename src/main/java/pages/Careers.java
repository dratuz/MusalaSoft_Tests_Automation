package pages;

import core.BasePageAction;
import org.openqa.selenium.By;

public class Careers extends BasePageAction {
    private static final By CHECK_OUR_OPEN_POSITIONS_BUTTON = By.cssSelector("button[class=\"contact-label contact-label-code btn btn-1b\"] span");

    /**
     * Click on "Check our open positions" button
     */
    public static void clickOpenPositionsButton() {
        click(CHECK_OUR_OPEN_POSITIONS_BUTTON);
    }
}
