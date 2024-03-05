package cucumberStepDefinition;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import TestBase.BaseClass;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class hookes {
	 public static WebDriver driver;
	 static Properties p;

	@BeforeAll
   public static void setup() throws Exception
   {
		BaseClass.setup("Chrome");
		//BaseClass.setup("Edge");

	}
	@AfterStep
    public void addScreenshot(Scenario scenario) {
    	// this is for cucumber junit report
        	TakesScreenshot ts=(TakesScreenshot) BaseClass.getDriver();
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
    }

   @AfterAll
   public static void tearDown() {
	   BaseClass.getDriver().quit();
   }
}