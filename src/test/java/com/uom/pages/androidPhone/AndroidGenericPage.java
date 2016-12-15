package com.uom.pages.androidPhone;

import java.lang.reflect.Field;

import com.uom.pages.common.GenericPage;

public class AndroidGenericPage extends GenericPage{
	

	//native elements
	public static final String[] btn_Add= {"//*[@resource-id='add-nav']",XPATH,"btn_Add"};	
	public static final String[] btn_Back= {"//*[@resource-id='back-nav']",XPATH,"btn_Back"};
	public static final String[] btn_Done= {"//*[@resource-id='done-nav']",XPATH,"btn_Done"};
	public static final String[] btn_Cancel= {"//*[@resource-id='cancel-nav']",XPATH,"btn_Cancel"};
	public static final String[] btn_Edit= {"//*[@resource-id='edit-nav']",XPATH,"btn_Edit"};
	public static final String[] btn_Close= {"//*[@resource-id='close-nav']",XPATH,"btn_Close"};
	public static final String[] btn_DeleteYes={"yes-button",ID,"btn_DeleteYes"};
	public static final String[] btn_Next = {"//*[@resource-id='next-nav']",XPATH,"btn_Next"};	
	
	public static final String[] lst_CompleteNativeList= {"//android.widget.ListView[1]",XPATH,"lst_CompleteNativeList"};
	public static final String[] lst_NativeAndroidList= {"//android.widget.ListView[1]//android.widget.CheckedTextView[@text='{dynamic1}']",XPATH,"lst_NativeAndroidList"};
	public static final String[] lnk_Next = {"//*[@resource-id='next-nav']",XPATH,"lnk_Next"};
	

	public static final String[] lst_NativeAndroidIpadList= {"//android.widget.ListView[1]//android.widget.CheckedTextView[@text='{dynamic1}']",XPATH,"lst_NativeAndroidIpadList"};

	public static final String[] btn_Add_ListPage= {"//*[@resource-id='add-nav']",XPATH,"btn_Add_ListPage"};	
	
	/* Functions on the Page are defined below */
	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqLocatorName){	
		Field childObjects;
		try {
			childObjects = AndroidGenericPage.class.getDeclaredField(reqLocatorName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (AndroidGenericPage.class.getDeclaredField(reqLocatorName).get(null));
			return childObject;
		}
 
		}catch (Exception e) {
			e.printStackTrace();
		}	
	return null;

}
}
