		
		/**
		 ********************************************************************************************************************************************
		 ********************************************************************************************************************************************
		 *																																		   	*
		 * 2016-2017 Infosys Limited, Banglore, India. All Rights Reserved																			*

		 * Version: 1.0																																*
		 * 																																			*
		 * Except for any free or open source software components embedded in this Infosys proprietary software program ("Program"),				*
		 * this Program is protected by copyright laws, international treaties and other pending or existing intellectual property rights in India, *
		 * the United States and other countries. Except as expressly permitted, any unautorized reproduction, storage, transmission 				*
		 * in any form or by any means (including without limitation electronic, mechanical, printing, photocopying, recording or otherwise), 		*
		 * or any distribution of this Program, or any portion of it, may result in severe civil and criminal penalties, 							*
		 * and will be prosecuted to the maximum extent possible under the law 																		*
		 *																																			*
		 ********************************************************************************************************************************************
		 ********************************************************************************************************************************************
		 **/
package com.uom.pages.common;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.plaf.basic.BasicSliderUI.ScrollListener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.framework.configuration.ConfigFile;
import com.framework.frameworkFunctions.LibraryPage;
import com.framework.reporting.FrameworkReporter;
import com.uom.commonFunctions.FunctionLibrary;
import com.uom.pages.androidPhone.AndroidAccountsPage;
import com.uom.pages.androidPhone.AndroidHomePage;
import com.uom.pages.androidPhone.AndroidNonSyscoPrepItemPage;
import com.uom.pages.iOSPhone.IOSAccountsPage;
import com.uom.pages.iOSPhone.IOSHomePage;
import com.uom.pages.iOSPhone.IOSNonSyscoPrepItemPage;
import com.uom.pages.iOSTablet.IOSTabletAccountsPage;
import com.uom.pages.iOSTablet.IOSTabletHomePage;
import com.uom.pages.iOSTablet.IOSTabletNonSyscoPrepItemPage;
import com.uom.tests.SetupInventory;




public class NonSyscoPrepItemPage extends LibraryPage{
	static Field[] declaredMemberVariables;
	static{
		declaredMemberVariables = NonSyscoPrepItemPage.class.getDeclaredFields();
	}
	
	//select supplier screen
	public static final String[] lnk_AddSupplier = {"//div[@class='mm-c-custom-setup__supplier']//a",XPATH,"lnk_AddSupplier"};	
	public static final String[] txt_SupplierName = {"//div[@class='mm-c-custom-setup__supplier']//input[contains(@class,'setup__category-name')]",XPATH,"txt_SupplierName"};
	public static final String[] lnk_Close = {"//a[@class='mm-o-icon icon-cross-circle']",XPATH,"lnk_Close"};
	public static final String[] btn_Next = {"//button[contains(text(),'Next')]",XPATH,"btn_Next"};		
	public static final String[] btn_Save = {"//button[contains(text(),'Save')]",XPATH,"btn_Save"};			 

	public static final String[] lbl_MultiStepSetupFlow={"//*[contains(@class,'mm-c-progress__steps-4 clearfix')]",XPATH,"lbl_MultiStepSetupFlow"};
	public static final String[] lbl_PrepMultiStepSetupFlow={"//div[@class='mm-c-progress__bars']",XPATH,"lbl_PrepMultiStepSetupFlow"};
	public static final String[] lbl_CreateSupplierForm={"//div[@class='mm-c-custom-setup__supplier']//*[@class='mm-c-custom-setup__form-options ']",XPATH,"frm_CreateSupplier"};
	public static final String[] lbl_SupplierName={"//label[contains(text(),'{dynamic1}')]",XPATH,"lbl_SupplierName"};
	public static final String[] lbl_SelectSupplierPage={"//*[contains(text(),'SELECT SUPPLIER')]",XPATH,"lbl_SelectSupplierPage"};
			
	//Product details screen
	public static final String[] txt_ProductName = {"name",ID,"txt_ProductName"};	
	public static final String[] txt_NickName = {"nickName",ID,"txt_NickName"};
	public static final String[] txt_ProductBrand = {"brand",ID,"txt_ProductBrand"};
	public static final String[] txt_UPCID = {"materialId",ID,"txt_UPCID"};	
	public static final String[] txt_Pack = {"pack",ID,"txt_Pack"};
	public static final String[] txt_Size = {"size",ID,"txt_Size"};
	public static final String[] txt_Weight = {"averageWeightPerCase",ID,"txt_Weight"};	
	public static final String[] txt_Price = {"price",ID,"txt_Price"};
	public static final String[] lst_PriceUOMAttribute = {"priceUom",ID,"lst_PriceUOMAttribute"};	
	public static final String[] btn_Previous = {"//button[contains(text(),'Previous')]",XPATH,"btn_Previous"};
	public static final String[] lbl_ProductDetails = {"//*[contains(text(),'Product Details')]",XPATH,"lbl_ProductDetails"};
	public static final String[] lbl_AddProductPage = {"//*[contains(text(),'Add Product')]",XPATH,"lbl_AddProductPage"};
	
