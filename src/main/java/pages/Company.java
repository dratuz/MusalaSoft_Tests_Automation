package pages;

import core.BasePageAction;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;

public class Company extends BasePageAction {

    private static final By COMPANY_LEADERSHIP_SECTION_ELEMENT = By.cssSelector("section.company-members > div > h2");
    private static final By COMPANY_FACEBOOK_LINK_FROM_FOOTER = By.cssSelector("body > footer > div > div > a:nth-child(5)");
    private static final By COOKIES_ACCEPT_BUTTON = By.id("wt-cli-accept-all-btn");


    /**
     * Verify Page Url
     * @param exp_companyPageUrl - Expected Page Url
     * @param messageOnTestFailure - Message on test failure
     */
    public static void verifyPageUrl(String exp_companyPageUrl, String messageOnTestFailure) {
        String act_CurrentPageUrl = getCurrentUrl();
        Assert.assertEquals(act_CurrentPageUrl, exp_companyPageUrl, messageOnTestFailure);
    }

    /**
     * Verify if there is Leadership Section
     * @param exp_Section_title - Expected section title result
     * @param messageOnTestFailure_Section_title - Message on test failure
     */
    public static void verifyContainingLeadershipSection(String exp_Section_title, String messageOnTestFailure_Section_title) {
        String act_Section_Title = getText(COMPANY_LEADERSHIP_SECTION_ELEMENT);
        Assert.assertEquals(act_Section_Title, exp_Section_title, messageOnTestFailure_Section_title);
    }

    /**
     * Click Facebook link from the page footer and switch the the newly opened window
     */
    public static void clickFacebookLink_FromFooter() {
        click(COOKIES_ACCEPT_BUTTON);
        click(COMPANY_FACEBOOK_LINK_FROM_FOOTER);

        // Switch to the new window
        for (String windowHandle : Browser.driver.getWindowHandles()){
            Browser.driver.switchTo().window(windowHandle);
        }
    }
}
