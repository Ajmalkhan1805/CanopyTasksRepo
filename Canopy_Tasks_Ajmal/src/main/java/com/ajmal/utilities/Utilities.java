package com.ajmal.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.PropertiesConfigurationLayout;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.ajmal.base.Page;
/**
 * @author 		Ajmal
 * 	
 * @Purpose: 	This class holds functions of utilities
 *  
 * @Date:		10/12/18
 * 
 * @ModificaitonHistory: 
 */

public class Utilities extends Page {

	public static String screenshotPath;
	public static String screenshotName;

	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

	}

	@DataProvider(name="dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];
		
		Hashtable<String,String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String,String>();
			
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		return data;

	}
	
	
	public static boolean isTestRunnable(String testName, ExcelReader excel){
		
		String sheetName="test_suite";
		int rows = excel.getRowCount(sheetName);
		
		
		for(int rNum=2; rNum<=rows; rNum++){
			
			String testCase = excel.getCellData(sheetName, "TCID", rNum);
			
			if(testCase.equalsIgnoreCase(testName)){
				
				String runmode = excel.getCellData(sheetName, "Runmode", rNum);
				
				if(runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}
			
			
		}
		return false;
	}
	
	public boolean isAttribtuePresent(WebElement element, String attribute) {
	    Boolean result = false;
	    try {
	        String value = element.getAttribute(attribute);
	        if (value != null){
	            result = true;
	        }
	    } catch (Exception e) {}

	    return result;
	}
	
	public static String TemplateName() {
		
		return "Template"+UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	

	public static String WriteProperties() {
		
		final String TempName = TemplateName();
		try {
			Properties properties = new Properties();
			properties.setProperty("TemplateName", TempName);
			properties.setProperty("CopiedTemplateName", "");
			
			File file = new File(System.getProperty("user.dir") + "//src//test//resources//properties//CanopyData.properties");
			FileOutputStream fileOut = new FileOutputStream(file);
			properties.store(fileOut, "Canopy Data - Engine - Author: Ajmal");
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return TempName;
	
	}
	

	public static void UpdatePorperties(String key, String data) {
		
		File file = new File(System.getProperty("user.dir") + "//src//test//resources//properties//CanopyData.properties");
	    PropertiesConfiguration config = new PropertiesConfiguration();
	    PropertiesConfigurationLayout layout = new PropertiesConfigurationLayout(config);
	    try {
			layout.load(new InputStreamReader(new FileInputStream(file)));
		} catch (ConfigurationException e) {
			
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	    FileWriter fw = null;
		try {
			fw = new FileWriter(System.getProperty("user.dir") + "//src//test//resources//properties//CanopyData.properties",false);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	    config.setProperty(key, data);
	    try {
			layout.save(fw);
		} catch (ConfigurationException e) {
		
			e.printStackTrace();
		}
	    System.out.println("Done");
	
	}
	
	
	
	public static String CanopyDataReader(String propKey){
		Properties properties;
		BufferedReader reader;
		String path = System.getProperty("user.dir") + "//src//test//resources//properties//CanopyData.properties";
		try {
			FileInputStream ff = new FileInputStream(path);
			//reader = new BufferedReader(new FileReader(ff));
			properties = new Properties();
			try {
				properties.load(ff);
				ff.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + path);
		}		
		
		return properties.getProperty(propKey);
	}
	
	public static void HoverAndClick(WebElement element){
		action.moveToElement(element).click(element).build().perform();
	}
	
	
	public static void HoverAndEnterValues(WebElement element, String str) throws Exception{
		action.moveToElement(element);
		action.click();
		action.sendKeys(str);
		action.build().perform();
	}
	
	
	public static String[] dollarValueExtractor(String str){
	 	Pattern p = Pattern.compile("-?\\d+(,\\d+)*?\\.?\\d{2}");
	    List<String> numbers = new ArrayList<String>();
	    List<String> numbers1 = new ArrayList<String>();
	    Matcher m = p.matcher(str);
	    while (m.find()) {  
	        numbers.add(m.group());
	    }   
	    
	    for (int i = 0; i < numbers.size(); i++) {
	    	String b = numbers.get(i);
	    	String c = b.replace(",", "");
	    	numbers1.add(c);
		}
	   
	    String [] arrValues =  numbers1.toArray(new String[numbers1.size()]);
	    return arrValues;
    
	}
	

	
	public static String getTotalValue(String str){
		
		String[] a = dollarValueExtractor(str);
		BigDecimal sum = BigDecimal.ZERO;
		for (int i = 0; i < a.length; i++) 
		{	sum = sum.add(new BigDecimal(a[i]));  }
		return sum.toString();
		}
	
	
	public static String numberExtractor(String str){
	 	Pattern p = Pattern.compile("-?\\d+(,\\d+)*?\\.?\\d{2}");
	    List<String> numbers = new ArrayList<String>();
	    Matcher m = p.matcher(str);
	    
	    while (m.find()) {  
	        numbers.add(m.group());
	    }   
	    return (numbers.get(0)).replace(",", "");
	 	}
	
	public static boolean verifyElementPresent(WebElement elemt) {
		StackTraceElement caller = new Throwable().getStackTrace()[1];
		String callerInfo = caller.getClassName() + " " + caller.getMethodName() + " line " + caller.getLineNumber();
		log.debug(callerInfo+ ": Verify presence of element " + elemt.toString());
		try {
			if (elemt.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		}
	}

	public static boolean waitForJSAndJQToLoad() {
		
		WebDriverWait wait = new WebDriverWait(driver, 100);

	    // wait for jQuery to load
	    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
	      
	      public Boolean apply(WebDriver driver) {
	        try {
	          return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
	        }
	        catch (Exception e) {
	          // no jQuery present
	          return true;
	        }
	      }
	    };

	    // wait for Javascript to load
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
	     
	      public Boolean apply(WebDriver driver) {
	        return ((JavascriptExecutor)driver).executeScript("return document.readyState")
	        .toString().equals("complete");
	      }
	    };

	  return wait.until(jQueryLoad) && wait.until(jsLoad);
	}
	
	public static void waitFor(long millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
