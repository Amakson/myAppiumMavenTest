package com.uom.pages.iOSPhone;

import java.lang.reflect.Field;

import com.uom.pages.androidPhone.AndroidSuppliersPage;
import com.uom.pages.common.LocationsPage;

public class IOSLocationsPage extends LocationsPage{

	
	//Location Details
		public static final String[] lbl_LocationDetailsName={"//UIATextField[@name='LOCATION NAME']",XPATH,"lbl_LocationName"};
		public static final String[] lbl_LocationDetailsType={"//UIATextField[@name='LOCATION TYPE']",XPATH,"lbl_LocationType"};
		
		
	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqLocatorName){	
		Field childObjects;
		try {
			childObjects = IOSLocationsPage.class.getDeclaredField(reqLocatorName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (IOSLocationsPage.class.getDeclaredField(reqLocatorName).get(null));
			return childObject;
		}
 
		}  catch (Exception e) {
			e.printStackTrace();
		}	
	return null;

}
}
