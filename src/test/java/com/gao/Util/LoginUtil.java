package com.gao.Util;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginUtil {
	public Properties loginUtil;
	public LoginUtil(String filepath) {
		loginUtil = ReadProperties(filepath);
	}

	/**
	 * 读取配置文件properties
	 * @return 
	 */
	public Properties ReadProperties(String filepath) {
		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		BufferedInputStream bufferedInputStream;
		try {
			fileInputStream = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bufferedInputStream = new BufferedInputStream(fileInputStream);
		try {
			properties.load(bufferedInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}
	
	/**
	 * 通过key获取元素
	 */
	public String GetPro(String key) {
		String value;
		if (loginUtil.containsKey(key)) {
			value = loginUtil.getProperty(key);
			return value;
		} else {
			return "不存在的元素";
		}
	}
	
	/**
	 * 获取properties大小
	 */
	public int GetLines() {
		return loginUtil.size();
	}
}
