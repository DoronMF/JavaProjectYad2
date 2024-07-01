package Yad2.PageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Yad2.AbstractComponents.AbstractComponents;

//import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class TruckDetailsPage extends AbstractComponents {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	String titleList = "";

	public TruckDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // This is only if you are using PageFactory
	}

	// PageFactory


	//Truck Search Page
	@FindBy(xpath = "(//span[@class='feed-item-info_heading__k5pVC'])[1]")
	WebElement manufacturerFromSearch;
	
	@FindBy(xpath = "(//span[@class='feed-item-info_marketingText__eNE4R'])[1]")
	WebElement modelFromSearch;
	
	@FindBy(xpath = "(//span[@class='feed-item-info_yearAndHandBox___JLbc'])[1]")
	WebElement yearFromSearch;
	
	@FindBy(xpath = "(//span[@class='price_price__xQt90'])[1]")
	WebElement priceFromSearch;
	
	
	@FindBy (xpath = "(//div[@class='feed-item-base_imageBox__rD5Q8 feed-item-base_hasTags__sAErH'])[1]")
	WebElement truckImage;
	
	
	// Truck Details Page
	@FindBy(css = "h1[class='heading_heading__6RE1P']")
	WebElement manufacturer;
	
	@FindBy(css = ".marketing-name_marketingName__VoALw")
	WebElement model;
	
	@FindBy(xpath = "(//span[@class= 'details-item_itemValue__r0R14'])[1]")
	WebElement year;
	
	@FindBy(xpath = "(//span[@data-testid='term'])[1]")
	WebElement hand1;
	
	@FindBy(xpath = "(//span[@class= 'details-item_itemValue__r0R14'])[2]")
	WebElement hand2;
	
	@FindBy(css = ".ad-price_adPriceBox__YOV1f.desktop-only")
	WebElement price;
	
		
	By priceBy = By.cssSelector(".ad-price_adPriceBox__YOV1f.desktop-only");;
	
	
	public boolean truckSearchDetailedPageComparison(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		String yearSearch = yearFromSearch.getText().split(" ")[0].trim();
		String hand1Search = yearFromSearch.getText().split(" ")[2].trim();
		String hand2Search = yearFromSearch.getText().split(" ")[3].trim();
		String outerSearchString = manufacturerFromSearch.getText() + " " + modelFromSearch.getText() + " " + yearSearch  + " " + hand1Search + " " + hand2Search + " " + priceFromSearch.getText();
		System.out.println(outerSearchString);
		
		truckImage.click();
		Thread.sleep(3000);
		
		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
		Iterator<String>it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);

		String detailsPageString = manufacturer.getText() + " " + model.getText() + " " + year.getText() + " " + hand1.getText() + " " + hand2.getText() + " " + price.getText();
		System.out.println(detailsPageString);
		driver.switchTo().window(parentId);
		if (outerSearchString.equalsIgnoreCase(detailsPageString)) {
			System.out.println("COMPARISON BETWEEN THE SEARCH PAGE AND DETAILS PAGE COMPLETE");
			return true;
		} else {
			return false;
		}
		
	}
}