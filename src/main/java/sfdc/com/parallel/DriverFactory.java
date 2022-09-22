package sfdc.com.parallel;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;

public class DriverFactory {
	
	protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	
	@BeforeMethod
	public void setdriver() {
		WebDriver driver = BrowserUtility.createBrowserInstance("chrome", false);
		threadLocalDriver.set(driver);
	}

	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	
	@AfterMethod
	public void removeDriver() {
		getDriver().quit();
		threadLocalDriver.remove();
	}
}
