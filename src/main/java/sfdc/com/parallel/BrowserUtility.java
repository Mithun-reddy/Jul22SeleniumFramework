package sfdc.com.parallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtility {
	
	public static WebDriver createBrowserInstance(String browserName, boolean headless) {
		WebDriver driver = null;
		String browser = browserName.toLowerCase();
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			if(headless) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--head");
				driver = new ChromeDriver(co);
			} else {
				driver = new ChromeDriver();
			}
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			driver = null;
		}
		return driver;
	}

}
