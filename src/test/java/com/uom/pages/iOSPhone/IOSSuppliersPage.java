package com.uom.pages.iOSPhone;

import java.lang.reflect.Field;

import com.uom.pages.common.SuppliersPage;


public class IOSSuppliersPage extends SuppliersPage {

	//Supplier Details page
	public static final String[] lbl_SupplierDetailsName={"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]",XPATH,"lbl_SupplierDetailsName"};
	public static final String[] lbl_SupplierDetailsPhoneNumber={"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[2]",XPATH,"lbl_SupplierDetailsPhoneNumber"};
	public static final String[] lbl_SupplierDetailsAddress={"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[3]",XPATH,"lbl_SupplierDetailsAddress"};
	public static final String[] lbl_SupplierDetailsContactInfo={"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[4]",XPATH,"lbl_SupplierDetailsContactInfo"};
	public static final String[] lbl_SupplierDetailsEmail={"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[5]",XPATH,"lbl_SupplierDetailsEmail"};
	public static final String[] lbl_SupplierDetailsNote={"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[6]",XPATH,"lbl_SupplierDetailsNote"};

	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqLocatorName){	
		Field childObjects;
		try {
			childObjects = IOSSuppliersPage.class.getDeclaredField(reqLocatorName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (IOSSuppliersPage.class.getDeclaredField(reqLocatorName).get(null));
			return childObject;
		}
 
		}  catch (Exception e) {
			e.printStackTrace();
		}	
	return null;

}
}
