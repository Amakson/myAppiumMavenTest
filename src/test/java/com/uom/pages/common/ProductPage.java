package com.uom.pages.common;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.framework.configuration.ConfigFile;
import com.framework.frameworkFunctions.LibraryPage;
import com.framework.reporting.FrameworkReporter;
import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;
import com.uom.commonFunctions.FunctionLibrary;
import com.uom.pageFactory.PageFactory;
import com.uom.pages.androidPhone.AndroidNonSyscoPrepItemPage;
import com.uom.pages.androidPhone.AndroidProductPage;
import com.uom.pages.iOSPhone.IOSNonSyscoPrepItemPage;
import com.uom.pages.iOSPhone.IOSProductPage;
import com.uom.pages.iOSTablet.IOSTabletNonSyscoPrepItemPage;
import com.uom.pages.iOSTablet.IOSTabletProductPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

public class ProductPage extends LibraryPage{

	static Field[] declaredMemberVariables;
	static{
		declaredMemberVariables = ProductPage.class.getDeclaredFields();
	}

	public static final String[] lbl_ProductDetailsPage={"//*[contains(text(),'Product Details')]",XPATH,"lbl_ProductDetailsPage"};
	public static final String[] img_Product={"(//*[@id='product-details']//img)[1]",XPATH,"img_Product"};
	public static final String[] lbl_ProductName={"//label[contains(text(),'PRODUCT NAME')]",XPATH,"lbl_ProductName"};
	public static final String[] txt_ProductName={"name",ID,"txt_ProductName"};
	public static final String[] lbl_NickName={"//label[contains(text(),'NICKNAME')]",XPATH,"lbl_NickName"};
	public static final String[] txt_NickName={"nickName",ID,"txt_NickName"};
	public static final String[] lbl_ProductBrand={"//label[contains(text(),'PRODUCT BRAND')]",XPATH,"lbl_ProductBrand"};
	public static final String[] txt_ProductBrand={"brand",ID,"txt_ProductBrand"};
	public static final String[] lbl_UPCID={"//label[contains(text(),'UPC/ID')]",XPATH,"lbl_UPCID"};
	public static final String[] txt_UPCID={"materialId",ID,"txt_UPCID"};
	public static final String[] lbl_Pack={"//label[contains(text(),'PACK')]",XPATH,"lbl_Pack"};
	public static final String[] txt_Pack={"pack",ID,"txt_Pack"};
	public static final String[] lbl_Size={"//label[contains(text(),'SIZE')]",XPATH,"lbl_Size"};
	public static final String[] txt_Size={"size",ID,"txt_Size"};
	public static final String[] lbl_Weight={"//label[contains(text(),'WEIGHT')]",XPATH,"lbl_Weight"};
	public static final String[] txt_Weight={"averageWeightPerCase",ID,"txt_Weight"};
	public static final String[] txt_Price={"price",ID,"txt_Price"};
	//public static final String[] lbl_Price={"price",ID,"txt_Price"};
	public static final String[] lbl_EditProduct={"//*[contains(text(),'Edit Product')]",XPATH,"lbl_EditProduct"};
	public static final String[] lbl_Price={"//label[contains(text(),'PRICE')]",XPATH,"lbl_Price"};

	//public static final String[] lbl_Price={"//label[contains(text(),'PRICE')]",XPATH,"lbl_Price"};
	public static final String[] lbl_ExpenseCategory={"//*[@id='expense-view']//*[contains(text(),'EXPENSE CATEGORY')]",XPATH,"lbl_ExpenseCategory"};
	public static final String[] lbl_ExpenseCategoryValue={"//*[@id='expense-view']//*[contains(@class,'product-details__expense')]",XPATH,"lbl_ExpenseCategoryValue"};
	public static final String[] lbl_Locations={"//*[contains(@class,'product-details__location-title')]",XPATH,"lbl_Locations"};
	public static final String[] lbl_LocationValueCount={"//*[contains(@class,'product-details__locations')]//*[contains(@class,'product-details__location disabled')]/span",XPATH,"lbl_LocationValueCount"};
	public static final String[] lbl_LocationValue={"(//*[contains(@class,'product-details__locations')]//*[contains(@class,'product-details__location disabled')]/span)[{dynamic1}]",XPATH,"lbl_LocationValue"};
	public static final String[] txt_LocationQuantity={"locations[{dynamic1}].quantity",NAME,"txt_LocationQuantity"};
	public static final String[] lst_LocationQuantityUOM={"locations[{dynamic1}].quantityUom",NAME,"lst_LocationQuantityUOM"};
	public static final String[] lbl_SelectExpense={"//*[@id='expense-add']//*[contains(text(),'SELECT EXPENSE')]",XPATH,"lbl_SelectExpense"};
	public static final String[] lst_SelectExpense1={"expense",NAME,"lst_SelectExpense"};


	public static final String[] lst_LocationsCount={"//*[contains(@class='mm-c-product-details__location']",XPATH,"lst_LocationsCount"};
	public static final String[] lst_Location={"locations[{dynamic1}].groupId",NAME,"lst_Locations"};
	public static final String[] lst_Locations={"//*[@class='mm-c-product-details__location']",XPATH,"lst_Locations"};
	//
	public static final String[] lnk_LocationDelete={"(//*[contains(@class,'product-details__locations')]//*[@id='delete'])[{dynamic1}]",XPATH,"lnk_LocationDelete"};	
	public static final String[] lnk_AddAnotherLocation={"Add Another Location",LINKTEXT,"lnk_AddAnotherLocation"};

	//native element
	//public static final String[] lst_LocQtyUOMNative={"//*[@content-desc='{dynamic1}']",XPATH,"lst_LocQtyUOMNative"};
	public static final String[] lst_DropdownOption={"//android.widget.CheckedTextView[@text='{dynamic1}']",XPATH,"lst_LocationOptions"};
	public static final String[] lst_DropdownOptions={"//android.widget.CheckedTextView[@index='{dynamic1}']",XPATH,"lst_LocationOptions"};
	//	public static final String[] lst_LocQtyUOMNative={"//*[@value='{dynamic1}']",XPATH,"lst_LocQtyUOMNative"};
	//UIAWebView[1]/UIAElement[1][@value='CS']
	public static final String[] lst_LocQtyUOMNative= {"//UIAElement[@value='{dynamic1}']",XPATH,"lst_LocQtyUOMNative"};

