package com.uom.tests;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.DataRead.Excel;
import com.framework.Starter;
import com.framework.configuration.ConfigFile;
import com.framework.utils.RetryAnalyzer;
import com.framework.utils.UOMTestNGListener;
import com.uom.excelSheetObject.CloseInventoryObject;
import com.uom.excelSheetObject.ExpenseCategoriesObject;
import com.uom.pageFactory.PageFactory;


@Listeners(value = UOMTestNGListener.class)
public class CloseInventory extends PageFactory{
	

	public static String[][] completeArray = null;	
   	Starter starter = new Starter();   	
   	
   	
    @BeforeClass(alwaysRun=true)
   	public void getData() throws Exception
   	{		
   		String strDataFilePath;
   		Excel newExcel =new Excel();
   	if(!ConfigFile.getProperty("platformType").toString().equalsIgnoreCase("ios"))
   	{
   		completeArray=newExcel.read("test-data/TestData.xls","CloseInventory");
   	}
   	else{
   		completeArray=newExcel.read("test-data/TestData.xls","CloseInventory_IOS");
   	}
   	}
    
    @BeforeMethod(alwaysRun=true)
    public void initiate() throws Exception
    {
    	
    	  	startup();
    }
    
    @AfterMethod
	public void clean()
	{
    	cleanUp();
	}
    
    @DataProvider(name = "DP1",parallel =true)
    public Object[][] getData(Method method) throws Exception{
	 	Excel newExcel =new Excel();
	 	CloseInventoryObject sheetObj = new CloseInventoryObject();
	 	 System.out.println(method.getName());
	     String[][] MethodArray=newExcel.getMethodData(completeArray, method.getName());
	     Object[][] retObjArr= sheetObj.getTestData(MethodArray);
	     return(retObjArr);
    }
    
