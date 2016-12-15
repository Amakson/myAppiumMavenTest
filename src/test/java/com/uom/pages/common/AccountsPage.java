package com.uom.pages.common;
		
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


import java.lang.reflect.Field;
import com.framework.frameworkFunctions.*;
import com.framework.reporting.FrameworkReporter;
import com.uom.pages.androidPhone.AndroidAccountsPage;
import com.uom.pages.iOSTablet.IOSTabletAccountsPage;
import com.framework.configuration.*;


public class AccountsPage extends LibraryPage{
	
	static Field[] declaredMemberVariables;
	static{
		declaredMemberVariables = AccountsPage.class.getDeclaredFields();
	}		

	

	

	/*********	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] getObject(String[] parentObject)
	{
		
		String[] childClassObject =null;
		String brand =ConfigFile.getProperty("brand").toString().toLowerCase().trim();
		switch (brand) {
				case "iphone":				
					//childClassObject= new IOSAccountsPage().findChildObject(parentObject[2]);	
					break;
				case "ipad":	
					childClassObject = new IOSTabletAccountsPage().findChildObject(parentObject[2]);	
					break;
				case "android":
					childClassObject = new AndroidAccountsPage().findChildObject(parentObject[2]);					
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
