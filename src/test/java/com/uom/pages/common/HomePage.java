		
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
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.framework.configuration.ConfigFile;
import com.framework.frameworkFunctions.LibraryPage;
import com.framework.reporting.FrameworkReporter;
import com.uom.pageFactory.PageFactory;
import com.uom.pages.androidPhone.AndroidHomePage;
import com.uom.pages.iOSPhone.IOSHomePage;
import com.uom.pages.iOSTablet.IOSTabletHomePage;

import io.appium.java_client.ios.IOSDriver;

import java.util.Date;

import org.openqa.selenium.WebElement;




public class HomePage extends LibraryPage{
	static Field[] declaredMemberVariables;
	static{
		declaredMemberVariables = HomePage.class.getDeclaredFields();
	}
	
	public static final String[] lnk_TrackInventory = {"//span[text()='Track Inventory']",XPATH,"lnk_TrackInventory"};
	public static final String[] lnk_SetupExpenseCategories = {"//span[contains(text(),'Expense Categories')]",XPATH,"lnk_SetupExpenseCategories"};
	public static final String[] lnk_Suppliers = {"//span[text()='Suppliers']",XPATH,"lnk_Suppliers"};
	public static final String[] lnk_Locations= {"//span[text()='Locations']",XPATH,"lnk_Locations"};
	public static final String[] lnk_SetupLocations= {"//span[text()='Setup Locations']",XPATH,"lnk_SetupLocations"};
	public static final String[] lnk_CreateNonSyscoItem= {"//span[text()='Create Non-Sysco Item']",XPATH,"lnk_CreateNonSyscoItem"};
	public static final String[] lnk_CreatePrepItem= {"//span[text()='Create Prep Item']",XPATH,"lnk_CreatePrepItem"};
	public static final String[] btn_HamburgerMenu = {"//UIAWebView[1]/UIAButton[2]",XPATH,"btn_HamburgerMenu"};
	public static final String[] btn_HamburgerLogout = {"//UIALink[contains(@label,'Logout')]",XPATH,"btn_HamburgerLogout"};
	
	public static final String[] txt_SetupInventory = {"//span[text()='Setup Inventory']",XPATH,"txt_SetupInventory"};	
	public static final String[] lnk_Purchases = {"//span[text()='Purchases']",XPATH,"lnk_Purchases"};

	//updated xpath for the below object
	//public static final String[] txt_SetupInventory = {"",XPATH,"txt_SetupInventory"};
	
	public static final String[] btn_CloseInventory={"//button[text()='Close Inventory']",XPATH,"btn_CloseInventory"};
	public static final String[] lbl_CloseInventoryConfirmation={"//*[@id='modal-body' and contains(text(),'Are you sure you want to close inventory for the current period?')]",XPATH,"lbl_CloseInventoryConfirmation"};
	public static final String[] lbl_CloseInventorySuccessMessage={"//*[@id='modal-title' and contains(text(),'Inventory Closed Successfully!')]",XPATH,"lbl_CloseInventorySuccessMessage"};
	public static final String[] lnk_InventoryNotUptoDateMessage={"//span[text()='Inventory is Not Up to Date']",XPATH,"lnk_InventoryNotUptoDateMessage"};
	public static final String[] lbl_InventoryClosingPage={"//*[text()='Inventory Closing']",XPATH,"lbl_InventoryClosingPage"};
	public static final String[] lnk_AssignExpenseCategories={"//*[text()='Assign Expense Categories']",XPATH,"lnk_AssignExpenseCategories"};
	public static final String[] lbl_AssignExpensesPage={"//*[text()='Assign Expenses']",XPATH,"lbl_AssignExpensesPage"};
	public static final String[] lnk_AssignLocations={"//*[text()='Assign Locations']",XPATH,"lnk_AssignLocations"};
	public static final String[] lbl_AssignLocationsPage={"//*[text()='Assign Locations']",XPATH,"lbl_AssignLocationsPage"};
	
	
	public static final String[] lbl_InventoryTools={"//span[@class='navbar-brand']/*[text()='Inventory Tools']",XPATH,"lbl_InventoryTools"};
	public static final String[] lnk_ViewFoodCost = {"//span[text()='View Food Cost']",XPATH,"lnk_ViewFoodCost"};
	
	
	
