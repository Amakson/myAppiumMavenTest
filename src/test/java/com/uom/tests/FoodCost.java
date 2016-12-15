package com.uom.tests;

import java.io.File;
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
import com.uom.excelSheetObject.FoodCostObject;
import com.uom.pageFactory.PageFactory;

@Listeners(value = UOMTestNGListener.class)
public class FoodCost extends PageFactory{

	public static String[][] completeArray = null;	
   	Starter starter = new Starter();
   	
    @BeforeClass(alwaysRun=true)
   	public void getData() throws Exception
   	{		
   		String strDataFilePath;
   		Excel newExcel =new Excel();		
   		completeArray=newExcel.read("test-data/TestData.xls","FoodCost");
   	}
    
    @BeforeMethod(alwaysRun=true)
    public void initiate() throws Exception
    {
    	
    	startup();
    }
    @AfterMethod(alwaysRun=true)
   	public void clean()
   	{
       	cleanUp();
   	}
    @DataProvider(name = "DP1",parallel =true)
    public Object[][] getData(Method method) throws Exception{
	 	Excel newExcel =new Excel();
	 	FoodCostObject sheetObj = new FoodCostObject();
	 	 System.out.println(method.getName());
	        String[][] MethodArray=newExcel.getMethodData(completeArray, method.getName());
	        Object[][] retObjArr= sheetObj.getTestData(MethodArray);
	        return(retObjArr);
    }
    
