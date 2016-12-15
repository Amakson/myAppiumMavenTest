package com.uom.pages.common;




import java.awt.Component;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.INTERNAL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.framework.configuration.ConfigFile;
import com.framework.frameworkFunctions.LibraryPage;
import com.framework.reporting.FrameworkReporter;
import com.uom.pageFactory.PageFactory;
import com.uom.pages.androidPhone.AndroidGenericPage;
import com.uom.pages.iOSTablet.IOSTabletGenericPage;
import com.uom.pages.androidPhone.AndroidExpenseCategoriesPage;
import com.uom.pages.androidPhone.AndroidSetupInventoryPage;
import com.uom.pages.iOSTablet.IOSTabletExpenseCategoriesPage;
import com.uom.pages.iOSTablet.IOSTabletSetupInventoryPage;

import io.appium.java_client.TouchAction;



public class SetupInventoryPage extends LibraryPage
{
	static Field[] declaredMemberVariables;
	static{
		declaredMemberVariables = NonSyscoPrepItemPage.class.getDeclaredFields();
	}
	
	public static final int descriptionIndex=17;
	public static final int idIndex=18;
	public static final int brandIndex=20;
	public static final int packIndex=22;
	public static final int categoryIndex=24;
	public static final int locationIndex=23;
	
	public static final String[] btn_SkipSetupInventory = {"skip",ID,"btn_SkipSetupInventory"};	
	public static final String[] btn_SaveSetupLocations= {"//button[@class='btn btn-success']",XPATH,"btn_SaveSetupLocations"};
	public static final String[] lnk_AddNewLocations= {"//a[text()='Add New Location']",XPATH,"lnk_AddNewLocations"};
	public static final String[] lnk_CrossButton= {"//*[@class='mm-o-icon icon-cross-circle']",XPATH,"lnk_CrossButton"};
	public static final String[] txt_ImportItems= {"//h2[text()='Import Items']",XPATH,"txt_ImportItems"};
	public static final String[] txt_Import= {"//h1[text()='IMPORT']",XPATH,"txt_Import"};
	public static final String[] btn_OrderGuide= {"//*[text()='Order Guide']",XPATH,"btn_OrderGuide"};
	public static final String[] btn_CustomLists= {"//*[text()='Custom Lists']",XPATH,"btn_CustomLists"};
	public static final String[] btn_Cooler= {"cooler0",ID,"btn_Cooler"};	
	public static final String[] btn_Freezer= {"freezer0",ID,"btn_Freezer"};
	public static final String[] btn_Dry= {"dry0",ID,"btn_Dry"};
	public static final String[] input_Location= {"//input[@name='locations[0].name']",XPATH,"input_Location"};
	public static final String[] btn_SkipAndUseDefault= {"//button[contains(@class,'mm-u-custom__default btn btn-primary')]",XPATH,"btn_SkipAndUseDefault"};
	public static final String[] btn_SkipAndUseCustomCategories = {"//*[contains(text(),'Skip and Use Custom Categories')]",XPATH,"btn_SkipAndUseCustomCategories"};
	public static final String[] btn_SkipAndUseListNames = {"//*[contains(text(),'Skip and Use List Names')]",XPATH,"btn_SkipAndUseCustomCategories"};
	public static final String[] lst_CustomList= {"list-item",ID,"lst_CustomList"};
	public static final String[] txt_SetupLocation= {"//h3[text()='SETUP LOCATIONS']",XPATH,"txt_SetupLocation"};
	public static final String[] txt_SetupExpenses= {"//h3[text()='SETUP EXPENSES']",XPATH,"txt_SetupExpenses"};
	public static final String[] btn_TakeMeHome= {"message-button",ID,"btn_TakeMeHome"};
	
	public static final String[] link_NextCustomLists= {"//UIAButton[@name='Next']",XPATH,"link_NextCustomLists"};	
	public static final String[] txt_Congratulations= {"//span[text()='Congratulations!']",XPATH,"txt_Congratulations"};
	public static final String[] btn_SaveCategory= {"//button[text()='Save']",XPATH,"btn_SaveCategory"};
	public static final String[] txt_AssignProducts= {"//h4[text()='Assign Products']",XPATH,"txt_AssignProducts"};
	public static final String[] txt_LocationsAdded= {"//div[@class='mm-c-card__locations']",XPATH,"txt_LocationsAdded_InAssignProductsPage"};
	public static final String[] txt_CategoriesAdded= {"//div[@class='mm-c-card__expenses']",XPATH,"txt_CategoriesAdded_InAssignProductsPage"};
	public static final String[] txt_CoolerLocation= {"//span[text()='Cooler']",XPATH,"txt_CoolerLocation"};
	public static final String[] txt_FreezerLocation= {"//span[text()='Freezer']",XPATH,"txt_FreezerLocation"};
	public static final String[] txt_DryLocation= {"//span[text()='Dry']",XPATH,"txt_DryLocation"};
	public static final String[] lnk_TrackInventory= {"//span[text()='Track Inventory']",XPATH,"lnk_TrackInventory"};
	public static final String[] lnk_Purchases= {"//span[text()='Purchases']",XPATH,"lnk_TrackInventory"};
	public static final String[] lnk_ViewFoodCost= {"//span[text()='View Food Cost']",XPATH,"lnk_ViewFoodCost"};
	public static final String[] btn_Next = {"//button[text()='Next']",XPATH,"btn_Next"};
	public static final String[] btn_Previous = {"//button[text()='Previous']",XPATH,"btn_Previous"};
	public static final String[] lnk_ClearText={"//a[@class='mm-o-icon icon-clear']",XPATH,"lnk_ClearText"};	
	public static final String[] lnk_AddNewExpense={"//a[text()='Add New Expense Category']",XPATH,"lnk_AddNewExpense"};	

	public static final String[] btn_AddNewCategoryFood={"//button[text()='FOOD']",XPATH,"btn_AddNewCategoryFood"};	
	public static final String[] btn_AddNewCategoryNonFood={"//button[text()='NONFOOD']",XPATH,"btn_AddNewCategoryNonFood"};	
	public static final String[] lst_SelectList={"//*[@class='mm-c-simplelist__item list-group-item']//*[text()='{dynamic1}']",XPATH,"lst_SelectList"};	
	public static final String[] lst_DeSelectList={"//*[@class='mm-c-simplelist__item list-group-item Active']//*[text()='{dynamic1}']",XPATH,"lst_DeSelectList"};	
	public static final String[] lst_SetUpLocationList={"//label[@class='control-label']/span[text()='{dynamic1}']",XPATH,"lst_SetUpLocationList"};	
	public static final String[] lnk_AddNewCategoryExpense= {"//div[@class='mm-c-custom-setup__cta']",XPATH,"lnk_AddNewCategoryExpense"};	
	public static final String[] btn_UseFoodAndNonFood= {"//button[text()='Use Food & Non-Food']",XPATH,"btn_UseFoodAndNonFood"};
	public static final String[] btn_UseSuggestedCategories= {"//button[text()='Use Suggested Categories']",XPATH,"btn_UseSuggestedCategories"};
	public static final String[] btn_UseFoodNonFood={"//button[text()='Use Food & Non-Food']",XPATH,"btn_UseFoodNonFood"};
	public static final String[] btn_UseSuggCategory={"//button[text()='Use Suggested Categories']",XPATH,"btn_UseSuggCategory"};
	
	public static final String[] txt_ProductTitleFirst= {"(//div[@class='mm-c-card__details-wrapper']//h4)[1]",XPATH,"txt_ProductTitleFirst"};
	public static final String[] txt_LocationsAddedFirst= {"(//div[@class='mm-c-card__locations'])[1]",XPATH,"txt_LocationsAddedFirst"};
	public static final String[] txt_CategoriesAddedFirst= {"(//div[@class='mm-c-card__expenses'])[1]",XPATH,"txt_CategoriesAddedFirst"};
	public static final String[] txt_AssignProductsActive= {"//h4[@class='mm-c-setup__active' and text() = 'Assign Products']",XPATH,"txt_AssignProductsActive"};	
	public static final String[] txt_AssignProductsLocationSlider= {"//*[@id='location-slider']//*[contains(@class,'swiper-slide')]",XPATH,"txt_AssignProductsLocationSlider"};
	public static final String[] btn_AssignProductsLocation= {"//button[text()='{dynamic1}']",XPATH,"btn_AssignProductsLocation"};
	public static final String[] txt_AssignProductsItem= {"//*[@id='inventory-carousel']//*[text()='{dynamic1}']",XPATH,"txt_AssignProductsItem"};
	public static final String[] txt_AssignProductsCategorySlider= {"//*[@id='expense-slider']//*[contains(@class,'swiper-slide')]",XPATH,"txt_AssignProductsCategorySlider"};
	public static final String[] btn_AssignProductsCategory= {"//button[text()='{dynamic1}']",XPATH,"btn_AssignProductsLocation"};
	public static final String[] input_Expense= {"//input[@name='expenses[0].name']",XPATH,"input_Expense"};  

	public static final String[] btn_AssignProductsCategoryName= {"//UIAWebView[1]/UIAButton[@label='{dynamic1}']",XPATH,"btn_AssignProductsCategoryName"};
	public static final String[] btn_AssignProductsLocationName= {"//UIAWebView[1]/UIAButton[@label='{dynamic1}']",XPATH,"btn_AssignProductsLocationName"};
	public static final String[] lst_SetUpExpenseCategoryList={"//label[@class='control-label']/span[text()='{dynamic1}']",XPATH,"lst_SetUpExpenseCategoryList"};
	public static final String[] lbl_InventoryAssignment={"//*[text() = 'Inventory Assignment']",XPATH,"lbl_InventoryAssignment"};
	public static final String[] form_AddNewLocationCategory={"//div[contains(@class,'mm-c-custom-setup__form-options')]",XPATH,"form_AddNewLocationCategory"};
	public static final String[] img_ProductCard={"//div[@class='swiper-slide swiper-slide-active']//div[@class='mm-c-card']//img",XPATH,"img_ProductCard"};
	public static final String[] lbl_ProductDecription={"//UIAScrollView[2]/UIAWebView[1]/UIAStaticText[{dynamic1}]",XPATH,"lbl_ProductDecription"};

	public static final String[] lbl_ProductDecription1={"(//div[@class='mm-c-card__details-wrapper')/h4)[{dynamic1}]",XPATH,"lbl_ProductDecription"};

