package com.uom.oldfiles;

import java.awt.Component;
import java.io.IOException;
import java.lang.reflect.Method;

import com.DataRead.Excel;
import com.framework.*;
import com.framework.configuration.ConfigFile;
import com.framework.utils.RetryAnalyzer;
import com.framework.utils.UOMTestNGListener;
import com.google.common.base.Supplier;
import com.uom.excelSheetObject.SuppliersObject;
import com.uom.excelSheetObject.TrackInventoryObject;
import com.uom.excelSheetObject.SetupInventoryObject;
import com.uom.pageFactory.PageFactory;
import com.uom.pages.common.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(value = UOMTestNGListener.class)
public class SetupInventory extends PageFactory{

	public static String[][] completeArray = null;	
	Starter starter = new Starter();


	@BeforeClass(alwaysRun=true)
	public void getData() throws Exception
	{		
		String strDataFilePath;
		Excel newExcel =new Excel();		
		completeArray=newExcel.read("test-data/TestData.xls","SetupInventory");
	}
    @BeforeMethod(alwaysRun = true)
    public void initiate() throws Exception
    {
    	
    	startup();
    }
    @AfterMethod
   	public void clean()
   	{
       	cleanUp();
   	}
	 @DataProvider(name = "DP1",parallel =false)
	public Object[][] getData(Method method) throws Exception{
		Excel newExcel =new Excel();	
		SetupInventoryObject sheetObj = new SetupInventoryObject();
		System.out.println(method.getName());
		String[][] MethodArray=newExcel.getMethodData(completeArray, method.getName());
		Object[][] retObjArr= sheetObj.getTestData(MethodArray);
		return(retObjArr);
	}

