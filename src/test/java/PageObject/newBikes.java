
package PageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class newBikes extends BasePage {

	WebDriver Driver;
	public newBikes(WebDriver driver) {
		super (driver);
	}

	//Elements

	@FindBy(id="makeId")
	WebElement manufactures;


	@FindBy(xpath="//*[@id=\"modelList\"]/li[16]/span")
	WebElement modelList;


//	@FindBy(xpath= "//div[@class='ar_b_91bed31b']/div[1]/div[2]/a")
//	List<WebElement> bikesName;

	@FindBy(xpath= "//a[@data-track-label='model-name']")
	List<WebElement> bikesName;

	@FindBy(xpath= "//div[@class='b fnt-15']")
	List<WebElement> bikesPrice;

	@FindBy(xpath= "//div[@class='clr-try fnt-14']")
	List<WebElement> launchDate;




	//action methods

	public void selectHonda() {
		Select select = new Select(manufactures);
		select.selectByVisibleText("Honda");
	}

//	public void scrollBy_1() {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,1250)", " ");
//	}

	public void viewMore() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",modelList);
	}

	public List<WebElement> bikesName() {
		return bikesName;

	}

	public List<WebElement> bikesPrice() {
		return bikesPrice;
	}

	public List<WebElement> launchDate() {
		return launchDate;
	}

	public void scrollBy_2() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1250)", " ");
	}

}
