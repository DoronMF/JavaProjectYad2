package Yad2.PageObjects;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Yad2.AbstractComponents.AbstractComponents;

public class TruckPage extends AbstractComponents {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	String titleList = "";

	public TruckPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // This is only if you are using PageFactory
	}

	// PageFactory
	@FindBy(css = "span[data-testid='total-items']")
	WebElement numTrucksFound;
	
	@FindBy (css="[class*='pseudo-sort-button_arrowIcon']")   //(css="svg[class='pseudo-sort-button_arrowIcon__ZlYnC pseudo-sort-button_collapsed__NTfMI']")
	WebElement sortByArrow;

	@FindBy (xpath = "//span[text()='מחיר - מהזול ליקר']")
	WebElement cheapToExpensive;

	@FindBy (xpath = "//span[text()='מחיר - מהיקר לזול']")
	WebElement expensiveToCheap;
	
	@FindBy (xpath = "(//li[@class='item_itemContainer__OhJfK'])[2]")
	WebElement page2Pagination;
	
	
	By page2By = By.xpath("(//li[@class='item_itemContainer__OhJfK'])[2]");
	By afterPage2By = By.cssSelector("a[data-nagish='feed-item-base-link']");
	By waitArrowKeyVisibility = By.cssSelector("[class*='pseudo-sort-button_arrowIcon']");   //By.cssSelector("svg[class='pseudo-sort-button_arrowIcon__ZlYnC pseudo-sort-button_collapsed__NTfMI']");
	
	
	public boolean truckSearchTest(WebDriver driver) {

		// Check the number of items displayed is actually equal to the number in the results displayed
		List<WebElement> itemsPerPage = driver.findElements(By.cssSelector("a[data-nagish='feed-item-base-link']"));
		System.out.println("Number of Items per Page is: " + itemsPerPage.size());
		List<WebElement> pagination = driver.findElements(By.cssSelector(".item_itemContainer__OhJfK"));

		int maxPageNumber = 0;
		WebElement lastPageLink = null;

		for (WebElement pages : pagination) {
			int pageNumber = Integer.parseInt(pages.getText());
			if (pageNumber > maxPageNumber) {
				maxPageNumber = pageNumber;
				lastPageLink = pages;
			}

		}

		lastPageLink.click();
		int itemsPerLastPage = driver.findElements(By.cssSelector("a[data-nagish='feed-item-base-link']")).size();
		int maxMinusOne = maxPageNumber - 1;
		int numTrucks = (maxMinusOne * itemsPerPage.size()) + itemsPerLastPage;
		System.out.println("The total number of pages is: " + maxPageNumber);
		System.out.println("The number of items on the last page is: " + itemsPerLastPage );
	
		int itemTotal = Integer.parseInt(numTrucksFound.getText().split(" ")[0].trim().replace(",", ""));

		boolean numCheck;
		if (numTrucks == itemTotal) {
			System.out.println("The number displayed in the Search Results is equal to the total count of items in the Search. The number is: " + numTrucks);
			numCheck = true;
		} else {
			numCheck = false;
		}
		return numCheck;
	}


	
	public boolean sortedTruckList(WebDriver driver) throws InterruptedException {

	//Sorting with Java Stream - sorting the truck list and checking the sort in the 2nd page is correct

		waitingForVisibilityOfElement(waitArrowKeyVisibility);
		Thread.sleep(2000);
		sortByArrow.click(); //sort dropdown
		Thread.sleep(2000);
		expensiveToCheap.click();
		//cheapToExpensive.click();
		Thread.sleep(2000);
		waitingForPresenceOfElementLocated(page2By);

	//Going to the 2nd page
		page2Pagination.click();

		
	//Getting original list after it's been sorted and then comparing it to the sort via Java Streams - seeing they are the same - means sort is good
		List<WebElement> truckList = driver.findElements(By.cssSelector(".feed-item-content-box_feedItemContentBoxBox__4Qypi .price_price__xQt90"));
		
		List<String> originaTruckList = truckList.stream().map(s -> s.getText().split(" ")[0]).collect(Collectors.toList());
		System.out.println(originaTruckList);
		List<String> sortedTruckList = originaTruckList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(sortedTruckList);

		if(originaTruckList.equals(sortedTruckList)){
			System.out.println("CHECKED THAT THE PRICES OF THE 2ND PAGE ARE SORTED CORRECTLY FROM HIGHEST TO LOWEST");
			return true;
		} else {
			return false;
		}
	
	}
}