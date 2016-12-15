
package com.uom.tests;



import java.lang.reflect.Method;

import com.DataRead.Excel;
import com.framework.*;
import com.framework.configuration.ConfigFile;
import com.framework.frameworkFunctions.LibraryPage;
import com.framework.utils.RetryAnalyzer;
import com.framework.utils.UOMTestNGListener;
import com.uom.excelSheetObject.ManageLocationObject;
import com.uom.excelSheetObject.TrackInventoryObject;
import com.uom.excelSheetObject.UsabilityObject;
import com.uom.pageFactory.PageFactory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(value = UOMTestNGListener.class)
public class ManageLocation extends PageFactory{

	public static String[][] completeArray = null;	
   	Starter starter = new Starter();
   	
      
    @BeforeClass(alwaysRun=true)
	public void getData() throws Exception
	{		
		
		Excel newExcel =new Excel();		
		completeArray=newExcel.read("test-data/TestData.xls","ManageLocation");
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
		 	ManageLocationObject sheetObj = new ManageLocationObject();
	        System.out.println(method.getName());
	        String[][] MethodArray=newExcel.getMethodData(completeArray, method.getName());
	        Object[][] retObjArr= sheetObj.getTestData(MethodArray);
	        return(retObjArr);
	    }
	 
	 /******************************************************************************************
	  * Name : INV_ML_001_005_007_View_Add_Edit_Locations
	  * 
	  * Description : Verify whether 1. Verify the location are displayed accordingly in the Manage Location screen - setup done using Default location. Locations and see the list of Default Locations in the order:
	  * 							 2. Validate  when  a valid user navigates to track inventory and  creates a custom location, user should be able to provide name and  type of the location  - From Track Inventory
	  * 							 3. Validate from Manage location the user is able to update the location name and type- Setup done using Default location
	  * 
	  * Manual Test cases :  INV_ML_001, INV_ML_005, INV_ML_007
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 9/26/2016
	  * 
	  * Notes : NA
	  * 
	  * Test data: uomautnu100
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/

	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageLocation","ManageLocation_iOS1","CriticalBatchAndroid","CriticalPatchIOS"}, description = "Add,View and Edit Location, verify default locations")

	 public void INV_ML_001_005_007_View_Add_Edit_Locations(ManageLocationObject data) throws Exception {	
		
		 //Login to app
		 component().login(data.strUserName, data.strPassword);
		 // Setup OG+Default Loc+Default Cat - INV_SI_001
		 component().setupInventorywithOGDefaultLocDefaultCat();
		 ///INV_ML_001 - verify default location and order of location from manage location page		
		 //Tap on locations from inventory tools page
		 home().tapLocations();
		 //verify locations page is dispalyed 
		 locations().verifyLocationsPage();
		 //verify default locations and 
		 locations().verifyDefaultLocations();
		 //verify order of locations
		 locations().verifyOrderOfDefaultLocations();
		 //verify item count displayed against each location
		 locations().verifyLocationsWithCount(data.strNumberOfLocations, data.strLocationsWithCount1,data.strLocationsWithCount2,data.strLocationsWithCount3);
		 //Tap on location from locations page
		 locations().tapLocation(data.strLocationName1);
		 //verify Location details page
		 locations().verifyLocationDetailsPage();
		 //verify number of items
		 locations().verifyNumberOfItemInLocation(data.strItemsCount, data.strLocationName1);
		 ///Hit on items on this page and verify the details
		 //get number of items in this location
		 locations().getNumberOfItemInThisLocation();
		 //Tap on view items on this location
		 locations().tapItemInThisLocation();
		 //verify correct location page is displayed 
		 locations().verifyLocationPage(data.strLocationName1);
		 //verify number of line items in this location equal to number of items in view items in this location button
		 locations().verifyNumberOfItemInThisLocation();
		//Tap on back 
		 generic().tapBack();	 
		 //verify Location details page
		 locations().verifyLocationDetailsPage();
		 
		 ///INV_ML_007 - Edit location details from manage location flow and verify the same thought track inventory flow. 
		 //Tap on Edit button
		 generic().tapEdit();
		 //Enter new location name and Type
		 locations().enterLocationDetails(data.strLocationName3, data.strLocationType3);
		//Tap on done button
		 generic().tapDone();
		 //wait for page to load
		 LibraryPage.waitFor(4);
		 //verify newly created location details - name and Type
		 locations().verifyLocationDetails(data.strLocationName3, data.strLocationType3);
		 //Tap on close button to close location details screen
		 generic().tapClose();
		 //verify new location is displayed in location list 
		 locations().verifyLocationInList(data.strLocationName3,true);
		 //verify old location name is not displayed in location list
		 locations().verifyLocationInList(data.strLocationName1,false);		
		//Tap on back 
		 generic().tapBack();					 
		 //Tap on Track inventory
		 home().tapTrackInventory();
		 //verify locations page
		 locations().verifyLocationsPage();
		//verify new location is displayed in location list 
		 locations().verifyLocationInList(data.strLocationName3,true);
		 //verify old location name is not displayed in location list
		 locations().verifyLocationInList(data.strLocationName1,false);			 
		//Tap on location from locations page		 
		 locations().tapLocation(data.strLocationName3);
		//verify newly created location details - name and Type
		 locations().verifyLocationPage(data.strLocationName3);		
		//Tap on back 
		 generic().tapBack();		 
		 
		 //TC INV_ML_005 - Create new location from track inventory flow and verify the same from manage locations page
		 //Tap on add button
		 generic().tapAdd();
		 //verify add location page
		 locations().verifyAddLocationPage();
		 //Enter location details - location name and type
		 locations().enterLocationDetails(data.strLocationName2, data.strLocationType2);
		 //Tap on done button
		 generic().tapDone();
		 //wait for page to load
		 LibraryPage.waitFor(4);
		 //verify newly created location details - name and Type
		 locations().verifyLocationDetails(data.strLocationName2, data.strLocationType2);
		 //Tap on close button to close location details screen
		 generic().tapClose();		 
		 //verify new location is displayed in location list
		 locations().verifyLocationInList(data.strLocationName2,true);
		//Tap on back 
		 generic().tapBack();
		//Tap on locations from inventory tools page
		 home().tapLocations();
		//verify new location is displayed in location list
		 locations().verifyLocationInList(data.strLocationName2,true);		
		//Tap on location from locations page
		 locations().tapLocation(data.strLocationName2);
		//verify newly created location details - name and Type
		 locations().verifyLocationDetails(data.strLocationName2, data.strLocationType2);	
		 //logout form location details page
		 component().logoutFromLocationDetailsPage();
		 //close app
		 generic().closeApp();
	 
	 }

	 /******************************************************************************************
	  * Name : INV_ML_006_010_CreateLocation_DeleteLocation_VerifyTrackInventory
	  * 
	  * Description : User should be able to Create and delete custom Location from Manage Locations and verify on Track inventory locations. 
	  * 
	  * Manual Test cases : INV_ML_006, INV_ML_010, INV_TI_054
	  * 
	  * Author : Periyasamy_Nainar
	  * 
	  * Date : 9/28/2016
	  * 
	  * Notes : NA
	  * 
	  * Test data: uomautnu100
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/

	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageLocation","ManageLocation_iOS1"}, description = "Create and delete custom Location from Manage Locations and verify on Track inventory locations")
	 public void INV_ML_006_010_TI_054_CreateLocation_DeleteLocation_VerifyTrackInventory(ManageLocationObject data) throws Exception {	
		
		 //Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory -  using default location-default category INV_SI_001
		 component().setupInventorywithOGDefaultLocDefaultCat();		 
		 //INV_ML_006 - Add new location from manage location page and verify the same in track inventory
		 //Tap Locations from inventory tools page
		 home().tapLocations();
		 //verify the Locations page is loaded
		 locations().verifyLocationsPage();
		 //Click on +
		 generic().tapAdd();
		 //verify add location page
		 locations().verifyAddLocationPage();
		 //Enter Location details
		 locations().enterLocationDetails(data.strLocationName1, data.strLocationType1);
		 //tap done
		 generic().tapDone();
		 //tap close
		 generic().tapClose();
		 //verify the Locations page is loaded
		 locations().verifyLocationsPage();
		 //verify newly created Location is added in the list
		 locations().verifyLocationInList(data.strLocationName1,true);
		 //tap on location created
		 locations().tapLocation(data.strLocationName1);
		 //verify location details
		 locations().verifyLocationDetails(data.strLocationName1, data.strLocationType1);
		 //tap close
		 generic().tapClose();
		 //tap back
		 generic().tapBack();
		 //tap track inventory from inventory tools page
		 home().tapTrackInventory();
		 //get Items count from no location
		 locations().getItemCountInLocation(data.strLocationName3);
		 //verify newly created Location is added in the list
		 locations().verifyLocationInList(data.strLocationName1,true);
		 //Tap on location from locations page		 
		 locations().tapLocation(data.strLocationName1);
		 //verify newly created location details - name and Type
		 locations().verifyLocationPage(data.strLocationName1);	
		 //Tap back 
		 generic().tapBack();
		//Tap back 
		 generic().tapBack();
		 
		 //INV_ML_010 - Deleting location from manage location item should be removed from specific location to no locations page. 
		//Tap Locations from inventory tools page
		 home().tapLocations();
		 //get item count from location
		 locations().getItemCountInLocation(data.strLocationName2);
		 //tap on any location 
		 locations().tapLocation(data.strLocationName2);
		 //Tap on Edit -- not required
		 //get all items from location before delete
		 locations().getAllProductsFromInventoryList(data.strLocationName2);
		 //Tap on Delete this location
		 locations().tapDeleteButton();		 
		 //verify Delete location confirmation modal
		 locations().verifyDeleteConfirmationMessage(data.strLocationName2);   // Needs to be uncommented. its a defect. 
//commenting the above line of code to run the script in batch execution. Please uncomment this line of code once the issue is fixed. 
		 //Tap on Yes Delete
		 generic().tapYesDelete();
		 //verify deleted location is not displayed in locations list
		 locations().verifyLocationInList(data.strLocationName2, false);
		 //Tap on Back
		 generic().tapBack();
		 
		 //INV TI - 054 - Validate when the location is deleted from Manage location screen all the items belonging to X location is moved to "No Location" and X location does not gets displayed in the track inventory list of location view
		 //Tap on Track inventory
		 home().tapTrackInventory();
		 //verify deleted location is not displayed in locations list
		 locations().verifyLocationInList(data.strLocationName2, false);		
		 //verify no location item count is increased by the count as the number of items in deleted location
		 locations().verifyItemCountAfterDeleteLoc(data.strLocationName3, data.strLocationName2);
		 //verify wheter all items in deleted location is available in no location page
		 locations().verifyProductsFromInventoryList(data.strLocationName2, data.strLocationName3);
		 //logout form inventory list page
		 component().logoutFromInventoryList();
		 //close app
		 generic().closeApp();
		
	 }
	 
	 /******************************************************************************************
	  * Name : INV_ML_002_008_ManageLocations_Edit_CustomLocation_Verify
	  * 
	  * Description : User should be able to Edit location details and verify. Also verify locations page and items count in locations page. 
	  * 
	  * Manual Test cases : INV_ML_008, INV_ML_002
	  * 
	  * Author : Sujina S
	  * 
	  * Date : 9/26/2016
	  * 
	  * Test data: uomautnu100
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  Updated - Added INV_ML_002 in this script as the setup inventory flow remains same.  - Periya
	  ******************************************************************************************/

	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageLocation","ManageLocation_iOS1"}, description = "Edit location details and verify")
	 public void INV_ML_002_008_ManageLocations_Edit_CustomLocation_Verify(ManageLocationObject data) throws Exception {	
		
		 //Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory -  using custom location, default category and Order guide - INV_SI_002
		 component().setupInventorywithOGCustomLocDefaultCatMultipleLocation(data.strLocationNames, data.strLocationTypes, data.strLocationNames.split("/")[0]+"/"+data.strLocationNames.split("/")[1], false, false);
		 //INV_ML_002 - verify custom locations and order of location from manage location page	and the item count with locations
		 //Tap Locations from inventory tools page
		 home().tapLocations();
		 //verify the Locations page is loaded
		  locations().verifyLocationsPage();
		 //verify item count displayed against each location
		 locations().verifyLocationsWithCount(data.strNumberOfLocations, data.strLocationsWithCount1,data.strLocationsWithCount2);
		 //Tap on location from locations page
	     locations().tapLocation(data.strLocationNames.split("/")[0]);
		 //verify Location details page
		 locations().verifyLocationDetailsPage();
		 //verify number of items
		 locations().verifyNumberOfItemInLocation(data.strItemsCount, data.strLocationNames.split("/")[0]);
		 ///Hit on items on this page and verify the details
		 //get number of items in this location
		 locations().getNumberOfItemInThisLocation();
		 //Tap on view items on this location
		 locations().tapItemInThisLocation();
		 //verify correct location page is displayed 
		 locations().verifyLocationPage(data.strLocationNames.split("/")[0]);
		 //verify number of line items in this location equal to number of items in view items in this location button
		 locations().verifyNumberOfItemInThisLocation();
		 //Tap on back
		 generic().tapBack();
		//Tap on Close
		 generic().tapClose();
		 
		 //INV_ML_008 - Add & Edit location from manage location and verify the changes are reflected properly. 
		 //Click on +
		 generic().tapAdd();
		  //Enter Location details
		 locations().enterLocationDetails(data.strLocationName2, data.strLocationType2);
		 //tap done
		 generic().tapDone();
		 //tap close
		 generic().tapClose();
		 //verify the Locations page is loaded
		 locations().verifyLocationsPage();
		 //verify newly created Location is added in the list
		 locations().verifyLocationInList(data.strLocationName2,true);
		 //tap on location created
		 locations().tapLocation(data.strLocationName2);
		 //verify location details
		 locations().verifyLocationDetails(data.strLocationName2, data.strLocationType2);
		 //tap on edit
		 generic().tapEdit();
		 //update new location details
		 locations().enterLocationDetails(data.strLocationName3, data.strLocationType3);
		 //tap done
		 generic().tapDone();
		 //tap back
		 generic().tapClose();
		 //verify newly created Location is added in the list
		 locations().verifyLocationInList(data.strLocationName3,true);
		 //verify edited location -old location is not available in the list
		 locations().verifyLocationInList(data.strLocationName2,false);
		//tap on location created
		 locations().tapLocation(data.strLocationName3);
		 //verify location details
		 locations().verifyLocationDetails(data.strLocationName3, data.strLocationType3);
		 //logout form location details page
		 component().logoutFromLocationDetailsPage();
		 //close app
		 generic().closeApp();

	 }
	 
	 
	 /******************************************************************************************
	  * Name : INV_ML_012_TI_055_DefaultLoc_DeleteAllLocation_VerifyTrackInventory
	  * 
	  * Description : User should be able to Edit and delete custom Location from Manage Locations and verify on Track inventory locations. 
	  * 
	  * Manual Test cases : INV_ML_012, INV_TI_055
	  * 
	  * Author : Periyasamy_Nainar
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

	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageLocation","ManageLocation_iOS1","Defect_D829"}, description = "Create and delete custom Location from Manage Locations and verify on Track inventory locations")
	 public void INV_ML_012_TI_055_DefaultLoc_DeleteAllLocation_VerifyTrackInventory(ManageLocationObject data) throws Exception {	
		
		//Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory - INV_SI_001 -  Can plug it in once the set inventory screens are stable
		 // Setup OG+Default Loc+Default Cat			 
		 component().setupInventorywithOGDefaultLocDefaultCat();
		 //INV_ML_012 - Delete all default locations from manage locations page and verify kithcen onboarding screen is displayed 
		//Tap Locations from inventory tools page
		 home().tapTrackInventory();
		 //verify location page is displayed
		 locations().verifyLocationsPage();
		//get item count from location -no location
		 locations().getItemCountInLocation(data.strLocationName4);  
		 //Tap on back
		 generic().tapBack();
		 //Tap on locations from inventory tools page
		 home().tapLocations();		 
		 //verify default locations and 
		 locations().verifyDefaultLocations();		
		 //tap on any location - Delete first default location
		 locations().tapLocation(data.strLocationName1);
		 //Tap on Edit -- not required
		 //get All items from location page before delete the location
		 locations().tapItemInThisLocation();
		// locations().getAllItemsFromLocation();
		 locations().getAllProductsFromInventoryList(data.strLocationName1);
		 //Tap on back
		 generic().tapBack();
		 //Tap on Delete this location
		 locations().tapDeleteButton();		 
		 //verify Delete location confirmation modal
		 locations().verifyDeleteConfirmationMessage(data.strLocationName1, data.strLocationType1);   //strLocationType1 - count 1
		 //Tap on Yes Delete
		 generic().tapYesDelete();
		 //verify deleted location is not displayed in locations list
		 locations().verifyLocationInList(data.strLocationName1, false);		 
		 //Delete 2nd default location
		//tap on any location 
		 locations().tapLocation(data.strLocationName2);
		 //Tap on Edit -- not required
		 //get All items from location page before delete the location
		 locations().tapItemInThisLocation();
		// locations().getAllItemsFromLocation();
		 locations().getAllProductsFromInventoryList(data.strLocationName2);
		 //Tap on back
		 generic().tapBack();
		 //Tap on Delete this location
		 locations().tapDeleteButton();		 
		 //verify Delete location confirmation modal
		 locations().verifyDeleteConfirmationMessage(data.strLocationName2, data.strLocationType2);   //strLocationType2 - count 2
		 //Tap on Yes Delete
		 generic().tapYesDelete();
		 //verify deleted location is not displayed in locations list
		 locations().verifyLocationInList(data.strLocationName2, false);		
		 //Delete 3rd default location
		//tap on any location 
		 locations().tapLocation(data.strLocationName3);
		 //Tap on Edit -- not required
		 //get All items from location page before delete the location
		 locations().tapItemInThisLocation();
		 //locations().getAllItemsFromLocation();
		 locations().getAllProductsFromInventoryList(data.strLocationName3);
		 //Tap on back
		 generic().tapBack();
		 //Tap on Delete this location
		 locations().tapDeleteButton();		 
		 //verify Delete location confirmation modal/		 locations().verifyDeleteConfirmationMessage(data.strLocationName3, data.strLocationType3);   //strLocationType3 - count 3
		 //Tap on Yes Delete
		 generic().tapYesDelete();			
		 //verify location on boarding page is displayed or not - To validate all locations are deleted
		 locations().verifyKitchenOnboardingPage();		
		 //Tap on back button through driver
		 generic().goBack();
		 //swipe function can be used instead of goBack function
		// locations().swipeScreen();
		 //Tap on back to go to home page
		 generic().tapBack();     
		 
		//below are the validation as part of INV_TI_055 - Verify when all the location are deleted the entire items from each location moves to "No Location" 
		 //Tap on Track inventory
		 home().tapTrackInventory();
		//verify location onboarding page is displayed or not
		 locations().verifyKitchenOnboardingPage();
		 //Tap on back button through driver
		 generic().goBack();
		 generic().waitFor(4);
		 //swipe function can be used instead of goBack function
		// locations().swipeScreen();
		 //verify deleted location is not displayed in locations list
		 locations().verifyLocationInList(data.strLocationName1, false); 
		 locations().verifyLocationInList(data.strLocationName2, false);	
		 locations().verifyLocationInList(data.strLocationName3, false);	
		 //verify no location is displayed in locations page
		 locations().verifyLocationInList(data.strLocationName4, true);
		 //Tap on no location page
		 locations().tapLocation(data.strLocationName4);
		 //verify wheter all items in deleted location is available in no location page
		 locations().verifyDeletedProductsInNoLocationList(data.strLocationName1, data.strLocationName4);
		 locations().verifyDeletedProductsInNoLocationList(data.strLocationName2, data.strLocationName4);
		 locations().verifyDeletedProductsInNoLocationList(data.strLocationName3, data.strLocationName4);
		 //Tap on back to go to home page
		 generic().tapBack(); 
		 //Tap on back button through driver
		 generic().goBack();
		 //verify item count in no location is increased with all items in deleted locations. 
		 locations().verifyItemCountAfterDeleteLoc(data.strLocationName4, data.strLocationName1+"," +data.strLocationName2+"," + data.strLocationName3,data.strItemsCount);	 
		 //logout from locations page
		 component().logoutFromLocationList();
		 //close app
		 generic().closeApp();
		 
		 //INV_ML_013 Test case can be added with this script once setup inventory flow is automated/working
		
	 }
	 
	 
	
	 
	 /******************************************************************************************
	  * Name : INV_ML_003_CustomLocation_Name_VerifyLocations_ItemCount_View
	  * 
	  * Description : Verify whether all locations are displayed properly in locations page with item count. Also verify view items in this location. 
	  * 
	  * Manual Test cases : INV_ML_003
	  * 
	  * Author : Periyasamy_Nainar
	  * 
	  * Date : 10/04/2016
	  * 
	  * Test data: uomautnu122
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/

	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageLocation","ManageLocation_iOS1"}, description = "Verify locations Item count and View link")
 public void INV_ML_003_CustomLocation_Name_VerifyLocations_ItemCount_View(ManageLocationObject data) throws Exception {	
		
		 //Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory - using Custom location (Location name as custom categories) INV_SI_007		 
		 component().setupInventorywithCustomListCustCatAsLocationDefaultCat(data.strListName1); 		
		 //Tap on locations from inventory tools page
		 home().tapLocations();
		 //verify locations page is dispalyed 
		 locations().verifyLocationsPage();		
		 //verify item count displayed against each location  - All parameters for locations only 
		 locations().verifyLocationsWithCount(data.strNumberOfLocations, data.strLocationsWithCount1, data.strLocationsWithCount2, data.strLocationsWithCount3);
		 //Tap on location from locations page
		 locations().tapLocation(data.strLocationName1);
		 //verify Location details page
		 locations().verifyLocationDetailsPage();
		 //verify number of items mentioned in link 
		 locations().verifyNumberOfItemInLocation(data.strItemsCount, data.strLocationName1);
		 ///Hit on items on this page and verify the details
		 //get number of items in this location
		 locations().getNumberOfItemInThisLocation();
		 //Tap on view items on this location
		 locations().tapItemInThisLocation();
		 //verify correct location page is displayed 
		 locations().verifyLocationPage(data.strLocationName1);
		 //verify number of line items in this location equal to number of items in view items in this location button
		 locations().verifyNumberOfItemInThisLocation();
		//Tap on back 
		 generic().tapBack();	 
		 //verify Location details page
		 locations().verifyLocationDetailsPage();	 
		 //logout form location details page
		 component().logoutFromLocationDetailsPage();
		 //close app
		 generic().closeApp();
		
	 }
	 
	 /******************************************************************************************
	  * Name : INV_ML_004_CustomLocation_List_VerifyLocations_ItemCount_View
	  * 
	  * Description : Verify whether all locations are displayed properly in locations page with item count. Also verify view items in this location. 
	  * 
	  * Manual Test cases : INV_ML_004
	  * 
	  * Author : Periyasamy_Nainar
	  * 
	  * Date : 9/28/2016
	  * 
	  * Test data: uomautnu122
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/

	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageLocation","ManageLocation_iOS1","CriticalBatchAndroid"}, description = "Verify locations Item count and View link")
	 public void INV_ML_004_CustomLocation_List_VerifyLocations_ItemCount_View(ManageLocationObject data) throws Exception {	
		
		 //Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory -  using Custom location (Location name as custom lists) INV_SI_009	 
		 component().setupInventorywithMultipleCustomListDefaultLocationDefaultCategory_ItemsMultipleLocation(data.strListName1, data.strListName2);			
		 //Tap on locations from inventory tools page
		 home().tapLocations();
		 //verify locations page is displayed 
		 locations().verifyLocationsPage();		
		 //verify item count displayed against each location
		 locations().verifyLocationsWithCount(data.strNumberOfLocations, data.strLocationsWithCount1,data.strLocationsWithCount2);
		 //Tap on location from locations page
		 locations().tapLocation(data.strLocationName1);
		 //verify Location details page
		 locations().verifyLocationDetailsPage();
		 //verify number of items
		 locations().verifyNumberOfItemInLocation(data.strItemsCount, data.strLocationName1);
		 ///Hit on items on this page and verify the details
		 //get number of items in this location
		 locations().getNumberOfItemInThisLocation();
		 //Tap on view items on this location
		 locations().tapItemInThisLocation();
		 //verify correct location page is displayed 
		 locations().verifyLocationPage(data.strLocationName1);
		 //verify number of line items in this location equal to number of items in view items in this location button
		 locations().verifyNumberOfItemInThisLocation();
		//Tap on back 
		 generic().tapBack();	 
		 //verify Location details page
		 locations().verifyLocationDetailsPage();	 
		 //logout form location details page
		 component().logoutFromLocationDetailsPage();
		 //close app
		 generic().closeApp();
		
	 }
	 
	 
	 /******************************************************************************************
	  * Name : INV_ML_013_TL_056_DefaultLoc_DeleteAllLocation_SetupDefaultLocations_verifyTrackInventory
	  * 
	  * Description : Validate the user is provided with option to Setup locations if the user has deleted all of the previously created location - New location using default
	  *and verify the new locations and product details from Track Inventory  
	  * 
	  * Manual Test cases : INV_ML_013,INV_TL_056
	  * 
	  * Author : Periyasamy_Nainar
	  * 
	  * Date : 10/12/2016
	  * 
	  * Test data: uomautnu105
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/

	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageLocation","ManageLocation_iOS1"}, description = "Verify user has an option to setup location once the user delete all locations")

	 public void INV_ML_013_TI_056_DefaultLoc_DeleteAllLocation_SetupDefaultLocations_verifyTrackInventory(ManageLocationObject data) throws Exception {	
		
		//Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory - INV_SI_001 -  Can plug it in once the set inventory screens are stable
         component().setupInventorywithOGDefaultLocDefaultCat();	 
		 //INV_ML_012 - Delete all default locations from manage locations page and verify kithcen onboarding screen is displayed 
		 component().deleteAllExistingLocations();	
		 //verify setup location link is displayed in home page
		 home().verifySetupLocations();
		 //Tap on setup location from home page
		 home().tapSetupLocations();
		 //verify onboarding screen for kitchen setup -location
		 locations().verifyKitchenOnboardingPage();
		 //swipe the screen to navigate to setup locations page
		 locations().swipeScreenInHorizontal(8, 2);	
		 //verify setup locations screen is displayed or not
		 setupInventory().verifySetupLocationsPageDisplayed();		
		 //Tap on skip and use default in select location screen
		 setupInventory().tapOnSkipAndUseDefaultButtonInSetupInventoryPage();
		 //tap on next button
		 generic().tapNextButton();
		 //complete the Setup process and verify whether the setup is complete and successful
		 setupInventory().verifySetupIsComplete();		 
		 //wait for 5 seconds for the page to load
		 generic().waitFor(8);
		 //Tap on manage location
		 home().tapLocations();
		 //verify default locations are displayed in locations list page
		 locations().verifyLocationInList(data.strLocationName1, true);
		 locations().verifyLocationInList(data.strLocationName2, true);
		 locations().verifyLocationInList(data.strLocationName3, true);	
		 
		 ///INV_TI_056
		 //Tap on back to go to home page
		 generic().tapBack();     
	    //Tap on Track inventory
		 home().tapTrackInventory();
		//verify Location details page
		 locations().verifyLocationsPage();
		 //verify default locations are displayed in locations list page		 
		 locations().verifyDefaultLocations();	
		 //verify default locations are displayed in proper order - No location
		 locations().verifyOrderOfDefaultLocations(data.strLocationName4);
		 //tap on a location
		 locations().tapLocation(data.strLocationName1);
		 //verify whether cooler items are comes under cooler location
		 locations().verifyLocationOfAllItemsInList(data.strLocationName1);
		 //Tap on back to go to locations page
		 generic().tapBack();  
		 //tap on a location
		 locations().tapLocation(data.strLocationName2);
		 //verify whether freezer items are comes under freezer location
		 locations().verifyLocationOfAllItemsInList(data.strLocationName2);
		 //Tap on back to go to locations page
		 generic().tapBack(); 
		 //tap on a location
		 locations().tapLocation(data.strLocationName3);
		 //verify whether Dry items are comes under Dry location
		 locations().verifyLocationOfAllItemsInList(data.strLocationName3);		
		//Tap on back to go to locations page
		 generic().tapBack();
		//tap on a location
		 locations().tapLocation(data.strLocationName1);
		 //verify product card fields in list
		 locations().verifyProductCardDetailsInList(true);
		 //verify category names of cooler location
		 locations().verifyItemCategoryofAllItemsInList(data.strCategoryNames1+"/"+ data.strCategoryNames2);
		 generic().tapBack(); 
		 //tap on a location
		 locations().tapLocation(data.strLocationName2);
		//verify category names of freezer location
		 locations().verifyItemCategoryofAllItemsInList(data.strCategoryNames1+"/"+ data.strCategoryNames2);	
		 generic().tapBack(); 
		 //tap on a location
		 locations().tapLocation(data.strLocationName3);
		//verify category names of Dry location
		 locations().verifyItemCategoryofAllItemsInList(data.strCategoryNames1+"/"+ data.strCategoryNames2);	
		 //tap back
		 generic().tapBack();
		 //verify no items in no location
		 locations().tapLocation(data.strLocationName4);
		 locations().verifyLocationPage(data.strLocationName4);
		 locations().verifyNoItemsInLocation();	
		 //logout form inventory list page
		 component().logoutFromInventoryList();
		 //close app
		 generic().closeApp();

	 }
	 
	 
	 /******************************************************************************************
	  * Name : INV_ML_014_TI_057_DefaultLoc_DeleteAllLocation_SetupCustomLocations_VerifyTrackInventory
	  * 
	  * Description : Validate the user is provided with option to Setup locations if the user has deleted all of the previously created location - New location using default 
	  * 
	  * Manual Test cases : INV_ML_014, INV_TI_057
	  * 
	  * Author : Periyasamy_Nainar
	  * 
	  * Date : 10/14/2016
	  * 
	  * Test data: uomautnu105
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/

	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageLocation","ManageLocation_iOS2"}, description = "Verify user has an option to setup location once the user delete all locations")

	 public void INV_ML_014_TI_057_DefaultLoc_DeleteAllLocation_SetupCustomLocations_VerifyTrackInventory(ManageLocationObject data) throws Exception {	
		
		//Login to app
		 component().login(data.strUserName, data.strPassword);
		 // Setup OG+Default Loc+Default Cat		 - INV_SI_001 + Delete all the location after setup	 
		component().setupInventorywithOGDefaultLocDefaultCat();
		 //Delete all default locations from manage locations page and verify kithcen onboarding screen is displayed 
		 component().deleteAllExistingLocations();	
		 //verify setup location link is displayed in home page
		 home().verifySetupLocations();
		 //Tap on setup location from home page
		 home().tapSetupLocations();
		 //verify on boarding screen for kitchen setup -location
		 locations().verifyKitchenOnboardingPage();
		 //swipe the screen to navigate to setup locations page
		 locations().swipeScreenInHorizontal(8, 2);
		 //verify setup locations screen is displayed or not
		 setupInventory().verifySetupLocationsPageDisplayed();
		 //Tap on add new location 
		 setupInventory().tapOnAddNewLocationButton();
		 //verify prompt to enter new location is displayed
		 setupInventory().verifyPromptToEnterCustomLocations();
		 //enter custom location details and hit save
		 component().AddMultipleLocationsInSetUpLocation(data.strLocationNames, data.strLocationTypes);
		 //verify newly added location in list view
		 setupInventory().verifyAdditionOfNewLocation(data.strLocationNames);
		 // Hit next button
		 setupInventory().tapOnNextButton();
		 //wait for 7 seconds for the page to load
		 generic().waitForPageLoadAndroid(7);
		 //swipe through all items and verify product details, select location for the items
		// setupInventory().swipeThroughItemsToVerifyDetailsAndSelectLocation(true,true,"all", data.strLocationNames.split("/")[0], "default");
		 setupInventory().swipeThroughItemsAndSelectLocationAndCategory("cat",true, "custom",data.strLocationName1, "default", "");
		 //hit on done button 
		 generic().tapDone();
		 //complete the Setup process and verify whether the setup is complete and successful
		 setupInventory().verifySetupIsComplete(); 	 
		 //Tap on manage location
		 home().tapLocations();		
		 //verify all custome locations are displayed in locations list page
		 locations().verifyLocationInList(data.strLocationNames, true);
		 //Tap on back to go to home page
		 generic().tapBack(); 		 
		///INV_TI_057	    
	    //Tap on Track inventory
		 home().tapTrackInventory();
		//verify Location details page
		 locations().verifyLocationsPage();
		 //verify all custom locations are displayed in locations page
		 locations().verifyLocationInList(data.strLocationNames, true);
		 //tap on a location
		 locations().tapLocation(data.strLocationNames.split("/")[1]);  // loc2
		 //verify only the items assigned by customer is displayed in this location 
		 locations().verifyAssignedProductsInInventoryList(data.strLocationNames.split("/")[1]);
		 //Tap on back to go to locations page
		 generic().tapBack();  
		 //tap on a location
		 locations().tapLocation(data.strLocationNames.split("/")[0]);
		//verify only the items assigned by customer is displayed in this location 
		 locations().verifyAssignedProductsInInventoryList(data.strLocationNames.split("/")[0]);
		 //verify product card fields in list
		 locations().verifyProductCardDetailsInList(true);
		 //Tap on back to go to locations page
		 generic().tapBack(); 	
		 locations().tapLocation(data.strLocationNames.split("/")[0]);
		 //verify category names of cooler location
		 locations().verifyItemCategoryofAllItemsInList(data.strCategoryNames1+"/"+ data.strCategoryNames2);
		 generic().tapBack(); 
		 //tap on a location
		 locations().tapLocation(data.strLocationNames.split("/")[1]);
		//verify category names of freezer location
		 locations().verifyItemCategoryofAllItemsInList(data.strCategoryNames1+"/"+ data.strCategoryNames2);	
		 generic().tapBack(); 
		 //tap on a location
		 locations().tapLocation(data.strLocationNames.split("/")[2]);
		//verify category names of Dry location
		 locations().verifyItemCategoryofAllItemsInList(data.strCategoryNames1+"/"+ data.strCategoryNames2);	
		 //tap back
		 generic().tapBack();
		 //verify no items in no location
		 locations().tapLocation(data.strLocationName4);
		 locations().verifyLocationPage(data.strLocationName4);
		 locations().verifyAssignedProductsInInventoryList("No Location");
		 //logout form inventory list page
		 component().logoutFromInventoryList();
		 //close app
		 generic().closeApp();
		
	 }
	 
	 
	 /******************************************************************************************
	  * Name : INV_ML_015_TI_058_DefaultLoc_DeleteAllLoc_SuggestedCat_SetupCustomLo_VerifyTrackInventory
	  * 
	  * Description : Validate the user is provided with option to Setup locations if the user has deleted all of the previously created location - New location created manually for Sugg 12 categories which exist previously
	  * 
	  * Manual Test cases : INV_ML_015, INV_TI_058
	  * 
	  * Author : Periyasamy_Nainar
	  * 
	  * Date : 10/06/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/

	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageLocation","ManageLocation_iOS2"}, description = "Verify user has an option to setup location once the user delete all locations")
 public void INV_ML_015_TI_058_DefaultLoc_DeleteAllLoc_SuggestedCat_SetupCustomLo_VerifyTrackInventory(ManageLocationObject data) throws Exception {	
		
		//Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory - INV_SI_004 -  Can plug it in once the set inventory screens are stable
		 // Setup OG+ Default Loc+ Suggested Cat	-INV_SI_004 + Delete all the location after setup		 
		 component().setupInventorywithOGDefaultLocSugg12Cat();  
		 // Delete all default locations from manage locations page and verify kithcen onboarding screen is displayed 
		 component().deleteAllExistingLocations();	
		 //verify setup location link is displayed in home page
		 home().verifySetupLocations();
		 //Tap on setup location from home page
		 home().tapSetupLocations();
		 //verify on boarding screen for kitchen setup -location
		 locations().verifyKitchenOnboardingPage();
		 //swipe the screen to navigate to setup locations page
		 locations().swipeScreenInHorizontal(8, 2);
		 //verify setup locations screen is displayed or not
		 setupInventory().verifySetupLocationsPageDisplayed();
		 //Tap on add new location 
		 setupInventory().tapOnAddNewLocationButton();
		 //verify prompt to enter new location is displayed
		 setupInventory().verifyPromptToEnterCustomLocations();
		 //enter custom location details and hit save
		 component().AddMultipleLocationsInSetUpLocation(data.strLocationNames, data.strLocationTypes);
		 //verify newly added location in list view
		 setupInventory().verifyAdditionOfNewLocation(data.strLocationNames);
		 // Hit next button
		 setupInventory().tapOnNextButton();
		 //swipe through all items and verify product details, select location for the items
		 setupInventory().swipeThroughItemsAndSelectLocationAndCategory("cat",true, "custom",data.strLocationName1, "suggested","");
		 //hit on done button 
		 generic().tapDone();
		 //complete the Setup process and verify whether the setup is complete and successful
		 setupInventory().verifySetupIsComplete(); 	 		
		 //INV_TI_058 
		 //Tap on manage location
		 home().tapLocations();		
		 //verify all custome locations are displayed in locations list page
		 locations().verifyLocationInList(data.strLocationNames, true);
		 //Tap on back to go to home page
		 generic().tapBack(); 		 
		///INV_TI_057  - Verify when the location are setup using "Setup Location" from Managing option , the custom  location are setup accordingly along with Sugg 12
	    //Tap on Track inventory
		 home().tapTrackInventory();
		//verify Location details page
		 locations().verifyLocationsPage();
		 //verify all custom locations are displayed in locations page
		 locations().verifyLocationInList(data.strLocationNames, true);
		 //tap on a location
		 locations().tapLocation(data.strLocationNames.split("/")[1]);  // loc2
		 //verify only the items assigned by customer is displayed in this location 
		 locations().verifyAssignedProductsInInventoryList(data.strLocationNames.split("/")[1]);
		 locations().verifyItemCategoryofAllItemsInList("", "suggested");	
		 //Tap on back to go to locations page
		 generic().tapBack();  
		 //tap on a location
		 locations().tapLocation(data.strLocationNames.split("/")[0]);
		//verify only the items assigned by customer is displayed in this location 
		 locations().verifyAssignedProductsInInventoryList(data.strLocationNames.split("/")[0]);
		 locations().verifyItemCategoryofAllItemsInList("", "suggested");
		 //verify product card fields in list
		 locations().verifyProductCardDetailsInList(true);
		 generic().tapBack(); 
		 //tap on a location
		 locations().tapLocation(data.strLocationNames.split("/")[2]);
		//verify category names of Dry location
		 locations().verifyItemCategoryofAllItemsInList("", "suggested");	
		 //tap back
		 generic().tapBack();
		 //verify no items in no location
		 locations().tapLocation(data.strLocationName4);
		 locations().verifyLocationPage(data.strLocationName4);
		 //locations().verifyNoItemsInLocation();	
		 locations().verifyAssignedProductsInInventoryList(data.strLocationName4);
		//logout form inventory list page
		 component().logoutFromInventoryList();
		 //close app
		 generic().closeApp();
		
	 }

	 /******************************************************************************************
	  * Name : INV_ML_016_CustomLoc_DeleteAllLocation_CustomCat_SetupCustomLocations
	  * 
	  * Description : Validate the user is provided with option to Setup locations if the user has deleted all of the previously created location - New location created manually for custom categories which exist previously. 
      *  1. During location assignment the User can Multy select location
	  *  2. Also change the category of an item from previous to updated category
	  * 
	  * Manual Test cases : INV_ML_016
	  * 
	  * Author : Periyasamy_Nainar
	  * 
	  * Date : 10/06/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/

	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageLocation","ManageLocation_iOS2","CriticalBatchAndroid"}, description = "Verify user has an option to setup location once the user delete all locations")
 public void INV_ML_016_TI_059_CustomLoc_DeleteAllLoc_CustomCat_SetupCustomLoc_VerifyTrackInventory(ManageLocationObject data) throws Exception {	
		
		//Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory - INV_SI_006 -  Can plug it in once the set inventory screens are stable
		 // Setup OG+Custom Loc+Custom Categories (Assign all items)	- INV_SI_006 + Delete all the location after setup		 
		 component().setupInventorywithOGCustomLocCustomCategory(data.strLocationName1, data.strLocationType1, data.strCategoryNames1, "Food/NonFood/Food");
		 // Delete all default locations from manage locations page and verify kitchen on boarding screen is displayed 
		 component().deleteAllExistingLocations();	
		 //verify setup location link is displayed in home page
		 home().verifySetupLocations();
		 //Tap on setup location from home page
		 home().tapSetupLocations();
		 //verify on boarding screen for kitchen setup -location
		 locations().verifyKitchenOnboardingPage();
		 //swipe the screen to navigate to setup locations page
		 locations().swipeScreenInHorizontal(8, 2);
		 //verify setup locations screen is displayed or not
		 setupInventory().verifySetupLocationsPageDisplayed();
		 //Tap on add new location 
		 setupInventory().tapOnAddNewLocationButton();
		 //verify prompt to enter new location is displayed
		 setupInventory().verifyPromptToEnterCustomLocations();
		 //enter custom location details and hit save
		 component().AddMultipleLocationsInSetUpLocation(data.strLocationName2, data.strLocationType2);
		 //verify newly added location in list view
		 setupInventory().verifyAdditionOfNewLocation(data.strLocationName2);
		 // Hit next button
		 setupInventory().tapOnNextButton();
		 //swipe through all items and verify product details, select location for the items and update category
		 setupInventory().swipeThroughItemsAndSelectLocationAndCategory("", true, "custom",data.strLocationNames, "custom",data.strCategoryNames);		
		 //hit on done button 
		 generic().tapDone();
		 //complete the Setup process and verify whether the setup is complete and successful
		 setupInventory().verifySetupIsComplete(); 	 
		 //Tap on manage location
		 home().tapLocations();
		 //verify default locations are displayed in locations list page
		 locations().verifyLocationInList(data.strLocationName2, true);
		 //Tap on back to go to home page
		 generic().tapBack(); 		 
		///INV_TI_059  - Verify when the location are setup using "Setup Location" from Managing option , the custom  location are setup accordingly along with Custom Categories
	    //Tap on Track inventory
		 home().tapTrackInventory();
		//verify Location details page
		 locations().verifyLocationsPage();
		 //verify all custom locations are displayed in locations page
		 locations().verifyLocationInList(data.strLocationName2, true);
		 //tap on a location
		 locations().tapLocation(data.strLocationName2.split("/")[1]);  // loc2
		 //verify only the items assigned by customer is displayed in this location 
		 locations().verifyAssignedProductsInInventoryList(data.strLocationName2.split("/")[1]);
		 locations().verifyCategoryOfAssignedProductsInInventoryList(data.strLocationName2.split("/")[1]);
		 //Tap on back to go to locations page
		 generic().tapBack();  
		 //tap on a location
		 locations().tapLocation(data.strLocationName2.split("/")[0]);
		//verify only the items assigned by customer is displayed in this location 
		 locations().verifyAssignedProductsInInventoryList(data.strLocationName2.split("/")[0]);
		 locations().verifyCategoryOfAssignedProductsInInventoryList(data.strLocationName2.split("/")[0]);
		 //verify product card fields in list
		 locations().verifyProductCardDetailsInList(true);
		 /*//Tap on back to go to locations page - Not needed , move the code to top
		 generic().tapBack(); 	
		 locations().tapLocation(data.strLocationNames.split("/")[0]);		 
		 //verify category names of cooler location
		 locations().verifyItemCategoryofAllItemsInList("", "suggested");
		 generic().tapBack(); 
		 //tap on a location
		 locations().tapLocation(data.strLocationNames.split("/")[1]);
		//verify category names of freezer location
		 locations().verifyItemCategoryofAllItemsInList("", "suggested");	
		 generic().tapBack(); 
		 //tap on a location
		 locations().tapLocation(data.strLocationNames.split("/")[2]);
		//verify category names of Dry location
		 locations().verifyItemCategoryofAllItemsInList("", "suggested");	*/
		 //tap back
		 generic().tapBack();
		 //verify no items in no location
		 locations().tapLocation(data.strLocationName4);
		 locations().verifyLocationPage(data.strLocationName4);
		 //locations().verifyNoItemsInLocation();	
		 locations().verifyAssignedProductsInInventoryList(data.strLocationName4);		
		//logout form inventory list page
		 component().logoutFromInventoryList();
		 //close app
		 generic().closeApp();
		
	 }

	 /******************************************************************************************
	  * Name : INV_ML_017_018_VerifyDuplicate_ErrorMessage_AddNewLocation_EditLocation_SameName
	  * 
	  * Description : 1. verify the error message when the user tries to create new location with existing location name. 
	  * 			  2. verify the error message when the user tries to edit the location name with existing location name. 
	  * 
	  * Manual Test cases : INV_ML_017, INV_ML_018
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 9/26/2016
	  * 
	  * Test Data: uomautnu105
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/

	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageLocation","ManageLocation_iOS1"}, description = "Edit location details and verify")
	 public void INV_ML_017_018_VerifyDuplicate_ErrorMessage_AddNewLocation_EditLocation_SameName(ManageLocationObject data) throws Exception {	
		
		 //Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory -  order guide, default location and default category - INV_SI_001
		 component().setupInventorywithOGDefaultLocDefaultCat();
		 //create new location form tools inventory page
		 component().createLocationFromManageLocation(data.strLocationName1, data.strLocationType1);
		 home().tapLocations();
		 //verify the Locations page is loaded
		 locations().verifyLocationsPage();
		 generic().tapAdd();
		 //verify add location page
		 locations().verifyAddLocationPage();
		 //Enter Location details
		 locations().enterLocationDetails(data.strLocationName1,data.strLocationType2);
		 //tap done
		 generic().tapDone();
		 //verify error message when the user is creating new supplier with existing supplier name. 
		 generic().verifyErrorMessageForDuplicateName("Could not add location","A Location with the same name already exists","Location");
		 //tap on close button
		 generic().tapOnCloseErrorMessage();
		 //tap on cancel button
		 generic().tapCancel();
		//verify the Locations page is loaded
		 locations().verifyLocationsPage();
		 //verify number of locations in location page
		 locations().verifyNumberOfLocation("4");
		 //tap on back
		 generic().tapBack();
		 //create one more new location from tools inventory page
		 component().createLocationFromManageLocation(data.strLocationName2, data.strLocationType2);
		 home().tapLocations();
		 //verify the Locations page is loaded
		 locations().verifyLocationsPage();
		 //verify number of locations in location page
		 locations().verifyNumberOfLocation("5");
		 locations().tapLocation(data.strLocationName2);
		 //verify add location page
		 locations().verifyLocationDetailsPage();
		 //Tap on Edit button
		 generic().tapEdit();		 
	     //Enter Location details
		 locations().enterLocationDetails(data.strLocationName1,data.strLocationType2);
		 //tap done
		 generic().tapDone();
		//verify error message when the user is creating new supplier with existing supplier name. 
		 generic().verifyErrorMessageForDuplicateName("Could not save location","A Location with the same name already exists","Location");
		 //tap on close button
		 generic().tapOnCloseErrorMessage();
		 //tap on cancel button
		 generic().tapCancel();
		 //tap on close button 
		 generic().tapClose();
		//verify the Locations page is loaded
		 locations().verifyLocationsPage();
		 //verify number of locations in location page
		 locations().verifyNumberOfLocation("5");
		//logout form location list page
		 component().logoutFromLocationList();
		 //close app
		 generic().closeApp();

	 }
	/******************************************************************************************
	  * Name : INV__ML_009_011_TI_053_CustomLocation_UpdateDeleteLocation_VerifyProductDetails_ItemInMultipleLocation
	  * 
	  * Description : Edit/Delete locations from manage location page, item should be available in multiple location and verify same items are displayed in updated locations in inventory list page. 
	  * 
	  * Manual Test cases : INV_TI_053 and INV_ML_009 and INV_ML_011
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 10/11/2016 
	  * 
	  * Notes : 
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/

	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"ManageLocation","ManageLocation_iOS1","CriticalBatchAndroid","CriticalPatchIOS"}, description = "verify update location from manage location and product details from track inven")

	 public void INV_ML_009_011_TI_053_CustomLocation_UpdateDeleteLocation_VerifyProductDetails_ItemInMultipleLocation(ManageLocationObject data) throws Exception {	 
	
		//Login to app
		component().login(data.strUserName, data.strPassword);		 
		// Below are pre-requisite - Setup done using Custom location and Items exist in multiple location - Item I1 belongs in Location X and Y. update Location X and Y
		//Set up Inventory - INV_SI_003 - Setup OG+ Custom Loc + Default Cat		 
		component().setupInventorywithOGCustomLocDefaultCategorySingleLocationSelection(data.strLocationName1+"/"+data.strLocationName2+"/"+data.strLocationName5, "COOLER/FREEZER/DRY",false);
		//tap on track inventory 
		home().tapTrackInventory();
		//tap on any location - loc1
		locations().tapLocation(data.strLocationName1);
		//tap on any product from inventory list page
		locations().selectAnItemFromProductList(data.strProductName);
		//verify product details page 
		product().verifyProductDetailsPage();
		//tap on Edit icon 
		generic().tapEdit();
		//tap on add another location
		product().tapOnAddAnotherLocation();
		//tap on location drop down - new one
		product().tapLocation("1");
		//select location from location picker
		generic().selectValueFromDropdown(data.strLocationName2, "Selected location '" + data.strLocationName2 + "' from location drop down");
		//tap on done
		generic().tapDone();
		//tap on back 
		generic().tapClose();
		generic().tapBack();
		generic().tapBack();  
	
		//tap on track inventory - get item details before updating location details from manage location screen
		home().tapTrackInventory();
		//tap on any location
		locations().tapLocation(data.strLocationName1);
		//get all products from inventory list page
		locations().getAllProductsFromInventoryList(data.strLocationName1);
		//Tap on back
		generic().tapBack();
		//tap on any location
		locations().tapLocation(data.strLocationName2);
		//get all products from second location
		locations().getAllProductsFromInventoryList(data.strLocationName2);
		//Tap on back
		generic().tapBack();
		generic().tapBack();
	
		//Edit location from manage location page - both loc INV_ML_009. Items in multiple location. 
		component().editLocationFromManageLocation(data.strLocationName1, data.strLocationName3, data.strLocationType3);
		component().editLocationFromManageLocation(data.strLocationName2, data.strLocationName4, data.strLocationType2);
		//navigate to track inventory
		home().tapTrackInventory();
		//verify locations page is displayed
		locations().verifyLocationsPage();
		//Inv TI 053 -
		//validate updated location is displayed in track inventory page
		locations().verifyLocationInList(data.strLocationName3, true);
		locations().verifyLocationInList(data.strLocationName4, true);
		//old locations should be present in track inventory
		locations().verifyLocationInList(data.strLocationName1, false);
		locations().verifyLocationInList(data.strLocationName2, false);
		//click on any updated location
		locations().tapLocation(data.strLocationName3);
		//verify location page is displayed
		locations().verifyLocationPage(data.strLocationName3);
		//User should be able to view the list of same items - before and after editing location name
		locations().verifyProductsFromInventoryList(data.strLocationName1, data.strLocationName3);
		// Verify if the item belongs to location X and Y , then  under location X, the item I1 should also have the updated value of Y
		locations().verifyLocationNameInInventoryList(data.strProductName, data.strLocationName4);		 
		//Tap on any item and navigate to product card details page
		locations().selectAnItemFromProductList(data.strProductName);
		//verify product details page is loaded
		product().verifyProductDetailsPage();
		//verify selected location name is populated in location label - disable
		product().verifySelectedLocation("0", data.strLocationName3);
		//verify updated location on 2nd index
		product().verifySelectedLocation("1", data.strLocationName4);
		//tap on close button
		generic().tapClose();		 
		//Tap on back 
		generic().tapBack();
		locations().tapLocation(data.strLocationName4);
		//verify location page is displayed
		locations().verifyLocationPage(data.strLocationName4);
		//User should be able to view the list of same items - before and after editing location name
		locations().verifyProductsFromInventoryList(data.strLocationName2, data.strLocationName4);
		// Verify if the item belongs to location X and Y , then  under location X, the item I1 should also have the updated value of Y
		locations().verifyLocationNameInInventoryList(data.strProductName, data.strLocationName3);		 
		//Tap on any item and navigate to product card details page
		 locations().selectAnItemFromProductList(data.strProductName);
		 //verify product details page is loaded
		 product().verifyProductDetailsPage();
		 //verify selected location name is populated in location label - disable
		 product().verifySelectedLocation("0", data.strLocationName3);
		 //verify updated location on 2nd index
		 product().verifySelectedLocation("1", data.strLocationName4);	 	
		 //tap on close button
		 generic().tapClose();		 
		//Tap on back
		 generic().tapBack();	
		 generic().tapBack();	
		 
		 //Tap on locations
		 home().tapLocations();
		 locations().tapLocation(data.strLocationName3);
		 //INV_ML_011 - Delete location and verify all the items from the particular location is moved to no location
		 //tap on delete button
		 locations().tapDeleteButton();
		 //verify delete location confirmation modal page
		 locations().verifyDeleteConfirmationMessage(data.strLocationName3, "5");   // Defect on delete confirmaiton modal item count
		//commenting the above line of code to run the script in batch execution. Please uncomment this line of code once the issue is fixed. 
		 //tap on yes delete
		 generic().tapYesDelete();
		 //verify deleted location is not available in locations list
		 locations().verifyLocationInList(data.strLocationName3,false);
		 //Tap on back
		 generic().tapBack();
		 //navigate to track inventory
		 home().tapTrackInventory();
		 //tap on no locations
		 locations().tapLocation(data.strLocationNames);
		 //verify item count 
		 locations().verifyDeletedProductsInNoLocationList(data.strLocationName1, data.strLocationNames, data.strProductName);
		 //Tap on back
		 generic().tapBack();		 
		 //Tap on back 
		 generic().tapBack();		
		 
		//Tap on locations
		 home().tapLocations();
		 locations().tapLocation(data.strLocationName4);
		 //INV_ML_011 - Delete location and verify all the items from the particular location is moved to no location
		 //tap on delete button
		 locations().tapDeleteButton();
		 //verify delete location confirmation modal page
		 locations().verifyDeleteConfirmationMessage(data.strLocationName4, "5");   // Defect on delete confirmaiton modal item count
//commenting the above line of code to run the script in batch execution. Please uncomment this line of code once the issue is fixed. 
		 //tap on yes delete
		 generic().tapYesDelete();
		 //verify deleted location is not available in locations list
		 locations().verifyLocationInList(data.strLocationName4,false);
		 //Tap on back
		 generic().tapBack();
		 //navigate to track inventory
		 home().tapTrackInventory();
		 //tap on no locations
		 locations().tapLocation(data.strLocationNames);
		 //verify item count 
		 locations().verifyDeletedProductsInNoLocationList(data.strLocationName2, data.strLocationNames, "");
		//logout from inventory list page
		 component().logoutFromInventoryList();
		 //close app
		 generic().closeApp();
	 }
	 

	 
}