    /******************************************************************************************
	  * Name : INV_CI_001_Close_Inventory_All_Items_Assigned_Default_Loc_Default_Cat
	  * 
	  * Description : Validate the Close Inventory if all the items in an inventory are  assigned to Location and Category for Default location and default category
	  * 
	  * Manual Test cases : INV_CI_001
	  * 
	  * Author : Gayathri Anand
	  * 
	  * Date : 10/14/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
  @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"CloseInventory","CloseInventoryIOS1"}, description = "Validate the Close Inventory if all the items in an inventory are  assigned to Location and Category for Default location and default category")
	 public void INV_CI_001_Close_Inventory_All_Items_Assigned_Default_Loc_Default_Cat(CloseInventoryObject data) throws Exception {	
  	
  		//Login to app
		 component().login(data.strUserName, data.strPassword);
		//setup inventory - precondition -INV_SI_001
		component().setupInventorywithOGDefaultLocDefaultCat();
		//verify close inventory option -- Method updated button to link with respect to new build APP v1.0.0
		home().verifyCloseInventoryLinkDisplayed(true);
		//verify close inventory button enabled -- Method updated button to link with respect to new build APP v1.0.0
		home().verifyCloseInventoryLinkEnabled(true);
		//hit on close inventory link chart 
		home().tapOnCloseInventoryLink();
		//hit on close inventory link button
		home().tapOnCloseInventory();
		//verify close inventory confirmation message
		home().verifyCloseInventoryConfirmationPopUp();
		//hit on Yes, Close button
		generic().tapYesDelete();
		//verify close inventory success message
		home().verifyCloseInventorySuccessMessage(true);
		//close app
		generic().closeApp();
	  }
  
  /******************************************************************************************
	  * Name : INV_CI_002_Close_Inventory_All_Items_Assigned_Custom_Loc_Default_Cat
	  * 
	  * Description : Validate the Close Inventory if all the items in an inventory are  assigned to Location and Category for Custom location and default category
	  * 
	  * Manual Test cases : INV_CI_002
	  * 
	  * Author : Gayathri Anand
	  * 
	  * Date : 10/14/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"CloseInventory","CloseInventoryIOS1"}, description = "Validate the Close Inventory if all the items in an inventory are  assigned to Location and Category for Custom location and default category")
	 public void INV_CI_002_Close_Inventory_All_Items_Assigned_Custom_Loc_Default_Cat(CloseInventoryObject data) throws Exception {	
	
		//Login to app
		 component().login(data.strUserName, data.strPassword);
		//setup inventory - precondition -INV_SI_003
		component().setupInventorywithOGCustomLocDefaultCatMultipleLocation(data.strLocationNames, data.strLocationTypes, data.strLocationName1,false);
		//verify close inventory option --Method updated button to link with respect to new build APP v1.0.0
		home().verifyCloseInventoryLinkDisplayed(true);
		//verify close inventory button enabled--Method updated button to link with respect to new build APP v1.0.0
		home().verifyCloseInventoryLinkEnabled(true);
		//hit on close inventory link chart 
		home().tapOnCloseInventoryLink();
		//hit on close inventory link button
		home().tapOnCloseInventory();
		//verify close inventory confirmation message
		home().verifyCloseInventoryConfirmationPopUp();
		//hit on Yes, Close button
		generic().tapYesDelete();
		//verify close inventory success message
		home().verifyCloseInventorySuccessMessage(true);
		//close app
		generic().closeApp();
	  }

/******************************************************************************************
 * Name : INV_CI_003_Close_Inventory_All_Items_Assigned_Default_Loc_Suggested_Cat
 * 
 * Description : Validate the Close Inventory if all the items in an inventory are  assigned to Location and Category for default location and suggested category
 * 
 * Manual Test cases : INV_CI_003
 * 
 * Author : Gayathri Anand
 * 
 * Date : 10/14/2016
 * 
 * Notes : NA
 * 
 * Modification Log
 * Date						Author						Description
 * -----------------------------------------------------------------------------------------
 *  
 ******************************************************************************************/
@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"CloseInventory","CloseInventoryIOS1"}, description = "Validate the Close Inventory if all the items in an inventory are  assigned to Location and Category for default location and suggested category")
public void INV_CI_003_Close_Inventory_All_Items_Assigned_Default_Loc_Suggested_Cat(CloseInventoryObject data) throws Exception {	

	//Login to app
	 component().login(data.strUserName, data.strPassword);
	//setup inventory - precondition -INV_SI_004
	component().setupInventorywithOGDefaultLocSugg12Cat();
	//verify close inventory option -- Method updated button to link with respect to new build APP v1.0.0
	home().verifyCloseInventoryLinkDisplayed(true);
	//verify close inventory button enabled -- Method updated button to link with respect to new build APP v1.0.0
	home().verifyCloseInventoryLinkEnabled(true);
	//hit on close inventory link chart 
	home().tapOnCloseInventoryLink();
	//hit on close inventory link button
	home().tapOnCloseInventory();
	//verify close inventory confirmation message
	home().verifyCloseInventoryConfirmationPopUp();
	//hit on Yes, Close button
	generic().tapYesDelete();
	//verify close inventory success message
	home().verifyCloseInventorySuccessMessage(true);
	//close app
	generic().closeApp();
 }

/******************************************************************************************
 * Name : INV_CI_004_Close_Inventory_All_Items_Assigned_Custom_Loc_Custom_Cat
 * 
 * Description : Validate the Close Inventory if all the items in an inventory are  assigned to Location and Category for custom location and custom category
 * 
 * Manual Test cases : INV_CI_004
 * 
 * Author : Gayathri Anand
 * 
 * Date : 10/14/2016
 * 
 * Notes : NA
 * 
 * Modification Log
 * Date						Author						Description
 * -----------------------------------------------------------------------------------------
 * 
 ******************************************************************************************/
