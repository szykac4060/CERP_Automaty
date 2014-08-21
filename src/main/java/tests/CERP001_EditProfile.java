package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CERP_EditProfilePage;
import pages.CERP_LoginPage;
import pages.CERP_MainPage;
import pages.CERP_UserProfilePage;
import pages.WebElementExtender;

public class CERP001_EditProfile
{
	private final static String testName = "CERP001_EditProfile";
	private final static String hubUrl = "http://localhost:4444/wd/hub";
	private final static String siteUrl = "https://spolecznosc-tst.comarch.pl/";
	private final static String siteToCompare = "https://spolecznosc-tst.comarch.pl/";
	private final static String email = "skacperski@sointeractive.pl";
	private final static String password = "szykac4060$";
	private final static String image = "C:\\Users\\Szymon\\Desktop\\avatar.jpg";
	private final static String add_avatar_text = "Możesz wgrać zdjęcie profilowe";
	private final static String delete_avatar_text = "Usuń to zdjęcie";
	private final static String date_born_incorrect = "0000/00/00";
	private final static String message_validation_text = "Nieprawidłowy format lub wartość";
	private final static String date_born = "1999/07/07";
	private final static String zip_code = "97425";
	private final static String web_page = "http://www.sointeractive.pl";
	private final static String about_me = "test wyświetlania informacji o mnie test wyświetlania informacji o mnie 123";

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
		{   // verification url
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
			CERP_UserProfilePage userProfile = mainPage1.clickViewProfile();
			CERP_EditProfilePage editProfile = userProfile.clickEditProfile();
			editProfile.addAvatar(image, delete_avatar_text);
			editProfile.deleteAvatar(add_avatar_text);
			editProfile.validationDate(date_born_incorrect,
					message_validation_text);
			editProfile.sendContent(date_born, zip_code, web_page, about_me);
			CERP_UserProfilePage userProfile1 = editProfile
					.clickViewNewUserProfile();
			userProfile1.checkContent(web_page, about_me);

		} catch (Exception e)
		{
			WebElementExtender.logErrorMessage(webdriver,
					"CERP001_EditProfile: " + e.toString());
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
