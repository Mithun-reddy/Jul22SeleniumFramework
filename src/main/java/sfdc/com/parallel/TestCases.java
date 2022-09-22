package sfdc.com.parallel;

import org.testng.annotations.Test;

import sfdc.com.pages.AccountsPage;
import sfdc.com.pages.LoginPage;

public class TestCases extends DriverFactory {
	
	
	@Test
	public void test1() {
		LoginPage lp = new LoginPage(getDriver());
//		AccountsPage ap = new AccountsPage(getDriver());
		getDriver().get("https://login.salesforce.com");
		lp.username.sendKeys("jul22.mithun@ta.com");
		lp.password.sendKeys("Mithun123");
		lp.loginButton.click();
	}

	@Test
	public void test2() {
		LoginPage lp = new LoginPage(getDriver());
		getDriver().get("https://login.salesforce.com");
		lp.username.sendKeys("jul22.mithun@ta.com");
		lp.password.sendKeys("Mithun123");
		lp.loginButton.click();
	}
	
	@Test
	public void test3() {
		LoginPage lp = new LoginPage(getDriver());
		getDriver().get("https://login.salesforce.com");
		lp.username.sendKeys("jul22.mithun@ta.com");
		lp.password.sendKeys("Mithun123");
		lp.loginButton.click();
	}
	
	@Test
	public void test4() {
		LoginPage lp = new LoginPage(getDriver());
		getDriver().get("https://login.salesforce.com");
		lp.username.sendKeys("jul22.mithun@ta.com");
		lp.password.sendKeys("Mithun123");
		lp.loginButton.click();
	}
}
