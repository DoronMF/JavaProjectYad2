package Yad2.Tests;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import Yad2.PageObjects.TruckDetailsPage;
import Yad2.TestComponents.BaseTest;

public class BackToHomePageTest07 extends BaseTest {

	@Test

	public void BackToHomePageTest07() throws IOException, InterruptedException {
		String homePageTitle = driver.getTitle();
		Actions a = new Actions(driver);
		a.moveToElement(homePage.carTopMenu).moveToElement(homePage.carToTruckTopMenu).click().build().perform();
		homePage.clickOnLogo();
		String homeTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, homeTitle);
		System.out.println("THE END - THANK YOU!!");

	}

}