    /******************************************************************************************
	  * Name : INV_FC_001_Verify_FoodCost_User_With_No_Inventory_Period
	  * 
	  * Description : Validate food cost when the user has not had 2 inventory periods
	  * 
	  * Manual Test cases : INV_FC_001
	  * 
	  * Author : Gayathri Anand
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
   @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"CriticalBatchAndroid","FoodCost","FoodCost_iOS1"}, description = "Validate food cost when the user has not had 2 inventory periods")
	 public void INV_FC_001_Verify_FoodCost_User_With_No_Inventory_Period(FoodCostObject data) throws Exception {	
   	
	   //Login to app
		 component().login(data.strUserName, data.strPassword);
		//setup inventory - precondition -INV_SI_001
		component().setupInventorywithOGDefaultLocDefaultCat();
		//verify Food Cost option
		home().verifyViewFoodCostLink();
		//Tap on View food cost
		home().tapOnViewFoodCost();
		//verify Food Cost calculator empty screen is displayed
		foodCost().verifyFoodCostCalculatorEmptyPage();
		//verify message displayed
		foodCost().verifyFoodCostCalculatorEmptyMessage();
		//close app
		generic().closeApp();
   }
   
   /******************************************************************************************
	  * Name : INV_FC_002_Verify_FoodCost_User_With_One_Inventory_Period
	  * 
	  * Description : Validate food cost when the user has only 1 inventory periods - he has done just one close
	  * 
	  * Manual Test cases : INV_FC_002
	  * 
	  * Author : Gayathri Anand
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
 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"CriticalBatchAndroid","FoodCost","FoodCost_iOS1"}, description = "Validate food cost when the user has only 1 inventory periods - he has done just one close")
	 public void INV_FC_002_Verify_FoodCost_User_With_One_Inventory_Period(FoodCostObject data) throws Exception {	
 	
	   //Login to app
		 component().login(data.strUserName, data.strPassword);
		//setup inventory - precondition -INV_SI_001
		component().setupInventorywithOGDefaultLocDefaultCat();
		//close inventory - precondition -INV_CI_001
		component().closeInventory();
		//verify Food Cost option
		home().verifyViewFoodCostLink();
		//Tap on View food cost
		home().tapOnViewFoodCost();
		//verify Food Cost calculator empty screen is displayed
		foodCost().verifyFoodCostCalculatorEmptyPage();
		//verify message displayed
		foodCost().verifyFoodCostCalculatorEmptyMessage();
		//close app
		generic().closeApp();
 }
 
 /******************************************************************************************
  * Name : INV_FC_003_Verify_FoodCost_User_With_Two_Inventory_Period_Default_Cat_Without_Purchase
  * 
  * Description : Validate food cost when the user has has done 2 inventory period - Default Category  w/o Purchase
  * 
  * Manual Test cases : INV_FC_003
  * 
  * Author : Gayathri Anand
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
@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"FoodCost","FoodCost_iOS1","CriticalPatchIOS"}, description = "Validate food cost when the user has has done 2 inventory period - Default Category  w/o Purchase")
 public void INV_FC_003_Verify_FoodCost_User_With_Two_Inventory_Period_Default_Cat_Without_Purchase(FoodCostObject data) throws Exception {	
	
   //Login to app
	 component().login(data.strUserName, data.strPassword);
	//setup inventory - precondition -INV_SI_001
	component().setupInventorywithOGDefaultLocDefaultCat();
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity1, "1");
	//get item price
	locations().getItemPrice("1");
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity1, "2");
	//get item price
	locations().getItemPrice("2");
	//enter quantity for 3rd item
	locations().enterQuantity(data.strQuantity3, "3");
	//get item price
	locations().getItemPrice("3");
	//get inventory value
	locations().getInventoryValue("3", "default");
	//tap back
	generic().tapBack();
	//tap back
	generic().tapBack();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(1);
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify Food Cost calculator empty screen is displayed
	foodCost().verifyFoodCostCalculatorEmptyPage();
	//tap back
	foodCost().swipeFoodCostEmptyScreen();	
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity2, "1",1);
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity2, "2",1);
	//enter quantity for 3rd item
	locations().enterQuantity(data.strQuantity3, "3",1);
	//get inventory value
	locations().getInventoryValue("3", "default");
	//tap back
	generic().tapBack();	
	//tap back
	generic().tapBack();
	//wait for 1 min
	home().waitForOneMinuteToCloseInventory();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(2);
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify food cost is displayed
	foodCost().verifyFoodCostPage();
	//verify food cost details
	foodCost().verifyFoodCostDetails(1,false);
	//verify COGS
	foodCost().verifyCOGS(1);
	//close app
	generic().closeApp();
}

/******************************************************************************************
 * Name : INV_FC_004_Verify_FoodCost_User_With_Two_Inventory_Period_Suggested_Cat_Without_Purchase
 * 
 * Description : Validate food cost when the user has has done 2 inventory period - Suggested Category  w/o Purchase
 * 
 * Manual Test cases : INV_FC_004
 * 
 * Author : Gayathri Anand
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
@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"FoodCost","FoodCost_iOS1"}, description = "Validate food cost when the user has has done 2 inventory period - Suggested Category  w/o Purchase")
public void INV_FC_004_Verify_FoodCost_User_With_Two_Inventory_Period_Suggested_Cat_Without_Purchase(FoodCostObject data) throws Exception {	
	
  //Login to app
	 component().login(data.strUserName, data.strPassword);
	//setup inventory - precondition -INV_SI_004
	component().setupInventorywithOGDefaultLocSugg12Cat();
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity1, "1");
	//get item price
	locations().getItemPrice("1");
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity1, "2");
	//get item price
	locations().getItemPrice("2");
	//enter quantity for 3rd item
	locations().enterQuantity(data.strQuantity3, "3");
	//get item price
	locations().getItemPrice("3");
	//get inventory value
	locations().getInventoryValue("3", "suggested");
	//tap back
	generic().tapBack();
	//tap back
	generic().tapBack();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(1);
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify Food Cost calculator empty screen is displayed
	foodCost().verifyFoodCostCalculatorEmptyPage();
	//tap back
	foodCost().swipeFoodCostEmptyScreen();	
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity2, "1",1);
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity2, "2",1);
	//enter quantity for 3rd item
	locations().enterQuantity(data.strQuantity3, "3",1);
	//get inventory value
	locations().getInventoryValue("3", "suggested");
	//tap back
	generic().tapBack();	
	//tap back
	generic().tapBack();
	//wait for 1 min
	home().waitForOneMinuteToCloseInventory();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(2);
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify food cost is displayed
	foodCost().verifyFoodCostPage();
	//verify food cost details
	foodCost().verifyFoodCostDetails(1,false);
	//verify COGS
	foodCost().verifyCOGS(1);
	//close app
	generic().closeApp();
}
/******************************************************************************************
 * Name : INV_FC_005_Verify_FoodCost_User_With_Two_Inventory_Period_Custom_Cat_Without_Purchase
 * 
 * Description : Validate food cost when the user has has done 2 inventory period - Custom Category  w/o Purchase
 * 
 * Manual Test cases : INV_FC_005
 * 
 * Author : Gayathri Anand
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

@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"CriticalBatchAndroid","FoodCost","FoodCost_iOS1","CriticalPatchIOS"}, description = "Validate food cost when the user has has done 2 inventory period - Custom Category  w/o Purchase")

public void INV_FC_005_Verify_FoodCost_User_With_Two_Inventory_Period_Custom_Cat_Without_Purchase(FoodCostObject data) throws Exception {	
	
  //Login to app
	 component().login(data.strUserName, data.strPassword);
	//setup inventory - precondition -INV_SI_006
	component().setupInventorywithOGCustomLocCustomCategory(data.strLocationNames, data.strLocationTypes, data.strCategoryNames, data.strCategoryTypes);
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity1, "1");
	//get item price
	locations().getItemPrice("1");
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity1, "2");
	//get item price
	locations().getItemPrice("2");
	//enter quantity for 3rd item
	locations().enterQuantity(data.strQuantity3, "3");
	//get item price
	locations().getItemPrice("3");
	//get inventory value
	locations().getInventoryValue("3", "custom");
	//tap back
	generic().tapBack();
	//tap back
	generic().tapBack();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(1);
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify Food Cost calculator empty screen is displayed
	foodCost().verifyFoodCostCalculatorEmptyPage();
	//tap back
	foodCost().swipeFoodCostEmptyScreen();	
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity2, "1",1);
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity2, "2",1);
	//enter quantity for 3rd item
	locations().enterQuantity(data.strQuantity3, "3",1);
	//get inventory value
	locations().getInventoryValue("3", "custom");
	//tap back
	generic().tapBack();	
	//tap back
	generic().tapBack();
	//wait for 1 min
	home().waitForOneMinuteToCloseInventory();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(2);
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify food cost is displayed
	foodCost().verifyFoodCostPage();
	//verify food cost details
	foodCost().verifyFoodCostDetails(1,false);
	//verify COGS
	foodCost().verifyCOGS(1);
	//close app
	generic().closeApp();
}

/******************************************************************************************
 * Name : INV_FC_006_013_016_Verify_FoodCost_User_With_Two_Inventory_Period_Default_Cat_With_NonSysco_Purchase_FoodCost_Views_Calculations
 * 
 * Description : Validate food cost when the user has has done 2 inventory period - Default Category  with NonSysco Purchase. Also verify that in the Food Cost there are 2 views provided and Food cost calculation
 * 
 * Manual Test cases : INV_FC_006, INV_FC_013, INV_FC_016
 * 
 * Author : Gayathri Anand
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
@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"CriticalBatchAndroid","FoodCost","FoodCost_iOS1","Defect_D0786"}, description = "Validate food cost when the user has has done 2 inventory period - Default Category  with NonSysco Purchase.Also verify that in the Food Cost there are 2 views provided and Food cost calculation")
public void INV_FC_006_013_016_Verify_FoodCost_User_With_Two_Inventory_Period_Default_Cat_With_NonSysco_Purchase_FoodCost_Views_Calculations(FoodCostObject data) throws Exception {	
	
  //Login to app
	 component().login(data.strUserName, data.strPassword);
	//setup inventory - precondition -INV_SI_001
	component().setupInventorywithOGDefaultLocDefaultCat();
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity1, "1");
	//get item price
	locations().getItemPrice("1");
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity1, "2");
	//get item price
	locations().getItemPrice("2");
	//enter quantity for 3rd item
	locations().enterQuantity(data.strQuantity3, "3");
	//get item price
	locations().getItemPrice("3");
	//get inventory value
	locations().getInventoryValue("3", "default");
	//tap back
	generic().tapBack();
	//tap back
	generic().tapBack();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(1);
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify Food Cost calculator empty screen is displayed
	foodCost().verifyFoodCostCalculatorEmptyPage();
	//tap back
	foodCost().swipeFoodCostEmptyScreen();
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity2, "1",1);
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity2, "2",1);
	//enter quantity for 3rd item
	locations().enterQuantity(data.strQuantity3, "3",1);
	//get inventory value
	locations().getInventoryValue("3", "default");
	//tap back
	generic().tapBack();	
	//tap back
	generic().tapBack();
	//create supplier
	component().createSupplier(data.strSupplierName1, "", "", "", "", "");
	//create purchase
	component().createPurchase(data.strSupplierName1, "Purchase1", data.strInvoiceTotal, data.strLineItemType, data.strLineItemPrice,1,"default",1);
	//wait for 1 min
	home().waitForOneMinuteToCloseInventory();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(2);
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify food cost is displayed
	foodCost().verifyFoodCostPage();
	//verify food cost details
	foodCost().verifyFoodCostDetails(1,true);
	//verify COGS
	foodCost().verifyCOGS(1);
	//verify food cost views
	foodCost().verifyFoodCostViews();
	//verify consolidated view
	foodCost().verifyConsolidatedView();
	//tap on categorized view
	foodCost().tapOnCategorizedView();
	//verify categorized view
	foodCost().verifyCategorizedView(1);
	//enter food sales
	foodCost().enterFoodSales(data.strFoodSales);
	//tap on consolidated view
	foodCost().tapOnConsolidatedView();
	//verify food cost calculation
	foodCost().verifyFoodCostCalculation(data.strFoodSales);
	//tap on categorized view
	foodCost().tapOnCategorizedView();
	//verify food cost calculation
	foodCost().verifyFoodCostCalculation(data.strFoodSales);
	//close app
	generic().closeApp();
}

/******************************************************************************************
 * Name : INV_FC_007_014_Verify_FoodCost_User_With_Two_Inventory_Period_Suggested_Cat_With_NonSysco_Purchase_FoodCost_Views
 * 
 * Description : Validate food cost when the user has has done 2 inventory period - Suggested Category  with NonSysco Purchase. Also verify that in the Food Cost there are 2 views provided
 * 
 * Manual Test cases : INV_FC_007, INV_FC_014
 * 
 * Author : Gayathri Anand
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
@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"FoodCost","FoodCost_iOS1","Defect_D0786"}, description = "Validate food cost when the user has has done 2 inventory period - Suggested Category  with NonSysco Purchase. Also verify that in the Food Cost there are 2 views provided")
public void INV_FC_007_014_Verify_FoodCost_User_With_Two_Inventory_Period_Suggested_Cat_With_NonSysco_Purchase_FoodCost_Views(FoodCostObject data) throws Exception {	
	
  //Login to app
	 component().login(data.strUserName, data.strPassword);
	//setup inventory - precondition -INV_SI_004
	component().setupInventorywithOGDefaultLocSugg12Cat();
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity1, "1");
	//get item price
	locations().getItemPrice("1");
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity1, "2");
	//get item price
	locations().getItemPrice("2");
	//enter quantity for 3rd item
	locations().enterQuantity(data.strQuantity3, "3");
	//get item price
	locations().getItemPrice("3");
	//get inventory value
	locations().getInventoryValue("3", "suggested");
	//tap back
	generic().tapBack();
	//tap back
	generic().tapBack();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(1);
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify Food Cost calculator empty screen is displayed
	foodCost().verifyFoodCostCalculatorEmptyPage();
	//tap back
	foodCost().swipeFoodCostEmptyScreen();	
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity2, "1",1);
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity2, "2",1);
	//enter quantity for 3rd item
	locations().enterQuantity(data.strQuantity3, "3",1);
	//get inventory value
	locations().getInventoryValue("3", "suggested");
	//tap back
	generic().tapBack();	
	//tap back
	generic().tapBack();
	//create supplier
	component().createSupplier(data.strSupplierName1, "", "", "", "", "");
	//create purchase
	component().createPurchase(data.strSupplierName1, "Purchase1", data.strInvoiceTotal, data.strLineItemType, data.strLineItemPrice,1,"suggested",1);
	//wait for 1 min
	home().waitForOneMinuteToCloseInventory();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(2);
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify food cost is displayed
	foodCost().verifyFoodCostPage();
	//verify food cost details
	foodCost().verifyFoodCostDetails(1,true);
	//verify COGS
	foodCost().verifyCOGS(1);
	//verify food cost views
	foodCost().verifyFoodCostViews();
	//verify consolidated view
	foodCost().verifyConsolidatedView();
	//tap on categorized view
	foodCost().tapOnCategorizedView();
	//verify categorized view
	foodCost().verifyCategorizedView(1);
	//close app
	generic().closeApp();
}

/******************************************************************************************
 * Name : INV_FC_008_015_Verify_FoodCost_User_With_Two_Inventory_Period_Custom_Cat_With_NonSysco_Purchase_FoodCost_Views
 * 
 * Description : Validate food cost when the user has has done 2 inventory period - Custom Category  with NonSysco Purchase. Also verify that in the Food Cost there are 2 views provided
 * 
 * Manual Test cases : INV_FC_008, INV_FC_015
 * 
 * Author : Gayathri Anand
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
@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"FoodCost","FoodCost_iOS1","Defect_D0786"}, description = "Validate food cost when the user has has done 2 inventory period - Custom Category with NonSysco Purchase. Also verify that in the Food Cost there are 2 views provided")
public void INV_FC_008_015_Verify_FoodCost_User_With_Two_Inventory_Period_Custom_Cat_With_NonSysco_Purchase_FoodCost_Views(FoodCostObject data) throws Exception {	
	
  //Login to app
	component().login(data.strUserName, data.strPassword);
	//setup inventory - precondition -INV_SI_006
	component().setupInventorywithOGCustomLocCustomCategory(data.strLocationNames, data.strLocationTypes, data.strCategoryNames, data.strCategoryTypes);
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity1, "1");
	//get item price
	locations().getItemPrice("1");
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity1, "2");
	//get item price
	locations().getItemPrice("2");
	//enter quantity for 3rd item
	locations().enterQuantity(data.strQuantity3, "3");
	//get item price
	locations().getItemPrice("3");
	//get inventory value
	locations().getInventoryValue("3", "custom");
	//tap back
	generic().tapBack();
	//tap back
	generic().tapBack();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(1);
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify Food Cost calculator empty screen is displayed
	foodCost().verifyFoodCostCalculatorEmptyPage();
	//tap back
	foodCost().swipeFoodCostEmptyScreen();	
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity2, "1",1);
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity2, "2",1);
	//enter quantity for 3rd item
	locations().enterQuantity(data.strQuantity3, "3",1);
	//get inventory value
	locations().getInventoryValue("3", "custom");
	//tap back
	generic().tapBack();	
	//tap back
	generic().tapBack();
	//create supplier
	component().createSupplier(data.strSupplierName1, "", "", "", "", "");
	//create purchase
	component().createPurchase(data.strSupplierName1, "Purchase1", data.strInvoiceTotal, data.strLineItemType, data.strLineItemPrice,1,"custom",1);
	//wait for 1 min
	home().waitForOneMinuteToCloseInventory();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(2);
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify food cost is displayed
	foodCost().verifyFoodCostPage();
	//verify food cost details
	foodCost().verifyFoodCostDetails(1,true);
	//verify COGS
	foodCost().verifyCOGS(1);
	//verify food cost views
	foodCost().verifyFoodCostViews();
	//verify consolidated view
	foodCost().verifyConsolidatedView();
	//tap on categorized view
	foodCost().tapOnCategorizedView();
	//verify categorized view
	foodCost().verifyCategorizedView(1);
	//close app
	generic().closeApp();
}
/******************************************************************************************
 * Name : INV_FC_019_Verify_Historic_Purchase_Update_Default_Cat_With_NonSysco_Purchase
 * 
 * Description : when the historic purchase is updated, the values are updated for the particular Food Cost - Default Category  with NonSysco Purchase
 * 
 * Manual Test cases : INV_FC_019
 * 
 * Author : Gayathri Anand
 * 
 * Date : 10/19/2016
 * 
 * Notes : NA
 * 
 * Modification Log
 * Date						Author						Description
 * -----------------------------------------------------------------------------------------
 * 
 ******************************************************************************************/
@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"FoodCost","FoodCost_iOS1","Defect_D0786","Defect_D0764"}, description = "when the historic purchase is updated, the values are updated for the particular Food Cost - Default Category  with NonSysco Purchase")
public void INV_FC_019_Verify_Historic_Purchase_Update_Default_Cat_With_NonSysco_Purchase(FoodCostObject data) throws Exception {	
	
  //Login to app
	 component().login(data.strUserName, data.strPassword);
	//setup inventory - precondition -INV_FC_006
	component().setupInventorywithOGDefaultLocDefaultCat();
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity1, "1");
	//get item price
	locations().getItemPrice("1");
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity1, "2");
	//get item price
	locations().getItemPrice("2");
	//enter quantity for 3rd item
	locations().enterQuantity(data.strQuantity3, "3");
	//get item price
	locations().getItemPrice("3");
	//get inventory value
	locations().getInventoryValue("3", "default");
	//tap back
	generic().tapBack();
	//tap back
	generic().tapBack();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(1);
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity2, "1",1);
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity2, "2",1);
	//enter quantity for 3rd item
	locations().enterQuantity(data.strQuantity3, "3",1);
	//get inventory value
	locations().getInventoryValue("3", "default");
	//tap back
	generic().tapBack();	
	//tap back
	generic().tapBack();
	//create supplier
	component().createSupplier(data.strSupplierName1, "", "", "", "", "");
	//create purchase
	component().createPurchase(data.strSupplierName1, "Purchase1", data.strInvoiceTotal, data.strLineItemType, data.strLineItemPrice,1,"default",1);
	//wait for 1 min
	home().waitForOneMinuteToCloseInventory();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(2);
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify food cost is displayed
	foodCost().verifyFoodCostPage();
	//verify food cost details
	foodCost().verifyFoodCostDetails(1,true);
	//verify COGS
	foodCost().verifyCOGS(1);
	///////////////////////////////////
	//tap back
	generic().tapBack();
	//tap purchase
	home().tapPurchases();
	//select previously added purchase
	purchase().clickOnPurchaseLine("1");
	//tap on edit
	generic().tapEdit();
	//add new line item
	purchase().clickAddLineItemAndAddItemDetails(data.strLineItemPrice1);
	generic().selectValueFromDropdown(data.strLineItemType1,data.strLineItemType1+" option is selected");
	//capture newly added purchase value
	purchase().getAddedFoodPurchases(data.strLineItemType1, data.strLineItemPrice1, 1);
	 //Tap on done button
	 generic().tapDone();
	//tap back
	 generic().tapBack();	
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify food cost is displayed
	foodCost().verifyFoodCostPage();
	//verify food cost details
	foodCost().verifyFoodCostDetails(1,true);
	//verify COGS
	foodCost().verifyCOGS(1);
	//close app
	generic().closeApp();
}

