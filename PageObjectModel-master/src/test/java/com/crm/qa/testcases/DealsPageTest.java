package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import com.google.common.collect.ObjectArrays;

public class DealsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	String sheetname = "sheet";
	public DealsPageTest() {
		
	super();
		
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		driver.navigate().refresh();
		loginPage = new LoginPage();//object of loginPage class
		 DealsPage DealsPage = new DealsPage();
	}
	

	@DataProvider
	public Object[][] getCrmDealsData() {
		
		Object data[][] = TestUtil.getTestData(sheetname);
		return data;
		
		
		
	}
	@Test(priority=1, enabled = false)
	public void quickDeal() throws Exception{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		DealsPage.quickDeal();
		
		
	}
	@Test(priority = 2, dataProvider = "getCrmDealsData", enabled = true)
	public void createDeals(String name, String amount) throws Exception{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		DealsPage.quickDeal();
		DealsPage.createQuickDeal(name, amount);
		
			
	}
	
	@Test(priority = 3, enabled = false)
	public void DealCreateVerify() throws InterruptedException{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		DealsPage.CreatedDealVerify();
		
		 
	}
	

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
}
