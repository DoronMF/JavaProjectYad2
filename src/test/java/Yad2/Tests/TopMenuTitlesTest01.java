package Yad2.Tests;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Yad2.TestComponents.BaseTest;

public class TopMenuTitlesTest01 extends BaseTest {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	@Test

	public void TopMenuTitlesTest01() throws IOException, InterruptedException {

		homePage.getTopMenuTitles();
	}

}
