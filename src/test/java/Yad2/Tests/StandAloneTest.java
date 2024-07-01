package Yad2.Tests;

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

import Yad2.PageObjects.CarPage;
import Yad2.PageObjects.HomePage;
import Yad2.PageObjects.TruckDetailsPage;
import Yad2.PageObjects.TruckPage;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {

		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("http://www.yad2.co.il/");
		String homePageTitle =  driver.getTitle();

		TruckDetailsPage truckDetailsPage = new TruckDetailsPage(driver);
//		Assert.assertTrue(truckDetailsPage.truckSearchDetailedPageComparison());
		
		HomePage homePage = new HomePage(driver);
		homePage.carTopMenu.click();
		CarPage carPage = new CarPage(driver);
		carPage.carTypesInnerSearch();
		//Assert.assertTrue(carPage.carSearch());
		Assert.assertTrue(carPage.motorcycleSearch());
		Assert.assertTrue(carPage.scooterSearch());
		Assert.assertTrue(carPage.truckSearch());
		Assert.assertTrue(carPage.waterCraftSearch());
		Assert.assertTrue(carPage.othersSpecialSearch());
		
		carPage.trucks.click();
		TruckPage truckPage = new TruckPage(driver);
	//	Assert.assertTrue(truckPage.truckSearchTest());
	//	truckPage.sortedTruckList();		
		
		homePage.getTopMenuTitles();
	//	homePage.picturesMenu();
	//	homePage.topMenu();
		
	//	Assert.assertEquals(homePage.picturesMenu(),homePage.carTopMenu);

		
//		//Sorting with Java Stream - sorting the truck list and checking the sort in the 2nd page is correct
//		driver.findElement(By.xpath("(//div[@class= 'leading-categories-item_circle__6BKRz'])[2]")).click();
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='משאיות']")));
//		driver.findElement(By.xpath("//span[text()='משאיות']")).click();
//		
//		driver.findElement(By.cssSelector("svg[class='pseudo-sort-button_arrowIcon__ZlYnC pseudo-sort-button_collapsed__NTfMI']")).click(); //sort dropdown
//		driver.findElement(By.xpath("//span[text()='מחיר - מהזול ליקר']")).click();
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".feed-item-info_heading__k5pVC")));
//		
//		//Going to the 2nd page
//		driver.findElement(By.xpath("(//li[contains(@id,'pageItem-')])[2]")).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-nagish='feed-item-base-link']")));
//		
//		
//		//Getting original list after it's been sorted and then comparing it to the sort via Java Streams - seeing they are the same - means sort is good
//		List<WebElement> truckList = driver.findElements(By.cssSelector(".feed-item-info_heading__k5pVC"));
//		
//		List<String> originaTruckList = truckList.stream().map(s -> s.getText()).collect(Collectors.toList());
//		System.out.println(originaTruckList);
//		List<String> sortedTruckList = originaTruckList.stream().sorted().collect(Collectors.toList());
//		System.out.println(sortedTruckList);
//		
//		//Assert.assertTrue(originaTruckList.equals(sortedTruckList));
//		
//		
		
//		
//		//Check the number of items displayed is actually equal to the number in the results displayed
//		int itemsPerPage = driver.findElements(By.cssSelector("a[data-nagish='feed-item-base-link']")).size();
//		System.out.println(itemsPerPage);
//		List<WebElement> pagination = driver.findElements(By.cssSelector("li[data-nagish='pagination-links-item']"));
//		
//		int maxPageNumber = 0;
//		WebElement lastPageLink = null;
//		
//		for (WebElement pages: pagination) {
//			int pageNumber = Integer.parseInt(pages.getText());
//			if(pageNumber > maxPageNumber) {
//				maxPageNumber = pageNumber;
//				lastPageLink = pages;
//			}
//
//		}
//
//		lastPageLink.click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-nagish='feed-item-base-link']")));
//		int itemsPerLastPage = driver.findElements(By.cssSelector("a[data-nagish='feed-item-base-link']")).size();
//		int maxMinusOne = maxPageNumber-1;
//		int numTrucks = (maxMinusOne * itemsPerPage) + itemsPerLastPage;
//		System.out.println(numTrucks);
//		System.out.println(maxPageNumber-1);
//		
//		int itemTotal = Integer.parseInt(driver.findElement(By.cssSelector("span[data-testid='total-items']")).getText().split(" ")[0].trim().replace(",",""));
//		System.out.println(itemTotal);
//		Assert.assertEquals(numTrucks, itemTotal);
		
		System.out.println("ALMOST THE END");
		WebElement logo;
		//12. Clicking on Yad2 icon and going to home page and making sure it is the home page - compare to home page title from the beginning of scenario
		driver.findElement(By.xpath("(//img[@alt='יד2 לעמוד הבית'])[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//section[@class='index_defaultSection__nhNXA'])[1]")));
		String homeTitle = driver.getTitle();
		
		Assert.assertEquals(homePageTitle, homeTitle);
		
		
		System.out.println("THE END - THANK YOU!!");
//		//2nd way to check number of items found against whats written
//        // CSS selector for pagination container
//        String paginationSelector = "CSS_SELECTOR_FOR_PAGINATION";
//        // CSS selector for next button
//        String nextButtonSelector = "CSS_SELECTOR_FOR_NEXT_BUTTON";
//        // CSS selector for the elements to be counted
//        String elementSelector = "CSS_SELECTOR_FOR_ELEMENTS";
//
//        int totalElements = 0;
//
//        // Loop to iterate through pages
//        while (true) {
//            // Count elements on the current page
//            List<WebElement> elementsOnPage = driver.findElements(By.cssSelector(elementSelector));
//            totalElements += elementsOnPage.size();
//
//            // Check if next button exists and is clickable
//            List<WebElement> nextButton = driver.findElements(By.cssSelector(nextButtonSelector));
//            if (nextButton.size() > 0) {
//                // Click the next button to go to the next page
//                nextButton.get(0).click();
//                
//                // Wait for the next page to load
//                try {
//                    Thread.sleep(2000); // Adjust sleep time if necessary
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                break; // Exit the loop if no next button is found
//            }
//        }
//
//        // Print the total number of elements
//        System.out.println("The total number of elements is: " + totalElements);
		

		
		//options = webdriver.ChromeOptions()
		//options.add_argument(f"user-agent={ua.random}")

		//driver = webdriver.Chrome(options=options)

//		try:
//		    driver.get('https://www.yad2.co.il/')
//		    time.sleep(10)  # Adjust sleep time as necessary
//		finally:
//		    driver.quit()

		//driver.get("http://www.yad2.co.il/");

		Thread.sleep(4000);
		driver.quit();
	}

}
