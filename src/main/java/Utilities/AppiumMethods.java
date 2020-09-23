package Utilities;

import org.openqa.selenium.WebElement;
import Capabilities.Desiredcaps;
import Helpers.LoggerHelper;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AppiumMethods {
	
	AndroidDriver<AndroidElement>  driver;

	//Other way to initialize driver, If driver is not declared as static 
//	public AppiumMethods(AndroidDriver<AndroidElement> driver)
//	{
//		this.driver=driver;
//	}
//	public void scrollToText(String text)
//	{
//	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
//	}
	
	
	// Data Provider to input data
//	@DataProvider(name="InputData")
//	public Object[][] getDataforEditField()
//	{
//		//2 sets of data, "hello" , "!@#$$"
//		Object[][] obj=new Object[][]
//				{
//			
//			{"hello"}, {"@#$%"}
//				};
//				
//				return obj;
//				
//	}

	
	public static void scrollToText(String text)
	{
		LoggerHelper.log("Text to Scroll: "+ text);
	     //Desiredcaps.driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	     Desiredcaps.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + text + "\").instance(0))"));
	}
	
	public static void click(WebElement e) {
		LoggerHelper.log("Element to click: "+ e);
LoggerHelper.log("Text to commit"+ text);
		e.click();
		LoggerHelper.log("Element Clicked: "+ e);
	}
	
	public static void sendkeys(WebElement e, String a) {
		LoggerHelper.log("Text to send: "+ a+ " for element: "+ e);
		e.sendKeys(a);
		LoggerHelper.log("SendKeys done");
	}
	
	
	public static String gettext(WebElement e) {
		LoggerHelper.log("Get text for element: "+ e);
		String s  = e.getText();
		LoggerHelper.log("Text coming is: "+ s);
		return s;

	}

}