	//arun
	public static final String[] lbl_UOMAttribute= {"//select[@name='locations[0].quantityUom']",XPATH,"lbl_UOMAttribute"};

	//UIAWebView[1]/UIAElement[1]
	public int lastLocationIndex=0;
	//public static final String[] lst_SelectSupplier={"//*[@id='supplier-add']",XPATH,"lst_SelectSupplier"};
	//public static final String[] lst_SelectSupplier={"//select[@name='supplier']/option[1]",XPATH,"lst_SelectSupplier"};
	public static final String[] lst_SelectSupplier= {"//UIAWebView[1]/UIAElement[2]",XPATH,"lst_SelectSupplier"};
	public static final String[] lst_SelectExpenseCategory= {"//UIAWebView[1]/UIAElement[{dynamic1}]",XPATH,"lst_SelectExpenseCategory"};

	//public static final String[] lst_SelectExpenseCategory= {"//div[@id='expense-add']",XPATH,"lst_SelectExpenseCategory"};
	public static final String[] lst_SelectLocation= {"//UIAWebView[1]/UIAElement[{dynamic1}]",XPATH,"lst_SelectLocation"};
	public static final String[] lst_SelectUOM= {"//UIAWebView[1]/UIAElement[{dynamic1}]",XPATH,"lst_SelectUOM"};
	public static final String[] lbl_NativeiOS_LocationName= {"//UIAWebView[1]/UIAElement[@value='{dynamic1}']",XPATH,"lbl_NativeiOS_LocationName"};
	public static final String[] lst_LocationsAfterEdit={"(//*[@class='mm-c-product-details__location'])[{dynamic1}]//select",XPATH,"lst_Locations"};
	//
	public static final String[] lbl_location={"(//*[@class='mm-c-product-details__location'])[{dynamic1}]//select[contains(@name,'groupId')]",XPATH,"lbl_location"};
	//public static final String[] lbl_location={"//select[@name='locations[0].groupId']",XPATH,"lbl_location"};


	//public static final String[] lbl_location={"(//*[@class='mm-c-product-details__location'])[{dynamic1}]//select",XPATH,"lbl_location"};

	public static final String[] lst_ExpenseCategoryAfterEdit={"(//*[@id='expense-add']//select)",XPATH,"lst_ExpenseCategoryAfterEdit"};

	public static final String[] lbl_SelectSupplier= {"//label[contains(text(),'SELECT SUPPLIER')]",XPATH,"lst_SelectSupplier"};
	public static final String[] lbl_SelectExpenseCategory= {"//label[contains(text(),'SELECT EXPENSE')]",XPATH,"lbl_SelectExpenseCategory"};
	public static final String[] lbl_Location= {"//label[contains(text(),'LOCATIONS')]",XPATH,"lbl_Location"};
	public static final String[] lst_SelectExpenseCategoryItem= {"//select[@name='expense']",XPATH,"lst_SelectExpenseCategoryItem"};

	//public static final String[] lst_SelectExpenseCategoryItem= {"(//select)[2]",XPATH,"lst_SelectExpenseCategory"};
	public static final String[] lst_SelectExpenseCategoryItemSyscoItem= {"(//select)[1]",XPATH,"lst_SelectExpenseCategory"};
	public static final String[] txt_LocationQuantity_Native={"//UIAWebView[1]/UIATextField[{dynamic1}]",XPATH,"txt_LocationQuantity_Native"};
	
	public static final String[] lbl_PackErrorMessage={"//div[@class='mm-c-product-details__pack form-group has-error']",XPATH,"lbl_PackErrorMessage"};
	public static final String[] lbl_WeightErrorMessage={"//div[@class='mm-c-product-details__weight form-group has-error']",XPATH,"lbl_WeightErrorMessage"};
	
	public static final String[] lbl_PackWithoutErrorMessage={"//div[@class='mm-c-product-details__pack form-group has-success']",XPATH,"lbl_PackWithoutErrorMessage"};
	public static final String[] lbl_WeightWithoutErrorMessage={"//div[@class='mm-c-product-details__weight form-group has-success']",XPATH,"lbl_WeightWithoutErrorMessage"};
	public static final String[] lst_PriceUOMAttribute={"priceUom",ID,"lst_PriceUOMAttribute"};
	public static final String[] lbl_ImageSlider={"",XPATH,"lbl_ImageSlider"};

