package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.InsideLoginPage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import uitlities.DatadrivenUtlits;
public class TC003_LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData", dataProviderClass= DatadrivenUtlits.class)
	
	void loginDDT(String email , String pass, String exp) {
		logger.info("*****************  The Page Started   ***********");
		HomePage hp= new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
	
	
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		lp.setPass(pass);
		lp.clickLogin();
	
		try {
		InsideLoginPage ip= new  InsideLoginPage(driver);

		 boolean value= ip.validate();
		 
		if(exp.equalsIgnoreCase("valid")) {
		
			if(value==true) {
				ip.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
			
		}
		if(exp.equalsIgnoreCase("invalid")) {
			if(value==true) {
				ip.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		logger.info("***************** The Page Ended ******************");
		 
		}catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
}

