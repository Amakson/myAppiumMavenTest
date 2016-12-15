 package com.uom.components;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.util.Strings;

import com.framework.configuration.ConfigFile;
import com.framework.frameworkFunctions.LibraryPage;
import com.framework.reporting.FrameworkReporter;
import com.sun.jna.platform.win32.OaIdl.LIBFLAGS;
import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;
import com.uom.excelSheetObject.SetupInventoryObject;
import com.uom.pageFactory.PageFactory;
import com.uom.pages.common.LocationsPage;

public class Components extends PageFactory{
	
	public static String userName="";
	
	/**
	 * @Function createSupplier
	 * @author Parvathy_P	
	 * @throws InterruptedException 
	 * @description Create a supplier. This component can be used only when supplier creation is only a prerequisite of a test case. No validations are covered apart from the basic checks  
	 * @date 24-09-2016
	 */
	public void createSupplier(String strSupplierName,String strPhoneNumber,String strAddress,String strContactInformation,String strEmailAddress,String strNotes) throws InterruptedException
	{
		 //Tap Suppliers
		 home().tapSuppliers();
		 //verify the Suppliers page is loaded
		 supplier().verifySuppliersPage();
		 //Click on +
		 generic().tapAdd();
		 //Verify Add suppliers page is loaded
		 supplier().verifyAddSupplierPage();
		 //Enter supplier details
		 supplier().enterSupplierDetails(strSupplierName,strPhoneNumber,strAddress,strContactInformation,strEmailAddress,strNotes);
		 //swipe the screen vertically down to view done button		
		 locations().swipeScreenInVertical(2, 8);
		 //tap done
		 generic().tapDone();
		 //tap back
		 generic().tapClose();
		 //verify the Suppliers page is loaded
		 supplier().verifySuppliersPage();
		 //verify newly created supplier is added in the list
		 supplier().verifySupplierInSupplierList(strSupplierName, true);
		 //tap back
		 generic().tapBack();
	}
	

	/**
	 * @Function login
	 * @author Parvathy_P	
	 * @description Login to UOM application 
	 * @date 24-09-2016
	 */
	public void login(String strUserName,String strPassword, Boolean... userCleanups)
	{

		
		
		boolean userCleanup = true;
		
		if(userCleanups.length >0 && !userCleanups[0])
		{
			userCleanup = false;
		}
		if(userCleanup)
		{
			//user clean up
			generic().userCleanUp(strUserName);
		}
		//if user name not displayed ... log out ..  for iOS
		
	//	if((ConfigFile.getProperty("platformType").equalsIgnoreCase("ios"))){
			home().logoutAfterCheck();
	//	}
		
		login().enterUserName(strUserName);
		login().enterPassword(strPassword);
		login().tapLogin();
		

	}
	
	/**
	 * @Function createExpenseCategory
	 * @author Gayathri_Anand	
	 * @description Create an expense category. This component can be used only when expense category creation is only a prerequisite of a test case. No validations are covered apart from the basic checks  
	 * @date 24-09-2016
	 */
	public void createExpenseCategory(String strExpenseName,String strExpenseType)
	{
		 //Tap Expense Categories
		 home().tapExpenseCategories();
		 //verify the expense categories page is loaded
		 expenseCat().verifyExpenseCategoriesPage();
		 //Click on +
		 generic().tapAdd();
		 //Verify Add expense categories page is loaded
		 expenseCat().verifyAddExpenseCategoryPage();
		 //enter category details
		 expenseCat().enterCategoryDetails(strExpenseName, strExpenseType);
		 //tap done
		 generic().tapDone();
		 //tap back
		 generic().tapClose();
		//verify the expense categories page is loaded
		 expenseCat().verifyExpenseCategoriesPage();
		 //verify newly created category is added in the list
		 expenseCat().verifyCategoryInCategoryList(strExpenseName, true);
	}
	
	/**
	 * @Function createLocationFromManageLocation
	 * @author Periyasamy_Nainar
	 * @throws InterruptedException 
	 * @description Create New location from manage location page. This component can be used only when location creation is only a prerequisite of a test case. No validations are covered apart from the basic checks  
	 * 				Only one validation is added in this function to verify whether newly created location is appearing or not in locations page. 
	 * @date 29-09-2016
	 */
	public void createLocationFromManageLocation(String strLocationName,String strLocationType) throws InterruptedException
	{
		//Tap Locations from inventory tools page
		 home().tapLocations();
		//verify the Locations page is loaded
		 locations().verifyLocationsPage();
		 //Click on +
		 generic().tapAdd();
		 //verify add location page
		 locations().verifyAddLocationPage();
		 //Enter Location details
		 locations().enterLocationDetails(strLocationName,strLocationType);
		 //tap done
		 generic().tapDone();
		 //wait for page load
		 LibraryPage.waitForPageLoadAndroid(2);
		 //tap close
		 generic().tapClose();
		 //verify the Locations page is loaded
		 locations().verifyLocationsPage();
		 //verify newly created Location is added in the list
		 locations().verifyLocationInList(strLocationName,true);		
		 //tap back
		 generic().tapBack();
	}
	
	
	
	/**
	 * @Function setupInventorywithOGCustomLocSuggestedCategorySomeItemSelection
	 * @author Arun Mathai
	 * @description Setup Inventory with Order guide, Custom location and suggested category and single location for some items	 
	 */
	public void setupInventorywithOGCustomLocSuggestedCategorySomeItemSelection(String strLocationNames,String strLocationTypes)
	{
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
		 //enter custom location details and hit save
		 component().AddMultipleLocationsInSetUpLocation(strLocationNames,strLocationTypes);
		 // Hit next button
		 setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		 setupInventory().verifySetupExpensesPageDisplay();
		// tap on suggested categories
		 setupInventory().tapUseSuggestedCategories();
		 setupInventory().tapOnNextButton();
		 //verify Inventory Assignment page is displayed
		 setupInventory().verifyInventoryAssignmentPage();
		 //swipe through all items and verify product details, category selected and select single location for the items
		 setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocation(false,true,"3",strLocationNames.split("/")[0], "suggested","");
		 //tap done
		 generic().tapDone();
		 //complete the Setup process and verify whether the setup is complete and successful
		 setupInventory().verifySetupIsComplete();
	}
	
	
	
	
	/**
	 * @Function createLocationFromTrackInventory
	 * @author Periyasamy_Nainar
	 * @throws InterruptedException 
	 * @description Create New location from Track inventory page. This component can be used only when location creation is only a prerequisite of a test case. No validations are covered apart from the basic checks  
	 * 				Only one validation is added in this function to verify whether newly created location is appearing or not in locations page. 
	 * @date 29-09-2016
	 */
	public void createLocationFromTrackInventory(String strLocationName,String strLocationType) throws InterruptedException
	{
		//Tap Locations from inventory tools page
		 home().tapTrackInventory();
		//verify the Locations page is loaded
		 locations().verifyLocationsPage();
		 //Click on +
		 generic().tapAdd();
		 //verify add location page
		 locations().verifyAddLocationPage();
		 //Enter Location details
		 locations().enterLocationDetails(strLocationName,strLocationType);
		 //tap done
		 generic().tapDone();
		 //tap close
		 generic().tapClose();
		 //verify the Locations page is loaded
		 locations().verifyLocationsPage();
		 //verify newly created Location is added in the list
		 locations().verifyLocationInList(strLocationName,true);		
		 //tap back
		 generic().tapBack();
	}
	