	/* Functions on the Page are defined below */
	/**
	 * @Function verifyProductDetailsPage
	 * @Description To verify whether Product Details page is displayed or not 
	 * @author Gayathri_Anand
	 * @date 23-09-2016
	 */	
	public void verifyProductDetailsPage(){
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_ProductDetailsPage,10)){
			FrameworkReporter.pass("Product Details page is displayed");
		}
		else{
			FrameworkReporter.fail("Product Details page is not displayed");
		}

	}

	/**
	 * @Function verifyProductDetails
	 * @Description To verify whether Product Details are displayed as expected
	 * @author Gayathri_Anand
	 * @param productName - Product name, nickName - Nick name, productBrand - Product brand, productId - Product id, pack - Pack, size - Size, weight - Weight, expenseCategory - Expense Category, locations - list of location names,locationQty - list of location quantities, locationQtyUOM - list of location quantity unit of measure
	 * @date 23-09-2016
	 * @status WORKING FINE, PLEASE DO NOT CHANGE THIS FUNCTIN - PERIYA
	 */
	//BELOW function is used to verify product details in disable mode, plesae do not change this function / update the object - Periya
	public void verifyProductDetails(String productName,String nickName,String productBrand,String productId,String pack,String size, String weight,String expenseCategory,String[] locations, String[] locationQty, String[] locationQtyUOM){

		switchToWebContext();
		if (!productName.isEmpty()) {
			System.out.println(getElementAttributeValue(txt_ProductName, "value"));
			if(getElementAttributeValue(txt_ProductName, "value").equalsIgnoreCase(productName)){
				FrameworkReporter.pass("Product name is displayed as expected");

			}
			else{
				FrameworkReporter.fail("Product name is not displayed as expected value: "+productName+", displayed as: "+getElementAttributeValue(txt_ProductName, "value"));
			}
		}
		if (!nickName.isEmpty()) {
			if(getElementAttributeValue(txt_NickName, "value").equals(productBrand)){
				FrameworkReporter.pass("Nick name is displayed as expected:");
			}
			else{
				FrameworkReporter.fail("Nick name is not displayed as expected value: "+nickName+", displayed as: "+getElementAttributeValue(txt_NickName, "value"));
			}
		}
		if (!productBrand.isEmpty()) {
			if(getElementAttributeValue(txt_ProductBrand, "value").equals(productBrand)){
				FrameworkReporter.pass("Product brand is displayed as expected");
			}
			else{
				FrameworkReporter.fail("Product brand is not displayed as expected value: "+productBrand+", displayed as: "+getElementAttributeValue(txt_ProductBrand, "value"));
			}
		}
		if (!productId.isEmpty()) {
			if(getElementAttributeValue(txt_UPCID, "value").equals(productId)){
				FrameworkReporter.pass("Product id is displayed as expected");
			}
			else{
				FrameworkReporter.fail("Product id is not displayed as expected value: "+productId+", displayed as: "+getElementAttributeValue(txt_UPCID, "value"));
			}
		}
		if (!pack.isEmpty()) {
			if(getElementAttributeValue(txt_Pack, "value").equals(pack)){
				FrameworkReporter.pass("Pack is displayed as expected");
			}
			else{
				FrameworkReporter.fail("Pack is not displayed as expected value: "+pack+", displayed as: "+getElementAttributeValue(txt_Pack, "value"));
			}
		}
		if (!size.isEmpty()) {
			if(getElementAttributeValue(txt_Size, "value").equals(size)){
				FrameworkReporter.pass("Size is displayed as expected");
			}
			else{
				FrameworkReporter.fail("Size is not displayed as expected value: "+size+", displayed as: "+getElementAttributeValue(txt_Size, "value"));
			}
		}
		if (!weight.isEmpty()) {
			if(getElementAttributeValue(txt_Weight, "value").equals(weight)){
				FrameworkReporter.pass("Weight is displayed as expected");
			}
			else{
				FrameworkReporter.fail("Weight is not displayed as expected value: "+weight+", displayed as: "+getElementAttributeValue(txt_Weight, "value"));
			}
		}
		if (!expenseCategory.isEmpty()) {
			if(getElementText(lbl_ExpenseCategoryValue).equals(expenseCategory)){
				FrameworkReporter.pass("Expense category is displayed as expected");
			}
			else{
				FrameworkReporter.fail("Expense category is not displayed as expected value: "+expenseCategory+", displayed as: "+getElementText(lbl_ExpenseCategoryValue));
			}
		}

		//updated the below function to validate location details in product page in disable mode, working fine for andorid. Please do not change the object for android. - Periya
		if(locations.length!=0){
			if(getElementCount(lbl_LocationValueCount)==locations.length){
				for (int i=0;i<locations.length;i++){
					if(getElementText(replaceDynamicText(lbl_LocationValue,Integer.toString(i+1))).equals(locations[i])){
						FrameworkReporter.pass("Name of location "+(i+1)+" is displayed as expected: "+locations[i] );
					}
					else{
						FrameworkReporter.fail("Name of location "+(i+1)+" is not displayed as expected value: "+locations[i]+", displayed as: "+getElementText(replaceDynamicText(lbl_LocationValue,Integer.toString(i+1))));
					}
					if(!locationQty[i].isEmpty()){
						if(getElementAttributeValue(replaceDynamicText(txt_LocationQuantity,Integer.toString(i)), "value").equals(locationQty[i])){
							FrameworkReporter.pass("Quantity of location "+(i+1)+" is displayed as expected: "+ locationQty[i]);
						}
						else{
							FrameworkReporter.fail("Quantity of location "+(i+1)+" is not displayed as expected value: "+locationQty[i]+", displayed as: "+getElementAttributeValue(replaceDynamicText(txt_LocationQuantity,Integer.toString(i)), "value"));
						}
						if(!locationQtyUOM[i].isEmpty()){
							//switchToNativeContext();
							Select select =new Select(waitForElementPresent(replaceDynamicText(lst_LocationQuantityUOM,Integer.toString(i))));
							String strCurrentUOM =(select.getFirstSelectedOption().getText());
							//String strCurrentUOM = getElementAttributeValue(replaceDynamicText(txt_LocationQuantity,Integer.toString(i)),"value");
							//String strCurrentUOM = getElementText(replaceDynamicText(lst_LocationQuantityUOM,Integer.toString(i)));

							if(strCurrentUOM.equals(locationQtyUOM[i])){
								FrameworkReporter.pass("Quantity UOM of location "+(i+1)+" is displayed as expected: "+ locationQtyUOM[i]);

							}
							else{
								FrameworkReporter.fail("Quantity UOM of location "+(i+1)+" is not displayed as expected value: "+locationQtyUOM[i]+", displayed as: "+getElementAttributeValue(replaceDynamicText(getObject(lst_LocQtyUOMNative),Integer.toString(i)), "content-desc"));	
							}							
						}
					}
				}
			}
			else{
				FrameworkReporter.fail("Number of associated locations is not correct, expected value: "+locations.length+", actual value: "+getElementCount(lbl_LocationValueCount));

			}
		}

	}

	/**
	 * @Function tapOnAddAnotherLocation
	 * @author Gayathri_Anand
	 * @description	Tap on Add Another Location
	 * @date 24-09-2016
	 */
	public void tapOnAddAnotherLocation(){
		switchToWebContext();
		lastLocationIndex=getElementCount(lst_Locations);
		consolePrint(lastLocationIndex+"");
		clickElement(lnk_AddAnotherLocation);
		FrameworkReporter.info("Tapped on Add Another Location");
		//if((ConfigFile.getProperty("platformType").equalsIgnoreCase("ios"))){
			int iLocationCount =getElementCount(lst_Locations);
			if(lastLocationIndex+1 == iLocationCount)
			{			
				FrameworkReporter.pass("Row to add new location is displayed");

			}
			else{
				FrameworkReporter.fail("Row to add new location is not displayed");

			}
		}
	//}

	/**
	 * @Function VerifyNewLocationFields
	 * @author Gayathri_Anand
	 * @description	Verify the row to add new location is displayed after clicking add another location link
	 * @date 24-09-2016     
	 */
	public void verifyNewLocationFields(){
		switchToWebContext();
		if((ConfigFile.getProperty("platformType").equalsIgnoreCase("android"))){
			String locationIndex=Integer.toString(lastLocationIndex+1);
			if(isElementPresent(replaceDynamicText(lst_Location,locationIndex))
					&&isElementPresent(replaceDynamicText(txt_LocationQuantity,locationIndex))
					&&isElementPresent(replaceDynamicText(lst_LocationQuantityUOM,locationIndex))){
				FrameworkReporter.pass("Row to add new location is displayed");

			}
			else{
				FrameworkReporter.fail("Row to add new location is not displayed");

			}
		}
		//the check is covered in tapOnAddAnotherLocation method for iOS - Parvathy

	}

	

	/**
	 * @Function enterNickName
	 * @author Gayathri_Anand
	 * @description	Enter nickname for product
	 * @param nickName - Nick name
	 * @date 24-09-2016
	 */
	public void enterNickName(String nickName){
		switchToWebContext();
		//clear(txt_NickName);
		sendText(txt_NickName, nickName);
		if(!nickName.trim().equalsIgnoreCase(""))
		{
			FrameworkReporter.info("Entered nick name "+nickName+" for product");
		}
		else
		{
			FrameworkReporter.info("Nick name is removed");
		}

	}
	
	/**
	 * @Function enterLocationQuantity
	 * @author Gayathri_Anand
	 * @description	Enter a location quantity
	 * @param locationName - location name, index - rowIndex (start from index 0)
	 * @date 24-09-2016
	 */
	public void enterLocationQuantity(String quantity, String index){
		if(ConfigFile.getProperty("brand").equalsIgnoreCase("android"))
		{
			switchToWebContext();
			sendText(replaceDynamicText(txt_LocationQuantity,Integer.toString(Integer.parseInt(index)-1)),quantity);
		}
		else
		{
			switchToWebContext();
			moveToElement(replaceDynamicText(lbl_location,Integer.toString((Integer.parseInt(index)))));
			switchToNativeContext();
			sendText(replaceDynamicText(txt_LocationQuantity_Native,Integer.toString(Integer.parseInt(index)+7)),quantity);	
			GenericPage gp = new GenericPage();
			gp.tapDoneAfterSearch();
		}	

		FrameworkReporter.info("Entered quantity for location "+index);

		//ios



	}
	/**
	 * @Function clearQuantity
	 * @author Gayathri_Anand
	 * @description	Clear a location quantity
	 * @param locationName - location name, index - rowIndex
	 * @date 24-09-2016
	 */
	public void clearQuantity(String index)
	{
		if(ConfigFile.getProperty("brand").equalsIgnoreCase("android"))
		{

			switchToWebContext();
			clear(replaceDynamicText(txt_LocationQuantity,Integer.toString(Integer.parseInt(index)-1)));
			FrameworkReporter.info("Cleared quantity for location "+index);
		}
		else
		{
			switchToNativeContext();
			clear(replaceDynamicText(txt_LocationQuantity_Native,Integer.toString(Integer.parseInt(index)+7)));
			FrameworkReporter.info("Cleared quantity for location "+index);
		}



	}
	/**
	 * @Function selectLocationQuantityUOM
	 * @author Gayathri_Anand
	 * @description	Select a location quantity UOM
	 * @param qtyUOM - quantity UOM, index - rowIndex
	 * @date 24-09-2016
	 */
	public void selectLocationQuantityUOM(String qtyUOM, String index){
		switchToWebContext();
		GenericPage gp =new GenericPage();
		if((ConfigFile.getProperty("brand").equalsIgnoreCase("android"))){
			clickElement(replaceDynamicText(lst_LocationQuantityUOM,Integer.toString(Integer.parseInt(index)-1)));
			switchToNativeContext();
			//clickElement(replaceDynamicText(getObject(lst_DropdownOption), qtyUOM));	 // updated this function, we can use common object from generic page to select value from dropdown- periya
			FrameworkReporter.info("Tapped on UOM "+qtyUOM);

		}else{		
			Actions builder=new Actions(getDriver());
			builder.moveToElement(waitForElementPresent(replaceDynamicText(lbl_location,Integer.toString((Integer.parseInt(index)))))).build().perform();		// this line of code is required	
			switchToNativeContext();
			clickElement(replaceDynamicText(getObject(lst_SelectUOM),index));			
		}
		gp.selectValueFromDropdown(qtyUOM,qtyUOM+" is selected");
		waitFor(1);
		swipeScreenInVertical(2, 8);
	}


	/**
	 * @Function enterNonSyscoItemDetails
	 * @Description To enter non sysco item details
	 * @param productName,nickName,productBrand,id,pack,size,weight,price
	 * @author Sujina_S
	 * @date 24-09-2016
	 */

	public void enterNonSyscoItemDetails(String productName,String nickName, String productBrand,String id,
			String pack, String size, String weight, String price){
		switchToWebContext();
		//wait for element, click element and clear element actions are handled inside sendText function in framework implicitly. So no need to call this function explicitly. 
		//waitForElementPresent(txt_ProductName);
		//clickElement(txt_ProductName);
		//clear(txt_ProductName);
		sendText(txt_ProductName,productName);
		FrameworkReporter.info("Entered product name");

		sendText(txt_NickName,nickName);
		FrameworkReporter.info("Entered product nickname");

		sendText(txt_ProductBrand,productBrand);
		FrameworkReporter.info("Entered product brand");

		sendText(txt_UPCID,id);
		FrameworkReporter.info("Entered product id");
		sendText(txt_Pack,pack);
		FrameworkReporter.info("Entered product pack");
		sendText(txt_Size,size);
		FrameworkReporter.info("Entered product size");

		sendText(txt_Weight,weight);
		FrameworkReporter.info("Entered product weight");


		//previous button is overriding on txt_price element, below code is used to handle that. 
		//swipeScreenInVertical(2,8);	
		//swipeScreenInVertical(2,8);	
		//AppiumDriver<WebElement> appDriver = (AppiumDriver<WebElement>)getDriver();
		//appDriver.hideKeyboard();
		if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
			swipeScreenInVertical(8,2);
			switchToWebContext();
			moveToElement(txt_Price);

		}

		//swipeScreenInVertical(2,8);	
		sendText(txt_Price,price);
		FrameworkReporter.info("Entered product price");



	}
	/**
	 * @Function enterPrepItemDetails
	 * @Description To enter non prep item details
	 * @param productName,nickName,id,pack,size,weight
	 * @author Sujina_S
	 * @date 24-09-2016
	 */

	public void enterPrepItemDetails(String productName,String nickName,String id,String pack, String size, String weight, String price){

		switchToWebContext();
		sendText(txt_ProductName,productName);
		FrameworkReporter.info("Entered product name");
		sendText(txt_NickName,nickName);
		FrameworkReporter.info("Entered product nickname");
		sendText(txt_UPCID,id);
		FrameworkReporter.info("Entered product id");
		sendText(txt_Pack,pack);
		FrameworkReporter.info("Entered product pack");	
		sendText(txt_Size,size);
		FrameworkReporter.info("Entered product size");		
		sendText(txt_Weight,weight);
		FrameworkReporter.info("Entered product weight");
		if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
			swipeScreenInVertical(8,2);
			switchToWebContext();
			moveToElement(txt_Price);			
		}
		if(price.isEmpty())
		{
			price="100";
		}
		sendText(txt_Price,price);
		FrameworkReporter.info("Entered product price");

	}
	/**

	 * @function selectSupplier
	 * @author Parvathy
	 * @description Click on the supplier drop down from Add Products Page 
	 * @param 
	 * @date 27-09-2016
	 */
	public void selectSupplier(){
		switchToWebContext();
		Actions action = new Actions(getDriver());
		action.moveToElement(waitForElementPresent(lbl_SelectExpenseCategory),0,0).build().perform();
		
		if(!(ConfigFile.getProperty("platformType").equalsIgnoreCase("android"))){	
		
			switchToNativeContext();	
			clickElement(getObject(lst_SelectSupplier));
		}	
		if(!(ConfigFile.getProperty("brand").equalsIgnoreCase("ipad"))){	
			
			if(isElementClickable(getObject(lst_SelectSupplier))){
				clickElement(getObject(lst_SelectSupplier));
			}	
		}
		FrameworkReporter.info("Supplier drop down is tapped");	
	}	



	/**
	 * @Function verifyUOMAttribute_ProductDetailsPage
	 * @Description To verify UOM attribute value in Product details page
	 * @param strUOMAttribute - UOM attribute value
	 * @author Arun_Mat
	 * @date 14-10-2016
	 */

	public void verifyUOMAttribute_ProductDetailsPage(String strUOMAttribute){
		switchToWebContext();

		Select select =new Select(waitForElementPresent(lbl_UOMAttribute));
		String strCurrentUOM =(select.getFirstSelectedOption().getText());

		if(strCurrentUOM.equals(strUOMAttribute)){
			FrameworkReporter.pass("UOM is isplayed as expected");
		}
		else{
			FrameworkReporter.fail("UOM is not displayed as expected");
		}


	}

	/**
	 * @Function verifyUOMAttribute
	 * @Description To verify UOM attribute value
	 * @param strUOMAttribute - UOM attribute value
	 * @author Gayathri
	 * @date 27-09-2016
	 */

	public void verifyUOMAttribute(String strUOMAttribute){
		switchToNativeContext();
		if(isElementPresent(replaceDynamicText(getObject(lst_LocQtyUOMNative),strUOMAttribute))){
			FrameworkReporter.pass("UOM is displayed as expected");
		}
		else{
			FrameworkReporter.fail("UOM is not displayed as expected");
		}

	}
	/**
	 * @Function verifyTogglingOfUOMAttribute
	 * @Description To verify the toggling of UOM attribute
	 * @author Gayathri Anand
	 * @date 27-09-2016
	 */

	public void verifyTogglingOfUOMAttribute(){
		switchToWebContext();
		clickElement(replaceDynamicText(lst_LocQtyUOMNative, "1"));
		String[] uomAttributes={"CS","EA","LB","OZ"};
		switchToNativeContext();
		String selectedAttribute= getSelectedOptionTextInDropDown(lst_DropdownOptions,uomAttributes.length);
		for (int i=0;i<uomAttributes.length;i++){
			clickElement(replaceDynamicText(lst_DropdownOption, uomAttributes[i]));
			FrameworkReporter.info("Selected attribute "+uomAttributes[i]);
			if(getElementAttributeValue(replaceDynamicText(lst_LocQtyUOMNative, "1"),"content-desc").equals(uomAttributes[i])){
				FrameworkReporter.pass("Selected UOM atribute is displayed");
			}
			else{
				FrameworkReporter.fail("Selected UOM atribute is not displayed");

			}
			switchToWebContext();
			clickElement(replaceDynamicText(lst_LocQtyUOMNative, "1"));
			switchToNativeContext();
		}
		clickElement(replaceDynamicText(lst_DropdownOption, selectedAttribute));
	}
	/**
	 * @Function verifyQuantity
	 * @Description To verify quantity
	 * @param strQty - quantity value
	 * @author Gayathri
	 * @date 27-09-2016
	 */

	public void verifyQuantity(String strQty){
		switchToWebContext();
		if(ConfigFile.getProperty("brand").equalsIgnoreCase("android"))
		{
			consolePrint(getElementAttributeValue(replaceDynamicText(txt_LocationQuantity, "0"),"value"));
			consolePrint(strQty);
			if(getElementAttributeValue(replaceDynamicText(txt_LocationQuantity, "0"),"value").equals(strQty)){
				FrameworkReporter.pass("Quantity is displayed as expected");

			}
			else{
				FrameworkReporter.fail("Quantity is not displayed as expected");
			}

		}
		//arun
		else
		{
			switchToWebContext();

			//moveToElement(lbl_location,Integer.toString((Integer.parseInt(""))));

			switchToNativeContext();
			if(getElementAttributeValue(replaceDynamicText(txt_LocationQuantity_Native, "8"),"value").equals(strQty))
			{
				FrameworkReporter.pass("Quantity is displayed as expected");

			}
			else{
				FrameworkReporter.fail("Quantity is not displayed as expected");
			}

		}

	}
	/**
	 * @Function verifyQuantityIsEmpty
	 * @Description To verify quantity is empty
	 * @param strQty - quantity value
	 * @author Gayathri
	 * @date 27-09-2016
	 */

	public void verifyQuantityIsEmpty(){
		switchToWebContext();
		if(ConfigFile.getProperty("brand").equalsIgnoreCase("android"))
		{
			if(getElementAttributeValue(replaceDynamicText(txt_LocationQuantity, "0"),"value").isEmpty()){
				FrameworkReporter.pass("Quantity is displayed as expected");

			}
			else{
				FrameworkReporter.fail("Quantity is not displayed as expected");

			}

		}
		else
		{
			switchToNativeContext();
			if(getElementAttributeValue(replaceDynamicText(txt_LocationQuantity_Native, "8"),"value").isEmpty())
			{
				FrameworkReporter.pass("Quantity is displayed as expected");

			}
			else
			{
				FrameworkReporter.fail("Quantity is not displayed as expected");
			}	
		}
	}
	/**
	 * @function tapExpenseCategoryNonSysco
	 * @author Parvathy
	 * @description Click on the expense category dropdown from Add Products Page for Non SyscoItems
	 * @param 
	 * @date 27-09-2016
	 */

	public void tapExpenseCategoryNonSysco(){

		
			switchToWebContext();
			Actions action = new Actions(getDriver());
			if(!(ConfigFile.getProperty("brand").equalsIgnoreCase("ipad"))){	//not required for ipad
				action.moveToElement(waitForElementPresent(lbl_Location),0,0).build().perform();
			}
			
		if(!(ConfigFile.getProperty("platformType").equalsIgnoreCase("android"))){	
			switchToNativeContext();			
		}	
		clickElement(replaceDynamicText(getObject(lst_SelectExpenseCategory),"3"));
		FrameworkReporter.info("Expense Catagory drop down is tapped");

	}	
	/**
	 * @function tapLocationNonSysco
	 * @author Parvathy
	 * @description Click on the Location drop down from Add Products Page for non Sysco Items
	 * @param 
	 * @date 27-09-2016
	 */

	public void tapLocationNonSysco(String index){
		//Swipe down
		//swipeScreenDown(lbl_NickName);
		//label[@for='nickName']
		switchToWebContext();
		Actions builder=new Actions(getDriver());		
		if((ConfigFile.getProperty("brand").equalsIgnoreCase("android"))){
			index = Integer.toString((Integer.parseInt(index)));
			WebElement ele = waitForElementPresent(replaceDynamicText(getObject(lst_SelectLocation),index));
			builder.moveToElement(ele).build().perform();

		}else{
			//builder.moveToElement(getDriver().findElement(By.xpath("(//*[@class='mm-c-product-details__location'])[1]//select"))).build().perform();
			builder.moveToElement(waitForElementPresent(replaceDynamicText(lbl_location,Integer.toString((Integer.parseInt(index)+1))))).build().perform();
			switchToNativeContext();
			index = Integer.toString((Integer.parseInt(index)*2)+3);
		}
		clickElement(replaceDynamicText(getObject(lst_SelectLocation),index));
		FrameworkReporter.info("Location drop down is tapped");

	}	
	/**
	 * @function tapExpenseCategory
	 * @author Parvathy
	 * @description Click on the expense category drop down from Add Products Page 
	 * @param 
	 * @date 27-09-2016
	 */

	public void tapExpenseCategory(){
		//switchToWebContext();
		if((ConfigFile.getProperty("platformType").equalsIgnoreCase("android"))){	
			switchToWebContext();
			Actions action = new Actions(getDriver());
			//action.moveToElement(waitForElementPresent(lbl_Location),0,0).build().perform(); 
			action.moveToElement(waitForElementPresent(getObject(lst_SelectExpenseCategoryItem))).build().perform();
			clickElement(getObject(lst_SelectExpenseCategoryItem));
		}
		else
		{
			switchToWebContext();
			Actions builder=new Actions(getDriver());
			builder.moveToElement(waitForElementPresent(replaceDynamicText(lbl_location,"1"))).build().perform();
			switchToNativeContext();	
			clickElement(replaceDynamicText(getObject(lst_SelectExpenseCategory),"1"));
		}	

		//clickElement(lst_SelectExpenseCategory);
		//clickElement("//UIAWebView[1]/UIAElement[3]");
		//getDriver().findElement(By.xpath("//UIAWebView[1]/UIAElement[1]")).click();
		FrameworkReporter.info("Expense Category drop down is tapped");

	}	

	/**
	 * @function tapLocation
	 * @author Parvathy
	 * @description Click on the Location dropdown from Add Products Page 
	 * @param 
	 * @date 27-09-2016
	 */

	public void tapLocation(String index){

		switchToWebContext();

		Actions builder=new Actions(getDriver());
		if((ConfigFile.getProperty("brand").equalsIgnoreCase("android"))){
			index = Integer.toString((Integer.parseInt(index)));
			WebElement ele = waitForElementPresent(replaceDynamicText(getObject(lst_SelectLocation),index));
			builder.moveToElement(ele).build().perform();

		}else{
			// builder.moveToElement(waitForElementPresent(replaceDynamicText(lbl_location,Integer.toString((Integer.parseInt(index)+1))))).build().perform();
			//	moveToElement(replaceDynamicText(lbl_location,Integer.toString((Integer.parseInt(index)+1))));

			String[] location = replaceDynamicText(getObject(lbl_location),Integer.toString((Integer.parseInt(index)+1)));
			moveToElement(location);	
			index = Integer.toString((Integer.parseInt(index)*2)+2);
			switchToNativeContext();	
		}

		clickElement(replaceDynamicText(getObject(lst_SelectLocation),index));			
		FrameworkReporter.info("Location drop down is tapped");
	}

	/**
	 * @function verifySelectedLocation
	 * @author Periyasamy_Nainar
	 * @description Click on the Location dropdown from Add Products Page 
	 * @param 
	 * @date 27-09-2016
	 */

	public void verifySelectedLocation(String index,String strLocationName){
		switchToWebContext();
		//if(!(ConfigFile.getProperty("brand").equalsIgnoreCase("android"))){}
		index = Integer.toString(Integer.parseInt(index)+1);

		if(isElementPresentAfterWait(replaceDynamicText(getObject(lbl_LocationValue),index), 8)){
			FrameworkReporter.pass("Location "+ strLocationName +" is displayed in " + index +" position");
		}else{
			FrameworkReporter.pass("Location "+ strLocationName +" is not displayed in " + index +" position");
		}

	}

	/**
	 * @Function verifyLocation
	 * @Description To verify location
	 * @param locationName - location name
	 * @author Gayathri
	 * @date 28-09-2016
	 */


	public void verifyLocation(String locationName){	
		switchToWebContext();
		if(getElementText(replaceDynamicText(lbl_LocationValue, "1")).equals(locationName)){
			FrameworkReporter.pass("Location: "+locationName+" displayed as expected");

		}
		else{
			FrameworkReporter.fail("Location: "+locationName+" is not displayed as expected");

		}
	}

	/**
	 * @Function verifyLocation
	 * @Description To verify location
	 * @param locationName - location name, index - position [if first location; pass 0]
	 * @author Parvathy
	 * @date 28-09-2016
	 */

	public void verifyLocationAfterEdit(String locationName,int index){
		switchToWebContext();
		Select sel =new Select(waitForElementPresent(replaceDynamicText(lst_LocationsAfterEdit,Integer.toString(index+1))));
		String strCurrentLocation =(sel.getFirstSelectedOption().getText());
		if(strCurrentLocation.trim().equalsIgnoreCase(locationName))
		{
			FrameworkReporter.pass("Location: "+locationName+" displayed as expected");

		}
		else{
			FrameworkReporter.fail("Location: "+locationName+" is not displayed as expected");
		}

	}

	/**
	 * @Function verifyExpenseCategoryAfterEdit
	 * @Description To verify expense category after clicking edit
	 * @param locationName - expense category name
	 * @author Parvathy
	 * @date 28-09-2016
	 */

	public void verifyExpenseCategoryAfterEdit(String expenseCategoryName){
		switchToWebContext();
		Select sel =new Select(waitForElementPresent(lst_ExpenseCategoryAfterEdit));
		String strCurrentLocation =(sel.getFirstSelectedOption().getText());
		if(strCurrentLocation.trim().equalsIgnoreCase(expenseCategoryName))
		{
			FrameworkReporter.pass("Expense Category: "+expenseCategoryName+" displayed as expected");

		}
		else{
			FrameworkReporter.fail("Expense Category: "+expenseCategoryName+" is not displayed as expected");
		}

	}
	/**
	 * @Function verifyCategoryInCategoryPicker
	 * @Description To verify category is displayed in category picker
	 * @author Gayathri
	 * @date 04-10-2016
	 */

	public void verifyCategoryInCategoryPicker(String expenseCategoryName){
		//   switchToWebContext();
		//moveToElement(lst_SelectExpenseDrpDwn);
		//clickElement(lst_SelectExpenseDrpDwn);
		PageFactory pf1=new PageFactory();
		tapExpenseCategory();
		/*
		switchToNativeContext();
		//Actions builder=new Actions(getDriver());
        //builder.moveToElement(waitForElementPresent(replaceDynamicText(lst_DropdownOption, expenseCategoryName))).build().perform();
        AppiumDriver<WebElement> driver1 = (AppiumDriver<WebElement>)getDriver();
        TouchAction action = new TouchAction(driver1);
        action.moveTo(waitForElementPresent(replaceDynamicText(lst_DropdownOption, expenseCategoryName)));
        //driver1.scrollTo(waitForElementPresent(replaceDynamicText(lst_DropdownOption, expenseCategoryName)));
		if (isElementPresent(replaceDynamicText(lst_DropdownOption, expenseCategoryName))) {
			FrameworkReporter.pass("Expense Category: "+expenseCategoryName+" is dispalyed in the category picker");
		}
		else{
			FrameworkReporter.fail("Expense Category: "+expenseCategoryName+" is not displayed in the category picker");
		}
		 */
	//	PageFactory pf=new PageFactory();
		pf1.generic().verifyValueInDropdown(expenseCategoryName, "category picker", true);
	}

	/**
	 * @Function clickEditProduct
	 * @author Parvathy_p	
	 * @description	Click on edit product label
	 * @param 
	 * @date 12-10-2016
	 */
	public void clickEditProduct(){
		switchToWebContext();
		clickElement(lbl_EditProduct);

	}
	/**
	 * @Function verifySuggested8Categories
	 * @Description Verify Suggested 8 categories in the picker
	 * @author Gayathri
	 * @date 04-10-2016
	 */

	public void verifySuggested8Categories(){
		NonSyscoPrepItemPage nsp = new NonSyscoPrepItemPage();
		GenericPage gp=new GenericPage();
		ArrayList<String> listSuggestedCat =nsp.getSuggestedCategories();	
		for (String cat :listSuggestedCat)
		{
			if(!ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
				gp.verifyValueInDropdown(cat,"Expense Category list",true);
			}
			else
			{
				gp.verifyValueInDropdownWeb(cat,"Expense Category list",true);
			}

		}

	}

	/**
	 * @function tapExpenseCategoryPrep
	 * @author Parvathy
	 * @description Click on the expense category drop down from Add Products Page 
	 * @param 
	 * @date 15-10-2016
	 */

	public void tapExpenseCategoryPrep(){
		//switchToWebContext();
		if((ConfigFile.getProperty("platformType").equalsIgnoreCase("android"))){	
			switchToWebContext();
			Actions action = new Actions(getDriver());
			//action.moveToElement(waitForElementPresent(lbl_Location),0,0).build().perform(); 
			action.moveToElement(waitForElementPresent(lst_SelectExpenseCategoryItem)).build().perform();
			clickElement(lst_SelectExpenseCategoryItem);
		}
		else
		{
			switchToWebContext();
			Actions builder=new Actions(getDriver());
			builder.moveToElement(waitForElementPresent(replaceDynamicText(lbl_location,"1"))).build().perform();
			switchToNativeContext();	
			clickElement(replaceDynamicText(getObject(lst_SelectExpenseCategory),"2"));
			if((ConfigFile.getProperty("brand").equalsIgnoreCase("iphone"))){	
				
			if(isElementClickable(replaceDynamicText(getObject(lst_SelectExpenseCategory),"2"))){
				clickElement(replaceDynamicText(getObject(lst_SelectExpenseCategory),"2"));
			}
			}
		}	

		//clickElement(lst_SelectExpenseCategory);
		//clickElement("//UIAWebView[1]/UIAElement[3]");
		//getDriver().findElement(By.xpath("//UIAWebView[1]/UIAElement[1]")).click();
		FrameworkReporter.info("Expense Category drop down is tapped");

	}	



