package sfdc.com.tests;

import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import sfdc.com.listeners.SFDCListeners;
import sfdc.com.pages.LoginPage;
import sfdc.com.pages.UserMenuPage;
import sfdc.reusable.utils.DataUtils;
import sfdc.reusable.utils.Utilities;

@Listeners(SFDCListeners.class)
public class LoginTest extends BaseTest {
	private LoginPage lp = null;
	private UserMenuPage up = null;
	private static Logger logger = LogManager.getLogger(LoginTest.class.getName());
	

	@BeforeTest
	public void initializeReport() {
//		String dateFormat = new SimpleDateFormat("yyyy_MM_dd_HHmmss").format(new Date());
//		String reportPath = System.getProperty("user.dir") + "\\src\\main\\resources\\reports\\" + dateFormat
//				+ "_sfdc.html";
//		logger.info("Started report configuration");
//		extent = new ExtentReports();
//		logger.info("Initialized extent object for the extent reports");
//		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(reportPath);
//		extent.attachReporter(htmlReport);
//		logger.info("Attached html report for the reporting");
	}

	@AfterTest
	public void reportTearDown() throws IOException {
//		extent.flush();
//		logger.info("Report flushed to the directory");
		
	}

	@BeforeClass
	public void setUp() {
//		WebDriverManager.chromedriver().setup();
//		headless mode
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--headless","--disable-gpu", "--window-size=1080,720", "--ignore-cerficate-errors");
//		driver = new ChromeDriver(co);
		
		
//		driver = getBrowser("chrome", false);
		
	}

	@BeforeMethod
	public void driverSetup(ITestContext iTest) throws IOException {
		
//		driver = getBrowser("chrome", false);
//		threadLocalDriver.set(driver);
		this.context = setContext(iTest, driver);
		
		
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
//		if(ITestResult.FAILURE == result.getStatus()) {
//			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
//		}
		driver.quit();
		logger.info("Browser is closed.");
	}

