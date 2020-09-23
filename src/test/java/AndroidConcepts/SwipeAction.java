package AndroidConcepts;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import Capabilities.Desiredcaps;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class SwipeAction {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws MalformedURLException {
		
		Desiredcaps.Appcap("ApiDemos-debug.apk", "Test");
		TouchAction t = new TouchAction(Desiredcaps.driver);
		t.tap(tapOptions().withElement(element(Desiredcaps.driver.findElementByXPath("//android.widget.TextView[@text='Views']")))).perform();
		Desiredcaps.driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		Desiredcaps.driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		Desiredcaps.driver.findElementByXPath("//*[@content-desc='9']").click();

		// long press //on element// 2 sec// move to another element and you release
		WebElement first = Desiredcaps.driver.findElementByXPath("//*[@content-desc='15']");
		WebElement second = Desiredcaps.driver.findElementByXPath("//*[@content-desc='45']");
		t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();

	}

}
