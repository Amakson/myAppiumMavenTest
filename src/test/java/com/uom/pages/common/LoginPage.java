		
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

package com.uom.pages.common;


import java.lang.reflect.Field;

import org.openqa.selenium.WebElement;

import com.framework.Starter;
import com.framework.configuration.ConfigFile;
import com.framework.frameworkFunctions.LibraryPage;
import com.framework.reporting.FrameworkReporter;
import com.uom.pages.androidPhone.AndroidLoginPage;
import com.uom.pages.iOSPhone.IOSAccountsPage;
import com.uom.pages.iOSPhone.IOSLoginPage;
import com.uom.pages.iOSTablet.IOSTabletLoginPage;

import io.appium.java_client.AppiumDriver;



public class LoginPage extends LibraryPage {
	static Field[] declaredMemberVariables;
	static{
		declaredMemberVariables = LoginPage.class.getDeclaredFields();
	}
	public static final String[] txt_UserName = {"username",ID,"txt_UserName"};
	public static final String[] txt_Password = {"password",ID,"txt_Password"};
	public static final String[] rbtn_SaveUsername = {"//input[@id='save-username']/parent::*",XPATH,"rbtn_SaveUsername"};
	public static final String[] btn_Login = {"login-button",ID,"btn_Login"};
	public static final String[] lbl_UserName = {"//label[text()='USERNAME']",XPATH,"lbl_UserName"};
	public static final String[] lbl_Password = {"//label[text()='PASSWORD']",XPATH,"lbl_Password"};
	public static final String[] lbl_SaveUserName = {"//label[text()='Save Username']",XPATH,"lbl_SaveUserName"};
	public static final String[] lbl_LoginButton = {"//button[text()='{dynamic1}']",XPATH,"lbl_LoginButton"};
	
	public static final String[] lbl_AuthenticationFail = {"//div[@class='mm-u-alert']",XPATH,"lbl_AuthenticationFail"};
	
	//native ele
	
	public static final String[] rbtn_SaveUserNameChecked = {"//*[@value='{dynamic1}']",XPATH,"rbtn_SaveUserNameChecked"};

	
	/* Functions on the Page are defined below */
	
	 // wait for target present is handled inside the framework(inside click method )	
	
	/**
	 * @function enterUserName
	 * @author Periyasamy Nainar
	 * @description Enter username to login to UOM app
	 * @param strUserName - Username
	 * @date 21-09-2016
	 */

	public LoginPage enterUserName(String strUserName){		
		
		switchToWebContext();		
		sendText(txt_UserName, strUserName);	
		//FrameworkReporter.info("Enter username :"+ strUserName);		
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
						
		switchToWebContext();
		sendText(txt_Password, strPassword);
		//FrameworkReporter.info("Enter password :"+ strPassword);
		return this;
	}
	
	/**
	 * @function selectRememberUserName
	 * @author Periyasamy Nainar
	 * @description Tap on remember username radio button
	 * @date 21-09-2016
	 */

	public LoginPage selectRememberUserName(){
		switchToWebContext();
		clickElement(rbtn_SaveUsername);  	
		return this;
	}
	
	/**
	 * @function tapLogin
	 * @author Periyasamy Nainar
	 * @description Tap on login button
	 * @date 21-09-2016
	 */

	public LoginPage tapLogin(){
		switchToWebContext();
		clickElement(btn_Login);
		FrameworkReporter.info("User is logged into UOM Application with valid credentials");
		return this;
	}
	
	
	/**
	 * @function verifyLoginPageFields
	 * @author Periyasamy Nainar
	 * @description Verify all fields in login page 
	 * @date 15-10-2016
	 */

