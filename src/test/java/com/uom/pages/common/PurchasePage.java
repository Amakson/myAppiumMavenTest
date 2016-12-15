
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
import com.uom.pages.iOSPhone.IOSPurchasePage;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.uom.commonFunctions.FunctionLibrary;
import com.uom.pages.androidPhone.AndroidPurchasePage;
import com.uom.pages.iOSTablet.IOSTabletPurchasePage;
import com.framework.frameworkFunctions.*;
import com.framework.configuration.*;
import com.framework.reporting.*;
import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class PurchasePage extends LibraryPage {

	static Field[] declaredMemberVariables;
	static{
		declaredMemberVariables = PurchasePage.class.getDeclaredFields();
	}

	
	//new objects
	public static final String[] lbl_PurchasePagePage={"//*[contains(text(),'PurchasePage')]",XPATH,"lbl_PurchasePagePage"};
	public static final String[] lbl_PurchaseDetailsPage={"//*[contains(text(),'Purchase Details')]",XPATH,"lbl_PurchaseDetailsPage"};
	public static final String[] txt_InvoiceNumber = {"invoice-number",ID,"txt_InvoiceNumber"};
	public static final String[] txt_InvoiceTotal = {"invoice-total",ID,"txt_InvoiceTotal"};
	public static final String[] lnk_AddLineItem={"//*[contains(text(),'Add Line Item')]",XPATH,"lnk_AddLineItem"};
	public static final String[] lbl_Purchase={"//*[contains(text(),'Purchases')]",XPATH,"lbl_Purchase"};
	
	public static final String[] txt_Supplier = {"//option[@label='{dynamic1}' or @label='Sysco']",XPATH,"txt_Supplier"};
	public static final String[] txt_InvNumber = {"//input[@name='invoiceNumber']",XPATH,"txt_InvNumber"};
	public static final String[] txt_InvTotal = {"//input[@name='invoiceTotal']",XPATH,"txt_InvTotal"};
	public static final String[] txt_LinePrice = {"//input[contains(@name,'currentExtendedPrice')]",XPATH,"txt_LinePrice"};

	public static final String[] lnk_PurchaseLine= {"(//div[@id='invoice-row'])['{dynamic1}']",XPATH,"lnk_PurchaseLine"};
	public static final String[] txt_LineItemTotal= {"//h2[contains(text(),'$')]",XPATH,"txt_LineItemTotal"};
	public static final String[] link_AddLineItem= {"//a[text()='Add Line Item']",XPATH,"link_AddLineItem"};	
	public static final String[] link_SelectItemType={"//UIAElement[@value ='Select']",XPATH,"link_SelectItemType"};
	public static final String[] txt_ItemPrice= {"//input[@id='priceId-0']",XPATH,"txt_ItemPrice"};
	public static final String[] link_NewLineItem= {"//div[@class='mm-c-purchase-details__expense-row']",XPATH,"link_NewLineItem"};

	
	//public static final String[] btn_Done= {"//android.widget.Button[@content-desc='Done']",XPATH,"btn_Done"};
	public static final String[] modal_SuccessMsg= {"//h4[@id='modal-title']",XPATH,"modal_SuccessMsg"};
	public static final String[] btn_NoIAmDone= {"//button[@id='no-button']",XPATH,"btn_NoIAmDone"};   // object and function already available in generic.pls remove this duplicate code
	public static final String[] modal_NoItemMesssage= {"//*[@class='modal-title']",XPATH,"modal_NoItemMesssage"};
	public static final String[] btn_Confirm= {"//*[@id='yes-button']",XPATH,"btn_Confirm"};    // object and function already available in generic. pls remove this duplicate code 
	public static final String[] btn_Cancel= {"//*[@id='no-button']",XPATH,"btn_Cancel"};       // object and function already available in generic. pls remove this duplicate code
	
	public static final String[] lnk_Delete= {"(//*[@class='mm-o-icon icon-minus-circle'])[{dynamic1}]",XPATH,"lnk_Delete"};
	public static final String[] btn_Delete= {"//span[contains(text(),'Delete')]",XPATH,"btn_Delete"};

	public static final String[] txt_TotalPurchase= {"//*[@id='month-total']",XPATH,"txt_TotalPurchase"};

	public static final String[] lst_ItemType= {"(//select[contains(@id,'categoryId')])[{dynamic1}]",XPATH,"lst_ItemType"};
	public static final String[] lst_ItemPriceByIndex={"(//input[contains(@id,'priceId')])[{dynamic1}]",XPATH,"lst_ItemPriceByIndex"};
	
	public static final String[] link_Supplier= {"//UIAElement[@name='SELECT SUPPLIER']",XPATH,"link_Supplier"};
	public static final String[] link_SelectAccount={"//*[contains(@href,'#accounts')]",XPATH,"link_SelectAccount"};
	public static final String[] link_SelectSubway={"(//button[@id='list-item'])[1]",XPATH,"link_SelectSubway"};
	
	public static final String[] lbl_InvoiceTotal={"//div[@id='invoice-total']/span",XPATH,"lbl_InvoiceTotal"};
	public static final String[] lbl_LineItemPrice ={"(//div[@class='mm-c-purchase-details__expense-amount '])[{dynamic1}]//input",XPATH,"lbl_LineItemPrice"};
	

	//*[@id='no-button']
	/* Functions on the Page are defined below */


	/**
	 * @Function verifyPurchasePagePage
	 * @Description To verify whether purchase details page is displayed or not 
	 * @author Sujina_S
	 * @date 27-09-2016
	 */
	public void verifyPurchaseDetailsPage(){
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_PurchaseDetailsPage,10)){
			FrameworkReporter.pass("Purchase details page is displayed");
		}
		else{
			FrameworkReporter.fail("Purchase details page is not displayed");
		}
		
	}
	
	/**
	 * @Function tapLocation
	 * @Description to tap on Add line item
	 * @author Sujina_S
	 * @date 27-09-2016
	 */

	public void tapAddLineItem(){
		switchToWebContext();
			clickElement(lnk_AddLineItem);
			FrameworkReporter.info("Tapped on Add line item");
			
		

	}
	/**
	 * @Function enterInvoiceNumber
	 * @Description To enter invoice number
	 * @param invoiceNumber- invoice number
	 * @author Sujina_S
	 * @date 27-09-2016
	 */
	public void enterInvoiceNumber(String invoiceNumber){
		switchToWebContext();
		sendText(txt_InvoiceNumber,invoiceNumber);
		FrameworkReporter.info("Entered invoice number");
		
		

	}  
	/**
	 * @Function enterInvoiceTotal
	 * @Description To enter invoice total
	 * @param invoiceTotal- invoice total
	 * @author Sujina_S
	 * @date 27-09-2016
	 */
	public void enterInvoiceTotal(String invoiceTotal){
		switchToWebContext();
		sendText(txt_InvoiceTotal,invoiceTotal);
		FrameworkReporter.info("Entered invoice total");
				

	}  	
	
		

	/**
	 * @Function verifyPurchasePage
	 * @Description To verify whether Purchase page is displayed or not 
	 * @author Sampada Dalai
	 * @date 22-09-2016
	 */
	public void verifyPurchasePage(){
		switchToWebContext();
		
		if(isElementPresentAfterWait(lbl_Purchase,10)){
			FrameworkReporter.pass("Purchsase page is displayed");
		}
		else{
			FrameworkReporter.fail("Purchase page is not displayed");
		}
		
	}
	/**
	 * @Function verifyValidatePurchaseInformation
	 * @Description To verify whether Purchase information is displayed or not 
	 * @author Sujina_S
	 * @date 22-09-2016
	 */
	public void verifyValidatePurchaseInformation(String strExpectedSupplierName,String strExpectedInVNumber,String strExpectedInvTotal,boolean hasValidatePurchaseInfo){
		switchToWebContext();
		
		if(isElementPresentAfterWait(replaceDynamicText(txt_Supplier, strExpectedSupplierName),10)){
			String strSupplierName=getElementText(replaceDynamicText(txt_Supplier, strExpectedSupplierName));
			FrameworkReporter.pass("Supplier name is displayed as :"+strSupplierName);
			
			if(hasValidatePurchaseInfo){
				if(strSupplierName.trim().equalsIgnoreCase(strExpectedSupplierName.trim())){
					FrameworkReporter.pass("Supplier name is validated and displayed as :"+strSupplierName);
				}else{
					FrameworkReporter.fail("Supplier name '"+strSupplierName+"' is displayed in stead of "+strExpectedSupplierName);
				}
			}
		}
		else{
			FrameworkReporter.fail("Supplier name is not displayed");
		}
		
		if(isElementPresentAfterWait(txt_InvNumber,10)){
			String strInvoiceNumber=getElementAttributeValue(txt_InvNumber, "value");
			FrameworkReporter.pass("Invoice number is displayed as :"+strInvoiceNumber);
			
			if(hasValidatePurchaseInfo){
				if(strInvoiceNumber.trim().equalsIgnoreCase(strExpectedInVNumber.trim())){
					FrameworkReporter.pass("Invoice number is validated and displayed as :"+strInvoiceNumber);
				}else{
					FrameworkReporter.fail("Invoice number '"+strInvoiceNumber+"' is displayed instead of "+strExpectedInVNumber);
				}
			}
		}
		else{
			FrameworkReporter.fail("Invoice number is not displayed");
		}
		
		if(isElementPresentAfterWait(txt_InvTotal,10)){
			String strInvoiceTotal=getElementAttributeValue(txt_InvTotal, "value");
			FrameworkReporter.pass("Invoice Total is displayed as :"+strInvoiceTotal);
			
			if(hasValidatePurchaseInfo){
				if(strInvoiceTotal.trim().equalsIgnoreCase(strExpectedInvTotal.trim())){
					FrameworkReporter.pass("Invoice total is validated and displayed as :"+strInvoiceTotal);
				}else{
					FrameworkReporter.fail("Invoice total '"+strInvoiceTotal+"' is displayed instead of "+strExpectedInvTotal);
				}
			}
		}
		else{
			FrameworkReporter.fail("Invoice total is not displayed");
		}
		
		
		if(isElementPresentAfterWait(txt_LineItemTotal, 10)) {
			String strInLineItemTotal = getElementText(txt_LineItemTotal);
			FrameworkReporter.pass("Line item total is displayed as :" + strInLineItemTotal);
		} else {
			FrameworkReporter.fail("Line item total is not displayed");
		}
	}
	
	/**
	 * @Function clickOnPurchaseLine
	 * @Description click on purchase line
	 * @author Sampada Dalai
	 * @date 14-10-2016
	 */

	public void clickOnPurchaseLine(String strIndex){

			switchToWebContext();
			waitForElementPresent(replaceDynamicText(lnk_PurchaseLine, strIndex),10);
			clickElement(replaceDynamicText(lnk_PurchaseLine, strIndex));
			FrameworkReporter.info("Clicked on purchase line :"+strIndex);	

	}
	
	/**
	 * @Function addLineAmountAndValidate
	 * @Description Add all amount displayed in 
	 * @author Sampada Dalai
	 * @date 14-10-2016
	 */

	public void addLineAmountAndValidate(){
			
			//String strBrand =ConfigFile.getProperty("brand").toString().toLowerCase().trim();
			 List<WebElement> liElemets=null;
			  switchToWebContext();
			  waitForElementPresent(txt_LinePrice,10);
			  liElemets=getElements(txt_LinePrice);

		   
		    double dLinePriceTotal=0;
		    String strExpectedlineItemTotal="";
		   for(WebElement ele:liElemets){
			   String strLine=ele.getAttribute("value");
			   double dLinePrice=Double.parseDouble(strLine.trim().replace("$",""));
			   dLinePriceTotal=dLinePriceTotal+dLinePrice;   
		   }
		   //Validating line item total
		   String[] arrTotal=String.valueOf(dLinePriceTotal).split("\\.");
		   try{
		       strExpectedlineItemTotal=arrTotal[0]+"."+arrTotal[1].substring(0,2);
		   }catch(StringIndexOutOfBoundsException e){
			   strExpectedlineItemTotal=arrTotal[0]+"."+"00";
		   }
		   FrameworkReporter.info("Total line price summed up and value is: "+strExpectedlineItemTotal);
		   switchToWebContext();
		   String strActualInvoiceTotal=getElementText(txt_LineItemTotal);
		   if(strExpectedlineItemTotal.equals((strActualInvoiceTotal.trim().replace("$","").trim()).replace(",", ""))){
			   FrameworkReporter.pass("Total line amount is displayed as same as total invoice total and amount displayed is : $"+strExpectedlineItemTotal);
		   }else{
			   FrameworkReporter.fail("Line item total and invoice total is not same as displayed and Invoice total is :"+strActualInvoiceTotal+" and line item total is : $"+strExpectedlineItemTotal);
		   }

	}
	
	/**
	 * @Function verifySwipeTopToButton
	 * @Description verify swipe in vertically from top to button
	 * @author Sampada Dalai
	 * @date 14-10-2016
	 */
	public void verifySwipeTopToButton(){
		try{
			swipeScreenInVertical(2, 8);
			FrameworkReporter.pass("Line item Swipe is verified");
		}catch(Exception e){
			FrameworkReporter.fail("Line item Swipe is not verified");
		}
	}
	
	/**
	 * @Function tapSelectSupplier
	 * @Description Tap on supplier to view the drop down
	 * @author Sampada Dalai
	 * @date 14-10-2016
	 */
	
	public void tapSelectSupplier(){
		String strBrand =ConfigFile.getProperty("brand").toString().toLowerCase().trim();
		if(strBrand.equals("android")){
		     switchToWebContext();
			clickElement(getObject(link_Supplier));
		}else{
			switchToNativeContext();
			clickElement(getObject(link_Supplier));
		}
			FrameworkReporter.info("Tapped on supplier");
			
		
	}
	
	/**
	 * @Function tapSupplier
	 * @Description Tap on supplier to view the drop down
	 * @author Sampada Dalai
	 * @date 14-10-2016
	 */
	
	public void enterInvoiceNumberAndInvoiceTotal(String strKey,String strInvoiceTotal,String strRandomInvoiceNumber){
		switchToWebContext();
		storeValue(strKey, strRandomInvoiceNumber);
		sendText(txt_InvNumber, strRandomInvoiceNumber);
		FrameworkReporter.info("Entered invoice number :"+strRandomInvoiceNumber);
		sendText(txt_InvTotal, strInvoiceTotal);
		FrameworkReporter.info("Entered invoice total :"+strInvoiceTotal);	
		

	}
	
	/**
	 * @Function clickAddLineItem
	 * @Description verify add line item(+) Click on add line item(+) 
	 * @author Sampada Dalai
	 * @date 14-10-2016
	 */
	
	public void clickAddLineItemAndAddItemDetails(String strItemPrice){
		String strBrand =ConfigFile.getProperty("brand").toString().toLowerCase().trim();
		switchToWebContext();
		waitForElementPresent(link_AddLineItem);
		//Verify line item(+)
		if(isElementPresent(link_AddLineItem)){
			FrameworkReporter.pass("+ Add Line item is displayed as expected");
		}else{
			FrameworkReporter.fail("+ Add Line item is not displayed as expected");
		}
		clickElement(link_AddLineItem);
		FrameworkReporter.info("Clicked add line item(+)");	
		
		//Verify empty line item added
		if(isElementPresent(link_NewLineItem)){
			FrameworkReporter.pass("New empty line item is displayed as expected");
		}else{
			FrameworkReporter.fail("New empty line item  is not displayed as expected");
		}
		
		
		//Verify dropdown of expense category and line item quantity text 

		if(!strBrand.equalsIgnoreCase("android")){
		 switchToNativeContext();
		}
		if(isElementPresent(getObject(link_SelectItemType))){
			FrameworkReporter.pass("Dropdown of item category line item is displayed as expected");
		}else{
			FrameworkReporter.fail("Dropdown of item category  line item is not displayed as expected");
		}
	   
	   
		switchToWebContext();
		if(isElementPresent(txt_ItemPrice)){
			FrameworkReporter.pass("Line item quantity  is displayed as expected");
		}else{
			FrameworkReporter.fail("Line item quantity  is not displayed as expected");
		}
		
		switchToWebContext();
		sendText(txt_ItemPrice, strItemPrice);
		FrameworkReporter.info("Entered item price  :"+strItemPrice);
		//click on select dropdown

		if(!strBrand.equalsIgnoreCase("android")){
			 switchToNativeContext();
			}
		
	    clickElement(getObject(link_SelectItemType));
	   
	   if(!strBrand.equalsIgnoreCase("ipad")&&!strBrand.equalsIgnoreCase("android"))
	    {
	    	if(isElementClickable(link_SelectItemType))
	    	{
	    		  clickElement(getObject(link_SelectItemType));
	    	}
	    }
		FrameworkReporter.info("Tapped on select to select the item type");
		
	}
	
		
	/**
	 * @Function verifyLineItemAddedSuccessMsg
	 * @Description Verify success message if line item added 
	 * @author Sampada Dalai
	 * @date 14-10-2016
	 */
	
   public void verifyLineItemAddedSuccessMsg(){
	   switchToWebContext();
	if(isElementPresentAfterWait(modal_SuccessMsg, 10)) {
		FrameworkReporter.pass("Line item is added successfully");
	} else {
		FrameworkReporter.fail("Line item is not added successfully");
	}
   }
	
	/**
	 * @Function clickOnNoToAddInvoices
	 * @Description click on 'No i am done' to get the invoices added in to the purchases
	 * @author Sampada Dalai
	 * @date 14-10-2016
	 */
	
   public void clickOnNoToAddInvoices(){
	   switchToWebContext();
	   clickElement(btn_NoIAmDone);
	   FrameworkReporter.info("Clicked on 'No i am done' button");
  }
   
   /**
	 * @Function verifyModalPopUpIfNoItemAdded
	 * @Description Verify modal pop up if no line item added 
	 * @author Sampada Dalai
	 * @date 14-10-2016
	 */
	
  public void verifyModalPopUpIfNoItemAdded(){
	   switchToWebContext();
	if(isElementPresentAfterWait(modal_NoItemMesssage, 10)) {
		FrameworkReporter.pass("Modal popup is displayed with message '"+getElementText(modal_NoItemMesssage)+"'  since no line items are added");
	} else {
		FrameworkReporter.fail("Modal popup is not displayed with message though no line items are added");
	}
  }
  
  /**
	 * @Function clickOnConfirm
	 * @Description click on confirm
	 * @author Sampada Dalai
	 * @date 14-10-2016
	 */
	
 public void clickOnConfirm(){
	   switchToWebContext();
	   clickElement(btn_Confirm);
	   FrameworkReporter.info("Clicked on confirm");
}
 /**
	 * @Function clickOnCancelPurChase
	 * @Description click on cancel
	 * @author Sampada Dalai
	 * @date 14-10-2016
	 */
	