	/******************************************************************************************
	 * Name : INV_SI_001_Verify_Setup_Inventory_Setup_OG_Default_Loc_Default_Cat
	 * 
	 * Description : Verify setup inventory is done correctly with Order guide setup, default location,default categories.
	 * 
	 * Manual Test cases : INV_SI_001
	 * 
	 * Author : Reshma S Farook
	 * 
	 * Date : 9/29/2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log
	 * Date						Author						Description
	 * -----------------------------------------------------------------------------------------
	 *  
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"SetupInventory"}, description = "Verify setup inventory is done correctly with Order guide setup, default location,default categories.")
	public void INV_SI_001_Verify_Setup_Inventory_Setup_OG_Default_Loc_Default_Cat(SetupInventoryObject data) throws Exception {	

		//Login to UOM application
		component().login(data.strUserName, data.strPassword);
		//navigate to Setup inventory
		home().tapSetupInventory();
		//click on Skip link after clicking Setup Inventory
		setupInventory().clickSkipOnSetupInventory();	
		//verify whether import items page has been loaded successfully.
		setupInventory().verifyImportPageDisplayAfterSwipe();
		//click on Order Guide Selection and click Next button
		setupInventory().tapOnOrderGuideButton();
		setupInventory().tapOnNextButton();
		//verify whether setup locations page has been loaded successfully.
		setupInventory().verifySelectionAtSetupLocations();
		//Hit "Skip and Use Default" and hit Next
		setupInventory().tapOnSkipAndUseDefaultButtonInSetupInventoryPage();
		setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		setupInventory().verifySetupExpensesPageDisplay();
		// Hit on "Skip and use Food&Non-Food" and hit Next
		setupInventory().tapUseFoodAndNonFoodButton();
		setupInventory().tapOnNextButton();
		//complete the Setup process and verify whether the setup is complete and successful
		setupInventory().verifySetupIsComplete();
		//close app
		generic().closeApp();

	}

	/******************************************************************************************
	 * Name : INV_SI_017_Verify_Setup_Inventory_Setup_OG_Default_Loc_Skip_Category
	 * 
	 * Description : Verify setup inventory setup is done correctly with OG+Default Loc+ Skip the Category (Do this Later)
	 * 
	 * Manual Test cases : INV_SI_017
	 * 
	 * Author :Gayathri Anand
	 * 
	 * Date : 10/01/2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log
	 * Date						Author						Description
	 * -----------------------------------------------------------------------------------------
	 *  
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"SetupInventory_Invalid"}, description = "Verify setup inventory setup is done correctly with OG+Default Loc+ Skip the Category (Do this Later)")
	public void INV_SI_017_Verify_Setup_Inventory_Setup_OG_Default_Loc_Skip_Category(SetupInventoryObject data) throws Exception {	

		//Login to UOM application
		component().login(data.strUserName, data.strPassword);
		//navigate to Setup inventory
		home().tapSetupInventory();
		//click on Skip link after clicking Setup Inventory
		setupInventory().clickSkipOnSetupInventory();	
		//verify whether import items page has been loaded successfully.
		setupInventory().verifyImportPageDisplayAfterSwipe();
		//click on Order Guide Selection and click Next button
		setupInventory().tapOnOrderGuideButton();
		setupInventory().tapOnNextButton();
		//verify whether setup locations page has been loaded successfully.
		setupInventory().verifySelectionAtSetupLocations();
		//Hit "Skip and Use Default" and hit Next
		setupInventory().tapOnSkipAndUseDefaultButtonInSetupInventoryPage();
		setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		setupInventory().verifySetupExpensesPageDisplay();
		// Hit next button without selecting a category
		setupInventory().tapOnNextButton();
		//verify Inventory Assignment page is displayed
		setupInventory().verifyInventoryAssignmentPage();
		//tap done
		generic().tapDone();
		//complete the Setup process and verify whether the setup is complete and successful
		setupInventory().verifySetupIsComplete();
		//close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name : INV_SI_002_Verify_Setup_Inventory_Setup_OG_Custom_Loc_Def_Category_Single_Location_Selection
	 * 
	 * Description : Verify setup inventory setup is done correctly with OG+Custom Loc+ Default Category- Single location selection
	 * 
	 * Manual Test cases : INV_SI_002
	 * 
	 * Author :Gayathri Anand
	 * 
	 * Date : 10/01/2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log
	 * Date						Author						Description
	 * -----------------------------------------------------------------------------------------
	 *  
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"SetupInventory"}, description = "Verify setup inventory setup is done correctly with OG+Custom Loc+ Default Category- Single location selection")
	public void INV_SI_002_Verify_Setup_Inventory_Setup_OG_Custom_Loc_Def_Category_Single_Location_Selection(SetupInventoryObject data) throws Exception {	

		//Login to UOM application
		component().login(data.strUserName, data.strPassword);
		//navigate to Setup inventory
		home().tapSetupInventory();
		//click on Skip link after clicking Setup Inventory
		setupInventory().clickSkipOnSetupInventory();	
		//verify whether import items page has been loaded successfully.
		setupInventory().verifyImportPageDisplayAfterSwipe();
		//click on Order Guide Selection and click Next button
		setupInventory().tapOnOrderGuideButton();
		setupInventory().tapOnNextButton();
		//verify whether setup locations page has been loaded successfully.
		setupInventory().verifySelectionAtSetupLocations();
		//Hit Add new location
		setupInventory().tapOnAddNewLocationButton();
		//verify prompt to enter new location is displayed
		setupInventory().verifyPromptToEnterCustomLocations();
		//enter custom location details and hit save
		component().AddMultipleLocationsInSetUpLocation(data.strLocationNames, data.strLocationTypes);
		//verify newly added location in list view
		setupInventory().verifyAdditionOfNewLocation(data.strLocationNames);
		// Hit next button
		setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		setupInventory().verifySetupExpensesPageDisplay();
		// Hit on "Skip and use Food&Non-Food"
		setupInventory().tapUseFoodAndNonFoodButton();
		// Hit next button
		setupInventory().tapOnNextButton();
		//verify Inventory Assignment page is displayed
		setupInventory().verifyInventoryAssignmentPage();
		//swipe through all items and verify product details, category selected and select location for the items
		setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocation(true,true,"all",data.strLocationNames.split("/")[0], "default","");
		//tap done
		generic().tapDone();
		//complete the Setup process and verify whether the setup is complete and successful
		setupInventory().verifySetupIsComplete();
		//close app
		generic().closeApp();

	}
	/******************************************************************************************
	 * Name : INV_SI_015_Verify_Setup_Inventory_Setup_CustomList_SyscoList_Custom_Loc_Custom_Category
	 * 
	 * Description : Verify setup inventory is done correctly with custom Sysco list setup, custom location, custom categories.
	 * 
	 * Manual Test cases : INV_SI_015
	 * 
	 * Author : Asha
	 * 
	 * Date : 9/30/2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log
	 * Date						Author						Description
	 * -----------------------------------------------------------------------------------------
	 *  
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"SetUpInventory","SetupINVMissing","SetupInventory"}, description = "Verify setup inventory is done correctly with custom Sysco list setup, custom location, custom categories.")
	public void INV_SI_015_Verify_Setup_Inventory_Setup_CustomList_SyscoList_Custom_Loc_Custom_Category(SetupInventoryObject data) throws Exception {	

		//Login to app
		component().login(data.strUserName, data.strPassword);		 
		//navigate to Setup inventory
		home().tapSetupInventory();
		//click on Skip link after clicking Setup Inventory
		setupInventory().clickSkipOnSetupInventory();	
		//verify whether import items page has been loaded successfully.
		setupInventory().verifyImportPageDisplayAfterSwipe();
		generic().waitForPageLoadAndroid(3);
		//click on customList button and click Next button
		setupInventory().tapOnCustomListsButton();
		setupInventory().tapOnNextButton();
		//click on desired syscoList and click Next button
		setupInventory().tapOnDesiredListToSelectList(data.strCustomList1);
		generic().tapOnNextLinkInCustomListsPage();		 	 
		//verify whether setup locations page has been loaded successfully.
		setupInventory().verifySelectionAtSetupLocations();
		//hit 'Add new Locations'
		setupInventory().tapOnAddNewLocationButton();
		//Add 10 locations	
		component().AddMultipleLocationsInSetUpLocation(data.strLocationNames,data.strLocationTypes);
		//Verify newly added locations are listed and hit next
		setupInventory().verifyAdditionOfNewLocation(data.strLocationNames);
		setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		setupInventory().verifySetupExpensesPageDisplay();
		// Hit on "Add New category"
		setupInventory().tapOnAddNewExpenseCategory();
		component().AddMultipleCategoriesInNewCategory(data.strCategoryNames,data.strCategoryTypes);
		//verify newly added categories and tap on next
		setupInventory().verifyAdditionOfNewExpenseCategory(data.strCategoryNames);
		setupInventory().tapOnNextButton();
		//verify AssignProduct Display page
		setupInventory().verifyInventoryAssignmentPage();		
		generic().waitForPageLoadAndroid(5);
		//verify multiple locations  and categories displayed in product view
		setupInventory().verifyLocationsListedInAssignProductsPage(data.strLocationNames);
		setupInventory().verifyExpenseCategoriesInAssignProductsPage(data.strCategoryNames);
		//swipe through all items and verify product details, select location and select category for the items
		setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocationAndCategory(true,"13",data.strCategoryNames, data.strLocationNames.split("/")[0]);		 
		//hit on done 
		generic().tapDone();
		//verify setupComplete
		setupInventory().verifySetupIsComplete();
		//close app
		generic().closeApp();
	}





	/******************************************************************************************
	 * Name : INV_SI_012_Verify_Setup_CustomList_CustomLoc_DefaultCategory_MultipleLocation
	 * 
	 * Description : Verify setup inventory is done correctly with custom list,custom location ,default categories and assign multiple locations to only 1 product and verify it.
	 * 
	 * Manual Test cases : INV_SI_012
	 * 
	 * Author : Arun Mathai
	 * 
	 * Date : 9/30/2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log
	 * Date						Author						Description
	 * -----------------------------------------------------------------------------------------
	 *  
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"SetupInventory"}, description = "Verify setup inventory is done correctly with Custon lists, Custom location,default categories, Multiple location")
	public void INV_SI_012_Verify_Setup_CustomList_CustomLoc_DefaultCategory_MultipleLocation(SetupInventoryObject data) throws Exception {	

		//Login to app
		component().login(data.strUserName, data.strPassword);
		//navigate to Setup inventory
		home().tapSetupInventory();
		//click on Skip link after clicking Setup Inventory
		setupInventory().clickSkipOnSetupInventory();	
		//verify whether import items page has been loaded successfully.
		setupInventory().verifySelectionAtImportItems();
		//click on Custom Lists and click Next button
		setupInventory().tapOnCustomListsButton();
		setupInventory().tapOnNextButton();
		//verify whether all lists are present in the custom lists page
		ArrayList<String>customList=new ArrayList<>();
		String Clist1=data.strCustomList1;
		String Clist2=data.strCustomList2;
		String Clist3=data.strCustomList3;
		//	 String Clist4=data.strCustomList4;
		customList.add(Clist1);
		customList.add(Clist2);
		customList.add(Clist3);

		setupInventory().verifyListsInSelectListsPage(customList);
		//click on one of the lists in the Lists page. 
		setupInventory().tapOnDesiredListToSelectList(data.strCustomList1);
		//clicking on the next button
		generic().tapOnNextLinkInCustomListsPage();
		//Verify the select location page is seen
		setupInventory().verifySelectionAtSetupLocations();
		//	setupInventory().tapOnAddNewLocationButton();

		setupInventory().tapOnAddNewLocationButton();

		component().AddMultipleLocationsInSetUpLocation(data.strLocationNames,data.strLocationTypes);
		setupInventory().tapOnNextButton();
		//Verify setup expenses page is seen 
		setupInventory().verifySetupExpensesPageDisplay();
		//Tapping on UseFoodAndNonFoodButton(
		setupInventory().tapUseFoodAndNonFoodButton();
		// Hit next button
		setupInventory().tapOnNextButton();
		//Verify Assign products page
		setupInventory().verifyAssignProductsPageDisplay();

		setupInventory().tapOnMultipleLocationsListedInAssignProductsPage(data.strLocationNames);

		setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocation(true,true,"all", data.strLocationNames,"default","");
		//	setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocation(true,false,"all",data.strLocationNames,"default","");

		//	setupInventory().verifyAssignProductsPageLocationsTextAfterclickingLocationsButton(data.strLocationTapped);

		generic().tapDone();
		//verify setupComplete
		setupInventory().verifySetupIsComplete();

		//verify whether the setup is complete and successful
		//		setupInventory().tapOnTakeMeHomeButton();
		generic().closeApp();
	}







	/******************************************************************************************
	 * Name : INV_SI_013_Verify_Setup_Customlist_Mylist_DefaultLoc_SuggestCategory
	 * 
	 * Description : Verify setup inventory is done correctly with Custom lists(My lists), default location,Suggested categories
	 * 
	 * Manual Test cases : INV_SI_013
	 * 
	 * Author : Arun Mathai
	 * 
	 * Date : 10/03/2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log
	 * Date						Author						Description
	 * -----------------------------------------------------------------------------------------
	 *  
	 ******************************************************************************************/

