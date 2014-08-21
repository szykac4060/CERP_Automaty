package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CERP_UserProfilePage
{
	private final RemoteWebDriver webdriver;
	private By edit_profile;
	private By about_me_locator;
	private By web_page_locator;
	

	
	public CERP_UserProfilePage(RemoteWebDriver driver)
	{
		webdriver = driver;
		edit_profile = By.cssSelector("#user-info .user-role>div>a");
		about_me_locator = By.cssSelector(".rightCol .content");
		web_page_locator = By.cssSelector(".rightCol .links .content a");

	}

	public CERP_EditProfilePage clickEditProfile()
	{
		WebElementExtender.elementClick(webdriver, edit_profile,
				"CERP_UserProfileedit_profile");
		return new CERP_EditProfilePage(webdriver);
	}

	public void checkContent(String web_page, String about_me ) throws Exception 
	{
	
		String about_me_get_text = "";
		String web_page_get_text = "";
		about_me_get_text = WebElementExtender.elementGetText(webdriver,
				about_me_locator, "CERP_UserProfile_about_me_locator");
		web_page_get_text = WebElementExtender.elementGetText(webdriver,
				web_page_locator, "CERP_UserProfile_web_page_locator");

	
		if (!about_me_get_text.equals(about_me))
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - display about_me_get_text");
			throw new Exception();
		}

		if (!web_page_get_text.equals(web_page))
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - display web_page_get_text");
			throw new Exception();
		}
	}

}
