package com.uom.pages.iOSTablet;

import java.lang.reflect.Field;

import com.uom.pages.androidPhone.AndroidLocationsPage;
import com.uom.pages.common.LocationsPage;

public class IOSTabletLocationsPage extends LocationsPage{
	public static final String[] lbl_ItemName={"//*[contains(@class,'mm-c-product-minlist__item')]//*[contains(text(),'{dynamic1}')]/parent::*/parent::*//input",XPATH,"lbl_ItemName"};
	public static final String[] lbl_Product={"//div[@class='mm-c-product-list__details ']//h4[contains(text(),'{dynamic1}')]",XPATH,"lbl_Product"};

	
	//below object remains same across iphone &ipad - so reading it from parent instead of rewritting it. 
	public static final String[] lbl_LocationDetailsName = LocationsPage.lbl_LocationDetailsName;
	public static final String[] lbl_LocationDetailsType = LocationsPage.lbl_LocationDetailsType;
	
	
	
	
	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqLocatorName){
		Field childObjects;
		try {
			if(IOSTabletLocationsPage.class.getDeclaredField(reqLocatorName)!=null){
			childObjects = IOSTabletLocationsPage.class.getDeclaredField(reqLocatorName);	
			String[] childObject;
			String[] objForChild={"","",""};
			if(childObjects.getType().isInstance(objForChild)){
				childObject=(String[]) (IOSTabletLocationsPage.class.getDeclaredField(reqLocatorName).get(null));
				return childObject;
			}else 
				{return null;	}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	return null;

}
}
