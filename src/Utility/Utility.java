
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;



public class Utility {

    public static String takeCaptureScreen(WebDriver driver, String screenshotName) {

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;

            File source = ts.getScreenshotAs(OutputType.FILE);

            String dest = "src/Screenshot/"+screenshotName + ".png";

            File destination = new File(dest);
            FileUtils.copyFile(source, destination);
            return dest;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}