/******************************************************************************************
 * Name : INV_FC_020_Verify_Historic_Purchase_Update_Suggested_Cat_With_NonSysco_Purchase
 * 
 * Description : when the historic purchase is updated, the values are updated for the particular Food Cost - Suggested Category  with NonSysco Purchase
 * 
 * Manual Test cases : INV_FC_020
 * 
 * Author : Gayathri Anand
 * 
 * Date : 10/20/2016
 * 
 * Notes : NA
 * 
 * Modification Log
 * Date						Author						Description
 * -----------------------------------------------------------------------------------------
 * 
 ******************************************************************************************/
@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"FoodCost","FoodCost_iOS1","Defect_D0786","Defect_D0764"}, description = "when the historic purchase is updated, the values are updated for the particular Food Cost - Suggested Category  with NonSysco Purchase")
public void INV_FC_020_Verify_Historic_Purchase_Update_Suggested_Cat_With_NonSysco_Purchase(FoodCostObject data) throws Exception {	
	
  //Login to app
	 component().login(data.strUserName, data.strPassword);
	//setup inventory - precondition -INV_FC_007
	 component().setupInventorywithOGDefaultLocSugg12Cat();
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity1, "1");
	//get item price
	locations().getItemPrice("1");
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity1, "2");
	//get item price
	locations().getItemPrice("2");
	//enter quantity for 3rd item
	locations().enterQuantity(data.strQuantity3, "3");
	//get item price
	locations().getItemPrice("3");
	//get inventory value
	locations().getInventoryValue("3", "suggested");
	//tap back
	generic().tapBack();
	//tap back
	generic().tapBack();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(1);
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity2, "1",1);
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity2, "2",1);
	//enter quantity for 3rd item
	locations().enterQuantity(data.strQuantity3, "3",1);
	//get inventory value
	locations().getInventoryValue("3", "suggested");
	//tap back
	generic().tapBack();	
	//tap back
	generic().tapBack();
	//create supplier
	component().createSupplier(data.strSupplierName1, "", "", "", "", "");
	//create purchase
	component().createPurchase(data.strSupplierName1, "Purchase1", data.strInvoiceTotal, data.strLineItemType, data.strLineItemPrice,1,"suggested",1);
	//wait for 1 min
	home().waitForOneMinuteToCloseInventory();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(2);
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify food cost is displayed
	foodCost().verifyFoodCostPage();
	//verify food cost details
	foodCost().verifyFoodCostDetails(1,true);
	//verify COGS
	foodCost().verifyCOGS(1);
	///////////////////////////////////
	//tap back
	generic().tapBack();
	//tap purchase
	home().tapPurchases();
	//select previously added purchase
	purchase().clickOnPurchaseLine("1");
	//tap on edit
	generic().tapEdit();
	//add new line item
	purchase().clickAddLineItemAndAddItemDetails(data.strLineItemPrice1);
	generic().selectValueFromDropdown(data.strLineItemType1,data.strLineItemType1+" option is selected");
	//capture newly added purchase value
	purchase().getAddedFoodPurchases(data.strLineItemType1, data.strLineItemPrice1, 1);
	 //Tap on done button
	 generic().tapDone();
	//tap back
	 generic().tapBack();	
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify food cost is displayed
	foodCost().verifyFoodCostPage();
	//verify food cost details
	foodCost().verifyFoodCostDetails(1,true);
	//verify COGS
	foodCost().verifyCOGS(1);
	//close app
	generic().closeApp();
}

