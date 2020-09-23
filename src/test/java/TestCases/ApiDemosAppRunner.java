package TestCases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.Test;

import Capabilities.InvokeEmulator;
import Helpers.LoggerHelper;
import Implementation.BaseClick;

	public class ApiDemosAppRunner{		
		
	public ApiDemosAppRunner() throws IOException, InterruptedException {
		LoggerHelper.log("Inside ApiDemosAppTestRunner");
		InvokeEmulator.StartEmulator();
	}
	
	@Test
	public static void ApiDemosBasicClick() throws MalformedURLException, InterruptedException {

		LoggerHelper.log("Enter BasicClick Method");
		BaseClick.ClickAPIDemos();
		LoggerHelper.log("Exit BasicClick Method");
	}
	@Test
	public static void ApiDemosBasicClick2() throws MalformedURLException, InterruptedException {

		LoggerHelper.log("Enter BasicClick2 Method");
		//BaseClick.ClickAPIDemos();
		LoggerHelper.log("Exit BasicClick2 Method");
	}

}
