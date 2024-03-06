
package PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage{

	public loginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(id="identifierId")
	WebElement sign;

//	@FindBy(xpath="//*[@id=\"identifierNext\"]/div/button/div[3]")
//	WebElement next;

//	@FindBy(xpath="//div[@class='o6cuMc Jj6Lae']")
//	WebElement error;

	@FindBy(xpath="//div[@class='Ekjuhf Jj6Lae']")
	WebElement error;


	//Elements


//	public void sign_in() {
//		sign.click();
//	}
//

	public void txt_username() {
		sign.sendKeys("suba@gmail.com");
	}

	public void nextPage() {
		sign.sendKeys(Keys.ENTER);
	}
	public String errorCapture() {
		return error.getText();
	}
}