public void clickOnCancelPurChase(){
	   switchToWebContext();
	   clickElement(btn_Cancel);
	   FrameworkReporter.info("Clicked on cancel link in purchase");
}

/**
 * @Function clickOnDeletePurChase
 * @Description click on delete link(-) 
 * @author Sampada Dalai
 * @date 14-10-2016
 */

public void clickOnDeleteItemLink(String strLineItemIndex){
//	try {
        switchToWebContext();
        String deleteItemType = "";
        String deleteItemPrice = "";
        Select lineItem = new Select(waitForElementPresent(replaceDynamicText(lst_ItemType, strLineItemIndex)));
        deleteItemType = lineItem.getFirstSelectedOption().toString();
        deleteItemPrice = getElementAttributeValue(replaceDynamicText(lst_ItemPriceByIndex, strLineItemIndex), "value");
        clickElement(replaceDynamicText(lnk_Delete, strLineItemIndex));
        storeValue("DeletedPurchaseType", deleteItemType);
        storeValue("DeletedPurchasePrice", deleteItemPrice);
        FrameworkReporter.info("clicked on delete link(-)");
//    }
//    catch (Exception e)
//    {
//
//    }
}

/**
 * @Function clickOnDeleteItemButton
 * @Description click on Item delete button
 * @author Sampada Dalai
 * @date 14-10-2016
 */