	public static final String[] lbl_ProductName = {"//label[@for='name']",XPATH,"lbl_ProductName"};	
	public static final String[] lbl_NickName = {"//label[@for='nickName']",XPATH,"lbl_NickName"};
	public static final String[] lbl_ProductBrand = {"//label[@for='brand']",XPATH,"lbl_ProductBrand"};
	public static final String[] lbl_UPCID = {"//label[@for='materialId']",XPATH,"lbl_UPCID"};	
	public static final String[] lbl_Pack = {"//label[@for='pack']",XPATH,"lbl_Pack"};
	public static final String[] lbl_Size = {"//label[@for='size']",XPATH,"lbl_Size"};
	public static final String[] lbl_Weight = {"//label[@for='averageWeightPerCase']",XPATH,"lbl_Weight"};	
	public static final String[] lbl_Price = {"//label[@for='price']",XPATH,"lbl_Price"};
	public static final String[] lbl_SelectSupplier = {"//label[contains(text(),'SELECT SUPPLIER')]",XPATH,"lbl_SelectSupplier"};
	
	//select expenses screen
	public static final String[] lnk_AddCategoryExpense= {"//div[@class='mm-c-custom-setup__expense']//a",XPATH,"lnk_AddCategoryExpense"};
	public static final String[] txt_CateoryName= {"//div[@class='mm-c-custom-setup__expense']//input[contains(@class,'setup__category-name')]",XPATH,"txt_CateoryName"};
	public static final String[] btn_DefaultLocationCategory= {"//button[text()='{dynamic1}']",XPATH,"btn_DefaultLocationCategory"};
	
	public static final String[] rbtn_Supplier = {"//input[@value='{dynamic1}']//ancestor::div[@class='radio']/label",XPATH,"rbtn_Supplier"};
	public static final String[] rbtn_ExpenseCategory= {"(//span[text()='{dynamic1}'])[1]/ancestor::div[1]/div[@class='radio']/label",XPATH,"rbtn_ExpenseCategory"};
	public static final String[] rbtn_SelectLocation= {"(//span[text()='{dynamic1}'])[1]/ancestor::div[1]/div[@class='checkbox']/label",XPATH,"rbtn_SelectLocation"};
	
	public static final String[] lbl_SelectExpensePage = {"//*[contains(text(),'SELECT EXPENSES')]",XPATH,"lbl_SelectExpensePage"};
	public static final String[] lbl_CategoryName={"(//span[text()='{dynamic1}'])[1]",XPATH,"lbl_CategoryName"};
	public static final String[] lbl_AllCategoryNames={"(//label[@class='control-label']/span[1])",XPATH,"lbl_AllCategoryNames"};
	public static final String[] rbtn_Category = {"//input[@type='radio' and @value='{dynamic1}']",XPATH,"rbtn_Category"};	
	//Select location screen
	public static final String[] lnk_AddLocation= {"//div[@class='mm-c-custom-setup__location']//a",XPATH,"lnk_AddLocation"};
	public static final String[] txt_LocationName= {"//div[@class='mm-c-custom-setup__location']//input[contains(@name,'name')]",XPATH,"txt_LocationName"};
//	public static final String[] btn_CoolerFreezerDry= {"//button[text()='{dynamic1}']",XPATH,"btn_CoolerFreezerDry"};      // Don't delelet this - Periya
//	public static final String[] rbtn_Location= {"(//span[text()='{dynamic1}'])[1]/ancestor::div[1]/div[@class='radio']",XPATH,"rbtn_Location"};  // Don't delelet this - Periya
	public static final String[] btn_Done = {"//button[contains(text(),'Done')]",XPATH,"btn_Done"};
	public static final String[] lbl_SelectLocationsPage = {"//*[contains(text(),'SELECT LOCATION')]",XPATH,"lbl_SelectLocationsPage"};
	
//	public static final String[] lst_LocUOMAttribute = {"uom",ID,"lst_LocUOMAttribute"};
	public static final String[] lbl_LocationName={"//span[contains(text(),'{dynamic1}')]",XPATH,"lbl_LocationName"};
	public static final String[] rbtn_Location = {"//input[@type='radio' and @value='{dynamic1}']",XPATH,"rbtn_Location"};	
	
	
	
	public static final String[] txt_LocationQty = {"(//span[text()='{dynamic1}'])[1]//following::div[@class='mm-c-custom-setup__uom-options'][1]//input[contains(@class,'mm-c-product-list__qty')]",XPATH,"txt_Quantity"};
	//public static final String[] lst_LocationQtyUOM={"(//span[text()='{dynamic1}'])[1]//following::select/option[1]",XPATH,"lst_LocationQtyUOM"};
	public static final String[] lst_LocationQtyUOM={"//UIAElement[@value='{dynamic1}']",XPATH,"lst_LocationQtyUOM"};
	public static final String[] lst_SelectLocationQtyUOM = {"(//span[text()='{dynamic1}'])[1]/ancestor::div[@class='mm-c-custom-setup__product-options']//child::select",XPATH,"lst_SelectLocationQtyUOM"};
	
