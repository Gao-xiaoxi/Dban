package com.gao.Page;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.gao.Page.BasePage;
import com.gao.Util.LoginUtil;

/**
 * 封装的方法，给页面元素用，方便LoginPage继承
 * 为什么不放在Util层，因为这些方法主要是给Page层用，如果登录Page，注册Page，任何Page，都会用到页面元素
 * @author 
 *
 */
public class BasePage {
	public WebDriver driver;
	public static Logger logger = Logger.getLogger(BasePage.class);

	/**
	 * BasePage构造方法
	 */
	public BasePage(WebDriver driver) {
		PropertyConfigurator.configure("log4j.properties");
		this.driver = driver;
	}

	/**
	 * 通过key从properties中获取定位方式&定位值
	 * 
	 * @param key
	 * @return
	 */

	public WebElement GetElementKey(String key) {
		WebElement Element = driver.findElement(this.GetElementLocator(key));
		return Element;
	}

	/**
	 * 8种定位方式
	 * 
	 * @param key
	 * @return
	 */
	public By GetElementLocator(String key) {
		// usernameEle=name>email
		LoginUtil pro = new LoginUtil("Dbanelement.properties");
		String line = pro.GetPro(key);// 配置文件的一行:name>email
		logger.debug("当前定位的key为--->" + key);
		logger.debug("当前定位方式为--->" + line.split(">")[0]);
		logger.debug("当前定位的值为--->" + line.split(">")[1]);
		if (line.split(">")[0].equals("id")) {
			return By.id(line.split(">")[1]);
		} else if (line.split(">")[0].equals("name")) {
			return By.name(line.split(">")[1]);
		} else if (line.split(">")[0].equals("className")) {
			return By.className(line.split(">")[1]);
		} else if (line.split(">")[0].equals("cssSelector")) {
			return By.cssSelector(line.split(">")[1]);

		} else if (line.split(">")[0].equals("linkText")) {
			return By.linkText(line.split(">")[1]);

		} else if (line.split(">")[0].equals("partialLinkText")) {
			return By.partialLinkText(line.split(">")[1]);

		} else if (line.split(">")[0].equals("tagName")) {
			return By.tagName(line.split(">")[1]);

		} else if (line.split(">")[0].equals("xpath")) {
			return By.xpath(line.split(">")[1]);

		}
		return null;
	}

	/**
	 * 元素的移动
	 */
	public void MoveToElement(WebElement ToElement) {
		Actions action = new Actions(driver);
		action.moveToElement(ToElement).perform();
	}

	/**
	 * 元素的高亮
	 */
	public void HighlightElement(WebElement Element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style',arguments[1]);", Element,
				"background:green;border:4px solid black");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
