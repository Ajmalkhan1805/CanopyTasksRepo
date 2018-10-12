package com.ajmal.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import com.ajmal.base.Page;
import com.ajmal.pages.locators.LeftNavigationLocators;
import com.ajmal.utilities.Utilities;

public class LeftNavigation extends Page {

	public LeftNavigationLocators leftNavigation;
	
	public LeftNavigation(){
		
		this.leftNavigation = new LeftNavigationLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,5);
		PageFactory.initElements(factory, this.leftNavigation);
		
	}
	

	public void gotoReportsTemplateDesign(){
		Utilities.waitForJSAndJQToLoad();
		Wait(leftNavigation.reports, 5);
		Page.click(leftNavigation.reports);
		Page.click(leftNavigation.reportsTemplatesDesign);
	}
	
	
	public void gotoAccountHoldings(){
		Utilities.waitForJSAndJQToLoad();
		Page.click(leftNavigation.userAccounts);
		Utilities.HoverAndClick(leftNavigation.accountHoldings);
		//Page.click(leftNavigation.accountHoldings);
	}
	
}
