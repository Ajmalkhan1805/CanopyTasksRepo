package com.ajmal.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author 		Ajmal
 * 	
 * @Purpose: 	To define locators of Log In Page
 *  
 * @Date:		10/12/18
 * 
 * @ModificaitonHistory: 
 *
 */
public class SigninPageLocators {
	
	@FindBy(name="username")
	public WebElement username;
	@FindBy(name="password")
	public WebElement password;
	@FindBy(xpath="//button[@value='/']")
	public WebElement login;

}
