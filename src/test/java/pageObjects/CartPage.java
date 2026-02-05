package pageObjects;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class CartPage extends BasePage {
	
	public CartPage( WebDriver driver) {

		super(driver);
	}
	@FindBy(xpath="//button[contains(@class,'btn') and contains(.,'item')]")
	WebElement cart_Btn;
	@FindBy(xpath="//ul[contains(@class,'dropdown-menu')]//a[contains(@href,'checkout/cart')]")
	WebElement  goToCart_Btn;
	@FindBy(xpath="//button[normalize-space()='Estimate Shipping & Taxes']")
	WebElement shipping_DropdownBtn;
	@FindBy(xpath="//select[@id='input-country']")
	WebElement contrySelect_Btn;
	@FindBy(xpath="//select[@id='input-zone']")             //"arguments[0].scrollIntoView(true);"
	WebElement regionSelect_Btn;  //
	@FindBy(xpath="//input[@id='input-postcode']")
	WebElement txt_Pincode;
	@FindBy(xpath="//button[@id='button-quote']")
	WebElement btn_GetQuotes;
	@FindBy(xpath="//input[@id='input-shipping-method-flat-flat']")
	WebElement btn_FlatShippingRate;
	@FindBy(xpath="//button[@id='button-shipping-method']")
	WebElement btn_ApplyShipping;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successMsg;
	@FindBy(xpath="//div[@id='alert']//button[@class='btn-close']")
	WebElement close_Msg;
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement btn_CheckOut;
	
	
	public void clickCart() {
		   js.executeScript("window.scrollTo(0, 0);");
//		js.executeScript("arguments[0].scrollIntoView(true);",  cart_Btn);
		wait.until(ExpectedConditions.elementToBeClickable( cart_Btn));
	    js.executeScript("arguments[0].click();", cart_Btn);

	}
	
	public void clickGoToCart() {
//		js.executeScript("arguments[0].scrollIntoView(true);", goToCart_Btn);
		wait.until(ExpectedConditions.elementToBeClickable(goToCart_Btn)).click();
	}
	public void selectContry() {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", contrySelect_Btn);
		Select select= new Select(contrySelect_Btn);
		select.selectByVisibleText("Angola");
		
	}
	public void selectRegion() {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", regionSelect_Btn);
		Select select= new Select(regionSelect_Btn);
		select.selectByIndex(3);;
	}
	public void pincode(String text) {
		 wait.until(ExpectedConditions.visibilityOf(txt_Pincode)).clear();
		    txt_Pincode.sendKeys(text); 
	} 
	public void getQuotes() {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", btn_GetQuotes);
		wait.until(ExpectedConditions.elementToBeClickable(btn_GetQuotes)).click();
	}
	
	public void clickFltShipping() {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", btn_FlatShippingRate);
		wait.until(ExpectedConditions.elementToBeClickable(btn_FlatShippingRate)).click();
	}
	public void clickAppltFltShpping() {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", btn_ApplyShipping);
		wait.until(ExpectedConditions.elementToBeClickable(btn_ApplyShipping)).click();
		
	}
	public boolean checkMsg() {
		return wait.until(ExpectedConditions.visibilityOf(successMsg)).isDisplayed();
	}
	public void closeMSg() {
		wait.until(ExpectedConditions.elementToBeClickable(close_Msg)).click();
	}
	
	public void clickCheckOut() {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", btn_CheckOut);
		wait.until(ExpectedConditions.elementToBeClickable(btn_CheckOut)).click();
	}
	public void openShippingEstimator() {
	    js.executeScript("arguments[0].scrollIntoView({block:'center'});", shipping_DropdownBtn);
	    wait.until(ExpectedConditions.elementToBeClickable(shipping_DropdownBtn)).click();
	}
	
	
	

}
