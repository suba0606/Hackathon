package cucumberStepDefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import PageObject.loginPage;
import PageObject.newBikes;
import PageObject.usedCars;
import PageObject.zigWheelsHome;
import TestBase.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ExcelUtilities;

public class identifyBikes {

	@Given("user is on zigWheels.com website")
	public void user_is_on_zig_wheels_com_website() {
		String actTitle = BaseClass.getDriver().getTitle();
		if (actTitle.equals("New Cars & Bikes, Prices, News, Reviews, Buy & Sell Used Cars - ZigWheels.com")) {
			System.out.println("Correct Website is Launched");
		} else {
			System.out.println("Incorrect Website is Launched");
			System.exit(0);
		}

	}


	@Then("navigate to upcoming bikes")
	public void navigate_to_upcoming_bikes() throws Exception {
		zigWheelsHome homePg= new zigWheelsHome(BaseClass.getDriver());
    	homePg.newBike();
    	homePg.upcomingBikes();
	}

	@Then("information of upcoming bikes")
	public void information_of_upcoming_bikes() throws IOException {

		newBikes newbks=new newBikes(BaseClass.getDriver());
		newbks.selectHonda();
		//newbks.scrollBy_1();
		newbks.viewMore();

		List<WebElement> list = newbks.bikesName();
		List<WebElement> list1 = newbks.bikesPrice();
		List<WebElement> list2 = newbks.launchDate();

		int j=1;

		for(int i=0;i<list.size();i++) {

			String bkname=list.get(i).getText();
			String bkprice=list1.get(i).getText();
			String bklaunch=list2.get(i).getText();

			if(bkprice.contains("Lakh")) {
				String[] price=bkprice.split(" ");
				float value=Float.parseFloat(price[1]);
				if(value<=4.0) {
					System.out.println(bkname+"  ---  "+bkprice+"  ---  "+bklaunch);
					ExcelUtilities.write(j, 0, bkname);
					ExcelUtilities.write(j, 1, bkprice);
					ExcelUtilities.write(j, 2, bklaunch);
					j++;
				}
			}
			else {
				System.out.println(bkname+"  ---  "+bkprice+"  ---  "+bklaunch);
				ExcelUtilities.write(j, 0, bkname);
				ExcelUtilities.write(j, 1, bkprice);
				ExcelUtilities.write(j, 2, bklaunch);
				j++;
			}


		}


		System.out.println("================");


	}

	@Given("used cars and chennai is on the page")
	public void used_cars_and_chennai_is_on_page() {

		zigWheelsHome homePg= new zigWheelsHome(BaseClass.getDriver());
		homePg.usedCars();
		homePg.chennai();
	}


	@Then("show popular models")
	public void show_popular_models() throws IOException {

		usedCars usedCk=new usedCars(BaseClass.getDriver());
		int j=1;
		List<WebElement> list = usedCk.bikesName();
		List<String> Bike = new ArrayList<String>();
		for (WebElement webElement : list) {
			String text = webElement.getText();
			Bike.add(text);
			ExcelUtilities.write(j++, 3, text);
		}
		System.out.println(Bike);
		System.out.println("=======================");
		usedCk.homePage();
	}


	@Given("click on login and google")
	public void click_on_login_and_google() {
    	zigWheelsHome homePg= new zigWheelsHome(BaseClass.getDriver());
        homePg.login();
        homePg.google();
	}


    @Then("enter the value of email")
    public void enter_the_value_of_email() {

    	loginPage lp=new loginPage(BaseClass.getDriver());


		List<String> allHandles = new ArrayList<String>(BaseClass.getDriver().getWindowHandles());
		String currentHandle = BaseClass.getDriver().getWindowHandle();
		for (String handle : allHandles) {
			if (!handle.equals(currentHandle)) {
				BaseClass.getDriver().switchTo().window(handle);

				break;
			}
		}
			lp.txt_username();
    }


    @Then("click on next page")
    public void click_on_next_page() throws IOException {

    			loginPage lp=new loginPage(BaseClass.getDriver());
				lp.nextPage();
    			String error = lp.errorCapture();
    			System.out.println(error);
    			ExcelUtilities.write(1, 4, error);
    			System.out.println("Error Captured Sucessfully");


    	}

    @Then("close the browser")
    public void close_the_browser() {
    	BaseClass.getDriver().quit();
		System.out.println("Browser Closed Successfully");

    }

	}





