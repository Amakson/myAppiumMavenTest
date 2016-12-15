package com.uom.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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
import com.uom.excelSheetObject.ExpenseCategoriesObject;
import com.uom.excelSheetObject.NonSyscoPrepItemObject;
import com.uom.excelSheetObject.UsabilityObject;
import com.uom.pageFactory.PageFactory;
import com.uom.pages.common.ProductPage;


@Listeners(value = UOMTestNGListener.class)
public class NonSyscoPrepItems extends PageFactory{
	
	public static String[][] completeArray = null;	
   	Starter starter = new Starter();
   	
    @BeforeClass(alwaysRun=true)
   	public void getData() throws Exception
   	{		
   		String strDataFilePath;
   		Excel newExcel =new Excel();		
   		completeArray=newExcel.read("test-data/TestData.xls","NonSyscoPrepItems");
   	}
    
    @BeforeMethod(alwaysRun=true)
    public void initiate() throws Exception
    {
    	
    	startup();
    }
    
    @DataProvider(name = "DP1",parallel =true)
    public Object[][] getData(Method method) throws Exception{
	 	Excel newExcel =new Excel();
	 	NonSyscoPrepItemObject sheetObj = new NonSyscoPrepItemObject();
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
	  * Name : INV_NSI_001_Add_NonSysco_Item_ExpenseCatNotSetup_NoSupplierList
	  * 
	  * Description : User should be able to add a non sysco item to inventory with expense category  not setup during initial setup and no supplier list
	  * 
	  * Manual Test cases : INV_NSI_001
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 9/30/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  ******************************************************************************************/
    @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"NonSyscoPrepItems","NonSyscoPrepItems_iOS1","NonSyscoPrepItems_Defect"}, description = "Add non sysco item to inventory with expense category not setup and no supplier list")
	 public void INV_NSI_001_Add_NonSysco_Item_ExpenseCatNotSetup_NoSupplierList(NonSyscoPrepItemObject data) throws Exception {	
   	
    	//Login to app
		 component().login(data.strUserName, data.strPassword);
		//Set up Inventory -  Can plug it in once the set inventory screens are stable
		 // - Order guide + Default location + NO category
		 component().setupInventorywithOGDefaultLocDefaultCat();
        // Delete expense categories
		 component().deleteallexpensecategories();
		//Tap Create Non-Sysco item
		 home().tapCreateNonSyscoItem();
		//Verify multi step setup flow is displayed
		 nonSyscoPrepItem().verifyMultiStepSetUpFlow();
		 //verify Add New Supplier option is displayed
		 nonSyscoPrepItem().verifyAddSupplierOption(true);
		 //click on Add new Supplier option
		 nonSyscoPrepItem().tapAddNewSupplier();
		//verify create supplier form is displayed
		 nonSyscoPrepItem().verifyCreateSupplierForm(true);
		 //click on 'X' button
		 generic().tapXButton();
		 //verify create supplier form is not displayed
		 nonSyscoPrepItem().verifyCreateSupplierForm(false);
		 //click on Add new Supplier option
		 nonSyscoPrepItem().tapAddNewSupplier();
		 //verify save button is disabled
		 generic().verifySaveButtonStatus(false);
		 //verify next button is disabled
		 generic().verifyNextButtonStatus(false);
		 //enter supplier name
		 nonSyscoPrepItem().enterSupplierName(data.strSupplierName1);  
		//verify save button is disabled
		 generic().verifySaveButtonStatus(true);
		 //tap on save button
		 generic().tapSaveButton();
		 //verify newly created supplier name is displayed
		 nonSyscoPrepItem().verifySupplierInSupplierList(data.strSupplierName1, true);		
		 //verify newly created supplier is auto-selected
//		 nonSyscoPrepItem().verifySupplierSelected(data.strSupplierName1);  
		 //verify next button is enabled
		 generic().verifyNextButtonStatus(true);
		 //tap next
		 generic().tapNextButton();
		 //verify product details page is displayed
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //verify product page fields displayed
		 nonSyscoPrepItem().verifyProductPageFields("nonsysco");
		 //verify mandatory fields - Creating item from home page
		 nonSyscoPrepItem().verifyNonSyscoItemMandatoryFields("Home");  
		 //enter product details
		 product().enterNonSyscoItemDetails(data.strProductName1, data.strNickName1, data.strProductBrand1, data.strProductId1, data.strPack1, data.strSize1, data.strWeight1, data.strPrice1);
		//tap previous button
		 generic().tapPreviousButton();
		 //verify Select supplier page is displayed
		 nonSyscoPrepItem().verifySelectSupplierPage();
//ISSUE - when we tap on previous button from product details page, app is navigated to select supplier page
//But supplier is not selected by default , now adding a line of code to select supplier to avoid the blocking 
// But this line of code needs to be removed once the issue is fixed
		 nonSyscoPrepItem().selectSupplier(data.strSupplierName1);
		 //tap next button
		 generic().tapNextButton();
		 //verify product details page is displayed
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //verify next button is enabled
		 generic().verifyNextButtonStatus(true);         
		 //tap next button
		 generic().tapNextButton();		 
		 //verify select expenses screen is displayed
		 nonSyscoPrepItem().verifySelectCategoryPage();
		 //verify next button is enable without add/selecting category - Not mandatory fields
		 generic().verifyNextButtonStatus(false);
		 //tap on add new expense category
		 nonSyscoPrepItem().tapAddNewCategoryExpense();
		 //verify the save button is disabled
		 generic().verifySaveButtonStatus(false);
		 //Tap add new category and enter category details
		 nonSyscoPrepItem().enterCategoryDetails(data.strCategoryName1, data.strCategoryType1);
		 //Tap on save button
		 generic().tapSaveButton();		 
		 //verify newly created category  is displayed
		 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName1, true);   
//QUERY - Newly created category is not selected by default , now adding a line of code to select supplier to avoid the blocking 
// But this line of code needs to be removed once the issue is fixed/ this behavior is expected	 
		 nonSyscoPrepItem().selectCategory(data.strCategoryName1);		 
		 //verify newly created category is selected
//		 nonSyscoPrepItem().verifyCategorySelected(data.strCategoryName1);
		 //tap next
		 generic().tapNextButton();
		 //verify select location page is displayed
		 nonSyscoPrepItem().verifySelectLocationPage();
		 //verify done button is enabled
		 generic().verifyDoneButtonStatus(false);
		 //Tap on add new location button
		 nonSyscoPrepItem().tapAddNewLocation();
		 //verify the save button is disabled
		 generic().verifySaveButtonStatus(false);		 
		//Tap add new location and enter location details
		 nonSyscoPrepItem().enterLocationDetails(data.strLocationName1, data.strLocationType1);
		 //tap on save button
		 generic().tapSaveButton();
		 //verify newly created location is displayed
		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName1, true); 
//QUERY - Newly created category is not selected by default , now adding a line of code to select supplier to avoid the blocking 
// But this line of code needs to be removed once the issue is fixed/ this behavior is expected	 
//		 nonSyscoPrepItem().selectLocation(data.strLocationName1);		 
		 //verify newly created location is selected
