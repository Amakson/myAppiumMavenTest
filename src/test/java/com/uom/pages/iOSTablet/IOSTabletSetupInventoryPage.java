package com.uom.pages.iOSTablet;

import java.lang.reflect.Field;

import com.uom.pages.common.ExpenseCategoriesPage;
import com.uom.pages.common.SetupInventoryPage;

public class IOSTabletSetupInventoryPage extends SetupInventoryPage{
	public static final String[] btn_LocationWithPosition={"//UIAWebView[1]/UIAButton[{dynamic1}]",XPATH,"btn_LocationWithPosition"};
	public static final String[] btn_AssignProductsLocationName={"//UIAWebView[1]/UIAButton[@label='{dynamic1}']",XPATH,"btn_AssignProductsLocationName"};
	public static final String[] lbl_ItemCount={"//UIAScrollView[2]/UIAWebView[1]/UIAStaticText[16]",XPATH,"lbl_ItemCount"};
	public static final String[] lnk_LocationChevRight={"//UIAScrollView[2]/UIAWebView[1]//UIAStaticText[@name='LOCATIONS']",XPATH,"lnk_LocationChevRight"};
	public static final String[] lnk_CategoryChevRight={"//UIAScrollView[2]/UIAWebView[1]//UIAStaticText[@name='EXPENSE CATEGORIES']",XPATH,"lnk_CategoryChevRight"};
	public static final String[] btn_AssignProductsCategoryName= {"//UIAWebView[1]/UIAButton[@label='{dynamic1}']",XPATH,"btn_AssignProductsCategoryName"};
	public static final String[] lnk_LocationChevDown={"//UIAScrollView[2]/UIAWebView[1]//UIAStaticText[@name='LOCATIONS']",XPATH,"lnk_LocationChevDown"};
	public static final String[] lnk_CategoryChevDown={"//UIAScrollView[2]/UIAWebView[1]//UIAStaticText[@name='EXPENSE CATEGORIES']",XPATH,"lnk_CategoryChevDown"};	
	public static final String[] lbl_ProductDecription={"//UIAScrollView[2]/UIAWebView[1]/UIAStaticText[{dynamic1}]",XPATH,"lbl_ProductDecription"};
	public static final String[] lbl_ProductBrand={"//UIAScrollView[2]/UIAWebView[1]/UIAStaticText[{dynamic1}]",XPATH,"lbl_ProductBrand"};
	public static final String[] lbl_ProductPack={"//UIAScrollView[2]/UIAWebView[1]/UIAStaticText[{dynamic1}]",XPATH,"lbl_ProductPack"};
	public static final String[] lbl_ProductId={"//UIAScrollView[2]/UIAWebView[1]/UIAStaticText[{dynamic1}]",XPATH,"lbl_ProductId"};
	public static final String[] lbl_ProductCategory={"//UIAScrollView[2]/UIAWebView[1]/UIAStaticText[{dynamic1}]",XPATH,"lbl_ProductCategory"};
	public static final String[] lbl_ProductLocation={"//UIAScrollView[2]/UIAWebView[1]/UIAStaticText[{dynamic1}]",XPATH,"lbl_ProductLocation"};
	
	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqLocatorName){	
		Field childObjects;
		try {
			childObjects = IOSTabletSetupInventoryPage.class.getDeclaredField(reqLocatorName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (IOSTabletSetupInventoryPage.class.getDeclaredField(reqLocatorName).get(null));
			return childObject;
		}
 
		}  catch (Exception e) {
			e.printStackTrace();
		}	
	return null;

}
}
