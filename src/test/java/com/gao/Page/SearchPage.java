package com.gao.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage{
	public WebDriver driver;
	public SearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 获取searchEle元素并高亮
	 */
	public WebElement GetsearchEle() {
		WebElement searchEle = GetElementKey("searchEle");
		HighlightElement(searchEle);
		return searchEle;
	}
	/**
	 * 获取searchbtnEle元素并高亮
	 */
	public WebElement GetsearchbtnEle() {
		WebElement searchbtnEle = GetElementKey("searchbtnEle");
		HighlightElement(searchbtnEle);
		return searchbtnEle;
	}
}
