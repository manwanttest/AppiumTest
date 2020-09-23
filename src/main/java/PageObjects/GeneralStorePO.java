package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Capabilities.Desiredcaps;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GeneralStorePO {

	public GeneralStorePO() {
		System.out.println("Inside GeneralStorePO b");
		PageFactory.initElements(new AppiumFieldDecorator(Desiredcaps.driver), this);
		System.out.println("Outside GeneralStorePO b");
	}
	
	//Other way to initialize driver, If driver is not declared as static 
//	public FormPage(AndroidDriver<AndroidElement> driver)
//	{
//		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	public WebElement YourName;
	
	//Other way to retutn WEbelement
//	public WebElement getNameField()
//	{
//		System.out.println("trying to find the Name field");
//		return YourName;
//	}

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	public WebElement Gender;

	@AndroidFindBy(className = "android.widget.Spinner")
	public WebElement SelectCountry;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Brazil']")
	public WebElement ClickCountry;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	public WebElement LetsShop;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/rvProductList")
	public List<WebElement> ProductList;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	public List<WebElement> AddtoCart;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement CartIcon;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/counterText")
	public WebElement CartCount;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	public List<WebElement> ProductPrice;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
	public List<WebElement> ProductName;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
	public List<WebElement> AddedtoCart;

	@AndroidFindBy(className = "android.widget.CheckBox")
	public WebElement EmailCheckbox;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	public WebElement VisitWebsite;	
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
	public WebElement GeneralStoreAppTitle;	
	
	
	

}