	public static final String[] lbl_ProductBrand={"//UIAScrollView[2]/UIAWebView[1]/UIAStaticText[{dynamic1}]",XPATH,"lbl_ProductBrand"};
	public static final String[] lbl_ProductPack={"//UIAScrollView[2]/UIAWebView[1]/UIAStaticText[{dynamic1}]",XPATH,"lbl_ProductPack"};
	public static final String[] lbl_ProductId={"//UIAScrollView[2]/UIAWebView[1]/UIAStaticText[{dynamic1}]",XPATH,"lbl_ProductId"};
	public static final String[] lbl_ProductCategory={"//UIAScrollView[2]/UIAWebView[1]/UIAStaticText[{dynamic1}]",XPATH,"lbl_ProductCategory"};
	public static final String[] lbl_ProductLocation={"//UIAScrollView[2]/UIAWebView[1]/UIAStaticText[{dynamic1}]",XPATH,"lbl_ProductLocation"};
	public static final String[] lbl_ItemCount={"//UIAScrollView[2]/UIAWebView[1]/UIAStaticText[16]",XPATH,"lbl_ItemCount"};
	public static final String[] lbl_ItemCountExpenses={"//UIAScrollView[2]/UIAWebView[1]/UIAStaticText[12]",XPATH,"lbl_ItemCountExpenses"};
	public static final String[] lbl_ItemCountCI={"//UIAScrollView[2]/UIAWebView[1]/UIAStaticText[11]",XPATH,"lbl_ItemCountCI"};
	public static final String[] btn_LocationsInAssignProducts={"//button[@class='btn-primary__location btn btn-primary']",XPATH,"btn_LocationsAssignProducts"};	
	public static final String[] lnk_DoneNativeAssignproductPage= {"//UIAButton[@name='Done']",XPATH,"btn_NativeAssignproductPage"};
	public static final String[] txt_InventoryUpToDate= {"//*[text()='Inventory is Up to Date']",XPATH,"txt_InventoryUpToDate"};
	public static final String[] lnk_LocationChevRight={"//UIAScrollView[2]/UIAWebView[1]//UIAStaticText[@name='LOCATIONS']",XPATH,"lnk_LocationChevRight"};
	public static final String[] lnk_CategoryChevRight={"//UIAScrollView[2]/UIAWebView[1]//UIAStaticText[@name='EXPENSE CATEGORIES']",XPATH,"lnk_CategoryChevRight"};	
	public static final String[] lnk_LocationChevDown={"//UIAScrollView[2]/UIAWebView[1]//UIAStaticText[@name='LOCATIONS']",XPATH,"lnk_LocationChevDown"};
	public static final String[] lnk_CategoryChevDown={"//UIAScrollView[2]/UIAWebView[1]//UIAStaticText[@name='EXPENSE CATEGORIES']",XPATH,"lnk_CategoryChevDown"};	
    public static final String[] txt_LocationsInAssignProductPage={"//div[@class='mm-c-card__locations']",XPATH,"txt_LocationsTextInProductPage"};
	public static final String[] btn_LocationAssignProductsPage= {"//button[@class='btn-primary__location btn btn-primary']",XPATH,"btn_LocationAssignProductsPage"};
	public static final String[] lbl_SetupLocationsPage= {"//h3[text()='Set Up Locations']",XPATH,"lbl_SetupLocationsPage"};
	public static final String[] lbl_CreateLocations= {"//h3[text()='CREATE LOCATIONS']",XPATH,"lbl_CreateLocations"};
	public static final String[] btn_LocationWithPosition={"//UIAWebView[1]/UIAButton[{dynamic1}]",XPATH,"btn_LocationWithPosition"};
	public static final String[] lbl_Products={"(//div[@class='mm-c-product-list__image ']//a//img)[{dynamic1}]",XPATH,"bl_Products"};
	public static final String[] lbl_ExpenseCategoryValue={"//*[@id='expense-view']//*[contains(@class,'product-details__expense')]",XPATH,"lbl_ExpenseCategoryValue"};
	public static final String[] lbl_ProductNames={"//div[contains(@class,'product-list__details')]//h4",XPATH,"lbl_ProductNames"};
	public static final String[] btn_ChevronRight={"//i[@class='mm-o-icon icon-chevron-right']",XPATH,"btn_ChevronRight"};
	public static final String[] btn_ChevronDown={"//*[@class='mm-o-icon icon-chevron-down']",XPATH,"btn_ChevronDown"};
	

	
	/**
	 * @Function verifyAssignProductsPageLocationsTextAfterclickingLocationsButton
	 * @Description Verify the locations text displayed in the assign products page after clicking the Location button
	 * @param strLoc - Display Location 
	 * @author Arun Mathai
	 * @date 03-10-2016
	 */
	public void verifyAssignProductsPageLocationsTextAfterclickingLocationsButton(String strLoc)
	{
		switchToWebContext();
		if(isElementPresentAfterWait(replaceDynamicText(txt_LocationsInAssignProductPage, strLoc),10))
		{
			FrameworkReporter.pass("AssignProducts page Locations "+ strLoc + "  is displayed");
			}
		else{
			FrameworkReporter.fail("AssignProducts page Locations "+ strLoc + "  is not displayed");
			}	
	}

	
	/**
	 * @Function verifyLocationsButtonListedInAssignProductsPage
	 * @Description Verify Locations listed in the assign products page
	 * @param strLocationsName - string of Locations name 
	 * @author Arun Mathai
	 * @date 03-10-2016
	 */
	public void verifyLocationsButtonListedInAssignProductsPage(String strLocations)
	{
		switchToWebContext();
		String[] strLocationsName = strLocations.split("/");
		int iLocationCount = getDriver().findElements(getLocatorsType(btn_LocationAssignProductsPage)).size();				 
				
				 System.out.println("ilocation count "+iLocationCount);

				 if(iLocationCount == strLocationsName.length){					 
					 for(int i = 0; i<iLocationCount; i++){		 
					    if(getDriver().findElement(getLocatorsType(replaceDynamicText(btn_AssignProductsLocation, strLocationsName[i]))).isDisplayed()){
							FrameworkReporter.pass("Element with "+ strLocationsName[i]+ " is displayed");							
						}else{
							consolePrint("Element with "+ strLocationsName[i]+ "is not displayed");
							FrameworkReporter.fail("Element with "+ strLocationsName[i]+ " is not displayed");
						} 
					 }
				 }
				 else{
					 FrameworkReporter.fail(" NOT All locations displayed");	
				 }				
	}
		
	/**
	 * @Function tapOnMultipleLocationsListedInAssignProductsPage
	 * @Description tap on multiple locations in the assign products page
	 * @param strLocationsName - string of Locations name 
	 * @author Arun Mathai
	 * @date 03-10-2016
	 */
	public void tapOnMultipleLocationsListedInAssignProductsPage(String strLocations)
	{
		switchToWebContext();
		waitForPageLoadAndroid(3);
		String[] strLocationsName = strLocations.split("/");
				int iLocationCount = getDriver().findElements(getLocatorsType(btn_LocationAssignProductsPage)).size();				 
				
				 System.out.println("ilocation count "+iLocationCount);

				 if(iLocationCount == strLocationsName.length){					 
					 for(int i = 0; i<iLocationCount; i++){		 
					    if(getDriver().findElement(getLocatorsType(replaceDynamicText(btn_AssignProductsLocation, strLocationsName[i]))).isDisplayed())
					    {
					    	getDriver().findElement(getLocatorsType(replaceDynamicText(btn_AssignProductsLocation, strLocationsName[i]))).click();
							FrameworkReporter.pass("Element with "+ strLocationsName[i]+ " is displayed");
						}else{
							consolePrint("Element with "+ strLocationsName[i]+ " is not displayed");
							FrameworkReporter.fail("Element with "+ strLocationsName[i]+ " is not displayed");
						} 
					 }
				 }
				 else{
					 FrameworkReporter.fail(" NOT All locations displayed");	
				 }			
						
	}

	/**
	 * @function tapOnNextLink
	 * @author Arun_Mathai
	 * @description Tapped on the Next link in custom lists page
	 * @date 01-10-2016
	 */
	public void tapOnNextLinkInCustomLists(){
		switchToNativeContext();
		clickElement(link_NextCustomLists);
		switchToWebContext();
		FrameworkReporter.info("Tapped on the Next link in custom lists page");		
	}

	/**
	 * @Function verifyLocationsListedInAssignProductsPage
	 * @Description Verify Locations listed in the assign products page
	 * @param strLocationsName - Each location Name
	 * @author Arun Mathai
	 * @date 01-10-2016
		 */
	public SetupInventoryPage verifyLocationsBtnInAssignProductsPage(ArrayList<String> strLocations)
	{
	
		System.out.println("Str Location : "+strLocations);
		ArrayList<String> locvalues=new ArrayList<>();
		int count=getDriver().findElements(getLocatorsType(btn_LocationsInAssignProducts)).size();	
		List<WebElement>webElementList= getDriver().findElements(getLocatorsType(btn_LocationsInAssignProducts));
		for(int i=0;i<count;i++)
			{
				String customLoc=webElementList.get(i).getText();
				locvalues.add(customLoc);
			}
		if(locvalues.equals(strLocations))
			{
				FrameworkReporter.pass("Verified the locations in the Assign Products(Inventory assignment) page and is same");
			}
		else
			{
				FrameworkReporter.fail("Locations in the assign products page are different");			
			}	
			return this;
		}

	/**
	 * @function tapOnDoneButtonAssignProductPage
	 * @author Arun_Mathai
	 * @description Tapped on the done button in assign products page
	 * @date 01-10-2016
	 */
	public SetupInventoryPage tapOnDoneButtonAssignProductPage()
	{
		switchToNativeContext();
		clickElement(lnk_DoneNativeAssignproductPage);
		switchToWebContext();
		FrameworkReporter.info("Tapped on the Done link in Assign Products(Inventory assignment)  page");
		return this;
	}
	
	/**
	 * @function tapOnLocationsInAssignProducts
	 * @author Arun_Mathai
	 * @description Tapped on the locations in assign products page
	 * @date 01-10-2016
	 */
	public void tapOnLocationsInAssignProducts()
	{
		switchToWebContext();
		if(isElementClickableAfterWait(btn_LocationsInAssignProducts, 20)) 
		{
			clickElement(btn_LocationsInAssignProducts);
			FrameworkReporter.info("Tapped on location button in Assign Products(Inventory assignment) Page");		
		}
		else
		{
			FrameworkReporter.fail("Couldnot find the location button in the page");
		}		
	}

	/**
	 * @function verifyProductAssignWithCategory
	 * @author Arun_Mathai
	 * @description Verifying whether a category is assigned correctly with a product  
	 * @param String - Product Name and Category name
	 * @date 29-09-2016
	 */
	public void verifyProductAssignWithCategory(String ProductName,String Category){
		switchToWebContext();
		String FirstProductName=getElementText(txt_ProductTitleFirst);
		String FirstCategoryName=getElementText(txt_CategoriesAddedFirst);
		if(FirstProductName.equals(ProductName) && FirstCategoryName.equals(Category)){
			FrameworkReporter.pass("Verified the Product Name " +ProductName+ " and Category Name " +Category);
		}
		else{
			FrameworkReporter.fail("User could not verify the Product Name " +ProductName+ " and Category Name " +Category);
		}		
	}

	/**
	 * @function verifyProductAssignWithLocation
	 * @author Arun_Mathai
	 * @description Verifying whether a location is assigned correctly with a product  
	 * @param String - Product Name and Location name
	 * @date 29-09-2016
	 */
	public void  verifyProductAssignWithLocation(String ProductName,String Location)
	{
		switchToWebContext();
		String FirstProductName=getElementText(txt_ProductTitleFirst);
		String FirstLocation=getElementText(txt_LocationsAddedFirst);
		if(FirstProductName.equals(ProductName) && FirstLocation.equals(Location)){
			FrameworkReporter.pass("Verified the Product Name " +ProductName+ " and Location Name " +Location);
		}
		else{
			FrameworkReporter.fail("Could not verify the Product Name " +ProductName+ " and Location Name " +Location);
		}		
	}
	
	/**
	 * @function verifySetupIsComplete
	 * @author Arun_Mathai
	 * @description Verify the setup is complete and user has reached the home page
	 * @date 29-09-2016
	 */
	public void verifySetupIsComplete()
	{
		switchToWebContext();		
		if(isElementPresentAfterWait(txt_Congratulations,30) && isElementPresentAfterWait(btn_TakeMeHome,30))
			{
				tapOnTakeMeHomeButton();	
			}
		else
			{
				FrameworkReporter.fail("Could not find the Congratulations page and Take me home Button after Setup Inventory");
			}
		waitForPageLoadAndroid(3);
		if(isElementPresentAfterWait(lnk_TrackInventory,10) && isElementPresentAfterWait(lnk_ViewFoodCost,10) && isElementPresentAfterWait(lnk_Purchases,10))
			{
				FrameworkReporter.pass("Take Me Home Button found and user reached the HomePage successfully");
			}
		else
			{
				FrameworkReporter.fail("Could not find the Homepage");
			}
		waitForPageLoadAndroid(4);
	}

	/**
	 * @function verifyDefaultLocationsAreLoaded
	 * @author Arun_Mathai
	 * @description Verify the default locations(Cooler,Freezer,Dry) are loaded after tapping Skip and select Default locations
	 * @date 29-09-2016
	 */
	public void verifyDefaultLocationsAreLoaded()
	{
		switchToWebContext();
		if(isElementPresent(txt_CoolerLocation) && isElementPresent(txt_FreezerLocation) && isElementPresent(txt_DryLocation))
			{
				FrameworkReporter.pass("Default locations(Cooler,Freezer,Dry) are loaded after tapping Skip & select Default locations");
			}
		else
			{
				FrameworkReporter.fail("Could not load the default locations");
			}	
	}
	
	/**
	 * @function tapOnTakeMeHomeButton
	 * @author Arun_Mathai
	 * @description Tapped on the take me Home button
	 * @date 29-09-2016
	 */
	public void tapOnTakeMeHomeButton()
	{
		clickElement(btn_TakeMeHome);
		FrameworkReporter.info("Tapped on the Take Me Home button");		
	}

	/**
	 * @function tapOnSavebuttonInSetupExpense
	 * @author Arun Mathai
	 * @description Clicked on Save button after selecting category in SetupExpense page
	 * @date 29-09-2016
	 */
	public void tapOnSavebuttonInSetupExpense()
	{
		switchToWebContext();
		clickElement(btn_SaveCategory);
		FrameworkReporter.info("Clicked on Save button after selecting the category in setup Expense page");		
	}
	
