package sfdc.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
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
	
	@Test(dataProvider = "UserNames", dataProviderClass = LoginTest.class, groups = "Login")
	public void loginErrorMessage01(String username, String password) {
//		SoftAssert sa = new SoftAssert();
		String expectedTitle = "Login | Salesforce";
		String actualTitle = driver.getTitle();
//		String username = "jul22.mithun@ta.com";
		Assert.assertEquals(actualTitle, expectedTitle, "Login page should be visible");
		String expectedError = "Please enter your password.";
		WebElement usernameElement = driver.findElement(By.name("username"));
		usernameElement.sendKeys(username);
		String actualUsername = usernameElement.getAttribute("value");
		Assert.assertEquals(actualUsername, username, "username displayed should be equal");
		driver.findElement(By.name("pw")).clear();
		String actualPw = driver.findElement(By.name("pw")).getText();
		Assert.assertEquals(actualPw, "", "password should be null");
		driver.findElement(By.id("Login")).click();
		String actualError = driver.findElement(By.id("error")).getText();
		//hard assert
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

	@Test(groups = "Login", priority = 1)
	public void loginToSFDC() {
		
	}
	
	@Test (groups = "Home")
	public void checkRememberMe() {
		
	}
	
	@Test (dependsOnMethods = "loginErrorMessage01")
	public void forgotPassword4A() {
		
	}
	
	@Test(dependsOnGroups = "Login")
	public void forgotPassword4B() {
		
	}
	
	
	@DataProvider(name = "UserNames")
	public Object[][] userCreds(){
		
		return new Object[][] {{"mithun.r@tekarch.com", "1234"},{"jul22.mithun@ta.com","Mithun123"}};
	}
	

}
