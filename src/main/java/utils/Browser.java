package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Browser {

    public static WebDriver driver;

    /**
     * Opens a desired by us browser. Supported: "chrome", "firefox"
     * @param browser the browser you would like to use for running the current tests
     */
    public static void open(String browser) {
        switch (browser){
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
                break;
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
                break;
            }

            default: throw new RuntimeException("Such browser is NOT supported -> " + browser);
        }
    }

    /**
     * Quits the driver process and all associated windows with it
     */
    public static void quit() {
        driver.quit();
    }
}