	/**
	 * @function verifyImportPageDisplayAfterSwipe
	 * @author Arun_Mathai
	 * @description verifying the import page heading 
	 * @date 28-09-2016
	 */
	public void verifyImportPageDisplayAfterSwipe()
	{
		switchToWebContext();
		if(isElementPresentAfterWait(txt_ImportItems,10))
			{
				FrameworkReporter.pass("Verified whether the Import items page has been displayed successfully");
			}
		else
			{
				FrameworkReporter.fail("Could not find Import items text in the page, Import items page verification failed");
			}
	}

	/**
	 * @function verifySelectionAtImportItems
	 * @author Arun_Mathai
	 * @description Verify the items in ImportItems page
	 * @date 28-09-2016
	 */
	public void verifySelectionAtImportItems()
	{
		switchToWebContext();
		if(isElementPresent(btn_OrderGuide) && isElementPresent(btn_CustomLists) && isElementPresent(btn_Next) && isElementPresent(txt_ImportItems))
			{
				FrameworkReporter.pass("Verified order guide, Custom lists, Next button in the Import items page");
			}
		else
			{
				FrameworkReporter.fail("Could not find order guide, Custom lists, Next button in the Import items page");
			}	
	}
	
	/**
	 * @function tapOnCoolerToSelectCoolerLocation
	 * @author Arun_Mathai
	 * @description Tapped on cooler to select cooler location
	 * @date 28-09-2016
	 */
	public void tapOnCoolerToSelectCoolerLocation()
	{
		switchToWebContext();
		clickElement(btn_Cooler);
		FrameworkReporter.info("Tapped on cooler button");		
	}
	
	/**
	 * @function tapOnFreezerToSelectFreezerLocation
	 * @author Arun_Mathai
	 * @description Tapped on Freezer to select Freezer location
	 * @date 28-09-2016
	 */
	public void tapOnFreezerToSelectFreezerLocation()
	{
		switchToWebContext();
		clickElement(btn_Freezer);
		FrameworkReporter.info("Tapped on Freezer button");
		
	}
	
	/**
	 * @function tapOnDryToSelectDryLocation
	 * @author Arun_Mathai
	 * @description Tapped on Dry to select Dry location
	 * @date 28-09-2016
	 */
	public void tapOnDryToSelectDryLocation()
	{
		switchToWebContext();
		clickElement(btn_Dry);
		FrameworkReporter.info("Tapped on Dry button");		
	}
	
	/**
	 * @function addLocationInSetupLocations
	 * @author Arun_Mathai
	 * @description To Enter the value in input field and to select any of the Location type(Cooler, Dry, Freezer)
	 * @param String - Location Name and Location type
	 * @date 28-09-2016
	 */
	public void addLocationInSetupLocations(String LocationName,String LocationType)
	{
		switchToWebContext();
		sendText(input_Location, LocationName);
		storeValue(LocationName+"_index", 0);
		LocationType=LocationType.toLowerCase();
		switch (LocationType){
		case "cooler":
			tapOnCoolerToSelectCoolerLocation();
			break;
		case "freezer":
			tapOnFreezerToSelectFreezerLocation();
			break;
		case "dry":
			tapOnDryToSelectDryLocation();
			break;
		default:
			break;
		}		
	}
	/**
	 * @function tapOnSkipAndUseDefaultButtonInSetupInventoryPage
	 * @author Arun_Mathai
	 * @description Tapped on skip and use default button  
	 * @date 28-09-2016
	 */
	public void tapOnSkipAndUseDefaultButtonInSetupInventoryPage()
	{
		switchToWebContext();
		if(isElementClickableAfterWait(btn_SkipAndUseDefault, 10)) 
		{
			clickElement(btn_SkipAndUseDefault);
			FrameworkReporter.info("Tapped on skip and use default button in the setup locations page");		
		}
		else
		{
			FrameworkReporter.fail("Skip and use default button is not visible in the setup locations page.");
		}		
	}	
	/**
	 * @function tapOnSkipAndUseCustomCategoriesInSetupLocationsPage
	 * @author Reshma_Farook
	 * @description Tapped on skip and use Custom categories button  
	 * @date 28-09-2016
	 */
	public void tapOnSkipAndUseCustomCategoriesInSetupLocationsPage()
	{
		switchToWebContext();
		if(isElementClickableAfterWait(btn_SkipAndUseCustomCategories, 10)) 
		{
			clickElement(btn_SkipAndUseCustomCategories);
			FrameworkReporter.info("Tapped on Skip and use Custom Categories button in the setup locations page");		
		}
		else
		{
			FrameworkReporter.fail("Skip and use Custom Categories button is not visible in the setup locations page.");
		}
	}
	/**
	 * @function verifyListsInSelectListsPage
	 * @author Arun_Mathai
	 * @description Verification of values in the customlist
	 * @param Array list of lists in the page
	 * @date 28-09-2016
	 */
	public void  verifyListsInSelectListsPage (ArrayList<String> values)
	{
		switchToWebContext();
		ArrayList<String> listvalues=new ArrayList<>();
		int count=getDriver().findElements(getLocatorsType(lst_CustomList)).size();	
		List<WebElement>webElementList= getDriver().findElements(getLocatorsType(lst_CustomList));
		for(int i=0;i<count;i++)
		{
			String customList=webElementList.get(i).getText();
			listvalues.add(customList);
		}
		listvalues.removeAll(Arrays.asList(null,""));
		values.removeAll(Arrays.asList(null,""));

		if(listvalues.equals(values))
		{

			FrameworkReporter.pass("Verified the Customlist values");
		}
		else
		{
			FrameworkReporter.fail("Customlist values are not same");
		}		
	}
	
	/**
	 * @function verifyAllListsInSelectListsPage
	 * @author Asha
	 * @description Verification of values in the customlist
	 * @param string of list names
	 * @date 07-10-2016
	 */
	public void  verifyAllListsInSelectListsPage (String listNames)
	{
		switchToWebContext();
		boolean isfound=false;		
		String[] listvalues=listNames.split("/");
		int count=getDriver().findElements(getLocatorsType(lst_CustomList)).size();	
		List<WebElement>webElementList= getDriver().findElements(getLocatorsType(lst_CustomList));
		for(int i=0;i<count;i++)
		{
			String customList=webElementList.get(i).getText();
			if(customList.contains(listvalues[i]))
			{

				FrameworkReporter.pass("Verified the Customlist value " + listvalues[i]);
				isfound = true;
			}
			else
			{
				FrameworkReporter.fail("Customlist value " +listvalues[i]+ " is not verified ");
			}
			
		}
	}
	
	/**
	 * @function verifySelectionAtSetupLocations
	 * @author Arun_Mathai
	 * @description Verified that the setup location is selected after navigating from import items"
	 * @date 28-09-2016
	 */
	public void  verifySelectionAtSetupLocations()
	{
		switchToWebContext();
		if(isElementPresentAfterWait(txt_SetupLocation,10) && isElementClickableAfterWait(lnk_AddNewLocations,10) && isElementClickableAfterWait(btn_SkipAndUseDefault,10))
		{
			FrameworkReporter.pass("Verified that the setup location is selected after navigating from import items");
		}
		else
		{
			FrameworkReporter.fail("Could not find the setup locations page");
		}		
	}
	
	/**
	 * @function verifySetupExpensesPageDisplay
	 * @author Arun_Mathai
	 * @description Verified the setup expense page is dispalyed with UseFoodAndNonFood, UseSuggestedCategories button and with AddNewCategoryExpense
	 * @date 28-09-2016
	 */
	public void verifySetupExpensesPageDisplay()
	{
		switchToWebContext();
		if(isElementPresentAfterWait(lnk_AddNewCategoryExpense,10) && isElementPresentAfterWait(btn_UseFoodAndNonFood,10) && isElementPresentAfterWait(btn_UseSuggestedCategories,10))
		{
			FrameworkReporter.pass("Verified the setup expense page is dispalyed with UseFoodAndNonFood, UseSuggestedCategories button and AddNewCategoryExpense");
		}
		else
		{
			FrameworkReporter.fail("Could not find the setup Expense page with UseFoodAndNonFood, UseSuggestedCategories button and AddNewCategoryExpense");
		}
	}
	
	/**
	 * @function clickSkipOnSetupInventory
	 * @author Arun Mathai
	 * @description Clicked on Skip button after clicking the Setup Inventory
	 * @date 27-09-2016
	 */
	public void clickSkipOnSetupInventory()
	{		
		//Test code for swipe 	
		//swipeScreenInHorizontal(7, 2);  // working fine , use this code wherever its required		
		switchToWebContext();
		waitFor(4);
		clickElement(btn_SkipSetupInventory);
		FrameworkReporter.info("Clicked on Skip button in the setupInventory");		
	}                    
	
	/**
	 * @function tapOnAddNewLocationButton
	 * @author Arun Mathai
	 * @description :Clicked on Add New Locations in the setup location page
	 * @date 27-09-2016
	 */
	public void tapOnAddNewLocationButton()
	{
		switchToWebContext();		
		if(isElementClickableAfterWait(lnk_AddNewLocations, 20)) 
		{
			clickElement(lnk_AddNewLocations);
			FrameworkReporter.info("Clicked on Add New Locations in the setup location page");	
		}
		else
		{
			FrameworkReporter.fail("Add New Locations in the setup location page is not visible.");
		}					
	}
	
	/**
	 * @function tapOnSaveButtonInSetupLocationsPage
	 * @author Arun Mathai
	 * @description Clicked on Save button after selecting the location
	 * @date 27-09-2016
	 */
	public void tapOnSaveButtonInSetupLocationsPage()
	{
		switchToWebContext();
		clickElement(btn_SaveSetupLocations);
		FrameworkReporter.info("Clicked on Save button after selecting the location");
	}
	
	/**
	 * @function tapOnCancelNewLocationCreationXButton
	 * @author Arun Mathai
	 * @description Cleared the location entered in the page
	 * @date 27-09-2016
	 */
	public void tapOnCancelNewLocationCreationXButton()
	{
		switchToWebContext();
		clickElement(lnk_CrossButton);
		FrameworkReporter.info("Tapped on Cancelled New location creation button");		
	} 

	/**
	 * @function tapOnOrderGuideButton
	 * @author Asha
	 * @description Tap on Order Guide from SetUp Inventory Page
	 * @date 27-09-2016
	 */
	public void tapOnOrderGuideButton()
	{
		waitForPageLoadAndroid(5);   // only for android 
		switchToWebContext();
		if(isElementClickableAfterWait(btn_OrderGuide, 20)) 
		{
			clickElement(btn_OrderGuide);
			FrameworkReporter.info("Tapped on Order Guide from SetUp Inventory Page");		
		}
		else
		{
			FrameworkReporter.fail("Order guide is not visible.");
		}		
	}
	
	/**
	 * @function tapOnCustomListsButton
	 * @author Asha
	 * @description Tap on CustomLists from SetUp Inventory Page
	 * @date 27-09-2016
	 */
	public void tapOnCustomListsButton()
	{
		switchToWebContext();
		waitForPageLoadAndroid(5);
		if(isElementClickableAfterWait(btn_CustomLists, 20)) 
		{
			waitForPageLoadAndroid(2);
			clickElement(btn_CustomLists);
			FrameworkReporter.info("Tapped on CustomLists button from SetUp Inventory Page");		
		}
		else
		{
			FrameworkReporter.fail("CustomLists button is not visible in the SetUp Inventory Page.");
		}		
	}
	/*
	/**
	 * @function tapOnNextButton
	 * @author Asha
	 * @description Tap on Next button
	 * @date 27-09-2016
	 */
	public void tapOnNextButton()
	{
		switchToWebContext();
		if(isElementClickableAfterWait(btn_Next, 30)) 
		{
			clickElement(btn_Next);
			FrameworkReporter.info("Tapped on Next button from SetUp Inventory Page");		
		}
		else
		{
			FrameworkReporter.fail("Next button is not visible.");
		}		
	}
	
	/**
	 * @function tapOnPreviousButtonInSetupLocationsPage
	 * @author Asha
	 * @description Tap on Previous button in the setup location page
	 * @date 28-09-2016
	 */
	public void tapOnPreviousButtonInSetupLocationsPage()
	{
		switchToWebContext();
		clickElement(btn_Previous);
		FrameworkReporter.info("Tapped on Previous button in the setup location page");		
	}
	
