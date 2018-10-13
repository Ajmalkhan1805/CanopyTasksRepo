package com.ajmal.testcases;

import org.testng.annotations.Test;
import com.ajmal.base.Page;
import com.ajmal.pages.actions.AccountHoldingsPage;
import com.ajmal.pages.actions.LeftNavigation;
import com.ajmal.pages.actions.SigninPage;
import com.ajmal.pages.actions.TopNavigation;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author 		Ajmal
 * 	
 * @Purpose: 	Test to validate Networth against sum of contract type headers
 *  
 * @Date:		10/12/18
 * 
 * @ModificaitonHistory: 
 */

public class AccountHoldingsTest extends Page {

	@Test
	public void calculateTotalNetworthTest() throws Exception {
		
		//Pages involved,
		SigninPage signin = new SigninPage();
		LeftNavigation  accounts = new LeftNavigation();
		AccountHoldingsPage AccountHoldingsPage = new AccountHoldingsPage();
		TopNavigation  logout = new TopNavigation(driver);
		
		/**Test steps Starts Here**/
		signin.doLogin();
		accounts.gotoAccountHoldings();
		AccountHoldingsPage.Select_ACDC4EVER_Account();
		AccountHoldingsPage.ApplyFilter();
		AccountHoldingsPage.VerifyNetworthisDisplayed();
		AccountHoldingsPage.VerifyCurrentValueUSDisDisplayed();
		test.log(LogStatus.INFO, "Highlighted Contract Headers: --> "+AccountHoldingsPage.GetHighlightedSections());
		AccountHoldingsPage.ValidateSumValueAgainstCurrentValueUSD(AccountHoldingsPage.GetCurrentValueUSD(), AccountHoldingsPage.GetTotalValueOfHighlightedSections());
		logout.gotoLogOut();
		/**End**/
		
	}	
	

}
