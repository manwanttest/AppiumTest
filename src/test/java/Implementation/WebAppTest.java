package Implementation;

import org.openqa.selenium.By;

import Capabilities.Desiredcaps;
import Helpers.AsyncCalls;

public class WebAppTest {

	//public static void main(String[] args) throws MalformedURLException {
		public static void OpenWebpage() {

//		Desiredcaps.AppcapforWebApp("Chrome", "Test");
		// If site cant be opened in emulator just go to Android studio and do cold
		// reboot now and then open again every website will open
		Desiredcaps.driver.get("https://m.facebook.com/");
//		Desiredcaps.driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Test");
//		Desiredcaps.driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("Test");
		Desiredcaps.driver.findElement(By.xpath("//button[@name='login']")).click();
		AsyncCalls.CheckMessage(Desiredcaps.driver.findElement(By.xpath("//div[@id='login_error']")));

	}

}
