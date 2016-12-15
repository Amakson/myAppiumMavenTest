package com.uom.pages.common;

import java.lang.reflect.Field;

import org.openqa.selenium.interactions.Actions;

import com.framework.frameworkFunctions.LibraryPage;
import com.framework.reporting.FrameworkReporter;
import com.uom.pageFactory.PageFactory;

public class IVRPage extends LibraryPage{
	
	static Field[] declaredMemberVariables;
	static{
		declaredMemberVariables =IVRPage.class.getDeclaredFields();
				
		}

	
	
	
	/**
	 * @Function verifyIVRSummaryPage
	 * @Description To verify IVR Summary page
	 * @author Gayathri_Anand
	 * @date 
	 */
	public void verifyIVRSummaryPage(){
		switchToWebContext();
		/* include the required element in the validation
	    if(isElementPresent()){
	    	FrameworkReporter.pass("IVR Summary page is displayed");
	    }
	    else{
	    	FrameworkReporter.fail("IVR Summary page is not displayed");
	    }
	    */
	}
	
	/**
	 * @Function verifyCategoriesInIVRPage
	 * @Description To verify categories displayed in IVR summary page
	 * @author Gayathri_Anand
	 * @date 
	 */
	public void verifyCategoriesInIVRPage(String categoryType, String...customCategoryNames){
		switchToWebContext();
		String[] categoryNames=null;
		boolean isTrue=true;
		/* include required element in the validation
		int categoryCount=getElementCount(locator_for_categories);
		*/
		switch (categoryType){
		case "default":
			categoryNames=new String[2];
			categoryNames[0]="Food";
			categoryNames[1]="Non-Food";
			break;
		case "suggested":
			categoryNames=new String[12];
			categoryNames[0]="Dairy";
			categoryNames[1]="Meat";
			categoryNames[2]="Poultry";
			categoryNames[3]="Seafood";
			categoryNames[4]="Produce";
			categoryNames[5]="Canned and Dry";
			categoryNames[6]="Dispenser Beverage";
			categoryNames[7]="Frozen";
			categoryNames[8]="Chemical & Janatorial";
			categoryNames[9]="Paper & Disposable";
			categoryNames[10]="Supplies & Equipment";
			categoryNames[11]="Healthcare & Hospitality";
			break;
		case "custom":
			categoryNames=customCategoryNames;
			break;
		default:
			break;
		}
		/* include required element in the validation
			for (int i=1;i<=categoryCount;i++) {
				switchToWebContext();
				boolean isCategoryFound=false;
				for (int j=0;j<categoryNames.length;j++){
					if(getElementText(locator_for_category).equals(categoryNames[j])){
						isCategoryFound=true;
						break;
					}						
				}
				if(!isCategoryFound){
					isTrue=false;
				}
				if(isElementPresent(locator_for_category_percentage)){
					FrameworkReporter.pass("Percentage is displayed for category "+getElementText(locator_for_category));
				}
				else{
				FrameworkReporter.fail("Percentage is not displayed for category "+getElementText(locator_for_category));
				}
				if(isElementPresent(locator_for_category_dollar)){
					FrameworkReporter.pass("Dollar value is displayed for category "+getElementText(locator_for_category));
				}
				else{
				FrameworkReporter.fail("Dollar value is not displayed for category "+getElementText(locator_for_category));
				}
			}
			if(isTrue){
				FrameworkReporter.pass("Categories are displayed as expected in IVR summary");
			}
			else{
				FrameworkReporter.fail("Categories are displayed as expected in IVR summary");
			}
				*/
	}
	
	/**
	 * @function tapOnIVRListView
	 * @author Gayathri Anand
	 * @description Tap on IVR list view
	 * @date
	 */

	public void tapOnIVRListView(){
		switchToWebContext();
		/* include required element in the validation
		clickElement(locator_for_list_view);
		FrameworkReporter.info("Tapped on IVR list view icon");
		*/
	}
	
	/**
	 * @Function verifyIVRListViewCategories
	 * @Description To verify IVR list view
	 * @author Gayathri_Anand
	 * @date 
	 */
	public void verifyIVRListViewCategories(String categoryType, String...customCategoryNames){
		switchToWebContext();
		String[] categoryNames=null;
		boolean isTrue=true;
		/* include required element in the validation
		int categoryCount=getElementCount(locator_for_categories);
		*/
		switch (categoryType){
		case "default":
			categoryNames=new String[2];
			categoryNames[0]="Food";
			categoryNames[1]="Non-Food";
			break;
		case "suggested":
			categoryNames=new String[12];
			categoryNames[0]="Dairy";
			categoryNames[1]="Meat";
			categoryNames[2]="Poultry";
			categoryNames[3]="Seafood";
			categoryNames[4]="Produce";
			categoryNames[5]="Canned and Dry";
			categoryNames[6]="Dispenser Beverage";
			categoryNames[7]="Frozen";
			categoryNames[8]="Chemical & Janatorial";
			categoryNames[9]="Paper & Disposable";
			categoryNames[10]="Supplies & Equipment";
			categoryNames[11]="Healthcare & Hospitality";
			break;
		case "custom":
			categoryNames=customCategoryNames;
			break;
		default:
			break;
		}
		/* include required element in the validation
			for (int i=1;i<=categoryCount;i++) {
				switchToWebContext();
				boolean isCategoryFound=false;
				for (int j=0;j<categoryNames.length;j++){
					if(getElementText(locator_for_category).equals(categoryNames[j])){
						isCategoryFound=true;
						break;
					}						
				}
				if(!isCategoryFound){
					isTrue=false;
				}
				if(isElementPresent(locator_for_category_percentage)){
					FrameworkReporter.pass("Percentage is displayed for category "+getElementText(locator_for_category));
				}
				else{
				FrameworkReporter.fail("Percentage is not displayed for category "+getElementText(locator_for_category));
				}
				if(isElementPresent(locator_for_category_dollar)){
					FrameworkReporter.pass("Dollar value is displayed for category "+getElementText(locator_for_category));
				}
				else{
				FrameworkReporter.fail("Dollar value is not displayed for category "+getElementText(locator_for_category));
				}
			}
			if(isTrue){
				FrameworkReporter.pass("Categories are displayed as expected in IVR list view");
			}
			else{
				FrameworkReporter.fail("Categories are displayed as expected in IVR list view");
			}
				*/
	}
}