	/**
	 * @Function editLocationFromManageLocation
	 * @author Periyasamy_Nainar
	 * @throws InterruptedException 
	 * @description Create New location from manage location page. This component can be used only when location creation is only a prerequisite of a test case. No validations are covered apart from the basic checks  
	 * 				Only one validation is added in this function to verify whether newly created location is appearing or not in locations page. 
	 * @date 29-09-2016
	 */
	public void editLocationFromManageLocation(String strOldLocationName,String strNewLocationName,String strLocationType) throws InterruptedException
	{
		//Tap Locations from inventory tools page
		 home().tapLocations();
		//verify the Locations page is loaded
		 locations().verifyLocationsPage();
		//Tap on location from locations page
		 locations().tapLocation(strOldLocationName);
		//verify add location page
		 locations().verifyLocationDetailsPage();
		 //Tap on Edit button
		 generic().tapEdit();		 
		 //Enter Location details
		 locations().enterLocationDetails(strNewLocationName,strLocationType);
		 //tap done
		 generic().tapDone();
		 //tap close
		 generic().tapClose();
		 //verify the Locations page is loaded
		 locations().verifyLocationsPage();
		 //verify newly created Location is added in the list
		 locations().verifyLocationInList(strNewLocationName,true);		
		 //verify old location is not available in the list
		 locations().verifyLocationInList(strOldLocationName, false);
		 //tap back
		 generic().tapBack();
	}
	
	/**
	 * @Function setupInventorywithOGDefaultLocDefaultCat
	 * @author Reshma S Farook
	 * @description Setup Inventory with Order guide, Default location and default category -INV_SI_001 
	 * @date 30-09-2016
	 */
	public void setupInventorywithOGDefaultLocDefaultCat()
	{
		
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
		// Hit on "Skip and use Food&Non-Food" and hit Next
		setupInventory().tapUseFoodAndNonFoodButton();
		//tap on next - 13.5 
		setupInventory().tapOnNextButton();
		//complete the Setup process and verify whether the setup is complete and successful
		setupInventory().verifySetupIsComplete();	 
	}
	
	/**
	 * @Function setupInventorywithOGDefaultLocSugg12Cat
	 * @author Reshma S Farook
	 * @description Setup Inventory with Order guide, Default location and Suggested 12 category -INV_SI_004 * 
	 * @date 30-09-2016
	 */
	public void setupInventorywithOGDefaultLocSugg12Cat()
	{
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
	}
	
	/**
	 * @Function setupInventorywithCustomListDefLocDefCat
	 * @author Reshma S Farook
	 * @description Setup Inventory with CustomList, Default location and Default category - INV_SI_010 	 * 
	 * @date 30-09-2016
	 */
	public void setupInventorywithCustomListDefLocDefCat(String ListName)
	{
	    home().tapSetupInventory();
	    //click on Skip link after clicking Setup Inventory
	    setupInventory().clickSkipOnSetupInventory();	
	    //verify whether import items page has been loaded successfully.
	    setupInventory().verifyImportPageDisplayAfterSwipe();	 
	    //Select Custom List (My List) in SMX
	    setupInventory().tapOnCustomListsButton();
	    setupInventory().tapOnNextButton();		
	    setupInventory().tapOnDesiredListToSelectList(ListName);
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
	}
	
	/**
	* @Function setupInventorywithCustomListCustCatAsLocationDefaultCat
	 * @author Reshma S Farook
	 * @description Setup Inventory with CustomList, Default location and Default category for single location/custom category as location -INV_SI_007	 * 
	 * @date 01-10-2016
	 */
	//Renamed - setupInventorywithCustomListDefLocDefCatSingleLocCustCatAsLocation
	public void setupInventorywithCustomListCustCatAsLocationDefaultCat(String ListName)
	{
	    home().tapSetupInventory();
	    //click on Skip link after clicking Setup Inventory
	    setupInventory().clickSkipOnSetupInventory();	
	    //verify whether import items page has been loaded successfully.
	    setupInventory().verifyImportPageDisplayAfterSwipe();	 
	    //Select Custom List (My List) in SMX
	    setupInventory().tapOnCustomListsButton();
	    setupInventory().tapOnNextButton();		
	    setupInventory().tapOnDesiredListToSelectList(ListName);
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
	}
	
	/**
	* @Function setupInventorywithSharedListCustLocDefCatSingleLocation
	 * @author Reshma S Farook
	 * @description Setup Inventory with Shared List, Custom location and Default category for single location - INV_SI_011* 
	 * @date 01-10-2016
	 */
	 public void  setupInventorywithSharedListCustLocDefCatSingleLocation(String strSharedListName,String strLocationNames,String strLocationTypes,String strAssignLocations,boolean storeReq){
	    home().tapSetupInventory();
	    //click on Skip link after clicking Setup Inventory
	    setupInventory().clickSkipOnSetupInventory();	
	    //verify whether import items page has been loaded successfully.
	    setupInventory().verifyImportPageDisplayAfterSwipe();	 
	    //Select Custom List (Shared List) in SMX
	    setupInventory().tapOnCustomListsButton();
	    setupInventory().tapOnNextButton();		
	    setupInventory().tapOnDesiredListToSelectList(strSharedListName);
	    generic().tapOnNextLinkInCustomListsPage();	    
	    //verify whether setup locations page has been loaded successfully.
		setupInventory().verifySelectionAtSetupLocations();
		//Hit Add new location
		setupInventory().tapOnAddNewLocationButton();
		//enter custom location details and hit save
		component().AddMultipleLocationsInSetUpLocation(strLocationNames, strLocationTypes);
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
		setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocation(false,storeReq,"all",strAssignLocations,"default","");
		//tap done
		generic().tapDone();
		//complete the Setup process and verify whether the setup is complete and successful
		setupInventory().verifySetupIsComplete();
	}

