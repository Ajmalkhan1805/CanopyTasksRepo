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
		
		test.log(LogStatus.INFO, "Step 1: Login to the application url using the mentioned credentials");
		SigninPage signin = new SigninPage();
		signin.doLogin();
		
		test.log(LogStatus.INFO, "Step 2: From the left navigation bar, go to menu 'User Accounts'.");
		LeftNavigation  accounts = new LeftNavigation();
		
		test.log(LogStatus.INFO, "Step 3: Under 'User Accounts' menu, go to sub-menu 'Account Holdings'.");
		accounts.gotoAccountHoldings();
		
		test.log(LogStatus.INFO, "Step 4: Select the account as 'acdc4ever'. Click on Apply Filters.");
		AccountHoldingsPage AccountHoldingsPage = new AccountHoldingsPage();
		AccountHoldingsPage.Select_ACDC4EVER_Account();
		AccountHoldingsPage.ApplyFilter();
		
		test.log(LogStatus.INFO, "Step 5: Validate that total networth 'Current Value USD' from the summary div 'Networth as of date' is shown on the page.");
		AccountHoldingsPage.VerifyNetworthisDisplayed();
		AccountHoldingsPage.VerifyCurrentValueUSDisDisplayed();

		test.log(LogStatus.INFO, "Step 6: Expand each of the contract type headers (highlighted in blue), take the 'Total' mentioned in bold under each one of them and sum up the values.");
		test.log(LogStatus.INFO, "Highlighted Sections: --> "+AccountHoldingsPage.GetHighlightedSections());
		
		test.log(LogStatus.INFO, "Step 7: Validate that the values in Step 5 and Step 6 are equal.");
		AccountHoldingsPage.ValidateSumValueAgainstCurrentValueUSD(AccountHoldingsPage.GetCurrentValueUSD(), AccountHoldingsPage.GetTotalValueOfHighlightedSections());
		
		test.log(LogStatus.INFO, "Step 8: Logout from the application.");
		TopNavigation  logout = new TopNavigation(driver);
		logout.gotoLogOut();
	}	
	

}
