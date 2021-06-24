package com.crm.qa.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;


public class DealsPage extends TestBase{
	
	//Page Factory - OR(object repository):
	
	
	@FindBy(xpath="//*[@id=\"crm_control_panel_menu_menu_crm_deal\"]/a[1]")
	static
	WebElement DealsLink;
	
	@FindBy(xpath="//div[contains(text(),'Quick Deal')]")
	static
	WebElement quickDeals;
	@FindBy(xpath="//*[@id='title_text']")
	static
	WebElement DealName;
	@FindBy(xpath="//*[@class='ui-ctl-inline ui-ctl-element ui-ctl-w75']")
	static
	WebElement DealAmount;
	@FindBy(xpath="//*[@class='ui-btn ui-btn-sm ui-btn-primary']")
	static
	WebElement DealSaveBtn;
	@FindBy(xpath="//*[@class='main-buttons-item-counter']")
	static
	WebElement DealCounter;
	
	
	//Initializing the Page Objects:
	//Pagefactory is a method
	// "this"  means current class object 
	 
	public DealsPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public static HomePage quickDeal() {
		DealsLink.click();
		quickDeals.click();
		return null;
	}
	
	public static HomePage createQuickDeal(String name, String amount) throws InterruptedException {
		
	
		quickDeals.click();
		DealName.sendKeys(name);
		DealAmount.sendKeys(amount);
		DealSaveBtn.click();
		
		
		return null;
	}

	public static HomePage CreatedDealVerify() {
	
		DealCounter.isDisplayed();
		String counter = DealCounter.getText();
	System.out.print("No of deals " +"  "+ counter +" ");
		return null;
		
	}
	
	
//	public boolean validateCRMImage(){
//		return crmLogo.isDisplayed();
//	}
//	
//	public HomePage login(String un, String pwd) throws InterruptedException {
//		String parentHandle = driver.getWindowHandle();	// get the current window handle
//		loginBtnHome.click();
//		loginEnter.click();
//		
//		for (String winHandle : driver.getWindowHandles()) {
//		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
//		}
//		
//		username.sendKeys(un);
//		Thread.sleep(2000);
//		nextBtn.click();
//		password.sendKeys(pwd);
//		nextPass.click();
//		Thread.sleep(2000);
//		driver.switchTo().window(parentHandle);
//		accB24.click();
//		accB24Link.click();
//		//Thread.sleep(2000);
//		
//		//loginBtnSubmit.click();
//		return new HomePage();
//	}
}