	//Final variables 
	public static final String DAIRY="Dairy";
	public static final String MEAT="Meat";
	public static final String POULTRY="Poultry";
	public static final String SEAFOOD="Seafood";
	public static final String PRODUCE="Produce";
	public static final String CANNEDANDDRY="Canned and Dry";
	public static final String DISPENSER="Dispenser Beverage";
	public static final String FROZEN="Frozen";
	public static final String CHEMICAL="Chemical & Janatorial";
	public static final String PAPERDISPOSE="Paper & Disposable";
	public static final String SUPPLIES="Supplies & Equipment";
	public static final String HEALTHCARE="Healthcare & Hospitality";
	
	/**
	 * @function verifyAddProductPage
	 * @author Periyasamy Nainar
	 * @description verify Add product page is displayed while creating a non sysco or prep item page
	 * @date 23-09-2016
	 */

	public void verifyAddProductPage(){
		switchToWebContext();
		if(isElementPresent(lbl_AddProductPage)){
			FrameworkReporter.pass("Add Product page is displayed in non sysco or prep item page");
		}else{
			FrameworkReporter.fail("Add Product page is not displayed in non sysco or prep item page");
		}
		
		
	}
	
	
	/**
	 * @function verifyProductDetailsPage
	 * @author Periyasamy Nainar
	 * @description verify product details page is displayed while creating a non sysco or prep item page
	 * @date 23-09-2016
	 */

	public void verifyProductDetailsPage(){
		switchToWebContext();
		if(isElementPresent(lbl_ProductDetails)){
			FrameworkReporter.pass("Product details page is displayed in non sysco or prep item page");
		}else{
			FrameworkReporter.fail("Product details page is not displayed in non sysco or prep item page");
		}
		
		
	}
	/**
	 * @function verifySelectCategoryPage
	 * @author Periyasamy Nainar
	 * @description verify select category page is displayed while creating a non sysco or prep item page
	 * @date 23-09-2016
	 */

	public void verifySelectCategoryPage(){
		switchToWebContext();
		if(isElementPresent(lbl_SelectExpensePage)){
			FrameworkReporter.pass("Select Expense page is displayed in non sysco or prep item page");
		}else{
			FrameworkReporter.fail("Select Expense page is not displayed in non sysco or prep item page");
		}
		
		
	}
	
	
	/**
	 * @function verifySelectLocationPage
	 * @author Periyasamy Nainar
	 * @description verify select location page is displayed while creating a non sysco or prep item page
	 * @date 23-09-2016
	 */

	public void verifySelectLocationPage(){
		switchToWebContext();
		if(isElementPresent(lbl_SelectLocationsPage)){
			FrameworkReporter.pass("Select Location page is displayed in non sysco or prep item page");
		}else{
			FrameworkReporter.fail("Select Location page is not displayed in non sysco or prep item page");
		}
	}
	
	/**
	 * @function verifyAddSupplierOption
	 * @author Periyasamy Nainar
	 * @description verify add supplier link is present in create non sysco or prep item page
	 * @date 23-09-2016
	 */

	public void verifyAddSupplierOption(Boolean boolVal){
		switchToWebContext();
		if(boolVal){
			if(isElementPresentAfterWait(lnk_AddSupplier,10)){
				FrameworkReporter.pass("Add supplier link is present in create non sysco or prep item page");			
			}else{
				FrameworkReporter.fail("Add supplier link is not present in create non sysco or prep item page");
			}
		}else{
				if(!(isElementPresentAfterWait(lnk_AddSupplier,10))){
					FrameworkReporter.pass("Add supplier link is not present in create non sysco or prep item page");			
				}else{
					FrameworkReporter.fail("Add supplier link is present in create non sysco or prep item page");
				}
			}
		
		
	}
	
	
	/**
	 * @function verifyAddNewCategoryOption
	 * @author Periyasamy Nainar
	 * @description verify add category link is present in create non sysco or prep item page
	 * @date 23-09-2016
	 */

	public void verifyAddNewCategoryOption(){
		switchToWebContext();
		if(isElementPresent(lnk_AddCategoryExpense)){
			FrameworkReporter.pass("Add Catogory link is present in create non sysco or prep item page");
		}else{
			FrameworkReporter.fail("Add Catogory link is not present in create non sysco or prep item page");
		}
		
		
	}
	
	/**
	 * @function verifyAddNewLocationOption
	 * @author Periyasamy Nainar
	 * @description verify add Location link is present in create non sysco or prep item page
	 * @date 23-09-2016
	 */