/******************************************************************************************
 * Name : INV_FC_021_Verify_Historic_Purchase_Update_Suggested_Cat_With_NonSysco_Purchase_Two_FC_Periods
 * 
 * Description : when the historic purchase is updated, the values are updated for the particular Food Cost (2 Food cost period exists)- Suggested Category  with NonSysco Purchase
 * 
 * Manual Test cases : INV_FC_021
 * 
 * Author : Gayathri Anand
 * 
 * Date : 10/20/2016
 * 
 * Notes : NA
 * 
 * Modification Log
 * Date						Author						Description
 * -----------------------------------------------------------------------------------------
 * 
 ******************************************************************************************/
@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"FoodCost","FoodCost_iOS1","Defect_D0786","Defect_D0764"}, description = "when the historic purchase is updated, the values are updated for the particular Food Cost (2 Food cost period exists) - Suggested Category  with NonSysco Purchase")
public void INV_FC_021_Verify_Historic_Purchase_Update_Suggested_Cat_With_NonSysco_Purchase_Two_FC_Periods(FoodCostObject data) throws Exception {	
	
  //Login to app
	 component().login(data.strUserName, data.strPassword);
	//setup inventory - precondition -INV_FC_007
	 component().setupInventorywithOGDefaultLocSugg12Cat();
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity1, "1");
	//get item price
	locations().getItemPrice("1");
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity1, "2");
	//get item price
	locations().getItemPrice("2");
	//get inventory value
	locations().getInventoryValue("2", "suggested");
	//tap back
	generic().tapBack();
	//tap back
	generic().tapBack();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(1);
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity2, "1",1);
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity2, "2",1);
	//get inventory value
	locations().getInventoryValue("2", "suggested");
	//tap back
	generic().tapBack();	
	//tap back
	generic().tapBack();
	//create supplier
	component().createSupplier(data.strSupplierName1, "", "", "", "", "");
	//create purchase
	component().createPurchase(data.strSupplierName1, "Purchase1", data.strInvoiceTotal, data.strLineItemType, data.strLineItemPrice,1,"suggested",1);
	//wait for 1 min
	home().waitForOneMinuteToCloseInventory();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(2);
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify food cost is displayed
	foodCost().verifyFoodCostPage();
	//verify food cost details
	foodCost().verifyFoodCostDetails(1,true);
	//verify COGS
	foodCost().verifyCOGS(1);
	///////////////////////////////////
	//tap back
	generic().tapBack();
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity3, "1",1);
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity3, "2",1);
	//get inventory value
	locations().getInventoryValue("2", "suggested");
	//tap back
	generic().tapBack();	
	//tap back
	generic().tapBack();
	//wait for 1 min
	home().waitForOneMinuteToCloseInventory();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(3);
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify food cost is displayed
	foodCost().verifyFoodCostPage();
	//verify food cost details
	foodCost().verifyFoodCostDetails(2,true);
	//verify COGS
	foodCost().verifyCOGS(2);
	//tap back
	generic().tapBack();
	//tap purchase
	home().tapPurchases();
	//select previously added purchase
	purchase().clickOnPurchaseLine("1");
	//tap on edit
	generic().tapEdit();
	//add new line item
	purchase().clickAddLineItemAndAddItemDetails(data.strLineItemPrice1);
	generic().selectValueFromDropdown(data.strLineItemType1,data.strLineItemType1+" option is selected");
	//capture newly added purchase value
	purchase().getAddedFoodPurchases(data.strLineItemType1, data.strLineItemPrice1, 1);
	 //Tap on done button
	 generic().tapDone();
	//tap back
	 generic().tapBack();	
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify food cost is displayed
	foodCost().verifyFoodCostPage();
	//tap on left arrow
	foodCost().tapOnLeftArrow();
	//verify food cost details
	foodCost().verifyFoodCostDetails(1,true);
	//verify COGS
	foodCost().verifyCOGS(1);
	//close app
	generic().closeApp();
}

