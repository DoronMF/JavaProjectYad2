package Yad2.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import Yad2.TestComponents.BaseTest;

public class TopMiddleMenuCarTitlesComparedTest02 extends BaseTest {

	@Test
	
	public void TopMiddleMenuCarTitlesComparedTest02() throws IOException, InterruptedException {

		String CarTopTitle = homePage.topMenu(driver);
		System.out.println("This is the car Top Title that I am printing: " + CarTopTitle);

		String carImageTitle = homePage.picturesMenu(driver);
		System.out.println("This is the car Image Title that I am printing: " + carImageTitle);


		System.out.println("");
		System.out.println("PARTS 1-3 COMPLETED");
		System.out.println("___________________");
		System.out.println("");
	
		Assert.assertEquals(carImageTitle, CarTopTitle);
				}

}
