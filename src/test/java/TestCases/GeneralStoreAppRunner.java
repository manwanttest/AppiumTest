package TestCases;

import java.net.MalformedURLException;
import java.sql.SQLException;

import org.testng.annotations.Test;
import Capabilities.InvokeAppiumServer;
import Helpers.LoggerHelper;
import Implementation.EcommerceGeneralStore;
import Utilities.AppiumMethods;
import Utilities.ReadDatafromExcel;

//When we mention dependsonmethod in class then testnG after executing constructor directly executes the dataprovider class and when we didn't men
//tion the dataprovider then after executing the constructor it goes for extend keyword and execute that class

public class GeneralStoreAppRunner{

	@Test(dependsOnMethods = "StoreEnterName")
	public static void RunGeneralStore() throws MalformedURLException, InterruptedException, SQLException {
		LoggerHelper.log("Enter RunGeneralStore Method");
		EcommerceGeneralStore.AddingProductinCart(InvokeAppiumServer.gspo);
		LoggerHelper.log("Exit RunGeneralStore Method");
System.out.println("Commit");
LoggerHelper.log("Commit from 2");
	}

	@Test(dataProvider = "shopname", dataProviderClass = ReadDatafromExcel.class)
	public static void StoreEnterName(String s) {
		LoggerHelper.log("Entering Name");
		AppiumMethods.sendkeys(InvokeAppiumServer.gspo.YourName, s);
		LoggerHelper.log("Entered Name");

	}

	@Test
	public static void StoreClickGender() {
		LoggerHelper.log("Selecting Gender");
		AppiumMethods.click(InvokeAppiumServer.gspo.Gender);
		LoggerHelper.log("Selected Gender");

	}

}