/******************************************************************************************
 * Name : INV_FC_022_Verify_Historic_Purchase_LineItem_Delete_Suggested_Cat_With_NonSysco_Purchase_Two_FC_Periods
 * 
 * Description : when the historic purchase is updated, the values are updated for the particular Food Cost (2 Food cost period exists)- Suggested Category  with NonSysco Purchase
 * 
 * Manual Test cases : INV_FC_022
 * 
 * Author : Gayathri Anand
 * 
 * Date : 10/20/2016
 * 
 * Notes : NA
 * 
 * Modification Log
 * Date						Author						Description
 * -----------------------------------------------------------------------------------------
 * 
 ******************************************************************************************/
@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"CriticalBatchAndroid","FoodCost","FoodCost_iOS1","Defect_D0786","Defect_D0764"}, description = "when the historic purchase is updated, the values are updated for the particular Food Cost (2 Food cost period exists) - Suggested Category  with NonSysco Purchase")
public void INV_FC_022_Verify_Historic_Purchase_LineItem_Delete_Suggested_Cat_With_NonSysco_Purchase_Two_FC_Periods(FoodCostObject data) throws Exception {	
	
  //Login to app
	 component().login(data.strUserName, data.strPassword);
	//setup inventory - precondition -INV_FC_007
	 component().setupInventorywithOGDefaultLocSugg12Cat();
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity1, "1");
	//get item price
	locations().getItemPrice("1");
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity1, "2");
	//get item price
	locations().getItemPrice("2");
	//get inventory value
	locations().getInventoryValue("2", "suggested");
	//tap back
	generic().tapBack();
	//tap back
	generic().tapBack();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(1);
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity2, "1",1);
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity2, "2",1);
	//get inventory value
	locations().getInventoryValue("2", "suggested");
	//tap back
	generic().tapBack();	
	//tap back
	generic().tapBack();
	//create supplier
	component().createSupplier(data.strSupplierName1, "", "", "", "", "");
	//create purchase
	component().createPurchase(data.strSupplierName1, "Purchase1", data.strInvoiceTotal, data.strLineItemType, data.strLineItemPrice,1,"suggested",1);
	//wait for 1 min
	home().waitForOneMinuteToCloseInventory();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(2);
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify food cost is displayed
	foodCost().verifyFoodCostPage();
	//verify food cost details
	foodCost().verifyFoodCostDetails(1,true);
	//verify COGS
	foodCost().verifyCOGS(1);
	///////////////////////////////////
	//tap back
	generic().tapBack();
	//navigate to track inventory
	home().tapTrackInventory();
	//verify locations page is displayed
	locations().verifyLocationsPage();
	//tap on a location
	locations().tapLocation(data.strLocationName);
	//verify location page is displayed
	locations().verifyLocationPage(data.strLocationName);
	//enter quantity for 1st item
	locations().enterQuantity(data.strQuantity3, "1",1);
	//enter quantity for 2nd item
	locations().enterQuantity(data.strQuantity3, "2",1);
	//get inventory value
	locations().getInventoryValue("2", "suggested");
	//tap back
	generic().tapBack();	
	//tap back
	generic().tapBack();
	//wait for 1 min
	home().waitForOneMinuteToCloseInventory();
	//close inventory
	component().closeInventory();
	//get beginning and ending inventory values
	home().getInventoryPeriodValues(3);
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify food cost is displayed
	foodCost().verifyFoodCostPage();
	//verify food cost details
	foodCost().verifyFoodCostDetails(2,true);
	//verify COGS
	foodCost().verifyCOGS(2);
	//tap back
	generic().tapBack();
	//tap purchase
	home().tapPurchases();
	//select previously added purchase
	purchase().clickOnPurchaseLine("1");
	//tap on edit
	generic().tapEdit();
	//delete line item
	purchase().clickOnDeleteItemLink("4");
	purchase().clickOnDeleteItemButton();
	//capture newly added purchase value
	purchase().getDeletedFoodPurchases(1);
	 //Tap on done button
	generic().tapDone();
	//tap back
	 generic().tapBack();	
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify food cost is displayed
	foodCost().verifyFoodCostPage();
	//tap on left arrow
	foodCost().tapOnLeftArrow();
	//verify food cost details
	foodCost().verifyFoodCostDetails(1,true);
	//verify COGS
	foodCost().verifyCOGS(1);
	//close app
	generic().closeApp();
}

