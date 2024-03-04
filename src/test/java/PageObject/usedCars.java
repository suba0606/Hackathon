
package PageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class usedCars extends BasePage{

	public usedCars(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath="//*[@class='zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10']/li")
	List<WebElement> popularModels;

	@FindBy(xpath="//*[@id=\"Header\"]/div/div[1]/div[1]/a/img")
	WebElement logo_click;

	//elements

	public void scrollBy_3() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", " ");
	}

	public List<WebElement> bikesName() {
		return popularModels;
	}

	public void homePage() {
		logo_click.click();
	}
}
