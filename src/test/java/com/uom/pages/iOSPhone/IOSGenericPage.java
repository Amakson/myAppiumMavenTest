package com.uom.pages.iOSPhone;

import java.lang.reflect.Field;

import com.uom.pages.androidPhone.AndroidSuppliersPage;
import com.uom.pages.common.GenericPage;

public class IOSGenericPage extends GenericPage{
	/* Functions on the Page are defined below */
	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqLocatorName){	
		Field childObjects;
		try {
			childObjects = IOSGenericPage.class.getDeclaredField(reqLocatorName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (IOSGenericPage.class.getDeclaredField(reqLocatorName).get(null));
			return childObject;
		}
 
		}  catch (Exception e) {
			e.printStackTrace();
		}	
	return null;

}

}
