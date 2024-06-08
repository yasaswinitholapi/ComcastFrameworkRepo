package com.comcast.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public final class FileUtility {
	//f any want to call ths method that testcase wrter should pass these arguments
	public String getDataFromPropertiesFile(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("./configAppData/commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		//we want to capture data
		String data=pobj.getProperty(key);
		
		return data;
		
	}

	
	
	

}
