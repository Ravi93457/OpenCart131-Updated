package testCases;

//import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.InsideLoginPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class Tc002_LoginTest extends BaseClass{
	@Test(groups= {"Regression", "Master"})
	void homepage() {
		try {
		HomePage hp= new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
	
	
		LoginPage lp= new LoginPage(driver);
		
		lp.setEmail( BaseClass.registeredEmail);
		lp.setPass( BaseClass.registeredPassword);
		lp.clickLogin();
	

/// Next Proccess

		
		InsideLoginPage ip= new  InsideLoginPage(driver);

		 boolean value= ip.validate();
		 Assert.assertTrue(value);
		 ip.clickDeskTop();
//		 Thread.sleep(5000);
		 ip.getName();
		 ip.clickCart();
		 boolean  validateCart= ip.validateCart();
		 Assert.assertTrue(validateCart);
		 ip.selectClr();
		 ip.clickAddToCart();
		boolean validateProduct= ip.validateProductAdded();
		Assert.assertTrue(validateProduct);
		ip.exitMsg();
		
		//Next process
		
		CartPage cart= new CartPage(driver);
		cart.clickCart();
		cart.clickGoToCart();
		cart.openShippingEstimator();
		cart.selectContry();
		cart.selectRegion();
		cart.pincode(randomNumber());
		cart.getQuotes();
		cart.clickFltShipping();	
		cart.clickAppltFltShpping();
		boolean check= cart.checkMsg();
		Assert.assertTrue(check );
		cart.closeMSg();
		
		cart.clickCheckOut();
		
		//Next process
		CheckOutPage checkOut= new CheckOutPage(driver);
		checkOut.enterFirstName(randomString());
		checkOut.enterLastName(randomString());
		checkOut.enterCompanyName(randomString());
		checkOut.enterAddress1(randomString());
		checkOut.enterAddress2(randomString());
		checkOut.enterCity(randomString());
		checkOut.selectRegion();
		checkOut.clickContinue();
		boolean checkmsg= checkOut.CheckMsg();
		Assert.assertTrue(checkmsg);
		checkOut.clickCloseMsg();
		checkOut.clickShipping();
		checkOut.clickShippingContinue();
		boolean shippingMsg= checkOut.checkShippingMsg();
		Assert.assertTrue(shippingMsg);
		checkOut.closShippingMsg();
		checkOut.clickPaymentMethod();
		checkOut.clickPaymentMethodContinue();
		boolean paymentMsg= checkOut.checkPaymentMsg();
		Assert.assertTrue(paymentMsg);
		checkOut.closePaymentMsg();
		checkOut.clickConfirmOrderBtn();
		boolean orderMsg= checkOut.checkorderMsg();
		Assert.assertTrue(orderMsg);
		
		
		
		}catch(Exception e) {
			 e.printStackTrace();
			    Assert.fail("Test failed due to exception: " + e.getMessage());
	
	
	}
}
}
