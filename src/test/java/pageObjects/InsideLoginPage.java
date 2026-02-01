package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InsideLoginPage extends BasePage {
public 	InsideLoginPage(WebDriver driver){
		super(driver);
	}
	@FindBy(xpath="//h1[normalize-space()=\"My Account\"]")
	WebElement txt_value;
	@FindBy(xpath= "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	
public boolean validate() {
	try {
		boolean value= txt_value.isDisplayed();
		return value;
	}catch(Exception e) {
		return false ; 	
	}
	

	
}
public void clickLogout() {
	lnkLogout.click();
}
}
