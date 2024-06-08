package com.comcast.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtilty {
	public String getDataFromjsonFile(String key ) throws Throwable {
		FileReader fileR=new FileReader("./configAppData/appCommonData.json");
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(fileR);
		// want to convert ths nto hashmap ey and value par gettng that object so thats why we are downcastng to json object
		JSONObject map=(JSONObject)obj;
		System.out.println(map.get("url"));
		String data=(String) map.get(key);
		return data;
		
	}
}
