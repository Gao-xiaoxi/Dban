package com.gao.Data;

import java.io.FileNotFoundException;

import org.testng.annotations.DataProvider;

import com.gao.Util.TestExcel;

public class TestData {
	String filepath =  "/Users/gaowenjuan/JavaProjects/Dban/src/test/java/com/gao/Data/";
	
	@DataProvider(name = "searchData")
	public Object[][] searchData() throws FileNotFoundException{
		TestExcel testExcel = new TestExcel();
		return testExcel.getTestData(filepath,"searchData.xlsx","Sheet1");
	}

}
