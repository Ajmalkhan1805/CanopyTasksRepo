package com.ajmal.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ajmal.base.Constants;
import com.ajmal.base.Page;
import com.ajmal.pages.locators.SigninPageLocators;
import com.ajmal.pages.locators.TopNavigationLocators;
import com.ajmal.utilities.Utilities;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author 		Ajmal
 * 	
 * @Purpose: 	To do login and verify login
 *  
 * @Date:		10/12/18
 * 
 * @ModificaitonHistory: 
 *
 */

public class SigninPage extends Page {
	
	public static SigninPageLocators signinPage;
	public TopNavigationLocators topNavigaiton;
	

	
	public SigninPage(){
		
		this.signinPage = new SigninPageLocators();
		this.topNavigaiton = new TopNavigationLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.signinPage);
		PageFactory.initElements(factory, this.topNavigaiton);
		
	}
	
	
	public void doLogin(){
		test.log(LogStatus.INFO, "Login to the application url using the mentioned credentials");
		Utilities.waitForJSAndJQToLoad();
		type(signinPage.username,Constants.userName);
		type(signinPage.password,Constants.password);
		//click(signinPage.login);
		Utilities.HoverAndClick(signinPage.login);
		Utilities.waitForJSAndJQToLoad();
		Wait(topNavigaiton.account, 5);
		Assert.assertEquals(topNavigaiton.account.getText(),Constants.userName,"The user "+Constants.userName+" has not logged in");
	}

}
