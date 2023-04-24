package pages.contacts;

import core.BasePageAction;
import org.testng.Assert;
import org.openqa.selenium.By;

public class Contacts extends BasePageAction {

    private static final By CONTACT_US_BUTTON = By.cssSelector("a.fancybox > button");
    private static final By CONTACT_US_FORM_NAME_INPUT_FIELD = By.id("cf-1");
    private static final By CONTACT_US_FORM_EMAIL_INPUT_FIELD = By.id("cf-2");
    private static final By CONTACT_US_FORM_SUBJECT_INPUT_FIELD = By.id("cf-4");
    private static final By CONTACT_US_FORM_MESSAGE_INPUT_FIELD = By.id("cf-5");
    private static final By CONTACT_US_FORM_SEND_BUTTON = By.cssSelector("input[wfd-id='id26']");
    private static final By CONTACT_US_FORM_INVALID_EMAIL_MESSAGE = By.xpath("//*[@id=\"wpcf7-f875-o1\"]/form/p[2]/span/span");
    private static final By CONTACTS_BODY = By.cssSelector("section.contacts");

    /**
     * Opening Contact us popup window form
      */
    public static void contactUsForm() {
        scrollToElement(CONTACTS_BODY);
        click(CONTACT_US_BUTTON);
    }

    /**
     * Input information in the required fields
     * @param name - Input name
     * @param email - Input email
     * @param subject - Input subject
     * @param message - input message
     */
    public static void contactUs_form_InputInfoInRequiredFields(String name, String email, String subject, String message) {
        type(CONTACT_US_FORM_NAME_INPUT_FIELD, name);
        type(CONTACT_US_FORM_SUBJECT_INPUT_FIELD, subject);
        type(CONTACT_US_FORM_MESSAGE_INPUT_FIELD, message);
        type(CONTACT_US_FORM_EMAIL_INPUT_FIELD, email);
        click(CONTACT_US_FORM_SEND_BUTTON);
    }

    /**
     * Verify if the invalid Email error message will appear
     * @param exp_invalidEmailMessage - Expected invalid Email error message
     * @param messageOnTestFailure - Message on Test Failure
     */
    public static void verifyInvalidEmailErrorMessage_inContactUsForm(String exp_invalidEmailMessage, String messageOnTestFailure) {
        String act_invalidEmailMessage = getText(CONTACT_US_FORM_INVALID_EMAIL_MESSAGE);
        Assert.assertEquals(act_invalidEmailMessage, exp_invalidEmailMessage, messageOnTestFailure);
    }
}