public void clickOnDeleteItemButton(){
   switchToWebContext();
   clickElement(btn_Delete);
   FrameworkReporter.info("clicked on delete button");
}


/**
 * @Function getFoodPurchases
 * @Description Capture the purchases made for food
 * @author Gayathri
 * @date 17-10-2016
 */

public void getFoodPurchases(String strLineItemType,String strLineItemQunatity,String categoryType,int inventoryPeriod){
   switchToWebContext();
   double foodPurchases=0;
   String foodCategories="";String category="";String categoryPrice="";
   DecimalFormat df=new DecimalFormat("0.00");
	switch (categoryType){
	case "default":
		foodCategories="Food";
	break;
	case "suggested":
		foodCategories="Healthcare & Hospitality/Dairy/Meat/Poultry/Seafood/Frozen/Canned and Dry/Produce";
	break;
	case "custom":
	foodCategories=retreiveStoredValue("FoodCategories").toString();
	break;
	}
	if(!retreiveStoredValue("PurchaseValue"+inventoryPeriod).equals("null")){
		foodPurchases=Double.parseDouble(retreiveStoredValue("PurchaseValue"+inventoryPeriod).toString());
	}
	for(int i=0;i<strLineItemType.split("/").length;i++){
		category=strLineItemType.split("/")[i];
		categoryPrice=strLineItemQunatity.split("/")[i];
		double oldPrice=0;
		for(int j=0;j<foodCategories.split("/").length;j++){
			if(category.equalsIgnoreCase(foodCategories.split("/")[j])){
				if(!retreiveStoredValue(category+"_Purchase"+inventoryPeriod).toString().equals("null")){
					oldPrice=Double.parseDouble(retreiveStoredValue(category+"_Purchase"+inventoryPeriod).toString());
				}
				storeValue(category+"_Purchase"+inventoryPeriod, df.format(Double.parseDouble(categoryPrice)+oldPrice));
				foodPurchases=foodPurchases+Double.parseDouble(categoryPrice.replace("$", ""));
				break;
			}}
	}
	storeValue("PurchaseValue"+inventoryPeriod, foodPurchases);
}

