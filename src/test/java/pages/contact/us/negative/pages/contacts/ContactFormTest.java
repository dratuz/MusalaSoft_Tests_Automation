package pages.contact.us.negative.pages.contacts;

import pages.Home;
import pages.contacts.Contacts;
import core.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContactFormTest extends BaseTest {

    /**
     * Verify if the error message is shown when using invalid email
     * @throws IOException
     */
    @Test
    public void invalidEmail_Test() throws IOException {
        String name = "Negative_Test_Name";
        String email = "test@test";
        String subject = "negative test Subject";
        String message = "negative test message";

        Home.goTo();
        Contacts.contactUsForm();
        Contacts.contactUs_form_InputInfoInRequiredFields(name, email, subject, message);

        String exp_invalidEmailMessage = "The e-mail address entered is invalid.";
        Contacts.verifyInvalidEmailErrorMessage_inContactUsForm(exp_invalidEmailMessage, "The invalid e-mail message was not present or it was wrong");
    }
}