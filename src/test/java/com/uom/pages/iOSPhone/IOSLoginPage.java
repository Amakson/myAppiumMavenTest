		
		/**
		 ********************************************************************************************************************************************
		 ********************************************************************************************************************************************
		 *																																		   	*
		 * 2016-2017 Infosys Limited, Banglore, India. All Rights Reserved																			*

		 * Version: 1.0																																*
		 * 																																			*
		 * Except for any free or open source software components embedded in this Infosys proprietary software program ("Program"),				*
		 * this Program is protected by copyright laws, international treaties and other pending or existing intellectual property rights in India, *
		 * the United States and other countries. Except as expressly permitted, any unautorized reproduction, storage, transmission 				*
		 * in any form or by any means (including without limitation electronic, mechanical, printing, photocopying, recording or otherwise), 		*
		 * or any distribution of this Program, or any portion of it, may result in severe civil and criminal penalties, 							*
		 * and will be prosecuted to the maximum extent possible under the law 																		*
		 *																																			*
		 ********************************************************************************************************************************************
		 ********************************************************************************************************************************************
		 **/																		

package com.uom.pages.iOSPhone;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.Reporter;

import com.framework.frameworkFunctions.LibraryPage;
import com.framework.reporting.FrameworkReporter;
import com.uom.commonFunctions.FunctionLibrary;
import com.uom.pages.androidPhone.AndroidSuppliersPage;
import com.uom.pages.common.LoginPage;


public class IOSLoginPage extends LoginPage {
	
	public static final String[] txt_UserName = {"username",ID,"txt_UserName"};
	public static final String[] txt_Password = {"password",ID,"txt_Password"};
	public static final String[] rbtn_SaveUsername = {"save-username",ID,"rbtn_SaveUsername"};
	public static final String[] btn_Login = {"login-button",ID,"btn_Login"};

	/* Functions on the Page are defined below */
	
	
	/**
	 * @function enterUserName
	 * @author Periyasamy Nainar
	 * @description Enter username to login to UOM app
	 * @param strUserName - Username
	 * @date 21-09-2016
	 */

	public LoginPage enterUserName(String strUserName){
		waitForElementPresent(txt_UserName);
		sendText(txt_UserName, strUserName);
		FrameworkReporter.info("Enter username :"+ strUserName);
		consolePrint("Enter username :"+ strUserName);
		return this;
	}
	
	/**
	 * @function enterPassword
	 * @author Periyasamy Nainar
	 * @description Enter password to login to UOM app
	 * @param strPassword - Password value
	 * @date 21-09-2016
	 */

	public LoginPage enterPassword(String strPassword){
		waitForElementPresent(txt_Password);
		sendText(txt_Password, strPassword);
		FrameworkReporter.info("Enter password :"+ strPassword);
		consolePrint("Enter password :"+ strPassword);
		return this;
	}
	
	/**
	 * @function selectRememberUserName
	 * @author Periyasamy Nainar
	 * @description Tap on remember username radio button
	 * @date 21-09-2016
	 */

	public LoginPage selectRememberUserName(){
		clickElement(rbtn_SaveUsername);   // wait for target present is handled inside the framework(inside click method )		
		return this;
	}
	
	/**
	 * @function tapLogin
	 * @author Periyasamy Nainar
	 * @description Tap on login button
	 * @date 21-09-2016
	 */

	public LoginPage tapLogin(){
		clickElement(btn_Login);
		FrameworkReporter.info("Tapped on Login button");
		consolePrint("Tapped on Login button");
		return this;
	}
	
	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqLocatorName){	
		Field childObjects;
		try {
			childObjects = IOSLoginPage.class.getDeclaredField(reqLocatorName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (IOSLoginPage.class.getDeclaredField(reqLocatorName).get(null));
			return childObject;
		}
 
		}  catch (Exception e) {
			e.printStackTrace();
		}	
	return null;

}

}
