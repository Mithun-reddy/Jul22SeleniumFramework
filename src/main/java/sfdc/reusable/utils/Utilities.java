package sfdc.reusable.utils;

import java.time.Duration;
import java.util.List;

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
		WebElement element = null;
		switch (type) {
		case "xpath":
			element = driver.findElement(By.xpath(text));
			break;

		case "css":
			element = driver.findElement(By.cssSelector(text));
			break;
		}
		return element;
	}

	
	/**
	 * This function is responsible to verify user menu items in user menu drop down
	 * This function has to be called after clicking on user menu 
	 * @return {Boolean} true if all options are verified successfully else returns false
	 */
	public static boolean verifyUserMenuItems() {
		boolean isOptionVerified = true;
		String[] expectedUserMenuItems = { "My Profile", "My Settings", "Developer Console",
				"Switch to Lightning Experience", "Logout" };
		List<WebElement> listOfuserMenuElements = driver.findElements(By.xpath("//div[@id='userNav-menuItems']/a"));
		for (int i = 0; i < listOfuserMenuElements.size(); i++) {
			String actualUserMenuItemValue = listOfuserMenuElements.get(i).getText();
			if (actualUserMenuItemValue.equals(expectedUserMenuItems[i])) {
				System.out.println("The option " + expectedUserMenuItems[i] + " passed");
			} else {
				System.out.println("The option " + expectedUserMenuItems[i] + " failed");
				isOptionVerified = false;
			}
		}
		return isOptionVerified;
	}

	public static boolean selectOptionInUserMenuDropDown(String optionName) {
		boolean isOptionSelected = false;
		WebElement userMenuOption = driver.findElement(By.xpath("//[text()=" + optionName + "]"));
		if (userMenuOption.isDisplayed()) {
			userMenuOption.click();
			isOptionSelected = true;
		} else {
			System.out.println("Option " + optionName + " not selected");
		}
		return isOptionSelected;
	}
	
	public static boolean createAPost(WebElement textBox, String message, WebElement button) {
		boolean isPostCreated = false;
		if(textBox.isDisplayed()) {
			textBox.click();
			System.out.println("Clicked on the text box");
			textBox.sendKeys(message);
			System.out.println("Entered the text in text box");
			if(button.isDisplayed()) {
				button.click();
				System.out.println("Clicked on the post button");
				isPostCreated = true;
			}
		}
		return isPostCreated;
	}
}
