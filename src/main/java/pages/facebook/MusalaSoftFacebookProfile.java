package pages.facebook;

import core.BasePageAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MusalaSoftFacebookProfile extends BasePageAction {

    private static final By ONLY_ALLOW_ESSENTIAL_COOKIES_BUTTON = By.cssSelector(
            "span[class=\"x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x1lliihq x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x xudqn12 x3x7a5m x6prxxf xvq8zen x1s688f x1dem4cn\"]");
    private static final By FACEBOOK_PROFILE_PICTURE = By.cssSelector("image[style=\"height: 168px; width: 168px;\"]");

    /**
     * Verify the current Url from facebook
     * @param exp_facebook_url - Expected result
     * @param messageOnTestFailure_facebook_url - Message on Test failure
     */
    public static void verifyCurrentUrl(String exp_facebook_url, String messageOnTestFailure_facebook_url) {
        String act_CurrentUrl = getCurrentUrl();

        Assert.assertEquals(act_CurrentUrl, exp_facebook_url, messageOnTestFailure_facebook_url);
    }

    /**
     * Verify if the facebook profile picture appears
     * @param messageOnTestFailure_Profile_Picture - Message on test failure
     */
    public static void verifyIfProfilePictureAppears(String messageOnTestFailure_Profile_Picture) {
        click(ONLY_ALLOW_ESSENTIAL_COOKIES_BUTTON);
        WebElement profilePicture = getElement(FACEBOOK_PROFILE_PICTURE);

        Assert.assertTrue(profilePicture.isDisplayed(), messageOnTestFailure_Profile_Picture);
    }
}
