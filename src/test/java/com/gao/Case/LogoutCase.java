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
import com.gao.Handle.LogoutHandle;
import com.gao.Handle.SearchHandle;
import com.gao.Data.TestData;

@Listeners(TestNGListnerScreen.class)
public class LogoutCase extends BaseCase{
	public LogoutHandle logouthandle;
	public static Logger logger = Logger.getLogger(LogoutCase.class);
	@Parameters({"url","browser","username","password"})
	@BeforeTest
	public void beforeTest(String url, String browser, String username, String password) {
		PropertyConfigurator.configure("log4j.properties");
		UserLogin_Base(url, browser, username, password);
		logouthandle = new LogoutHandle(driver);
	}
	
	/**
	 * 后续关闭浏览器
	 */
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	/**
	 * Logout_Case
	 */
	@Test()
	public void Logout_Case() {
		Wait();
		logger.debug("开始执行UserLogout_Base");
		LogoutHandle.ClickusericonEle();
		LogoutHandle.ClickquitbtnEle();
		//非专门测试登出
	}
}
