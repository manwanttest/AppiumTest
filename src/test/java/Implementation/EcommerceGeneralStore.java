package Implementation;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import Capabilities.Desiredcaps;
import Database.ConnectDB;
import Helpers.LoggerHelper;
import PageObjects.GeneralStorePO;
import Utilities.AppiumMethods;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class EcommerceGeneralStore extends GeneralStorePO {

	public static int addeditems;
	public static HashMap<Integer, Double> map = new HashMap<Integer, Double>();

	
	
	public static void AddingProductinCart(GeneralStorePO b) throws InterruptedException, SQLException {
		LoggerHelper.log("GeneralStorePO Object coming is: " + b);
		LoggerHelper.log("Adding the Product in Cart");
		//AppiumMethods.sendkeys(b.YourName, "GeneralStore");
		AppiumMethods.sendkeys(b.YourName, ConnectDB.createcon()[0].toString());
		AppiumMethods.click(b.Gender);
		AppiumMethods.click(b.SelectCountry);
		AppiumMethods.scrollToText("Brazil");
		AppiumMethods.click(b.ClickCountry);
		AppiumMethods.click(b.LetsShop);
		LoggerHelper.log("Getting the list of Prodcuts");
		int Productlistcount = b.ProductList.size();
		LoggerHelper.log("List of Products are: " + Productlistcount);
		AppiumMethods.scrollToText("Jordan 6 Rings");
		int Productnamecount = b.ProductName.size();
		LoggerHelper.log("Count of Products name are: " + Productnamecount);
		int addcartsize = b.AddtoCart.size();
		LoggerHelper.log("Count of AddtoCart buttons are: " + addcartsize);
		for (int i = 0; i < Productnamecount; i++) {
			String Productname = AppiumMethods.gettext(b.ProductName.get(i));
			LoggerHelper.log("Name of Product coming is: " + Productname);
			LoggerHelper.log("Clicking Add to Cart");
			AppiumMethods.click(b.AddtoCart.get(0));
			LoggerHelper.log("Clicked Add to Cart");
			String addedtocart = AppiumMethods.gettext(b.AddedtoCart.get(0));
			LoggerHelper.log("AddedToCart text coming is: " + addedtocart);
			LoggerHelper.log("Getting price of product");
			String ProductPrice = AppiumMethods.gettext(b.ProductPrice.get(i));
			LoggerHelper.log("Product Prize coming is: " + ProductPrice);
			double cost = Double.parseDouble(ProductPrice.substring(1));
			LoggerHelper.log("Cost is: " + cost);
			map.put(i, cost);
			addeditems++;
		}
		double Totalproductcost = 0;
		LoggerHelper.log("Size of products prices in map: " + map.size());
		for (int j = 0; j < map.size(); j++) {

			Totalproductcost = Totalproductcost + map.get(j);
			LoggerHelper.log("Value in Totalproductcost: " + Totalproductcost);
		}
		map.clear();
		LoggerHelper.log("After clearing MAp size is: " + map.size());
		LoggerHelper.log("Final value of Added Items: " + addeditems);
		LoggerHelper.log("Final Product Price before coming is: " + Totalproductcost);

		String cartcount = AppiumMethods.gettext(b.CartCount);
		LoggerHelper.log("Count of Cart is: " + Integer.parseInt(cartcount));
		if (addeditems == Integer.parseInt(cartcount)) {
			LoggerHelper.log("Cart count is matched with added items");
		} else {
			LoggerHelper.log("Cart count not matched with added items");
		}

		LoggerHelper.log("Clicking button of Cart");
		AppiumMethods.click(b.CartIcon);
		Thread.sleep(2000);
		int Productpricecount = b.ProductPrice.size();
		LoggerHelper.log("Count of Products name coming after adding to cart: " + Productpricecount);
		for (int i = 0; i < Productpricecount; i++) {
			String ProductPriceafteraddingtocart = AppiumMethods.gettext(b.ProductPrice.get(i));
			LoggerHelper.log("Product Price after addingtocart coming is: " + ProductPriceafteraddingtocart);
			String ProductPrice = AppiumMethods.gettext(b.ProductPrice.get(i));
			LoggerHelper.log("Product Prize after addingtocart coming is: " + ProductPrice);
			double cost = Double.parseDouble(ProductPrice.substring(1));
			LoggerHelper.log("Cost is: " + cost);
			map.put(i, cost);
		}
		double Totalproductcostafteradding = 0;
		LoggerHelper.log("Size of products prices after adding to cart: " + map.size());
		for (int j = 0; j < map.size(); j++) {

			Totalproductcostafteradding = Totalproductcostafteradding + map.get(j);
			LoggerHelper.log("Value in Totalproductcost: " + Totalproductcostafteradding);
		}
		map.clear();
		LoggerHelper.log("Final Product Price coming is: " + Totalproductcostafteradding);

		if (Totalproductcost == Totalproductcostafteradding) {
			LoggerHelper.log("Product Price is getting matched before and after adding to cart");
		} else {
			LoggerHelper.log("Product Price is not getting matched");
		}

		LoggerHelper.log("Clicking the E mail checkbox and Visit to Website");
		AppiumMethods.click(b.EmailCheckbox);
		AppiumMethods.click(b.VisitWebsite);
		LoggerHelper.log("Clicked the E mail checkbox and Visit to Website");
		Thread.sleep(5000);
		Set<String> contexts = Desiredcaps.driver.getContextHandles();

		for (String contextName : contexts)

		{

			LoggerHelper.log("Length of Context coming is: " + contextName);

		}
		Object[] a = contexts.toArray();
		LoggerHelper.log("Context Array : " + contexts.toArray());

		// Desiredcaps.driver.context("WEBVIEW_com.androidsample.generalstore");
		LoggerHelper.log("Value of Context Array at index 0: " + a[1].toString());
		Desiredcaps.driver.context(a[1].toString());

		Desiredcaps.driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("GoogleTest");
		LoggerHelper.log("Text entered in Search box");

		Desiredcaps.driver.pressKey(new KeyEvent(AndroidKey.BACK));

		// Desiredcaps.driver.context("NATIVE_APP");
		LoggerHelper.log("Value of Context Array at index 0: " + a[0].toString());
		Desiredcaps.driver.context(a[0].toString());
		LoggerHelper.log("Back to Native App");

	}
}
