package Yad2.AbstractComponents;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this); //This is only if you are using PageFactory
	
	}
	//@FindBy (css = "img[src*='logo-default']")
	//protected
	//WebElement logo;

	@FindBy (xpath = "\"(//img[@alt='יד2 לעמוד הבית'])[2]\"")
	WebElement logo;
	
//	public void clickOnLogo() {
//		logo.click();
//	}
	
	public void childParentWindow() throws InterruptedException {
		
		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
		Iterator<String>it = windows.iterator();
		String parentId = it.next();
		//System.out.println(parentId);
		String childId = it.next();
		//System.out.println(childId);
		driver.switchTo().window(parentId);
		Thread.sleep(2000);
	}
	
	public void childWindow1() throws InterruptedException {
		
		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
		Iterator<String>it = windows.iterator();
		String parentId = it.next();
		//System.out.println(parentId);
		String childId1 = it.next();
		//System.out.println(childId);
		driver.switchTo().window(childId1);
		Thread.sleep(2000);
	}

	public void childWindow2() throws InterruptedException {
		
		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
		Iterator<String>it = windows.iterator();
		String parentId = it.next();
		//System.out.println(parentId);
		String childId1 = it.next();
		String childId2 = it.next();
		//System.out.println(childId);
		driver.switchTo().window(childId2);
		Thread.sleep(2000);
	}
	
	public void childWindow3() throws InterruptedException {
		
		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
		Iterator<String>it = windows.iterator();
		String parentId = it.next();
		//System.out.println(parentId);
		String childId1 = it.next();
		String childId2 = it.next();
		String childId3 = it.next();
		//System.out.println(childId);
		driver.switchTo().window(childId3);
		Thread.sleep(2000);
	}
	public void waitingForVisibilityOfElement(By findBy) throws InterruptedException {
		//Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitingForinvisibilityOfElement(By findBy) throws InterruptedException {
		//Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}

	public void waitingForPresenceOfElementLocated(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(findBy));
		
		boolean staleElement = true;
		while (staleElement) {
                // Attempt to interact with the element
			wait.until(ExpectedConditions.presenceOfElementLocated(findBy)).click();
             staleElement = false; // Exit the loop if successful
		} 
		wait.until(ExpectedConditions.presenceOfElementLocated(findBy));
	}

	
}

