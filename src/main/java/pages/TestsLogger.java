package pages;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TestsLogger {

	static private SimpleFormatter formatterTxt;
	static private ConsoleHandler consoleTxt;

	static public void setup() throws IOException {

		Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

		logger.setLevel(Level.INFO);
		consoleTxt = new ConsoleHandler();

		formatterTxt = new SimpleFormatter();
		consoleTxt.setFormatter(formatterTxt);
		logger.addHandler(consoleTxt);
		
		
	}
}
