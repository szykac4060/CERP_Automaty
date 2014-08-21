package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CERP_LoginPage;
import pages.CERP_MainPage;
import pages.CERP_QuestionPage;
import pages.WebElementExtender;

public class CERP003_QuestionAnswerAttachmentSearch
{
	private final static String testName = "CERP003_QuestionAnswerAttachmentSearch";
	private final static String hubUrl = "http://jenkins.mydomain:4444/wd/hub";
	private final static String siteUrl = "https://spolecznosc-tst.comarch.pl/";
	private final static String siteToCompare = "https://spolecznosc-tst.comarch.pl/";

	private final static String email = "skacperski@sointeractive.pl";
	private final static String password = "szykac4060$";

	private final static String file_name = "C:\\Users\\Szymon\\Desktop\\avatar.jpg";
	private final static String text = "abcdedgh";

	private final static String title_text = "Nadawanie uprawnie do edycji 123450 dokumentłw w innym ŁÓDŹ centrum!";
	private final static String contents_text = "edytowanie dokumentw zŁÓDŹ innego 12345 centrum nidomylnie ustawione..Choddzi o to iytkownik pracuje na wicej jednym centrum - aby umo mu edycjdokumnetw kiku centach musi bydodany wicej ni jedno,po zadeklarowaniu centrum domylengo i dodaniu jeszcze jeddnego";
	private final static String answer_contents_text = "qasw edytowanie dokumentw z innego 12345 centrum nidomylnie ŁÓDŹ ustawione..Choddzi o to iytkownik pracuje na wicej jednym centrum - aby umo mu edycjdokumnetw kiku centach musi bydodany wicej ni jedno,po zadeklarowaniu centrum domylengo i dodaniu jeszcze jeddnego";
	private final static String message_text = "Brak wpisów - spróbuj wybrać inną tematykę.";
	private RemoteWebDriver webdriver;

	@BeforeClass
	public void getDriver(ITestContext context)
	{
		System.out.println(testName);

		// FROM TESTNG.XML
		String platform = context.getCurrentXmlTest().getParameter("platform");
		String version = context.getCurrentXmlTest().getParameter("version");
		String browser = context.getCurrentXmlTest().getParameter("browser");
		String url = context.getCurrentXmlTest().getParameter("url");

		// WEBBROWSERS
		DesiredCapabilities capabilities = new DesiredCapabilities();

		if (platform.equalsIgnoreCase("Windows"))
			capabilities.setPlatform(org.openqa.selenium.Platform.WINDOWS);

		if (browser.equalsIgnoreCase("Internet Explorer"))
		{
			capabilities = DesiredCapabilities.internetExplorer();
		}

		if (browser.equalsIgnoreCase("FireFox"))
			capabilities = DesiredCapabilities.firefox();

		if (browser.equalsIgnoreCase("Chrome"))
			capabilities = DesiredCapabilities.chrome();

		// IE 11
		if (version.equalsIgnoreCase("11"))
			capabilities.setVersion(version);

		// IE 10
		if (version.equalsIgnoreCase("10"))
			capabilities.setVersion(version);

		// IE 9
		if (version.equalsIgnoreCase("9"))
			capabilities.setVersion(version);

		// IE 8
		if (version.equalsIgnoreCase("8"))
			capabilities.setVersion(version);

		// FF
		if (version.equalsIgnoreCase("26.0"))
			capabilities.setVersion(version);

		// Chrome
		if (version.equalsIgnoreCase("2.10"))
			capabilities.setVersion("2.10");

		try
		{
			webdriver = new RemoteWebDriver(new URL(hubUrl), capabilities);
		} catch (MalformedURLException e)
		{
			e.printStackTrace();
		}

		if (url.equalsIgnoreCase(siteToCompare))
		{

			webdriver.get(siteUrl);
			webdriver.manage().window().maximize();
		}
		
	}

	@Test
	public void TestMethod() throws Exception
	{
		try
		{
			// verification url
			String url_get = webdriver.getCurrentUrl();
			String url_incorrect = "res://ieframe.dll/invalidcert.htm?SSLError=33554432#https://spolecznosc-tst.comarch.pl/";
			System.out.println(url_get);
			if (url_get.equals(url_incorrect))
			{
				WebElementExtender.elementClick(webdriver,
						By.cssSelector("#overridelink"), "messageLocator");
			}
			CERP_MainPage mainPage = new CERP_MainPage(this.webdriver);
			CERP_LoginPage loginPage = mainPage.clickLogIn();
			CERP_MainPage mainPage1 = loginPage.login(email, password);
			CERP_QuestionPage questionPage = mainPage1.clickQuestion();
			questionPage.addQuestionAttachment(title_text, contents_text,
					file_name);
			questionPage.checkAddQuestion(title_text, contents_text);
			questionPage.checkAddQuestion(title_text, contents_text);
			questionPage.checkAttachmentQuestion();
			questionPage.addAnswerAttachment(answer_contents_text, file_name);
			questionPage.checkAddAnswer(answer_contents_text);
			questionPage.checkAttachmentAnswer();
			questionPage.searchAddedQuestion(title_text, contents_text);
			questionPage.deleteQuestion();
			questionPage.searchDeleteQuestion(title_text, message_text);

		} catch (Exception e)
		{
			WebElementExtender.logErrorMessage(webdriver,
					"CERP003_QuestionAnswerAttachmentSearch: " + e.toString());
			throw new Exception();
		}
	}

	@AfterClass
	public void tearDown()
	{
		for (String handle : webdriver.getWindowHandles())
		{
			webdriver.switchTo().window(handle).close();
		}

		webdriver.quit();
	}

}