	public static final String[] lnk_DisableTrackInventory = {"//span[text()='Track Inventory']",XPATH,"lnk_DisableTrackInventory"};
	public static final String[] lnk_DisablePurchases = {"//span[text()='Purchases']",XPATH,"lnk_DisablePurchases"};
	public static final String[] lnk_DisableFoodCost = {"//span[text()='View Food Cost']",XPATH,"lnk_DisableFoodCost"};	
	
	public static final String[] lnk_DisableSetupExpenseCategories = {"//span[contains(text(),'Expense Categories')]",XPATH,"lnk_DisableSetupExpenseCategories"};	
	public static final String[] lnk_DisableSetupLocations= {"//span[text()='Setup Locations']",XPATH,"lnk_DisableSetupLocations"};
	public static final String[] lnk_DisableSuppliers = {"//span[text()='Suppliers']",XPATH,"lnk_DisableSuppliers"};
	public static final String[] lnk_DisableCreateNonSyscoItem= {"//span[text()='Create Non-Sysco Item']",XPATH,"lnk_DisableCreateNonSyscoItem"};
	public static final String[] lnk_DisableCreatePrepItem= {"//span[text()='Create Prep Item']",XPATH,"lnk_DisableCreatePrepItem"};
	public static final String[] lnk_EnableSetupInventory = {"//span[@class='list-group-item']//span[text()='Setup Inventory']",XPATH,"lnk_EnableSetupInventory"};	
	
	public static final String[] lnk_EnabledLinks= {"//span[@class='list-group-item']",XPATH,"lnk_EnabledLinks"};	
	public static final String[] lnk_DisabledLinks= {"//span[@class='list-group-item disabled']",XPATH,"lnk_DisabledLinks"};	

	public static final String[] lnk_ViewReporting = {"//span[text()='View Reporting']",XPATH,"lnk_ViewReporting"};

	public static final String[] lnk_CloseInventory={"//div[@class='mm-c-chart']",XPATH,"lnk_CloseInventory"};

	

	
	//console print is not required inside the function as its written inside framework reporter functions, will be called automatically while using info, pass, fail functions
	
	/**
	 * @function tapTrackInventory
	 * @author Periyasamy Nainar
	 * @description Tap on Track inventory link from Inventory Tools page
	 * @date 21-09-2016
	 */

	public void tapTrackInventory(){
		switchToWebContext();
		waitForElementToBeClickable(lnk_TrackInventory);
		clickElement(lnk_TrackInventory);
		FrameworkReporter.info("Tapped on Track inventory from Inventory Tools Page");
		
	}
	
	

	/**
	 * @function tapSuppliers
	 * @author Periyasamy Nainar
	 * @description Tap on suppliers link from Inventory Tools page
	 * @date 21-09-2016
	 */

	public void tapSuppliers(){
		switchToWebContext();
	
		clickElement(lnk_Suppliers);
		FrameworkReporter.info("Tapped on Suppliers link from Inventory Tools Page");
		
	}
	

	/**
	 * @function tapLocations
	 * @author Periyasamy Nainar
	 * @description Tap on Locations link from Inventory Tools page
	 * @date 21-09-2016
	 */

	public void tapLocations(){
		switchToWebContext();
		clickElement(lnk_Locations);
		FrameworkReporter.info("Tapped on Locations from Inventory Tools Page");
		
	}
	
	/**
	 * @function tapSetupLocations
	 * @author Periyasamy Nainar
	 * @description Tap on Setup Locations link from Inventory Tools page
	 * @date 21-09-2016
	 */

	public void tapSetupLocations(){
		switchToWebContext();
		clickElement(lnk_SetupLocations);
		FrameworkReporter.info("Tapped on Setup Locations from Inventory Tools Page");
		
	}
	
