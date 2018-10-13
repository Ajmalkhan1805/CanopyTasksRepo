package com.ajmal.pages.actions;

import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ajmal.base.Page;
import com.ajmal.pages.locators.ReportTemplateDesignLocators;
import com.ajmal.utilities.Utilities;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author 		Ajmal
 * 	
 * @Purpose: 	This class holds functions of Report Template Design module
 *  
 * @Date:		10/12/18
 * 
 * @ModificaitonHistory: 
 *
 */

public class ReportTemplateDesignPage extends Page {
	
public ReportTemplateDesignLocators design;

	

	public ReportTemplateDesignPage(){
		
		this.design = new ReportTemplateDesignLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,5);
		PageFactory.initElements(factory, this.design);

	}
	
	
	public void goToCreateTeplate(){
		test.log(LogStatus.INFO, "Click on 'Create' button", "");
		click(design.createButton);
		
	}
	
	public void Confirm(){
		test.log(LogStatus.INFO, "Click 'Ok' to confirm.", "");
		Wait(design.okButton,5);
		click(design.okButton);
		wait.until(ExpectedConditions.elementToBeClickable(design.refreshLink));
		
	}

	public void Refresh(){
	
		wait.until(ExpectedConditions.elementToBeClickable(design.refreshLink));
		click(design.refreshLink);
		wait.until(ExpectedConditions.elementToBeClickable(design.refreshLink));
		
	}
	public String ConfirmMessage(){
		Wait(design.okButton,5);
		log.debug("Confirmation message"+design.confirmationMessage.getText());
		return design.confirmationMessage.getText();
	}

	public void searchTemplate(String TemplateName){
		test.log(LogStatus.INFO, "In the table, in the Name column, enter the unique report template name that you had previously given.", "");
		type(design.nameOfTemplate,TemplateName );
		design.nameOfTemplate.sendKeys(Keys.ENTER);
		
	}
	
	
	public void DeleteSelectedTemplates(){
		test.log(LogStatus.INFO, "Click on the delete button", "");
		click(design.deleteButton);
		test.log(LogStatus.INFO, "Click on the delete button", "");
	}
	
	public void enterTemplateName(String TemplateName){
		design.nameOfTemplatePopup.clear();
		type(design.nameOfTemplatePopup,TemplateName);
		design.nameLabel.click();
	}

	
	public void selectStyleTemplate(){
		
		test.log(LogStatus.INFO, "On the pop-up, enter any unique Name, choose Style template ", "");
		click(design.typeOfTemplate);
		 Utilities.waitFor(1000);
		//click(design.styleTemplate); --> It works but takes time, so replacing this with below code
		type(design.filterInput, "Style template");	
		 Utilities.waitFor(2000);
		design.filterInput.sendKeys(Keys.TAB);
	}
	
	
	public void selectBaseTemplateDL(){
		
		test.log(LogStatus.INFO, "Select Base Template DL", "");
		click(design.chooseStyleTemplateDropdown);	
		Utilities.waitFor(1000);
		click(design.baseTemplateDL);
	}
	
	public void saveReportTemplate(){
		test.log(LogStatus.INFO, "Save template", "");
		wait.until(ExpectedConditions.elementToBeClickable(design.saveButton));
		click(design.saveButton);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h3[@data-bind='text: header']")));
	}
	
	public void simpleClickOnStatusLabel(){
		click(design.statusLabel);
		
	}
	
	public void saveTemplate(){
		wait.until(ExpectedConditions.elementToBeClickable(design.saveButton));
		Utilities.HoverAndClick(design.saveButton);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h3[@data-bind='text: header']")));
	}
	
	
	public void selectReadyToAssignOption(){
		test.log(LogStatus.INFO, "On the pop-up, edit the status to 'Ready to Assign' and click on 'Save'", "");
		wait.until(ExpectedConditions.visibilityOf(design.statusSelectionArrow));
		click(design.statusSelectionArrow);
		Utilities.waitFor(2000);
		wait.until(ExpectedConditions.visibilityOf(design.readyToAssignOption));
		click(design.readyToAssignOption);
		robt.keyPress(KeyEvent.VK_TAB);
		robt.keyRelease(KeyEvent.VK_TAB);
		
	}
	
	public String resultantTemplateName(){
		
		boolean elementPresent = design.searchedTemplateName.isDisplayed();
		
		if (elementPresent){
			log.debug("resultant template name -- "+elementPresent);
		return design.searchedTemplateName.getText();
		}else {
			log.debug("Template unavailable");
			return "Template unavailable";
		}
		
	}
		
	
	public String resultantTemplateOwner(){
		
	boolean elementPresent = design.searchedTemplateName.isDisplayed();
		
		if (elementPresent){
			log.debug("Template created by user : "+design.searchedNameOfOwner.getText());
			return design.searchedNameOfOwner.getText();
		}else {
			log.debug("User not found");
			return "owner name is not available";
		}
		}
	
	//Edit Template
	public void goToEditTemplate(String TempName){
		test.log(LogStatus.INFO, "Click on the edit template icon", "");
		wait.until(ExpectedConditions.visibilityOf(design.templatesGrid));
		List<WebElement> rows_table = design.templatesGrid.findElements(By.tagName("tr"));
	    
	    for (int row=0; row<rows_table.size(); row++){
	      	
	      	List<WebElement> Col_row = rows_table.get(row).findElements(By.tagName("td"));
	      	
	      	for (int column=0; column<Col_row.size(); column++){
	      		
	      		  String celtext = Col_row.get(column).getText();

	      		  if (celtext.equalsIgnoreCase(TempName)) {
	      			  int rowVal = row+1;
	      			  int colVal = column;
	      			  log.debug("Template found at row "+rowVal+"in a table");
	      			  driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/section[1]/reporting-manage-component[1]/section[1]/div[1]/div[5]/table[1]/tbody[1]/tr["+rowVal+"]/td["+colVal+"]/a[1]")).click();
	      			  break;
					}
	      		else
	      		{
	      			log.debug("Template not found");
	      		}
	      	}
	      	
	      }
		
	}
	
	
	//Copy Template
	public void goToCopyTemplate(String TempName){
		test.log(LogStatus.INFO, "Click on the copy template icon", "");
		wait.until(ExpectedConditions.visibilityOf(design.templatesGrid));
		List<WebElement> rows_table = design.templatesGrid.findElements(By.tagName("tr"));
	    
	    for (int row=0; row<rows_table.size(); row++){
	      	
	      	List<WebElement> Col_row = rows_table.get(row).findElements(By.tagName("td"));
	      	
	      	for (int column=0; column<Col_row.size(); column++){
	      		
	      		  String celtext = Col_row.get(column).getText();

	      		  if (celtext.equalsIgnoreCase(TempName)) {
	      			  int rowVal = row+1;
	      			log.debug("Template found at row "+rowVal+"in a table");
	      			  driver.findElement(By.xpath("//tr["+rowVal+"]//span[@class='k-icon k-i-copy']")).click();
	      			  break;
					}
	      		else
	      		{
	      			log.debug("Template not found");
	      		}
	      	}
	      	
	      }
		
	}
	
	
	//To Verify Template Status 
	public String checkTemplateStatus(String TempName) throws Exception{
		String statusOfTemplate = "";
		List<WebElement> rows_table = design.templatesGrid.findElements(By.tagName("tr"));
	    for (int row=0; row<rows_table.size(); row++){
	      	List<WebElement> Col_row = rows_table.get(row).findElements(By.tagName("td"));
	      	for (int column=0; column<Col_row.size(); column++){
	      		String celtext = Col_row.get(column).getText();
	      		if (celtext.equalsIgnoreCase(TempName)) {
      			  int rowVal = row+1;
      			  statusOfTemplate = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/section[1]/reporting-manage-component[1]/section[1]/div[1]/div[5]/table[1]/tbody[1]/tr["+rowVal+"]/td[8]")).getText();
      			  break;
					}
	      		else
	      		{
	      			log.debug("Template not found");
	      			return "Template not found";
	      			
	      		}
	      	}
	      	
	      }
	    return statusOfTemplate;
	}
	
	
	//Search for a template in Grid
	public String lookforTemplate(String TempName){
		Utilities.waitForJSAndJQToLoad();
		WebElement element =  driver.findElement(By.xpath("//table[@class='k-selectable']//td[contains(text(),'"+TempName+"')]"));
		boolean isTemplatePresent = element.isDisplayed();
		
		if (isTemplatePresent){
			log.debug(element.getText());
			return element.getText();
		}
		else {
			log.debug("Template is not available");
			return "Template is not available";
		}
	}
	
	
	public void SelectTemplate(String TemplateName){
		test.log(LogStatus.INFO, "Select the template :--> "+TemplateName,"");
		wait.until(ExpectedConditions.visibilityOf(design.templatesGrid));
		List<WebElement> rows_table = design.templatesGrid.findElements(By.tagName("tr"));
	    for (int row=0; row<rows_table.size(); row++){
	      	List<WebElement> Col_row = rows_table.get(row).findElements(By.tagName("td"));
	      	for (int column=0; column<Col_row.size(); column++){
	      		String celtext = Col_row.get(column).getText();
	      		if (celtext.equalsIgnoreCase(TemplateName)) {
      			  int rowVal = row+1;
      			  driver.findElement(By.xpath("//tbody[@role='rowgroup']//tr["+rowVal+"]//input[@type='checkbox']")).click();
      			log.debug("Selected template at row -->>"+rowVal);
      			test.log(LogStatus.INFO, "Selected template at row -->>"+rowVal, "");
      			  break;
					}
	      	}
	      	
	      }
	    }
	
	public String VerifyDeletion(String TemplateName){
		searchTemplate(TemplateName);	
		if (design.noRecordsAvailable.isDisplayed()){
			log.debug("No records available");
  			test.log(LogStatus.INFO, "No records available", "");
    		return "No records available";
		}else{
			log.debug("Records found");
  			test.log(LogStatus.INFO, "Records found", "");
			return "Records found";
		}
		
	}
	
	
	

	

	

}
