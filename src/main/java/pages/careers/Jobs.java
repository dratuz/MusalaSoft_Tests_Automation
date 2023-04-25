package pages.careers;

import core.BasePageAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Browser;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;

public class Jobs extends BasePageAction {

    private static final By ALL_MAIN_SECTIONS = By.className("content-title");
    private static final By APPLY_BUTTON = By.cssSelector("input[type=\"button\"][value=\"Apply\"]");
    private static final By APPLY_FORM_EMAIL_FIELD = By.id("cf-2");
    private static final By APPLY_FORM_UPLOAD_CV_FIELD = By.cssSelector("#uploadtextfield");
    private static final By COOKIES_ACCEPT_BUTTON = By.id("wt-cli-accept-all-btn");
    private static final By APPLY_FORM_SEND_BUTTON = By.cssSelector("input[type=\"submit\"][value=\"Send\"]");
    private static final By APPLY_FORM_NAME_ERROR_MESSAGE = By.cssSelector("input[id=\"cf-1\"] + span");
    private static final By APPLY_FORM_EMAIL_ERROR_MESSAGE = By.cssSelector("input[id=\"cf-2\"] + span");
    private static final By APPLY_FORM_MOBILE_ERROR_MESSAGE = By.cssSelector("input[id=\"cf-3\"] + span");


    /**
     * Verify if all 4 main sections are shown
     * @param mainSections - List with all main sections
     * @param messageOnTestFailure_mainSections - Message on Test failure
     */
    public static void verifyIfMainSectionsAreShown(List<String> mainSections, String messageOnTestFailure_mainSections) {
        List<WebElement> mainSectionsElements = getElements(ALL_MAIN_SECTIONS);

        List<String> elementTitles = new ArrayList<>();
        for (WebElement element : mainSectionsElements) {
            String title = element.findElement(By.cssSelector("h2")).getText();
            elementTitles.add(title);
        }

        for (String title : elementTitles) {
            Assert.assertTrue(mainSections.contains(title), title + " " + messageOnTestFailure_mainSections);
        }
    }

    /**
     * Verify Apply button if it is present
     * @param exp_buttonValue - Expected Value
     * @param messageOnTestFailure_applyButton - Message on Test failure
     */
    public static void verifyApplyButtonIsPresent(String exp_buttonValue, String messageOnTestFailure_applyButton) {
        String act_button_value = Browser.driver.findElement(APPLY_BUTTON).getAttribute("value");

        Assert.assertEquals(act_button_value, exp_buttonValue, messageOnTestFailure_applyButton);
    }

    /**
     * Click on the Apply button
     */
    public static void clickApplyButton() {
        click(COOKIES_ACCEPT_BUTTON);
        click(APPLY_BUTTON);
    }

    /**
     * Input invalid data in the Apply form
     * @param invalidEmail - Invalid email
     * @param cvPath - Path to the cv file
     */
    public static void inputInvalidDataInApplyForm(String invalidEmail, String cvPath) {
        type(APPLY_FORM_EMAIL_FIELD, invalidEmail);

        WebElement uploadElement = getElement(APPLY_FORM_UPLOAD_CV_FIELD);
        Actions actions = new Actions(Browser.driver);
        uploadElement.sendKeys(cvPath);
        actions.sendKeys(Keys.ENTER).perform();

        click(APPLY_FORM_SEND_BUTTON);
    }

    /**
     * Verifying Shown error messages
     * @param exp_nameErrorMessage - Expected Name error message
     * @param exp_emailErrorMessage - Expected email error message
     * @param exp_mobileErrorMessage - Expected mobile error message
     * @param messageOnFailure_ErrorMessages - Message on failure test
     */
    public static void verifyShownErrorMessages(
            String exp_nameErrorMessage,
            String exp_emailErrorMessage,
            String exp_mobileErrorMessage,
            String messageOnFailure_ErrorMessages) {

        String act_nameErrorMessage = getText(APPLY_FORM_NAME_ERROR_MESSAGE);
        String act_emailErrorMessage = getText(APPLY_FORM_EMAIL_ERROR_MESSAGE);
        String act_mobileErrorMessage = getText(APPLY_FORM_MOBILE_ERROR_MESSAGE);

        Assert.assertEquals(act_nameErrorMessage, exp_nameErrorMessage, messageOnFailure_ErrorMessages);
        Assert.assertEquals(act_emailErrorMessage, exp_emailErrorMessage, messageOnFailure_ErrorMessages);
        Assert.assertEquals(act_mobileErrorMessage, exp_mobileErrorMessage, messageOnFailure_ErrorMessages);
    }
}
