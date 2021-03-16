package com.gao.Case;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.gao.Util.TestNGListnerScreen;
import com.gao.Handle.LoginHandle;
import com.gao.Page.LoginPage;

@Listeners(TestNGListnerScreen.class)
public class LoginCase extends BaseCase{
	public WebDriver driver;
	public LoginHandle loginhandle;
	public LoginPage loginpage;
	public static Logger logger = Logger.getLogger(LoginCase.class);
	
	/**
	 * 初始化
	 */
	@Parameters({"url","browser"})
	@BeforeTest
	public void beforeTest(String url, String browser) {
		PropertyConfigurator.configure("log4j.properties");
		logger.debug("初始化浏览器");
		driver = GetDriver(browser);
		logger.debug("打开被测网址");
		driver.get(url);
		driver.manage().window().maximize();
		Wait();
		loginhandle = new LoginHandle(driver);
		loginpage = new LoginPage(driver);
	}

	/**
	 * 后续关闭浏览器
	 */
	@AfterTest
	public void afterTest() {
		driver.close();
	}
	
	/**
	 * Case1
	 */
	@Parameters({"username","password"})
	@Test
	public void UserLogin_Case(String username, String password) {
		//输入正确的用户名
		//输入正确的密码
		//点击登录按钮
		driver.switchTo().frame(0);
		logger.debug("开始执行UserLogin_Case");
		loginhandle.Clicklogin2Ele();
		loginhandle.SendKeyusernameEle(username);
		loginhandle.SendKeypasswordEle(password);
		Wait();
		loginhandle.ClickloginbtnEle();
		Wait();
		//非专门测试登录
		
	}
}
