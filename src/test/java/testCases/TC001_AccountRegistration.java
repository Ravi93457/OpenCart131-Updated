 package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass {
	
	@Test( groups= {"Sanity" , "Master"})
	public void Registeration() {
		try{
		logger.info("Starting the HomePage .......");
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.clickMyRegister();
		System.out.println("The Page Has Gone to the Registration Page .........");
	}catch(Exception e) {
		logger.error("Test failed....");
//		logger.debug("Debug Failed....");
		Assert.fail();
		
	}
	

		try {
		logger.info("Starting the Registration Page.....");
		RegisterPage rp= new RegisterPage(driver);
		rp.setUserFirstName(randomString());
		rp.setUserLastName(randomString());
		rp.setEmail(randomEmail()+"@gmail.com");
		rp.setPass(randomNumber());
		rp.clickAgree();
		System.out.println("The Agree Btn clicked......");
		rp.clickCountinue();
		logger.info("Validating the page at the end...");
		Assert.assertEquals(rp.checkBanner(), "Your Account Has Been Created!");
	}catch(Exception e) {
		logger.error("Regristration Failed.....");
//		logger.debug("The Regristration Debug Failed...");
		Assert.fail();
	}
	}
	
	

}


