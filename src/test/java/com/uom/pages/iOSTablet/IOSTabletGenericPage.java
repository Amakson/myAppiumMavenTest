package com.uom.pages.iOSTablet;

import java.lang.reflect.Field;
import com.uom.pages.common.GenericPage;

public class IOSTabletGenericPage extends GenericPage{
	
	
	
	
	//Below objects are remains same across iPhone and ios devices, so reading the object directly from the parent instead of defining the same locator. 
	// Please check with parvathy/periya before writting this kind of locators. 
	public static final String[] btn_Back= GenericPage.btn_Back;
	public static final String[] btn_Done= GenericPage.btn_Done;
	public static final String[] btn_Cancel= GenericPage.btn_Cancel;
	public static final String[] btn_Edit= GenericPage.btn_Edit;
	public static final String[] btn_Close= GenericPage.btn_Close;
	public static final String[] btn_DeleteYes=GenericPage.btn_DeleteYes;
	
	public static final String[] lst_NativeAndroidIpadList= {"//UIAPopover[1]//UIAStaticText[@label='{dynamic1}']",XPATH,"lst_NativeAndroidIpadList"};
	
	public static final String[] btn_Add= {"//UIAWebView[1]/UIAButton[3]",XPATH,"btn_Add"};
	public static final String[] btn_Add_ListPage= {"//UIAWebView[1]/UIAButton[4]",XPATH,"btn_Add_ListPage"};	
	public static final String[] btn_NativeList_Done= {"(//UIAButton[@name='Done'])[2]",XPATH,"btn_Done"};
	
	
	public static final String[] txt_Search_Native= {"//UIAWebView[1]/UIATextField[1]",XPATH,"txt_Search_Native"};		
	public static final String[] lnk_Next = {"//UIAWebView[1]/UIAButton[@name='Next']",XPATH,"lnk_Next"};
	
	
	
	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqLocatorName){	
		Field childObjects;
		try {
			childObjects = IOSTabletGenericPage.class.getDeclaredField(reqLocatorName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (IOSTabletGenericPage.class.getDeclaredField(reqLocatorName).get(null));
			return childObject;
		}
 
		}  catch (Exception e) {
			e.printStackTrace();
		}	
	return null;

}
}