		/**
		* @Function setupInventorywithSharedListCustLocDefCatSingleLocation
		* @author Reshma S Farook
		* @description Setup Inventory with  Custom list (Shared list)+Default Loc+Custom Categories - INV_SI_014
		* @date 05-10-2016
	    */ 
	 public void setupInventorywithSharedListDefLocCustomCat(String strSharedListName,String strCategoryNames,String strCategoryTypes,String strAssignCategory)
	 {
		 //navigate to Setup inventory
		 home().tapSetupInventory();
		 //click on Skip link after clicking Setup Inventory
		 setupInventory().clickSkipOnSetupInventory();	
		 //verify whether import items page has been loaded successfully.
		 setupInventory().verifyImportPageDisplayAfterSwipe();	 
		 //Select Custom List (Shared List) in SMX
		 setupInventory().tapOnCustomListsButton();
		 setupInventory().tapOnNextButton();		
		 setupInventory().tapOnDesiredListToSelectList(strSharedListName);
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
		 //add multiple categories
		 component().AddMultipleCategoriesInNewCategory(strCategoryNames,strCategoryTypes);
		 setupInventory().tapOnNextButton();
		 //verify Inventory Assignment page is displayed
		 setupInventory().verifyInventoryAssignmentPage();
		 //swipe through all items and verify product details, default location and select category for the items
		 setupInventory().swipeThroughItemsToVerifyDetailsAndSelectCategory(false,"all",strAssignCategory.split("/")[0],"default");
		 //tap done
		 generic().tapDone();
		 //complete the Setup process and verify whether the setup is complete and successful
		 setupInventory().verifySetupIsComplete();
	 }
	 
	 
	/**
	 * @Function AddMultipleLocationsInSetUpLocation
	 * @author Asha
	 * @description This will create as many locations based on the names and types provided in the excel
	 * @date 30-09-2016
	 */
	public void AddMultipleLocationsInSetUpLocation(String strLocationName,String strLocationType)
	{
		 for (int i=0;i<strLocationName.split("/").length;i++){ 
			setupInventory().addLocationInSetupLocations(strLocationName.split("/")[i], strLocationType.split("/")[i]);
			setupInventory().tapOnSaveButtonInSetupLocationsPage();
			//need to remove the below line of code - work around to avoid the issue as of now. 
			//setupInventory().tapOnCancelNewLocationCreationXButton(); Commented since the issue is fixed - D-0738 (Version 13.6)
			if(i<strLocationName.split("/").length-1){
			setupInventory().tapOnAddNewLocationButton();
			}
		 }
		 if(strLocationName.split("/").length>3){
			 setupInventory().setLocationExpanderValue(true);
		 }
		 else{
			 setupInventory().setLocationExpanderValue(false);
		 }
	}
	
	/**
	 * @Function AddMultipleCategoriesInNewCategory
	 * @author Asha
	 * @description This will create as many Categories based on the names and types provided in the excel
	 * @date 30-09-2016
	 */
	public void AddMultipleCategoriesInNewCategory(String strCategoryName,String strCategoryType)
	{
		String foodCategories="";
		 for (int i = 0; i<strCategoryName.split("/").length; i++){
			 
			 setupInventory().addNewCategoryExpense(strCategoryName.split("/")[i], strCategoryType.split("/")[i]);
			 setupInventory().tapOnSavebuttonInSetupExpense();
			 if(i<strCategoryName.split("/").length-1){
				 if(strCategoryType.split("/")[i].equalsIgnoreCase("food")){
					 foodCategories=foodCategories+strCategoryName.split("/")[i]+"/";
				 }
				 setupInventory().tapOnAddNewExpenseCategory();
				 }
			 else{
				 if(strCategoryType.split("/")[i].equalsIgnoreCase("food")){
					 foodCategories=foodCategories+strCategoryName.split("/")[i];
				 }
			 }
			 }
		 setupInventory().getFoodCategories(foodCategories);
		// setupInventory().tapOnSavebuttonInSetupExpense();
		 if(strCategoryName.split("/").length>3){
			 setupInventory().setCategoryExpanderValue(true);
		 }
		 else{
			 setupInventory().setCategoryExpanderValue(false);
		 }
	}
	
	/**
	 * @Function setupInventorywithOGDefaultLocNoCat
	 * @author Gayathri
	 * @description Setup Inventory with Order guide, Default location and no category 	 - INV_SI_017
	 * @date 01-10-2016
	 */
	public void setupInventorywithOGDefaultLocNoCat()
	{
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
	}
	
	/**
	 * @Function setupInventorywithOGCustomLocCustomCat
	 * @author Reshma S Farook
	 * @description Setup Inventory with Order guide, Custom location and Custom category assigning	only some items and leaving other items without location or category -INV_SI_020 * 
	 * @date 01-10-2016
	 */
	public void setupInventorywithOGCustomLocCustomCatAssignOnlySomeItems(Boolean boolNoLocVal, String LocationNames, String LocationTypes, String CategoryNames, String CategoryTypes,String AssignLocations,String AssignCategory )
	{
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
		//enter custom location details and hit save
		 component().AddMultipleLocationsInSetUpLocation(LocationNames, LocationTypes);
		// Hit next button
		setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		setupInventory().verifySetupExpensesPageDisplay();
		//Hit "Add new Category"
		setupInventory().tapOnAddNewExpenseCategory();
		//Add 10-15 new Categories
		component().AddMultipleCategoriesInNewCategory(CategoryNames, CategoryTypes);
		// Hit next button
		setupInventory().tapOnNextButton();
		//verify Inventory Assignment page is displayed
		setupInventory().verifyInventoryAssignmentPage();
		//swipe through all items and verify product details, category selected and select single location for the items
		if(boolNoLocVal){
			setupInventory().swipeThroughItemsAndSelectLocationAndCategory("", true, LocationTypes,AssignLocations, CategoryTypes,AssignCategory);
		}else{
		setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocationAndCategory(false,"3", AssignCategory, AssignLocations);
		}
		//tap done
		generic().tapDone();
		//complete the Setup process and verify whether the setup is complete and successful
		setupInventory().verifySetupIsComplete();
	}
	
	
	/**
	 * @Function setupInventorywithOGCustomLocDefaultCatMultipleLocation
	 * @author Reshma S Farook
	 * @description Setup Inventory with  OG+Custom  Loc+Default Cat - Multiple location selection - INV_SI_003
	 * @date 04-10-2016
	 */
	public void setupInventorywithOGCustomLocDefaultCatMultipleLocation(String strLocationNames, String strLocationTypes, String AssignLocations,Boolean storeReq)
	{
		
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
		 //enter custom location details and hit save
		 component().AddMultipleLocationsInSetUpLocation(strLocationNames,strLocationTypes);
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
		 setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocation(false,storeReq,"all",AssignLocations,"default","");
		 //tap done
		 generic().tapDone();
		 //complete the Setup process and verify whether the setup is complete and successful
		 setupInventory().verifySetupIsComplete();
	}
	
	/**
	 * @Function setupInventorywithOGCustomLocDefaultCatMultipleLocation
	 * @author Reshma S Farook
	 * @description Setup Inventory with  OG+Custom  Loc+Default Cat - Multiple location selection - INV_SI_003
	 * @date 04-10-2016
	 */
	public void setupInventorywithOGCustomLocDefaultCatMultipleLocation(String strLocationNames, String strLocationTypes, String AssignLocations,boolean bVerification,boolean bStore)
	{
		
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
		 component().AddMultipleLocationsInSetUpLocation(strLocationNames,strLocationTypes);
		 //verify newly added location in list view
		 setupInventory().verifyAdditionOfNewLocation(strLocationNames);
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
		 setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocation(bVerification,bStore,"all",AssignLocations,"default","");
		 //tap done
		 generic().tapDone();
		 //complete the Setup process and verify whether the setup is complete and successful
		 setupInventory().verifySetupIsComplete();
	}
	