	public void verifyAddNewLocationOption(){
		switchToWebContext();
		if(isElementPresent(lnk_AddLocation)){
			FrameworkReporter.pass("Add Location link is present in create non sysco or prep item page");
		}else{
			FrameworkReporter.fail("Add Location link is not present in create non sysco or prep item page");
		}
	}
	

	
	
	/**
	 * @function verifyPreviousButton
	 * @author Periyasamy Nainar
	 * @description verify Previous button is present in create non sysco or prep item page
	 * @date 23-09-2016
	 */

	public void verifyPreviousButton(){
		switchToWebContext();
		if(isElementPresent(btn_Previous)){
			FrameworkReporter.pass("Previous button is displayed in non sysco or prep item page");			
		}else{
			FrameworkReporter.fail("Previous button is not displayed in non sysco or prep item page");
		}
		
		
	}
	
	/**
	 * @function verifyProductPageFields
	 * @author Periyasamy Nainar
	 * @description verify product page fields ( label and text box ) in product details screen while creating non sysco or prep item page
	 * @param strItemType - either nonsysco or prep 
	 * @date 23-09-2016
	 */

	public void verifyProductPageFields(String strItemType){	
		switchToWebContext();
		if(isElementPresent(lbl_ProductName) && isElementPresent(txt_ProductName)){
			FrameworkReporter.pass("Product name label and text box is displayed in product details screen in add product page");
		}else{
			FrameworkReporter.fail("Product name label and text box is not displayed in product details screen in add product page");
		}
		
		if(isElementPresent(lbl_NickName) && isElementPresent(txt_NickName)){
			FrameworkReporter.pass("Nick name label and text box is displayed in product details screen in add product page");
		}else{
			FrameworkReporter.fail("Nick name label and text box is not displayed in product details screen in add product page");
		}		
		
		if(isElementPresent(lbl_UPCID) && isElementPresent(txt_UPCID)){
			FrameworkReporter.pass("Product upcid label and text box is displayed in product details screen in add product page");
		}else{
			FrameworkReporter.fail("Product upcid label and text box is not displayed in product details screen in add product page");
		}
		
		if(isElementPresent(lbl_Pack) && isElementPresent(txt_Pack)){
			FrameworkReporter.pass("Product pack label and text box is displayed in product details screen in add product page");
		}else{
			FrameworkReporter.fail("Product pack label and text box is not displayed in product details screen in add product page");
		}
		
		if(isElementPresent(lbl_Size) && isElementPresent(txt_Size)){
			FrameworkReporter.pass("Product size label and text box is displayed in product details screen in add product page");
		}else{
			FrameworkReporter.fail("Product size label and text box is not displayed in product details screen in add product page");
		}
		
		if(isElementPresent(lbl_Weight) && isElementPresent(txt_Weight)){
			FrameworkReporter.pass("Product weight label and text box is displayed in product details screen in add product page");
		}else{
			FrameworkReporter.fail("Product weight label and text box is not displayed in product details screen in add product page");
		}
				
		//Below validations are applicable for only non sysco items
		if(strItemType.equalsIgnoreCase("nonsysco")){
			
			if(isElementPresent(lbl_ProductBrand) && isElementPresent(txt_ProductBrand)){
				FrameworkReporter.pass("Product brand label and text box is displayed in product details screen in add product page");
			}else{
				FrameworkReporter.fail("Product brand label and text box is not displayed in product details screen in add product page");
			}
			
			if(isElementPresent(lbl_Price) && isElementPresent(txt_Price)){
				FrameworkReporter.pass("Product price label and text box is displayed in product details screen in add product page");
			}else{
				FrameworkReporter.fail("Product price label and text box is not displayed in product details screen in add product page");
			}
			
			if(isElementPresent(lst_PriceUOMAttribute)){
				FrameworkReporter.pass("Product price UOM Attirbute list box is displayed in product details screen in add product page");
			}else{
				FrameworkReporter.fail("Product price UOM Attirbute list box is not displayed in product details screen in add product page");
			}
		}
		
		
	}
	
	/**
	 * @function tapAddNewSupplier
	 * @author Periyasamy Nainar
	 * @description Tap on Add new supplier button while creating non sysco or prep item
	 * @date 23-09-2016
	 */
	public void tapAddNewSupplier(){
		switchToWebContext();
		clickElement(lnk_AddSupplier);
		FrameworkReporter.info("Tapped on Add new supplier link ");
		
	}
	
	
	
