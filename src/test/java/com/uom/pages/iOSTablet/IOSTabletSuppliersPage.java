package com.uom.pages.iOSTablet;

import java.lang.reflect.Field;
import java.util.logging.Logger;

import com.uom.pages.common.SuppliersPage;


public class IOSTabletSuppliersPage extends SuppliersPage{

	public static final String[] lbl_SupplierDetailsName={"//UIATextField[@name='SUPPLIER NAME']",XPATH,"lbl_SupplierDetailsPhoneNumber"};
	public static final String[] lbl_SupplierDetailsPhoneNumber={"//UIATextField[@name='PHONE NUMBER']",XPATH,"lbl_SupplierDetailsPhoneNumber"};
	public static final String[] lbl_SupplierDetailsAddress={"//UIATextField[@name='ADDRESS']",XPATH,"lbl_SupplierDetailsAddress"};
	public static final String[] lbl_SupplierDetailsContactInfo={"//UIATextField[@name='CONTACT INFORMATION']",XPATH,"lbl_SupplierDetailsContactInfo"};
	public static final String[] lbl_SupplierDetailsEmail={"//UIATextField[@name='EMAIL ADDRESS']",XPATH,"lbl_SupplierDetailsEmail"};
	public static final String[] lbl_SupplierDetailsNote={"//UIATextField[@name='NOTE/COMMENTS']",XPATH,"lbl_SupplierDetailsNote"};
	
	
	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqLocatorName){
		Field childObjects;
		try {
			childObjects = IOSTabletSuppliersPage.class.getDeclaredField(reqLocatorName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (IOSTabletSuppliersPage.class.getDeclaredField(reqLocatorName).get(null));
			return childObject;
		}
 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	return null;

}
}
