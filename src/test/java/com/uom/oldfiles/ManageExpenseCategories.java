package com.uom.oldfiles;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.DataRead.Excel;
import com.framework.Starter;
import com.framework.configuration.ConfigFile;
import com.framework.frameworkFunctions.LibraryPage;
import com.framework.utils.RetryAnalyzer;
import com.framework.utils.UOMTestNGListener;
import com.uom.excelSheetObject.ExpenseCategoriesObject;
import com.uom.excelSheetObject.SuppliersObject;
import com.uom.pageFactory.PageFactory;

@Listeners(value = UOMTestNGListener.class)
public class ManageExpenseCategories extends PageFactory{
	
	public static String[][] completeArray = null;	
   	Starter starter = new Starter();
   	
    @BeforeClass(alwaysRun=true)
   	public void getData() throws Exception
   	{		
   		String strDataFilePath;
   		Excel newExcel =new Excel();	
   		if(!ConfigFile.getProperty("platformType").toString().equalsIgnoreCase("ios"))
		{
   		completeArray=newExcel.read("test-data/TestData.xls","ExpenseCategories");
		}
   		else{
   		completeArray=newExcel.read("test-data/TestData.xls","ExpenseCategories_IOS");
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
	 	ExpenseCategoriesObject sheetObj = new ExpenseCategoriesObject();
	 	 System.out.println(method.getName());
	        String[][] MethodArray=newExcel.getMethodData(completeArray, method.getName());
	        Object[][] retObjArr= sheetObj.getTestData(MethodArray);
	        return(retObjArr);
    }
    
    /******************************************************************************************
	  * Name : INV_MEC_001_004_007_INV_TI_035_038_Verify_Update_Delete_DefaultExpenseCategories_Verify_Product_Categories
	  * 
	  * Description : User should be able to verify,update and delete default expense categories and verify the changes in categories for location items (Covering the track inventory test cases, INV_TI_035,INV_TI_038)
	  * 
	  * Manual Test cases : INV_MEC_001,INV_MEC_004,INV_MEC_007,INV_TI_035,INV_TI_038
	  * 
	  * Author : Gayathri Anand
	  * 
	  * Date : 10/03/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  10/05/2016					Gayathri				Included the validations for INV_TI_035, INV_TI_038
	  ******************************************************************************************/
    @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ExpenseCategoriesDefect"}, description = "Verify,Update and Delete Default Expense Categories and verify the changes in categories for location items")
	 public void INV_MEC_001_004_007_INV_TI_035_038_Verify_Update_Delete_DefaultExpenseCategories_Verify_Product_Categories(ExpenseCategoriesObject data) throws Exception {	
    	
    	//Login to app
		 component().login(data.strUserName, data.strPassword);
		//setup inventory - precondition -INV_SI_001
		component().setupInventorywithOGDefaultLocDefaultCat();
		//Tap Expense Categories
		 home().tapExpenseCategories();
		//verify the expense categories page is loaded
		 expenseCat().verifyExpenseCategoriesPage();
		 //verify the list of expense categories
		 expenseCat().verifyCategoriesList("default", "");
		 //select an expense category
		 expenseCat().tapCategoryFromList(data.strCategoryName1);
		 //verify expense categories details page 
		expenseCat().verifyExpenseCategoryDetailsPage();
		//verify category name and type
		expenseCat().verifyCategoryDetails(data.strCategoryName1, data.strCategoryType1);
		//hit edit button
		generic().tapEdit();
		//edit category name
		expenseCat().enterCategoryDetails(data.strCategoryName2,"");
		//verify expense type is disabled
		expenseCat().verifyExpenseTypeDisabled();
		//hit done
		generic().tapDone();
		//verify category name and type
		expenseCat().verifyCategoryDetails(data.strCategoryName2, data.strCategoryType1);
		//hit back button
		generic().tapClose();
		//select an expense category
		expenseCat().tapCategoryFromList(data.strCategoryName3);
		//verify expense categories details page 
		expenseCat().verifyExpenseCategoryDetailsPage();
		//verify category name and type
		expenseCat().verifyCategoryDetails(data.strCategoryName3, data.strCategoryType3);
		//hit edit button
		generic().tapEdit();
		//edit category name
		expenseCat().enterCategoryDetails(data.strCategoryName4,"");
		//verify expense type is disabled
		expenseCat().verifyExpenseTypeDisabled();
		//hit done
		generic().tapDone();
		//verify category name and type
		expenseCat().verifyCategoryDetails(data.strCategoryName4, data.strCategoryType3);
		//hit close button
		generic().tapClose();
		///INV_TI_035
		 //tap back
		 generic().tapBack();
		 //navigate to track inventory
		 home().tapTrackInventory();
		 //verify locations page is displayed
		 locations().verifyLocationsPage();
		 //tap on a location
		 locations().tapLocation(data.strLocationName1);
		 //verify location page is displayed
		 locations().verifyLocationPage(data.strLocationName1);
		 //verify category of all items from list
		 locations().verifyItemCategoryAfterEditOfAllItemsInListAfterUpdate("default",new String[]{data.strCategoryName1,data.strCategoryName3},new String[]{data.strCategoryName2,data.strCategoryName4});
		 //verify category of all items from product card
		 locations().verifyCategoryOfAllItemsInListFromProductCardAfterUpdate("default",new String[]{data.strCategoryName1,data.strCategoryName3},new String[]{data.strCategoryName2,data.strCategoryName4});
		//tap back
		 generic().tapBack();
		//tap back
		 generic().tapBack();
		 //INV_MEC_007
		//Tap Expense Categories
		 home().tapExpenseCategories();
		//verify the expense categories page is loaded
		 expenseCat().verifyExpenseCategoriesPage();
		 //select an expense category
		expenseCat().tapCategoryFromList(data.strCategoryName2);
		//verify expense categories details page 
		expenseCat().verifyExpenseCategoryDetailsPage();
		//hit edit button
		generic().tapEdit();
		//tap delete expense category button
		expenseCat().tapDeleteExpenseCategory();
		//verify confirmation message
		expenseCat().verifyDeleteExpenseCategoryConfirmationPopUp(data.strCategoryName2);
		//hit yes delete
		generic().tapYesDelete();
		//verify the expense categories page is loaded
		expenseCat().verifyExpenseCategoriesPage();
		//verify deleted category not in list
		 expenseCat().verifyCategoryInCategoryList(data.strCategoryName2, false);
		 //INV_TI_038
		 //tap back
		 generic().tapBack();
		 //navigate to track inventory
		 home().tapTrackInventory();
		 //verify locations page is displayed
		 locations().verifyLocationsPage();
		 //tap on a location
		 generic().waitForPageLoadAndroid(2);
		 locations().tapLocation(data.strLocationName1);
		 //verify location page is displayed
		 locations().verifyLocationPage(data.strLocationName1);
		 //verify no category is displayed for items of deleted category
		 locations().verifyCategoryOfDeletedCategoryItems(data.strCategoryName2);
		 //tap back
		 generic().tapBack();
		 //tap back
		 generic().tapBack();
		 //log out
		 home().logout();
		 //close app
		 generic().closeApp();
    }
    /******************************************************************************************
	  * Name : INV_MEC_002_005_008_INV_TI_036_039_Verify_Update_Delete_SuggestedExpenseCategories_Verify_Product_Categories
	  * 
	  * Description : User should be able to verify,update and delete suggested expense categories  and verify the changes in categories for location items (Covering the track inventory test cases, INV_TI_036,INV_TI_039)
	  * 
	  * Manual Test cases : INV_MEC_002,INV_MEC_005,INV_MEC_008,INV_TI_036,INV_TI_039
	  * 
	  * Author : Gayathri Anand
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
   @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ExpenseCategoriesDefect"}, description = "Verify,Update and Delete Suggested Expense Categories and verify the changes in categories for location items")
	 public void INV_MEC_002_005_008_INV_TI_036_039_Verify_Update_Delete_SuggestedExpenseCategories_Verify_Product_Categories(ExpenseCategoriesObject data) throws Exception {	
   	
   		//Login to app
	   component().login(data.strUserName, data.strPassword);
	   //setup inventory - precondition
		 component().setupInventorywithOGDefaultLocSugg12Cat();
		//Tap Expense Categories
		 home().tapExpenseCategories();
		//verify the expense categories page is loaded
		 expenseCat().verifyExpenseCategoriesPage();
		 //verify the list of expense categories
		 expenseCat().verifyCategoriesList("suggested", "");
		 //select an expense category
		 expenseCat().tapCategoryFromList(data.strCategoryName1);
		 //verify expense categories details page 
		expenseCat().verifyExpenseCategoryDetailsPage();
		//verify category name and type
		expenseCat().verifyCategoryDetails(data.strCategoryName1, data.strCategoryType1);
		//hit edit button
		generic().tapEdit();
		//edit category name
		expenseCat().enterCategoryDetails(data.strCategoryName2,"");
		//verify expense type is disabled
		expenseCat().verifyExpenseTypeDisabled();
		//hit done
		generic().tapDone();
		//verify category name and type
		expenseCat().verifyCategoryDetails(data.strCategoryName2, data.strCategoryType1);
		//hit close button
		generic().tapClose();
		//select an expense category
		expenseCat().tapCategoryFromList(data.strCategoryName3);
		//verify expense categories details page 
		expenseCat().verifyExpenseCategoryDetailsPage();
		//verify category name and type
		expenseCat().verifyCategoryDetails(data.strCategoryName3, data.strCategoryType3);
		//hit edit button
		generic().tapEdit();
		//edit category name
		expenseCat().enterCategoryDetails(data.strCategoryName4,"");
		//verify expense type is disabled
		expenseCat().verifyExpenseTypeDisabled();
		//hit done
		generic().tapDone();
		//verify category name and type
		expenseCat().verifyCategoryDetails(data.strCategoryName4, data.strCategoryType3);
		//hit close button
		generic().tapClose();
		//select an expense category
		expenseCat().tapCategoryFromList(data.strCategoryName5);
		//verify expense categories details page 
		expenseCat().verifyExpenseCategoryDetailsPage();
		//verify category name and type
		expenseCat().verifyCategoryDetails(data.strCategoryName5, data.strCategoryType5);
		//hit edit button
		generic().tapEdit();
		//edit category name
		expenseCat().enterCategoryDetails(data.strCategoryName6,"");
		//verify expense type is disabled
		expenseCat().verifyExpenseTypeDisabled();
		//hit done
		generic().tapDone();
		//verify category name and type
		expenseCat().verifyCategoryDetails(data.strCategoryName6, data.strCategoryType5);
		//hit close button
		generic().tapClose();
		///INV_TI_036
		 //tap back
		 generic().tapBack();
		 //navigate to track inventory
		 home().tapTrackInventory();
		 //verify locations page is displayed
		 locations().verifyLocationsPage();
		 //tap on a location
		 locations().tapLocation(data.strLocationName1);
		 //verify location page is displayed
		 locations().verifyLocationPage(data.strLocationName1);
		 //verify category of all items from list
		 locations().verifyItemCategoryAfterEditOfAllItemsInListAfterUpdate("suggested",new String[]{data.strCategoryName1,data.strCategoryName3,data.strCategoryName5},new String[]{data.strCategoryName2,data.strCategoryName4,data.strCategoryName6});
		 //verify category of all items from product card
		 locations().verifyCategoryOfAllItemsInListFromProductCardAfterUpdate("suggested",new String[]{data.strCategoryName1,data.strCategoryName3,data.strCategoryName5},new String[]{data.strCategoryName2,data.strCategoryName4,data.strCategoryName6});
		//tap back
		 generic().tapBack();
		//tap back
		 generic().tapBack();
		 //INV_MEC_008
		//Tap Expense Categories
		 home().tapExpenseCategories();
		//verify the expense categories page is loaded
		 expenseCat().verifyExpenseCategoriesPage();
		 //select an expense category
		expenseCat().tapCategoryFromList(data.strCategoryName2);
		//verify expense categories details page 
		expenseCat().verifyExpenseCategoryDetailsPage();
		//hit edit button
		generic().tapEdit();
		//tap delete expense category button
		expenseCat().tapDeleteExpenseCategory();
		//verify confirmation message
		expenseCat().verifyDeleteExpenseCategoryConfirmationPopUp(data.strCategoryName2);
		//hit yes delete
		generic().tapYesDelete();
		//verify the expense categories page is loaded
		expenseCat().verifyExpenseCategoriesPage();
		//verify deleted category not in list
		 expenseCat().verifyCategoryInCategoryList(data.strCategoryName2, false);
		//select an expense category
		expenseCat().tapCategoryFromList(data.strCategoryName4);
		//verify expense categories details page 
		expenseCat().verifyExpenseCategoryDetailsPage();
		//hit edit button
		generic().tapEdit();
		//tap delete expense category button
		expenseCat().tapDeleteExpenseCategory();
		//verify confirmation message
		expenseCat().verifyDeleteExpenseCategoryConfirmationPopUp(data.strCategoryName4);
		//hit yes delete
		generic().tapYesDelete();
		//verify the expense categories page is loaded
		expenseCat().verifyExpenseCategoriesPage();
		//verify deleted category not in list
		 expenseCat().verifyCategoryInCategoryList(data.strCategoryName4, false);
		//select an expense category
		expenseCat().tapCategoryFromList(data.strCategoryName6);
		//verify expense categories details page 
		expenseCat().verifyExpenseCategoryDetailsPage();
		//hit edit button
		generic().tapEdit();
		//tap delete expense category button
		expenseCat().tapDeleteExpenseCategory();
		//verify confirmation message
		expenseCat().verifyDeleteExpenseCategoryConfirmationPopUp(data.strCategoryName6);
		//hit yes delete
		generic().tapYesDelete();
		//verify the expense categories page is loaded
		expenseCat().verifyExpenseCategoriesPage();
		//verify deleted category not in list
		 expenseCat().verifyCategoryInCategoryList(data.strCategoryName6, false);
		 //INV_TI_039
		 //tap back
		 generic().tapBack();
		 //navigate to track inventory
		 home().tapTrackInventory();
		 //verify locations page is displayed
		 locations().verifyLocationsPage();
		 generic().waitForPageLoadAndroid(2);
		 //tap on a location
		 locations().tapLocation(data.strLocationName1);
		 //verify location page is displayed
		 locations().verifyLocationPage(data.strLocationName1);
		 //verify no category is displayed for items of deleted categories
		 locations().verifyCategoryOfDeletedCategoryItems(data.strCategoryName2);
		 locations().verifyCategoryOfDeletedCategoryItems(data.strCategoryName4);
		 locations().verifyCategoryOfDeletedCategoryItems(data.strCategoryName6);
		 //tap back
		 generic().tapBack();
		 //tap back
		 generic().tapBack();
		 //log out
		 home().logout();
		 //close app
		 generic().closeApp();
   }
   
   /******************************************************************************************

 	  * Name : INV_MEC_003_006_009_INV_TI_037_040_Verify_Update_Delete_CustomExpenseCategories 
 	  *  	  
 	  * Description : User should be able to verify,update and delete custom expense categories. 
 	  * and the same updation is validate in Track Inventory also
 	  * Manual Test cases : INV_MEC_003,INV_MEC_006,INV_MEC_009,INV_TI_037,INV_TI_040
 	  * 
 	  * Author : Asha
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
    @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ExpenseCategoriesDefect"}, description = "Verify,Update and Delete Custom Expense Categories")
 	 public void INV_MEC_003_006_009_INV_TI_037_040_Verify_Update_Delete_CustomExpenseCategories(ExpenseCategoriesObject data) throws Exception {	
		//Login to app
		   component().login(data.strUserName, data.strPassword);
		   //setup inventory - precondition
		 component().setupInventorywithOGDefaultLocCustomCategory(data.strCategoryNames,data.strCategoryTypes);
		//Tap Expense Categories
		 home().tapExpenseCategories();
		//verify the expense categories page is loaded
		 expenseCat().verifyExpenseCategoriesPage();
		 //verify the list of expense categories
		 expenseCat().verifyCategoriesList("custom", data.strCategoryName1,data.strCategoryName2,data.strCategoryName3);
		 //select an expense category
		 expenseCat().tapCategoryFromList(data.strCategoryName1);
		 //verify expense categories details page 
		expenseCat().verifyExpenseCategoryDetailsPage();
		//verify category name and type
		expenseCat().verifyCategoryDetails(data.strCategoryName1, data.strCategoryType1);
		//hit edit button
		generic().tapEdit();
		//edit category name
		expenseCat().enterCategoryDetails(data.strCategoryName4,"");
		//verify expense type is disabled
		expenseCat().verifyExpenseTypeDisabled();
		//hit done
		generic().tapDone();
		//verify category name and type
		expenseCat().verifyCategoryDetails(data.strCategoryName4, data.strCategoryType1);
		//tap close
		generic().tapClose();
		//hit back button
		generic().tapBack(); 
		//INV_TI_037 - /Validate that updates to expense category is reflected in track Inventory
		home().tapTrackInventory();
		//tap on a location
		locations().tapLocation(data.strLocationName1);
		 //verify category of all items from list
		locations().verifyItemCategoryAfterEditOfAllItemsInListAfterUpdate("custom",new String[]{data.strCategoryName1,data.strCategoryName2,data.strCategoryName3},new String[]{data.strCategoryName4,data.strCategoryName2,data.strCategoryName3},data.strCategoryName1,data.strCategoryName2,data.strCategoryName3);
		 //verify category of all items from product card
		locations().verifyCategoryOfAllItemsInListFromProductCardAfterUpdate("custom",new String[]{data.strCategoryName1,data.strCategoryName2,data.strCategoryName3},new String[]{data.strCategoryName4,data.strCategoryName2,data.strCategoryName3},data.strCategoryName1,data.strCategoryName2,data.strCategoryName3);
		 //INV_MEC_009
		//hit back button
		generic().tapBack(); 
		//hit back button
		generic().tapBack(); 
		//Tap Expense Categories
		 home().tapExpenseCategories();
		//select an expense category
		expenseCat().tapCategoryFromList(data.strCategoryName4);
		//verify expense categories details page 
		expenseCat().verifyExpenseCategoryDetailsPage();
		//hit edit button
		generic().tapEdit();
		//tap delete expense category button
		expenseCat().tapDeleteExpenseCategory();
		//verify confirmation message
		expenseCat().verifyDeleteExpenseCategoryConfirmationPopUp(data.strCategoryName4);
		//hit yes delete
		generic().tapYesDelete();
		//verify the expense categories page is loaded
		expenseCat().verifyExpenseCategoriesPage();
		//verify deleted category not in list
		expenseCat().verifyCategoryInCategoryList(data.strCategoryName4, false);
		//Validate that updates to expense category is reflected for all the items under that category in track inventory screen
		//INV_TI_040
		//tap back
		 generic().tapBack();
		 //navigate to track inventory
		 home().tapTrackInventory();
		 //verify locations page is displayed
		 locations().verifyLocationsPage();
		 //tap on a location
		 locations().tapLocation(data.strLocationName1);
		 //verify no category is displayed for items of deleted categories		
		 locations().verifyCategoryOfDeletedCategoryItems(data.strCategoryName4);		
		 //tap back
		 generic().tapBack();
		 //tap back
		 generic().tapBack();
		 //log out
		 home().logout();
		 //close app
		 generic().closeApp();
    }

	  /** Name : INV_MEC_010_011_017_INV_TI_042_046_Delete_All_Custom_Categories_Setup_Default_Categories_Verify_Product_Categories_Add_New_Custom_Categories
	  * 
	  * Description : User should be able to delete all custom expense categories, Set up expenses using default categories, Verify product categories and add new custom categories and verify new category in product page
	  * 
	  * Manual Test cases : INV_MEC_010, INV_MEC_011, INV_MEC_017,INV_TI_042,INV_TI_046
	  * 
	  * Author : Gayathri Anand
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
    @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ExpenseCategories"}, description = "_Delete All Custom Categories, Setup Default Categories, Verify Product Categories,Add New Custom Categoriesand verify new category in product page")
	 public void INV_MEC_010_011_017_INV_TI_042_046_Delete_All_Custom_Categories_Setup_Default_Categories_Verify_Product_Categories_Add_New_Custom_Categories(ExpenseCategoriesObject data) throws Exception {	
 	
 		//Login to app
	   component().login(data.strUserName, data.strPassword);
	   //setup inventory - precondition -INV_SI_005
	   component().setupInventorywithOGDefaultLocCustomCategory(data.strCategoryNames,data.strCategoryTypes);
	   //Tap Expense Categories
	   home().tapExpenseCategories();
	   //verify the expense categories page is loaded
	   expenseCat().verifyExpenseCategoriesPage();
	   //delete all categories
	   expenseCat().deleteExpenseCategories("all");
	   //verify setup expenses onboarding workflow is displayed
	   expenseCat().verifySetupExpenseCategoriesOnboardingWorkFlow();
	   expenseCat().swipeToSetupExpenses();
	   //verify whether the setup expenses page has been loaded successfully.
	   setupInventory().verifySetupExpensesPageDisplay();
	   // Hit on use Food&Non-Food"
	   setupInventory().tapUseFoodAndNonFoodButton();
	   //verify Inventory Assignment page is displayed
	   setupInventory().verifyInventoryAssignmentPage();
	   //swipe through all items and verify product details, category selected and select location for the items
	   setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocation(true,true,"all",data.strLocationName1, "default");
	   //tap done
	   generic().tapDone();
	   //complete the Setup process and verify whether the setup is complete and successful
	   setupInventory().verifySetupIsComplete();
	   //navigate to track inventory
	   home().tapTrackInventory();
	   //verify locations page is displayed
	   locations().verifyLocationsPage();
	   //tap on a location
	   locations().tapLocation(data.strLocationName1);
	   //verify location page is displayed
	   locations().verifyLocationPage(data.strLocationName1);
	   //verify category of all items from list
	   locations().verifyItemCategoryOfAllItemsInList("default");
	   //verify category of all items from product card
	   locations().verifyCategoryOfAllItemsInListFromProductCard("default");
	   //tap back
	   generic().tapBack();
	   //tap back
	   generic().tapBack();
	   //Tap Expense Categories
	   home().tapExpenseCategories();
	   //verify the expense categories page is loaded
	   expenseCat().verifyExpenseCategoriesPage();
	   //verify the list of expense categories
	   expenseCat().verifyCategoriesList("default");
	   //hit + to add new category
	   generic().tapAdd();
	   //verify add expense categories page
	   expenseCat().verifyAddExpenseCategoryPage();
	   //enter category details
	   expenseCat().enterCategoryDetails(data.strCategoryName1, data.strCategoryType1);
	   //tap done
	   generic().tapDone();
	   //tap close
	   generic().tapClose();
	   //verify added category in list
	   expenseCat().verifyCategoryInCategoryList(data.strCategoryName1, true);
	   //tap back
	   generic().tapBack();
	   //navigate to track inventory
	   home().tapTrackInventory();
	   //verify locations page is displayed
	   locations().verifyLocationsPage();
	   //tap on a location
	   locations().tapLocation(data.strLocationName1);
	   //verify location page is displayed
	   locations().verifyLocationPage(data.strLocationName1);
	   //tap on an item
	  locations().selectAnItemWithIndex("1");
	  //verify product details page
	  product().verifyProductDetailsPage();
	  //tap edit
	  generic().tapEdit();
	  //verify category in category picker
	  product().verifyCategoryInCategoryPicker(data.strCategoryName1);
	  //close app
	   generic().closeApp();
 }
    /** Name : INV_MEC_012_018_INV_TI_043_047_Setup_Suggested_Categories_Verify_Product_Categories_Add_New_Custom_Categories
	  * 
	  * Description : User should be able to Set up expenses using suggested categories after deleting all categories, Verify product categories and add new custom categories and verify new category in product page
	  * 
	  * Manual Test cases : INV_MEC_012, INV_MEC_018,INV_TI_043,INV_TI_047
	  * 
	  * Author : Gayathri Anand
	  * 
	  * Date : 10/05/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
   @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ExpenseCategories"}, description = "Setup Suggested Categories, Verify Product Categories,Add New Custom Categoriesand verify new category in product page")
	 public void INV_MEC_012_018_INV_TI_043_047_Setup_Suggested_Categories_Verify_Product_Categories_Add_New_Custom_Categories(ExpenseCategoriesObject data) throws Exception {	
	
		//Login to app
	   component().login(data.strUserName, data.strPassword);
	   // precondition -INV_MEC_010
	   ////////////
	   component().setupInventorywithOGDefaultLocCustomCategory(data.strCategoryNames,data.strCategoryTypes);
	   //Tap Expense Categories
	   home().tapExpenseCategories();
	   //verify the expense categories page is loaded
	   expenseCat().verifyExpenseCategoriesPage();
	   //delete all categories
	   expenseCat().deleteExpenseCategories("all");
	   ////////////
	   //verify setup expenses onboarding workflow is displayed
	   expenseCat().verifySetupExpenseCategoriesOnboardingWorkFlow();
	   expenseCat().swipeToSetupExpenses();
	   //verify whether the setup expenses page has been loaded successfully.
	   setupInventory().verifySetupExpensesPageDisplay();
	   // Hit on use Suggested Categories
	   setupInventory().tapUseSuggestedCategories();
	   //verify Inventory Assignment page is displayed
	   setupInventory().verifyInventoryAssignmentPage();
	   //swipe through all items and verify product details, category selected and select location for the items
	   setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocation(true,false,"all",data.strLocationName1, "suggested");
	   //tap done
	   generic().tapDone();
	   //complete the Setup process and verify whether the setup is complete and successful
	   setupInventory().verifySetupIsComplete();
	   //navigate to track inventory
	   home().tapTrackInventory();
	   //verify locations page is displayed
	   locations().verifyLocationsPage();
	   //tap on a location
	   locations().tapLocation(data.strLocationName1);
	   //verify location page is displayed
	   locations().verifyLocationPage(data.strLocationName1);
	   //verify category of all items from list
	   locations().verifyItemCategoryOfAllItemsInList("suggested");
	   //verify category of all items from product card
	   locations().verifyCategoryOfAllItemsInListFromProductCard("suggested");
	   //tap back
	   generic().tapBack();
	   //tap back
	   generic().tapBack();
	   //Tap Expense Categories
	   home().tapExpenseCategories();
	   //verify the expense categories page is loaded
	   expenseCat().verifyExpenseCategoriesPage();
	   //verify the list of expense categories
	   expenseCat().verifyCategoriesList("suggested");
	   //hit + to add new category
	   generic().tapAdd();
	   //verify add expense categories page
	   expenseCat().verifyAddExpenseCategoryPage();
	   //enter category details
	   expenseCat().enterCategoryDetails(data.strCategoryName1, data.strCategoryType1);
	   //tap done
	   generic().tapDone();
	   //tap close
	   generic().tapClose();
	   //verify added category in list
	   expenseCat().verifyCategoryInCategoryList(data.strCategoryName1, true);
	   //tap back
	   generic().tapBack();
	   generic().swipeScreenInVertical(8, 2);  // newly added line of code
	   //navigate to track inventory
	   home().tapTrackInventory();
	   //verify locations page is displayed
	   locations().verifyLocationsPage();
	   //tap on a location
	   locations().tapLocation(data.strLocationName1);
	   //verify location page is displayed
	   locations().verifyLocationPage(data.strLocationName1);
	   //tap on an item
	  locations().selectAnItemWithIndex("1");
	  //verify product details page
	  product().verifyProductDetailsPage();
	  //tap edit
	  generic().tapEdit();
	  //verify category in category picker
	  product().verifyCategoryInCategoryPicker(data.strCategoryName1);
	   //close app
	   generic().closeApp();
}
   /** Name : INV_MEC_013_019_INV_TI_044_048_Setup_Custom_Categories_Verify_Product_Categories_Add_New_Custom_Categories
	  * 
	  * Description : User should be able to Set up expenses using custom categories after deleting all categories, Verify product categories and add new custom categories and verify new category in product page
	  * 
	  * Manual Test cases : INV_MEC_013, INV_MEC_019,INV_TI_044,INV_TI_048
	  * 
	  * Author : Gayathri Anand
	  * 
	  * Date : 10/05/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ExpenseCategories"}, description = "Setup custom Categories, Verify Product Categories,Add New Custom Categoriesand verify new category in product page")
	 public void INV_MEC_013_019_INV_TI_044_048_Setup_Custom_Categories_Verify_Product_Categories_Add_New_Custom_Categories(ExpenseCategoriesObject data) throws Exception {	
	
		//Login to app
	   component().login(data.strUserName, data.strPassword);
	   // precondition -INV_MEC_010
	   ////////////
	   component().setupInventorywithOGDefaultLocCustomCategory(data.strCategoryNames,data.strCategoryTypes);
	   //Tap Expense Categories
	   home().tapExpenseCategories();
	   //verify the expense categories page is loaded
	   expenseCat().verifyExpenseCategoriesPage();
	   //delete all categories
	   expenseCat().deleteExpenseCategories("all");
	   ////////////
	   //verify setup expenses onboarding workflow is displayed
	   expenseCat().verifySetupExpenseCategoriesOnboardingWorkFlow();
	   expenseCat().swipeToSetupExpenses();
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
	   //navigate to track inventory
	   home().tapTrackInventory();
	   //verify locations page is displayed
	   locations().verifyLocationsPage();
	   //tap on a location
	   locations().tapLocation(data.strLocationName1);
	   //verify location page is displayed
	   locations().verifyLocationPage(data.strLocationName1);
	   //verify category of all items from list
	   locations().verifyItemCategoryOfAllItemsInList("custom",data.strCategoryNames.split("/"));
	   //verify category of all items from product card
	   locations().verifyCategoryOfAllItemsInListFromProductCard("custom",data.strCategoryNames.split("/"));
	   //tap back
	   generic().tapBack();
	   //tap back
	   generic().tapBack();
	   //Tap Expense Categories
	   home().tapExpenseCategories();
	   //verify the expense categories page is loaded
	   expenseCat().verifyExpenseCategoriesPage();
	   //verify the list of expense categories
	   expenseCat().verifyCategoriesList("custom",data.strCategoryNames.split("/"));
	   //hit + to add new category
	   generic().tapAdd();
	   //verify add expense categories page
	   expenseCat().verifyAddExpenseCategoryPage();
	   //enter category details
	   expenseCat().enterCategoryDetails(data.strCategoryName1, data.strCategoryType1);
	   //tap done
	   generic().tapDone();
	   //tap close
	   generic().tapClose();
	   //verify added category in list
	   expenseCat().verifyCategoryInCategoryList(data.strCategoryName1, true);
	   //tap back
	   generic().tapBack();
	   //navigate to track inventory
	   home().tapTrackInventory();
	   //verify locations page is displayed
	   locations().verifyLocationsPage();
	   //tap on a location
	   locations().tapLocation(data.strLocationName1);
	   //verify location page is displayed
	   locations().verifyLocationPage(data.strLocationName1);
	   //tap on an item
	  locations().selectAnItemWithIndex("1");
	  //verify product details page
	  product().verifyProductDetailsPage();
	  //tap edit
	  generic().tapEdit();
	  //verify category in category picker
	  product().verifyCategoryInCategoryPicker(data.strCategoryName1);
	   //close app
	   generic().closeApp();
}
 /** Name : INV_MEC_014_Setup_Default_ExpenseCategories_After_Skipping_Expense_In_Initial_Setup
  * 
  * Description : User should be able to Set up expenses using default categories after skipping expense category setup in initital setup
  * 
  * Manual Test cases : INV_MEC_014
  * 
  * Author : Gayathri Anand
  * 
  * Date : 10/05/2016
  * 
  * Notes : NA
  * 
  * Modification Log
  * Date						Author						Description
  * -----------------------------------------------------------------------------------------
  *  
  ******************************************************************************************/

@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Defect-D0745"}, description = "Set up expenses using default categories after skipping expense category setup in initital setup")

 public void INV_MEC_014_Setup_Default_ExpenseCategories_After_Skipping_Expense_In_Initial_Setup(ExpenseCategoriesObject data) throws Exception {	

	//Login to app
   component().login(data.strUserName, data.strPassword);
   // precondition -INV_SI_017
   ////////////
   component().setupInventorywithOGDefaultLocNoCat();
   //Tap Expense Categories
   home().tapExpenseCategories();
   //verify setup expenses onboarding workflow is displayed
   expenseCat().verifySetupExpenseCategoriesOnboardingWorkFlow();
   expenseCat().swipeToSetupExpenses();
   //verify whether the setup expenses page has been loaded successfully.
   setupInventory().verifySetupExpensesPageDisplay();
   // Hit on use Food&Non-Food"
   setupInventory().tapUseFoodAndNonFoodButton();
   //verify Inventory Assignment page is displayed
   setupInventory().verifyInventoryAssignmentPage();
   //swipe through all items and verify product details, category selected and select location for the items
   setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocation(true,true,"all",data.strLocationName1, "default");
   //tap done
   generic().tapDone();
   //complete the Setup process and verify whether the setup is complete and successful
   setupInventory().verifySetupIsComplete();
   //navigate to track inventory
   home().tapTrackInventory();
   //verify locations page is displayed
   locations().verifyLocationsPage();
   //tap on a location
   locations().tapLocation(data.strLocationName1);
   //verify location page is displayed
   locations().verifyLocationPage(data.strLocationName1);
   //verify category of all items from list
   locations().verifyItemCategoryOfAllItemsInList("default");
   //verify category of all items from product card
   locations().verifyCategoryOfAllItemsInListFromProductCard("default");
  //tap back
  generic().tapBack();
  //tap back
  generic().tapBack();
	//log out
  home().logout();
   //close app
   generic().closeApp();
}
/** Name : INV_MEC_015_Setup_Suggested_ExpenseCategories_After_Skipping_Expense_In_Initial_Setup
 * 
 * Description : User should be able to Set up expenses using suggested categories after skipping expense category setup in initital setup
 * 
 * Manual Test cases : INV_MEC_015
 * 
 * Author : Gayathri Anand
 * 
 * Date : 10/05/2016
 * 
 * Notes : NA
 * 
 * Modification Log
 * Date						Author						Description
 * -----------------------------------------------------------------------------------------
 *  
 ******************************************************************************************/

@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Defect-D0745"}, description = "Set up expenses using suggested categories after skipping expense category setup in initital setup")

public void INV_MEC_015_Setup_Suggested_ExpenseCategories_After_Skipping_Expense_In_Initial_Setup(ExpenseCategoriesObject data) throws Exception {	

	//Login to app
  component().login(data.strUserName, data.strPassword);
  // precondition -INV_SI_017
  ////////////
  component().setupInventorywithOGDefaultLocNoCat();
  //Tap Expense Categories
  home().tapExpenseCategories();
  //verify setup expenses onboarding workflow is displayed
  expenseCat().verifySetupExpenseCategoriesOnboardingWorkFlow();
  expenseCat().swipeToSetupExpenses();
  //verify whether the setup expenses page has been loaded successfully.
  setupInventory().verifySetupExpensesPageDisplay();
  // Hit on use Suggested Categories
  setupInventory().tapUseSuggestedCategories();
  //verify Inventory Assignment page is displayed
  setupInventory().verifyInventoryAssignmentPage();
  //swipe through all items and verify product details, category selected and select location for the items
  setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocation(true,true,"all",data.strLocationName1, "suggested");
  //tap done
  generic().tapDone();
  //complete the Setup process and verify whether the setup is complete and successful
  setupInventory().verifySetupIsComplete();
  //navigate to track inventory
  home().tapTrackInventory();
  //verify locations page is displayed
  locations().verifyLocationsPage();
  //tap on a location
  locations().tapLocation(data.strLocationName1);
  //verify location page is displayed
  locations().verifyLocationPage(data.strLocationName1);
  //verify category of all items from list
  locations().verifyItemCategoryOfAllItemsInList("suggested");
  //verify category of all items from product card
  locations().verifyCategoryOfAllItemsInListFromProductCard("suggested");
//tap back
  generic().tapBack();
  //tap back
  generic().tapBack();
	//log out
  home().logout();
  //close app
  generic().closeApp();
}

/** Name : INV_MEC_016_Setup_Custom_ExpenseCategories_After_Skipping_Expense_In_Initial_Setup
 * 
 * Description : User should be able to Set up expenses using custom categories after skipping expense category setup in initital setup
 * 
 * Manual Test cases : INV_MEC_016
 * 
 * Author : Gayathri Anand
 * 
 * Date : 10/05/2016
 * 
 * Notes : NA
 * 
 * Modification Log
 * Date						Author						Description
 * -----------------------------------------------------------------------------------------
 *  
 ******************************************************************************************/

@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Defect-D0745"}, description = "Set up expenses using custom categories after skipping expense category setup in initital setup")

public void INV_MEC_016_Setup_Custom_ExpenseCategories_After_Skipping_Expense_In_Initial_Setup(ExpenseCategoriesObject data) throws Exception {	

	//Login to app
  component().login(data.strUserName, data.strPassword);
  // precondition -INV_SI_017
  ////////////
  component().setupInventorywithOGDefaultLocNoCat();
  //Tap Expense Categories
  home().tapExpenseCategories();
  //verify setup expenses onboarding workflow is displayed
  expenseCat().verifySetupExpenseCategoriesOnboardingWorkFlow();
  expenseCat().swipeToSetupExpenses();
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
  //navigate to track inventory
  home().tapTrackInventory();
  //verify locations page is displayed
  locations().verifyLocationsPage();
  //tap on a location
  locations().tapLocation(data.strLocationName1);
  //verify location page is displayed
  locations().verifyLocationPage(data.strLocationName1);
  //verify category of all items from list
  locations().verifyItemCategoryOfAllItemsInList("custom",data.strCategoryNames.split("/"));
  //verify category of all items from product card
  locations().verifyCategoryOfAllItemsInListFromProductCard("custom",data.strCategoryNames.split("/"));
  //tap back
  generic().tapBack();
  //tap back
  generic().tapBack();
	//log out
  home().logout();
  //close app
  generic().closeApp();
}

/******************************************************************************************
 * Name : INV_MEC_020_021_VerifyDuplicate_ErrorMessage_AddNew_Edit_ExpWithSameName
 * 
 * Description : Verify whether 
 * 			1) user is not allowed to add new manage Expense with existing name. An error message should be displayed.
 * .			2) user is not allowed to edit mamge expense name with existing name. An error message should be displayed.
 * 
 * Manual Test cases : INV_MS_021 , INV_MS_020 [New scenarios]
 * 
 * Author :  Parvathy P	
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
@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ExpenseCategories"},priority=1, description = "Create Manage expense - error verification")
public void INV_MEC_020_021_VerifyDuplicate_ErrorMessage_AddNew_Edit_CatWithSameName(ExpenseCategoriesObject data) throws Exception {	
	
	 //Login to app
	 component().login(data.strUserName, data.strPassword);
	 //Set up Inventory -  Can plug it in once the set inventory screens are stable
	 component().setupInventorywithOGDefaultLocDefaultCat();
	 //create an expense category
	 component().createExpenseCategory(data.strCategoryName1, data.strCategoryType1);
	 //Click on +
	 generic().tapAdd();
	 //Verify Add expense categories page is loaded
	 expenseCat().verifyAddExpenseCategoryPage();
	 //enter category details
	 expenseCat().enterCategoryDetails(data.strCategoryName1, data.strCategoryType1);
	 //tap done
	 generic().tapDone();
	 //verify error message when the user is creating new category with existing cat name. 
	 generic().verifyErrorMessageForDuplicateName("Could Not Add Expense Category","An Expense Category with the same name already exists","Add Expense Category");
	 //tap on close button
	 generic().tapOnCloseErrorMessage();
	 //tap on cancel button
	 generic().tapCancel();
	 //verify number of categories displayed in Expense category page -1 
	 expenseCat().verifyNumberOfCategories("3");
	 //tap on back
	 generic().tapBack();
	 //create an expense category
	 component().createExpenseCategory(data.strCategoryName2, data.strCategoryType2);
	 //tap on newly created exp category
	 expenseCat().tapCategoryFromList(data.strCategoryName2);
	 //verify category details page is displayed
	 expenseCat().verifyExpenseCategoryDetailsPage();
	 //edit
	 generic().tapEdit();
	 //enter available exp cat name
	 expenseCat().enterCategoryDetails(data.strCategoryName1, "");
	 //tap done
	 generic().tapDone();
	 //verify error message when the user is creating new category with existing cat name. 
	 generic().verifyErrorMessageForDuplicateName("Could Not Save Expense Category","An Expense Category with the same name already exists","Add Expense Category");
	 //tap on close button
	 generic().tapOnCloseErrorMessage();
	 //tap on cancel button
	 generic().tapCancel();
	 //tap on close button 
	 generic().tapClose();		 
	//verify number of cat displayed in suppliers page  -  2
	 expenseCat().verifyNumberOfCategories("4");
	 //exp cat verification
	 expenseCat().verifyCategoriesList("custom","Food","Non-Food","Cat1","Cat2");
	 //close app
	 generic().closeApp();

}

}