	/**
	 * @function addSupplier
	 * @author Periyasamy Nainar
	 * @description Enter supplier name to create new supplier while creating non sysco or prep item
	 * @param strSupplierName - Supplier name to create new supplier
	 * @date 23-09-2016
	 */
	public void enterSupplierName(String strSupplierName){
		switchToWebContext();
		sendText(txt_SupplierName, strSupplierName);
		FrameworkReporter.info("Entered supplier name as "+ strSupplierName);
		
	}
	
	
	/**
	 * @function selectSupplier
	 * @author Periyasamy Nainar
	 * @description select supplier name from list of suppliers while creating non sysco or prep item
	 * @param strSupplierName - Supplier name to select from list
	 * @date 23-09-2016
	 */
	public void selectSupplier(String strSupplierName){	
		switchToWebContext();
		clickElement(replaceDynamicText(rbtn_Supplier, strSupplierName));
		FrameworkReporter.info("Selected the supplier from select supplier screen: "+ strSupplierName);
		
	}
	
	
	/**
	 * @function selectCategory
	 * @author Periyasamy Nainar
	 * @description select category from list of categories while creating non sysco or prep item
	 * @param strCategoryName - category name to select from list
	 * @date 23-09-2016
	 */
	public void selectCategory(String strCategoryName){
		swipeScreenInVertical(8,2);
		switchToWebContext();
		moveToElement(replaceDynamicText(rbtn_ExpenseCategory,strCategoryName));
		clickElement(replaceDynamicText(rbtn_ExpenseCategory,strCategoryName));
		FrameworkReporter.info("Selected the category from select category screen: "+ strCategoryName);
		
	}
	
	//Even though the logic for the above & below functions are remains same, keeping it in different function for easy understanding during script creation and different log message. But we have used the same object ,so redundant functions are not created
	/**
	 * @function selectLocation
	 * @author Periyasamy Nainar
	 * @description select location from list of categories while creating non sysco or prep item
	 * @param strLocationName - location name to select from list
	 * @date 23-09-2016
	 */
	public void selectLocation(String strLocationName){
		switchToWebContext();
		clickElement(replaceDynamicText(rbtn_SelectLocation,strLocationName));
		FrameworkReporter.info("Selected the location from select location screen: "+ strLocationName);
		
	}
	
	
	/**
	 * @function tapAddNewCategoryExpense
	 * @author Periyasamy Nainar
	 * @description Tap add new category expense link from select expense screen in Add product page
	 * @date 23-09-2016
	 */
	public void tapAddNewCategoryExpense(){
		switchToWebContext();
		clickElement(lnk_AddCategoryExpense);
		FrameworkReporter.info("Tap on add new category expense");		
		
	}
	

	/**
	 * @function tapAddNewLocation
	 * @author Periyasamy Nainar
	 * @description Tap add new location link from select expense screen in Add product page
	 * @date 23-09-2016
	 */
	public void tapAddNewLocation(){
		switchToWebContext();
		clickElement(lnk_AddLocation);
		FrameworkReporter.info("Tap on add new category expense");		
		
	}
	
	/**
	 * @function enterCategoryDetails
	 * @author Periyasamy Nainar
	 * @description Add new category from select expense screen while creating non sysco or prep item
	 * @param strCategoryName - category name to add , StrCategoryType - Type of category ( F, D, C )
	 * @date 23-09-2016
	 */
	
	public void enterCategoryDetails(String strCategoryName, String strCategoryType){	
		switchToWebContext();
		sendText(txt_CateoryName, strCategoryName);		
		clickElement(replaceDynamicText(btn_DefaultLocationCategory,strCategoryType.toUpperCase()));
		FrameworkReporter.info("Entered Category name:"+ strCategoryName+ " Selected Category Type: " + strCategoryType);	
		
	}
	
	/**
	 * @function enterLocationDetails
	 * @author Periyasamy Nainar
	 * @description Add new category from select expense screen while creating non sysco or prep item
	 * @param strLocationName - Location name to add , StrLocationType - Type of Location ( F, D, C )
	 * @date 23-09-2016
	 */
	