//		 nonSyscoPrepItem().verifyLocationSelected(data.strLocationName1);
		 //tap done button
		 generic().tapDoneButton();
		 //wait for 8 seconds
		 generic().waitFor(10);
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //click close in product details page
		 generic().tapClose();        
		 //navigate to track inventory
		 home().tapTrackInventory();
		 //navigate to selected location
		 locations().tapLocation(data.strLocationName1);
		 //verify item present in location
		 locations().verifyItemPresentInLocation(data.strProductId1, "UPCID", true);
		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);
		 //verify category of item
		 locations().verifyItemCategoryInItemList(data.strProductName1,data.strCategoryName1);
		 //tap on item 
		 locations().selectAnItemFromProductList(data.strProductName1);
		 //add code for verify product details if needed
		 //verify location name in product details page
		 product().verifyLocation(data.strLocationName1);
		//close app
		 generic().closeApp();
    }
    
    
    /******************************************************************************************
	  * Name : INV_NSI_002_Add_NonSysco_Item_DefaultCat_DefaultLoc_SupplierList
	  * 
	  * Description : User should be able to add a non sysco item to inventory with expense category  not setup during initial setup and no supplier list
	  * 
	  * Manual Test cases : INV_NSI_002
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 9/30/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------

	  ******************************************************************************************/

   @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"NonSyscoPrepItems","NonSyscoPrepItems_iOS1","NonSyscoPrepItems_Defect","CriticalBatchAndroid","CriticalPatchIOS"}, description = "Add non sysco item to inventory with supplier list and default category")

	 public void INV_NSI_002_Add_NonSysco_Item_DefaultCat_DefaultLoc_SupplierList(NonSyscoPrepItemObject data) throws Exception {	
  	
   	//Login to app
		 component().login(data.strUserName, data.strPassword);
		//Set up Inventory -  Can plug it in once the set inventory screens are stable
		 //INV_NSI_001 - Order guide + Default location + Default category		 
		 component().setupInventorywithOGDefaultLocDefaultCat();

		 //create two suppliers as pre-requisite for this script 
		 component().createSupplier(data.strSupplierName1, data.strPhoneNumber, data.strAddress, "", data.strEmail, "");
		 component().createSupplier(data.strSupplierName2, data.strPhoneNumber, data.strAddress, "123", "", "");
		 component().createSupplier(data.strSupplierName3, "", data.strAddress, "", "sysco@sysco.com", "");  
		//Tap Create Non-Sysco item
		 home().tapCreateNonSyscoItem();
		//Verify multi step setup flow is displayed
		 nonSyscoPrepItem().verifyMultiStepSetUpFlow();
		 //verify Add New Supplier option is displayed
		 nonSyscoPrepItem().verifyAddSupplierOption(true);
		 //validate the user is able to view list of suppliers
		 nonSyscoPrepItem().verifySupplierInSupplierList(data.strSupplierName1, true);	
		 nonSyscoPrepItem().verifySupplierInSupplierList(data.strSupplierName2, true);	
		 nonSyscoPrepItem().verifySupplierInSupplierList(data.strSupplierName3, true);
		 //verify next button is not enable before selecting supplier from list
		 generic().verifyNextButtonStatus(false);
		 //select one supplier from supplier list
		 nonSyscoPrepItem().selectSupplier(data.strSupplierName2);
		 //tap next
		 generic().tapNextButton();		 
		 //verify product details page is displayed
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //verify product page fields displayed
		 nonSyscoPrepItem().verifyProductPageFields("nonsysco");
		 //verify mandatory fields - Creating item from home page
		 nonSyscoPrepItem().verifyNonSyscoItemMandatoryFields("Home");  
		 //enter product details
		 product().enterNonSyscoItemDetails(data.strProductName1, data.strNickName1, data.strProductBrand1, data.strProductId1, data.strPack1, data.strSize1, data.strWeight1, data.strPrice1);
		//tap previous button
		 generic().tapPreviousButton();
		 //verify Select supplier page is displayed
		 nonSyscoPrepItem().verifySelectSupplierPage();
		 //select supplier from supplier list
		 //nonSyscoPrepItem().selectSupplier(data.strSupplierName2);
		 //tap next button
		 generic().tapNextButton();
		 //verify product details page is displayed
		 nonSyscoPrepItem().verifyProductDetailsPage();        
		 //tap next button
		 generic().tapNextButton();		 
		 //verify select expenses screen is displayed
		 nonSyscoPrepItem().verifySelectCategoryPage();		 
		 //validate the list of categories in select categories screen
		 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName1, true);   
		 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName2, true);   
		 //select one category form list of categories
		 nonSyscoPrepItem().selectCategory(data.strCategoryName1);
		 //tap next
		 generic().tapNextButton();		 
		 //verify select location page is displayed
		 nonSyscoPrepItem().verifySelectLocationPage();
		//validate the list of location in select locations screen
		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName1, true); 
		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName2, true); 
		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName3, true); 
		//select one location form list of locations
		 nonSyscoPrepItem().selectLocation(data.strLocationName2);	
		 //tap done button
		 generic().tapDoneButton();
		 //wait for 8 seconds
		 generic().waitFor(10);
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //click close in product details page
		 generic().tapClose();        
		 //navigate to track inventory
		 home().tapTrackInventory();
		 //navigate to selected location
		 locations().tapLocation(data.strLocationName2);
		 //verify item present in location
		 locations().verifyItemPresentInLocation(data.strProductId1, "UPCID", true);
		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);
		 //verify category of item
		 locations().verifyItemCategoryInItemList(data.strProductName1,data.strCategoryName1);
		 //tap on item 
		 locations().selectAnItemFromProductList(data.strProductName1);
		 //add code for verify product details if needed
		 //verify location name in product details page
		 product().verifyLocation(data.strLocationName2);
		//close app
		 generic().closeApp();
   }
   
   
   
   /******************************************************************************************
	  * Name : INV_NSI_003_Add_NonSysco_Item_SuggestedCat_CustomLoc_SupplierList
	  * 
	  * Description : User should be able to add a non sysco item to inventory with suggested category, custome location and list of suppliers. 
	  * 
	  * Manual Test cases : INV_NSI_003
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 9/30/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------

	  ******************************************************************************************/
  @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"NonSyscoPrepItems","NonSyscoPrepItems_iOS1","NonSyscoPrepItems_Defect"}, description = "Add non sysco item to inventory with supplier list and suggested category and customer location")
	 public void INV_NSI_003_Add_NonSysco_Item_SuggestedCat_CustomLoc_SupplierList(NonSyscoPrepItemObject data) throws Exception {	
 	
  	//Login to app
		 component().login(data.strUserName, data.strPassword);
		//Set up Inventory -  Can plug it in once the set inventory screens are stable
		 //INV_NSI_001 - Order guide + Default location + Default category		 
		 component().setupInventorywithOGCustomLocSuggestedCategorySomeItemSelection(data.strLocationNames, data.strLocationTypes);

		 //create three suppliers as pre-requisite for this script 
		 component().createSupplier(data.strSupplierName1, data.strPhoneNumber, data.strAddress, "", data.strEmail, "");
		 component().createSupplier(data.strSupplierName2, data.strPhoneNumber, data.strAddress, "123", "", "");
		 component().createSupplier(data.strSupplierName3, "", data.strAddress, "", "sysco@sysco.com", "");  
		//Tap Create Non-Sysco item
		 home().tapCreateNonSyscoItem();
		//Verify multi step setup flow is displayed
		 nonSyscoPrepItem().verifyMultiStepSetUpFlow();
		 //verify Add New Supplier option is displayed
		 nonSyscoPrepItem().verifyAddSupplierOption(true);
		 //validate the user is able to view list of suppliers
		 nonSyscoPrepItem().verifySupplierInSupplierList(data.strSupplierName1, true);	
		 nonSyscoPrepItem().verifySupplierInSupplierList(data.strSupplierName2, true);	
		 nonSyscoPrepItem().verifySupplierInSupplierList(data.strSupplierName3, true);
		 //verify next button is not enable before selecting supplier from supplier list
		 generic().verifyNextButtonStatus(false);
		 //select one supplier from supplier list
		 nonSyscoPrepItem().selectSupplier(data.strSupplierName2);
		 //tap next
		 generic().tapNextButton();		 
		 //verify product details page is displayed
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //verify product page fields displayed
		 nonSyscoPrepItem().verifyProductPageFields("nonsysco");
		 //verify mandatory fields - Creating item from home page
		 nonSyscoPrepItem().verifyNonSyscoItemMandatoryFields("Home");  
		 //enter product details
		 product().enterNonSyscoItemDetails(data.strProductName1, data.strNickName1, data.strProductBrand1, data.strProductId1, data.strPack1, data.strSize1, data.strWeight1, data.strPrice1);
		//tap previous button
		 generic().tapPreviousButton();
		 //verify Select supplier page is displayed
		 nonSyscoPrepItem().verifySelectSupplierPage();
		 //select supplier from supplier list
		// nonSyscoPrepItem().selectSupplier(data.strSupplierName2);
		 //tap next button
		 generic().tapNextButton();
		 //verify product details page is displayed
		 nonSyscoPrepItem().verifyProductDetailsPage();        
		 //tap next button
		 generic().tapNextButton();		 
		 //verify select expenses screen is displayed
		 nonSyscoPrepItem().verifySelectCategoryPage();		 
		 //validate all suggested categories are displayed in category list
		 nonSyscoPrepItem().verifySuggestedCategoryInCategoryList(); 
		 //select one category form list of categories
		 nonSyscoPrepItem().selectCategory(data.strCategoryName1);
		 //tap next
		 generic().tapNextButton();		 
		 //verify select location page is displayed
		 nonSyscoPrepItem().verifySelectLocationPage();
		//validate the list of location in select locations screen
		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName1, true); 
		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName2, true); 
		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName3, true); 
		//select one location form list of locations
		 nonSyscoPrepItem().selectLocation(data.strLocationName2);	
		 //tap done button
		 generic().tapDoneButton();
		 //wait for 8 seconds
		 generic().waitFor(10);
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //click close in product details page
		 generic().tapClose();        
		 //navigate to track inventory
		 home().tapTrackInventory();
		 //navigate to selected location
		 locations().tapLocation(data.strLocationName2);
		 //verify item present in location
		 locations().verifyItemPresentInLocation(data.strProductId1, "UPCID", true);
		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);
		 //verify category of item
		 locations().verifyItemCategoryInItemList(data.strProductName1,data.strCategoryName1);
		 //tap on item 
		 locations().selectAnItemFromProductList(data.strProductName1);
		 //add code for verify product details if needed
		 //verify location name in product details page
		 product().verifyLocation(data.strLocationName2);
		//close app
		 generic().closeApp();
  }
   
  
  /******************************************************************************************
	  * Name : INV_NSI_004_Add_NonSysco_Item_CustomCat_ListNameAsLocation_SupplierList
	  * 
	  * Description : User should be able to add a non sysco item to inventory with custom category, list name as location and list of suppliers. 
	  * 
	  * Manual Test cases : INV_NSI_004
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 9/30/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------

	  ******************************************************************************************/
  @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"NonSyscoPrepItems","NonSyscoPrepItems_iOS1","NonSyscoPrepItems_Defect"}, description = "Add non sysco item to inventory with supplier list and custom category and list name as location")
	 public void INV_NSI_004_Add_NonSysco_Item_CustomCat_ListNameAsLocation_SupplierList(NonSyscoPrepItemObject data) throws Exception {	
	
	//Login to app
		 component().login(data.strUserName, data.strPassword);
		//Set up Inventory -  Can plug it in once the set inventory screens are stable
		 //INV_SI_ - Custom list + list name as location + custom category	
		 component().setupInventorywithMutlipleCustomListListNameAsLocationCustomCat(data.strListName1, data.strListName2, data.strCategoryNames, data.strCategoryTypes, data.strCategoryNames.split("/")[0]);
	//	component().setupinventorywithmuti
		 //create three suppliers as pre-requisite for this script 
		 component().createSupplier(data.strSupplierName1, data.strPhoneNumber, data.strAddress, "", data.strEmail, "");
		 component().createSupplier(data.strSupplierName2, data.strPhoneNumber, data.strAddress, "123", "", "");
		 component().createSupplier(data.strSupplierName3, "", data.strAddress, "", "sysco@sysco.com", "");  
		//Tap Create Non-Sysco item
		 home().tapCreateNonSyscoItem();
		//Verify multi step setup flow is displayed
		 nonSyscoPrepItem().verifyMultiStepSetUpFlow();
		 //verify Add New Supplier option is displayed
		 nonSyscoPrepItem().verifyAddSupplierOption(true);
		 //validate the user is able to view list of suppliers
		 nonSyscoPrepItem().verifySupplierInSupplierList(data.strSupplierName1, true);	
		 nonSyscoPrepItem().verifySupplierInSupplierList(data.strSupplierName2, true);	
		 nonSyscoPrepItem().verifySupplierInSupplierList(data.strSupplierName3, true);
		 //verify next button is not enable before selecting supplier from supplier list
		 generic().verifyNextButtonStatus(false);
		 //select one supplier from supplier list
		 nonSyscoPrepItem().selectSupplier(data.strSupplierName2);
		 //tap next
		 generic().tapNextButton();		 
		 //verify product details page is displayed
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //verify product page fields displayed
		 nonSyscoPrepItem().verifyProductPageFields("nonsysco");
		 //verify mandatory fields - Creating item from home page
		 nonSyscoPrepItem().verifyNonSyscoItemMandatoryFields("Home");  
		 //enter product details
		 product().enterNonSyscoItemDetails(data.strProductName1, data.strNickName1, data.strProductBrand1, data.strProductId1, data.strPack1, data.strSize1, data.strWeight1, data.strPrice1);
		//tap previous button
		 generic().tapPreviousButton();
		 //verify Select supplier page is displayed
		 nonSyscoPrepItem().verifySelectSupplierPage();
		 //select supplier from supplier list
		 //nonSyscoPrepItem().selectSupplier(data.strSupplierName2);
		 //tap next button
		 generic().tapNextButton();
		 //verify product details page is displayed
		 nonSyscoPrepItem().verifyProductDetailsPage();        
		 //tap next button
		 generic().tapNextButton();		 
		 //verify select expenses screen is displayed
		 nonSyscoPrepItem().verifySelectCategoryPage();	
		//validate the list of categories in select categories screen
		 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName1, true);   
		 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName2, true);   
		 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName3, true);   		 
		 //select one category form list of categories
		 nonSyscoPrepItem().selectCategory(data.strCategoryName2);
		 //tap next
		 generic().tapNextButton();		 
		 //verify select location page is displayed
		 nonSyscoPrepItem().verifySelectLocationPage();
		//validate the list of location in select locations screen
		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName1, true); 
		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName2, true); 
		//select one location form list of locations
		 nonSyscoPrepItem().selectLocation(data.strLocationName2);	
		 //tap done button
		 generic().tapDoneButton();
		 //wait for 8 seconds
		 generic().waitFor(10);
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //click close in product details page
		 generic().tapClose();        
		 //navigate to track inventory
		 home().tapTrackInventory();
		 //navigate to selected location
		 locations().tapLocation(data.strLocationName2);
		 //verify item present in location
		 locations().verifyItemPresentInLocation(data.strProductId1, "UPCID", true);
		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);
		 //verify category of item
		 locations().verifyItemCategoryInItemList(data.strProductName1,data.strCategoryName2);
		 //tap on item 
		 locations().selectAnItemFromProductList(data.strProductName1);
		 //add code for verify product details if needed
		 //verify location name in product details page
		 product().verifyLocation(data.strLocationName2);
		//close app
		 generic().closeApp();
}

			
			
			/******************************************************************************************
			 * Name : INV_NSI_005_Add_NonSysco_Item_CustomCat_CategoryAsLocation_SupplierList																									
			 * 
			 * Description : User should be able to add a non sysco item to inventory with custom category, custom category as location and list of suppliers. 
			 * 
			 * Manual Test cases : INV_NSI_005
			 * 
			 * Author : Periyasamy Nainar
			 * 
			 * Date : 10/11/2016
			 * 
			 * Notes : NA
			 * 
			 * Modification Log
			 * Date						Author						Description
			 * -----------------------------------------------------------------------------------------
			
			 ******************************************************************************************/
			@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"NonSyscoPrepItems","NonSyscoPrepItems_iOS2","NonSyscoPrepItems_Defect","CriticalBatchAndroid"}, description = "Add non sysco item to inventory with supplier list and custom category and custom category as location")
			public void INV_NSI_005_Add_NonSysco_Item_CustomCat_CategoryAsLocation_SupplierList(NonSyscoPrepItemObject data) throws Exception {	
			
				//Login to app
				 component().login(data.strUserName, data.strPassword);
				//Set up Inventory -  Can plug it in once the set inventory screens are stable
				 //INV_NSI_00 - custom list + custom category as location + custom category - setup inv is nt ready 
				 component().setupInventorywithCustomListCustomCategoryAsLocationCustomCat(data.strListName1, data.strCategoryNames, data.strCategoryTypes, data.strCategoryNames.split("/")[0], data.strLocationName1+"/"+data.strLocationName2+"/"+data.strLocationName3);

				 //create three suppliers as pre-requisite for this script 
				 component().createSupplier(data.strSupplierName1, data.strPhoneNumber, data.strAddress, "", data.strEmail, "");
				 component().createSupplier(data.strSupplierName2, data.strPhoneNumber, data.strAddress, "123", "", "");
				 component().createSupplier(data.strSupplierName3, "", data.strAddress, "", "sysco@sysco.com", "");  
				//Tap Create Non-Sysco item
				 home().tapCreateNonSyscoItem();
				//Verify multi step setup flow is displayed
				 nonSyscoPrepItem().verifyMultiStepSetUpFlow();
				 //verify Add New Supplier option is displayed
				 nonSyscoPrepItem().verifyAddSupplierOption(true);
				 //validate the user is able to view list of suppliers
				 nonSyscoPrepItem().verifySupplierInSupplierList(data.strSupplierName1, true);	
				 nonSyscoPrepItem().verifySupplierInSupplierList(data.strSupplierName2, true);	
				 nonSyscoPrepItem().verifySupplierInSupplierList(data.strSupplierName3, true);
				 //verify next button is disable before selecting supplier
				 generic().verifyNextButtonStatus(false);
				 //select one supplier from supplier list
				 nonSyscoPrepItem().selectSupplier(data.strSupplierName2);
				 //tap next
				 generic().tapNextButton();		 
				 //verify product details page is displayed
				 nonSyscoPrepItem().verifyProductDetailsPage();
				 //verify product page fields displayed
				 nonSyscoPrepItem().verifyProductPageFields("nonsysco");
				 //verify mandatory fields - Creating item from home page
				 nonSyscoPrepItem().verifyNonSyscoItemMandatoryFields("Home");  
				 //enter product details
				 product().enterNonSyscoItemDetails(data.strProductName1, data.strNickName1, data.strProductBrand1, data.strProductId1, data.strPack1, data.strSize1, data.strWeight1, data.strPrice1);
				//tap previous button
				 generic().tapPreviousButton();
				 //verify Select supplier page is displayed
				 nonSyscoPrepItem().verifySelectSupplierPage();
				 //select supplier from supplier list
				 //nonSyscoPrepItem().selectSupplier(data.strSupplierName2);
				 //tap next button
				 generic().tapNextButton();
				 //verify product details page is displayed
				 nonSyscoPrepItem().verifyProductDetailsPage();        
				 //tap next button
				 generic().tapNextButton();		 
				 //verify select expenses screen is displayed
				 nonSyscoPrepItem().verifySelectCategoryPage();		 
				 //validate all suggested categories are displayed in category list
				 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName1, true); 
				 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName2, true); 
				 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName3, true); 
				 //select one category form list of categories
				 nonSyscoPrepItem().selectCategory(data.strCategoryName1);
				 //tap next
				 generic().tapNextButton();		 
				 //verify select location page is displayed
				 nonSyscoPrepItem().verifySelectLocationPage();
				//validate the list of location in select locations screen
				 nonSyscoPrepItem().verifyLocationInList(data.strLocationName1, true); 
				 nonSyscoPrepItem().verifyLocationInList(data.strLocationName2, true); 
				 nonSyscoPrepItem().verifyLocationInList(data.strLocationName3, true); 
				//select one location form list of locations
				 nonSyscoPrepItem().selectLocation(data.strLocationName1);	
				 //tap done button
				 generic().tapDoneButton();
				 //wait for 8 seconds
				 generic().waitFor(10);
				 nonSyscoPrepItem().verifyProductDetailsPage();
				 //click close in product details page
				 generic().tapClose();               
				 //navigate to track inventory
				 home().tapTrackInventory();
				 //navigate to selected location
				 locations().tapLocation(data.strLocationName1);
				 //verify item present in location
				 locations().verifyItemPresentInLocation(data.strProductId1, "UPCID", true);
				 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);
				 //verify category of item
				 locations().verifyItemCategoryInItemList(data.strProductName1,data.strCategoryName1);
				 //tap on item 
				 locations().selectAnItemFromProductList(data.strProductName1);
				 //add code for verify product details if needed
				 //verify location name in product details page
				 product().verifyLocation(data.strLocationName1);
				//close app
				 generic().closeApp();
			}
			
			    
   
   
   /******************************************************************************************
 	  * Name : INV_NSI_006_Add_Prep_Item_ExpenseCatNotSetup_NoSupplierList
 	  * 
 	  * Description : User should be able to add a prep item to inventory with expense category not setup during initial setup
 	  * 
 	  * Manual Test cases : INV_NSI_006
 	  * 
 	  * Author : Periyasamy Nainar
 	  * 
 	  * Date : 9/30/2016
 	  * 
 	  * Notes : NA
 	  * 
 	  * Modification Log
 	  * Date						Author						Description
 	  * -----------------------------------------------------------------------------------------
 	  ******************************************************************************************/
     @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"NonSyscoPrepItems","NonSyscoPrepItems_iOS1","NonSyscoPrepItems_Defect"}, description = "Add prep item to inventory with expense category not setup")
 	 public void INV_NSI_006_Add_Prep_Item_ExpenseCatNotSetup(NonSyscoPrepItemObject data) throws Exception {	
    	
     	//Login to app
 		 component().login(data.strUserName, data.strPassword);
 		//Set up Inventory -  Can plug it in once the set inventory screens are stable
 		component().setupInventorywithOGDefaultLocDefaultCat();
        // Delete expense categories
		 component().deleteallexpensecategories();
 		//Tap Create Prep item
 		 home().tapCreatePrepItem();
 		//Verify multi step setup flow is displayed
 		 nonSyscoPrepItem().verifyPrepMultiStepSetUpFlow();
 		 //verify Add New Supplier option is displayed
 		 nonSyscoPrepItem().verifyAddSupplierOption(false); 
 		 //verify product details page is displayed
 		 nonSyscoPrepItem().verifyProductDetailsPage();
 		 //Tap on previous button
// 		 generic().tapPreviousButton();--- Previous button is removed with 13.6
 		 //Tap on create prep itme 
 	//   home().tapCreatePrepItem();
 		 //verify product details page is displayed
 	//    nonSyscoPrepItem().verifyProductDetailsPage();
 		 //verify product page fields displayed
 		 nonSyscoPrepItem().verifyProductPageFields("prep");
 		 //verify mandatory fields - Creating item from home page
 		 nonSyscoPrepItem().verifyPrepItemMandatoryFields();
 		 //enter product details
 		 product().enterPrepItemDetails(data.strProductName1, data.strNickName1, data.strProductId1, data.strPack1, data.strSize1, data.strWeight1,data.strPrice1); 		 
 		 //tap next button
 		 generic().tapNextButton();		 
 		 //verify select expenses screen is displayed
 		 nonSyscoPrepItem().verifySelectCategoryPage();
 		 //verify next button is enable without add/selecting category - Not mandatory fields
 		 generic().verifyNextButtonStatus(false);
 		 //tap on add new expense category
 		 nonSyscoPrepItem().tapAddNewCategoryExpense();
 		 //verify the save button is disabled
 		 generic().verifySaveButtonStatus(false);
 		 //Tap add new category and enter category details
 		 nonSyscoPrepItem().enterCategoryDetails(data.strCategoryName1, data.strCategoryType1);
 		 //Tap on save button
 		 generic().tapSaveButton();		 
 		 //verify newly created category  is displayed
 		 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName1, true);   
 //QUERY - Newly created category is not selected by default , now adding a line of code to select supplier to avoid the blocking 
 // But this line of code needs to be removed once the issue is fixed/ this behavior is expected	 
 		 nonSyscoPrepItem().selectCategory(data.strCategoryName1);		 
 		 //verify newly created category is selected
