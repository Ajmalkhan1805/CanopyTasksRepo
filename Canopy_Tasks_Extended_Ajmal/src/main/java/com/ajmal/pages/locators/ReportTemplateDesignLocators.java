package com.ajmal.pages.locators;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author 		Ajmal
 * 	
 * @Purpose: 	To define locators of Report Template design Page
 *  
 * @Date:		10/12/18
 * 
 * @ModificaitonHistory: 
 *
 */

public class ReportTemplateDesignLocators {
	
		//Create Button
		@FindBy(xpath="/html/body/div[1]/div[1]/section/div/div[2]/div/section//reporting-manage-component/section/div/div[1]/div/a[1]")
		public WebElement createButton;

		//public static By templateName = By.xpath("//table[@class='k-selectable']//td[contains(text(),'"+TempName+"')]");
		
		//Grid: Name Field
		@FindBy(xpath="/html/body/div[1]/div[1]/section/div/div[2]/div/section/reporting-manage-component/section/div/div[4]/div/table/thead[1]/tr[2]/th[5]/span/span/span/input")
		public WebElement nameOfTemplate;
		
		//Grid: Desc Field
		@FindBy(xpath="//thead[@class='tableFloatingHeaderOriginal']//tr[@class='k-filter-row']//th[6]//span[1]//span[1]//span[1]//input[1]")
		public WebElement descriptionValue;
		
		//Result Grid: Name Field
		@FindBy(xpath="//table[@class='k-selectable']/tbody[1]/tr[3]/td[5]")
		public WebElement searchedTemplateName;

		//Grid: Owner
		@FindBy(xpath="/html/body/div[1]/div[1]/section/div/div[2]/div/section/reporting-manage-component/section/div/div[5]/table/tbody/tr[3]/td[7]")
		public WebElement searchedNameOfOwner;
		
		//Grid: Type
		@FindBy(xpath="/html/body/div[1]/div[1]/section/div/div[2]/div/section/reporting-manage-component/section/div/div[5]/table/tbody/tr[3]/td[9]")
		public WebElement searchedTypeOfTemplate;
		
		
		//Grid: Templates
		@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/section[1]/reporting-manage-component[1]/section[1]/div[1]/div[5]/table[1]")
		public WebElement templatesGrid;
		
		//Grid: MyTemplates Label
		@FindBy(xpath="//tbody[@role='rowgroup']//tr[1]//td[1]//p[1]")
		public WebElement myTemplatesLabel;
		
		
		////a[@class='k-button k-grid-deleteReport grid-delete-button']//span[@class='k-icon k-i-delete']
		@FindBy(xpath="//a[@class='k-button k-grid-deleteReport grid-delete-button']//span[@class='k-icon k-i-delete']")
		public WebElement deleteButton;
		
		
		//OK Button Confirm Popup
		@FindBy(xpath="//button[@data-bb-handler='confirm']")
		public WebElement okButton;
		

		//Modal Message
		@FindBy(xpath="//div[@class='bootbox-body']")
		public WebElement confirmationMessage;
		
		//Modal Message
		@FindBy(xpath="//div[@data-role='pager'][1]//a[@href='#'][@title='Refresh']")
		public WebElement refreshLink;
		
		//Loading Mask
		@FindBy(xpath="//div[@class='k-loading-mask']")
		public WebElement loadingMask;

		
		//No Records Available
		@FindBy(xpath="//div[@class='k-grid-norecords-template'][contains(text(),'No records available.')]")
		public WebElement noRecordsAvailable;
		
	//*********************************Add Popup********************************************
		
		//Name
		@FindBy(xpath="//*[@id='reportName']")
		public WebElement nameOfTemplatePopup;
		
		//Type
		//@FindBy(xpath="/html/body/div[26]/div/div/form/div[2]/div/div[5]/div/span/span/span[1]")
		@FindBy(xpath="//div[1]/div[1]/form[1]/div[2]/div[1]/div[5]/div[1]/span[1]/span[1]")
		public WebElement typeOfTemplate;
		
		//Style Template
		@FindBy(xpath="//div[@id='reportTypes-list']//li[@class='k-item'][contains(text(),'Style Template')]")
		public WebElement styleTemplate;
		
		//Save Button // -->Abs--> /html/body/div[26]/div/div/form/div[1]/div[4]/button
		@FindBy(xpath="//button[@type='button'][contains(text(),'Save')]")
		public WebElement saveButton;
		
		//
		//Status label
		@FindBy(xpath="//label[@class='control-label col-sm-2'][contains(text(),'Status')]")
		public WebElement statusLabel;
		
		
		@FindBy(xpath="//label[@class='control-label col-sm-2'][@for='reportName'][contains(text(),'Name')]")
		public WebElement nameLabel;
		
		//Input
		@FindBy(xpath="//div[@id='reportTypes-list']//input[@class='k-textbox']")
		public WebElement filterInput;


		//Input
		@FindBy(xpath="//li[text()='BaseTemplateDL' and @class='k-item']")
		public WebElement baseTemplateDL;
		
		//Input
		@FindBy(xpath="//span[contains(text(),'Choose style template...')]")
		public WebElement chooseStyleTemplateDropdown;

		@FindBy(xpath="//div[@id='baseReports-list']//span[1]//input[1][ not (contains(@aria-busy, 'false'))]")
		public WebElement filterInputStyleTemplate;
		//div[@id='baseReports-list']//input[@class='k-textbox']
		
	//******************************Edit Popup***********************************************
		//Name
		@FindBy(xpath="//div[@class='form-horizontal']//div[6]//div[1]//span[1]//span[1]//span[2]")
		public WebElement statusSelectionArrow;
		
		//Ready To Assign
		@FindBy(xpath="//div[1]//div[2]//ul[1]//li[3][@data-offset-index='2'][contains(text(),'Ready To Assign')]")
		public WebElement readyToAssignOption;
		

		
		
		

		
	
}
