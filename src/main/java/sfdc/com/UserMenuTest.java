package sfdc.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import sfdc.reusable.utils.Utilities;

public class UserMenuTest {

	public WebDriver driver;
	
	@BeforeClass
	public void driverSetup() {
		WebDriverManager.chromedriver().setup();
//		headless mode
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--headless","--disable-gpu", "--window-size=1080,720", "--ignore-cerficate-errors");
//		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void launchApp() {
		driver = new ChromeDriver();
//		driver.get("https://login.salesforce.com");
		driver.navigate().to("https://login.salesforce.com");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	public void TC06() {
		String[] expectedUserMenuValues = { "My Profile", "My Settings", "Developer Console",
				"Switch to Lightning Experience", "Logout" };
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".menuButtonButton #userNavLabel")).click();

		for (int i = 0; i < expectedUserMenuValues.length; i++) {
			String actualValue = driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a" + "[" + (i + 1) + "]"))
					.getText();
			if (actualValue.equals(expectedUserMenuValues[i])) {
				System.out.println(expectedUserMenuValues[i] + " is verified successfully");
			}
		}
		// clicks on my profile
		driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a[1]")).click();

		// click on edit profile
		driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']")).click();

		// Switching to an iframe

		driver.switchTo().frame("contactInfoContentId");

		driver.findElement(Utilities.xpath("//li[@id='aboutTab']/a")).click();

		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		lastName.clear();
		lastName.sendKeys("Raj");
		driver.findElement(By.xpath("//*[@value='Save All']")).click();

		// come out of iframe

		driver.switchTo().defaultContent();

		driver.findElement(Utilities.css("#publishereditablearea")).click();

		driver.switchTo().frame(0);

		driver.findElement(By.xpath("/html/body")).sendKeys("Adding my first post");
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("#publishersharebutton")).click();

		driver.findElement(By.cssSelector("#publisherAttachContentPost")).click();
		
//		Utilities.findElement("#publishersharebutton", "css").click();
		
//		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='publisherAttachContentPost']/span[1]")).click();
		
		driver.findElement(By.cssSelector("#chatterUploadFileAction")).click();
		driver.findElement(By.cssSelector("#chatterFile")).sendKeys("C:\\Users\\user\\Desktop\\Framework.PNG");
		
		driver.findElement(By.cssSelector("#publishersharebutton")).click();
		if(driver.findElement(By.cssSelector("#displayBadge")).isDisplayed()) {
			driver.findElement(By.cssSelector("#displayBadge")).click();
		} else {
			System.out.println("Display badge is not visible");
		}
		driver.switchTo().frame("uploadPhotoContentId");
		driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile")).sendKeys("C:\\Users\\user\\Desktop\\Framework.PNG");
		driver.findElement(By.name("j_id0:uploadFileForm:uploadBtn")).click();

		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("j_id0:j_id7:save"))));
		
//		driver.findElement(By.name("j_id0:j_id7:save")).click();
//		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.name("j_id0:j_id7:save")));
		
	}

}
