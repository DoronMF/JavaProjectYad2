package Yad2.PageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

public class CarPage extends AbstractComponents {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	String titleList = "";

	public CarPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // This is only if you are using PageFactory
	}

// PageFactory

// Car Type Menu
	@FindBy(xpath = "(//a[@href='/vehicles/cars#search'])[2]")
	WebElement cars; // פרטיים ומסחריים

	@FindBy(xpath = "(//a[@href='/vehicles/motorcycles#search'])[1]")
	WebElement motorcycles;

	@FindBy(xpath = "(//a[@href='/vehicles/scooters#search'])[1]")
	WebElement scooters;

	@FindBy(xpath = "(//a[@href='/vehicles/trucks#search'])[1]")
	public WebElement trucks;

	@FindBy(xpath = "(//a[@href='/vehicles/watercraft#search'])[1]")
	WebElement waterCrafts;

	@FindBy(xpath = "(//a[@href='/vehicles/other#search'])[1]")
	WebElement othersSpecials;

// Filter

	@FindBy(xpath = "(//span[@class='pseudo-drop-button_text__duTa4'])[1]")
	WebElement carType;

	@FindBy(xpath = "(//span[@class='pseudo-drop-button_text__duTa4'])[2]")
	WebElement carManufacturer;

	@FindBy(xpath = "(//span[@class='pseudo-drop-button_text__duTa4'])[3]")
	WebElement carmodel;

	@FindBy(xpath = "(//span[@class='pseudo-drop-button_text__duTa4'])[4]")
	WebElement carYear;

	@FindBy(css = ".toggle-button_buttonText__jUvpU")
	WebElement otherFilters;

	@FindBy(css = "button[type='submit']")
	WebElement searchButton;

	@FindBy(xpath = "(//img[@alt='רכב משפחתי'])[2]")
	WebElement familyCars;

	@FindBy(xpath = "//span[text()='XPENG']")
	WebElement manufacturerExample;

	@FindBy(xpath = "//span[text()='G9']")
	WebElement modelExample;

	@FindBy(xpath = "//span[text()='עם תמונה']")
	WebElement extrasExample1;

	@FindBy(xpath = "//span[text()='עם מחיר']")
	WebElement extrasExample2;

	@FindBy(xpath="(//input[@data-nagish='search-ui-simple-input'])[3]")
	WebElement fromPrice;
	
	@FindBy(xpath="(//input[@data-nagish='search-ui-simple-input'])[4]")
	WebElement toPrice;
	
	@FindBy(css = ".action-buttons_approve__pG6HF")
	WebElement confirmButton;
	
	@FindBy(css=".no-results_noResults__6_UYR")
	WebElement errorMessage;
	
	@FindBy (css=".search-results_heading__R1Ikr")
	WebElement vehicleHeading;

	
	By errorMeesageBy = By.cssSelector(".no-results_noResults__6_UYR");
			
	public boolean carSearch() {

		String carName = "רכבים";
		// System.out.println(carName);
		cars.click();
		String carHeading = vehicleHeading.getText().split(" ")[0]
				.trim();
		// System.out.println(carHeading);
		if (carHeading.equalsIgnoreCase(carName)) {
			System.out.println("Car Comparison passed");
			return true;
		} else {
			return false;
		}
	}

	public boolean motorcycleSearch() {

		String motorcycleName = motorcycles.getText();
		// System.out.println(motorcycleName);
		motorcycles.click();
		String motorcycleHeading = vehicleHeading.getText().split(" ")[0].trim();
		// System.out.println(motorcycleHeading);
		if (motorcycleName.equalsIgnoreCase(motorcycleHeading)) {
			System.out.println("MotorCycle Comparison passed");
			return true;
		} else {
			return false;
		}
	}

	public boolean scooterSearch() {

		String scooterName = scooters.getText();
		// System.out.println(scooterName);
		scooters.click();
		String scooterHeading = vehicleHeading.getText().split(" ")[0].trim();
		// System.out.println(scooterHeading);
		if (scooterName.equalsIgnoreCase(scooterHeading)) {
			System.out.println("Scooter Comparison passed");
			return true;
		} else {
			return false;
		}
	}

	public boolean truckSearch() {

		String truckName = trucks.getText();
		// System.out.println(truckName);
		trucks.click();
		String truckHeading = vehicleHeading.getText().split(" ")[0]
				.trim();
		// System.out.println(truckHeading);
		if (truckName.equalsIgnoreCase(truckHeading)) {
			System.out.println("Truck Comparison passed");
			return true;
		} else {
			return false;
		}
	}

	public boolean waterCraftSearch() {

		String waterCraftName = waterCrafts.getText();
		// System.out.println(waterCraftName);
		waterCrafts.click();
		String waterCraftHeading1 = vehicleHeading.getText().split(" ")[0].trim();
		String waterCraftHeading2 = vehicleHeading.getText().split(" ")[1].trim();
		String waterCraftHeading = waterCraftHeading1.concat(" ").concat(waterCraftHeading2);
		// System.out.println(waterCraftHeading);
		if (waterCraftName.equalsIgnoreCase(waterCraftHeading)) {
			System.out.println("Water Craft Comparison passed");
			return true;
		} else {
			return false;
		}
	}

	public boolean othersSpecialSearch() {

		String othersSpecialName = othersSpecials.getText();
		// System.out.println(othersSpecialName);
		othersSpecials.click();
		String othersSpecialHeading = vehicleHeading.getText().split(" ")[1].trim();
		// System.out.println(othersSpecialHeading);
		if (othersSpecialName.equalsIgnoreCase(othersSpecialHeading)) {
			System.out.println("Others/Specials Comparison passed");
			return true;
		} else {
			return false;
		}
	}

	public void carTypesInnerSearch() {
		carType.click();
		familyCars.click();
		carManufacturer.click();
		manufacturerExample.click();
		carmodel.click();
		modelExample.click();
		carYear.click();
		otherFilters.click();
		extrasExample1.click();
		extrasExample2.click();
		fromPrice.sendKeys("10");
		toPrice.sendKeys("10");
		confirmButton.click();
		searchButton.click();
	}
	
	public String getErrorMessage() throws InterruptedException {
		waitingForVisibilityOfElement(errorMeesageBy);
		return errorMessage.getText();
	}

}
