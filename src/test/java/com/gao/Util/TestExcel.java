package com.gao.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;

public class TestExcel {
	
	public Object[][] getTestData(String filePath, String fileName, String sheetName) throws FileNotFoundException {
		 File file = new File(filePath + fileName);
		 FileInputStream inputStream = new FileInputStream(file);
		 Workbook Workbook = null;
		 String fileExtensionName = fileName.substring(fileName.indexOf("."));
		 if(fileExtensionName.equals(".xlsx")) {
			 try {
				Workbook = new XSSFWorkbook(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 }
		 else if(fileExtensionName.equals(".xls")) {
			 try {
				Workbook = new HSSFWorkbook(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 Sheet Sheet = Workbook.getSheet(sheetName);
		 int rowCount = Sheet.getLastRowNum() - Sheet.getFirstRowNum();
		 List<Object[]> records = new ArrayList<Object[]>();
		 for(int i = 1; i < rowCount +1; i++) {
			Row row = Sheet.getRow(i);
			String fields[] = new String[row.getLastCellNum()];
			for(int j = 0; j < row.getLastCellNum(); j++) {
				fields[j] = row.getCell(j).getStringCellValue().trim();
			}
			records.add(fields);
		 }
		 Object[][] results = new Object[records.size()][];
		 for(int i = 0; i < records.size(); i++) {
			 results[i] = records.get(i); 
		 }
		 return results;
	 }
	
	public static void main(String[] args) throws FileNotFoundException {
		TestExcel testExcel = new TestExcel();
		Object[][] results = testExcel.getTestData("/Users/gaowenjuan/JavaProjects/Dban/src/test/java/com/gao/Data/","search.xlsx","Sheet1");
		System.out.println(JSONObject.toJSONString(results));

	}
}

