		
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


import java.lang.reflect.Field;
import com.uom.commonFunctions.FunctionLibrary;
import com.uom.pages.androidPhone.AndroidSuppliersPage;
import com.uom.pages.iOSPhone.IOSSuppliersPage;
import com.uom.pages.iOSTablet.IOSTabletSuppliersPage;
import com.framework.*;
import com.framework.frameworkFunctions.*;
import com.framework.configuration.*;
import com.framework.reporting.*;

public class SuppliersPage extends LibraryPage {
	
	static Field[] declaredMemberVariables;
	static{
		declaredMemberVariables = SuppliersPage.class.getDeclaredFields();
	}
	
	//new objects
	
	//Suppliers page - UPdated periya
	
	public static final String[] lbl_SuppliersPage={"//*[contains(text(),'Suppliers')]",XPATH,"lbl_SuppliersPage"};
	public static final String[] lbl_SupplierDetailsPage={"//*[text()='Supplier Details']",XPATH,"lbl_SupplierDetailsPage"};
	public static final String[] lst_SuppliersList={"//div[@class='mm-u-list mm-u-navbar-padding']",XPATH,"lst_SuppliersList"};
	public static final String[] lst_Supplier={"//*[@id='list-item']//*[text()='{dynamic1}']/ancestor::button",XPATH,"lst_Supplier"};
	public static final String[] lbl_SyscoSupplier={"(//*[@class='mm-c-simplelist__name'])[1]",XPATH};  // Don't change this xpath, pls check with parvathy/periya before changing it 
	public static final String[] txt_SyscoSupplierNameNotEditable={"//input[@disabled and @value='Sysco']",XPATH,"txt_SyscoSupplierNameNotEditable"};		
	public static final String[] txt_SupplierName={"name",ID,"txt_SupplierName"};
	public static final String[] txt_PhoneNumber={"phoneNumber",ID,"txt_PhoneNumber"};
	public static final String[] txt_Address={"address",ID,"txt_Address"};
	public static final String[] txt_ContactInfo={"contactName",ID,"txt_ContactInfo"};
	public static final String[] txt_Email={"emailAddress",ID,"txt_Email"};
	public static final String[] txt_Note={"notes",ID,"txt_Note"};
	public static final String[] lbl_SupplierName={"//label[contains(text(),'SUPPLIER NAME')]",XPATH,"lbl_SupplierName"};
	public static final String[] lbl_PhoneNumber={"//label[contains(text(),'PHONE NUMBER')]",XPATH,"lbl_PhoneNumber"};
	public static final String[] lbl_Address={"//label[contains(text(),'ADDRESS')]",XPATH,"lbl_Address"};
	public static final String[] lbl_ContactInfo={"//label[contains(text(),'CONTACT INFORMATION')]",XPATH,"lbl_ContactInfo"};
	public static final String[] lbl_Email={"//label[contains(text(),'EMAIL ADDRESS')]",XPATH,"lbl_Email"};
	public static final String[] lbl_Note={"//label[contains(text(),'NOTE/COMMENTS')]",XPATH,"lbl_Note"};
	public static final String[] lbl_AddSupplierPage={"//*[contains(text(),'Add Supplier')]",XPATH,"lbl_AddSupplierPage"};
	
/////	
	
	
	
	public static final String[] lnk_DoneWeb={"//*[@id='done-nav']",XPATH,"lnk_DoneWeb"};
	public static final String[] lnk_Cancel={"//*[contains(text(),'Cancel')]",XPATH,"lnk_Cancel"};
	
	
	
