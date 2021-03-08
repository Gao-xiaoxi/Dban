package com.gao.Handle;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.gao.Page.SearchPage;

public class SearchHandle {
	public static Logger logger = Logger.getLogger(SearchHandle.class);
	public SearchPage searchpage;
	public SearchHandle(WebDriver driver) {
		PropertyConfigurator.configure("log4j.properties");
		searchpage = new SearchPage(driver);
	}
	/**
	 * 输入,searchEle元素
	 */
	public void SendKeysearchEle(String searchContent) {
		logger.debug("当前输入为--->"+searchContent);
		searchpage.GetsearchEle().clear();
		searchpage.GetsearchEle().sendKeys(searchContent);
	}
	/**
	 * 输入,searchbtnEle元素
	 */
	public void ClicksearchbtnEle() {
		logger.debug("当前点击为--->");
		searchpage.GetsearchbtnEle().click();
	}
}
