package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Capabilities.Desiredcaps;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class APIDemosPO {
	
	public APIDemosPO() {
		System.out.println("Inside APIDemosPO b");
		PageFactory.initElements(new AppiumFieldDecorator(Desiredcaps.driver), this);
		System.out.println("Outside APIDemosPO b");
	}

	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='API Demos']")
	public WebElement APIDemosTitle;

}
