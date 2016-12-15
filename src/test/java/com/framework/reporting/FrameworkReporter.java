package com.framework.reporting;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.Reporter;

import com.framework.frameworkFunctions.LibraryPage;
import com.uom.commonFunctions.FunctionLibrary;



public class FrameworkReporter {
	
	
	
	public static void pass(String str){
		
		Reporter.log(getTime()+ "   LOG_PASS:   " + str);
		LibraryPage.consolePrint(getTime()+ "   LOG_PASS:  " + str);
		Assert.assertTrue(true);	
	}

	public static void fail(String str){
        Reporter.log(getTime() + "   LOG_FAIL:   " + str);
        Reporter.log("-----------------------------------------------------------------");
        Reporter.log("*****************************************************************");
        LibraryPage.consolePrint(getTime() + "   LOG_FAIL:  " + str);
        //try {
			Assert.assertTrue(false);
		//}
		//catch (AssertionError e) {
            //e.printStackTrace();
		//}
	}
	

	public static void warning(String str){
	
		Reporter.log(getTime()+ "   LOG_WARNING:   "+ str);
		LibraryPage.consolePrint(getTime()+ "   LOG_WARNING:  "+ str);
		//Assert.assertTrue(false);
	}


	public static void info(String str){
	
		Reporter.log(getTime()+ "   LOG_INFO:   "+ str);
		LibraryPage.consolePrint(getTime()+ "   LOG_INFO:  "+ str);
		//Assert.assertTrue(false);
}

	public static String getTime(){
		Calendar cal = Calendar.getInstance();	
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(cal.getTime());
	}
	

}
