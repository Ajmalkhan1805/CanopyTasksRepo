package com.ajmal.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import com.ajmal.base.Page;
import com.ajmal.pages.locators.LeftNavigationLocators;
import com.ajmal.utilities.Utilities;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author 		Ajmal
 * 	
 * @Purpose: 	This class holds functions Left Navigation which is common across all the modules
 *  
 * @Date:		10/12/18
 * 
 * @ModificaitonHistory: 
 *
 */


public class LeftNavigation extends Page {

	public LeftNavigationLocators leftNavigation;
	
	public LeftNavigation(){
		
		this.leftNavigation = new LeftNavigationLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,5);
		PageFactory.initElements(factory, this.leftNavigation);
		
	}
	

	public void gotoReportsTemplateDesign(){
		test.log(LogStatus.INFO, "From the left navigation bar, go to menu 'Reports'.");
		test.log(LogStatus.INFO, "Under 'Reports' menu, go to sub-menu 'Reports Templates Design'.");
		Utilities.waitForJSAndJQToLoad();
		Wait(leftNavigation.reports, 5);
		Page.click(leftNavigation.reports);
		Page.click(leftNavigation.reportsTemplatesDesign);
	}
	
	
	public void gotoAccountHoldings(){
		Utilities.waitForJSAndJQToLoad();
		test.log(LogStatus.INFO, "From the left navigation bar, go to menu 'User Accounts'.");
		Page.click(leftNavigation.userAccounts);
		test.log(LogStatus.INFO, "Under 'Reports' menu, go to sub-menu 'Account Holdings'.");
		Utilities.HoverAndClick(leftNavigation.accountHoldings);
		//Page.click(leftNavigation.accountHoldings);
	}
	
}
