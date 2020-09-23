package AndroidConcepts;

import java.net.MalformedURLException;

import Capabilities.Desiredcaps;

public class InvokeAppwithPackagectivityName {

	public static void main(String[] args) throws MalformedURLException {


		Desiredcaps.Appcapwithpackagename("io.appium.android.apis","io.appium.android.apis.app.LoaderCursor","Test");
		Desiredcaps.driver.closeApp();
		Desiredcaps.Appcapwithpackagename("io.appium.android.apis","io.appium.android.apis.app.HelloWorld","Test");
		Desiredcaps.driver.closeApp();
		Desiredcaps.Appcapwithpackagename("io.appium.android.apis","io.appium.android.apis.app.FinishAffinity","Test");
		Desiredcaps.driver.closeApp();
		Desiredcaps.Appcapwithpackagename("io.appium.android.apis","io.appium.android.apis.app.ActionBarTabs","Test");
		Desiredcaps.driver.closeApp();
		Desiredcaps.Appcapwithpackagename("io.appium.android.apis","io.appium.android.apis.accessibility.CustomViewAccessibilityActivity","Test");

	}

}
