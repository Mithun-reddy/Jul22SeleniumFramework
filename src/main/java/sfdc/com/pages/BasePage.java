package sfdc.com.pages;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import sfdc.reusable.utils.DataUtils;

/**
 * @author Mithun Browser Configs, Report Configs
 */
public class BasePage {
	static Logger logger = LogManager.getLogger(BasePage.class.getName());

	public void launchApp(WebDriver driver) throws IOException {
		driver.get(DataUtils.readPropertiesFile("logintestdata", "prod.salesforce"));
//		driver.get("https://login.salesforce.com");
		logger.info("Launched the app");
	}
	

}