	/**
	 * @Function setupInventorywithOGCustomLocDefaultCategorySingleLocationSelection
	 * @author Gayathri
	 * @description Setup Inventory with Order guide, Custom location and Default category and single location for all items - INV_SI_002
	 * @date 03-10-2016
	 */
	public void setupInventorywithOGCustomLocDefaultCategorySingleLocationSelection(String strLocationNames,String strLocationTypes,Boolean...booleans)
	{
		boolean storeValue =true;
		if(booleans.length >0 && !booleans[0])
		{
			storeValue = false;
		}
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
		 //enter custom location details and hit save
		 component().AddMultipleLocationsInSetUpLocation(strLocationNames,strLocationTypes);
		 // Hit next button
		 setupInventory().tapOnNextButton();
		 //verify whether the setup expenses page has been loaded successfully.
		 setupInventory().verifySetupExpensesPageDisplay();
		 // Hit on "Skip and use Food&Non-Food" and hit Next
		 setupInventory().tapUseFoodAndNonFoodButton();
		// Hit next button
		 setupInventory().tapOnNextButton();
		 //verify Inventory Assignment page is displayed
		 setupInventory().verifyInventoryAssignmentPage();
		 //swipe through all items and verify product details, category selected and select single location for the items
		 setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocation(false,storeValue,"all",strLocationNames.split("/")[0], "default","");
		 //tap done
		 generic().tapDone();
		 //waiting for fix of assign products page to continue the script
		 //swipe through all items and verify product details, category selected and select multiple location for the items
		 //verify whether multiple location can be selected for an item
		 //complete the Setup process and verify whether the setup is complete and successful
		 setupInventory().verifySetupIsComplete();
		 LibraryPage.waitForPageLoadAndroid(2);
	}
	
	/**
	 * @Function setupInventorywithOGCustomLocNoCategorySingleLocationSelection
	 * @author Gayathri
	 * @description Setup Inventory with Order guide, Custom location and no category and single location for all items	 - INV_SI_018
	 * @date 03-10-2016
	 */
	public void setupInventorywithOGCustomLocNoCategorySingleLocationSelection(String strLocationNames,String strLocationTypes)
	{
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
		 //enter custom location details and hit save
		 component().AddMultipleLocationsInSetUpLocation(strLocationNames,strLocationTypes);
		 // Hit next button
		 setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		 setupInventory().verifySetupExpensesPageDisplay();
		// Hit next button without selecting a category
		 setupInventory().tapOnNextButton();
		 //verify Inventory Assignment page is displayed
		 setupInventory().verifyInventoryAssignmentPage();
		 //swipe through all items and verify product details, category selected and select single location for the items
		 setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocation(false,true,"all",strLocationNames.split("/")[0], "no category","");
		 //tap done
		 generic().tapDone();
		 //complete the Setup process and verify whether the setup is complete and successful
		 setupInventory().verifySetupIsComplete();
	}

	/**
	 * @Function setupInventorywithOGCustomLocSuggestedCategorySingleLocationSelection
	 * @author Gayathri
	 * @description Setup Inventory with Order guide, Custom location and suggested category and single location for all items	 - INV_SI_019
	 * @date 03-10-2016
	 */
	public void setupInventorywithOGCustomLocSuggestedCategorySingleLocationSelection(String strLocationNames,String strLocationTypes)
	{
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
		 //enter custom location details and hit save
		 component().AddMultipleLocationsInSetUpLocation(strLocationNames,strLocationTypes);
		 // Hit next button
		 setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		 setupInventory().verifySetupExpensesPageDisplay();
		// tap on suggested categories
		 setupInventory().tapUseSuggestedCategories();
		 setupInventory().tapOnNextButton();
		 //verify Inventory Assignment page is displayed
		 setupInventory().verifyInventoryAssignmentPage();
		 //swipe through all items and verify product details, category selected and select single location for the items
		 setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocation(false,true,"all",strLocationNames.split("/")[0], "suggested","");
		 //tap done
		 generic().tapDone();
		 //complete the Setup process and verify whether the setup is complete and successful
		 setupInventory().verifySetupIsComplete();
	}
	
	/**
	 * @Function setupInventorywithMulCustListDefLocDefCatItemInMultipeLoc
	 * @author Reshma S Farook
	 * @description Setup Inventory with Custom List(Multiple List - My lists)+Default Loc+Default Cat (Items Multiple Location)- INV_SI_009 
	 * @date 04-10-2016
	 */
	public void setupInventorywithMulCustListDefLocDefCatItemInMultipeLoc(String ...strListNames ) //--updated Parvathy .. please contact me for updates
	{
		home().tapSetupInventory();
	    //click on Skip link after clicking Setup Inventory
	    setupInventory().clickSkipOnSetupInventory();	
	    //verify whether import items page has been loaded successfully.
	    setupInventory().verifyImportPageDisplayAfterSwipe();	 
	    //Select Multiple Custom Lists (My Lists) in UOM with Item in list1 and list 2
	    setupInventory().tapOnCustomListsButton();
	    setupInventory().tapOnNextButton();		
	    for (String strListName : strListNames) {
	    	 setupInventory().tapOnDesiredListToSelectList(strListName);
		}	    
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
	}
	
	/**
	 * @Function setupInventorywithOGDefaultLocCustomCategory
	 * @author Gayathri
	 * @description Setup Inventory with Order guide, default location and custom category - INV_SI_005
	 * @date 03-10-2016
	 */
	public void setupInventorywithOGDefaultLocCustomCategory(String strCategoryNames,String strCategoryTypes,int...itemCount )
	{
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
		 //tap on next button
		 setupInventory().tapOnNextButton();
		 //verify whether the setup expenses page has been loaded successfully.
		 setupInventory().verifySetupExpensesPageDisplay();
		//Hit 'Add new Category'
		 setupInventory().tapOnAddNewExpenseCategory();
		 //add multiple categories
		 component().AddMultipleCategoriesInNewCategory(strCategoryNames, strCategoryTypes);
		 setupInventory().tapOnNextButton();
		 //verify Inventory Assignment page is displayed
		 setupInventory().verifyInventoryAssignmentPage();
		//swipe through all items and verify product details, default location and select category for the items
		 if(itemCount.length!=0 && itemCount[0]>0){   
			 setupInventory().swipeThroughItemsToVerifyDetailsAndSelectCategory(false,Integer.toString(itemCount[0]),strCategoryNames.split("/")[0],"default");
		 }
		 else{
		 setupInventory().swipeThroughItemsToVerifyDetailsAndSelectCategory(false,"all",strCategoryNames.split("/")[0],"default");
		 }
		 //tap done
		 generic().tapDone();
		 //complete the Setup process and verify whether the setup is complete and successful
		 setupInventory().verifySetupIsComplete();
	}
	
