package com.uom.pages.iOSTablet;

import java.lang.reflect.Field;

import com.uom.pages.common.ProductPage;

public class IOSTabletProductPage extends ProductPage{

	public static final String[] lst_LocQtyUOMNative= {"//UIAElement[@value='{dynamic1}']",XPATH,"lst_LocQtyUOMNative"};
	public static final String[] lst_SelectSupplier= {"//UIAWebView[1]/UIAElement[2]",XPATH,"lst_SelectSupplier"};
	public static final String[] lst_SelectExpenseCategory= {"//UIAWebView[1]/UIAElement[{dynamic1}]",XPATH,"lst_SelectExpenseCategory"};
	public static final String[] lst_SelectLocation= {"//UIAWebView[1]/UIAElement[{dynamic1}]",XPATH,"lst_SelectLocation"};
	public static final String[] lst_SelectUOM= {"//UIAWebView[1]/UIAElement[{dynamic1}]",XPATH,"lst_SelectUOM"};
	public static final String[] lbl_NativeiOS_LocationName= {"//UIAWebView[1]/UIAElement[@value='{dynamic1}']",XPATH,"lbl_NativeiOS_LocationName"};
	public static final String[] txt_LocationQuantity_Native={"//UIAWebView[1]/UIATextField[{dynamic1}]",XPATH,"txt_LocationQuantity_Native"};
	public static final String[] lbl_location={"(//*[@class='mm-c-product-details__location'])[{dynamic1}]//select",XPATH,"lbl_location"};
	
	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqLocatorName){
		Field childObjects;
		try {
			childObjects = IOSTabletProductPage.class.getDeclaredField(reqLocatorName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (IOSTabletProductPage.class.getDeclaredField(reqLocatorName).get(null));
			return childObject;
		}
 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	return null;

}
}