	@Test(dataProviderClass = LoginTest.class, groups = "Login")
	public void loginErrorMessage_TC01(Method name) throws IOException {
		WebDriver driver = getBrowser("chrome", false);
		lp = new LoginPage(driver);
		up = new UserMenuPage(driver);
		lp.launchApp(driver);
		test.info("App launched");
		lp.enterUsername(DataUtils.readPropertiesFile("logintestdata", "prod.valid.username"));
		test.info("Username is entered");
		lp.clearPassword();
		test.info("Password cleared");
		lp.clickLogin();
		test.info("Login button clicked");
		Assert.assertTrue(lp.isErrorMessageSeen(), "Error message should be visible");
		test.info("Login error message is seen");
		Assert.assertEquals(lp.getErrorMessage(), DataUtils.readPropertiesFile("logintestdata", "login.error.emptypasssword"));
		test.info("Empty password error message verified");
//		SoftAssert sa = new SoftAssert();
//		test = extent.createTest(name.getName());
//		logger.info("Creating the test object for "+name.getName()+" test script");
//		String username = DataUtils.readPropertiesFile("logintestdata", "prod.valid.username");
//		String expectedTitle = "Login | Salesforce";
//		String actualTitle = driver.getTitle();
////		String username = "jul22.mithun@ta.com";
//		Assert.assertEquals(actualTitle, expectedTitle, "Login page should be visible");
//		test.log(Status.INFO, "Title of the page is verified");
//		String expectedError = "Please enter your password.";
//		WebElement usernameElement = driver.findElement(By.name("username"));
//		usernameElement.sendKeys(username);
//		test.log(Status.INFO, "Username is entered");
//		String actualUsername = usernameElement.getAttribute("value");
//		Assert.assertEquals(actualUsername, username, "username displayed should be equal");
//		WebElement pass = driver.findElement(By.name("pw"));
//		test.log(Status.INFO, "password id cleared");
//		logger.error("This is resulting in an error while clearing password");
//		pass.sendKeys(DataUtils.readExcel("POIDEMO", 1, 1));
//		String actualPw = driver.findElement(By.name("pw")).getText();
//		Assert.assertEquals(actualPw, "", "password should be null");
//		driver.findElement(By.id("Login")).click();
//		logger.fatal("Shouldn't be logging in to homepage");
//		test.log(Status.INFO, "Login button clicked");
//		String actualError = driver.findElement(By.id("error")).getText();
//		// hard assert
//		Assert.assertEquals(actualError, expectedError, "Error message should be equal");
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

	@Test(groups = "Login", priority = 1)
	public void loginToSFDC_TC02() throws IOException {
		WebDriver driver = getBrowser("chrome", false);
		lp = new LoginPage(driver);
		up = new UserMenuPage(driver);
		lp.launchApp(driver);
		test.info("App launched");
		lp.enterUsername(DataUtils.readPropertiesFile("logintestdata", "prod.valid.username"));
		test.info("Valid username is entered");
		lp.enterPassword(DataUtils.readPropertiesFile("logintestdata", "prod.valid.password"));
		test.info("Valid password is entered");
		Assert.assertTrue(lp.isFreeTrailSeen(), "Free trial option should be available");
		test.info("Free trial is seen");
	}

	@Test (groups = "Login")
	public void checkRememberMe_TC03() throws IOException {
		WebDriver driver = getBrowser("chrome", false);
		lp = new LoginPage(driver);
		up = new UserMenuPage(driver);
		lp.launchApp(driver);
		test.info("App launched");
		lp.enterUsername(DataUtils.readPropertiesFile("logintestdata", "prod.valid.username"));
		test.info("Valid username is entered");
		lp.enterPassword(DataUtils.readPropertiesFile("logintestdata", "prod.valid.password"));
		test.info("Valid password is entered");
		Assert.assertTrue(lp.selectRemeberMeCheckbox(),"Remember me checkbox should be selected");
		test.info("Remember me checkbox selected");
		lp.clickLogin();
		test.info("Clicked on login button");
		Utilities.waitForElement(driver, up.userMenu);
		test.info("Waiting for usermenu to appear");
		Assert.assertTrue(up.isUserMenuSeen(),"User menu options should be seen");
		up.clickOnUserMenu();
		test.info("Clicked on user menu");
		Assert.assertTrue(up.selectOptionInUserMenuDropDown(driver, "Logout"), "logout option should be visible and clickable");
		Utilities.waitForElement(driver, lp.savedUsername);
		Assert.assertTrue(lp.isSavedUsernameSeen(), "username should be saved");
		Utilities.waitForElement(driver, lp.savedUsername);
		Assert.assertEquals(lp.getSavedUsername(), DataUtils.readPropertiesFile("logintestdata", "prod.valid.username"), "Saved username and entered username should be same" );
		test.info("User name is saved "+lp.getSavedUsername());
	}

	@Test(groups = "Login")
	public void forgotPassword_TC04A() throws IOException, InterruptedException {
		WebDriver driver = getBrowser("chrome", false);
		lp = new LoginPage(driver);
		up = new UserMenuPage(driver);
		lp.launchApp(driver);
		test.info("App launched");
		lp.clickForgotYourPassword();
		Utilities.waitForElement(driver, lp.forgotUsername);
		Assert.assertTrue(lp.isForgotPassowrdDisplayed(), "Forgot password screen should be displayed");
		lp.enterForgotUsername(DataUtils.readPropertiesFile("logintestdata", "prod.valid.actualusername"));
		lp.continueButton.click();
		Assert.assertTrue(lp.passwordResetScreen.isDisplayed(), "password reset message should be seen");
		
	}

	@Test(groups = "Login")
	public void forgotPassword_TC04B() throws IOException {
		WebDriver driver = getBrowser("chrome", false);
		lp = new LoginPage(driver);
		up = new UserMenuPage(driver);
		lp.launchApp(driver);
		test.info("App launched");
		lp.enterUsername("123");
		lp.enterPassword("22131");
		lp.clickLogin();
		Assert.assertEquals(lp.getErrorMessage(), DataUtils.readPropertiesFile("logintestdata", "login.error.up"));
	}

	@DataProvider(name = "UserNames")
	public Object[][] userCreds() {

		return new Object[][] { { "mithun.r@tekarch.com", "1234" }, { "jul22.mithun@ta.com", "Mithun123" } };
	}

}
