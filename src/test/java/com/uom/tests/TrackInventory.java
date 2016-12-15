
package com.uom.tests;

import java.io.IOException;
import java.lang.reflect.Method;

import com.DataRead.Excel;
import com.framework.*;
import com.framework.configuration.ConfigFile;
import com.framework.utils.RetryAnalyzer;

import com.framework.utils.UOMTestNGListener;
import com.google.common.base.Supplier;
import com.uom.excelSheetObject.ManageLocationObject;
import com.uom.excelSheetObject.SetupInventoryObject;
import com.uom.excelSheetObject.SuppliersObject;
import com.uom.excelSheetObject.TrackInventoryObject;
import com.uom.pageFactory.PageFactory;
import com.uom.pages.common.*;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

@Listeners(value = UOMTestNGListener.class)
public class TrackInventory extends PageFactory {

	public static String[][] completeArray = null;
	Starter starter = new Starter();

	@BeforeClass(alwaysRun = true)
	public void getData() throws Exception {
		String strDataFilePath;
		Excel newExcel = new Excel();		
		if(ConfigFile.getProperty("brand").equalsIgnoreCase("ios")){
			completeArray = newExcel.read("test-data/TestData.xls", "TrackInventory_iOS");
		}
		else if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
			completeArray = newExcel.read("test-data/TestData.xls", "TrackInventory");
		}
	}

	@BeforeMethod(alwaysRun = true)
	public void initiate() throws Exception {

		startup();
	}

	@DataProvider(name = "DP1", parallel = false)
	public Object[][] getData(Method method) throws Exception {
		Excel newExcel = new Excel();
		TrackInventoryObject sheetObj = new TrackInventoryObject();
		System.out.println(method.getName());
		String[][] MethodArray = newExcel.getMethodData(completeArray, method.getName());
		Object[][] retObjArr = sheetObj.getTestData(MethodArray);
		return (retObjArr);
	}

	@AfterMethod
	public void clean() {
		cleanUp();
	}

	/******************************************************************************************
	 * Name : INV_TI_030_Verify_CustomLoc_Products_CustomCategory
	 * 
	 * Description : User should be able to add,view details and delete a
	 * supplier(). Also verify the cancel button's functionality in the add
	 * suppliers page
	 * 
	 * Manual Test cases : INV_TI_030
	 * 
	 * Author : Arun Mathai
	 * 
	 * Date : 9/23/2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/

	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory",
			"TI_Others","CriticalPatchIOS" }, description = "Verify CustomLocations in the TrackInventory")
	public void INV_TI_030_Validate_Inventory_Setup_Custom_List_Custom_Loc_Cust_Category_SingleLocation(
			TrackInventoryObject data) throws Exception

	{

		// Login to app
		component().login(data.strUserName, data.strPassword);
		// Set up Inventory - Can plug it in once the set inventory screens are
		// stable
		component().setupInventorywithCustomListCustomLocCustomCatAssignOnlySomeItems(data.strLocationNames,
				data.strLocationTypes, data.strCategoryNames, data.strCategoryTypes, data.strLocationName1,
				data.strCategoryName1, data.strListName1);
		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations in the list as entered in the setuplocations
		// page
		locations().verifyLocationInList(data.strLocationName1, true);
		locations().verifyLocationInList(data.strLocationName2, true);
		locations().verifyLocationInList(data.strLocationName3, true);

		locations().verifyItemCountIsDisplayedForAllLocations();

		locations().tapLocation(data.strLocationName1);

		locations().verifyItemListViewIsDisplayed();

		locations().verifyAssignedItemsInLocation(data.strLocationName1);

		// to verify whether the location in the product card is same
		locations().verifyLocationOfAllItemsInList(data.strLocationName1);

		locations().verifyCategoryInProductCardDetails(data.strCategoryName1);

		locations().verifyProductCardDetailsInList(true);

		generic().tapBack();

		locations().tapLocation("No Location");
		locations().verifyItemsInNoLocations(data.strProductName1);

		// locations().verifyLocationsInNoLocations();
		generic().tapBack();
		// close app
		generic().closeApp();

	}

	/******************************************************************************************
	 * Name :
	 * INV_TI_031_Validate_Inventory_Setup_Multiple_Custom_List_Def_Loc_Def_Category_ItemInMultipleLoc
	 * 
	 * Description : User should be able to add,view details and delete a
	 * supplier(). Also verify the cancel button's functionality in the add
	 * suppliers page
	 * 
	 * Manual Test cases : INV_TI_031_Verify
	 * 
	 * Author : Arun Mathai
	 * 
	 * Date : 9/23/2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/

	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory","CriticalBatch1"}, description = "Verify inventory setup inventory setup (Setup Custom List(Multiple List)+Default Loc+Default Cat (Items Multiple Location)")
	public void INV_TI_031_Validate_Inventory_Setup_Multiple_Custom_List_Def_Loc_Def_Category_ItemInMultipleLoc(
			TrackInventoryObject data) throws Exception {

		// Login to app
		component().login(data.strUserName, data.strPassword);
		// Set up Inventory - INV_SI_016
		component().setupInventorywithMultipleCustomListDefaultLocationDefaultCategory_ItemsMultipleLocation(
				data.strListName1, data.strListName2);
		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verify whether custom locations are populated as expected
		locations().verifyLocationInListMultipleLocation(data.strListName1 + "/" + data.strListName2);
		// verify count of items in paranthesis is displayed for all locations
		locations().verifyItemCountIsDisplayedForAllLocations();
		// tap on a location
		locations().tapLocation(data.strListName1);
		// verify location page is displayed
		locations().verifyLocationPage(data.strListName1);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strListName1);
		// tap back
		generic().tapBack();
		// tap on a location
		locations().tapLocation(data.strListName2);
		// verify location page is displayed
		locations().verifyLocationPage(data.strListName2);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strListName2);
		// verify product card fields in list
		locations().verifyProductCardDetailsInList(true);
		// verify category of items in location
		locations().verifyItemCategoryOfAllItemsInList("default", "");
		// tap back
		generic().tapBack();
		// verify no items in no location
		locations().tapLocation("No Location");
		locations().verifyLocationPage("No Location");
		locations().verifyNoItemsInLocation();
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name :
	 * INV_TI_001_002_003_005_006_009_Verify_Default_Locations_Indicator_UOM_Update_Quantity
	 * 
	 * Description : User should be able to verify default locations, verify
	 * brand indicator, verify default UOM attribute and to update quantity from
	 * both product card and inventory list
	 * 
	 * Manual Test cases :
	 * INV_TI_001,INV_TI_002,INV_TI_003,INV_TI_005,INV_TI_006,INV_TI_009,
	 * INV_TI_010
	 * 
	 * Author : Gayathri Anand
	 * 
	 * Date : 9/27/2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory", "Track Inv NR","TI_UOMValidation","CriticalBatch1","CriticalPatchIOS" }, description = "Verify Default Locations,Indicator and UOM and Update Quantity")

	public void INV_TI_001_002_003_005_006_009_Verify_Default_Locations_Indicator_UOM_Update_Quantity(
			TrackInventoryObject data) throws Exception {
		String strRandomSupplier = RandomStringUtils.randomAlphanumeric(7);
		// Login to app
		component().login(data.strUserName, data.strPassword);
		// Set up Inventory with default location
		component().setupInventorywithOGDefaultLocDefaultCat();
		// add a nonsysco item to inventory
		generic().waitForPageLoadAndroid(3);
		component().createNonSyscoitem(strRandomSupplier, data.strProductName3, "", data.strProductBrand1,
				data.strProductID1, "6", "", "", "12", data.strCategoryName1, data.strLocationName);
		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verifying whether default locations are displayed
		locations().verifyDefaultLocations();
		// verify order of default locations
		locations().verifyOrderOfDefaultLocations();
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// verify indicator for sysco branded item
		locations().verifyIndicator("Sysco Branded", data.strProductName1);
		// verify indicator for sysco supplied item
		locations().verifyIndicator("Sysco Non Branded", data.strProductName2);
		// verify indicator not displayed for non sysco item
		locations().verifyIndicator("Non Sysco", data.strProductName3);
		// verify text color for non sysco item is same as sysco item
		locations().verifyNonSyscoItemTextColorSameAsSyscoItem(data.strProductName3, data.strProductName1);
		// tap back
		generic().tapBack();
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify qty and UOM attribute is displayed for an item
		locations().verifyQuantityAndUOMAttribute("1");
		// select an item
		locations().selectAnItemWithIndex("1");
		// verify default inventory UOM is CS
		product().verifyUOMAttribute_ProductDetailsPage("CS");
		// edit quantity (enter whole number)
		generic().tapEdit();

		product().enterLocationQuantity(data.strQuantity1, "1");
		generic().tapDone();
		// verify quantity
		product().verifyQuantity(data.strQuantity1);
		// edit quantity (enter decimal number)
		generic().tapEdit();
		product().enterLocationQuantity(data.strQuantity2, "1");
		generic().tapDone();
		// verify quantity
		product().verifyQuantity(data.strQuantity2);
		// delete quantity
		generic().tapEdit();
		product().clearQuantity("1");
		generic().tapDone();
		// verify quantity cleared
		product().verifyQuantityIsEmpty();
		// edit quantity
		generic().tapEdit();
		product().enterLocationQuantity(data.strQuantity1, "1");
		// verify quantity
		generic().tapDone();
		product().verifyQuantity(data.strQuantity1);
		// update quantity
		generic().tapEdit();
		product().enterLocationQuantity(data.strQuantity3, "1");
		generic().tapDone();
		// verify quantity
		product().verifyQuantity(data.strQuantity3);
		// log out
		generic().tapClose();
		generic().tapBack();
		generic().tapBack();
		home().logout();
		// log in
		component().login(data.strUserName, data.strPassword, false);
		// navigate to track inventory
		generic().waitForPageLoadAndroid(2);
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify quantity
		generic().waitForPageLoadAndroid(3);
		// locations().verifyQuantityAndUOMAttributeWithItemName(data.strProductName1,
		// data.strQuantity3, "CS");
		locations().verifyQuantityAfterReLogin(data.strQuantity3, "1");
		/*
		 * select an item locations().selectAnItem(data.strProductName1,true);
		 * //verify quantity // product().verifyQuantity(data.strQuantity3);
		 * locations().verifyQuantity(data.strQuantity3, "2");
		 */

		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name : INV_TI_007_Search_Item_Inventory_With_Default_Locations
	 * 
	 * Description : User should be able to search for an item using item
	 * #/Brand/Description(single word/Multi word)/(Pack & Size)/Nickname while
	 * inventory setup using default locations.
	 * 
	 * Manual Test cases : INV_TI_007
	 * 
	 * Author : Gayathri Anand
	 * 
	 * Date : 9/27/2016
	 * 
	 * Notes : Created only one script. Multiple rows are added in the datasheet
	 * for each type of search keyword (Eg.itemId,Brand,Description etc)
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory",
			"TI_DefLocNoDependency","CriticalBatch1" }, description = "Verify search for an item, while inventory setup using default location")
	public void INV_TI_007_Search_Item_Inventory_With_Default_Locations(TrackInventoryObject data) throws Exception {
		// Login to app
		component().login(data.strUserName, data.strPassword);
		// Set up Inventory with default location
		component().setupInventorywithOGDefaultLocDefaultCat();
		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verifying whether default locations are displayed
		locations().verifyDefaultLocations();
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// search for item using itemid
		locations().searchItem(data.strSearchKeyword);
		// verify item is displayed in search results
		locations().verifySearchedItems(data.strSearchKeyword);
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name :
	 * INV_TI_007_Search_Item_Inventory_With_Default_Locations_NonSyscoItem
	 * 
	 * Description : User should be able to search for an item using item
	 * #/Brand/Description(single word/Multi word)/(Pack & Size)/Nickname while
	 * inventory setup using default locations.
	 * 
	 * Manual Test cases : INV_TI_007
	 * 
	 * Author : Gayathri Anand
	 * 
	 * Date : 9/27/2016
	 * 
	 * Notes : Created only one script. Multiple rows are added in the datasheet
	 * for each type of search keyword (Eg.itemId,Brand,Description etc)
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory",
			"TI_DefLocNoDependency" }, description = "Verify search for an item, while inventory setup using default location")
	public void INV_TI_007_Search_Item_Inventory_With_Default_Locations_NonSyscoItem(TrackInventoryObject data)
			throws Exception {
		String strRandomSupplier = RandomStringUtils.randomAlphanumeric(7);
		// Login to app
		component().login(data.strUserName, data.strPassword);
		// Set up Inventory with default location
		component().setupInventorywithOGDefaultLocDefaultCat();
		// add a nonsysco item to inventory
		component().createNonSyscoitem(strRandomSupplier, data.strProductName1, data.strNickName1,
				data.strProductBrand1, data.strProductID1, "", "", "", "12", data.strCategoryName1,
				data.strLocationName);
		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verifying whether default locations are displayed
		locations().verifyDefaultLocations();
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// search for item using keyword
		locations().searchItem(data.strSearchKeyword);
		// verify item is displayed in search results
		locations().verifySearchedNonSyscoItems(data.strProductID1);
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name : INV_TI_008_Search_Item_Inventory_With_Custom_Locations
	 * 
	 * Description : User should be able to search for an item using item
	 * #/Brand/Description(single word/Multi word)/(Pack & Size)/Nickname while
	 * inventory setup using custom locations.
	 * 
	 * Manual Test cases : INV_TI_008
	 * 
	 * Author : Gayathri Anand
	 * 
	 * Date : 9/27/2016
	 * 
	 * Notes : Created only one script. Multiple rows are added in the datasheet
	 * for each type of search keyword (Eg.itemId,Brand,Description etc)
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory","TI_CustLocDefaultCat","CriticalPatchIOS" }, description = "Verify search for an item, while inventory setup using Custom location")
	public void INV_TI_008_Search_Item_Inventory_With_Custom_Locations(TrackInventoryObject data) throws Exception {
		// Login to app
		component().login(data.strUserName, data.strPassword);
		// setup inventory - default location - default category
		// component().setupInventorywithOGCustomLocationDefaultCategory();
		component().setupInventorywithOGCustomLocDefaultCategorySingleLocationSelection(data.strLocationName,
				data.strLocationType1, false);
		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verifying whether custom locations are displayed
		locations().verifyLocationInList(data.strLocationName, true);
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// Add nickName
		locations().selectAnItem(data.strProductName1, true);
		generic().tapEdit();
		generic().waitForPageLoadAndroid(5);
		product().enterNickName(data.strProductName2);
		generic().tapDone();
		generic().tapClose();
		// search for item using keyword
		locations().searchItem(data.strSearchKeyword);
		// verify item is displayed in search results
		locations().verifySearchedItems(data.strItemNames);
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name :
	 * INV_TI_008_Search_Item_Inventory_With_Custom_Locations_NonSyscoItem
	 * 
	 * Description : User should be able to search for an item using item
	 * #/Brand/Description(single word/Multi word)/(Pack & Size)/Nickname while
	 * inventory setup using custom locations.
	 * 
	 * Manual Test cases : INV_TI_008
	 * 
	 * Author : Gayathri Anand
	 * 
	 * Date : 9/27/2016
	 * 
	 * Notes : Created only one script. Multiple rows are added in the datasheet
	 * for each type of search keyword (Eg.itemId,Brand,Description etc)
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory",
			"TI_CustLocDefaultCat" }, description = "Verify search for an item, while inventory setup using Custom location")
	public void INV_TI_008_Search_Item_Inventory_With_Custom_Locations_NonSyscoItem(TrackInventoryObject data)
			throws Exception {
		String strRandomSupplier = RandomStringUtils.randomAlphanumeric(7);
		// Login to app
		component().login(data.strUserName, data.strPassword);
		// Set up Inventory with default location
		component().setupInventorywithOGCustomLocDefaultCategorySingleLocationSelection(data.strLocationNames, data.strLocationTypes);
		// add a nonsysco item to inventory
		//component().createSupplier(strRandomSupplier + "Non", "9846318808", "", "", "", "");
		component().createNonSyscoitem(strRandomSupplier, data.strProductName1, data.strNickName1,
				data.strProductBrand1, data.strProductID1, "", "", "", "12", data.strCategoryName1,
				data.strLocationName);
		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verifying whether custom locations are displayed
		locations().verifyLocationInList(data.strLocationName, true);
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// search for item using keyword
		locations().searchItem(data.strSearchKeyword);
		// verify item is displayed in search results
		locations().verifySearchedNonSyscoItems(data.strProductID1);
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name :
	 * INV_TI_011_016_034_Validate_Inventory_Setup_OG_Def_Loc_Def_Cat_Locations_Item_Count_Category
	 * 
	 * Description : User should be able to validate the inventory setup
	 * (OG+Default Loc+Default Cat) and to verify the item count is displayed
	 * for each location in locations page. Also verifies the category of items
	 * in a location
	 * 
	 * Manual Test cases : INV_TI_011,INV_TI_016,INV_TI_034,INV_SI_001
	 * 
	 * Author : Gayathri Anand
	 * 
	 * Date : 9/27/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory",
			"TI_DefLocNoDependency","CriticalBatch1"}, description = "Verify inventory setup (OG+Default Loc+Default Cat) and Item count and category for a location")
	public void INV_TI_011_016_034_Validate_Inventory_Setup_OG_Def_Loc_Def_Cat_Locations_Item_Count_Category(
			TrackInventoryObject data) throws Exception {
		// Login to app
		component().login(data.strUserName, data.strPassword);
		// setup track inventory - precondition - INV_SI_001
		component().setupInventorywithOGDefaultLocDefaultCat();
		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verifying whether default locations are displayed
		locations().verifyDefaultLocations();
		// verify order of default locations
		locations().verifyOrderOfDefaultLocations();
		// verify count of items in paranthesis is displayed for all locations
		locations().verifyItemCountIsDisplayedForAllLocations();
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strLocationName);
		// tap back
		generic().tapBack();
		// tap on a location
		locations().tapLocation(data.strLocationName1);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName1);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strLocationName1);
		// tap back
		generic().tapBack();
		// tap on a location
		locations().tapLocation(data.strLocationName2);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName2);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strLocationName2);
		// verify product card fields in list
		locations().verifyProductCardDetailsInList(true);
		// verify category of items in location
		locations().verifyItemCategoryOfAllItemsInList("default", "");
		// tap back
		generic().tapBack();
		// verify no items in no location
		locations().tapLocation("No Location");
		locations().verifyLocationPage("No Location");
		locations().verifyNoItemsInLocation();
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name :
	 * INV_TI_019_012_Validate_Inventory_Setup_OG_Def_Loc_Sugg12_Cat_Locations_Category
	 * 
	 * Description : User should be able to validate the inventory setup
	 * (OG+Default Loc+Suggested 12 Cat). Also verifies the category of items in
	 * a location
	 * 
	 * Manual Test cases : INV_TI_019,INV_TI_012,INV_SI_004
	 * 
	 * Author : Gayathri Anand
	 * 
	 * Date : 9/27/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory",
			"TI_DefLocNoDependency","CriticalBatch1"}, description = "Verify inventory setup (OG+Default Loc+Suggested12 Cat) and category for a location")
	public void INV_TI_019_012_Validate_Inventory_Setup_OG_Def_Loc_Sugg12_Cat_Locations_Category(
			TrackInventoryObject data) throws Exception {
		// Login to app
		component().login(data.strUserName, data.strPassword);
		// setup track inventory - precondition - INV_SI_004
		component().setupInventorywithOGDefaultLocSugg12Cat();
		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verifying whether default locations are displayed
		locations().verifyDefaultLocations();
		// verify order of default locations
		locations().verifyOrderOfDefaultLocations();
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strLocationName);
		// tap back
		generic().tapBack();
		// tap on a location
		locations().tapLocation(data.strLocationName1);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName1);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strLocationName1);
		// tap back
		generic().tapBack();
		// tap on a location
		locations().tapLocation(data.strLocationName2);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName2);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strLocationName2);
		// verify product card fields in list
		locations().verifyProductCardDetailsInList(true);
		// verify category of items in location
		locations().verifyItemCategoryOfAllItemsInList("suggested", "");
		// tap back
		generic().tapBack();
		// verify no items in no location
		locations().tapLocation("No Location");
		locations().verifyLocationPage("No Location");
		locations().verifyNoItemsInLocation();
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name : INV_TI_049_DefaultLocation_AddNewLocation_VerifyProductDetails
	 * 
	 * Description : Add new location from track inventory page and verify newly
	 * added location is available in selection location picker from product
	 * page.
	 * 
	 * Manual Test cases : INV_TI_049
	 * 
	 * Author : Periyasamy Nainar
	 * 
	 * Date : 9/29/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/

	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory", "Track Inv NR",
			"TI_ManageLoc"}, description = "Verify search for an item, while inventory setup using Custom location")
	public void INV_TI_049_DefaultLocation_AddNewLocation_VerifyProductDetails(TrackInventoryObject data)
			throws Exception {
		// Login to app
		component().login(data.strUserName, data.strPassword);
		// Set up Inventory - INV_SI_001 - Can plug it in once the set inventory
		// screens are stable
		// Setup OG+Default Loc+Default Cat
		component().setupInventorywithOGDefaultLocDefaultCat();
		// Create new location from track inventory
		generic().waitForPageLoadAndroid(3);
		component().createLocationFromTrackInventory(data.strLocationName1, data.strLocationType1);
		// navigate to track inventory
		generic().waitForPageLoadAndroid(2);
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// tap on a location
		locations().tapLocation(data.strLocationName2);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName2);
		// Tap on any item and navigate to product card details page
		locations().selectAnItemFromProductList(data.strProductName1);
		// verify product details page is loaded
		product().verifyProductDetailsPage();
		// verify selected location name is populated in location label -
		// disable
		product().verifyLocation(data.strLocationName2);
		// Tap on Edit
		generic().tapEdit();
		// Tap on Location selection drop down
		product().tapLocation("0");
		// verify location picker is displayed or not
		generic().verifyDropDownDisplay("Location");
		// verify newly created location is available for selection in drop down
		generic().verifyValueInDropdown(data.strLocationName1, "Location dropdown", true);
		// select the newly added location
		generic().selectValueFromDropdown(data.strLocationName1, "is selected from ");
		// verify the selected location value is populated in product page -
		// enabled mode
		product().verifyLocationAfterEdit(data.strLocationName1, 0);
		// product().verifyLocation(data.strLocationName1);
		// Tap on done
		generic().tapDone();
		// verify selected location name is populated in location label -
		// disable
		product().verifyLocation(data.strLocationName1);
		// tap on close
		generic().tapClose();
		// tap on back
		generic().tapBack();
		// verify locations page
		locations().verifyLocationsPage();
		// tap on new created locations page
		locations().tapLocation(data.strLocationName1);
		// verify an item present
		locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);
		// Tap on same item and navigate to product card details page
		locations().selectAnItemFromProductList(data.strProductName1);
		// verify the selected location value is displayed in product page
		// verify product details page is loaded
		product().verifyProductDetailsPage();
		// verify selected location name is populated in location label -
		// disable
		product().verifyLocation(data.strLocationName1);
		// tap on close
		generic().tapClose();
		// tap on back - Below are additional validation to ensure item is not
		// available in previous location.
		generic().tapBack();
		// verify locations page
		locations().verifyLocationsPage();
		// tap on new created locations page
		locations().tapLocation(data.strLocationName2);
		// verify item is not present in old location as its moved to differnt
		// location
		locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", false);
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name : INV_TI_050_DefaultLocation_AddNewLocation_VerifyProductDetails
	 * 
	 * Description : Add new location from manage inventory page and verify
	 * newly added location is available in selection location picker from
	 * product page.
	 * 
	 * Manual Test cases : INV_TI_050
	 * 
	 * Author : Periyasamy Nainar
	 * 
	 * Date : 10/11/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/

	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory", "Track Inv NR",
			"TI_ManageLoc","CriticalBatch1"}, description = "Verify search for an item, while inventory setup using Custom location")
	public void INV_TI_050_DefaultLocation_AddNewLocation_VerifyProductDetails(TrackInventoryObject data)
			throws Exception {

		// Login to app
		component().login(data.strUserName, data.strPassword);
		// Set up Inventory - INV_SI_001 - Can plug it in once the set inventory
		// screens are stable
		// Setup OG+Default Loc + Default Cat
		component().setupInventorywithOGDefaultLocDefaultCat();
		// Create new location from manage location page
		generic().waitForPageLoadAndroid(3);
		component().createLocationFromManageLocation(data.strLocationName1, data.strLocationType1);
		// navigate to track inventory
		generic().waitForPageLoadAndroid(2);
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// tap on any location
		locations().tapLocation(data.strLocationName2);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName2);
		// Tap on any item and navigate to product card details page
		locations().selectAnItemFromProductList(data.strProductName1);
		// verify product details page is loaded
		product().verifyProductDetailsPage();
		// verify selected location name is populated in location label -
		// disable
		product().verifyLocation(data.strLocationName2);
		// Tap on Edit
		generic().tapEdit();
		// Tap on Location selection drop down
		product().tapLocation("0");
		// verify location picker is displayed or not
		generic().verifyDropDownDisplay("Location");
		// verify newly created location is available for selection in drop down
		generic().verifyValueInDropdown(data.strLocationName1, "Location dropdown", true);
		// select the newly added location
		generic().selectValueFromDropdown(data.strLocationName1, "is selected from ");
		// verify the selected location value is populated in product page -
		// enabled mode
		product().verifyLocationAfterEdit(data.strLocationName1, 0);
		// Tap on done
		generic().tapDone();
		// verify selected location name is populated in location label -
		// disable
		product().verifyLocation(data.strLocationName1);
		// tap on close
		generic().tapClose();
		// tap on back
		generic().tapBack();
		// verify locations page
		locations().verifyLocationsPage();
		// tap on new created locations page
		locations().tapLocation(data.strLocationName1);
		// verify an item present
		locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", true);
		// Tap on same item and navigate to product card details page
		locations().selectAnItemFromProductList(data.strProductName1);
		// verify product details page is loaded
		product().verifyProductDetailsPage();
		// verify selected location name is populated in location label -
		// disable
		product().verifyLocation(data.strLocationName1);
		// tap on close
		generic().tapClose();
		// tap on back - Below are additional validation to ensure item is not
		// available in previous location.
		generic().tapBack();
		// verify locations page
		locations().verifyLocationsPage();
		// tap on new created locations page
		locations().tapLocation(data.strLocationName2);
		// verify item is not present in old location as its moved to different
		// location
		locations().verifyItemPresentInLocation(data.strProductName1, "Product Name", false);
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name : INV_TI_051_DefaultLocation_EditLocation_VerifyProductDetails
	 * 
	 * Description : Edit location from Manage location page and verify newly
	 * Edited location details are reflected in track inventory and product
	 * details page
	 * 
	 * Manual Test cases : INV_TI_051
	 * 
	 * Author : Periyasamy Nainar
	 * 
	 * Date : 10/04/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/

	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory",
			"TI_ManageLoc"}, description = "Verify updated location name in product details for default locations")
	public void INV_TI_051_DefaultLocation_EditLocation_VerifyProductDetails(TrackInventoryObject data)
			throws Exception {

		// Login to app
		component().login(data.strUserName, data.strPassword);
		// Set up Inventory - INV_SI_001 - Can plug it in once the set inventory
		// screens are stable
		// Setup OG+Default Loc+Default Cat
		component().setupInventorywithOGDefaultLocDefaultCat();
		// Navigating to location page and get all product ids before changing
		// location name from manage location page for validaiton
		// navigate to track inventory
		home().tapTrackInventory();
		// tap on a location
		locations().tapLocation(data.strLocationName1);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName1);
		// get All product id's from location page
		locations().getAllItemsFromLocation();
		// Tap on back button
		generic().tapBack();
		// Tap on back button
		generic().tapBack();
		// wait for 5 seconds to load the page
		generic().waitFor(5);
		// Edit location from manage locations page
		component().editLocationFromManageLocation(data.strLocationName1, data.strLocationName2, data.strLocationType2);
		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify edited location name is appearing in location list view page
		locations().verifyLocationInList(data.strLocationName2, true);
		// verify old location name is not displayed in location list view page
		locations().verifyLocationInList(data.strLocationName1, false);
		// tap on a location
		locations().tapLocation(data.strLocationName2);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName2);
		// verify the same items are displayed in location list before changing
		// the location name
		locations().verifyAllItemsInLocation();
		// Tap on any item and navigate to product card details page
		locations().selectAnItemFromProductList(data.strProductName1);
		// verify product details page is loaded
		product().verifyProductDetailsPage();
		// verify selected location name is populated in location drop down
		product().verifyLocation(data.strLocationName2);
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name : INV_TI_052_CustomLocation_EditLocation_VerifyProductDetails
	 * 
	 * Description : Edit location from Manage location page and verify newly
	 * Edited location details are reflected in track inventory and product
	 * details page for setup inv with custom location
	 * 
	 * Manual Test cases : INV_TI_052
	 * 
	 * Author : Periyasamy Nainar
	 * 
	 * Date : 10/04/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/

	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory",
			"TI_ManageLoc"}, description = "Verify updated location name in product details for custom locations")
	public void INV_TI_052_CustomLocation_EditLocation_VerifyProductDetails(TrackInventoryObject data)
			throws Exception {

		// Login to app
		component().login(data.strUserName, data.strPassword);
		// Set up Inventory - INV_SI_001 - Can plug it in once the set inventory
		// screens are stable
		// Setup OG+ Custom Loc+Default Cat
		component().setupInventorywithOGCustomLocDefaultCategorySingleLocationSelection(data.strLocationNames,data.strLocationTypes);
		// Navigating to location page and get all product ids before changing
		// location name from manage location page for validation
		// navigate to track inventory
		home().tapTrackInventory();
		// tap on a location
		locations().tapLocation(data.strLocationName1);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName1);
		// get All product id's from location page
		locations().getAllItemsFromLocation();
		// Tap on back button
		generic().tapBack();
		// Tap on back button
		generic().tapBack();
		// wait for 5 seconds
		generic().waitFor(5);
		// Edit location from manage locations page
		component().editLocationFromManageLocation(data.strLocationName1, data.strLocationName2, data.strLocationType2);
		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify edited location name is appearing in location list view page
		locations().verifyLocationInList(data.strLocationName2, true);
		// verify old location name is not displayed in location list view page
		locations().verifyLocationInList(data.strLocationName1, false);
		// tap on a location

		locations().tapLocation(data.strLocationName2);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName2);
		// verify the same items are displayed in location list before changing
		// the location name
		locations().verifyAllItemsInLocation();
		// Tap on any item and navigate to product card details page
		locations().selectAnItemFromProductList(data.strProductName1);
		// verify product details page is loaded
		product().verifyProductDetailsPage();
		// verify selected location name is populated in location drop down
		product().verifyLocation(data.strLocationName2);
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name :
	 * INV__ML_009_011_TI_053_CustomLocation_UpdateDeleteLocation_VerifyProductDetails_ItemInMultipleLocation
	 * 
	 * Description : Edit/Delete locations from manage location page, item
	 * should be available in multiple location and verify same items are
	 * displayed in updated locations in inventory list page.
	 * 
	 * Manual Test cases : INV_TI_053 and INV_ML_009 and INV_ML_011
	 * 
	 * Author : Periyasamy Nainar
	 * 
	 * Date : 10/11/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
