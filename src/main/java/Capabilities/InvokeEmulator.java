package Capabilities;

import java.io.IOException;
import org.testng.annotations.BeforeSuite;

import Helpers.AsyncCalls;
import Helpers.ConfigReader;
import Helpers.LoggerHelper;

public class InvokeEmulator {

	@BeforeSuite
	public static void StartEmulator() throws IOException, InterruptedException {
		LoggerHelper.log("Enter StartEmulator Method");
		LoggerHelper.log("User directory Path: "+ System.getProperty("user.dir"));
		String path =System.getProperty("user.dir")+ConfigReader.getValue("StartEmulatorPath");
		LoggerHelper.log("Path of .bat file: "+ path);
	    Runtime.getRuntime().exec(path);
		LoggerHelper.log("Sleeping....");
		Thread.sleep(5000);
		//AsyncCalls.PollingEmulatorStatus();
		AsyncCalls.WaitingforHomeScreen();
		LoggerHelper.log("Exit StartEmulator Method");

	}

}
