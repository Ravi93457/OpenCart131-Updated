package pageObjects;





import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;




public class HomePage extends BasePage{

	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//span[normalize-space()=\"My Account\"]")
	WebElement lnkMyAccount;
	@FindBy(xpath="//a[normalize-space()=\"Register\"]")//
	WebElement lnkRegister;
	
	
	@FindBy(xpath="//a[normalize-space()=\"Login\"]")  
	WebElement lnkLogin;
	
	
	
	
	public void clickMyaccount() {
		js.executeScript("arguments[0].scrollIntoView(true);", lnkMyAccount);
		wait.until(ExpectedConditions.elementToBeClickable(lnkMyAccount));
		 js.executeScript("arguments[0].click();", lnkMyAccount);
	}
	public void clickMyRegister() {
		js.executeScript("arguments[0].scrollIntoView(true);",  lnkRegister);
		wait.until(ExpectedConditions.elementToBeClickable( lnkRegister));
		 js.executeScript("arguments[0].click();",  lnkRegister);
	}
	public void clickLogin() {
		js.executeScript("arguments[0].scrollIntoView(true);", lnkLogin);
		wait.until(ExpectedConditions.elementToBeClickable( lnkLogin));
		 js.executeScript("arguments[0].click();",  lnkLogin);
		
	}
	

}