/**
 * @Function verifyProductImageInProductDetails
 * @Description verify product image in product details page
 * @author Periyasamy nainar
 * @date 18-10-2016
 */

public void  verifyProductImageInProductDetails(String strItemID){		
	//image width should be 320 as per 13.5 as the image is displayed in enhanced view 
	//item id should be available in d

	switchToWebContext();
	WebElement element = waitForElementPresent(img_Product);	
		String strActualText = element.getAttribute("src");
		consolePrint("actual text value is"+ strActualText);
		if(strActualText.contains("http://sysco-cdn.madmobile.com/?width=335") && strActualText.contains(strItemID) && strActualText.contains("Fweb") && strActualText.contains(".png")){
			FrameworkReporter.pass("image is displayed in product details page for an item with ID " + strItemID);
		}else{
			FrameworkReporter.pass("image is not displayed in product details page for an item with ID " + strItemID);
		}				
	

}			



/**
 * @Function verifyPriceInProductDetails
 * @Description To verify whether Product price in product details page
 * @author Periyasamy Nainar
 * @param strPriceAmount - expected price amount
 * @date 21-10-2016
 */
public void verifyPriceInProductDetails(String strPriceAmount){
	switchToWebContext();
	if (!strPriceAmount.isEmpty()) {
		String strActualPrice = getElementAttributeValue(txt_Price, "value");
		System.out.println(strActualPrice);
		if(strActualPrice.equalsIgnoreCase(strPriceAmount)){
			FrameworkReporter.pass("Price amount is displayed as expected. Price: " + strPriceAmount);

		}
		else{
			FrameworkReporter.fail("Price amount is not displayed as expected. Expected Price: " + strPriceAmount+ " Actual Price: " + strActualPrice);
		}
	}
}


