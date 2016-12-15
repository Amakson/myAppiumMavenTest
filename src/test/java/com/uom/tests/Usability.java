
package com.uom.tests;


import java.lang.reflect.Method;

import com.DataRead.Excel;
import com.framework.*;
import com.framework.configuration.ConfigFile;
import com.framework.frameworkFunctions.LibraryPage;
import com.framework.utils.RetryAnalyzer;
import com.framework.utils.UOMTestNGListener;
import com.uom.excelSheetObject.UsabilityObject;
import com.uom.pageFactory.PageFactory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(value = UOMTestNGListener.class)
public class Usability extends PageFactory{

	public static String[][] completeArray = null;	
     	
      
    @BeforeClass(alwaysRun=true)
	public void getData() throws Exception
	{		
		
		Excel newExcel =new Excel();		
		completeArray=newExcel.read("test-data/TestData.xls","Usability");
	}
    @BeforeMethod(alwaysRun=true)
    public void initiate() throws Exception
    { 	
    	startup();
    }
	
	 @DataProvider(name = "DP1",parallel =false)
	  public Object[][] getData(Method method) throws Exception{
		 	Excel newExcel =new Excel();	
		 	UsabilityObject sheetObj = new UsabilityObject();
	        System.out.println(method.getName());
	        String[][] MethodArray=newExcel.getMethodData(completeArray, method.getName());
	        Object[][] retObjArr= sheetObj.getTestData(MethodArray);
	        return(retObjArr);
	    }
	 
	 @AfterMethod
		public void clean()
		{
	    	cleanUp();
		}
	 
