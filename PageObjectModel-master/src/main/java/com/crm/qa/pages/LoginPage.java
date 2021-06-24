package com.crm.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR(object repository):
	
	@FindBy(xpath="//div[contains(text(),'Log In')]")
	WebElement loginBtnHome;
	
	@FindBy(xpath="//div[contains(text(),'Enter')]")
	WebElement loginEnter;
	
	@FindBy(xpath="//*[@id=\"login\"]")
	WebElement username;
	
	@FindBy(xpath="//button[contains(text(),'Next')]")
	WebElement nextBtn;
	
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"authorize-layout\"]/div/div[3]/div/form/div/div[3]/button[1]")
	WebElement nextPass;
	
	@FindBy(xpath="//div[@class='portal-auth-bitrix24__user']")
	WebElement accB24;
	
	@FindBy(xpath="//a[contains(text(),'b24-0eponp.bitrix24.com')]")
	WebElement accB24Link;
	
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtnSubmit;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//span[contains(@class,'header-logo__picture)]")
	WebElement crmLogo;
	
	@FindBy(xpath="//*[@id=\"crm_control_panel_menu_menu_crm_deal\"]/a[1]")
	WebElement DealsLink;
	
	@FindBy(xpath="//div[contains(text(),'Quick Deal')]")
	WebElement quickDeals;
	
	@FindBy(xpath="//div[@class='advertising-popup__close']")
	WebElement popup;
	
//	@FindBy(xpath="//div[@class='helpdesk-notification-shutter-close-btn js-help-notification-shutter-close']")
//	WebElement ShatterPopup;
	//Initializing the Page Objects:
	//Pagefactory is a method
	// "this"  means current class object 
	 
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage quickDeal() {
		DealsLink.click();
		quickDeals.click();
		return null;
	}
	
//	public boolean validateCRMImage(){
//		return crmLogo.isDisplayed();
//	}
//	
	public HomePage login(String un, String pwd) throws InterruptedException {
		String parentHandle = driver.getWindowHandle();	// get the current window handle
		popup.click();
		
		loginBtnHome.click();
		loginEnter.click();
		
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		
		username.sendKeys(un);
		Thread.sleep(2000);
		nextBtn.click();
		password.sendKeys(pwd);
		nextPass.click();
		Thread.sleep(2000);
		driver.switchTo().window(parentHandle);
		accB24.click();
		accB24Link.click();
		//ShatterPopup.click();
		//Thread.sleep(2000);
		
		//loginBtnSubmit.click();
		return new HomePage();
	}
}
