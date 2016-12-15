package com.uom.pages.iOSTablet;

import java.lang.reflect.Field;
import com.uom.pages.common.NonSyscoPrepItemPage;

public class IOSTabletNonSyscoPrepItemPage extends NonSyscoPrepItemPage{

	

	public static final String[] lst_LocationQtyUOM={"//UIAWebView[1]/UIAStaticText[20]",XPATH,"lst_LocationQtyUOM"};
//	public static final String[] lst_LocationQtyUOM={"(//select)[1]/ancestor::div[@class='mm-u-product-uom-wrapper form-group']",XPATH,"lst_LocationQtyUOM"};

	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqLocatorName){
		Field childObjects;
		try {
			childObjects = IOSTabletNonSyscoPrepItemPage.class.getDeclaredField(reqLocatorName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (IOSTabletNonSyscoPrepItemPage.class.getDeclaredField(reqLocatorName).get(null));
			return childObject;
		}
 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	return null;

}
	
	
}
