package pages.contact.us.positive.pages;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.Company;
import pages.Home;
import pages.components.PageHeader;
import pages.facebook.MusalaSoftFacebookProfile;

import java.io.IOException;

public class CompanyTest extends BaseTest {

    /**
     * Test that verify the following steps:
     * 1. Verify if after clicking on Company in the Header we are redirected to the Company's page Url
     * 2. Verify that there is ‘Leadership’ section
     * 3. After clicking on the Facebook link from the footer
     *      we Verify that the correct URL (https://www.facebook.com/MusalaSoft?fref=ts) loads and
     *      verifying if the Musala Soft profile picture appears on the new page
     */
    @Test
    public void verifyCompanyAndFacebookPagesLoads_and_ProfilePictureAppears_Test() throws IOException {
        /*
         * Go from home page to Company page
         */
        Home.goTo();
        PageHeader.openCompanyPage();

        /*
         * Verifying if the company PageUrl is as expected
         */
        String exp_companyPageUrl = "https://www.musala.com/company/";
        String messageOnTestFailure_CompanyPage_Url = "The actual page url it is NOT as expected!";
        Company.verifyPageUrl(exp_companyPageUrl, messageOnTestFailure_CompanyPage_Url);

        /*
         * Verify if there is Leadership Section
         */
        String exp_Section_Title = "Leadership";
        String messageOnTestFailure_Section_Title = "The actual page url it is NOT as expected!";
        Company.verifyContainingLeadershipSection(exp_Section_Title, messageOnTestFailure_Section_Title);

        /*
        Verify if the current facebook Url is as expected
         */
        String exp_facebook_Url = "https://www.facebook.com/MusalaSoft?fref=ts";
        String messageOnTestFailure_Facebook_Url = "The actual page url it is NOT as expected!";
        Company.clickFacebookLink_FromFooter();
        MusalaSoftFacebookProfile.verifyCurrentUrl(exp_facebook_Url, messageOnTestFailure_Facebook_Url);

        String messageOnTestFailure_Profile_Picture = "MusalaSoft profile picture is NOT displayed!";
        MusalaSoftFacebookProfile.verifyIfProfilePictureAppears(messageOnTestFailure_Profile_Picture);
    }
}
