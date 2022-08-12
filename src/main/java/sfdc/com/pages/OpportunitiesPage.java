package sfdc.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage extends BasePage {

	public OpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
