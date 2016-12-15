package com.uom.pages.androidPhone;

import java.lang.reflect.Field;

import com.uom.pages.common.GenericPage;
import com.uom.pages.common.SetupInventoryPage;

public class AndroidSetupInventoryPage extends SetupInventoryPage{
	

	public static final String[] btn_LocationWithPosition={"((//div[@class='mm-c-slider__selections'])[1]//button)[{dynamic1}]",XPATH,"btn_LocationWithPosition"};  // web ele for android
	public static final String[] btn_AssignProductsLocationName= {"//button[text()='{dynamic1}']",XPATH,"btn_AssignProductsLocationName"};
	public static final String[] lbl_ItemCount={"//div[@class='mm-c-card']",XPATH,"lbl_ItemCount"};
	public static final String[] lnk_LocationChevRight={"//h4[contains(text(),'LOCATIONS')]//i[@class='mm-o-icon icon-chevron-right']",XPATH,"lnk_LocationChevRight"};
	public static final String[] lnk_CategoryChevRight={"//h4[contains(text(),'EXPENSE CATEGORIES')]//i[@class='mm-o-icon icon-chevron-right']",XPATH,"lnk_CategoryChevRight"};	
	public static final String[] lbl_ProductDecription={"//div[@class='swiper-slide swiper-slide-active']//div[@class='mm-c-card__details-wrapper']//h4",XPATH,"lbl_ProductDecription"};
	public static final String[] btn_AssignProductsCategoryName= {"//*[@class='expanded-slider']//*[text()='{dynamic1}']",XPATH,"btn_AssignProductsCategoryName"};
	public static final String[] lnk_LocationChevDown={"//h4[contains(text(),'LOCATIONS')]//i[@class='mm-o-icon icon-chevron-down']",XPATH,"lnk_LocationChevDown"};
	public static final String[] lnk_CategoryChevDown={"//h4[contains(text(),'EXPENSE CATEGORIES')]//i[@class='mm-o-icon icon-chevron-down']",XPATH,"lnk_CategoryChevDown"};	
	public static final String[] lbl_ProductBrand={"(//div[@class='swiper-slide swiper-slide-active']//div[@class='mm-c-card']//span[@class='mm-c-card__details'])[2]",XPATH,"lbl_ProductBrand"};
	public static final String[] lbl_ProductPack={"(//div[@class='swiper-slide swiper-slide-active']//div[@class='mm-c-card']//span[@class='mm-c-card__details'])[3]",XPATH,"lbl_ProductPack"};
	public static final String[] lbl_ProductId={"(//div[@class='swiper-slide swiper-slide-active']//div[@class='mm-c-card']//span[@class='mm-c-card__details'])[1]",XPATH,"lbl_ProductId"};
	public static final String[] lbl_ProductCategory={"(//div[@class='mm-c-card__expenses'])[{dynamic1}]",XPATH,"lbl_ProductCategory"};
	public static final String[] lbl_ProductLocation={"(//div[@class='mm-c-card__locations'])[{dynamic1}]",XPATH,"lbl_ProductLocation"};
	
	/* Functions on the Page are defined below */
	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] findChildObject(String reqLocatorName){	
		Field childObjects;
		try {
			childObjects = AndroidSetupInventoryPage.class.getDeclaredField(reqLocatorName);
		
		String[] childObject;
		String[] objForChild={"","",""};
		if(childObjects.getType().isInstance(objForChild)){
			childObject=(String[]) (AndroidSetupInventoryPage.class.getDeclaredField(reqLocatorName).get(null));
			return childObject;
		}
 
		}catch (Exception e) {
			e.printStackTrace();
		}	
	return null;

}
}
