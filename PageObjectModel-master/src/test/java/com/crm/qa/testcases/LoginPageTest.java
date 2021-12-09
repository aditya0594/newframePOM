package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	
	//contructor 
	//super keyword , we have to call the testbase class constructor that is properties we using for the initialization 
	//complusary to call the using super keyword we are calling the super class contructor ie Testbase 
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		driver.navigate().refresh();
		loginPage = new LoginPage();              //object of loginPage class
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Bitrix24: #1 Free Collaboration Platform With CRM, Tasks, Projects, Documents, Messaging And Much More");
	}
	
//	@Test(priority=2)
////	public void crmLogoImageTest(){
////		boolean flag = loginPage.validateCRMImage();
////		Assert.assertTrue(flag);
////	}
//	
	@Test(priority=2)
	public void loginTest() throws Exception{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	@Test(priority=3)
	public void quickDeal() throws Exception{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		loginPage.quickDeal();
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
