package sfdc.reusable.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utilities {

	static WebDriver driver;
	public void click(WebElement element) {
		element.click();
	}

	public void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean waitForElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean assertEquals(String actual, String expected) {
		try {
			Assert.assertEquals(expected, actual);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static By xpath(String xpath) {
		
		return By.xpath(xpath);
	}
	
	public static By css(String css) {
		
		return By.cssSelector(css);
	}
	
	public static WebElement findElement(String text, String type) {
		WebElement element=null;
		switch (type) {
		case "xpath":
			element =  driver.findElement(By.xpath(text));
			break;
			
		case "css":
			element = driver.findElement(By.cssSelector(text));
			break;
		}
		
		return element;
		
		
	}
}