/**
 * @Function verifyPackAndWeightErrorMessage
 * @Description To verify pack and weight error message based on UOM Attribute in product page
 * @param isPackError - true or false to verify the error, isWeightError - true r false
 * @author Periyasamy Nainar
 * @date 23-10-2016
 */	
public void verifyPackAndWeightErrorMessage(boolean isPackError, boolean isWeightError){
	switchToWebContext();
	
	if(isPackError){
		if(isElementPresentAfterWait(lbl_PackErrorMessage,5)){
			FrameworkReporter.pass("Pack error message is displayed in product details page as expected");
		}
		else{
			FrameworkReporter.fail("Pack error message is not displayed in product details page");
		}
		
	}else{
		if(isElementPresentAfterWait(lbl_PackWithoutErrorMessage,5)){
			FrameworkReporter.pass("Pack error message is not displayed in product details page as expected");
		}
		else{
			FrameworkReporter.fail("Pack error message is displayed in product details page");
		}
	}
	

	if(isWeightError){
		if(isElementPresentAfterWait(lbl_WeightErrorMessage,5)){
			FrameworkReporter.pass("Weight error message is displayed in product details page as expected");
		}
		else{
			FrameworkReporter.fail("Weight error message is not displayed in product details page");
		}
		
	}else{
		if(isElementPresentAfterWait(lbl_WeightWithoutErrorMessage,5)){
			FrameworkReporter.pass("Weight error message is not displayed in product details page as expected");
		}
		else{
			FrameworkReporter.fail("Weight error message is displayed in product details page");
		}
	}
	

}


