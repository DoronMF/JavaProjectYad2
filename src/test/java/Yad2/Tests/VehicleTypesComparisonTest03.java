package Yad2.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Yad2.PageObjects.CarPage;
import Yad2.TestComponents.BaseTest;

public class VehicleTypesComparisonTest03 extends BaseTest {

	@Test
	
	public void VehicleTypesComparisonTest03() throws IOException, InterruptedException {

		homePage.carTopMenu.click();
		CarPage carPage = new CarPage(driver);
		carPage.carTypesInnerSearch();
		Assert.assertTrue(carPage.carSearch());
		Assert.assertTrue(carPage.motorcycleSearch());
		Assert.assertTrue(carPage.scooterSearch());
		Assert.assertTrue(carPage.truckSearch());
		Assert.assertTrue(carPage.waterCraftSearch());
		Assert.assertTrue(carPage.othersSpecialSearch());
		
		System.out.println("");
		System.out.println("PARTS 4-6 COMPLETED");
		System.out.println("___________________");
		System.out.println("");
		
				}

}
