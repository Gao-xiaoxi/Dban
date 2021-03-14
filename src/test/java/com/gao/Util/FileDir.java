package com.gao.Util;

import java.io.File;
import java.io.FileNotFoundException;

import com.alibaba.fastjson.JSONObject;

public class FileDir {
	
	public File createDir(String dirName) {
		File dir = new File(System.getProperty("user.dir")+File.separator+dirName);
        if (!dir.exists()) {// 判断目录是否存在     
            dir.mkdir();   
        }
		return dir;
	}
	
	public String getProjectName() {
		String projectname = System.getProperty("user.dir");
		String pn = projectname.substring(projectname.lastIndexOf('/')+1,projectname.length());
		return pn;
	}
}
