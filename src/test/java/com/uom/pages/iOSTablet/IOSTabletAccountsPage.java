package com.uom.pages.iOSTablet;

import java.lang.reflect.Field;

import com.uom.pages.androidPhone.AndroidSuppliersPage;
import com.uom.pages.common.AccountsPage;

public class IOSTabletAccountsPage extends AccountsPage{

	 /*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqLocatorName){	
		Field childObjects;
		try {
			childObjects = IOSTabletAccountsPage.class.getDeclaredField(reqLocatorName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (IOSTabletAccountsPage.class.getDeclaredField(reqLocatorName).get(null));
			return childObject;
		}
 
		}  catch (Exception e) {
			e.printStackTrace();
		}	
	return null;

}
	
	
}
