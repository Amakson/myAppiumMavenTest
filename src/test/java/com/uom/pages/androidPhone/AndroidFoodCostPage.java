package com.uom.pages.androidPhone;

import java.lang.reflect.Field;

import com.uom.pages.common.FoodCostPage;

public class AndroidFoodCostPage extends FoodCostPage{
	 /*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqLocatorName){	
		Field childObjects;
		try {
			childObjects = AndroidFoodCostPage.class.getDeclaredField(reqLocatorName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (AndroidFoodCostPage.class.getDeclaredField(reqLocatorName).get(null));
			return childObject;
		}
 
		}  catch (Exception e) {
			e.printStackTrace();
		}	
	return null;

}
}
