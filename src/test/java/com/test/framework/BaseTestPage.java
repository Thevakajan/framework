package com.test.framework;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.utils.ExtentUtil;

public class BaseTestPage {
	protected static WebDriver driver;
	private String browser;
	protected static Properties prop = new Properties();
	private static String screenShotFolderPath = System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\";
	private static String reportFolderPath = "\\src\\test\\resources\\results";
	 public static ExtentReports extentReport = new ExtentReports(reportFolderPath);
	  public static ExtentTest extentTest;
	public static String excelFilePath = "\\src\\test\\resources\\xldata\\data.xlsx";
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		InputStream inputStream = null;
	    inputStream = this.getClass().getClassLoader().getResourceAsStream("config/config.properties");
	    prop.load(inputStream);
	    
	    browser = System.getProperty("browser");
	    if (browser == null || browser.isEmpty()) {      
	      browser = prop.getProperty("browser");
	    }
	    switch (browser) {
	      case "chrome":
	        System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
	        driver = new ChromeDriver();
	        break;
	      case "firefox":
	        System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxDriverPath"));
	        driver = new FirefoxDriver();
	        break;
	      default:
	        driver = new ChromeDriver();
	        break;
	    }
		
	    
	}
	public static String captureScreeShot() {
        String filename= Functions.getTimeStamp("yyyy-MM-dd_HH.mm.ss")+".jpg";
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String screenShotName = screenShotFolderPath + filename;
        try {
          FileUtils.copyFile(screenshotFile, new File(screenShotName));
        }
        catch (Exception e) {
          // TODO: handle exception
        }
        
        return screenShotName;
      }
	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    //ExtentUtil.flush();
	    driver.quit();
	  }
}
