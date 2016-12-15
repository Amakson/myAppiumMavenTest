package com.uom.oldfiles;


import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.DataRead.Excel;
import com.uom.excelSheetObject.ManageInventoryListObject;
import com.uom.pageFactory.PageFactory;
import com.framework.Starter;
import com.framework.configuration.ConfigFile;
import com.framework.utils.RetryAnalyzer;
import com.framework.utils.UOMTestNGListener;

@Listeners(value = UOMTestNGListener.class)
public class ManageInventoryListiOS extends PageFactory {
	 
	 public static String[][] completeArray = null;	

	 @BeforeClass(alwaysRun=true)
		public void getData() throws Exception
		{		
			String strDataFilePath;
			Excel newExcel =new Excel();		
			completeArray=newExcel.read("test-data/TestData.xls","ManageInventoryList");
		}
	    @BeforeMethod(alwaysRun=true)
	    public void initiate()
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
			 	ManageInventoryListObject sheetObj = new ManageInventoryListObject();
		        System.out.println(method.getName());
		        String[][] MethodArray=newExcel.getMethodData(completeArray, method.getName());
		        Object[][] retObjArr= sheetObj.getTestData(MethodArray);
		        return(retObjArr);
		    }

		 /******************************************************************************************
		  * Name : INV_MIL_001_006_AddItem_FromOrderGuide_NonSysco
		  * 
		  * Description : Verify if the user is able to add item from Order Guide and a non Sysco item fordefault location set up
		  * 
		  * Manual Test cases : INV_MIL_001 ,INV_MIL_006
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 9/23/2016
		  * 
		  * Notes : NA
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"issue","ManageInventoryList_iOS2"}, description = "Add item from Order Guide")
		 public void INV_MIL_001_006_AddItem_FromOrderGuide_NonSysco(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up Inventory -  Can plug it in once the set inventory screens are stable
			component().setupInventorywithOGDefaultLocDefaultCat();		
            //Create Supplier 
			component().createSupplier(data.strSupplierName, data.strPhoneNumber, data.strAddress, data.strContactInformation, data.strEmailAddress, data.strNotes);
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//Select Any one location
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
		
				
			//INV_MIL_005
			// Tap + button
			generic().tapAddFromListPage();
			//verify Add item form is displayed
			locations().verifyAddItemFormPageDisplayed();
			//tap create non Sysco item
			locations().tapCreateNonSyscoItem();
			//verify Add Product Page is displayed
			locations().verifyAddProductPageDisplayed();
			//Enter Mandatory fields
			product().enterNonSyscoItemDetails(data.strProduct1Name, data.strProduct1NickName, data.strProduct1Brand, data.strProduct1Id, data.strProduct1Pack, data.strProduct1Size, data.strProduct1Weight, data.strProduct1Price);
			//Select Supplier
			product().selectSupplier();
			generic().selectValueFromDropdown(data.strSupplierName,"Supplier "+data.strSupplierName+" is selected");
			//Select Expense Category
			product().tapExpenseCategoryNonSysco();
			generic().selectValueFromDropdown(data.strExpenseCategory,"Expense Category "+data.strExpenseCategory+" is selected");
			//tap done
			generic().tapDone();
			//verify location page is displayed
			//
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			generic().waitForPageToLoad(6);
			//Verify the newly added item is displayed in the locations page
			locations().verifyItemPresentInLocation(data.strProduct1Name,"Product Name",true);	
		
			
			//INV_MIL_001
			// Tap + button
			generic().tapAddFromListPage();
			//verify Add item form is displayed
			locations().verifyAddItemFormPageDisplayed();
			//tap on add from Order Guide
			locations().tapAddItemFromOrderGuide();
			//Verify Add Order Guide Page is displayed
			locations().verifyAddOrderGuidePage();
			//Select an item
			locations().selectAnItemWithIndexFromList("1","true","upcid");
			//locations().selectAnItemWithName(data.strItem1Name);
			//Click on Done
			generic().tapDone();
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//Verify the newly added item is displayed in the locations page
			locations().verifyItemPresentInLocation(data.strItem1Name,"UPCID",true,"true");		
			
			
			//component().logoutFromInventoryList();
			generic().closeApp();
			}
		 
		 /******************************************************************************************
		  * Name : INV_MIL_002_007_Add_FromCustomList_PrepItem
		  * 
		  * Description : Verify if the user is able to add item from Order Guide and a perp item - for default Location
		  * 
		  * Manual Test cases : INV_MIL_002 ,INV_MIL_007
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 9/26/2016
		  * 
		  * Notes : NA
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"issue","ManageInventoryList_iOS1"}, description = "Add item from Custom List")
		 public void INV_MIL_002_007_Add_FromCustomList_PrepItem(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up inventory  - Default location
			component().setupInventorywithOGDefaultLocDefaultCat();	
			//strItemName - needs to be updated in the data sheet based on the user
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//Select Any one location
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			// Tap + button
			generic().tapAddFromListPage();
			//verify Add item form is displayed
			locations().verifyAddItemFormPageDisplayed();
			//tap on add from Order Guide
			locations().tapAddItemFromCustomList();
			//Verify SelectList Page is displayed
			locations().verifySelectPage();
			//select a list
			locations().selectCustomList(data.strListName1);
			//verify Add Custom List page is displayed
			locations().verifyAddCustomListPage();
			//Select an item
			locations().selectAnItemWithIndexFromList("1","true","upcid");
			//Click on Done
			generic().tapDone();
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//Verify the newly added item is displayed in the locations page
			locations().verifyItemPresentInLocation(data.strItem1Name,"UPCID",true,"true");		
			
			//INV_MIL_006
			// Tap + button
			generic().tapAddFromListPage();
			//verify Add item form is displayed
			locations().verifyAddItemFormPageDisplayed();
			//tap create Prep item
			locations().tapCreatePrepItem();
			//verify Add Product Page is displayed
			locations().verifyAddProductPageDisplayed();
			//Select Expense Category
			product().tapExpenseCategoryPrep();
			generic().selectValueFromDropdown(data.strExpenseCategory,"Expense Category "+data.strExpenseCategory+" is selected");
			//Enter Mandatory fields
			product().enterPrepItemDetails(data.strProduct1Name, data.strProduct1NickName, data.strProduct1Id, data.strProduct1Pack, data.strProduct1Size, data.strProduct1Weight,data.strProduct1Price);
			//tap done
			generic().tapDone();
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			generic().waitForPageToLoad(6);
			//Verify the newly added item is displayed in the locations page
			locations().verifyItemPresentInLocation(data.strProduct1Name,"Product Name",true);	
			
			//component().logoutFromInventoryList();
			generic().closeApp();
			}
		 
		 /******************************************************************************************
		  * Name : INV_MIL_008_010_AddItem_FromOrderGuide_NonSysco_CustomLocation
		  * 
		  * Description : Verify if the user is able to add item from Order Guide and a non Sysco item for- Custom location set up
		  * 
		  * Manual Test cases : INV_MIL_008,INV_MIV_010
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 9/28/2016
		  * 
		  * Notes : NA
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"issue","ManageInventoryList_iOS2"}, description = "Add item from Order Guide")
		 public void INV_MIL_008_010_AddItem_FromOrderGuide_NonSysco_CustomLocation(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up inventory  - Custom location
			component().setupInventorywithOGCustomLocationDefaultCategory();			
			//Create Supplier 
			component().createSupplier(data.strSupplierName, data.strPhoneNumber, data.strAddress, data.strContactInformation, data.strEmailAddress, data.strNotes);
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//Select Any one location
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			
			//INV_MIL_005
			// Tap + button
			generic().tapAddFromListPage();
			//verify Add item form is displayed
			locations().verifyAddItemFormPageDisplayed();
			//tap create non Sysco item
			locations().tapCreateNonSyscoItem();
			//verify Add Product Page is displayed
			locations().verifyAddProductPageDisplayed();
			//Enter Mandatory fields
			product().enterNonSyscoItemDetails(data.strProduct1Name, data.strProduct1NickName, data.strProduct1Brand, data.strProduct1Id, data.strProduct1Pack, data.strProduct1Size, data.strProduct1Weight, data.strProduct1Price);
			//Select Supplier
			product().selectSupplier();
			generic().selectValueFromDropdown(data.strSupplierName,"Supplier "+data.strSupplierName+" is selected");
			//Select Expense Category
			product().tapExpenseCategoryNonSysco();
			generic().selectValueFromDropdown(data.strExpenseCategory,"Expense Category "+data.strExpenseCategory+" is selected");
			//tap done
			generic().tapDone();
			//verify location page is displayed
			generic().waitForPageToLoad(6);
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//Verify the newly added item is displayed in the locations page
			locations().verifyItemPresentInLocation(data.strProduct1Name,"Product Name",true);	
			
			// Tap + button
			generic().tapAddFromListPage();
			//verify Add item form is displayed
			locations().verifyAddItemFormPageDisplayed();
			//tap on add from Order Guide
			locations().tapAddItemFromOrderGuide();
			//Verify Add Order Guide Page is displayed
			locations().verifyAddOrderGuidePage();
			//Select an item
			locations().selectAnItemWithIndexFromList("1","true","upcid");
			//Click on Done
			generic().tapDone();
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//Verify the newly added item is displayed in the locations page
			locations().verifyItemPresentInLocation(data.strItem1Name,"UPCID",true,"true");		
			
			
			
			//component().logoutFromInventoryList();
			generic().closeApp();
			
			}
		 /******************************************************************************************
		  * Name : INV_MIL_009_011_AddItem_FromCustomList_PrepItem_CustomLocation
		  * 
		  * Description : Verify if the user is able to add item from Order Guide and a perp item - for Custom Location
		  * 
		  * Manual Test cases : INV_MIL_009, INV_MIL_011
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 9/28/2016
		  * 
		  * Notes : NA
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"issue","ManageInventoryList_iOS1"}, description = "Add item from Custom List")
		 public void INV_MIL_009_011_AddItem_FromCustomList_PrepItem_CustomLocation(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up inventory  - Custom location
			component().setupInventorywithOGCustomLocationDefaultCategory();			
			//strItemName - needs to be updated in the data sheet based on the user
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//Select Any one location
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			
			
			//INV_MIL_011
			// Tap + button
			generic().tapAddFromListPage();
			//verify Add item form is displayed
			locations().verifyAddItemFormPageDisplayed();
			//tap create Prep item
			locations().tapCreatePrepItem();
			//verify Add Product Page is displayed
			locations().verifyAddProductPageDisplayed();
			//Enter Mandatory fields
			product().enterPrepItemDetails(data.strProduct1Name, data.strProduct1NickName, data.strProduct1Id, data.strProduct1Pack, data.strProduct1Size, data.strProduct1Weight,data.strProduct1Price);
			//Select Expense Category
			product().tapExpenseCategoryPrep();
			generic().selectValueFromDropdown(data.strExpenseCategory,"Expense Category "+data.strExpenseCategory+" is selected");
			//tap done
			generic().tapDone();
			//verify location page is displayed
			generic().waitForPageToLoad(6);
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//Verify the newly added item is displayed in the locations page
			locations().verifyItemPresentInLocation(data.strProduct1Name,"Product Name",true);	
			
			
			// Tap + button
			generic().tapAddFromListPage();
			//verify Add item form is displayed
			locations().verifyAddItemFormPageDisplayed();
			//tap on add from Custom List
			locations().tapAddItemFromCustomList();
			//Verify SelectList Page is displayed
			locations().verifySelectPage();
			//select a list
			locations().selectCustomList(data.strListName1);
			//verify Add Custom List page is displayed
			locations().verifyAddCustomListPage();
			//Select an item
			locations().selectAnItemWithIndexFromList("1","true","upcid");
			//Click on Done
			generic().tapDone();
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//Verify the newly added item is displayed in the locations page
			locations().verifyItemPresentInLocation(data.strItem1Name,"UPCID",true,"true");	
			
			
			//component().logoutFromInventoryList();
			
			generic().closeApp();
			}
		 /******************************************************************************************
		  * Name : INV_MIL_015_016_VerifyProductNickName
		  * 
		  * Description : Verify Product Nick name feature -  single location , multiple location mapping
		  * 
		  * Manual Test cases : INV_MIL_015, INV_MIL_016 
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 9/28/2016
		  * 
		  * Notes : NA
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageInventoryList","ManageInventoryList_iOS2"}, description = "Verify Product Nick Name in Track Inventory")
		 public void INV_MIL_015_016_VerifyProductNickName(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up Inventory -  Can plug it in once the set inventory screens are stable
			component().setupInventorywithOGDefaultLocDefaultCat();	
			//strItemName - needs to be updated in the data sheet based on the user
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//Select Any one location
			locations().tapLocation(data.strLocation1Name);  
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//select an item which is available in one location
			locations().selectAnItemFromProductList(data.strItem1Name);
			//click on edit
			generic().tapEdit();
			//Add nick name
			product().enterNickName(data.strProduct1NickName);
			//click on Done
			generic().tapDone();
			//tap on back
			generic().tapClose();
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//Verify if the updated item is displayed with the nick name
			locations().verifyItemPresentInLocation(data.strProduct1NickName,"Product Name",true);	
			//Verify that the product name is no longer available in the list
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",false);	
			//Select item updated item
			locations().selectAnItemFromProductList(data.strProduct1NickName);
			//click on edit
			generic().tapEdit();
			//Remove the Product Nick Name
			product().enterNickName("");
			//Add a new location
			product().tapOnAddAnotherLocation();
			//Verify a new row is created
			product().verifyNewLocationFields();
			product().tapLocation("1");
			//Add a new location for an item
			generic().selectValueFromDropdown(data.strLocation2Name,data.strLocation2Name+" is selected");
			//Click on done
			generic().tapDone();
			//tap on close
			generic().tapClose();
			//Verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//Verify if the item is available with item name
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);	
					
			//select an item which is available in 2 locations
			locations().selectAnItemFromProductList(data.strItem1Name);
			//click on edit
			generic().tapEdit();
			//Add nick name
			product().enterNickName(data.strProduct2NickName);
			//click on Done
			generic().tapDone();
			//tap on back
			generic().tapClose();
			//Verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//Verify if the updated item is displayed with the nick name
			locations().verifyItemPresentInLocation(data.strProduct2NickName,"Product Name",true);	
			//Verify that the product name is no longer available in the list
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",false);	
			//tap back
			generic().tapBack();
			//Location list page is displayed
			locations().verifyLocationsPage();
			//Select the second location
			locations().tapLocation(data.strLocation2Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation2Name);
			//Verify if the updated item is displayed with the nick name
			locations().verifyItemPresentInLocation(data.strProduct2NickName,"Product Name",true);	
			//Verify that the product name is no longer available in the list
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",false);	
			//Select item updated item
			locations().selectAnItemFromProductList(data.strProduct2NickName);
			//click on edit
			generic().tapEdit();
			//Remove the Product Nick Name
			product().enterNickName("");
			product().clickEditProduct();
			//Click on Done
			generic().tapDone();
			generic().tapClose();
			//Verify if the item is available with item name
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);	
			generic().tapBack();
			//Location list page is displayed
			locations().verifyLocationsPage();			
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//Verify if the item is available with product name
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);	
			//component().logoutFromInventoryList();
			generic().closeApp();
			}
		 
		 /******************************************************************************************
		  * Name : INV_MIL_003_Add_FromSyscoList_Default
		  * 
		  * Description : Verify if the user is able to add item from Sysco List - for Default Location
		  * 		  * 
		  * Manual Test cases : INV_MIL_003
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 9/29/2016
		  * 
		  * Notes : NA
		  * 
		  * Test Data : uomautnu1/automate1
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageInventoryList","ManageInventoryList_iOS1"}, description = "Add item from Custom List")
		 public void INV_MIL_003_Add_FromSyscoList_Default(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up Inventory -  Can plug it in once the set inventory screens are stable
			component().setupInventorywithOGDefaultLocDefaultCat();		
			//strItemName - needs to be updated in the data sheet based on the user
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//Select Any one location
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			// Tap + button
			generic().tapAddFromListPage();
			//verify Add item form is displayed
			locations().verifyAddItemFormPageDisplayed();
			//tap on add from Order Guide
			locations().tapAddItemFromCustomList();
			//Verify SelectList Page is displayed
			locations().verifySelectPage();
			//select a sysco list
			locations().selectCustomList(data.strListName1);
			//verify Add Custom List page is displayed
			locations().verifyAddCustomListPage();
			//Select an item
			locations().selectAnItemWithIndexFromList("1","true","upcid");
			//Click on Done
			generic().tapDone();
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//generic().waitForPageToLoad(6);
			//Verify the newly added item is displayed in the locations page
			locations().verifyItemPresentInLocation(data.strItem1Name,"UPCID",true,"true");			
			//component().logoutFromInventoryList();
			generic().closeApp();
			}
		 
		 /******************************************************************************************
		  * Name : INV_MIL_017_038_AddMultipleLocationsForItems_Default
		  * 
		  * Description : Verify if user is able to add multiple locations to a same item- for Default Location
		  * 		 
		  * Manual Test cases : INV_MIL_017, INV_MIL_038
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 9/29/2016
		  * 
		  * Notes : NA
		  * 
		  * Test Data : uomautnu1/automate1
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageInventoryList","ManageInventoryList_iOS2"}, description = "Add items to multiple location")
		 public void INV_MIL_017_038_AddMultipleLocationsForItems_Default(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up inventory  - Default location
			component().setupInventorywithOGDefaultLocDefaultCat();		
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//Select Any one location - Freezer
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//select an item which is available in one location
			locations().selectAnItemFromProductList(data.strItem1Name);
			//click on edit
			generic().tapEdit();
			//verify the location of the item
			product().verifyLocationAfterEdit(data.strLocation1Name,0);
			//Verify there is an option to add another location
			product().tapOnAddAnotherLocation();
			//Verify a new row is created
			product().verifyNewLocationFields();
			product().tapLocation("1");
			//verify the picker has only other locations to select
			generic().verifyValueInDropdown(data.strLocation2Name,"Location list",true);
			generic().verifyValueInDropdown(data.strLocation3Name,"Location list",true);
			generic().verifyValueInDropdown(data.strLocation1Name,"Location list",false);			
			//Add a new location for an item
			generic().selectValueFromDropdown(data.strLocation2Name,data.strLocation2Name+" is selected");
			//Click on done
			generic().tapDone();
			//tap on close
			generic().tapClose();
			//verify if item is added available in the current location
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);		
			//tap back
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation2Name);
			//Verify the item is available in the newly added locations
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);		
		//	component().logoutFromInventoryList();
			generic().closeApp();
			}
		/******************************************************************************************
		  * Name : INV_MIL_018a_AddMultipleLocationsForNonSyscoItems_Default
		  * 
		  * Description : Verify if user is able to add multiple locations to a same  non sysco item- for Default Location
		  * 		 
		  * Manual Test cases : INV_MIL_018a_AddMultipleLocationsForNonSyscoItems_Default
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 9/29/2016
		  * 
		  * Notes : NA
		  * 
		  * Test Data : uomautnu1/automate1
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"issue","ManageInventoryList_iOS2"}, description = "")
		 public void INV_MIL_018a_AddMultipleLocationsForNonSyscoItems_Default(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
		
			//Set up inventory  - Default location
			component().setupInventorywithOGDefaultLocDefaultCat();		
			//strItemName - needs to be updated in the data sheet based on the user
		    component().createSupplier(data.strSupplierName, data.strPhoneNumber, data.strAddress, data.strContactInformation, data.strEmailAddress, data.strNotes);
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//Select Any one location - Freezer
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			
			// Tap + button
			generic().tapAddFromListPage();
			//verify Add item form is displayed
			locations().verifyAddItemFormPageDisplayed();
			//tap create non Sysco item
			locations().tapCreateNonSyscoItem();
			//verify Add Product Page is displayed
			locations().verifyAddProductPageDisplayed();
			//Enter Mandatory fields
			product().enterNonSyscoItemDetails(data.strProduct1Name, data.strProduct1NickName, data.strProduct1Brand, data.strProduct1Id, data.strProduct1Pack, data.strProduct1Size, data.strProduct1Weight, data.strProduct1Price);
			//Select Supplier
			product().selectSupplier();
			generic().selectValueFromDropdown(data.strSupplierName,"Supplier "+data.strSupplierName+" is selected");
			//Select Expense Category
			product().tapExpenseCategoryNonSysco();
			generic().selectValueFromDropdown(data.strExpenseCategory,"Expense Category "+data.strExpenseCategory+" is selected");
			//tap done
			generic().tapDone();
			//verify location page is displayed
			//
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			generic().waitForPageToLoad(6);
			//Verify the newly added item is displayed in the locations page
			locations().verifyItemPresentInLocation(data.strProduct1Name,"Product Name",true);	
			
			//select an item which is available in one location
			locations().selectAnItemFromProductList(data.strProduct1Name);
			//click on edit
			generic().tapEdit();
			//verify the location of the item
			product().verifyLocationAfterEdit(data.strLocation1Name,0);
			//Verify there is an option to add another location
			product().tapOnAddAnotherLocation();
			//Verify a new row is created
			product().verifyNewLocationFields();
			product().tapLocationNonSysco("1");
			//verify the picker has only other locations to select
			generic().verifyValueInDropdown(data.strLocation2Name,"Location list",true);
			generic().verifyValueInDropdown(data.strLocation3Name,"Location list",true);
			generic().verifyValueInDropdown(data.strLocation1Name,"Location list",false);			
			//Add a new location for an item
			generic().selectValueFromDropdown(data.strLocation2Name,data.strLocation2Name+" is selected");
			//Click on done
			generic().tapDone();
			//tap on close
			generic().tapClose();
			//verify if item is added available in the current location
			locations().verifyItemPresentInLocation(data.strProduct1Name,"Product Name",true);		
			//tap back
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation2Name);
			//Verify the item is available in the newly added locations
			locations().verifyItemPresentInLocation(data.strProduct1Name,"Product Name",true);		
			//component().logoutFromInventoryList();
			generic().closeApp();
			}
		 
		 /******************************************************************************************
		  * Name : INV_MIL_018b_AddMultipleLocationsForPrep_Default
		  * 
		  * Description : Verify if user is able to add multiple locations to a same  prep item- for Default Location
		  * 		 
		  * Manual Test cases : INV_MIL_018
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 9/29/2016
		  * 
		  * Notes : NA
		  * 
		  * Test Data : uomautnu1/automate1
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"issue","ManageInventoryList_iOS1"}, description = "")
		 public void INV_MIL_018b_AddMultipleLocationsForPrep_Default(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up inventory  - Default location
			component().setupInventorywithOGDefaultLocDefaultCat();		
			//strItemName - needs to be updated in the data sheet based on the user
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//Select Any one location - Freezer
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			// Tap + button
			generic().tapAddFromListPage();
			//verify Add item form is displayed
			locations().verifyAddItemFormPageDisplayed();
			//tap create Prep item
			locations().tapCreatePrepItem();
			//verify Add Product Page is displayed
			locations().verifyAddProductPageDisplayed();
			//Select Expense Category
			product().tapExpenseCategoryPrep();
			generic().selectValueFromDropdown(data.strExpenseCategory,"Expense Category "+data.strExpenseCategory+" is selected");
			//Enter Mandatory fields
			product().enterPrepItemDetails(data.strProduct1Name, data.strProduct1NickName, data.strProduct1Id, data.strProduct1Pack, data.strProduct1Size, data.strProduct1Weight,data.strProduct1Price);
			//tap done
			generic().tapDone();
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			generic().waitForPageToLoad(6);
			//Verify the newly added item is displayed in the locations page
			locations().verifyItemPresentInLocation(data.strProduct1Name,"Product Name",true);	
									
			//select an item which is available in one location
			locations().selectAnItemFromProductList(data.strProduct1Name);
			//click on edit
			generic().tapEdit();
			//verify the location of the item
			product().verifyLocationAfterEdit(data.strLocation1Name,0);
			//Verify there is an option to add another location
			product().tapOnAddAnotherLocation();
			//Verify a new row is created
			product().verifyNewLocationFields();
			product().tapLocation("1");
			//verify the picker has only other locations to select
			generic().verifyValueInDropdown(data.strLocation2Name,"Location list",true);
			generic().verifyValueInDropdown(data.strLocation3Name,"Location list",true);
			generic().verifyValueInDropdown(data.strLocation1Name,"Location list",false);			
			//Add a new location for an item
			generic().selectValueFromDropdown(data.strLocation2Name,data.strLocation2Name+" is selected");
			//Click on done
			generic().tapDone();
			//tap on close
			generic().tapClose();
			//verify if item is added available in the current location
			locations().verifyItemPresentInLocation(data.strProduct1Name,"Product Name",true);		
			//tap back
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation2Name);
			//Verify the item is available in the newly added locations
			locations().verifyItemPresentInLocation(data.strProduct1Name,"Product Name",true);	
			//component().logoutFromInventoryList();
			generic().closeApp();
			}
		/******************************************************************************************
		  * Name : INV_MIL_021_EditDetails_Location_NonSyscoItem
		  * 
		  * Description : Verify if user is able to edit non Sysco item details. If he changes the location, the item should move to the new location
		  *  		 
		  * Manual Test cases : INV_MIL_018a_AddMultipleLocationsForNonSyscoItems_Default
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 9/30/2016
		  * 
		  * Notes : NA
		  * 
		  * Test Data : uomautnu3/automate1
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"issue","ManageInventoryList_iOS2"}, description = "")
		 public void INV_MIL_021_022_EditDetails_Location_NonSyscoItem(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up Inventory -  Can plug it in once the set inventory screens are stable
			//Set up inventory  - Default location
			component().setupInventorywithOGDefaultLocDefaultCat();		
			//strItemName - needs to be updated in the data sheet based on the user
			component().createSupplier(data.strSupplierName, data.strPhoneNumber, data.strAddress, data.strContactInformation, data.strEmailAddress, data.strNotes);
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//Select Any one location - Freezer
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			// Tap + button
			generic().tapAddFromListPage();
			//verify Add item form is displayed
			locations().verifyAddItemFormPageDisplayed();
			//tap create non Sysco item
			locations().tapCreateNonSyscoItem();
			//verify Add Product Page is displayed
			locations().verifyAddProductPageDisplayed();
			//Enter Mandatory fields
			product().enterNonSyscoItemDetails(data.strProduct1Name, data.strProduct1NickName, data.strProduct1Brand, data.strProduct1Id, data.strProduct1Pack, data.strProduct1Size, data.strProduct1Weight, data.strProduct1Price);
			//Select Supplier
			product().selectSupplier();
			generic().selectValueFromDropdown(data.strSupplierName,"Supplier "+data.strSupplierName+" is selected");
			//Select Expense Category
			product().tapExpenseCategoryNonSysco();
			generic().selectValueFromDropdown(data.strExpenseCategory,"Expense Category "+data.strExpenseCategory+" is selected");
			//tap done
			generic().tapDone();
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			generic().waitForPageToLoad(6);
			//Verify the newly added item is displayed in the locations page
			locations().verifyItemPresentInLocation(data.strProduct1Name,"Product Name",true);	
			//select an item which is available in one location
			locations().selectAnItemFromProductList(data.strProduct1Name);
			//click on edit
			generic().tapEdit();
			//Edit details
			product().enterNonSyscoItemDetails(data.strProduct2Name, data.strProduct2NickName, data.strProduct2Brand, data.strProduct2Id, data.strProduct2Pack, data.strProduct2Size, data.strProduct2Weight, data.strProduct2Price);
			//click on add product
			product().clickEditProductLabel();			
			//tap done
			generic().tapDoneFromEdit();
			generic().tapClose();
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//Verify the item with the old name is not displayed in the locations page
			locations().verifyItemPresentInLocation(data.strProduct1Name,"Product Name",false);	
			//Verify the newly added item is displayed in the locations page
			locations().verifyItemPresentInLocation(data.strProduct2Name,"Product Name",true);	
			generic().tapBack();
			generic().tapBack();
			
			home().logout();
					 
			//Login to app
			component().login(data.strUserName, data.strPassword,false);
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//Select Any one location - Freezer
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//Verify the newly added item is displayed in the locations page
			locations().verifyItemPresentInLocation(data.strProduct2Name,"Product Name",true);	
			//select the non sysco item
			locations().selectAnItemFromProductList(data.strProduct2Name);
			generic().tapEdit();
			product().tapLocationNonSysco("0");
			//Add a new location for an item
			generic().selectValueFromDropdown(data.strLocation2Name,data.strLocation2Name+" is selected");
			//Click on done
			generic().tapDone();
			//tap on close
			generic().tapClose();
			//verify if item is added available in the current location
			locations().verifyItemPresentInLocation(data.strProduct2Name,"Product Name",false);		
			//tap back
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation2Name);
			//Verify the item is available in the newly added locations
			locations().verifyItemPresentInLocation(data.strProduct2Name,"Product Name",true);		
			//component().logoutFromInventoryList();
			generic().closeApp();
			}
		 /******************************************************************************************
		  * Name : INV_MIL_024_025_DeleteItem_Single_Multiple_Locations
		  * 
		  * Description : Verify if user is able to delete items which is avialable in single and mutliple locations
		  *  		 
		  * Manual Test cases : INV_MIL_024,INV_MIL_025
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 9/30/2016
		  * 
		  * Notes : NA
		  * 
		  * Test Data : uomautnu3/automate1
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageInventoryList","ManageInventoryList_iOS1","retry123"}, description = "Delete Item")
		 public void INV_MIL_024_025_DeleteItem_Single_Multiple_Locations(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up Inventory -  Can plug it in once the set inventory screens are stable
			component().setupInventorywithOGDefaultLocDefaultCat();		
			//Set up inventory  - Default location
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//Select Any one location - Cooler
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//tap Edit
			generic().tapEdit();
			//delete an item (only one location)
			locations().deleteItem(data.strItem1Name);
			//tap done
			generic().tapDone();
			generic().tapYesDelete();
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//Verify the item with the old name is not displayed in the locations page
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",false);
			// Go to No location
			generic().tapBack();
			//Select newly added location
			locations().tapLocation("No Location");
			//verify location page is displayed
			locations().verifyLocationPageDisplayed("No Location");
			//Verify the item with the old name is displayed in the no locations page
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);
			
			// Go to another location
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation2Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation2Name);
			//select 2nd item
			locations().selectAnItemFromProductList(data.strItem2Name);
			generic().tapEdit();
			//Verify there is an option to add another location
			product().tapOnAddAnotherLocation();
			product().tapLocation("1");
			//Add a new location for an item
			generic().selectValueFromDropdown(data.strLocation1Name,data.strLocation1Name+" is selected");
			//Click on done
			generic().tapDone();
			//tap on close
			generic().tapClose();
			
			// Go to previous location
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//tap Edit
			generic().tapEdit();
			//delete an item (only one location)
			locations().deleteItem(data.strItem2Name);
			//tap done
			generic().tapDone();
			generic().tapYesDelete();
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//Verify the item with the old name is not displayed in the locations page
			locations().verifyItemPresentInLocation(data.strItem2Name,"Product Name",false);
			
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation2Name);
			//Verify the item is available in the newly added locations
			locations().verifyItemPresentInLocation(data.strItem2Name,"Product Name",true);		
			// Go to No location
			generic().tapBack();
			//Select newly added location
			locations().tapLocation("No Location");
			//verify location page is displayed
			locations().verifyLocationPageDisplayed("No Location");
			//Verify the item with the old name is displayed in the no locations page
			locations().verifyItemPresentInLocation(data.strItem2Name,"Product Name",false);
			//component().logoutFromInventoryList();
			generic().closeApp();			
			}
		/******************************************************************************************
		  * Name : INV_MIL_012_Add_FromSyscoList_CustomLocation
		  * 
		  * Description : Verify if the user is able to add item from Sysco List- for Custom Location
		  * 		  * 
		  * Manual Test cases : INV_MIL_012
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 10/1/2016
		  * 
		  * Notes : NA
		  * 
		  * Test Data : uomautnu1/automate1
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageInventoryList","ManageInventoryList_iOS1"}, description = "Add item from Custom List")
		 public void INV_MIL_012_Add_FromSyscoList_CustomLocation(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up Inventory -  Can plug it in once the set inventory screens are stable			
			//Set up inventory  - custom location
			component().setupInventorywithOGCustomLocDefaultCategorySingleLocationSelection(data.strLocation1Name, "FREEZER",false);
			//strItemName - needs to be updated in the data sheet based on the user
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//Select Any one location
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			// Tap + button
			generic().tapAddFromListPage();
			//verify Add item form is displayed
			locations().verifyAddItemFormPageDisplayed();
			//tap on add from Order Guide
			locations().tapAddItemFromCustomList();
			//Verify SelectList Page is displayed
			locations().verifySelectPage();
			//select a sysco list
			locations().selectCustomList(data.strListName1);
			//verify Add Custom List page is displayed
			locations().verifyAddCustomListPage();
			//Select an item
			locations().selectAnItemWithIndexFromList("1","true","upcid");
			//Click on Done
			generic().tapDone();
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//generic().waitForPageToLoad(6);
			//Verify the newly added item is displayed in the locations page
			locations().verifyItemPresentInLocation(data.strItem1Name,"UPCID",true,"true");	
			//component().logoutFromInventoryList();
			generic().closeApp();
			}
		 /******************************************************************************************
		  * Name : INV_MIL_019_AddMultipleLocationsForItems_CustomLocation
		  * 
		  * Description : Verify if user is able to add multiple locations to a same item- for Custom Location
		  * 		 
		  * Manual Test cases : INV_MIL_019
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 9/29/2016
		  * 
		  * Notes : NA
		  * 
		  * Test Data : uomautnu1/automate1
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageInventoryList","ManageInventoryList_iOS1","retry123"}, description = "Add items to multiple location")
		 public void INV_MIL_019_AddMultipleLocationsForItems_CustomLocation(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up Inventory -  Can plug it in once the set inventory screens are stable
			//Set up inventory  - 3 Custom location
			component().setupInventorywithOGCustomLocDefaultCategorySingleLocationSelection(data.strLocation1Name+"/"+data.strLocation2Name+"/"+data.strLocation3Name, "COOLER/FREEZER/DRY",false);
			//strItemName - needs to be updated in the data sheet based on the user
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//Select Any one location - Freezer
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//select an item which is available in one location
			locations().selectAnItemFromProductList(data.strItem1Name);
			//click on edit
			generic().tapEdit();
			//verify the location of the item
			product().verifyLocationAfterEdit(data.strLocation1Name,0);
			//Verify there is an option to add another location
			product().tapOnAddAnotherLocation();
			//Verify a new row is created
			product().verifyNewLocationFields();
			product().tapLocation("1");
			//verify the picker has only other locations to select
			generic().verifyValueInDropdown(data.strLocation2Name,"Location list",true);
			generic().verifyValueInDropdown(data.strLocation3Name,"Location list",true);
			generic().verifyValueInDropdown(data.strLocation1Name,"Location list",false);			
			//Add a new location for an item
			generic().selectValueFromDropdown(data.strLocation2Name,data.strLocation2Name+" is selected");
			//Click on done
			generic().tapDone();
			//tap on close
			generic().tapClose();
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//verify if item is added available in the current location
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);		
			//tap back
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation2Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation2Name);
			//Verify the item is available in the newly added locations
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);		
			//component().logoutFromInventoryList();
			generic().closeApp();
			}
		/******************************************************************************************
		  * Name : INV_MIL_020a_AddMultipleLocationsForNonSyscoItems_CustomLocation
		  * 
		  * Description : Verify if user is able to add multiple locations to a same  non sysco item- for Custom Location
		  * 		 
		  * Manual Test cases : INV_MIL_20
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 10/01/2016
		  * 
		  * Notes : NA
		  * 
		  * Test Data : uomautnu1/automate1
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"issue","ManageInventoryList_iOS2"}, description = "")
		 public void INV_MIL_020a_AddMultipleLocationsForNonSyscoItems_CustomLocation(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up Inventory -  Can plug it in once the set inventory screens are stable
			//Set up inventory  - Custom location
			component().setupInventorywithOGCustomLocDefaultCategorySingleLocationSelection(data.strLocation1Name+"/"+data.strLocation2Name+"/"+data.strLocation3Name, "COOLER/FREEZER/DRY",false);
			//strItemName - needs to be updated in the data sheet based on the user
			component().createSupplier(data.strSupplierName, data.strPhoneNumber, data.strAddress, data.strContactInformation, data.strEmailAddress, data.strNotes);
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//Select Any one location - Freezer
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			
			// Tap + button
			generic().tapAddFromListPage();
			//verify Add item form is displayed
			locations().verifyAddItemFormPageDisplayed();
			//tap create non Sysco item
			locations().tapCreateNonSyscoItem();
			//verify Add Product Page is displayed
			locations().verifyAddProductPageDisplayed();
			//Enter Mandatory fields
			product().enterNonSyscoItemDetails(data.strProduct1Name, data.strProduct1NickName, data.strProduct1Brand, data.strProduct1Id, data.strProduct1Pack, data.strProduct1Size, data.strProduct1Weight, data.strProduct1Price);
			//Select Supplier
			product().selectSupplier();
			generic().selectValueFromDropdown(data.strSupplierName,"Supplier "+data.strSupplierName+" is selected");
			//Select Expense Category
			product().tapExpenseCategoryNonSysco();
			generic().selectValueFromDropdown(data.strExpenseCategory,"Expense Category "+data.strExpenseCategory+" is selected");
			//tap done
			generic().tapDone();
			//verify location page is displayed
			//
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			generic().waitForPageToLoad(6);
			//Verify the newly added item is displayed in the locations page
			locations().verifyItemPresentInLocation(data.strProduct1Name,"Product Name",true);	
			
			//select an item which is available in one location
			locations().selectAnItemFromProductList(data.strProduct1Name);
			//click on edit
			generic().tapEdit();
			//verify the location of the item
			product().verifyLocationAfterEdit(data.strLocation1Name,0);
			//Verify there is an option to add another location
			product().tapOnAddAnotherLocation();
			//Verify a new row is created
			product().verifyNewLocationFields();
			product().tapLocationNonSysco("1");
			//verify the picker has only other locations to select
			generic().verifyValueInDropdown(data.strLocation2Name,"Location list",true);
			generic().verifyValueInDropdown(data.strLocation3Name,"Location list",true);
			generic().verifyValueInDropdown(data.strLocation1Name,"Location list",false);			
			//Add a new location for an item
			generic().selectValueFromDropdown(data.strLocation2Name,data.strLocation2Name+" is selected");
			//Click on done
			generic().tapDone();
			//tap on close
			generic().tapClose();
			//verify if item is added available in the current location
			locations().verifyItemPresentInLocation(data.strProduct1Name,"Product Name",true);		
			//tap back
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation2Name);
			//Verify the item is available in the newly added locations
			locations().verifyItemPresentInLocation(data.strProduct1Name,"Product Name",true);	
			//component().logoutFromInventoryList();
			generic().closeApp();
			}
		 
		 /******************************************************************************************
		  * Name : INV_MIL_020b_AddMultipleLocationsForPrep_CustomLocation
		  * 
		  * Description : Verify if user is able to add multiple locations to a same  prep item- for Default Location
		  * 		 
		  * Manual Test cases : INV_MIL_020
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 10/01/2016
		  * 
		  * Notes : NA
		  * 
		  * Test Data : uomautnu1/automate1
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"issue","ManageInventoryList_iOS1"}, description = "")
		 public void INV_MIL_020b_AddMultipleLocationsForPrep_CustomLocation(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up Inventory -  Can plug it in once the set inventory screens are stable
			//Set up inventory  - custom location
			component().setupInventorywithOGCustomLocDefaultCategorySingleLocationSelection(data.strLocation1Name+"/"+data.strLocation2Name+"/"+data.strLocation3Name, "COOLER/FREEZER/DRY",false);
			//strItemName - needs to be updated in the data sheet based on the user
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//Select Any one location - Freezer
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			// Tap + button
			generic().tapAddFromListPage();
			//verify Add item form is displayed
			locations().verifyAddItemFormPageDisplayed();
			//tap create Prep item
			locations().tapCreatePrepItem();
			//verify Add Product Page is displayed
			locations().verifyAddProductPageDisplayed();
			//Enter Mandatory fields
			product().enterPrepItemDetails(data.strProduct1Name, data.strProduct1NickName, data.strProduct1Id, data.strProduct1Pack, data.strProduct1Size, data.strProduct1Weight,data.strProduct1Price);
			//Select Expense Category
			product().tapExpenseCategoryPrep();
			generic().selectValueFromDropdown(data.strExpenseCategory,"Expense Category "+data.strExpenseCategory+" is selected");
			//tap done
			generic().tapDone();
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			generic().waitForPageToLoad(6);
			//Verify the newly added item is displayed in the locations page
			locations().verifyItemPresentInLocation(data.strProduct1Name,"Product Name",true);	
									
			//select an item which is available in one location
			locations().selectAnItemFromProductList(data.strProduct1Name);
			//click on edit
			generic().tapEdit();
			//verify the location of the item
			product().verifyLocationAfterEdit(data.strLocation1Name,0);
			//Verify there is an option to add another location
			product().tapOnAddAnotherLocation();
			//Verify a new row is created
			product().verifyNewLocationFields();
			product().tapLocation("1");
			//verify the picker has only other locations to select
			generic().verifyValueInDropdown(data.strLocation2Name,"Location list",true);
			generic().verifyValueInDropdown(data.strLocation3Name,"Location list",true);
			generic().verifyValueInDropdown(data.strLocation1Name,"Location list",false);			
			//Add a new location for an item
			generic().selectValueFromDropdown(data.strLocation2Name,data.strLocation2Name+" is selected");
			//Click on done
			generic().tapDone();
			//tap on close
			generic().tapClose();
			//verify if item is added available in the current location
			locations().verifyItemPresentInLocation(data.strProduct1Name,"Product Name",true);		
			//tap back
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation2Name);
			//Verify the item is available in the newly added locations
			locations().verifyItemPresentInLocation(data.strProduct1Name,"Product Name",true);	
			//component().logoutFromInventoryList();
			generic().closeApp();
			}
		 
		 /******************************************************************************************
		  * Name : INV_MIL_029_ChangeLocation_DefaultLocation
		  * 
		  * Description : Verify if user is able to change the location of the item	- for Default Location
		  * 		 
		  * Manual Test cases : INV_MIL_029
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 10/03/2016
		  * 
		  * Notes : NA
		  * 
		  * Test Data : uomautnu3/automate1
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageInventoryList","ManageInventoryList_iOS1"}, description = "Change Location")
		 public void INV_MIL_029_ChangeLocation_DefaultLocation(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up Inventory -  Can plug it in once the set inventory screens are stable
			//Set up inventory  - Default location
			component().setupInventorywithOGDefaultLocDefaultCat();
			//strItemName - needs to be updated in the data sheet based on the user
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//Select Any one location - Freezer
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//select an item which is available in one location
			locations().selectAnItemFromProductList(data.strItem1Name);
			//click on edit
			generic().tapEdit();
			//verify the location of the item
			product().verifyLocationAfterEdit(data.strLocation1Name,0);
			product().tapLocation("0");
			//verify the picker has only other locations to select
			generic().verifyValueInDropdown(data.strLocation2Name,"Location list",true);
			generic().verifyValueInDropdown(data.strLocation3Name,"Location list",true);
			generic().verifyValueInDropdown(data.strLocation1Name,"Location list",true);			
			//Add a new location for an item
			generic().selectValueFromDropdown(data.strLocation2Name,data.strLocation2Name+" is selected");
			//verify the location of the item
			product().verifyLocationAfterEdit(data.strLocation2Name,0);
			//Click on done
			generic().tapDone();
			//tap on close
			generic().tapClose();
			//verify if item is added available in the current location
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",false);		
			//tap back
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation2Name);
			//Verify the item is available in the newly added locations
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);		
			//component().logoutFromInventoryList();
			generic().closeApp();
			}
		 
		 /******************************************************************************************
		  * Name : INV_MIL_030_ChangeLocation_CustomLocation
		  * 
		  * Description : Verify if user is able to change the location of the item	- for Default Location
		  * 		 
		  * Manual Test cases : INV_MIL_030
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 10/03/2016
		  * 
		  * Notes : NA
		  * 
		  * Test Data : uomautnu3/automate1
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageInventoryList","ManageInventoryList_iOS1"}, description = "Change Location")
		 public void INV_MIL_030_ChangeLocation_CustomLocation(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up Inventory -  Can plug it in once the set inventory screens are stable
			//Set up inventory  - Custom location
			component().setupInventorywithOGCustomLocDefaultCategorySingleLocationSelection(data.strLocation1Name+"/"+data.strLocation2Name+"/"+data.strLocation3Name, "COOLER/FREEZER/DRY",false);
			//strItemName - needs to be updated in the data sheet based on the user
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//Select Any one location - Freezer
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//select an item which is available in one location
			locations().selectAnItemFromProductList(data.strItem1Name);
			//click on edit
			generic().tapEdit();
			//verify the location of the item
			product().verifyLocationAfterEdit(data.strLocation1Name,0);
			product().tapLocation("0");
			//verify the picker has only other locations to select
			generic().verifyValueInDropdown(data.strLocation2Name,"Location list",true);
			generic().verifyValueInDropdown(data.strLocation3Name,"Location list",true);
			generic().verifyValueInDropdown(data.strLocation1Name,"Location list",true);			
			//Add a new location for an item
			generic().selectValueFromDropdown(data.strLocation2Name,data.strLocation2Name+" is selected");
			//verify the location of the item
			product().verifyLocationAfterEdit(data.strLocation2Name,0);
			//Click on done
			generic().tapDone();
			//tap on close
			generic().tapClose();
			//verify if item is added available in the current location
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",false);		
			//tap back
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation2Name);
			//Verify the item is available in the newly added locations
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);	
			//component().logoutFromInventoryList();
			generic().closeApp();
			}
		 
		 /******************************************************************************************
		  * Name : INV_MIL_032_028_ChangeCategory_DefaultLocation_DefaultCategory
		  * 
		  * Description : Verify if user is able to change the Category of the item	- for DefaultLocation, DefaultCategory
		  * 		 
		  * Manual Test cases : INV_MIL_030,INV_MIL_028
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 10/03/2016
		  * 
		  * Notes : NA
		  * 
		  * Test Data : uomautnu3/automate1
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageInventoryList","ManageInventoryList_iOS1"}, description = "Change Location")
		 public void INV_MIL_032_028_ChangeCategory_DefaultLocation_DefaultCategory(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up Inventory -  Can plug it in once the set inventory screens are stable
			//Set up inventory  - Default location
			component().setupInventorywithOGDefaultLocDefaultCat();
			//strItemName - needs to be updated in the data sheet based on the user
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//verify default locations
			locations().verifyDefaultLocations();
			//Select Any one location - Freezer
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//select an item which is available in one location
			locations().selectAnItemFromProductList(data.strItem1Name);
			//click on edit
			generic().tapEdit();
			//verify the expense category of the item
			product().verifyExpenseCategoryAfterEdit(data.strExpenseCategory);
			product().tapExpenseCategory();
			//verify the picker has only other exp cat to select
			generic().verifyValueInDropdown(data.strExpenseCategory,"Expense Category list",true);
			generic().verifyValueInDropdown(data.strExpenseCategory2,"Expense Category list",true);
			//Add a different expense category for an item
			generic().selectValueFromDropdown(data.strExpenseCategory2,data.strExpenseCategory2+" is selected");
			//verify the expense category of the item
			product().verifyExpenseCategoryAfterEdit(data.strExpenseCategory2);
			//Click on done
			generic().tapDone();
			//tap on close
			generic().tapClose();
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//verify if item is added available in the current location
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);		
			//Verify the expense category 
			locations().verifyExpenseCategory(data.strItem1Name, data.strExpenseCategory2,true);
			//Verify the expense category 
			locations().verifyExpenseCategory(data.strItem1Name, data.strExpenseCategory,false);
			//component().logoutFromInventoryList();
			generic().closeApp();
			}
		 
		 /******************************************************************************************
		  * Name : INV_MIL_004_005_AddItem_ProductCatalog_SharedList_DefaultCategory
		  * 
		  * Description : Verify if the user is able to add item from Product Catalog and shared list - for default Location
		  * 		 
		  * Manual Test cases : INV_MIL_004,INV_MIL_005
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 10/05/2016
		  * 
		  * Notes : NA
		  * 
		  * Test Data : uomautnu6/automate1
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageInventoryList","ManageInventoryList_iOS1"}, description = "Add Item - Product Catalog and Shared List")
		 public void INV_MIL_004_005_AddItem_ProductCatalog_SharedList_DefaultLocation(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up Inventory -  Can plug it in once the set inventory screens are stable
			component().setupInventorywithOGDefaultLocDefaultCat();		
			//strItemName - needs to be updated in the data sheet based on the user
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//Select Any one location - Freezer
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			
			//Add item from shared list -eSYSCO_OG_056_104166
			// Tap + button
			generic().tapAddFromListPage();
			//verify Add item form is displayed
			locations().verifyAddItemFormPageDisplayed();
			//tap on add from Custom List
			locations().tapAddItemFromCustomList();
			//Verify SelectList Page is displayed
			locations().verifySelectPage();
			//select a shared list 
			locations().selectCustomList(data.strListName1);
			//verify Add Custom List page is displayed
			locations().verifyAddCustomListPage();
			//Select an item
			locations().selectAnItemWithIndexFromList("1","true","upcid");
			//Click on Done
			generic().tapDone();
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//Verify the newly added item is displayed in the locations page
			locations().verifyItemPresentInLocation(data.strItem1Name,"UPCID",true,"true");		
			
			//Add from Product Catalog
			// Tap + button
			generic().tapAddFromListPage();
			//verify Add item form is displayed
			locations().verifyAddItemFormPageDisplayed();
			//search for chicken
			locations().searchItemInAddItemForm("Chicken");
			locations().tapAddItemForm();
			//Select an item
			locations().selectAnItemWithName(data.strItem2Name);
			//tap done
			generic().tapDone(false);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//Verify the newly added item is displayed in the locations page
			locations().verifyItemPresentInLocation(data.strItem2Name,"Product Name",true);	
			
			//component().logoutFromInventoryList();
			generic().closeApp();
			
		 }
		 
		 /******************************************************************************************
		  * Name : INV_MIL_013_014_AddItem_ProductCatalog_SharedList_DefaultCategory
		  * 
		  * Description : Verify if the user is able to add item from Product Catalog and shared list - for default Location
		  * 		 
		  * Manual Test cases : INV_MIL_013,INV_MIL_014
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 10/05/2016
		  * 
		  * Notes : NA
		  * 
		  * Test Data : uomautnu6/automate1
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageInventoryList","ManageInventoryList_iOS2"}, description = "Add Item - Product Catalog and Shared List")
		 public void INV_MIL_013_014_AddItem_ProductCatalog_SharedList_CustomLocation(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up inventory  - Custom location
			component().setupInventorywithOGCustomLocationDefaultCategory();	
			//strItemName - needs to be updated in the data sheet based on the user
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//Select Any one location - Freezer
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			
			//Add item from shared list -eSYSCO_OG_056_104166
			// Tap + button
			generic().tapAddFromListPage();
			//verify Add item form is displayed
			locations().verifyAddItemFormPageDisplayed();
			//tap on add from Custom List
			locations().tapAddItemFromCustomList();
			//Verify SelectList Page is displayed
			locations().verifySelectPage();
			//select a shared list 
			locations().selectCustomList(data.strListName1);
			//verify Add Custom List page is displayed
			locations().verifyAddCustomListPage();
			//Select an item
			locations().selectAnItemWithIndexFromList("1","true","upcid");
			//locations().selectAnItemWithName(data.strItem1Name);
			//Click on Done
			generic().tapDone();
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//Verify the newly added item is displayed in the locations page
			//locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);		
			locations().verifyItemPresentInLocation(data.strItem1Name,"UPCID",true,"true");			
			//Add from Product Catalog
			// Tap + button
			generic().tapAddFromListPage();
			//verify Add item form is displayed
			locations().verifyAddItemFormPageDisplayed();
			//search for chicken
			locations().searchItemInAddItemForm("Chicken");
			locations().tapAddItemForm();
			//Select an item
			locations().selectAnItemWithName(data.strItem2Name);
			//tap done
			generic().tapDone(false);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//Verify the newly added item is displayed in the locations page

			locations().verifyItemPresentInLocation(data.strItem2Name,"Product Name",true);	
			//close application
			generic().closeApp();
	
	 }
		 
		 /******************************************************************************************
		  * Name : INV_MIL_031_33_ChangeLocation_ChangeExpense_CustomLocation
		  * 
		  * Description : Verify if user is able to add multiple locations to a same item- for Custom Location
		  * 		 
		  * Manual Test cases : INV_MIL_031,INV_MIL_033 Pre Req : INV SI 003
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 9/29/2016
		  * 
		  * Notes : NA
		  * 
		  * Test Data : uomautnu4/automate1
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageInventoryList","ManageInventoryList_iOS2"}, description = "Add items to multiple location")
		 public void INV_MIL_031_033_ChangeLocation_ChangeExpense_CustomLocation(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up Inventory -  Can plug it in once the set inventory screens are stable
			//Set up inventory  - 3 Custom location
			component().setupInventorywithOGCustomLocDefaultCatMultipleLocation(data.strLocationNames,data.strLocationTypes, data.strAssignLocations,false,false);
			//strItemName - needs to be updated in the data sheet based on the user
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//Select Any one location - Freezer
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//select an item which is available in one location
			locations().selectAnItemFromProductList(data.strItem1Name);
			//click on edit
			generic().tapEdit();
			//verify the location of the item
			product().verifyLocationAfterEdit(data.strLocation1Name,0);
			//tap on the location
			product().tapLocation("0");
			//verify the picker has only other locations to select
			generic().verifyValueInDropdown(data.strLocation2Name,"Location list",true);
			generic().verifyValueInDropdown(data.strLocation1Name,"Location list",true);
			generic().verifyValueInDropdown(data.strLocation3Name,"Location list",false);	
			//Update the location
			generic().selectValueFromDropdown(data.strLocation2Name,data.strLocation2Name+" is selected");
			//Click on done
			generic().tapDone();
			//tap on close
			generic().tapClose();
			//Verify item not available in the current location
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",false);		
			//Verify item is available in the other 2 locations
			//tap back
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation2Name);
			//Verify the item is available in the newly added locations
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);		
			//tap back
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation3Name);
			//Verify the item is available in the newly added locations
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);		
			//Go to the product card page of item 1
			locations().selectAnItemFromProductList(data.strItem1Name);
			//click on edit
			generic().tapEdit();		
			//Update the expense category
			product().tapExpenseCategory();
			//verify the picker has only other locations to select
			generic().verifyValueInDropdown(data.strExpenseCategory,"Expense Category list",true);
			generic().verifyValueInDropdown(data.strExpenseCategory2,"Expense Category list",true);
			//Add a different expense category for an item
			generic().selectValueFromDropdown(data.strExpenseCategory2,data.strExpenseCategory2+" is selected");
			//verify the expense category of the item
			product().verifyExpenseCategoryAfterEdit(data.strExpenseCategory2);
			//Click on done
			generic().tapDone();
			//tap on close
			generic().tapClose();
			//Verify expense category is updated for the item in the location page
			locations().verifyExpenseCategory(data.strItem1Name, data.strExpenseCategory2,true);
			//tap back
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation2Name);
			//Verify expense category is updated for the item in the loc2 
			locations().verifyExpenseCategory(data.strItem1Name, data.strExpenseCategory2,true);
			//component().logoutFromInventoryList();
			generic().closeApp();
			}
		 /******************************************************************************************
		  * Name : INV_MIL_026_ManageLocation_AddNewLocations
		  * 
		  * Description : Verify that user is able to assign items to multiple location which are created from manage location screen
		  * 
		  * Manual Test cases : INV_MIL_026
		  * 
		  * Author : Parvathy
		  * 
		  * Date : 10/12/2016
		  * 
		  * Notes : 
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 

		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageInventoryList","ManageInventoryList_iOS1"}, description = "Assign mutliple location - Manage Location flow")
		 public void INV_MIL_026_ManageLocation_AddNewLocations(ManageInventoryListObject data) throws Exception {	 
			
			 //Login to app
			 component().login(data.strUserName, data.strPassword);
			 //Set up Inventory - INV_SI_001 -  Can plug it in once the set inventory screens are stable		 
			 // Setup OG+Default Loc + Default Cat
			 component().setupInventorywithOGDefaultLocDefaultCat();
			 //Create location 1
			 component().createLocationFromManageLocation(data.strLocation2Name, data.strLocation1Type);
			 //Create location 2
			 component().createLocationFromManageLocation(data.strLocation3Name, data.strLocation2Type);
			 //navigate to track inventory
			 home().tapTrackInventory();
			 //verify locations page is displayed
			 locations().verifyLocationsPage();
			//tap on any location
			 locations().tapLocation(data.strLocation1Name);
			 //verify location page is displayed
			 locations().verifyLocationPage(data.strLocation1Name);
			 //Tap on any item and navigate to product card details page
			 locations().selectAnItemFromProductList(data.strItem1Name);
			 //verify product details page is loaded
			 product().verifyProductDetailsPage();
			//click on edit
			generic().tapEdit();
			//Verify there is an option to add another location
			product().tapOnAddAnotherLocation();
			//Verify a new row is created
			product().verifyNewLocationFields();
			product().tapLocation("1");
			//verify the picker has only other locations to select
			generic().verifyValueInDropdown(data.strLocation2Name,"Location list",true);
			generic().verifyValueInDropdown(data.strLocation3Name,"Location list",true);
			//Add a new location for an item
			generic().selectValueFromDropdown(data.strLocation2Name,data.strLocation2Name+" is selected");
			
			
			
			//Verify there is an option to add another location
			product().tapOnAddAnotherLocation();
			//Verify a new row is created
			product().verifyNewLocationFields();
			product().tapLocation("2");
			//verify the picker has only other locations to select
			generic().verifyValueInDropdown(data.strLocation2Name,"Location list",false);
			generic().verifyValueInDropdown(data.strLocation3Name,"Location list",true);
			//Add a new location for an item
			generic().selectValueFromDropdown(data.strLocation3Name,data.strLocation3Name+" is selected");
			
			
			//Click on done
			generic().tapDone();
			//tap on close
			generic().tapClose();
			//tap back
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation2Name);
			//verify location page is displayed
			 locations().verifyLocationPage(data.strLocation2Name);
			//verify if item is added available in the current location
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);		
			//tap back
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation3Name);
			//verify location page is displayed
			 locations().verifyLocationPage(data.strLocation3Name);
			//Verify the item is available in the newly added locations
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);		
			 
			//component().logoutFromInventoryList();	
			 //close app
			 generic().closeApp();
		 }
		 
		 /******************************************************************************************
		  * Name : INV_MIL_027_ManageLocation_AddNewLocationsUOMQuantity
		  * 
		  * Description : Verify that user is able to assign items to multiple location,UOM and Quantity which are created from manage location screen
		  * 
		  * Manual Test cases : INV_MIL_027
		  * 
		  * Author : Parvathy
		  * 
		  * Date : 10/12/2016
		  * 
		  * Notes : 
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 

		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageInventoryList","ManageInventoryList_iOS2","Rerun1","retry123"}, description = "Assign mutliple location - Manage Location flow")
		 public void INV_MIL_027_ManageLocation_AddNewLocationsUOMQuantity(ManageInventoryListObject data) throws Exception {	 
			
			 //Login to app
			 component().login(data.strUserName, data.strPassword);
			 //Set up Inventory - INV_SI_001 -  Can plug it in once the set inventory screens are stable		 
			 // Setup OG+Default Loc + Default Cat
			 component().setupInventorywithOGDefaultLocDefaultCat();
			 //Create location 1
			 component().createLocationFromManageLocation(data.strLocation2Name, data.strLocation1Type);
			 //Create location 2
			 component().createLocationFromManageLocation(data.strLocation3Name, data.strLocation2Type);
			 //navigate to track inventory
			 home().tapTrackInventory();
			 //verify locations page is displayed
			 locations().verifyLocationsPage();
			//tap on any location
			 locations().tapLocation(data.strLocation1Name);
			 //verify location page is displayed
			locations().verifyLocationPage(data.strLocation1Name);
			 //Tap on any item and navigate to product card details page
			 locations().selectAnItemFromProductList(data.strProduct1Name);
			 //verify product details page is loaded
			 product().verifyProductDetailsPage();
			//click on edit
			generic().tapEdit();
			//Verify there is an option to add another location
			product().tapOnAddAnotherLocation();
			//Verify a new row is created
			product().verifyNewLocationFields();
			product().tapLocation("1");
			//Add a new location for an item
			generic().selectValueFromDropdown(data.strLocation2Name,data.strLocation2Name+" is selected");
			
			//Select UOM
			product().selectLocationQuantityUOM(data.strItem1UOM, "2");
			//Set Quantity
			product().enterLocationQuantity(data.strItem1Qty, "2");
			
			//Verify there is an option to add another location
			product().tapOnAddAnotherLocation();
			//Verify a new row is created
			product().verifyNewLocationFields();
			product().tapLocation("2");
			//Add a new location for an item
			generic().selectValueFromDropdown(data.strLocation3Name,data.strLocation3Name+" is selected");
			//Select UOM
			product().selectLocationQuantityUOM(data.strItem1UOM, "3");
			//Set Quantity
			product().enterLocationQuantity(data.strItem1Qty, "3");			
			//Click on done
			generic().tapDone();
			//tap on close
			generic().tapClose();
			//tap back
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation2Name);
			//verify location page is displayed
			 locations().verifyLocationPage(data.strLocation2Name);
			//verify if item is added available in the current location
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);		
			
			//verify UOM and quantity
			locations().verifyQuantityAndUOMAttributeWithItemName(data.strItem1Name, data.strItem1Qty, data.strItem1UOM);
			//tap back
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation3Name);
			//verify location page is displayed
			 locations().verifyLocationPage(data.strLocation3Name);
			//Verify the item is available in the newly added locations
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);		
			//component().logoutFromInventoryList();
			 //close app
			 generic().closeApp();
		 }
		 
		 /******************************************************************************************
		  * Name : INV_MIL_034_ChangeCategory_Suggested8
		  * 
		  * Description : Verify if user is able to change the Category of the item	- Suggested 8 
		  * 		 
		  * Manual Test cases : INV_MIL_034; Pre requisite : INV_SI_004
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 10//2016
		  * 
		  * Notes : NA
		  * 
		  * Test Data : uomautnu3/automate1
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageInventoryList","ManageInventoryList_iOS1"}, description = "Change Location")
		 public void INV_MIL_034_ChangeCategory_Suggested8(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up inventory  - Suggested Category
			component().setupInventorywithOGDefaultLocSugg12Cat();
			//strItemName - needs to be updated in the data sheet based on the user
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//verify default locations
			//locations().verifyDefaultLocations();
			//Select Any one location - Freezer
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//select an item which is available in one location
			locations().selectAnItemFromProductList(data.strItem1Name);
			//click on edit
			generic().tapEdit();
			//verify the expense category of the item
			product().verifyExpenseCategoryAfterEdit(data.strExpenseCategory);
			product().tapExpenseCategory();
			//verify the picker has only other locations to select
			product().verifySuggested8Categories();
			//Add a different expense category for an item
			generic().selectValueFromDropdown(data.strExpenseCategory2,data.strExpenseCategory2+" is selected");
			//verify the expense category of the item
			product().verifyExpenseCategoryAfterEdit(data.strExpenseCategory2);
			//Click on done
			generic().tapDone();
			//tap on close
			generic().tapClose();
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//verify if item is added available in the current location
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);		
			//Verify the expense category 
			locations().verifyExpenseCategory(data.strItem1Name, data.strExpenseCategory2,true);
			//Verify the expense category 
			locations().verifyExpenseCategory(data.strItem1Name, data.strExpenseCategory,false);
			//component().logoutFromInventoryList();
			generic().closeApp();
			}
		 /******************************************************************************************
		  * Name : INV_MIL_035_ChangeCategory_CustomCategory
		  * 
		  * Description : Verify if user is able to change the Category of the item	- Custom Category
		  * 		 
		  * Manual Test cases : INV_MIL_035; Pre requisite : INV_SI_005
		  * 
		  * Author : Parvathy P
		  * 
		  * Date : 10/13/2016
		  * 
		  * Notes : NA
		  * 
		  * Test Data : uomautnu6/automate1
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageInventoryList","ManageInventoryList_iOS1"}, description = "Change Category")
		 public void INV_MIL_035_ChangeCategory_CustomCategory(ManageInventoryListObject data) throws Exception {	
			 
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Set up inventory  - Custom Category
			component().setupInventorywithOGDefaultLocCustomCategory(data.strCategoryNames,data.strCategoryTypes);
			//strItemName - needs to be updated in the data sheet based on the user
			//Tap Track Inventory 
			home().tapTrackInventory();
			//verify location list page is displayed
			locations().verifyLocationsPage();
			//verify default locations
			//locations().verifyDefaultLocations();
			//Select Any one location - Freezer
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//select an item which is available in one location
			locations().selectAnItemFromProductList(data.strItem1Name);
			//click on edit
			generic().tapEdit();
			//verify the expense category of the item
			product().verifyExpenseCategoryAfterEdit(data.strExpenseCategory);
			product().tapExpenseCategory();
			//verify the picker has only other exp category to select
			generic().verifyValueInDropdown(data.strExpenseCategory,"Expense Category list",true);
			generic().verifyValueInDropdown(data.strExpenseCategory2,"Expense Category list",true);
			//Add a different expense category for an item
			generic().selectValueFromDropdown(data.strExpenseCategory2,data.strExpenseCategory2+" is selected");
			//verify the expense category of the item
			product().verifyExpenseCategoryAfterEdit(data.strExpenseCategory2);
			//Click on done
			generic().tapDone();
			//tap on close
			generic().tapClose();
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//verify if item is added available in the current location
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);		
			//Verify the expense category 
			locations().verifyExpenseCategory(data.strItem1Name, data.strExpenseCategory2,true);
			//Verify the expense category 
			locations().verifyExpenseCategory(data.strItem1Name, data.strExpenseCategory,false);
			//component().logoutFromInventoryList();
			generic().closeApp();
			}
		 
		 /******************************************************************************************
		  * Name : INV_MIL_039_AddNewLocationsUOMQuantity_CustomLocation
		  * 
		  * Description : Verify that user is able to assign items to multiple location,UOM and Quantity -Custom Location
		  * 
		  * Manual Test cases : INV_MIL_039
		  * 
		  * Author : Parvathy
		  * 
		  * Date : 10/13/2016
		  * 
		  * Notes : 
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 

		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageInventoryList","ManageInventoryList_iOS2","Rerun1"}, description = "Assign mutliple location - Manage Location flow")
		 public void INV_MIL_039_AddNewLocationsUOMQuantity_CustomLocation(ManageInventoryListObject data) throws Exception {	 
			
			 //Login to app
			 component().login(data.strUserName, data.strPassword);
			 // Setup OG+Custom Loc + Default Cat
			component().setupInventorywithOGCustomLocationDefaultCategory();
			//navigate to track inventory
			home().tapTrackInventory();
			 //verify locations page is displayed
			 locations().verifyLocationsPage();
			//tap on any location
			 locations().tapLocation(data.strLocation1Name);
			 //verify location page is displayed
			locations().verifyLocationPage(data.strLocation1Name);
			 //Tap on any item and navigate to product card details page
			 locations().selectAnItemWithIndex("1","true");
			 //verify product details page is loaded
			 product().verifyProductDetailsPage();
			//click on edit
			generic().tapEdit();
			//Verify there is an option to add another location
			product().tapOnAddAnotherLocation();
			//Verify a new row is created
			product().verifyNewLocationFields();
			product().tapLocation("1");
			//Add a new location for an item
			generic().selectValueFromDropdown(data.strLocation2Name,data.strLocation2Name+" is selected");
			
			//Select UOM
			product().selectLocationQuantityUOM(data.strItem1UOM, "2");
			//Set Quantity
			product().enterLocationQuantity(data.strItem1Qty, "2");
			
			//Verify there is an option to add another location
			product().tapOnAddAnotherLocation();
			//Verify a new row is created
			product().verifyNewLocationFields();
			product().tapLocation("2");
			//Add a new location for an item
			generic().selectValueFromDropdown(data.strLocation3Name,data.strLocation3Name+" is selected");
			//Select UOM
			product().selectLocationQuantityUOM(data.strItem1UOM, "3");
			//Set Quantity
			product().enterLocationQuantity(data.strItem1Qty, "3");			
			//Click on done
			generic().tapDone();
			//tap on close
			generic().tapClose();
			//tap back
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation2Name);
			//verify location page is displayed
			 locations().verifyLocationPage(data.strLocation2Name);
			//verify if item is added available in the current location
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true,"true");		
			
			//verify UOM and quantity
			locations().verifyQuantityAndUOMAttributeWithItemName(data.strItem1Name, data.strItem1Qty, data.strItem1UOM,"true");
				
			//tap back
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation3Name);
			//verify location page is displayed
			 locations().verifyLocationPage(data.strLocation3Name);
			//Verify the item is available in the newly added locations
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true,"true");		
			//verify UOM and quantity
			locations().verifyQuantityAndUOMAttributeWithItemName(data.strItem1Name, data.strItem1Qty, data.strItem1UOM,"true");
			//component().logoutFromInventoryList();		
			 //close app
			 generic().closeApp();
		 }

		 
		 /******************************************************************************************
		  * Name : INV_MIL_036_AddNewLocations_CustomLocationAsCategories
		  * 
		  * Description : Verify that user is able to assign items to multiple location,UOM and Quantity -Custom Location
		  * 
		  * Manual Test cases : INV_MIL_036, SI007
		  * 
		  * Author : Parvathy
		  * 
		  * Date : 10/18/2016
		  * 
		  * Notes : uomautnu32/automate1~Tightly coupled with user. Specific setup done in SMX for this
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 

		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageInventoryList","ManageInventoryList_iOS1"}, description = "Assign mutliple location - Manage Location flow")
		 public void INV_MIL_036_AddNewLocations_CustomLocationAsCategories(ManageInventoryListObject data) throws Exception {	 
			
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//CustomList > Custom Categories and Location > Default cat
			component().setupInventorywithCustomListCustCatAsLocationDefaultCat(data.strListName1);
			//navigate to track inventory
			home().tapTrackInventory();
			//verify locations page is displayed
			locations().verifyLocationsPage();
			//verify custom locations
			locations().verifyLocationInListMultipleLocation(data.strAssignLocations);			
			//tap on any location
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPage(data.strLocation1Name);
			//Tap on any item and navigate to product card details page
			locations().selectAnItemFromProductList(data.strItem1Name);
			//verify product details page is loaded
			product().verifyProductDetailsPage();
			//click on edit
			generic().tapEdit();
			product().tapLocation("0");
			//Add a new location for an item
			generic().selectValueFromDropdown(data.strLocation2Name,data.strLocation2Name+" is selected");
			generic().tapDone();
			//tap on close
			generic().tapClose();
			//verify location page is displayed
			 locations().verifyLocationPage(data.strLocation1Name);
			//verify if item is not available in the current location
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",false);		
			//tap back
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation2Name);
			//verify location page is displayed
			 locations().verifyLocationPage(data.strLocation2Name);
			//Verify the item is available in the newly added locations
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);	
			//component().logoutFromInventoryList();
			 //close app
			 generic().closeApp();
		 }


		 /******************************************************************************************
		  * Name : INV_MIL_037_AddNewLocations_LocationNameAsListName
		  * 
		  * Description : Verify that user is able to change location	 - for SI_009
		  * 
		  * Manual Test cases : INV_MIL_037, SI009
		  * 
		  * Author : Parvathy
		  * 
		  * Date : 10/18/2016
		  * 
		  * Notes : uomautnu32/automate1 ~Tightly coupled with user. Specific setup done in SMX for this
		  * 
		  * Modification Log
		  * Date						Author						Description
		  * -----------------------------------------------------------------------------------------
		  *  
		  ******************************************************************************************/
		 

		 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageInventoryList","ManageInventoryList_iOS1","Rerun1"}, description = "Change Location")
		 public void INV_MIL_037_AddNewLocations_LocationNameAsListName(ManageInventoryListObject data) throws Exception {	 
			
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//Multiple List > Location name as list names
			component().setupInventorywithMulCustListDefLocDefCatItemInMultipeLoc("List1","List2","List3","List4");
			//navigate to track inventory
			home().tapTrackInventory();
			//verify locations page is displayed
			locations().verifyLocationsPage();
			//verify custom locations
			locations().verifyLocationInListMultipleLocation(data.strAssignLocations);			
			//tap on any location
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPage(data.strLocation1Name);
			//Tap on any item and navigate to product card details page
			locations().selectAnItemFromProductList(data.strItem1Name);
			//verify product details page is loaded
			product().verifyProductDetailsPage();
			//click on edit
			generic().tapEdit();
			product().tapLocation("0");
			//Add a new location for an item
			generic().selectValueFromDropdown(data.strLocation2Name,data.strLocation2Name+" is selected");
			product().tapLocation("1");
			//Add a new location for an item
			generic().selectValueFromDropdown(data.strLocation3Name,data.strLocation3Name+" is selected");
			generic().tapDone();
			//tap on close
			generic().tapClose();
			//verify location page is displayed
			 locations().verifyLocationPage(data.strLocation1Name);
			//verify if item is not available in the current location
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",false);		
			//tap back
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation2Name);
			//verify location page is displayed
			 locations().verifyLocationPage(data.strLocation2Name);
			//Verify the item is available in the newly added locations
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);	
			//tap back
			generic().tapBack();
			//Select newly added location
			locations().tapLocation(data.strLocation3Name);
			//verify location page is displayed
			 locations().verifyLocationPage(data.strLocation3Name);
			//Verify the item is available in the newly added locations
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);	
			//component().logoutFromInventoryList();
			 //close app
			 generic().closeApp();
		 }
		 
		 /******************************************************************************************
			* Name : INV_MIL_040_Validate_cake_description_in_MIL_pdt_card_add_from_custom_list
			* 
			* Description : Verify cake description of an item in Track inventory list, product card and add from custom list 
			* 
			* Manual Test cases : 
			* 
			* Author : Reshma S Farook
			* 
			* Date : 10.21.2016
			* 
			* Notes : Precondition - setupInventorywithCustomListDefLocDefCat
			* 
			* Modification Log
			* Date Author Description
			* -----------------------------------------------------------------------------------------
			*  
			******************************************************************************************/
			@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Defect"}, description = "Verify cake description of an item in Track inventory list, product card and add from custom list)")
			public void INV_MIL_040_Validate_cake_description_in_MIL_pdt_card_add_from_custom_list (ManageInventoryListObject data) throws Exception {  
			
			//SETUP+TRACK INVENTORY VALIDATION
			//Login to app
			component().login(data.strUserName, data.strPassword);
			//setup inventory - Custom list + Def Location + Def Category
			component().setupInventorywithCustomListDefLocDefCat(data.strListName1);
			//navigate to track inventory
			home().tapTrackInventory();
			//verify locations page is displayed
			locations().verifyLocationsPage(); 
			//tap on a location
			locations().tapLocation(data.strLocation1Name);
			//verify location page is displayed
			locations().verifyLocationPage(data.strLocation1Name);				
			
			//ADDITION OF ITEM ALREADY PRESENT IN THE LOCATION SELECTED VIA ADD FROM CUSTOM LIST AND VERIFICATION OF THE CAKE DESCRIPTION IN THE ADD FROM PRODUCT LISTS
			//INV_MIL_040
			// Tap + button
			generic().tapAddFromListPage();
			//verify Add item form is displayed
			locations().verifyAddItemFormPageDisplayed();
			//tap on add from Custom List
			locations().tapAddItemFromCustomList();
			//Verify SelectList Page is displayed
			locations().verifySelectPage();
			//select a list
			locations().selectCustomList(data.strListName1);
			//verify Add Custom List page is displayed
			locations().verifyAddCustomListPage();
			//Verify cake description and select an item
			locations().verifyCakeDescOfItemSelectedFromAddCustomList(data.strItem1Name);
			//Click on Done
			generic().tapDone();
			
			//VERIFICATION OF THE CAKE DESCRIPTION IN THE PRODUCT LIST VIEW, PRODUCT CARD DETAILS AND THE PRODUCT NAME LISTED WHILE ADDING FROM CUSTOM LIST
			//verify location page is displayed
			locations().verifyLocationPageDisplayed(data.strLocation1Name);
			//Verify the newly added item is displayed in the locations page
			locations().verifyItemPresentInLocation(data.strItem1Name,"Product Name",true);
			//click on item newly added
			locations().selectAnItemFromProductList(data.strItem1Name);	
			product().verifyProductDetails(data.strItem1Name,"","","","","","","",new String[0],new String[0],new String[0]);
			component().logoutFromProductDetailsPage();
			//close app
			 generic().closeApp();		 
			
		 }
			
			
			/******************************************************************************************
			* Name : INV_MIL_041_Validate_whether_user_can_add_item_to_same_location_more_than_once_custom_list
			* 
			* Description : Verify whether a user can add an item to the same location more than once via add from custom list.
			* 
			* Manual Test cases : 
			* 
			* Author : Reshma S Farook
			* 
			* Date : 10.21.2016
			* 
			* Notes : Precondition - setupInventorywithCustomListDefLocDefCat
			* 
			* Modification Log
			* Date Author Description
			* -----------------------------------------------------------------------------------------
			*  
			******************************************************************************************/
			@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Defect"}, description = "Verify whether a user can add an item to the same more than once via add from custom list)")
			public void INV_MIL_041_Validate_whether_user_can_add_item_to_same_location_more_than_once_custom_list (ManageInventoryListObject data) throws Exception {  
				 
				//SETUP+TRACK INVENTORY VALIDATION
				 //Login to app
				 component().login(data.strUserName, data.strPassword);
				 //setup inventory - Custom list + Def Location + Def Category
				 component().setupInventorywithCustomListDefLocDefCat(data.strListName1);
				 //navigate to track inventory
				 home().tapTrackInventory();
				 //verify locations page is displayed
				 locations().verifyLocationsPage(); 
				 //tap on a location
				 locations().tapLocation(data.strLocation1Name);
				 //verify location page is displayed
				 locations().verifyLocationPage(data.strLocation1Name);	
				 //validating items in location after setup inventory 
				 locations().verifyWhetherItemInLocation(data.strLocation1Name,data.strItemUPCID,"UPCID",true);
				 
				//ADDITION OF ITEM ALREADY PRESENT IN THE LOCATION SELECTED VIA ADD FROM CUSTOM LIST
				 //INV_MIL_041
				 //Tap + button
				 generic().tapAddFromListPage();
				 //verify Add item form is displayed
				 locations().verifyAddItemFormPageDisplayed();
				 //tap on add from Custom List
				 locations().tapAddItemFromCustomList();
				 //Verify SelectList Page is displayed
				 locations().verifySelectPage();
				 //select a list
				 locations().selectCustomList(data.strListName1);
				 //verify Add Custom List page is displayed
				 locations().verifyAddCustomListPage();
				 //Verify cake description and select an item
				 locations().verifyCakeDescOfItemSelectedFromAddCustomList(data.strItem2Name);
				 //Click on Done
				 generic().tapDone();
				 
				 //VALIDATING WHETHER A USER IS ALLOWED TO ADD AN ITEM MORE THAN ONCE TO THE SAME LOCATION AND VERIFICATION OF THE CAKE DESCRIPTION IN THE ADD FROM PRODUCT LISTS
				 //verify location page is displayed
				 locations().verifyLocationPageDisplayed(data.strLocation1Name);
				 //Verify the newly added item is displayed in the locations page
				 locations().verifyItemPresentInLocation(data.strItem2Name,"Product Name",true);
				 //validating items in location same item which is already present in the location is added again - verifying duplication
				 locations().verifyWhetherItemInLocation(data.strLocation1Name,data.strItemUPCID,"UPCID",true);
				 //click on item newly added
				 locations().selectAnItemFromProductList(data.strItem2Name);	
				 //verify product name of the newly created item
				 product().verifyProductDetails(data.strItem2Name,"","","","","","","",new String[0],new String[0],new String[0]);
				 //verify whether user is able to add an item to a location more than once
	     		 locations().verifyDuplicationLoc(data.strLocation1Name,data.strItem2Name);
	     		component().logoutFromProductDetailsPage();
	     		 //close app
				 generic().closeApp();
			
			}
			
			
			/******************************************************************************************
			* Name : INV_MIL_042_Validate_whether_user_can_add_item_to_same_location_more_than_once_order_guide
			* 
			* Description : Verify whether a user can add an item to the same location more than once via add from order guide.
			* 
			* Manual Test cases : 
			* 
			* Author : Reshma S Farook
			* 
			* Date : 10.21.2016
			* 
			* Notes : Precondition - setupInventorywithCustomListDefLocDefCat
			* 
			* Modification Log
			* Date Author Description
			* -----------------------------------------------------------------------------------------
			*  
			******************************************************************************************/
			@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Defect"}, description = "Verify whether a user can add an item to the same more than once via add from order guide)")
			public void INV_MIL_042_Validate_whether_user_can_add_item_to_same_location_more_than_once_order_guide (ManageInventoryListObject data) throws Exception { 
				
				
				 //SETUP+TRACK INVENTORY VALIDATION
				 //Login to app
				 component().login(data.strUserName, data.strPassword);
				 //setup inventory - Custom list + Def Location + Def Category
				 component().setupInventorywithCustomListDefLocDefCat(data.strListName1);
				 //navigate to track inventory
				 home().tapTrackInventory();
				 //verify locations page is displayed
				 locations().verifyLocationsPage(); 
				 //tap on a location
				 locations().tapLocation(data.strLocation1Name);
				 //verify location page is displayed
				 locations().verifyLocationPage(data.strLocation1Name);	
				 //validating items in location after setup inventory 
				 locations().verifyWhetherItemInLocation(data.strLocation1Name,data.strItemUPCID,"UPCID",true);			 

				 //ADDITION OF ITEM ALREADY PRESENT IN THE LOCATION SELECTED VIA ADD FROM ORDER GUIDE AND VERIFICATION OF THE CAKE DESCRIPTION IN THE ADD FROM PRODUCT LISTS
				 //INV_MIL_042
	     		 // Tap + button
	 			 generic().tapAddFromListPage();
	 			 //verify Add item form is displayed
	 			 locations().verifyAddItemFormPageDisplayed();
	 			 //tap on add from Order Guide
	 			 locations().tapAddItemFromOrderGuide();
	 			 //Verify Add Order Guide Page is displayed
	 			 locations().verifyAddOrderGuidePage();				 
	 			 //Verify cake description and select an item
				 locations().verifyCakeDescOfItemSelectedFromAddCustomList(data.strItem2Name);
				 //Click on Done
				 generic().tapDone();
				 
				 //VALIDATING WHETHER A USER IS ALLOWED TO ADD AN ITEM MORE THAN ONCE TO THE SAME LOCATION
				 //verify location page is displayed
				 locations().verifyLocationPageDisplayed(data.strLocation1Name);
				 //Verify the newly added item is displayed in the locations page
				 locations().verifyItemPresentInLocation(data.strItem2Name,"Product Name",true);
				 //validating items in location same item which is already present in the location is added again - verifying duplication
				 locations().verifyWhetherItemInLocation(data.strLocation1Name,data.strItemUPCID,"UPCID",true);
				 //click on item newly added
				 locations().selectAnItemFromProductList(data.strItem2Name);	
				 //verify product name of the newly created item
				 product().verifyProductDetails(data.strItem2Name,"","","","","","","",new String[0],new String[0],new String[0]);
				 //verify whether user is able to add an item to a location more than once
	     		 locations().verifyDuplicationLoc(data.strLocation1Name,data.strItem2Name);
	     		component().logoutFromProductDetailsPage();
	     		//close app
				 generic().closeApp();			 
				
				
			}
			/******************************************************************************************
			* Name : INV_MIL_043_Validate_whether_user_can_add_item_to_same_location_more_than_once_product_catalog
			* 
			* Description : Verify whether a user can add an item to the same more than once via add from product catalog
			* 
			* Manual Test cases : 
			* 
			* Author : Reshma S Farook
			* 
			* Date : 10.21.2016
			* 
			* Notes : Precondition - setupInventorywithCustomListDefLocDefCat
			* 
			* Modification Log
			* Date Author Description
			* -----------------------------------------------------------------------------------------
			*  
			******************************************************************************************/
			@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Defect"}, description = "Verify whether a user can add an item to the same more than once via add from product catalog)")
			public void INV_MIL_043_Validate_whether_user_can_add_item_to_same_location_more_than_once_product_catalog (ManageInventoryListObject data) throws Exception { 
				
				
				 //SETUP+TRACK INVENTORY VALIDATION
				 //Login to app
				 component().login(data.strUserName, data.strPassword);
				 //setup inventory - Custom list + Def Location + Def Category
				 component().setupInventorywithCustomListDefLocDefCat(data.strListName1);
				 //navigate to track inventory
				 home().tapTrackInventory();
				 //verify locations page is displayed
				 locations().verifyLocationsPage(); 
				 //tap on a location
				 locations().tapLocation(data.strLocation1Name);
				 //verify location page is displayed
				 locations().verifyLocationPage(data.strLocation1Name);	
				 //validating items in location after setup inventory 
				 locations().verifyWhetherItemInLocation(data.strLocation1Name,data.strItemUPCID,"UPCID",true);			 

				 //ADDITION OF ITEM ALREADY PRESENT IN THE LOCATION SELECTED VIA ADD FROM ORDER GUIDE AND VERIFICATION OF THE CAKE DESCRIPTION IN THE ADD FROM PRODUCT LISTS
				 //INV_MIL_043
				 //Tap + button
				 generic().tapAddFromListPage();
				 //verify Add item form is displayed
				 locations().verifyAddItemFormPageDisplayed();
				 //search for chicken
				 locations().searchItemInAddItemForm("Almond");
				 locations().tapAddItemForm();
				 //Verify cake description and select an item
				 locations().verifyCakeDescOfItemSelectedFromAddCustomList(data.strItem2Name);
				 //Click on Done
				 generic().tapDone();
				 
				 //VALIDATING WHETHER A USER IS ALLOWED TO ADD AN ITEM MORE THAN ONCE TO THE SAME LOCATION
				 //verify location page is displayed
				 locations().verifyLocationPageDisplayed(data.strLocation1Name);
				 //Verify the newly added item is displayed in the locations page
				 locations().verifyItemPresentInLocation(data.strItem2Name,"Product Name",true);
				 //validating items in location same item which is already present in the location is added again - verifying duplication
				 locations().verifyWhetherItemInLocation(data.strLocation1Name,data.strItemUPCID,"UPCID",true);
				 //click on item newly added
				 locations().selectAnItemFromProductList(data.strItem2Name);	
				 //verify product name of the newly created item
				 product().verifyProductDetails(data.strItem2Name,"","","","","","","",new String[0],new String[0],new String[0]);
				 //verify whether user is able to add an item to a location more than once
	     		 locations().verifyDuplicationLoc(data.strLocation1Name,data.strItem2Name);
	     		component().logoutFromProductDetailsPage();
	     		 //close app
				 generic().closeApp();			 				
				
			}
	
}
