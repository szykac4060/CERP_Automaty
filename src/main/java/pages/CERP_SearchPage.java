package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CERP_SearchPage
{
	private final RemoteWebDriver webdriver;

	private By search_imput_locator;
	private By title_locator;
	private By contents_locator;
	private By answer_contents_locator;
	private By user_name_locator;
	private By box_user_name_locator;
	private By no_results_locator;
	private By search_locator;
	private By question_locator;

	private CERP_QuestionPage random;
	private String random_string = random.random_string;
	private String random_string1 = random.random_string1;

	public CERP_SearchPage(RemoteWebDriver driver)
	{
		webdriver = driver;

		search_imput_locator = By.cssSelector("#great-filter input.big");
		title_locator = By
				.cssSelector(".pageContainer .listEntry .entry .entryCloud .content .highlight");
		contents_locator = By
				.cssSelector(".pageContainer .listEntry .entry .entryCloud .highlight");
		answer_contents_locator = By
				.cssSelector(".pageContainer .listEntry .entry .entryCloud .content .highlight");
		user_name_locator = By
				.cssSelector(".leftCol .sortable>:first-child .header > a");
		box_user_name_locator = By
				.cssSelector(".rightCol .box .previewContent .name");
		no_results_locator = By.cssSelector(".leftCol .no-results");
		search_locator = By
				.cssSelector(".pageHeader .menuUser li a .icoSearch");
		question_locator = By
				.cssSelector(".pageHeader .menuMain :nth-child(1) a ");
	}

	public void searchTitle(String title_text) throws Exception
	{
		String title_get_text = "";
		boolean exist;
		
		WebElementExtender.elementClick(webdriver, search_locator,
				"CERP_QuestionPage_searchTitle_search_locator");
		WebElementExtender.elementClearSendKeys(webdriver,
				search_imput_locator, title_text+random_string,
				"CERP_SearchPage_searchTitle_search_imput_locator");

		exist = WebElementExtender.implicitlyWait(webdriver, title_locator,
				"CERP_SearchPage_searchConents_title_locator");
		Thread.sleep(2000);
		title_get_text = WebElementExtender.elementGetText(webdriver,
				title_locator, "CERP_SearchPage_searchTitle_title_locator");
		
		
		if (!title_get_text.equals(title_text + random_string)|| exist == false)
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - search title failed ");
			throw new Exception();
		}
	}

	public void searchContents(String contents_text) throws Exception
	{
		String contents_get_text = "";
		boolean exist;

		WebElementExtender.elementClick(webdriver, search_locator,
				"CERP_QuestionPage_searchContents_search_locator");
		WebElementExtender.elementClearSendKeys(webdriver,
				search_imput_locator, contents_text + random_string,
				"CERP_SearchPage_searchContents_search_imput_locator");
		exist = WebElementExtender.implicitlyWait(webdriver, contents_locator,
				"CERP_SearchPage_searchConents_contents_locator");
		Thread.sleep(2000);
		contents_get_text = WebElementExtender.elementGetText(webdriver,
				contents_locator,
				"CERP_SearchPage_searchContents_contents_locator");
	
		if (!contents_get_text.equals(contents_text + random_string))
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - search contents failed ");
			throw new Exception();
		}
	}

	public void searchAnswerContents(String answer_contents_text)
			throws Exception
	{
		String answer_contents_get_text = "";
		boolean exist;

		WebElementExtender.elementClick(webdriver, search_locator,
				"CERP_QuestionPage_searchAnswerContents_search_locator");
		WebElementExtender.elementClearSendKeys(webdriver,
				search_imput_locator, answer_contents_text + random_string1,
				"CERP_SearchPage_searchAnswerContents_search_imput_locatorr");
		exist = WebElementExtender.implicitlyWait(webdriver,
				answer_contents_locator,
				"CERP_SearchPage_searchConents_answer_contents_locator");
		Thread.sleep(2000);
		answer_contents_get_text = WebElementExtender.elementGetText(webdriver,
				answer_contents_locator,
				"CERP_SearchPage_searchTitle_title_locator");

		if (!answer_contents_get_text.equals(answer_contents_text
				+ random_string1)
				|| exist == false)
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - search answer contgents failed ");
			throw new Exception();
		}

	}

	public void searchUser(String user_name) throws Exception
	{
		String user_name_get_text = "";
		String box_user_name_get_text = "";
		boolean exist;

		WebElementExtender.elementClick(webdriver, search_locator,
				"CERP_QuestionPage_searchUser_search_locator");
		WebElementExtender.elementClearSendKeys(webdriver,
				search_imput_locator, user_name,
				"CERP_SearchPage_searchUser_search_imput_locatorr");
		Thread.sleep(3000);
		exist = WebElementExtender.implicitlyWait(webdriver, user_name_locator,
				"CERP_SearchPage_searchUser_answer_contents_locator");
		user_name_get_text = WebElementExtender.elementGetText(webdriver,
				user_name_locator, "CERP_SearchPage_searchUser_title_locator");

		if (!user_name_get_text.equals(user_name) || exist == false)
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - search user name failed ");
			throw new Exception();
		}
		exist = WebElementExtender.implicitlyWait(webdriver,
				box_user_name_locator,
				"CERP_SearchPage_searchUser_box_user_name_locator");
		Thread.sleep(3000);
		box_user_name_get_text = WebElementExtender.elementGetText(webdriver,
				box_user_name_locator,
				"CERP_SearchPage_searchUser_box_user_name_locator");

		if (!box_user_name_get_text.equals(user_name) || exist == false)
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - search user name box -  failed ");
			throw new Exception();
		}

	}

	public void searchDeleteQuestion(String title_text)
	{
		WebElementExtender.elementClick(webdriver, search_locator,
				"CERP_QuestionPage_searchDeleteQuestion_search_locator");
		WebElementExtender.elementClearSendKeys(webdriver,
				search_imput_locator, title_text + random_string,
				"CERP_SearchPage_searchTitle_search_imput_locator");
		WebElementExtender.elementExistance(webdriver, no_results_locator,
				"CERP_SearchPage_searchDeleteQuestion_no_results_locator");
	}

	public void searchDeleteAnswer(String answer_contents_text)
	{
		WebElementExtender.elementClick(webdriver, search_locator,
				"CERP_QuestionPage_searchDeleteAnswer_search_locator");
		WebElementExtender.elementSendKeys(webdriver, search_imput_locator,
				answer_contents_text + random_string1,
				"CERP_SearchPage_searchAnswerContents_search_imput_locatorr");
		WebElementExtender.elementExistance(webdriver, no_results_locator,
				"CERP_SearchPage_searchDeleteAnswer_no_results_locator");
	}

	public CERP_QuestionPage clickQuestion()
	{
		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_clickQuestion_question_locator");
		return new CERP_QuestionPage(webdriver);
	}

}
