		
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
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.Reporter;

import com.framework.frameworkFunctions.LibraryPage;
import com.framework.reporting.FrameworkReporter;
import com.uom.commonFunctions.FunctionLibrary;
import com.uom.pages.androidPhone.AndroidSuppliersPage;
import com.uom.pages.common.HomePage;




public class IOSHomePage extends HomePage{
	
	public static final String[] lnk_TrackInventory = {"//span[text()='Track Inventory']",XPATH,"lnk_TrackInventory"};
	public static final String[] lnk_SetupExpenseCategories = {"//span[text()='Setup Expense Categories']",XPATH,"lnk_SetupExpenseCategories"};
	public static final String[] lnk_Suppliers = {"//span[text()='Suppliers']",XPATH,"lnk_Suppliers"};
	public static final String[] lnk_Locations= {"//span[text()='Locations']",XPATH,"lnk_Locations"};
	public static final String[] lnk_CreateNonSyscoItem= {"//span[text()='Create Non-Sysco Item']",XPATH,"lnk_CreateNonSyscoItem"};
	public static final String[] lnk_CreatePrepItem= {"//span[text()='Create Prep Item']",XPATH,"lnk_CreatePrepItem"};
	public static final String[] btn_HamburgerMenu = {"hamburger-nav",ID,"btn_HamburgerMenu"};
	public static final String[] btn_HamburgerLogout = {"//span[contains(text(),'Logout')]",XPATH,"btn_HamburgerLogout"};
	



	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqLocatorName){	
		Field childObjects;
		try {
			childObjects = IOSHomePage.class.getDeclaredField(reqLocatorName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (IOSHomePage.class.getDeclaredField(reqLocatorName).get(null));
			return childObject;
		}
 
		}  catch (Exception e) {
			e.printStackTrace();
		}	
	return null;

}


	

	
	
}