	/**
	 * @Function setupInventorywithOGCustomLocCustomCategory
	 * @author Gayathri
	 * @description Setup Inventory with Order guide, custom location and custom category - INV_SI_006
	 * @date 03-10-2016
	 */
	public void setupInventorywithOGCustomLocCustomCategory(String strLocationNames, String strLocationTypes, String strCategoryNames,String strCategoryTypes)
	{
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
		 //enter custom location details and hit save
		 component().AddMultipleLocationsInSetUpLocation(strLocationNames, strLocationTypes);
		 // Hit next button
		 setupInventory().tapOnNextButton();
		 //verify whether the setup expenses page has been loaded successfully.
		 setupInventory().verifySetupExpensesPageDisplay();
		//Hit 'Add new Category'
		 setupInventory().tapOnAddNewExpenseCategory();
		//add multiple categories
		 component().AddMultipleCategoriesInNewCategory(strCategoryNames, strCategoryTypes);
		 //verify newly added categories in list view
		// setupInventory().verifyAdditionOfNewExpenseCategory(strCategoryNames);
		 setupInventory().tapOnNextButton();
		 //verify Inventory Assignment page is displayed
		 setupInventory().verifyInventoryAssignmentPage();
		 //swipe through all items and verify product details, select location and select category for the items
		 setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocationAndCategory(false,"all",strCategoryNames, strLocationNames.split("/")[0]);
		 //tap done
		 generic().tapDone();
		 //complete the Setup process and verify whether the setup is complete and successful
		 setupInventory().verifySetupIsComplete();
	}
	
	
	/**
	 * @Function deleteAllExistingLocations
	 * @author Periyasamy Nainar
	 * @description Delete all existing locations from manage locations page
	 * @date 03-10-2016
	 */
	public void deleteAllExistingLocations()
	{
		 //Tap on locations from inventory tools page
		 home().tapLocations();
		 //get all location from locations page and delete one by one
		 int size = driver.findElements(By.xpath(LocationsPage.btn_AllLocationsInList[0])).size();		 	
		 	for(int i=1 ; i <= size; i++){
		 		driver.findElement(By.xpath(LocationsPage.btn_FirstLocationInList[0])).click();
                //Tap on Delete this location
				 locations().tapDeleteButton();				
				 //Tap on Yes Delete
				 generic().tapYesDelete();	
				 LibraryPage.waitFor(5);
		 	}
		 	//verify kitchen onboarding page is displayed once the user deleted all locations
		 	locations().verifyKitchenOnboardingPage();
		 	//go back to home page
		 	generic().goBack();
		 	generic().tapBack();
		
	}


	/** @Function setupInventorywithOGCustomCategoryDefaultLocation
	 * @author Parvathy
	 * @description Setup Inventory with Order guide, 3 Custom location(Loc1, Loc2, Loc3) and custom category - This component is used in manage inventory test cases. Please check with Parvathy before updating the component
	 * @date 03-10-2016
	 */
	public void setupInventorywithOGCustomLocationDefaultCategory()
	{			
		home().tapSetupInventory();
		//click on Skip link after clicking Setup Inventory
		setupInventory().clickSkipOnSetupInventory();	
		LibraryPage.waitFor(2);
		//verify whether import items page has been loaded successfully.
		setupInventory().verifyImportPageDisplayAfterSwipe();
		//click on Order Guide Selection and click Next button
		setupInventory().tapOnOrderGuideButton();
		setupInventory().tapOnNextButton();
		//verify whether setup locations page has been loaded successfully.
		setupInventory().verifySelectionAtSetupLocations();
		//Hit "Add new location"
		 setupInventory().tapOnAddNewLocationButton();
		//enter custom location details and hit save
		 component().AddMultipleLocationsInSetUpLocation("Loc1/Loc2/Loc3", "Cooler/Freezer/Dry");
		// Hit next button
		setupInventory().tapOnNextButton();
		//verify whether the setup expenses page has been loaded successfully.
		setupInventory().verifySetupExpensesPageDisplay();		
		//Tap on Default category
		setupInventory().tapUseFoodAndNonFoodButton();
		// Hit next button
		setupInventory().tapOnNextButton();
		setupInventory().verifyAssignProductsPageDisplay();
		//Assign products  - First item to first location, 2nd item to second location like wise
		setupInventory().swipeThroughItemsSelectLocation(3);
		generic().tapDone();
		//complete the Setup process and verify whether the setup is complete and successful
		setupInventory().verifySetupIsComplete();	
	}


	/** @Function setupInventorywithOGCustomCategoryDefaultLocation
	 * @author Parvathy
	 * @description Setup Inventory with Order guide, 3 Custom location(Loc1, Loc2, Loc3) and custom category - This component is used in manage inventory test cases. Please check with Parvathy before updating the component
	 * @date 03-10-2016
	 */
	public void createNonSyscoitem(String strSupplierName1,String strProductName1,String strNickName1,String strProductBrand1,String strProductId1,String strPack1,String strSize1,String strWeight1,String strPrice1,String strCategoryName1,String strLocationName1){
	 home().tapCreateNonSyscoItem();
	//Verify multi step setup flow is displayed
	 nonSyscoPrepItem().verifyMultiStepSetUpFlow();
	 //click on Add new Supplier option
	 nonSyscoPrepItem().tapAddNewSupplier();
	 //enter supplier name
	 nonSyscoPrepItem().enterSupplierName(strSupplierName1);
	//verify save button is disabled
	 generic().verifySaveButtonStatus(true);
	 //tap on save button
	 generic().tapSaveButton();
	 //verify newly created supplier name is displayed
	 nonSyscoPrepItem().verifySupplierInSupplierList(strSupplierName1, true);	
	 //tap next
	 generic().tapNextButton();
	//verify product details page is displayed
	 nonSyscoPrepItem().verifyProductDetailsPage();
	//enter product details
	 product().enterNonSyscoItemDetails(strProductName1, strNickName1, strProductBrand1, strProductId1, strPack1, strSize1, strWeight1, strPrice1);
	//tap next button
	 generic().tapNextButton();		 
	//verify select expenses screen is displayed
	 nonSyscoPrepItem().verifySelectCategoryPage();		 
	 //select one category form list of categories
	 nonSyscoPrepItem().selectCategory(strCategoryName1);
	//tap next
	 generic().tapNextButton();		 
	//verify select location page is displayed
	 nonSyscoPrepItem().verifySelectLocationPage();
	//select one location form list of locations
	nonSyscoPrepItem().selectLocation(strLocationName1);	
	//tap done button
	generic().tapDoneButton();
	//wait for 8 seconds
	generic().waitFor(10);
	nonSyscoPrepItem().verifyProductDetailsPage();
//click close in product details page
	generic().tapClose();   
	}

	
	/** @Function Setup_Inventory_Setup_CustomList_Custom_Loc_Custom_Category
	 * @author Arun_Mathai
	 * @description Setup Inventory with Custom List (Multiple List),  custom location and Custom category and items in multiple location - INV_SI_015
	 * @date 20-10-2016
	 */

