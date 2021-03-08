package com.gao.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * @author
 *
 */
public class LogoutPage extends BasePage{
	public WebDriver driver;
	public LogoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 获取usericonEle元素并高亮
	 */
	public WebElement GetusericonEle() {
		WebElement usericonEle = GetElementKey("usericonEle");
		HighlightElement(usericonEle);
		return usericonEle;
	}
	/**
	 * 获取quitbtnEle元素并高亮
	 */
	public WebElement GetquitbtnEle() {
		WebElement quitbtnEle = GetElementKey("quitbtnEle");
		HighlightElement(quitbtnEle);
		return quitbtnEle;
	}
}