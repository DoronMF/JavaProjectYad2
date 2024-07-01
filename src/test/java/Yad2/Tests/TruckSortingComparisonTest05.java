package Yad2.Tests;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Yad2.PageObjects.CarPage;
import Yad2.PageObjects.TruckPage;
import Yad2.TestComponents.BaseTest;

public class TruckSortingComparisonTest05 extends BaseTest {

	@Test
	
	public void TruckSortingComparisonTest05() throws IOException, InterruptedException {
//		Actions a = new 	Actions(driver);
//		a.moveToElement(homePage.carTopMenu).moveToElement(homePage.carToTruckTopMenu).click().build().perform();
		homePage.carTopMenu.click();
		CarPage carPage = new CarPage(driver);
		carPage.trucks.click();
		TruckPage truckPage = new TruckPage(driver);
		Assert.assertTrue(truckPage.sortedTruckList(driver));
		
		System.out.println("");
		System.out.println("PARTS 7-9 COMPLETED");
		System.out.println("___________________");
		System.out.println("");
				}

}
