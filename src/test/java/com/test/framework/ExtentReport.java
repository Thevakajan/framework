package com.test.framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport extends BaseTestPage {
	private static Logger logger = LogManager.getLogger(LoginTestPage.class);
	  boolean flag = false;
	ExtentHtmlReporter htmlReporter; 
	ExtentReports extent;
	@BeforeSuite
	 @Test
       public void setUp() {
		htmlReporter = new ExtentHtmlReporter("extent.html");
	    
        // create ExtentReports and attach reporter(s)
		ExtentReports  extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
//////////////////////////////////////////////////////////////////////////////////////////////
      
       

       }
	@Test
 public void test1() throws Exception {
		// creates a toggle for the given test, adds all log events under it    
        ExtentTest test = extent.createTest("MyFirstTest", "Sample description"); 
     // log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");
        
        // log with snapshot
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
       }
	@AfterTest
 public void tearDown() {
		extent.flush();
 }
       
}
	