// 		 nonSyscoPrepItem().verifyCategorySelected(data.strCategoryName1);
 		 //tap next
 		 generic().tapNextButton();
 		 //verify select location page is displayed
 		 nonSyscoPrepItem().verifySelectLocationPage();
 		 //verify done button is enabled
 		 generic().verifyDoneButtonStatus(false);
 		 //Tap on add new location button
 		 nonSyscoPrepItem().tapAddNewLocation();
 		 //verify the save button is disabled
 		 generic().verifySaveButtonStatus(false);		 
 		//Tap add new location and enter location details
 		 nonSyscoPrepItem().enterLocationDetails(data.strLocationName1, data.strLocationType1);
 		 //tap on save button
 		 generic().tapSaveButton();
 		 //verify newly created location is displayed
 		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName1, true); 
 //QUERY - Newly created category is not selected by default , now adding a line of code to select supplier to avoid the blocking 
 // But this line of code needs to be removed once the issue is fixed/ this behavior is expected	 
 		 //nonSyscoPrepItem().selectLocation(data.strLocationName1);		 
 		 //verify newly created location is selected -- Newly created location already selected in the app
// 		 nonSyscoPrepItem().verifyLocationSelected(data.strLocationName1);
 		 //tap done button
 		 generic().tapDoneButton();
 		 //wait for 8 seconds
 		 generic().waitFor(10);
 		 nonSyscoPrepItem().verifyProductDetailsPage();
 		 //click close in product details page
 		 generic().tapClose();        
 		 //navigate to track inventory
 		 home().tapTrackInventory();
 		 //navigate to selected location
 		 locations().tapLocation(data.strLocationName1);
 		 //verify item present in location
 		 locations().verifyItemPresentInLocation(data.strProductId1, "UPCID", true);
 		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);
 		 //verify category of item
 		 locations().verifyItemCategoryInItemList(data.strProductName1,data.strCategoryName1);
 		 //tap on item 
 		 locations().selectAnItemFromProductList(data.strProductName1);
 		 //add code for verify product details if needed
 		 //verify location name in product details page
 		 product().verifyLocation(data.strLocationName1);
 		//close app
 		 generic().closeApp();
     }
     
     
     /******************************************************************************************
 	  * Name : INV_NSI_007_Add_Prep_Item_DefaultCat_DefaultLoc
 	  * 
 	  * Description : User should be able to add a prep item to inventory with default category and default location
 	  * 
 	  * Manual Test cases : INV_NSI_007
 	  * 
 	  * Author : Periyasamy Nainar
 	  * 
 	  * Date : 9/26/2016
 	  * 
 	  * Notes : NA
 	  * 
 	  * Modification Log
 	  * Date						Author						Description
 	  * -----------------------------------------------------------------------------------------

 	  ******************************************************************************************/
    @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"NonSyscoPrepItems","NonSyscoPrepItems_iOS1"}, description = "Add prep item to inventory with supplier list")
 	 public void INV_NSI_007_Add_Prep_Item_DefaultCat_DefaultLoc(NonSyscoPrepItemObject data) throws Exception {	
   	
    	//Login to app
 		 component().login(data.strUserName, data.strPassword);
 		//Set up Inventory -  Can plug it in once the set inventory screens are stable
 		component().setupInventorywithOGDefaultLocDefaultCat();	 
 		 
 		//Tap Create Prep item
 		 home().tapCreatePrepItem();
 		//Verify multi step setup flow is displayed
 		 nonSyscoPrepItem().verifyPrepMultiStepSetUpFlow();
 		 //verify Add New Supplier option is displayed
 		 nonSyscoPrepItem().verifyAddSupplierOption(false); 
 		 //verify product details page is displayed
 		 nonSyscoPrepItem().verifyProductDetailsPage();
 		 //Tap on previous button
 //		 generic().tapPreviousButton();--- Previous button is removed with 13.6
 		 //Tap on create prep itme 
 //		 home().tapCreatePrepItem();
 		 //verify product details page is displayed
 //		 nonSyscoPrepItem().verifyProductDetailsPage();
 		 //verify product page fields displayed
 		 nonSyscoPrepItem().verifyProductPageFields("prep");
 		 //verify mandatory fields - Creating item from home page
 		 nonSyscoPrepItem().verifyPrepItemMandatoryFields();
 		 //enter product details
 		 product().enterPrepItemDetails(data.strProductName1, data.strNickName1, data.strProductId1, data.strPack1, data.strSize1, data.strWeight1,data.strPrice1); 		 
 		 //tap next button
 		 generic().tapNextButton();		 	 
 		 //verify select expenses screen is displayed
 		 nonSyscoPrepItem().verifySelectCategoryPage();		 
 		 //validate the list of categories in select categories screen
 		 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName1, true);   
 		 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName2, true);   
 		 //select one category form list of categories
 		 nonSyscoPrepItem().selectCategory(data.strCategoryName1);
 		 //tap next
 		 generic().tapNextButton();		 
 		 //verify select location page is displayed
 		 nonSyscoPrepItem().verifySelectLocationPage();
 		//validate the list of location in select locations screen
 		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName1, true); 
 		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName2, true); 
 		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName3, true); 
 		//select one location form list of locations
 		 nonSyscoPrepItem().selectLocation(data.strLocationName2);	
 		 //tap done button
 		 generic().tapDoneButton();
 		 //wait for 8 seconds
 		 generic().waitFor(10);
 		 nonSyscoPrepItem().verifyProductDetailsPage();  
 		 //click close in product details page
 		 generic().tapClose();        
 		 //navigate to track inventory
 		 home().tapTrackInventory();
 		 //navigate to selected location
 		 locations().tapLocation(data.strLocationName2);
 		 //verify item present in location
 		 locations().verifyItemPresentInLocation(data.strProductId1, "UPCID", true);
 		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);
 		 //verify category of item
 		 locations().verifyItemCategoryInItemList(data.strProductName1,data.strCategoryName1);
 		 //tap on item 
 		 locations().selectAnItemFromProductList(data.strProductName1);
 		 //add code for verify product details if needed
 		 //verify location name in product details page
 		 product().verifyLocation(data.strLocationName2);
 		//close app
 		 generic().closeApp();
    }
    
    

    /******************************************************************************************
	  * Name : INV_NSI_008_Add_Prep_Item_SuggestedCat_CustomLoc
	  * 
	  * Description : User should be able to add a prep item to inventory with suggested category and custom location
	  * 
	  * Manual Test cases : INV_NSI_008
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 9/30/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------

	  ******************************************************************************************/
   @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"NonSyscoPrepItems","NonSyscoPrepItems_iOS2","CriticalBatchAndroid"}, description = "Add prep item to inventory with supplier list")
	 public void INV_NSI_008_Add_Prep_Item_SuggestedCat_CustomLoc(NonSyscoPrepItemObject data) throws Exception {	
  	
   	//Login to app
		 component().login(data.strUserName, data.strPassword);
		//Set up Inventory -  Can plug it in once the set inventory screens are stable
		 //INV_NSI_ - Order guide + custom location + suggested category		 
		component().setupInventorywithOGCustomLocSuggestedCategorySingleLocationSelection(data.strLocationName1+"/"+data.strLocationName2+"/"+data.strLocationName3, "COOLER/FREEZER/DRY");
		//Tap Create Prep item
		 home().tapCreatePrepItem();
		//Verify multi step setup flow is displayed
		 nonSyscoPrepItem().verifyPrepMultiStepSetUpFlow();
		 //verify Add New Supplier option is displayed
		 nonSyscoPrepItem().verifyAddSupplierOption(false); 
		 //verify product details page is displayed
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //Tap on previous button
	//	 generic().tapPreviousButton(); -- previous button removed in 13.6
		 //Tap on create prep itme 
	//	 home().tapCreatePrepItem();
		 //verify product details page is displayed
	//	 nonSyscoPrepItem().verifyProductDetailsPage();
		 //verify product page fields displayed
		 nonSyscoPrepItem().verifyProductPageFields("prep");
		 //verify mandatory fields - Creating item from home page
		 nonSyscoPrepItem().verifyPrepItemMandatoryFields();
		 //enter product details
		 product().enterPrepItemDetails(data.strProductName1, data.strNickName1, data.strProductId1, data.strPack1, data.strSize1, data.strWeight1,data.strPrice1); 		 
		 //tap next button
		 generic().tapNextButton();		 	 
		 //verify select expenses screen is displayed
		 nonSyscoPrepItem().verifySelectCategoryPage();		 
		 //validate all suggested categories are displayed in category list
		 nonSyscoPrepItem().verifySuggestedCategoryInCategoryList();		 
		 //select one category form list of categories
		 nonSyscoPrepItem().selectCategory(data.strCategoryName1);
		 //tap next
		 generic().tapNextButton();		 
		 //verify select location page is displayed
		 nonSyscoPrepItem().verifySelectLocationPage();
		//validate the list of location in select locations screen
		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName1, true); 
		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName2, true); 
		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName3, true); 
		//select one location form list of locations
		 nonSyscoPrepItem().selectLocation(data.strLocationName2);	
		 //tap done button
		 generic().tapDoneButton();
		 //wait for 8 seconds
		 generic().waitFor(10);
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //click close in product details page
		 generic().tapClose();        
		 //navigate to track inventory
		 home().tapTrackInventory();
		 //navigate to selected location
		 locations().tapLocation(data.strLocationName2);
		 //verify item present in location
		 locations().verifyItemPresentInLocation(data.strProductId1, "UPCID", true);
		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);
		 //verify category of item
		 locations().verifyItemCategoryInItemList(data.strProductName1,data.strCategoryName1);
		 //tap on item 
		 locations().selectAnItemFromProductList(data.strProductName1);
		 //add code for verify product details if needed
		 //verify location name in product details page
		 product().verifyLocation(data.strLocationName2);
		//close app
		 generic().closeApp();
   }
   
   
   /******************************************************************************************
	  * Name : INV_NSI_009_Add_Prep_Item_CustomCat_ListNameAsLocation
	  * 
	  * Description : User should be able to add a prep item to inventory with list name as location and custom category
	  * 
	  * Manual Test cases : INV_NSI_009
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 10/01/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------

	  ******************************************************************************************/
  @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"NonSyscoPrepItems","NonSyscoPrepItems_iOS1"}, description = "Add prep item to inventory with supplier list")
	 public void INV_NSI_009_Add_Prep_Item_CustomCat_ListNameAsLocation(NonSyscoPrepItemObject data) throws Exception {	
 	
  	//Login to app
		 component().login(data.strUserName, data.strPassword);
		//Set up Inventory -  Can plug it in once the set inventory screens are stable
		 //INV_NSI - custom list + list name as location + custom category	 
		 component().setupInventorywithMutlipleCustomListListNameAsLocationCustomCat(data.strListName1, data.strListName2, data.strCategoryNames, data.strCategoryTypes, data.strCategoryNames.split("/")[0]);
		//Tap Create Prep item
		 home().tapCreatePrepItem();
		//Verify multi step setup flow is displayed
		 nonSyscoPrepItem().verifyPrepMultiStepSetUpFlow();
		 //verify Add New Supplier option is displayed
		 nonSyscoPrepItem().verifyAddSupplierOption(false); 
		 //verify product details page is displayed	
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //Tap on previous button
		 generic().tapCancel();
		 //Tap on create prep item 
		 home().tapCreatePrepItem();
		 //verify product details page is displayed
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //verify product page fields displayed
		 nonSyscoPrepItem().verifyProductPageFields("prep");
		 //verify mandatory fields - Creating item from home page
		 nonSyscoPrepItem().verifyPrepItemMandatoryFields();
		 //enter product details
		 product().enterPrepItemDetails(data.strProductName1, data.strNickName1, data.strProductId1, data.strPack1, data.strSize1, data.strWeight1,data.strPrice1); 		 
		 //tap next button
		 generic().tapNextButton();		 	 
		 //verify select expenses screen is displayed
		 nonSyscoPrepItem().verifySelectCategoryPage();		 
		//validate the list of categories in select categories screen - 
		 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName1, true);   
		 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName2, true);   
		 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName3, true);   		 
		 //select one category form list of categories
		 nonSyscoPrepItem().selectCategory(data.strCategoryName2);
		 //tap next
		 generic().tapNextButton();		 
		 //verify select location page is displayed
		 nonSyscoPrepItem().verifySelectLocationPage();
		//validate the list of location in select locations screen
		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName1, true); 
		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName2, true); 
		//select one location form list of locations
		 nonSyscoPrepItem().selectLocation(data.strLocationName2);	
		 //tap done button
		 generic().tapDoneButton();
		 //wait for 8 seconds
		 generic().waitFor(10);
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //click close in product details page
		 generic().tapClose();        
		 //navigate to track inventory
		 home().tapTrackInventory();
		 //navigate to selected location
		 locations().tapLocation(data.strLocationName2);
		 //verify item present in location
		 locations().verifyItemPresentInLocation(data.strProductId1, "UPCID", true);
		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);
		 //verify category of item
		 locations().verifyItemCategoryInItemList(data.strProductName1,data.strCategoryName2);
		 //tap on item 
		 locations().selectAnItemFromProductList(data.strProductName1);
		 //add code for verify product details if needed
		 //verify location name in product details page
		 product().verifyLocation(data.strLocationName2);
		//close app
		 generic().closeApp();
  }
    
  
	
	/******************************************************************************************
	 * Name : INV_NSI_010_Add_Prep_Item_CustomCat_CategoryAsLocation																									
	 * 
	 * Description : User should be able to add a non sysco item to inventory with custom category, custom category as location and list of suppliers. 
	 * 
	 * Manual Test cases : INV_NSI_010
	 * 
	 * Author : Periyasamy Nainar
	 * 
	 * Date : 10/11/2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log
	 * Date						Author						Description
	 * -----------------------------------------------------------------------------------------
	
	 ******************************************************************************************/

	@Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"NonSyscoPrepItems","NonSyscoPrepItems_iOS2","CriticalBatchAndroid","CriticalPatchIOS"}, description = "Add non sysco item to inventory with supplier list and custom category and custom category as location")

	public void INV_NSI_010_Add_Prep_Item_CustomCat_CategoryAsLocation(NonSyscoPrepItemObject data) throws Exception {	
	
		//Login to app
		 component().login(data.strUserName, data.strPassword);
		//Set up Inventory -  Can plug it in once the set inventory screens are stable
		 //INV_NSI_ - custom list + custom category as location + custom category
		 component().setupInventorywithCustomListCustomCategoryAsLocationCustomCat(data.strListName1, data.strCategoryNames, data.strCategoryTypes, data.strCategoryNames.split("/")[0], data.strLocationName1+"/"+data.strLocationName2+"/"+data.strLocationName3);
		//Tap Create Prep item
		 home().tapCreatePrepItem();
		//Verify multi step setup flow is displayed
		 nonSyscoPrepItem().verifyPrepMultiStepSetUpFlow();
		 //verify Add New Supplier option is displayed
		 nonSyscoPrepItem().verifyAddSupplierOption(false); 
		 //verify product details page is displayed
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //Tap on previous button
		 generic().tapCancel();
		 //Tap on create prep item 
		 home().tapCreatePrepItem();
		 //verify product details page is displayed
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //verify product page fields displayed
		 nonSyscoPrepItem().verifyProductPageFields("prep");
		 //verify mandatory fields - Creating item from home page
		 nonSyscoPrepItem().verifyPrepItemMandatoryFields();
		 //enter product details
		 product().enterPrepItemDetails(data.strProductName1, data.strNickName1, data.strProductId1, data.strPack1, data.strSize1, data.strWeight1,data.strPrice1); 		 
		 //tap next button
		 generic().tapNextButton();		 	 
		 //verify select expenses screen is displayed
		 nonSyscoPrepItem().verifySelectCategoryPage();		 
		 //validate all suggested categories are displayed in category list
		 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName1, true); 
		 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName2, true); 
		 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName3, true); 
		 //select one category form list of categories
		// nonSyscoPrepItem().selectCategory(data.strCategoryName1);
		 //tap next
		 generic().tapNextButton();		 
		 //verify select location page is displayed
		 nonSyscoPrepItem().verifySelectLocationPage();
		//validate the list of location in select locations screen
		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName1, true); 
		//select one location form list of locations
		 nonSyscoPrepItem().selectLocation(data.strLocationName1);	
		 //tap done button
		 generic().tapDoneButton();
		 //wait for 8 seconds
		 generic().waitFor(10);
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //click close in product details page
		 generic().tapClose();        
		 //navigate to track inventory
		 home().tapTrackInventory();
		 //navigate to selected location
		 locations().tapLocation(data.strLocationName1);
		 //verify item present in location
		 locations().verifyItemPresentInLocation(data.strProductId1, "UPCID", true);
		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);
		 //verify category of item
		 locations().verifyItemCategoryInItemList(data.strProductName1,data.strCategoryName1);
		 //tap on item 
		 locations().selectAnItemFromProductList(data.strProductName1);
		 //add code for verify product details if needed
		 //verify location name in product details page
		 product().verifyLocation(data.strLocationName1);
		//close app
		 generic().closeApp();
	}
	
    
	/******************************************************************************************
	  * Name : INV_NSI_011_Add_NonSysco_Item_ExpenseCatNotSetup_NoSupplierList_LocQtyUOM
	  * 
	  * Description : User should be able to add a prep item to inventory with expense category not setup during initial setup+ no supplier list, verify qty and uom attribute in selection location screen
	  * 
	  * Manual Test cases : INV_NSI_011
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 10/02/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  ******************************************************************************************/
    @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"NonSyscoPrepItems","NonSyscoPrepItems_iOS1","NonSyscoPrepItems_Defect"}, description = "Add prep item to inventory with expense category not setup")
	 public void INV_NSI_011_Add_NonSysco_Item_ExpenseCatNotSetup_NoSupplierList_LocQtyUOM(NonSyscoPrepItemObject data) throws Exception {	
   	
    	//Login to app
		 component().login(data.strUserName, data.strPassword);
		//Set up Inventory -  Can plug it in once the set inventory screens are stable
		 component().setupInventorywithOGDefaultLocDefaultCat();
	        // Delete expense categories
			 component().deleteallexpensecategories();
		 
		 //all button and page validations are covered in previous 5 Tc's for prep item 
		 //Adding new validation in select locations page for uom qty, uom attribute and multi select location		 
		//Tap Create Non-Sysco item
		 home().tapCreateNonSyscoItem();
		 //click on Add new Supplier option
		 nonSyscoPrepItem().tapAddNewSupplier();			
		 //enter supplier name
		 nonSyscoPrepItem().enterSupplierName(data.strSupplierName1);			
		 //tap on save button
		 generic().tapSaveButton();
		 //verify newly created supplier name is displayed
		 nonSyscoPrepItem().verifySupplierInSupplierList(data.strSupplierName1, true);		
		 //verify newly created supplier is auto-selected
//		 nonSyscoPrepItem().verifySupplierSelected(data.strSupplierName1);  		
		 //tap next
		 generic().tapNextButton();
		 //verify product details page is displayed
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //enter product details
		 product().enterNonSyscoItemDetails(data.strProductName1, data.strNickName1, data.strProductBrand1, data.strProductId1, data.strPack1, data.strSize1, data.strWeight1, data.strPrice1);
		 //tap next button
		 generic().tapNextButton();		 
		 //verify select expenses screen is displayed
		 nonSyscoPrepItem().verifySelectCategoryPage();
		 //tap on add new expense category
		 nonSyscoPrepItem().tapAddNewCategoryExpense();
		 //Tap add new category and enter category details
		 nonSyscoPrepItem().enterCategoryDetails(data.strCategoryName1, data.strCategoryType1);
		 //Tap on save button
		 generic().tapSaveButton();		 
		 //verify newly created category  is displayed
		 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName1, true);   