	 /******************************************************************************************
	  * Name : INV_UI_002_004_Verify_SaveUserNameAutoPopulate_LoginButtonStateChange
	  * 
	  * Description : 1) Verify the Username which was previously saved is auto populated 
	  * 				2) Verify when the user enters all the necessary details and clicks on Login, the transition button state should be shown as "Submitting"
	  * 
	  * Manual Test cases : INV_UI_002, INV_UI_004
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 10/15/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/

	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Usability","Usability_iOS1"},priority=1, description = "verify save username and login button state changes")

	 public void INV_UI_002_004_Verify_SaveUserNameAutoPopulate_LoginButtonStateChange(UsabilityObject data) throws Exception {	
		
		 //logout from the app due to session issue
		 home().logoutAfterCheck();
		  //verify login page fields
		 login().verifyLoginPageFields();
		 //Enter username
		 login().enterUserName(data.strUserName);
		 //Enter password
		 login().enterPassword(data.strPassword);
		 //tap on save username radio button
		 login().selectRememberUserName();
		 //verify save username radio button is selected
		 login().verifySaveUserNameIsSelected(true);
		 //tap on login button
		 //verify save username radio button 
		 login().tapLogin();
		 //verify the state changes for login button		
		 login().verifyLoginButtonStateChanges();
		 //wait for home page to load
		 LibraryPage.waitForPageLoadAndroid(9);
		//verify inventory tools page is displayed
		 home().verifyInventoryToolsPage();
		 //tap on logout button
		 home().logout();
		 //verify login page fields
		 login().verifyLoginPageFields();
		//verify username is autopopulated
		 login().verifySavedUserNameAutoPopulated(data.strUserName);
		//verify save username radio button is selected
		 login().verifySaveUserNameIsSelected(true);
		//Enter password
		 login().enterPassword(data.strPassword);
		 //tap on save username radio button to unselect
		 login().selectRememberUserName();
		 //tap on login button
		 login().tapLogin();
		//wait for home page to load
		 LibraryPage.waitForPageLoadAndroid(9);
		 //verify inventory tools page is displayed
		 home().verifyInventoryToolsPage();
		 //close app
		 generic().closeApp();
	 
	 }
	 
	 
	 
	 /******************************************************************************************
	  * Name : INV_UI_003_005_Verify_AuthenticationFailure_UserName_NoAutoPopulate_NoRememberName
	  * 
	  * Description : 1. Verify the authentication failure message when the user login with invalid/expired password
	  * 				2. Verify the User name is not auto populated as the radio button save username is not clicked	
	  * 
	  * Manual Test cases :  INV_UI_003, INV_UI_005
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 10/16/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/

	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Usability","Usability_iOS1"},priority=1, description = "verify authenticaiton failure while login with invalid password")

	 public void INV_UI_003_005_Verify_AuthenticationFailure_UserName_NoAutoPopulate_NoRememberName(UsabilityObject data) throws Exception {	
		
		 //INV_UI_005 - Verify the authentication failure message when the user login with invalid/expired password --
		//logout from the app due to session issue
		 home().logoutAfterCheck();
		 //verify login page fields
		 login().verifyLoginPageFields();
		 //Enter username
		 login().enterUserName(data.strUserName);
		 //Enter password
		 login().enterPassword(data.strLocationName1);		 
		 //tap on login button
		 login().tapLogin();
		 //wait for 2 seconds
		 LibraryPage.waitForPageLoadAndroid(2);
		//verify authentication failure error message
		 login().verifyAuthenticationErrorMsg();
		 //INV_UI_003 - Verify the User name is not auto populated as the radio button save username is not clicked --
		 LibraryPage.waitForPageLoadAndroid(3);
		 //Enter username
		 login().enterUserName(data.strUserName);
		 //Enter password
		 login().enterPassword(data.strPassword);		
		 //verify save username radio button is not selected
		 login().verifySaveUserNameIsSelected(false);
		 //tap on login button
		 login().tapLogin();	
		//wait for home page to load
		 LibraryPage.waitForPageLoadAndroid(9);
		//verify inventory tools page is displayed
		 home().verifyInventoryToolsPage();
		 //tap on logout button
		 home().logout();
		//verify username is auto populated
		 login().verifyUserNameNotAutoPopulated();
		//verify save username radio button is selected
		 login().verifySaveUserNameIsSelected(false);
		//Enter username
		 login().enterUserName(data.strUserName);
		//Enter password
		 login().enterPassword(data.strPassword);
		 //tap on login button
		 login().tapLogin();
		//wait for home page to load
		 LibraryPage.waitForPageLoadAndroid(9);
		 //verify inventory tools page is displayed
		 home().verifyInventoryToolsPage();
		 //close app
		 generic().closeApp();
	 
	 }
	 
	 

	 /******************************************************************************************
	  * Name : INV_UI_006_Verify_Offline_Login_Message
	  * 
	  * Description : 1. Validate the error message when the user tries to login to the app in offline 
	  * 
	  * Manual Test cases :  INV_UI_006
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 10/18/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Usability_offline","Usability_iOS1","Usability_ipad"},priority=1, description = "verify authenticaiton failure while login with invalid password")
	 public void INV_UI_006_Verify_Offline_Login_Message(UsabilityObject data) throws Exception {	
		
		  //verify login page fields
		 login().verifyLoginPageFields();
		 //Enter username
		 login().enterUserName(data.strUserName);
		 //Enter password
		 login().enterPassword(data.strPassword);		 
		 //tap on login button
		 login().tapLogin();
		 //wait for 2 seconds
		 LibraryPage.waitForPageLoadAndroid(2);
		//verify authentication failure error message due to offline 
		 login().verifyOfflineErrorMsg();	 
		 //close app
		 generic().closeApp();
	 
	 }


	 
	 /******************************************************************************************
	  * Name : INV_UI_015_017_Verify_NextButton_Disable_Enable_Adding_NewLocation_NewCategory
	  * 
	  * Description :1. Validate during setup - Location Step process , the "Next" button is enabled only when the user has selected an option during custom location creation_1
	  * 			 2. Validate during setup - expense category Step process , the "Next" button is enabled only when the user has selected an option during custom category creation_1  
	  * 
	  * Manual Test cases : INV_UI_015 , INV_UI_017
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 10/16/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Usability","Usability_iOS1"},priority=1, description = "verify enable/disable next button while adding new category/location")
	 public void INV_UI_015_017_Verify_NextButton_Disable_Enable_Adding_NewLocation_NewCategory(UsabilityObject data) throws Exception {	
		
		  //Login to UOM Application
		 component().login(data.strUserName, data.strPassword);
		 //Tap on setup inventory
		 home().tapSetupInventory();
		 //tap on skip button
		 setupInventory().clickSkipOnSetupInventory();
		 //Tap on Order Guide
		 setupInventory().tapOnOrderGuideButton();
		 //Tap on Next
		 setupInventory().tapOnNextButton();
		 //verify select location page
		 setupInventory().verifySelectionAtSetupLocations();
		 //verify next button is disabled
		 generic().verifyNextButtonStatus(false,"bgcolor");
		 //verify skip and use default location is displayed
		 setupInventory().verifySkipAndUseDefaultButtonInLocationPage(true);
		 //Tap on add new location
		 setupInventory().tapOnAddNewLocationButton();		 
		 setupInventory().verifyPromptToEnterCustomLocations();
		 //enter location details and tap on save
		 setupInventory().addLocationInSetupLocations(data.strLocationName1, data.strLocationType1);
		//tap on save
		 generic().tapSaveButton();
		 //verify skip and use default location is not displayed
		 setupInventory().verifySkipAndUseDefaultButtonInLocationPage(false);
		 //verify next button is enabled
		 generic().verifyNextButtonStatus(true,"bgcolor");
		 //Tap on next
		 setupInventory().tapOnNextButton();
		 //verify select category page
		 setupInventory().verifySetupExpensesPageDisplay();
		 //verify next button is disabled         -----------------------   Defect ---- Failed 
		// generic().verifyNextButtonStatus(false);
		 generic().verifyNextButtonStatus(false,"bgcolor");
		 //verify skip and use default category is displayed
		 setupInventory().verifySkipAndUseDefaultButtonInCategoryPage(true);
		 //tap on add new category
		 setupInventory().tapOnAddNewExpenseCategory();
		 //verify custom catgory form to create new custom category
		 setupInventory().verifyPromptToEnterCustomCategories();
		 //verify next button is disabled - 
		 generic().verifyNextButtonStatus(false,"bgcolor");
		 //enter category details and tap on save button
		 setupInventory().addNewCategoryExpense(data.strCategoryName1, data.strCategoryType1);
		 //tap on save 
		 generic().tapSaveButton();
		 //verify skip and use default category is not displayed
		 setupInventory().verifySkipAndUseDefaultButtonInCategoryPage(false);
		 //verify next button is enabled
		 generic().verifyNextButtonStatus(true,"bgcolor");
		//Tap on next
		 setupInventory().tapOnNextButton();
		 //wait for page to load
		 LibraryPage.waitForPageLoadAndroid(5);
		 //verify assign product page displayed
		 setupInventory().verifyAssignProductsPageDisplay();		 
		 //close app
		 generic().closeApp();
	 
	 }
	 
	 

	 /******************************************************************************************
	  * Name : INV_UI_016_018_Verify_NextButton_Disable_Enable_Default_Location_Category
	  * 
	  * Description :1. Validate during setup - Location Step process , the "Next" button is enabled only when the user has selected an option during custom location creation_2
	  * 			 2. Validate during setup - Location Step process , the "Next" button is enabled only when the user has selected an option during custom location creation_2  
	  * 
	  * Manual Test cases : INV_UI_016 , INV_UI_018
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 10/16/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Usability","Usability_iOS1","Usability_ipad"},priority=1, description = "verify enable/disable of next button based on skip and use default location/category")
	 public void INV_UI_016_018_Verify_NextButton_Disable_Enable_Default_Location_Category(UsabilityObject data) throws Exception {	
		
		  //Login to UOM Application
		 component().login(data.strUserName, data.strPassword);
		 //Tap on setup inventory
		 home().tapSetupInventory();
		 //tap on skip button
		 setupInventory().clickSkipOnSetupInventory();
		 //Tap on Order Guide
		 setupInventory().tapOnOrderGuideButton();
		 //Tap on Next
		 setupInventory().tapOnNextButton();
		 //verify select location page
		 setupInventory().verifySelectionAtSetupLocations();
		 //verify next button is disabled
		 generic().verifyNextButtonStatus(false,"bgcolor");
		 //verify skip and use default location is displayed
		 setupInventory().verifySkipAndUseDefaultButtonInLocationPage(true);
		 //verify the background color of skip and use default button - not selected
		 setupInventory().verifySkipAndUseDefaultLocBGColor(false);
		 //Tap on Skip and use default location
		 setupInventory().tapOnSkipAndUseDefaultButtonInSetupInventoryPage();	
		//verify the background color of skip and use default button - selected
		 setupInventory().verifySkipAndUseDefaultLocBGColor(true);
		 //verify next button is enabled
		 generic().verifyNextButtonStatus(true,"bgcolor");
		 //Tap on next
		 setupInventory().tapOnNextButton();
		 //verify select category page
		 setupInventory().verifySetupExpensesPageDisplay();
		 //verify next button is disabled
		 generic().verifyNextButtonStatus(false,"bgcolor");  // Defect ---- Failed
		
		 //verify skip and use default category is displayed
		 setupInventory().verifySkipAndUseDefaultButtonInCategoryPage(true);	
		 //verify the background color of use food and non food button - not selected
		 setupInventory().verifySkipAndUseDefaultCategoryBGColor(false);
		 //tap on skip and use default category
		 setupInventory().tapUseFoodAndNonFoodButton();
		 //verify the background color of use food and non food button - selected
		 setupInventory().verifySkipAndUseDefaultCategoryBGColor(true);
		 //verify next button is enabled
		 generic().verifyNextButtonStatus(true,"bgcolor");
		//Tap on next
		 setupInventory().tapOnNextButton();		  	 
		 //close app
		 generic().closeApp();
	 
	 }
	 
	 
	 /******************************************************************************************
	  * Name : INV_UI_007_011_012_Qty_UOMAttribute_VerifyBackgroundColor_SetupInventoryInHomePage
	  * 
	  * Description :1. Validate only  Setup inventory option is enabled for the user and rest of the options are all disabled
	  * 			 2. Validate when the user enters qty or perform inventory count, the item which has qty is highlighted for that current open inventory
	  * 			 3. Validate when the user enters qty or perform inventory count, the item which has qty is not highlighted when inventory period is closed  
	  * 
	  * Manual Test cases : INV_UI_007 , INV_UI_011, INV_UI_012
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 10/17/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Usability","Usability_iOS2"},priority=1, description = "verify enable/disable of next button based on skip and use default location/category")
	 public void INV_UI_007_011_012_Qty_UOMAttribute_VerifyBackgroundColor_SetupInventoryInHomePage(UsabilityObject data) throws Exception {	
		
		  //Login to UOM Application
		 component().login(data.strUserName, data.strPassword);
		 //INV_UI_007 - validate only setup inventory is enabled in home page 
		 //verify only setup inventory is enabled
		 home().verifyOnlySetupInventoryEnable();	
		 //setup inventory - OG +Default location + Default category - INV_SI_001
		 component().setupInventorywithOGDefaultLocDefaultCat();
		 //Tap on track inventory from home page
		 home().tapTrackInventory();
		 //verify locations page
		 locations().verifyLocationsPage();
		 //tap on any location
		 locations().tapLocation(data.strLocationName1);
		 //verify location list page
		 locations().verifyLocationPage(data.strLocationName1);
		 //Enter qty for an item
		 locations().enterQuantity(data.strQty1, data.strIndex1);
		 //tap on location header 
		 locations().tapOnLocationHeader(data.strLocationName1);
		 //verify entered quantity is displayed in line item
		 locations().verifyQuantityAndUOMAttributeWithItemName(data.strIndex1, data.strQty1, data.strUOMAttribute1);
		 //verify item is highlighted in blue color after entering quantity
		 locations().verifyItemBackGroundHighlightColor(data.strIndex1, true,"");
		 //enter qty and UOM for an item
		 locations().enterQuantity(data.strQty2, data.strIndex2);
		 locations().tapOnUOMAttribute(data.strIndex2);
		 generic().selectValueFromDropdown(data.strUOMAttribute1, "Selected UOM Attribute" + data.strUOMAttribute1 + "from dropdown");
		 locations().verifyQuantityAndUOMAttributeWithItemName(data.strIndex2, data.strQty1, data.strUOMAttribute1);
		 //verify item is highlighted in blue color after entering qty and uom
		 locations().verifyItemBackGroundHighlightColor(data.strIndex1, true,"");
		 //Enter UOM for an item 
		 locations().tapOnUOMAttribute(data.strIndex3);
		 generic().selectValueFromDropdown(data.strUOMAttribute2, "Selected UOM Attribute" + data.strUOMAttribute2 + "from dropdown");
		 locations().verifyQuantityAndUOMAttributeWithItemName(data.strIndex2, "", data.strUOMAttribute2);
		 //verify item is not highlight in blue color
		 locations().verifyItemBackGroundHighlightColor(data.strIndex2, false,"");  
		 //tap on back
		 generic().tapBack();
		//tap on back
		 generic().tapBack();
		 //logout from an app
		 home().logout();
		 //login again
		 component().login(data.strUserName, data.strPassword);
		 //tap on track inventory
		 home().tapTrackInventory();
		 //tap on any location
		 locations().tapLocation(data.strLocationName1);
		 //verify 1st 2 items are highlighted in blue color - Should retain it after logout and login
		 locations().verifyItemBackGroundHighlightColor(data.strIndex1, true,"");
		 locations().verifyItemBackGroundHighlightColor(data.strIndex2, true,"");
		 //Tap on back
		 generic().tapBack();
		 //Tap on back 
		 generic().tapBack();
		 //hit on close inventory button
		 home().tapOnCloseInventory();
		 //verify close inventory confirmation message
		 home().verifyCloseInventoryConfirmationPopUp();
		 //hit on Yes, Close button
		 generic().tapYesDelete();
		 //verify close inventory success message
		 home().verifyCloseInventorySuccessMessage(true);
		 //tap on okay got it on close inventory success pop up
		 generic().tapYesDelete();  
		 //tap on track inventory
		 home().tapTrackInventory();
		 //tap on any location
		 locations().tapLocation(data.strLocationName1);
		 //verify quantity intact for first 2 items
		 locations().verifyQuantityAndUOMAttributeWithItemName(data.strIndex1, data.strQty1, data.strUOMAttribute1);
		 locations().verifyQuantityAndUOMAttributeWithItemName(data.strIndex2, data.strQty1, data.strUOMAttribute2);
		 //verify blue color back ground is not retained for both items as the inventory is closed
		 locations().verifyItemBackGroundHighlightColor(data.strIndex1, false,"");
		 locations().verifyItemBackGroundHighlightColor(data.strIndex2, false,"");		 
		 //close app
		 generic().closeApp();
	 
	 }
	 
	 
	 /******************************************************************************************
	  * Name : INV_UI_013_Verify_Screen_Transition_Within_TrackInventory
	  * 
	  * Description : 1. Validate the screen transition within track inventory
	  * 
	  * Manual Test cases :  INV_UI_013
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 10/18/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/

	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Usability","Usability_iOS1",},priority=1, description = "verify authenticaiton failure while login with invalid password")

	 public void INV_UI_013_Verify_Screen_Transition_Within_TrackInventory(UsabilityObject data) throws Exception {			
		 
		 //login to uom app with valid username and password
		 component().login(data.strUserName, data.strPassword);
		//setup inventory - OG +Default location + Default category - INV_SI_001
		 component().setupInventorywithOGDefaultLocDefaultCat();
		//Tap on track inventory from home page
		 home().tapTrackInventory();
		 //verify locations page
		 locations().verifyLocationsPage();
		 //tap on any location
		 locations().tapLocation(data.strLocationName1);
		 //verify location list page
		 locations().verifyLocationPage(data.strLocationName1);
		 //verify item list within location should be displayed
		 locations().verifyItemListViewIsDisplayed();
		 locations().verifySearchIconInItemList();
		 locations().verifyProductCardDetailsInList(true);
		 //verify add, back and edit button in item list page
		 generic().verifyAddButton();
		 generic().verifyEditButton();
		 generic().verifyBackButton();
		 //tap on back 
		 generic().tapBack();
		 //verify location list page
		 locations().verifyLocationsPage();
		 //verify list of locations
		 locations().verifyLocationInList(data.strLocationName1, true);
		 locations().verifyLocationInList(data.strLocationName2, true);
		 locations().verifyLocationInList(data.strLocationName3, true);
		 //tap on any location - cooler
		 locations().tapLocation(data.strLocationName1);
		 //verify location list page
		 locations().verifyLocationPage(data.strLocationName1);
		 //tap on any product -
		// locations().selectAnItemWithName(data.strProductName1);
		 locations().selectAnItemFromProductList(data.strProductName1);
		 //verify product details page
		 product().verifyProductDetailsPage();
		 //tap on close
		 generic().tapClose();
		 //verify item list within location should be displayed
		 locations().verifyItemListViewIsDisplayed();
		 locations().verifySearchIconInItemList();
		 locations().verifyProductCardDetailsInList(true);
		 //Tap on edit button for a location
		 generic().tapEdit();
		 //verify item list view with delete and rearrange buttons for each item
		 locations().verifyEditItemListDeleteRearrangeIcon();
		 //tap on cancel
		 generic().tapCancel();
		 //item list view within location should be displayed
		 locations().verifyLocationPage(data.strLocationName1);
		 locations().verifyItemListViewIsDisplayed();
		 locations().verifySearchIconInItemList();
		 //tap on add button
		 generic().tapAddFromListPage();
		//Add item from screen should be displayed
		 locations().verifyAddItemFormPageDisplayed();
		 //tap back 
		 generic().tapBack();
		 //item list view within location should be displayed
		 locations().verifyLocationPage(data.strLocationName1);
		 locations().verifyItemListViewIsDisplayed();
		 locations().verifySearchIconInItemList();
		 //close app
		 generic().closeApp();
	 
	 }
	 
	 

	 /******************************************************************************************
	  * Name : INV_UI_014_Verify_Done_Canel_Edit_ItemList_View
	  * 
	  * Description : 1. Validate the Done and Cancel button in the item list view in Edit mode
	  * 
	  * Manual Test cases :  INV_UI_014
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 10/18/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/

	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Usability","Usability_iOS1"},priority=1, description = "verify authenticaiton failure while login with invalid password")

	 public void INV_UI_014_Verify_Done_Canel_Edit_ItemList_View(UsabilityObject data) throws Exception {			
		 
		 //login to uom app with valid username and password
		 component().login(data.strUserName, data.strPassword);
		//setup inventory - OG +Default location + Default category - INV_SI_001
		 component().setupInventorywithOGDefaultLocDefaultCat();
		//Tap on track inventory from home page
		 home().tapTrackInventory();
		 //verify locations page
		 locations().verifyLocationsPage();
		 //tap on any location
		 locations().tapLocation(data.strLocationName1);
		 //verify location list page
		 locations().verifyLocationPage(data.strLocationName1);
		 //verify item list within location should be displayed
		 locations().verifyItemListViewIsDisplayed();
		 locations().verifySearchIconInItemList();
		 locations().verifyProductCardDetailsInList(true);
		 //verify add, back and edit button in item list page
		 generic().verifyAddButton();
		 generic().verifyEditButton();
		 generic().verifyBackButton();
		//Tap on edit button 
		 generic().tapEdit();
		 //verify item list view with delete and rearrange buttons for each item
		 locations().verifyEditItemListDeleteRearrangeIcon();
		 //tap on delete icon
		 locations().deleteItem(data.strProductName1);
		 //verify deleted item not present in edit item list page
		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", false);
		 //tap on cancel
		 generic().tapCancel();
		 //verify item list within location should be displayed
		 locations().verifyItemListViewIsDisplayed();
		 locations().verifySearchIconInItemList();
		 //verify item is present ( not deleted as the user clicked on cancel ) in item list page
		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);
		//Tap on edit button 
		 generic().tapEdit();
		 //verify item list view with delete and rearrange buttons for each item
		 locations().verifyEditItemListDeleteRearrangeIcon();
		 //tap on delete icon
		 locations().deleteItem(data.strProductName1);
		//verify deleted item not present in edit item list page
		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", false);
		 //tap on done button
		 generic().tapDone();
		 //verify confirmation modal 
		 locations().verifyDeleteConfirmationPopUp();
		 //Tap on no, cancel button
		 generic().tapNoCancel();
		//verify item list view with delete and rearrange buttons for each item
		 locations().verifyEditItemListDeleteRearrangeIcon();
		 //verify item is present ( as the user clicked on no cancel ) in item list page
		 locations().verifyItemPresentInLocation(data.strProductName2, "Product Name", true);
		 generic().tapCancel();
		 //verify item list within location should be displayed
		 locations().verifyItemListViewIsDisplayed();
		 locations().verifySearchIconInItemList();
		 //verify item is present ( not deleted as the user clicked on cancel ) in item list page
		 locations().verifyItemPresentInLocation(data.strProductName3, "Product Name", true);
		//Tap on edit button 
		 generic().tapEdit();
		 //verify item list view with delete and rearrange buttons for each item
		 locations().verifyEditItemListDeleteRearrangeIcon();
		 //tap on delete icon
		 locations().deleteItem(data.strProductName1);
		//verify deleted item not present in edit item list page
		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", false);
		 //tap on done button
		 generic().tapDone();
		 //verify confirmation modal 
		 locations().verifyDeleteConfirmationPopUp();
		 //tap on yes delete
		 generic().tapYesDelete();
		//verify item list within location should be displayed
		 locations().verifyItemListViewIsDisplayed();
		 locations().verifySearchIconInItemList();
		//verify deleted item not present in item list page
		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", false);		 
		 //close app
		 generic().closeApp();
	 
	 }
	 
	 
	 

	 /******************************************************************************************
	  * Name : INV_UI_021_VerifyProduct_InListView_WithCakeDescription_NoNickname
	  * 
	  * Description : 1. Validate when an item has Cake description available only the cake description is displayed in the item list view
					Test Data - Item has Cake Description and no Nickname
	  * 
	  * Manual Test cases :  INV_UI_021
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 10/18/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Usability","Usability_iOS1"},priority=1, description = "verify authenticaiton failure while login with invalid password")
	 public void INV_UI_021_VerifyProduct_InListView_WithCakeDescription_NoNickname(UsabilityObject data) throws Exception {			
		 
		 //login to uom app with valid username and password
		 component().login(data.strUserName, data.strPassword);
		//setup inventory - OG +Default location + Default category - INV_SI_001
		 component().setupInventorywithOGDefaultLocDefaultCat();
		//Tap on track inventory from home page
		 home().tapTrackInventory();
		 //verify locations page
		 locations().verifyLocationsPage();
		 //tap on any location
		 locations().tapLocation(data.strLocationName1);
		 //verify location list page
		 locations().verifyLocationPage(data.strLocationName1);
		 //verify item list within location should be displayed
		 locations().verifyItemListViewIsDisplayed();
		 locations().verifySearchIconInItemList();
		 locations().verifyProductCardDetailsInList(true);
		 //verify cake descrption is displayed in product card list view
		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);		 
		 //close app
		 generic().closeApp();
	 
	 }
	 
	 
	 
	 /******************************************************************************************
	  * Name : INV_UI_022_VerifyProduct_InListView_WithCakeDescription_WithNickname
	  * 
	  * Description : 1. Validate when an item has Cake description available only the cake description is displayed in the item list view
					Test Data - Item has Cake Description and with Nickname
	  * 
	  * Manual Test cases :  INV_UI_022
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 10/18/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Usability","Usability_iOS1","Usability_ipad"},priority=1, description = "verify authenticaiton failure while login with invalid password")
	 public void INV_UI_022_VerifyProduct_InListView_WithCakeDescription_WithNickname(UsabilityObject data) throws Exception {			
		 
		 //login to uom app with valid username and password
		 component().login(data.strUserName, data.strPassword);
		//setup inventory - OG +Default location + Default category - INV_SI_001
		 component().setupInventorywithOGDefaultLocDefaultCat();
		//Tap on track inventory from home page
		 home().tapTrackInventory();
		 //verify locations page
		 locations().verifyLocationsPage();
		 //tap on any location
		 locations().tapLocation(data.strLocationName1);
		 //verify location list page
		 locations().verifyLocationPage(data.strLocationName1);
		 //verify item list within location should be displayed
		 locations().verifyItemListViewIsDisplayed();
		 locations().verifySearchIconInItemList();
		 locations().verifyProductCardDetailsInList(true);
		 //verify cake description is displayed in product card list view
		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);		
		 //tap on product
		 locations().selectAnItemFromProductList(data.strProductName1);
		 //tap on edit
		 generic().tapEdit();
		 //enter nickname
		 product().enterNickName(data.strProductName2);
		 //tap on done 
		 generic().tapDone();
		 LibraryPage.waitForPageLoadAndroid(5);
		 //tap close
		 generic().tapClose();
		 //verify cake description is not displayed in product card list view as an item is having nickname
		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", false);		
		 //verify nickname is  displayed in item list page as an item is nickname
		 locations().verifyItemPresentInLocation(data.strProductName2, "Product Name", true);			 
		 //close app
		 generic().closeApp();
	 
	 }
	 
	 /******************************************************************************************
	  * Name : INV_UI_024_025_Verify_ProductImage_ItemListView_ProductDetails
	  * 
	  * Description : 1. Validate if an item has Image associated with it the user is able to view the image in the item list view within any location
	  * 			  2. Validate if an item has Image associated with it the user is able to view the image in the Product Card details within any location
	  * 
	  * Manual Test cases :  INV_UI_024, INV_UI_025
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 10/18/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Usability","Usability_iOS1","Usability_ipad"},priority=1, description = "verify product image in item list view")
	 public void INV_UI_024_025_Verify_ProductImage_ItemListView_ProductDetails(UsabilityObject data) throws Exception {			
		 
		 //login to uom app with valid username and password
		 component().login(data.strUserName, data.strPassword);
		//setup inventory - OG +Default location + Default category - INV_SI_001
		 component().setupInventorywithOGDefaultLocDefaultCat();
		//Tap on track inventory from home page
		 home().tapTrackInventory();
		 //verify locations page
		 locations().verifyLocationsPage();
		 //tap on any location
		 locations().tapLocation(data.strLocationName1);
		 //verify location list page
		 locations().verifyLocationPage(data.strLocationName1);
		 //verify item list within location should be displayed
		 locations().verifyItemListViewIsDisplayed();
		 locations().verifyProductCardDetailsInList(true);		 
		 //verify product card image in item list view
		 locations().verifyProductImageInListView(data.strProductName1);    // Item id	
		 //select an item 
		 locations().selectAnItemFromProductList(data.strProductName2);
		 //verify product details page
		 product().verifyProductDetailsPage();
		//verify product image in details page 
		 product().verifyProductImageInProductDetails(data.strProductName2);
		 //close app
		 generic().closeApp();
	 
	 }
	 
	 
	 
	 /******************************************************************************************
	  * Name : INV_UI_031_Qty_UOMAttribute_VerifyBackgroundColor_ProductDetails
	  * 
	  * Description :1. Validate when the user enters qty or perform inventory count, the item which has qty is highlighted for that current open inventory via Product card  
	  * 
	  * Manual Test cases : INV_UI_031
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 10/18/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/

	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Usability","Usability_iOS2"},priority=1, description = "verify enable/disable of next button based on skip and use default location/category")

	 public void INV_UI_031_Qty_UOMAttribute_VerifyBackgroundColor_ProductDetails(UsabilityObject data) throws Exception {	
		
		  //Login to UOM Application
		 component().login(data.strUserName, data.strPassword);
		 //setup inventory - OG +Default location + Default category - INV_SI_001
		 component().setupInventorywithOGDefaultLocDefaultCat();
		 //Tap on track inventory from home page
		 home().tapTrackInventory();
		 //verify locations page
		 locations().verifyLocationsPage();
		 //tap on any location
		 locations().tapLocation(data.strLocationName1);
		 //verify location list page
		 locations().verifyLocationPage(data.strLocationName1);
		 //select an item location page
    	 locations().selectAnItemFromProductList(data.strProductName1);
		 //Tap on Edit
		 generic().tapEdit();
		 //Enter qty for an item from product page
		 product().enterLocationQuantity(data.strQty1, "1");
		 //tap on Done
		 generic().tapDone();
		 //tap on close
		 generic().tapClose();
		//verify entered quantity is displayed in line item
		 locations().verifyQuantityAndUOMAttributeWithItemName(data.strProductName1, data.strQty1, data.strUOMAttribute1);
		 //verify item is highlighted in blue color after entering quantity
		 locations().verifyItemBackGroundHighlightColor(data.strIndex1, true,data.strProductName1);		 
		 //For second item - Enter quantity and select UOM attribute
		 //select an item location page
		 locations().selectAnItemFromProductList(data.strProductName2);
		 //verify product detail spage
		 product().verifyProductDetailsPage();
		 //Tap on Edit
		 generic().tapEdit();
		 //Enter qty for an item from product page
		 product().enterLocationQuantity(data.strQty2, "1");
		 //tap on uom Attribute
		 product().selectLocationQuantityUOM(data.strUOMAttribute2, "1");
		//tap on Done
		 generic().tapDone();
		 //tap on close
		 generic().tapClose();
		//verify entered quantity is displayed in line item
		 locations().verifyQuantityAndUOMAttributeWithItemName(data.strProductName2, data.strQty2, data.strUOMAttribute2);
		 //verify item is highlighted in blue color after entering quantity
		 locations().verifyItemBackGroundHighlightColor(data.strIndex2, true,data.strProductName2);			 
		 //For Third item - Select UOM attribute
		 //select an item location page
		 locations().selectAnItemFromProductList(data.strProductName3);
		 //verify product detail spage
		 product().verifyProductDetailsPage();
		 //Tap on Edit
		 generic().tapEdit();
		 //tap on uom Attribute
		 product().selectLocationQuantityUOM(data.strUOMAttribute3, "1");
		//tap on Done
		 generic().tapDone();
		 //tap on close
		 generic().tapClose();
		//verify entered quantity is displayed in line item
		 locations().verifyQuantityAndUOMAttributeWithItemName(data.strProductName3, "", data.strUOMAttribute3);
		 //verify item is not highlighted in blue color without entering quantity
		 locations().verifyItemBackGroundHighlightColor(data.strIndex3, false,data.strProductName3);	
		 //verify back ground color is highlighted for other 2 items (first 2 products )
		 locations().verifyItemBackGroundHighlightColor(data.strIndex1, true,data.strProductName1);	
		 locations().verifyItemBackGroundHighlightColor(data.strIndex2, true,data.strProductName2); 
		 //tap on back
		 generic().tapBack();
		//tap on back
		 generic().tapBack();
		 //logout from an app
		 home().logout();
		 //login again
		 component().login(data.strUserName, data.strPassword);
		 //tap on track inventory
		 home().tapTrackInventory();
		 //tap on any location
		 locations().tapLocation(data.strLocationName1);
		 //verify 1st 2 items are highlighted in blue color - Should retain it after logout and login
		 locations().verifyItemBackGroundHighlightColor(data.strIndex1, true,data.strProductName1);
		 locations().verifyItemBackGroundHighlightColor(data.strIndex2, true,data.strProductName2);
		 //verify item is not highlighted in blue color without entering quantity
		 locations().verifyItemBackGroundHighlightColor(data.strIndex3, false,data.strProductName3);	
		 //Tap on back
		 generic().tapBack();
		 //Tap on back 
		 generic().tapBack();
		 //hit on close inventory button
		 home().tapOnCloseInventory();
		 //verify close inventory confirmation message
		 home().verifyCloseInventoryConfirmationPopUp();
		 //hit on Yes, Close button
		 generic().tapYesDelete();
		 //verify close inventory success message
		 home().verifyCloseInventorySuccessMessage(true);
		 //tap on okay got it on close inventory success pop up
		 generic().tapYesDelete();  
		 //tap on track inventory
		 home().tapTrackInventory();
		 //tap on any location
		 locations().tapLocation(data.strLocationName1);  
		 //verify quantity intact for first 2 items
		 locations().verifyQuantityAndUOMAttributeWithItemName(data.strProductName1, data.strQty1, data.strUOMAttribute1);
		 locations().verifyQuantityAndUOMAttributeWithItemName(data.strProductName2, data.strQty2, data.strUOMAttribute2);
		 locations().verifyQuantityAndUOMAttributeWithItemName(data.strProductName3, "", data.strUOMAttribute3);
		 //verify blue color back ground is not retained for both items as the inventory is closed
		 locations().verifyItemBackGroundHighlightColor(data.strIndex1, false,data.strProductName1);
		 locations().verifyItemBackGroundHighlightColor(data.strIndex2, false,data.strProductName2);	
		//verify item is not highlighted in blue color without entering quantity
		 locations().verifyItemBackGroundHighlightColor(data.strIndex3, false,data.strProductName3);	
		 //close app
		 generic().closeApp();
	 
	 }
	 
	 
	 /******************************************************************************************
	  * Name : INV_UI_028_Verify_NoPhoneCallIcon_ForSupplier_NoContactNumber
	  * 
	  * Description : Verify phone call icon is not present in suppliers page when the supplier dont have contact number in supplier details page
	  * 
	  * Manual Test cases : INV_UI_028
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 10/18/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Usability","Usability_iOS1","Usability_ipad"}, description = "verify no phone call icon for supplier with no contact number")
	 public void INV_UI_028_Verify_NoPhoneCallIcon_ForSupplier_NoContactNumber(UsabilityObject data) throws Exception {	
		
		 //Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory -  Can plug it in once the set inventory screens are stable
		 component().setupInventorywithOGDefaultLocDefaultCat();
		 //Create new Supplier
		 component().createSupplier(data.strLocationName1, "", "", "", "", "");   // locationname1- supplier name
		 //tap on supplier form inventory tools page
		 home().tapSuppliers();
		 //verify the Suppliers page is loaded
		 supplier().verifySuppliersPage();		 
		 //verify newly created supplier is added in the list
		 supplier().verifySupplierInSupplierList(data.strLocationName1, true);
		 //verify whether phone call icon is displayed against supplier name in suppliers page
		 supplier().verifyPhoneCallIconForSupplier(data.strLocationName1, false);
		 //close app
		 generic().closeApp();
	 }
	 
	 
	 
	 /******************************************************************************************
	  * Name : INV_UI_029_Verify_PhoneCallIcon_ForSupplier_WithContactNumber_ExceptIPad
	  * 
	  * Description : Verify phone call icon is present in manage location page when the supplier dont have contact number in supplier details page
	  * 
	  * Manual Test cases : INV_UI_028
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 10/21/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/

	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Usability","Usability_iOS1"}, description = "verify no phone call icon for supplier with no contact number")

	 public void INV_UI_029_Verify_PhoneCallIcon_ForSupplier_WithContactNumber_ExceptIPad(UsabilityObject data) throws Exception {	
		
		 //Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory -  Can plug it in once the set inventory screens are stable
		 component().setupInventorywithOGDefaultLocDefaultCat();
		 //Create new Supplier
		 component().createSupplier(data.strLocationName1, "9876541230", "", "", "", "");   // locationname1- supplier name
		 //tap on supplier form inventory tools page
		 home().tapSuppliers();
		 //verify the Suppliers page is loaded
		 supplier().verifySuppliersPage();		 
		 //verify newly created supplier is added in the list
		 supplier().verifySupplierInSupplierList(data.strLocationName1, true);
		 //verify whether phone call icon is displayed against supplier name in suppliers page
		 supplier().verifyPhoneCallIconForSupplier(data.strLocationName1, true);
		 //close app
		 generic().closeApp();
	 }
	 
	 
	 /******************************************************************************************
	  * Name : INV_UI_030_Verify_PriceField_WithDecimal_WithoutDecimal_NonSyscoItemCreation
	  * 
	  * Description : Price field should be formatted with 2 decimal places while creating non sysco item
	  * 
	  * Manual Test cases : INV_UI_030
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 10/21/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------

	  ******************************************************************************************/


