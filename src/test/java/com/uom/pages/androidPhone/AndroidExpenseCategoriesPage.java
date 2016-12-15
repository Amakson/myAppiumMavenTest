package com.uom.pages.androidPhone;

import java.lang.reflect.Field;

import com.uom.pages.common.ExpenseCategoriesPage;

public class AndroidExpenseCategoriesPage extends ExpenseCategoriesPage{

	public static final String[] btn_ExpenseTypeNative={"//*[@content-desc='{dynamic1}']",XPATH,"btn_ExpenseTypeNative"};
	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqLocatorName){	
		Field childObjects;
		try {
			childObjects = AndroidExpenseCategoriesPage.class.getDeclaredField(reqLocatorName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (AndroidExpenseCategoriesPage.class.getDeclaredField(reqLocatorName).get(null));
			return childObject;
		}
 
		} catch (Exception e) {
		e.printStackTrace();
		}	
	return null;

}
}