/**
 * @Function addFoodPurchases
 * @Description Capture the newly added line item price made for food
 * @author Gayathri
 * @date 17-10-2016
 */

public void getAddedFoodPurchases(String strLineItemType,String strLineItemQunatity,int inventoryPeriod){
   switchToWebContext();
   double foodPurchases=0;
   String foodCategories="";String category="";String categoryPrice="";
   DecimalFormat df=new DecimalFormat("0.00");
	if(!retreiveStoredValue("PurchaseValue"+inventoryPeriod).equals("null")){
		foodPurchases=Double.parseDouble(retreiveStoredValue("PurchaseValue"+inventoryPeriod).toString());
	}
	category=strLineItemType;
	categoryPrice=strLineItemQunatity;
	double oldPrice=0;
	if(!retreiveStoredValue(category+"_Purchase"+inventoryPeriod).toString().equals("null")){
		oldPrice=Double.parseDouble(retreiveStoredValue(category+"_Purchase"+inventoryPeriod).toString());
	}
	storeValue(category+"_Purchase"+inventoryPeriod, df.format(Double.parseDouble(categoryPrice)+oldPrice));
	foodPurchases=foodPurchases+Double.parseDouble(categoryPrice.replace("$", ""));			
	storeValue("PurchaseValue"+inventoryPeriod, foodPurchases);
}
/**
 * @Function getEditedFoodPurchases
 * @Description Capture the edited line item price made for food
 * @author Gayathri
 * @date 17-10-2016
 */

