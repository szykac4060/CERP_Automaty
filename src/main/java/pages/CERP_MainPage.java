package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CERP_MainPage
{
	private final RemoteWebDriver webdriver;
	
	private By login_locator;
	private By profile_locatro;
	private By view_profile_locatro;
	private By question_locator;
	private By search_locator;

	public CERP_MainPage(RemoteWebDriver driver)
	{
		webdriver = driver;
		login_locator = By.cssSelector(".pageHeader .menuUser strong");
		profile_locatro = By
				.cssSelector(".pageHeader .menuUser .menu>:nth-child(6) a");
		view_profile_locatro = By
				.cssSelector(".pageHeader .menuUser li ul.list.profile .more.viewProfile a");
		question_locator = By
				.cssSelector(".pageHeader .menuMain :nth-child(1) a ");
		search_locator = By.cssSelector(".pageHeader .menuUser li a .icoSearch");
	}

	public CERP_LoginPage clickLogIn()
	{
		WebElementExtender.elementClick(webdriver, login_locator,
				"CERP_MainPage_log_in_locator");
		return new CERP_LoginPage(webdriver);
	}

	public CERP_UserProfilePage clickViewProfile() throws InterruptedException
	{
		WebElementExtender.elementClick(webdriver, profile_locatro,
				"CERP_MainPage_profile_locatro");
		WebElementExtender.elementClick(webdriver, view_profile_locatro,
				"CERP_MainPage_view_profile_locatro");
		return new CERP_UserProfilePage(webdriver);
	}

	public CERP_QuestionPage clickQuestion()
	{
		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_MainPage_question_locator");
		return new CERP_QuestionPage(webdriver);
	}
	public CERP_SearchPage clickSearch (){
		WebElementExtender.elementClick(webdriver, search_locator, "CERP_SearchPage_clickSearch_search_locator");
		return new CERP_SearchPage (webdriver);
	}
}
