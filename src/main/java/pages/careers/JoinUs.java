package pages.careers;

import core.BasePageAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.careers.jobs.Job;
import utils.Browser;

import java.util.*;

public class JoinUs extends BasePageAction {

    private static final By GET_LOCATION_DROPDOWN = By.xpath("//*[@id=\"get_location\"]");
    private static final By FIND_ELEMENT_WITH_OPEN_JOB_TITLE = By.className("card-jobsHot__title");
    private static final By FIND_ALL_LISTED_JOBS = By.cssSelector("article[class=\"card-jobsHot\"]");
    private static final By OPEN_JOB_POSITION_CITY = By.cssSelector("p[class=\"card-jobsHot__location\"]");
    private static final By OPEN_JOB_TITLE = By.cssSelector("h2[class=\"card-jobsHot__title\"]");
    private static final By OPEN_JOB_MORE_INFO_LINK = By.cssSelector("a[class=\"card-jobsHot__link\"]");



    public static List<Job> openJobPositions = new ArrayList<>();

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

    /**
     * Method for adding open positions by city from List of WebElement to List of class Job
     * @param cityName - Name of the city Location we are looking for open positions
     */
    public static void addOpenPositionsByCityToList(String cityName) {
        List<WebElement> elements = getElements(FIND_ALL_LISTED_JOBS);

        for (WebElement element : elements){
            if (element.findElement(OPEN_JOB_POSITION_CITY).getText().contains(cityName)){
                String city = element.findElement(OPEN_JOB_POSITION_CITY).getText();
                String jobTitle = element.findElement(OPEN_JOB_TITLE).getText();
                String moreInfo = element.findElement(OPEN_JOB_MORE_INFO_LINK).getAttribute("href");
                Job job = new Job(city, jobTitle, moreInfo);

                openJobPositions.add(job);
            }
        }
    }

    /**
     * Printing All the Jobs from Job List ordered by City
     */
    public static void printAddedInListOpenPositions() {
        String cityName = "";
        Comparator<Job> comparator = Comparator.comparing(p -> p.city);
        openJobPositions.sort(comparator);

        for(Job job : openJobPositions){
            if (!job.city.equals(cityName)){
                cityName = job.city;
                System.out.println(cityName);
            }
            System.out.println("Position: " + job.positionTitle);
            System.out.println("More info: " + job.moreInfo);
        }
    }
}