   @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Usability","Usability_iOS1"}, description = "Add non sysco item to inventory with supplier list and default category")

	 public void INV_UI_030_Verify_PriceField_WithDecimal_WithoutDecimal_NonSyscoItemCreation(UsabilityObject data) throws Exception {	
  	
   	//Login to app
		 component().login(data.strUserName, data.strPassword);
		 //INV_NSI_001 - Order guide + Default location + Default category	
		 component().setupInventorywithOGDefaultLocDefaultCat();		 
		 //create two suppliers as pre-requisite for this script 
		 component().createSupplier(data.strLocationName1, "", "", "", "", "");   // location name - supplier name
		 //part 1- Enter price with decimal and non decimal value while creating non sysco item	from home page	 
		//Tap Create Non-Sysco item
		 home().tapCreateNonSyscoItem();
		 //verify newly created supplier is displayed in supplier list
		 nonSyscoPrepItem().verifySupplierInSupplierList(data.strLocationName1, true);			 
		 //select one supplier from supplier list
		 nonSyscoPrepItem().selectSupplier(data.strLocationName1);
		 //tap next
		 generic().tapNextButton();		 
		 //verify product details page is displayed
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //verify product page fields displayed
		 nonSyscoPrepItem().verifyProductPageFields("nonsysco");
		 //verify mandatory fields - Creating item from home page
		 nonSyscoPrepItem().verifyNonSyscoItemMandatoryFields("Home");  
		 //enter product details
		 product().enterNonSyscoItemDetails(data.strProductName1, data.strNickName1, data.strProductBrand1, data.strProductId1, "5", "10", "8", data.strPrice1);		
		 //tap next button
		 generic().tapNextButton();		 
		 //verify select expenses screen is displayed
		 nonSyscoPrepItem().verifySelectCategoryPage();		   
		 //select one category form list of categories
		 nonSyscoPrepItem().selectCategory(data.strCategoryName1);
		 //tap next
		 generic().tapNextButton();		 
		 //verify select location page is displayed
		 nonSyscoPrepItem().verifySelectLocationPage();
		//select one location form list of locations
		 nonSyscoPrepItem().selectLocation(data.strLocationName2);	
		 //tap done button
		 generic().tapDoneButton();
		 //wait for 8 seconds
		 generic().waitFor(10);
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //verify product price in product details page
		 product().verifyPriceInProductDetails(data.strPrice1);
		 //click close in product details page
		 generic().tapClose(); 
		//close app
		 generic().closeApp();
   }
   
	
   
