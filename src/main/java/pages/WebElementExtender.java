package pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class WebElementExtender {

	private final static Logger LOGGER = Logger
			.getLogger(WebElementExtender.class.getName());

	public static void highlightElement(WebElement element) {

		for (int i = 0; i < 5; i++) {
			WrapsDriver wrappedElement = (WrapsDriver) element;
			JavascriptExecutor driver = (JavascriptExecutor) wrappedElement
					.getWrappedDriver();
			driver.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "color: yellow; border: 5px solid red");
			driver.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "");

		}
	}

	public static void elementExistance(RemoteWebDriver webdriver,
			org.openqa.selenium.By elementLocator, String messageLocator) {

		WebElement element;

		try {
			TestsLogger.setup();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Problems with creating log files");
		}

		LOGGER.setLevel(Level.INFO);
		LOGGER.info(getBrowserType(webdriver) + " "
				+ getBrowserVersion(webdriver) + " " + messageLocator);

		(new WebDriverWait(webdriver, 30)).until(ExpectedConditions
				.visibilityOfElementLocated(elementLocator));
		element = webdriver.findElement(elementLocator);
		//WebElementExtender.highlightElement(element);
	}

	public static void elementClick(RemoteWebDriver webdriver,
			org.openqa.selenium.By elementLocator, String messageLocator) {

		WebElement element;

		try {
			TestsLogger.setup();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Problems with creating log files");
		}

		LOGGER.setLevel(Level.INFO);
		LOGGER.info(getBrowserType(webdriver) + " "
				+ getBrowserVersion(webdriver) + " " + messageLocator);

		(new WebDriverWait(webdriver, 30)).until(ExpectedConditions
				.visibilityOfElementLocated(elementLocator));
		element = webdriver.findElement(elementLocator);
		//WebElementExtender.highlightElement(element);
		element.click();
	}

	public static void elementSendKeys(RemoteWebDriver webdriver,
			org.openqa.selenium.By elementLocator, String keysText,
			String messageLocator) {
		WebElement element;

		try {
			TestsLogger.setup();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Problems with creating log files");
		}

		LOGGER.setLevel(Level.INFO);
		LOGGER.info(getBrowserType(webdriver) + " "
				+ getBrowserVersion(webdriver) + " " + messageLocator);

		(new WebDriverWait(webdriver, 30)).until(ExpectedConditions
				.visibilityOfElementLocated(elementLocator));
		element = webdriver.findElement(elementLocator);
	//	WebElementExtender.highlightElement(element);
		element.sendKeys(keysText);
	}
	public static void elementClearSendKeys(RemoteWebDriver webdriver,
			org.openqa.selenium.By elementLocator, String keysText,
			String messageLocator) {
		WebElement element;

		try {
			TestsLogger.setup();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Problems with creating log files");
		}

		LOGGER.setLevel(Level.INFO);
		LOGGER.info(getBrowserType(webdriver) + " "
				+ getBrowserVersion(webdriver) + " " + messageLocator);

		(new WebDriverWait(webdriver, 30)).until(ExpectedConditions
				.visibilityOfElementLocated(elementLocator));
		element = webdriver.findElement(elementLocator);
		//WebElementExtender.highlightElement(element);
		element.clear();
		element.sendKeys(keysText);
		
	}
	public static void elementSendKeysTinymce(RemoteWebDriver webdriver, String keysText,
			String messageLocator) {
		WebElement element;
		

		try {
			TestsLogger.setup();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Problems with creating log files");
		}

		LOGGER.setLevel(Level.INFO);
		LOGGER.info(getBrowserType(webdriver) + " "
				+ getBrowserVersion(webdriver) + " " + messageLocator);
		(new WebDriverWait(webdriver, 30)).until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("#tinymce-small_ifr")));
		webdriver.switchTo().frame(webdriver.findElement(By.id("tinymce-small_ifr")));
		element = webdriver.findElement(By.cssSelector("#tinymce"));
		element.click();
		element.sendKeys(keysText);
		webdriver.switchTo().defaultContent();
	}

	public static void elementSendKeysAndSubmit(RemoteWebDriver webdriver,
			org.openqa.selenium.By elementLocator, String keysText,
			String messageLocator) {
		WebElement element;

		try {
			TestsLogger.setup();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Problems with creating log files");
		}

		LOGGER.setLevel(Level.INFO);
		LOGGER.info(getBrowserType(webdriver) + " "
				+ getBrowserVersion(webdriver) + " " + messageLocator);

		(new WebDriverWait(webdriver, 30)).until(ExpectedConditions
				.visibilityOfElementLocated(elementLocator));
		element = webdriver.findElement(elementLocator);
		WebElementExtender.highlightElement(element);
		element.sendKeys(keysText);
		element.submit();
	}

	public static String elementGetText(RemoteWebDriver webdriver,
			org.openqa.selenium.By elementLocator, String messageLocator) {
		WebElement element;
		String text;

		try {
			TestsLogger.setup();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Problems with creating log files");
		}

		LOGGER.setLevel(Level.INFO);
		LOGGER.info(getBrowserType(webdriver) + " "
				+ getBrowserVersion(webdriver) + " " + messageLocator);

		(new WebDriverWait(webdriver, 30)).until(ExpectedConditions
				.visibilityOfElementLocated(elementLocator));
		element = webdriver.findElement(elementLocator);
	//	WebElementExtender.highlightElement(element);
		text = element.getText().trim();

		return text;
	}

	public static List<WebElement> elementGetList(RemoteWebDriver webdriver,
			org.openqa.selenium.By elementLocator, String messageLocator) {
		List<WebElement> element;

		try {
			TestsLogger.setup();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Problems with creating log files");
		}

		LOGGER.setLevel(Level.INFO);
		LOGGER.info(getBrowserType(webdriver) + " "
				+ getBrowserVersion(webdriver) + " " + messageLocator);

		(new WebDriverWait(webdriver, 30)).until(ExpectedConditions
				.visibilityOfElementLocated(elementLocator));
		element = webdriver.findElements(elementLocator);
		// WebElementExtender.highlightElement(element);
		return element;
	}

	public static double elementGetPrice(RemoteWebDriver webdriver,
			org.openqa.selenium.By elementLocator, String perProduct,
			String messageLocator) {
		WebElement element;
		String priceText;

		try {
			TestsLogger.setup();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Problems with creating log files");
		}

		LOGGER.setLevel(Level.INFO);
		LOGGER.info(getBrowserType(webdriver) + " "
				+ getBrowserVersion(webdriver) + " " + messageLocator);

		(new WebDriverWait(webdriver, 30)).until(ExpectedConditions
				.visibilityOfElementLocated(elementLocator));
		element = webdriver.findElement(elementLocator);
		WebElementExtender.highlightElement(element);

		priceText = webdriver
				.findElement(elementLocator)
				.getText()
				.substring(
						0,
						webdriver.findElement(elementLocator).getText()
								.length() - 2);

		if (perProduct.equals("perProduct")) {
			return Double.parseDouble(priceText);
		} else {
			return Double.parseDouble(priceText) / 100;
		}
	}

	public static void logErrorMessage(RemoteWebDriver webdriver, String message) {
		try {
			TestsLogger.setup();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Problems with creating log files");
		}

		//LOGGER.setLevel(Level.SEVERE);
		LOGGER.info(getBrowserType(webdriver) + " "
				+ getBrowserVersion(webdriver) + " " + message);
	
	}

	public static void takeScreenShot(RemoteWebDriver webdriver,
			String pathToFile, String message) {
		File screenshot;
		try {
			WebDriver augmentedDriver = new Augmenter().augment(webdriver);
			screenshot = ((TakesScreenshot) augmentedDriver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(pathToFile));

			LOGGER.setLevel(Level.INFO);
			LOGGER.info(getBrowserType(webdriver) + " "
					+ getBrowserVersion(webdriver) + " " + message);

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Problems with taking a screenshot");
		}
	}

	public static boolean checkANumber(RemoteWebDriver webdriver, String text,
			String message) {
		String stringNumber = "";
		int integerNumber = 0;

		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(text);

		while (m.find()) {
			stringNumber = m.group();
		}

		try {
			integerNumber = Integer.parseInt(stringNumber);

			LOGGER.setLevel(Level.INFO);
			LOGGER.info(getBrowserType(webdriver) + " "
					+ getBrowserVersion(webdriver) + " " + message);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static int getANumber(RemoteWebDriver webdriver, String text,
			String message) {
		String stringNumber = "";
		int integerNumber = 0;

		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(text);

		while (m.find()) {
			stringNumber = m.group();
		}

		try {
			integerNumber = Integer.parseInt(stringNumber);

			LOGGER.setLevel(Level.INFO);
			LOGGER.info(getBrowserType(webdriver) + " "
					+ getBrowserVersion(webdriver) + " " + message);
		} catch (NumberFormatException e) {
			throw new RuntimeException("Invalid number format");
		}

		return integerNumber;
	}

	public static boolean compareCountersInteger(RemoteWebDriver webdriver,
			int counterFirst, int counterSecond, String message) {
		int value = 0;

		value = Integer.compare(counterFirst, counterSecond);

		LOGGER.setLevel(Level.INFO);
		LOGGER.info(getBrowserType(webdriver) + " "
				+ getBrowserVersion(webdriver) + " " + message);

		if (value == 0) {
			return true;
		}
		return false;
	}

	public static boolean compareCountersDouble(RemoteWebDriver webdriver,
			double counterFirst, double counterSecond, String message) {
		int value = 0;

		value = Double.compare(counterFirst, counterSecond);

		LOGGER.setLevel(Level.INFO);
		LOGGER.info(getBrowserType(webdriver) + " "
				+ getBrowserVersion(webdriver) + " " + message);

		if (value == 0) {
			return true;
		}
		return false;
	}

	public static double checkAmounts(RemoteWebDriver webdriver,
			double priceOfProduct, int quantityOfProduct,
			double totalOfProduct, String message) {

		LOGGER.setLevel(Level.INFO);
		LOGGER.info(getBrowserType(webdriver) + " "
				+ getBrowserVersion(webdriver) + " " + message);

		if (WebElementExtender.compareAmounts(webdriver, priceOfProduct,
				quantityOfProduct, totalOfProduct, message + "_compareAmounts")) {
			return totalOfProduct;
		} else {
			return 0.0;
		}
	}

	public static boolean compareAmounts(RemoteWebDriver webdriver,
			double price, int quantity, double total, String message) {

		int returnValue = Double.compare(
				(double) Math.round(price * quantity * 100) / 100, total);

		LOGGER.setLevel(Level.INFO);
		LOGGER.info(getBrowserType(webdriver) + " "
				+ getBrowserVersion(webdriver) + " " + message);

		if (returnValue == 0) {
			return true;
		} else {
			return false;
		}
	}

	private static String getBrowserType(RemoteWebDriver webdriver) {
		String browserName;
		Capabilities caps = ((RemoteWebDriver) webdriver).getCapabilities();
		browserName = caps.getBrowserName();
		return browserName;
	}

	private static String getBrowserVersion(RemoteWebDriver webdriver) {
		String browserVersion;
		Capabilities caps = ((RemoteWebDriver) webdriver).getCapabilities();
		browserVersion = caps.getVersion();
		return browserVersion;
	}
	
	public static void checkCheckbox (RemoteWebDriver webdriver, org.openqa.selenium.By elementLocator, String messageLocator )
	{
		WebElement element;
		String attribute ="";
		String clas = "checked "; 

		try {
			TestsLogger.setup();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Problems with creating log files");
		}

		LOGGER.setLevel(Level.INFO);
		LOGGER.info(getBrowserType(webdriver) + " "
				+ getBrowserVersion(webdriver) + " " + messageLocator);

		(new WebDriverWait(webdriver, 30)).until(ExpectedConditions
				.visibilityOfElementLocated(elementLocator));
		element = webdriver.findElement(elementLocator);
		WebElementExtender.highlightElement(element);
		attribute = element.getAttribute("class");
		
		if (attribute.equals(clas))
		{
			element.click();
		
		}	
	}
	
	public static boolean implicitlyWait (RemoteWebDriver webdriver, org.openqa.selenium.By elementLocator, String messageLocator)

	{
		
		
		webdriver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		boolean exist = webdriver.findElements(elementLocator).size() != 0;
		webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if (exist ==true )
		{
			return true;
		}
		else {
			return false;
		}
		
	}
}