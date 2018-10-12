package com.ajmal.testcases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.ajmal.base.Page;
import com.ajmal.errorcollectors.ErrorCollector;
import com.ajmal.pages.actions.LeftNavigation;
import com.ajmal.pages.actions.ReportTemplateDesignPage;
import com.ajmal.pages.actions.SigninPage;
import com.ajmal.pages.actions.TopNavigation;
import com.ajmal.utilities.Utilities;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author ajimulkhan
 * @
 */
public class ReportsTest extends Page {
	
	@BeforeSuite
	public void setUp(){
		
		Page.initConfiguration();
	}
	
	
	@Test(priority = 0)
	public void createReportTemplateTest() throws Exception {
		String TemplateName = Utilities.WriteProperties();
		String actualStatus = "";
		
		test.log(LogStatus.INFO, "Step 1: Login to the application url using the mentioned credentials", "");
		SigninPage signin = new SigninPage();
		signin.doLogin();
		
		test.log(LogStatus.INFO, "Step 2: From the left navigation bar, go to menu \"Reports\".", "");
		test.log(LogStatus.INFO, "Step 3: Under \"Reports\" menu, go to sub-menu \"Reports Templates Design\".", "");
		LeftNavigation  reports = new LeftNavigation();
		reports.gotoReportsTemplateDesign();
		
		
		test.log(LogStatus.INFO, "Step 4: Click on \"Create\" button", "");
		ReportTemplateDesignPage designPage = new ReportTemplateDesignPage();
		designPage.goToCreateTeplate();
		
		
		test.log(LogStatus.INFO, "Step 5: On the pop-up, enter any unique Name, choose Style template as \"BaseTemplateDL\" and click on \"Save\".", "");
		designPage.enterTemplateName(TemplateName);
		designPage.selectStyleTemplate();
		designPage.saveReportTemplate();
		//designPage.saveTemplate();
		
		test.log(LogStatus.INFO, "Step 6: In the table, in the Name column, enter the unique report template name that you had previously given in Step 5.", "");
		designPage.searchTemplate(TemplateName);
		
		test.log(LogStatus.INFO, "Step 7: Validate that the template created by you is present in the table.", "Actual result matches with expected result as "+TemplateName);
		actualStatus = designPage.resultantTemplateName();
		ErrorCollector.validateResults(actualStatus, TemplateName);
		test.log(LogStatus.INFO, "Expected Template: "+TemplateName, "");
		test.log(LogStatus.INFO, "Actual Template  : "+actualStatus, "");
		
		test.log(LogStatus.INFO, "Step 8: Logout from the application.", "");
		TopNavigation  logout = new TopNavigation(driver);
		logout.gotoLogOut();
	}
	
	
	@Test(priority = 1, dependsOnMethods = { "createReportTemplateTest"})
	public void editReportTemplateTest() throws Exception {
		
		String TemplateName = Utilities.CanopyDataReader("TemplateName");
		String actualStatus = "";
		
		test.log(LogStatus.INFO, "Step 1: Login to the application url using the mentioned credentials", "");
		SigninPage signin = new SigninPage();
		signin.doLogin();
		
		test.log(LogStatus.INFO, "Step 2: From the left navigation bar, go to menu \"Reports\".", "");
		LeftNavigation  reports = new LeftNavigation();
		test.log(LogStatus.INFO, "Step 3: Under \"Reports\" menu, go to sub-menu \"Reports Templates Design\".", "");
		reports.gotoReportsTemplateDesign();
		
		test.log(LogStatus.INFO, "Step 4: Select the template that you have created in scenario 1.", "scenario 1: Create Report Template");
		ReportTemplateDesignPage designPage = new ReportTemplateDesignPage();
		test.log(LogStatus.INFO, "Step 5: Click on the edit template icon", "");
		designPage.goToEditTemplate(TemplateName);
		
		test.log(LogStatus.INFO, "Step 6: On the pop-up, edit the status to \"Ready to Assign\" and click on \"Save\"", "");
		designPage.selectReadyToAssignOption();
		designPage.saveReportTemplate();
		
		actualStatus = designPage.checkTemplateStatus(TemplateName);
		test.log(LogStatus.INFO, "Step 7: Validate that the Status of template in the table changes to \"Ready to Assign\"", "");
		ErrorCollector.validateResults(actualStatus, "Ready To Assign");
		test.log(LogStatus.INFO, "Expected status: Ready To Assign", "");
		test.log(LogStatus.INFO, "Actual Status  : "+actualStatus+"", "");
		
		test.log(LogStatus.INFO, "Step 8: Logout from the application.", "");
		TopNavigation  logout = new TopNavigation(driver);
		logout.gotoLogOut();
	}	
	
	
	