   /******************************************************************************************
	  * Name : INV_UI_030_Verify_InvoiceTotal_PurchaseTotal_WithDecimal_WithoutDecimal_Purchase
	  * 
	  * Description : Verify that in Purchase screen, Total purchases and  invoice total should be formated with 2 decimal places and commas as $10,000.00 or $10.000.50. 
	  * 
	  * Manual Test cases : INV_UI_030a
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 10/21/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------

	  ******************************************************************************************/
 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Usability","Usability_iOS1"}, description = "verify total purchase and invoice totatl should be fomratted with 2 decimal values and comma")
	 public void INV_UI_030a_Verify_InvoiceTotal_PurchaseTotal_WithDecimal_WithoutDecimal_Purchase(UsabilityObject data) throws Exception {	
	
 	//Login to app
		 component().login(data.strUserName, data.strPassword);
		 //INV_NSI_001 - Order guide + Default location + Default category	
		 component().setupInventorywithOGDefaultLocDefaultCat();		
		 //create new suppliers
		 component().createSupplier(data.strLocationName1, "", "", "", "", "");
		 //create two suppliers as pre-requisite for this script 
		 component().createPurchase(data.strLocationName1, "INV_UI_030a_Verify_InvoiceTotal_PurchaseTotal_WithDecimal_WithoutDecimal_Purchase", data.strInvoiceTotal, "Food/Food/Food", data.strPrice1+ "/"+ data.strPrice2+ "/"+ data.strPrice3, 1, "default", 0,"false");
		//Tap on purchase from inventory tools page
		 home().tapPurchases();
		 //verify total purchase and invoice total with/without decimal value
		 purchase().validateTotalPurchases(data.strTotalPurchase);
		 //verify invoice total from purchase page
		 purchase().verifyInvoiceTotal(data.strInvoiceTotal);
		 //tap on invoice line item
		 purchase().clickOnPurchaseLine("1");
		 //verify purhcase details page
		 purchase().verifyPurchaseDetailsPage();
		 //verify line item total amount format
//		 puchase().addLineAmountAndValidate();
		 //verify each line item amount format
		 purchase().verifyLineItemPrice("3", data.strPrice1);
		 purchase().verifyLineItemPrice("2", data.strPrice2);
		 purchase().verifyLineItemPrice("1", data.strPrice3);
		 //verify invoice total format	  
		 purchase().verifyInvoiceTotalInPurchaseDetails(data.strInvoiceTotal);
		 //verify line item total
	 purchase().verifyLineItemTotalInPurchaseDetails(data.strPrice4);
		//close app
		 generic().closeApp();
 }
 
 
 