public void editFoodPurchases(int inventoryPeriod){
   switchToWebContext();
   double foodPurchases=0;
   String foodCategories="";String category="";
   DecimalFormat df=new DecimalFormat("0.00");
	if(!retreiveStoredValue("PurchaseValue"+inventoryPeriod).equals("null")){
		foodPurchases=Double.parseDouble(retreiveStoredValue("PurchaseValue"+inventoryPeriod).toString());
	}
	category=retreiveStoredValue("EditedPurchaseType").toString();
	String strLineItemOldQunatity=retreiveStoredValue("EditedPurchaseOldPrice").toString();
	String strLineItemNewQuantity=retreiveStoredValue("EditedPurchaseNewPrice").toString();
	double oldPrice=0;
	if(!retreiveStoredValue(category+"_Purchase"+inventoryPeriod).toString().equals("null")){
		oldPrice=Double.parseDouble(retreiveStoredValue(category+"_Purchase"+inventoryPeriod).toString());
	}
	storeValue(category+"_Purchase"+inventoryPeriod, df.format(oldPrice-Double.parseDouble(strLineItemOldQunatity)+Double.parseDouble(strLineItemNewQuantity)));
	foodPurchases=foodPurchases-Double.parseDouble(strLineItemOldQunatity)+Double.parseDouble(strLineItemNewQuantity);			
	storeValue("PurchaseValue"+inventoryPeriod, df.format(foodPurchases));
}