	/**
	 * @Function tapOnDesiredListToSelectList
	 * @Description Select the desired Listname in the select list page 
	 * @param strListName - List name 
	 * @author Asha
	 * @date 28-09-2016
	 */
	public void tapOnDesiredListToSelectList(String strListName)
	{		
		switchToWebContext();
		clickElement(replaceDynamicText(lst_SelectList, strListName.trim()));
		FrameworkReporter.info("Tapped on DesiredList to Select "+strListName);		
		
	}
	
	/**
	 * @Function tapOnDesiredListToDeSelectList
	 * @Description DeSelect the desired Listname in the select list page
	 * @param strListName - List name 	
	 * @author Asha
	 * @date 28-09-2016
	 */
	public void tapOnDesiredListToDeSelectList(String strListName)
	{
		switchToWebContext();
		clickElement(replaceDynamicText(lst_DeSelectList, strListName));
		FrameworkReporter.info("Tapped on DesiredList to Deselect "+strListName);		
	}
	
	/**
	 * @Function clearLocationInSetupLocationsPage
	 * @Description Clear details of a location added	 
	 * @author Asha
	 * @date 28-09-2016
	 */
	public void clearLocationInSetupLocationsPage()
	{
		switchToWebContext();
		clickElement(lnk_ClearText);
		FrameworkReporter.info("Clicked on clear button to clear text");		
	}
	
	/**
	 * @Function verifyAdditionOfNewLocation
	 * @Description Verify addition of a newly added location in the setup locations page passing the newly added location details
	 * @param strLocationName - Location name 
	 * @author Asha
	 * @date 30-09-2016
	 */
	public void verifyAdditionOfNewLocation(String strLocationName){
		switchToWebContext();
		for (int i=0; i<strLocationName.split("/").length;i++){
			{
				if(isElementPresentAfterWait(replaceDynamicText(lst_SetUpLocationList, strLocationName.split("/")[i]),10))
				{
					FrameworkReporter.pass("SetupLocations page "+ strLocationName.split("/")[i]+ " is displayed");
				}
				else
				{
					FrameworkReporter.pass("SetupLocations page "+ strLocationName+ " is not displayed");
				}
			}
		}
	}
	
	/**
	 * @function tapOnAddNewExpenseCategory
	 * @author Asha
	 * @description Click On Add New Expense Category button
	 * @date 28-09-2016
	 */
	public void tapOnAddNewExpenseCategory()
	{
		switchToWebContext();
		clickElement(lnk_AddNewExpense);
		FrameworkReporter.info("Tapped on Add New Expense Category button");		
	}
	
	/**
	 * @function tapOnFoodtoSelectFoodCategory
	 * @author Asha
	 * @description Click On Add New Expense Category button
	 * @date 28-09-2016
	 */
	public void tapOnFoodtoSelectFoodCategory()
	{
		switchToWebContext();
		clickElement(btn_AddNewCategoryFood);
		FrameworkReporter.info("Tapped on Add New Expense Category button");		
	}

	/**
	 * @function tapOnNonFoodtoSelectNonFoodCategory
	 * @author Asha
	 * @description Click On Non Food button to set New Category entered as Non Food category
	 * @date 28-09-2016
	 */
	public void tapOnNonFoodtoSelectNonFoodCategory()
	{
		switchToWebContext();
		clickElement(btn_AddNewCategoryNonFood);
		FrameworkReporter.info("Click On Non Food button to set New Category entered as Non Food category");		
	}
	
	/**
	 * @function tapUseFoodAndNonFoodButton
	 * @author Asha
	 * @description tap Use Food & Non Food Button in Setup Expenses page. category
	 * @date 28-09-2016
	 */
	public void tapUseFoodAndNonFoodButton()
	{
		switchToWebContext();
		if(isElementClickableAfterWait(btn_UseFoodNonFood, 10)) 
		{
			clickElement(btn_UseFoodNonFood);
			FrameworkReporter.info("Tapped Use Food & Non Food Button in Setup Expenses page");		
			setCategoryExpanderValue(false);
		}
		else
		{
			FrameworkReporter.fail("Use Food & Non Food Button is not visible in the setup locations page.");
		}
				
	}
	
	/**
	 * @function tapUseSuggestedCategories
	 * @author Asha
	 * @description tap Use Suggested Categories in Setup Expenses page.
	 * @date 28-09-2016
	 */
	public void tapUseSuggestedCategories()
	{
		switchToWebContext();
		if(isElementClickableAfterWait(btn_UseSuggCategory, 10)) 
		{
			clickElement(btn_UseSuggCategory);
			FrameworkReporter.info("Tapped Use Suggested Categories in Setup Expenses page");		
		}
		else
		{
			FrameworkReporter.fail("Use Suggested Categories is not visible in the setup locations page.");
		}
		setCategoryExpanderValue(true);
	}
	
	/**
	 * @Function verifyAssignProductsPageDisplay
	 * @Description Verify Assign Products Page is displayed correctly	 
	 * @author Asha
	 * @date 29-09-2016
	 */
	public void verifyAssignProductsPageDisplay()
	{
		switchToWebContext();
		if(isElementPresentAfterWait(txt_AssignProductsActive,20)){
			FrameworkReporter.pass("AssignProducts page is displayed");
			}
		else{
			FrameworkReporter.fail("AssignProducts page is not displayed");
			}		
	}
	
	/**
	 * @Function verifyLocationsListedInAssignProductsPage
	 * @Description Verify Locations listed in the assign products page
	 * @param strLocationsName - string of Locations name 
	 * @author Asha
	 * @date 29-09-2016
	 */
	public void verifyLocationsListedInAssignProductsPage(String strLocations)
	{
		switchToWebContext();
		String[] strLocationsName = strLocations.split("/");			
					 clickElement(btn_ChevronRight);
					 for(int i = 0; i<strLocationsName.length; i++){							 
					    if(getDriver().findElement(getLocatorsType(replaceDynamicText(btn_AssignProductsLocation, strLocationsName[i]))).isDisplayed()){
							FrameworkReporter.pass("Element with "+ strLocationsName[i]+ " is displayed");							
						}else{
							consolePrint("Element with "+ strLocationsName[i]+ "is not displayed");
							FrameworkReporter.fail("Element with "+ strLocationsName[i]+ " is not displayed");
						} 
					 }				
	}
	
	
	/**
	 * @Function verifyExpenseCategoriesInAssignProductsPage
	 * @Description Verify whether the Categories added have been listed in Expense categories in the Assign products page
	 * @param strCategories - string of Category 
	 * @author Asha
	 * @date 29-09-2016
	 */
	public void verifyExpenseCategoriesInAssignProductsPage(String strCategory)
	{
		switchToWebContext();
		String[] strCategories = strCategory.split("/");
			clickElement(btn_ChevronRight);
					 for(int i = 0; i<strCategories.length; i++){		 
					 
						 if(getDriver().findElement(getLocatorsType(replaceDynamicText(btn_AssignProductsCategory, strCategories[i]))).isDisplayed()){
							FrameworkReporter.pass("Element with "+ strCategories[i]+ " is displayed");							
						}else{
							consolePrint("Element with "+ strCategories[i]+ "is not displayed");
							FrameworkReporter.fail("Element with "+ strCategories[i]+ " is not displayed");
						} 
					 }					
			clickElement(btn_ChevronDown);
		}
	
	/**
	 * @Function verifyAssignProductsPageItems
	 * @Description Verify whether all details are displayed in the Assign product display
	 * @param strDisplayItem - Display Item
	 * @author Asha
	 * @date 28-09-2016
	 */
	public void verifyAssignProductsPageItems(String strDisplayItem)
	{
		switchToWebContext();
		if(isElementPresentAfterWait(replaceDynamicText(txt_AssignProductsItem, strDisplayItem),10)){
			FrameworkReporter.pass("AssignProducts page "+ strDisplayItem + " is displayed");
			}
		else{
			FrameworkReporter.fail("AssignProducts page "+ strDisplayItem + " is not displayed");
			}	
	}

	/**
	 * @function addNewCategoryExpense
	 * @author Asha
	 * @description To Enter the value of new category in input field and to select any of the Food type(Food, NonFood)
	 * @param String - Category Name and Category type
	 * @date 30-09-2016
	 */
	public void addNewCategoryExpense(String CategoryName,String CategoryType)
	{		
		switchToWebContext();
		sendText(input_Expense, CategoryName);
		switch (CategoryType.toUpperCase()){
		case "FOOD":
			tapOnFoodtoSelectFoodCategory();
			break;
		case "NONFOOD":
			tapOnNonFoodtoSelectNonFoodCategory();
			break;		
		default:
			break;
		}		
	}
	
/**
 * @function tapLocatorsInAssignProductView
 * @author Asha
 * @param strLocationName - Location name 
 * @description Tapped on locations
 * @date 30-09-2016
 */
public void tapLocatorsInAssignProductView(String strLocationName)
{	
	if(ConfigFile.getProperty("brand").equalsIgnoreCase("android"))			
	{
		switchToWebContext();
		moveToElement(replaceDynamicText(getObject(btn_AssignProductsLocationName), strLocationName));
	}
	else
	{
		switchToNativeContext(); 
	}
	clickElement(replaceDynamicText(getObject(btn_AssignProductsLocationName), strLocationName));
	FrameworkReporter.info("Tapped on location "+strLocationName);	
}

/**
 * @function tapCategoryInAssignProductView
 * @author Asha
 * @param strCategoryName - category name 
 * @description Tapped on Categories
 * @date 30-09-2016
 */
public void tapCategoryInAssignProductView(String strCategoryName)
{	
	if(ConfigFile.getProperty("brand").equalsIgnoreCase("android"))					
	{
		switchToWebContext();
		moveToElement(replaceDynamicText(getObject(btn_AssignProductsCategoryName), strCategoryName));
	}
	else
	{
		switchToNativeContext();
	}
	clickElement(replaceDynamicText(getObject(btn_AssignProductsCategoryName), strCategoryName));
	FrameworkReporter.info("Tapped on Category "+strCategoryName);	
}

/**
 * @Function verifyAdditionOfNewExpenseCategory
 * @Description Verify addition of a newly added category in setupExpense Page
 * @param strCategoryName - Category name 
 * @author Asha
 * @date 30-09-2016
 */
public void verifyAdditionOfNewExpenseCategory(String strCategoryName){
	switchToWebContext();
	for (int i = 0; i<strCategoryName.split("/").length; i++){			
		if(isElementPresentAfterWait(replaceDynamicText(lst_SetUpExpenseCategoryList, strCategoryName.split("/")[i]),10)){
			FrameworkReporter.pass("Setup Expenses page "+ strCategoryName.split("/")[i] + " is displayed");
		}
		else{
			FrameworkReporter.fail("Setup Expenses page "+ strCategoryName.split("/")[i] + " is not displayed");
		}
	}
}
/**
 * @Function verifyInventoryAssignmentPage
 * @Description Verify Inventory Assignment page is displayed
 * @author Gayathri
 * @date 01-10-2016
 */
public void verifyInventoryAssignmentPage(){
	switchToWebContext();
	if(isElementPresentAfterWait(lbl_InventoryAssignment,30)){
		FrameworkReporter.pass("Inventory Assignment page is displayed");
		}
	else{
		FrameworkReporter.fail("Inventory Assignment page is not displayed");
		}	
}

/**
 * @function verifyPromptToEnterCustomLocations
 * @author Gayathri
 * @description :To verify the prompt to enter custom locations is displayed after clicking 'Add new location'
 * @date 01-10-2016
 */
public void verifyPromptToEnterCustomLocations()
{
	switchToWebContext();
	if(isElementPresentAfterWait(form_AddNewLocationCategory,5)){
		FrameworkReporter.pass("Prompt to enter custom locations is displayed");
	}
	else{
		FrameworkReporter.fail("Prompt to enter custom locations is not displayed");
	}
	if(!isElementPresent(btn_SkipAndUseDefault)){
		FrameworkReporter.pass("All the skip options are removed");
	}
	else{
		FrameworkReporter.fail("All the skip options are not removed");
	}
}

/**
 * @function verifyPromptToEnterCustomCategories
 * @author Gayathri
 * @description :To verify the prompt to enter custom Categories is displayed after clicking 'Add new Category Expense'
 * @date 03-10-2016
 */
public void verifyPromptToEnterCustomCategories()
{
	switchToWebContext();
	if(isElementPresentAfterWait(form_AddNewLocationCategory,5)){
		FrameworkReporter.pass("Prompt to enter custom categories is displayed");
	}
	else{
		FrameworkReporter.fail("Prompt to enter custom categories is not displayed");
	}
	if(!(isElementPresent(btn_UseSuggestedCategories)&&isElementPresent(btn_UseFoodAndNonFood))){
		FrameworkReporter.pass("All the skip options are removed");
	}
	else{
		FrameworkReporter.fail("All the skip options are not removed");
	}
}

/**
 * @Function verifyProductCardDetailsInInventoryAssignmentPage
 * @Description Verify Product Card details in inventory assignment screen
 * @author Gayathri
 * @date 01-10-2016
 */
public void verifyProductCardDetailsInInventoryAssignmentPage(int index){
	if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
		switchToWebContext();
		//image
		if(isElementPresentAfterWait(img_ProductCard,5)){
			FrameworkReporter.pass("Image is displayed in product card");
			}
		else{
			FrameworkReporter.fail("Image is not displayed in product card");
			}
		}
		else{
			switchToNativeContext();
		}
	int descInd=descriptionIndex+(index-1)*10;
	int idInd=idIndex+(index-1)*10;
	int brandInd=brandIndex+(index-1)*10;
	int packInd=packIndex+(index-1)*10;
    if(!retreiveStoredValue("SetupExpenseOnboarding").equals("null")&&retreiveStoredValue("SetupExpenseOnboarding").equals(true)){
		descInd=13+(index-1)*10;
		idInd=14+(index-1)*10;
		brandInd=16+(index-1)*10;
		packInd=18+(index-1)*10;
	}

