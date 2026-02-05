package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.*;




public class InsideLoginPage extends BasePage {
public 	InsideLoginPage(WebDriver driver){
		super(driver);
	}

	@FindBy(xpath="//h1[normalize-space()=\"My Account\"]")
	WebElement txt_value;
	@FindBy(xpath= "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	@FindBy(xpath="//a[normalize-space()=\"Desktops\"]")
	WebElement deskTop;
	@FindBy(xpath= "//a[normalize-space()=\"Show All Desktops\"]")
	WebElement allDeskTop;
	@FindBy(xpath="//div[@id='product-list']//div[@class='product-thumb']")
     List<WebElement> allProduct;
	@FindBy(xpath="//div[@class='description']//a[contains(text(),'Canon EOS 5D')]")
	WebElement clickaddToCart;
	@FindBy(xpath="//body[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/p[1]/span[1]/i[1]")
	WebElement checkcart;
	@FindBy(xpath="//select[@class='form-select']")
	WebElement select_clr;
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement addToCart;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement  success_Msg;
	@FindBy(xpath="//button[@class='btn-close']")
	WebElement exit_SuccessMsg;
	

	
public boolean validate() {
	try {
//		boolean value= txt_value.isDisplayed();
		return wait.until(ExpectedConditions.visibilityOf(txt_value)).isDisplayed();
	}catch(Exception e) {
		return false ; 	
	}
}
public void clickDeskTop() {
	Actions act = new Actions(driver);
	act.moveToElement(deskTop).moveToElement(allDeskTop).click().build().perform();
}
public void getName() {
	for(WebElement a : allProduct) {
	String  b= a.getText();	
		System.out.print(b+"\t");
	}
	
	System.out.println();

	
}
public void  clickCart() {
	js.executeScript("arguments[0].scrollIntoView({block:'center'});",clickaddToCart);
	wait.until(ExpectedConditions.elementToBeClickable(clickaddToCart)).click();
//	 js.executeScript("arguments[0].click();", clickaddToCart);
}
 public boolean validateCart() {
	 return wait.until(ExpectedConditions.visibilityOf(checkcart)).isDisplayed();
 }

public void selectClr() {
	Select select= new Select(select_clr);
	select.selectByIndex(1);
}
public void clickAddToCart() {
	js.executeScript("arguments[0].scrollIntoView({block:'center'});", addToCart);
	wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
//	js.executeScript("arguments[0].click();", addToCart);
}
public boolean validateProductAdded() {
    return wait.until(ExpectedConditions.visibilityOf(success_Msg)).isDisplayed();
}
public void exitMsg() {
	wait.until(ExpectedConditions.elementToBeClickable(exit_SuccessMsg)).click();
}
public void clickLogout() {
	lnkLogout.click();
}
}
