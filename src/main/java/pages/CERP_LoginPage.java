package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CERP_LoginPage
{
	private final RemoteWebDriver webdriver;
	private By email_locator;
	private By password_locator;
	private By submit_button_locator;

	public CERP_LoginPage(RemoteWebDriver driver)
	{
		webdriver = driver;
		email_locator = By.cssSelector(".form-signin .ng-scope :nth-child(4)>.form-control");
		password_locator = By.cssSelector(".form-signin .ng-scope :nth-child(5) .form-control");
		submit_button_locator = By.cssSelector(".form-signin .ng-scope :nth-child(5) .col-sm-1");
	}
	
	public CERP_MainPage login (String email, String password)
	{
		WebElementExtender.elementClearSendKeys(webdriver, email_locator, email, "CERP_MainPage_email_locatro");
		WebElementExtender.elementClearSendKeys(webdriver, password_locator, password, "CERP_MainPage_password_locator");
		WebElementExtender.elementClick(webdriver, submit_button_locator, "CERP_MainPage_submit_button_locator");
		return new CERP_MainPage (webdriver);
	}
	
}