/**
 * @Function validateTotalPurchases
 * @Description validate total purchases 
 * @author Sampada Dalai
 * @date 14-10-2016
 */

public void validateTotalPurchases(String strExpectedPurchaseValue){
   switchToWebContext();
   String strActualPurchaseValue=getElementText(txt_TotalPurchase);
   System.out.println("Purchases values is displayed as :"+strActualPurchaseValue);
   if(strActualPurchaseValue.trim().equals(strExpectedPurchaseValue)){
	   FrameworkReporter.pass("Total purchase value is validated and displayed  as :"+strExpectedPurchaseValue);
   }else{
	   FrameworkReporter.fail("Total purchase value is not same as exepected and the actual total purchase value displayed as :"+strActualPurchaseValue);
   }
}

/**
 * @Function editPurChaseLineItemPrice
 * @Description Edit purchase line item
 * @author Gayathri
 * @date 14-10-2016
 */
 

public void editPurChaseLineItemPrice(String editItemNewPrice,String strLineItemIndex){
   switchToWebContext();
   String editItemType=""; String editItemOldPrice="";
   Select lineItem=new Select(waitForElementPresent(replaceDynamicText(lst_ItemType, strLineItemIndex)));
   editItemType=lineItem.getFirstSelectedOption().toString();
   editItemOldPrice=getElementAttributeValue(replaceDynamicText(lst_ItemPriceByIndex, strLineItemIndex), "value");
   sendText(replaceDynamicText(lst_ItemPriceByIndex, strLineItemIndex), editItemNewPrice);
   storeValue("EditedPurchaseType", editItemType);
   storeValue("EditedPurchaseOldPrice",editItemOldPrice);
   storeValue("EditedPurchaseNewPrice",strLineItemIndex);
   FrameworkReporter.info("Edited line item price");
}
/**
 * @Function getDeletedFoodPurchases
 * @Description Capture the deleted line item price made for food
 * @author Gayathri
 * @date 17-10-2016
 */

