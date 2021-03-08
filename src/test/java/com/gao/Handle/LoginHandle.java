package com.gao.Handle;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.gao.Page.LoginPage;

public class LoginHandle {
	public static Logger logger = Logger.getLogger(LoginHandle.class);
	public LoginPage loginpage;
	public LoginHandle(WebDriver driver) {
		PropertyConfigurator.configure("log4j.properties");
		loginpage = new LoginPage(driver);
	}
	/**
	 * 输入,usernameEle元素
	 */
	public void SendKeyusernameEle(String usernameEle) {
		logger.debug("当前输入为--->"+usernameEle);
		loginpage.GetusernameEle().clear();
		loginpage.GetusernameEle().sendKeys(usernameEle);
	}
	/**
	 * 输入,passwordEle元素
	 */
	public void SendKeypasswordEle(String passwordEle) {
		logger.debug("当前输入为--->"+passwordEle);
		loginpage.GetpasswordEle().clear();
		loginpage.GetpasswordEle().sendKeys(passwordEle);
	}
	/**
	 * 点击,loginbtnEle元素
	 */
	public void ClickloginbtnEle() {
		logger.debug("当前点击为--->登录按钮");
		loginpage.GetloginbtnEle().click();;
	}
	/**
	 * 点击,login2Ele元素
	 */
	public void Clicklogin2Ele() {
		logger.debug("当前点击为--->登录页面2");
		loginpage.Getlogin2Ele().click();;
	}
}