	@Test(priority = 2 , dependsOnMethods = { "editReportTemplateTest"})
	public void copyReportTemplateTest() throws Exception {
		
		String TemplateName = Utilities.CanopyDataReader("TemplateName");
		String CopyTemplateName = Utilities.TemplateName();
		String actualStatus = "";
		
		test.log(LogStatus.INFO, "Step 1: Login to the application url using the mentioned credentials", "");
		SigninPage signin = new SigninPage();
		signin.doLogin();
		
		test.log(LogStatus.INFO, "Step 2: From the left navigation bar, go to menu \"Reports\".", "");
		LeftNavigation  reports = new LeftNavigation();
		test.log(LogStatus.INFO, "Step 3: Under \"Reports\" menu, go to sub-menu \"Reports Templates Design\".", "");
		reports.gotoReportsTemplateDesign();
		
		
		test.log(LogStatus.INFO, "Step 4: Select the template that you have created in scenario 1.", "scenario 1: Create Report Template");
		ReportTemplateDesignPage designPage = new ReportTemplateDesignPage();
		test.log(LogStatus.INFO, "Step 5: Click on the copy template icon", "");
		designPage.goToCopyTemplate(TemplateName);
		
		test.log(LogStatus.INFO, "Step 6: On the pop-up, enter unique Report Template Name and click on \"Save\".", "");
		designPage.enterTemplateName(CopyTemplateName);
		designPage.saveReportTemplate();
		
		actualStatus = designPage.lookforTemplate(CopyTemplateName);
		Utilities.UpdatePorperties("CopiedTemplateName", CopyTemplateName);
		test.log(LogStatus.INFO, "Step 7: Validate that the template copy created by you in Step 6 is present in the table.", "");
		ErrorCollector.validateResults(actualStatus, CopyTemplateName);
		test.log(LogStatus.INFO, "Expected Template Name: "+CopyTemplateName, "");
		test.log(LogStatus.INFO, "Actual Template Name: "+actualStatus+"", "");
		
		test.log(LogStatus.INFO, "Step 8: Logout from the application.", "");
		TopNavigation  logout = new TopNavigation(driver);
		logout.gotoLogOut();
	}
	
	
	
	@Test(priority = 3, dependsOnMethods = { "copyReportTemplateTest"})
	public void deleteReportTemplateTest() throws Exception {
		
		String newTemplateName = Utilities.CanopyDataReader("TemplateName");
		String copiedTemplateName = Utilities.CanopyDataReader("CopiedTemplateName");
		String actualStatus = "";
		
		test.log(LogStatus.INFO, "Step 1: Login to the application url using the mentioned credentials", "");
		SigninPage signin = new SigninPage();

		signin.doLogin();
		
		test.log(LogStatus.INFO, "Step 2: From the left navigation bar, go to menu \"Reports\".", "");
		LeftNavigation  reports = new LeftNavigation();
		test.log(LogStatus.INFO, "Step 3: Under \"Reports\" menu, go to sub-menu \"Reports Templates Design\".", "");
		reports.gotoReportsTemplateDesign();
		
		
		test.log(LogStatus.INFO, "Step 4: Select the two templates created in scenario 1 and scenario 3","");
		ReportTemplateDesignPage designPage = new ReportTemplateDesignPage();
		designPage.SelectTemplate(newTemplateName);
		designPage.SelectTemplate(copiedTemplateName);
		
		test.log(LogStatus.INFO, "Step 5: Click on the delete button. Click \"Ok\" to confirm.", "");
		designPage.DeleteSelectedTemplates();
		designPage.Confirm();

		test.log(LogStatus.INFO, "Step 6: Validate that the two templates created by you are no longer present in the table.", "");
		actualStatus = designPage.VerifyDeletion(newTemplateName);
		test.log(LogStatus.INFO, "Given Template Name : "+newTemplateName, "");
		ErrorCollector.validateResults(actualStatus, "No records available");
		
		actualStatus = designPage.VerifyDeletion(copiedTemplateName);
		test.log(LogStatus.INFO, "Given Template Name : "+copiedTemplateName, "");
		ErrorCollector.validateResults(actualStatus, "No records available");
		
		test.log(LogStatus.INFO, "Step 7: Logout from the application.", "");
		TopNavigation  logout = new TopNavigation(driver);
		logout.gotoLogOut();
	}	
	
	

	@AfterSuite
	public void tearDown(){
		Page.quitBrowser();
	}




}