@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"CloseInventory","CloseInventoryIOS1","CriticalPatchIOS"}, description = "Validate the Close Inventory if all the items in an inventory are  assigned to Location and Category for custom location and custom category")
public void INV_CI_004_Close_Inventory_All_Items_Assigned_Custom_Loc_Custom_Cat(CloseInventoryObject data) throws Exception {	

	//Login to app
	 component().login(data.strUserName, data.strPassword);
	//setup inventory - precondition -INV_SI_006
	component().setupInventorywithOGCustomLocCustomCategory(data.strLocationNames, data.strLocationTypes, data.strCategoryNames, data.strCategoryTypes);
	//verify close inventory option -- Method updated button to link with respect to new build APP v1.0.0
	home().verifyCloseInventoryLinkDisplayed(true);
	//verify close inventory button enabled --Method updated button to link with respect to new build APP v1.0.0
	home().verifyCloseInventoryLinkEnabled(true);
	//hit on close inventory link chart 
	home().tapOnCloseInventoryLink();
	//hit on close inventory link button
	home().tapOnCloseInventory();
	//verify close inventory confirmation message
	home().verifyCloseInventoryConfirmationPopUp();
	//hit on Yes, Close button
	generic().tapYesDelete();
	//verify close inventory success message
	home().verifyCloseInventorySuccessMessage(true);
	//close app
	generic().closeApp();
 }

/******************************************************************************************
 * Name : INV_CI_006_Close_Inventory_All_Items_Assigned_Custom_Loc_List_Names_Default_Cat
 *
 * Description : Validate the Close Inventory if all the items in an inventory are  assigned to Location and Category for custom location as list names and default category
 *
 * Manual Test cases : INV_CI_006
 *
 * Author : Gayathri Anand
 *
 * Date : 10/14/2016
 *
 * Notes : NA
 *
 * Modification Log
 * Date						Author						Description
 * -----------------------------------------------------------------------------------------
 *
 ******************************************************************************************/
@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"CloseInventory","CloseInventoryIOS1","CriticalBatchAndroid"}, description = "Validate the Close Inventory if all the items in an inventory are  assigned to Location and Category for custom location as list names and default category")
public void INV_CI_006_Close_Inventory_All_Items_Assigned_Custom_Loc_List_Names_Default_Cat(CloseInventoryObject data) throws Exception {

	//Login to app
	 component().login(data.strUserName, data.strPassword);
	//setup inventory - precondition -INV_SI_009
	component().setupInventorywithMulCustListDefLocDefCatItemInMultipeLoc(data.strListName1, data.strListName2);
	//verify close inventory option --Method updated button to link with respect to new build APP v1.0.0
	home().verifyCloseInventoryLinkDisplayed(true);
	//verify close inventory button enabled --Method updated button to link with respect to new build APP v1.0.0
	home().verifyCloseInventoryLinkEnabled(true);
	//hit on close inventory link chart 
	home().tapOnCloseInventoryLink();
	//hit on close inventory link button
	home().tapOnCloseInventory();
	//verify close inventory confirmation message
	home().verifyCloseInventoryConfirmationPopUp();
	//hit on Yes, Close button
	generic().tapYesDelete();
	//verify close inventory success message
	home().verifyCloseInventorySuccessMessage(true);
	//close app
	generic().closeApp();
 }

/******************************************************************************************
 * Name : INV_CI_007_008_009_Close_Inventory_Some_Items_Not_Assigned_Assign_Expenses
 *
 * Description : Validate the Close Inventory if the user has some items which are not assigned to expense category or locations and Only assign items to expense category
 *
 * Manual Test cases : INV_CI_007, INV_CI_008,INV_CI_009
 *
 * Author : Gayathri Anand
 *
 * Date : 10/14/2016
 *
 * Notes : NA
 *
 * Modification Log
 * Date						Author						Description
 * -----------------------------------------------------------------------------------------
 *
 ******************************************************************************************/
