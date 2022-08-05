package sfdc.com;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgDemo {

	@BeforeClass
	public void initializedriver() {
		System.out.println("Intializing driver ..");
	}
	
	@AfterClass
	public void closeDriver() {
		System.out.println("Closing driver..");
	}
	
	@BeforeTest
	public void initializeBrowser() {
		System.out.println("Initialize chrome browser");
	}
	
	@BeforeMethod
	public void setup() {
		System.out.println("Launch the app");
	}
	
	@AfterMethod
	public void signout() {
		System.out.println("Signout of the app");
	}
	
	
	@Test()
	public void login() {
		System.out.println("Logging in to sfdc.com");
	}

	@Test()
	public void loginErrorMsg() {
		System.out.println("error messgae");
//		throw new NoSuchElementException();
	}

	@Test(priority = 1)
	public void LoginErrorMsg() {
		System.out.println("Login error with wrong pass");
//		throw new SkipException("WIP");
	}
}