	public LoginPage verifyLoginPageFields(){
		waitFor(4);
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_UserName, 8) && isElementPresentAfterWait(txt_UserName, 2)){
			FrameworkReporter.pass("Username label and text box is displayed in Login page");
		}else{
			FrameworkReporter.fail("Username label and text box is not displayed in Login page");
		}
		
		if(isElementPresentAfterWait(lbl_Password, 2) && isElementPresentAfterWait(txt_Password, 2)){
			FrameworkReporter.pass("Password label and text box is displayed in Login page");
		}else{
			FrameworkReporter.fail("Password label and text box is displayed in Login page");
		}
		
		if(isElementPresentAfterWait(rbtn_SaveUsername, 2)){
			if(isElementPresentAfterWait(lbl_SaveUserName, 2))
			FrameworkReporter.pass("Save username label and text box is displayed in Login page");
		}else{
			FrameworkReporter.fail("Save username label and text box is displayed in Login page");
		}
		if(isElementPresentAfterWait(btn_Login,2) && isElementPresentAfterWait(replaceDynamicText(lbl_LoginButton,"Login"),2)){
			FrameworkReporter.pass("Login button is displayed in Login page");
		}else{
			FrameworkReporter.fail("Login button is displayed in Login page");
		}
		return this;
	}
	
	/**
	 * @function verifyAuthenticationErrorMsg
	 * @author Periyasamy Nainar
	 * @description Verify authentication error when the user tries to login to app with invalid password
	 * @date 15-10-2016
	 */

	public LoginPage verifyAuthenticationErrorMsg(){
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_AuthenticationFail, 8) && (getElementText(lbl_AuthenticationFail).equalsIgnoreCase("User authentication failed"))){
			FrameworkReporter.pass("Authentication failed error message"+  getElementText(lbl_AuthenticationFail) + "is displayed in login page when the user tried to login wiht invalid password");
		}else{
			FrameworkReporter.fail("Authentication failed error message"+ getElementText(lbl_AuthenticationFail) + "is not displayed in login page when the user tried to login wiht invalid password");
		}
		
		return this;
	}
	
	/**
	 * @function verifyOfflineErrorMsg
	 * @author Periyasamy Nainar
	 * @description Verify offline error message is displayed when the user is login to uom application in offline
	 * @date 15-10-2016
	 */

	public LoginPage verifyOfflineErrorMsg(){
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_AuthenticationFail, 8) && (getElementText(lbl_AuthenticationFail).replace("\n", "").replace("\r", "").replace(" ", "").toUpperCase().
				equalsIgnoreCase("No Connection".replace("\n", "").replace("\r", "").replace(" ", "").toUpperCase()))){
				//equalsIgnoreCase("Request has been terminatedPossible causes: the network is offline, Origin is not allowed by Access-Control-Allow-Origin, the page is being unloaded, etc.".replace("\n", "").replace("\r", "").replace(" ", "").toUpperCase()))){
			FrameworkReporter.pass("Authentication failed error message"+  getElementText(lbl_AuthenticationFail) + "is displayed in login page when the user tried to login with invalid password");
		}else{
			FrameworkReporter.fail("Authentication failed error message"+ getElementText(lbl_AuthenticationFail) + "is not displayed in login page when the user tried to login with invalid password");
		}
		
		return this;
	}
	
	
	
	/**
	 * @function verifySaveUserNameIsSelected
	 * @author Periyasamy Nainar
	 * @description Verify save username radio button is selected when the user click on it 
	 * @date 15-10-2016
	 */

	public LoginPage verifySaveUserNameIsSelected(boolean boolVal){
	
		
		switchToNativeContext();			
		String str = "";
		if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
			 str = Boolean.toString(boolVal);
		}
		else{   // For ios - 1 for selected and 0 for not selected 
			if(boolVal){
				str = "1";
			}else{
				str = "0";
				}				
		}
						
		if(isElementPresentAfterWait(replaceDynamicText(getObject(rbtn_SaveUserNameChecked), str), 10)){
				if(boolVal){
					FrameworkReporter.pass("Save username radio button is selected when the user is tapped on it");     // for true case
				}else{
					FrameworkReporter.pass("Save username radio button is not selected when the user is not tapped on it");  // for false case
				}
				
			}else{
				if(boolVal){
					FrameworkReporter.fail("Save username radio button is not selected when the user is tapped on it");
				}else{
					FrameworkReporter.fail("Save username radio button is selected when the user is not tapped on it");
				}
			}
				
	
		return this;
	}
	
	
	/**
	 * @function verifySavedUserNameAutoPopulated
	 * @author Periyasamy Nainar
	 * @description Verify user name is auto populated when the user is click on save username while login to the in previous session
	 * @param strUserName - Username to be auto populated
	 * @date 16-10-2016
	 */

	public LoginPage verifySavedUserNameAutoPopulated(String strUserName){
		switchToWebContext();		
		if(getElementAttributeValue(txt_UserName, "value").toString().equalsIgnoreCase(strUserName)){
			FrameworkReporter.pass("Saved username is autopopulated in user name field in login page");
		}else{
			FrameworkReporter.fail("Saved username is not populated automatically in duser name field in login page");
		}
		
		return this;
	}
	
	
	/**
	 * @function verifyUserNameNotAutoPopulated
	 * @author Periyasamy Nainar
	 * @description Verify user name is not auto populated when the user is not click on save username while login to the in previous session
	 * @date 16-10-2016
	 */

	public LoginPage verifyUserNameNotAutoPopulated(){
		switchToWebContext();		
		if(getElementAttributeValue(txt_UserName, "value").toString().isEmpty()){
			FrameworkReporter.pass("Username is not autopopoulated as the user is not clicked on save username and username field is having empty value");
		}else{
			FrameworkReporter.fail("Username is autopopoulated as the user is not clicked on save username and username field is not having empty value");
		}
		
		return this;
	}
	
	/**
	 * @function verifySavedUserNameAutoPopulated
	 * @author Periyasamy Nainar
	 * @description Verify user name is auto populated when the user is click on save username while login to the in previous session
	 * @date 15-10-2016
	 */

	public LoginPage verifyLoginButtonStateChanges(){
		switchToWebContext();
		
		if(isElementPresentAfterWait(btn_Login,2) && isElementPresentAfterWait(replaceDynamicText(lbl_LoginButton,"Submitting..."),1)){
			FrameworkReporter.pass("Login button state is changed to submitting... when the user tapped on login button");
		}else{
			FrameworkReporter.fail("Login button state is not changed to submitting... when the user tapped on login button");
		}
		//verify background color
		//verifyBackGroundColor(btn_Login, "C5B84");
		
		return this;
	}
	
	
	
	
	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] getObject(String[] parentObject)
	{
		
		String[] childClassObject =null;
		String brand =ConfigFile.getProperty("brand").toString().toLowerCase().trim();
		switch (brand) {
				case "iphone":				
					//childClassObject= new IOSLoginPage().findChildObject(parentObject[2]);	
					break;
				case "ipad":	
					childClassObject = new IOSTabletLoginPage().findChildObject(parentObject[2]);	
					break;
				case "android":
					childClassObject = new AndroidLoginPage().findChildObject(parentObject[2]);					
					break;
				case "android tablet":
					break;
					
				case "desktop":
					break;
				default:
					break;
				}
			
			if(null!=childClassObject){
				return childClassObject;}
				
	return parentObject;
	}
}