//QUERY - Newly created category is not selected by default , now adding a line of code to select supplier to avoid the blocking 
// But this line of code needs to be removed once the issue is fixed/ this behavior is expected	 
		 nonSyscoPrepItem().selectCategory(data.strCategoryName1);		 
		 //verify newly created category is selected
//		 nonSyscoPrepItem().verifyCategorySelected(data.strCategoryName1);
		 //tap next
		 generic().tapNextButton();
		 //verify select location page is displayed
		 nonSyscoPrepItem().verifySelectLocationPage();  
		 //Tap on add new location button
		 nonSyscoPrepItem().tapAddNewLocation();	 
		//Tap add new location and enter location details
		 nonSyscoPrepItem().enterLocationDetails(data.strLocationName1, data.strLocationType1);
		 //tap on save button
		 generic().tapSaveButton();    
		 //verify newly created location is displayed
		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName1, true); 
//QUERY - Newly created category is not selected by default , now adding a line of code to select supplier to avoid the blocking 
// But this line of code needs to be removed once the issue is fixed/ this behavior is expected	 
		 //nonSyscoPrepItem().selectLocation(data.strLocationName1);   -- Created location already created.       
		 //verify quantity and qtyUOM attribute is displayed next to selected location
		 nonSyscoPrepItem().verifyLocationQtyIAndUOMAttrFields(data.strLocationName1);
		 //Enter quantity for selected location
		 nonSyscoPrepItem().enterQuantity(data.strLocationName1, data.strQty1);   
		 //Tap on uom attribute to change the quantity
		 nonSyscoPrepItem().tapQuantityUOMAttribute(data.strLocationName1);
		 //select the Attibute value from the modal - 
		 generic().selectValueFromDropdown(data.strUOMAttribute1, "Selected UOM Attribute value from UOM Attribute selection modal as: "+ data.strUOMAttribute1); 		 
		 //select one existing location to verify whether the user is able to select both newly created & old location
		 nonSyscoPrepItem().selectLocation(data.strLocationName2);
		 //verify quantity and qtyUOM attribute is displayed next to selected location
		 nonSyscoPrepItem().verifyLocationQtyIAndUOMAttrFields(data.strLocationName2);
		 //Enter quantity for selected location
		 nonSyscoPrepItem().enterQuantity(data.strLocationName2, data.strQty2);   
		 //Tap on uom attribute to change the quantity
		 nonSyscoPrepItem().tapQuantityUOMAttribute(data.strLocationName2);
		 //select the Attribute value from the modal - 
		 generic().selectValueFromDropdown(data.strUOMAttribute2, "Selected UOM Attribute value from UOM Attribute selection modal as: " + data.strUOMAttribute2);	 		 
		 //tap done button
		 generic().tapDoneButton();
		 //wait for 8 seconds
		 generic().waitFor(10);
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //validation to verify product details in non editable mode - Once its working move to some TC in top
		 product().verifyProductDetails(data.strProductName1, data.strNickName1, "", data.strProductId1, data.strPack1, data.strSize1, data.strWeight1, data.strCategoryName1,data.strLocations,data.strLocationQty,data.strLocationQtyUOMAttr); 
		 //click close in product details page
		 generic().tapClose(); 
		 //navigate to track inventory
		 home().tapTrackInventory();
		 //navigate to selected location
		 locations().tapLocation(data.strLocationName1);
		 //verify item present in location
		 locations().verifyItemPresentInLocation(data.strProductId1, "UPCID", true);
		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);
		 //verify category of item - As the item present in 2 location, other location name should be display with category
		 locations().verifyItemCategoryInItemList(data.strProductName1,data.strCategoryName1+" / "+ data.strLocationName2);
		 //tap on item 
		 locations().selectAnItemFromProductList(data.strProductName1);
		 //add code for verify product details if needed
		 //verify locaiton qty and UOM attribute is displayed correctly
		 product().verifyProductDetails(data.strProductName1, data.strNickName1, "", data.strProductId1, data.strPack1, data.strSize1, data.strWeight1, data.strCategoryName1,data.strLocations,data.strLocationQty,data.strLocationQtyUOMAttr);
		//Tap on close
		 generic().tapClose();
		 //Tap on back 
		 generic().tapBack();
		//navigate to selected location
		 locations().tapLocation(data.strLocationName2);
		 //verify item present in location
		 locations().verifyItemPresentInLocation(data.strProductId1, "UPCID", true);
		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);
		 //verify category of item - As the item present in 2 location, other location name should be display with category
		 locations().verifyItemCategoryInItemList(data.strProductName1,data.strCategoryName1+" / "+ data.strLocationName1);
		 //tap on item 
		 locations().selectAnItemFromProductList(data.strProductName1);
		 //add code for verify product details if needed
		 //verify locaiton qty and UOM attribute is displayed correctly
		 product().verifyProductDetails(data.strProductName1, data.strNickName1, "", data.strProductId1, data.strPack1, data.strSize1, data.strWeight1, data.strCategoryName1,data.strLocations,data.strLocationQty,data.strLocationQtyUOMAttr);
		//close app
		 generic().closeApp();
    }
    
	
	
    /******************************************************************************************
  	  * Name : INV_NSI_012_Add_NonSysco_Item_DefaultCat_DefaultLoc_SupplierList_LocQtyUOM
  	  * 
  	  * Description : User should be able to add a non sysco item to inventory with expense category not setup during initial setup + supplier list  ,verify qty and uom attribute in selection location screen
  	  * 
  	  * Manual Test cases : INV_NSI_012
  	  * 
  	  * Author : Periyasamy Nainar
  	  * 
  	  * Date : 10/02/2016
  	  * 
  	  * Notes : NA
  	  * 
  	  * Modification Log
  	  * Date						Author						Description
  	  * -----------------------------------------------------------------------------------------
  	  ******************************************************************************************/
      @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"NonSyscoPrepItems","NonSyscoPrepItems_iOS1","CriticalBatchAndroid"}, description = "Add prep item to inventory with expense category not setup")
  	 public void INV_NSI_012_Add_NonSysco_Item_DefaultCat_DefaultLoc_SupplierList_LocQtyUOM(NonSyscoPrepItemObject data) throws Exception {	
     	
      	//Login to app
  		 component().login(data.strUserName, data.strPassword);
  		//Set up Inventory -  Can plug it in once the set inventory screens are stable
  		 component().setupInventorywithOGDefaultLocDefaultCat();
  		 
  		 
  		 //all button and page validations are covered in previous 5 Tc's for prep item 
		 //Adding new validation in select locations page for uom qty, uom attribute and multi select location		 
	
  		 //create two suppliers as pre-requisite for this script 
		 component().createSupplier(data.strSupplierName1, data.strPhoneNumber, data.strAddress, "", data.strEmail, "");
		 component().createSupplier(data.strSupplierName2, data.strPhoneNumber, data.strAddress, "123", "", "");
		//Tap Create Non-Sysco item
		 home().tapCreateNonSyscoItem();
		 //validate the user is able to view list of suppliers
		 nonSyscoPrepItem().verifySupplierInSupplierList(data.strSupplierName1, true);	
		 nonSyscoPrepItem().verifySupplierInSupplierList(data.strSupplierName2, true);	
		 //select one supplier from supplier list
		 nonSyscoPrepItem().selectSupplier(data.strSupplierName2);
		 //tap next
		 generic().tapNextButton();		 
		 //verify product details page is displayed
		 nonSyscoPrepItem().verifyProductDetailsPage();
		 //enter product details
		 product().enterNonSyscoItemDetails(data.strProductName1, data.strNickName1, data.strProductBrand1, data.strProductId1, data.strPack1, data.strSize1, data.strWeight1, data.strPrice1); 		 
		 //tap next button
		 generic().tapNextButton();	
  		 //verify select expenses screen is displayed
  		 nonSyscoPrepItem().verifySelectCategoryPage();		 
		 //validate the list of categories in select categories screen
		 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName1, true);   
		 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName2, true);   
		 //select one category form list of categories
		 nonSyscoPrepItem().selectCategory(data.strCategoryName1);
		 //tap next
		 generic().tapNextButton();		 
		 //verify select location page is displayed
		 nonSyscoPrepItem().verifySelectLocationPage();
		//validate the list of location in select locations screen
		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName1, true); 
		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName2, true); 
		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName3, true); 
		//select two locations with quanity and UOM attributes 
		 nonSyscoPrepItem().selectLocation(data.strLocationName1);          
		 //verify quantity and qtyUOM attribute is displayed next to selected location
		 nonSyscoPrepItem().verifyLocationQtyIAndUOMAttrFields(data.strLocationName1);
		 //Enter quantity for selected location
		 nonSyscoPrepItem().enterQuantity(data.strLocationName1, data.strQty1);   
		 //Tap on uom attribute to change the quantity
		 nonSyscoPrepItem().tapQuantityUOMAttribute(data.strLocationName1);
		 //select the Attibute value from the modal - 
		 generic().selectValueFromDropdown(data.strUOMAttribute1, "Selected UOM Attribute value from UOM Attribute selection modal as: "+ data.strUOMAttribute1); 		 
		 //select one existing location to verify whether the user is able to select both newly created & old location
		 nonSyscoPrepItem().selectLocation(data.strLocationName2);
		 //verify quantity and qtyUOM attribute is displayed next to selected location
		 nonSyscoPrepItem().verifyLocationQtyIAndUOMAttrFields(data.strLocationName2);
		 //Enter quantity for selected location
		 nonSyscoPrepItem().enterQuantity(data.strLocationName2, data.strQty2);   
		 //Tap on uom attribute to change the quantity
		 nonSyscoPrepItem().tapQuantityUOMAttribute(data.strLocationName2);
		 //select the Attribute value from the modal - 
		 generic().selectValueFromDropdown(data.strUOMAttribute2, "Selected UOM Attribute value from UOM Attribute selection modal as: " + data.strUOMAttribute2);
		 //tap done button
		 generic().tapDoneButton();
  		 //wait for 8 seconds
  		 generic().waitFor(10);
  		 nonSyscoPrepItem().verifyProductDetailsPage();
  		 //Add a validation to verify product details in non editable mode - Once its working move to some TC in top
		 product().verifyProductDetails(data.strProductName1, data.strNickName1, "", data.strProductId1, data.strPack1, data.strSize1, data.strWeight1, data.strCategoryName1,data.strLocations,data.strLocationQty,data.strLocationQtyUOMAttr);
  		 //click close in product details page
  		 generic().tapClose();       
  		 //navigate to track inventory
  		 home().tapTrackInventory();
  		 //navigate to selected location
		 locations().tapLocation(data.strLocationName1);
		 //verify item present in location
		 locations().verifyItemPresentInLocation(data.strProductId1, "UPCID", true);
		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);
		 //verify category of item - As the item present in 2 location, other location name should be display with category
		 locations().verifyItemCategoryInItemList(data.strProductName1,data.strCategoryName1+" / "+ data.strLocationName2);
		 //tap on item 
		 locations().selectAnItemFromProductList(data.strProductName1);
		 //add code for verify product details if needed
		 //verify locaiton qty and UOM attribute is displayed correctly
		 product().verifyProductDetails(data.strProductName1, data.strNickName1, "", data.strProductId1, data.strPack1, data.strSize1, data.strWeight1, data.strCategoryName1,data.strLocations,data.strLocationQty,data.strLocationQtyUOMAttr);
		//Tap on close
		 generic().tapClose();
		 //Tap on back 
		 generic().tapBack();
		//navigate to selected location
		 locations().tapLocation(data.strLocationName2);
		 //verify item present in location
		 locations().verifyItemPresentInLocation(data.strProductId1, "UPCID", true);
		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);
		 //verify category of item - As the item present in 2 location, other location name should be display with category
		 locations().verifyItemCategoryInItemList(data.strProductName1,data.strCategoryName1+" / "+ data.strLocationName1);
		 //tap on item 
		 locations().selectAnItemFromProductList(data.strProductName1);
		 //add code for verify product details if needed
		 //verify locaiton qty and UOM attribute is displayed correctly
		 product().verifyProductDetails(data.strProductName1, data.strNickName1, "", data.strProductId1, data.strPack1, data.strSize1, data.strWeight1, data.strCategoryName1,data.strLocations,data.strLocationQty,data.strLocationQtyUOMAttr);
  		//close app
  		 generic().closeApp();
      }
	 
	   /******************************************************************************************
	 	  * Name : INV_NSI_013_Add_Prep_Item_ExpenseCatNotSetup_LocQtyUOM
	 	  * 
	 	  * Description : User should be able to add a prep item to inventory with expense category not setup during initial setup, verify qty and uom attribute in selection location screen
	 	  * 
	 	  * Manual Test cases : INV_NSI_013
	 	  * 
	 	  * Author : Periyasamy Nainar
	 	  * 
	 	  * Date : 9/30/2016
	 	  * 
	 	  * Notes : NA
	 	  * 
	 	  * Modification Log
	 	  * Date						Author						Description
	 	  * -----------------------------------------------------------------------------------------
	 	  ******************************************************************************************/
	     @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"NonSyscoPrepItems","NonSyscoPrepItems_iOS1","NonSyscoPrepItems_Defect"}, description = "Add prep item to inventory with expense category not setup")
	 	 public void INV_NSI_013_Add_Prep_Item_ExpenseCatNotSetup_LocQtyUOM(NonSyscoPrepItemObject data) throws Exception {	
	    	
	     	//Login to app
	 		 component().login(data.strUserName, data.strPassword);
	 		//Set up Inventory -  Can plug it in once the set inventory screens are stable
	 		 // - Order guide + Default location + NO category
	 		component().setupInventorywithOGDefaultLocDefaultCat();
	        // Delete expense categories
			 component().deleteallexpensecategories();
	 		 
	 		 //all button and page validations are covered in previous 5 Tc's for prep item 
	 		 //Adding new validation in select locations page for uom qty, uom attribute and multi select location		 
	 		 //Tap on create prep itme 
	 		 home().tapCreatePrepItem();
	 		 //verify product details page is displayed
	 		 nonSyscoPrepItem().verifyProductDetailsPage();
	 		 //enter product details
	 		 product().enterPrepItemDetails(data.strProductName1, data.strNickName1, data.strProductId1, data.strPack1, data.strSize1, data.strWeight1,data.strPrice1); 		 
	 		 //tap next button
	 		 generic().tapNextButton();		 
	 		 //verify select expenses screen is displayed
	 		 nonSyscoPrepItem().verifySelectCategoryPage();
	 		 //tap on add new expense category
	 		 nonSyscoPrepItem().tapAddNewCategoryExpense();
	 		 //Tap add new category and enter category details
	 		 nonSyscoPrepItem().enterCategoryDetails(data.strCategoryName1, data.strCategoryType1);
	 		 //Tap on save button
	 		 generic().tapSaveButton();		 
	 		 //verify newly created category  is displayed
	 		 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName1, true);   
	 //QUERY - Newly created category is not selected by default , now adding a line of code to select supplier to avoid the blocking 
	 // But this line of code needs to be removed once the issue is fixed/ this behavior is expected	 
	 		 nonSyscoPrepItem().selectCategory(data.strCategoryName1);		 
	 		 //verify newly created category is selected
