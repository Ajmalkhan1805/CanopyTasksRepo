package com.ajmal.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author ajimulkhan
 * @Desc   Account Holding Page Locators using 'FindBy'
 */
public class AccountHoldingsPageLocators {
	
	//Please Select Account
	@FindBy(xpath="//input[@class='k-input k-readonly']")
	public WebElement accountField;
	
	//account
	@FindBy(xpath="//li[contains(text(),'acdc4ever (335)')]")
	public WebElement acdc4everAccount;
	
	
	//Apply Filters
	@FindBy(xpath="//button[@type='submit']")
	public WebElement applyFiltersButton;
	
	//Networth Label
	@FindBy(xpath="//legend[@class='legend']")
	public WebElement netWorthLegend;
	
	//Current Value
	@FindBy(xpath="//fieldset[1]/table[1]/tbody[1]/tr[1]/td[1]/span[1]")
	public WebElement currentValueUSD;
	
	//Current Value
	@FindBy(xpath="//div[@class='input-group-addon']//span[@class='glyphicon glyphicon-refresh glyphicon-refresh-animate']")
	public WebElement refreshIcon;
	
	
	//Current Value
	@FindBy(xpath="//td[@data-bind='text: baseCurrencyCode']")
	public WebElement currencyCode;
	

}
