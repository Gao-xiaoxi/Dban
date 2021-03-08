package com.gao.Case;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gao.Util.TestExcel;
import com.gao.Util.TestNGListnerScreen;
import com.gao.Handle.SearchHandle;
import com.gao.Data.TestData;

@Listeners(TestNGListnerScreen.class)
public class SearchCase extends BaseCase{
	public SearchHandle searchhandle;
	public static Logger logger = Logger.getLogger(SearchCase.class);
	@Parameters({"url","browser","username","password"})
	@BeforeTest
	public void beforeTest(String url, String browser, String username, String password) {
		PropertyConfigurator.configure("log4j.properties");
		UserLogin_Base(url, browser, username, password);
		searchhandle = new SearchHandle(driver);
	}
	
	/**
	 * 后续关闭浏览器
	 */
	@AfterTest
	public void afterTest() {
		UserLogout_Base();
		driver.quit();
	}
	
	/*
	 * 
	 */
//	@DataProvider(name = "search")
//	public Object[][] words() throws FileNotFoundException{
//		TestExcel testExcel = new TestExcel();
//		return testExcel.getTestData("/Users/gaowenjuan/JavaProjects/Dban/src/test/java/com/gao/Data/","search.xlsx","Sheet1");
//	}
	
	/**
	 * Search_Case
	 */
	@Test(dataProvider = "searchData", dataProviderClass = TestData.class)
	public void Search_Case(String searchContent) {
		searchhandle.SendKeysearchEle(searchContent);
		searchhandle.ClicksearchbtnEle();
		Wait();
		//断言
	}
}
