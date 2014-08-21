package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CERP_EditProfilePage;
import pages.CERP_LoginPage;
import pages.CERP_MainPage;
import pages.CERP_QuestionPage;
import pages.CERP_UserProfilePage;
import pages.WebElementExtender;

public class CERP002_QuestionAddDeleteValidation
{
	private final static String testName = "CERP002_QuestionAddDeleteValidation";
	private final static String hubUrl = "http://localhost:4444/wd/hub";
	private final static String siteUrl = "https://spolecznosc-tst.comarch.pl/";
	private final static String siteToCompare = "https://spolecznosc-tst.comarch.pl/";

	private final static String email = "skacperski@sointeractive.pl";
	private final static String password = "szykac4060$";

	private final static String text = "abcdedgh";
	private final static String validation_title_text = "Tytuł musi posiadać przynajmniej 10 znaków.";
	private final static String validation_contents_text = "Treść musi posiadać przynajmniej 10 znaków";
	private final static String validation_category_text = "Musisz wybrać od 1 do 3 kategorii.";
	private final static String title_text = "Nadawanie uprawnie do edycji 123450 dokumentłw w innym centru";
	private final static String contents_text = "edytowanie dokumentw z innego 12345 centrum nidomylnie ustawione..Choddzi o to iytkownik pracuje na wicej jednym centrum - aby umo mu edycjdokumnetw kiku centach musi bydodany wicej ni jedno,po zadeklarowaniu centrum domylengo i dodaniu jeszcze jeddnego";

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
			questionPage.validationNoText(validation_title_text,
					validation_contents_text, validation_category_text);
			questionPage.validationLengthText(text, validation_title_text,
					validation_contents_text, validation_category_text);
			questionPage.addQuestion(title_text, contents_text);
			questionPage.checkAddQuestion(title_text, contents_text);
			questionPage.deleteQuestion();
			questionPage.checkDeleteQuestion(title_text, contents_text);

		} catch (Exception e)
		{
			WebElementExtender.logErrorMessage(webdriver,
					"CERP002_QuestionAddDeleteValidation: " + e.toString());
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