	//int packInd=packIndex+(index-1)*10;
	//description
			if(isElementPresent(replaceDynamicText(getObject(lbl_ProductDecription),Integer.toString(descInd)))){
				FrameworkReporter.pass("Product description is displayed in product card");
				}
			else{
				FrameworkReporter.fail("Product description is not displayed in product card");
				}
			//brand
			if(isElementPresent(replaceDynamicText(getObject(lbl_ProductBrand),Integer.toString(brandInd)))){
				FrameworkReporter.pass("Product brand is displayed in product card");
				}
			else{
				FrameworkReporter.fail("Product brand is not displayed in product card");
				}
			//pack
			if(isElementPresent(replaceDynamicText(getObject(lbl_ProductPack),Integer.toString(packInd)))){
				FrameworkReporter.pass("Product pack is displayed in product card");
				}
			else{
				FrameworkReporter.fail("Product pack is not displayed in product card");
				}

			//material id
			if(isElementPresent(replaceDynamicText(getObject(lbl_ProductId),Integer.toString(idInd)))){
				FrameworkReporter.pass("Product id is displayed in product card");
				}
			else{
				FrameworkReporter.fail("Product id is not displayed in product card");
				}
}

/**
* @Function verifyProductCategoryInInventoryAssignmentPage
* @Description Verify Product category in inventory assignment screen
* @author Gayathri
* @date 01-10-2016
*/
public SetupInventoryPage verifyProductCategoryInInventoryAssignmentPage(String categoryType,String index, String ... customCategories){
	
	String[] categoryNames=null;
	boolean isfound=false;
	switch (categoryType){
	case "default":
		categoryNames=new String[2];
		categoryNames[0]="Food";
		categoryNames[1]="Non-Food";
		break;
	case "suggested":
		categoryNames=new String[12];
		categoryNames[0]="Dairy";
		categoryNames[1]="Meat";
		categoryNames[2]="Poultry";
		categoryNames[3]="Seafood";
		categoryNames[4]="Produce";
		categoryNames[5]="Canned and Dry";
		categoryNames[6]="Dispenser Beverage";
		categoryNames[7]="Frozen";
		categoryNames[8]="Chemical & Janatorial";
		categoryNames[9]="Paper & Disposable";
		categoryNames[10]="Supplies & Equipment";
		categoryNames[11]="Healthcare & Hospitality";
		break;
	case "custom":
		categoryNames=customCategories;
		break;
	default:
		break;
	}
	int indexNum=Integer.parseInt(index);
	int categoryInd=categoryIndex+(indexNum-1)*10;
	if(!retreiveStoredValue("SetupExpenseOnboarding").equals("null")&&retreiveStoredValue("SetupExpenseOnboarding").equals(true)){
		categoryInd=20+(indexNum-1)*10;
	}
	if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
		switchToWebContext();
		if(!categoryType.equals("no category")){
			for (int i=0;i<categoryNames.length;i++){
				if(getElementText(replaceDynamicText(getObject(lbl_ProductCategory), index)).equalsIgnoreCase(categoryNames[i])){
					isfound=true;
					break;
				}
			}
			if(isfound){
				FrameworkReporter.pass("Product category is displayed as expected in product card");
			}
			else{
				FrameworkReporter.fail("Product category is not displayed as expected in product card");
			}
			}
			else{
				if(getElementText(replaceDynamicText(getObject(lbl_ProductCategory), index)).equalsIgnoreCase("No category added")){
					FrameworkReporter.pass("No category is displayed for the item in product card");
				}
				else{
					FrameworkReporter.fail("Product category is displayed for the item in product card");
				}
			}
	}
	else{
		switchToNativeContext();
		if(!categoryType.equals("no category")){
			for (int i=0;i<categoryNames.length;i++){
				if(getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductCategory),Integer.toString(categoryInd)),"label").equalsIgnoreCase(categoryNames[i])){
					isfound=true;
					break;
				}
			}
			if(isfound){
				FrameworkReporter.pass("Product category is displayed as expected in the product card");
			}
			else{
				FrameworkReporter.fail("Product category is not displayed as expected in the product card");
			}
			}
			else{
				if(getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductCategory),Integer.toString(categoryInd)),"label").equalsIgnoreCase("No category added")){
					FrameworkReporter.pass("No category is displayed for the item in the product card");
				}
				else{
					FrameworkReporter.fail("Product category is displayed for the item in the product card");
				}
			}
	}
	
	return this;
	}

/**
* @Function verifyProductLocationInInventoryAssignmentPage
* @Description Verify product location in inventory assignment screen
* @author Gayathri
* @date 01-10-2016
*/
public SetupInventoryPage verifyProductLocationInInventoryAssignmentPage(String index, String locationType, String...customLocations){
	String[] locationNames=null;
	switch(locationType){
	case "default":
		locationNames=new String[3];
		locationNames[0]="Cooler";
		locationNames[1]="Freezer";
		locationNames[2]="Dry";
		break;
	case "custom":
		locationNames=customLocations;
		break;
	}
	int indexNum=Integer.parseInt(index);
	int locInd=locationIndex+(indexNum-1)*10;
	boolean isfound=false;
	if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
		switchToWebContext();
		if(!locationType.equals("no location")){
			for (int i=0;i<locationNames.length;i++){
				if(getElementText(replaceDynamicText(getObject(lbl_ProductLocation), index)).equals(locationNames[i])){
					isfound=true;
					break;
				}
			}
			if(isfound){
				FrameworkReporter.pass("Product location is displayed as expected in the product card");
			}
			else{
				FrameworkReporter.fail("Product location is not displayed as expected in the product card");
			}
			}
		else{
			if(getElementText(replaceDynamicText(getObject(lbl_ProductLocation), index)).equalsIgnoreCase("No Location(S) Added")){
				FrameworkReporter.pass("No location is displayed for the item in product card");
			}
			else{
				FrameworkReporter.fail("Product location is displayed for the item in product card "+" Actual text" + getElementText(replaceDynamicText(getObject(lbl_ProductLocation), index)));
			}
		}
	}
	else{
		switchToNativeContext();
		if(!locationType.equals("no location")){
			for (int i=0;i<locationNames.length;i++){
				if(getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductLocation), Integer.toString(locInd)),"label").equals(locationNames[i])){
					isfound=true;
					break;
				}
			}
			if(isfound){
				FrameworkReporter.pass("Product location is displayed as expected in the product card");
			}
			else{
				FrameworkReporter.fail("Product location is not displayed as expected in the product card");
			}
		}
		else{
			if(getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductLocation), Integer.toString(locInd)),"label").equalsIgnoreCase("No location(s) added")){
				FrameworkReporter.pass("No location is displayed for the item in the product card");
			}
			else{
				FrameworkReporter.fail("Product location is displayed for the item in the product card");
			}
		}
	}
	return this;
	}


/**
 * @function tapOnSkipAndUseListNamesInSetupLocationsPage
 * @author Asha
 * @description Tapped on skip and use List Names button  
 * @date 03-10-2016
 */
public void tapOnSkipAndUseListNamesInSetupLocationsPage()
{
	switchToWebContext();
	if(isElementClickableAfterWait(btn_SkipAndUseListNames, 10)) 
	{
		clickElement(btn_SkipAndUseListNames);
		FrameworkReporter.info("Tapped on Skip and use List names button in the setup locations page");		
	}
	else
	{
		FrameworkReporter.fail("Skip and use List Names button is not visible in the setup locations page.");
	}
}

/**
 * @Function verifySetUpCompleteInHome
 * @Description Verify Inventory is up to date in Home	 
 * @author Asha
 * @date 03-10-2016
 */
public void verifySetUpCompleteInHome()
{
	switchToWebContext();
	if(isElementPresentAfterWait(txt_InventoryUpToDate,10)){
		FrameworkReporter.pass("Home Inventory setup is up to date is displayed correctly");
		}
	else{
		FrameworkReporter.fail("Home Inventory setup is up to date is not displayed");
		}		
}

/**
* @Function swipeThroughItemsToVerifyDetails
* @Description Swipe through items to verify the product card details and to select location
* @author Gayathri
* @date 01-10-2016
*/
public SetupInventoryPage swipeThroughItemsToVerifyDetailsAndSelectLocation(boolean isVerification,boolean bStoreValue,String swipeCount,String strLocationName, String categoryType,String ... customCategories){
	
	//Adding the below line of code for swipe functionality	
	int itemCount=0;
	int locationLastIndex=0;
	int totalItemCount=0;boolean isExpanded=false;
	if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
	switchToWebContext();
	totalItemCount=getElementCount(getObject(lbl_ItemCount));
	
	}
	else{
		switchToNativeContext();
		if(!retreiveStoredValue("SetupExpenseOnboarding").equals("null")&&retreiveStoredValue("SetupExpenseOnboarding").equals(true)){
			totalItemCount=Integer.parseInt(getElementAttributeValue(getObject(lbl_ItemCountExpenses), "label").replace("/", ""));
		}
		else if(!retreiveStoredValue("SetupLocationsCloseInventory").equals("null")&&retreiveStoredValue("SetupLocationsCloseInventory").equals(true)){
				totalItemCount=Integer.parseInt(getElementAttributeValue(getObject(lbl_ItemCountCI), "label").replace("/", ""));	
		}
		else{
		totalItemCount=Integer.parseInt(getElementAttributeValue(getObject(lbl_ItemCount), "label").replace("/", ""));
		}
	}
	if(swipeCount.equals("all")){
	itemCount=totalItemCount;
	}
	else{
		itemCount=Integer.parseInt(swipeCount);
	}
	
	for(int i=1;i<=itemCount;i++){	
		if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
			switchToWebContext();
		}
		int descInd=descriptionIndex+(i-1)*10;
		if(!retreiveStoredValue("SetupExpenseOnboarding").equals("null")&&retreiveStoredValue("SetupExpenseOnboarding").equals(true)){
			descInd=13+(i-1)*10;
		}
		if (isVerification) {
		FrameworkReporter.info("Verifying product card details for item "+i);
		verifyProductCardDetailsInInventoryAssignmentPage(i);
		verifyProductCategoryInInventoryAssignmentPage(categoryType, Integer.toString(i), customCategories);
		}
		FrameworkReporter.info("Selecting location for item "+i);
		if(retreiveStoredValue("locationExpander").equals(true)&&!isExpanded){
			if(isElementClickableAfterWait(getObject(lnk_LocationChevRight), 5)){
				clickElement(getObject(lnk_LocationChevRight));
				FrameworkReporter.info("Expanded Locations view");	
				isExpanded=true;
				 if(!ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
				swipeScreenInVertical(8, 2);}
			}
			else{
				FrameworkReporter.info("Need not expand Locations view.");
			}
			}
		if(!strLocationName.contains("/")){
		if(bStoreValue)
		{
	        if(!retreiveStoredValue(strLocationName+"_index").toString().equals("null")){
	    		locationLastIndex=Integer.parseInt(retreiveStoredValue(strLocationName+"_index").toString());
	    		}
	        locationLastIndex=locationLastIndex+1;
	        if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
	    		storeValue(strLocationName+"_item"+locationLastIndex, getElementText(getObject(lbl_ProductDecription)));
	        }
	        else{
	        	storeValue(strLocationName+"_item"+locationLastIndex, getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductDecription), Integer.toString(descInd)),"label"));
	        }
	    		storeValue(strLocationName+"_index", locationLastIndex);
	    		
		}	
		tapLocatorsInAssignProductView(strLocationName);
		}
		else{
			for (int j = 0; j<strLocationName.split("/").length; j++){
				locationLastIndex=0;
			if(bStoreValue)
				{
					if(!retreiveStoredValue(strLocationName.split("/")[j]+"_index").toString().equals("null")){
						locationLastIndex=Integer.parseInt(retreiveStoredValue(strLocationName.split("/")[j]+"_index").toString());
						}
					 locationLastIndex=locationLastIndex+1;
				        if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
				    		storeValue(strLocationName.split("/")[j]+"_item"+locationLastIndex, getElementText(getObject(lbl_ProductDecription)));
				        }
				        else{
				        	storeValue(strLocationName.split("/")[j]+"_item"+locationLastIndex, getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductDecription), Integer.toString(descInd)),"label"));
				        }
				        storeValue(strLocationName.split("/")[j]+"_index",locationLastIndex);
				}
				tapLocatorsInAssignProductView(strLocationName.split("/")[j]);
			}
		}
		if(retreiveStoredValue("locationExpander").equals(true)&&isExpanded){
			if(isElementPresentAfterWait(getObject(lnk_LocationChevDown), 2)){
				moveToElement(getObject(lnk_LocationChevDown));
				if(isElementClickable(getObject(lnk_LocationChevDown))){
				clickElement(getObject(lnk_LocationChevDown));
				FrameworkReporter.info("Collapsed Location view");	
				isExpanded=false;
			}
			else{
				FrameworkReporter.info("Need not collapse Location view.");
			}	
			}
			}
	if(i<itemCount){
		swipeScreenInVertical(2,8);
		swipeScreenInVertical(2,8);
		swipeScreenInVertical(2,8);

	swipeScreenInHorizontal(8, 2);
	}
	}
	return this;
}


