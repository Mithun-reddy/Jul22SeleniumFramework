package sfdc.com;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.helper.DataUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
import sfdc.reusable.utils.DataUtils;
import sfdc.reusable.utils.Utilities;

@Listeners(ListenersDemo.class)
public class LoginTest {
	public static WebDriver driver;
	public ExtentReports extent;
	public static ExtentTest test;
	private static Logger logger = LogManager.getLogger(LoginTest.class.getName());
	
	@BeforeSuite
	public void initializations() {
		WebDriverManager.chromedriver().setup();
		logger.debug("Initialized the chromedriver setup using webdrivermanager");

	}

	@BeforeTest
	public void initializeReport() {
		String dateFormat = new SimpleDateFormat("yyyy_MM_dd_HHmmss").format(new Date());
		String reportPath = System.getProperty("user.dir") + "\\src\\main\\resources\\reports\\" + dateFormat
				+ "_sfdc.html";
		logger.info("Started report configuration");
		extent = new ExtentReports();
		logger.info("Initialized extent object for the extent reports");
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(reportPath);
		extent.attachReporter(htmlReport);
		logger.info("Attached html report for the reporting");
	}

	@AfterTest
	public void reportTearDown() {
		extent.flush();
		logger.info("Report flushed to the directory");
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
	public void launchApp() throws IOException {
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--headless","--disable-gpu", "--window-size=1080,720", "--ignore-cerficate-errors");
//		Capabilities cp = new DesiredCapabilities();
//		driver = new RemoteWebDriver(cp);
		driver = new ChromeDriver();
		logger.debug("Chromedriver object is set as the driver");
		driver.get(DataUtils.readPropertiesFile("logintestdata", "prod.salesforce"));
		logger.info("Launching the app on the browser");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		logger.info("Browser is closed.");
	}

	@Test(dataProviderClass = LoginTest.class, groups = "Login")
	public void loginErrorMessage01(Method name) throws IOException {
//		SoftAssert sa = new SoftAssert();
		test = extent.createTest(name.getName());
		logger.info("Creating the test object for "+name.getName()+" test script");
		String username = DataUtils.readPropertiesFile("logintestdata", "prod.valid.username");
		String expectedTitle = "Login | Salesforce";
		String actualTitle = driver.getTitle();
//		String username = "jul22.mithun@ta.com";
		Assert.assertEquals(actualTitle, expectedTitle, "Login page should be visible");
		test.log(Status.INFO, "Title of the page is verified");
		String expectedError = "Please enter your password.";
		WebElement usernameElement = driver.findElement(By.name("username"));
		usernameElement.sendKeys(username);
		test.log(Status.INFO, "Username is entered");
		String actualUsername = usernameElement.getAttribute("value");
		Assert.assertEquals(actualUsername, username, "username displayed should be equal");
		WebElement pass = driver.findElement(By.name("pw"));
		test.log(Status.INFO, "password id cleared");
		logger.error("This is resulting in an error while clearing password");
		pass.sendKeys(DataUtils.readExcel("POIDEMO", 1, 1));
		String actualPw = driver.findElement(By.name("pw")).getText();
		Assert.assertEquals(actualPw, "", "password should be null");
		driver.findElement(By.id("Login")).click();
		logger.fatal("Shouldn't be logging in to homepage");
		test.log(Status.INFO, "Login button clicked");
		String actualError = driver.findElement(By.id("error")).getText();
		// hard assert
		Assert.assertEquals(actualError, expectedError, "Error message should be equal");
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
	public Object[][] userCreds() {

		return new Object[][] { { "mithun.r@tekarch.com", "1234" }, { "jul22.mithun@ta.com", "Mithun123" } };
	}

}
