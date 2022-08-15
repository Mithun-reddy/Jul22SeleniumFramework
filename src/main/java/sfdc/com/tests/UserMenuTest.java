package sfdc.com.tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import sfdc.com.pages.LoginPage;
import sfdc.com.pages.UserMenuPage;
import sfdc.reusable.utils.Utilities;

public class UserMenuTest extends BaseTest {
	
	public ExtentReports extent;
	public static ExtentTest test;
	private LoginPage lp = null;
	private UserMenuPage up = null;
	private static Logger logger = LogManager.getLogger(LoginTest.class.getName());
	
	@BeforeMethod
	public void driverSetup() throws IOException {
		driver = getBrowser("chrome", false);
//		driver = getBrowser("chrome", false);
//		threadLocalDriver.set(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		logger.info("Browser is closed.");
	}
	
	@Test(groups = "Usermenu")
	public void editProfile_TC06() throws IOException, InterruptedException {
		lp = new LoginPage(driver);
		up = new UserMenuPage(driver);
		lp.launchApp(driver);
		lp.loginToApp();
		test.info("App launched");
		Utilities.waitForElement(driver, up.userMenu);
		Assert.assertTrue(up.isUserMenuSeen(),"User menu should be seen");
		up.clickOnUserMenu();
		Assert.assertTrue(up.verifyUserMenuItems(),"User menu options should be in order");
		Assert.assertTrue(up.selectOptionInUserMenuDropDown(driver, "My Profile"),"My profile should be clickable");
		Utilities.waitForElement(driver, up.editprofilebutton);
		Assert.assertTrue(up.openEditProfileModal(), "Edit profile modal should be opened");
		Assert.assertTrue(up.changeLastNameInAboutTab(driver,"Raj"),"About tab should be selected");
		Utilities.waitForElement(driver, up.postLink);
		Assert.assertTrue(up.createAPost(driver, "Hello world"), "Post should be created");
	}
}
