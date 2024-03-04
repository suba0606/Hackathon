package TestCase;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import PageObject.loginPage;
import PageObject.newBikes;
import PageObject.usedCars;
import PageObject.zigWheelsHome;
import TestBase.BaseClass;
import utilities.ExcelUtilities;
import utilities.TakeScreenshot;

public class TC_01_zigwheels extends BaseClass{



	@Test(priority = 1, groups= {"regression","smoke","master"})
    public void upcmgBikes() throws Exception {
    	zigWheelsHome homePg= new zigWheelsHome(driver);
    	homePg.newBike();
    	homePg.upcomingBikes();
    	TakeScreenshot.TakeScrShot(driver);
    }

	@Test(priority = 2,groups= {"regression","master"})
	public void newBikes() throws Exception {
		newBikes newbks=new newBikes(driver);
		newbks.selectHonda();
		//newbks.scrollBy_1();
		newbks.viewMore();
		TakeScreenshot.TakeScrShot(driver);

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,1250)", " ");
//		Thread.sleep(2000);

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

//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
//		js1.executeScript("window.scrollBy(0,-1250)", " ");
//		Thread.sleep(2000);

		//newbks.scrollBy_2();

		System.out.println("=======================");

}

	@Test(priority = 3,groups= {"regression","smoke","master"})
    public void usCkr() throws Exception {
    zigWheelsHome homePg= new zigWheelsHome(driver);
	homePg.usedCars();
	homePg.chennai();
	TakeScreenshot.TakeScrShot(driver);

    }
	@Test(priority = 4,groups= {"regression","master"})
	public void upcomingCars() throws Exception {

		usedCars usedCk=new usedCars(driver);
		int j=1;
	//	usedCk.scrollBy_3();


//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,1200)", " ");
//		Thread.sleep(2000);

		// print
		List<WebElement> list = usedCk.bikesName();
		List<String> Bike = new ArrayList<String>();
		for (WebElement webElement : list) {
			String text = webElement.getText();
			Bike.add(text);
			ExcelUtilities.write(j++, 3, text);
		}
		System.out.println(Bike);
		System.out.println();
		System.out.println("=======================");
		usedCk.homePage();
	}


	@Test(priority = 5,groups= {"regression","smoke","master"})
    public void lopkg() throws Exception {
    zigWheelsHome homePg= new zigWheelsHome(driver);
    homePg.login();
    homePg.google();
    TakeScreenshot.TakeScrShot(driver);
    }


	@Test(priority = 6,groups= {"regression","master"})
	public void login() throws Exception {
		loginPage lp=new loginPage(driver);


		List<String> allHandles = new ArrayList<String>(driver.getWindowHandles());
		String currentHandle = driver.getWindowHandle();
		for (String handle : allHandles) {
			if (!handle.equals(currentHandle)) {
				driver.switchTo().window(handle);

				break;
			}
		}
			lp.txt_username();
			lp.nextPage();
			String error = lp.errorCapture();
			System.out.println(error);
			ExcelUtilities.write(1, 4, error);
			System.out.println("Error Captured Sucessfully");
			TakeScreenshot.TakeScrShot(driver);

	}
}
