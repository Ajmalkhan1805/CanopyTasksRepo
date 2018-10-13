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
 * @author 		Ajmal
 * 	
 * @Purpose: 	To verify Add, Edit, Copy and delete features of Report Template Design module
 *  
 * @Date:		10/12/18
 * 
 * @ModificaitonHistory: 
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
		SigninPage signin = new SigninPage();
		LeftNavigation  reports = new LeftNavigation();
		ReportTemplateDesignPage designPage = new ReportTemplateDesignPage();
		TopNavigation  logout = new TopNavigation(driver);
		
		// Test Starts Here
		signin.doLogin();
		reports.gotoReportsTemplateDesign();
		designPage.goToCreateTeplate();
		designPage.enterTemplateName(TemplateName);
		designPage.selectStyleTemplate();
		designPage.selectBaseTemplateDL();
		designPage.saveReportTemplate();
		designPage.searchTemplate(TemplateName);
		actualStatus = designPage.resultantTemplateName();
		ErrorCollector.validateResults(actualStatus, TemplateName);
		test.log(LogStatus.INFO, "Expected Template: "+TemplateName);
		test.log(LogStatus.INFO, "Actual Template  : "+actualStatus);
		logout.gotoLogOut();
	}
	
	
	@Test(priority = 1, dependsOnMethods = { "createReportTemplateTest"})
	public void editReportTemplateTest() throws Exception {
		
		String TemplateName = Utilities.CanopyDataReader("TemplateName");
		SigninPage signin = new SigninPage();
		LeftNavigation  reports = new LeftNavigation();
		ReportTemplateDesignPage designPage = new ReportTemplateDesignPage();
		TopNavigation  logout = new TopNavigation(driver);
		
		// Test Starts Here
		signin.doLogin();
		reports.gotoReportsTemplateDesign();
		designPage.goToEditTemplate(TemplateName);
		designPage.selectReadyToAssignOption();
		designPage.saveReportTemplate();
		designPage.VerifyTemplateStatus(TemplateName);
		logout.gotoLogOut();
	}	
	
	
	

	@Test(priority = 2 , dependsOnMethods = { "editReportTemplateTest"})
	public void copyReportTemplateTest() throws Exception {
		
		String TemplateName = Utilities.CanopyDataReader("TemplateName");
		String CopyTemplateName = Utilities.TemplateName();
		String actualStatus = "";
		SigninPage signin = new SigninPage();
		LeftNavigation  reports = new LeftNavigation();
		ReportTemplateDesignPage designPage = new ReportTemplateDesignPage();
		TopNavigation  logout = new TopNavigation(driver);
		
		// Test Starts Here
		signin.doLogin();
		reports.gotoReportsTemplateDesign();
		designPage.goToCopyTemplate(TemplateName);
		designPage.enterTemplateName(CopyTemplateName);
		designPage.saveReportTemplate();
		
		actualStatus = designPage.lookforTemplate(CopyTemplateName);
		Utilities.UpdatePorperties("CopiedTemplateName", CopyTemplateName);
		test.log(LogStatus.INFO, "Validate that the template copy created by you in Step 6 is present in the table.");
		ErrorCollector.validateResults(actualStatus, CopyTemplateName);
		test.log(LogStatus.INFO, "Expected Template Name: "+CopyTemplateName);
		test.log(LogStatus.INFO, "Actual Template Name: "+actualStatus+"");
		logout.gotoLogOut();
	}
	
	
	
	@Test(priority = 3, dependsOnMethods = { "copyReportTemplateTest"})
	public void deleteReportTemplateTest() throws Exception {
		
		String newTemplateName = Utilities.CanopyDataReader("TemplateName");
		String copiedTemplateName = Utilities.CanopyDataReader("CopiedTemplateName");
		String actualStatus = "";
		SigninPage signin = new SigninPage();
		LeftNavigation  reports = new LeftNavigation();
		ReportTemplateDesignPage designPage = new ReportTemplateDesignPage();
		TopNavigation  logout = new TopNavigation(driver);
		
		// Test Starts Here
		signin.doLogin();
		reports.gotoReportsTemplateDesign();
		designPage.SelectTemplate(newTemplateName);
		designPage.SelectTemplate(copiedTemplateName);
		designPage.DeleteSelectedTemplates();
		designPage.Confirm();

		test.log(LogStatus.INFO, "Validate that the two templates created by you are no longer present in the table.");
		actualStatus = designPage.VerifyDeletion(newTemplateName);
		test.log(LogStatus.INFO, "Given Template Name : "+newTemplateName);
		ErrorCollector.validateResults(actualStatus, "No records available");
		
		actualStatus = designPage.VerifyDeletion(copiedTemplateName);
		test.log(LogStatus.INFO, "Given Template Name : "+copiedTemplateName);
		ErrorCollector.validateResults(actualStatus, "No records available");
		logout.gotoLogOut();
	}	
	
	@AfterSuite
	public void tearDown(){
		Page.quitBrowser();
	}
	

}