	/**
	 * @function tapExpenseCategories
	 * @author Periyasamy Nainar
	 * @description Tap on Expense categories link from Inventory Tools page
	 * @date 21-09-2016
	 */

	public void tapExpenseCategories(){
		switchToWebContext();
		if(isElementClickableAfterWait(lnk_SetupExpenseCategories, 20)){
		clickElement(lnk_SetupExpenseCategories);
		FrameworkReporter.info("Tapped on Expense categories from Inventory Tools Page");
		}
	}

	
	/**
	 * @function tapCreateNonSyscoItem
	 * @author Periyasamy Nainar
	 * @description Tap on Create non sysco item link from Inventory Tools page
	 * @date 21-09-2016
	 */

	public HomePage tapCreateNonSyscoItem(){
		switchToWebContext();
		clickElement(lnk_CreateNonSyscoItem);
		FrameworkReporter.info("Tapped on Create non sysco item from Inventory Tools Page");
		return this;
	}
	
	/**
	 * @function tapCreatePrepItem
	 * @author Periyasamy Nainar
	 * @description Tap on Create prep item link from Inventory Tools page
	 * @date 21-09-2016
	 */

	public HomePage tapCreatePrepItem(){
		switchToWebContext();
		clickElement(lnk_CreatePrepItem);
		FrameworkReporter.info("Tapped on Create prep item from Inventory Tools Page");
		return this;
	}
	
	
	/**
	 * @function tapCreatePrepItem
	 * @author Periyasamy Nainar
	 * @description Tap on Create prep item link from Inventory Tools page
	 * @date 21-09-2016
	 */

