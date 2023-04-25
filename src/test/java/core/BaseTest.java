package core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.Browser;
import utils.PropertiesReader;


public class BaseTest {

    private static ExtentReports extent;

    /**
     * Method to set up Extent Report
     */
    @BeforeSuite
    public void setUpExtentReport(){
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target\\report\\ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @BeforeMethod
    public void setUp() throws Exception {
        //Opening the browser
        String configPath = "src/main/resources/config.properties";
        String browser = PropertiesReader.getBrowser(configPath);
        Browser.open(browser);
    }

    /**
     * Tear down method to quit the webdriver and creating the Report
     * @param result
     */
    @AfterMethod
    public void tearDown(ITestResult result){
        // Closing the browser
        Browser.quit();

        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test skipped");
        } else {
            test.log(Status.PASS, "Test passed");
        }
        extent.flush();
    }
}
