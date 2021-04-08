package com.gao.Util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.gao.Case.BaseCase;
import com.gao.Case.HomeCase;
import com.gao.Case.LoginCase;
import com.gao.Case.LogoutCase;
import com.gao.Case.SearchCase;
import com.google.common.io.Files;

import bsh.commands.dir;

public class TestNGListnerScreen extends TestListenerAdapter{
	  @Override
	  public void onTestFailure(ITestResult tr) {
		String caseName = String.valueOf(tr.getInstanceName());
	    caseName = caseName.split("\\.")[3];
	    System.out.println("当前case：" + caseName);
	  	BaseCase bc = (BaseCase)tr.getInstance();
		WebDriver driver = bc.driver;
	    this.TakeScreenshot(driver, caseName);
	    super.onTestFailure(tr);
	  }
	  /**
		 * 截图方法优化
		 * @param args
		 */
		public void TakeScreenshot(WebDriver driver, String caseName) {
			//图片名称
			//图片路径
			//当前时间和当前方法名（否则截图名称都是同一个）
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年-MM月-dd日-HH时mm分ss秒");
			String curTime = sdf.format(new Date());
			String filepath = curTime+caseName+".png";
			FileDir filedir = new FileDir();
			File dir = filedir.createDir("TestScreenshot");
			File ScrFile = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
			try {
				Files.copy(ScrFile, new File(dir+"/"+filepath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
