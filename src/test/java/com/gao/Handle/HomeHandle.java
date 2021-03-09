package com.gao.Handle;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.gao.Page.HomePage;
import com.gao.Page.SearchPage;

public class HomeHandle {
	public static Logger logger = Logger.getLogger(HomeHandle.class);
	public HomePage homepage;
	public HomeHandle(WebDriver driver) {
		PropertyConfigurator.configure("log4j.properties");
		homepage = new HomePage(driver);
	}
	/**
	 * 输入,awordEle元素
	 */
	public void SendKeyawordEle(String searchContent1,String searchContent2) {
		logger.debug("当前输入为--->");
		homepage.GetawordEle().click();
		homepage.GetawordEle().clear();
		homepage.GetawordEle().sendKeys(searchContent1+searchContent2);
	}
	/**
	 * 输入,publishEle元素
	 */
	public void ClickpublishEle() {
		logger.debug("当前点击为--->");
		homepage.GetpublishEle().click();
	}
}
