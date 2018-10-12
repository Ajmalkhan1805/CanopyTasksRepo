package com.ajmal.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author ajimulkhan
 * @Desc Log in Page locators
 */
public class SigninPageLocators {
	
	@FindBy(name="username")
	public WebElement username;
	@FindBy(name="password")
	public WebElement password;
	@FindBy(xpath="//button[@value='/']")
	public WebElement login;

}
