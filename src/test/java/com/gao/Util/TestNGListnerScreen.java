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
import com.gao.Case.LoginCase;
import com.gao.Case.LogoutCase;
import com.gao.Case.SearchCase;
import com.google.common.io.Files;

public class TestNGListnerScreen extends TestListenerAdapter{
	  @Override
	  public void onTestFailure(ITestResult tr) {
		String caseName = String.valueOf(tr.getInstanceName());
	    caseName = caseName.split("\\.")[3];
	    System.out.println("当前case：" + caseName);
	    BaseCase bc = (BaseCase)tr.getInstance();
	    if(caseName.equals("LoginCase")) {
	    	bc = (LoginCase)tr.getInstance();
	    }
	    else if (caseName.equals("SearchCase")) {
	    	bc = (SearchCase)tr.getInstance();
	    }
	    else if (caseName.equals("LogoutCase")) {
	    	bc = (LogoutCase)tr.getInstance();
	    }
	    else if (caseName.equals("HomeCase")) {
	    	bc = (LogoutCase)tr.getInstance();
	    }
		WebDriver driver = bc.driver;
	    this.TakeScreenshot(driver);
	    super.onTestFailure(tr);
	  }
	  /**
		 * 截图方法优化
		 * @param args
		 */
		public void TakeScreenshot(WebDriver driver) {
			//图片名称
			//图片路径
			//当前时间和当前方法名（否则截图名称都是同一个）
			SimpleDateFormat sdf = new SimpleDateFormat("yy_MM_dd_hh_mm_ss");
			String curTime = sdf.format(new Date());
			String curClassName = this.getClass().getName();
			String filepath = curTime+curClassName+".png";
			File ScrFile = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
			try {
				Files.copy(ScrFile, new File(filepath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
