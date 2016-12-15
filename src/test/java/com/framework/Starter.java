package com.framework;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.framework.configuration.ConfigFile;
import com.framework.frameworkFunctions.LibraryPage;
import com.framework.reporting.FrameworkReporter;

import bsh.Console;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class Starter {
	

	public DesiredCapabilities cap = new DesiredCapabilities();
		
	public static String strPlatformName, strPlatformVersion, strDeviceName, strAutoWebView, strUDID, strAppPath;
	public static String strHost, strPort ;	
	public static Boolean boolIsAppVal;
	public static WebDriver driver ;
	public static String strTimeout;
	public static Process p,resetAppiumP;
	private static Process process;
	//need to pass from config file when starting exec in windows
	private static String APPIUMSERVERSTART = "C:\\Appium\\node.exe C:\\Appium\\node_modules\\appium\\bin\\appium.js";

	public void startup() {	
		
		try {
		 System.out.println("Inside startup");
			URL urlObj = new URL("http://"+ strHost + ":"+ strPort+ "/wd/hub");
			
			if(ConfigFile.getProperty("executionEnvOS").equalsIgnoreCase("mac"))
			{
				if(ConfigFile.getProperty("appiumRestart").equalsIgnoreCase("true"))
				{
					try {
						stopAppiumOnMac();
						if(ConfigFile.getProperty("iOSWebkitProxyRestart").equalsIgnoreCase("true"))
						{
							//delete Completed.txt if present
							//deleteDummyFile();
							deleteFiles();	
					//		startResetAppiumUtility();
						}

						
						//delete Completed.txt if present
						//deleteFiles();						
						startAppiumOnMac();
					} catch (Exception e) {
						
						e.printStackTrace();						
					}
				}
			}
			//For windows - please add if required
			if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
				//ClearCache();
			}
					
			switch(strPlatformName){			
				case "android":
					driver = new AndroidDriver<WebElement>(urlObj, getAndroidCapabilities());
					FrameworkReporter.info("Started Script Execution in Android device '"+ strDeviceName+"' with version '"+ strPlatformVersion+ "' ");
					break;
				case "ios":
					driver = new IOSDriver<WebElement>(urlObj, getIOSCapabilities());	
					if(ConfigFile.getProperty("iOSWebkitProxyRestart").equalsIgnoreCase("true"))
					{
				//		startResetAppiumUtility();
						ProcessBuilder pb = new ProcessBuilder("ios_webkit_debug_proxy","-u",strUDID+":27753");
						//pb.redirectError();
						p = pb.start();
						System.out.println(p.toString());
					}			
						
					
					FrameworkReporter.info("Started Script Execution in IOS device '"+ strDeviceName+"' with UDID '"+ strUDID+ "' "+ " and Version: '"+ strPlatformVersion);
					break;
				case "desktop":
					driver =new RemoteWebDriver(urlObj, getDesktopCapabilities());	
					break;
				default:
					System.out.println("Specify correct platformType in testType parameters in test.properties file");
			}
			LibraryPage.isNative = true;
			LibraryPage lib = new LibraryPage();
			lib.switchToWebContext();
			System.out.println(driver.toString());
		}catch(Exception e){
			e.printStackTrace();
		}		
		
	}
	//Appium Launch for Mac Users. We will need to implement Appium Launch for Windows users if needed. 

	public void cleanUp(){	
		if(ConfigFile.getProperty("platformType").toString().equalsIgnoreCase("ios") && ConfigFile.getProperty("iOSWebkitProxyRestart").equalsIgnoreCase("true"))
		{
			System.out.println("Inside killIOSWebKitDebugProxy");
			p.destroyForcibly();
			try {
				Runtime.getRuntime().exec("pkill ios_webkit_debug_proxy");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(ConfigFile.getProperty("iOSWebkitProxyRestart").equalsIgnoreCase("true"))
		{
			//Create a dummy file
			createDummyFile();
		}
		if(ConfigFile.getProperty("platformType").equalsIgnoreCase("ios"))
		{
			try{
				Runtime.getRuntime().exec("pkill idevicesyslog");
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		if(ConfigFile.getProperty("appiumRestart").equalsIgnoreCase("true"))
		{
		try {
			Runtime.getRuntime().exec("killall node");
			Runtime.getRuntime().exec("pkill mdworker");
			}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public static void startAppiumOnMac(){
		
		CommandLine command = new CommandLine(ConfigFile.getProperty("appiumAppPath")+"/Contents/Resources/node/bin/node");
		command.addArgument(ConfigFile.getProperty("appiumAppPath")+"/Contents/Resources/node_modules/appium/build/lib/main.js", false);
		command.addArgument("--address", false);
		command.addArgument(strHost);
		command.addArgument("--port", false);
		command.addArgument(strPort);
		command.addArgument("--no-reset", false);
		command.addArgument("--log",true);
		command.addArgument(ConfigFile.getProperty("appiumLogPath").toString()+"/appium.log");
		//--log "/Users/syscotest/Documents/App/appium.log"
		//--log-level "debug"
		command.addArgument("--log-level",true);
		command.addArgument("debug");
		
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(command, resultHandler);
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void stopAppiumOnMac() throws Exception {
		Runtime.getRuntime().exec("killall node");
		Thread.sleep(10000);
	}
	//Appium Launch on Windows

	public static void startAppiumOnWindows() throws IOException, InterruptedException {
	
		Runtime runtime = Runtime.getRuntime();
		process = runtime.exec(APPIUMSERVERSTART);
		Thread.sleep(5000);
		if (process != null) {
			System.out.println("Appium server started");
		}
	}

	public static void stopAppiumOnWindows() throws IOException {
	if (process != null) {
		process.destroy();
		}
	}
	
	public static WebDriver getWebDriver(){
		return driver;
	}
	
	
	public DesiredCapabilities getAndroidCapabilities(){

		cap.setCapability("platformName", strPlatformName);
		cap.setCapability("platformVersion", strPlatformVersion);
		cap.setCapability("deviceName", strDeviceName);		
		if(boolIsAppVal){
			cap.setCapability("app", strAppPath);
			cap.setCapability("autoWebview", strAutoWebView);
			cap.setCapability("newCommandTimeout",strTimeout );
		}
		
		return cap;
	}
	
	public DesiredCapabilities getIOSCapabilities(){
		
		cap.setCapability("platformName", strPlatformName);
		cap.setCapability("platformVersion", strPlatformVersion);
		cap.setCapability("deviceName", strDeviceName);		
		cap.setCapability("udid", strUDID);	
		//cap.setCapability("fullReset", true);		
		if(boolIsAppVal){
			cap.setCapability("app", strAppPath);
		}
		
		return cap;
	}
	
	
	public DesiredCapabilities getDesktopCapabilities(){
		
		String strBrowser = ConfigFile.getProperty("test.browser").toLowerCase();
		
		switch(strBrowser){
			
		case "chrome":
			cap = DesiredCapabilities.chrome();		
		case "firefox":
			cap = DesiredCapabilities.firefox();
		case "iexplorer":
			cap = DesiredCapabilities.internetExplorer();
		default:
			System.out.println("Please provide correct browser type in test.browser parameter");
		}
		
		return cap;
	}
	
	public void startResetAppiumUtility() 
	{
		//get the path of the Shell Scripts folder
		File shell = new File("ShellScripts/AppiumRestart.sh");
		String scriptPath = shell.getAbsolutePath();		
		String path = ConfigFile.getProperty("appiumLogPath").toString();
		//invoke it using parameter
		ProcessBuilder pb = new ProcessBuilder(scriptPath,path+"/appium.log", path+"/Completed.txt");
		try {
			resetAppiumP = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Completed.txt always in documents
	}
	public void deleteFiles()
	{
		String path = ConfigFile.getProperty("appiumLogPath").toString();
		File f = new File(path+"/Completed.txt");
		if(f.exists()) { 
		    f.delete();
		}
		
		File log = new File(path+"/appium.log");
		if(log.exists()) { 
			log.delete();
		}
	}
	public void createDummyFile()
	{
		String path = ConfigFile.getProperty("appiumLogPath").toString();
		File f = new File(path+"/Completed.txt");
		if(!f.exists()) { 
		    try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	static{	
		
		strHost = ConfigFile.getProperty("selenium.host");
		strPort = ConfigFile.getProperty("selenium.port");
		
		if(ConfigFile.getProperty("platformType")==null | ConfigFile.getProperty("platformType").trim().isEmpty()){
			strPlatformName = "";
		}else{
			strPlatformName = ConfigFile.getProperty("platformType").toLowerCase();}		
		
		if(ConfigFile.getProperty("platformVersion")==null | ConfigFile.getProperty("platformVersion")=="null"){
			strPlatformVersion = "";			
		}else{
			strPlatformVersion = ConfigFile.getProperty("platformVersion");		}
		
		if(ConfigFile.getProperty("deviceName")==null | ConfigFile.getProperty("deviceName")=="null"){
			strDeviceName = "";
			}else{
			strDeviceName = ConfigFile.getProperty("deviceName");		}
		
		if(ConfigFile.getProperty("autoWebView")==null | ConfigFile.getProperty("autoWebView")=="null"){
			strAutoWebView = "";			
		}else{
			strAutoWebView = ConfigFile.getProperty("autoWebView");		}
		
		if(ConfigFile.getProperty("udid")==null | ConfigFile.getProperty("udid")=="null"){
			strUDID = "";			
		}else{
			strUDID = ConfigFile.getProperty("udid");		}
		
		if(ConfigFile.getProperty("appPath")==null | ConfigFile.getProperty("appPath")=="null"){
			strAppPath = "";	
		}else{
			strAppPath = ConfigFile.getProperty("appPath");		}
		
		if(ConfigFile.getProperty("isApp")==null | ConfigFile.getProperty("isApp")=="null"){
			boolIsAppVal = false;	
		}else{
			boolIsAppVal = Boolean.parseBoolean(ConfigFile.getProperty("isApp"));		
			}
		if(ConfigFile.getProperty("timeout")==null | ConfigFile.getProperty("timeout")=="null"){
			strTimeout = "";	
		}else{
			strTimeout = ConfigFile.getProperty("timeout");		
			}	
	}
	public void ClearCache()
	{
		String deleteCmd = "adb shell pm clear com.syscouom.uomqasq";      
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec(deleteCmd);
        } catch (IOException e) {
            e.printStackTrace();                
        }
	}
}