	public void enterLocationDetails(String strLocationName, String strLocationType){		
		switchToWebContext();
		sendText(txt_LocationName, strLocationName);
		clickElement(replaceDynamicText(btn_DefaultLocationCategory, strLocationType.toUpperCase()));
		FrameworkReporter.info("Entered Location name:"+ strLocationName+ " Selected Location Type: " + strLocationType);
		
	}
	
	
	
	
	/**
	 * @function verifyNonSyscoItemMandatoryFields
	 * @author Gayathri Anand
	 * @description Verify mandatory fields for Non sysco item
	 * @param strHomeOrTrackInvent - Home or Track inventory 
	 * @date 24-09-2016
	 */
	public void verifyNonSyscoItemMandatoryFields(String strHomeOrTrackInvent){		
		switchToWebContext();
		if(getElementAttributeValue(lbl_ProductName, "class").contains("asterisk")){
			FrameworkReporter.pass("Product name is displayed as mandatory field for Non sysco items");
		}
		else{
			FrameworkReporter.fail("Product name is not displayed as mandatory field for Non sysco items");
		}
		if(getElementAttributeValue(lbl_ProductBrand, "class").contains("asterisk")){
			FrameworkReporter.pass("Product brand is displayed as mandatory field for Non sysco items");
		}
		else{
			FrameworkReporter.fail("Product brand is not displayed as mandatory field for Non sysco items");
		}
		if(getElementAttributeValue(lbl_UPCID, "class").contains("asterisk")){
			FrameworkReporter.pass("Product id is displayed as mandatory field for Non sysco items");
		}
		else{
			FrameworkReporter.fail("Product id is not displayed as mandatory field for Non sysco items");
		}
		if(getElementAttributeValue(lbl_Price, "class").contains("asterisk")){
			FrameworkReporter.pass("Product price is displayed as mandatory field for Non sysco items");
		}
		else{
			FrameworkReporter.fail("Product price is not displayed as mandatory field for Non sysco items");
		}
		//Below validation is applicable only when we are creating non sysco items from track inventory flow. Not applicable while creating item from home page. 
		// Parameter should be either Home or Trackinventory
		if(!(strHomeOrTrackInvent.equalsIgnoreCase("Home"))){
			if(getElementAttributeValue(lbl_SelectSupplier, "class").contains("asterisk")){
				FrameworkReporter.pass("Select supplier is displayed as mandatory field for Non sysco items");
			}
			else{
				FrameworkReporter.fail("Select supplier is not displayed as mandatory field for Non sysco items");
				}
			}
		
	}
	
	
	/**
	 * @function verifyPrepItemMandatoryFields
	 * @author Gayathri Anand
	 * @description Verify mandatory fields for Non sysco item
	 * @date 24-09-2016
	 */
	public void verifyPrepItemMandatoryFields(){	
		switchToWebContext();
		if(getElementAttributeValue(lbl_ProductName, "class").contains("asterisk")){
			FrameworkReporter.pass("Product name is displayed as mandatory field for Prep items");
		}
		else{
			FrameworkReporter.fail("Product name is not displayed as mandatory field for Prep items");
		}
	}
	
