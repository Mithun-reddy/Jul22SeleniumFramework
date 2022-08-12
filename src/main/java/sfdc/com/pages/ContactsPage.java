package sfdc.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends BasePage {

	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
