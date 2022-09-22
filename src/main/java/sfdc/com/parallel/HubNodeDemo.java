package sfdc.com.parallel;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class HubNodeDemo {
	
	@Test
	public void node1() throws MalformedURLException {
		WebDriver driver = null;
		String URL = "https://www.login.salesforce.com";
 		String Node = "http://192.168.1.14:9999";
 		DesiredCapabilities cap = new DesiredCapabilities();
 		cap.setPlatform(Platform.WIN10);
 		cap.setBrowserName("chrome");
 		ChromeOptions op = new ChromeOptions();
 		op.merge(cap);

 		driver = new RemoteWebDriver(new URL(Node), cap);

 		driver.navigate().to(URL);
	}
	
//	@Test
	public void node2() throws MalformedURLException {
		WebDriver driver = null;
		String URL = "https://www.login.salesforce.com";
 		String Node = "http://192.168.1.45:6666";
 		DesiredCapabilities cap = new DesiredCapabilities();
 		cap.setPlatform(Platform.ANY);
 		cap.setBrowserName("chrome");
 		ChromeOptions op = new ChromeOptions();
 		op.merge(cap);

 		driver = new RemoteWebDriver(new URL(Node), cap);

 		driver.navigate().to(URL);
	}

	
}
