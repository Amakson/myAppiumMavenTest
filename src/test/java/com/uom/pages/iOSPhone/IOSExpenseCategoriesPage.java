package com.uom.pages.iOSPhone;

import java.lang.reflect.Field;

import com.uom.pages.common.ExpenseCategoriesPage;

public class IOSExpenseCategoriesPage extends ExpenseCategoriesPage{

	
	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqLocatorName){	
		Field childObjects;
		try {
			childObjects = IOSExpenseCategoriesPage.class.getDeclaredField(reqLocatorName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (IOSExpenseCategoriesPage.class.getDeclaredField(reqLocatorName).get(null));
			return childObject;
		}
 
		}  catch (Exception e) {
			e.printStackTrace();
		}	
	return null;

}
}
