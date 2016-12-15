package com.uom.oldfiles;


import java.io.IOException;
import java.lang.reflect.Method;

import com.DataRead.Excel;
import com.framework.*;
import com.uom.pages.common.*;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


public class WorkFlow extends Starter{
	//my changes to test my newly created branch
	//something
/*
	LoginPage loginPage=new LoginPage();
	HomePage homePage=new HomePage();
	AccountsPage accountsPage=new AccountsPage();
	InventoryToolPage inventoryToolPage=new InventoryToolPage();
	

    
    public static String[][] arrComplete ;
    Excel excel = new Excel();
    WorkFlowObject firstClassObject = new WorkFlowObject();
	
	/*
	 * Validating user is able to setup inventory by adding items from OrderGuide and then assign those items to Default location and Default category. 
	 * Validating location displayed for first item section on default locations and verifying count of items displayed on each default location.
	 * Prerequisite:Normal/MA User with OG items.
	 */

		
	/*
	@BeforeClass
	public void beforeC(){
		System.out.println("Before class method");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		String strData = "TestData.xls";		
		arrComplete=excel.read(strData, "FirstClass");
	}
	
	
	@DataProvider(name="DP1", parallel=true)
	public Object[][] dataReadLogic(Method method){
		System.out.println("DataProvider");
		System.out.println(method.getName());
		String[][] strArray = excel.getMethodData(arrComplete, method.getName());
		Object[][] retObjArr = firstClassObject.getTestData(strArray);
		return retObjArr;
	}
	
	@BeforeMethod
	public  void setUp() throws Exception{
		/*DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "9.0");
		capabilities.setCapability("deviceName", "Jasobanta’s iPad");
		capabilities.setCapability("app", "/Users/naveen_raj04/Desktop/UOM_Files/Builds/july 27/UOMQASQ-13.ipa");
		driver = new IOSDriver(new URL("http://10.155.162.74:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
		switchToWebContext();	
		startup();
	}*/
	@AfterMethod(alwaysRun=true)
	public  void tearDown() throws Exception{
		/*driver.close();
		driver.closeApp();*/
		//driver.quit();
		
	}
	int user;

	


/*
	@SuppressWarnings("static-access")
	@Test(groups={"SI - WF 3"},priority=1, description = "SI - WF 3-OG + Cus Loc + Cust Category")
	public void SI_WF3_OG_CustomMultipleLocation_CustomMultipleCategory() throws Exception {	

		user=2;

		loginPage.verifyLoginPage("SI - WF 3-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 3-save username");	
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 1-Login");	
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 3-FirstAccountSelect");
		inventoryToolPage.InvTools_SetUpInventory("SI - WF 3-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 3-Skip1 Tapped");
		setupInventoryPage.TapOrderGuide("SI - WF 3-OG Selected");
		setupInventoryPage.tapContinue("SI - WF 3-Tapped Continue1");
		locationsPage.CustomLocation("SI - WF 3-Tapped Custom location");
		locationsPage.tapContinue("SI - WF 3-Tapped Continue2");
		// Sprint two Integrate -----------
		locationsPage.VerifyOptionsOnCustomLocations("SI-WF3-Verified create custom LocationsPage");
		////
		locationsPage.EnterLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[2],"SI - WF 3-Enter location name");
		locationsPage.AddLocations1_TypeDry("SI - WF 3-Tapped Dry1");
		locationsPage.AddLocations2("SI - WF 3-Second location");
		locationsPage.AddLocations2_name(datapool.readFromExcelLocationInfo().locationNameDataPool[3],"");
		locationsPage.AddLocations2_TypeDry("SI - WF 3-Tapped Dry2");
		locationsPage.TapOnNext("SI - WF 3-Tapped Next1");
		locationsPage.selectMultipleItemsFromLocation1("SI - WF 3-Selected Multiple items");
		locationsPage.TapOnNext("SI - WF 3-Tapped Next2");
		locationsPage.selectMultipleItemsFromLocation2("SI - WF 3-Selected Multiple items");
		locationsPage.TapOnDone("SI - WF 3-Tapped Done1");
		categoryPage.CustomCategories("SI - WF 1-CustomCategories Tapped");
		categoryPage.tapContinue("SI - WF 3-Tapped Continue3");
		categoryPage.VerifyOptionsOnCreateExpenseCategory("SI-WF3-Verified create custom category Page");
		categoryPage.CreateTwoExpenseCategory(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], datapool.readFromExcelCategoryInfo().categoryNameDataPool[2], "SI - WF 3-CreateTwoExpenseCategory");
		categoryPage.TapOnNext("SI - WF 3-Tapped Next3");
		categoryPage.selectMultipleItemsFromCategory1("SI - WF 3-selectMultipleItemsFromCategory1");
		categoryPage.selectMultipleItemsFromCategory1("SI - WF 3-selectMultipleItemsFromCategory1");
		categoryPage.TapOnNext("SI - WF 3-Tapped Next4");
		categoryPage.selectMultipleItemsFromCategory2("SI - WF 3-selectMultipleItemsFromCategory2");
		setupInventoryPage.TapOnDone("SI - WF 3-Tapped Done2");
		setupInventoryPage.TapTakeHome("SI - WF 3-Tapped Continue4");
		inventoryToolPage.InvTools_TrackInventory("SI - WF 3-Selected track inventory");
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "SI - WF 3-LocationTap1");
		locationsPage.ItemVerifyOnLocation1("SI - WF 3-Verify item inside location1");
		locationsPage.TapOnBack("SI - WF 3-Tap on Back1");
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "SI - WF 3-LocationTap2");
		locationsPage.ItemVerifyOnLocation2("SI - WF 3-Verify item inside location2");
	}	
	*/
/*


	@Test(groups={"SI - WF 4"},priority=2, description = "SI - WF 4-OG + Default Loc + Custom Category ")
	public void SI_WF4_OG_DefaultLocation_CustomCategory() throws Exception {

		user=15;

		loginPage.verifyLoginPage("SI - WF 4-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 4-save username");	
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 4-Login");	
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 4-FirstAccountSelect");
		inventoryToolPage.InvTools_SetUpInventory("SI - WF 4-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 4-Skip1 Tapped");
		setupInventoryPage.TapOrderGuide("SI - WF 4-OG Selected");
		setupInventoryPage.tapContinue("SI - WF 4-Tapped Continue");
		locationsPage.DefaultLocation("SI - WF 4-Tapped Custom location");
		locationsPage.tapContinue("SI - WF 4-Tapped Continue");
		categoryPage.CustomCategories("SI - WF 4-CustomCategories Tapped");
		categoryPage.tapContinue("SI - WF 4-Tapped Continue3");
		categoryPage.CreateTwoExpenseCategory(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], datapool.readFromExcelCategoryInfo().categoryNameDataPool[2], "SI - WF 4-CreateTwoExpenseCategory");
		categoryPage.TapOnNext("SI - WF 4-Tapped Next3");
		categoryPage.selectMultipleItemsFromCategory1("SI - WF 4-selectMultipleItemsFromCategory1");
		categoryPage.TapOnNext("SI - WF 4-Tapped Next4");
		categoryPage.selectMultipleItemsFromCategory2("SI - WF 4-selectMultipleItemsFromCategory2");
		setupInventoryPage.TapOnDone("SI - WF 4-Tapped Done2");
		setupInventoryPage.TapTakeHome("SI - WF 4-Tapped Continue4") ;
		inventoryToolPage.InvTools_Locations("SI-WF4-Selected Locations");
		locationsPage.VerifyOrderOfLocations(datapool.readFromExcelLocationInfo().locationNameDataPool[6], datapool.readFromExcelUserInfo().locationNameDataPool[7], datapool.readFromExcelUserInfo().locationNameDataPool[8], datapool.readFromExcelUserInfo().locationNameDataPool[5], "SI-WF4-Verified order of locations");
		locationsPage.TapOnBack("SI-WF4-Tapped Back");
		
		inventoryToolPage.InvTools_TrackInventory("SI - WF 4-Selected track inventory");
		locationsPage.VerifyOrderOfLocations(datapool.readFromExcelLocationInfo().locationNameDataPool[6], datapool.readFromExcelUserInfo().locationNameDataPool[7], datapool.readFromExcelUserInfo().locationNameDataPool[8], datapool.readFromExcelUserInfo().locationNameDataPool[5], "SI - WF 4-Verified order of locations");
		
		//checking INV_248,249 scenario 5, INV_250,251 scenario 5---Sprint9
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[5], "SI-WF4-Selecting no location");
		locationsPage.NoItemsCheckInNoLocation("SI-WF4-Item verification in no location");
	
	}


	@Test(groups={"SI - WF 5"},priority=3, description = "SI - WF 5-OG + Custom Loc + Default Category")
	public void SI_WF5_OG_CustomLocation_DefaultCategory() throws Exception {



		user=14;

		loginPage.verifyLoginPage("SI - WF 5-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 5-save username");	
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 5-Login");	
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 5-FirstAccountSelect");
		inventoryToolPage.InvTools_SetUpInventory("SI - WF 5-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 5-Skip1 Tapped");
		setupInventoryPage.TapOrderGuide("SI - WF 5-OG Selected");
		setupInventoryPage.tapContinue("SI - WF 5-Tapped Continue1");
		locationsPage.CustomLocation("SI - WF 5-Tapped Custom location");
		locationsPage.tapContinue("SI - WF 5-Tapped Continue2");
		locationsPage.EnterLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[2],"SI - WF 5-Enter location name");
		locationsPage.AddLocations1_TypeDry("SI - WF 5-Tapped Dry1");
		locationsPage.AddLocations2("SI - WF 5-AddLocations2");
		locationsPage.AddLocations2_name(datapool.readFromExcelLocationInfo().locationNameDataPool[3],"AddLocations2_name");
		locationsPage.AddLocations2_TypeDry("SI - WF 5-Tapped Dry2");
		locationsPage.TapOnNext("SI - WF 5-Tapped Next1");
		locationsPage.selectMultipleItemsFromLocation1("SI - WF 5-Selected Multiple items");
		locationsPage.TapOnNext("SI - WF 5-Tapped Next2");
		locationsPage.selectMultipleItemsFromLocation2("SI - WF 3-Selected Multiple items");
		locationsPage.TapOnDone("SI - WF 5-Tapped Done1");
		categoryPage.defaultCategories("SI - WF 5-Tapped Default category");
		categoryPage.tapComplete("SI - WF 5-Tapped Complete");
		setupInventoryPage.TapTakeHome("SI - WF 5-Tapped Continue3");   
		inventoryToolPage.InvTools_TrackInventory("SI - WF 5-Selected track inventory");
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "SI - WF 5-LocationTap1");
		locationsPage.ItemVerifyOnLocation1("SI - WF 5-Verify item inside location1");
		locationsPage.TapOnBack("SI - WF 5-Tap on Back1");
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "SI - WF 5-LocationTap2");
		locationsPage.ItemVerifyOnLocation2("SI - WF 5-Verify item inside location2");
		locationsPage.TapOnBack("SI - WF 5-Tap on Back1");
		locationsPage.TapOnBack("SI - WF 5-Tap on Back1");
		//Validating View items link on locations
		inventoryToolPage.InvTools_Locations("SI - WF 5-Tapped Locations");
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "SI - WF 5-Selecting Location1");
		locationsPage.ViewItemsOnLocation("SI - WF 5-view items on Location1");
		locationsPage.ItemVerifyOnLocation1("SI - WF 5-Verify item inside location1");
		
		//sprint9
		
		locationsPage.TapOnBack("SI-WF5-Tap on Back1");
		locationsPage.TapOnBack("SI-WF5-Tap on Back1");
		locationsPage.TapOnBack("SI-WF5-Tap on Back1");
		
		inventoryToolPage.InvTools_TrackInventory("SI-WF5-Selected track inventory");

		//checking INV_248,249 scenario 1
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[5], "SI-WF5-Selecting no location");
		locationsPage.CustomLocItemsCheckInNoLocation("SI-WF5-Item verification in no location");
		locationsPage .NoLocationTextCheck(datapool.readFromExcelLocationInfo().locationNameDataPool[5],"SI-WF5-No location text verification");
        //.TapOnBack("SI-WF5-Tap on Back1")
        
      //checking INV_250,251 scenario 1
		//._atLocationsPage()
    //	.SelectLocation(locationsData3.LocationName, "SI-WF5-Selecting no location")
		locationsPage.NoLocationEdit("SI-WF5-No location verification");
		locationsPage.TapOnBack("SI-WF5-Tap on Back1");
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "SI-WF5-Selecting no location");
		locationsPage.LocationFirstItemCheck("SI-WF5-");
		locationsPage.TapOnBack("SI-WF5-Tap on Back1");
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "SI-WF5-Selecting no location");
		locationsPage.LocationFirstItemCheck("SI-WF5-Verifying no loc item in another location");
		locationsPage.TapOnBack("SI-WF5-Tap on Back1");

	}	

	@Test(groups={"SI - WF 6"},priority=4, description = "SI - WF 6-OG + Skip Loc + Skip Cust")
	public void SI_WF6_OG_SkipLocation_SkipCategory() throws Exception {	


		user=13;

		loginPage.verifyLoginPage("SI - WF 6-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 6-save username");	
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 6-Login");	
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 6-FirstAccountSelect");
		inventoryToolPage.InvTools_SetUpInventory("SI - WF 6-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 6-Skip1 Tapped");
		setupInventoryPage.TapOrderGuide("SI - WF 6-OG Selected");
		setupInventoryPage.tapContinue("SI - WF 6-Tapped Continue1");
		setupInventoryPage.TapOnDOThisLater("SI - WF 6-Do this Later for locations Tapped");
		setupInventoryPage.TapOnDOThisLater("Do this Later for category Tapped");
		setupInventoryPage.TapTakeHome("SI - WF 6-Cotinue2 Tapped"); 
		inventoryToolPage.InvTools_TrackInventory("SI - WF 6-Selected track inventory");
	}

	
	 * Validating user is able to setup inventory by adding items from OrderGuide and then assign those items to Default locations and skip category.
	 * Validating users cache is not cleared when logout after setting up inventory.  
	 * Validating Track Inventory displayed after setting up inventory.
	 * Validating location is created on Track Inventory and adding items to that location by product catalog addition.
	 * Prerequisite:Normal/MA User with OG items.
	 
	@Test(groups={"SI - WF 7"},priority=5, description = "SI - WF 7-OG+Default loc + Skip Category")
	public void SI_WF7_OG_DefaultLocation_SkipCategory() throws Exception {

		user=18;
		

		loginPage.verifyLoginPage("SI - WF 7-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 7-save username");	
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 7-Login");	
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 7-Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 7-FirstAccountSelect");
		inventoryToolPage.InvTools_SetUpInventory("SI - WF 7-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 7-Skip1 Tapped");
		setupInventoryPage.TapOrderGuide("SI - WF 7-OG Selected");
		setupInventoryPage.tapContinue("SI - WF 7-Tapped Continue");
		locationsPage.DefaultLocation("SI - WF 7-Tapped Custom location");
		locationsPage.tapContinue("SI - WF 7-Tapped Continue");
		setupInventoryPage.TapOnDOThisLater("SI - WF 7 Do this Later for category Tapped");
		setupInventoryPage.TapTakeHome("SI - WF 7-Cotinue2 Tapped"); 

		inventoryToolPage.InvTools_TrackInventory("SI - WF 7-Selected track inventory");
		locationsPage.TapOnBack("SI - WF 7-tapped on back");

		homePage.HamburgerMenu("SI - WF 7-tapped hamburger");
		homePage.HamMenu_Logout("SI - WF 7-tapped logout");
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 7-Login");	
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 7 Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 7-FirstAccountSelect");

		inventoryToolPage.InvTools_TrackInventory("SI - WF 7-Selected track inventory");

		//validating D-0338
		locationsPage.TapAddLocation("SI - WF 7-Tapped ADD");
		locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[2],"SI - WF 7-Enter location name");
		locationsPage.AddLocations1_TypeDry("SI - WF 7-Tapped Dry");
		locationsPage.TapOnDone("SI - WF 7-Tapped Done");
		locationsPage.TapOnBack("SI - WF 7-Tapped Back");
		locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "SI - WF 7-Verifing AddedLocation");
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "SI - WF 7-Selecting AddedLocation");
		locationsPage.TapAddLocation("MIL - WF 1 WF 4-Tapped ADD") ;
		setupInventoryPage.SearchItem(datapool.readFromExcelSearchInfo().searchNameDataPool[1],"SI - WF 7-Search item");
		setupInventoryPage.SelectItemFrom_Catalog("SI - WF 7-Selected item from OG");
		setupInventoryPage.TapOnDone("SI - WF 7-Done");
		setupInventoryPage.verifySearchItemsOnSetupInv("SI - WF 7-Verify item selected");
	
		;

	}
	
	
	
	 * Validating user is able to setup inventory by adding items from OrderGuide and then skip location and assigning to Default category.
	 * Prerequisite:Normal/MA User with OG items.
	 
	@Test(groups={"SI-WF8"},priority=6, description = "SI-WF8-OG + Skip Loc + Default Category")
	public void SI_WF8_OG_SkipLocation_DefaultCategory() throws Exception{

		user=15;
	
		loginPage.verifyLoginPage("SI-WF8-LoginPage");
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI-WF8-LoginPage");
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI-WF8-Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI-WF8-FirstAccountSelect");

		inventoryToolPage.InvTools_SetUpInventory("SI-WF8-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI-WF8-Skip1 Tapped");
		setupInventoryPage.TapOrderGuide("SI-WF8-OG Selected");
		setupInventoryPage.tapContinue("SI-WF8-Tapped Continue1");

		setupInventoryPage.TapOnDOThisLater("SI-WF8-Do this Later for locations Tapped");
		setupInventoryPage.TapOnSkip("SI-WF8-Skip3 Tapped") ;

		categoryPage.defaultCategories("SI-WF8-Tapped Default category");
		categoryPage.tapComplete("SI-WF8-Tapped Complete");

		setupInventoryPage.TapTakeHome("SI-WF8-Tapped TakeHome") ;  
		inventoryToolPage.InvTools_TrackInventory("SI-WF8-Selected track inventory")


		;
	}		
	
	 * Validating user is able to setup inventory by adding items from CustomList and then assign those items to Default  location and default category.
	 * Validating Default categories are listed on Expense categories page 
	 * Prerequisite:Normal/MA User with MyList.
	 
	@Test(groups={"SI-WF19"},priority=7, description = "SI-WF19-Custom List + default Loc + default Category ")
	public void SI_WF19_CustomList_defaultLoc_defaultcategory() throws Exception {	

		user=1;
	
		loginPage.verifyLoginPage("SI-WF19-LoginPage");
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI-WF19-LoginPage");
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI-WF19-Clicked account");
		accountsPage.Sixth_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI-WF19-FirstAccountSelect");

		inventoryToolPage.InvTools_SetUpInventory("SI-WF19-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI-WF19-Skip1 Tapped");

		
		listPage.TapCustomList("SI-WF19-custom list Selected");
		listPage.tapContinue("SI-WF19-Tapped Continue1");
		listPage.SelectListwithItems("List4", "SI-WF19-select list");
		listPage.TapOnNext("SI-WF19-tapped next");

		locationsPage.DefaultLocation("SI-WF19-Tapped Custom location");
		locationsPage.tapContinue("SI-WF19-Tapped Continue");

		categoryPage.defaultCategories("SI-WF19-Tapped Default category");
		categoryPage.tapComplete("SI-WF19-Tapped Complete");

		setupInventoryPage.TapTakeHome("SI-WF19-Tapped takeme home") ;  
		inventoryToolPage.InvTools_Category("SI-WF19-Tapped Categories");
		
		categoryPage.VerifyDefaultCategoryList("SI-WF19-Verified default Categories List");

		;

	}
	
	
	 * Validating user is able to setup inventory by adding items from CustomList and then assigning all items to multiple  locations and Custom category.
	 * Validating items are displayed on corresponding locations assigned
	 * Validating location and category displayed on item section on locations page is same as assigned ones.
	 * Validating delete location functionality and checking items are listed on No Location in Track Inventory
	 * Validating delete category functionality and checking no category is displayed for those items on No Location in Track Inventory
	 * Prerequisite:Normal/MA User with MyList with 6 items.
	 * 
	 
	@Test(groups={"SI-WF20"},priority=8, description = "SI-WF20-Custom List + Custom Loc + Custom Category ")
	public void SI_WF20_CustomList_CustomLoc_Customcategory() throws Exception {	

		user=2;
		
		
		loginPage.verifyLoginPage("SI-WF20-LoginPage");
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI-WF20-LoginPage");
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI-WF20-Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI-WF20-FirstAccountSelect");

		inventoryToolPage.InvTools_SetUpInventory("SI-WF20-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI-WF20-Skip2 Tapped");

		listPage.TapCustomList("SI-WF20-custom list Selected");
		listPage.tapContinue("SI-WF20-Tapped Continue1");
		listPage.SelectListwithItems("List4", "SI-WF20-select list");
		listPage.TapOnNext("SI-WF20-tapped next");


		locationsPage.CustomLocation("SI-WF20-Tapped Custom location");
		locationsPage.tapContinue("SI-WF20-Tapped Continue2");

		locationsPage.EnterLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[2],"SI-WF20-Enter location name1");
		locationsPage.AddLocations1_TypeDry("SI-WF20-Tapped Dry1");

		locationsPage.AddLocations2("SI-WF20-Tapped add another location");
		locationsPage.AddLocations2_name(datapool.readFromExcelLocationInfo().locationNameDataPool[3],"SI-WF20-Enter location name2");
		locationsPage.AddLocations2_TypeDry("SI-WF20-Tapped Dry2");
		locationsPage.TapOnNext("SI-WF20-Tapped Next1");

		locationsPage.selectMultipleItemsFromLocation1("SI-WF20-Selected Multiple items");
		locationsPage.TapOnNext("SI-WF20-Tapped Next2");

		locationsPage.selectMultipleItemsFromLocation2("SI-WF20-Selected Multiple items");
		locationsPage.TapOnDone("SI-WF20-Tapped Done1");

	

		categoryPage.CustomCategories("SI - WF 20-Custom Categories Tapped");
		categoryPage.tapContinue("SI - WF 20-Tapped Continue3");
		categoryPage.CreateTwoExpenseCategory(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], datapool.readFromExcelCategoryInfo().categoryNameDataPool[2], "SI - WF 20-CreateTwoExpenseCategory");
		categoryPage.TapOnNext("SI - WF 20-Tapped Next3");
		categoryPage.selectMultipleItemsFromCategory1("SI - WF 20-selectMultipleItemsFromCategory1");
		categoryPage.TapOnNext("SI - WF 20-Tapped Next4");
		categoryPage.selectMultipleItemsFromCategory2("SI - WF 20-selectMultipleItemsFromCategory2");
		
		setupInventoryPage.TapOnDone("SI - WF 20-Tapped Done2");
		setupInventoryPage.TapTakeHome("SI - WF 20-Tapped Continue3")  ; 
		inventoryToolPage.InvTools_TrackInventory("SI - WF 20-Selected track inventory");

		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "SI - WF 20-select added location");
		locationsPage.ItemVerifyOnLocation1("SI - WF 20-Item verification");
		locationsPage.SyscoCategoryIdentify("SI - WF 20-Category Identify on location1");
	
		categoryPage.VerifyCustomListItemsCustomCategoryLocation1(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1],"SI - WF 20-Category verification on location1");
		
		locationsPage.VerifyCustomListItemsCustomLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "SI - WF 20-Location1 verification");

		locationsPage.TapOnDone("SI - WF 1-Tapped Done");
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "SI - WF 20-select added location");
		locationsPage.ItemVerifyOnLocation2("SI - WF 20-Item verification");
		locationsPage.SyscoCategoryIdentify("SI - WF 20-Category Identify on location2");
		
		categoryPage.VerifyCustomListItemsCustomCategoryLocation2(datapool.readFromExcelCategoryInfo().categoryNameDataPool[2],"SI - WF 20-Category verification on location2");
		
		locationsPage.VerifyCustomListItemsCustomLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "SI - WF 20-Location2 verification");
		locationsPage.TapOnDone("SI - WF 20-Tapped Done")  ;

		//deleting location and checking items in no location
		locationsPage.TapOnBack("SI - WF 20-Tapped Back");
		
		inventoryToolPage.InvTools_Locations("SI - WF 20-Tapped Locations");
		
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "SI - WF 20-Selecting Location1");
		locationsPage.TapOnDeleteLocation("SI - WF 20-Tapped Delete");
		locationsPage.TapOnYesDelete("SI - WF 20-Deleting AddedLocation");
		locationsPage.VerifyCancelledLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "SI - WF 20-Verifing AddedLocation");
		locationsPage.TapOnBack("SI - WF 20-Tapped Back");
		
		inventoryToolPage.InvTools_Category("SI - WF 20-Tapped Category");
		
		categoryPage.SelectCategory(datapool.readFromExcelCategoryInfo().categoryNameDataPool[2], "SI - WF 20-Selecting Category");
		categoryPage.TapOnDeleteCategory("SI - WF 20-Deleting Category");
		categoryPage.TapOnYesDelete("SI - WF 20-Tap on Yes Delete");
		categoryPage.VerifyDeletedCategoryList(datapool.readFromExcelCategoryInfo().categoryNameDataPool[2], "SI - WF 20-Verifying Deleted category list");
		categoryPage.TapOnBack("SI - WF 20-Tapped Back");

		
		inventoryToolPage.InvTools_TrackInventory("SI - WF 20-Tapped Track Inventory");
		
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[5], "SI - WF 20-Selecting nolocation");
		locationsPage.ItemVerifyOnLocation1("SI - WF 20-Item verification in nolocation");
		locationsPage.TapOnBack("SI - WF 20-Tapped Back");
		locationsPage.VerifyCountOfItemsInLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[5], "MIL WF3 verify count");
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[5], "SI - WF 20-Selecting nolocation");
		locationsPage.VerifyDeletedItemsCategory(datapool.readFromExcelLocationInfo().locationNameDataPool[5],"SI - WF 20-Item category verification in nolocation");
		
		
		;
	}	
	
	
	 * Validating user is able to setup inventory by adding items from CustomList and then assign few items to multiple  locations and Custom category.
	 * Validating items are displayed on corresponding locations assigned
	 * Prerequisite:Normal/MA User with MyList with 6 items.
	 * 
	 
	@Test(groups={"SI - WF 21"},priority=9, description = "SI - WF 21-Custom List + Custom Loc + Custom Category + Few items")
	public void SI_WF21_CustomList_CustomLoc_Customcategory_FewItems() throws Exception {	

		user=4;
		loginPage.verifyLoginPage("SI - WF 21-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 21-Save Username");
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 21-LoginPage");
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 21-TC1 Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 21-FirstAccountSelect");

		inventoryToolPage.InvTools_SetUpInventory("SI - WF 21-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 21-Ready to start");

		listPage.TapCustomList("SI - WF 21-custom list Selected");
		listPage.tapContinue("SI - WF 21-Tapped Continue1");
		listPage.SelectListwithItems("List4", "SI - WF 21-select list");
		listPage.TapOnNext("SI - WF 21-tapped next");


		locationsPage.CustomLocation("SI - WF 21-Tapped Custom location");
		locationsPage.tapContinue("SI - WF 21-Tapped Continue2");

		locationsPage.EnterLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[2],"SI - WF 21-Enter location name");
		locationsPage.AddLocations1_TypeDry("SI - WF 21-Tapped Dry1");

		locationsPage.AddLocations2("SI - WF 21- tapped add another location");
		locationsPage.AddLocations2_name(datapool.readFromExcelLocationInfo().locationNameDataPool[3],"enter loc name 2");
		locationsPage.AddLocations2_TypeDry("SI - WF 21-Tapped Dry2");
		locationsPage.TapOnNext("SI - WF 21-Tapped Next1");

		locationsPage.selectMultipleItemsFromLocation1("SI - WF 21-Selected Multiple items");
		locationsPage.TapOnNext("SI - WF 21-Tapped Next2");
		locationsPage.selectMultipleItemsFromLocation2("SI - WF 21-Selected Multiple items");
		locationsPage.selectMultipleItemsFromLocation2("SI - WF 21-Selected Multiple items");
		locationsPage.TapOnDone("SI - WF 21-Tapped Done1");

		

		categoryPage.CustomCategories("SI - WF 21-Custom Categories Tapped");
		categoryPage.tapContinue("SI - WF 21-Tapped Continue3");
		categoryPage.CreateTwoExpenseCategory(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], datapool.readFromExcelCategoryInfo().categoryNameDataPool[2], "SI - WF 21-CreateTwoExpenseCategory");
		categoryPage.TapOnNext("SI - WF 21-Tapped Next3");
		categoryPage.selectMultipleItemsFromCategory1("SI - WF 21-selectMultipleItemsFromCategory1");
		categoryPage.TapOnNext("SI - WF 21-Tapped Next4");
	
		setupInventoryPage.TapOnDone("SI - WF 21-Tapped Done2");
		setupInventoryPage.TapTakeHome("SI - WF 21-Tapped Continue3");   
		inventoryToolPage.InvTools_TrackInventory("SI - WF 21-Selected track inventory");

		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "SI - WF 21-select added location");
		locationsPage.ItemVerifyOnLocation1("SI - WF 21-Item verification");
		//locationsPage.TapOnDone("SI - WF 1-Tapped Done");
		locationsPage.TapOnBack("SI - WF 20-Tapped Back");
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[5], "SI - WF 21-select added location");
		locationsPage.ItemVerifyOnLocation2("SI - WF 21-Item verification");
		    
		;
	}	

	
	 * Validating user is able to setup inventory by adding items from CustomList and then assign items to Default  locations and Custom category.
	 * Prerequisite:Normal/MA User with MyList with 6 items.
	 * 
	 

	@Test(groups={"SI - WF 22"},priority=10, description = "SI - WF 22-Custom List + Default Loc + custom Category")
	public void SI_WF22_CustomList_DefaultLoc_Customcategory() throws Exception {	

		user=2;
		
		loginPage.verifyLoginPage("SI - WF 22-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 22-Save Username");
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 22-LoginPage");

		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 22-TC1 Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 22-FirstAccountSelect");

		inventoryToolPage.InvTools_SetUpInventory("SI - WF 22-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 22-Skip1 Tapped");

		listPage.TapCustomList("SI - WF 22-custom list Selected");
		listPage.tapContinue("SI - WF 22-Tapped Continue1");
		//listPage.SelectListwithItems(datapool.readFromExcelListInfo().listNameDataPool[4],"SI - WF 23-select list");
		listPage.SelectListwithItems(datapool.readFromExcelList4Info().list4DataPool[0], "SI - WF 22-select list");
		listPage.TapOnNext("SI - WF 22-tapped next");

		locationsPage.DefaultLocation("SI - WF 22-Tapped Custom location");
		locationsPage.tapContinue("SI - WF 22-Tapped Continue");

		categoryPage.CustomCategories("SI - WF 22-Custom Categories Tapped");
		categoryPage.tapContinue("SI - WF 22-Tapped Continue3");
		categoryPage.CreateTwoExpenseCategory(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], datapool.readFromExcelCategoryInfo().categoryNameDataPool[2], "SI - WF 22-CreateTwoExpenseCategory");
		categoryPage.TapOnNext("SI - WF 22-Tapped Next3");
		categoryPage.selectMultipleItemsFromCategory1("SI - WF 22-selectMultipleItemsFromCategory1");
		categoryPage.TapOnNext("SI - WF 22-Tapped Next4");
		categoryPage.selectMultipleItemsFromCategory2("SI - WF 22-selectMultipleItemsFromCategory2");
	
		setupInventoryPage.TapOnDone("SI - WF 22-Tapped Done2");
		setupInventoryPage.TapTakeHome("SI - WF 22-Tapped Continue3") ;  

		inventoryToolPage.InvTools_TrackInventory("SI - WF 22-Selected track inventory");

		;

	}
	
	
	 * Validating user is able to setup inventory by adding items from CustomList and then assign items to multiple  locations and default category.
	 * Validating items are displayed on corresponding locations assigned
	 * Validating category displayed on item section on locations page is same as assigned ones.
	 * Prerequisite:Normal/MA User with MyList with 6 items.
	 * 
	 

	@Test(groups={"SI - WF 23"},priority=11, description = "SI - WF 23-Custom List + Custom Loc + default Category")
	public void SI_WF23_CustomList_CustomLoc_defaultcategory() throws Exception {	

	user=1;	
		loginPage.verifyLoginPage("SI - WF 23-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 23-Save Username");
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 23-LoginPage");
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 23-TC1 Clicked account");
		accountsPage.Fifth_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 23-FirstAccountSelect");

		inventoryToolPage.InvTools_SetUpInventory("SI - WF 23-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 23-Skip2 Tapped");

		listPage.TapCustomList("SI - WF 23-custom list Selected");
		listPage.tapContinue("SI - WF 23-Tapped Continue1");
		listPage.SelectListwithItems("List4", "SI - WF 23-select list");
		listPage.TapOnNext("SI - WF 23-tapped next");

		locationsPage.CustomLocation("SI - WF 23-Tapped Custom location");
		locationsPage	.tapContinue("SI - WF 23-Tapped Continue2");

		locationsPage.EnterLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[2],"SI - WF 23-Enter location name");
		locationsPage.AddLocations1_TypeDry("SI - WF 23-Tapped Dry1");

		locationsPage.AddLocations2("");
		locationsPage.AddLocations2_name(datapool.readFromExcelLocationInfo().locationNameDataPool[3],"");
		locationsPage.AddLocations2_TypeDry("SI - WF 23-Tapped Dry2");
		locationsPage.TapOnNext("SI - WF 23-Tapped Next1");

		locationsPage.selectMultipleItemsFromLocation1("SI - WF 23-Selected Multiple items");
		locationsPage.TapOnNext("SI - WF 23-Tapped Next2");

		locationsPage.selectMultipleItemsFromLocation2("SI - WF 23-Selected Multiple items");
		locationsPage.TapOnDone("SI - WF 23-Tapped Done1");

		categoryPage.defaultCategories("SI - WF 23-Tapped Default category");
		categoryPage.tapComplete("SI - WF 23-Tapped Complete");

		setupInventoryPage.TapTakeHome("SI - WF 23-Tapped Continue3") ;  
		inventoryToolPage.InvTools_TrackInventory("SI - WF 23-Selected track inventory");

		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "SI - WF 23-select added location");
		locationsPage.ItemVerifyOnLocation1("SI - WF 23-Item verification in location1");
		locationsPage.SyscoCategoryIdentify("SI - WF 23-Category Identification in location1");
		
		categoryPage.VerifyCustomListItemsDefaultCategoryLocation1("SI- WF 23-Verifying default categories in location1");
		categoryPage.TapOnDone("SI - WF 1-Tapped Done");
	
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "SI - WF 23-select added location");
		locationsPage.ItemVerifyOnLocation2("SI - WF 23-Item verification in location2");
		locationsPage.SyscoCategoryIdentify("SI - WF 23-Category Identification in location1");
		categoryPage.VerifyCustomListItemsDefaultCategoryLocation2("SI- WF 23-Verifying default categories in location2");
		categoryPage.TapOnDone("SI - WF 23-Tapped Done");      
		
		//checking INV_248,249 scenario 3--Sprint9
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[5], "SI-WF23-Selecting no location");
		locationsPage.CustomLocItemsCheckInNoLocation("SI-WF23-Item verification in no location");
		locationsPage.NoLocationTextCheck(datapool.readFromExcelLocationInfo().locationNameDataPool[5],"SI-WF23-No location text verification");
		//.TapOnBack("SI-WF23-Tap on Back1")
		        
	    //checking INV_250,251 scenario 3--Sprint9
		//._atLocationsPage()
	//	.SelectLocation(locationsData3.LocationName, "SI-WF23-Selecting no location")
		locationsPage.NoLocationEdit("SI-WF23-No location verification");
		locationsPage.TapOnBack("SI-WF23-Tap on Back");
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "SI-WF23-Selecting no location");
		locationsPage.LocationFirstItemCheck("SI-WF23-");
		locationsPage.TapOnBack("SI-WF23-Tap on Back");
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "SI-WF23-Selecting no location");
		locationsPage.LocationFirstItemCheck("SI-WF23-Verifying no loc item in another location");
		locationsPage.TapOnBack("SI-WF23-Tap on Back1");

	}
	
	
	 * Validating user is able to setup inventory by adding items from CustomList and then assign items by skipping locations and category.
	 * Prerequisite:Normal/MA User with MyList with 6 items.
	 * 
	 

	@Test(groups={"SI - WF 24"},priority=12, description = "SI - WF 24-Custom List + Skip location+ Skip Category")
	public void SI_WF24_CustomList_SkipLoc_Skipcategory() throws Exception {	

		user=2;

		loginPage.verifyLoginPage("SI - WF 24-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 24-Save Username");
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 24-LoginPage");
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 24-TC1 Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 24-FirstAccountSelect");

		inventoryToolPage.InvTools_SetUpInventory("SI - WF 24-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 24-Skip1 Tapped");

		listPage.TapCustomList("SI - WF 24-custom list Selected");
		listPage.tapContinue("SI - WF 24-Tapped Continue1");
		listPage.SelectListwithItems("List4", "SI - WF 24-select list");
		listPage.TapOnNext("SI - WF 24-tapped next");

		setupInventoryPage.TapOnDOThisLater("SI - WF 224-STapOnDOThisLater Tapped");
		setupInventoryPage.TapOnSkip("SI - WF 24-Skip3 Tapped") ;
		setupInventoryPage.TapOnDOThisLater("SI - WF 24 TapOnDOThisLater Tapped");
		setupInventoryPage.tapContinue("SI - WF 24-Tapped Continue3")  ; 

		inventoryToolPage.InvTools_TrackInventory("SI - WF 24-Selected track inventory");

		locationsPage.SelectLocation("List4", "SI - WF 24-select added location");
		//locationsPage.ItemVerifyOnLocation(datapool.readFromExcelUserInfo().locationNameDataPool[5], "SI - WF 1-Verify item inside location");
		locationsPage.TapOnDone("SI - WF 24-Tapped Done");
		

	}
	
	
	
	 * Validating user is able to setup inventory by adding items from CustomList and then assign items to Default  locations and skip category.
	 * Prerequisite:Normal/MA User with MyList with 6 items.
	 * 
	 

	@Test(groups={"SI - WF 25"},priority=13, description = "SI - WF 25-Custom List+Default loc + Skip Category")
	public void SI_WF25_CustomList_DefaultLoc_Skipcategory() throws Exception {	

		user=1;
		
		loginPage.verifyLoginPage("SI - WF 25-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 25-Save Username");
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 25-LoginPage");
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 25-TC1 Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 25-FirstAccountSelect");

		inventoryToolPage.InvTools_SetUpInventory("SI - WF 25-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 25-Skip1 Tapped");

		listPage.TapCustomList("SI - WF 25-custom list Selected");
		listPage.tapContinue("SI - WF 25-Tapped Continue1");
		listPage.SelectListwithItems("List4", "SI - WF 25-select list");
		listPage.TapOnNext("SI - WF 25-tapped next");

		locationsPage.DefaultLocation("SI - WF 25-Tapped Custom location");
		locationsPage.tapContinue("SI - WF 25-Tapped Continue");

		setupInventoryPage.TapOnDOThisLater("SI - WF 25-STapOnDOThisLater Tapped");
		setupInventoryPage.TapTakeHome("SI - WF 25-Tapped Continue3")   ;
		inventoryToolPage.InvTools_TrackInventory("SI - WF 25-Selected track inventory");


	}
	
	
	 * Validating user is able to setup inventory by adding items from CustomList and then assign items by skipping locations and default category.
	 * Prerequisite:Normal/MA User with MyList with 6 items.
	 * 
	 
	@Test(groups={"SI - WF 26"},priority=14, description = "SI - WF 26-Custom List+skip location + default category for Normal user")
	public void SI_WF26_CustomList_SkipLoc_defaultcategory_NU() throws Exception {	

		user=2;		
		loginPage.verifyLoginPage("SI - WF 26-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 26-Save Username");
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 26-LoginPage");
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 26-TC1 Clicked account");
		accountsPage.Fifth_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 26-FirstAccountSelect");

		inventoryToolPage.InvTools_SetUpInventory("SI - WF 26-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 26-Skip1 Tapped");

		listPage.TapCustomList("SI - WF 26-custom list Selected");
		listPage.tapContinue("SI - WF 26-Tapped Continue1");
		listPage.SelectListwithItems("List4", "SI - WF 26-select list");
		listPage.TapOnNext("SI - WF 26-tapped next");

		setupInventoryPage.TapOnDOThisLater("SI - WF 26-TapOnDOThisLater Tapped");
		setupInventoryPage.TapOnSkip("SI - WF 26-Skip1 Tapped");

		categoryPage.defaultCategories("SI - WF 26-Tapped Custom category");
		categoryPage.tapComplete("SI - WF 26-Tapped Complete");
		categoryPage.tapContinue("SI - WF 26-Tapped Continue");

		inventoryToolPage.InvTools_TrackInventory("SI - WF 26-Selected track inventory");

		locationsPage.SelectLocation(datapool.readFromExcelUserInfo().locationNameDataPool[5], "SI - WF 26-select added location");
		//locationsPage.ItemVerifyOnLocation(datapool.readFromExcelUserInfo().locationNameDataPool[5], "SI - WF 1-Verify item inside location");
		locationsPage.TapOnDone("SI - WF 26-Tapped Done");
		

	}

	
	
	 * Validating user is able to setup inventory by adding items from CustomList(Multiple list) and then assign items to Default category.
	 * Validating items are displayed on corresponding locations assigned
	 * Prerequisite:Normal/MA User with MyList having 2 items each for List2,List3
	 * 
	 
	@Test(groups={"SI - WF 27"},priority=15, description = "SI - WF 27-Custom List + Select Multiple List +List Names+Default Cat")
	public void SI_WF27_CustomList_MultipleList_ListNames_DefaultCat() throws Exception {	


		user=1;
		
		loginPage.verifyLoginPage("SI - WF 27-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 27-Save Username");
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 27-LoginPage");
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 27-TC1 Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 27-FirstAccountSelect");

		inventoryToolPage.InvTools_SetUpInventory("SI - WF 27-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 27-Skip1 Tapped");

		listPage.TapCustomList("SI - WF 27-custom list Selected");
		listPage.tapContinue("SI - WF 27-Tapped Continue1");
		listPage.SelectListwithItems(datapool.readFromExcelUserInfo().listNameDataPool[2], "SI - WF 27-select list");
		listPage.SelectListwithItems(datapool.readFromExcelUserInfo().listNameDataPool[3], "SI - WF 27-select list");
		listPage.SelectListwithItems("List2", "SI - WF 27-select list");
		listPage.SelectListwithItems("List3", "SI - WF 27-select list");
		listPage.TapOnNext("SI - WF 27-tapped next");

		locationsPage.ListNames("SI - WF 27-Tapped Custom location");
		locationsPage.tapContinue("SI - WF 27-Tapped Continue");

		categoryPage.defaultCategories("SI - WF 27-Tapped Default category");
		categoryPage.tapComplete("SI - WF 27-Tapped Complete");

		setupInventoryPage.TapTakeHome("SI - WF 27-Tapped take me home")      ;
		inventoryToolPage.InvTools_TrackInventory("SI - WF 27-Selected track inventory");
		locationsPage.SelectLocation(datapool.readFromExcelUserInfo().listNameDataPool[2], "SI - WF 27-select added location");
		locationsPage.VerifyListItemsOnLocation(datapool.readFromExcelUserInfo().listProduct1DataPool[2],datapool.readFromExcelUserInfo().listProduct2DataPool[2],"SI - WF 27-Item verification");
		locationsPage.SelectLocation("List2", "SI - WF 27-select added location");
		locationsPage.VerifyListItemsOnLocation("1358522","208845","SI - WF 27-Item verification");
		
		locationsPage.TapOnDone("SI - WF 1-Tapped Done");
		locationsPage.SelectLocation(datapool.readFromExcelUserInfo().listNameDataPool[3], "SI - WF 27-select added location");
		locationsPage.VerifyListItemsOnLocation(datapool.readFromExcelUserInfo().listProduct1DataPool[3],datapool.readFromExcelUserInfo().listProduct2DataPool[3],"SI - WF 27-Item verification");
		locationsPage.SelectLocation("List3", "SI - WF 27-select added location");
		locationsPage.VerifyListItemsOnLocation("1141142","1145283","SI - WF 27-Item verification");
		
		locationsPage.TapOnDone("SI - WF 27-Tapped Done") ;     
		
	}
	
	
	 * Validating user is able to setup inventory by adding items from CustomList(Multiple list) and then assign items to custom category.
	 * Validating items are displayed on corresponding locations assigned
	 * Prerequisite:Normal/MA User with MyList having 2 items each for List2,List3
	 * 
	 
	@Test(groups={"SI - WF 28"},priority=16, description = "SI - WF 28-Custom List + Select Multiple List +List Names as location+custom Cat")
	public void SI_WF28_1_CustomList_MultipleList_ListNames_Customcategory() throws Exception {	

		user=2;
		loginPage.verifyLoginPage("SI - WF 28-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 28-Save Username");
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 28-LoginPage");
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 28-TC1 Clicked account");
		accountsPage.Fifth_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 28-FirstAccountSelect");

		inventoryToolPage.InvTools_SetUpInventory("SI - WF 28-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 28-Skip1 Tapped");
		
		listPage.TapCustomList("SI - WF 28-custom list Selected");
		listPage.tapContinue("SI - WF 28-Tapped Continue1");
		listPage.SelectListwithItems(datapool.readFromExcelUserInfo().listNameDataPool[2], "SI - WF 28-select list");
		listPage.SelectListwithItems(datapool.readFromExcelUserInfo().listNameDataPool[3], "SI - WF 28-select list");
		listPage.SelectListwithItems("List2", "SI - WF 27-select list");
		listPage.SelectListwithItems("List3", "SI - WF 27-select list");
		listPage.TapOnNext("SI - WF 28-tapped next");

		locationsPage.ListNames("SI - WF 28-Tapped List Names");
		locationsPage.tapContinue("SI - WF 28-Tapped Continue");

		categoryPage.CustomCategories("SI - WF 28-Custom Categories Tapped");
		categoryPage.tapContinue("SI - WF 28-Tapped Continue3");
		categoryPage.CreateTwoExpenseCategory(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], datapool.readFromExcelCategoryInfo().categoryNameDataPool[2], "SI - WF 28-CreateTwoExpenseCategory");
		categoryPage.TapOnNext("SI - WF 28-Tapped Next3");
		categoryPage.selectMultipleItemsFromCategory1("SI - WF 28-selectMultipleItemsFromCategory1");
		categoryPage.TapOnNext("SI - WF 28-Tapped Next4");
		
		setupInventoryPage.TapOnDone("SI - WF 28-Tapped Done2");
		setupInventoryPage.TapTakeHome("SI - WF 28-Tapped take me home")  ;    

		inventoryToolPage.InvTools_TrackInventory("SI - WF 28-Selected track inventory");
		
		locationsPage.SelectLocation(datapool.readFromExcelUserInfo().listNameDataPool[2], "SI - WF 28-select added location");
		locationsPage.VerifyListItemsOnLocation(datapool.readFromExcelUserInfo().listProduct1DataPool[2],datapool.readFromExcelUserInfo().listProduct2DataPool[2],"SI - WF 28-Item verification");
		locationsPage.SelectLocation("List2", "SI - WF 27-select added location");
		locationsPage.VerifyListItemsOnLocation("1358522","208845","SI - WF 27-Item verification");
		//locationsPage.TapOnDone("SI - WF 28-Tapped Done");
		locationsPage.TapOnBack("SI - WF 28-Tapped Back");
		
		locationsPage.SelectLocation(datapool.readFromExcelUserInfo().listNameDataPool[3], "SI - WF 28-select added location");
		locationsPage.VerifyListItemsOnLocation(datapool.readFromExcelUserInfo().listProduct1DataPool[3],datapool.readFromExcelUserInfo().listProduct2DataPool[3],"SI - WF 28-Item verification");
		locationsPage.SelectLocation("List3", "SI - WF 27-select added location");
		locationsPage.VerifyListItemsOnLocation("1141142","1145283","SI - WF 27-Item verification");
		
		//locationsPage.TapOnDone("SI - WF 28-Tapped Done");      
		

	}	
	@Test(groups={"SI - WF 28"},priority=16, description = "SI - WF 28-Custom List + Select Multiple List +List Names as location+custom Cat")
	public void SI_WF28_CustomList_MultipleList_ListNames_Customcategory() throws Exception {	

		user=2;
		loginPage.verifyLoginPage("SI - WF 28-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 28-Save Username");
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 28-LoginPage");
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 28-TC1 Clicked account");
		accountsPage.Fifth_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 28-FirstAccountSelect");

		inventoryToolPage.InvTools_SetUpInventory("SI - WF 28-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 28-Skip1 Tapped");

		listPage.TapCustomList("SI - WF 28-custom list Selected");
		listPage.tapContinue("SI - WF 28-Tapped Continue1");
		listPage.SelectListwithItems(datapool.readFromExcelList2Info().list2DataPool[0], "SI - WF 27-select list");
		listPage.SelectListwithItems(datapool.readFromExcelList3Info().list3DataPool[0], "SI - WF 27-select list");
		listPage.TapOnNext("SI - WF 28-tapped next");

		locationsPage.ListNames("SI - WF 28-Tapped List Names");
		locationsPage.tapContinue("SI - WF 28-Tapped Continue");

		categoryPage.CustomCategories("SI - WF 28-Custom Categories Tapped");
		categoryPage.tapContinue("SI - WF 28-Tapped Continue3");
		categoryPage.CreateTwoExpenseCategory(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], datapool.readFromExcelCategoryInfo().categoryNameDataPool[2], "SI - WF 28-CreateTwoExpenseCategory");
		categoryPage.TapOnNext("SI - WF 28-Tapped Next3");
		categoryPage.selectMultipleItemsFromCategory1("SI - WF 28-selectMultipleItemsFromCategory1");
		categoryPage.TapOnNext("SI - WF 28-Tapped Next4");

		setupInventoryPage.TapOnDone("SI - WF 28-Tapped Done2");
		setupInventoryPage	.TapTakeHome("SI - WF 28-Tapped take me home")  ;    

		    

		  inventoryToolPage.InvTools_TrackInventory("SI - WF 27-Selected track inventory");
			 locationsPage.SelectLocation(datapool.readFromExcelList2Info().list2DataPool[0], "SI - WF 27-select added location");
			locationsPage.VerifyListItemsOnLocation(datapool.readFromExcelList2Info().list2DataPool[1],datapool.readFromExcelList2Info().list2DataPool[2],"SI - WF 27-Item verification");
			  

			  locationsPage.TapOnBack("SI - WF 1-Tapped Done");
			  locationsPage.SelectLocation(datapool.readFromExcelList3Info().list3DataPool[0], "SI - WF 27-select added location");
				locationsPage.VerifyListItemsOnLocation(datapool.readFromExcelList3Info().list3DataPool[1],datapool.readFromExcelList3Info().list3DataPool[2],"SI - WF 27-Item verification");
			

	}	

	
	 * Validating user is able to setup inventory by adding items from CustomList(single list) and then assign items to custom category as location and Default Cat .
	 * Prerequisite:Normal/MA User with MyList having 6 items and items should be categorized
	 * 
	 
	@Test(groups={"SI - WF 29"},priority=17, description = "SI - WF 29-Custom List + Select single  List +Custom categories as location+Default Cat")
	public void SI_WF29_CustomListSingleList_CustomCategoryOnLocationsPage_defaultcategory() throws Exception {	

		user=1;
	
		loginPage.verifyLoginPage("SI - WF 29-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 29-Save Username");
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 29-LoginPage");
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 29-TC1 Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 29-FirstAccountSelect");

		inventoryToolPage.InvTools_SetUpInventory("SI - WF 29-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 29-Skip1 Tapped");

		listPage.TapCustomList("SI - WF 29-custom list Selected");
		listPage.tapContinue("SI - WF 29-Tapped Continue1");
		//listPage.SelectListwithItems(datapool.readFromExcelUserInfo().listNameDataPool[1], "SI - WF 29-select list");
		listPage.SelectListwithItems("List4", "SI - WF 29-select list");
		listPage.TapOnNext("SI - WF 29-tapped next");

		locationsPage.CustomCategories("SI - WF 29-Tapped Default category in Location Page");
		locationsPage.tapContinue("SI - WF 29-Tapped Continue2");

		categoryPage.defaultCategories("SI - WF 29-Tapped Default category");
		categoryPage.tapComplete("SI - WF 29-Tapped Complete");
		
		setupInventoryPage.TapTakeHome("SI - WF 29-Tapped Continue3")   ;
		inventoryToolPage.InvTools_TrackInventory("SI - WF 29-Selected track inventory");
		
		//checking INV_248,249 scenario 5 INV_250,251 scenario 5--Sprint9
			
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[5], "SI-WF29-Selecting no location");
		locationsPage.NoItemsCheckInNoLocation("SI-WF29-Item verification in no location");


	}
	
	
	/*
	 * Validating user is able to setup inventory by adding items from CustomList(single list) and then assign items to custom category as location and Custom Cat 
	 * Prerequisite:Normal/MA User with MyList having 6 items and items should be categorized
	 * 
	 


	@Test(groups={"SI - WF 30"},priority=18, description = "SI - WF 30-Custom List + Select single  List +Custom Categories as location+Custom Cat")
	public void SI_WF30_CustomListSingleList_CustomCategoryOnLocationsPage_customcategory() throws Exception {	

		user=1;
		
		loginPage.verifyLoginPage("SI - WF 30-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 30-Save Username");
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 30-LoginPage");
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 30-TC1 Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 30-FirstAccountSelect");

		inventoryToolPage.InvTools_SetUpInventory("SI - WF 30-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 30-Skip1 Tapped");

		listPage.TapCustomList("SI - WF 30-custom list Selected");
		listPage.tapContinue("SI - WF 30-Tapped Continue1");
		//listPage.SelectListwithItems(datapool.readFromExcelUserInfo().listNameDataPool[4], "SI - WF 29-select list");
		listPage.SelectListwithItems("List5", "SI - WF 29-select list");
		
		listPage.TapOnNext("SI - WF 30-tapped next");

		locationsPage.CustomCategories("SI - WF 30-Tapped Default category in Location Page");
		locationsPage.tapContinue("SI - WF 30-Tapped Continue2");

		categoryPage.CustomCategories("SI - WF 30-Custom Categories Tapped");
		categoryPage.tapContinue("SI - WF 30-Tapped Continue3");
		categoryPage.CreateTwoExpenseCategory(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], datapool.readFromExcelCategoryInfo().categoryNameDataPool[2], "SI - WF 20-CreateTwoExpenseCategory");
		categoryPage.TapOnNext("SI - WF 30-Tapped Next3");
		categoryPage.selectMultipleItemsFromCategory1("SI - WF 30-selectMultipleItemsFromCategory1");
		categoryPage.TapOnNext("SI - WF 30-Tapped Next4");
		categoryPage.selectMultipleItemsFromCategory2("SI - WF 20-selectMultipleItemsFromCategory2");
		
		setupInventoryPage.TapOnDone("SI - WF 30-Tapped Done2");
		setupInventoryPage.TapTakeHome("SI - WF 30-Tapped Continue3")  ; 

		inventoryToolPage.InvTools_TrackInventory("SI - WF 30-Selected track inventory");
		
		//checking INV_248,249 scenario 4--Sprint9
	
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[5], "SI-WF30-Selecting no location");
		//locationsPage.UncategorizedItemsCheckInNoLocation(datapool.readFromExcelListInfo().listUnCatProduct1DataPool[4],datapool.readFromExcelListInfo().listUnCatProduct2DataPool[4],datapool.readFromExcelUserInfo().listUnCatProduct2DataPool[4],"SI-WF30-Item verification in no location");
		locationsPage.UncategorizedItemsCheckInNoLocation("108807","228650","1358522","SI-WF30-Item verification in no location");
		
		locationsPage.NoLocationTextCheck(datapool.readFromExcelLocationInfo().locationNameDataPool[5],"SI-WF30-No location text verification");
			//	.TapOnBack("SI-WF23-Tap on Back")
						        
				 //checking INV_250,251 scenario 4
			//	._atLocationsPage()
			//	.SelectLocation(locationsData3.LocationName, "SI-WF23-Selecting no location")
		locationsPage.NoLocationEdit("SI-WF30-No location verification");
		locationsPage.TapOnBack("SI-WF30-Tap on Back");
		//locationsPage.SelectLocation(datapool.readFromExcelListInfo().listCategoryDataPool[4], "SI-WF23-Selecting no location"); 
		locationsPage.SelectLocation("Category1", "SI-WF23-Selecting no location"); 
		locationsPage.LocationFirstItemCheck("SI-WF30-Verifying no loc item in another location");
		locationsPage.TapOnBack("SI-WF30-Tap on Back");

	}
	
	
	 * Validating user is able to setup inventory by adding items from CustomList(Multiple list) and then skipping Category 
	 * Validating items are displayed on corresponding locations assigned
	 * Prerequisite:Normal/MA User with MyList having 2 items each for List2,List3
	 * 
	 
	@Test(groups={"SI - WF 31"},priority=19, description = "SI - WF 31-Custom List + Select Multiple List +List Names as location+skip Cat")
	public void SI_WF31_CustomList_MultipleList_ListNames_Skipcategory() throws Exception {	

		user=1;
	
		loginPage.verifyLoginPage("SI - WF 31-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 31-Save Username");
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 31-LoginPage");
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 31-TC1 Clicked account");
		accountsPage.Fifth_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 31-FirstAccountSelect");

		inventoryToolPage.InvTools_SetUpInventory("SI - WF 31-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 31-Skip1 Tapped");

		listPage.TapCustomList("SI - WF 31-custom list Selected");
		listPage.tapContinue("SI - WF 31-Tapped Continue1");
		listPage.SelectListwithItems(datapool.readFromExcelUserInfo().listNameDataPool[2], "SI - WF 31-select list");
		listPage.SelectListwithItems(datapool.readFromExcelUserInfo().listNameDataPool[3], "SI - WF 31-select list");
		listPage.SelectListwithItems("List2", "SI - WF 27-select list");
		listPage.SelectListwithItems("List3", "SI - WF 27-select list");
		listPage.TapOnNext("SI - WF 31-tapped next");

		locationsPage.ListNames("SI - WF 31-Tapped List Names");
		locationsPage.tapContinue("SI - WF 31-Tapped Continue");

		setupInventoryPage.TapOnDOThisLater("SI - WF 31-STapOnDOThisLater Tapped"); 
		setupInventoryPage.TapTakeHome("SI - WF 31-Tapped take me home");      

		inventoryToolPage.InvTools_TrackInventory("SI - WF 31-Selected track inventory");
		
		locationsPage.SelectLocation(datapool.readFromExcelUserInfo().listNameDataPool[2], "SI - WF 31-select added location");
		locationsPage.VerifyListItemsOnLocation(datapool.readFromExcelUserInfo().listProduct1DataPool[2],datapool.readFromExcelUserInfo().listProduct2DataPool[2],"SI - WF 31-Item verification");
		locationsPage.SelectLocation("List2", "SI - WF 27-select added location");
		locationsPage.VerifyListItemsOnLocation("1358522","208845","SI - WF 27-Item verification");
		
		locationsPage.TapOnDone("SI - WF 31-Tapped Done");
		locationsPage.SelectLocation(datapool.readFromExcelUserInfo().listNameDataPool[3], "SI - WF 31-select added location");
		locationsPage.VerifyListItemsOnLocation(datapool.readFromExcelUserInfo().listProduct1DataPool[3],datapool.readFromExcelUserInfo().listProduct2DataPool[3],"SI - WF 31-Item verification");
		
		locationsPage.SelectLocation("List3", "SI - WF 27-select added location");
		locationsPage.VerifyListItemsOnLocation("1141142","1145283","SI - WF 27-Item verification");
		
		locationsPage.TapOnDone("SI - WF 31-Tapped Done");      
	
	}
	
	
	 * Validating user is able to setup inventory by adding items from CustomList(single list) and then assign items to custom category as location and then skipping Category 
	 * Prerequisite:Normal/MA User with MyList having 6 items 
	 * 
	 
	@Test(groups={"SI - WF 32"},priority=20, description = "SI - WF 32-Custom List + Select single  List +Custom categories as location+Skip Cat")
	public void SI_WF32_CustomList_SingleList_CustomCatLoc_Skipcategory() throws Exception {	

		user=1;
	
		loginPage.verifyLoginPage("SI - WF 32-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 32-Save Username");
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 32-LoginPage");
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 32-TC1 Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 32-FirstAccountSelect");

		inventoryToolPage.InvTools_SetUpInventory("SI - WF 32-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 32-Skip1 Tapped");

		listPage.TapCustomList("SI - WF 32-custom list Selected");
		listPage.tapContinue("SI - WF 32-Tapped Continue1");
		//listPage.SelectListwithItems(datapool.readFromExcelUserInfo().listNameDataPool[1], "SI - WF 32-select list");
		listPage.SelectListwithItems("List4", "SI - WF 32-select list");
		listPage.TapOnNext("SI - WF 32-tapped next");

		locationsPage.CustomCategories("SI - WF 32-Tapped Custom location");
		locationsPage.tapContinue("SI - WF 32-Tapped Continue");

		setupInventoryPage.TapOnDOThisLater("SI - WF 32-STapOnDOThisLater Tapped");
		setupInventoryPage.TapTakeHome("SI - WF 32-Tapped take me home");      
		inventoryToolPage.InvTools_TrackInventory("SI - WF 32-Selected track inventory");


	}

	
	
	
	
	 * Validating user is able to setup inventory by adding items from OrderGuide and then assign those items to Default locations and Suggested category.
	 * Prerequisite:Normal/MA User with OG items.
	 

	@Test(groups={"SI - WF 33"},priority=21, description = "SI - WF 33-OG + Default Loc + Suggested Category")
	public void SI_WF33_OG_DefaultLocation_SuggestedCategory() throws Exception {	


		user=12;

		loginPage.verifyLoginPage("SI - WF 33-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 33-save username");	
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 33-Login");	
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 33-Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 33-FirstAccountSelect");
		inventoryToolPage.InvTools_SetUpInventory("SI - WF 33-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 33-Skip1 Tapped");
		setupInventoryPage.TapOrderGuide("SI - WF 33-OG Selected");
		setupInventoryPage.tapContinue("SI - WF 33-Tapped Continue");
		locationsPage.DefaultLocation("SI - WF 33-Tapped Custom location");
		locationsPage.tapContinue("SI - WF 33-Tapped Continue");

		categoryPage.SuggestedCategories("SI - WF 33-SuggestedCategories Tapped");
		categoryPage.tapContinue("SI - WF 33-Tapped Continue3");
		setupInventoryPage.TapTakeHome("SI - WF 33-Tapped Take me Home");
		inventoryToolPage.InvTools_TrackInventory("SI- WF 33-Selected track inventory");
		locationsPage.VerifyOrderOfLocations(datapool.readFromExcelLocationInfo().locationNameDataPool[6], datapool.readFromExcelLocationInfo().locationNameDataPool[7], datapool.readFromExcelLocationInfo().locationNameDataPool[8],datapool.readFromExcelLocationInfo().locationNameDataPool[5], "SI - WF 33-Verified order of locations");


		;



	}
	
	 * Validating user is able to setup inventory by adding items from OrderGuide and then assign those items to Custom locations and Suggested category.
	 * Validating items are displayed on corresponding locations assigned
	 * Validating suggested categories are displayed for each item on Track Inv
	 * Prerequisite:Normal/MA User with OG items.
	 

	@Test(groups={"SI - WF 34"},priority=22, description = "SI - WF 34-OG + Custom Loc + Suggested Category")
	public void SI_WF34_OG_CustomLocation_SuggestedCategory() throws Exception {	

		user=14;

		loginPage.verifyLoginPage("SI - WF 34-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 34-save username");	
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 34-Login");	
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 34-FirstAccountSelect");
		inventoryToolPage.InvTools_SetUpInventory("SI - WF 34-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 34-Skip1 Tapped");
		setupInventoryPage.TapOrderGuide("SI - WF 34-OG Selected");
		setupInventoryPage.tapContinue("SI - WF 34-Tapped Continue1");
		locationsPage.CustomLocation("SI - WF 34-Tapped Custom location");
		locationsPage.tapContinue("SI - WF 34-Tapped Continue2");
		locationsPage.EnterLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[2],"SI - WF 34-Enter location name");
		locationsPage.AddLocations1_TypeDry("SI - WF 34-Tapped Dry1");
		locationsPage.AddLocations2("SI - WF 34-AddLocations2");
		locationsPage.AddLocations2_name(datapool.readFromExcelLocationInfo().locationNameDataPool[3],"AddLocations2_name");
		locationsPage.AddLocations2_TypeDry("SI - WF 34-Tapped Dry2");
		locationsPage.TapOnNext("SI - WF 34-Tapped Next1");
		locationsPage.selectMultipleItemsFromLocation1("SI - WF 34-Selected Multiple items");
		locationsPage.TapOnNext("SI - WF 34-Tapped Next2");
		locationsPage.selectMultipleItemsFromLocation2("SI - WF 3-Selected Multiple items");
		locationsPage.TapOnDone("SI - WF 34-Tapped Done1");

		categoryPage.SuggestedCategories("SI - WF 34-SuggestedCategories Tapped");
		categoryPage.tapContinue("SI - WF 34-Tapped Continue3");
		setupInventoryPage.TapTakeHome("SI - WF 34-Tapped Take me Home");

		inventoryToolPage.InvTools_TrackInventory("SI- WF 34-Selected track inventory");
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "SI - WF 34-select added location1");
		locationsPage.ItemVerifyOnLocation1("SI - WF 34-Verify item inside location1");
		locationsPage.SyscoCategoryIdentify("SI - WF 34-Category identification for Syscoitems in location1");
		categoryPage.VerifyOGSyscoItemsSuggestedCategoryLocation1("SI - WF 34-Category verification for Syscoitems in location1");
		categoryPage.TapOnDone("SI - WF 34-Tapped Done2");
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "SI - WF 34-select added location2");
		locationsPage.ItemVerifyOnLocation2( "SI - WF 34-Verify item inside location2");
		locationsPage.SyscoCategoryIdentify("SI - WF 34-Category identification for Syscoitems in location2");
		categoryPage.VerifyOGSyscoItemsSuggestedCategoryLocation1("SI - WF 34-Category verification for Syscoitems in location2");

		categoryPage.TapOnDone("SI - WF 34-Tapped Done3");

		;


	}
	
	
	
	 * Validating user is able to setup inventory by adding items from CustomList(single list) and then assign items to custom category as location and Suggested Cat .
	 * Prerequisite:Normal/MA User with MyList having 6 items and items should be categorized
	 * 
	 

	@Test(groups={"SI - WF 35"},priority=23, description = "SI - WF 35-Custom List + Select single  List +Custom Categories as location+Suggested Cat")
	public void SI_WF35_CustomListSingleList_CustomCategoryOnLocationsPage_suggestedcategory() throws Exception {

		user=2;
		loginPage.verifyLoginPage("SI - WF 35-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 35-Save Username");
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 35-LoginPage");
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 35-TC1 Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 35-FirstAccountSelect");

		inventoryToolPage.InvTools_SetUpInventory("SI - WF 35-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 35-Skip1 Tapped");

		listPage.TapCustomList("SI - WF 35-custom list Selected");
		listPage.tapContinue("SI - WF 35-Tapped Continue1");
	//	listPage.SelectListwithItems(datapool.readFromExcelUserInfo().listNameDataPool[1], "SI - WF 35-select list");
		listPage.SelectListwithItems("List4", "SI - WF 35-select list");
		
		listPage.TapOnNext("SI - WF 35-tapped next");

		locationsPage.CustomCategories("SI - WF 35-Tapped Default category in Location Page");
		locationsPage.tapContinue("SI - WF 35-Tapped Continue2");

		categoryPage.SuggestedCategories("SI - WF 35-SuggestedCategories Tapped");
		categoryPage.tapContinue("SI - WF 35-Tapped Continue3") ;

		setupInventoryPage.TapTakeHome("SI - WF 35-Tapped Take me Home");
		inventoryToolPage.InvTools_TrackInventory("SI - WF 35-Selected track inventory");


	}
	
	 * Validating user is able to setup inventory by adding items from CustomList(Multiple list) and then assign items to Suggested Category .
	 * Validating suggested category can be edited on product detail page and verifying.
	 * Prerequisite:Normal/MA User with MyList having  2 items each for List2,List3
	 * 
	 
	@Test(groups={"SI - WF 36"},priority=24, description = "SI - WF 36-Custom List + Select Multiple List +List Names+Suggested Cat")
	public void SI_WF36_CustomList_MultipleList_ListNames_SuggestedCat() throws Exception {

		user=4;
		
		loginPage.verifyLoginPage("SI - WF 36-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 36-Save Username");
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 36-LoginPage");
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 36-TC1 Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 36-FirstAccountSelect");

		inventoryToolPage.InvTools_SetUpInventory("SI - WF 36-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 36-Skip1 Tapped");

		listPage.TapCustomList("SI - WF 36-custom list Selected");
		listPage.tapContinue("SI - WF 36-Tapped Continue1");
		listPage.SelectListwithItems(datapool.readFromExcelUserInfo().listNameDataPool[2], "SI - WF 36-select list");
		listPage.SelectListwithItems(datapool.readFromExcelUserInfo().listNameDataPool[3], "SI - WF 36-select list");
		listPage.SelectListwithItems("List2", "SI - WF 27-select list");
		listPage.SelectListwithItems("List3", "SI - WF 27-select list");
		listPage.TapOnNext("SI - WF 36-tapped next");

		locationsPage.ListNames("SI - WF 36-Tapped Custom location");
		locationsPage.tapContinue("SI - WF 36-Tapped Continue");

		categoryPage.SuggestedCategories("SI - WF 36-SuggestedCategories Tapped");
		categoryPage.tapContinue("SI - WF 36-Tapped Continue1");

		setupInventoryPage.TapTakeHome("SI - WF 36-Tapped take me home")   ;   
		inventoryToolPage.InvTools_TrackInventory("SI - WF 36-Selected track inventory");

		locationsPage.SelectLocation(datapool.readFromExcelUserInfo().listNameDataPool[2], "SI - WF 36-select added location");
		locationsPage.VerifyListItemsOnLocation(datapool.readFromExcelUserInfo().listProduct1DataPool[2],datapool.readFromExcelUserInfo().listProduct2DataPool[2],"SI - WF 36-Item verification");
		locationsPage.SelectLocation("List2", "SI - WF 27-select added location");
		locationsPage.VerifyListItemsOnLocation("1358522","208845","SI - WF 27-Item verification");
		
		locationsPage.TapOnDone("SI - WF 36-Tapped Done");
		locationsPage.SelectLocation(datapool.readFromExcelUserInfo().listNameDataPool[3], "SI - WF 36-select added location");
		locationsPage.VerifyListItemsOnLocation(datapool.readFromExcelUserInfo().listProduct1DataPool[3],datapool.readFromExcelUserInfo().listProduct2DataPool[3],"SI - WF 36-Item verification");
		locationsPage.SelectLocation("List3", "SI - WF 27-select added location");
		locationsPage.VerifyListItemsOnLocation("1141142","1145283","SI - WF 27-Item verification");
		
		//changing category and verification

		setupInventoryPage.VerifyProductID_Location("SI - WF 36-Verified Product");
		categoryPage.VerifySuggestedCategory("SI - WF 36-Verified Category");
		
		locationsPage.SyscoProductSelect("SI - WF 36-Select Product");
		locationsPage.TapOnEdit("SI - WF 36-Tapped Edit");
		locationsPage.AddCategory_AddProductDetailsPage("SI - WF 36-CategorySelect");
		
		categoryPage.TapAnySuggestedCategory("SI - WF 36- tapped on a suggested category");
		categoryPage.TapOnDone("SI - WF 36-Tapped Done");
		categoryPage.TapOnBack("SI - WF 36-Tapped Back");
		categoryPage.VerifySelectedSuggestedCategory("SI - WF 36-Verified Category");
		categoryPage.TapOnDone("SI - WF 36-Tapped Done");      

	}



	@Test(groups={"TI-WF1-WF2"},priority=25, description = "TI-WF1-WF2-Select a location from trackinventory updating quantity and uom")
	public void TI_WF1_WF2_Location_Item_UOMQuantity() throws Exception {	

		LoginData loginData =LoginData.fetch("LoginData1");	
		LocationsData locationsData1 =LocationsData.fetch("LocationsData");
		UOMQuantityData uomQuantityData=UOMQuantityData.fetch("UOMQuantityData");
		UOMQuantityData uomQuantityData1=UOMQuantityData.fetch("UOMQuantityData1");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
		 
		user=8;

		loginPage.verifyLoginPage("TI-WF1-WF2 LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("TI-WF1-WF2-save username");	
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"TI-WF1-WF2-Login");	
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"TI-WF1-WF2-Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"TI-WF1-WF2-FirstAccountSelect");

		//setting up inventory    
		inventoryToolPage.InvTools_SetUpInventory("TI-WF1-WF2-SetupInventoryTap");

		setupInventoryPage.TapOnSkip("TI-WF1-WF2-Skip1 Tapped");
		setupInventoryPage.TapOrderGuide("TI-WF1-WF2-OG Selected");
		setupInventoryPage.tapContinue("TI-WF1-WF2-Tapped Continue");

		locationsPage.DefaultLocation("TI-WF1-WF2-Tapped Custom location");
		locationsPage.tapContinue("TI-WF1-WF2-Tapped Continue");
		setupInventoryPage.TapOnDOThisLater("TI-WF1-WF2-Tapped do this later");
		setupInventoryPage.TapTakeHome("TI-WF1-WF2-Tapped Take me Home");
		inventoryToolPage.InvTools_TrackInventory("TI-WF1-WF2-Tapped trackINventory");

		//creating a location
		locationsPage.TapAddLocation("TI-WF1-WF2-Tapped ADD");
		locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[10],"TI-WF1-WF2-Enter location name");
		locationsPage.AddLocationCooler("TI-WF1-WF2-Tapped Cooler");
		locationsPage.TapOnDone("TI-WF1-WF2-Tapped Done");
		locationsPage.TapOnBack("TI-WF1-WF2-Tapped Back");
		locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[10], "TI-WF1-WF2-Verifing AddedLocation");

		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[10], "MIL - WF 1 WF 4-Selecting AddedLocation");
		locationsPage.TapAddLocation("TI-WF1-WF24-Tapped ADD");
		setupInventoryPage.AddItemFrom_PrepItem("TI-WF1-WF2-Tapped Prepitem");
		setupInventoryPage.EnterItemDetails(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0], datapool.readFromExcelPrepItemInfo().prepItemDataPool[1], datapool.readFromExcelPrepItemInfo().prepItemDataPool[2],
				datapool.readFromExcelPrepItemInfo().prepItemDataPool[3],datapool.readFromExcelPrepItemInfo().prepItemDataPool[4], datapool.readFromExcelPrepItemInfo().prepItemDataPool[5], datapool.readFromExcelPrepItemInfo().prepItemDataPool[6], "MIL-WF 2-NonSyscoItem details entered");
		setupInventoryPage.TapOnDone("TI-WF1-WF2-Tapped Done");
		setupInventoryPage.verifyNonSyscoPrepItemSetupInv(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0],"TI-WF1-WF2-Verify item selected");

		//.SelectLocation(locationsData1.LocationName,"TI-WF1-WF2-Selected location for entering");
		locationsPage.ProductQtyEnter(datapool.readFromExcelUOMQuantityInfo().uomQuantityDataPool[0],"TI-WF1-WF2-Entering Quantity1");
		locationsPage.UomEnterOZ(datapool.readFromExcelUOMQuantityInfo().uomQuantityDataPool[1], "TI-WF1-WF2-Entering Uom unit OZ");
		locationsPage.TapOnDone("TI-WF1-WF2-Tapped done");

		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[10],"TI-WF1-WF2-Selected location for verifying");
		locationsPage.QuantityVerify(datapool.readFromExcelUOMQuantityInfo().uomQuantityDataPool[0], "TI-WF1-WF2-Verifying Quantity1");

		locationsPage.TapOnBack("TI-WF1-WF2-Tapped Back");
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[10],"TI-WF1-WF2-Selected location for updating");
		locationsPage.ProductQtyEnter(datapool.readFromExcelUOMQuantityInfo().uomQuantityDataPool[2],"TI-WF1-WF2-Entering Quantity2");
		locationsPage.UomEnterOZ(datapool.readFromExcelUOMQuantityInfo().uomQuantityDataPool[3], "TI-WF1-WF2-Entering Uom unit OZ");
		locationsPage.TapOnDone("TI-WF1-WF2-Tapped done");

		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[10],"TI-WF1-WF2-Selected location for update verify");
		locationsPage.QuantityVerify(datapool.readFromExcelUOMQuantityInfo().uomQuantityDataPool[2],"TI-WF1-WF2-Verifying Quantity2");

		;

	}



	
	 * Validating user is able to setup inventory.
	 * Validating creation of location on Track inventory,adding multiple items to location (Pdt catalog + OG +Non sysco+Prep)
	 * Validating nickname can be assigned for OG and catalog items  
	 * Prerequisite:Normal/MA User with OG items
	 

	@Test(groups={"MIL-WF1-WF4"},priority=26, description = "MIL - WF 1,WF 4-Creating Location in trackinventory and add items from multiple lists to location")
	public void MIL_WF1_WF4_Location_AddItems() throws Exception {	

			LoginData loginData =LoginData.fetch("LoginData2");	
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		ProductNickNameData productNickNameData=ProductNickNameData.fetch("ProductNickNameData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		SearchData searchData=SearchData.fetch("SearchData");
		 
		user=8;

		loginPage.verifyLoginPage("MIL-WF1-WF4 LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("MIL-WF1-WF4-save username");	
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"MIL-WF1-WF4-Login");	
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"MIL-WF1-WF4-Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"MIL-WF1-WF4-FirstAccountSelect");


		//setting up inventory    
		inventoryToolPage.InvTools_SetUpInventory("MIL-WF1-WF4-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("MIL-WF1-WF4-Skip1 Tapped");
		setupInventoryPage.TapOrderGuide("MIL-WF1-WF4-OG Selected");
		setupInventoryPage.tapContinue("MIL-WF1-WF4-Tapped Continue");
		locationsPage.DefaultLocation("MIL-WF1-WF4-Tapped Custom location");
		locationsPage.tapContinue("MIL-WF1-WF4-Tapped Continue");
		setupInventoryPage.TapOnDOThisLater("MIL-WF1-WF4-Tapped do this later");
		setupInventoryPage.TapTakeHome("MIL-WF1-WF4-Tapped TakeMeHome");
		inventoryToolPage.InvTools_TrackInventory("MIL-WF1-WF4-TrackinventoryTap");

		locationsPage.TapAddLocation("MIL-WF1-WF4-Tapped ADD");
		locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[3],"MIL-WF1-WF4-Enter location name");
		locationsPage.AddLocationCooler("MIL-WF1-WF4-Tapped Cooler");
		locationsPage.TapOnDone("MIL-WF1-WF4-Tapped Done");
		locationsPage.TapOnBack("MIL-WF1-WF4-Tapped Back");
		locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "MIL-WF1-WF4-Verifing AddedLocation");

		//nonsysco addition 
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "MIL-WF1-WF4-Selecting AddedLocation");
		locationsPage.TapAddLocation("MIL-WF1-WF4-Tapped ADD");
		setupInventoryPage.AddItemFrom_NonSysco("MIL-WF1-WF4-Tapped NonSysco");
		setupInventoryPage.NonSysco_Prompt(datapool.readFromExcelUserInfo().userNameDataPool[user],"MIL-WF1-WF4-verify NonSysco");

		setupInventoryPage.EnterItemDetails(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0],datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[1],datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[2],
				datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[3], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[4], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[5], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[6], "MIL-WF1-WF4-NonSyscoItem details entered");
		setupInventoryPage.AddSupplier_AddProductDetailsPage("MIL-WF1-WF4-select supplier");
		vendorPage.Add_Supplier("MIL-WF1-WF4-AddVendorTap");
		vendorPage.AddSupplier_Details(datapool.readFromExcelSupplier1Info().supplier1DataPool[0], datapool.readFromExcelSupplier1Info().supplier1DataPool[1], datapool.readFromExcelSupplier1Info().supplier1DataPool[2],
				datapool.readFromExcelSupplier1Info().supplier1DataPool[3], datapool.readFromExcelSupplier1Info().supplier1DataPool[4], datapool.readFromExcelSupplier1Info().supplier1DataPool[5], "MIL-WF1-WF4-AddVendorDetails");
		vendorPage.TapOnDone("MIL-WF1-WF4-Done");
		vendorPage.TapOnBack("MIL-WF1-WF4-Back");
		vendorPage.SupplierSelect(datapool.readFromExcelSupplier1Info().supplier1DataPool[0],"MIL-WF1-WF4-SupplierSelect");
		vendorPage.TapOnDone("MIL-WF1-WF4-Done");


		//prepitemaddition
		locationsPage.TapAddLocation("MIL-WF1-WF4-Tapped ADD");
		setupInventoryPage.AddItemFrom_PrepItem("MIL-WF1-WF4-Tapped NonSysco");
		setupInventoryPage.Prep_Prompt("MIL-WF1-WF4-verify Prep");   ///change to prep item

		setupInventoryPage.EnterItemDetails(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0], datapool.readFromExcelPrepItemInfo().prepItemDataPool[1], datapool.readFromExcelPrepItemInfo().prepItemDataPool[2],
				datapool.readFromExcelPrepItemInfo().prepItemDataPool[3],datapool.readFromExcelPrepItemInfo().prepItemDataPool[4], datapool.readFromExcelPrepItemInfo().prepItemDataPool[5], datapool.readFromExcelPrepItemInfo().prepItemDataPool[6], "MIL-WF 1-4-NonSyscoItem details entered");
		setupInventoryPage.TapOnDone("MIL-WF1-WF4-Tapped Done");


		//product catalog additin
		locationsPage.TapAddLocation("MIL - WF 1 WF 4-Tapped ADD"); 
		setupInventoryPage.SearchItem(datapool.readFromExcelSearchInfo().searchNameDataPool[1],"MIL-WF1-WF4-Search item");
		setupInventoryPage.SelectItemFrom_Catalog("MIL-WF1-WF4-Selected item from OG");
		setupInventoryPage.TapOnDone("MIL-WF1-WF4-Done");
		setupInventoryPage.verifySearchItemsOnSetupInv("MIL-WF1-WF4-Verify item selected");
		setupInventoryPage.TapOnDone("MIL-WF1-WF4-Tapped Done");
		//assiging nickname to catalog item
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "MIL-WF1-WF4-Selecting AddedLocation");
		locationsPage.SyscoProductSelect("MIL-WF1-WF4-Select Product");
		locationsPage.TapOnEdit("MIL-WF1-WF4-Tapped Edit");
		locationsPage.EditProduct_NickName(datapool.readFromExcelProductNickNameInfo().productNickNameDataPool[0], "MIL-WF1-WF4-Entering Nickname");
		locationsPage.TapOnDone("MIL-WF1-WF4-Tapped Done");
		locationsPage.TapOnBack("MIL-WF1-WF4-Tapped Back");

		//og item addition and assigning nickname to it
		locationsPage.TapAddLocation("MIL-WF1-WF4-Tapped ADD");
		locationsPage.AddItemFrom_OrderGuide("MIL-WF1-WF4-Tapped NonSysco");
		setupInventoryPage.SelectItemFrom_OrderGuide("MIL-WF1-WF4-Selected item from OG");
		setupInventoryPage.TapOnDone("MIL-WF1-WF4-Tapped Done");
		setupInventoryPage.verifyOGItemsOnSetupInv("MIL-WF1-WF4-Verify item selected");  
		setupInventoryPage.TapOnDone("MIL-WF1-WF4-Tapped Done"); 

		locationsPage.SyscoProductSelect("MIL-WF1-WF4-Select Product");
		locationsPage.TapOnEdit("MIL-WF1-WF4-Tapped Edit");
		locationsPage.EditProduct_NickName("nickName", "MIL-WF1-WF4-Entering Nickname");
		locationsPage.TapOnDone("MIL-WF1-WF4-Tapped Done");
		locationsPage.TapOnBack("MIL-WF1-WF4-Tapped Back");


		setupInventoryPage.verifySearchItemsOnSetupInv("MIL-WF1-WF4-Verify item selected");


		setupInventoryPage.verifyOGItemsOnSetupInv("MIL  - WF 1 WF 4-Verify item selected"); 

		setupInventoryPage.verifyNonSyscoPrepItemSetupInv(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0],"MIL-WF1-WF4-Verify item selected");
		setupInventoryPage.verifyNonSyscoPrepItemSetupInv(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0],"MIL-WF1-WF4-Verify item selected");

		;
	}

	
	 * Validating user is able to setup inventory.
	 * Validating creation of location on Track inventory,adding Non sysco and Prep items to multiple locations
	 * Validating  quantity updation on Product detail page for same item on different locations
	 * Prerequisite:Normal/MA User with OG items
	 


	@Test(groups={"MIL - WF 2"},priority=27, description = "MIL - WF 2-Selecing a location, adding same items to multiple location")
	public void MIL_WF2_Location_AddItems__MultipleLocation() throws Exception {	

		LoginData loginData =LoginData.fetch("LoginData3");
		LocationsData locationsData3 =LocationsData.fetch("LocatiosData3");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		//SearchData searchData=SearchData.fetch("SearchData");
		UOMQuantityData uomQuantityData = UOMQuantityData.fetch("UOMQuantityData");
		UOMQuantityData uomQuantityData1 = UOMQuantityData.fetch("UOMQuantityData1");
		 
		user=12;

		loginPage.verifyLoginPage("MIL-WF 2 LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("MIL-WF 2-save username");	
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"MIL-WF 2-Login");	
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"MIL-WF 2-Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"MIL-WF 2-FirstAccountSelect");

		inventoryToolPage.InvTools_SetUpInventory("MIL-WF 2-SetupInventoryTap");

		setupInventoryPage.TapOnSkip("MIL-WF 2-Tapped Skip1");
		setupInventoryPage.TapOrderGuide("MIL-WF 2-Tapped orderguide");
		setupInventoryPage.tapContinue("MIL-WF 2-Tapped continue");

		locationsPage.DefaultLocation("MIL-WF 2-Tapped Custom location");
		locationsPage.tapContinue("MIL-WF 2-Tapped Continue");

		setupInventoryPage.TapOnDOThisLater("MIL-WF6-Tapped do this later");
		setupInventoryPage.TapTakeHome("MIL-WF 2-Tapped take me home");


		inventoryToolPage.InvTools_TrackInventory("MIL-WF 2-TrackinventoryTap");

		//creating a location1       
		locationsPage.TapAddLocation("MIL-WF 2-Tapped ADD");
		locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[2],"MIL-WF 2-Enter location1 name");
		locationsPage.AddLocationCooler("MIL-WF 2-Tapped Cooler");
		locationsPage.TapOnDone("MIL-WF 2-Tapped Done");
		locationsPage.TapOnBack("MIL-WF 2-Tapped Back");
		locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MIL-WF 2-Verifing Added Location1");

		//nonsysco item addition to location1
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MIL-WF 2-Selecting Added Location1");
		locationsPage.TapAddLocation("MIL-WF 2-Tapped ADD");

		setupInventoryPage.AddItemFrom_NonSysco("MIL-WF 2-Tapped NonSysco");
		setupInventoryPage.EnterItemDetails(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0],datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[1],datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[2],
				datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[3], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[4], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[5], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[6], "MIL-WF2-NonSyscoItem details entered");

		setupInventoryPage.AddSupplier_AddProductDetailsPage("MIL-WF 2-select supplier");

		vendorPage.Add_Supplier("MIL-WF 2-AddVendorTap");
		vendorPage.AddSupplier_Details(datapool.readFromExcelSupplier1Info().supplier1DataPool[0], datapool.readFromExcelSupplier1Info().supplier1DataPool[1], datapool.readFromExcelSupplier1Info().supplier1DataPool[2],
				datapool.readFromExcelSupplier1Info().supplier1DataPool[3], datapool.readFromExcelSupplier1Info().supplier1DataPool[4], datapool.readFromExcelSupplier1Info().supplier1DataPool[5], "MIL-WF2-AddVendorDetails");
		vendorPage.TapOnDone("MIL-WF 2-Done");
		vendorPage.TapOnBack("MIL-WF 2-Back");
		vendorPage.SupplierSelect(datapool.readFromExcelSupplier1Info().supplier1DataPool[0],"MIL-WF 2-SupplierSelect");

		//same nonsysco item addition to location2 
		locationsPage.AddLocation_AddProductDetailsPage("MIL-WF 2-Select Add/Select location option");
		locationsPage.TapAddLocation("MIL-WF 2-Tapped ADD");
		locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[3],"MIL-WF 2-Enter location2 name");
		locationsPage.AddLocationCooler("MIL-WF 2-Tapped Cooler");
		locationsPage.TapOnDone("MIL-WF 2-Tapped Done");
		locationsPage.TapOnBack("MIL-WF 2-Tapped Back");
		locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "MIL-WF 2-Verifing Added Location2");

		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "MIL-WF 2-Selecting Added Location2");
		locationsPage.LocationDoneSelection("MIL-WF 2-Selecting Done");
		locationsPage.TapOnDone("MIL-WF 2-Tapped Done");

		//location1 displayed with 1 non sysco item
		//prep item addition to location1

		locationsPage.TapAddLocation("MIL-WF 2-Tapped ADD");

		setupInventoryPage.AddItemFrom_PrepItem("MIL-WF 2-Tapped Prepitem");
		setupInventoryPage.EnterItemDetails(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0], datapool.readFromExcelPrepItemInfo().prepItemDataPool[1], datapool.readFromExcelPrepItemInfo().prepItemDataPool[2],
				datapool.readFromExcelPrepItemInfo().prepItemDataPool[3],datapool.readFromExcelPrepItemInfo().prepItemDataPool[4], datapool.readFromExcelPrepItemInfo().prepItemDataPool[5], datapool.readFromExcelPrepItemInfo().prepItemDataPool[6], "MIL-WF 1-4-NonSyscoItem details entered");

		//same prep item addition to location3 
		locationsPage.AddLocation_AddProductDetailsPage("MIL-WF 2-Select Add/Select location option");
		locationsPage.TapAddLocation("MIL-WF 2-Tapped ADD");
		locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[4],"MIL-WF 2-Enter location3 name");
		locationsPage.AddLocationCooler("MIL-WF 2-Tapped Cooler");
		locationsPage.TapOnDone("MIL-WF 2-Tapped Done");
		locationsPage.TapOnBack("MIL-WF 2-Tapped Back");
		locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[4], "MIL-WF 2-Verifing Added Location3");

		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[4], "MIL-WF 2-Selecting Added Location3");
		locationsPage.LocationDoneSelection("MIL-WF 2-Selecting Done");
		locationsPage.TapOnDone("MIL-WF 2-Tapped Done");
		// .TapOnDone("MIL-WF 2-Tapped Done");

		//location1 displayed with nonsysco and prep item
		//Verifications
		locationsPage.TapOnBack("MIL-WF 2-Tapped back");

		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MIL-WF 2-Selecting Added Location2"); 
		setupInventoryPage. verifyNonSyscoPrepItemSetupInv(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0],"MIL-WF 2-Verify nonsysco item selected in Location2");
		setupInventoryPage.verifyNonSyscoPrepItemSetupInv(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0],"MIL-WF 2-Verify prep item selected in Location3");

		locationsPage.TapOnBack("MIL-WF 2-Tapped Back");

		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "MIL-WF 2-Selecting Added Location3");
		setupInventoryPage. verifyNonSyscoPrepItemSetupInv(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0],"MIL-WF 2-Verify nonsysco item selected in Location2");
		locationsPage.TapOnBack("MIL-WF 2-Tapped Back");

		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[4], "MIL-WF 2-Selecting Added Location3");

		setupInventoryPage.verifyNonSyscoPrepItemSetupInv(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0],"MIL-WF 2-Verify prep item selected in Location3");


		locationsPage.ProductSelect(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0], "MIL-WF 2-Selecting prep item");
		locationsPage.TapOnEdit("MIL - WF 10 NU Tap on edit");
		locationsPage.PdtDetailPage_Location1_EnterQty(datapool.readFromExcelUOMQuantityInfo().uomQuantityDataPool[0],datapool.readFromExcelLocationInfo().locationNameDataPool[2], "Enter Qty frst location");
		locationsPage.PdtDetailPage_Location2_EnterQty(datapool.readFromExcelUOMQuantityInfo().uomQuantityDataPool[2],datapool.readFromExcelLocationInfo().locationNameDataPool[4], "Enter Qty second location");
		locationsPage.TapOnDone("MIL - WF 10 NU tap on done");
		locationsPage.TapOnBack("MIL - WF 10 NU tap on back");
		locationsPage.QuantityVerify(datapool.readFromExcelUOMQuantityInfo().uomQuantityDataPool[2], "MIL - WF 2 NU Quantity verify");

		locationsPage.TapOnBack("MIL-WF 2-Tapped Back");
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MIL-WF 2-Selecting Added Location1");
		locationsPage.QuantityVerify(datapool.readFromExcelUOMQuantityInfo().uomQuantityDataPool[0], "MIL - WF 2 NU Quantity verify");
		///////change location also here


		;
	}
	
	 * Validating user is able to setup inventory.
	 * Validating creation of location on Track inventory,adding OG items to location and searching items within location
	 * Validating count of items displayed for each location.
	 * Prerequisite:Normal/MA User with OG items
	 
	@Test(groups={"MIL - WF 3"},priority=28, description = "MIL - WF 3-Selecting a specific location in trackinventory and search for items within location for MA user")
	public void MIL_WF3_Location_SearchItems() throws Exception {	

		LoginData loginData =LoginData.fetch("LoginData1");
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		SearchData searchData=SearchData.fetch("SearchData");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		 
		user=12;

		loginPage.verifyLoginPage("MIL-WF-3LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("MIL-WF-3-save username");	
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"MIL-WF-3-Login");	
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"MIL-WF-3-Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"MIL-WF-3-FirstAccountSelect");
		inventoryToolPage.InvTools_SetUpInventory("MIL-WF-3-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("MIL-WF-3-Skip1 Tapped");
		setupInventoryPage.TapOrderGuide("MIL-WF-3-OG Selected");
		setupInventoryPage.tapContinue("MIL-WF-3-Tapped Continue");

		

		locationsPage.CustomLocation("MIL-WF-3-Tapped Custom location");
		locationsPage.tapContinue("MIL-WF-3-Tapped Continue2");
		locationsPage.EnterLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[2],"MIL-WF-3-Enter location name");
		locationsPage.AddLocations1_TypeDry("MIL-WF-3-Tapped Dry1");
		locationsPage.AddLocations2("MIL-WF-3-AddLocations2");
		locationsPage.AddLocations2_name(datapool.readFromExcelLocationInfo().locationNameDataPool[3],"AddLocations2_name");
		locationsPage.AddLocations2_TypeDry("MIL-WF-3-Tapped Dry2");
		locationsPage.TapOnNext("MIL-WF-3-Tapped Next1");

		setupInventoryPage.SearchItem(datapool.readFromExcelSearchInfo().searchNameDataPool[2],"MIL-WF3-Search item");
		locationsPage.selectMultipleItemsFromLocation1("MIL - WF 3-Selected Multiple items");
		setupInventoryPage.verifySearchedItems(datapool.readFromExcelSearchInfo().searchNameDataPool[2],"MIL-WF3-Searched items verify");
		locationsPage.TapOnNext("MIL - WF 3-Tapped Next4");
		locationsPage.selectMultipleItemsFromLocation2("MIL - WF 3-Selected Multiple items");
		locationsPage.TapOnDone("MIL - WF 3-Tapped Done1");
		categoryPage.CustomCategories("MIL - WF 3-Custom Categories Tapped");
		categoryPage.tapContinue("MIL - WF 3-Tapped Continue3");
		categoryPage.CreateTwoExpenseCategory(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], datapool.readFromExcelCategoryInfo().categoryNameDataPool[2], "MIL - WF 3-CreateTwoExpenseCategory");
		categoryPage.TapOnNext("MIL - WF 3-Tapped Next3");
		setupInventoryPage.SearchItem(datapool.readFromExcelSearchInfo().searchNameDataPool[2],"MIL-WF3-Search item");
		categoryPage.selectMultipleItemsFromCategory1("MIL - WF 3-selectMultipleItemsFromCategory1");
		setupInventoryPage.verifySearchedItems(datapool.readFromExcelSearchInfo().searchNameDataPool[2],"MIL-WF3-Searched items verify");
		categoryPage.TapOnNext("MIL - WF 3-Tapped Next4");
		categoryPage.selectMultipleItemsFromCategory2("MIL - WF 3-selectMultipleItemsFromCategory2");
		setupInventoryPage.TapOnDone("MIL - WF 3-Tapped Done2");

		setupInventoryPage.TapTakeHome("MIL - WF 3-Tapped Continue3");   
		inventoryToolPage.InvTools_TrackInventory("MIL-WF3-TrackinventoryTap");
		locationsPage.TapAddLocation("MIL-WF3-Tapped ADD");
		locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[1],"MIL-WF 3-Enter location name");
		locationsPage.AddLocationCooler("MIL-WF3-Tapped Cooler");
		locationsPage.TapOnDone("MIL-WF3-Tapped Done");
		locationsPage.TapOnBack("MIL-WF3-Tapped Back");
		locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[1], "MIL-WF3-Verifing AddedLocation");
		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[1], "MIL-WF3-Selecting location");

		//og item addition
		locationsPage.TapAddLocation("MIL-WF3-Tapped ADD");

		locationsPage.AddItemFrom_OrderGuide("MIL-WF3-Tapped Orderguide");
		setupInventoryPage.SelectMultipleItemsFrom_OrderGuide("MIL-WF3-Selected multiple items from OG");
		setupInventoryPage.TapOnDone("MIL-WF3-Tapped Done");
		setupInventoryPage.verifyMultipleItemsfromOGonSetUpInv("MIL-WF3-Verify items selected");  
		
		
		setupInventoryPage.SearchKeyword("MIL-WF3-Keyword searching");
		setupInventoryPage.verifyKeywordSearchItems("MIL-WF3-Verify Keyword search");
		locationsPage.TapOnBack("MIL-WF3-Tapped Back");
		locationsPage.VerifyCountOfItemsInLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[1], "MIL WF3 verify count");

		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[1], "MIL-WF3-Selecting location");
		locationsPage.TapAddLocation("MIL-WF3-Tapped ADD");

		setupInventoryPage.SearchItem(datapool.readFromExcelSearchInfo().searchNameDataPool[3],"MIL-WF3-Search item");
		setupInventoryPage.verifyItemDescriptionSearch(datapool.readFromExcelSearchInfo().searchNameDataPool[3], "MIL-WF3-Verified search with item description");
		setupInventoryPage.SelectItemFrom_Catalog("MIL-WF3-Selected item from catalog");
		setupInventoryPage.TapOnDone("MIL-WF3-Tapped Done4");

		//added 
		setupInventoryPage.TapOnDone("MIL-WF3-Tapped Done4");

		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[1], "MIL-WF3-Selecting location");
		setupInventoryPage.SearchWord("MIL-WF3-Keyword searching");
		setupInventoryPage.verifyWordSearchItems("MIL-WF3-Verify word search");
		locationsPage.verifyUIAfterSearch("MIL-WF3-Verify after search");
		locationsPage.TapOnBack("tapped on back");

		locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[1], "MIL-WF3-Selecting location");
		locationsPage.TapOnEdit("MIL-WF3-Tapped Edit");
		setupInventoryPage.verifyEditLocationPage("MIL-WF3-verify edit location page");



		;
	}
	
	 * Validating user is able to setup inventory.
	 * Validating creation of location on Track inventory,adding Non sysco item to location 
	 * Validating different locations can be assigned to same item through product detail page
	 * Prerequisite:Normal/MA User with OG items
	 * 
	 @Test(groups={"MIL - WF 5"},priority=29, description = "MIL - WF 5-Selecting a location navigate to product and assiging  item  to diff location")
	 public void MIL_WF5_Locations_ItemEdit_UpdateLocation() throws Exception {	

		 LoginData loginData =LoginData.fetch("LoginData2");
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		  	user=12;

		  loginPage.verifyLoginPage("MIL-WF-5 LoginPage");
		  loginPage.saveUsernameCheckBoxclickElement("MIL-WF-5-save username");	
		  loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"MIL-WF-5-Login");	
		  homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"MIL-WF-5-Clicked account");
		  accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"MIL-WF-5-FirstAccountSelect");

		  inventoryToolPage.InvTools_SetUpInventory("MIL- WF 5-SetupInventoryTap");

		  setupInventoryPage.TapOnSkip("MIL-WF 5-Tapped Skip");

		  setupInventoryPage.TapOrderGuide("MIL - WF 5-OG Selected");
		  setupInventoryPage.tapContinue("MIL - WF 5-Tapped Continue1");

		  locationsPage.DefaultLocation("SI - WF 5-Tapped Custom location");
		  locationsPage.tapContinue("SI - WF 5-Tapped Continue");

		  setupInventoryPage.TapOnDOThisLater("MIL-WF 5-Tapped do this later");
		  setupInventoryPage.TapTakeHome("SI - WF 5-Tapped take me home");


		  inventoryToolPage.InvTools_TrackInventory("MIL- WF 5-TrackinventoryTap");

		  locationsPage.TapAddLocation("MIL- WF 5-Tapped ADD");
		  locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[2],"MIL- WF 5-Enter location name");
		  locationsPage.AddLocationCooler("MIL- WF 5-Tapped Cooler");
		  locationsPage.TapOnDone("MIL- WF 5-Tapped Done");
		  locationsPage.TapOnBack("MIL- WF 5-Tapped Back");
		  locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MIL- WF 5-Verifing AddedLocation");
		  locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MIL- WF 5-Selecting AddedLocation");
		  locationsPage.TapAddLocation("MIL- WF 5-Tapped ADD");

		  setupInventoryPage.AddItemFrom_NonSysco("MIL- WF 5-Tapped NonSysco");
		  setupInventoryPage.EnterItemDetails(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0],datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[1],datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[2],
				  datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[3], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[4], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[5], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[6], "MIL-5 NonSyscoItem details entered");

		  setupInventoryPage.AddSupplier_AddProductDetailsPage("MIL- WF 5-select supplier");

		  vendorPage.Add_Supplier("MIL- WF 5-AddVendorTap");
		  vendorPage.AddSupplier_Details(datapool.readFromExcelSupplier1Info().supplier1DataPool[0], datapool.readFromExcelSupplier1Info().supplier1DataPool[1], datapool.readFromExcelSupplier1Info().supplier1DataPool[2],
				  datapool.readFromExcelSupplier1Info().supplier1DataPool[3], datapool.readFromExcelSupplier1Info().supplier1DataPool[4], datapool.readFromExcelSupplier1Info().supplier1DataPool[5], "MIL-WF5-AddVendorDetails");
		  vendorPage.TapOnDone("MIL- WF 5-Done");

		  vendorPage.TapOnBack("MIL- WF 5-Back");
		  vendorPage.SupplierSelect(datapool.readFromExcelSupplier1Info().supplier1DataPool[0],"MIL- WF 5-SupplierSelect");
		  vendorPage.TapOnDone("MIL- WF 5-Done");

		  setupInventoryPage.verifyNonSyscoPrepItemSetupInv(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0],"MIL- WF 5-Verify item selected");

		  locationsPage.ProductSelect(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0], "MIL- WF 5-Select Product");
		  locationsPage.TapOnEdit("MIL- WF 5-Tapped Edit");
		  locationsPage.AddLocation_AddProductDetailsPage("MIL- WF 5-Select Add/Select option");
		  locationsPage.TapAddLocation("MIL- WF 5-Tapped ADD");
		  locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[3],"MIL- WF 5-Enter location name");
		  locationsPage.AddLocationCooler("MIL- WF 5-Tapped Cooler");
		  locationsPage.TapOnDone("MIL- WF 5-Tapped Done");
		  locationsPage.TapOnBack("MIL- WF 5-Tapped Back");
		  locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "MIL- WF 5-Verifing AddedLocation"); ////////

		  locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "MIL- WF 5-Selecting AddedLocation");
		  locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MIL- WF 5-Selecting AddedLocation");
		  locationsPage.LocationDoneSelection("MIL- WF 5-Selecting Done");
		  locationsPage.TapOnDone("MIL- WF 5-Tapped Done");

		  locationsPage.TapOnBack("MIL- WF 5-Tapped Back");
		  locationsPage.TapOnBack("MIL- WF 5-Tapped Back");

		  locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MIL- WF 5-Selecting AddedLocation");
		  setupInventoryPage.verifyNonSyscoPrepItemSetupInv(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0],"MIL- WF 5-Verify item selected");

		  locationsPage.TapOnBack("MIL- WF 5-Tapped Back");
		  locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "MIL- WF 5-Selecting AddedLocation");

		  setupInventoryPage.verifyNonSyscoPrepItemSetupInv(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0],"MIL- WF 5-Verify item selected");

		  ;
	 }

	 
	  * Validating user is able to setup inventory.
	  * Validating Creating Location,Editing Location in Manage Locations and deleting location
	  * Prerequisite:Normal/MA User with OG items
	  * 
	  


	 @Test(groups={"MIL - WF 6"},priority=30, description = "MIL - WF 6-Creating Location,Editing Location in Manage Locations and assiging  item  to diff location")
	 public void MIL_WF6_Create_Edit_Delete_Locations() throws Exception {	

		 LoginData loginData =LoginData.fetch("LoginData4");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
		  
		 user=12;

		 loginPage.verifyLoginPage("MIL-WF-6 LoginPage");
		 loginPage.saveUsernameCheckBoxclickElement("MIL-WF-6-save username");	
		 loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"MIL-WF-6-Login");	
		 homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"MIL-WF-6-Clicked account");
		 accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"MIL-WF-6-FirstAccountSelect");


		 //setting up inventory    
		 inventoryToolPage.InvTools_SetUpInventory("MIL - WF 6-SetupInventoryTap");

		 setupInventoryPage.TapOnSkip("MIL - WF 6-Skip1 Tapped");
		 setupInventoryPage.TapOrderGuide("MIL - WF 6-OG Selected");
		 setupInventoryPage.tapContinue("MIL - WF 6-Tapped Continue");

		 locationsPage.DefaultLocation("MIL - WF 6-Tapped Custom location");
		 locationsPage.tapContinue("MIL - WF 6-Tapped Continue");
		 setupInventoryPage.TapOnDOThisLater("MIL - WF 6-Tapped do this later");
		 setupInventoryPage.TapTakeHome("MIL - WF 6-Tapped Take me Home");

		 inventoryToolPage.InvTools_Locations("MIL - WF 6-TrackinventoryTap");

		 locationsPage.TapAddLocation("MIL- WF 6-Tapped ADD");
		 locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[2],"MIL- WF 6-Enter location name");
		 locationsPage.AddLocationFreezer("MIL- WF 6-Tapped Cooler");
		 locationsPage.TapOnDone("MIL- WF 6-Tapped Done");
		 locationsPage.TapOnBack("MIL- WF 6-Tapped Back");
		 locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MIL- WF 6-Verifing AddedLocation");

		 locationsPage.TapAddLocation("MIL- WF 6-Tapped ADD");
		 locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[3],"MIL- WF 6-Enter location name");
		 locationsPage.AddLocationCooler("MIL- WF 6-Tapped Cooler");

		 locationsPage.TapOnCancel("MIL- WF 6-Tapped Cancel");
		 locationsPage.VerifyCancelledLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "MIL- WF 6-Verifing AddedLocation");
		 locationsPage.TapAddLocation("MIL- WF 6-Tapped ADD");
		 locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[3],"MIL- WF 6-Enter location name");
		 locationsPage.AddLocationCooler("MIL- WF 6-Tapped Cooler");

		 locationsPage.TapOnDone("MIL- WF 6-Tapped Done");
		 locationsPage.TapOnBack("MIL- WF 6-Tapped Back");
		 locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "MIL- WF 6-Verifing AddedLocation");

		 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "MIL- WF 6-Selecting AddedLocation");
		 locationsPage.TapOnEdit("MIL- WF 6-Editing AddedLocation");
		 locationsPage.AddLocationFreezer("MIL- WF 6-Tapped Cooler");
		 locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().editedLocationNameDataPool[3],"MIL- WF 6-Enter location name");

		 locationsPage.TapOnDone("MIL- WF 6-Tapped Done");
		 locationsPage.TapOnBack("MIL- WF 6-Tapped Back");
		 locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().editedLocationNameDataPool[3], "MIL- WF 6-Verifing AddedLocation");

		 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().editedLocationNameDataPool[3] ,"MIL- WF 6-Selecting AddedLocation");
		 locationsPage.TapOnDeleteLocation("MIL- WF 6-Tapped Delete");
		 locationsPage.TapOnYesDelete("MIL- WF 6-Deleting AddedLocation");
		 //  .TapOnBack("MIL- WF 6-Tapped Back");
		 locationsPage.VerifyCancelledLocationList(datapool.readFromExcelLocationInfo().editedLocationNameDataPool[3], "MIL- WF 6-Verifing AddedLocation");



		 ;
	 }
	 
	  * Validating user is able to setup inventory.
	  * Validating Creating Location and Delete Items from location
	  * Prerequisite:Normal/MA User with OG items
	  * 
	  

	 @Test(groups={"MIL - WF 7"},priority=31, description = "MIL - WF 7-Track Inventory+Location+Edit+Delete Items from location")
	 public void MIL_WF7_TrackInventory_Location_Edit_Delete_Items_location_MA() throws Exception {

		 LoginData loginData =LoginData.fetch("LoginData3"); 
		LocationsData locationsData8 =LocationsData.fetch("LocatiosData8");
		LocationsData locationsData9 =LocationsData.fetch("LocatiosData9");

		LocationsData locationsData3 =LocationsData.fetch("LocatiosData3");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		//SearchData searchData=SearchData.fetch("SearchData");
		UOMQuantityData uomQuantityData = UOMQuantityData.fetch("UOMQuantityData");
		UOMQuantityData uomQuantityData1 = UOMQuantityData.fetch("UOMQuantityData1");
		  
		 user=8;

		 loginPage.verifyLoginPage("MIL-WF-7 LoginPage");
		 loginPage.saveUsernameCheckBoxclickElement("MIL-WF-7-save username");	
		 loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"MIL-WF-7-Login");	
		 homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"MIL-WF-7-Clicked account");
		 accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"MIL-WF-7-FirstAccountSelect");

		 inventoryToolPage.InvTools_SetUpInventory("MIL-WF7-SetupInventoryTap");

		 setupInventoryPage.TapOnSkip("MIL-WF7-Skip1 Tapped");
		 setupInventoryPage.TapOrderGuide("MIL-WF7-OG Selected");
		 setupInventoryPage.tapContinue("MIL-WF7-Tapped Continue1");

		 locationsPage.CustomLocation("MIL-WF7-Tapped Custom location");
		 locationsPage.tapContinue("MIL-WF7-Tapped Continue2");

		 locationsPage.EnterLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[2],"MIL-WF7-Enter location name1");
		 locationsPage.AddLocations1_TypeDry("MIL-WF7-Tapped Dry1");

		 locationsPage.AddLocations2("MIL-WF7-Add location2");
		 locationsPage.AddLocations2_name(datapool.readFromExcelLocationInfo().locationNameDataPool[3],"MIL-WF7-Enter location name2");
		 locationsPage.AddLocations2_TypeDry("MIL-WF7-Tapped Dry2");
		 locationsPage.TapOnNext("MIL-WF7-Tapped Next1");

		 locationsPage.selectMultipleItemsFromLocation1("MIL-WF7-Selected Multiple items");
		 locationsPage.TapOnNext("MIL-WF7-Tapped Next2");

		 locationsPage.selectMultipleItemsFromLocation2("MIL-WF7-Selected Multiple items");
		 locationsPage.TapOnDone("MIL-WF7-Tapped Done1");

		 categoryPage.defaultCategories("MIL-WF7-Tapped Default category");
		 categoryPage.tapComplete("MIL-WF7-Tapped Complete");

		 setupInventoryPage.TapTakeHome("MIL-WF7-Tapped Take me Home");  

		 inventoryToolPage.InvTools_TrackInventory("MIL-WF7-Selected track inventory");

		 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MIL-WF7-selected location1");
		 locationsPage.ItemVerifyOnLocation1("MIL-WF7-Verify items inside location1");    
		 locationsPage.TapOnEdit("MIL-WF7-Tapped Edit");
		 locationsPage.DeleteItems("MIL-WF7-Deleting items in location");
		 locationsPage.TapOnDone("MIL-WF7-Tapped Done2");
		 locationsPage.TapOnYesDelete("MIL-WF7-confirming Deleting items");
		 locationsPage.VerifyDeleteItemsList("MIL-WF7-Verifying Deleted items list");
		 locationsPage.TapOnBack("tapped on back");

		 //creating a location1       
		 locationsPage.TapAddLocation("MIL-WF 7-Tapped ADD");
		 locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[4],"MIL-WF 7-Enter location1 name");
		 locationsPage.AddLocationCooler("MIL-WF 7-Tapped Cooler");
		 locationsPage.TapOnDone("MIL-WF 7-Tapped Done");
		 locationsPage.TapOnBack("MIL-WF 7-Tapped Back");
		 locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[4], "MIL-WF 7-Verifing Added Location1");

		 //nonsysco item addition to location1
		 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[4], "MIL-WF 7-Selecting Added Location1");
		 locationsPage.TapAddLocation("MIL-WF 7-Tapped ADD");

		 setupInventoryPage.AddItemFrom_NonSysco("MIL-WF 7-Tapped NonSysco");
		 setupInventoryPage.EnterItemDetails(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0],datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[1],datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[2],
				 datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[3], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[4], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[5], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[6], "MIL-WF7-NonSyscoItem details entered");

		 setupInventoryPage.AddSupplier_AddProductDetailsPage("MIL-WF 7-select supplier");

		 vendorPage.Add_Supplier("MIL-WF 7-AddVendorTap");
		 vendorPage.AddSupplier_Details(datapool.readFromExcelSupplier1Info().supplier1DataPool[0], datapool.readFromExcelSupplier1Info().supplier1DataPool[1], datapool.readFromExcelSupplier1Info().supplier1DataPool[2],
				 datapool.readFromExcelSupplier1Info().supplier1DataPool[3], datapool.readFromExcelSupplier1Info().supplier1DataPool[4], datapool.readFromExcelSupplier1Info().supplier1DataPool[5], "MIL-WF7-AddVendorDetails"); vendorPage.TapOnDone("MIL-WF 7-Done");
				 vendorPage.TapOnBack("MIL-WF 7-Back");
				 vendorPage.SupplierSelect(datapool.readFromExcelSupplier1Info().supplier1DataPool[0],"MIL-WF 7-SupplierSelect");

				 //same nonsysco item addition to location7 
				 locationsPage.AddLocation_AddProductDetailsPage("MIL-WF 7-Select Add/Select location option");
				 locationsPage.TapAddLocation("MIL-WF 7-Tapped ADD");
				 locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[10],"MIL-WF 7-Enter location7 name");
				 locationsPage.AddLocationCooler("MIL-WF 7-Tapped Cooler");
				 locationsPage.TapOnDone("MIL-WF 7-Tapped Done");
				 locationsPage.TapOnBack("MIL-WF 7-Tapped Back");
				 locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[10], "MIL-WF 7-Verifing Added Location7");
				 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[10], "MIL-WF 7-Selecting Added Location3");
				 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[4], "MIL-WF 7-Selecting Added Location7");
				 locationsPage.LocationDoneSelection("MIL-WF 7-Selecting Done");
				 locationsPage.TapOnDone("MIL-WF 7-Tapped Done");

				 //location1 displayed with 1 non sysco item
				 //prep item addition to location1

				 locationsPage.TapAddLocation("MIL-WF 7-Tapped ADD");

				 setupInventoryPage.AddItemFrom_PrepItem("MIL-WF 7-Tapped Prepitem");
				 setupInventoryPage.EnterItemDetails(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0], datapool.readFromExcelPrepItemInfo().prepItemDataPool[1], datapool.readFromExcelPrepItemInfo().prepItemDataPool[7],
						 datapool.readFromExcelPrepItemInfo().prepItemDataPool[3],datapool.readFromExcelPrepItemInfo().prepItemDataPool[4], datapool.readFromExcelPrepItemInfo().prepItemDataPool[5], datapool.readFromExcelPrepItemInfo().prepItemDataPool[6], "MIL-WF 7-NonSyscoItem details entered");

				 //same prep item addition to location3 
				 locationsPage.AddLocation_AddProductDetailsPage("MIL-WF 7-Select Add/Select location option");
				 locationsPage.TapAddLocation("MIL-WF 7-Tapped ADD");
				 locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[9],"MIL-WF 7-Enter location3 name");
				 locationsPage.AddLocationCooler("MIL-WF 7-Tapped Cooler");
				 locationsPage.TapOnDone("MIL-WF 7-Tapped Done");
				 locationsPage.TapOnBack("MIL-WF 7-Tapped Back");
				 locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[9], "MIL-WF 7-Verifing Added Location3");

				 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[9], "MIL-WF 7-Selecting Added Location3");
				 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[4], "MIL-WF 7-Selecting Added Location3");
				 locationsPage.LocationDoneSelection("MIL-WF 7-Selecting Done");
				 locationsPage.TapOnDone("MIL-WF 7-Tapped Done");
				 // .TapOnDone("MIL-WF 7-Tapped Done");

				 //location1 displayed with nonsysco and prep item
				 //Verifications
				 locationsPage.TapOnBack("MIL-WF 7-Tapped back");

				 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[4], "MIL-WF 7-Selecting Added Location7"); 
				 locationsPage.TapOnBack("");
				 inventoryToolPage.InvTools_TrackInventory("MIL- WF 7-TrackinventoryTap");
				 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[4], "MIL-WF7-selected location1");
				 locationsPage.TapOnEdit("MIL-WF7-Tapped Edit");
				 locationsPage.DeleteItems("MIL-WF7-Deleting items in location");
				 locationsPage.TapOnDone("MIL-WF7-Tapped Done7");
				 locationsPage.TapOnYesDelete("MIL-WF7-confirming Deleting items");
				 //.VerifyDeleteItemsList("MIL-WF7-Verifying Deleted items list");
				 locationsPage.TapOnBack("");
				 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[9], "MIL-WF7-selected location1");
				 //verify item deleted locn
				 locationsPage.TapOnBack("");
				 locationsPage.TapOnBack("");
				 //inv 754 

				 inventoryToolPage.InvTools_Locations("");

				 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[9], "MIL-WF7-selected location1");
				 locationsPage.TapOnEdit("MIL-WF7-Tapped Edit");
				 locationsPage.TapOnDeleteLocation("");
				 locationsPage.TapOnYesDelete("MIL-WF7-confirming Deleting items");
				 locationsPage.SelectLocation("no location", "");
				 locationsPage.ViewItemsOnLocation("SI - WF 7-view items on Location1");
				 //verify items in no location
				 locationsPage.GetLocationsNameText("");
				 //verify item on the split location obtained

				 ;
	 }
	 
	  * Validating user is able to setup inventory.
	  * Validating Creating Location and updating quantity on product card
	  * Prerequisite:Normal/MA User with OG items
	  * 
	  


	 @Test(groups={"MIL - WF 10"},priority=32, description = "MIL - WF 10 NU Track Inventory+Location+item product card + update qty & UOM")
	 public void MIL_WF10_TrackInventory_Location_item_productcard_updateqtyUOM() throws Exception {	

		 LoginData loginData =LoginData.fetch("LoginData4");;
			LocationsData locationsData =LocationsData.fetch("LocationsData");
			PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
			PrepItemData prepItemData1 =PrepItemData.fetch("PrepItemData1");
			UOMQuantityData uomQuantityData1 = UOMQuantityData.fetch("UOMQuantityData1");
		  
		 user=12;

		 loginPage.verifyLoginPage("MIL - WF 10 LoginPage");
		 loginPage.saveUsernameCheckBoxclickElement("MIL - WF 10-save username");	
		 loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"MIL - WF 10-Login");	
		 homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"MIL - WF 10-Clicked account");
		 accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"MIL - WF 10-FirstAccountSelect");

		 
		 inventoryToolPage.InvTools_SetUpInventory("MIL-WF10-SetupInventoryTap");
		 
		 setupInventoryPage.TapOnSkip("MIL - WF 10 NU-Skip1 Tapped");
		 setupInventoryPage.TapOrderGuide("MIL - WF 10 NU Selected");
		 setupInventoryPage.tapContinue("MIL - WF 10 NU-Tapped Continue");
		 locationsPage.DefaultLocation("MIL-WF 2-Tapped Custom location");
		 locationsPage.tapContinue("MIL-WF 2-Tapped Continue");

		 setupInventoryPage.TapOnDOThisLater("MIL-WF6-Tapped do this later");
		 setupInventoryPage.TapTakeHome("MIL-WF 2-Tapped take me home");

		 inventoryToolPage.InvTools_TrackInventory("MIL - WF 10 NU-TrackinventoryTap");


		 locationsPage.TapAddLocation("MIL - WF 10 NU-Tapped ADD");
		 locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[2],"MIL - WF 10 NU-Enter location name");
		 locationsPage.AddLocationCooler("MIL - WF 10 NU-Tapped Cooler");
		 locationsPage.TapOnDone("MIL - WF 10 NU-Tapped Done");
		 locationsPage.TapOnBack("MIL - WF 10 NU-Tapped Back");
		 locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MIL - WF 10 NU-Verifing AddedLocation");

		 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MIL - WF 10 NU-Selecting AddedLocation");
		 locationsPage.TapAddLocation("MIL - WF 10 NU-Tapped ADD");
		 setupInventoryPage.AddItemFrom_PrepItem("MIL - WF 10 NU-Tapped NonSysco");
		 setupInventoryPage.EnterItemDetails(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0], datapool.readFromExcelPrepItemInfo().prepItemDataPool[1], datapool.readFromExcelPrepItemInfo().prepItemDataPool[2],
				 datapool.readFromExcelPrepItemInfo().prepItemDataPool[3],datapool.readFromExcelPrepItemInfo().prepItemDataPool[4], datapool.readFromExcelPrepItemInfo().prepItemDataPool[5], datapool.readFromExcelPrepItemInfo().prepItemDataPool[6], "MIL-WF 10-NonSyscoItem details entered");;
				 setupInventoryPage.TapOnDone("MIL - WF 10 NU-Tapped Done");

				 locationsPage.ProductSelect(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0], "");
				 locationsPage.TapOnEdit("MIL - WF 10 NU Tap on edit");

				 setupInventoryPage.EnterItemDetails(datapool.readFromExcelPrepItemInfo().prepItemDataPool[7], datapool.readFromExcelPrepItemInfo().prepItemDataPool[8], datapool.readFromExcelPrepItemInfo().prepItemDataPool[9],
						 datapool.readFromExcelPrepItemInfo().prepItemDataPool[10],datapool.readFromExcelPrepItemInfo().prepItemDataPool[11], datapool.readFromExcelPrepItemInfo().prepItemDataPool[12], datapool.readFromExcelPrepItemInfo().prepItemDataPool[13], "MIL-WF 10-NonSyscoItem details entered");

				 locationsPage.tapOnProductOpenProductDetailsPageAndEnterQty(datapool.readFromExcelPrepItemInfo().prepItemDataPool[7], datapool.readFromExcelUOMQuantityInfo().uomQuantityDataPool[2], "");
				 locationsPage.TapOnDone("MIL - WF 10 NU tap on done");
				 locationsPage.TapOnBack("MIL - WF 10 NU tap on back");      ///////
				 locationsPage.QuantityVerify(datapool.readFromExcelUOMQuantityInfo().uomQuantityDataPool[2], "MIL - WF 10 NU Quantity verify");

				 setupInventoryPage.verifyNonSyscoPrepItemSetupInv(datapool.readFromExcelPrepItemInfo().prepItemDataPool[7],"MIL-WF1-WF4-Verify item selected");

				 ;

	 }


	 
	  * Validating user is able to setup inventory.
	  * Validating editing item and updating category on product card
	  * Prerequisite:Normal/MA User with OG items
	  * 
	  

	 @Test(groups={"MEC - WF 1"},priority=33, description = "MEC - WF 1-Selecting a location navigate to product and assiging  item  to category created")
	 public void MEC_WF1_Locations_ItemEdit_UpdateCategory() throws Exception {	

		 
		 user=1;

		 loginPage.verifyLoginPage("MEC-WF 1LoginPage");
		 loginPage.saveUsernameCheckBoxclickElement("MEC-WF 1-save username");	
		 loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"MEC-WF 1-Login");	
		 homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"MEC-WF 1-Clicked account");
		 accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"MEC-WF 1-FirstAccountSelect");


		 inventoryToolPage.InvTools_SetUpInventory("SI - WF 19-SetupInventoryTap");


		 setupInventoryPage.TapOnSkip("MIL - WF 10 NU-Skip1 Tapped");
		 setupInventoryPage.TapOrderGuide("MIL - WF 10 NU Selected");
		 setupInventoryPage.tapContinue("MIL - WF 10 NU-Tapped Continue");

		 locationsPage.DefaultLocation("MIL-WF 2-Tapped Custom location");
		 locationsPage.tapContinue("MIL-WF 2-Tapped Continue");


		 setupInventoryPage.TapOnDOThisLater("MIL-WF6-Tapped do this later");
		 setupInventoryPage.TapTakeHome("MIL-WF 2-Tapped take me home");



		 inventoryToolPage.InvTools_TrackInventory("MEC-WF 1-TrackinventoryTap");


		 locationsPage.TapAddLocation("MEC-WF 1-Tapped ADD");
		 locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[2],"MEC-WF 1-Enter location name");
		 locationsPage.AddLocationCooler("MEC-WF 1-Tapped Cooler");
		 locationsPage.TapOnDone("MEC-WF 1-Tapped Done");
		 locationsPage.TapOnBack("MEC-WF 1-Tapped Back");
		 locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MEC-WF 1-Verifing AddedLocation");
		 //nonsysco item addition 
		 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MEC-WF 1-Selecting AddedLocation");
		 locationsPage.TapAddLocation("MEC-WF 1-Tapped ADD");


		 setupInventoryPage.AddItemFrom_NonSysco("MEC-WF 1-Tapped NonSysco");
		 setupInventoryPage.EnterItemDetails(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0],datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[1],datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[2],
				 datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[3], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[4], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[5], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[6], "MEC WF 1 NonSyscoItem details entered");
		 setupInventoryPage.AddSupplier_AddProductDetailsPage("MEC-WF 1-select supplier");

		 vendorPage.Add_Supplier("MEC-WF 1-AddVendorTap");
		 vendorPage.AddSupplier_Details(datapool.readFromExcelSupplier1Info().supplier1DataPool[0], datapool.readFromExcelSupplier1Info().supplier1DataPool[1], datapool.readFromExcelSupplier1Info().supplier1DataPool[2],
				 datapool.readFromExcelSupplier1Info().supplier1DataPool[3], datapool.readFromExcelSupplier1Info().supplier1DataPool[4], datapool.readFromExcelSupplier1Info().supplier1DataPool[5], "MEC WF1-AddVendorDetails");vendorPage.TapOnDone("MEC-WF 1-Tapped Done");
				 vendorPage.TapOnBack("MEC-WF 1-Tapped Back");
				 vendorPage.SupplierSelect(datapool.readFromExcelSupplier1Info().supplier1DataPool[0],"MEC-WF 1-SupplierSelect");
				 vendorPage.TapOnDone("MEC-WF 1-Tapped Done");


				 setupInventoryPage.verifyNonSyscoPrepItemSetupInv(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0],"MEC-WF 1-Verify item selected");


				 locationsPage.ProductSelect(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0], "MEC-WF 1-Select Product");
				 locationsPage.TapOnEdit("MEC-WF 1-Tapped Edit");


				 locationsPage.AddCategory_AddProductDetailsPage("MEC-WF 1-CategorySelect");
				 locationsPage.TapAddLocation("MEC-WF 1-Tapped Add");

				 categoryPage.AddCategoryName(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "MEC-WF 1-Enter Category Name");
				 categoryPage.AddLocationCooler("MEC-WF 1-Enter type Cooler");
				 categoryPage.TapOnDone("MEC-WF 1-Tapped Done");
				 categoryPage.TapOnBack("MEC-WF 1-Tapped Back");
				 categoryPage.SelectCategory(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "MEC-WF 1-Select Category Name");
				 categoryPage.TapOnDone("MEC-WF 1-Tapped Done"); 
				 categoryPage.TapOnBack("MEC-WF 1-Tapped Back");
				 categoryPage.TapOnBack("MEC-WF 1-Tapped Back");


				 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MEC-WF 1-Selecting AddedLocation");

				 categoryPage.VerifyCategory(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "MEC-WF 1-Verified Category");

				 //inv 252,253

				 //no scenario

				 locationsPage.TapAddLocation("MEC-WF1-Tapped ADD");

				 setupInventoryPage.AddItemFrom_PrepItem("MEC-WF1-Tapped Prepitem");
				 setupInventoryPage.EnterItemDetails(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0], datapool.readFromExcelPrepItemInfo().prepItemDataPool[1], datapool.readFromExcelPrepItemInfo().prepItemDataPool[2],
						 datapool.readFromExcelPrepItemInfo().prepItemDataPool[3],datapool.readFromExcelPrepItemInfo().prepItemDataPool[4], datapool.readFromExcelPrepItemInfo().prepItemDataPool[5], datapool.readFromExcelPrepItemInfo().prepItemDataPool[6], "MEC WF 1 NonSyscoItem details entered");

				 // prep item addition to 2 locations created 

				 locationsPage.AddLocation_AddProductDetailsPage("MEC-WF1-Select Add/Select location option");
				 locationsPage.TapAddLocation("MEC-WF1-Tapped ADD");
				 locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[2],"MEC-WF1-Enter location3 name");
				 locationsPage.AddLocationCooler("MEC-WF1-Tapped Cooler");
				 locationsPage.TapOnDone("MEC-WF1-Tapped Done");
				 locationsPage.TapOnBack("MEC-WF1-Tapped Back");
				 locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MEC-WF1-Verifing Added Location3");

				 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MEC-WF1-Selecting Added Location3");
				 locationsPage .SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MEC-WF1-Selecting Added Location1");
				 locationsPage.LocationDoneSelection("MEC-WF1-Selecting Done");
				 locationsPage.TapOnDone("MEC-WF1-Tapped Done");


				 setupInventoryPage.verifyNonSyscoPrepItemSetupInv(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0],"MEC-WF1-Verify item selected");


				 locationsPage.ProductSelect(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0], "MEC-WF1-Select Product");
				 locationsPage.TapOnEdit("MEC-WF1-Tapped Edit");
				 //.LocationsDelete("MEC-WF1-Tapped Edit");
				 locationsPage.LocationsDelete(datapool.readFromExcelLocationInfo().locationNameDataPool[2],"MEC-WF1-Tapped delete");
				 locationsPage.LocationsDelete(datapool.readFromExcelLocationInfo().locationNameDataPool[2],"MEC-WF1-Tapped delete");
				 locationsPage.DeleteAllLocConfirmation("MEC-WF1-Confirming deleting all locations");
				 locationsPage.TapOnNoDelete("MEC-WF1-Tapped No for deletion");
				 locationsPage.TapOnEdit("MEC-WF1-Tapped Edit");
				 locationsPage.TapOnDone("MEC-WF1-Tapped Done");
				 locationsPage.TapOnBack("MEC-WF1-Tapped Back");
				 locationsPage.TapOnBack("MEC-WF1-Tapped Back");
				 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "MEC-WF1-Selecting Added Location3");

				 locationsPage.NoItemsCheckInNoLocation("MEC-WF1-No items in no location");


				 locationsPage.TapOnBack("MEC-WF1-Tapped Back");
				 //yes scenario
				 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[1], "MEC-WF1-Selecting AddedLocation");

				 locationsPage.TapAddLocation("MEC-WF1-Tapped ADD");

				 setupInventoryPage.AddItemFrom_PrepItem("MIL-WF2-Tapped Prepitem");
				 setupInventoryPage.EnterItemDetails(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0], datapool.readFromExcelPrepItemInfo().prepItemDataPool[1], datapool.readFromExcelPrepItemInfo().prepItemDataPool[2],
						 datapool.readFromExcelPrepItemInfo().prepItemDataPool[3],datapool.readFromExcelPrepItemInfo().prepItemDataPool[4], datapool.readFromExcelPrepItemInfo().prepItemDataPool[5], datapool.readFromExcelPrepItemInfo().prepItemDataPool[6], "MIL-WF 1-4-NonSyscoItem details entered");
				 // prep item addition to 2 locations created 

				 locationsPage.AddLocation_AddProductDetailsPage("MEC-WF1-Select Add/Select location option");
				 locationsPage.TapAddLocation("MEC-WF1-Tapped ADD");
				 locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[4],"MEC-WF1-Enter location3 name");
				 locationsPage.AddLocationCooler("MEC-WF1-Tapped Cooler");
				 locationsPage.TapOnDone("MEC-WF1-Tapped Done");
				 locationsPage.TapOnBack("MEC-WF1-Tapped Back");
				 locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[4], "MEC-WF1-Verifing Added Location3");

				 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[4], "MEC-WF1-Selecting Added Location3");
				 locationsPage .SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[1], "MEC-WF1-Selecting Added Location1");
				 locationsPage.LocationDoneSelection("MEC-WF1-Selecting Done");
				 locationsPage.TapOnDone("MEC-WF1-Tapped Done");


				 setupInventoryPage.verifyNonSyscoPrepItemSetupInv(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0],"MEC-WF1-Verify item selected");


				 locationsPage.ProductSelect(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0] ,"MEC-WF1-Select Product");

				 locationsPage.TapOnEdit("MEC-WF1-Tapped Edit");
				 //	.LocationsDelete("MEC-WF1-Tapped delete");
				 locationsPage.LocationsDelete(datapool.readFromExcelLocationInfo().locationNameDataPool[4],"MEC-WF1-Tapped delete");
				 locationsPage.LocationsDelete(datapool.readFromExcelLocationInfo().locationNameDataPool[1],"MEC-WF1-Tapped delete");
				 locationsPage.DeleteAllLocConfirmation("MEC-WF1-Confirming deleting all locations");
				 locationsPage.TapOnYesDelete("MEC-WF1-Tapped yes for deleting all locations");
				 locationsPage.TapOnDone("MEC-WF1-Tapped Done");
				 locationsPage.TapOnBack("MEC-WF1-Tapped Back");
				 locationsPage.TapOnBack("MEC-WF1-Tapped Back");
				 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[3], "MEC-WF1-Selecting Added Location3");

				 setupInventoryPage.verifyNonSyscoPrepItemSetupInv(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0],"MEC-WF1-Verify item selected");

				 locationsPage.NoLocationTextCheck(datapool.readFromExcelLocationInfo().locationNameDataPool[3],"MEC-WF1-No location text verification");



				 ;
	 }

	 
	  * Validating user is able to setup inventory.
	  * Validating Creating, editing and deleting category
	  * Prerequisite:Normal/MA User with OG items
	  * 
	  

	 @Test(groups={"MEC - WF 2"},priority=34, description = "MEC - WF 2-Creating, editing and deleting category ")
	 public void MEC_WF2_Category_Create_Edit_Delete_Category() throws Exception {	

		 user=1;

		 loginPage.verifyLoginPage("MEC-WF 2LoginPage");
		 loginPage.saveUsernameCheckBoxclickElement("MEC-WF 2-save username");	
		 loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"MEC-WF 2-Login");	
		 homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"MEC-WF 2-Clicked account");
		 accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"MEC-WF 2-FirstAccountSelect");
		 inventoryToolPage.InvTools_SetUpInventory("MEC-WF 2-SetupInventoryTap");
		 setupInventoryPage.TapOnSkip("MEC-WF 2-Skip1 Tapped");
		 setupInventoryPage.TapOrderGuide("MEC-WF 2-OG Selected");
		 setupInventoryPage.tapContinue("MEC-WF 2-Tapped Continue");
		 locationsPage.DefaultLocation("MEC-WF 2-Tapped Custom location");
		 locationsPage.tapContinue("MEC-WF 2-Tapped Continue");
		 setupInventoryPage.TapOnDOThisLater("MEC-WF 2 Do this Later for category Tapped");
		 setupInventoryPage.TapTakeHome("MEC-WF 2-Cotinue2 Tapped"); 


		 inventoryToolPage.InvTools_Category("MEC-WF 2-Expense Category Tap");

		 categoryPage.TapAdd("MEC-WF 2-Add Expense Category Tap");
		 categoryPage.AddCategoryName(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "MEC-WF 2-Enter Category Name");
		 categoryPage.AddLocationCooler("MEC-WF 2-Enter type Cooler");
		 categoryPage.TapOnDone("MEC-WF 2-Tapped Done");
		 categoryPage.TapOnBack("MEC-WF 2-Tapped Back");
		 categoryPage.VerifyCategoryList(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "MEC-WF 2-Verifying added category list");

		 categoryPage.SelectCategory(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "MEC-WF 2-Selecting Category");
		 categoryPage.TapOnEdit("MEC-WF 2-Tap on Edit");
		 categoryPage.AddLocationCooler("MEC-WF 2-Enter type Cooler");
		 categoryPage.AddCategoryName(datapool.readFromExcelCategoryInfo().categoryNameDataPool[2], "MEC-WF 2-Entering new name");
		 categoryPage.TapOnDone("MEC-WF 2-Tapped Done");
		 categoryPage.TapOnBack("MEC-WF 2-Tapped Back");
		 categoryPage.VerifyCategoryList(datapool.readFromExcelCategoryInfo().categoryNameDataPool[2], "MEC-WF 2-Verifying edited category list");

		 categoryPage.SelectCategory(datapool.readFromExcelCategoryInfo().categoryNameDataPool[2], "MEC-WF 2-Selecting Category");
		 categoryPage.TapOnDeleteCategory("MEC-WF 2-Deleting Category");
		 categoryPage.TapOnYesDelete("MEC-WF 2-Tap on Yes Delete");
		 categoryPage.VerifyDeletedCategoryList(datapool.readFromExcelCategoryInfo().categoryNameDataPool[2], "MEC-WF 2-Verifying Deleted category list");
		 ;
	 }	

	 
	  * Validating user is able to add purchase and Food cost
	  


	 @Test(groups={"MP-WF1"},priority=35, description = "MP - WF 1-Purchases-FoodCost")
	 public void MP_WF1_Purchases_FoodCost() throws Exception
	 {
		 LoginData loginData =LoginData.fetch("LoginData7");
			LocationsData locDataCooler=LocationsData.fetch("LocatiosData5");
			LocationsData locDataFreezer=LocationsData.fetch("LocatiosData6");
			LocationsData locDataDry=LocationsData.fetch("LocatiosData7");
			UOMQuantityData uomQuantityData=UOMQuantityData.fetch("UOMQuantityData");
			UOMQuantityData uomQuantityData3=UOMQuantityData.fetch("UOMQuantityData3");
			VendorDetailsData vendorData=VendorDetailsData.fetch("VendorDetailData1");
			PurchasesData purchasesData=PurchasesData.fetch("PurchasesData");
		  	
		 user=12;

		 loginPage.verifyLoginPage("MP-WF 1 LoginPage");
		 loginPage.saveUsernameCheckBoxclickElement("MP-WF 1-save username");	
		 loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"MP-WF 1-Login");	
		 homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"MP-WF 1-Clicked account");
		 accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"MP-WF 1-FirstAccountSelect");


		 inventoryToolPage.InvTools_SetUpInventory("SI - WF 1-SetupInventoryTap");


		 setupInventoryPage.TapOnSkip("SI - WF 1-Skip1 Tapped");

		 setupInventoryPage.TapOrderGuide("SI - WF 1-OG Selected");
		 setupInventoryPage.tapContinue("SI - WF 1-Tapped Continue");



		 locationsPage.DefaultLocation("SI - WF 1-Tapped Custom location");
		 locationsPage.tapContinue("SI - WF 1-Tapped Continue");



		 categoryPage.defaultCategories("SI - WF 1-Tapped Default category");
		 categoryPage.tapComplete("SI - WF 1-Tapped Complete");


		 setupInventoryPage.TapTakeHome("SI - WF 1-Tapped take me home");   


		 inventoryToolPage.InvTools_TrackInventory("SI - WF 1-Selected track inventory");


		 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[6], "SI - WF 1-Selected cooler");
		 locationsPage.ProductQtyEnter(datapool.readFromExcelUOMQuantityInfo().uomQuantityDataPool[0],"TI-WF1-WF2-Entering Quantity1");
		 locationsPage.UomEnterOZ(datapool.readFromExcelUOMQuantityInfo().uomQuantityDataPool[1], "TI-WF1-WF2-Entering Uom unit OZ");
		 locationsPage.TapOnDone("TI-WF1-WF2-Tapped done");
		 locationsPage.TapOnBack("SI - WF 1-Tapped on Back");


		 inventoryToolPage.InvTools_CloseInventory("Tapped close inventory");
		 inventoryToolPage.InvTools_ClosedInventoryYes("Tapped Yes,Close");
		 inventoryToolPage.InvTools_CloseInventory("Tapped close inventory");
		 inventoryToolPage.InvTools_ClosedInventoryYes("Tapped Yes,Close");
		 inventoryToolPage.InvTools_TrackInventory("SI - WF 1-Selected track inventory");

		 locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[7], "SI - WF 1-Selected cooler");
		 locationsPage.ProductQtyEnter(datapool.readFromExcelUOMQuantityInfo().uomQuantityDataPool[4],"TI-WF1-WF2-Entering Quantity1");
		 locationsPage.UomEnterOZ(datapool.readFromExcelUOMQuantityInfo().uomQuantityDataPool[5], "TI-WF1-WF2-Entering Uom unit OZ");
		 locationsPage.TapOnDone("TI-WF1-WF2-Tapped done");
		 locationsPage.TapOnBack("SI - WF 1-Tapped on Back");


		 inventoryToolPage.InvTools_Suppliers("MSP-1,MSP-2-Tapped on suppliers");

		 vendorPage.Add_Supplier("MSP-1,MSP-2-Add button clicked");
		 vendorPage.AddSupplier_Details(datapool.readFromExcelSupplier1Info().supplier1DataPool[0], datapool.readFromExcelSupplier1Info().supplier1DataPool[1], datapool.readFromExcelSupplier1Info().supplier1DataPool[2],
					datapool.readFromExcelSupplier1Info().supplier1DataPool[3], datapool.readFromExcelSupplier1Info().supplier1DataPool[4], datapool.readFromExcelSupplier1Info().supplier1DataPool[5], "MIL-WF1-WF4-AddVendorDetails");
		 vendorPage.TapOnDone("MSP-1,MSP-2-Done tapped");
		 vendorPage.TapOnBack("MSP-1,MSP-2-Back tapped");
		 vendorPage.TapOnBack("MSP-1,MSP-2-Back tapped");


		 inventoryToolPage.InvTools_Purchases("Tapped on purchase");


		 purchasespage.AddPurchases("Tapped on Add purchase");
		 purchasespage.SupplierSelect("Selected supplier");
		 purchasespage.DateSelect(datapool.readFromExcelPurchasesInfo().purchasesDataPool[8],datapool.readFromExcelPurchasesInfo().purchasesDataPool[9],datapool.readFromExcelPurchasesInfo().purchasesDataPool[10],"Date selected");
		 purchasespage.PurchaseDetails(datapool.readFromExcelPurchasesInfo().purchasesDataPool[0],datapool.readFromExcelPurchasesInfo().purchasesDataPool[1],"Entered purchase details");
		 purchasespage.ExpenseCategorySelect(datapool.readFromExcelPurchasesInfo().purchasesDataPool[4],"Selected Food category");
		 purchasespage.EnterExpenseAmount(datapool.readFromExcelPurchasesInfo().purchasesDataPool[2], "Entered expense amount");
		 purchasespage.AddExpenseCategory("Tapped add button");
		 purchasespage.ExpenseCategorySelect(datapool.readFromExcelPurchasesInfo().purchasesDataPool[5],"Selected Non Food category");
		 purchasespage.EnterExpenseAmount(datapool.readFromExcelPurchasesInfo().purchasesDataPool[3], "Entered expense amount");
		 purchasespage.AddExpenseCategory("Tapped add button");
		 purchasespage.TapOnDone("Tapped on done");
		 purchasespage.TapNoAddingPurchase("Tapped No adding purchase");

		 vendorPage.TapOnBack("MSP-1,MSP-2-Back tapped");


		 inventoryToolPage.InvTools_CloseInventory("Tapped close inventory");
		 inventoryToolPage.InvTools_ClosedInventoryYes("Tapped Yes,Close");
		 inventoryToolPage.InvTools_FoodCost("Tapped food cost");

		
		 foodCostpage.VerifyTotalPurchase(datapool.readFromExcelPurchasesInfo().purchasesDataPool[2],"verify total purchase value");
		 foodCostpage.VerifyNetPurchases("verify net purchase value");
		 foodCostpage.VerifyCostOfGoodsSold("verify cost of goods sold value");
		 foodCostpage.EnterRevenue(datapool.readFromExcelPurchasesInfo().purchasesDataPool[6], "Entered Revenue"); 
		 foodCostpage .CalculateFoodCost("Calculated food cost");


		 ;
	 }

	 

	  
		 * Validating user is able to setup inventory.
		 * Validating Non sysco item addition through Homepage and linking supplier location and category
		 * Prerequisite:Normal/MA User with OG items
		 * 
		 
	 
	 @Test(groups={"MNS-1"},priority=36, description = "MNS-1-Manage_Create Non-Sysco Item_Link Supplier_Location_Expense Category")
		public void MNS_1_CreateNonSyscoItem_LinkSupplier_Location_Category() throws Exception {	

			  

					user=1;
			
			loginPage.verifyLoginPage("MNS-1-LoginPage");
			loginPage.saveUsernameCheckBoxclickElement("MNS-1-save username");
			loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"MNS-1-Login");
			homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"MNS-1-Clicked account");
			accountsPage.Second_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"MNS-1-FirstAccountSelect");

			inventoryToolPage.InvTools_SetUpInventory("MNS-1-SetupInventoryTap");
			setupInventoryPage.TapOnSkip("MNS-1-Tapped Skip1");
			setupInventoryPage.TapOrderGuide("MIL - WF 5-OG Selected");
			setupInventoryPage.tapContinue("MIL - WF 5-Tapped Continue1");
				
			locationsPage.DefaultLocation("SI - WF 1-Tapped Custom location");
			locationsPage.tapContinue("SI - WF 1-Tapped Continue");
			
			setupInventoryPage.TapOnDOThisLater("MIL-WF6-Tapped do this later");
			setupInventoryPage.TapTakeHome("SI - WF 32-Tapped take me home")  ;

			inventoryToolPage.InvTools_CreateNonSysco("MNS-1-Tapped Nonsysco item");
			setupInventoryPage.EnterItemDetails(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[1], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[2],datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[3], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[4], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[5], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[6], "MNS-1-NonSyscoItem details entered");

			//linking supplier
			setupInventoryPage.AddSupplier_AddProductDetailsPage("MNS-1-Select supplier");
			vendorPage.Add_Supplier("MNS-1-AddVendorTap");
			vendorPage.AddSupplier_Details(datapool.readFromExcelSupplier1Info().supplier1DataPool[0],datapool.readFromExcelUserInfo().supplier1DataPool[1], datapool.readFromExcelSupplier1Info().supplier1DataPool[2], datapool.readFromExcelSupplier1Info().supplier1DataPool[3], datapool.readFromExcelSupplier1Info().supplier1DataPool[4], datapool.readFromExcelSupplier1Info().supplier1DataPool[5], "MSP-1,MSP-2-Entered vendor details to be cancelled vendor details");
			
			vendorPage.TapOnDone("MNS-1-Supplier added");
			vendorPage.TapOnBack("MNS-1-Tapped Back1");
			vendorPage.SupplierSelect(datapool.readFromExcelSupplier1Info().supplier1DataPool[0],"MNS-1-SupplierSelect");

			//linking location
			locationsPage.AddLocation_AddProductDetailsPage("MNS-1-Select Add/Select location option");
			locationsPage.TapAddLocation("MNS-1-Tapped ADD Location");
			locationsPage.AddLocationName( datapool.readFromExcelLocationInfo().locationNameDataPool[1],"MNS-1-Enter location name");
			locationsPage.AddLocationCooler("MNS-1-Tapped Cooler");
			locationsPage.TapOnDone("MNS-1-Tapped Done4");
			locationsPage.TapOnBack("MNS-1-Tapped Back2");
			locationsPage.VerifyLocationList( datapool.readFromExcelLocationInfo().locationNameDataPool[1], "MNS-1-Verifing Added Location");
			locationsPage.SelectLocation( datapool.readFromExcelLocationInfo().locationNameDataPool[1], "MNS-1-Selecting Added Location");
			locationsPage.LocationDoneSelection("MNS-1-Selecting Done");

			//linking category
			locationsPage.AddCategory_AddProductDetailsPage("MNS-1-Tapped CategorySelect");
			categoryPage.TapAdd("MNS-1-Tapped Add category");
			categoryPage.AddCategoryName(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "MNS-1-Enter Category Name");
			categoryPage.AddCategoryFood("MNS-1-Enter type food");
			categoryPage.TapOnDone("MNS-1-Tapped Done5");
			categoryPage.TapOnBack("MNS-1-Tapped Back3");
			categoryPage.SelectCategory(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "MNS-1-Select Category Name");

			categoryPage.TapOnDone("MNS-1-Tapped Done,Nonsyscoitem added") ;
			inventoryToolPage.InvTools_TrackInventory("MNS-1-Selected track inventory");
			locationsPage.SelectLocation( datapool.readFromExcelLocationInfo().locationNameDataPool[1], "MNS-1-Select added location");

			setupInventoryPage.verifyNonSyscoPrepItemSetupInv(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0],"MNS-1-Verify nonsysco item added");
			locationsPage.NonSyscoPrepCategoryIdentify(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0],datapool.readFromExcelPrepItemInfo().prepItemDataPool[0],"MNS-1-Category idenitification for nonsysco");
			categoryPage.VerifyNonSycoCustomCategory(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "MNS-1-Category verification");
			
			locationsPage.ProductSelect(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0], "MIL-WF10-Product select");
			locationsPage.TapOnEdit("MIL-WF10-Tap on edit");
			
			
			setupInventoryPage.EnterItemDetails( datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[7],  datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[8],  datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[9],  datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[10],  datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[11], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[12],  datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[13], "MIL-WF10-NonSyscoItem details entered");
			setupInventoryPage.AddSupplier_AddProductDetailsPage("MIL-WF10-select supplier");

			vendorPage.Add_Supplier("MIL-WF10-AddVendorTap");
			vendorPage.AddSupplier_Details(datapool.readFromExcelSupplier2Info().supplier2DataPool[0], datapool.readFromExcelSupplier2Info().supplier2DataPool[1], datapool.readFromExcelSupplier2Info().supplier2DataPool[2], datapool.readFromExcelSupplier2Info().supplier2DataPool[3], datapool.readFromExcelSupplier2Info().supplier2DataPool[4], datapool.readFromExcelSupplier2Info().supplier2DataPool[5], "MIL-WF10-AddVendorDetails");
			vendorPage.TapOnDone("MIL-WF10-Done");
			vendorPage.TapOnBack("MIL-WF10-Back");
			vendorPage.SupplierSelect(datapool.readFromExcelSupplier2Info().supplier2DataPool[0],"MIL-WF10-SupplierSelect");
			
			locationsPage.AddLocation_AddProductDetailsPage("MIL-WF10-Select Add/Select location option");
			locationsPage.TapAddLocation("MIL-WF10-Tapped ADD");
			locationsPage.AddLocationName( datapool.readFromExcelLocationInfo().locationNameDataPool[2],"MIL-WF10-Enter location2 name");
			locationsPage.AddCatFood("MIL-WF10-Tapped Food");
			locationsPage.TapOnDone("MIL-WF10-Tapped Done");
			locationsPage.TapOnBack("MIL-WF10-Tapped Back");
			locationsPage.VerifyLocationList( datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MIL-WF10-Verifing Added Location2");

			locationsPage.SelectLocation( datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MIL-WF10-Selecting Added Location2");
			locationsPage.SelectLocation( datapool.readFromExcelLocationInfo().locationNameDataPool[1], "MIL-WF2-Selecting Added Location2") ;    //not preselected
			locationsPage.LocationDoneSelection("MIL-WF10-Selecting Done");
			locationsPage.TapOnDone("MIL-WF10-Tapped Done");
			
			locationsPage.TapOnBack("MIL-WF10-Tapped Back");
			locationsPage.SelectLocation( datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MIL-WF10-Selecting Added Location2");
			setupInventoryPage.verifyNonSyscoPrepItemSetupInv( datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[7],"MIL-WF10-Verify nonsysco item added");
			
		}
			
			
			 

	@Test(groups={"MNS-1-1"},priority=36, description = "MNS-1-Manage_Create Non-Sysco Item_Link Supplier_Location_Expense Category")
	public void MNS_1_1_CreateNonSyscoItem_LinkSupplier_Location_Category() throws Exception {	

		  
user=2;
		
		loginPage.verifyLoginPage("MNS-1-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("MNS-1-save username");
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"MNS-1-Login");
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"MNS-1-Clicked account");
		accountsPage.Second_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"MNS-1-FirstAccountSelect");
	
		inventoryToolPage.InvTools_SetUpInventory("MNS-1-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("MNS-1-Tapped Skip1");
		setupInventoryPage.TapOrderGuide("MIL - WF 5-OG Selected");
		setupInventoryPage.tapContinue("MIL - WF 5-Tapped Continue1");
			
		locationsPage.DefaultLocation("SI - WF 1-Tapped Custom location");
		locationsPage.tapContinue("SI - WF 1-Tapped Continue");
		
		setupInventoryPage.TapOnDOThisLater("MIL-WF6-Tapped do this later");
		setupInventoryPage.TapTakeHome("SI - WF 32-Tapped take me home")  ;
		
		
		
		//create supplier 2
				inventoryToolPage.InvTools_Suppliers("MSP-1,MSP-2-Tapped on suppliers");
				
				vendorPage.verifySupplierPage("MSP-1,MSP-2-Supplier page verified");
				vendorPage.Add_Supplier("MSP-1,MSP-2-Add button clicked");
				vendorPage.AddSupplier_Details(datapool.readFromExcelSupplier2Info().supplier2DataPool[0], datapool.readFromExcelSupplier2Info().supplier2DataPool[1], datapool.readFromExcelSupplier2Info().supplier2DataPool[2], datapool.readFromExcelSupplier2Info().supplier2DataPool[3], datapool.readFromExcelSupplier2Info().supplier2DataPool[4], datapool.readFromExcelSupplier2Info().supplier2DataPool[5], "MSP-1,MSP-2-Vendor details added");
				vendorPage.TapOnDone("MSP-1,MSP-2-Done tapped");
				vendorPage.TapOnBack("MSP-1,MSP-2-Back tapped");
				vendorPage.TapOnBack("MSP-1,MSP-2-Back tapped");
				
				//create category 1
				 inventoryToolPage.InvTools_Category("MEC-WF 2-Expense Category Tap");

				 categoryPage.TapAdd("MEC-WF 2-Add Expense Category Tap");
				 categoryPage.AddCategoryName(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "MEC-WF 2-Enter Category Name");
				 categoryPage.AddCategoryFood("MEC-WF 2-Enter type food");
				 categoryPage.TapOnDone("MEC-WF 2-Tapped Done");
				 categoryPage.TapOnBack("MEC-WF 2-Tapped Back");
				 categoryPage.VerifyCategoryList(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "MEC-WF 2-Verifying added category list");
				 categoryPage.TapOnBack("MEC-WF 2-Tapped Back");
				
				//Non sysco pdt card page
					inventoryToolPage.InvTools_CreateNonSysco("MNS-1-Tapped Nonsysco item");
					setupInventoryPage.EnterItemDetails(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[1], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[2],datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[3], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[4], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[5], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[6], "MNS-1-NonSyscoItem details entered");
					
					setupInventoryPage.SelectSupplier_PdtCard(datapool.readFromExcelSupplier2Info().supplier2DataPool[2], "Supplier selected");
					
					
					setupInventoryPage.SelectCategory_PdtCard(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "Category selected");
					
					setupInventoryPage.TapOnDone("MNS-1-Tapped Done,Nonsyscoitem added");
					setupInventoryPage.TapTakeHome("SI - WF 32-Tapped take me home")  ;
					inventoryToolPage.InvTools_TrackInventory("MNS-1-Selected track inventory");
					locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[5], "SI - WF 1-Selected No Location");
					setupInventoryPage.verifyNonSyscoPrepItemSetupInv( datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0],"MIL-WF10-Verify nonsysco item added");
					
					
					

	}

	@Test(groups={"MNS-1-3"},priority=36, description = "MNS-1-Manage_Create Non-Sysco Item_Link Supplier_Location_Expense Category")
	public void MNS_1_3_CreateNonSyscoItem_LinkSupplier_Location_Category() throws Exception {	

		  
        user=1;
		
		loginPage.verifyLoginPage("MNS-1-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("MNS-1-save username");
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"MNS-1-Login");
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"MNS-1-Clicked account");
		accountsPage.Second_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"MNS-1-FirstAccountSelect");
	
		inventoryToolPage.InvTools_SetUpInventory("MNS-1-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("MNS-1-Tapped Skip1");
		setupInventoryPage.TapOrderGuide("MIL - WF 5-OG Selected");
		setupInventoryPage.tapContinue("MIL - WF 5-Tapped Continue1");
			
		locationsPage.DefaultLocation("SI - WF 1-Tapped Custom location");
		locationsPage.tapContinue("SI - WF 1-Tapped Continue");
		
		setupInventoryPage.TapOnDOThisLater("MIL-WF6-Tapped do this later");
		setupInventoryPage.TapTakeHome("SI - WF 32-Tapped take me home")  ;
		
		
		
		//create supplier 2
				inventoryToolPage.InvTools_Suppliers("MSP-1,MSP-2-Tapped on suppliers");
				
				vendorPage.verifySupplierPage("MSP-1,MSP-2-Supplier page verified");
				vendorPage.Add_Supplier("MSP-1,MSP-2-Add button clicked");
				vendorPage.AddSupplier_Details(datapool.readFromExcelSupplier2Info().supplier2DataPool[0], datapool.readFromExcelSupplier2Info().supplier2DataPool[1], datapool.readFromExcelSupplier2Info().supplier2DataPool[2], datapool.readFromExcelSupplier2Info().supplier2DataPool[3], datapool.readFromExcelSupplier2Info().supplier2DataPool[4], datapool.readFromExcelSupplier2Info().supplier2DataPool[5], "MSP-1,MSP-2-Vendor details added");
				vendorPage.TapOnDone("MSP-1,MSP-2-Done tapped");
				vendorPage.TapOnBack("MSP-1,MSP-2-Back tapped");
				vendorPage.TapOnBack("MSP-1,MSP-2-Back tapped");
				
				//create category 1
				 inventoryToolPage.InvTools_Category("MEC-WF 2-Expense Category Tap");

				 categoryPage.TapAdd("MEC-WF 2-Add Expense Category Tap");
				 categoryPage.AddCategoryName(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "MEC-WF 2-Enter Category Name");
				 categoryPage.AddCategoryFood("MEC-WF 2-Enter type food");
				 categoryPage.TapOnDone("MEC-WF 2-Tapped Done");
				 categoryPage.TapOnBack("MEC-WF 2-Tapped Back");
				 categoryPage.VerifyCategoryList(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "MEC-WF 2-Verifying added category list");
				 categoryPage.TapOnBack("MEC-WF 2-Tapped Back");
				
				//Non sysco pdt card page
					inventoryToolPage.InvTools_CreateNonSysco("MNS-1-Tapped Nonsysco item");
					setupInventoryPage.EnterItemDetails(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[1], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[2],datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[3], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[4], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[5], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[6], "MNS-1-NonSyscoItem details entered");
					
					setupInventoryPage.SelectSupplier_PdtCard(datapool.readFromExcelSupplier2Info().supplier2DataPool[0], "Supplier selected");
					
					
					setupInventoryPage.SelectCategory_PdtCard(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "Category selected");
					
					setupInventoryPage.TapOnCancel("MNS-1-Tapped Done,Nonsyscoitem is not added");
					inventoryToolPage.InvTools_TrackInventory("MNS-1-Selected track inventory");
					locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[5], "SI - WF 1-Selected No Location");
					setupInventoryPage.verifyNonSyscoPrepItemSetupInv( datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0],"MIL-WF10-Verify nonsysco item added");
					
					
	}
	
	
	@Test(groups={"MNS-1-2"},priority=36, description = "MNS-1-Manage_Create Non-Sysco Item_Link Supplier_Location_Expense Category")
	public void MNS_1_2_CreateNonSyscoItem_LinkSupplier_Location_Category() throws Exception {	

		  
		user=15;

		loginPage.verifyLoginPage("SI - WF 4-LoginPage");
		loginPage.saveUsernameCheckBoxclickElement("SI - WF 4-save username");	
		loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 4-Login");	
		homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"Clicked account");
		accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 4-FirstAccountSelect");
		inventoryToolPage.InvTools_SetUpInventory("SI - WF 4-SetupInventoryTap");
		setupInventoryPage.TapOnSkip("SI - WF 4-Skip1 Tapped");
		setupInventoryPage.TapOrderGuide("SI - WF 4-OG Selected");
		setupInventoryPage.tapContinue("SI - WF 4-Tapped Continue");
		locationsPage.DefaultLocation("SI - WF 4-Tapped Custom location");
		locationsPage.tapContinue("SI - WF 4-Tapped Continue");
		categoryPage.CustomCategories("SI - WF 4-CustomCategories Tapped");
		categoryPage.tapContinue("SI - WF 4-Tapped Continue3");
		categoryPage.CreateTwoExpenseCategory(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], datapool.readFromExcelCategoryInfo().categoryNameDataPool[2], "SI - WF 4-CreateTwoExpenseCategory");
		categoryPage.TapOnNext("SI - WF 4-Tapped Next3");
		categoryPage.selectMultipleItemsFromCategory1("SI - WF 4-selectMultipleItemsFromCategory1");
		categoryPage.TapOnNext("SI - WF 4-Tapped Next4");
		categoryPage.selectMultipleItemsFromCategory2("SI - WF 4-selectMultipleItemsFromCategory2");
		setupInventoryPage.TapOnDone("SI - WF 4-Tapped Done2");
		setupInventoryPage.TapTakeHome("SI - WF 4-Tapped Continue4") ;
		inventoryToolPage.InvTools_Locations("SI-WF4-Selected Locations");
		locationsPage.VerifyOrderOfLocations(datapool.readFromExcelLocationInfo().locationNameDataPool[6], datapool.readFromExcelUserInfo().locationNameDataPool[7], datapool.readFromExcelUserInfo().locationNameDataPool[8], datapool.readFromExcelUserInfo().locationNameDataPool[5], "SI-WF4-Verified order of locations");
		locationsPage.TapOnBack("SI-WF4-Tapped Back");
		
		
		//create supplier 2
				inventoryToolPage.InvTools_Suppliers("MSP-1,MSP-2-Tapped on suppliers");
				
				vendorPage.verifySupplierPage("MSP-1,MSP-2-Supplier page verified");
				vendorPage.Add_Supplier("MSP-1,MSP-2-Add button clicked");
				vendorPage.AddSupplier_Details(datapool.readFromExcelSupplier2Info().supplier2DataPool[0], datapool.readFromExcelSupplier2Info().supplier2DataPool[1], datapool.readFromExcelSupplier2Info().supplier2DataPool[2], datapool.readFromExcelSupplier2Info().supplier2DataPool[3], datapool.readFromExcelSupplier2Info().supplier2DataPool[4], datapool.readFromExcelSupplier2Info().supplier2DataPool[5], "MSP-1,MSP-2-Vendor details added");
				vendorPage.TapOnDone("MSP-1,MSP-2-Done tapped");
				vendorPage.TapOnBack("MSP-1,MSP-2-Back tapped");
				vendorPage.TapOnBack("MSP-1,MSP-2-Back tapped");
				
				//create category 1
				 inventoryToolPage.InvTools_Category("MEC-WF 2-Expense Category Tap");

				 categoryPage.TapAdd("MEC-WF 2-Add Expense Category Tap");
				 categoryPage.AddCategoryName(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "MEC-WF 2-Enter Category Name");
				 categoryPage.AddCategoryFood("MEC-WF 2-Enter type food");
				 categoryPage.TapOnDone("MEC-WF 2-Tapped Done");
				 categoryPage.TapOnBack("MEC-WF 2-Tapped Back");
				 categoryPage.VerifyCategoryList(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "MEC-WF 2-Verifying added category list");
				 categoryPage.TapOnBack("MEC-WF 2-Tapped Back");
				
				//Non sysco pdt card page
					inventoryToolPage.InvTools_CreateNonSysco("MNS-1-Tapped Nonsysco item");
					setupInventoryPage.EnterItemDetails(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[1], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[2],datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[3], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[4], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[5], datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[6], "MNS-1-NonSyscoItem details entered");
					
					setupInventoryPage.SelectSupplier_PdtCard(datapool.readFromExcelSupplier2Info().supplier2DataPool[0], "Supplier selected");
					
					
					setupInventoryPage.SelectCategory_PdtCard(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "Category selected");
					
					setupInventoryPage.TapOnDone("MNS-1-Tapped Done,Nonsyscoitem added");
					inventoryToolPage.InvTools_TrackInventory("MNS-1-Selected track inventory");
					locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[5], "SI - WF 1-Selected No Location");
					setupInventoryPage.verifyNonSyscoPrepItemSetupInv( datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0],"MIL-WF10-Verify nonsysco item added");
					
					
					

	}
	
	
		 
		 * Validating user is able to setup inventory.
		 * Validating Prep item addition through Homepage and linking supplier location and category
		 * Prerequisite:Normal/MA User with OG items
		 * 
		 

		@Test(groups={"MPI-1"},priority=37, description = "MPI-1-Manage_Create Prep Item_LinkLocation_Expense Category")
		public void MPI_1_CreatePrepItem_LinkLocation_Category_NU() throws Exception {	

		user=1;
			
			
			loginPage.verifyLoginPage("MPI-1-LoginPage");
			loginPage.saveUsernameCheckBoxclickElement("MPI-1-save username");
			loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"MPI-1-Login");
			homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"MPI-1-Clicked account");
			accountsPage.Third_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"MPI-1-FirstAccountSelect");

			inventoryToolPage.InvTools_SetUpInventory("MPI-1-SetupInventoryTap");
			setupInventoryPage.TapOnSkip("MPI-1-Tapped Skip1");
			setupInventoryPage.TapOrderGuide("MIL - WF 5-OG Selected");
			setupInventoryPage.tapContinue("MIL - WF 5-Tapped Continue1");
			
			locationsPage.DefaultLocation("SI - WF 1-Tapped Custom location");
			locationsPage.tapContinue("SI - WF 1-Tapped Continue");
			
			setupInventoryPage.TapOnDOThisLater("MIL-WF6-Tapped do this later");
			setupInventoryPage.TapTakeHome("SI - WF 32-Tapped take me home");
			
			inventoryToolPage.InvTools_CreatePrep("MPI-1-Tapped Prep item");
			setupInventoryPage.EnterItemDetails(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0], datapool.readFromExcelPrepItemInfo().prepItemDataPool[1], datapool.readFromExcelPrepItemInfo().prepItemDataPool[2],datapool.readFromExcelPrepItemInfo().prepItemDataPool[3], datapool.readFromExcelUserInfo().prepItemDataPool[4], datapool.readFromExcelPrepItemInfo().prepItemDataPool[5], datapool.readFromExcelPrepItemInfo().prepItemDataPool[6], "MPI-1-PrepItem details entered");

			//linking location
			locationsPage.AddLocation_AddProductDetailsPage("MPI-1-Select Add/Select location option");
			locationsPage.TapAddLocation("MPI-1-Tapped ADD Location");
			locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[1],"MPI-1-Enter location name");
			locationsPage.AddLocationCooler("MPI-1-Tapped Cooler");
			locationsPage.TapOnDone("MPI-1-Tapped Done3");
			locationsPage.TapOnBack("MPI-1-Tapped Back1");
			locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[1], "MPI-1-Verifing Added Location");
			locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[1], "MPI-1-Selecting Added Location");
			locationsPage.LocationDoneSelection("MPI-1-Selecting Done");

			//linking category
			
			locationsPage.AddCategory_AddProductDetailsPage("MPI-1-Tapped CategorySelect");
			categoryPage.TapAdd("MPI-1-Tapped Add category");
			categoryPage.AddCategoryName(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "MPI-1-Enter Category Name");
			categoryPage.AddLocationCooler("MPI-1-Enter type Cooler");
			categoryPage.TapOnDone("MPI-1-Tapped Done4");
			categoryPage.TapOnBack("MPI-1-Tapped Back2");
			categoryPage.SelectCategory(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "MPI-1-Select Category Name");
			categoryPage.TapOnDone("MPI-1-Tapped Done,Prepitem added") ;

			inventoryToolPage.InvTools_TrackInventory("MPI-1-Selected track inventory");
			locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[1], "MPI-1-Select added location");
			setupInventoryPage.verifyNonSyscoPrepItemSetupInv(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0],"MPI-1-Verify Prep item added");
			locationsPage.NonSyscoPrepCategoryIdentify(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0],datapool.readFromExcelPrepItemInfo().prepItemDataPool[0],"MPI-1-Category idenitification for Prepitem");
			categoryPage.VerifyPrepCustomCategory(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "MPI-1-Category verification");
			
			locationsPage.ProductSelect(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0], "MNS-1-Product select");
			locationsPage.TapOnEdit("MNS-1-Tap on edit");
				
			setupInventoryPage.EnterItemDetails(datapool.readFromExcelPrepItemInfo().prepItemDataPool[7], datapool.readFromExcelPrepItemInfo().prepItemDataPool[8], datapool.readFromExcelPrepItemInfo().prepItemDataPool[9],datapool.readFromExcelPrepItemInfo().prepItemDataPool[10], datapool.readFromExcelPrepItemInfo().prepItemDataPool[11], datapool.readFromExcelPrepItemInfo().prepItemDataPool[12], datapool.readFromExcelPrepItemInfo().prepItemDataPool[13], "MNS-1-PrepItem details entered");
			locationsPage.AddLocation_AddProductDetailsPage("MIL-WF10-Select Add/Select location option");
			locationsPage.TapAddLocation("MIL-WF10-Tapped ADD");
			locationsPage.AddLocationName(datapool.readFromExcelLocationInfo().locationNameDataPool[2],"MIL-WF10-Enter location2 name");
			locationsPage.AddLocationCooler("MIL-WF10-Tapped Cooler");
			locationsPage.TapOnDone("MIL-WF10-Tapped Done");
			locationsPage.TapOnBack("MIL-WF10-Tapped Back");
			locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MIL-WF10-Verifing Added Location2");

			locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MIL-WF10-Selecting Added Location2");
			locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[1], "MIL-WF2-Selecting Added Location2");     //not preselected
			locationsPage.LocationDoneSelection("MIL-WF10-Selecting Done");
			locationsPage.TapOnDone("MIL-WF10-Tapped Done");
			
			locationsPage.TapOnBack("MIL-WF10-Tapped Back");
			locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MIL-WF10-Selecting Added Location2");
			setupInventoryPage.verifyNonSyscoPrepItemSetupInv(datapool.readFromExcelPrepItemInfo().prepItemDataPool[7],"MIL-WF10-Verify nonsysco item added");
			
			;
		}
		
		@Test(groups={"MPI-2"},priority=37, description = "MPI-1-Manage_Create Prep Item_LinkLocation_Expense Category")
		public void MPI_2_CreatePrepItem_LinkLocation_Category_NU() throws Exception {	

		user=1;
			
			
			loginPage.verifyLoginPage("MPI-1-LoginPage");
			loginPage.saveUsernameCheckBoxclickElement("MPI-1-save username");
			loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"MPI-1-Login");
			homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"MPI-1-Clicked account");
			accountsPage.Third_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"MPI-1-FirstAccountSelect");

			inventoryToolPage.InvTools_SetUpInventory("MPI-1-SetupInventoryTap");
			setupInventoryPage.TapOnSkip("MPI-1-Tapped Skip1");
			setupInventoryPage.TapOrderGuide("MIL - WF 5-OG Selected");
			setupInventoryPage.tapContinue("MIL - WF 5-Tapped Continue1");
			
			locationsPage.DefaultLocation("SI - WF 1-Tapped Custom location");
			locationsPage.tapContinue("SI - WF 1-Tapped Continue");
			
			setupInventoryPage.TapOnDOThisLater("MIL-WF6-Tapped do this later");
			setupInventoryPage.TapTakeHome("SI - WF 32-Tapped take me home");
			

			//create category 1
			 inventoryToolPage.InvTools_Category("MEC-WF 2-Expense Category Tap");

			 categoryPage.TapAdd("MEC-WF 2-Add Expense Category Tap");
			 categoryPage.AddCategoryName(datapool.readFromExcelCategoryInfo().categoryNameDataPool[2], "MEC-WF 2-Enter Category Name");
			 categoryPage.AddCategoryFood("MEC-WF 2-Enter type food");
			 categoryPage.TapOnDone("MEC-WF 2-Tapped Done");
			 categoryPage.TapOnBack("MEC-WF 2-Tapped Back");
			 categoryPage.VerifyCategoryList(datapool.readFromExcelCategoryInfo().categoryNameDataPool[2], "MEC-WF 2-Verifying added category list");
			 categoryPage.TapOnBack("MEC-WF 2-Tapped Back");
			
			inventoryToolPage.InvTools_CreatePrep("MPI-1-Tapped Prep item");
			setupInventoryPage.EnterItemDetails(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0], datapool.readFromExcelPrepItemInfo().prepItemDataPool[1], datapool.readFromExcelPrepItemInfo().prepItemDataPool[2],datapool.readFromExcelPrepItemInfo().prepItemDataPool[3], datapool.readFromExcelUserInfo().prepItemDataPool[4], datapool.readFromExcelPrepItemInfo().prepItemDataPool[5], datapool.readFromExcelPrepItemInfo().prepItemDataPool[6], "MPI-1-PrepItem details entered");

			
			//linking category

			setupInventoryPage.SelectCategory_PdtCard(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "Category selected");
			
			//setupInventoryPage.TapOnDone("MNS-1-Tapped Done,Nonsyscoitem added");
			//inventoryToolPage.InvTools_TrackInventory("MNS-1-Selected track inventory");
			//locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[5], "SI - WF 1-Selected No Location");

			//locationsPage.VerifyItemsOnDefaultLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[6], "SI - WF 1-Verified cooler");
			
			
			
			//linking location
			locationsPage.AddLocation_AddProductDetailsPage("MPI-1-Select Add/Select location option");
			locationsPage.TapAddLocation("MPI-1-Tapped ADD Location");
			locationsPage.AddLocName(datapool.readFromExcelLocationInfo().locationNameDataPool[6],"MPI-1-Added location name");
			//locationsPage.AddLocationCooler("MPI-1-Tapped Cooler");
			locationsPage.TapOnDone("MPI-1-Tapped Done3");
			locationsPage.TapOnBack("MPI-1-Tapped Back1");
			//locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[1], "MPI-1-Verifing Added Location");
			//locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[1], "MPI-1-Selecting Added Location");
			//locationsPage.LocationDoneSelection("MPI-1-Selecting Done");


			inventoryToolPage.InvTools_TrackInventory("MPI-1-Selected track inventory");
			//locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[1], "MPI-1-Select added location");
			//setupInventoryPage.verifyNonSyscoPrepItemSetupInv(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0],"MPI-1-Verify Prep item added");
			//locationsPage.NonSyscoPrepCategoryIdentify(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0],datapool.readFromExcelPrepItemInfo().prepItemDataPool[0],"MPI-1-Category idenitification for Prepitem");
			//categoryPage.VerifyPrepCustomCategory(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "MPI-1-Category verification");
			
			locationsPage.ProductSelect(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0], "MNS-1-Product select");
			locationsPage.TapOnEdit("MNS-1-Tap on edit");
				
			setupInventoryPage.EnterItemDetails(datapool.readFromExcelPrepItemInfo().prepItemDataPool[7], datapool.readFromExcelPrepItemInfo().prepItemDataPool[8], datapool.readFromExcelPrepItemInfo().prepItemDataPool[9],datapool.readFromExcelPrepItemInfo().prepItemDataPool[10], datapool.readFromExcelPrepItemInfo().prepItemDataPool[11], datapool.readFromExcelPrepItemInfo().prepItemDataPool[12], datapool.readFromExcelPrepItemInfo().prepItemDataPool[13], "MNS-1-PrepItem details entered");
			locationsPage.AddLocation_AddProductDetailsPage("MPI-1-Select Add/Select location option");
			locationsPage.TapAddLocationName("MPI-1-Tapped ADD Location");
			locationsPage.TapOnDone("MIL-WF10-Tapped Done");
			locationsPage.TapOnBack("MIL-WF10-Tapped Back");
			//locationsPage.VerifyLocationList(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MIL-WF10-Verifing Added Location2");

			locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MIL-WF10-Selecting Added Location2");
			locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[1], "MIL-WF2-Selecting Added Location2");     //not preselected
			locationsPage.LocationDoneSelection("MIL-WF10-Selecting Done");
			locationsPage.TapOnDone("MIL-WF10-Tapped Done");
			
			locationsPage.TapOnBack("MIL-WF10-Tapped Back");
			locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[2], "MIL-WF10-Selecting Added Location2");
			setupInventoryPage.verifyNonSyscoPrepItemSetupInv(datapool.readFromExcelPrepItemInfo().prepItemDataPool[7],"MIL-WF10-Verify nonsysco item added");
			
			//Cancel the item
			inventoryToolPage.InvTools_CreatePrep("MPI-1-Tapped Prep item");
			setupInventoryPage.EnterItemDetails(datapool.readFromExcelPrepItemInfo().prepItemDataPool[0], datapool.readFromExcelPrepItemInfo().prepItemDataPool[1], datapool.readFromExcelPrepItemInfo().prepItemDataPool[2],datapool.readFromExcelPrepItemInfo().prepItemDataPool[3], datapool.readFromExcelUserInfo().prepItemDataPool[4], datapool.readFromExcelPrepItemInfo().prepItemDataPool[5], datapool.readFromExcelPrepItemInfo().prepItemDataPool[6], "MPI-1-PrepItem details entered");

			
			//linking category

			setupInventoryPage.SelectCategory_PdtCard(datapool.readFromExcelCategoryInfo().categoryNameDataPool[1], "Category selected");
			
			//setupInventoryPage.TapOnDone("MNS-1-Tapped Done,Nonsyscoitem added");
			//inventoryToolPage.InvTools_TrackInventory("MNS-1-Selected track inventory");
			//locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[5], "SI - WF 1-Selected No Location");

			//locationsPage.VerifyItemsOnDefaultLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[6], "SI - WF 1-Verified cooler");
			
			
			
			//linking location
			locationsPage.AddLocation_AddProductDetailsPage("MPI-1-Select Add/Select location option");
			locationsPage.TapAddLocation("MPI-1-Tapped ADD Location");
			locationsPage.AddLocName(datapool.readFromExcelLocationInfo().locationNameDataPool[6],"MPI-1-Added location name");
			
			setupInventoryPage.TapOnCancel("MNS-1-Tapped Done,Nonsyscoitem is not added");
			inventoryToolPage.InvTools_TrackInventory("MNS-1-Selected track inventory");
			locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[5], "SI - WF 1-Selected No Location");
			setupInventoryPage.verifyNonSyscoPrepItemSetupInv(datapool.readFromExcelNonSyscoItemInfo().nonSyscoItemDataPool[0],"MIL-WF10-Verify nonsysco item added");
			
			
			
			;
		}
		
		
		 
		 * Validating user is able to setup inventory.
		 * Validating add/edit/delete supplier  through Homepage 
		 * Prerequisite:Normal/MA User with OG items
		 * 
		 

		@Test(groups={"MSP-1 MSP-2"},priority=38, description = "MSP-1 MSP-2 Home Screen-->Suppliers-->Add new Suppliers/View/Maintain Suppliers")
		public void MSP1_MSP2_Add_View_ManageSuppliers() throws Exception
		{
			
		//	VendorDetailsData vendorData=VendorDetailsData.fetch("VendorDetailData2");  datapool.readFromExcelUserInfo().supplier2DataPool[]
		//	VendorDetailsData vendorDataEdit=VendorDetailsData.fetch("VendorDetailData3");   datapool.readFromExcelUserInfo().supplier3DataPool[]
		//	VendorDetailsData vendorData1=VendorDetailsData.fetch("VendorDetailData1");  datapool.readFromExcelUserInfo().supplier1DataPool[]
			
			user=1;
			
			loginPage.verifyLoginPage("MSP-1,MSP-2-LoginPage");
			loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"MSP-1,MSP-2-LoginPage");
			homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"Clicked account");
			accountsPage.Fourth_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"MSP-1,MSP-2-FirstAccountSelect");

		
			inventoryToolPage.InvTools_SetUpInventory("SI - WF 1-SetupInventoryTap");
			setupInventoryPage.TapOnSkip("SI - WF 1-Skip1 Tapped");
			setupInventoryPage.TapOrderGuide("SI - WF 1-OG Selected");
			setupInventoryPage.tapContinue("SI - WF 1-Tapped Continue");
			
			locationsPage.DefaultLocation("SI - WF 1-Tapped Custom location");
			locationsPage.tapContinue("SI - WF 1-Tapped Continue");
		
			setupInventoryPage.TapOnDOThisLater("MIL-WF6-Tapped do this later");
			setupInventoryPage.TapTakeHome("SI - WF 32-Tapped take me home")  ;
			inventoryToolPage.InvTools_Suppliers("MSP-1,MSP-2-Tapped on suppliers");
			
			vendorPage.verifySupplierPage("MSP-1,MSP-2-Supplier page verified");
			vendorPage.Add_Supplier("MSP-1,MSP-2-Add button clicked");
			vendorPage.AddSupplier_Details(datapool.readFromExcelSupplier2Info().supplier2DataPool[0], datapool.readFromExcelSupplier2Info().supplier2DataPool[1], datapool.readFromExcelSupplier2Info().supplier2DataPool[2], datapool.readFromExcelSupplier2Info().supplier2DataPool[3], datapool.readFromExcelSupplier2Info().supplier2DataPool[4], datapool.readFromExcelSupplier2Info().supplier2DataPool[5], "MSP-1,MSP-2-Vendor details added");
			vendorPage.TapOnDone("MSP-1,MSP-2-Done tapped");
			vendorPage.TapOnBack("MSP-1,MSP-2-Back tapped");
			vendorPage.SupplierSelect(datapool.readFromExcelSupplier2Info().supplier2DataPool[0],"MSP-1,MSP-2-selected added vendor");
			vendorPage.TapOnEdit("MSP-1,MSP-2-Edit tapped");
			vendorPage.ViewSupplierDetails(datapool.readFromExcelSupplier2Info().supplier2DataPool[0], datapool.readFromExcelSupplier2Info().supplier2DataPool[1], datapool.readFromExcelSupplier2Info().supplier2DataPool[2], datapool.readFromExcelSupplier2Info().supplier2DataPool[3], datapool.readFromExcelSupplier2Info().supplier2DataPool[4], datapool.readFromExcelSupplier2Info().supplier2DataPool[5],"MSP-1,MSP-2-Verified vendor details");
			vendorPage.AddSupplier_Details(datapool.readFromExcelSupplier3Info().supplier3DataPool[0], datapool.readFromExcelSupplier3Info().supplier3DataPool[1], datapool.readFromExcelSupplier3Info().supplier3DataPool[2], datapool.readFromExcelSupplier3Info().supplier3DataPool[3], datapool.readFromExcelSupplier3Info().supplier3DataPool[4], datapool.readFromExcelSupplier3Info().supplier3DataPool[5], "MSP-1,MSP-2-Editted vendor details");
			vendorPage.TapOnDone("MSP-1,MSP-2-Done tapped");
			vendorPage.TapOnBack("MSP-1,MSP-2-Back tapped");
			vendorPage.Add_Supplier("MSP-1,MSP-2-Add2 button clicked");
			vendorPage.AddSupplier_Details(datapool.readFromExcelSupplier1Info().supplier1DataPool[0],datapool.readFromExcelUserInfo().supplier1DataPool[1], datapool.readFromExcelSupplier1Info().supplier1DataPool[2], datapool.readFromExcelSupplier1Info().supplier1DataPool[3], datapool.readFromExcelSupplier1Info().supplier1DataPool[4], datapool.readFromExcelSupplier1Info().supplier1DataPool[5], "MSP-1,MSP-2-Entered vendor details to be cancelled vendor details");
			vendorPage.TapOnCancel("MSP-1,MSP-2-Cancel tapped");
			vendorPage.SupplierCancelledVerify(datapool.readFromExcelSupplier1Info().supplier1DataPool[0], "MSP-1,MSP-2-SupplierCancel Verified");
			vendorPage.SupplierSelect(datapool.readFromExcelSupplier3Info().supplier3DataPool[0], "MSP-1,MSP-2-selected edited vendor");
			vendorPage.TapOnEdit("MSP-1,MSP-2-Edit tapped");
			vendorPage.ViewSupplierDetails(datapool.readFromExcelSupplier3Info().supplier3DataPool[0], datapool.readFromExcelSupplier3Info().supplier3DataPool[1], datapool.readFromExcelSupplier3Info().supplier3DataPool[2], datapool.readFromExcelSupplier3Info().supplier3DataPool[3], datapool.readFromExcelSupplier3Info().supplier3DataPool[4], datapool.readFromExcelSupplier3Info().supplier3DataPool[5], "MSP-1,MSP-2-Verified editted vendor details");
			vendorPage.DeleteSupplier("MSP-1,MSP-2-deleted added vendor");
			vendorPage.VerifyDeletedSupplier(datapool.readFromExcelSupplier3Info().supplier3DataPool[0], "MSP-1,MSP-2-verify deleted  vendor");
			
		}
		
		
		@Test(groups={"MSP-1 MSP-2"},priority=38, description = "MSP-1 MSP-2 Home Screen-->Suppliers-->Add new Suppliers/View/Maintain Suppliers")
		public void SI_WF39_DefaultLocation_DefaultCategory_Change() throws Exception{
			
			user=1;

			loginPage.verifyLoginPage("SI - WF 39-LoginPage");
			loginPage.saveUsernameCheckBoxclickElement("SI - WF 39-save username");	
			loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 39-Login");	
			homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"Clicked account");
			accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI - WF 39-FirstAccountSelect");
			inventoryToolPage.InvTools_SetUpInventory("SI - WF 39-SetupInventoryTap");
			setupInventoryPage.TapOnSkip("SI - WF 39-Skip1 Tapped");
			setupInventoryPage.VerifyOptionsOnImportItems("SI - WF 39-Verified import items page");
			setupInventoryPage.TapOrderGuide("SI - WF 39-OG Selected");
			setupInventoryPage.tapContinue("SI - WF 39-Tapped Continue");
			locationsPage.VerifyOptionsOnSetupLocations("SI - WF 39-Location page verified");
			locationsPage.DefaultLocation("SI - WF 39-Tapped Custom location");
			locationsPage.tapContinue("SI - WF 39-Tapped Continue");
			categoryPage.VerifyOptionsOnSetUpFoodCost("SI - WF 39-Category page verified");
			categoryPage.defaultCategories("SI - WF 39-Tapped Default category");
			categoryPage.tapComplete("SI - WF 39-Tapped Complete");
			setupInventoryPage.TapTakeHome("SI - WF 39-Tapped take me home")  ; 
			
			//clicked on track inventory link
			inventoryToolPage.InvTools_TrackInventory("SI - WF 39-Selected track inventory");			
			//verify order of locations
			locationsPage.VerifyOrderOfLocations(datapool.readFromExcelLocationInfo().locationNameDataPool[6], datapool.readFromExcelUserInfo().locationNameDataPool[7], datapool.readFromExcelUserInfo().locationNameDataPool[8], datapool.readFromExcelUserInfo().locationNameDataPool[5], "SI-WF4-Verified order of locations");
			//get item count before doing the changes
			locationsPage.getItemCountForDefaultLocations("SI - WF 39-Item Count");
			//click on Freezer locations
			locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[7], "SI - WF 39-Select Location");
			//get product name 
			locationsPage.getProductName(1,"SI - WF 39-get product name");
			//click on product name 
			locationsPage.productTap(1,"SI - WF 39- click product name");
			//verify location and category fields should not be editable
			productPage.verifyLocationCategoryNonEditable("SI - WF 39 - Location category Editable check");
			//tab on edit button to enable the page
			productPage.tapOnEdit("SI - WF 39-Tapped Edit");
			//verify location drop down - picker view with coolder, freezer and dry
			productPage.verifyLocationDropDown("SI - WF 39-verify picker view for location");
			//select any location from the picker view - Cooler
			productPage.selectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[7],"SI - WF 39-select picker view for location");
			//verify category drop down - picker view with food and non food
			productPage.verifyCategoryDropDown("SI - WF 39-verify picker view for category");
			//select any location from the picker view - Cooler
			productPage.selectCategory("non-food","SI - WF 39- select picker view for category");   //need to look into params
			//click on done button 
			productPage.tabOnDone("SI - WF 39- Done button click");
			//verify product details pge
			productPage	.verifyProductPageLoaded("SI - WF 39- product page loaded");
			//verify location and category fields should not be editable
			productPage.verifyLocationCategoryNonEditable("SI - WF 39 - Location category Editable check");
			//click on back button
			productPage.tapBack("SI - WF 39 - Tab on back");
			//verify product list page - inventory list of that location
			locationsPage.verifyProductListLoaded("SI - WF 39 - Product list page loaded");
			//click on back button
			productPage.tapBack("SI - WF 39 - Tab on back");
			//Go to Freezer 
			locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[7], "SI-WF39-Selected cooler");
			//search for an item for which we have changed the lcation 
			locationsPage.productSearch("","SI - WF 39-Search the location changed item");
			//verify not product found error message is displayed
			locationsPage.noProductSearchVerification(true,"SI - WF 39-Verify No Product Found message in Product list page");
			//Tab on new location - Cooler
			locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[6], "SI-WF39-Selected cooler");
			//search for an item for which we have changed the location 
			locationsPage.productSearch("","SI - WF 39-Search the location changed item");
			//Item should be displayed
			locationsPage.verifyProduct("","SI- WF 39-Newly added item verification");
			//tab on the product which is displayed in search result 
			locationsPage.productTap(1,"SI-WF39-Product Tap");	
			//verify product page is displayed
			productPage.verifyProductPageLoaded("SI - WF 39- product page loaded");
			//verify product page is disable - Category and location dropdown should be disabled
			productPage.verifyLocationCategoryNonEditable("SI - WF 39 - Location category Editable check");
			//verify location name and categories are displayed wiht new values for the item
			productPage.verifyLocationAndCategoryValue(datapool.readFromExcelLocationInfo().locationNameDataPool[6], "", "Verify location and category updated for the item");
			//Tab two times to go back to home page
			productPage.tapBack("SI-WF39-Tap Back");
			productPage.tapBack("SI-WF39-Tap Back");
			//tab on logout button
			homePage.HamMenu_Logout("SI-WF39-Application is logged out");
			//login to the app again  - verify login page
			loginPage.verifyLoginPage("SI - WF 39-LoginPage");
			//tab on save user name checkout
			loginPage.saveUsernameCheckBoxclickElement("SI - WF 39-save username");
			//enter username , password and tab on sign in button
			loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI - WF 39-Login");
			//tab on track inventory 			
			inventoryToolPage.InvTools_TrackInventory("SI - WF 39-Selected track inventory");			
			//verify order of locations
			locationsPage.VerifyOrderOfLocations(datapool.readFromExcelLocationInfo().locationNameDataPool[6], datapool.readFromExcelUserInfo().locationNameDataPool[7], datapool.readFromExcelUserInfo().locationNameDataPool[8], datapool.readFromExcelUserInfo().locationNameDataPool[5], "SI-WF4-Verified order of locations");
			//verify item count updates for old and new locations
			locationsPage.verifyItemCountForLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[6],datapool.readFromExcelLocationInfo().locationNameDataPool[6],"SI- WF39- Verify Item Count in Cooler after the change in last session");
			//click on Cooler locations
			locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[6], "SI - WF 39-Select Location");
			//search with item
			locationsPage.productSearch("","SI-WF39-Search the location changed item");			
			//Item should be displayed
			locationsPage.verifyProduct("","SI-WF39-Newly added item verification");
			//tab on the product and navigate to product details page
			locationsPage.productTap(1,"SI- WF39- Product Tap");
			//verify product details page 
			productPage.verifyProductPageLoaded("SI - WF 39- product page loaded");
			//verify product page is disable - Category and location dropdown should be disabled
			productPage.verifyLocationCategoryNonEditable("SI - WF 39 - Location category Editable check");
			//verify location name and categories are displayed wiht new values for the item
			productPage.verifyLocationAndCategoryValue(datapool.readFromExcelLocationInfo().locationNameDataPool[6], "", "Verify location and category updated for the item");
			//Tab two times to go back to home page
			productPage.tapBack("SI-WF39-Tap Back");
			productPage.tapBack("SI-WF39-Tap Back");
			//tab on logout button
			homePage.HamMenu_Logout("SI-WF39-Application is logged out");
			
		}
		
		
		*//**
		 * @author Parvathy_P
		 * @testcase INV_300
		 * @description Validate when a customer tries to change the location for sysco item, the list should be available as a drop down in product card
		 * @date 14/8/2016
		 * @throws Exception
		 *//*
				
		@Test(groups={"SI - WF 39"},priority=5, description = "SI - WF 39 ")
		public void SI_WF39_OG_INV_300() throws Exception {

			user=24;
			
			//Login and Set up inventory from Order Guide
			loginPage.verifyLoginPage("SI-WF39-LoginPage");
			//loginPage.saveUsernameCheckBoxclickElement("SI-WF39-save username");	
			loginPage.signIn(datapool.readFromExcelUserInfo().userNameDataPool[user],datapool.readFromExcelUserInfo().passwordDataPool[user],"SI-WF39-Login");	
			homePage.ClickAccount(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI-WF39-Clicked account");
			accountsPage.First_AccountSelection(datapool.readFromExcelUserInfo().userNameDataPool[user],"SI-WF39-FirstAccountSelect");
			inventoryToolPage.InvTools_SetUpInventory("SI-WF39-SetupInventoryTap");
			setupInventoryPage.TapOnSkip("SI-WF39-Skip1 Tapped");
			setupInventoryPage.TapOrderGuide("SI-WF39-OG Selected");
			setupInventoryPage.tapContinue("SI-WF39-Tapped Continue");
			locationsPage.DefaultLocation("SI-WF39-Tapped Custom location");
			locationsPage.tapContinue("SI-WF39-Tapped Continue");
			setupInventoryPage.TapOnDOThisLater("SI-WF39-Do this Later for category Tapped"); //- what is this
			setupInventoryPage.TapTakeHome("SI-WF39-Continue2 Tapped"); 
			//Select Track Inventory Option
			inventoryToolPage.InvTools_TrackInventory("SI-WF39-Track Inventory Tapped");
			//Navigate to Cooler Location
			locationsPage.getItemCountForDefaultLocations("SI-WF39-Get Location Item Count");
			locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[6], "SI-WF39-Selected cooler");
			//verify if the Product list is loaded
			locationsPage.verifyProductListLoaded("SI-WF39-Product List");
			//Get the name of the first item listed
			locationsPage.getProductName(1,"SI-WF39-Get Product Name");
			//Tap on the first item
			locationsPage.productTap(1,"SI-WF39-Product Tap");	
			//verify if the product page is displayed
			productPage.verifyProductPageLoaded("SI-WF39-Get Product Page Loaded");
			//Verify if the location and category fields are editable
			productPage.verifyLocationCategoryNonEditable("SI-WF39- Location Category Fields editable verification");
			//Tap on edit item
			productPage.tapOnEdit("SI-WF39-Edit is Tapped");
			//Change the location to Freezer - editable will be checked automatically
			productPage.clickOnLocation("SI-WF39-Location is Tapped");	
			productPage.selectLocation("Freezer","SI-WF39-Location Selected");
			//Tap back and go to the Location list
			productPage.tapBack("SI-WF39-Tap Back");
			productPage.tapBack("SI-WF39-Tap Back");
			//Verify if the item count is reduced from cooler
			locationsPage.verifyItemCountForLocation("","Cooler","SI-WF39-Verify Item Count in Cooler after change in location");
			//Go to cooler and search for the item name for which the location is changed
			locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[6], "SI-WF39-Selected cooler");
			//No Product page should be displayed
			locationsPage.productSearch("","SI-WF39-Search the location changed item");
			locationsPage.noProductSearchVerification(true,"SI-WF39-Verify No Product Found message in Product list page");
			//Navigate back to location list
			productPage.tapBack("SI-WF39-Tap Back");
			//Verify if the item count is increased in freezer cooler
			locationsPage.verifyItemCountForLocation("","Freezer","SI-WF39-Verify Item Count in Freezer after change in location");
			//Go to Freezer and search for the item name for which the location is changed
			locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[7], "SI-WF39-Selected Freezer");
			locationsPage.productSearch("","SI-WF39-Search the location changed item");			
			//Item should be displayed
			locationsPage.verifyProduct("","SI-WF39-Newly added item verification");
			//Logout and Login back
			//?? logout
			productPage.tapBack("SI-WF39-Tap Back");
			productPage.tapBack("SI-WF39-Tap Back");
			homePage.HamMenu_Logout("SI-WF39-Application is logged out");
			//Select Track Inventory Option
			inventoryToolPage.InvTools_TrackInventory("SI-WF39-Track Inventory Tapped");
			locationsPage.verifyItemCountForLocation("","Freezer","SI-WF39-Verify Item Count in Freezer after the change in last session");
			//Go to Freezer and search for the item name for which the location is changed
			locationsPage.SelectLocation(datapool.readFromExcelLocationInfo().locationNameDataPool[7], "SI-WF39-Selected Freezer");
			locationsPage.productSearch("","SI-WF39-Search the location changed item");		
			locationsPage.verifyProduct("","SI-WF39-Newly added item verification");
			//Verify if the item count is reduced from cooler
			locationsPage.verifyItemCountForLocation("","Cooler","SI-WF39-Verify Item Count in Cooler after the change in last session");
			//Close the app
			
			
		}
*/
	 
}


