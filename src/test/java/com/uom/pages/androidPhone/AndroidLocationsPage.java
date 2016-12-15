package com.uom.pages.androidPhone;

import java.lang.reflect.Field;

import com.framework.reporting.FrameworkReporter;
import com.uom.pages.common.LocationsPage;

public class AndroidLocationsPage extends LocationsPage{
	
	public static final String[] lbl_LocationDetailsName={"//android.widget.EditText[@resource-id='name']",XPATH,"lbl_LocationDetailsName"};
	public static final String[] lbl_LocationDetailsType={"//android.widget.EditText[@resource-id='storage']",XPATH,"lbl_LocationDetailsType"};
	public static final String[] btn_Close= {"//*[@resource-id='close-nav']",XPATH,"btn_Close"};

	public static final String[] txt_EnterItemQuantity= {"(//input[@type='number'])[{dynamic1}]",XPATH,"txt_EnterItemQuantity"};
	public static final String[] lbl_Product={"//div[@class='mm-c-product-list__details ']//h4[contains(text(),'{dynamic1}')]",XPATH,"lbl_Product"};

	//public static final String[] lbl_ItemName={"(//*[contains(@class,'mm-c-product-minlist__item')]//*[contains(text(),'{dynamic1}')]/ancestor::*)[12]/*[contains(@class,'mm-c-product-list__check-icon')]",XPATH,"lbl_ItemName"};


	public static final String[] lbl_ItemName={"//*[contains(@class,'mm-c-product-minlist__item')]//*[contains(text(),'{dynamic1}')]/parent::div/parent::div//label",XPATH,"lbl_ItemName"};   // periya - updated for android with app 13.3
	
	
	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqLocatorName){
		Field childObjects;
		try {
				if(AndroidLocationsPage.class.getDeclaredField(reqLocatorName)!=null){
					childObjects = AndroidLocationsPage.class.getDeclaredField(reqLocatorName);
				
				String[] childObject;
				String[] objForChild={"","",""};
				if(childObjects.getType().isInstance(objForChild)){
					childObject=(String[]) (AndroidLocationsPage.class.getDeclaredField(reqLocatorName).get(null));
					return childObject;
				}
			}else{
				FrameworkReporter.info("Child object is not present for locator"+ reqLocatorName+ "in AndroidLocationsPage" );
				return null;
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		} 
			return null;

 }
}
