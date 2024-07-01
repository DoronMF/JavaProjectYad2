package Yad2.Tests;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import Yad2.PageObjects.TruckDetailsPage;
import Yad2.TestComponents.BaseTest;

public class TruckSearchDetailedPageComparisonTest06 extends BaseTest {

	@Test
	
	public void TruckSearchDetailedPageComparisonTest06() throws IOException, InterruptedException {
		Actions a = new Actions(driver);
		a.moveToElement(homePage.carTopMenu).moveToElement(homePage.carToTruckTopMenu).click().build().perform();
		TruckDetailsPage truckDetailsPage = new TruckDetailsPage(driver);
		Assert.assertTrue(truckDetailsPage.truckSearchDetailedPageComparison(driver));
		
				}

}
