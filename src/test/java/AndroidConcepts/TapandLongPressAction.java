package AndroidConcepts;

import Capabilities.Desiredcaps;
import Helpers.LoggerHelper;
import Utilities.AppiumMethods;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.offset.ElementOption.element;


public class TapandLongPressAction extends AppiumMethods
{

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		Desiredcaps.Appcap("ApiDemos-debug.apk", "Test");
		TouchAction t=new TouchAction(Desiredcaps.driver);
		Desiredcaps.driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		WebElement expandList=	Desiredcaps.driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		t.tap(tapOptions().withElement(element(expandList))).perform();
		Desiredcaps.driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
	    WebElement pn=	Desiredcaps.driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		t.longPress(longPressOptions().withElement(element(pn)).withDuration(ofSeconds(2))).release().perform();
		Thread.sleep(2000);
		boolean b = Desiredcaps.driver.findElementById("android:id/title").isDisplayed();
		LoggerHelper.log("Status of Title: "+ b);
		String title= gettext(Desiredcaps.driver.findElementById("android:id/title"));
		LoggerHelper.log("Text of Title: "+ title);
		Desiredcaps.driver.closeApp();

	}

}