public void getDeletedFoodPurchases(int inventoryPeriod){
   switchToWebContext();
   double foodPurchases=0;
   String foodCategories="";String category="";
   DecimalFormat df=new DecimalFormat("0.00");
	if(!retreiveStoredValue("PurchaseValue"+inventoryPeriod).equals("null")){
		foodPurchases=Double.parseDouble(retreiveStoredValue("PurchaseValue"+inventoryPeriod).toString());
	}
	category=retreiveStoredValue("DeletedPurchaseType").toString();
	String strLineItemQunatity=retreiveStoredValue("DeletedPurchasePrice").toString();
	double oldPrice=0;
	if(!retreiveStoredValue(category+"_Purchase"+inventoryPeriod).toString().equals("null")){
		oldPrice=Double.parseDouble(retreiveStoredValue(category+"_Purchase"+inventoryPeriod).toString());
	}
	storeValue(category+"_Purchase"+inventoryPeriod, df.format(oldPrice-Double.parseDouble(strLineItemQunatity)));
	foodPurchases=foodPurchases-Double.parseDouble(strLineItemQunatity);			
	storeValue("PurchaseValue"+inventoryPeriod, df.format(foodPurchases));
}


/**
 * @Function selectAccountForMAUser
 * @description	Select accounts
 * @author Sampada Dalai 
 * @param 
 * @date 24-09-2016
 */

public void selectAccountForMAUser(){
	switchToWebContext();
	waitForElementPresent(link_SelectAccount, 30);
	clickElement(link_SelectAccount);
	FrameworkReporter.info("Tapped on select account link ");
	clickElement(link_SelectSubway);
	FrameworkReporter.info("Tapped on account/subway ");

}

/**
 * @Function verifyPurchaseLine
 * @Description Verify purchase line should not be created for MA user
 * @author Sampada Dalai
 * @date 14-10-2016
 */

public void verifyPurchaseLine(String strIndex){

		switchToWebContext();
		waitForElementPresent(replaceDynamicText(lnk_PurchaseLine, strIndex),10);
		if(getElementCount(replaceDynamicText(lnk_PurchaseLine, strIndex))==0){
			FrameworkReporter.pass("Purchase line is not created for MA user as expected");
		}else{
			FrameworkReporter.fail("Purchase line is created for MA user ");
		}
			

}

/**
 * @Function validateInvoiceTotalPurchases
 * @Description Validate the Invoice Total for Purchase
 * @author Sampada Dalai
 * @date 14-10-2016
 */


public void validateInvoiceTotalPurchases(String strExpectedInvTotalValue){
   switchToWebContext();
   String strActualTotalInvoiceValue=getElementText(txt_InvoiceTotal);
   System.out.println("Purchases values is displayed as :"+strActualTotalInvoiceValue);
   if(strActualTotalInvoiceValue.trim().equals(strExpectedInvTotalValue)){
	   FrameworkReporter.pass("Invoice Total value is validated and displayed  as :"+strExpectedInvTotalValue);
   }else{
	   FrameworkReporter.fail("Invoice Total value is not same as exepected and the actual total purchase value displayed as :"+strActualTotalInvoiceValue);
   }
   FrameworkReporter.info("clicked on delete button");
}

/**
 * @Function validateLineTitemTotal
 * @Description validate line item total 
 * @author Sampada Dalai
 * @date 14-10-2016
 */