/**
 * @Function changePriceUOMAttribute
 * @author Periyasamy Nainar
 * @description	change price uom attribute from product details page
 * @param qtyUOM - quantity UOM
 * @date 24-09-2016
 */
public void changePriceUOMAttribute(String qtyUOM){
	switchToWebContext();
	GenericPage gp =new GenericPage();
	
	clickElement(lst_PriceUOMAttribute);	
	gp.selectValueFromDropdown(qtyUOM,qtyUOM+" is selected for price");

}

/**
 * @Function clickEditProductLabel
 * @Description Click on edit product label
 * @param
 * @author Parvathy
 * @date 01-11-2016
 */

public void clickEditProductLabel(){
	switchToWebContext();
	clickElement(lbl_EditProduct);
	
}
/**
 * @function tapLocationPrep
 * @author Parvathy
 * @description Click on the Location drop down from Add Products Page 
 * @param 
 * @date 27-09-2016
 */

public void tapLocationPrep(String index){

	switchToWebContext();

	Actions builder=new Actions(getDriver());
	if((ConfigFile.getProperty("brand").equalsIgnoreCase("android"))){
		index = Integer.toString((Integer.parseInt(index)));
		WebElement ele = waitForElementPresent(replaceDynamicText(getObject(lst_SelectLocation),index));
		builder.moveToElement(ele).build().perform();

	}else{
		// builder.moveToElement(waitForElementPresent(replaceDynamicText(lbl_location,Integer.toString((Integer.parseInt(index)+1))))).build().perform();
		//	moveToElement(replaceDynamicText(lbl_location,Integer.toString((Integer.parseInt(index)+1))));

		String[] location = replaceDynamicText(getObject(lbl_location),Integer.toString((Integer.parseInt(index)+1)));
		moveToElement(location);	
		index = Integer.toString((Integer.parseInt(index)*2)+3);
		switchToNativeContext();	
	}

	clickElement(replaceDynamicText(getObject(lst_SelectLocation),index));			
	FrameworkReporter.info("Location drop down is tapped");
}

/**
 * @function verifySlider
 * @author Gayathri
 * @description Verify product image slider i displayed or not
 * @date 
 */

public void verifySlider(boolean isExpected){

	switchToWebContext();
	if(isExpected){
		if(isElementPresent(getObject(lbl_ImageSlider))){
		    FrameworkReporter.pass("Image slider is displayed as expected");
		}
		else{
		   FrameworkReporter.fail("Image slider is not displayed as expected");
		}
	}
	else{
		if(!isElementPresent(getObject(lbl_ImageSlider))){
		    FrameworkReporter.pass("Image slider is not displayed as expected");
		}
		else{
		   FrameworkReporter.fail("Image slider is displayed");
		}
	}
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
			//childClassObject= new IOSProductPage().findChildObject(parentObject[2]);	
			break;
		case "ipad":	
			childClassObject = new IOSTabletProductPage().findChildObject(parentObject[2]);	
			break;
		case "android":
			childClassObject = new AndroidProductPage().findChildObject(parentObject[2]);					
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
