package sfdc.com;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import sfdc.reusable.utils.Utilities;

@Listeners(ListenersDemo.class)
public class LoginTest {
	public WebDriver driver = new ChromeDriver();
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeSuite
	public void initializations() {
		
	}
	
	@BeforeTest
	public void initializeReport() {
		String dateFormat = new SimpleDateFormat("yyyy_MM_dd_HHmmss").format(new Date());
		String reportPath = System.getProperty("user.dir")+"\\src\\main\\resources\\reports\\"+dateFormat+"_sfdc.html";
		extent = new ExtentReports();
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(reportPath);
		extent.attachReporter(htmlReport);
	}
	
	@AfterTest
	public void reportTearDown() {
		extent.flush();
	}
	
	@BeforeClass
	public void driverSetup() {
//		WebDriverManager.chromedriver().setup();
//		headless mode
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--headless","--disable-gpu", "--window-size=1080,720", "--ignore-cerficate-errors");
//		driver = new ChromeDriver(co);
	}
	
	@BeforeMethod
	public void launchApp() {
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--headless","--disable-gpu", "--window-size=1080,720", "--ignore-cerficate-errors");
//		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider = "UserNames", dataProviderClass = LoginTest.class, groups = "Login")
	public void loginErrorMessage01(String username, String password) throws IOException {
//		SoftAssert sa = new SoftAssert();
		test = extent.createTest("TC01");
		String expectedTitle = "Login | Salesforce";
		String actualTitle = driver.getTitle();
//		String username = "jul22.mithun@ta.com";
		Assert.assertEquals(actualTitle, expectedTitle, "Login page should be visible");
		test.log(Status.INFO, "Title of the page is verified");
		String expectedError = "Please enter your password";
		WebElement usernameElement = driver.findElement(By.name("username"));
		usernameElement.sendKeys(username);
		test.log(Status.INFO, "Username is entered");
		String actualUsername = usernameElement.getAttribute("value");
		Assert.assertEquals(actualUsername, username, "username displayed should be equal");
		driver.findElement(By.name("pw")).clear();
		test.log(Status.INFO, "password id cleared");
		String actualPw = driver.findElement(By.name("pw")).getText();
		Assert.assertEquals(actualPw, "", "password should be null");
		driver.findElement(By.id("Login")).click();
		test.log(Status.INFO, "Login button clicked");
		String actualError = driver.findElement(By.id("error")).getText();
		//hard assert
		Assert.assertEquals(actualError, expectedError, "Error message should be equal");
		test.log(Status.PASS, "TC01 passed");
		
		// soft assert (verify)
//		sa.assertEquals(actualError, expectedError);
//		sa.assertAll();
//		if(actualError.equals(expectedError)) {
//			System.out.println("Pass");
//		}
//		else {
//			System.out.println("Fail");
//		}
	}

//	@Test(groups = "Login", priority = 1)
	public void loginToSFDC() {
		
	}
	
//	@Test (groups = "Home")
	public void checkRememberMe() {
		
	}
	
//	@Test (dependsOnMethods = "loginErrorMessage01")
	public void forgotPassword4A() {
		
	}
	
//	@Test(dependsOnGroups = "Login")
	public void forgotPassword4B() {
		
	}
	
	
	@DataProvider(name = "UserNames")
	public Object[][] userCreds(){
		
		return new Object[][] {{"mithun.r@tekarch.com", "1234"},{"jul22.mithun@ta.com","Mithun123"}};
	}
	

}