public void validateLineTitemTotal(String strExpectedValue){
   switchToWebContext();
   String strActualValue=getElementText(txt_LineItemTotal).replace(" ", "");
   System.out.println("Line item total is displayed as :"+strActualValue);
   if(strActualValue.trim().equals(strExpectedValue)){
	   FrameworkReporter.pass("Line item total is validated and displayed  as :"+strExpectedValue);
   }else{
	   FrameworkReporter.fail("Line item total is not same as exepected and the actual Line item total displayed as :"+strActualValue);
   }
}




/**
 * @Function verifyInvoiceTotal
 * @Description validate invoice total in purchases screen
 * @author Periyasamy Nainar
 * @date 22-10-2016
 */

public void verifyInvoiceTotal(String strExpectedPurchaseValue){
   switchToWebContext();
   String strActualPurchaseValue=getElementText(lbl_InvoiceTotal);
   System.out.println("Purchases values is displayed as :"+strActualPurchaseValue);
   if(strActualPurchaseValue.trim().equals(strExpectedPurchaseValue)){
	   FrameworkReporter.pass("Invoice Total value is validated and displayed  as :"+strExpectedPurchaseValue);
   }else{
	   FrameworkReporter.fail("Invoice Total value is not same as exepected and the actual total purchase value displayed as :"+strActualPurchaseValue);
   }
}



/**
 * @Function verifyInvoiceTotalInPurchaseDetails
 * @Description validate invoice total in purchases details screen
 * @author Periyasamy Nainar
 * @date 22-10-2016
 */

public void verifyInvoiceTotalInPurchaseDetails(String strExpectedPurchaseValue){
   switchToWebContext();
   String strActualPurchaseValue=getElementAttributeValue(txt_InvoiceTotal,"value");
   System.out.println("Purchases values is displayed as :"+strActualPurchaseValue);
   if(strActualPurchaseValue.trim().equals(strExpectedPurchaseValue)){
	   FrameworkReporter.pass("Invoice Total value is validated and displayed  as :"+strExpectedPurchaseValue + " in purchase details page");
   }else{
	   FrameworkReporter.fail("Invoice Total value is not same as exepected and the actual total purchase value displayed as :"+strActualPurchaseValue + " in purchase details page");
   }
   FrameworkReporter.info("clicked on delete button");
}

/**
 * @Function verifyInvoiceTotalInPurchaseDetails
 * @Description validate invoice total in purchases details screen
 * @author Periyasamy Nainar
 * @date 22-10-2016
 */

public void verifyLineItemPrice(String strIndex, String strExpectedLineItemValue){
   switchToWebContext();
   String strActualLineItemValue=getElementAttributeValue(replaceDynamicText(lbl_LineItemPrice, strIndex), "placeholder");
   System.out.println("Purchases values is displayed as :"+strActualLineItemValue);
   if(strActualLineItemValue.trim().equals(strExpectedLineItemValue)){
	   FrameworkReporter.pass("Line Item value is validated and displayed  as :"+strExpectedLineItemValue + " in purchase details page");
   }else{
	   FrameworkReporter.fail("Line Item value is not same as exepected and the actual Line Item value displayed as :"+strActualLineItemValue + " in purchase details page");
   }
   FrameworkReporter.info("clicked on delete button");
}


/**
 * @Function verifyLineItemTotalInPurchaseDetails
 * @Description validate line item total in purchases details screen with/without decimal value - format validation
 * @author Periyasamy Nainar
 * @date 22-10-2016
 */

public void verifyLineItemTotalInPurchaseDetails(String strExpectedPurchaseValue){
   switchToWebContext();
   String strActualPurchaseValue=getElementText(txt_LineItemTotal);
  // String strActualPurchaseValue=getElementAttributeValue(txt_LineItemTotal,"value");
   System.out.println("Line item total is displayed as :"+strActualPurchaseValue);
   if(strActualPurchaseValue.replace(" ","").trim().equals(strExpectedPurchaseValue)){
	   FrameworkReporter.pass("Line Item Total value is validated and displayed  as :"+strExpectedPurchaseValue + " in purchase details page");
   }else{
	   FrameworkReporter.fail("Line Item Total value is not same as exepected and the actual total purchase value displayed as :"+strActualPurchaseValue + " in purchase details page");
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
	//			childClassObject= new IOSPurchasePage().findChildObject(parentObject[2]);	
				break;
			case "ipad":	
				childClassObject = new IOSTabletPurchasePage().findChildObject(parentObject[2]);
				break;
			case "android":
				childClassObject = new AndroidPurchasePage().findChildObject(parentObject[2]);					
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
