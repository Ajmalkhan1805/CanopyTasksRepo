package com.ajmal.pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ajmal.base.Page;
import com.ajmal.pages.locators.TopNavigationLocators;
import com.ajmal.utilities.Utilities;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author 		Ajmal
 * 	
 * @Purpose: 	This class holds functions Top Navigation which is common across all the modules
 *  
 * @Date:		10/12/18
 * 
 * @ModificaitonHistory: 
 *
 */

public class TopNavigation extends Page{
	
	public TopNavigationLocators topNavigation;
	
	public TopNavigation(WebDriver driver){
		
		this.topNavigation = new TopNavigationLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,5);
		PageFactory.initElements(factory, this.topNavigation);
	
		
	}

	public void gotoSignIn(){
		click(topNavigation.account);
		click(topNavigation.LogoutBtn);
	}
	

	public void gotoLogOut(){
		test.log(LogStatus.INFO, "Logout from the application.");
		click(topNavigation.account);
		Utilities.waitForJSAndJQToLoad();
		wait.until(ExpectedConditions.visibilityOf(topNavigation.LogoutBtn));
		//Page.click(topNavigation.LogoutBtn);
		Utilities.HoverAndClick(topNavigation.LogoutBtn);
	}
	

}
