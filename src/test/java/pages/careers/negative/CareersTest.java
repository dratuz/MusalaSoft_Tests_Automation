package pages.careers.negative;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.Careers;
import pages.Home;
import pages.careers.Jobs;
import pages.careers.JoinUs;
import pages.components.PageHeader;
import utils.PropertiesReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CareersTest extends BaseTest {

    /**
     * Test to verify:
     * 1. verify if the 4 main sections are shown
     * 2. verify if the Apply button is present
     * 3. verify if error messages are shown in the Apply form
     * @throws IOException
     */
    @Test
    public void verifyJobApplyErrorMessages_Test() throws IOException {
        Home.goTo();
        PageHeader.openCareersPage();
        Careers.clickOpenPositionsButton();

        String exp_UrlPage = "https://www.musala.com/careers/join-us/";
        String messageOnFailure_PageUrl = "The current page is NOT as expected!";
        JoinUs.verifyJoinUsPageIsOpen(exp_UrlPage, messageOnFailure_PageUrl);

        String valueFromDropdownToSelect = "Anywhere";
        JoinUs.selectValueFromDropdown(valueFromDropdownToSelect);

        String nameOfOpenPosition = ".NET Developer";
        JoinUs.chooseOpenPositionByName(nameOfOpenPosition);

        List<String> mainSections = new ArrayList<>(Arrays.asList(
                "General description",
                "Requirements",
                "Responsibilities",
                "What we offer"));

        String messageOnTestFailure_mainSections = "One of the main sections is missing!";
        Jobs.verifyIfMainSectionsAreShown(mainSections, messageOnTestFailure_mainSections);

        String exp_buttonValue = "Apply";
        String messageOnTestFailure_applyButton = "The Apply button is not present!";
        Jobs.verifyApplyButtonIsPresent(exp_buttonValue, messageOnTestFailure_applyButton);
        Jobs.clickApplyButton();

        String invalidEmailPath = "src/main/resources/invalidEmail.properties";
        String cvPathFilePath = "src/main/resources/cv.properties";
        String invalidEmail = PropertiesReader.invalidEmail(invalidEmailPath);
        String cvPath = PropertiesReader.cvPath(cvPathFilePath);

        Jobs.inputInvalidDataInApplyForm(invalidEmail, cvPath);

        String exp_nameErrorMessage = "The field is required.";
        String exp_emailErrorMessage = "The e-mail address entered is invalid.";
        String exp_mobileErrorMessage = "The field is required.";
        String messageOnFailure_ErrorMessages = "The error message is wrong or not shown";
        Jobs.verifyShownErrorMessages(exp_nameErrorMessage, exp_emailErrorMessage, exp_mobileErrorMessage, messageOnFailure_ErrorMessages);
    }
}