@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"CloseInventory","CloseInventoryIOS2"}, description = "Validate the Close Inventory if the user has some items which are not assigned to expense category or locations and Only assign items to expense category")
public void INV_CI_007_008_009_Close_Inventory_Some_Items_Not_Assigned_Assign_Expenses(CloseInventoryObject data) throws Exception {

	//Login to app
	 component().login(data.strUserName, data.strPassword);
	//setup inventory - precondition -INV_SI_020
	component().setupInventorywithOGCustomLocCustomCatAssignOnlySomeItems(false,data.strLocationNames, data.strLocationTypes, data.strCategoryNames, data.strCategoryTypes, data.strLocationName1, data.strCategoryNames);
	//tap on close inventory link
	home().tapOnCloseInventoryLink();
	//verify close inventory button displayed or not
	home().verifyCloseInventoryButtonDisplayed(true);
	//verify close inventory button disabled -- Method updated button to link with respect to new build APP v1.0.0
	home().verifyCloseInventoryButtonDisplayed(true);
	//verify inventory not up to date message is displayed
	home().verifyInventoryNotUptoDateMessage(true);
	//hit on inventory is not up to date link
	home().tapOnInventoryNotUptoDate();
	//verify inventory closing page is displayed
	home().verifyInventoryClosingPageIsDisplayed();
	//hit on Assign Expense Categories link
	home().tapOnAssignExpenseCategories();
	//verify Assign Expenses Workflow screen is displayed
	home().verifyAssignExpensesWorkFlowScreenIsDisplayed();
	//swipe through items and assign categories
	setupInventory().swipeThroughItemsToVerifyDetailsAndSelectCategory(false, "all", data.strCategoryNames, "");
	//hit on done
	generic().tapDone();
	//verify close inventory option
	home().verifyCloseInventoryButtonDisplayed(true);
	//verify close inventory button disabled
	home().verifyCloseInventoryButtonDisplayed(true);
	//hit on close inventory link chart and then close inventory button
	home().tapOnCloseInventory();
	//verify close inventory confirmation message
	home().verifyCloseInventoryConfirmationPopUp();
	//hit on Yes, Close button
	generic().tapYesDelete();
	//verify close inventory success message
	home().verifyCloseInventorySuccessMessage(true);
	//close app
	generic().closeApp();
 }

/******************************************************************************************
 * Name : INV_CI_010_Close_Inventory_Some_Items_Not_Assigned_Assign_Expenses_And_Locations
 *
 * Description : Validate the Close Inventory if the user has some items which are not assigned to expense category or locations and assign items to expense category and locations
 *
 * Manual Test cases : INV_CI_010
 *
 * Author : Gayathri Anand
 *
 * Date : 10/14/2016
 *
 * Notes : NA
 *
 * Modification Log
 * Date						Author						Description
 * -----------------------------------------------------------------------------------------
 *
 ******************************************************************************************/