	public void setupInventorywithCustomListCustomLocCustomCatAssignOnlySomeItems(String LocationNames, String LocationTypes, String CategoryNames, String CategoryTypes,String AssignLocations,String AssignCategory, String listname )
	{

		home().tapSetupInventory();
		//click on Skip link after clicking Setup Inventory
		setupInventory().clickSkipOnSetupInventory();	
		//verify whether import items page has been loaded successfully.
		setupInventory().verifyImportPageDisplayAfterSwipe();
		//click on Order Guide Selection and click Next button
		setupInventory().tapOnCustomListsButton();
		setupInventory().tapOnNextButton();
		//verify whether setup locations page has been loaded successfully.
		setupInventory().tapOnDesiredListToSelectList(listname);
		generic().tapOnNextLinkInCustomListsPage();		 	 
		setupInventory().tapOnAddNewLocationButton();
		//enter custom location details and hit save
		AddMultipleLocationsInSetUpLocation(LocationNames, LocationTypes);
		setupInventory().tapOnNextButton();
		setupInventory().tapOnAddNewExpenseCategory();
		component().AddMultipleCategoriesInNewCategory(CategoryNames,CategoryTypes);
		setupInventory().tapOnNextButton();
		setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocationAndCategory(false,"3", AssignCategory, AssignLocations);

		generic().tapDone();
		//complete the Setup process and verify whether the setup is complete and successful
		setupInventory().verifySetupIsComplete();
	}
	

	/** @Function setupInventorywithCustomListCustomListDefaultCategory
	 * @author Asha
	 * @description Setup Inventory with Custom List,  multiple location and default category
	 * @date 07-10-2016
	 */
	public void setupInventorywithCustomListCustomListDefaultCategory(String listNames, String strLocationNames, String strLocationTypes,boolean isStore)
	{			
		
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
		setupInventory().verifyAllListsInSelectListsPage(listNames);
		//click on one of the lists in the Lists page. 
		setupInventory().tapOnDesiredListToSelectList(listNames.split("/")[4]);
		//clicking on the next button
		generic().tapOnNextLinkInCustomListsPage();
		//Verify the select location page is seen
		setupInventory().verifySelectionAtSetupLocations();
		setupInventory().tapOnAddNewLocationButton();
		component().AddMultipleLocationsInSetUpLocation(strLocationNames,strLocationTypes);
		setupInventory().tapOnNextButton();
		//Verify setup expenses page is seen 
		setupInventory().verifySetupExpensesPageDisplay();
		//Tapping on UseFoodAndNonFoodButton(
		setupInventory().tapUseFoodAndNonFoodButton();
		setupInventory().tapOnNextButton();
		//Verify Assign products page
		setupInventory().verifyAssignProductsPageDisplay();
		setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocation(false,isStore,"3", strLocationNames,"","");
		generic().tapDone();
		//verify setupComplete
		setupInventory().verifySetupIsComplete();
	}
	
	/** @Function validateTrackInventoryCustomCategoryDefLocationDefSetupExpenses
	 * @author Reshma S Farook
	 * @description Validation of Track Inventory module for custom category set in setup expenses with Default location and Default setup expenses
	 * @date 07-10-2016
	 */
	 public void validateTrackInventoryAfterSetupInventory(String strSetupInventoryType,int locationIndex,String strAssignLocations,String strProductIdOrName,String strVerificationBy,boolean isExpected,String strAssignCategory)
	 {
			 locations().tapLocation(strAssignLocations.split("/")[locationIndex]);
			 //verify location page is displayed
			 locations().verifyLocationPage(strAssignLocations.split("/")[locationIndex]);			 
			 //verify item list view
			 //if(strSetupInventoryType .equalsIgnoreCase("OGCustomLocDefCategory") ){
			 //locations().verifyItemListViewIsDisplayed();
	 		 //}
			 //verify whether items in location is displayed as set in setup inventory 
			 locations().verifyWhetherItemInLocation(strAssignLocations.split("/")[locationIndex],strProductIdOrName,"UPCID",isExpected);
			 //verify whether the product card details is displayed for the items selected in the selected location
			 locations().verifyIfProductCardDetailsAreDisplayedFortheItemSelected();
			 //verify category of items in location
			 if(strAssignCategory.equals("default"))
				 {
				 	locations().verifyItemCategoryOfAllItemsInList("default","");
				 }
			 else if(strAssignCategory.equals("suggested"))
			 	{
				 locations().verifyItemCategoryOfAllItemsInList("suggested","");
			 	}
			 else 
			 	{
				 locations().verifyItemCategoryOfAllItemsInList("custom",strAssignCategory);
			 	}
			 //tap back
			 generic().tapBack();		 
	 }
	 
	 /** @Function createNewPurchaseAndAddLineItem
		 * @author Sampada Dalai
		 * @description Create new purchase and veify the purchase information and add line items
		 * @date 14-10-2016
		 */
	 public void createNewPurchaseAndAddLineItem(String strSupplierName,String strKey,String strInVoiceTotal,String strLineItemType,String strLineItemQunatity,int iTotalLineItemNeeded,int iTotalInvoicesNeeded)
	 {
		    
		for(int iInvoiceLoop=0;iInvoiceLoop<iTotalInvoicesNeeded;iInvoiceLoop++){ 
		    String strRandomInvoiceNumber=RandomStringUtils.randomAlphanumeric(5);
			 //Tap add(+)
			 generic().tapAdd();	
			 //Verify purchase details page
			 purchase().verifyPurchaseDetailsPage();
			 //Click on supplier which will display dropdown
			 purchase().tapSelectSupplier();
			 //Verify Sysco supplier should not be displayed in supplier type
			 generic().verifyValueInDropdown("sysco", "in Supplier ", false);
			 //Select option from dropdown
			 generic().selectValueFromDropdown(strSupplierName,strSupplierName+" option is selected");
			 //Enter invoice number and invoice total
			 purchase().enterInvoiceNumberAndInvoiceTotal(strKey, strInVoiceTotal,strRandomInvoiceNumber);
			//Enter multiple line items 
			for(int iLoop=0;iLoop<iTotalLineItemNeeded;iLoop++){ 
				//Click on add line item(+) and enter the details and verify 
			    purchase().clickAddLineItemAndAddItemDetails(strLineItemQunatity.split("/")[iLoop]);
			    //Select item type from dropdown
			    generic().selectValueFromDropdown(strLineItemType.split("/")[iLoop],strLineItemType.split("/")[iLoop]+" option is selected");
			 }
			generic().tapDone();
			 //Verify line item added success message
			 purchase().verifyLineItemAddedSuccessMsg();
			 //Click on 'No i am done' button to get it added into the invoices
			 purchase().clickOnNoToAddInvoices();
			
		}
			 
	 }
	 
		 
		 /** @Function setupInventorywithMultipleCustomListDefaultLocationDefaultCategory_ItemsMultipleLocation
			 * @author Gayathri
			 * @description Setup Inventory with Custom List (Multiple List),  custom location and default category and items in multiple location - INV_SI_016
			 * @date 16-10-2016
			 */
			public void setupInventorywithMultipleCustomListDefaultLocationDefaultCategory_ItemsMultipleLocation(String strCustomList1, String strCustomList2)
			{			
				
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
				 setupInventory().tapOnDesiredListToSelectList(strCustomList1);
				 setupInventory().tapOnDesiredListToSelectList(strCustomList2);
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
			}
			
			 /** @Function closeInventory
			 * @author Gayathri
			 * @description Close inventory component
			 * @date 16-10-2016
			 */
			public void closeInventory()
			{			
				//hit on close inventory button
				home().tapOnCloseInventory();
				//hit on Yes, Close button
				generic().tapYesDelete();
				//verify close inventory success message
				home().verifyCloseInventorySuccessMessage(true);
				//tap on Got It
				generic().tapYesDelete();
			}
			
