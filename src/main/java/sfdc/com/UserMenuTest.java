package sfdc.com;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import sfdc.com.pages.UserMenuPage;
import sfdc.reusable.utils.Utilities;

public class UserMenuTest {

//	public WebDriver driver;
	private static Logger logger = LogManager.getLogger(ExtentReportDemo.class);
	
	@BeforeClass
	public void driverSetup() {
		WebDriverManager.chromedriver().setup();
//		headless mode
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--headless","--disable-gpu", "--window-size=1080,720", "--ignore-cerficate-errors");
//		driver = new ChromeDriver();
//		UserMenuPage up = new UserMenuPage(driver);
	}
	
	@BeforeMethod
	public void launchApp() {
//		driver = new ChromeDriver();
//		driver.get("https://login.salesforce.com");
//		driver.navigate().to("https://login.salesforce.com");
		
	}
	
	@AfterMethod
	public void tearDown() {
//		driver.quit();
	}
	
	
	public void TC06() {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.cssSelector(".menuButtonButton #userNavLabel")).click();

//		Assert.assertTrue(Utilities.verifyUserMenuItems(), "User menu items should be as expected");
//		Assert.assertTrue(Utilities.selectOptionInUserMenuDropDown("My Profile"), "Option shouls e selected");
//		Assert.assertTrue(Utilities.createAPost(null, null, null));
//		Assert.assertTrue(Utilities.isDispalyed(), "Accounts hsuls");
//		Assert.assertEquals(Utilities.updateContactInfo(), "");
		
		// clicks on my profile
//		driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a[1]")).click();
//
//		// click on edit profile
//		driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']")).click();
//
//		// Switching to an iframe
//
//		driver.switchTo().frame("contactInfoContentId");
//
//		driver.findElement(Utilities.xpath("//li[@id='aboutTab']/a")).click();
//
//		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
//		lastName.clear();
//		lastName.sendKeys("Raj");
//		driver.findElement(By.xpath("//*[@value='Save All']")).click();
//
//		// come out of iframe
//
//		driver.switchTo().defaultContent();
//
//		driver.findElement(Utilities.css("#publishereditablearea")).click();
//
//		driver.switchTo().frame(0);
//
//		driver.findElement(By.xpath("/html/body")).sendKeys("Adding my first post");
//		driver.switchTo().defaultContent();
//		driver.findElement(By.cssSelector("#publishersharebutton")).click();
//
//		driver.findElement(By.cssSelector("#publisherAttachContentPost")).click();
//		
////		Utilities.findElement("#publishersharebutton", "css").click();
//		
////		Thread.sleep(3000);
//		driver.findElement(By.xpath("//a[@id='publisherAttachContentPost']/span[1]")).click();
//		
//		driver.findElement(By.cssSelector("#chatterUploadFileAction")).click();
//		driver.findElement(By.cssSelector("#chatterFile")).sendKeys("C:\\Users\\user\\Desktop\\Framework.PNG");
//		
//		driver.findElement(By.cssSelector("#publishersharebutton")).click();
//		if(driver.findElement(By.cssSelector("#displayBadge")).isDisplayed()) {
//			driver.findElement(By.cssSelector("#displayBadge")).click();
//		} else {
//			System.out.println("Display badge is not visible");
//		}
//		driver.switchTo().frame("uploadPhotoContentId");
//		driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile")).sendKeys("C:\\Users\\user\\Desktop\\Framework.PNG");
//		driver.findElement(By.name("j_id0:uploadFileForm:uploadBtn")).click();
//
//		// explicit wait
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("j_id0:j_id7:save"))));
//		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", driver.findElement(By.name("j_id0:j_id7:save")));
		
	}

}
