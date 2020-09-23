package Implementation;

import java.net.MalformedURLException;
import java.util.List;

import Capabilities.Desiredcaps;
import Helpers.LoggerHelper;
import Utilities.AppiumMethods;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class BaseClick extends AppiumMethods
{
	
	//public static void main(String[] args) throws MalformedURLException, InterruptedException {
		public static void ClickAPIDemos() throws MalformedURLException, InterruptedException {
		
			// Way to use xpath only with tag name
			//driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		//Desiredcaps.Appcap("ApiDemos-debug.apk", "Test");
		click(Desiredcaps.driver.findElementByXPath("//android.widget.TextView[@text='Preference']"));
		List<AndroidElement>b=Desiredcaps.driver.findElementsById("android:id/text1");
		LoggerHelper.log("List of Options coming are: " + b.size());
		for (int i=0;i <b.size();i++) {
			
			String Text = gettext(Desiredcaps.driver.findElementsById("android:id/text1").get(i));
			if (Text.equalsIgnoreCase("8. Headers")) {
				LoggerHelper.log("Match found");
				click(Desiredcaps.driver.findElementByXPath("//android.widget.TextView[@text='8. Headers']"));
				break;
			}
			else {
				LoggerHelper.log("Match not found yet");
			}
		}
		
		Desiredcaps.driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Desiredcaps.driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		Desiredcaps.driver.findElementById("android:id/checkbox").click();
		Desiredcaps.driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		Desiredcaps.driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
		Desiredcaps.driver.findElementsByClassName("android.widget.Button").get(1).click();
		Thread.sleep(3000);
		Desiredcaps.driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Desiredcaps.driver.pressKey(new KeyEvent(AndroidKey.BACK));
		// AndroidUIAutomatorUsage
		Desiredcaps.driver.findElementByAndroidUIAutomator("text(\"Views\")").click();	     
	   //  Validate clickable feature for all options
	   //List<AndroidElement> b = Desiredcaps.driver.findElementsByAndroidUIAutomator("new UiSelector().property(value)");  
	   List<AndroidElement> prop = Desiredcaps.driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(false)");
	   LoggerHelper.log("Property value coming is: "+ prop.size());
	}
	
}