//	 		 nonSyscoPrepItem().verifyCategorySelected(data.strCategoryName1);
	 		 //tap next
	 		 generic().tapNextButton();
	 		 //verify select location page is displayed
	 		 nonSyscoPrepItem().verifySelectLocationPage();  
	 		 //Tap on add new location button
	 		 nonSyscoPrepItem().tapAddNewLocation();	 
	 		//Tap add new location and enter location details
	 		 nonSyscoPrepItem().enterLocationDetails(data.strLocationName1, data.strLocationType1);
	 		 //tap on save button
	 		 generic().tapSaveButton();    
	 		 //verify newly created location is displayed
	 		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName1, true); 
	 //QUERY - Newly created category is not selected by default , now adding a line of code to select supplier to avoid the blocking 
	 // But this line of code needs to be removed once the issue is fixed/ this behavior is expected	 
	 		// nonSyscoPrepItem().selectLocation(data.strLocationName1);     -- newly created location name already selected.     
	 		 //verify quantity and qtyUOM attribute is displayed next to selected location
	 		 nonSyscoPrepItem().verifyLocationQtyIAndUOMAttrFields(data.strLocationName1);
	 		 //Enter quantity for selected location
	 		 nonSyscoPrepItem().enterQuantity(data.strLocationName1, data.strQty1);   
	 		 //Tap on uom attribute to change the quantity
	 		 nonSyscoPrepItem().tapQuantityUOMAttribute(data.strLocationName1);
	 		 //select the Attibute value from the modal - 
	 		 generic().selectValueFromDropdown(data.strUOMAttribute1, "Selected UOM Attribute value from UOM Attribute selection modal as: "+ data.strUOMAttribute1); 		 
	 		 //select one existing location to verify whether the user is able to select both newly created & old location
	 		 nonSyscoPrepItem().selectLocation(data.strLocationName2);
	 		 //verify quantity and qtyUOM attribute is displayed next to selected location
	 		 nonSyscoPrepItem().verifyLocationQtyIAndUOMAttrFields(data.strLocationName2);
	 		 //Enter quantity for selected location
	 		 nonSyscoPrepItem().enterQuantity(data.strLocationName2, data.strQty2);   
	 		 //Tap on uom attribute to change the quantity
	 		 nonSyscoPrepItem().tapQuantityUOMAttribute(data.strLocationName2);
	 		 //select the Attribute value from the modal - 
	 		 generic().selectValueFromDropdown(data.strUOMAttribute2, "Selected UOM Attribute value from UOM Attribute selection modal as: " + data.strUOMAttribute2);	 		 
	 		 //tap done button
	 		 generic().tapDoneButton();
	 		 //wait for 8 seconds
	 		 generic().waitFor(10);
	 		 nonSyscoPrepItem().verifyProductDetailsPage();
	 		 //validation to verify product details in non editable mode - Once its working move to some TC in top
	 		 product().verifyProductDetails(data.strProductName1, data.strNickName1, "", data.strProductId1, data.strPack1, data.strSize1, data.strWeight1, data.strCategoryName1,data.strLocations,data.strLocationQty,data.strLocationQtyUOMAttr); 
	 		 //click close in product details page
	 		 generic().tapClose(); 
	 		 //navigate to track inventory
	 		 home().tapTrackInventory();
	 		 //navigate to selected location
	 		 locations().tapLocation(data.strLocationName1);
	 		 //verify item present in location
	 		 locations().verifyItemPresentInLocation(data.strProductId1, "UPCID", true);
	 		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);
	 		 //verify category of item - As the item present in 2 location, other location name should be display with category
	 		 locations().verifyItemCategoryInItemList(data.strProductName1,data.strCategoryName1+" / "+ data.strLocationName2);
	 		 //tap on item 
	 		 locations().selectAnItemFromProductList(data.strProductName1);
	 		 //add code for verify product details if needed
	 		 //verify locaiton qty and UOM attribute is displayed correctly
	 		 product().verifyProductDetails(data.strProductName1, data.strNickName1, "", data.strProductId1, data.strPack1, data.strSize1, data.strWeight1, data.strCategoryName1,data.strLocations,data.strLocationQty,data.strLocationQtyUOMAttr);
	 		//Tap on close
	 		 generic().tapClose();
	 		 //Tap on back 
	 		 generic().tapBack();
	 		//navigate to selected location
	 		 locations().tapLocation(data.strLocationName2);
	 		 //verify item present in location
	 		 locations().verifyItemPresentInLocation(data.strProductId1, "UPCID", true);
	 		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);
	 		 //verify category of item - As the item present in 2 location, other location name should be display with category
	 		 locations().verifyItemCategoryInItemList(data.strProductName1,data.strCategoryName1+" / "+ data.strLocationName1);
	 		 //tap on item 
	 		 locations().selectAnItemFromProductList(data.strProductName1);
	 		 //add code for verify product details if needed
	 		 //verify locaiton qty and UOM attribute is displayed correctly
	 		 product().verifyProductDetails(data.strProductName1, data.strNickName1, "", data.strProductId1, data.strPack1, data.strSize1, data.strWeight1, data.strCategoryName1,data.strLocations,data.strLocationQty,data.strLocationQtyUOMAttr);
	 		//close app
	 		 generic().closeApp();
	     }
	     
	     

	     /******************************************************************************************
	   	  * Name : INV_NSI_006_Add_Prep_Item_ExpenseCatNotSetup_NoSupplierList
	   	  * 
	   	  * Description : User should be able to add a prep item to inventory with expense category not setup during initial setup  verify qty and uom attribute in selection location screen
	   	  * 
	   	  * Manual Test cases : INV_NSI_006
	   	  * 
	   	  * Author : Periyasamy Nainar
	   	  * 
	   	  * Date : 9/30/2016
	   	  * 
	   	  * Notes : NA
	   	  * 
	   	  * Modification Log
	   	  * Date						Author						Description
	   	  * -----------------------------------------------------------------------------------------
	   	  ******************************************************************************************/
	       @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"NonSyscoPrepItems","NonSyscoPrepItems_iOS2"}, description = "Add prep item to inventory with expense category not setup")
	   	 public void INV_NSI_014_Add_Prep_Item_DefaultCat_DefaultLoc_LocQtyUOM(NonSyscoPrepItemObject data) throws Exception {	
	      	
	       	//Login to app
	   		 component().login(data.strUserName, data.strPassword);
	   		//Set up Inventory -  Can plug it in once the set inventory screens are stable
	   		 // - Order guide + Default location + default category
	   		 component().setupInventorywithOGDefaultLocDefaultCat();
	   		 
	   		 //all button and page validations are covered in previous 5 Tc's for prep item 
	 		 //Adding new validation in select locations page for uom qty, uom attribute and multi select location		 
	 		 //Tap on create prep itme 
	 		 home().tapCreatePrepItem();
	 		 //verify product details page is displayed
	 		 nonSyscoPrepItem().verifyProductDetailsPage();
	 		 //enter product details
	 		 product().enterPrepItemDetails(data.strProductName1, data.strNickName1, data.strProductId1, data.strPack1, data.strSize1, data.strWeight1,data.strPrice1); 		 
	 		 //tap next button
	 		 generic().tapNextButton();	
	   		 //verify select expenses screen is displayed
	   		 nonSyscoPrepItem().verifySelectCategoryPage();		 
	 		 //validate the list of categories in select categories screen
	 		 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName1, true);   
	 		 nonSyscoPrepItem().verifyCategoryInCategoryList(data.strCategoryName2, true);   
	 		 //select one category form list of categories
	 		 nonSyscoPrepItem().selectCategory(data.strCategoryName1);
	 		 //tap next
	 		 generic().tapNextButton();		 
	 		 //verify select location page is displayed
	 		 nonSyscoPrepItem().verifySelectLocationPage();
	 		//validate the list of location in select locations screen
	 		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName1, true); 
	 		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName2, true); 
	 		 nonSyscoPrepItem().verifyLocationInList(data.strLocationName3, true); 
	 		//select two locations with quanity and UOM attributes 
	 		 nonSyscoPrepItem().selectLocation(data.strLocationName1);          
	 		 //verify quantity and qtyUOM attribute is displayed next to selected location
	 		 nonSyscoPrepItem().verifyLocationQtyIAndUOMAttrFields(data.strLocationName1);
	 		 //Enter quantity for selected location
	 		 nonSyscoPrepItem().enterQuantity(data.strLocationName1, data.strQty1);   
	 		 //Tap on uom attribute to change the quantity
	 		 nonSyscoPrepItem().tapQuantityUOMAttribute(data.strLocationName1);
	 		 //select the Attibute value from the modal - 
	 		 generic().selectValueFromDropdown(data.strUOMAttribute1, "Selected UOM Attribute value from UOM Attribute selection modal as: "+ data.strUOMAttribute1); 		 
	 		 //select one existing location to verify whether the user is able to select both newly created & old location
	 		 nonSyscoPrepItem().selectLocation(data.strLocationName2);
	 		 //verify quantity and qtyUOM attribute is displayed next to selected location
	 		 nonSyscoPrepItem().verifyLocationQtyIAndUOMAttrFields(data.strLocationName2);
	 		 //Enter quantity for selected location
	 		 nonSyscoPrepItem().enterQuantity(data.strLocationName2, data.strQty2);     
	 		 //Tap on uom attribute to change the quantity
			 nonSyscoPrepItem().tapQuantityUOMAttribute(data.strLocationName2);
	 		 //select the Attribute value from the modal - 
	 		 generic().selectValueFromDropdown(data.strUOMAttribute2, "Selected UOM Attribute value from UOM Attribute selection modal as: " + data.strUOMAttribute2);
	 		 //tap done button
	 		 generic().tapDoneButton();
	   		 //wait for 8 seconds
	   		 generic().waitFor(10);
	   		 nonSyscoPrepItem().verifyProductDetailsPage();
	   		 //Add a validation to verify product details in non editable mode - Once its working move to some TC in top
	 		 product().verifyProductDetails(data.strProductName1, data.strNickName1, "", data.strProductId1, data.strPack1, data.strSize1, data.strWeight1, data.strCategoryName1,data.strLocations,data.strLocationQty,data.strLocationQtyUOMAttr);
	   		 //click close in product details page
	   		 generic().tapClose();       
	   		 //navigate to track inventory
	   		 home().tapTrackInventory();
	   		 //navigate to selected location
	 		 locations().tapLocation(data.strLocationName1);
	 		 //verify item present in location
	 		 locations().verifyItemPresentInLocation(data.strProductId1, "UPCID", true);
	 		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);
	 		 //verify category of item - As the item present in 2 location, other location name should be display with category
	 		 locations().verifyItemCategoryInItemList(data.strProductName1,data.strCategoryName1+" / "+ data.strLocationName2);
	 		 //tap on item 
	 		 locations().selectAnItemFromProductList(data.strProductName1);
	 		 //add code for verify product details if needed
	 		 //verify locaiton qty and UOM attribute is displayed correctly
	 		 product().verifyProductDetails(data.strProductName1, data.strNickName1, "", data.strProductId1, data.strPack1, data.strSize1, data.strWeight1, data.strCategoryName1,data.strLocations,data.strLocationQty,data.strLocationQtyUOMAttr);
	 		//Tap on close
	 		 generic().tapClose();
	 		 //Tap on back 
	 		 generic().tapBack();
	 		//navigate to selected location
	 		 locations().tapLocation(data.strLocationName2);
	 		 //verify item present in location
	 		 locations().verifyItemPresentInLocation(data.strProductId1, "UPCID", true);
	 		 locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);
	 		 //verify category of item - As the item present in 2 location, other location name should be display with category
	 		 locations().verifyItemCategoryInItemList(data.strProductName1,data.strCategoryName1+" / "+ data.strLocationName1);
	 		 //tap on item 
	 		 locations().selectAnItemFromProductList(data.strProductName1);
	 		 //add code for verify product details if needed
	 		 //verify locaiton qty and UOM attribute is displayed correctly
	 		 product().verifyProductDetails(data.strProductName1, data.strNickName1, "", data.strProductId1, data.strPack1, data.strSize1, data.strWeight1, data.strCategoryName1,data.strLocations,data.strLocationQty,data.strLocationQtyUOMAttr);
	   		//close app
	   		 generic().closeApp();
	       }
	       
	       
	  	 /******************************************************************************************
	  	  * Name : INV_NSI_015_Error_Message_ChangeUOMAttriubte_ForNonSyscoItem
	  	  * 
	  	  * Description : verify that  specific required fields on non-Sysco and prep items to allow for conversions between two units-of-measure
	  	  * 
	  	  * Manual Test cases : INV_UI_015
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
	     @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"NonSyscoPrepItems","NonSyscoPrepItems_iOS1","NonSyscoPrepItems_Defect"}, description = "Add non sysco item to inventory with supplier list and default category")
	  	 public void INV_NSI_015_Error_Message_ChangeUOMAttriubte_ForNonSyscoItem(NonSyscoPrepItemObject data) throws Exception {	
	    	
	     	//Login to app
	  		 component().login(data.strUserName, data.strPassword);
	  		 //INV_NSI_001 - Order guide + Default location + Default category	
	  		 component().setupInventorywithOGDefaultLocDefaultCat();		 
	  		 //create two suppliers as pre-requisite for this script 
	  		 component().createSupplier(data.strSupplierName1, "", "", "", "", "");   // location name - supplier name
	  		 //tap on track inventory from home page
	  		 home().tapTrackInventory();
	  		 //tap on any location
	  		 locations().tapLocation(data.strLocationName1);
	  		 //tap add from list page
	  		 generic().tapAddFromListPage();
			 //verify Add item form is displayed
			 locations().verifyAddItemFormPageDisplayed();
			 //tap create non Sysco item
			 locations().tapCreateNonSyscoItem();
			 //verify Add Product Page is displayed
		 	 locations().verifyAddProductPageDisplayed();
			 //Enter Mandatory fields
			 product().enterNonSyscoItemDetails(data.strProductName1, data.strNickName1, data.strProductBrand1, data.strProductId1, "", "", "", data.strPrice1);
			 //Select Supplier
		 	 product().selectSupplier();
			 generic().selectValueFromDropdown(data.strSupplierName1,"Supplier "+data.strSupplierName1+" is selected");
			 //Select Expense Category
			 product().tapExpenseCategoryNonSysco();
			 generic().selectValueFromDropdown(data.strCategoryName1,"Expense Category "+data.strCategoryName1+" is selected");
			 //tap done
			 generic().tapDone();
		 	 //verify location page is displayed
			 generic().waitForPageToLoad(6);
			 locations().verifyLocationPageDisplayed(data.strLocationName1);
			 //Verify the newly added item is displayed in the locations page
			 locations().verifyItemPresentInLocation(data.strProductName1,"Product Name",true);	
			 //tap on item 
			 locations().selectAnItemFromProductList(data.strProductName1);			 
			 //verify product details page
			 product().verifyProductDetailsPage();
			 //Tap on edit button
			 generic().tapEdit();
			 //Change UOM attribute against location to EA and verify the pack error message
			 product().selectLocationQuantityUOM("EA", "1");
			 //verify pack error message in product details page
			 product().verifyPackAndWeightErrorMessage(true, false);
			 //Change UOM attribute against location to LB and verify the weight error message
			 product().selectLocationQuantityUOM("LB", "1");
			 //verify weight error message in product details page
			 product().verifyPackAndWeightErrorMessage(false, true);
			 //Change UOM attribute against location to LB and verify the weight error message
			 product().selectLocationQuantityUOM("OZ", "1");
			 //verify weight error message in product details page
			 product().verifyPackAndWeightErrorMessage(false, true);
			 //change price UOM Attribute to EA and veriyf pack e& weight error message
			 product().changePriceUOMAttribute("EA");
			//verify weight & pack error message in product details page
			 product().verifyPackAndWeightErrorMessage(true, true);
			 //Change UOM attribute against location to LB and verify the weight error message
			 product().selectLocationQuantityUOM("LB", "1");
			 //verify weight & pack error message in product details page
			 product().verifyPackAndWeightErrorMessage(true, true);	  		 
	  		//close app
	  		 generic().closeApp();
	     }
	     
	     
	     /******************************************************************************************
	  	  * Name : INV_NSI_015a_Error_Message_ChangeUOMAttriubte_ForPrepItem
	  	  * 
	  	  * Description : verify that  specific required fields on  prep items to allow for conversions between two units-of-measure
	  	  * 
	  	  * Manual Test cases : INV_UI_015
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
	     @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"NonSyscoPrepItems","NonSyscoPrepItems_iOS1","NonSyscoPrepItems_Defect"}, description = "Add prep item to inventory with supplier list and default category")
	  	 public void INV_NSI_015a_Error_Message_ChangeUOMAttriubte_ForPrepItem(NonSyscoPrepItemObject data) throws Exception {	
	    	
	     	//Login to app
	  		 component().login(data.strUserName, data.strPassword);
	  		 //INV_NSI_001 - Order guide + Default location + Default category	
 		 component().setupInventorywithOGDefaultLocDefaultCat();
	  		 //tap on track inventory from home page
	  		 home().tapTrackInventory();
	  		 //tap on any location
	  		 locations().tapLocation(data.strLocationName1);
	  		 //tap add from list page
	  		 generic().tapAddFromListPage();
			 //verify Add item form is displayed
			 locations().verifyAddItemFormPageDisplayed();
			 //tap on create prep item 
			 locations().tapCreatePrepItem();
			 //verify Add Product Page is displayed
			 locations().verifyAddProductPageDisplayed();
			 //Select Expense Category
			 product().enterPrepItemDetails(data.strProductName1, data.strNickName1,  data.strProductId1, "", "", "", data.strPrice1);
			 //Select Supplier
		 	 product().selectSupplier();
			// generic().selectValueFromDropdown(data.strSupplierName1,"Supplier "+data.strSupplierName1+" is selected");
			 //product().tapExpenseCategoryPrep();
			 generic().selectValueFromDropdown(data.strCategoryName1,"Expense Category "+data.strCategoryName1+" is selected");
			 //Enter Mandatory fields
			 
			 //tap done
			 generic().tapDone();
		 	 //verify location page is displayed
			 generic().waitForPageToLoad(6);
			 locations().verifyLocationPageDisplayed(data.strLocationName1);
			 //Verify the newly added item is displayed in the locations page
			 locations().verifyItemPresentInLocation(data.strProductName1,"Product Name",true);	
			 //tap on item 
			 locations().selectAnItemFromProductList(data.strProductName1);			 
			 //verify product details page
			 product().verifyProductDetailsPage();
			 //Tap on edit button
			 generic().tapEdit();
			 //Change UOM attribute against location to EA and verify the pack error message
			 product().selectLocationQuantityUOM("EA", "1");
			 //verify pack error message in product details page
			 product().verifyPackAndWeightErrorMessage(true, false);
			 //Change UOM attribute against location to LB and verify the weight error message
			 product().selectLocationQuantityUOM("LB", "1");
			 //verify weight error message in product details page
			 product().verifyPackAndWeightErrorMessage(false, true);
			 //Change UOM attribute against location to LB and verify the weight error message
			 product().selectLocationQuantityUOM("OZ", "1");
			 //verify weight error message in product details page
			 product().verifyPackAndWeightErrorMessage(false, true);
			 //change price UOM Attribute to EA and verify pack e& weight error message
			 product().changePriceUOMAttribute("EA");
			//verify weight & pack error message in product details page
			 product().verifyPackAndWeightErrorMessage(true, true);
			 //Change UOM attribute against location to LB and verify the weight error message
			 product().selectLocationQuantityUOM("LB", "1");
			 //verify weight & pack error message in product details page
			 product().verifyPackAndWeightErrorMessage(true, true);	  		 
	  		//close app
	  		 generic().closeApp();
	     }
}
