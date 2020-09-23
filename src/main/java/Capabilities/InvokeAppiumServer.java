package Capabilities;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import Helpers.AsyncCalls;
import Helpers.LoggerHelper;
import PageObjects.APIDemosPO;
import PageObjects.GeneralStorePO;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class InvokeAppiumServer implements IInvokedMethodListener{

	public static AppiumDriverLocalService service;
	public static GeneralStorePO gspo;
	public static APIDemosPO adpo;
	
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		LoggerHelper.log("Inside Before invocation");
		String Methodname =method.getTestMethod().getMethodName();
		LoggerHelper.log("Method Name coming is: "+ Methodname);
		LoggerHelper.log("Enter StartAppiumServer Method");
		try {
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			LoggerHelper.log("TaskKilled");
		} catch (IOException e1) {
			LoggerHelper.log("Landed in Task Killed catch block");
		}
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		AsyncCalls.PollingAppiumServerStatus("started");
		LoggerHelper.log("Exit StartAppiumServer Method");
		System.out.println("Method Name coming is: "+ Methodname);
		InvokeApp(Methodname);
		
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("after invocation " + method.getTestMethod().getMethodName());
		LoggerHelper.log("Enter StopAppiumServer Method");
		Desiredcaps.driver.closeApp();
		LoggerHelper.log("Current Activity after App Closed: " + Desiredcaps.driver.currentActivity());
		if (Desiredcaps.driver.currentActivity().contains("Nexus")) {
			LoggerHelper.log("App has been successfully Closed");
		} else {
			LoggerHelper.log("App has not been Closed so Retry it");
		}
		service.stop();
		LoggerHelper.log("Service Stopped logs: " + service.getStdOut());
		if (service.getStdOut() == null) {
			LoggerHelper.log("Appium Server has been successfully Closed");
		} else {
			LoggerHelper.log("Appium Server has not been Closed so Retry it");
		}
		LoggerHelper.log("Exit StopAppiumServer Method");
		
	}
	
	public static void isAppOpened(WebElement e) {
		LoggerHelper.log("Webelement coming is: "+ e);
		int counter = 0;
		boolean onlinealert = false;
		while (!onlinealert && counter != 500000) {
			try {
				LoggerHelper.log("Checking for App Title");
				String s = e.getText();
				LoggerHelper.log("App Title coming is: "+ s);
				onlinealert = true;
				Thread.sleep(3000);
			} catch (Exception e1) {
				LoggerHelper.log("Landed in Catch block of Checking for App Title");
				counter++;
				LoggerHelper.log("Keep Waiting for App Title at counter: " + counter);
			}
		}
	}
	
	// Check Appium server is ruuning or not

	//public static boolean checkIfServerIsRunnning(int port) {
//			
//			boolean isServerRunning = false;
//			ServerSocket serverSocket;
//			try {
//				serverSocket = new ServerSocket(port);
//				
//				serverSocket.close();
//			} catch (IOException e) {
//				//If control comes here, then it means that the port is in use
//				isServerRunning = true;
//			} finally {
//				serverSocket = null;
//			}
//			return isServerRunning;
//		}

//		boolean flag=	checkIfServerIsRunnning(4723);
//		if(!flag)
//		{
//			
//			service=AppiumDriverLocalService.buildDefaultService();
//			service.start();
//		}
//			return service;
//			
//		}
	
	public static void InvokeApp(String Methodname) {
		if (Methodname.contains("Store")) {
			LoggerHelper.log("Its the General Store App need to invoke");
			Desiredcaps.Appcap("General-Store.apk", "Test");
			gspo= new GeneralStorePO();
			LoggerHelper.log("Object Initialized: "+ gspo);
			isAppOpened(gspo.GeneralStoreAppTitle);
		} 
		else if (Methodname.contains("ApiDemos")) {
			LoggerHelper.log("Its the API Demos App need to invoke");
			Desiredcaps.Appcap("ApiDemos-debug.apk", "Test");
			adpo= new APIDemosPO();
			isAppOpened(adpo.APIDemosTitle);
		} 
		else {
			LoggerHelper.log("Its the Web App need to invoke");
			Desiredcaps.AppcapforWebApp("Chrome", "Test");
		}
	}

}
