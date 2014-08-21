package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CERP_EditProfilePage
{
	private final RemoteWebDriver webdriver;
	private By add_avatar_locator;
	private By submit_button_locatro;
	private By back_edit_profile_locatro;
	private By delete_avatar_locatro;
	private By close_message_locatro;
	private By add_avatar_text_locator;
	private By date_born_locator;
	private By message_validation_text_locatro;
	private By zip_code_locator;
	private By web_page_locatro;
	private By about_me_locatro;
	private By user_profile_locator;

	public CERP_EditProfilePage(RemoteWebDriver driver)
	{
		webdriver = driver;
		add_avatar_locator = By.cssSelector("#id_profile_image");
		submit_button_locatro = By.cssSelector("#dostuff");
		back_edit_profile_locatro = By.cssSelector("#tools>p :nth-child(4)");
		delete_avatar_locatro = By.cssSelector("#deleteAvatar");
		close_message_locatro = By.cssSelector("#fbOverlay #hide-fbOverlay");
		add_avatar_text_locator = By.cssSelector("#avatar_upload>.fl");
		date_born_locator = By.cssSelector("#id_dob");
		message_validation_text_locatro = By.cssSelector(".f_err>ul>li");
		zip_code_locator = By.cssSelector("#id_zip");
		web_page_locatro = By.cssSelector("#id_url");
		about_me_locatro = By.cssSelector("#id_description");
		user_profile_locator = By.cssSelector("#tools>p :nth-child(1)");

	}

	public void addAvatar(String image, String delete_avater_text) throws Exception
	{
		String delete_avatar_get_text = "";
		
		WebElementExtender.elementSendKeys(webdriver, add_avatar_locator,
				image, "CERP_EditProfile_add_avatar_locator");
		WebElementExtender.elementClick(webdriver, submit_button_locatro,
				"CERP_MainPage_submit_button_locatro");
		WebElementExtender.elementClick(webdriver, back_edit_profile_locatro,
				"CERP_EditProfile_back_edit_profile");
		delete_avatar_get_text = WebElementExtender.elementGetText(webdriver,
				delete_avatar_locatro, "CERP_EditProfile_messageLocator");

		if (!delete_avatar_get_text.equals(delete_avater_text))
		{
			WebElementExtender.logErrorMessage(webdriver, "ERROR - 	addAvatar");
			throw new Exception();
		}

	}

	public void deleteAvatar(String add_avatar_text) throws Exception
	{
		String add_avatar_get_text = "";
		

		WebElementExtender.elementClick(webdriver, delete_avatar_locatro,
				"CERP_EditProfile_delete_avatar_locatro");
		WebElementExtender.elementClick(webdriver, close_message_locatro,
				"CERP_EditProfile_close_message_locatro");
		WebElementExtender.elementClick(webdriver, submit_button_locatro,
				"CERP_MainPage_submit_button_locatro");
		WebElementExtender.elementClick(webdriver, back_edit_profile_locatro,
				"CERP_EditProfile_back_edit_profile");
		add_avatar_get_text = WebElementExtender.elementGetText(webdriver,
				add_avatar_text_locator,
				"CERP_EditProfile_add_avatar_text_locator");

		if (!add_avatar_get_text.equals(add_avatar_text))
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - deleteAvatar");
			throw new Exception();
		}

	}

	public void validationDate(String date_born_incorrect, String message_validation_text) throws Exception
	{
		String message_validation_get_text = "";
	
		WebElementExtender.elementClearSendKeys(webdriver, date_born_locator,
				date_born_incorrect, "CERP_EditProfile_date_born_locatro");
		WebElementExtender.elementClick(webdriver, submit_button_locatro,
				"CERP_MainPage_submit_button_locatro");
		message_validation_get_text = WebElementExtender.elementGetText(
				webdriver, message_validation_text_locatro,
				"CERP_EditProfile_message_validation_text_locatro");

		if (!message_validation_get_text.equals(message_validation_text))
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - message_validation");
			throw new Exception();
		}

	}

	public void sendContent(String date_born, String zip_code,
			String web_page, String about_me)
	{
		WebElementExtender.elementClearSendKeys(webdriver, date_born_locator,
				date_born, "CERP_EditProfile_date_born_locator");
		WebElementExtender.elementClearSendKeys(webdriver, zip_code_locator,
				zip_code, "CERP_EditProfile_zip_code_locator");
		WebElementExtender.elementClearSendKeys(webdriver, web_page_locatro,
				web_page, "CERP_EditProfile_web_page_locatro");
		WebElementExtender.elementClearSendKeys(webdriver, about_me_locatro,
				about_me, "CERP_EditProfile_about_me_locatro");
		WebElementExtender.elementClick(webdriver, submit_button_locatro,
				"CERP_MainPage_submit_button_locatro");

	}

	public CERP_UserProfilePage clickViewNewUserProfile()
	{
		WebElementExtender.elementClick(webdriver, user_profile_locator,
				"CERP_EditProfile_user_profile_locator");
		return new CERP_UserProfilePage(webdriver);
	}

}
