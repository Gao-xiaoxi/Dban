package com.gao.Case;

import java.io.FileNotFoundException;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.gao.Case.LoginCase;
import com.gao.Handle.LoginHandle;
import com.gao.Handle.LogoutHandle;
import com.gao.Util.LoginUtil;
import com.gao.Util.TestExcel;
import com.gao.Util.TestNGListnerScreen;

@Listeners(TestNGListnerScreen.class)
public class BaseCase {
	public WebDriver driver;
	public static Logger logger = Logger.getLogger(BaseCase.class);
	public WebDriver GetDriver(String browser) {
		PropertyConfigurator.configure("log4j.properties");
		if(browser.equalsIgnoreCase("chrome")) {
			logger.debug("初始化谷歌浏览器");
			driver = new ChromeDriver();
		}else {
			logger.debug("初始化火狐浏览器");
			driver = new FirefoxDriver();
		}
		return driver;
	}
	
	/**
	 * 等待3s
	 */
	public void Wait() {
		logger.debug("等待5s...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 切换窗口
	 * 
	 */
	public void SwitchWindow(String ExpectTitle) {
		for(int a=0;a<=9;a++) {
			Set<String> windowHandles = driver.getWindowHandles();
			for(String handler: windowHandles) {
				driver.switchTo().window(handler);
				if(ExpectTitle.equals(driver.getTitle())) {
					a = 10;
					break;
				}
			}
		}
	}
	/**
	 * 登陆方法-默认登陆
	 */
	@Parameters({"url","browser","username","password"})
	public void UserLogin_Base(String url, String browser, String username, String password) {
		Logger logger = Logger.getLogger(LoginCase.class);
		PropertyConfigurator.configure("log4j.properties");
		logger.debug("初始化浏览器");
		driver = GetDriver(browser);
		logger.debug("打开被测网址");
		driver.get(url);
		driver.manage().window().maximize();
		Wait();
		LoginHandle loginhandle = new LoginHandle(driver);
		driver.switchTo().frame(0);
		logger.debug("开始执行UserLogin_Base");
		loginhandle.Clicklogin2Ele();
		loginhandle.SendKeyusernameEle(username);
		loginhandle.SendKeypasswordEle(password);
		Wait();
		loginhandle.ClickloginbtnEle();
		Wait();
	}
		
		/**
		 * 登出
		 */
		public void UserLogout_Base() {
			LogoutHandle logouthandle = new LogoutHandle(driver);
			logger.debug("开始执行UserLogout_Base");
			logouthandle.ClickusericonEle();
			logouthandle.ClickquitbtnEle();
	}
}
