package TestBase;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	static Properties p;

	@Parameters({"browser"})
	@BeforeClass (groups= {"regression","smoke","master"})
	public static void setup(String browser) throws InterruptedException {

//		switch (browser) {
//		case "Chrome":
//			driver = new ChromeDriver();
//			System.out.println("Chrome is Launched.");
//			break;
//
//		case "Edge":
//			driver = new EdgeDriver();
//			System.out.println("Edge is Launched");
//			break;
//
//		}

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setPlatform(Platform.WIN11);
		capabilities.setBrowserName("MicrosoftEdge");
		driver = new RemoteWebDriver(new URL("http://10.229.38.62:4444"), capabilities);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.zigwheels.com");
		Thread.sleep(10000);
	}

	public static WebDriver getDriver() {
		return driver;
	}
	@AfterClass(groups= {"regression","smoke","master"})
	public void teardown() {
		driver.quit();
		System.out.println("Browser Closed Successfully");
	}

}