/******************************************************************************************
 * Name : INV_FC_023_Verify_Hot_Shedules_Customer_Food_Cost
 * 
 * Description : Verify food cost for hot schedules customer
 * 
 * Manual Test cases : INV_FC_023
 * 
 * Author : Gayathri Anand
 * 
 * Date : 10/22/2016
 * 
 * Notes : NA
 * 
 * Modification Log
 * Date						Author						Description
 * -----------------------------------------------------------------------------------------
 * 
 ******************************************************************************************/
@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"CriticalBatchAndroid","FoodCost","FoodCost_iOS1"}, description = "Verify food cost for hot schedules customer")
public void INV_FC_023_Verify_Hot_Shedules_Customer_Food_Cost(FoodCostObject data) throws Exception {	
	
  //Login to app
	component().login(data.strUserName, data.strPassword,false);
	//Tap on View food cost
	home().tapOnViewFoodCost();
	//verify food cost is displayed
	foodCost().verifyFoodCostPage();
	//verify food sales amount
	foodCost().verifyFoodSalesAmountForHotShedulesCustomer(data.strFoodSales);
	//verify food cost calculation
	foodCost().verifyFoodCostCalculation(data.strFoodSales);
	//tap on categorized view
	foodCost().tapOnCategorizedView();
	//verify food cost calculation
	foodCost().verifyFoodCostCalculation(data.strFoodSales);
}
}
