package com.ajmal.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ajmal.pages.actions.TopNavigation;
import com.ajmal.utilities.ExcelReader;
import com.ajmal.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author 	Ajmal
 * @Desc 	Initialization
 * 			#WebDriver
 * 			#Reports
 * 			#Excels
 * 			#Property Files
 * 			#Email Monitoring
 * 			#Listeners
 * 			#Extent Reports
 * 			#Browser initialization
 */
public class Page {

	public static WebDriver driver;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait ;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	public static WebDriverWait newWait;
	public static Robot robot;
	public static Actions action;
	public static TopNavigation topNav;
	public static String TempName = "";

	
	
	public static void initConfiguration(){
		
		if(Constants.browser.equals("firefox")){
		    driver = new FirefoxDriver();
			log.debug("Launching Firefox");
		}else if(Constants.browser.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			driver = new ChromeDriver(options);
			log.debug("Launching Chrome");
		}else if(Constants.browser.equals("ie")){
			
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			log.debug("Launching IE");
		}
		
		
		driver.get(Constants.testsiteurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.implicitwait, TimeUnit.SECONDS);
		
		topNav = new TopNavigation(driver);
		wait = new WebDriverWait(driver, 20);
		
		action = new Actions(driver);
	}
	
	
	public static void click(WebElement element) {
		
		element.click();
		log.debug("Clicking on an Element : "+element);
		test.log(LogStatus.INFO, "Clicking on : " +element);
	}
	
	
	public static void type(WebElement element, String value1) {
		
		element.sendKeys(value1);
		log.debug("Typing in an Element : "+element+" entered value as : "+value1);
		test.log(LogStatus.INFO, "Typing in : " + element + " entered value as " + value1);

	}
	
	
	public static void Wait(WebElement element, int time){
		newWait = new WebDriverWait(driver, time);
		newWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public static void quitBrowser(){
		
		driver.quit();
		
	}
	

}