	//Supplier Details page - Needs to be updated if needed
	public static final String[] lbl_SupplierDetailsName={"//UIATextField[@name='SUPPLIER NAME']",XPATH,"lbl_SupplierDetailsPhoneNumber"};
	public static final String[] lbl_SupplierDetailsPhoneNumber={"//UIATextField[@name='PHONE NUMBER']",XPATH,"lbl_SupplierDetailsPhoneNumber"};
	public static final String[] lbl_SupplierDetailsAddress={"//UIATextField[@name='ADDRESS']",XPATH,"lbl_SupplierDetailsAddress"};
	public static final String[] lbl_SupplierDetailsContactInfo={"//UIATextField[@name='CONTACT INFORMATION']",XPATH,"lbl_SupplierDetailsContactInfo"};
	public static final String[] lbl_SupplierDetailsEmail={"//UIATextField[@name='EMAIL ADDRESS']",XPATH,"lbl_SupplierDetailsEmail"};
	public static final String[] lbl_SupplierDetailsNote={"//UIATextField[@name='NOTE/COMMENTS']",XPATH,"lbl_SupplierDetailsNote"};
	
	//updated - 
	public static final String[] lnk_DeleteSupplier={"//button[contains(text(),'Delete this supplier')]",XPATH,"lnk_DeleteSupplier"};
	public static final String[] btn_PhoneIconInForSupplier={"//*[@id='list-item']//*[text()='{dynamic1}']/ancestor::button/parent::*//i[@class='mm-o-icon icon-phone']",XPATH,"btn_PhoneIconInForSupplier"};
	public static final String[] lbl_Suppliers={"//div[@class='mm-u-list__item']",XPATH,"lbl_Suppliers"};
	

	
	
	
	public static final String[] btn_DeleteYes={"yes-button",ID};
	public static final String[] btn_DeleteCancel={"no-button",ID};
	
	
		
	
	/* Functions on the Page are defined below */
	
