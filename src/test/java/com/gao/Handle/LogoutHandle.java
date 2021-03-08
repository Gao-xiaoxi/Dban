package com.gao.Handle;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.gao.Page.LoginPage;
import com.gao.Page.LogoutPage;

public class LogoutHandle {
	public static Logger logger = Logger.getLogger(LogoutHandle.class);
	public static LogoutPage logoutpage;
	public LogoutHandle(WebDriver driver) {
		PropertyConfigurator.configure("log4j.properties");
		logoutpage = new LogoutPage(driver);
	}
	/**
	 * 点击,usericonEle元素
	 */
	public static void ClickusericonEle() {
		logger.debug("当前点击为--->");
		logoutpage.GetusericonEle().click();
	}
	/**
	 * 点击,quitbtnEle元素
	 */
	public static void ClickquitbtnEle() {
		logger.debug("当前点击为--->");
		logoutpage.GetquitbtnEle().click();
	}
}