/**
* @Function swipeThroughItemsSelectLocation
* @Description Swipe through items to select locations and select locations. If there are 3 locations then the first item will select 1 location , 2nd item will select 2nd location and so on
* @author Parvathy
* @date 04-10-2016
*/
public SetupInventoryPage swipeThroughItemsSelectLocation(int locationCount){
	int itemCount=0, index=0;int totalItemCount=0;
	if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
		switchToWebContext();
		totalItemCount=getElementCount(getObject(lbl_ItemCount));
		
		}
		else{
			switchToNativeContext();
			if(!retreiveStoredValue("SetupLocationsCloseInventory").equals("null")&&retreiveStoredValue("SetupLocationsCloseInventory").equals(true)){
				totalItemCount=Integer.parseInt(getElementAttributeValue(getObject(lbl_ItemCountCI), "label").replace("/", ""));
			}
			else{
				waitFor(2);
				System.out.println(getElementAttributeValue(getObject(lbl_ItemCount), "label").toString());
			totalItemCount=Integer.parseInt(getElementAttributeValue(getObject(lbl_ItemCount), "label").replace("/", ""));
			}
		}
	itemCount=totalItemCount;
	int j=1;
	for(int i=1;i<=itemCount;i++){		
		if(j>locationCount)
		{
			j=1;			
		}
		if(!(ConfigFile.getProperty("platformType").equalsIgnoreCase("android"))){
			switchToNativeContext();
			index =  2+j;
		}else{
			switchToWebContext(); // Don't remove this line of code, script will fail while adding second loc as the context is changed to native inside swipe fn
			index = j;    // updated for android. 
		}
		clickElement(replaceDynamicText(getObject(btn_LocationWithPosition),Integer.toString(index)));  // updated for android
		j++;
		swipeScreenInVertical(2,8);
		swipeScreenInVertical(2,8);
		swipeScreenInVertical(2,8);
		swipeScreenInHorizontal(7,2);
		}
	return this;
}

/**
* @Function swipeThroughItemsToVerifyDetailsAndSelectLocationAndCategory
* @Description Swipe through items to verify the product card details and to select location and category
* @author Gayathri
* @date 04-10-2016
*/
public void swipeThroughItemsToVerifyDetailsAndSelectLocationAndCategory(boolean isVerification,String swipeCount,String customCategory,String strLocationName){
	int totalItemCount=0;int k=0;int itemCount=0;int locationLastIndex=0;
	boolean isExpanded=false;
	if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
	switchToWebContext();
	totalItemCount=getElementCount(getObject(lbl_ItemCount));
	}
	else{
		switchToNativeContext();
		totalItemCount=Integer.parseInt(getElementAttributeValue(getObject(lbl_ItemCount), "label").replace("/", ""));
	}
	if(swipeCount.equals("all")){
	itemCount=totalItemCount;
	}
	else{
		itemCount=Integer.parseInt(swipeCount);
	}
	int categoryCount=customCategory.split("/").length;
	for(int i=1;i<=itemCount;i++){
		if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
			switchToWebContext();
		}
		int descInd=descriptionIndex+(i-1)*10;
		if (isVerification) {
		FrameworkReporter.info("Verifying product card details for item "+i);
		verifyProductCardDetailsInInventoryAssignmentPage(i);
		verifyProductLocationInInventoryAssignmentPage(Integer.toString(i),"no location");
		verifyProductCategoryInInventoryAssignmentPage("no category", Integer.toString(i));
		}
		FrameworkReporter.info("Selecting category for item "+i);
		if(retreiveStoredValue("categoryExpander").equals(true)&&!isExpanded){
			if(isElementPresentAfterWait(getObject(lnk_CategoryChevRight), 2)){
				moveToElement(getObject(lnk_CategoryChevRight));
				if(isElementClickable(getObject(lnk_CategoryChevRight))){
					clickElement(getObject(lnk_CategoryChevRight));
					FrameworkReporter.info("Expanded Category view");	
					isExpanded=true;
					 if(!ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
							swipeScreenInVertical(8, 2);}
				}
				else{
					FrameworkReporter.info("Need not expand category view.");
				}
			}
			}
		
		if(k==categoryCount)
			{
				k=0;			
			}
			tapCategoryInAssignProductView(customCategory.split("/")[k]);
			k++;
		FrameworkReporter.info("Selecting location for item "+i);
		if(retreiveStoredValue("locationExpander").equals(true)){
			if(isElementClickableAfterWait(getObject(lnk_LocationChevRight), 5)){
				clickElement(getObject(lnk_LocationChevRight));
				FrameworkReporter.info("Expanded Locations view");	
				isExpanded=true;
				 if(!ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
						swipeScreenInVertical(8, 2);}
			}
			else{
				FrameworkReporter.info("Need not expand Locations view.");
			}
			}
		if(!strLocationName.contains("/")){
			locationLastIndex=0;
			tapLocatorsInAssignProductView(strLocationName);
			  if(!retreiveStoredValue(strLocationName+"_index").toString().equals("null")){
		    		locationLastIndex=Integer.parseInt(retreiveStoredValue(strLocationName+"_index").toString());
		    		}
		        locationLastIndex=locationLastIndex+1;
		        if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
		    		storeValue(strLocationName+"_item"+locationLastIndex, getElementText(getObject(lbl_ProductDecription)));
		        }
		        else{
		        	storeValue(strLocationName+"_item"+locationLastIndex, getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductDecription), Integer.toString(descInd)),"label"));
		        }
		    		storeValue(strLocationName+"_index", locationLastIndex);
		}
			else{
				//modified code with < instead of <=
				for (int j = 0; j<strLocationName.split("/").length; j++){
					locationLastIndex=0;
					tapLocatorsInAssignProductView(strLocationName.split("/")[j]);
					  if(!retreiveStoredValue(strLocationName+"_index").toString().equals("null")){
				    		locationLastIndex=Integer.parseInt(retreiveStoredValue(strLocationName+"_index").toString());
				    		}
				        locationLastIndex=locationLastIndex+1;
				        if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
				    		storeValue(strLocationName.split("/")+"_item"+locationLastIndex, getElementText(getObject(lbl_ProductDecription)));
				        }
				        else{
				        	storeValue(strLocationName.split("/")+"_item"+locationLastIndex, getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductDecription), Integer.toString(descInd)),"label"));
				        }
				    		storeValue(strLocationName.split("/")+"_index", locationLastIndex);
				}
			}
		
		if(retreiveStoredValue("locationExpander").equals(true)&&isExpanded){
			if(isElementPresentAfterWait(getObject(lnk_LocationChevDown), 2)){
				moveToElement(getObject(lnk_LocationChevDown));
				if(isElementClickable(getObject(lnk_LocationChevDown))){
				clickElement(getObject(lnk_LocationChevDown));
				FrameworkReporter.info("Collapsed location view");	
				isExpanded=false;
			}
			else{
				FrameworkReporter.info("Need not collapse location view.");
			}	
			}
			}
		else if(retreiveStoredValue("categoryExpander").equals(true)&&isExpanded){
			if(isElementPresentAfterWait(getObject(lnk_CategoryChevDown), 2)){
				moveToElement(getObject(lnk_CategoryChevDown));
				if(isElementClickable(getObject(lnk_CategoryChevDown))){
				clickElement(getObject(lnk_CategoryChevDown));
				FrameworkReporter.info("Collapsed category view");	
				isExpanded=false;
			}
			else{
				FrameworkReporter.info("Need not collapse category view.");
			}	
			}
			}
		if(i<itemCount){
			swipeScreenInVertical(2,8);
			swipeScreenInHorizontal(8, 2);}
		}
}
/**
* @Function swipeThroughItemsToVerifyDetailsAndSelectCategory
* @Description Swipe through items to verify the product card details and to select category
* @author Gayathri
* @date 01-10-2016
*/
public SetupInventoryPage swipeThroughItemsToVerifyDetailsAndSelectCategory(boolean isVerification,String swipeCount,String customCategory,String locationType,String... locationNames){
	int itemCount=0;
	int locationLastIndex=0;
	int totalItemCount=0;int k=0;
	boolean isExpanded=false;
	if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
	switchToWebContext();
	totalItemCount=getElementCount(getObject(lbl_ItemCount));
	}
	else{
		switchToNativeContext();
		if(!retreiveStoredValue("SetupExpenseOnboarding").equals("null")&&retreiveStoredValue("SetupExpenseOnboarding").equals(true)){
			totalItemCount=Integer.parseInt(getElementAttributeValue(getObject(lbl_ItemCountExpenses), "label").replace("/", ""));
		}
		else if(!retreiveStoredValue("SetupExpenseCloseInventory").equals("null")&&retreiveStoredValue("SetupExpenseCloseInventory").equals(true)){
			totalItemCount=Integer.parseInt(getElementAttributeValue(getObject(lbl_ItemCountCI), "label").replace("/", ""));
		}
		else{
		totalItemCount=Integer.parseInt(getElementAttributeValue(getObject(lbl_ItemCount), "label").replace("/", ""));
		}
	}
	if(swipeCount.equals("all")){
	itemCount=totalItemCount;
	}
	else{
		itemCount=Integer.parseInt(swipeCount);
	}
	if(retreiveStoredValue("categoryExpander").equals(true)){
	if(isElementPresentAfterWait(getObject(lnk_CategoryChevRight), 5)){
		moveToElement(getObject(lnk_CategoryChevRight));
		if(isElementClickable(getObject(lnk_CategoryChevRight))){
		clickElement(getObject(lnk_CategoryChevRight));
		FrameworkReporter.info("Expanded Category view");	
		isExpanded=true;
		 if(!ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
				swipeScreenInVertical(8, 2);}
	}
	else{
		FrameworkReporter.info("Need not expand category view.");
	}
	}
	}
	int categoryCount=customCategory.split("/").length;
	for(int i=1;i<=itemCount;i++){
		if(retreiveStoredValue("categoryExpander").equals(true)&&!isExpanded){
			if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
				switchToWebContext();
			}
		if(isElementPresentAfterWait(getObject(lnk_CategoryChevRight), 2)){
			moveToElement(getObject(lnk_CategoryChevRight));
			if(isElementClickable(getObject(lnk_CategoryChevRight))){
				clickElement(getObject(lnk_CategoryChevRight));
				FrameworkReporter.info("Expanded Category view");	
				isExpanded=true;
				 if(!ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
						swipeScreenInVertical(8, 2);}
			}
			else{
				FrameworkReporter.info("Need not expand category view.");
			}
		}
		}
		if(isVerification){
		FrameworkReporter.info("Verifying product card details for item "+i);
		verifyProductCardDetailsInInventoryAssignmentPage(i);
		verifyProductLocationInInventoryAssignmentPage(Integer.toString(i),locationType);
		}
		FrameworkReporter.info("Selecting category for item "+i);
		if(k==categoryCount)
		{
			k=0;			
		}
		tapCategoryInAssignProductView(customCategory.split("/")[k]);
		k++;
		if(retreiveStoredValue("categoryExpander").equals(true)&&isExpanded){
		if(isElementPresentAfterWait(getObject(lnk_CategoryChevDown), 2)){
			moveToElement(getObject(lnk_CategoryChevDown));
			if(isElementClickable(getObject(lnk_CategoryChevDown))){
			clickElement(getObject(lnk_CategoryChevDown));
			FrameworkReporter.info("Collapsed Category view");	
			isExpanded=false;
		}
		else{
			FrameworkReporter.info("Need not collapse category view.");
		}	
		}
		}
		if(i<itemCount){

			swipeScreenInVertical(2,8);
			swipeScreenInVertical(2,8);
			swipeScreenInVertical(2,8);
			swipeScreenInHorizontal(7, 2);}
		}
	return this;
}
/**
 * @Function verifyCategoryOfAllItemsInListFromProductCardAfterUpdate
 * @Description To verify category of all items in a list from product card after updating the category name
 * @author Gayathri
 * @throws InterruptedException 
 * @date 05-10-2016
 */
