package Yad2.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Yad2.PageObjects.HomePage;

public class BaseTest {

	public WebDriver driver;
	public HomePage homePage;
	
	public WebDriver initializeDriver() throws IOException {
		
	// Properties Class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//Yad2//Resources//GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
		
			//ChromeOptions options = new ChromeOptions();
	        //options.addArguments("--incognito");
	        //options.setAcceptInsecureCerts(true);
			
	        driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			String geckoDriverPath = System.getProperty("user.dir") + "\\DriversJava\\geckodriver.exe";
		    System.setProperty("webdriver.gecko.driver", geckoDriverPath);
			driver = new FirefoxDriver();
			
		} else if (browserName.equalsIgnoreCase("edge")) {
			String edgeDriverPath = System.getProperty("user.dir") + "\\DriversJava\\msedgedriver.exe";
		    System.setProperty("webdriver.edge.driver", edgeDriverPath);
			driver = new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.manage().deleteAllCookies();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
		return driver;

	}  
		 @BeforeMethod   
		public HomePage launchApplication() throws IOException {
			driver = initializeDriver();
			homePage = new HomePage(driver);
			homePage.goTo();
			return homePage;
		}
		 
		 @AfterMethod
		 public void closeBrowser() throws InterruptedException {
			 Thread.sleep(3000);
			 driver.quit();
		 }
		 
		 public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
			 TakesScreenshot ts = (TakesScreenshot) driver; 
			 File source = ts.getScreenshotAs(OutputType.FILE);
			 File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
			 FileUtils.copyFile(source, file);
			 return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
			 
		 }
}