package com.gao.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
	public WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 获取awordEle元素并高亮
	 */
	public WebElement GetawordEle() {
		WebElement awordEle = GetElementKey("awordEle");
		HighlightElement(awordEle);
		return awordEle;
	}
	/**
	 * 获取publishEle元素并高亮
	 */
	public WebElement GetpublishEle() {
		WebElement publishEle = GetElementKey("publishEle");
		HighlightElement(publishEle);
		return publishEle;
	}
}
