package com.framework.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class ConfigFile { 

	
public static Set<Entry<Object, Object>> obj ;
public static Map<Object, Object> mapObject = new HashMap<>();
	
	static{
	System.out.println("Static block");
	
	//MadM JCH java -cp bin:lib/* -DconfigToUse=android org.testng.TestNG testng.xml
	String whichConfigToUse = System.getProperty("configToUse");
	File fileAndroid = new File("configurationFiles/config-android.properties");
	
	File file = new File("configurationFiles/config.properties");	
	Properties prop = new Properties();
	try {
		if (whichConfigToUse != null && whichConfigToUse.equals("android"))
		{
			System.out.println("Using Android config-android.properties");
			prop.load(new FileInputStream(fileAndroid));		
		}
		else
		{
			System.out.println("Using iOS config.properties");
			prop.load(new FileInputStream(file));		
		}
		obj = prop.entrySet();		
		for(Entry<Object, Object> en: obj){
			System.out.println(en.getKey()+" ="+ " "+ en.getValue() );			
			mapObject.put(en.getKey(), en.getValue());					
		}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

	public static String getProperty(String str){	
		if( mapObject.get(str)!=null){
			return mapObject.get(str).toString();
		}
		else{
			System.out.println("Please add property name: " + str + "its corresponding value in config.properites file");
			return null;
		}
}


}