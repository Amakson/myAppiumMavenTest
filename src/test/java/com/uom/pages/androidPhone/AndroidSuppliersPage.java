package com.uom.pages.androidPhone;

import java.lang.reflect.Field;
import java.util.logging.Logger;

import com.uom.pages.common.SuppliersPage;



public class AndroidSuppliersPage extends SuppliersPage {
	
	//Supplier Details page - Needs to be updated if needed
	public static final String[] lbl_SupplierDetailsName={"//android.widget.EditText[@resource-id='name']",XPATH,"lbl_SupplierDetailsPhoneNumber"};
	public static final String[] lbl_SupplierDetailsPhoneNumber={"//android.widget.EditText[@resource-id='phoneNumber']",XPATH,"lbl_SupplierDetailsPhoneNumber"};
	public static final String[] lbl_SupplierDetailsAddress={"//android.widget.EditText[@resource-id='address']",XPATH,"lbl_SupplierDetailsAddress"};
	public static final String[] lbl_SupplierDetailsContactInfo={"//android.widget.EditText[@resource-id='contactName']",XPATH,"lbl_SupplierDetailsContactInfo"};
	public static final String[] lbl_SupplierDetailsEmail={"//android.widget.EditText[@resource-id='emailAddress']",XPATH,"lbl_SupplierDetailsEmail"};
	public static final String[] lbl_SupplierDetailsNote={"//android.widget.EditText[@resource-id='notes']",XPATH,"lbl_SupplierDetailsNote"};
	
	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqLocatorName){	
		Field childObjects;
		try {
			childObjects = AndroidSuppliersPage.class.getDeclaredField(reqLocatorName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (AndroidSuppliersPage.class.getDeclaredField(reqLocatorName).get(null));
			return childObject;
		}
 
		}  catch (Exception e) {
			e.printStackTrace();
		}	
	return null;

}
}