@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"CloseInventory","CloseInventoryIOS2"}, description = "Validate the Close Inventory if the user has some items which are not assigned to expense category or locations and assign items to expense category and locations")
public void INV_CI_010_Close_Inventory_Some_Items_Not_Assigned_Assign_Expenses_And_Locations(CloseInventoryObject data) throws Exception {

	//Login to app
	 component().login(data.strUserName, data.strPassword);
	//setup inventory - precondition -INV_SI_020
	component().setupInventorywithOGCustomLocCustomCatAssignOnlySomeItems(false,data.strLocationNames, data.strLocationTypes, data.strCategoryNames, data.strCategoryTypes, data.strLocationName1, data.strCategoryNames);
	//hit on close inventory link
	home().tapOnCloseInventoryLink();
	//hit on inventory is not up to date link
	home().tapOnInventoryNotUptoDate();
	//verify inventory closing page is displayed
	home().verifyInventoryClosingPageIsDisplayed();
	//hit on Assign Expense Categories link
	home().tapOnAssignExpenseCategories();
	//verify Assign Expenses Workflow screen is displayed
	home().verifyAssignExpensesWorkFlowScreenIsDisplayed();
	//swipe through items and assign categories
	setupInventory().swipeThroughItemsToVerifyDetailsAndSelectCategory(false, "all", data.strCategoryNames, "");
	//hit on done
	generic().tapDone();
	//verify close inventory option
	home().verifyCloseInventoryLinkDisplayed(true);
	//verify close inventory button disabled
	home().verifyCloseInventoryLinkEnabled(true);
	//hit on assign locations link
	home().tapOnAssignLocoations();
	//verify Assign Locations Workflow screen is displayed
	home().verifyAssignLocationsWorkFlowScreenIsDisplayed();
	//swipe through items and assign locations
	setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocation(false, false, "all", data.strLocationNames.split("/")[0], "custom", data.strCategoryNames);
	//hit on done
	generic().tapDone();
	//hit on close inventory link chart and then close inventory button
	home().tapOnCloseInventory();
	//verify close inventory confirmation message
	home().verifyCloseInventoryConfirmationPopUp();
	//hit on Yes, Close button
	generic().tapYesDelete();
	//verify close inventory success message
	home().verifyCloseInventorySuccessMessage(true);
	//close app
	generic().closeApp();
 }

/******************************************************************************************
 * Name : INV_CI_011_Verify_Close_Inventory_MA_User
 *
 * Description : Validate the Close Inventory option is not available for MA user
 *
 * Manual Test cases : INV_CI_011
 *
 * Author : Gayathri Anand
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
@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"CloseInventory","CloseInventoryIOS1"}, description = "Validate the Close Inventory option is not available for MA user")
public void INV_CI_011_Verify_Close_Inventory_MA_User(CloseInventoryObject data) throws Exception {

	//Login to app
	 component().login(data.strUserName, data.strPassword,false);
	 //verify inventory tools page
	 home().verifyInventoryToolsPage();
	//verify close inventory option
	home().verifyCloseInventoryLinkDisplayed(false);
	//close app
	generic().closeApp();
}
	 /******************************************************************************************
	  * Name : INV_CI_005_Close_Inventory_All_Items_Assigned_Custom_Loc_As_Custom_Categories_Default_Cat
	  *
	  * Description : Validate the Close Inventory if all the items in an inventory are  assigned to Location and Category for custom location as custom categories and default category
	  *
	  * Manual Test cases : INV_CI_005
	  *
	  * Author : Gayathri Anand
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
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"CloseInventory","CloseInventoryIOS1"}, description = "Validate the Close Inventory if all the items in an inventory are  assigned to Location and Category for custom location as custom categories and default category")
	 public void INV_CI_005_Close_Inventory_All_Items_Assigned_Custom_Loc_As_Custom_Categories_Default_Cat(CloseInventoryObject data) throws Exception {

	 	//Login to app
	 	 component().login(data.strUserName, data.strPassword);
	 	//setup inventory - precondition -INV_SI_007
	 	component().setupInventorywithCustomListCustCatAsLocationDefaultCat(data.strListName1);
	 	//verify close inventory option -- Method updated button to link with respect to new build APP v1.0.0
	 	home().verifyCloseInventoryLinkDisplayed(true);
	 	//verify close inventory button enabled --Method updated button to link with respect to new build APP v1.0.0
	 	home().verifyCloseInventoryLinkEnabled(true);
	 	//hit on close inventory link chart 
	 	home().tapOnCloseInventoryLink();
	 	//hit on close inventory link button
	 	home().tapOnCloseInventory();
	 	//verify close inventory confirmation message
	 	home().verifyCloseInventoryConfirmationPopUp();
	 	//hit on Yes, Close button
	 	generic().tapYesDelete();
	 	//verify close inventory success message
	 	home().verifyCloseInventorySuccessMessage(true);
	 	//close app
	 	generic().closeApp();
	  }

}