			/** @Function createPurchase
			 * @author Gayathri
			 * @description Create new purchase and capture the food cost value
			 * @date 17-10-2016
			 */
			 public void createPurchase(String strSupplierName,String strKey,String strInVoiceTotal,String strLineItemType,String strLineItemQunatity,int iTotalInvoicesNeeded,String categoryType,int inventoryPeriod, String ...str)
			 {
				//navigate to Purchases
				 home().tapPurchases();	
				 //verify purchases page is displayed
				 purchase().verifyPurchasePage();    
				for(int iInvoiceLoop=1;iInvoiceLoop<=iTotalInvoicesNeeded;iInvoiceLoop++){ 
				    String strRandomInvoiceNumber=RandomStringUtils.randomAlphanumeric(5);
					 //Tap add(+)
					 generic().tapAdd();	
					 //Verify purchase details page
					 purchase().verifyPurchaseDetailsPage();
					 //Click on supplier which will display dropdown
					 purchase().tapSelectSupplier();
					 //Select option from dropdown
					 generic().selectValueFromDropdown(strSupplierName,strSupplierName+" option is selected");
					 //Enter invoice number and invoice total
					 purchase().enterInvoiceNumberAndInvoiceTotal(strKey, strInVoiceTotal,strRandomInvoiceNumber);
					//Enter multiple line items 
					for(int iLoop=0;iLoop<strLineItemQunatity.split("/").length;iLoop++){ 
						//Click on add line item(+) and enter the details and verify 
					    purchase().clickAddLineItemAndAddItemDetails(strLineItemQunatity.split("/")[iLoop]);
					    //Select item type from dropdown
					    generic().selectValueFromDropdown(strLineItemType.split("/")[iLoop],strLineItemType.split("/")[iLoop]+" option is selected");
					 }
					if(!(str.length!=0 && str[0].equalsIgnoreCase("false"))){    // get Food value only if its needed for validation
						purchase().getFoodPurchases(strLineItemType, strLineItemQunatity, categoryType, inventoryPeriod);
					}					
					 //Tap on done button
					 generic().tapDone();
					//Verify line item added success message
					 purchase().verifyLineItemAddedSuccessMsg();
					 //Click on 'No i am done' button to get it added into the invoices
					 purchase().clickOnNoToAddInvoices();	
				}
				//tap back
				 generic().tapBack();		 	 
			 }
			 
			 /** @Function setupInventorywithCustomlist_Mylist_DefaultLoc_SuggestCategory
				 * @author Gayathri
				 * @description Setup Inventory with Custom List (My List),  custom location and default category and items in multiple location - INV_SI_016
				 * @date 16-10-2016
				 */
				public void setupInventorywithCustomlist_Mylist_DefaultLoc_SuggestCategory(String strCustomList1)
				{			
					
					//navigate to Setup inventory
					home().tapSetupInventory();
					//click on Skip link after clicking Setup Inventory
					setupInventory().clickSkipOnSetupInventory();	
					//verify whether import items page has been loaded successfully.
					setupInventory().verifySelectionAtImportItems();
					//click on Order Guide Selection and click Next button
					setupInventory().tapOnCustomListsButton();
					setupInventory().tapOnNextButton();
					//verify whether setup locations page has been loaded successfully.
					setupInventory().tapOnDesiredListToSelectList(strCustomList1);
					generic().tapOnNextLinkInCustomListsPage();		
					//Verify the select location page is seen
					setupInventory().verifySelectionAtSetupLocations();
					setupInventory().tapOnSkipAndUseDefaultButtonInSetupInventoryPage();
					//Tapping on next button
					setupInventory().tapOnNextButton();
					//Verify setup expenses page is seen 
					setupInventory().verifySetupExpensesPageDisplay();
					//Tapping on UseFoodAndNonFoodButton(
					setupInventory().tapUseSuggestedCategories();
					// Hit next button
					setupInventory().tapOnNextButton();
					//verify setupComplete
					setupInventory().verifySetupIsComplete();
				}
				 /**
				* @Function setupInventorywithMutlipleCustomListListNameAsLocationCustomCat
				 * @author Periyasamy Nainar
				 * @description Setup Inventory with CustomList, List name as location and custom category
				 * @date 25-10-2016
				 */
				//Renamed - setupInventorywithCustomListDefLocDefCatSingleLocCustCatAsLocation
				public void setupInventorywithMutlipleCustomListListNameAsLocationCustomCat(String strCustomList1, String strCustomList2, String strCategoryNames,String strCategoryTypes,String strAssignCategory)
				{
				    home().tapSetupInventory();
				    //click on Skip link after clicking Setup Inventory
				    setupInventory().clickSkipOnSetupInventory();	
				    //verify whether import items page has been loaded successfully.
				    setupInventory().verifyImportPageDisplayAfterSwipe();	 
				    //Select Custom List (My List) in SMX
				    setupInventory().tapOnCustomListsButton();
				    setupInventory().tapOnNextButton();		
				  //click on multiple custom list( my list and sysco list)
					 setupInventory().tapOnDesiredListToSelectList(strCustomList1);
					 setupInventory().tapOnDesiredListToSelectList(strCustomList2);
				    generic().tapOnNextLinkInCustomListsPage();	    
				   //verify whether setup locations page has been loaded successfully.
					setupInventory().verifySelectionAtSetupLocations();
					//Hit "Skip and Use List Names as locations" and hit Next
					setupInventory().tapOnSkipAndUseListNamesInSetupLocationsPage();
					setupInventory().tapOnNextButton();
					//verify whether the setup expenses page has been loaded successfully.
					setupInventory().verifySetupExpensesPageDisplay();
					//Hit 'Add new Category'
					 setupInventory().tapOnAddNewExpenseCategory();
					 //add multiple categories
					 component().AddMultipleCategoriesInNewCategory(strCategoryNames, strCategoryTypes);
					 setupInventory().tapOnNextButton();
					 //verify Inventory Assignment page is displayed
					 setupInventory().verifyInventoryAssignmentPage();
					 //swipe through all items and verify product details, custom location and select category for the items
					 setupInventory().swipeThroughItemsToVerifyDetailsAndSelectCategory(false,"all",strCategoryNames.split("/")[0],"custom",strCustomList1+"/"+strCustomList2);
					//tap done
					 generic().tapDone();
					//complete the Setup process and verify whether the setup is complete and successful
					setupInventory().verifySetupIsComplete();			
				}
				
				
				 /**
				* @Function setupInventorywithCustomListCustomCategoryAsLocationCustomCat
				 * @author Periyasamy Nainar
				 * @description Setup Inventory with CustomList, custom category as location and custom category
				 * @date 25-10-2016
				 */
				//Renamed - setupInventorywithCustomListDefLocDefCatSingleLocCustCatAsLocation
				public void setupInventorywithCustomListCustomCategoryAsLocationCustomCat(String strCustomList1, String strCategoryNames,String strCategoryTypes,String strAssignCategory, String strCustomCatAsLocations)
				{
				    home().tapSetupInventory();
				    //click on Skip link after clicking Setup Inventory
				    setupInventory().clickSkipOnSetupInventory();	
				    //verify whether import items page has been loaded successfully.
				    setupInventory().verifyImportPageDisplayAfterSwipe();	 
				    //Select Custom List (My List) in SMX
				    setupInventory().tapOnCustomListsButton();
				    setupInventory().tapOnNextButton();		
				  //click on multiple custom list( my list and sysco list)
					 setupInventory().tapOnDesiredListToSelectList(strCustomList1);
				    generic().tapOnNextLinkInCustomListsPage();	    
				   //verify whether setup locations page has been loaded successfully.
					setupInventory().verifySelectionAtSetupLocations();
					//Hit "Skip and Use Custom Categories as locations" and hit Next
					setupInventory().tapOnSkipAndUseCustomCategoriesInSetupLocationsPage();
					setupInventory().tapOnNextButton();
					//verify whether the setup expenses page has been loaded successfully.
					setupInventory().verifySetupExpensesPageDisplay();
					//Hit 'Add new Category'
					 setupInventory().tapOnAddNewExpenseCategory();
					 //add multiple categories
					 component().AddMultipleCategoriesInNewCategory(strCategoryNames, strCategoryTypes);
					 setupInventory().tapOnNextButton();
					 //verify Inventory Assignment page is displayed
					 setupInventory().verifyInventoryAssignmentPage();
					 //swipe through all items and verify product details, custom location and select category for the items
					 setupInventory().swipeThroughItemsToVerifyDetailsAndSelectCategory(false,"all",strCategoryNames.split("/")[0],"custom",strCustomCatAsLocations);
					//tap done
					 generic().tapDone();
					//complete the Setup process and verify whether the setup is complete and successful
					setupInventory().verifySetupIsComplete();			
				}
				
				
				
