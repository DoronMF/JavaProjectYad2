package Yad2.Tests;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Yad2.PageObjects.CarPage;
import Yad2.TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	@Test
	
	public void ErrorValidation() throws IOException, InterruptedException {
		homePage.carTopMenu.click();
		CarPage carPage = new CarPage(driver);
		carPage.carTypesInnerSearch();
		Assert.assertEquals("זה לא עניין שבשגרה, אבל מה שחיפשת לא נמצא",carPage.getErrorMessage());
	}

}