package com.uom.pages.iOSPhone;

import java.lang.reflect.Field;

import com.uom.pages.common.PurchasePage;

public class IOSPurchasePage extends PurchasePage{

	//Location Details
	    public static final String[] link_Supplier= {"//UIAElement[@name='SELECT SUPPLIER']",XPATH,"link_Supplier"};
		public static final String[] link_SelectItemType={"//UIAElement[@value ='Select']",XPATH,"link_SelectItemType"};
		public static final String[] txt_LinePrice = {"//UIAWebView[1]/UIATextField[not(@name = 'INVOICE NUMBER') and not(@name = 'INVOICE TOTAL')]",XPATH,"txt_LinePrice"};
		public static final String[] btn_Done= {"//UIAButton[@name='Done'][1]",XPATH,"btn_Done"};
	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqPurchaseName){	
		Field childObjects;
		try {
			childObjects = IOSPurchasePage.class.getDeclaredField(reqPurchaseName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (IOSPurchasePage.class.getDeclaredField(reqPurchaseName).get(null));
			return childObject;
		}
 
		}  catch (Exception e) {
			e.printStackTrace();
		}	
	return null;
	}
}