	@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"SetupInventory"}, description = "Verify setup inventory is done correctly with Custon lists(My lists), default location,Suggested categories")
	public void INV_SI_013_Verify_Setup_Customlist_Mylist_DefaultLoc_SuggestCategory(SetupInventoryObject data) throws Exception {	

		//Login to app
		component().login(data.strUserName, data.strPassword);
		//navigate to Setup inventory
		home().tapSetupInventory();
		//click on Skip link after clicking Setup Inventory
		setupInventory().clickSkipOnSetupInventory();	
		//verify whether import items page has been loaded successfully.
		setupInventory().verifySelectionAtImportItems();
		//click on Custom Lists and click Next button
		setupInventory().tapOnCustomListsButton();
		setupInventory().tapOnNextButton();
		//verify whether all lists are present in the custom lists page

		ArrayList<String>customList=new ArrayList<>();
		String Clist1=data.strCustomList1;
		String Clist2=data.strCustomList2;
		String Clist3=data.strCustomList3;
		//	 String Clist4=data.strCustomList4;
		customList.add(Clist1);
		customList.add(Clist2);
		customList.add(Clist3);
		setupInventory().verifyListsInSelectListsPage(customList);
		//click on one of the lists in the Lists page. 


		setupInventory().tapOnDesiredListToSelectList(data.strCustomList1);
		//clicking on the next button
		generic().tapOnNextLinkInCustomListsPage();
		//Verify the select location page is seen
		setupInventory().verifySelectionAtSetupLocations();

		setupInventory().tapOnAddNewLocationButton();
		component().AddMultipleLocationsInSetUpLocation(data.strLocationNames,data.strLocationTypes);

		//Tapping on next button
		setupInventory().tapOnNextButton();
		//Verify setup expenses page is seen 
		setupInventory().verifySetupExpensesPageDisplay();
		//Tapping on UseFoodAndNonFoodButton(
		setupInventory().tapUseSuggestedCategories();
		// Hit next button
		setupInventory().tapOnNextButton();
		//Verify Assign products page
		setupInventory().verifyAssignProductsPageDisplay();

		setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocationAndCategory(false, "all", data.strCategoryNames.split("/")[0], data.strLocationNames);

		generic().tapDone();
		//verify setupComplete
		setupInventory().verifySetupIsComplete();

		//verify whether the setup is complete and successful
		//	setupInventory().tapOnTakeMeHomeButton();
		generic().closeApp();
	}






	/******************************************************************************************
	 * Name : INV_SI_016_Verify_Setup_Inventory_Setup_CustomList_MultipleList_Default_Loc_Default_Category_ItemsMultipleLocation
	 * Description : Verify setup inventory setup is done correctly with CustomList_MultipleList_Default_Loc_Default_Category_ItemsMultipleLocation
	 * 
	 * Manual Test cases : INV_SI_016
	 * 
	 * Author :Asha
	 * 
	 * Date : 10/03/2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log
	 * Date						Author						Description
	 * -----------------------------------------------------------------------------------------
	 *  
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"SetupInventory"}, description = "Verify_Setup_Inventory_Setup_CustomList_MultipleList_Default_Loc_Default_Category_ItemsMultipleLocation")
	public void INV_SI_016_Verify_Setup_Inventory_Setup_CustomList_MultipleList_Default_Loc_Default_Category_ItemsMultipleLocation(SetupInventoryObject data) throws Exception {	

		//Login to UOM application
		component().login(data.strUserName, data.strPassword);
		//navigate to Setup inventory
		home().tapSetupInventory();
		//click on Skip link after clicking Setup Inventory
		setupInventory().clickSkipOnSetupInventory();	
		//verify whether import items page has been loaded successfully.
		setupInventory().verifyImportPageDisplayAfterSwipe();
		//click on Order Guide Selection and click Next button
		setupInventory().tapOnCustomListsButton();
		setupInventory().tapOnNextButton();
		//click on multiple custom list( my list and sysco list)
		setupInventory().tapOnDesiredListToSelectList(data.strCustomList1);
		setupInventory().tapOnDesiredListToSelectList(data.strCustomList2);
		//click next button
		generic().tapOnNextLinkInCustomListsPage();	
		//verify whether setup locations page has been loaded successfully.
		setupInventory().verifySelectionAtSetupLocations();
		//Hit "Skip and Use Custom Categories as locations"
		setupInventory().tapOnSkipAndUseListNamesInSetupLocationsPage();	
		//hit next
		setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		setupInventory().verifySetupExpensesPageDisplay();			 
		// Hit on "Skip and use Food&Non-Food" and hit Next
		setupInventory().tapUseFoodAndNonFoodButton();
		// Hit next button
		setupInventory().tapOnNextButton();
		//complete the Setup process and verify whether the setup is complete and successful
		setupInventory().verifySetupIsComplete();
		//close app
		generic().closeApp();
	}


	/******************************************************************************************
	 * Name : INV_SI_018_Verify_Setup_Inventory_Setup_OG_Custom_Loc_Skip_Category_Single_Location_Selection
	 * 
	 * Description : Verify setup inventory setup is done correctly with OG+Custom Loc+ No Category- Single location selection
	 * 
	 * Manual Test cases : INV_SI_018
	 * 
	 * Author :Gayathri Anand
	 * 
	 * Date : 10/02/2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log
	 * Date						Author						Description
	 * -----------------------------------------------------------------------------------------
	 *  
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"SetupInventory_Invalid"}, description = "Verify setup inventory setup is done correctly with OG+Custom Loc+ No Category- Single location selection")
	public void INV_SI_018_Verify_Setup_Inventory_Setup_OG_Custom_Loc_Skip_Category_Single_Location_Selection(SetupInventoryObject data) throws Exception {	

		//Login to UOM application
		component().login(data.strUserName, data.strPassword);
		//navigate to Setup inventory
		home().tapSetupInventory();
		//click on Skip link after clicking Setup Inventory
		setupInventory().clickSkipOnSetupInventory();	
		//verify whether import items page has been loaded successfully.
		setupInventory().verifyImportPageDisplayAfterSwipe();
		//click on Order Guide Selection and click Next button
		setupInventory().tapOnOrderGuideButton();
		setupInventory().tapOnNextButton();
		//verify whether setup locations page has been loaded successfully.
		setupInventory().verifySelectionAtSetupLocations();
		//Hit Add new location
		setupInventory().tapOnAddNewLocationButton();
		//verify prompt to enter new location is displayed
		setupInventory().verifyPromptToEnterCustomLocations();
		//enter custom location details and hit save
		component().AddMultipleLocationsInSetUpLocation(data.strLocationNames, data.strLocationTypes);
		//verify newly added location in list view
		setupInventory().verifyAdditionOfNewLocation(data.strLocationNames);
		// Hit next button
		setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		setupInventory().verifySetupExpensesPageDisplay();
		// Hit next button without selecting a category
		setupInventory().tapOnNextButton();
		//verify Inventory Assignment page is displayed
		setupInventory().verifyInventoryAssignmentPage();
		//swipe through all items and verify product details, category selected and select location for the items
		setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocation(true,true,"all",data.strLocationNames.split("/")[0], "no category","");
		//tap done
		generic().tapDone();
		//complete the Setup process and verify whether the setup is complete and successful
		setupInventory().verifySetupIsComplete();
		//close app
		generic().closeApp();
	}


	/******************************************************************************************
	 * Name : INV_SI_019_Verify_Setup_Inventory_Setup_OG_Custom_Loc_Suggested_Category_Single_Location_Selection
	 * 
	 * Description : Verify setup inventory setup is done correctly with OG+Custom Loc+ Suggested Category- Single location selection
	 * 
	 * Manual Test cases : INV_SI_019
	 * 
	 * Author :Gayathri Anand
	 * 
	 * Date : 10/02/2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log
	 * Date						Author						Description
	 * -----------------------------------------------------------------------------------------
	 *  
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"SetupInventory"}, description = "Verify setup inventory setup is done correctly with OG+Custom Loc+ No Category- Single location selection")
	public void INV_SI_019_Verify_Setup_Inventory_Setup_OG_Custom_Loc_Suggested_Category_Single_Location_Selection(SetupInventoryObject data) throws Exception {	

		//Login to UOM application
		component().login(data.strUserName, data.strPassword);
		//navigate to Setup inventory
		home().tapSetupInventory();
		//click on Skip link after clicking Setup Inventory
		setupInventory().clickSkipOnSetupInventory();	
		//verify whether import items page has been loaded successfully.
		setupInventory().verifyImportPageDisplayAfterSwipe();
		//click on Order Guide Selection and click Next button
		setupInventory().tapOnOrderGuideButton();
		setupInventory().tapOnNextButton();
		//verify whether setup locations page has been loaded successfully.
		setupInventory().verifySelectionAtSetupLocations();
		//Hit Add new location
		setupInventory().tapOnAddNewLocationButton();
		//verify prompt to enter new location is displayed
		setupInventory().verifyPromptToEnterCustomLocations();
		//enter custom location details and hit save
		component().AddMultipleLocationsInSetUpLocation(data.strLocationNames, data.strLocationTypes);
		//verify newly added location in list view
		setupInventory().verifyAdditionOfNewLocation(data.strLocationNames);
		// Hit next button
		setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		setupInventory().verifySetupExpensesPageDisplay();
		// Hit on use suggested categories 
		setupInventory().tapUseSuggestedCategories();
		setupInventory().tapOnNextButton();
		//verify Inventory Assignment page is displayed
		setupInventory().verifyInventoryAssignmentPage();
		//swipe through all items and verify product details, category selected and select location for the items
		setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocation(true,true,"all",data.strLocationNames.split("/")[0], "suggested","");
		//tap done
		generic().tapDone();
		//complete the Setup process and verify whether the setup is complete and successful
		setupInventory().verifySetupIsComplete();
		//close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name : INV_SI_005_Verify_Setup_Inventory_Setup_OG_Default_Loc_Custom_Category
	 * 
	 * Description : Verify setup inventory setup is done correctly with OG+Default Loc+ Custom Category
	 * 
	 * Manual Test cases : INV_SI_005
	 * 
	 * Author :Gayathri Anand
	 * 
	 * Date : 10/03/2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log
	 * Date						Author						Description
	 * -----------------------------------------------------------------------------------------
	 *  
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"SI_MultipleLocCat","SetupINVMissing","SetupInventory"}, description = "Verify setup inventory setup is done correctly with OG+Default Loc+ Custom Category")
	public void INV_SI_005_Verify_Setup_Inventory_Setup_OG_Default_Loc_Custom_Category(SetupInventoryObject data) throws Exception {	

		//Login to UOM application
		component().login(data.strUserName, data.strPassword);
		//navigate to Setup inventory
		home().tapSetupInventory();
		//click on Skip link after clicking Setup Inventory
		setupInventory().clickSkipOnSetupInventory();	
		//verify whether import items page has been loaded successfully.
		setupInventory().verifyImportPageDisplayAfterSwipe();
		//click on Order Guide Selection and click Next button
		setupInventory().tapOnOrderGuideButton();
		setupInventory().tapOnNextButton();
		//verify whether setup locations page has been loaded successfully.
		setupInventory().verifySelectionAtSetupLocations();
		//Hit "Skip and Use Default" and hit Next
		setupInventory().tapOnSkipAndUseDefaultButtonInSetupInventoryPage();
		setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		setupInventory().verifySetupExpensesPageDisplay();
		//Hit 'Add new Category'
		setupInventory().tapOnAddNewExpenseCategory();
		//verify prompt to enter category details
		setupInventory().verifyPromptToEnterCustomCategories();
		//add multiple categories
		component().AddMultipleCategoriesInNewCategory(data.strCategoryNames, data.strCategoryTypes);
		//verify newly added categories in list view
		setupInventory().verifyAdditionOfNewExpenseCategory(data.strCategoryNames);
		setupInventory().tapOnNextButton();
		//verify Inventory Assignment page is displayed
		setupInventory().verifyInventoryAssignmentPage();
		//swipe through all items and verify product details, default location and select category for the items
		setupInventory().swipeThroughItemsToVerifyDetailsAndSelectCategory(true,"all",data.strCategoryNames.split("/")[0],"default");
		//tap done
		generic().tapDone();
		//complete the Setup process and verify whether the setup is complete and successful
		setupInventory().verifySetupIsComplete();
		//close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name : INV_SI_006_Verify_Setup_Inventory_Setup_OG_Custom_Loc_Custom_Category
	 * 
	 * Description : Verify setup inventory setup is done correctly with OG+Custom Loc+ Custom Category
	 * 
	 * Manual Test cases : INV_SI_006
	 * 
	 * Author :Gayathri Anand
	 * 
	 * Date : 10/04/2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log
	 * Date						Author						Description
	 * -----------------------------------------------------------------------------------------
	 *  
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"SetupInventory"}, description = "Verify setup inventory setup is done correctly with OG+Custom Loc+ Custom Category")
	public void INV_SI_006_Verify_Setup_Inventory_Setup_OG_Custom_Loc_Custom_Category(SetupInventoryObject data) throws Exception {	

		//Login to UOM application
		component().login(data.strUserName, data.strPassword);
		//navigate to Setup inventory
		home().tapSetupInventory();
		//click on Skip link after clicking Setup Inventory
		setupInventory().clickSkipOnSetupInventory();	
		//verify whether import items page has been loaded successfully.
		setupInventory().verifyImportPageDisplayAfterSwipe();
		//click on Order Guide Selection and click Next button
		setupInventory().tapOnOrderGuideButton();
		setupInventory().tapOnNextButton();
		//verify whether setup locations page has been loaded successfully.
		setupInventory().verifySelectionAtSetupLocations();
		//Hit Add new location
		setupInventory().tapOnAddNewLocationButton();
		//verify prompt to enter new location is displayed
		setupInventory().verifyPromptToEnterCustomLocations();
		//enter custom location details and hit save
		component().AddMultipleLocationsInSetUpLocation(data.strLocationNames, data.strLocationTypes);
		//verify newly added location in list view
		setupInventory().verifyAdditionOfNewLocation(data.strLocationNames);
		// Hit next button
		setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		setupInventory().verifySetupExpensesPageDisplay();
		//Hit 'Add new Category'
		setupInventory().tapOnAddNewExpenseCategory();
		//verify prompt to enter category details
		setupInventory().verifyPromptToEnterCustomCategories();
		//add multiple categories
		component().AddMultipleCategoriesInNewCategory(data.strCategoryNames, data.strCategoryTypes);
		//verify newly added categories in list view
		setupInventory().verifyAdditionOfNewExpenseCategory(data.strCategoryNames);
		setupInventory().tapOnNextButton();
		//verify Inventory Assignment page is displayed
		setupInventory().verifyInventoryAssignmentPage();
		//swipe through all items and verify product details, select location and select category for the items
		setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocationAndCategory(true,"all",data.strCategoryNames.split("/")[0], data.strLocationNames.split("/")[0]);
		//tap done
		generic().tapDone();
		//complete the Setup process and verify whether the setup is complete and successful
		setupInventory().verifySetupIsComplete();
		//close app
		generic().closeApp();
	} 
	/******************************************************************************************
	 * Name : INV_SI_003_Verify_Setup_Inventory_Setup_OG_Custom_Loc_Def_Category_Multiple_Location_Selection
	 * 
	 * Description : Verify setup inventory setup is done correctly with OG+Custom Loc+ Default Category- Multiple location selection
	 * 
	 * Manual Test cases : INV_SI_003
	 * 
	 * Author :Reshma S Farook
	 * 
	 * Date : 04-10-2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log
	 * Date						Author						Description
	 * -----------------------------------------------------------------------------------------
	 *  
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"SI_MultipleLocCat","SetupINVMissing","SetupInventory"}, description = "Verify setup inventory setup is done correctly with OG+Custom Loc+ Default Category- Multiple location selection")
	public void INV_SI_003_Verify_Setup_Inventory_Setup_OG_Custom_Loc_Def_Category_Multiple_Location_Selection(SetupInventoryObject data) throws Exception {	

		//Login to UOM application
		component().login(data.strUserName, data.strPassword);
		//navigate to Setup inventory
		home().tapSetupInventory();
		//click on Skip link after clicking Setup Inventory
		setupInventory().clickSkipOnSetupInventory();	
		//verify whether import items page has been loaded successfully.
		setupInventory().verifyImportPageDisplayAfterSwipe();
		//click on Order Guide Selection 
		setupInventory().tapOnOrderGuideButton();
		//click Next button
		setupInventory().tapOnNextButton();
		//verify whether setup locations page has been loaded successfully.
		setupInventory().verifySelectionAtSetupLocations();
		//Hit Add new location
		setupInventory().tapOnAddNewLocationButton();
		//verify prompt to enter new location is displayed
		setupInventory().verifyPromptToEnterCustomLocations();
		//enter custom location details and hit save
		component().AddMultipleLocationsInSetUpLocation(data.strLocationNames,data.strLocationTypes);
		//verify newly added location in list view
		setupInventory().verifyAdditionOfNewLocation(data.strLocationNames);
		// Hit next button
		setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		setupInventory().verifySetupExpensesPageDisplay();		
		//Hit on "Skip and use Food&Non-Food" and hit Next
		setupInventory().tapUseFoodAndNonFoodButton();
		setupInventory().tapOnNextButton();
		//verify Inventory Assignment page is displayed
		setupInventory().verifyInventoryAssignmentPage();
		//swipe through all items and verify product details, category selected and select multiple locations for the items
		setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocation(true,true,"all",data.strAddLocationName,"default","");
		//tap done
		generic().tapDone();
		//complete the Setup process and verify whether the setup is complete and successful
		setupInventory().verifySetupIsComplete();
		//close app
		generic().closeApp();

	} 

	/******************************************************************************************
	 * Name : INV_SI_004_Verify_Setup_Inventory_Setup_OG_Def_Loc_Suggested_Category
	 * 
	 * Description : Verify setup inventory setup is done correctly with Order guide, Default location and Suggested 12 category
	 * 
	 * Manual Test cases : INV_SI_004
	 * 
	 * Author :Reshma S Farook
	 * 
	 * Date : 30-09-2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log
	 * Date						Author						Description
	 * -----------------------------------------------------------------------------------------
	 *  
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"SetupInventory"}, description = "Verify setup inventory setup is done correctly with Order guide, Default location and Suggested 12 category")
	public void INV_SI_004_Verify_Setup_Inventory_Setup_OG_Def_Loc_Suggested_Category(SetupInventoryObject data) throws Exception {	

		//Login to UOM application
		component().login(data.strUserName, data.strPassword);
		home().tapSetupInventory();
		//click on Skip link after clicking Setup Inventory
		setupInventory().clickSkipOnSetupInventory();	
		//verify whether import items page has been loaded successfully.
		setupInventory().verifyImportPageDisplayAfterSwipe();
		//click on Order Guide Selection and click Next button
		setupInventory().tapOnOrderGuideButton();
		setupInventory().tapOnNextButton();
		//verify whether setup locations page has been loaded successfully.
		setupInventory().verifySelectionAtSetupLocations();
		//Hit "Skip and Use Default" and hit Next
		setupInventory().tapOnSkipAndUseDefaultButtonInSetupInventoryPage();
		//tap on next - 13.5 
		setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		setupInventory().verifySetupExpensesPageDisplay();
		// Hit on "Skip and use Suggested Category" and hit Next
		setupInventory().tapUseSuggestedCategories();
		//tap on next - 13.5 
		setupInventory().tapOnNextButton();
		//complete the Setup process and verify whether the setup is complete and successful
		setupInventory().verifySetupIsComplete();
		//close app
		generic().closeApp();

	} 

	/******************************************************************************************
	 * Name : INV_SI_007_Verify_Setup_Inventory_Setup_CustomList_Def_Loc_Def_Category_Single_Location
	 * 
	 * Description : Verify setup inventory setup is done correctly with CustomList, Default location and Default category for single location/custom category as location
	 * 
	 * Manual Test cases : INV_SI_007
	 * 
	 * Author :Reshma S Farook
	 * 
	 * Date : 30-09-2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log
	 * Date						Author						Description
	 * -----------------------------------------------------------------------------------------
	 *  
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"SetupInventory"}, description = "Verify setup inventory setup is done correctly with CustomList, Default location and Default category for single location/custom category as location")
	public void INV_SI_007_Verify_Setup_Inventory_Setup_CustomList_Def_Loc_Def_Category_Single_Location(SetupInventoryObject data) throws Exception {	

		//Login to UOM application
		component().login(data.strUserName, data.strPassword);
		home().tapSetupInventory();
		//click on Skip link after clicking Setup Inventory
		setupInventory().clickSkipOnSetupInventory();	
		//verify whether import items page has been loaded successfully.
		setupInventory().verifyImportPageDisplayAfterSwipe();	 
		//Select Custom List (My List) in SMX
		setupInventory().tapOnCustomListsButton();
		setupInventory().tapOnNextButton();		
		setupInventory().tapOnDesiredListToSelectList(data.strCustomList1);
		generic().tapOnNextLinkInCustomListsPage();	    
		//verify whether setup locations page has been loaded successfully.
		setupInventory().verifySelectionAtSetupLocations();
		//Hit "Skip and Use Custom Categories as locations" and hit Next
		setupInventory().tapOnSkipAndUseCustomCategoriesInSetupLocationsPage();
		setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		setupInventory().verifySetupExpensesPageDisplay();
		// Hit on "Skip and use Food and Non Food" and hit Next
		setupInventory().tapUseFoodAndNonFoodButton();
		setupInventory().tapOnNextButton();
		//complete the Setup process and verify whether the setup is complete and successful
		setupInventory().verifySetupIsComplete();	
		//close app
		generic().closeApp();
	} 

	/******************************************************************************************
	 * Name : INV_SI_009_Verify_Setup_Inventory_Setup_CustomList_Def_Loc_Def_Category_Multiple_Location
	 * 
	 * Description : Verify setup inventory setup is done correctly with Custom List(Multiple List - My lists)+Default Loc+Default Cat (Items Multiple Location)
	 * 
	 * Manual Test cases : INV_SI_009
	 * 
	 * Author :Reshma S Farook
	 * 
	 * Date : 04-10-2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log
	 * Date						Author						Description
	 * -----------------------------------------------------------------------------------------
	 *  
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"SetupInventory"}, description = "Verify setup inventory setup is done correctly with Custom List(Multiple List - My lists)+Default Loc+Default Cat (Items Multiple Location)")
	public void INV_SI_009_Verify_Setup_Inventory_Setup_CustomList_Def_Loc_Def_Category_Multiple_Location(SetupInventoryObject data) throws Exception {	

		//Login to UOM application
		component().login(data.strUserName, data.strPassword);
		home().tapSetupInventory();
		//click on Skip link after clicking Setup Inventory
		setupInventory().clickSkipOnSetupInventory();	
		//verify whether import items page has been loaded successfully.
		setupInventory().verifyImportPageDisplayAfterSwipe();	 
		//Select Multiple Custom Lists (My Lists) in UOM with Item in list1 and list 2
		setupInventory().tapOnCustomListsButton();
		setupInventory().tapOnNextButton();		
		setupInventory().tapOnDesiredListToSelectList(data.strCustomList1);
		setupInventory().tapOnDesiredListToSelectList(data.strCustomList2);
		generic().tapOnNextLinkInCustomListsPage();	    
		//verify whether setup locations page has been loaded successfully.
		setupInventory().verifySelectionAtSetupLocations();
		//Hit "Skip and Use List Names" and hit Next
		setupInventory().tapOnSkipAndUseListNamesInSetupLocationsPage();
		setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		setupInventory().verifySetupExpensesPageDisplay();
		// Hit on "Skip and Use Food and Non Food" and hit Next
		setupInventory().tapUseFoodAndNonFoodButton();	
		setupInventory().tapOnNextButton();
		//complete the Setup process and verify whether the setup is complete and successful
		setupInventory().verifySetupIsComplete();	
		//close app
		generic().closeApp();
	} 

	/******************************************************************************************
	 * Name : INV_SI_010_Verify_Setup_Inventory_Setup_CustomList_Def_Loc_Def_Category
	 * 
	 * Description : Verify setup inventory setup is done correctly with Custom List+Default Loc+Default Cat
	 * 
	 * Manual Test cases : INV_SI_010
	 * 
	 * Author :Reshma S Farook
	 * 
	 * Date : 30-09-2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log
	 * Date						Author						Description
	 * -----------------------------------------------------------------------------------------
	 *  
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"SetupInventory"}, description = "Verify setup inventory setup is done correctly with Custom List+Default Loc+Default Cat")
	public void INV_SI_010_Verify_Setup_Inventory_Setup_CustomList_Def_Loc_Def_Category(SetupInventoryObject data) throws Exception {	

		//Login to UOM application
		component().login(data.strUserName, data.strPassword);
		home().tapSetupInventory();
		//click on Skip link after clicking Setup Inventory
		setupInventory().clickSkipOnSetupInventory();	
		//verify whether import items page has been loaded successfully.
		setupInventory().verifyImportPageDisplayAfterSwipe();	 
		//Select Custom List (My List) in SMX
		setupInventory().tapOnCustomListsButton();
		setupInventory().tapOnNextButton();		
		setupInventory().tapOnDesiredListToSelectList(data.strCustomList1);
		generic().tapOnNextLinkInCustomListsPage();	    
		//verify whether setup locations page has been loaded successfully.
		setupInventory().verifySelectionAtSetupLocations();
		//Hit "Skip and Use Default" and hit Next
		setupInventory().tapOnSkipAndUseDefaultButtonInSetupInventoryPage();
		setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		setupInventory().verifySetupExpensesPageDisplay();
		// Hit on "Skip Food & Non Food" button and hit Next
		setupInventory().tapUseFoodAndNonFoodButton();
		setupInventory().tapOnNextButton();
		//complete the Setup process and verify whether the setup is complete and successful
		setupInventory().verifySetupIsComplete();		
		//close app
		generic().closeApp();
	} 

	/******************************************************************************************
	 * Name : INV_SI_011_Verify_Setup_Inventory_Setup_SharedList_Def_Loc_Def_Category
	 * 
	 * Description : Verify setup inventory setup is done correctly with Shared List+Default Loc+Default Cat
	 * 
	 * Manual Test cases : INV_SI_011
	 * 
	 * Author :Reshma S Farook
	 * 
	 * Date : 30-09-2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log
	 * Date						Author						Description
	 * -----------------------------------------------------------------------------------------
	 *  
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"SI_MultipleLocCat","SetupINVMissing","SetupInventory"}, description = "Verify setup inventory setup is done correctly with Shared List+Default Loc+Default Cat")
	public void INV_SI_011_Verify_Setup_Inventory_Setup_SharedList_Def_Loc_Def_Category(SetupInventoryObject data) throws Exception {	

		//Login to UOM application
		component().login(data.strUserName, data.strPassword);
		home().tapSetupInventory();
		//click on Skip link after clicking Setup Inventory
		setupInventory().clickSkipOnSetupInventory();	
		//verify whether import items page has been loaded successfully.
		setupInventory().verifyImportPageDisplayAfterSwipe();	 
		//Select Custom List (Shared List) in SMX
		setupInventory().tapOnCustomListsButton();
		setupInventory().tapOnNextButton();		
		setupInventory().tapOnDesiredListToSelectList(data.strCustomList1);
		generic().tapOnNextLinkInCustomListsPage();	    
		//verify whether setup locations page has been loaded successfully.
		setupInventory().verifySelectionAtSetupLocations();
		//Hit Add new location
		setupInventory().tapOnAddNewLocationButton();
		//enter custom location details and hit save
		component().AddMultipleLocationsInSetUpLocation(data.strLocationNames, data.strLocationTypes);
		// Hit next button
		setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		setupInventory().verifySetupExpensesPageDisplay();
		//Hit On Skip and Use Food and Non-Food
		setupInventory().tapUseFoodAndNonFoodButton();
		// Hit next button
		setupInventory().tapOnNextButton();
		//verify Inventory Assignment page is displayed
		setupInventory().verifyInventoryAssignmentPage();
		//swipe through all items and verify product details, default category selected and select multiple locations for the items
		setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocation(true,false,"all",data.strNewLocation,"default","");
		//tap done
		generic().tapDone();
		//complete the Setup process and verify whether the setup is complete and successful
		setupInventory().verifySetupIsComplete();
		//close app
		generic().closeApp();
	} 

	/******************************************************************************************
	 * Name : INV_SI_014_Verify_Setup_Inventory_Setup_SharedList_Def_Loc_Custom_Category_Single_Location
	 * 
	 * Description : Verify setup inventory setup is done correctly with Custom list (Shared list)+Default Loc+Custom Categories
	 * 
	 * Manual Test cases : INV_SI_014
	 * 
	 * Author :Reshma S Farook
	 * 
	 * Date : 30-09-2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log
	 * Date						Author						Description
	 * -----------------------------------------------------------------------------------------
	 *  
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"SI_MultipleLocCat","SetupINVMissing","SetupInventory"}, description = "Verify setup inventory setup is done correctly with Custom list (Shared list)+Default Loc+Custom Categories")
	public void INV_SI_014_Verify_Setup_Inventory_Setup_SharedList_Def_Loc_Custom_Category_Single_Location(SetupInventoryObject data) throws Exception {	

		//Login to UOM application
		component().login(data.strUserName, data.strPassword);
		//navigate to Setup inventory
		home().tapSetupInventory();
		//click on Skip link after clicking Setup Inventory
		setupInventory().clickSkipOnSetupInventory();	
		//verify whether import items page has been loaded successfully.
		setupInventory().verifyImportPageDisplayAfterSwipe();	 
		//Select Custom List (Shared List) in SMX
		setupInventory().tapOnCustomListsButton();
		setupInventory().tapOnNextButton();		
		setupInventory().tapOnDesiredListToSelectList(data.strCustomList1);
		generic().tapOnNextLinkInCustomListsPage();
		//verify whether setup locations page has been loaded successfully.
		setupInventory().verifySelectionAtSetupLocations();
		//Hit "Skip and Use Default" and hit Next
		setupInventory().tapOnSkipAndUseDefaultButtonInSetupInventoryPage();
		setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		setupInventory().verifySetupExpensesPageDisplay();
		//Hit 'Add new Category'
		setupInventory().tapOnAddNewExpenseCategory();
		//verify prompt to enter category details
		setupInventory().verifyPromptToEnterCustomCategories();
		//add multiple categories
		component().AddMultipleCategoriesInNewCategory(data.strCategoryNames,data.strCategoryTypes);
		//verify newly added categories in list view
		setupInventory().verifyAdditionOfNewExpenseCategory(data.strCategoryNames);
		setupInventory().tapOnNextButton();
		//verify Inventory Assignment page is displayed
		setupInventory().verifyInventoryAssignmentPage();
		//swipe through all items and verify product details, default location and select category for the items
		setupInventory().swipeThroughItemsToVerifyDetailsAndSelectCategory(true,"all",data.strCategoryNames,"default");
		//tap done
		generic().tapDone();
		//complete the Setup process and verify whether the setup is complete and successful
		setupInventory().verifySetupIsComplete();
		//close app
		generic().closeApp();
	} 

	/******************************************************************************************
	 * Name : INV_SI_020_Verify_Setup_Inventory_Setup_OG_Custom_Loc_Custom_Category
	 * 
	 * Description : Verify setup inventory setup is done correctly with Order guide, Custom location and Custom category assigning	only some items and leaving other items without location or category
	 * 
	 * Manual Test cases : INV_SI_020
	 * 
	 * Author :Reshma S Farook
	 * 
	 * Date : 01-10-2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log
	 * Date						Author						Description
	 * -----------------------------------------------------------------------------------------
	 *  
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"SI_MultipleLocCat","SetupINVMissing","SetupInventory"}, description = "Verify setup inventory setup is done correctly with Order guide, Custom location and Custom category assigning	only some items and leaving other items without location or category")
	public void INV_SI_020_Verify_Setup_Inventory_Setup_OG_Custom_Loc_Custom_Category(SetupInventoryObject data) throws Exception {	

		//Login to UOM application
		component().login(data.strUserName, data.strPassword);
		//navigate to Setup inventory
		home().tapSetupInventory();
		//click on Skip link after clicking Setup Inventory
		setupInventory().clickSkipOnSetupInventory();	
		//verify whether import items page has been loaded successfully.
		setupInventory().verifyImportPageDisplayAfterSwipe();
		//click on Order Guide Selection and click Next button
		setupInventory().tapOnOrderGuideButton();
		setupInventory().tapOnNextButton();
		//verify whether setup locations page has been loaded successfully.
		setupInventory().verifySelectionAtSetupLocations();
		//Hit "Add new location"
		setupInventory().tapOnAddNewLocationButton();
		//verify prompt to enter new location is displayed
		setupInventory().verifyPromptToEnterCustomLocations();
		//enter custom location details and hit save
		component().AddMultipleLocationsInSetUpLocation(data.strLocationNames, data.strLocationTypes);
		//verify newly added location in list view
		setupInventory().verifyAdditionOfNewLocation(data.strLocationNames);
		// Hit next button
		setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		setupInventory().verifySetupExpensesPageDisplay();
		//Hit "Add new Category"
		setupInventory().tapOnAddNewExpenseCategory();
		//Verify prompt to enter New categories
		setupInventory().verifyPromptToEnterCustomCategories();
		//Add 10-15 new Categories
		component().AddMultipleCategoriesInNewCategory(data.strCategoryNames, data.strCategoryTypes);
		//setupInventory().addNewCategoryExpense(CategoryNames, CategoryTypes);
		//Verify Addition of newly added categories.
		setupInventory().verifyAdditionOfNewExpenseCategory(data.strCategoryNames);
		// Hit next button
		setupInventory().tapOnNextButton();
		//verify Inventory Assignment page is displayed
		setupInventory().verifyInventoryAssignmentPage();
		//swipe through all items and verify product details, category selected and select single location for the items
		setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocationAndCategory(true,"3", data.strCategoryNames, data.strAddLocationName);
		//tap done
		generic().tapDone();
		//complete the Setup process and verify whether the setup is complete and successful
		setupInventory().verifySetupIsComplete();
		//close app
		generic().closeApp();
	}
}
