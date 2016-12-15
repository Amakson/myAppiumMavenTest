package com.uom.pages.androidPhone;

import java.lang.reflect.Field;

import com.uom.pages.common.PurchasePage;

public class AndroidPurchasePage extends PurchasePage{

	public static final String[] link_Supplier= {"//select[@name='supplier']",XPATH,"link_Supplier"};
	public static final String[] link_SelectItemType= {"(//select[@id='categoryId-0'])[1]",XPATH,"link_SelectItemType"};
	public static final String[] txt_LinePrice = {"//input[contains(@name,'currentExtendedPrice')]",XPATH,"txt_LinePrice"};
	
		/*********
		 * Framework function : DO NOT UPDATE/DELETE
		 *********/
	public String[] findChildObject(String reqLocatorName){	
		Field childObjects;
		try {
			childObjects = AndroidPurchasePage.class.getDeclaredField(reqLocatorName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (AndroidPurchasePage.class.getDeclaredField(reqLocatorName).get(null));
			return childObject;
		}
 
		} catch (Exception e) {
			e.printStackTrace();
		}	
	return null;
}
}

