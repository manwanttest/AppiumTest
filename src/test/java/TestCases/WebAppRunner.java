package TestCases;

import org.testng.annotations.Test;

import Helpers.LoggerHelper;
import Implementation.WebAppTest;

public class WebAppRunner {

	@Test
	public static void WebTesting() {

		LoggerHelper.log("Enter WebTesting Method");
		WebAppTest.OpenWebpage();
		LoggerHelper.log("Exit WebTesting Method");
LoggerHelper.log("Commit from 3");
	}

}