	/**
	 * @function verifyMultiStepSetUpFlow
	 * @author Gayathri Anand
	 * @description Verify multi step setup flow is displayed
	 * @date 26-09-2016
	 */
	public void verifyMultiStepSetUpFlow(){	
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_MultiStepSetupFlow,5)){
			FrameworkReporter.pass("Multi step setup flow is displayed");
		}
		else{
			FrameworkReporter.fail("Multi step setup flow is not displayed");
		}
	}
	
	
	/**
	 * @function verifyPrepMultiStepSetUpFlow
	 * @author Periyasamy Nainar
	 * @description Verify multi step setup flow is displayed for prep item
	 * @date 30-09-2016
	 */
	public void verifyPrepMultiStepSetUpFlow(){	
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_PrepMultiStepSetupFlow,5)){
			FrameworkReporter.pass("Multi step setup flow for Prep item is displayed");
		}
		else{
			FrameworkReporter.fail("Multi step setup flow for prep item is not displayed");
		}
	}
	
	
	
	/**
	 * @function verifyCreateSupplierForm
	 * @author Gayathri Anand
	 * @description Verify create supplier form is displayed or not
	 * @date 26-09-2016
	 */
	public void verifyCreateSupplierForm(boolean isExpected){	
		switchToWebContext();
		if(isExpected){
			if(isElementPresent(lbl_CreateSupplierForm)){
				FrameworkReporter.pass("Create supplier form is displayed");
			}
			else{
				FrameworkReporter.fail("Create supplier form is not displayed");
			}
		}
		else{
			if(isElementPresent(lbl_CreateSupplierForm)){
				FrameworkReporter.fail("Create supplier form is displayed");
			}
			else{
				FrameworkReporter.pass("Create supplier form is not displayed");
			}
		}
	}
	
	/**
	 * @function verifySupplierInSupplierList
	 * @author Gayathri Anand
	 * @description Verify supplier is displayed in the list in Select Supplier screen
	 * @date 26-09-2016
	 */
	public void verifySupplierInSupplierList(String strSupplierName,boolean isExpected){	
		switchToWebContext();
		if(isExpected){
			if(isElementPresentAfterWait(replaceDynamicText(lbl_SupplierName, strSupplierName),10)){
				FrameworkReporter.pass("Supplier '"+strSupplierName+"' is displayed in the supplier list");
			}
			else{
				FrameworkReporter.fail("Supplier '"+strSupplierName+"' is not displayed in the supplier list");
			}
		}
		else{
			if(isElementPresent(replaceDynamicText(lbl_SupplierName, strSupplierName))){
				FrameworkReporter.fail("Supplier '"+strSupplierName+"' is displayed in the supplier list");
			}
			else{
				FrameworkReporter.pass("Supplier '"+strSupplierName+"' is not displayed in the supplier list");
			}
		}
	}
	/**
	 * @function verifySupplierSelected
	 * @author Gayathri Anand
	 * @description Verify supplier selected in the list
	 * @date 26-09-2016
	 */
	public void verifySupplierSelected(String strSupplierName){
		switchToWebContext();
	//	if(getElementAttributeValue(replaceDynamicText(rbtn_Supplier,strSupplierName), "checked").equals("true")){
		System.out.println("test");
		WebElement element = getDriver().findElement(By.xpath("//div[@class='radio']//input"));
		if(element.isSelected()){
			System.out.println("yes");
		}
		if(waitForElementPresent(replaceDynamicText(rbtn_Supplier,strSupplierName)).isEnabled()){
			FrameworkReporter.pass("Supplier '"+strSupplierName+"' is selected");
		}
		else{
			FrameworkReporter.fail("Supplier '"+strSupplierName+"' is not selected");
		}
	}
	
	/**
	 * @function verifySelectSupplierPage
	 * @author Gayathri Anand
	 * @description verify select supplier page is displayed while creating a non sysco or prep item page
	 * @date 23-09-2016
	 */

	public void verifySelectSupplierPage(){
		switchToWebContext();
		if(isElementPresent(lbl_SelectSupplierPage)){
			FrameworkReporter.pass("Select Supplier page is displayed in non sysco or prep item page");
		}else{
			FrameworkReporter.fail("Select Supplier page is not displayed in non sysco or prep item page");
		}
	}
	
	/**
	 * @function verifyCategoryInCategoryList
	 * @author Gayathri Anand
	 * @description Verify category is displayed in the list in Select Expenses page
	 * @date 26-09-2016
	 */
	public void verifyCategoryInCategoryList(String strCategoryName,boolean isExpected){	
		switchToWebContext();
		if(isExpected){
			if(isElementPresent(replaceDynamicText(lbl_CategoryName, strCategoryName))){
				FrameworkReporter.pass("Category "+strCategoryName+"' is displayed in the category list");
			}
			else{
				FrameworkReporter.fail("Category "+strCategoryName+"' is not displayed in the category list");
			}
		}
		else{
			if(isElementPresent(replaceDynamicText(lbl_CategoryName, strCategoryName))){
				FrameworkReporter.fail("Category "+strCategoryName+"' is displayed in the category list");
			}
			else{
				FrameworkReporter.pass("Category "+strCategoryName+"' is not displayed in the category list");
			}
		}
	}
	
	
	/**
	 * @function verifySuggestedCategoryInCategoryList
	 * @author Periyasamy Nainar
	 * @description Verify all suggested categories are displayed in the list in Select Expenses page
	 * @date 26-09-2016
	 */
	public void verifySuggestedCategoryInCategoryList(){	
		switchToWebContext();
		Boolean boolVal = false;
		ArrayList<String> listSuggestedCat =getSuggestedCategories();		
		List<WebElement> elements = getElements(lbl_AllCategoryNames);
		int arraySize = listSuggestedCat.size();
		if(elements.size()== arraySize){
			FrameworkReporter.pass("Number of suggested categories displayed in select expense categories page is correct");
		}else{
			FrameworkReporter.pass("Number of suggested categories displayed in select expense categories page is not correct");
		}
		for(WebElement ele: elements){
			for(int j =0; j < arraySize; j++){				
				if(ele.getText().equalsIgnoreCase(listSuggestedCat.get(j))){						
						boolVal = true;
						break;
					}		
			}
			
			if(boolVal){						
				FrameworkReporter.pass("Suggested Category '"+ele.getText()+"' is displayed in the category list");
			}else{
				FrameworkReporter.fail("Suggested Category '"+ele.getText()+"' is not displayed in the category list");
			}	
		}
		
	}
	

	/**
	 * @function verifyLocationInList
	 * @author Gayathri Anand
	 * @description Verify location is displayed in the list in Select Locations page
	 * @date 26-09-2016
	 */
	public void verifyLocationInList(String strLocationName,boolean isExpected){	
		switchToWebContext();
		if(isExpected){
			if(isElementPresent(replaceDynamicText(lbl_LocationName, strLocationName))){
				FrameworkReporter.pass("Location "+strLocationName+"' is displayed in the list");
			}
			else{
				FrameworkReporter.fail("Location "+strLocationName+"' is not displayed in the list");
			}
		}
		else{
			if(isElementPresent(replaceDynamicText(lbl_LocationName, strLocationName))){
				FrameworkReporter.fail("Location "+strLocationName+"' is displayed in the list");
			}
			else{
				FrameworkReporter.pass("Location "+strLocationName+"' is not displayed in the list");
			}
		}
	}
	/**
	 * @function verifyCategorySelected
	 * @author Gayathri Anand
	 * @description Verify category selected in the list
	 * @date 26-09-2016
	 */
	public void verifyCategorySelected(String strCategoryName){
		switchToWebContext();
		if(getElementAttributeValue(replaceDynamicText(rbtn_Category,strCategoryName), "checked").equals("true")){
			FrameworkReporter.pass("Category '"+strCategoryName+"' is selected");
		}
		else{
			FrameworkReporter.fail("Category '"+strCategoryName+"' is not selected");
		}
	}
	/**
	 * @function verifyLocationSelected
	 * @author Gayathri Anand
	 * @description Verify location selected in the list
	 * @date 26-09-2016
	 */
	public void verifyLocationSelected(String strLocationName){
		switchToWebContext();
		if(getElementAttributeValue(replaceDynamicText(rbtn_Location,strLocationName), "checked").equals("true")){
			FrameworkReporter.pass("Location '"+strLocationName+"' is selected");
		}
		else{
			FrameworkReporter.fail("Location '"+strLocationName+"' is not selected");
		}
	}
	
	
	/**
	 * @function verifyLocationQtyIAndUOMAttrFields
	 * @author Periyasasmy_Nainar
	 * @description Verify location Qty and UOM Attribute fields are displayed in select location screen
	 * @date 01-10-2016
	 */
	public void verifyLocationQtyIAndUOMAttrFields(String strLocationName){
		switchToWebContext();
		if(isElementPresentAfterWait(replaceDynamicText(txt_LocationQty, strLocationName), 5)){
			FrameworkReporter.pass("Location Qty is displayed next to location"+ strLocationName + " in Select Location screen");
		}
		else{
			FrameworkReporter.fail("Location Qty is not displayed next to location"+ strLocationName + " in Select Location screen");
		}
		
	//	if(isElementPresentAfterWait(replaceDynamicText(lst_LocationQtyUOM,strLocationName), 5)){  
		if(isElementPresentAfterWait(replaceDynamicText(lst_SelectLocationQtyUOM,strLocationName), 5)){  
			FrameworkReporter.pass("Location UOM Attribute is displayed next to location"+ strLocationName + " in Select Location screen");
		}
		else{
			FrameworkReporter.fail("Location UOM Attribute is not displayed next to location"+ strLocationName + " in Select Location screen");
		}
		
	}
	
	
	/**
	 * @function enterQuantity
	 * @author Periyasamy Nainar
	 * @description Enter quantity in qty text box against location in location list while creating non sysco or prep item
	 * @param strQty - Quantity amount,  StrLocationType - Type of Location ( ex. F, D, C )
	 * @date 01-10-2016
	 */
	public void enterQuantity(String strLocationType, String strQty){		
		switchToWebContext();
		sendText(replaceDynamicText(txt_LocationQty, strLocationType), strQty);		
		FrameworkReporter.info("Entered Quantity" + strQty+ " for location :"+ strLocationType);

    }
	
	
	/**
	 * @function tapQuantityUOMAttribute
	 * @author Periyasamy Nainar
	 * @description Enter quantity in qty text box against location in location list while creating non sysco or prep item
	 * @param  StrLocationType - Type of Location ( ex. F, D, C )
	 * @date 01-10-2016
	 */
	public void tapQuantityUOMAttribute(String strLocationType){	
		if(!(ConfigFile.getProperty("brand").equalsIgnoreCase("android"))){
			switchToWebContext();
			WebElement element = waitForElementPresent(replaceDynamicText(lst_SelectLocationQtyUOM, strLocationType));
			Select sel = new Select(element);				
			consolePrint(sel.getFirstSelectedOption().toString());
			String str = sel.getFirstSelectedOption().getAttribute("value").toString();
			switchToNativeContext();
			clickElement(replaceDynamicText(getObject(lst_LocationQtyUOM),str.toUpperCase()));	
			}else{		
				switchToWebContext();
				clickElement(replaceDynamicText(getObject(lst_LocationQtyUOM),strLocationType));	
			}
		//switchToWebContext();
		
		FrameworkReporter.info("Tapped on UOM Attribute to change the value for location : "+ strLocationType);

    }
	
	
	/**
	 * @function getSuggestedCategories
	 * @author Periyasamy Nainar
	 * @description To get all suggested categories
	 * @date 30-09-2016
	 */
	
	public ArrayList<String> getSuggestedCategories(){			
	ArrayList<String> listSuggestedCat = new ArrayList<String>();
				listSuggestedCat.add(DAIRY);
				listSuggestedCat.add(MEAT);
				listSuggestedCat.add(POULTRY);
				listSuggestedCat.add(SEAFOOD);
				listSuggestedCat.add(PRODUCE);
				listSuggestedCat.add(FROZEN);
				listSuggestedCat.add(DISPENSER);
				listSuggestedCat.add(SUPPLIES);
				listSuggestedCat.add(CANNEDANDDRY);
				listSuggestedCat.add(HEALTHCARE);
				listSuggestedCat.add(CHEMICAL);
				listSuggestedCat.add(PAPERDISPOSE);				
	return listSuggestedCat;
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
					//childClassObject= new IOSNonSyscoPrepItemPage().findChildObject(parentObject[2]);	
					break;
				case "ipad":	
					childClassObject = new IOSTabletNonSyscoPrepItemPage().findChildObject(parentObject[2]);	
					break;
				case "android":
					childClassObject = new AndroidNonSyscoPrepItemPage().findChildObject(parentObject[2]);					
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
	

	
	
}