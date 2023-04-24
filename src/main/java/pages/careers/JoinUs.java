package pages.careers;

import core.BasePageAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.Browser;

import java.util.List;

public class JoinUs extends BasePageAction {

    private static final By GET_LOCATION_DROPDOWN = By.xpath("//*[@id=\"get_location\"]");
    private static final By FIND_ELEMENT_WITH_OPEN_JOB_TITLE = By.className("card-jobsHot__title");
    private static final By FIND_ALL_LISTED_JOBS = By.className("card-jobsHot");

    /**
     * Verify if JoinUs page is open
     * @param exp_urlPage - expected Url page
     * @param messageOnFailure_pageUrl - message on test failure
     */
    public static void verifyJoinUsPageIsOpen(String exp_urlPage, String messageOnFailure_pageUrl) {
        String act_UrlPage = getCurrentUrl();
        Assert.assertEquals(act_UrlPage, exp_urlPage, messageOnFailure_pageUrl);
    }

    /**
     * Select value from dropdown
     * @param valueFromDropdownToSelect - Value that must be selected from dropdown menu
     */
    public static void selectValueFromDropdown(String valueFromDropdownToSelect) {
        selectFromDropdown(GET_LOCATION_DROPDOWN, valueFromDropdownToSelect);
    }

    /**
     * Choose open position and open it
     * @param nameOfOpenPosition - Name of the open position
     */
    public static void chooseOpenPositionByName(String nameOfOpenPosition) {

        List<WebElement> elements = getElements(FIND_ALL_LISTED_JOBS);

        // Loop through all elements
        for (WebElement element : elements) {

            // Get the text of the job title
            String elementTitle = element.findElement(FIND_ELEMENT_WITH_OPEN_JOB_TITLE).getText();

            // Check if the job title matches the provided name and open the job
            if (elementTitle.equals(nameOfOpenPosition)) {
                Actions action = new Actions(Browser.driver);
                action.moveToElement(element.findElement(By.className("back"))).click();
                action.click();
                action.perform();
                break;
            }
        }
    }

}
