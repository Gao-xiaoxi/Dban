package com.gao.Case;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gao.Data.TestData;
import com.gao.Handle.HomeHandle;
import com.gao.Handle.SearchHandle;
import com.gao.Util.TestNGListnerScreen;

@Listeners(TestNGListnerScreen.class)
public class HomeCase extends BaseCase{
	public HomeHandle homehandle;
	public static Logger logger = Logger.getLogger(HomeCase.class);
	
	@Parameters({"url","browser","username","password"})
	@BeforeClass
	public void beforeClass(String url, String browser, String username, String password) {
		PropertyConfigurator.configure("log4j.properties");
		UserLogin_Base(url, browser, username, password);
		homehandle = new HomeHandle(driver);
	}
	
	/**
	 * 后续关闭浏览器
	 */
	@AfterClass
	public void afterClass() {
		UserLogout_Base();
		driver.quit();
	}
	
	/**
	 * Home_Case
	 */
	@Test(dataProvider = "home1Data", dataProviderClass = TestData.class)
	public void Home_Case1(String searchContent1, String searchContent2) {
		homehandle.SendKeyawordEle(searchContent1, searchContent2);
		homehandle.ClickpublishEle();
		Wait();
		//断言
	}
	
}