	/**
	 * @Function verifySuppliersPage
	 * @Description To verify whether supplier page is displayed or not 
	 * @author Gayathri_Anand
	 * @date 19-09-2016
	 */
	public void verifySuppliersPage(){
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_SuppliersPage,10)){
			FrameworkReporter.pass("Suppliers page is displayed");
		}
		else{
			FrameworkReporter.fail("Suppliers page is not displayed");
		}
		
	}
	
	/**
	 * @Function verifyAddSupplierPage
	 * @Description To verify whether Add supplier page is displayed or not 
	 * @author Periyasamy Nainar
	 * @date 19-09-2016
	 */
	public void verifyAddSupplierPage(){
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_AddSupplierPage,10)){
			FrameworkReporter.pass("Add Supplier page is displayed");
		}
		else{
			FrameworkReporter.fail("Add Supplier page is not displayed");
		}
		
	} 
	
	
	/**
	 * @Function verifySupplierDetailsPage
	 * @Description To verify whether supplier details page is displayed or not 
	 * @author Periyasamy Nainar
	 * @date 21-09-2016
	 */
	public void verifySupplierDetailsPage(){
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_SupplierDetailsPage,10)){
			FrameworkReporter.pass("Supplier details page is displayed");
		}
		else{
			FrameworkReporter.fail("Supplier details page is not displayed");
		}
		
	}
	
	
	/**
	 * @Function verifyDeleteSupplier
	 * @Description Verify delete supplier button is not present for sysco supplier and present for non sysco suppliers
	 * @author Periyasamy Nainar
	 * @param boolVal - True for non sysco suppliers and false for sysco suppliers
	 * @date 21-09-2016
	 */
	public void verifyDeleteSupplier(Boolean boolVal){
		switchToWebContext();
		if(boolVal){
			if(isElementPresentAfterWait(lnk_DeleteSupplier,10)){
				FrameworkReporter.pass("Delete supplier link is displayed in Supplier page for non sysco item");
			}
			else{
				FrameworkReporter.fail("Delete supplier link is NOT displayed in Supplier page for non sysco item");
			}
		}else{
			if(!(isElementPresentAfterWait(lnk_DeleteSupplier,10))){
				FrameworkReporter.pass("Delete supplier link is NOT displayed in Supplier page for sysco item");
			}
			else{
				FrameworkReporter.fail("Delete supplier link is displayed in Supplier page for sysco item");
			}
		}
		
	}
	
	
	
	/**
	 * @Function verifySupplierNameEditable
	 * @Description To verify supplier name is not editable for sysco supplier and editable for non sysco suppliers
	 * @author Periyasamy Nainar
	 * @param boolVal - True for non sysco suppliers and false for sysco suppliers
	 * @date 21-09-2016
	 */
	public void verifySupplierNameEditable(Boolean boolVal){
		switchToWebContext();
		if(boolVal){
			if(isElementPresentAfterWait(txt_SupplierName,10)){
				FrameworkReporter.pass("Supplier name is editable for non sysco item");
			}
			else{
				FrameworkReporter.fail("Supplier name is NOT editable for non sysco item");
			}
		}else{
			if(isElementPresentAfterWait(txt_SyscoSupplierNameNotEditable,10)){
			//if(isElementPresentAfterWait(txt_SupplierName,10)){   // need to add && condition for iphone
				FrameworkReporter.pass("Supplier name is NOT editable for sysco item");
			}
			else{
				FrameworkReporter.fail("Supplier name is editable for sysco item");
			}
		}
		
	}
	
	/**
	 * @Function verifySupplierDetailsPage
	 * @Description To verify sysco supplier is displayed in top of the page  
	 * @author Periyasamy Nainar
	 * @date 21-09-2016
	 */
	public void verifySyscoSupplierTopInTheList(){
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_SyscoSupplier,10)){
			FrameworkReporter.pass("Sysco supplier is displayed in top of the page in Suppliers page");
		}
		else{
			FrameworkReporter.fail("Sysco supplier is NOT displayed in top of the page in Suppliers page");
		}
		
	}
	
	
	/**
	 * @Function verifySuppliersList
	 * @Description To verify whether suppliers are displayed in list view
	 * @author Periyasamy Nainar
	 * @description	Verify Suppliers Page is displayed
	 * @date 19-09-2016
	 */
	public void verifySuppliersListInSuppliersPage(){
		switchToWebContext();
		if(isElementPresentAfterWait(lst_SuppliersList,10)){
			FrameworkReporter.pass("Suppliers are dispalyed in list view");
		}
		else{
			FrameworkReporter.fail("Suppliers are NOT dispalyed in list view");
		}
		
	}
	
	
	/**
	 * @Function verifySupplierDetailsPageInfo
	 * @Description To verify all the elements are dispalyed in supplier page(label- supplier name, phone no,,,) 
	 * @author Periyasamy Nainar
	 * @description	Verify Suppliers Page is displayed
	 * @date 21-09-2016
	 */
	public void verifyAddSupplierPageFieldsInfo(){
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_SupplierName,10) && isElementPresentAfterWait(txt_SupplierName,10)){
			FrameworkReporter.pass("Supplier name label and text box are dispalyed in Add supplier page");
		}
		else{
			FrameworkReporter.fail("Supplier name label and text box are dispalyed in Add supplier page");			
		}
		
		if(isElementPresentAfterWait(lbl_PhoneNumber,10) && isElementPresentAfterWait(txt_PhoneNumber,10)){
			FrameworkReporter.pass("Supplier phone number label and text box are dispalyed in Add supplier page");
		}
		else{
			FrameworkReporter.fail("Supplier phone number label and text box are dispalyed in Add supplier page");			
		}
		
		if(isElementPresentAfterWait(lbl_Address,10) && isElementPresentAfterWait(txt_Address,10)){
			FrameworkReporter.pass("Supplier address label and text box are dispalyed in Add supplier page");
		}
		else{
			FrameworkReporter.fail("Supplier address label and text box are dispalyed in Add supplier page");			
		}
		
		if(isElementPresentAfterWait(lbl_ContactInfo,10) && isElementPresentAfterWait(txt_ContactInfo,10)){
			FrameworkReporter.pass("Supplier contact info label and text box are dispalyed in Add supplier page");
		}
		else{
			FrameworkReporter.fail("Supplier contact info label and text box are dispalyed in Add supplier page");			
		}
		
		if(isElementPresentAfterWait(lbl_Email,10) && isElementPresentAfterWait(txt_Email,10)){
			FrameworkReporter.pass("Supplier email label and text box are dispalyed in Add supplier page");
		}
		else{
			FrameworkReporter.fail("Supplier email label and text box are dispalyed in Add supplier page");			
		}
		
		if(isElementPresentAfterWait(lbl_Note,10) && isElementPresentAfterWait(txt_Note,10)){
			FrameworkReporter.pass("Supplier note/comments label and text box are dispalyed in Add supplier page");
		}
		else{
			FrameworkReporter.fail("Supplier note/comments label and text box are dispalyed in Add supplier page");			
		}
		
		
	}
	
	
	/**
	 * @Function verifySupplierInSupplierList
	 * @author Gayathri_Anand
	 * @description	Verify whether the passed supplier is displayed in the supplier list
	 * @param supplierName - Supplier name, isExpected - true or false whether supplier is expected or not
	 * @date 19-09-2016
	 */
	public void verifySupplierInSupplierList(String supplierName,boolean isExpected){	
		switchToWebContext();
		if(isExpected){
			if(isElementPresentAfterWait(replaceDynamicText(lst_Supplier, supplierName),10)){
				FrameworkReporter.pass("Supplier '"+supplierName+"' is displayed in the supplier list");
			}
			else{
				FrameworkReporter.fail("Supplier '"+supplierName+"' is not displayed in the supplier list");
			}
		}
		else{
			if(!isElementPresent(replaceDynamicText(lst_Supplier, supplierName))){
				FrameworkReporter.pass("Supplier '"+supplierName+"' is not displayed in the supplier list");
			}
			else{
				FrameworkReporter.fail("Supplier '"+supplierName+"' is displayed in the supplier list");
			}
		}
		
	}

	

	
	/**
	 * @Function tapSupplierFromList
	 * @author Gayathri_Anand
	 * @description	Select supplier from the suppliers list
	 * @param supplierName - Supplier name
	 * @date 19-09-2016
	 */
	public void tapSupplierFromList(String supplierName){
		switchToWebContext();
		String[] strSupplier = {};
		//if(lst_Supplier[0].contains("{dynamic1}")){
			//lst_Supplier[0]=lst_Supplier[0].replace("{dynamic1}",supplierName);
		//	strSupplier = lst_Supplier;
		//	strSupplier[0]=strSupplier[0].replace("{dynamic1}",supplierName);
			clickElement(replaceDynamicText(lst_Supplier, supplierName));
			FrameworkReporter.info("Tapped on supplier '"+supplierName+"' from suppliers page");
		//}
		
	}
	
	
	
	
	/**
	 * @Function verifySupplierDetails
	 * @author Gayathri_Anand
	 * @description	Verify supplier details
	 * @param supplierName- supplier name, phoneNum - supplier phone number, address - supplier address, contactinfo - supplier contact info, email - supplier email, note - 
	 * @date 19-09-2016
	 */
	public void verifySupplierDetails(String supplierName, String phoneNum,String address, String contactinfo, String email, String note){
		switchToWebContext();
		if(!supplierName.isEmpty()){
			
			if(getElementAttributeValue(txt_SupplierName,"value").toString().equals(supplierName)){
				FrameworkReporter.pass("Supplier name '" +supplierName+ "' is displayed as expected");
			}
			else{
				FrameworkReporter.fail("Supplier name is not displayed as expected value: "+supplierName+", displayed as: "+getElementText(getObject(lbl_SupplierDetailsName)));
			}
		}
		if(!phoneNum.isEmpty()){
			if(getElementAttributeValue(txt_PhoneNumber,"value").equals(phoneNum)){
				FrameworkReporter.pass("Supplier phone number '" +phoneNum+ "'  is displayed as expected");
			}
			else{
				
				FrameworkReporter.fail("Supplier phone number is not displayed as expected value: "+phoneNum+", displayed as: "+getElementText(getObject(lbl_SupplierDetailsPhoneNumber)));
			}
		}
		if(!phoneNum.isEmpty()){
			if(getElementAttributeValue(txt_Address,"value").equals(address)){
				FrameworkReporter.pass("Supplier address '" +address+ "'  is displayed as expected");
			}
			else{
				
				FrameworkReporter.fail("Supplier address is not displayed as expected value: "+address+", displayed as: "+getElementText(getObject(lbl_SupplierDetailsAddress)));
			}
		}
		if(!contactinfo.isEmpty()){
			if(getElementAttributeValue(txt_ContactInfo,"value").equals(contactinfo)){
				FrameworkReporter.pass("Supplier contactinfo '" +contactinfo+ "' is displayed as expected");
			}
			else{
				
				FrameworkReporter.fail("Supplier contactinfo is not displayed as expected value: "+contactinfo+", displayed as: "+getElementText(getObject(lbl_SupplierDetailsContactInfo)));
			}
		}
		if(!email.isEmpty()){
			if(getElementAttributeValue(txt_Email,"value").equals(email)){
				FrameworkReporter.pass("Supplier email '" +email+ "'  is displayed as expected");
			}
			else{
				
				FrameworkReporter.fail("Supplier email is not displayed as expected value: "+email+", displayed as: "+getElementText(getObject(lbl_SupplierDetailsEmail)));
			}
		}
		if(!note.isEmpty()){
			if(getElementAttributeValue(txt_Note,"value").equals(note)){
				FrameworkReporter.pass("Supplier note '" +note+ "'  is displayed as expected");
			}
			else{				
				FrameworkReporter.fail("Supplier note is not displayed as expected value: "+note+", displayed as: "+getElementText(getObject(lbl_SupplierDetailsNote)));
			}
		}
		switchToWebContext();
		
	}
	
	/**
	 * @Function tapDeleteSupplier
	 * @author Gayathri_Anand
	 * @description	Tap on Delete supplier
	 * @date 20-09-2016
	 */
	public void tapDeleteSupplier(){
		switchToWebContext();
		clickElement(lnk_DeleteSupplier);
		FrameworkReporter.info("Tapped on delete supplier from supplier details page");
		
	}
	
	
	/**
	 * @Function enterSupplierDetails
	 * @author Gayathri_Anand
	 * @description	Enter supplier details
	 * @param supplierName- supplier name, phoneNum - supplier phone number, address - supplier address, contactinfo - supplier contact info, email - supplier email, note - 
	 * @date 20-09-2016
	 */
	public void enterSupplierDetails(String supplierName,String phoneNum,String address, String contactinfo, String email, String note){
		switchToWebContext();
		FrameworkReporter.info("Entering supplier details");
		if(!supplierName.isEmpty()){
			sendText(txt_SupplierName,supplierName);
			//	FrameworkReporter.info("Entered supplier name");
		}
		if(!phoneNum.isEmpty()){
			sendText(txt_PhoneNumber,phoneNum);
			//FrameworkReporter.info("Entered supplier phone number");
		}
		if(!address.isEmpty()){		
			sendText(txt_Address,address);
			//FrameworkReporter.info("Entered supplier address");
		}
		if(!contactinfo.isEmpty()){
			sendText(txt_ContactInfo,contactinfo);
			//FrameworkReporter.info("Entered supplier contactinfo");
		}
		if(!email.isEmpty()){
			sendText(txt_Email,email);
			//FrameworkReporter.info("Entered supplier email");
		}
		if(!note.isEmpty()){
			sendText(txt_Note,note);
			//FrameworkReporter.info("Entered supplier note");
		}
		
	}
	
	
	/**
	 * @Function verifyPhoneCallIconForSupplier
	 * @Description To verify phone call icon is dispalyed for suppliers who has phone number in contact details
	 * @author Periyasamy Nainar
	 * @param boolVal - True r false
	 * @date 18-10-2016
	 */
	public void verifyPhoneCallIconForSupplier(String strSupplierName, Boolean boolVal){
		switchToWebContext();
		if(boolVal){
			
			if(ConfigFile.getProperty("brand").equalsIgnoreCase("ipad")){   // only for iPad
				if(!(isElementPresentAfterWait(replaceDynamicText(btn_PhoneIconInForSupplier, strSupplierName),10))){
					FrameworkReporter.pass("Phone call icon is not displayed for the supplier " + strSupplierName + "in suppliers page as the device is IPAD");
				}
				else{
					FrameworkReporter.fail("Phone call icon is displayed for the supplier " + strSupplierName + "in suppliers page even in IPAD");
				}
			}else{		// except ipad	
				if(isElementPresentAfterWait(replaceDynamicText(btn_PhoneIconInForSupplier, strSupplierName),10)){
					FrameworkReporter.pass("Phone call icon is displayed for the supplier " + strSupplierName + "in suppliers page");
				}
				else{
					FrameworkReporter.fail("Phone call icon is not displayed for the supplier " + strSupplierName + "in suppliers page");
				}
			}
		}else{
			if(!(isElementPresentAfterWait(replaceDynamicText(btn_PhoneIconInForSupplier, strSupplierName),10))){
				FrameworkReporter.pass("Phone call icon is not displayed for the supplier " + strSupplierName + "in suppliers page as the supplier don't have contact number");
			}
			else{
				FrameworkReporter.fail("Phone call icon is displayed for the supplier " + strSupplierName + "in suppliers page even though the supplier don't have contact number");
			}
		}
		
	}
	
	
	
	/**
	 * @Function verifyPhoneCallIconForSupplier
	 * @Description To verify phone call icon is dispalyed for suppliers who has phone number in contact details
	 * @author Periyasamy Nainar
	 * @param boolVal - True r false
	 * @date 18-10-2016
	 */
	public void verifyNumberOfSuppliers(String strCount){
		switchToWebContext();		
				
		if(getElementCount(lbl_Suppliers) == Integer.parseInt(strCount)){			
				FrameworkReporter.pass("Number of suppliers are dispalyed correctly as expected in suppliers page. count: "+ strCount);
			}
			else{
				FrameworkReporter.fail("Number of suppliers are not displayed correctly as expected in suppliers page. count: "+ strCount);
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
					//childClassObject= new IOSSuppliersPage().findChildObject(parentObject[2]);	
					break;
				case "ipad":	
					childClassObject = new IOSTabletSuppliersPage().findChildObject(parentObject[2]);	
					break;
				case "android":
					childClassObject = new AndroidSuppliersPage().findChildObject(parentObject[2]);					
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
	/*public String[] getObject(String[] parentObject)
	{
		
		String[] childClassObject =null;
		Object obj;
		String brand =ConfigFile.getProperty("brand").toString().toLowerCase().trim();
		for(int i=0;i<declaredMemberVariables.length-1;i++){
			Field tmpField=declaredMemberVariables[i];
			//compare with the parentObject
			if(tmpField.getName().equalsIgnoreCase(parentObject[2]))
			{
				switch (brand) {
				case "iphone":				
					obj =new IOSSuppliersPage();
					childClassObject= ((IOSSuppliersPage) obj).findChildObject(tmpField.getName());	
					break;
				case "ipad":	
					obj =new IOSTabletSuppliersPage();
					childClassObject= ((IOSTabletSuppliersPage) obj).findChildObject(tmpField.getName());
					break;
				case "android":
					obj =new AndroidSuppliersPage();
					childClassObject= ((AndroidSuppliersPage) obj).findChildObject(tmpField.getName());					
					break;
				case "android tablet":
					break;
					
				case "desktop":
					break;
				default:
					break;
				}
			}
			if(null!=childClassObject){
				return childClassObject;
			}		
		}
		return parentObject;
	}*/
	
}
