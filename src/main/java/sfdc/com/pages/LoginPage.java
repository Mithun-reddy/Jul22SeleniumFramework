package sfdc.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	
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


}
