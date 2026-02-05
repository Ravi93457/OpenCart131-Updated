package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage {
	 public CheckOutPage(WebDriver driver){
		super(driver);
	}
	@FindBy(xpath="//input[@id='input-shipping-firstname']")
	WebElement txt_FirstName;
	@FindBy(xpath="//input[@id='input-shipping-lastname']")
	WebElement txt_LastName;             
	@FindBy(xpath="//input[@id='input-shipping-company']")
	WebElement txt_CompanyName;
	
	@FindBy(xpath="//input[@name='address_1']")
	WebElement txt_Address1;
	//button[@class='btn-close']
	@FindBy(xpath="//input[@name='address_2']")
	WebElement txt_Address2;

	@FindBy(xpath="//input[@id='input-shipping-city']")
	WebElement txt_City;

	@FindBy(xpath="//select[@id='input-shipping-zone']")
	WebElement SelectBtn_Region;

	@FindBy(xpath="//button[@id='button-shipping-address']")
	WebElement btn_Continue;
	@FindBy(xpath=" //div[@class='alert alert-success alert-dismissible']")
	WebElement success_Msg;
	@FindBy(xpath="//button[@class='btn-close']")
	WebElement closeSucess_Msg;
	
	
	
	
	
	@FindBy(xpath="//button[@id='button-shipping-methods']") //button[@id='button-shipping-method']
	WebElement btn_ShippingMethod;
	@FindBy(xpath="//div[@class='text-end']//button[@id='button-shipping-method']")
	WebElement btn_ShippingMethod_Continue;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successMsg_Shipping;
	@FindBy(xpath="//button[@data-bs-dismiss='alert']")
	WebElement closeSucessMsg_Shipping;
	@FindBy(xpath="//button[@id='button-payment-methods']")
	WebElement btn_PaymentMethod;
	@FindBy(xpath="//button[@id='button-payment-method']")
	WebElement btn_PaymentMethodContinue;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement success_MsgPaymentMethod;
	@FindBy(xpath="//button[@data-bs-dismiss='alert']")
	WebElement close_SucessPaymentMsg;
	@FindBy(xpath="//button[@id='button-confirm']")
	WebElement  btn_ConfirmOrder;
	@FindBy(xpath="//h1[normalize-space()='Your order has been placed!']")
	WebElement orderConfirm_Msg;
	

	public void enterFirstName(String name) {
		wait.until(ExpectedConditions.visibilityOf(txt_FirstName)).clear();
		txt_FirstName.sendKeys(name);
	}
	public void enterLastName(String name) {
		wait.until(ExpectedConditions.visibilityOf(txt_LastName)).clear();
		txt_LastName.sendKeys(name);
	}
	public void  enterCompanyName(String name) {
		wait.until(ExpectedConditions.visibilityOf(txt_CompanyName)).clear();
		txt_CompanyName.sendKeys(name);

	}
	public void enterAddress1(String name) {
		wait.until(ExpectedConditions.visibilityOf(txt_Address1)).clear();
		txt_Address1.sendKeys(name);	
	}
	public void enterAddress2(String name) {
		wait.until(ExpectedConditions.visibilityOf(txt_Address2)).clear();
		txt_Address2.sendKeys(name);
	}
	public void enterCity(String name) {
		wait.until(ExpectedConditions.visibilityOf(txt_City)).clear();
		txt_City.sendKeys(name);
	}
	public void selectRegion(String name) {
		new Select(SelectBtn_Region).selectByVisibleText(name);
	}
	public void clickContinue() {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});",btn_Continue);
		wait.until(ExpectedConditions.elementToBeClickable(btn_Continue)).click();
		
	}
	public boolean CheckMsg() {
		return wait.until(ExpectedConditions.visibilityOf(success_Msg)).isDisplayed();
	}
	public void clickCloseMsg() {
		wait.until(ExpectedConditions.elementToBeClickable(closeSucess_Msg)).click();
		
	}
	public void clickShipping() {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});",btn_ShippingMethod);
		wait.until(ExpectedConditions.elementToBeClickable(btn_ShippingMethod)).click();
	}
	public void clickShippingContinue() {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});",btn_ShippingMethod_Continue);
		wait.until(ExpectedConditions.elementToBeClickable(btn_ShippingMethod_Continue)).click();
	}
	public boolean checkShippingMsg() {
		return wait.until(ExpectedConditions.visibilityOf(successMsg_Shipping)).isDisplayed();
	}
	public void closShippingMsg() {
		wait.until(ExpectedConditions.elementToBeClickable(closeSucessMsg_Shipping)).click();
	}
	public void  clickPaymentMethod() {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});",btn_PaymentMethod);
		wait.until(ExpectedConditions.elementToBeClickable(btn_PaymentMethod)).click();
	}
	public void clickPaymentMethodContinue() {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});",btn_PaymentMethodContinue);
		wait.until(ExpectedConditions.elementToBeClickable(btn_PaymentMethodContinue)).click();
	}
	public boolean checkPaymentMsg() {
		return wait.until(ExpectedConditions.visibilityOf(success_MsgPaymentMethod)).isDisplayed();
	}
	public void closePaymentMsg() {
		wait.until(ExpectedConditions.elementToBeClickable(close_SucessPaymentMsg)).click();
		
	}
	public void  clickConfirmOrderBtn() {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});",btn_ConfirmOrder);
		wait.until(ExpectedConditions.elementToBeClickable(btn_ConfirmOrder)).click();
		
	}
 public boolean checkorderMsg() {
	 return wait.until(ExpectedConditions.visibilityOf(orderConfirm_Msg)).isDisplayed();

 }
	
	
	


}
