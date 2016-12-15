package com.uom.pages.androidPhone;

import java.lang.reflect.Field;

import com.uom.pages.common.ProductPage;

public class AndroidProductPage extends ProductPage{


	

	//native element
		public static final String[] lst_LocQtyUOMNative={"//*[@content-desc='{dynamic1}']",XPATH,"lst_LocQtyUOMNative"};
		public static final String[] lst_LocationOptions={"//android.widget.CheckedTextView[@text='{dynamic1}']",XPATH,"lst_LocationOptions"};
		public static final String[] lst_CategoryOptions={"//android.widget.CheckedTextView[@text='{dynamic1}']",XPATH,"lst_CategoryOptions"};
		public static final String[] lst_SelectExpenseCategory= {"(//select)[3]",XPATH,"lst_SelectExpenseCategory"};
		
		public static final String[] lst_SelectSupplier= {"(//select)[2]",XPATH,"lst_SelectSupplier"};
		
	//	public static final String[] lst_SelectLocation= {"(//android.widget.Spinner)[2]",XPATH,"lst_SelectLocation"};
		public static final String[] lst_SelectLocation= {"//select[@name='locations[{dynamic1}].groupId']",XPATH,"lst_SelectLocation"}; //web element
		
		public static final String[] lst_CompleteNativeList= {"//android.widget.ListView[1]",XPATH,"lst_CompleteNativeList"};
		public static final String[] lst_NativeAndroidList= {"//android.widget.CheckedTextView[@text='{dynamic1}']",XPATH,"lst_NativeAndroidList"};

		public static final String[] lbl_LocationValue={"(//*[contains(@class,'product-details__locations')]//*[contains(@class,'product-details__location disabled')]/span)[{dynamic1}]",XPATH,"lbl_LocationValue"};

		public static final String[] lst_DropdownOption={"//android.widget.CheckedTextView[@text='{dynamic1}']",XPATH,"lst_LocationOptions"};
		public static final String[] lst_SelectExpenseCategoryItem= {"//select[@name='expense']",XPATH,"lst_SelectExpenseCategoryItem"};
		public static final String[] lbl_ImageSlider={"//*[@class='swiper-pagination']",XPATH,"lbl_ImageSlider"};
		
		/*********
		 * Framework function : DO NOT UPDATE/DELETE
		 *********/
	public String[] findChildObject(String reqLocatorName){	
		Field childObjects;
		try {
			childObjects = AndroidProductPage.class.getDeclaredField(reqLocatorName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (AndroidProductPage.class.getDeclaredField(reqLocatorName).get(null));
			return childObject;
		}
 
		} catch (Exception e) {
			e.printStackTrace();
		}	
	return null;

}
}
