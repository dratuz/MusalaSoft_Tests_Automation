package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.Browser;

import java.util.List;

public class BasePageAction {

    /**
     * Method for clicking on given element element
     * @param locator finding element By given locator
     */
    protected static void click(By locator) {
        Browser.driver.findElement(locator).click();
    }

    /**
     * Method to open given link
     * @param url Link to be opened
     */
    protected static void openUrl(String url) {
        Browser.driver.get(url);
    }

    /**
     * Method to type string to the located field
     * @param locator finding element By given locator
     * @param text String for typing in the given element field
     */
    protected static void type(By locator, String text) {
        Browser.driver.findElement(locator).sendKeys(text);
    }

    /**
     * Method to get text from given element
     * @param locator finding element By given locator
     * @return text String from the given element
     */
    protected static String getText(By locator) {
        return Browser.driver.findElement(locator).getText();
    }

    /**
     * Scroll to element using Actions
     * @param locator finding element By given locator
     */
    protected static void scrollToElement(By locator){
        Actions builder = new Actions(Browser.driver);
        WebElement element = Browser.driver.findElement(locator);
        builder.scrollToElement(element);
        builder.perform();
    }

    /**
     * Getting the current page Url
     * @return - String with the current Url
     */
    protected static String getCurrentUrl(){
        return Browser.driver.getCurrentUrl();
    }

    /**
     * Get Element by locator
     * @param locator to find element
     * @return the located element
     */
    protected static WebElement getElement(By locator){
        return Browser.driver.findElement(locator);
    }

    /**
     * Select from dropdown by value
     * @param getLocationDropdown - Given locator to find the dropdown element
     * @param valueFromDropdownToSelect - The given value that must be selected
     */
    protected static void selectFromDropdown(By getLocationDropdown, String valueFromDropdownToSelect) {
        WebElement dropdownElement = Browser.driver.findElement(getLocationDropdown);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(valueFromDropdownToSelect);
    }

    /**
     * Method that returns List<WebElement> found by locator
     * @param findAllListedJobs - Locator to find the list of elements
     * @return - List<WebElement>
     */
    protected static List<WebElement> getElements(By findAllListedJobs) {
        return Browser.driver.findElements(findAllListedJobs);
    }
}
