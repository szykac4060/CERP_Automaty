package pages;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CERP_QuestionPage
{
	private final RemoteWebDriver webdriver;

	private By big_input_locatro;
	private By create_question_locator;
	private By contents_input_locator;
	private By select_category_locator;
	private By category_locator;
	private By close_category_locatro;
	private By button_send_locator;
	private By validation_title_locator;
	private By validation_contents_locator;
	private By validation_category_locator;
	private By title_input_locator;
	private By question_locator;
	private By added_question_locator;
	private By added_title_locator;
	private By added_contents_locator;
	private By menu_dropdown_locator;
	private By delete_question_locator;
	private By confirm_delete_locator;
	private By uploaded_file_locator;
	private By attachment_question_locator;
	private By add_answer_locator;
	private By added_contents_answer_locator;
	private By attachment_answer_locator;
	private By no_result_search_locatro;
	private By profile_locatro;
	private By log_out_locator;
	private By rating_plus_question_locator;
	private By rating_minus_question_locator;
	private By score_question_locator;
	private By rating_plus_answer_locator;
	private By rating_minus_answer_locator;
	private By score_answer_locator;
	private By cup_locator;
	private By accept_cup_locator;
	private By message_cup_locator;
	public static String random_string = "";
	public static String random_string1 = "";
	private By search_locator;
	private By add_comment_locator;
	private By send_locator;
	private By add_comment_locator2;
	private By send_locator2;
	private By aswer_size;
	private By comment_size;

	
	// ///user1//////////
	private String random_string2 = "";
	private String random_string3 = "";

	private String search1 = random_string2;
	private String search2 = random_string3;
	private By comment_locator;
	;

	public CERP_QuestionPage(RemoteWebDriver driver)
	{
		webdriver = driver;
		big_input_locatro = By.cssSelector("#great-filter input.big");
		create_question_locator = By.cssSelector("#create-new-entry");
		select_category_locator = By.cssSelector(".new-entry.box .ico");
		category_locator = By
				.cssSelector(".new-entry.box .menuDropdown ul>:nth-child(8) a");
		close_category_locatro = By.cssSelector(".new-entry.box  a.save");
		validation_title_locator = By.cssSelector("#title_e_ajax");
		validation_contents_locator = By.cssSelector("#qbody_e_ajax");
		validation_category_locator = By.cssSelector("#category_e_ajax");
		title_input_locator = By.cssSelector(".qa_form :nth-child(5)");
		button_send_locator = By.cssSelector(".qa_form .right button");
		question_locator = By
				.cssSelector(".pageHeader .menuMain :nth-child(1)>a");
		added_question_locator = By
				.cssSelector(".sortable :nth-child(1) .content>a");
		added_title_locator = By.cssSelector(".content>p");
		added_contents_locator = By.cssSelector(".wysiwyg>p");
		menu_dropdown_locator = By
				.cssSelector("#entry .downSection .linkDropdown .ico ");
		delete_question_locator = By.cssSelector("#entry .menuDropdown .del");
		confirm_delete_locator = By.cssSelector("#fbOverlay .btn");
		uploaded_file_locator = By.cssSelector("#uploadedfile_1");
		attachment_question_locator = By.cssSelector(".thumb");
		add_answer_locator = By.cssSelector(".loadContent");
		added_contents_answer_locator = By
				.cssSelector(".leftCol :nth-child(2) .fullText>p");
		attachment_answer_locator = By.cssSelector(".sortable .thumb");
		no_result_search_locatro = By.cssSelector(".no-results");
		profile_locatro = By
				.cssSelector(".pageHeader .menuUser .menu>:nth-child(6) a");
		log_out_locator = By
				.cssSelector(".pageHeader .menuUser li ul.list.profile .more .button");
		rating_plus_question_locator = By
				.cssSelector(".sortable>:nth-child(1) .plus");
		rating_minus_question_locator = By
				.cssSelector(".sortable>:nth-child(1) .minus");
		score_question_locator = By
				.cssSelector(".sortable :nth-child(1) .footer .rate");
		rating_plus_answer_locator = By
				.cssSelector(".leftCol>:nth-child(2) .plus");
		rating_minus_answer_locator = By
				.cssSelector(".leftCol>:nth-child(2) .minus");
		score_answer_locator = By.cssSelector(".leftCol>:nth-child(2) .rate");
		cup_locator = By
				.cssSelector(".pageContainer .blogContainer .listEntry.comments.for-author .entry .footer .cup");
		accept_cup_locator = By
				.cssSelector(".pageContainer .blogContainer .listEntry.comments.for-author .entry .footer .cup-confirm .cup-content .button");
		message_cup_locator = By
				.cssSelector(".pageContainer .blogContainer .listEntry.comments .entry .entryCloud .status");
		search_locator = By
				.cssSelector(".pageHeader .menuUser li a .icoSearch");
		add_comment_locator = By
				.cssSelector(".pageContainer .blogContainer .leftCol :nth-child(4) .loadContent");

		add_comment_locator2 = By
				.cssSelector(".moreComments>:nth-child(2) .loadContent");
		send_locator2 = By
				.cssSelector(".moreComments>:nth-child(2)  .right > button");
		send_locator = By.cssSelector(".right > button");
		aswer_size = By.cssSelector(".sortable.anslist.paginated>article");
		comment_size = By.cssSelector(".entryCloud .header>a[href$='/index.php/profil/77/Szymon-Kacperski']");


	}

	public void validationNoText(String validation_title_text,
			String validation_contents_text, String validation_category_text)
			throws Exception
	{
		String validation_title_get_text = "";
		String validation_contents_get_text = "";
		String validation_category_get_text = "";

		WebElementExtender.elementClick(webdriver, big_input_locatro,
				"CERP_QustrionPage_title_input_locatro");
		WebElementExtender.elementClick(webdriver, create_question_locator,
				"CERP_QustrionPage_create_question_locator");
		WebElementExtender.elementClick(webdriver, button_send_locator,
				"CERP_QuestionPage_send_locator");

		validation_title_get_text = WebElementExtender.elementGetText(
				webdriver, validation_title_locator,
				"CERP_QuestionPage_validation_title_locator");
		validation_contents_get_text = WebElementExtender.elementGetText(
				webdriver, validation_contents_locator,
				"CERP_QuestionPage_validation_contents_locator");
		validation_category_get_text = WebElementExtender.elementGetText(
				webdriver, validation_category_locator,
				"CERP_QuestionPage_validation_category_locator");

		if (!validation_title_get_text.equals(validation_title_text))
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - validation title");
			throw new Exception();
		}

		if (!validation_contents_get_text.equals(validation_contents_text))
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - validation contents");
			throw new Exception();
		}

		if (!validation_category_get_text.equals(validation_category_text))
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - validation category");
			throw new Exception();
		}

	}

	public void validationLengthText(String text, String validation_title_text,
			String validation_contents_text, String validation_category_text)
			throws Exception
	{
		String validation_title_get_text = "";
		String validation_contents_get_text = "";
		String validation_category_get_text = "";

		WebElementExtender.elementSendKeys(webdriver, title_input_locator,
				text, "title_imput_locator");
		WebElementExtender.elementSendKeysTinymce(webdriver, text,
				"CERP_QuestionPage_tinymce");
		WebElementExtender.elementClick(webdriver, button_send_locator,
				"CERP_QuestionPage_button_send_locator");

		validation_title_get_text = WebElementExtender.elementGetText(
				webdriver, validation_title_locator,
				"CERP_QuestionPage_validation_title_locator");
		validation_contents_get_text = WebElementExtender.elementGetText(
				webdriver, validation_contents_locator,
				"CERP_QuestionPage_validation_contents_locator");
		validation_category_get_text = WebElementExtender.elementGetText(
				webdriver, validation_category_locator,
				"CERP_QuestionPage_validation_category_locator");

		if (!validation_title_get_text.equals(validation_title_text))
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - validation title");
			throw new Exception();
		}

		if (!validation_contents_get_text.equals(validation_contents_text))
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - validation contents");
			throw new Exception();
		}

		if (!validation_category_get_text.equals(validation_category_text))
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - validation category");
			throw new Exception();
		}

	}

	public void addQuestion(String title_text, String contents_text)
	{
		random_string = randomString();

		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_question_locatro");
		WebElementExtender.elementClearSendKeys(webdriver, big_input_locatro,
				title_text + random_string,
				"CERP_QuestionPage_big_input_locatro");
		WebElementExtender.elementClick(webdriver, create_question_locator,
				"CERP_QuestionPage_create_question_locator");
		WebElementExtender.elementSendKeysTinymce(webdriver, contents_text
				+ random_string, "CERP_QuestionPage_Send_tinymce");

		WebElementExtender.elementClick(webdriver, select_category_locator,
				"CERP_QuestionPage_select_category_locator");
		WebElementExtender.elementClick(webdriver, category_locator,
				"CERP_QuestionPage_category_locator");
		WebElementExtender.elementClick(webdriver, close_category_locatro,
				"CERP_QuestionPage_category_locator");
		WebElementExtender.elementClick(webdriver, button_send_locator,
				"CERP_QuestionPage_button_send_locator");
	}

	public void checkAddQuestion(String title_text, String contents_text)
			throws Exception
	{
		String title_get_text = "";
		String contents_get_text = "";

		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_question_locatro");
		WebElementExtender.elementClick(webdriver, added_question_locator,
				"CERP_QuestionPage_add_question_locator");

		title_get_text = WebElementExtender.elementGetText(webdriver,
				added_title_locator, "CERP_QusesionPage_added_title_locatro");
		contents_get_text = WebElementExtender.elementGetText(webdriver,
				added_contents_locator,
				"CERP_QusetionPage_added_content_locatro");
System.out.println(contents_get_text);
		if (!title_get_text.equals(title_text + random_string)
				|| !contents_get_text.equals(contents_text + random_string))
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - add question - title");
			throw new Exception();
		}

	}

	public void deleteQuestion()
	{
		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_question_locatro");
		WebElementExtender.elementClick(webdriver, added_question_locator,
				"CERP_QuestionPage_add_question_locator");
		WebElementExtender.elementClick(webdriver, menu_dropdown_locator,
				"CERP_Question_menu_dropdown_locator");
		WebElementExtender.elementClick(webdriver, delete_question_locator,
				"CERP_Question_delete_question_locator");
		WebElementExtender.elementClick(webdriver, confirm_delete_locator,
				"CERP_Question_confirm_delete_locator");
	}

	public void checkDeleteQuestion(String title_text, String contents_text)
			throws Exception
	{
		String title_get_text = "";
		String contents_get_text = "";
		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_question_locatro");
		WebElementExtender.elementClick(webdriver, added_question_locator,
				"CERP_QuestionPage_add_question_locator");

		title_get_text = WebElementExtender.elementGetText(webdriver,
				added_title_locator, "CERP_QusesionPage_added_title_locatro");
		contents_get_text = WebElementExtender.elementGetText(webdriver,
				added_contents_locator,
				"CERP_QusetionPage_added_content_locatro");

		if (title_get_text.equals(title_text + random_string)
				|| contents_get_text.equals(contents_text + random_string))
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - delete question");
			throw new Exception();
		}

	}

	public void addQuestionAttachment(String title_text, String contents_text,
			String file_name)
	{
		random_string = randomString();
		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_question_locatro");
		WebElementExtender.elementClearSendKeys(webdriver, big_input_locatro,
				title_text + random_string,
				"CERP_QuestionPage_big_input_locatro");
		WebElementExtender.elementClick(webdriver, create_question_locator,
				"CERP_QuestionPage_create_question_locator");
		WebElementExtender.elementSendKeysTinymce(webdriver, contents_text
				+ random_string, "CERP_QuestionPage_Send_tinymce");
		WebElementExtender.elementClick(webdriver, select_category_locator,
				"CERP_QuestionPage_select_category_locator");
		WebElementExtender.elementClick(webdriver, category_locator,
				"CERP_QuestionPage_category_locator");
		WebElementExtender.elementClick(webdriver, close_category_locatro,
				"CERP_QuestionPage_category_locator");

		WebElementExtender
				.elementSendKeys(webdriver, uploaded_file_locator, file_name,
						"CERP_QuestionPage_addQuestionAttachment_uploaded_file_locataor");

		WebElementExtender.elementClick(webdriver, button_send_locator,
				"CERP_QuestionPage_addQuestionAttachment_button_send_locator");

	}

	public void checkAttachmentQuestion()
	{
		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_question_locatro");
		WebElementExtender.elementClick(webdriver, added_question_locator,
				"CERP_QuestionPage_add_question_locator");
		WebElementExtender.elementExistance(webdriver,
				attachment_question_locator,
				"CERP_QuestionPage_checkAttachment_attachment_locator");
	}

	public void addAnswer(String answer_contents_text)
	{
		random_string1 = randomString();

		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_question_locatro");
		WebElementExtender.elementClick(webdriver, added_question_locator,
				"CERP_QuestionPage_add_question_locator");
		WebElementExtender.elementClick(webdriver, add_answer_locator,
				"CERP_QuestionPage_addAnswer_add_answer_locator");
		WebElementExtender.elementSendKeysTinymce(webdriver,
				answer_contents_text + random_string1,
				"CERP_QuestionPage_addAnswert_contents_text");
		WebElementExtender.elementClick(webdriver, button_send_locator,
				"CERP_QuestionPage_addAnswer_button_send_locator");
	}

	public void addAnswerAttachment(String answer_contents_text,
			String file_name)
	{
		random_string1 = randomString();

		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_question_locatro");
		WebElementExtender.elementClick(webdriver, added_question_locator,
				"CERP_QuestionPage_add_question_locator");
		WebElementExtender.elementClick(webdriver, add_answer_locator,
				"CERP_QuestionPage_addAnswerAttachment_add_answer_locator");
		WebElementExtender.elementSendKeysTinymce(webdriver,
				answer_contents_text + random_string1,
				"CERP_QuestionPage_addAnswerAttachment_contents_text");
		WebElementExtender
				.elementSendKeys(webdriver, uploaded_file_locator, file_name,
						"CERP_QuestionPage_addQuestionAttachment_uploaded_file_locataor");
		WebElementExtender.elementClick(webdriver, button_send_locator,
				"CERP_QuestionPage_addAnswerAttachment_button_send_locator");
	}

	public void checkAddAnswer(String answer_contents_text) throws Exception
	{
		String contents_get_text = "";
		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_question_locatro");
		WebElementExtender.elementClick(webdriver, added_question_locator,
				"CERP_QuestionPage_add_question_locator");
		contents_get_text = WebElementExtender.elementGetText(webdriver,
				added_contents_answer_locator,
				"CERP_QuestionPage_checkAddAnswer_add_answer_locator");

		if (!contents_get_text.equals(answer_contents_text + random_string1))
		{
			WebElementExtender.logErrorMessage(webdriver, "ERROR - add answer");
		}

	}

	public void checkAttachmentAnswer()
	{
		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_checkAttachmentAnswer_question_locatro");
		WebElementExtender.elementClick(webdriver, added_question_locator,
				"CERP_QuestionPage_checkAttachmentAnswer_add_question_locator");
		WebElementExtender
				.elementExistance(webdriver, attachment_answer_locator,
						"CERP_QuestionPage_checkAttachmentAnswer_attachment_answer_locator");

	}

	public void searchAddedQuestion(String title_text, String contents_text)
			throws Exception
	{
		String title_get_text = "";
		String contents_get_text = "";
		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_searchAddegQuestion_question_locatro");
		WebElementExtender.elementClearSendKeys(webdriver, big_input_locatro,
				title_text + random_string,
				"CERP_QuestionPage_searchAddegQuestion_big_input_locatro");
		Thread.sleep(3000);
		WebElementExtender.elementClick(webdriver, added_question_locator,
				"CERP_QuestionPage_add_question_locator");

		title_get_text = WebElementExtender.elementGetText(webdriver,
				added_title_locator,
				"CERP_QusesionPage_searchAddedQuestion_added_title_locatro");
		contents_get_text = WebElementExtender.elementGetText(webdriver,
				added_contents_locator,
				"CERP_QusetionPage_searchAddedQuestion_added_content_locatro");

		if (!title_get_text.equals(title_text + random_string))
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - search added question");
			throw new Exception();
		}

		if (!contents_get_text.equals(contents_text + random_string))
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - search added question");
			throw new Exception();
		}
	}

	public void searchDeleteQuestion(String title_text, String message_text)
			throws Exception
	{
		String message_get_text = "";

		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_searchDeleteQuestion_question_locatro");
		WebElementExtender.elementClearSendKeys(webdriver, big_input_locatro,
				title_text + random_string,
				"CERP_QuestionPage_searchDeleteQuestion_big_input_locatro");

		message_get_text = WebElementExtender
				.elementGetText(webdriver, no_result_search_locatro,
						"CERP_QusesionPage_searchDeleteQuestion_no_result_search_locatro");

		if (!message_get_text.equals(message_text))
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - search delete question");
			throw new Exception();
		}

	}

	public CERP_MainPage logOut()
	{
		WebElementExtender.elementClick(webdriver, profile_locatro,
				"CERP_QuestionPage_logOut_profile_locatro");
		WebElementExtender.elementClick(webdriver, log_out_locator,
				"CERP_QuestionPage_logOut_log_out_locator");

		return new CERP_MainPage(webdriver);
	}

	public void ratingPlusQuestion(String score_question) throws Exception

	{
		String score_question_get_text = "";
		WebElementExtender.elementClick(webdriver,
				rating_plus_question_locator,
				"CERP_QuestionPage_ratingPlusQuestion_rating_plus_locator");
		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_ratingPlusQuestion_question_locatro");
		score_question_get_text = WebElementExtender.elementGetText(webdriver,
				score_question_locator,
				"CERP_QuestionPage_votePlusQuestion_score_locator");

		if (!score_question_get_text.equals(score_question))
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - rating plus question");
			throw new Exception();
		}
	}

	public void ratingMinusQuestion(String score_question1) throws Exception
	{
		String score1_question_get_text = "";
		WebElementExtender.elementClick(webdriver,
				rating_minus_question_locator,
				"CERP_QuestionPage_ratingMinusQuestion_rating_minus_locator");
		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_ratingMinusQuestion_question_locatro");
		WebElementExtender.elementClick(webdriver,
				rating_minus_question_locator,
				"CERP_QuestionPage_ratingMinusQuestion_rating_minus_locator");
		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_ratingMinusQuestion_question_locatro");
		score1_question_get_text = WebElementExtender.elementGetText(webdriver,
				score_question_locator,
				"CERP_QuestionPage_ratingMinusQuestion_score_question_locator");

		if (!score1_question_get_text.equals(score_question1))
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - rating minus question");
			throw new Exception();
		}
	}

	public void ratingPlusAnswer(String score_answer) throws Exception

	{
		String score_answer_get_text = "";
		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_ratingPlusAnswer_question_locatro");
		WebElementExtender.elementClick(webdriver, added_question_locator,
				"CERP_QuestionPage_ratingPlusAnswer_added_question_locator");
		WebElementExtender.elementClick(webdriver, rating_plus_answer_locator,
				"CERP_QuestionPage_ratingPlusAnswer_rating_plus_locator");
		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_ratingPlusAnswer_question_locatro");
		WebElementExtender.elementClick(webdriver, added_question_locator,
				"CERP_QuestionPage_ratingPlusAnswer_added_question_locator");
		score_answer_get_text = WebElementExtender.elementGetText(webdriver,
				score_answer_locator,
				"CERP_QuestionPage_ratingPlusAnswer_score_locator");

		if (!score_answer_get_text.equals(score_answer))
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - rating plus answer");
			throw new Exception();
		}
	}

	public void ratingMinusAnswer(String score_answer1) throws Exception
	{
		String score1_answer_get_text = "";
		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_ratingMinusAnswer_question_locatro");
		WebElementExtender.elementClick(webdriver, added_question_locator,
				"CERP_QuestionPage_ratingMinusAnswer_added_question_locator");
		WebElementExtender.elementClick(webdriver, rating_minus_answer_locator,
				"CERP_QuestionPage_ratingMinusAnswer_rating_minus_locator");
		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_ratingMinusAnswer_question_locatro");
		WebElementExtender.elementClick(webdriver, added_question_locator,
				"CERP_QuestionPage_ratingMinusAnswer_added_question_locator");
		WebElementExtender.elementClick(webdriver, rating_minus_answer_locator,
				"CERP_QuestionPage_ratingMinusAnswer_rating_minus_locator");
		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_ratingMinusAnswer_question_locatro");
		WebElementExtender.elementClick(webdriver, added_question_locator,
				"CERP_QuestionPage_ratingMinusAnswer_added_question_locator");
		score1_answer_get_text = WebElementExtender.elementGetText(webdriver,
				score_answer_locator,
				"CERP_QuestionPage_ratingMinusAnswer_score_answer_locator");

		if (!score1_answer_get_text.equals(score_answer1))
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - vote minus answer");
			throw new Exception();
		}
	}

	public void sufficientAnswer()
	{

		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_sufficientAnswer_question_locatro");
		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_ratingMinusAnswer_question_locatro");
		WebElementExtender.elementClick(webdriver, added_question_locator,
				"CERP_QuestionPage_sufficientAnswer_added_question_locator");
		WebElementExtender.elementClick(webdriver, cup_locator,
				"CERP_QuestionPage_sufficientAnswer_cup_locator");
		WebElementExtender.elementClick(webdriver, accept_cup_locator,
				"CERP_QuestionPage_sufficientAnswer_cup_accept_locator");
		WebElementExtender.elementExistance(webdriver, message_cup_locator,
				"CERP_QuestionPage_sufficentAnswer_message_cup_locator");

	}

	private String randomString()
	{

		int string_L = 10;
		Random RANDOM = new SecureRandom();
		String letters = "abcdefghjkmnpqrstuvwxyz";
		String random_string = "";

		for (int i = 0; i < string_L; i++)

		{
			int index = (int) (RANDOM.nextDouble() * letters.length());
			random_string += letters.substring(index, index + 1);
		}
		return random_string;

	}

	public CERP_SearchPage clickSearch()
	{
		WebElementExtender.elementClick(webdriver, search_locator,
				"CERP_QuestionPage_clickSearch_search_locator");
		return new CERP_SearchPage(webdriver);
	}

	// /////////// tests ad-hoc/////////////////////////////////////////////////////////////////////////////////////////////////////

	public void addAnswer1(String answer_contents_text)
	{
		random_string1 = randomString();

		WebElementExtender.elementClick(webdriver, add_answer_locator,
				"CERP_QuestionPage_addAnswer_add_answer_locator");
		WebElementExtender.elementSendKeysTinymce(webdriver, random_string1,
				"CERP_QuestionPage_addAnswert_contents_text");
		WebElementExtender.elementClick(webdriver, button_send_locator,
				"CERP_QuestionPage_addAnswer_button_send_locator");

	}

	public void beforAddComment()
	{
		WebElementExtender.elementClick(webdriver, question_locator,
				"CERP_QuestionPage_ratingMinusAnswer_question_locatro");
		WebElementExtender.elementClick(webdriver, added_question_locator,
				"CERP_QuestionPage_sufficientAnswer_added_question_locator");
	}

	public void addComment(String text_comment) throws Exception
	{	
		
		WebElementExtender.elementClick(webdriver, add_comment_locator, "");
		Thread.sleep((long) (Math.random() * 2000));
		WebElementExtender.elementSendKeysTinymce(webdriver, text_comment, "");
		Thread.sleep((long) (Math.random() * 2000));
		WebElementExtender.elementClick(webdriver, send_locator,
				"CERP_QuestionPage_add_question_locator");

		int int_article = 0;
		List<WebElement> element1;
		Thread.sleep(2000);
		element1 = WebElementExtender.elementGetList(webdriver, aswer_size, "");
		int_article = element1.size();

		if (int_article > 1)
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - komentarz dodany w złym miejscu!!!!");
			throw new Exception();

		}
		for (int i=0; i<1; i++)
		{
	 List<WebElement> comment_befor;
	int int_comment_befor =0;
	
	comment_befor = WebElementExtender.elementGetList(webdriver, comment_size, "");
	int_comment_befor =comment_befor.size();

		WebElementExtender.elementClick(webdriver, add_comment_locator2, "");
		Thread.sleep((long) (Math.random() * 2000));
		WebElementExtender.elementSendKeysTinymce(webdriver, text_comment, "");
		Thread.sleep((long) (Math.random() * 2000));
		WebElementExtender.elementClick(webdriver, send_locator,
				"CERP_QuestionPage_add_question_locator");
		
		int int_article1 = 0;
		List<WebElement> element2;
		Thread.sleep(2000);
		element2= WebElementExtender.elementGetList(webdriver, aswer_size, "");
		int_article1 = element1.size();

		if (int_article1 > 1)
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - komentarz dodany w złym miejscu!!!!");
			throw new Exception();

		}
		int int_comment_after=0;
		Thread.sleep(2000);
		List<WebElement> comment_after;
		comment_after = WebElementExtender.elementGetList(webdriver, comment_size,
				"");
		int_comment_after = comment_after.size();

		if (int_comment_after != int_comment_befor + 1)
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR- pytanie nie dodało się !!!");
			throw new Exception ();
		}

		}	
		
	}

	
	public void addComment1(String text_comment) throws Exception
	{
		
		
		WebElementExtender.elementClick(webdriver, add_comment_locator, "");
		Thread.sleep((long) (Math.random() * 5000));
		WebElementExtender.elementSendKeysTinymce(webdriver, text_comment, "");
		Thread.sleep((long) (Math.random() * 5000));
		WebElementExtender.elementClick(webdriver, send_locator,
				"CERP_QuestionPage_add_question_locator");

		int int_article = 0;
		List<WebElement> element;
		Thread.sleep(2000);
		element = WebElementExtender.elementGetList(webdriver, aswer_size, "");
		int_article = element.size();

		if (int_article > 1)
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR - komentarz dodany w złym miejscu!!!!");
			throw new Exception();
		}

	
		WebElementExtender.elementClick(webdriver, add_comment_locator2, "");
		Thread.sleep((long) (Math.random() * 5000));
		WebElementExtender.elementSendKeysTinymce(webdriver, text_comment, "");
		Thread.sleep((long) (Math.random() * 5000));
		WebElementExtender.elementClick(webdriver, send_locator,
				"CERP_QuestionPage_add_question_locator");
		Thread.sleep(2000);
		int int_article1 = 0;
		List<WebElement> element1;

		element1 = WebElementExtender.elementGetList(webdriver, aswer_size, "");
		int_article1 = element.size();

		if (int_article1 > 1)
		{
			WebElementExtender.logErrorMessage(webdriver,
					"ERROR-komentarz dodany w zlym miejscu!!!!");
			throw new Exception();
		}

		
	}


}