public void verifyCategoryOfAllItemsInListFromProductCardAfterUpdate(String categoryType,String[] categoryNamesBefore, String[] categoryNamesAfter,String...customCategories ) throws InterruptedException{
	switchToWebContext();
	String[] categoryNames=null;
	boolean isTrue=true;
	int itemCount=getElementCount(lbl_ProductNames);
	switch (categoryType){
	case "default":
		categoryNames=new String[2];
		categoryNames[0]="Food";
		categoryNames[1]="Non-Food";
		break;
	case "suggested":
		categoryNames=new String[12];
		categoryNames[0]="Dairy";
		categoryNames[1]="Meat";
		categoryNames[2]="Poultry";
		categoryNames[3]="Seafood";
		categoryNames[4]="Produce";
		categoryNames[5]="Canned and Dry";
		categoryNames[6]="Dispenser Beverage";
		categoryNames[7]="Frozen";
		categoryNames[8]="Chemical & Janatorial";
		categoryNames[9]="Paper & Disposable";
		categoryNames[10]="Supplies & Equipment";
		categoryNames[11]="Healthcare & Hospitality";
		break;
	case "custom":
		categoryNames=customCategories;
		break;
	default:
		break;
	}
	for(int i=0;i<categoryNamesBefore.length;i++){
		for(int j=0;j<categoryNames.length;j++){
		if(categoryNames[j].equals(categoryNamesBefore[i])){
			categoryNames[j]=categoryNamesAfter[i];
			break;
		}
		}
	}
	for (int i=1;i<=itemCount;i++) {
		switchToWebContext();
		boolean isCategoryFound=false;
		Actions builder=new Actions(getDriver());
        builder.moveToElement(waitForElementPresent(replaceDynamicText(lbl_Products,Integer.toString(i)))).build().perform();
		clickElement(replaceDynamicText(lbl_Products,Integer.toString(i)));
		for (int j=0;j<categoryNames.length;j++){
		if(getElementText(lbl_ExpenseCategoryValue).equals(categoryNames[j])){
			isCategoryFound=true;
			break;
		}						
		}
		if(!isCategoryFound){
			isTrue=false;
		}
		PageFactory pf =new PageFactory();
		pf.generic().tapClose();
	}
	if(isTrue){
		FrameworkReporter.pass("Category of all items in the list is displayed as expected in the product card");
	}
	else{
		FrameworkReporter.fail("Category of all items in the list is not displayed as expected in the product card");
	}
}

/**
 * @function verifySetupLocationsPageDisplayed
 * @author Periyasamy_Nainar
 * @description Verified setup locations page displayed with required fields
 * @date 28-09-2016
 */
public void  verifySetupLocationsPageDisplayed()
{
	switchToWebContext();
	if(isElementPresentAfterWait(lbl_SetupLocationsPage,10) && isElementPresentAfterWait(lbl_CreateLocations,2) && isElementPresentAfterWait(lnk_AddNewLocations,2) && isElementPresentAfterWait(btn_SkipAndUseDefault,2))
	{
		FrameworkReporter.pass("Verified that the setup location is dispalyed");
	}
	else
	{
		FrameworkReporter.fail("Setup locations page is not displayed");
	}		
}

/**
* @Function swipeThroughItemsToVerifyDetailsAndSelectLocationUpdateCategory
* @Description Swipe through items to verify the product card details and to select location and update/change category
* @author Periyasamy Nainar
* @date 06-10-2016
*/
public void swipeThroughItemsToVerifyDetailsAndSelectLocationUpdateCategory(boolean isVerification,String swipeCount,String strLocationName, String categoryType,String strCategoryName , String ... customCategories){
	
	int totalItemCount=0;int itemCount=0;int locationLastIndex=0;
	if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
	switchToWebContext();
	totalItemCount=getElementCount(getObject(lbl_ItemCount));
	}
	else{
		switchToNativeContext();
		totalItemCount=Integer.parseInt(getElementAttributeValue(getObject(lbl_ItemCount), "label").replace("/", ""));
	}
	if(swipeCount.equals("all")){
	itemCount=totalItemCount;
	}
	else{
		itemCount=Integer.parseInt(swipeCount);
	}
	waitFor(3);
	for(int i=1;i<=itemCount;i++){
		int descInd=descriptionIndex+(i-1)*10;

		if (isVerification) {
		FrameworkReporter.info("Verifying product card details for item "+i);
		verifyProductCardDetailsInInventoryAssignmentPage(i);
		verifyProductCategoryInInventoryAssignmentPage(categoryType, Integer.toString(i), customCategories);
		}
		FrameworkReporter.info("Selecting location for item "+i);
		if(!strLocationName.contains("/")){
		tapLocatorsInAssignProductView(strLocationName);
		if(!retreiveStoredValue(strLocationName+"_index").toString().equals("null")){
    		locationLastIndex=Integer.parseInt(retreiveStoredValue(strLocationName+"_index").toString());
    		}
        locationLastIndex=locationLastIndex+1;
        if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
    		storeValue(strLocationName+"_item"+locationLastIndex, getElementText(getObject(lbl_ProductDecription)));
        }
        else{
        	storeValue(strLocationName+"_item"+locationLastIndex, getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductDecription), Integer.toString(descInd)),"label"));
        }
    		storeValue(strLocationName+"_index", locationLastIndex);
    			
		}
		else{
			String[] strLocName = strLocationName.split("/");
			for (int j = 0; j<strLocName.length; j++){			
			if(strLocName.length >3){ // Number of locations are more than 3 then go for below check 
				if(isElementClickableAfterWait(getObject(lnk_LocationChevRight), 10)){
					clickElement(getObject(lnk_LocationChevRight));
					FrameworkReporter.info("Expanded Locations view");	
					 if(!ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
							swipeScreenInVertical(8, 2);}
				}
				else{
					FrameworkReporter.info("Need not expand Locations view.");
				}	
			}	
				//tapLocatorsInAssignProductView(strLocationName.split("/")[i]);
				//storeValue(strLocationName.split("/")[i]+"_item"+i, getElementText(lbl_ProductDecription));
				//changed the value from i to j as its supposed to read value from inside for loop rather than outside - Periya
				//Revert the changes with appropriate command if its impacting anywhere else. 
				tapLocatorsInAssignProductView(strLocationName.split("/")[j]);
				if(!retreiveStoredValue(strLocationName.split("/")[j]+"_index").toString().equals("null")){
		    		locationLastIndex=Integer.parseInt(retreiveStoredValue(strLocationName.split("/")[j]+"_index").toString());
		    		}
		        locationLastIndex=locationLastIndex+1;
		        if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
		    		storeValue(strLocationName.split("/")[j]+"_item"+locationLastIndex, getElementText(getObject(lbl_ProductDecription)));
		        }
		        else{
		        	storeValue(strLocationName.split("/")[j]+"_item"+locationLastIndex, getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductDecription), Integer.toString(descInd)),"label"));
		        }
		    		storeValue(strLocationName.split("/")[j]+"_index", locationLastIndex);
		    		
			}	
			}		
		//update/change the category
		if(!(strCategoryName.isEmpty())){
			tapCategoryInAssignProductView(strCategoryName);
			 if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
		    		storeValue(strCategoryName+"_item"+i, getElementText(getObject(lbl_ProductDecription)));
		        }
		        else{
		        	storeValue(strCategoryName+"_item"+i, getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductDecription), Integer.toString(descInd)),"label"));
		        }
			}
		
		if(i<itemCount){
	swipeScreenInHorizontal(8, 2);}
			}
		}
