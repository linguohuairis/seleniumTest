
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;


public class Mytest {

    WebDriver diver;
    ExtentHtmlReporter report = new ExtentHtmlReporter("src/Report/result.html");
    ExtentReports extent = new ExtentReports();
    ExtentTest logger;
    //ExtentTest logger2 = logger.createNode("Result");

    @Test
    public void testLogin(){

        System.setProperty("webdriver.gecko.driver", "src/lib/geckodriver.exe");
        extent.attachReporter(report);
        logger = extent.createTest("Login");
        diver = new FirefoxDriver();
        logger.log(Status.INFO,"visit webcccccccc");
        diver.get("http://www.learn-automation.com");

        diver.manage().window().maximize();

        String title = diver.getTitle();
        Assert.assertTrue(title.contains("saf"));
        logger.log(Status.PASS,"ccccccccccccc");

        extent.flush();

    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {


        if(result.getStatus()==ITestResult.FAILURE){


            String screenShotPath = Utility.takeCaptureScreen(diver,result.getName());
            logger.fail("xxxx", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
            extent.flush();

        }
        diver.quit();
    }


}