				 /**
				* @Function logoutFromLocationDetailsPage
				 * @author Periyasamy Nainar
				 * @description Logout from application from location details page
				 * @date 25-10-2016
				 * 				 */
				
				public void logoutFromLocationDetailsPage()
				{
					if((ConfigFile.getProperty("platformType").equalsIgnoreCase("ios"))){
						home().logout(2);   
					}
					 		
				}
				
				 /**
				* @Function logoutFromLocationList
				 * @author Aneesh V R
				 * @description Logout from application from location list page
				 * @date 31-10-2016
				 * 				 */
				public void logoutFromLocationList()
				{
					if((ConfigFile.getProperty("platformType").equalsIgnoreCase("ios"))){
						home().logout(1);   
					}
					 		
				}
				
				/**
				* @Function logoutFromInventoryList
				 * @author Aneesh V R
				 * @description Logout from application from Inventory list page
				 * @date 31-10-2016
				 * 				 */
				public void logoutFromInventoryList()
				{
					if((ConfigFile.getProperty("platformType").equalsIgnoreCase("ios"))){
						LibraryPage lib =new LibraryPage();
						LibraryPage.waitFor(2);
						home().logout(2);   
					}
					 		
				}
				
				/**
				* @Function logoutFromProductDetailsPage
				 * @author Aneesh V R
				 * @description Logout from application from Product Details page
				 * @date 31-10-2016
				 * 				 */
				public void logoutFromProductDetailsPage()
				{
					if((ConfigFile.getProperty("platformType").equalsIgnoreCase("ios"))){
						home().logout(3);   
					}
					 		
				}
				
				/**
				* @Function logoutFromSupplierList
				 * @author Aneesh V R
				 * @description Logout from application from Supplier List page
				 * @date 31-10-2016
				 * 				 */
				public void logoutFromSupplierList()
				{
					if((ConfigFile.getProperty("platformType").equalsIgnoreCase("ios"))){
						home().logout(1);   
					}
					 		
				}
				
				/**
				* @Function logoutFromCategoryList
				 * @author Aneesh V R
				 * @description Logout from application from Category List page
				 * @date 31-10-2016
				 * 				 */
				public void logoutFromCategoryList()
				{
					if((ConfigFile.getProperty("platformType").equalsIgnoreCase("ios"))){
						home().logout(1);   
					}
					 		
				}	
				
				/**
				* @Function logoutFromSupplierDetailsPage
				 * @author Aneesh V R
				 * @description Logout from application from Supplier Details page
				 * @date 31-10-2016
				 * 				 */
				public void logoutFromSupplierDetailsPage()
				{
					if((ConfigFile.getProperty("platformType").equalsIgnoreCase("ios"))){
						home().logout(2);   
					}
					 		
				}	
				
				/**
				* @Function logoutFromCategoryDetailsPage
				 * @author Aneesh V R
				 * @description Logout from application from Category Details page
				 * @date 31-10-2016
				 * 				 */
				public void logoutFromCategoryDetailsPage()
				{
					if((ConfigFile.getProperty("platformType").equalsIgnoreCase("ios"))){
						home().logout(2);   
					}
					 		
				}	
				
				/**
				* @Function logoutFromProductDetailsPage_NonSyscoPrepItems
				 * @author Aneesh V R
				 * @description Logout from application from Product Details page of Non_Sysco_Prep Items
				 * @date 31-10-2016
				 * 				 */
				public void logoutFromProductDetailsPage_NonSyscoPrepItems()
				{
					if((ConfigFile.getProperty("platformType").equalsIgnoreCase("ios"))){
						generic().tapClose();
						home().logout();   
					}
					 		
				}	
				
				
				/**
				* @Function logoutFromPurchaseList
				 * @author Aneesh V R
				 * @description Logout from application from Purchase List
				 * @date 31-10-2016
				 * 				 */
				public void logoutFromPurchaseList()
				{
					if((ConfigFile.getProperty("platformType").equalsIgnoreCase("ios"))){
						home().logout(1);   
					}
					 		
				}	

				/**
				* @Function logoutFromPurchaseDetails
				 * @author Aneesh V R
				 * @description Logout from application from Purchase Details page
				 * @date 31-10-2016
				 * 				 */
				public void logoutFromPurchaseDetails()
				{
					if((ConfigFile.getProperty("platformType").equalsIgnoreCase("ios"))){
						home().logout(2);   
					}
					 		
				}	
				
				/**
				* @Function logoutFromFoodCost
				 * @author Aneesh V R
				 * @description Logout from application from Food cost page
				 * @date 31-10-2016
				 * 				 */
				public void logoutFromFoodCost()
				{
					if((ConfigFile.getProperty("platformType").equalsIgnoreCase("ios"))){
						home().logout(1);   
					}
					 		
				}	
						
				/**
				* @Function deleteallexpensecategories
				 * @author Aneesh V R
				 * @description Logout from application from Food cost page
				 * @date 31-10-2016
				 * 				 */
				public void deleteallexpensecategories()
				{
					expenseCat().deleteExpenseCategories("all");
					 //Swipe to Setup expense categories
					 expenseCat().swipeToSetupExpenses();
					 //tap to cancel setup expenses
					 generic().tapBack();
					 		
				}	
}



