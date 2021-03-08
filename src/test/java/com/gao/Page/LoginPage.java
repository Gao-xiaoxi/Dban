package com.gao.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * 存放登录页面的元素：用户名元素，密码元素，登录按钮元素...需要的可以往后加
 * @author
 *
 */
public class LoginPage extends BasePage{
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 获取usernameEle元素并高亮
	 */
	public WebElement GetusernameEle() {
		WebElement usernameEle = GetElementKey("usernameEle");
		HighlightElement(usernameEle);
		return usernameEle;
	}
	/**
	 * 获取passwordEle元素并高亮
	 */
	public WebElement GetpasswordEle() {
		WebElement passwordEle = GetElementKey("passwordEle");
		HighlightElement(passwordEle);
		return passwordEle;
	}
	/**
	 * 获取usernameEle元素并高亮
	 */
	public WebElement GetloginbtnEle() {
		WebElement loginbtnEle = GetElementKey("loginbtnEle");
		HighlightElement(loginbtnEle);
		return loginbtnEle;
	}
	/**
	 * 获取login2Ele元素并高亮
	 */
	public WebElement Getlogin2Ele() {
		WebElement login2Ele = GetElementKey("login2Ele");
		HighlightElement(login2Ele);
		return login2Ele;
	}
}