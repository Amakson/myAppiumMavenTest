package com.uom.pages.iOSTablet;

import java.lang.reflect.Field;

import com.uom.pages.common.ExpenseCategoriesPage;

public class IOSTabletExpenseCategoriesPage extends ExpenseCategoriesPage{
	
	public static final String[] btn_ExpenseTypeNative={"//*[@label='{dynamic1}']",XPATH,"btn_ExpenseTypeNative"};

	
	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqLocatorName){	
		Field childObjects;
		try {
			childObjects = IOSTabletExpenseCategoriesPage.class.getDeclaredField(reqLocatorName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (IOSTabletExpenseCategoriesPage.class.getDeclaredField(reqLocatorName).get(null));
			return childObject;
		}
 
		}  catch (Exception e) {
			e.printStackTrace();
		}	
	return null;

}
}
