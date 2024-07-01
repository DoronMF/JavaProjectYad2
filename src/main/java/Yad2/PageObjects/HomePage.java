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
import org.openqa.selenium.support.ui.WebDriverWait;

import Yad2.AbstractComponents.AbstractComponents;

public class HomePage extends AbstractComponents {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	String titleList = "";

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // This is only if you are using PageFactory
	}

// PageFactory
// -----------  
// Picture Menu
	@FindBy(css = "img[alt='נדל״ן']")
	WebElement propertyImage;

	@FindBy(css = "img[alt='רכב']")
	public WebElement carImage;

	@FindBy(css = "img[alt='יד שנייה']")
	WebElement secondHandImage;

	@FindBy(css = "img[alt='דרושים']")
	WebElement neededImage;

	@FindBy(css = "img[alt='חיות מחמד']")
	WebElement petsImage;

	@FindBy(css = "img[alt='בעלי מקצוע']")
	WebElement professionalsImage;

	@FindBy(css = "img[alt='עסקים למכירה']")
	WebElement businessesForSaleImage;

// Top Menu
	@FindBy(xpath = "(//a[@href='/realestate/forsale'])[1]")
	WebElement propertyTopMenu;

	@FindBy(xpath = "(//a[@href='/vehicles/cars'])[1]")
	public WebElement carTopMenu;


	@FindBy(xpath = "(//a[@href='/vehicles/trucks'])[1]")
	public WebElement carToTruckTopMenu;
	
	
	@FindBy(xpath = "(//a[@href='/lobby/products'])[1]")
	WebElement secondHandTopMenu;

	@FindBy(css = "a[href='https://www.drushim.co.il/?utm_source=yad2&utm_medium=hp']")
	WebElement neededTopMenu;

	@FindBy(xpath = "(//a[@href='/pets/all'])[2]")
	WebElement petsTopMenu;
	
	@FindBy(xpath = "(//a[@href='/b144'])[2]")
	WebElement professionalsTopMenu;

	@FindBy(xpath = "(//a[contains(@href,'businesses-for-sale')])[2]")
	WebElement businessesForSaleTopMenu;

	@FindBy(css = "a[href='//magazine.yad2.co.il/?yad2_source=header_more']")
	WebElement magazineOnlyTopMenu;
	
	@FindBy(xpath = "(//a[@class='toYad2WebLink'])[1]")
	WebElement logoMagazinePage;
	
	@FindBy (xpath = "(//img[@alt='יד2 לעמוד הבית'])[2]")
	WebElement logo;
	
	@FindBy (css = ".menu-list-items_list__ur5ur")
	WebElement topMenuBar;

	@FindBy (xpath = "//li[@class='menu-item_listItem__7Cwz7']")
	List<WebElement> topMenuItems;
	
	
	By waitMagazineVisibleBy = By.cssSelector("a[href='https://magazine.yad2.co.il/?yad2_source=header_more']");
	By waitPetsVisibleBy = By.xpath("(//a[@href='/pets/all'])[2]");	
	By waitLogoVisibleBy = By.xpath("(//section[@class='index_defaultSection__nhNXA'])[1]");

	public void getTopMenuTitles() throws InterruptedException {
		System.out.println("Number of menu items: " + topMenuItems.size());

		Actions actions = new Actions(driver);

		for (int i = 0; i < topMenuItems.size(); i++) {
			actions.keyDown(Keys.CONTROL).click(topMenuItems.get(i)).keyUp(Keys.CONTROL).perform();
			Thread.sleep(1000); // Give time for the new tab to open
		}

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		while (it.hasNext()) {
			String window = it.next();
			driver.switchTo().window(window);

			// Try to get the title even if the page is still loading
			String title = driver.getTitle();
			System.out.println("PAGE TITLE IS: " + title);
			// titleList = titleList.concat(" ||| ").concat(driver.getTitle());
			Thread.sleep(1000); // Optional: Wait to allow time for the title to load

		}

		childParentWindow();
		logo.click();

	}

	public String picturesMenu(WebDriver driver) throws InterruptedException {
		System.out.println("");
		System.out.println("FROM THE PICTURE MENU");

		propertyImage.click();
		System.out.println("Image Menu Page Title: " + driver.getTitle());
		logo.click();

		carImage.click();
		String carImageTitle = driver.getTitle();
		System.out.println("Image Menu Page Title: " + carImageTitle);
		driver.navigate().back();

		secondHandImage.click();
		System.out.println("Image Menu Page Title: " + driver.getTitle());
		driver.navigate().back();

		neededImage.click();
		Thread.sleep(2000);
		System.out.println("Image Menu Page Title: " + driver.getTitle());
		driver.navigate().back();

		petsImage.click();
		System.out.println("Image Menu Page Title: " + driver.getTitle());
		driver.navigate().back();

		professionalsImage.click();
		System.out.println("Image Menu Page Title: " + driver.getTitle());
		driver.navigate().back();

		businessesForSaleImage.click();
		System.out.println("Image Menu Page Title: " + driver.getTitle());
		driver.navigate().back();

		return carImageTitle;
	}

	public String topMenu(WebDriver driver) throws InterruptedException {
//		WebElement [] topMenuLinkArray = {propertyTopMenu, carTopMenu, secondHandTopMenu, neededTopMenu, petsOfTopMenu, professionalsTopMenu, businessesForSaleTopMenu, magazineOnlyTopMenu, logo};

		System.out.println("");
		System.out.println("FROM THE TOP MENU");
        Actions a = new Actions(driver);

		propertyTopMenu.click();
		System.out.println("TOP Menu Page Title: " + driver.getTitle());

		carTopMenu.click();
		String carTopMenuTitle = driver.getTitle();
		System.out.println("TOP Menu Page Title: " + carTopMenuTitle);

	    secondHandTopMenu.click();
	    System.out.println("TOP Menu Page Title: " + driver.getTitle());
	    
		neededTopMenu.click();
		childWindow1();
		System.out.println("TOP Menu Page Title: " + driver.getTitle());
		childParentWindow();
				
		businessesForSaleTopMenu.click();
		System.out.println("TOP Menu Page Title: " + driver.getTitle());

		waitingForPresenceOfElementLocated(waitPetsVisibleBy);
		petsTopMenu.click();
		Thread.sleep(2000);
		System.out.println("TOP Menu Page Title: " + driver.getTitle());
		
		professionalsTopMenu.click();
		childWindow2();
		System.out.println("TOP Menu Page Title: " + driver.getTitle());
		childParentWindow();
		
		a.moveToElement(magazineOnlyTopMenu).click().build().perform();
		
		childWindow3();
		System.out.println("TOP Menu Page Title: " + driver.getTitle());
		logoMagazinePage.click();
		
		return carTopMenuTitle;
	}
	

	
	public void clickOnLogo() throws InterruptedException {
		logo.click();
		waitingForVisibilityOfElement(waitLogoVisibleBy);

		
	}
	
	public void goTo() {
		driver.get("http://www.yad2.co.il/");
	}
}
