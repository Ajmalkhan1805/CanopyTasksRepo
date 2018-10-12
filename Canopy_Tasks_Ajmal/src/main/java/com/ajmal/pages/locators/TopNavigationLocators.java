package com.ajmal.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author 	Ajmal
 * @Desc 	Topnavigation is constant across all the pages of application. Hence, defined all here in one place.
 *
 */
public class TopNavigationLocators {

	/***Account***/
	@FindBy(id="lnkName")
	public WebElement account;
	
	/***Log out button***/
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-user']//*[@href='/Account/LogOff']")
	public WebElement LogoutBtn;
	
	
	
}
