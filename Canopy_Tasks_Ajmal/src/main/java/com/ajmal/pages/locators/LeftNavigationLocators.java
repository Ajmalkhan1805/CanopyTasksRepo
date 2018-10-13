package com.ajmal.pages.locators;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * @author 		Ajmal
 * 	
 * @Purpose: 	To define locators of Left Navigation objects
 *  
 * @Date:		10/12/18
 * 
 * @ModificaitonHistory: 
 *
 */
public class LeftNavigationLocators {
	
	//REPORTS Selection
	@FindBy(xpath="//span[contains(text(),'REPORTS')]")
	public WebElement reports;
	
	//Reports Template Design 
	@FindBy(xpath="//span[contains(text(),'Reports Templates Design')]")
	public WebElement reportsTemplatesDesign;
	
	
	//User Accounts
	@FindBy(xpath="//a[@id='25']//span[contains(text(),'USER ACCOUNTS')]")
	public WebElement userAccounts;
	
	//Account Holdings
	@FindBy(xpath="//li[@id='menu_pb_active']//ul[@class='k-group k-panel']//li[3]//a/span[contains(text(),'Account Holdings')]")
	public WebElement accountHoldings;


}