	public HomePage logout(int...backCount){
		PageFactory pf=new PageFactory();
		if(backCount.length >0 &&backCount[0]>0)
		
		{
			for(int i=1;i<=backCount[0];i++){
				waitFor(1);
				pf.generic().tapBack();
			}
		}
		if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
		switchToWebContext();
		
		}
		else{
			switchToNativeContext();
			
			
		
		}
		if(isElementPresentAfterWait(getObject(btn_HamburgerMenu), 2)){
			clickElement(getObject(btn_HamburgerMenu));
			waitFor(2);
			waitForElementToBeClickable(btn_HamburgerLogout);
			clickElement(getObject(btn_HamburgerLogout));
		}
		FrameworkReporter.info("Tapped on logout button to logout from UOM Application");
		return this;
	}
	
	
	 /**
     * @function tapSetupInventory
     * @author Arun_Mathai
     * @description Tapped on setup inventory from Home page
     * @date 27-09-2016
     */
	public HomePage tapSetupInventory()
	{
		switchToWebContext();
		if(isElementClickableAfterWait(txt_SetupInventory, 10)){
		clickElement(txt_SetupInventory);
		FrameworkReporter.info("Tapped on setup inventory");
		}
		storeValue("SetupExpenseOnboarding", false);
		storeValue("SetupExpenseCloseInventory", false);
		return this;
	}

	/**
	 * @function logoutAfterCheck
	 * @author Parvathy
	 * @description Tap on Create prep item link from Inventory Tools page
	 * @date 04-10-2016
	 */

	public void logoutAfterCheck(){
		switchToWebContext();
		if(! isElementPresentAfterWait(LoginPage.txt_UserName,2))
		{			
			logout();			
		}
		
	}

	
	/**
	 * @function verifySetupLocations
	 * @author Periyasamy Nainar
	 * @description verify setup locations link is displayed in home page once the user delete all locations
	 * @date 06-10-2016
	 */

	public void verifySetupLocations(){
		switchToWebContext();
		if(isElementPresentAfterWait(lnk_SetupLocations, 5)){
			FrameworkReporter.pass("Setup locations link is dispalyed in home page after deleting all locations");
		}else{
			FrameworkReporter.fail("Setup locations link is not dispalyed in home page after deleting all locations");
		}
	}
	
	/**
	 * @function verifyCloseInventoryLinkDisplayed
	 * @author Aneesh
	 * @description verify close inventory link is displayed or not
	 * @date 13-10-2016
	 */

	public void verifyCloseInventoryLinkDisplayed(boolean isExpected){
		switchToWebContext();
		if(isExpected){
		if(isElementPresentAfterWait(lnk_CloseInventory, 5)){
			FrameworkReporter.pass("Close Inventory chart link is dispalyed in home page");
		}else{
			FrameworkReporter.fail("Close Inventory chart link is not dispalyed in home page");
		}
		}
		else{
			if(!isElementPresentAfterWait(lnk_CloseInventory, 5)){
				FrameworkReporter.pass("Close Inventory chart link is not dispalyed in home page");
			}else{
				FrameworkReporter.fail("Close Inventory chart link is dispalyed in home page");
			}
		}
	}
	/**
	 * @function verifyCloseInventoryButtonDisplayed
	 * @author Gayathri Anand
	 * @description verify close inventory button is displayed or not
	 * @date 13-10-2016
	 */

	public void verifyCloseInventoryButtonDisplayed(boolean isExpected){
		switchToWebContext();
		if(isExpected){
		if(isElementPresentAfterWait(btn_CloseInventory, 5)){
			FrameworkReporter.pass("Close Inventory button is dispalyed in home page");
		}else{
			FrameworkReporter.fail("Close Inventory button is not dispalyed in home page");
		}
		}
		else{
			if(!isElementPresentAfterWait(btn_CloseInventory, 5)){
				FrameworkReporter.pass("Close Inventory button is not dispalyed in home page");
			}else{
				FrameworkReporter.fail("Close Inventory button is dispalyed in home page");
			}
		}
	}
	/**
	 * @function tapOnCloseInventory
	 * @author Gayathri Anand
	 * @description Tap on close inventory button
	 * @date 13-10-2016
	 */

	public void tapOnCloseInventory(){
		switchToWebContext();
		
		waitForPageLoadAndroid(5);
		clickElement(btn_CloseInventory);
		FrameworkReporter.info("Tapped on Close Inventory button");
	}
	
	/**
	 * @function tapOnCloseInventoryLink
	 * @author Aneesh
	 * @description Tap on close inventory link
	 * @date 14-12-2016
	 */

	public void tapOnCloseInventoryLink(){
		switchToWebContext();
		waitForPageLoadAndroid(5);
		clickElement(lnk_CloseInventory);
		FrameworkReporter.info("Tapped on Close Inventory link chart");
		
	}
	
	/**
	 * @Function verifyCloseInventoryConfirmationPopUp
	 * @Description Verify close inventory confirmation message popup
	 * @author Gayathri_Anand
	 * @date 13-10-2016
	 */
	public void verifyCloseInventoryConfirmationPopUp(){
		switchToWebContext();	

		waitForPageLoadAndroid(4);
		if(isElementPresentAfterWait(lbl_CloseInventoryConfirmation,10)){
			FrameworkReporter.pass("Confirmation message to close inventory is displayed");
		}
		else{
			FrameworkReporter.fail("Confirmation message to close inventory is not displayed");
		}
	}
	
	/**
	 * @Function verifyCloseInventorySuccessMessage
	 * @Description Verify close inventory success message is displayed or not
	 * @author Gayathri_Anand
	 * @date 14-10-2016
	 */
	public void verifyCloseInventorySuccessMessage(boolean isExpected){
		switchToWebContext();
		if(isExpected){
			if(isElementPresentAfterWait(lbl_CloseInventorySuccessMessage,10)){
				FrameworkReporter.pass("Close Inventory success message is displayed");
			}else{
				FrameworkReporter.fail("Close Inventory success message is not displayed");
			}
			}
			else{
				if(!isElementPresent(lbl_CloseInventorySuccessMessage)){
					FrameworkReporter.pass("Close Inventory success message is not displayed");
				}else{
					FrameworkReporter.fail("Close Inventory success message is  displayed");
				}
			}
	}
	/**
	 * @function verifyCloseInventoryButtonEnabled
	 * @author Gayathri Anand
	 * @description verify close inventory button is enabled or not
	 * @date 13-10-2016
	 */

	public void verifyCloseInventoryLinkEnabled(boolean isExpected){
		switchToWebContext();
		if(isExpected){
		if(isElementEnabled(lnk_CloseInventory)){
			FrameworkReporter.pass("Close Inventory chart link is enabled");
		}else{
			FrameworkReporter.fail("Close Inventory chart link is not enabled");
		}
		}
		else{
			if(!isElementEnabled(lnk_CloseInventory)){
				FrameworkReporter.pass("Close Inventory chart link is disabled");
			}else{
				FrameworkReporter.fail("Close Inventory chart link is not disabled");
			}
		}
	}
	/**
	 * @Function verifyInventoryNotUptoDateMessage
	 * @Description Verify inventory not upto date message is displayed or not
	 * @author Gayathri_Anand
	 * @date 14-10-2016
	 */
	public void verifyInventoryNotUptoDateMessage(boolean isExpected){
		switchToWebContext();
		if(isExpected){
			if(isElementPresentAfterWait(lnk_InventoryNotUptoDateMessage, 5)){
				FrameworkReporter.pass("Inventory Not Up To Date message is displayed");
			}else{
				FrameworkReporter.fail("Inventory Not Up To Date message is not displayed");
			}
			}
			else{
				if(!isElementPresent(lnk_InventoryNotUptoDateMessage)){
					FrameworkReporter.pass("Inventory Not Up To Date message is not displayed");
				}else{
					FrameworkReporter.fail("Inventory Not Up To Date message is  displayed");
				}
			}
	}
	/**
	 * @function tapOnInventoryNotUptoDate
	 * @author Gayathri Anand
	 * @description Tap on inventory not upto date link
	 * @date 14-10-2016
	 */

	public void tapOnInventoryNotUptoDate(){
		switchToWebContext();
		clickElement(lnk_InventoryNotUptoDateMessage);
		FrameworkReporter.info("Tapped on inventory not upto date link");
	}
	
	/**
	 * @Function verifyInventoryClosingPageIsDisplayed
	 * @Description Verify Inventory Closing page is displayed
	 * @author Gayathri_Anand
	 * @date 14-10-2016
	 */
	public void verifyInventoryClosingPageIsDisplayed(){
		switchToWebContext();
		if(isElementPresent(lbl_InventoryClosingPage)){
			FrameworkReporter.pass("Inventory Closing page is displayed");
		}
		else{
			FrameworkReporter.fail("Inventory Closing page is not displayed");
		}
	}
	/**
	 * @function tapOnAssignExpenseCategories
	 * @author Gayathri_Anand
	 * @description Tap on Assign Expense categories link from Inventory Closing page
	 * @date 14-10-2016
	 */

	public void tapOnAssignExpenseCategories(){
		switchToWebContext();
		if(isElementClickableAfterWait(lnk_AssignExpenseCategories, 20)){
		clickElement(lnk_AssignExpenseCategories);
		FrameworkReporter.info("Tapped on Assign Expense categories link from Inventory Closing page");
		storeValue("SetupExpenseCloseInventory", true);
		}
	}
	/**
	 * @Function verifyAssignExpensesWorkFlowScreenIsDisplayed
	 * @Description Verify Assign Expenses Workflow screen is displayed
	 * @author Gayathri_Anand
	 * @date 14-10-2016
	 */
	public void verifyAssignExpensesWorkFlowScreenIsDisplayed(){
		switchToWebContext();
		if(isElementPresent(lbl_AssignExpensesPage)){
			FrameworkReporter.pass("Assign Expenses Workflow screen is displayed");
		}
		else{
			FrameworkReporter.fail("Assign Expenses Workflow screen is not displayed");
		}
	}
	/**
	 * @function tapOnAssignLocoations
	 * @author Gayathri_Anand
	 * @description Tap on Assign Locations link from Inventory Closing page
	 * @date 14-10-2016
	 */

	public void tapOnAssignLocoations(){
		switchToWebContext();
		if(isElementClickableAfterWait(lnk_AssignLocations, 20)){
		clickElement(lnk_AssignLocations);
		FrameworkReporter.info("Tapped on Assign Locations link from Inventory Closing page");
		storeValue("SetupLocationsCloseInventory", true);
		}
	}
	/**
	 * @Function verifyAssignLocationsWorkFlowScreenIsDisplayed
	 * @Description Verify Assign Locations Workflow screen is displayed
	 * @author Gayathri_Anand
	 * @date 14-10-2016
	 */
	public void verifyAssignLocationsWorkFlowScreenIsDisplayed(){
		switchToWebContext();
		if(isElementPresent(lbl_AssignLocationsPage)){
			FrameworkReporter.pass("Assign Locations Workflow screen is displayed");
		}
		else{
			FrameworkReporter.fail("Assign Locations Workflow screen is not displayed");
		}
	}
	
	
	
	/**
	 * @Function verifyInventoryToolsPage
	 * @Description Verify inventory tools page is displayed
	 * @author Periyasamy_Nainar
	 * @date 15-10-2016
	 */
	public void verifyInventoryToolsPage(){
		switchToWebContext();
		
		if(isElementPresentAfterWait(lbl_InventoryTools,10)){
			FrameworkReporter.pass("Inventory tools page is displayed");
		}
		else{
			FrameworkReporter.fail("Inventory tools page is not displayed");
		}
	}
	/**
	 * @function verifyViewFoodCostLink
	 * @author Gayathri Anand
	 * @description Verify view food cost link is displayed
	 * @date 16-10-2016
	 */

	public void verifyViewFoodCostLink(){
		switchToWebContext();
		if(isElementPresentAfterWait(lnk_ViewFoodCost, 5)){
			FrameworkReporter.pass("View Food Cost link is displayed in home page");
		}else{
			FrameworkReporter.fail("View Food Cost link is not displayed in home page");
		}
	}
	/**
	 * @function tapOnViewFoodCost
	 * @author Gayathri Anand
	 * @description Tap on view food cost link
	 * @date 16-10-2016
	 */

	public void tapOnViewFoodCost(){
		switchToWebContext();
		clickElement(lnk_ViewFoodCost);
		FrameworkReporter.info("Tapped on View Food Cost link");
	}
	
	/**
	 * @function getInventoryPeriodValues
	 * @author Gayathri Anand
	 * @description Store inventory period values
	 * @date 17-10-2016
	 */

	public void getInventoryPeriodValues(int period){
		switchToWebContext();
		String pattern = "MM-d-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		String currentInventory=retreiveStoredValue("InventoryValue").toString();
		String currentDate=date.replace("-", "/");
		storeValue("EndingInventory_Period"+(period-1),currentInventory);
		storeValue("EndingDate_Period"+(period-1),currentDate);
		storeValue("BeginningInventory_Period"+period,currentInventory);
		storeValue("BeginningDate_Period"+period,currentDate);
		}
	
	public void tapPurchases(){
		switchToWebContext();
		waitForElementPresent(lnk_Purchases, 30);
		clickElement(lnk_Purchases);
		FrameworkReporter.info("Tapped on purchase from Inventory Tools Page");
		
	}
	
	
	
	
	/**
	 * @Function verifyOnlySetupInventoryEnable
	 * @Description Verify only setup inventory link is enabled in home page and except that all other links should be disabled
	 * @author Periyasamy_Nainar
	 * @date 16-10-2016
	 */
	public void verifyOnlySetupInventoryEnable(){
		switchToWebContext();
		LibraryPage.waitForPageLoadAndroid(5);
		if(getElementCount(lnk_EnabledLinks)==1 && getElementCount(lnk_DisabledLinks)==8){
			FrameworkReporter.pass("Setup inventory button(1) only enabled and all other buttons(8) are disabled");
		}else{
			FrameworkReporter.fail("Setup inventory button(1) and some other buttons are enabled");
		}
		
		if(isElementPresentAfterWait(lnk_EnableSetupInventory,2)){
			FrameworkReporter.pass("Setup inventory link is enabled in home page");
		}
		else{
			FrameworkReporter.fail("Setup inventory link is not enabled in home page");
		}
		
		if(isElementPresentAfterWait(lnk_DisableTrackInventory,2)){
			FrameworkReporter.pass("Track inventory button in home page is disabled");
		}
		else{
			FrameworkReporter.fail("Track inventory button in home page is not disabled");
		}
		
		if(isElementPresentAfterWait(lnk_DisablePurchases,2)){
			FrameworkReporter.pass("Purchase button in home page is disabled");
		}
		else{
			FrameworkReporter.fail("purhcase button in home page is not disabled");
		}
		
		if(isElementPresentAfterWait(lnk_DisableFoodCost,2)){
			FrameworkReporter.pass("Food Cost button in home page is disabled");
		}
		else{
			FrameworkReporter.fail("Food Cost button in home page is not disabled");
		}
		
		if(isElementPresentAfterWait(lnk_DisableSetupExpenseCategories,2)){
			FrameworkReporter.pass("Setup Expense Categories button in home page is disabled");
		}
		else{
			FrameworkReporter.fail("Setup Expense Categories button in home page is not disabled");
		}
		
		if(isElementPresentAfterWait(lnk_DisableSetupLocations,2)){
			FrameworkReporter.pass("Setup locations button in home page is disabled");
		}
		else{
			FrameworkReporter.fail("TSetup locations button in home page is not disabled");
		}
		
		if(isElementPresentAfterWait(lnk_DisableSuppliers,2)){
			FrameworkReporter.pass("Suppliers button in home page is disabled");
		}
		else{
			FrameworkReporter.fail("Suppliers button in home page is not disabled");
		}
		
		if(isElementPresentAfterWait(lnk_DisableCreateNonSyscoItem,2)){
			FrameworkReporter.pass("Create non sysco item button in home page is disabled");
		}
		else{
			FrameworkReporter.fail("Create non sysco item button in home page is not disabled");
		}
		
		if(isElementPresentAfterWait(lnk_DisableCreatePrepItem,2)){
			FrameworkReporter.pass("Create prep item button in home page is disabled");
		}
		else{
			FrameworkReporter.fail("Create prep item button in home page is not disabled");
		}
		
		
	}
	/**
	 * @function waitForOneMinuteToCloseInvnetory
	 * @author Gayathri Anand
	 * @description Method to wait for 1 min
	 * @date 13-10-2016
	 */

	public void waitForOneMinuteToCloseInventory(){
		switchToWebContext();
		if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
		waitFor(60);
		}
		else{
			//waitFor(15);
		}
	}
	
	/**
	 * @function tapViewReporting
	 * @author Gayathri Anand
	 * @description Tap on view reporting link
	 * @date
	 */

	public void tapViewReporting(){
		switchToWebContext();
		clickElement(lnk_ViewReporting);
		FrameworkReporter.info("Tapped on View Reporting link");
	}
	
	/**
	 * @function verifyLastClosedDate
	 * @author Gayathri Anand
	 * @description Verify last closed date is displayed below close inventory button
	 * @date 
	 */

	public void verifyLastClosedDate(){
		switchToWebContext();
		/*update the validation with required element
		if(isElementPresent(stringVal)){
			FrameworkReporter.pass("Last closed date is displayed in home page");
		}
		else{
			FrameworkReporter.fail("Last closed date is not displayed in home page");
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
					break;
				case "ipad":	
					childClassObject = new IOSTabletHomePage().findChildObject(parentObject[2]);	
					break;
				case "android":
					childClassObject = new AndroidHomePage().findChildObject(parentObject[2]);
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