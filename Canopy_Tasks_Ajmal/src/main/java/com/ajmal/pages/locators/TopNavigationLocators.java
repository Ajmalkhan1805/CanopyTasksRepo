package com.ajmal.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author 		Ajmal
 * 	
 * @Purpose: 	To define locators of Top navigation objects
 *  
 * @Date:		10/12/18
 * 
 * @ModificaitonHistory: 
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
