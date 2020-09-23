package AndroidConcepts;

import org.openqa.selenium.WebElement;

import Capabilities.Desiredcaps;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;

public class DragDropAction {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws MalformedURLException {

		Desiredcaps.Appcap("ApiDemos-debug.apk", "Test");
		TouchAction t = new TouchAction(Desiredcaps.driver);
		Desiredcaps.driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		Desiredcaps.driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
		WebElement source = Desiredcaps.driver.findElementsByClassName("android.view.View").get(0);
		WebElement destination = Desiredcaps.driver.findElementsByClassName("android.view.View").get(1);
		// longpress(source)/move(destination)//release
		// t.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();
		t.longPress(element(source)).moveTo(element(destination)).release().perform();

	}

}
