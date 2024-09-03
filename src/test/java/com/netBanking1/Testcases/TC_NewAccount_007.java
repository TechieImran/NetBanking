package com.netBanking1.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.netBanking1.PageObjects.LoginPage;
import com.netBanking1.PageObjects.NewAccount;

public class TC_NewAccount_007 extends BaseClass
{
	@Test(priority=1)
	   public void login() throws InterruptedException, IOException
	   {
		  
		  
		   driver.get(baseURL);
//		   Thread.sleep(2000);
		    	  
		   logger.info(" URL is oppened ");
		   driver.manage().window().maximize();
		   
		   LoginPage lp=new LoginPage(driver);
		   lp.setUsername(username);
		   logger.error("Username is entered");
		   lp.setPassword(password);
		   logger.info("password is entered");

		   lp.clickButton();
		   logger.info("Clicked on login button");
		  if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		  {
			 Assert.assertTrue(true); 
			 logger.info("Login test is passed");
		  }
		  else
		  {
			 captureScreen(driver,"login");
			  Assert.assertTrue(false);
			  logger.info("Login test is failed");
		  }
		   
		   
		   
	   }
	
   @Test(priority=2)
   
	public void createNewAccount() throws Exception
	{
	   NewAccount NA=new NewAccount( driver);
	   
	   NA.ClickNewAccountBtn();
	   
	   NA.setCusID("76778");
	   logger.info("Customer ID Entered");
	   NA.setAccntType("Current");
	   logger.info("Account type is entered");
	   NA.setInitDepo("5000"); 
	   logger.info("Intial Deposit entered");
	  
	   Thread.sleep(2000);
	   NA.ClickSubmit();
	   logger.info("NewAccount is submitted");
	   Thread.sleep(2000);
	   boolean status=driver.getPageSource().contains("Account Generated Successfully!!!");
	   
	   if(status==true)
	   {
		   Assert.assertTrue(true);
		   logger.info("Account Generated Successfully");
	   }
	  
	   else
	   {
		   captureScreen(driver,"createNewAccount");
		   Assert.assertTrue(false);
		   logger.info("Account Generation Failed");
	   }
	   
	   
	   
	}

}
