package com.gao.Util;

import java.io.File;

public class FileDir {
	
	public File createDir(String dirName) {
		File dir = new File(System.getProperty("user.dir")+File.separator+dirName);
        if (!dir.exists()) {// 判断目录是否存在     
            dir.mkdir();   
        }
		return dir;
	}
}
