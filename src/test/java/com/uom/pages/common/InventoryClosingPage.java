package com.uom.pages.common;

import java.lang.reflect.Field;

import com.framework.configuration.ConfigFile;
import com.framework.frameworkFunctions.LibraryPage;
import com.framework.reporting.FrameworkReporter;

public class InventoryClosingPage extends LibraryPage{
	
	static Field[] declaredMemberVariables;
	static{
		declaredMemberVariables =InventoryClosingPage.class.getDeclaredFields();
	}

	public static final String[] lbl_RequiredUpdates={"//*[text()='REQUIRED UPDATES']",XPATH,"lbl_RequiredUpdates"};
	public static final String[] lbl_RequiredUpdatesCount={"//*[text()='REQUIRED UPDATES']//span",XPATH,"lbl_RequiredUpdatesCount"};
	public static final String[] lbl_SuggestedUpdates={"//*[text()='SUGGESTED UPDATES']",XPATH,"lbl_SuggestedUpdates"};
	public static final String[] lbl_SuggestedUpdatesCount={"//*[text()='SUGGESTED UPDATES']//span",XPATH,"lbl_SuggestedUpdatesCount"};
	public static final String[] lnk_AssignExpenseCategories={"//*[text()='REQUIRED UPDATES']/ancestor::div//*[text()='Assign Expense Categories']",XPATH,"lnk_AssignExpenseCategories"};
	public static final String[] lnk_AssignLocations={"//*[text()='SUGGESTED UPDATES']/ancestor::div//*[text()='Assign Locations']",XPATH,"lnk_AssignLocations"};
	/* Functions on the Page are defined below */
	
	/**
	 * @Function verifyRequiredUpdatesLink
	 * @Description To verify Required Updates link
	 * @author Gayathri_Anand
	 * @date 07-12-2016
	 */
	public void verifyRequiredUpdatesLink(){
		    switchToWebContext();
		    if(isElementPresent(lbl_RequiredUpdates)&&!isElementPresent(lbl_RequiredUpdatesCount)){
		    	FrameworkReporter.pass("Required Updates link is displayed without count");
		    }
		    else if(isElementPresent(lbl_RequiredUpdates)&&isElementPresent(lbl_RequiredUpdatesCount)){
		    	FrameworkReporter.fail("Required Updates link is displayed with count");
		    }
		    else{
		    	FrameworkReporter.fail("Required Updates link is not displayed");
		    }
		    verifyTextColor(lbl_RequiredUpdates, "ff3b30");
	}
	/**
	 * @Function verifySuggestedUpdatesLink
	 * @Description To verify Suggested Updates link
	 * @author Gayathri_Anand
	 * @date 07-12-2016
	 */
	public void verifySuggestedUpdatesLink(){
		    switchToWebContext();
		    if(isElementPresent(lbl_SuggestedUpdates)&&!isElementPresent(lbl_SuggestedUpdatesCount)){
		    	FrameworkReporter.pass("Suggested Updates link is displayed without count");
		    }
		    else if(isElementPresent(lbl_SuggestedUpdates)&&isElementPresent(lbl_SuggestedUpdatesCount)){
		    	FrameworkReporter.fail("Suggested Updates link is displayed with count");
		    }
		    else{
		    	FrameworkReporter.fail("Suggested Updates link is not displayed");
		    }
		    verifyTextColor(lbl_SuggestedUpdates, "f18a1f");
	}
	/**
	 * @Function verifyAssignExpenseCategoriesLink
	 * @Description To verify Assign expense Categories link
	 * @author Gayathri_Anand
	 * @date 07-12-2016
	 */
	public void verifyAssignExpenseCategoriesLink(){
		    switchToWebContext();
		    if(isElementPresent(lnk_AssignExpenseCategories)){
		    	FrameworkReporter.pass("Assign Expense Categories link is displayed under Required Updates");
		    }
		    else{
		    	FrameworkReporter.fail("Assign Expense Categories link is not displayed under Required Updates");
		    }
	}
	/**
	 * @Function verifyAssignLocationsLink
	 * @Description To verify Assign Locations link
	 * @author Gayathri_Anand
	 * @date 07-12-2016
	 */
	public void verifyAssignLocationsLink(){
		    switchToWebContext();
		    if(isElementPresent(lnk_AssignLocations)){
		    	FrameworkReporter.pass("Assign Locations link is displayed under Suggested Updates");
		    }
		    else{
		    	FrameworkReporter.fail("Assign Locations link is not displayed under Suggested Updates");
		    }
	}
	/**
	 * @Function verifyUpdateNonSyscoPrices
	 * @Description To verify Update Non Sysco Prices link
	 * @author Gayathri_Anand
	 * @date 
	 */
	public void verifyUpdateNonSyscoPrices(){
		switchToWebContext();
		/* include the required element in the validation
	    if(isElementPresent()){
	    	FrameworkReporter.pass("Update Non Sysco Prices link is displayed under Suggested Updates");
	    }
	    else{
	    	FrameworkReporter.fail("Update Non Sysco Prices link is not displayed under Suggested Updates");
	    }
	    */
	}
	
	/**
	 * @Function verifyAddPurchaseToInventory
	 * @Description To verify Add Purchase to Inventory link
	 * @author Gayathri_Anand
	 * @date 
	 */
	public void verifyAddPurchaseToInventory(){
		switchToWebContext();
		/* include the required element in the validation
	    if(isElementPresent()){
	    	FrameworkReporter.pass("Add Purchase to Inventory link is displayed under Suggested Updates");
	    }
	    else{
	    	FrameworkReporter.fail("Add Purchase to Inventory link is not displayed under Suggested Updates");
	    }
	    */
	}
	/**
	 * @Function verifyViewUncountedItems
	 * @Description To verify View Uncounted Items link
	 * @author Gayathri_Anand
	 * @date 
	 */
	public void verifyViewUncountedItems(){
		switchToWebContext();
		/* include the required element in the validation
	    if(isElementPresent()){
	    	FrameworkReporter.pass("View Uncounted Items link is displayed under Suggested Updates");
	    }
	    else{
	    	FrameworkReporter.fail("View Uncounted Items link is not displayed under Suggested Updates");
	    }
	    */
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
					//childClassObject= new IOSInventoryClosingPage().findChildObject(parentObject[2]);	
					break;
				case "ipad":	
					//childClassObject = new IOSTabletInventoryClosingPage().findChildObject(parentObject[2]);	
					break;
				case "android":
					//childClassObject = new AndroidInventoryClosingPage().findChildObject(parentObject[2]);					
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
