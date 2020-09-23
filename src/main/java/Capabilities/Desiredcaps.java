package Capabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;

import Helpers.LoggerHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Desiredcaps {

	public static AndroidDriver<AndroidElement> driver;

	public static void Appcap(String appname, String devicename) {

		File appDir = new File("src");
		File app = new File(appDir, appname);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10);
		capabilities.setCapability("autoGrantPermissions", true); // Have Appium automatically determine which
																	// permissions your app requires and grant them to
																	// the app on install. Defaults to false. If noReset
																	// is true, this capability doesn't work.
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true); // noReset just clears the app data, such as
																			// its cache.Do not stop app, do not clear
																			// app data, and do not uninstall apk
		capabilities.setCapability("skipDeviceInitialization", true);
		capabilities.setCapability("dontStopAppOnReset", true);// dont close the App after executing test
		capabilities.setCapability("android.permission.WRITE_SECURE_SETTINGS", true);// dont close the App after
																						// executing test
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability("chromedriverExecutable",
				"C:\\Users\\manwantjot.singh\\Phone\\src\\chromedriver.exe");
		try {
			LoggerHelper.log("Creating driver Object");
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			LoggerHelper.log("Created driver Object");
		} catch (MalformedURLException e) {
			LoggerHelper.log("Landed in driver object creation catch block: " + e.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void Appcapwithpackagename(String packagename, String activityname, String devicename) {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10);
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability("skipDeviceInitialization", true);
		capabilities.setCapability("dontStopAppOnReset", true);// dont close the App after executing test
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, packagename);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, activityname);
		try {
			LoggerHelper.log("Creating driver Object");
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			LoggerHelper.log("Created driver Object");
		} catch (MalformedURLException e) {
			LoggerHelper.log("Landed in driver object creation catch block: " + e.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void AppcapforWebApp(String Browsername, String devicename) {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10);
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, Browsername);
		capabilities.setCapability("chromedriverExecutable",
				"C:\\Users\\manwantjot.singh\\Phone\\src\\chromedriver.exe");
		try {
			LoggerHelper.log("Creating driver Object");
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			LoggerHelper.log("Created driver Object");
		} catch (MalformedURLException e) {
			LoggerHelper.log("Landed in driver object creation catch block: " + e.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void AppcapforRealDevice(String appname) {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10);

		capabilities.setCapability("chromedriverExecutable",
				"C:\\Users\\manwantjot.singh\\Phone\\src\\chromedriver.exe");
		try {
			LoggerHelper.log("Creating driver Object");
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			LoggerHelper.log("Created driver Object");
		} catch (MalformedURLException e) {
			LoggerHelper.log("Landed in driver object creation catch block: " + e.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
