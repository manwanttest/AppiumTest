package Helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Capabilities.InvokeAppiumServer;

public class AsyncCalls {

	public static void PollingAppiumServerStatus(String waittext) {

		LoggerHelper.log("Waiting for : " + waittext);
		boolean alert = false;
		int counter = 0;
		while (!alert && counter != 5000) {
			LoggerHelper.log("Checking for the Output after starting Appium Server");
			String text = InvokeAppiumServer.service.getStdOut();
			LoggerHelper.log("Output after starting Appium Server: " + text);
			if (text.contains(text) == true) {
				LoggerHelper.log("Appium Server Started");
				alert = true;
				LoggerHelper.log("Alert flag set to :" + alert);
			} else {
				LoggerHelper.log("Appium Server not Started Yet");
				counter++;
				LoggerHelper.log("Value of counter set to: " + counter);

			}
		}
		if (counter == 5000) {
			Assert.assertEquals("Appium Server not Started", "Appium Server should be Started");

		} else {
			LoggerHelper.log("Appium Server got Started at counter: " + counter);
		}

	}

	public static void PollingEmulatorStatus() throws IOException, InterruptedException {
		int counter = 0;
		boolean onlinealert = false;
		boolean offlinealert = false;
		while (!onlinealert && counter != 5000) {
			String s = null;
			Process p = Runtime.getRuntime().exec(System.getProperty("user.dir") + ConfigReader.getValue("PollEmulatorStatusPath"));
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			Thread.sleep(3000);
			while ((s = stdInput.readLine()) != null) {
				LoggerHelper.log("Command output is: " + s);
				if (s.contains("emulator") && s.contains("device")) {
					onlinealert = true;
					LoggerHelper.log("Emulator is Online Now and onlinealert set to: " + onlinealert);
					break;
				} else {
					offlinealert = true;
					LoggerHelper.log("Emulator not came online yet and offlinealert set to: " + offlinealert);
				}
			}

			if (onlinealert == true) {
				LoggerHelper.log("onlinealert coming is: " + onlinealert + " at counter: " + counter);
			} else {
				LoggerHelper.log("offlinealert coming is: " + offlinealert);
				counter++;
				LoggerHelper.log("Keep Waiting for Emulator to come Online at counter: " + counter);
				if (counter == 5000) {
					LoggerHelper.log("Assert here");
				}
			}
		}
	}
	
	
	public static void WaitingforHomeScreen() throws IOException, InterruptedException {
		int counter = 0;
		boolean onlinealert = false;
		boolean offlinealert = false;
		while (!onlinealert && counter != 5000) {
			String s = null;
			String path =System.getProperty("user.dir")+ConfigReader.getValue("PollHomeScreen");
			LoggerHelper.log("Path of .bat file: "+ path);
			//Process p = Runtime.getRuntime().exec("adb shell cmd shortcut get-default-launcher"); // returns emulator launcher package when phone starts after Google loading
			//Process p = Runtime.getRuntime().exec("adb shell input keyevent 82"); // long press the home screen to display the menu
			Process p = Runtime.getRuntime().exec(path); //Returns the height when home screen isfully ready to use.
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			Thread.sleep(3000);
			while ((s = stdInput.readLine()) != null) {
				LoggerHelper.log("Command output is: " + s);
				if (s.contains("412")) {
					onlinealert = true;
					LoggerHelper.log("Emulator is Online Now and onlinealert set to: " + onlinealert);
					Thread.sleep(4000);
					break;
				} else {
					offlinealert = true;
					LoggerHelper.log("Emulator not came online yet and offlinealert set to: " + offlinealert);
				}
			}

			if (onlinealert == true) {
				LoggerHelper.log("onlinealert coming is: " + onlinealert + " at counter: " + counter);
			} else {
				LoggerHelper.log("offlinealert coming is: " + offlinealert);
				counter++;
				LoggerHelper.log("Keep Waiting for Emulator to come Online at counter: " + counter);
				if (counter == 5000) {
					LoggerHelper.log("Assert here");
				}
			}
		}
	}
	
	
	public static void CheckMessage(WebElement e) {
		int counter = 0;
		boolean onlinealert = false;
		while (!onlinealert && counter != 5000) {
			try {
				LoggerHelper.log("Checking for Error Message");
				String s = e.getText();
				LoggerHelper.log("Error Message coming is: "+ s);
				onlinealert = true;
			} catch (Exception e1) {
				LoggerHelper.log("Landed in Catch block of Checking for Error Message");
				counter++;
				LoggerHelper.log("Keep Waiting for Error Message at counter: " + counter);
			}
		}
	}
}
