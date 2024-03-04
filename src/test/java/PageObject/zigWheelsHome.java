package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class zigWheelsHome extends BasePage{

	public zigWheelsHome(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//a[@href='/newbikes'][1]")
	WebElement newBikeshover_1;

	@FindBy(xpath="//span[@onclick=\"goToUrl('/upcoming-bikes')\"]")
	WebElement upcomingikes;


	@FindBy(xpath="//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[7]/a")
	WebElement usedCarshover_2;

//	@FindBy(xpath="//span[@onclick=\"goToUrl('/used-car/Chennai')\"])")
//	WebElement location;

	@FindBy(xpath="//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[7]/ul/li/div[2]/ul/li[4]/span")
	WebElement location;

	@FindBy(xpath="//*[@id=\"des_lIcon\"]")
	WebElement loginClick;


//	@FindBy(xpath="//*[@id=\"myModal3-modal-content\"]/div[1]/div/div[3]/div[6]/div")
//	WebElement googleClick;


	@FindBy (xpath="//div[@class='lgn-sc c-p txt-l pl-30 pr-30 googleSignIn']")
	WebElement googleClick;


	//Elements
	public void newBike() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(newBikeshover_1).perform();
		Thread.sleep(2000);
	}

	public void upcomingBikes() {
		upcomingikes.click();
	}

	public void usedCars() {
		Actions action = new Actions(driver);
		action.moveToElement(usedCarshover_2).perform();
	}

	public void chennai() {
		location.click();
	}


	public void login() {
		loginClick.click();
	}

	public void google() {
		googleClick.click();
	}


}
