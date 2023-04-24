package pages;

import core.BasePageAction;
import org.openqa.selenium.By;

public class Careers extends BasePageAction {
    private static final By CHECK_OUR_OPEN_POSITIONS_BUTTON = By.xpath("//*[@id=\"content\"]/div[1]/div/div[1]/div/section/div/a/button");

    /**
     * Click on "Check our open positions" button
     */
    public static void clickOpenPositionsButton() {
        click(CHECK_OUR_OPEN_POSITIONS_BUTTON);
    }
}
