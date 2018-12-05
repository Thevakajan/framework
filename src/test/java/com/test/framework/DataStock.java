package com.test.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataStock {
	 private static XSSFWorkbook workbook; 
	    private static XSSFSheet sheet;
	    private static FileInputStream file;
	    
	    private Map <String,Integer> headerRow;
	    public static Map<String,ArrayList<String>> testData;
	    private static Logger log = LogManager.getLogger(DataStock.class);
	    
	    public static void readExcelFile(String filepath) {
	        String filePath = System.getProperty("user.dir")+ filepath;
	        try {
	            FileInputStream excelFile = new FileInputStream(new File(filePath));
	            workbook = new XSSFWorkbook (excelFile);
	        } catch (IOException e) {
	            log.error("Excel file reading error: \n" + e.getMessage());
	        }
	        sheet = workbook.getSheetAt(0);
	        
	    }
	    public static void loadData() {
	    	 testData = new HashMap<String,ArrayList<String>>();
	    	 XSSFRow firstRow = sheet.getRow(0);
	         int minColNumber = firstRow.getFirstCellNum();
	         int maxColNumber = firstRow.getLastCellNum();
	         
	         boolean hasDataFlag;
	         String cellValue;
	         
	         for (int i=minColNumber;i<maxColNumber;i++) {
	             ArrayList<String> arrList = new ArrayList<>();
	             for (int j=1; j<= sheet.getLastRowNum();j++) {
	                 
	                  hasDataFlag = (sheet.getRow(j).getCell(i) !=null);
	                  
	                  if (hasDataFlag) {
	                      cellValue = sheet.getRow(j).getCell(i).getStringCellValue(); 
	                  } else {
	                      cellValue ="";
	                  }
	                  arrList.add(cellValue);
	                  
	             }
	             testData.put(firstRow.getCell(i).getStringCellValue(),arrList );
	         }
	         
	         
	    }
	    public static void clearData() {
	        try {
	            workbook.close();
	            file.close();
	        } catch (IOException e) {
	          
	            e.printStackTrace();
	        }
	            
	    }
	    }

