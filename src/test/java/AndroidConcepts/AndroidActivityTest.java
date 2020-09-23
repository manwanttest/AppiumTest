package AndroidConcepts;

import java.net.MalformedURLException;
import java.time.Duration;

import Capabilities.Desiredcaps;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AndroidActivityTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		Desiredcaps.Appcap("ApiDemos-debug.apk", "Test");
		//Desiredcaps.Appcap("General-Store.apk", "Test");
		//setup();
		//startActivityInThisAppTestCase();
		//startActivityWithWaitingAppTestCase();
		//startActivityInNewAppTestCase();
		startActivityInNewAppTestCaseWithoutClosingApp();

	}
	
	public static void setup() {
		Activity activity = new Activity("io.appium.android.apis", ".ApiDemos");
        Desiredcaps.driver.startActivity(activity);
    }
	
	
	public static void startActivityInThisAppTestCase() {
        Activity activity = new Activity("io.appium.android.apis",".accessibility.AccessibilityNodeProviderActivity");
        Desiredcaps.driver.startActivity(activity);
        String currentactivity= Desiredcaps.driver.currentActivity();
        System.out.println("Current Activity coming is: "+ currentactivity);
    }
	
	public static void startActivityWithWaitingAppTestCase() {
		Activity activity = new Activity("io.appium.android.apis", ".accessibility.AccessibilityNodeProviderActivity").setAppWaitPackage("io.appium.android.apis").setAppWaitActivity(".accessibility.AccessibilityNodeProviderActivity");
		Desiredcaps.driver.startActivity(activity);
		String currentactivity= Desiredcaps.driver.currentActivity();
        System.out.println("Current Activity coming is: "+ currentactivity);
    }
	
	public static void startActivityInNewAppTestCase() {
        Activity activity = new Activity("com.android.settings", ".Settings");
        Desiredcaps.driver.startActivity(activity);
        String currentactivity= Desiredcaps.driver.currentActivity();
        System.out.println("Current Activity coming is: "+ currentactivity);
        Desiredcaps.driver.pressKey(new KeyEvent(AndroidKey.BACK));
        String currentactivityafterkeyback= Desiredcaps.driver.currentActivity();
        System.out.println("Current Activity after Key back coming is: "+ currentactivityafterkeyback);
    }
	
	public static void startActivityInNewAppTestCaseWithoutClosingApp() throws InterruptedException {
		
		Activity newActivity = new Activity("com.android.settings", ".Settings").setAppWaitPackage("com.android.settings").setAppWaitActivity(".Settings").setStopApp(false);
        Desiredcaps.driver.startActivity(newActivity);
        String newcurrentactivity= Desiredcaps.driver.currentActivity();
        System.out.println("New Current Activity coming is: "+ newcurrentactivity);
        Desiredcaps.driver.runAppInBackground(Duration.ofSeconds(5));
		Activity revertactivity = new Activity("io.appium.android.apis", ".ApiDemos").setAppWaitPackage("io.appium.android.apis").setAppWaitActivity(".ApiDemos");
        Desiredcaps.driver.startActivity(revertactivity);
        String revertactivity1= Desiredcaps.driver.currentActivity();
        System.out.println("Revert Current Activity coming is: "+ revertactivity1);
        boolean b =revertactivity.isStopApp();
        System.out.println("isStopApp: "+ b);
        
        
		Activity activity = new Activity("com.androidsample.generalstore", ".SplashActivity");
				//.setAppWaitPackage("com.androidsample.generalstore").setAppWaitActivity(".SplashActivity").setStopApp(true);
        Desiredcaps.driver.startActivity(activity);
        String currentactivity= Desiredcaps.driver.currentActivity();
        System.out.println("Current Activity coming is: "+ currentactivity);
        
//        Activity revertactivity = new Activity("io.appium.android.apis", ".ApiDemos").setAppWaitPackage("io.appium.android.apis").setAppWaitActivity(".ApiDemos").setStopApp(false);
//        Desiredcaps.driver.startActivity(revertactivity);
//        String revertactivity1= Desiredcaps.driver.currentActivity();
//        System.out.println("Revert Current Activity coming is: "+ revertactivity1);
        
        //
        //background_app 5 where 5 is the number of seconds you want the app to be in background. This will automatically, resume the application in the same screen.
        
//        Activity activity = new Activity("com.androidsample.generalstore",".MainActivity").setAppWaitPackage("com.androidsample.generalstore").setAppWaitActivity(".MainActivity").setStopApp(false);
//        Desiredcaps.driver.startActivity(activity);
//        String currentactivity= Desiredcaps.driver.currentActivity();
//        System.out.println("Current Activity coming is: "+ currentactivity);
        //Desiredcaps.driver.pressKey(new KeyEvent(AndroidKey.BACK));
//        String newcurrentactivityafterkeyback= Desiredcaps.driver.currentActivity();
//        System.out.println("New Current Activity after key back coming is: "+ newcurrentactivityafterkeyback);
    }

}
