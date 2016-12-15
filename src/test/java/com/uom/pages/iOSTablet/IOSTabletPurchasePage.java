package com.uom.pages.iOSTablet;

import java.lang.reflect.Field;

import com.uom.pages.common.PurchasePage;

public class IOSTabletPurchasePage extends PurchasePage{
	
    public static final String[] link_Supplier= {"//UIAElement[@name='SELECT SUPPLIER']",XPATH,"link_Supplier"};
    public static final String[] link_SelectItemType={"//UIAElement[@value ='Select']",XPATH,"link_SelectItemType"};
	public static final String[] txt_LinePrice = {"//UIAWebView[1]/UIATextField[not(@name = 'INVOICE NUMBER') and not(@name = 'INVOICE TOTAL')]",XPATH,"txt_LinePrice"};


		
	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqLocatorName){
		Field childObjects;
		try {
			childObjects = IOSTabletPurchasePage.class.getDeclaredField(reqLocatorName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (IOSTabletPurchasePage.class.getDeclaredField(reqLocatorName).get(null));
			return childObject;
		}
 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	return null;

}
}
