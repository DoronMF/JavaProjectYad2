package Yad2.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Yad2.PageObjects.CarPage;
import Yad2.PageObjects.TruckPage;
import Yad2.TestComponents.BaseTest;

public class TruckSearchComparisonTest04 extends BaseTest {

	@Test

	public void TruckSearchComparisonTest04() throws IOException, InterruptedException {

		homePage.carTopMenu.click();
		CarPage carPage = new CarPage(driver);
		carPage.trucks.click();
		TruckPage truckPage = new TruckPage(driver);
		Assert.assertTrue(truckPage.truckSearchTest(driver));

	}

}
