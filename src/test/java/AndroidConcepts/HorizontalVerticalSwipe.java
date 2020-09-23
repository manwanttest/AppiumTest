package AndroidConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import Capabilities.Desiredcaps;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.ElementOption;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class HorizontalVerticalSwipe {
	
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		//HorizontalSwipe();
		VerticalSwipe();
	}
	
	@SuppressWarnings("rawtypes")
	public static void HorizontalSwipe() throws MalformedURLException, InterruptedException {
		
		Desiredcaps.Appcap("ApiDemos-debug.apk", "Test");
		Desiredcaps.driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		Desiredcaps.driver.findElementByAndroidUIAutomator("text(\"Gallery\")").click();
		Desiredcaps.driver.findElementByXPath("//android.widget.TextView[@text='1. Photos']").click();

        AndroidElement gallery = Desiredcaps.driver.findElementById("io.appium.android.apis:id/gallery");
        Point location = gallery.getLocation();
        Point center = gallery.getCenter();
        System.out.println("Location of Gallary: "+ location);
        System.out.println("Centre of Gallary: "+ center);
        System.out.println("List of Images: "+ gallery.findElementsByClassName("android.widget.ImageView").size());
        int centery= center.y;
        System.out.println("centery: "+ centery);
        int locationy= location.y;
        System.out.println("locationy: "+ locationy);
        int differencey =center.y - location.y;
        System.out.println("differencey: "+ differencey);
        int text = 0;
        
        // Moving from Left to Right
        while (text!=7)
        {
        	System.out.println("Moving from Left to Right");
        	System.out.println("Text coming is: "+ text);
        	int resize= gallery.findElementsByClassName("android.widget.ImageView").size();
        	System.out.println("Resize Value: "+ resize);
        	ElementOption pressOption = element(gallery.findElementsByClassName("android.widget.ImageView").get(resize-1),-10,differencey);
            ElementOption moveOption = element(gallery, 10,differencey);
            TouchAction t = new TouchAction(Desiredcaps.driver);
            t.press(pressOption).waitAction(waitOptions(ofSeconds(2))).moveTo(moveOption).release().perform();
            Thread.sleep(2000);
            int size= gallery.findElementsByClassName("android.widget.ImageView").size();
            System.out.println("Image Size on Screen: "+ size);
            gallery.findElementsByClassName("android.widget.ImageView").get(size-1).click();
            String toast= Desiredcaps.driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
            text =Integer.parseInt(toast);
            System.out.println("Toast Message: "+ text);
            
        }
        
     // Moving from Right to Left
        while (text!=0)
        {
        	System.out.println("Moving from Right to Left");
        	System.out.println("Text coming is: "+ text);
        	int resize= gallery.findElementsByClassName("android.widget.ImageView").size();
        	System.out.println("Resize Value: "+ resize);
        	ElementOption pressOption = element(gallery.findElementsByClassName("android.widget.ImageView").get(1),10,differencey);
            ElementOption moveOption = element(gallery, -10,differencey);
            TouchAction t = new TouchAction(Desiredcaps.driver);
            t.press(pressOption).waitAction(waitOptions(ofSeconds(2))).moveTo(moveOption).release().perform();
            Thread.sleep(2000);
            int size= gallery.findElementsByClassName("android.widget.ImageView").size();
            System.out.println("Image Size on Screen: "+ size);
            gallery.findElementsByClassName("android.widget.ImageView").get(0).click();
            String toast= Desiredcaps.driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
            text =Integer.parseInt(toast);
            System.out.println("Toast Message: "+ text);
            
        }
	}
	
	@SuppressWarnings("rawtypes")
	public static void VerticalSwipe() throws MalformedURLException {
		Desiredcaps.Appcap("ApiDemos-debug.apk", "Test");
		Desiredcaps.driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		WebElement press= Desiredcaps.driver.findElementByAccessibilityId("Gallery");
		WebElement move= Desiredcaps.driver.findElementByAccessibilityId("Auto Complete");
		Point originalLocation = press.getLocation();
		System.out.println("Original Location of Gallery is: "+ originalLocation.getY());
		TouchAction t = new TouchAction(Desiredcaps.driver);
		t.press(element(press)).waitAction(waitOptions(ofSeconds(2))).moveTo(element(move)).release().perform();
		Point afterswipeLocation = press.getLocation();
		System.out.println("After Swipe Location of Gallery is: "+ afterswipeLocation.getY());
		
	}

}
