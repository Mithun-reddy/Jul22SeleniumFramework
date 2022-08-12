package sfdc.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
@FindBy(id = "username")
public WebElement username;

@FindBy(name = "pw")
public WebElement password;

@FindBy(id = "Login")
public WebElement loginButton;

@FindBy(xpath = "//*[@id='rememberUn']")
public WebElement rememberMe;

@FindBy(partialLinkText = "Forgot Your")
public WebElement forgotYourPassword;

@FindBy(xpath = "/html/body/div[2]/div/div[6]/div[1]/div/div[8]/div/div/div/a/span")
public WebElement startFreeTrial;

@FindBy(css = "#error")
public WebElement loginError;


public void loginToApp() {
	
}

public void enterUsername(String text) {
	username.sendKeys(text);
}

public void enterPassword(String text) {
	password.sendKeys(text);
}

public void clickLogin() {
	loginButton.click();
}


/**
 * This function can be called to fetch the login error message
 * @return string with error message
 */
public String getErrorMessage() {
	String errorMessage = loginError.getText();
	return errorMessage;
}

}