 /******************************************************************************************
	  * Name : INV_UI_030_Verify_InvoiceTotal_PurchaseTotal_WithDecimal_WithoutDecimal_Purchase
	  * 
	  * Description : Verify that in Purchase screen, Total purchases and  invoice total should be formated with 2 decimal places and commas as $10,000.00 or $10.000.50. 
	  * 
	  * Manual Test cases : INV_UI_030a
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 10/21/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------

	  ******************************************************************************************/
@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Usability","Usability_iOS1"}, description = "verify total purchase and invoice totatl should be fomratted with 2 decimal values and comma")
	 public void INV_UI_030b_Verify_CostOfFood_FoodCost_WithDecimal_WithoutDecimal_Purchase(UsabilityObject data) throws Exception {	
	
	//Login to app
		 component().login(data.strUserName, data.strPassword);
		 //INV_NSI_001 - Order guide + Default location + Default category	
		 component().setupInventorywithOGDefaultLocDefaultCat();		 
		//hit on close inventory button
		 home().tapOnCloseInventory();
		 //verify close inventory confirmation message
		 home().verifyCloseInventoryConfirmationPopUp();
		 //hit on Yes, Close button
		 generic().tapYesDelete();
		 //verify close inventory success message
		 home().verifyCloseInventorySuccessMessage(true);
		//tap on okay got it on close inventory success pop up
		 generic().tapYesDelete();  
		 //wait for one min
		 LibraryPage.waitFor(30);
		 //tap on suppliers and navigate back to home page - just to wait for more than 60 sec
		 home().tapSuppliers();
		 LibraryPage.waitFor(15);
		 generic().tapBack();
		 LibraryPage.waitFor(25);
		//hit on close inventory button
		 home().tapOnCloseInventory();
		 //verify close inventory confirmation message
		 home().verifyCloseInventoryConfirmationPopUp();
		 //hit on Yes, Close button
		 generic().tapYesDelete();
		 //verify close inventory success message
		 home().verifyCloseInventorySuccessMessage(true);
		//tap on okay got it on close inventory success pop up
		 generic().tapYesDelete();   
		 //tap on food cost
		//Tap on View food cost
		home().tapOnViewFoodCost();
		//verify food cost is displayed
		foodCost().verifyFoodCostPage();
		//enter food sales
		foodCost().enterFoodSales(data.strPrice2);    // don't change
		//tap on consolidated view
		foodCost().tapOnConsolidatedView();		
		//verify food sales - with and without decimal
		foodCost().verifyTotalFoodSalesAmount(data.strPrice1);
		//tap back
		generic().tapBack();
		//logout from home page
		home().logout();
		//close app
		 generic().closeApp();
}
	 
}



