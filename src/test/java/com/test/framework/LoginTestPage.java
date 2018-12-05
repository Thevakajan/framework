package com.test.framework;

import org.apache.logging.log4j.LogManager;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class LoginTestPage extends BaseTestPage {
	private static Logger logger = LogManager.getLogger(LoginTestPage.class);
	  boolean flag = false;
	  
	  @Test
	  public void testOrangePageHrm() {
		  DataStock.readExcelFile(excelFilePath);
		  DataStock.loadData();
		   for (int i = 0; i < DataStock.testData.get("username").size(); i++) {
			   try {
				   extentTest = extentReport.startTest("Admin Login");
				   driver.get(prop.getProperty("baseUrl"));
				   Log.startTestCase();
				   driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='LOGIN Panel'])[1]/following::span[1]")).click();
				   driver.findElement(By.id("txtUsername")).clear();
				   driver.findElement(By.id("txtUsername"))
				   .sendKeys(DataStock.testData.get("username").get(i));
				   String file = captureScreeShot();
				   extentTest.log(LogStatus.PASS, "Enter UserName");
				   logger.log(Level.INFO, "********* Entered username **********");
				   driver.findElement(By.id("txtPassword")).clear();
				   driver.findElement(By.id("txtPassword"))
				   .sendKeys(DataStock.testData.get("password").get(i));
				   String file1 = captureScreeShot();
				   extentTest.log(LogStatus.PASS, "Enter Password");
				   logger.log(Level.INFO, "********* Entered Password **********");
				   driver.findElement(By.id("btnLogin")).click();
				   String file3 = captureScreeShot();
				   extentTest.log(LogStatus.PASS, "Click Button");
				   logger.log(Level.INFO, "********* Login Button **********");
				   Thread.sleep(500);
				   try {
				          assertEquals(driver.findElement(By.id("welcome")).getText(), "Welcome Admin");
				          logger.log(Level.INFO, "Verified Welcome Message");
				        } catch (Error e) {
				          String file4 = captureScreeShot();
				          extentTest.log(LogStatus.FAIL, "Failed to find the message");
				          logger.log(Level.ERROR, "Failed to find mesasge. \n" + "Screenshot file: " + file);
				        }
				   driver.findElement(By.id("welcome")).click();
			   } catch (Exception e) {
			        // TODO: handle exception
			      }
		   }
	  }
}


