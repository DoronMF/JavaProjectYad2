package Yad2.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Yad2.PageObjects.CarPage;
import Yad2.PageObjects.HomePage;
import Yad2.PageObjects.TruckDetailsPage;
import Yad2.PageObjects.TruckPage;
import Yad2.TestComponents.BaseTest;

public class StandAloneTestUpdated extends BaseTest {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	@Test
	
	public void StandAlone() throws IOException, InterruptedException {


		String homePageTitle =  driver.getTitle();
		homePage.getTopMenuTitles();
		
		String carImageTitle = homePage.picturesMenu(driver);
		System.out.println("This is the car Image Title that I am printing: " + carImageTitle);

		String CarTopTitle = homePage.topMenu(driver);
		System.out.println("This is the car Top Title that I am printing: " + CarTopTitle);
		
		System.out.println("");
		System.out.println("PARTS 1-3 COMPLETED");
		System.out.println("___________________");
		System.out.println("");
	
		Assert.assertEquals(carImageTitle, CarTopTitle);
			
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
		
		carPage.trucks.click();
		TruckPage truckPage = new TruckPage(driver);
		Assert.assertTrue(truckPage.truckSearchTest(driver));
		
		Assert.assertTrue(truckPage.sortedTruckList(driver));
		
		System.out.println("");
		System.out.println("PARTS 7-9 COMPLETED");
		System.out.println("___________________");
		System.out.println("");
		
		homePage.carTopMenu.click();
		carPage.trucks.click();
		TruckDetailsPage truckDetailsPage = new TruckDetailsPage(driver);
		Assert.assertTrue(truckDetailsPage.truckSearchDetailedPageComparison(driver));
		
		WebElement logo;
	//12. Clicking on Yad2 icon and going to home page and making sure it is the home page - compare to home page title from the beginning of scenario
		homePage.clickOnLogo(); 
		//driver.findElement(By.xpath("(//img[@alt='יד2 לעמוד הבית'])[2]")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//section[@class='index_defaultSection__nhNXA'])[1]")));
		
		
		String homeTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, homeTitle);
		
		
		
		
		System.out.println("THE END - THANK YOU!!");



	}

}
