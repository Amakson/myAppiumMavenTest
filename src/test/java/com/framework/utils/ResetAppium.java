package com.framework.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import com.framework.configuration.ConfigFile;
import com.gargoylesoftware.htmlunit.javascript.host.file.FileReader;

//import jdk.nashorn.internal.runtime.regexp.joni.Config;

public class ResetAppium extends Thread{
	
	boolean webProxyCrashed = false;
	public void run ()
	   {
		String appiumLogPath = "/tmp/appium.log";
		if(ConfigFile.getProperty("appiumLogPath")==null | ConfigFile.getProperty("appiumLogPath")=="null"){
			appiumLogPath=ConfigFile.getProperty("appiumLogPath");
		}
		try {
			 FileInputStream fstream = new FileInputStream(appiumLogPath);
			 BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			 String strLine;
			 /* read log line by line */
			 while ((strLine = br.readLine()) != null)   {
			 /* parse strLine to obtain what you want */
			    System.out.println (strLine);
			  }	 
			
			//reset if required
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	   }
			
}