//commenting since the script is already available in Manage Locations
	/*@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory",
			"TI_Others","TrackInventoryRerun" }, description = "verify update location from manage location and product details from track inven")
	public void INV__ML_009_011_TI_053_CustomLocation_UpdateDeleteLocation_VerifyProductDetails_ItemInMultipleLocation(
			TrackInventoryObject data) throws Exception {

		// Login to app
		component().login(data.strUserName, data.strPassword);
		// Below are pre-requisite - Setup done using Custom location and Items
		// exist in multiple location - Item I1 belongs in Location X and Y.
		// update Location X and Y
		// Set up Inventory - INV_SI_003 - Setup OG+ Custom Loc + Default Cat
		component().setupInventorywithOGCustomLocDefaultCategorySingleLocationSelection(
				data.strLocationName1 + "/" + data.strLocationName2 + "/" + "Loc3", "COOLER/FREEZER/DRY");
		// tap on track inventory
		home().tapTrackInventory();
		// tap on any location - loc1
		locations().tapLocation(data.strLocationName1);
		// tap on any product from inventory list page
		locations().selectAnItemFromProductList(data.strProductName1);
		// verify product details page
		product().verifyProductDetailsPage();
		// tap on Edit icon
		generic().tapEdit();
		// tap on add another location
		product().tapOnAddAnotherLocation();
		// tap on location drop down - new one
		product().tapLocation("1");
		// select location from location picker
		generic().selectValueFromDropdown(data.strLocationName2,
				"Selected location '" + data.strLocationName2 + "' from location drop down");
		// tap on done
		generic().tapDone();
		// tap on back
		generic().tapClose();
		generic().tapBack();
		generic().tapBack();

		// tap on track inventory - get item details before updating location
		// details from manage location screen
		home().tapTrackInventory();
		// tap on any location
		locations().tapLocation(data.strLocationName1);
		// get all products from inventory list page
		locations().getAllProductsFromInventoryList(data.strLocationName1);
		// Tap on back
		generic().tapBack();
		// tap on any location
		locations().tapLocation(data.strLocationName2);
		// get all products from second location
		locations().getAllProductsFromInventoryList(data.strLocationName2);
		// Tap on back
		generic().tapBack();
		generic().tapBack();

		// Edit location from manage location page - both loc INV_ML_009. Items
		// in multiple location.
		component().editLocationFromManageLocation(data.strLocationName1, data.strLocationName3, data.strLocationType3);
		component().editLocationFromManageLocation(data.strLocationName2, data.strLocationName, data.strLocationType2);
		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// Inv TI 053 -
		// validate updated location is displayed in track inventory page
		locations().verifyLocationInList(data.strLocationName3, true);
		locations().verifyLocationInList(data.strLocationName, true);
		// old locations should be present in track inventory
		locations().verifyLocationInList(data.strLocationName1, false);
		locations().verifyLocationInList(data.strLocationName2, false);
		// click on any updated location
		locations().tapLocation(data.strLocationName3);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName3);
		// User should be able to view the list of same items - before and after
		// editing location name
		locations().verifyProductsFromInventoryList(data.strLocationName1, data.strLocationName3);
		// Verify if the item belongs to location X and Y , then under location
		// X, the item I1 should also have the updated value of Y
		locations().verifyLocationNameInInventoryList(data.strProductName1, data.strLocationName);
		// Tap on any item and navigate to product card details page
		locations().selectAnItemFromProductList(data.strProductName1);
		// verify product details page is loaded
		product().verifyProductDetailsPage();
		// verify selected location name is populated in location label -
		// disable
		product().verifySelectedLocation("0", data.strLocationName3);
		// verify updated location on 2nd index
		product().verifySelectedLocation("1", data.strLocationName);
		// tap on close button
		generic().tapClose();
		// Tap on back
		generic().tapBack();
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// User should be able to view the list of same items - before and after
		// editing location name
		locations().verifyProductsFromInventoryList(data.strLocationName2, data.strLocationName);
		// Verify if the item belongs to location X and Y , then under location
		// X, the item I1 should also have the updated value of Y
		locations().verifyLocationNameInInventoryList(data.strProductName1, data.strLocationName3);
		// Tap on any item and navigate to product card details page
		locations().selectAnItemFromProductList(data.strProductName1);
		// verify product details page is loaded
		product().verifyProductDetailsPage();
		// verify selected location name is populated in location label -
		// disable
		product().verifySelectedLocation("0", data.strLocationName3);
		// verify updated location on 2nd index
		product().verifySelectedLocation("1", data.strLocationName);
		// tap on close button
		generic().tapClose();
		// Tap on back
		generic().tapBack();
		generic().tapBack();

		// Tap on locations
		home().tapLocations();
		locations().tapLocation(data.strLocationName3);
		// INV_ML_011 - Delete location and verify all the items from the
		// particular location is moved to no location
		// tap on delete button
		locations().tapDeleteButton();
		// verify delete location confirmation modal page
		locations().verifyDeleteConfirmationMessage(data.strLocationName3, "5"); // Defect
																					// on
																					// delete
																					// confirmaiton
																					// modal
																					// item
																					// count
		// tap on yes delete
		generic().tapYesDelete();
		// verify deleted location is not available in locations list
		locations().verifyLocationInList(data.strLocationName3, false);
		// Tap on back
		generic().tapBack();
		// navigate to track inventory
		home().tapTrackInventory();
		// tap on no locations
		locations().tapLocation(data.strLocationNames);
		// verify item count
		locations().verifyDeletedProductsInNoLocationList(data.strLocationName1, data.strLocationNames,
				data.strProductName1);
		// Tap on back
		generic().tapBack();
		// Tap on back
		generic().tapBack();

		// Tap on locations
		home().tapLocations();
		locations().tapLocation(data.strLocationName);
		// INV_ML_011 - Delete location and verify all the items from the
		// particular location is moved to no location
		// tap on delete button
		locations().tapDeleteButton();
		// verify delete location confirmation modal page
		locations().verifyDeleteConfirmationMessage(data.strLocationName, "5"); // Defect
																				// on
																				// delete
																				// confirmaiton
																				// modal
																				// item
																				// count
		// tap on yes delete
		generic().tapYesDelete();
		// verify deleted location is not available in locations list
		locations().verifyLocationInList(data.strLocationName, false);
		// Tap on back
		generic().tapBack();
		// navigate to track inventory
		home().tapTrackInventory();
		// tap on no locations
		locations().tapLocation(data.strLocationNames);
		// verify item count
		locations().verifyDeletedProductsInNoLocationList(data.strLocationName2, data.strLocationNames, "");
		// Tap on back
		generic().tapBack();
		// close app
		generic().closeApp();
	}*/

	/******************************************************************************************
	 * Name :
	 * INV_TI_020_013_Validate_Inventory_Setup_OG_Def_Loc_Custom_Cat_Locations_Category
	 * 
	 * Description : User should be able to validate the inventory setup
	 * (OG+Default Loc+Custom Cat). Also verifies the category of items in a
	 * location
	 * 
	 * Manual Test cases : INV_TI_020,INV_TI_013
	 * 
	 * Author : Gayathri Anand
	 * 
	 * Date : 9/28/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/

	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory",
			"TI_Others" }, description = "Verify inventory setup (OG+Default Loc+Custom Cat) and category for a location")
	public void INV_TI_020_013_Validate_Inventory_Setup_OG_Def_Loc_Custom_Cat_Locations_Category(
			TrackInventoryObject data) throws Exception {

		// Login to app
		component().login(data.strUserName, data.strPassword);

		// setup inventory - INV_SI_005
		component().setupInventorywithOGDefaultLocCustomCategory(data.strCategoryNames, data.strCategoryTypes);

		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verifying whether default locations are displayed
		locations().verifyDefaultLocations();
		// verify order of default locations
		locations().verifyOrderOfDefaultLocations();
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strLocationName);
		// tap back
		generic().tapBack();
		// tap on a location
		locations().tapLocation(data.strLocationName1);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName1);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strLocationName1);
		// tap back
		generic().tapBack();
		// tap on a location
		locations().tapLocation(data.strLocationName2);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName2);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strLocationName2);
		// verify product card fields in list
		locations().verifyProductCardDetailsInList(true);
		// verify category of items in location
		locations().verifyItemCategoryOfAllItemsInList("custom", data.strCategoryNames.split("/"));
		// tap back
		generic().tapBack();
		// verify no items in no location
		locations().tapLocation("No Location");
		locations().verifyLocationPage("No Location");
		locations().verifyNoItemsInLocation();
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name : INV_TI_014_Update_UOM_Default_Locations_Sysco_NonSysco_Items
	 * 
	 * Description : User should be able to update uom for both sysco and non
	 * sysco items with inventory setup using default locations
	 * 
	 * Manual Test cases : INV_TI_014
	 * 
	 * Author : Gayathri Anand
	 * 
	 * Date : 9/29/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory", "Track Inv NR",
			"TI_UOMValidation"}, description = "Verify update uom for both sysco and nonsysco items in default loctions")
	public void INV_TI_014_Update_UOM_Default_Locations_Sysco_NonSysco_Items(TrackInventoryObject data)
			throws Exception {
		// Login to app
		component().login(data.strUserName, data.strPassword);
		component().setupInventorywithOGDefaultLocDefaultCat();
		// add a nonsysco item to inventory
		generic().waitForPageLoadAndroid(3);
		component().createNonSyscoitem(data.strSupplierName1 + "_NS", data.strProductName2, data.strNickName1,
				data.strProductBrand1, data.strProductID1, "6", "", "", "12", data.strCategoryName1,
				data.strLocationName);
		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verifying whether default locations are displayed
		locations().verifyDefaultLocations();
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// select an item
		locations().selectAnItem(data.strProductName1, true);
		// verify default inventory UOM is CS
		generic().waitForPageLoadAndroid(1);
		product().verifyUOMAttribute("CS");
		// tap edit
		generic().tapEdit();
		// update uom
		product().selectLocationQuantityUOM(data.strQuantity1, "1");
		// tap edit
		generic().tapDone();
		// tap close
		generic().tapClose();
		// select a non sysco item
		locations().selectAnItem(data.strProductName2, true);
		// verify default inventory UOM is CS
		generic().waitForPageLoadAndroid(2);
		product().verifyUOMAttribute("CS");
		// tap edit
		generic().tapEdit();
		// update uom
		product().selectLocationQuantityUOM(data.strQuantity1, "1");
		// tap edit
		generic().tapDone();
		// tap close
		generic().tapClose();
		// tap back
		generic().tapBack();
		// tap back
		generic().tapBack();
		home().logout();
		// log in
		component().login(data.strUserName, data.strPassword, false);
		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// select an item
		locations().selectAnItem(data.strProductName1, true);
		// verify default inventory UOM is updated value
		generic().waitForPageLoadAndroid(2);
		product().verifyUOMAttribute(data.strQuantity1);
		// changing uom to default value
		// tap edit
		generic().tapEdit();
		// update uom
		product().selectLocationQuantityUOM("CS", "1");
		// tap edit
		generic().tapDone();
		// tap close
		generic().tapClose();
		// select a non sysco item
		locations().selectAnItem(data.strProductName2, true);
		// verify default inventory UOM is updated value
		generic().waitForPageLoadAndroid(2);
		product().verifyUOMAttribute(data.strQuantity1);
		// changing uom to default value
		// tap edit
		generic().tapEdit();
		// update uom
		product().selectLocationQuantityUOM("CS", "1");
		// tap edit
		generic().tapDone();
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name : INV_TI_015_Update_UOM_Custom_Locations_Sysco_NonSysco_Items
	 * 
	 * Description : User should be able to update uom for both sysco and non
	 * sysco items with inventory setup using custom locations
	 * 
	 * Manual Test cases : INV_TI_015
	 * 
	 * Author : Gayathri Anand
	 * 
	 * Date : 9/29/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory", "Track Inv NR",
			"TI_UOMValidation" }, description = "Verify update uom for both sysco and nonsysco items in custom loctions")
	public void INV_TI_015_Update_UOM_Custom_Locations_Sysco_NonSysco_Items(TrackInventoryObject data)
			throws Exception {
		// Login to app
		component().login(data.strUserName, data.strPassword);
		// Set up Inventory - INV_SI_003 - Setup OG+ Custom Loc + Default Cat
		component().setupInventorywithOGCustomLocDefaultCategorySingleLocationSelection(
				data.strLocationName1 + "/" + data.strLocationName2 + "/" + "Loc3", "COOLER/FREEZER/DRY");
		// add a nonsysco item to inventory
		component().createNonSyscoitem(data.strSupplierName1, data.strProductName2, data.strNickName1,
				data.strProductBrand1, data.strProductID1, "6", "", "", "12", data.strCategoryName1,
				data.strLocationName);
		// navigate to track inventory
		generic().waitForPageLoadAndroid(3);
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verifying whether default locations are displayed
		locations().verifyLocationInList(data.strLocationName, true);
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// select an item
		locations().selectAnItem(data.strProductName1, true);
		// verify default inventory UOM is CS
		generic().waitForPageLoadAndroid(3);
		product().verifyUOMAttribute("CS");
		// tap edit
		generic().tapEdit();
		// update uom
		product().selectLocationQuantityUOM(data.strQuantity1, "1");
		// tap edit
		generic().tapDone();
		// tap close
		generic().tapClose();
		// select a non sysco item
		locations().selectAnItem(data.strProductName2, true);
		// verify default inventory UOM is CS
		generic().waitForPageLoadAndroid(3);
		product().verifyUOMAttribute("CS");
		// tap edit
		generic().tapEdit();
		// update uom
		product().selectLocationQuantityUOM(data.strQuantity1, "1");
		// tap edit
		generic().tapDone();
		// tap close
		generic().tapClose();
		// tap back
		generic().tapBack();
		// tap back
		generic().tapBack();
		home().logout();
		// log in
		component().login(data.strUserName, data.strPassword, false);
		// navigate to track inventory
		generic().waitForPageLoadAndroid(3);
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// select an item
		locations().selectAnItem(data.strProductName1, true);
		// verify default inventory UOM is updated value
		generic().waitForPageLoadAndroid(3);
		product().verifyUOMAttribute(data.strQuantity1);
		// changing uom to default value
		// tap edit
		generic().tapEdit();
		// update uom
		product().selectLocationQuantityUOM("CS", "1");
		// tap edit
		generic().tapDone();
		// tap close
		generic().tapClose();
		// select a non sysco item
		locations().selectAnItem(data.strProductName2, true);
		// verify default inventory UOM is updated value
		generic().waitForPageLoadAndroid(3);
		product().verifyUOMAttribute(data.strQuantity1);
		// changing uom to default value
		// tap edit
		generic().tapEdit();
		// update uom

		product().selectLocationQuantityUOM("CS", "1");
		// tap edit
		generic().tapDone();
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name : INV_TI_032_Validate_Inventory_Setup_OG_Def_Loc_No_Category
	 * 
	 * Description : User should be able to validate the inventory setup
	 * (OG+Default Loc+No Cat)
	 * 
	 * Manual Test cases : INV_TI_032
	 * 
	 * Author : Gayathri Anand
	 * 
	 * Date : 9/30/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventoryInvalid"}, description = "Verify inventory setup (OG+Default Loc+No Cat)")
	public void INV_TI_032_Validate_Inventory_Setup_OG_Def_Loc_No_Category(TrackInventoryObject data) throws Exception {
		// Login to app
		component().login(data.strUserName, data.strPassword);
		// setup inventory - precondition
		component().setupInventorywithOGDefaultLocNoCat();
		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verifying whether default locations are displayed
		locations().verifyDefaultLocations();
		// verify order of default locations
		locations().verifyOrderOfDefaultLocations();
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// verify item list view
		// locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strLocationName);
		// tap back
		generic().tapBack();
		// tap on a location
		locations().tapLocation(data.strLocationName1);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName1);
		// verify item list view
		// locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strLocationName1);
		// tap back
		generic().tapBack();
		// tap on a location
		locations().tapLocation(data.strLocationName2);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName2);
		// verify item list view
		// locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strLocationName2);
		// verify product card fields in list
		locations().verifyProductCardDetailsInList(false);
		// verify category of items in location
		locations().verifyItemCategoryOfAllItemsInList("no category");
		// tap back
		generic().tapBack();
		// verify no items in no location
		locations().tapLocation("No Location");
		locations().verifyLocationPage("No Location");
		locations().verifyNoItemsInLocation();
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name :
	 * INV_TI_025_Validate_Inventory_Setup_Custom_List_My_List_Def_Loc_Def_Category
	 * 
	 * Description : User should be able to validate the inventory setup (Custom
	 * list (My list)+Default Loc+Default Cat)
	 * 
	 * Manual Test cases : INV_TI_025,INV_SI_010
	 * 
	 * Author : Gayathri Anand
	 * 
	 * Date : 9/30/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/

	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory", "Track Inv NR",
			"TI_DefLocNoDependency"}, description = "Verify inventory setup (Custom list (My list)+Default Loc+Default Cat)")
	public void INV_TI_025_Validate_Inventory_Setup_Custom_List_My_List_Def_Loc_Def_Category(TrackInventoryObject data)
			throws Exception {
		// Login to app
		component().login(data.strUserName, data.strPassword);
		// Setup Inventory - Custom list - INV_SI_010
		component().setupInventorywithCustomListDefLocDefCat(data.strListName1);
		// navigate to track inventory
		generic().waitForPageLoadAndroid(3);
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verifying whether default locations are displayed
		locations().verifyDefaultLocations();
		// verify order of default locations
		locations().verifyOrderOfDefaultLocations();
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strLocationName);
		// tap back
		generic().tapBack();
		// tap on a location
		locations().tapLocation(data.strLocationName1);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName1);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strLocationName1);
		// tap back
		generic().tapBack();
		// tap on a location
		locations().tapLocation(data.strLocationName2);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName2);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strLocationName2);
		// verify product card fields in list
		locations().verifyProductCardDetailsInList(true);
		// verify category of items in location
		locations().verifyItemCategoryOfAllItemsInList("default", "");
		// tap back
		generic().tapBack();
		// verify no items in no location
		locations().tapLocation("No Location");
		locations().verifyLocationPage("No Location");
		locations().verifyNoItemsInLocation();
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name :
	 * INV_TI_028_Validate_Inventory_Setup_Custom_List_My_List_Def_Loc_Suggested_Category
	 * 
	 * Description : User should be able to validate the inventory setup (Custom
	 * list (My list)+Default Loc+Suggested Cat)
	 * 
	 * Manual Test cases : INV_TI_028
	 * 
	 * Author : Gayathri Anand
	 * 
	 * Date : 9/30/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory",
			"TI_DefLocNoDependency"}, description = "Verify inventory setup (Custom list (My list)+Default Loc+Suggested Cat)")
	public void INV_TI_028_Validate_Inventory_Setup_Custom_List_My_List_Def_Loc_Suggested_Category(
			TrackInventoryObject data) throws Exception {
		// Login to app
		component().login(data.strUserName, data.strPassword);
		// setup inventory - SI_013
		component().setupInventorywithCustomlist_Mylist_DefaultLoc_SuggestCategory(data.strListName1);
		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verifying whether default locations are displayed
		locations().verifyDefaultLocations();
		// verify order of default locations
		locations().verifyOrderOfDefaultLocations();
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strLocationName);
		// tap back
		generic().tapBack();
		// tap on a location
		locations().tapLocation(data.strLocationName1);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName1);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strLocationName1);
		// tap back
		generic().tapBack();
		// tap on a location
		locations().tapLocation(data.strLocationName2);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName2);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strLocationName2);
		// verify product card fields in list
		locations().verifyProductCardDetailsInList(true);
		// verify category of items in location
		locations().verifyItemCategoryOfAllItemsInList("suggested", "");
		// tap back
		generic().tapBack();
		// verify no items in no location
		locations().tapLocation("No Location");
		locations().verifyLocationPage("No Location");
		locations().verifyNoItemsInLocation();
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name :
	 * INV_TI_022_Validate_Inventory_Setup_Custom_List_My_List_Def_Loc_Def_Category_SingleLocation
	 * 
	 * Description : User should be able to validate the inventory setup (Custom
	 * List(Custom cat)+Default Loc+Default Cat (Single Location))
	 * 
	 * Manual Test cases : INV_TI_022,INV_SI_007
	 * 
	 * Author : Reshma S Farook
	 * 
	 * Date : 10/01/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory",
			"TI_MultCustomLocCat"}, description = "Verify inventory setup Custom List((Custom cat)+Default Loc+Default Cat (Single Location))")
	public void INV_TI_022_Validate_Inventory_Setup_Custom_List_My_List_Def_Loc_Def_Category_SingleLocation(
			TrackInventoryObject data) throws Exception {
		// Login to app

		component().login(data.strUserName, data.strPassword);
		// Setup Inventory - Custom list -INV_SI_020
		// component().setupInventorywithOGCustomLocCustomCatAssignOnlySomeItems(false,data.strLocationNames,data.strLocationTypes,data.strCategoryNames,data.strCategoryTypes,data.strAssignLocation,data.strAssignCategory);
		component().setupInventorywithCustomListCustCatAsLocationDefaultCat(data.strListName1);
		// navigate to track inventory
		generic().waitForPageLoadAndroid(3);
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verify whether custom locations are populated as expected
		locations().verifyLocationInListMultipleLocation(data.strAssignLocation);
		// verify count of items in paranthesis is displayed for all locations
		locations().verifyItemCountIsDisplayedForAllLocations();
		// verify whether track inventory has been setup as per setup inventory
		// - INV_SI_020
		component().validateTrackInventoryAfterSetupInventory("OGCustomLocDefCategory", 0, data.strAssignLocation,
				data.strItemsInCustomCat1, "UPCID", true, data.strAssignCategory);
		component().validateTrackInventoryAfterSetupInventory("OGCustomLocDefCategory", 1, data.strAssignLocation,
				data.strItemsInCustomCat2, "UPCID", true, data.strAssignCategory);
		component().validateTrackInventoryAfterSetupInventory("OGCustomLocDefCategory", 2, data.strAssignLocation,
				data.strItemsInFrozen, "UPCID", true, data.strAssignCategory);
		component().validateTrackInventoryAfterSetupInventory("OGCustomLocDefCategory", 3, data.strAssignLocation,
				data.strItemsInPoultry, "UPCID", true, data.strAssignCategory);
		component().validateTrackInventoryAfterSetupInventory("OGCustomLocDefCategory", 4, data.strAssignLocation,
				data.strItemsInSeafood, "UPCID", true, data.strAssignCategory);
		component().validateTrackInventoryAfterSetupInventory("OGCustomLocDefCategory", 5, data.strAssignLocation,
				data.strItemsInMeat, "UPCID", true, data.strAssignCategory);
		component().validateTrackInventoryAfterSetupInventory("OGCustomLocDefCategory", 6, data.strAssignLocation,
				data.strItemsInDairy, "UPCID", true, data.strAssignCategory);
		component().validateTrackInventoryAfterSetupInventory("OGCustomLocDefCategory", 7, data.strAssignLocation,
				data.strUncategorizedItems, "UPCID", true, data.strAssignCategory);
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name : INV_TI_059_Validate_Inventory_Setup_OG_Custom_Loc_Custom_Category
	 * 
	 * Description : User should be able to validate the inventory setup (Setup
	 * OG+Custom Loc+Custom Categories (Assign only some items and leave the
	 * other items without any location or categories))
	 * 
	 * Manual Test cases : INV_TI_059,INV_SI_020
	 * 
	 * Author : Reshma S Farook
	 * 
	 * Date : 10/01/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	/*
	 * @Test(retryAnalyzer =
	 * RetryAnalyzer.class,dataProvider="DP1",groups={"TrackInventory"},
	 * description =
	 * "Verify inventory setup, Setup OG+Custom Loc+Custom Categories (Assign only some items and leave the other items without any location or categories"
	 * ) public void
	 * INV_TI_059_Validate_Inventory_Setup_OG_Custom_Loc_Custom_Category(
	 * TrackInventoryObject data) throws Exception { //Login to app
	 * 
	 * component().login(data.strUserName, data.strPassword); //Setup Inventory
	 * - Custom list -INV_SI_020
	 * component().setupInventorywithOGCustomLocCustomCatAssignOnlySomeItems(
	 * false,data.strLocationNames,data.strLocationTypes,data.strCategoryNames,
	 * data.strCategoryTypes,data.strAssignLocation,data.strAssignCategory);
	 * //navigate to track inventory generic().waitForPageLoadAndroid(3);
	 * home().tapTrackInventory(); //verify locations page is displayed
	 * locations().verifyLocationsPage(); //verify all locations view- Verifying
	 * by checking whether no location option is displayed
	 * locations().verifyLocationInList("No Location", true); //verify whether
	 * custom locations are populated as expected
	 * locations().verifyLocationInListMultipleLocation(data.strAssignLocation);
	 * //verify count of items in paranthesis is displayed for all locations
	 * locations().verifyItemCountIsDisplayedForAllLocations(); //verify whether
	 * track inventory has been setup as per setup inventory - INV_SI_020
	 * component().validateTrackInventoryAfterSetupInventory(
	 * "OGCustomLocDefCategory", 0, data.strAssignLocation, data.strItemNames,
	 * "UPCID", true,"custom");
	 * component().validateTrackInventoryAfterSetupInventory(
	 * "OGCustomLocDefCategory", 1, data.strAssignLocation, data.strItemNames,
	 * "UPCID", true,"custom");
	 * component().validateTrackInventoryAfterSetupInventory(
	 * "OGCustomLocDefCategory", 2, data.strAssignLocation, data.strItemNames,
	 * "UPCID", true,"custom"); //verify no items in no location
	 * locations().tapLocation("No Location"); locations().verifyLocationPage(
	 * "No Location"); locations().verifyNoItemsInLocation(); //close app
	 * generic().closeApp(); }
	 */

	/******************************************************************************************
	 * Name :
	 * INV_TI_024_Validate_Inventory_Setup_Multiple_My_List_Def_Loc_Def_Category_ItemInMultipleLoc
	 * 
	 * Description : User should be able to validate the inventory setup (Setup
	 * Custom List(Multiple List - My lists)+Default Loc+Default Cat (Items
	 * Multiple Location))
	 * 
	 * Manual Test cases : INV_TI_024,INV_SI_009,INV_SI_016
	 * 
	 * Author : Reshma S Farook
	 * 
	 * Date : 10/03/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory",
			"TI_MultCustomLocCat"}, description = "Verify inventory setup inventory setup (Setup Custom List(Multiple List - My lists)+Default Loc+Default Cat (Items Multiple Location)")
	public void INV_TI_024_Validate_Inventory_Setup_Multiple_My_List_Def_Loc_Def_Category_ItemInMultipleLoc(
			TrackInventoryObject data) throws Exception {
		// Login to app
		component().login(data.strUserName, data.strPassword);
		// Setup Inventory - Custom list -INV_SI_009
		component().setupInventorywithMulCustListDefLocDefCatItemInMultipeLoc(data.strListName1, data.strListName2);
		// navigate to track inventory
		generic().waitForPageLoadAndroid(3);
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verify count of items in paranthesis is displayed for all locations
		locations().verifyItemCountIsDisplayedForAllLocations();
		// verify whether custom locations are populated as expected
		locations().verifyLocationInListMultipleLocation(data.strAssignLocation);
		// verify items listed in location set as custom categories
		component().validateTrackInventoryAfterSetupInventory("MultipleMyListDefLocationDefSetupExpenses", 0,
				data.strAssignLocation, data.strItemNames, "UPCID", true, "default");
		component().validateTrackInventoryAfterSetupInventory("MultipleMyListDefLocationDefSetupExpenses", 1,
				data.strAssignLocation, data.strItemNames, "UPCID", true, "default");
		// tap back to exit out of the application
		generic().tapBack();
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name :
	 * INV_TI_018_Validate_Inventory_Setup_OG_Custom_Loc_Def_Category_Multiple_Location
	 * 
	 * Description : User should be able to validate the inventory setup (Setup
	 * OG+Custom Loc+Default Cat - Multiple location selection)
	 * 
	 * Manual Test cases : INV_TI_018,INV_SI_003
	 * 
	 * Author : Reshma S Farook
	 * 
	 * Date : 10/04/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory","TI_MultCustomLocCat","CriticalBatch1" ,"CriticalPatchIOS"}, description = "Verify inventory setup inventory setup (Setup Custom List(Multiple List - My lists)+Default Loc+Default Cat (Items Multiple Location)")

	public void INV_TI_018_Validate_Inventory_Setup_OG_Custom_Loc_Def_Category_Multiple_Location(
			TrackInventoryObject data) throws Exception {
		// Login to app
		component().login(data.strUserName, data.strPassword);
		// Setup Inventory - Custom list -INV_SI_003 - commenting to execute
		// test
		component().setupInventorywithOGCustomLocDefaultCatMultipleLocation(data.strLocationNames,
				data.strLocationTypes, data.strAssignLocation, false);
		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verify whether custom locations are populated as expected
		locations().verifyLocationInListMultipleLocation(data.strAssignLocation);
		// verify count of items in paranthesis is displayed for all locations
		locations().verifyItemCountIsDisplayedForAllLocations();
		// verify whether track inventory has been setup as per setup inventory
		// - INV_SI_003
		component().validateTrackInventoryAfterSetupInventory("OGCustomLocDefCategory", 0, data.strAssignLocation,
				data.strItemNames, "UPCID", true, "default");
		component().validateTrackInventoryAfterSetupInventory("OGCustomLocDefCategory", 1, data.strAssignLocation,
				data.strItemNames, "UPCID", true, "default");
		component().validateTrackInventoryAfterSetupInventory("OGCustomLocDefCategory", 2, data.strAssignLocation,
				data.strItemNames, "UPCID", true, "default");
		// verify no items in no location
		locations().tapLocation("No Location");
		locations().verifyLocationPage("No Location");
		locations().verifyNoItemsInLocation();
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name : INV_TI_027_Setup_Custom_list_Syscolist_Custom_Loc_Default_Cat
	 * 
	 * Description : Verify the items should be assigned with proper category
	 * (Food/non food) and proper location
	 * 
	 * Manual Test cases : INV_TI_027
	 * 
	 * 
	 * Author : Asha
	 * 
	 * Date : 10/04/2016 Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory",
			"TI_CustLocDefaultCat"}, description = "Verify search for an item, while inventory setup using Custom location")
	public void INV_TI_027_Setup_Custom_list_Syscolist_Custom_Loc_Default_Cat(TrackInventoryObject data)
			throws Exception {

		// Login to app
		component().login(data.strUserName, data.strPassword);
		component().setupInventorywithCustomListCustomListDefaultCategory(data.strListName1, data.strLocationNames,data.strLocationTypes,true);
		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verifying whether custom locations are displayed
		locations().verifyLocationInList(data.strLocationNames, true);
		// tap on a location
		locations().tapLocation(data.strLocationName1);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName1);
		// verify only the items assigned by the customer belongs to the
		// location
		locations().verifyAssignedItemsInLocation(data.strLocationName1);
		locations().verifyItemsCountInLocation("3");
		// verify product card fields in list
		locations().verifyProductCardDetailsInList(true);
		// verify only additional location details are present in an item
		// details
		locations().verifyItemCategoryofAllItemsInList(data.strCategoryName1);
		// tap back
		generic().tapBack();
		// verify no items in no location
		locations().tapLocation("No Location");
		locations().verifyLocationPage("No Location");
		// verify only the items not assigned in other locations are displayed
		// in No location
		locations().verifyAllItemsInLocationsPage(data.strProductName3);
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name :
	 * INV_TI_041_Validate_Category_Removed_For_Items_After_Deleting_All_Categories
	 * 
	 * Description : Validate that category is removed from all the items which
	 * was previously associated after deleting all categories
	 * 
	 * Manual Test cases : INV_TI_041
	 * 
	 * Author : Gayathri Anand
	 * 
	 * Date : 10/05/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory",
			"TI_Others"}, description = " Validate that category is removed from all the items after deleting all categories")
	public void INV_TI_041_Validate_Category_Removed_For_Items_After_Deleting_All_Categories(TrackInventoryObject data)
			throws Exception {
		// Login to app
		component().login(data.strUserName, data.strPassword);
		// setup inventory - precondition -INV_SI_005
		component().setupInventorywithOGDefaultLocCustomCategory(data.strCategoryNames, data.strCategoryTypes);
		// Tap Expense Categories
		generic().waitForPageLoadAndroid(3);
		home().tapExpenseCategories();
		// verify the expense categories page is loaded
		expenseCat().verifyExpenseCategoriesPage();
		// delete all categories
		expenseCat().deleteExpenseCategories("all");
		// navigate to homepage
		expenseCat().swipeToSetupExpenses();
		generic().tapCancel();
		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// verify category of items in location in item list
		locations().verifyItemCategoryOfAllItemsInList("no category");
		// verify category of items in location in product card
		locations().verifyCategoryOfAllItemsInListFromProductCard("no category");
		// Tap back
		generic().tapBack();
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name :
	 * INV_TI_026_Validate_Inventory_Shared_List_Cust_Loc_Def_Cat_Single_Location
	 * 
	 * Description : User should be able to validate the inventory setup (Setup
	 * Custom list (Shared list)+Custom Loc+Default Cat - Single location
	 * selection)
	 * 
	 * Manual Test cases : INV_TI_026,INV_SI_011
	 * 
	 * Author : Reshma Farook
	 * 
	 * Date : 10/05/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory", "TI_MultCustomLocCat",
			"TI_MultCustomLocCat","CriticalBatch1"}, description = "Verify inventory setup (Custom list (Shared list)+Custom  Loc+Default Cat - Single location selection")
	public void INV_TI_026_Validate_Inventory_Shared_List_Cust_Loc_Def_Cat_Single_Location(TrackInventoryObject data)
			throws Exception {

		// Login to app

		component().login(data.strUserName, data.strPassword);
		// Setup Inventory - Shared list -INV_SI_011
		component().setupInventorywithSharedListCustLocDefCatSingleLocation(data.strListName1, data.strLocationNames,
				data.strLocationTypes, data.strAssignLocation, false);
		// navigate to track inventory
		generic().waitForPageLoadAndroid(3);
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verify whether custom locations are populated as expected
		locations().verifyLocationInListMultipleLocation(data.strLocationNames);

		/*
		 * tap on a location locations().tapLocation(data.strLocationName);
		 * //verify location page is displayed
		 * locations().verifyLocationPage(data.strLocationName); //verify item
		 * list view locations().verifyItemListViewIsDisplayed(); //verify items
		 * in location
		 * locations().verifyAssignedItemsInLocation(data.strLocationName);
		 * //verify product card fields in list
		 * locations().verifyProductCardDetailsInList(true); //verify category
		 * of items in location
		 * locations().verifyItemCategoryOfAllItemsInList("default",""); //tap
		 * back generic().tapBack();
		 */

		locations().tapLocation(data.strLocationName);
		locations().verifyLocationPage(data.strLocationName);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		locations().verifyWhetherItemInLocation(data.strLocationName, data.strItemNames, "UPCID", true);
		// verify product card fields in list
		locations().verifyProductCardDetailsInList(true);
		// verify whether category of the item is default - food or non-food.
		locations().verifyItemCategoryOfAllItemsInList("default", "");
		// tap back
		generic().tapBack();

		// verify no items in no location
		locations().tapLocation("No Location");
		locations().verifyLocationPage("No Location");
		locations().verifyNoItemsInLocation();
		// close app
		generic().closeApp();

	}

	/******************************************************************************************
	 * Name :
	 * INV_TI_029_Validate_Inventory_Shared_List_Default_Loc_Custom_Category
	 * 
	 * Description : User should be able to validate the inventory setup (Setup
	 * Custom list (Shared list)+Default Loc + Custom Category
	 * 
	 * Manual Test cases : INV_TI_029,INV_SI_014
	 * 
	 * Author : Reshma Farook
	 * 
	 * Date : 10/05/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory",
			"TI_MultCustomLocCat"}, description = "Verify inventory setup (Custom list (Shared list)+Custom  Loc+Default Cat - Single location selection")
	public void INV_TI_029_Validate_Inventory_Shared_List_Default_Loc_Custom_Category(TrackInventoryObject data)
			throws Exception {

		// Login to app
		component().login(data.strUserName, data.strPassword);
		// Setup Inventory - Shared list -INV_SI_014
		component().setupInventorywithSharedListDefLocCustomCat(data.strListName1, data.strCategoryNames,
				data.strCategoryTypes, data.strAssignCategory);
		// navigate to track inventory
		generic().waitForPageLoadAndroid(3);
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verifying whether default locations are displayed
		locations().verifyDefaultLocations();
		// locations().verifyDefaultLocationsAnyOrder();
		// verify order of default locations--need to confirm the latest
		// behavior of this.
		locations().verifyOrderOfDefaultLocations();
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strLocationName);
		// verify product card fields in list
		locations().verifyProductCardDetailsInList(true);
		// verify category of items in location
		locations().verifyItemCategoryOfAllItemsInList("custom", data.strAssignCategory);
		// tap back
		generic().tapBack();
		// tap on a location
		locations().tapLocation(data.strLocationName1);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName1);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strLocationName1);
		// verify product card fields in list
		locations().verifyProductCardDetailsInList(true);
		// verify category of items in location
		locations().verifyItemCategoryOfAllItemsInList("custom", data.strAssignCategory);
		// tap back
		generic().tapBack();
		// tap on a location
		locations().tapLocation(data.strLocationName2);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName2);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify location of items in location
		locations().verifyLocationOfAllItemsInList(data.strLocationName2);
		// verify product card fields in list
		locations().verifyProductCardDetailsInList(true);
		// verify category of items in location
		locations().verifyItemCategoryOfAllItemsInList("custom", data.strAssignCategory);
		// tap back
		generic().tapBack();
		// verify no items in no location
		locations().tapLocation("No Location");
		locations().verifyLocationPage("No Location");
		locations().verifyNoItemsInLocation();
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name : INV_TI_061_INV_Validate_Inventory_SAll_items_uncounted
	 * 
	 * Description : Validate As a user, I want to be able to filter items on
	 * the track inventory screen by All items/uncounted and see the total
	 * number of items next to each filter - count all items (active open
	 * inventory)
	 * 
	 * Manual Test cases : INV_TI_061,INV_TI_063
	 * 
	 * Author : Sampada Dalai
	 * 
	 * Date : 10/12/2016 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/

	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory","TI_Others","CriticalBatch1"}, description = "Verify inventory setup (Custom list (Shared list)+Custom  Loc+Default Cat - Single location selection")
	public void INV_TI_061_INV_TI_063_INV_Validate_Inventory_SAll_items_uncounted(TrackInventoryObject data)
			throws Exception {
		String[] strArrIndex = new String[] { "1", "2", "3" };
		String[] strArrAllItem = new String[] { "All" };
		// Login to app
		component().login(data.strUserName, data.strPassword);
		// setup inventory - precondition -INV_SI_005
		component().setupInventorywithOGDefaultLocDefaultCat();
		generic().waitForPageLoadAndroid(3);
		// navigate to track inventory
		generic().waitForPageLoadAndroid(1);
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verifying whether custom locations are displayed
		locations().verifyLocationInList(data.strLocationName, true);
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// Enter quantity and verify quantity updated for the items
		locations().enterQuantityAndVerifyForTheItem(data.strLocationName, "1", strArrIndex, true);
		// Click on all item filter
		locations().clickOnFilterForAllItemAndUncounted();
		// Verify items displayed for Uncounted filter and Enter quantity for
		// all uncounted filtered items displayed for the location
		locations().enterQuantityAndVerifyForTheItem(data.strLocationName, "1", strArrAllItem, true);
		// tap back
		generic().tapBack();
		// tap back
		generic().tapBack();
		// logout from the application
		home().logout();
		// Login to app
		component().login(data.strUserName, data.strPassword, false);
		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verifying whether custom locations are displayed
		locations().verifyLocationInList(data.strLocationName, true);
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// Verify items displayed for all item filter
		locations().enterQuantityAndVerifyForTheItem(data.strLocationName, null, null, true);
		// Click on all item filter
		locations().clickOnFilterForAllItemAndUncounted();
		// Verify no items displayed for Uncounted filter
		locations().enterQuantityAndVerifyForTheItem(data.strLocationName, null, null, false);
		// close app
		generic().closeApp();

	}

	/******************************************************************************************
	 * 
	 * Name : INV_TI_004_010_Validate_UOM_Toggle_Quantity_Update
	 * 
	 * Description : User should be able to toggle the unit of measure type by
	 * case, each, pound, oz and add, delete and update quantity
	 * 
	 * Manual Test cases : INV_TI_004, INV_TI_010
	 * 
	 * Author : Gayathri Anand
	 * 
	 * Date : 10/07/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/

	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory", "Track Inv NR","TI_UOMValidation","TI_Defects" }, description = "Verify toggling of UOM attributes and add, delete and update quantity")
	public void INV_TI_004_010_Validate_UOM_Toggle_Quantity_Update(TrackInventoryObject data) throws Exception {

		// Login to app
		component().login(data.strUserName, data.strPassword);
		// Setup Inventory
		component().setupInventorywithOGDefaultLocDefaultCat();
		// navigate to track inventory
		generic().waitForPageLoadAndroid(3);
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verifying whether default locations are displayed
		locations().verifyDefaultLocations();
		// verify order of default locations
		locations().verifyOrderOfDefaultLocations();
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// toggle uom from item list
		locations().verifyTogglingOfUOMAttributeFromItemList("1");
		// edit quantity (enter whole number)
		locations().enterQuantity(data.strQuantity1, "1");
		// verify quantity
		locations().verifyQuantity(data.strQuantity1, "1");
		// edit quantity (enter decimal number)
		locations().enterQuantity(data.strQuantity2, "2");
		// verify quantity
		locations().verifyQuantity(data.strQuantity2, "2");
		// delete quantity
		locations().clearQuantity("1");
		// verify quantity is empty
		locations().verifyQuantityIsEmpty("1");
		// update quantity
		locations().enterQuantity(data.strQuantity3, "1");
		// verify quantity
		locations().verifyQuantity(data.strQuantity3, "1");
		generic().tapBack();
		generic().tapBack();
		home().logout();
		// log in
		component().login(data.strUserName, data.strPassword, false);
		// navigate to track inventory
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify quantity
		generic().waitForPageLoadAndroid(3);
		locations().verifyQuantityAfterReLogin(data.strQuantity3, "1");
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name : INV_TI_062_INV_Validate_Inventory_SAll_items_uncounted
	 * 
	 * Description : Validate As a user, I want to be able to filter items on
	 * the track inventory screen by All items/uncounted and see the total
	 * number of items next to each filter - Verify filter has respective count
	 * # displayed
	 * 
	 * Manual Test cases : INV_TI_062
	 * 
	 * Author : Sampada Dalai
	 * 
	 * Date : 10/12/2016
	 *******************************************************************************************/

	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory",
			"TI_Others"}, description = "Verify inventory setup (Custom list (Shared list)+Custom  Loc+Default Cat - Single location selection")
	public void INV_TI_062_INV_Validate_Inventory_SAll_items_uncounted(TrackInventoryObject data) throws Exception {
		String[] strArrIndex = new String[] { "1", "2", "3" };
		// Login to app
		component().login(data.strUserName, data.strPassword);
		// setup inventory - precondition -INV_SI_005
		component().setupInventorywithOGDefaultLocDefaultCat();
		// navigate to track inventory
		generic().waitForPageLoadAndroid(1);
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verifying whether custom locations are displayed
		locations().verifyLocationInList(data.strLocationName, true);
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// Enter quantity and verify quantity updated for the items
		locations().enterQuantityAndVerifyForTheItem(data.strLocationName, "1", strArrIndex, true);
		// Verify items displayed for all item filter
		locations().enterQuantityAndVerifyForTheItem(data.strLocationName, null, null, true);
		// Click on all item filter
		locations().clickOnFilterForAllItemAndUncounted();
		// Verify items displayed for Uncounted filter
		locations().enterQuantityAndVerifyForTheItem(data.strLocationName, null, null, true);
		// close app
		generic().closeApp();

	}
	/******************************************************************************************
	 * Name :
	 * INV_TI_017_Validate_Inventory_Setup_OG_Custom_Loc_Def_Category_Single_Location
	 * 
	 * Description : User should be able to validate the inventory setup (Setup
	 * OG+Custom Loc+Default Cat - Single location selection)
	 * 
	 * Manual Test cases : INV_TI_017
	 * 
	 * Author : Gayathri Anand
	 * 
	 * Date : 10/13/2016
	 * 
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/

	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory",
			"TI_MultCustomLocCat" }, description = "Verify inventory setup inventory setup (Setup OG+Default Loc+Default Cat (Items Single Location)")
	public void INV_TI_017_Validate_Inventory_Setup_OG_Custom_Loc_Def_Category_Single_Location(
			TrackInventoryObject data) throws Exception {

		// Login to app
		component().login(data.strUserName, data.strPassword);
		// Setup Inventory -INV_SI_002
		component().setupInventorywithOGCustomLocDefaultCategorySingleLocationSelection(data.strLocationNames,
				data.strLocationTypes);
		// navigate to track inventory
		generic().waitForPageLoadAndroid(3);
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verify whether custom locations are populated as expected
		locations().verifyLocationInListMultipleLocation(data.strLocationNames);
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify items in location
		locations().verifyAssignedItemsInLocation(data.strLocationName);
		// verify product card fields in list
		locations().verifyProductCardDetailsInList(true);
		// verify category of items in location
		locations().verifyItemCategoryOfAllItemsInList("default", "");
		// tap back
		generic().tapBack();
		// verify no items in no location
		locations().tapLocation("No Location");
		locations().verifyLocationPage("No Location");
		locations().verifyNoItemsInLocation();
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name :
	 * INV_TI_045_Validate_Inventory_Setup_OG_Custom_Loc_Suggested_Category_Single_Location
	 * 
	 * Description : User should be able to validate the inventory setup (Setup
	 * OG+Custom Loc+Suggested Cat - Single location selection)
	 * 
	 * Manual Test cases : INV_TI_045
	 * 
	 * Author : Gayathri Anand
	 * 
	 * Date : 10/13/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory", "Track Inv NR",
			"TI_MultCustomLocCat"}, description = "Verify inventory setup inventory setup (Setup OG+Default Loc+Suggested Cat (Items Single Location)")
	public void INV_TI_045_Validate_Inventory_Setup_OG_Custom_Loc_Suggested_Category_Single_Location(
			TrackInventoryObject data) throws Exception {

		// Login to app
		component().login(data.strUserName, data.strPassword);
		// Setup Inventory -INV_SI_019
		component().setupInventorywithOGCustomLocSuggestedCategorySingleLocationSelection(data.strLocationNames,
				data.strLocationTypes);
		// navigate to track inventory
		generic().waitForPageLoadAndroid(2);
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verify whether custom locations are populated as expected
		locations().verifyLocationInListMultipleLocation(data.strLocationNames);
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify items in location
		generic().waitForPageLoadAndroid(5);
		locations().verifyAssignedItemsInLocation(data.strLocationName);
		// verify product card fields in list
		locations().verifyProductCardDetailsInList(true);
		// verify category of items in location
		locations().verifyItemCategoryOfAllItemsInList("suggested", "");
		// tap back
		generic().tapBack();
		// verify no items in no location
		locations().tapLocation("No Location");
		locations().verifyLocationPage("No Location");
		locations().verifyNoItemsInLocation();
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name : INV_TI_021_Validate_Inventory_Setup_OG_Custom_Loc_Custom_Category
	 * 
	 * Description : User should be able to validate the inventory setup
	 * (OG+Custom Loc+Custom Cat)
	 * 
	 * Manual Test cases : INV_TI_021
	 * 
	 * Author : Gayathri Anand
	 * 
	 * Date : 10/13/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory", "Track Inv NR",
			"TI_MultCustomLocCat","CriticalBatch1"}, description = "Verify inventory setup (OG+Custom Loc+Custom Cat)")
	public void INV_TI_021_Validate_Inventory_Setup_OG_Custom_Loc_Custom_Category(TrackInventoryObject data)
			throws Exception {
		// Login to app
		component().login(data.strUserName, data.strPassword);
		// setup inventory - INV_SI_006
		component().setupInventorywithOGCustomLocCustomCategory(data.strLocationNames, data.strLocationTypes,
				data.strCategoryNames, data.strCategoryTypes);
		// navigate to track inventory
		generic().waitForPageLoadAndroid(3);
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verifying list of locations are displayed
		locations().verifyLocationInList(data.strLocationNames, true);
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify items in location
		locations().verifyAssignedItemsInLocation(data.strLocationName);
		// verify product card fields in list
		locations().verifyProductCardDetailsInList(true);
		// verify category of items in location
		locations().verifyItemCategoryOfAllItemsInList("custom", data.strCategoryNames.split("/"));
		// tap back
		generic().tapBack();
		// verify no items in no location
		locations().tapLocation("No Location");
		locations().verifyLocationPage("No Location");
		locations().verifyNoItemsInLocation();
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name : INV_TI_060_CustomLoc_CustomCat_AssignFewItems_VerifyTrackInventory
	 * 
	 * Description : Validate the track inventory is setup accordingly after
	 * setup - Setup OG+custom Loc+Custom Cat (Assign only few items)
	 * 
	 * Manual Test cases : INV_TI_060
	 * 
	 * Author : Periyasamy_Nainar
	 * 
	 * Date : 10/15/2016
	 * 
	 * Notes : NA
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventory",
			"TI_MultCustomLocCat"}, description = "Verify user has an option to setup location once the user delete all locations")
	public void INV_TI_060_CustomLoc_CustomCat_AssignFewItems_VerifyTrackInventory(TrackInventoryObject data)
			throws Exception {

		// Login to app
		component().login(data.strUserName, data.strPassword);
		// Set up Inventory - INV_SI_020 -
		// Setup OG+Custom Loc+Custom Categories (Assign only few items only)
		// component().setupInventorywithOGCustomLocCustomCategory(data.strLocationName1,
		// data.strLocationType1, data.strCategoryNames1, "Food/NonFood/Food");
		component().setupInventorywithOGCustomLocCustomCatAssignOnlySomeItems(true, data.strLocationName1,
				data.strLocationType1, data.strCategoryName1, data.strCategoryTypes, data.strLocationNames,
				data.strCategoryNames);
		// Tap on Track inventory
		generic().waitForPageLoadAndroid(3);
		home().tapTrackInventory();
		// verify Location details page
		locations().verifyLocationsPage();
		// verify all custom locations are displayed in locations page
		locations().verifyLocationInList(data.strLocationName1, true);
		// tap on a location
		locations().tapLocation(data.strLocationName1.split("/")[1]); // loc2
		// verify only the items assigned by customer is displayed in this
		// location
		locations().verifyAssignedProductsInInventoryList(data.strLocationName1.split("/")[1]);
		locations().verifyCategoryOfAssignedProductsInInventoryList(data.strLocationName1.split("/")[1]);
		// verify product card fields in list
		locations().verifyProductCardDetailsInList(true);
		// Tap on back to go to locations page
		generic().tapBack();
		// tap on a location
		locations().tapLocation(data.strLocationName1.split("/")[0]);
		// verify only the items assigned by customer is displayed in this
		// location
		locations().verifyAssignedProductsInInventoryList(data.strLocationName1.split("/")[0]);
		locations().verifyCategoryOfAssignedProductsInInventoryList(data.strLocationName1.split("/")[0]);
		// verify product card fields in list
		locations().verifyProductCardDetailsInList(true);
		// Tap on back to go to locations page
		generic().tapBack();
		// tap on a location
		locations().tapLocation(data.strLocationName1.split("/")[2]);
		// locations().verifyExpenseCategory("Egg Shell Extra Large Brown",
		// "nocategory", false);
		// verify only the items assigned by customer is displayed in this
		// location
		locations().verifyAssignedProductsInInventoryList(data.strLocationName1.split("/")[2]);
		locations().verifyCategoryOfAssignedProductsInInventoryList(data.strLocationName1.split("/")[2]);
		// verify product card fields in list
		locations().verifyProductCardDetailsInList(true);
		// tap back
		generic().tapBack();
		// verify no items in no location
		locations().tapLocation(data.strLocationName2);
		locations().verifyLocationPage(data.strLocationName2);
		// locations().verifyNoItemsInLocation();
		locations().verifyAssignedProductsInInventoryList(data.strLocationName2);
		locations().verifyCategoryOfAssignedProductsInInventoryList(data.strLocationName2);
		// close app
		generic().closeApp();
	}

	/******************************************************************************************
	 * Name :
	 * INV_TI_033_Validate_Inventory_Setup_OG_Custom_Loc_Skip_Category_Single_Location
	 * 
	 * Description : User should be able to validate the inventory setup
	 * (OG+Custom Loc+ Skip the Cat (Do this later) - Single location selection)
	 * 
	 * Manual Test cases : INV_TI_033
	 * 
	 * Author : Gayathri Anand
	 * 
	 * Date : 10/16/2016
	 * 
	 * Notes :
	 * 
	 * Modification Log Date Author Description
	 * -------------------------------------------------------------------------
	 * ----------------
	 * 
	 ******************************************************************************************/

	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "DP1", groups = { "TrackInventoryInvalid"}, description = "Verify inventory setup (OG+Custom  Loc+ Skip the Cat (Do this later) - Single location selection)")
	public void INV_TI_033_Validate_Inventory_Setup_OG_Custom_Loc_Skip_Category_Single_Location(
			TrackInventoryObject data) throws Exception {
		// Login to app
		component().login(data.strUserName, data.strPassword);
		// setup inventory - INV_SI_018
		component().setupInventorywithOGCustomLocNoCategorySingleLocationSelection(data.strLocationNames,
				data.strLocationTypes);
		// navigate to track inventory
		generic().waitForPageLoadAndroid(3);
		home().tapTrackInventory();
		// verify locations page is displayed
		locations().verifyLocationsPage();
		// verify all locations view- Verifying by checking whether no location
		// option is displayed
		locations().verifyLocationInList("No Location", true);
		// verifying list of locations are displayed
		locations().verifyLocationInList(data.strLocationNames, true);
		// tap on a location
		locations().tapLocation(data.strLocationName);
		// verify location page is displayed
		locations().verifyLocationPage(data.strLocationName);
		// verify item list view
		locations().verifyItemListViewIsDisplayed();
		// verify items in location
		locations().verifyAssignedItemsInLocation(data.strLocationName);
		// verify product card fields in list
		locations().verifyProductCardDetailsInList(true);
		// verify category of items in location
		locations().verifyItemCategoryOfAllItemsInList("no category");
		// tap back
		generic().tapBack();
		// verify no items in no location
		locations().tapLocation("No Location");
		locations().verifyLocationPage("No Location");
		locations().verifyNoItemsInLocation();
		// close app
		generic().closeApp();
	}

}

