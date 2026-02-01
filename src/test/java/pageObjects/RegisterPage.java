package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage{
	 public RegisterPage(WebDriver driver){
		super(driver);
	}
@FindBy(xpath="//input[@id=\"input-firstname\"]")
WebElement txt_UserFirstName;
@FindBy(xpath="//input[@id=\"input-lastname\"]")
WebElement txt_UserLastName;
@FindBy(xpath="//input[@id=\"input-email\"]")
WebElement txt_Email;
@FindBy(xpath="//input[@id=\"input-password\"]")
WebElement txt_Pass;
@FindBy(xpath="//input[@name=\"agree\"]")
WebElement btn_Agree;
@FindBy(xpath="//button[normalize-space()=\"Continue\"]")
WebElement btn_Countinue;
@FindBy(xpath="//h1[normalize-space()=\"Your Account Has Been Created!\"]")
WebElement verify_txt;


public void setUserFirstName(String firstName) {
	txt_UserFirstName.sendKeys(firstName);
}
public void setUserLastName(String lastName) {
	txt_UserLastName.sendKeys(lastName);
}
public void setEmail(String email) {
	txt_Email.sendKeys(email);
}
public void setPass(String pass) {
	txt_Pass.sendKeys(pass);
}
public void clickAgree() {
	js.executeScript("arguments[0].scrollIntoView(true);", btn_Agree);
	wait.until(ExpectedConditions.elementToBeClickable(btn_Agree));
	 js.executeScript("arguments[0].click();", btn_Agree);
}
public void clickCountinue() {
	btn_Countinue.click();
}
public String checkBanner() {
	try {
		return( verify_txt.getText());
	}catch(Exception e) {
		return(e.getMessage());
	}
}

}