/**
* @Function swipeThroughItemsToVerifyDetails
* @Description Swipe through items to verify the product card details and to select location
* @author Periyasamy Nainar
* @param strValidation - empty/loccat/loc/cat to perform validation, bStoreValue - true or false, location type and location name, category type and category names
* @date 13-10-2016
* please do not modify this function - kindly check with parvathy/periya before updating this function. highly critical one. 
*/
public SetupInventoryPage swipeThroughItemsAndSelectLocationAndCategory(String strValidation, boolean bStoreValue, String stLocationType, String strLocationName, String categoryType,String customCategories){
	
	int itemCount=0, iSize=0, iMultiSize=0, iLocCount=0;int totalItemCount=0;	
	if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
		switchToWebContext();
		totalItemCount=getElementCount(getObject(lbl_ItemCount));
		
		}
		else{
			switchToNativeContext();
			totalItemCount=Integer.parseInt(getElementAttributeValue(getObject(lbl_ItemCountExpenses), "label").replace("/", ""));   // pls do not modify
		}
	
	String strDiffLocName = "", strMultiLoc="", strKey = "", strValue="";	
	String[] strCustomCategories = customCategories.split("/");
	    itemCount=totalItemCount;
		iLocCount = strLocationName.split("/").length;
		int i= 1;    // don't change the value of i 
		verifyProductDetailsWithCatAndLoc(i, strValidation, stLocationType, strLocationName, categoryType, customCategories);
	while(i<=itemCount){	
		if(i<=iLocCount){// swipe without selecting location 						
				if(strLocationName.split("/").length>3){
					if(isElementClickableAfterWait(getObject(lnk_LocationChevRight), 2)){
						clickElement(getObject(lnk_LocationChevRight));
						FrameworkReporter.info("Expanded Locations view");	
						swipeScreenInVertical(8, 2);}
				}
				if(strLocationName.contains("/")){		
					iSize = strLocationName.split("/").length;
					for (int j = 0; j<iSize; j++){                     // loop for different location
						int descInd=descriptionIndex+j*10;
						int idInd=idIndex+j*10;
						FrameworkReporter.info("Selecting location for item "+(j+1));
						i++;
						strDiffLocName = strLocationName.split("/")[j];
						if(strDiffLocName.contains(":")){
							iMultiSize = strDiffLocName.split(":").length;
							for(int k=0; k< iMultiSize; k++){			// loop for multiple location for same item
								strMultiLoc = strDiffLocName.split(":")[k];	
								if(bStoreValue)
								{
									if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){	
										strKey = strMultiLoc+getElementText(getObject(lbl_ProductId));
										strValue = getElementText(getObject(lbl_ProductDecription));
										 }
										 else{
											 strKey = strMultiLoc+getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductId), Integer.toString(idInd)),"label");
											 strValue = getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductDecription), Integer.toString(descInd)),"label");
										 }
									locItemMap.put(strKey,strValue);    
								}	
								if(strLocationName.split("/").length>3){
									if(isElementClickableAfterWait(getObject(lnk_LocationChevRight), 2)){
										clickElement(getObject(lnk_LocationChevRight));
										FrameworkReporter.info("Expanded Locations view");
											swipeScreenInVertical(8, 2);}
								}
								tapLocatorsInAssignProductView(strMultiLoc);					
									}
							
								}
							else{
								if(bStoreValue)
								{
									 if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){	
									strKey = strDiffLocName+getElementText(getObject(lbl_ProductId));
									strValue = getElementText(getObject(lbl_ProductDecription));
									 }
									 else{
										 strKey = strDiffLocName+getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductId), Integer.toString(idInd)),"label");
										 strValue = getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductDecription), Integer.toString(descInd)),"label");
									 }
									locItemMap.put(strKey,strValue);    							
								}	
								if(strLocationName.split("/").length>3){
									if(isElementClickableAfterWait(getObject(lnk_LocationChevRight), 2)){
										clickElement(getObject(lnk_LocationChevRight));
										FrameworkReporter.info("Expanded Locations view");
										swipeScreenInVertical(8, 2);
									}
								}
								tapLocatorsInAssignProductView(strDiffLocName);					
								}
						if(isElementPresentAfterWait(getObject(lnk_LocationChevDown), 2)){
							moveToElement(getObject(lnk_LocationChevDown));
							if(isElementClickable(getObject(lnk_LocationChevDown))){
							clickElement(getObject(lnk_LocationChevDown));
							FrameworkReporter.info("Collapsed location view");	
							}
						}
						else{
							FrameworkReporter.info("Need not collapse location view.");
						}	
							if(i<itemCount){
								if(i<=strCustomCategories.length){
									tapCategoryInAssignProductView(strCustomCategories[i-2]);
									if(bStoreValue)
									{   if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){	
										locItemMap.put(getElementText(getObject(lbl_ProductDecription)), strCustomCategories[i-2]);  }
									 else{
								        	locItemMap.put(getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductDecription), Integer.toString(descInd)),"label"),strCustomCategories[i-2]);  
								        }   } // For category 
								}else{
									
									if(bStoreValue)
									{   if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){	
										locItemMap.put(getElementText(getObject(lbl_ProductDecription)),"nocategory");  }
									 else{
								        	locItemMap.put(getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductDecription), Integer.toString(descInd)),"label"),"nocategory");  
								        }  } 
								}
								swipeScreenInVertical(2,8);
								swipeScreenInVertical(2,8);
								swipeScreenInVertical(2,8);
								swipeScreenInHorizontal(8, 2);
								verifyProductDetailsWithCatAndLoc(i, strValidation, stLocationType, strLocationName, categoryType, customCategories);
							}
						}
					
				}else{
					int descInd=descriptionIndex+(i)*10;
					int idInd=idIndex+(i)*10;
					if(bStoreValue)
					{
						if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){locItemMap.put(LocationsPage.NOLOCATION+getElementText(getObject(lbl_ProductId)),getElementText(getObject(lbl_ProductDecription)));    // nolocation10394561
						}
						 else{
							 locItemMap.put(LocationsPage.NOLOCATION+getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductId),Integer.toString(idInd)),"label"),getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductDecription), Integer.toString(descInd)),"label"));
						 }   
						}					
					tapLocatorsInAssignProductView(strLocationName);
					if(isElementPresentAfterWait(getObject(lnk_LocationChevDown), 2)){
						moveToElement(getObject(lnk_LocationChevDown));
						if(isElementClickable(getObject(lnk_LocationChevDown))){
						clickElement(getObject(lnk_LocationChevDown));
						FrameworkReporter.info("Collapsed location view");	
						}
					}
					i++;
					if(i<itemCount){
						if(i<=strCustomCategories.length){
							tapCategoryInAssignProductView(strCustomCategories[i-2]);
							if(bStoreValue)
							{  if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){	
								locItemMap.put(getElementText(getObject(lbl_ProductDecription)), strCustomCategories[i-2]);  }
							 else{
						        	locItemMap.put(getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductDecription), Integer.toString(descInd)),"label"),strCustomCategories[i-2]);  
						        }  } // For category 
							
						}
						else{
							
							if(bStoreValue){   
								if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){	
									locItemMap.put(getElementText(getObject(lbl_ProductDecription)),"nocategory");  }
								 else{
							        	locItemMap.put(getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductDecription), Integer.toString(descInd)),"label"),"nocategory");  
							        }
							} 
						}
						swipeScreenInVertical(2, 8);
						swipeScreenInHorizontal(8, 2);
						verifyProductDetailsWithCatAndLoc(i, strValidation, stLocationType, strLocationName, categoryType, customCategories);
					}
				}
		}else{
			int descInd=descriptionIndex+(i)*10;
			int idInd=idIndex+(i)*10;
			if(bStoreValue)
			{
				if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){locItemMap.put(LocationsPage.NOLOCATION+getElementText(getObject(lbl_ProductId)),getElementText(getObject(lbl_ProductDecription)));    // nolocation10394561
				}
				 else{
					 locItemMap.put(LocationsPage.NOLOCATION+getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductId), Integer.toString(idInd)),"label"),getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductDecription), Integer.toString(descInd)),"label"));
				 }
			}
			i++;
			if(i<=itemCount){	
				if(i<=strCustomCategories.length){
					tapCategoryInAssignProductView(strCustomCategories[i-2]);
					if(bStoreValue){ 
						if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){	
							locItemMap.put(getElementText(getObject(lbl_ProductDecription)), strCustomCategories[i-2]);  }
						 else{
					        	locItemMap.put(getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductDecription), Integer.toString(descInd)),"label"),strCustomCategories[i-2]);  
					        }
					} // For category 
				}
					else{						
						if(bStoreValue){   
							if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){	
								locItemMap.put(getElementText(getObject(lbl_ProductDecription)),"nocategory");  }
							 else{
						        	locItemMap.put(getElementAttributeValue(replaceDynamicText(getObject(lbl_ProductDecription), Integer.toString(descInd)),"label"),"nocategory");  
						        }
						} 
					}
				swipeScreenInVertical(2, 8);
				swipeScreenInHorizontal(8, 2);
				verifyProductDetailsWithCatAndLoc(i, strValidation, stLocationType, strLocationName, categoryType, customCategories);
			}
		}		
		
	}	
	for(Map.Entry<String, String> obj: locItemMap.entrySet()){
		if(obj.getKey().toLowerCase().contains("loc")){		
			consolePrint(" location key:  "+ obj.getKey()+ "  Value: "+ obj.getValue());
		}else{
		consolePrint("key:  "+ obj.getKey()+ "  Value: "+ obj.getValue());}
	}
	
	
	return this;
}

/**
 * 
 * @name verifyProductDetailsWithCatAndLoc
 * @Description supporting method for swipeThroughItemsAndSelectLocationAndCategory
 */
public void verifyProductDetailsWithCatAndLoc(int i, String strValidation,String stLocationType, String strLocationName, String categoryType,String ... customCategories){
	switchToWebContext();
	if(strValidation.isEmpty()){
		//don't do anything
	}else if(strValidation.equalsIgnoreCase("loccat")){
		verifyProductCardDetailsInInventoryAssignmentPage(i);
		verifyProductCategoryInInventoryAssignmentPage(categoryType, Integer.toString(i), customCategories);
		verifyProductLocationInInventoryAssignmentPage(Integer.toString(i), stLocationType, strLocationName);
	}else if(strValidation.equalsIgnoreCase("cat")){
		verifyProductCardDetailsInInventoryAssignmentPage(i);
		verifyProductCategoryInInventoryAssignmentPage(categoryType, Integer.toString(i), customCategories);
	}
	else if(strValidation.equalsIgnoreCase("loc")){
		verifyProductCardDetailsInInventoryAssignmentPage(i);
		verifyProductLocationInInventoryAssignmentPage(Integer.toString(i), stLocationType, strLocationName);
	}
}


/**
 * @function verifySkipAndUseDefaultButtonInLocationPage
 * @author Periyasamy Nainar
 * @description Verify skip and use default button in select location page
 * @param boolval - true /false
 * @date 16-10-2016
 */
public void verifySkipAndUseDefaultButtonInLocationPage(Boolean boolval)
{	
	switchToWebContext();
	if(boolval){
		if(isElementClickableAfterWait(btn_SkipAndUseDefault, 10)){
			FrameworkReporter.pass("Skip and use default option is displayed");
		}else{
			FrameworkReporter.fail("Skip and use default option is not displayed");
		}		
	}
	else{
		if(!(isElementClickableAfterWait(btn_SkipAndUseDefault,3))){
			FrameworkReporter.pass("Skip and use default option is removed");
		}
		else{
			FrameworkReporter.fail("Skip and use default option is not removed");
		}		
	}	
		
}	

/**
 * @function verifySkipAndUseDefaultButtonInCategoryPage
 * @author Periyasamy Nainar
 * @description Verify skip and use Food/Non-Food button in select category page
 * @param boolval - true /false
 * @date 16-10-2016
 */
public void verifySkipAndUseDefaultButtonInCategoryPage(Boolean boolval)
{	
	switchToWebContext();
	if(boolval){
		if(isElementClickableAfterWait(btn_UseFoodAndNonFood, 10)){
			FrameworkReporter.pass("Skip and use Food/NonFood option is displayed");
		}else{
			FrameworkReporter.fail("Skip and use Food/NonFood option is not displayed");
		}
	}
	else{
		if(!(isElementClickableAfterWait(btn_UseFoodAndNonFood,3))){
			FrameworkReporter.pass("Skip and use Food/NonFood option is removed");
		}
		else{
			FrameworkReporter.fail("Skip and use Food/NonFood option is not removed");
		}
	}	
		
}	

/**
 * 
 * @name getFoodCategories
 * @Description to store custom categories with type food
 */
public void getFoodCategories(String foodCategories){
	switchToWebContext();
	storeValue("FoodCategories", foodCategories);
}


/**
 * @Function verifySkipAndUseDefaultLocBGColor
 * @Description To verify background of color of skip and use default location button 
 * @author Periyasamy Nainar
 * @param isSelected - True or false 
 * @date 16-10-2016
 */
public void verifySkipAndUseDefaultLocBGColor(Boolean isSelected){
	switchToWebContext();
	
	if(isSelected){
		verifyBackGroundColor(btn_SkipAndUseDefault, ENABLEBTNCOLOR);
	}else{
		verifyBackGroundColor(btn_SkipAndUseDefault, DISABLEBTNCOLOR);
	}
	FrameworkReporter.info("Clicked on Toggle button");
		
}


/**
 * @Function verifySkipAndUseDefaultCategoryBGColor
 * @Description To verify background of color of skip and use default category button 
 * @author Periyasamy Nainar
 * @param isSelected - True or false 
 * @date 16-10-2016
 */
public void verifySkipAndUseDefaultCategoryBGColor(Boolean isSelected){
	switchToWebContext();
	
	if(isSelected){
		verifyBackGroundColor(btn_UseFoodNonFood, ENABLEBTNCOLOR);
	}else{
		verifyBackGroundColor(btn_UseFoodNonFood, DISABLEBTNCOLOR);
	}
	FrameworkReporter.info("Clicked on Toggle button");
		
}

/**
 * @Function setLocationExpanderValue
 * @Description To set location expander value to true if more than 3 locations are available
 * @author Gayathri
 * @date 20-10-2016
 */
public void setLocationExpanderValue(boolean bVal){
	storeValue("locationExpander", bVal);
}

/**
 * @Function setCategoryExpanderValue
 * @Description To set category expander value to true if more than 3 category are available
 * @author Gayathri
 * @date 20-10-2016
 */
public void setCategoryExpanderValue(boolean bVal){
	storeValue("categoryExpander", bVal);
}
/*********
 * Framework function : DO NOT UPDATE/DELETE
 *********/

public String[] getObject(String[] parentObject)
{
	
	String[] childClassObject =null;
	String brand =ConfigFile.getProperty("brand").toString().toLowerCase().trim();
	switch (brand) {
			case "iphone":				
				//childClassObject= new IOSExpenseCategoriesPage().findChildObject(parentObject[2]);	
				break;
			case "ipad":	
				childClassObject = new IOSTabletSetupInventoryPage().findChildObject(parentObject[2]);	
				break;
			case "android":
				childClassObject = new AndroidSetupInventoryPage().findChildObject(parentObject[2]);					
				break;
			case "android tablet":
				break;
				
			case "desktop":
				break;
			default:
				break;
			}
		
		if(null!=childClassObject){
			return childClassObject;}
			
return parentObject;
}


public void temp1(){
	locItemMap.put("Egg Shell Extra Large Brown", "Cat1");
	locItemMap.put("Clam Stuffed Premium", "Cat3");
	locItemMap.put("Beef Tenderloin Peeled Silver Skin-Side Muscle On Select Frozen", "Cat2");
	locItemMap.put("Egg Quail", "Cat3");
	locItemMap.put("Juice Orange Nectar Thick", "Cat2");	
}
}

