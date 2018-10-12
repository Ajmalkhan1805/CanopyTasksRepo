package com.ajmal.pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ajmal.base.Page;
import com.ajmal.pages.locators.TopNavigationLocators;
import com.ajmal.utilities.Utilities;

public class TopNavigation extends Page{
	
	public TopNavigationLocators topNavigation;
	
	public TopNavigation(WebDriver driver){
		
		this.topNavigation = new TopNavigationLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,5);
		PageFactory.initElements(factory, this.topNavigation);
	
		
	}

	public void gotoSignIn(){
		
		Page.click(topNavigation.account);
		Page.click(topNavigation.LogoutBtn);
	}
	

	public void gotoLogOut(){
		
		Page.click(topNavigation.account);
		Utilities.waitForJSAndJQToLoad();
		wait.until(ExpectedConditions.visibilityOf(topNavigation.LogoutBtn));
		//Page.click(topNavigation.LogoutBtn);
		Utilities.HoverAndClick(topNavigation.LogoutBtn);
	}
	

}
