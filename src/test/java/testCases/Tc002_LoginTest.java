package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.InsideLoginPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class Tc002_LoginTest extends BaseClass{
	@Test(groups= {"Regression", "Master"})
	void homepage() {
		HomePage hp= new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
	
	
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPass(p.getProperty("pass"));
		lp.clickLogin();



		try {
		InsideLoginPage ip= new  InsideLoginPage(driver);

		 boolean value= ip.validate();
		 Assert.assertTrue(value);
		 
		}catch(Exception e) {
			Assert.fail();
		
	}
}
}
