package com.uom.pages.common;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.framework.configuration.ConfigFile;
import com.framework.frameworkFunctions.LibraryPage;
import com.framework.reporting.FrameworkReporter;
import com.uom.commonFunctions.FunctionLibrary;
import com.uom.pages.androidPhone.AndroidExpenseCategoriesPage;
import com.uom.pages.androidPhone.AndroidNonSyscoPrepItemPage;
import com.uom.pages.iOSPhone.IOSExpenseCategoriesPage;
import com.uom.pages.iOSPhone.IOSNonSyscoPrepItemPage;
import com.uom.pages.iOSTablet.IOSTabletExpenseCategoriesPage;
import com.uom.pages.iOSTablet.IOSTabletNonSyscoPrepItemPage;

public class ExpenseCategoriesPage extends LibraryPage{
	
	static Field[] declaredMemberVariables;
	static{
		declaredMemberVariables = ExpenseCategoriesPage.class.getDeclaredFields();
	}
	
	//Expense Categories page
	public static final String[] lst_ExpenseCategories={"//*[@id='list-item']//*[text()='{dynamic1}']",XPATH,"lst_ExpenseCategories"};
	public static final String[] lbl_ExpenseCategoriesPage={"//*[contains(text(),'Expense Categories')]",XPATH,"lbl_ExpenseCategoriesPage"};
	public static final String[] lst_ExpenseCategoriesCount={"//*[@id='list-item']//span",XPATH,"lst_ExpenseCategoriesCount"};
	public static final String[] lst_ExpenseCategory={"(//*[@id='list-item']//span)[1]",XPATH,"lst_ExpenseCategoriesCount"};
			
	//Add Expense Category Page
	public static final String[] txt_ExpenseName={"name",ID,"txt_ExpenseName"};
	public static final String[] btn_ExpenseType={"//input[@value='{dynamic1}']",XPATH,"btn_ExpenseType"};
	public static final String[] lbl_ExpenseName={"//label[contains(text(),'EXPENSE NAME')]",XPATH,"lbl_ExpenseName"};
	public static final String[] lbl_ExpenseType={"foodType",XPATH,"EXPENSE TYPE"};
	public static final String[] lbl_AddExpenseCategoryPage={"//*[contains(text(),'Add Expense Category')]",XPATH,"lbl_AddExpenseCategoryPage"};
	
	//Expense Category Details Page
	public static final String[] lbl_CategoryDetailsName={"name",ID,"lbl_CategoryDetailsName"};
	public static final String[] lbl_CategoryDetailsType={"foodType",ID,"lbl_CategoryDetailsType"};
	public static final String[] btn_DeleteExpenseCategory={"//button[contains(text(),'Delete Expense Category')]",XPATH,"btn_DeleteExpenseCategory"};
	public static final String[] lbl_ExpenseCategoryDetailsPage={"//*[contains(text(),'Expense Category Details')]",XPATH,"lbl_ExpenseCategoryDetailsPage"};
	
	//Edit Expense Category Page
	public static final String[] btn_ExpenseTypeDisabled={"//input[@type='radio' and @name='foodType']",XPATH,"btn_ExpenseTypeDisabled"};
	public static final String[] lbl_DeleteCategoryConfirmation={"//*[@id='modal-body' and contains(text(),'Are you sure you want to delete {dynamic1} from your list?')]",XPATH,"lbl_DeleteCategoryConfirmation"};
	
	public static final String[] lbl_SetUpExpenseCategoriesWF={"//*[@class='mm-c-help mm-c-help__step1 mm-c-help__expenses']",XPATH,"lbl_SetUpExpenseCategoriesWF"};
	
	//Native element
	public static final String[] btn_ExpenseTypeNative={"//*[@label='{dynamic1}']",XPATH,"btn_ExpenseTypeNative"};
	
	
	public static final String[] lbl_Expense={"//div[@class='mm-u-list__item']",XPATH,"lbl_Suppliers"};
	
	
	
	/* Functions on the Page are defined below */
	
	/**
	 * @Function tapCategoryFromList
	 * @Description To select a category from the categories list
	 * @author Gayathri_Anand
	 * @date 22-09-2016
	 * @param categoryName - Expense category name
	 */
	public void tapCategoryFromList(String categoryName){
		    switchToWebContext();
			clickElement(replaceDynamicText(lst_ExpenseCategories,categoryName));
			FrameworkReporter.info("Tapped on category "+categoryName);
			consolePrint("Tapped on category "+categoryName);
		
	}
	
	/**
	 * @Function enterCategoryDetails
	 * @Description To enter category details
	 * @author Gayathri_Anand
	 * @date 22-09-2016
	 * @param expenseName -Expense category name, expenseType - Expense category type (Food or Non-Food)
	 */
	public void enterCategoryDetails(String expenseName,String expenseType){
		switchToWebContext();
		if(!expenseName.isEmpty()){
			sendText(txt_ExpenseName, expenseName);
			FrameworkReporter.info("Entered expense name");
		}
		if(!expenseType.isEmpty()){
			switch (expenseType){
			case "Food":
				expenseType="FOOD";
				break;
			case "Non-Food":
				expenseType="NON-FOOD";
				break;
			}
			switchToNativeContext();
			clickElement(replaceDynamicText(getObject(btn_ExpenseTypeNative),expenseType));
			FrameworkReporter.info("Entered expense type");
		}
		
	}
	
	/**
	 * @Function verifyCategoryDetails
	 * @Description To verify category details
	 * @author Gayathri_Anand
	 * @date 22-09-2016
	 * @param expenseName -Expense category name, expenseType - Expense category type (Food or Non-Food)
	 */
	public void verifyCategoryDetails(String expenseName, String expenseType){
		switchToWebContext();
		if(!expenseName.isEmpty()){
			if(getElementAttributeValue(lbl_CategoryDetailsName, "value").equals(expenseName)){
				FrameworkReporter.pass("Expense name is displayed as expected");
				consolePrint("PASSED: Expense name is displayed as expected");
			}
			else{
				FrameworkReporter.fail("Expense name is not displayed as expected value: "+expenseName+", displayed as: "+getElementAttributeValue(lbl_CategoryDetailsName, "value"));
				consolePrint("FAILED: Expense name is not displayed as expected value: "+expenseName+", displayed as: "+getElementAttributeValue(lbl_CategoryDetailsName, "value"));
			}
		}
		if(!expenseType.isEmpty()){
			if(getElementAttributeValue(lbl_CategoryDetailsType, "value").equals(expenseType)){
				FrameworkReporter.pass("Expense type is displayed as expected");
				consolePrint("PASSED: Expense type is displayed as expected");
			}
			else{
				FrameworkReporter.fail("Expense type is not displayed as expected value: "+expenseType+", displayed as: "+getElementAttributeValue(lbl_CategoryDetailsType, "value"));
				consolePrint("FAILED: Expense type is not displayed as expected value: "+expenseType+", displayed as: "+getElementAttributeValue(lbl_CategoryDetailsType, "value"));
			}
		}
		
	}
	/**
	 * @Function tapDeleteExpenseCategory
	 * @author Gayathri_Anand
	 * @description	Tap on Delete Expense Category button
	 * @date 23-09-2016
	 */
	public void tapDeleteExpenseCategory(){
		switchToWebContext();
		clickElement(btn_DeleteExpenseCategory);
		FrameworkReporter.info("Tapped on Delete Expense Category");
		
	}
	
	/***
	 * @Function verifyExpenseCategoriesPage
	 * @Description To verify whether expense categories page is displayed or not 
	 * @author Gayathri_Anand
	 * @date 23-09-2016
	 */
	public void verifyExpenseCategoriesPage(){
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_ExpenseCategoriesPage,10)){
			FrameworkReporter.pass("Expense Categories page is displayed");
			consolePrint("PASSED: Expense Categories page is displayed");
		}
		else{
			FrameworkReporter.fail("Expense Categories page is not displayed");
			consolePrint("FAILED: Expense Categories page is not displayed");
		}
		
	}
	
	/**
	 * @Function verifyExpenseCategoryDetailsPage
	 * @Description To verify whether expense category details page is displayed or not 
	 * @author Gayathri_Anand
	 * @date 23-09-2016
	 */
	public void verifyExpenseCategoryDetailsPage(){
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_ExpenseCategoryDetailsPage,10)){
			FrameworkReporter.pass("Expense Category Details page is displayed");
			consolePrint("PASSED: Expense Category Details page is displayed");
		}
		else{
			FrameworkReporter.fail("Expense Category Details page is not displayed");
			consolePrint("FAILED: Expense Category Details page is not displayed");
		}
		
	}
	

	/**
	 * @Function verifyAddExpenseCategoryPage
	 * @Description To verify whether Add Expense Category page is displayed or not 
	 * @author Gayathri_Anand
	 * @date 24-09-2016
	 */
	public void verifyAddExpenseCategoryPage(){
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_AddExpenseCategoryPage,10)){
			FrameworkReporter.pass("Add Expense Category page is displayed");
		}
		else{
			FrameworkReporter.fail("Expense Category Details page is not displayed");
		}
		
	}
	
	/**
	 * @Function verifyCategoryInCategoryList
	 * @Description To verify whether category present the categories list
	 * @author Gayathri_Anand
	 * @param strCategoryName - Category name, isExpected - true or false whether category is expected or not
	 * @date 24-09-2016
	 */
	public void verifyCategoryInCategoryList(String strCategoryName,boolean isExpected){
		switchToWebContext();
		if(isExpected){
			moveToElement(replaceDynamicText(lst_ExpenseCategories,strCategoryName));
			if(isElementPresent(replaceDynamicText(lst_ExpenseCategories,strCategoryName))){
				FrameworkReporter.pass("Category '"+strCategoryName+"' is displayed in the categories list");
			}
			else{
				FrameworkReporter.fail("Category '"+strCategoryName+"' is not displayed in the categories list");
			}
		}
		else{
			if(!isElementPresent(replaceDynamicText(lst_ExpenseCategories,strCategoryName))){
				FrameworkReporter.pass("Category '"+strCategoryName+"' is not displayed in the categories list");
			}
			else{
				FrameworkReporter.fail("Category '"+strCategoryName+"' is displayed in the categories list");
			}
		}
		//swipeScreenInVertical(2, 8);
	}
	/**
	 * @Function verifyCategoriesList
	 * @Description To verify the list of expense categories
	 * @author Gayathri_Anand
	 * @date 24-09-2016
	 */
	public void verifyCategoriesList(String expenseListType, String... customCategoryNames){
		switchToWebContext();
		String[] categoryNames=null;
		switch (expenseListType){
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
		int categoriesCount=getElementCount(lst_ExpenseCategoriesCount);
		if(categoriesCount==categoryNames.length){
			FrameworkReporter.pass("The number of categories displayed is "+categoryNames.length+" as expected");
			List<WebElement> elements=getDriver().findElements(getLocatorsType(lst_ExpenseCategoriesCount));
			boolean categoryFound=false;
			for (int i=0;i<categoryNames.length;i++){
				for (WebElement element:elements){
					if(element.getText().equals(categoryNames[i])){
						categoryFound=true;
						break;
					}
				}
				if(categoryFound){
					FrameworkReporter.pass("Category "+categoryNames[i]+" is displayed");
				}
				else{
					FrameworkReporter.fail("Category "+categoryNames[i]+" is not displayed");
				}
			}
		}
		else{
			FrameworkReporter.fail("The number of categories displayed is not "+categoryNames.length+" as expected. Actual value :"+categoriesCount);
		}
	}
	
	/**
	 * @Function deleteExpenseCategories
	 * @Description Delete expense categories by passing the number of categories to be deleted
	 * @author Gayathri_Anand
	 * @param count - Number of categories to be deleted
	 * @date 24-09-2016
	 */
	public void deleteExpenseCategories(String count){
		switchToWebContext();
		int categoriesCount=0;
		String categoryName="";
		if(count.equals("all")){
			categoriesCount=getElementCount(lst_ExpenseCategoriesCount);
			while(isElementPresentAfterWait(lst_ExpenseCategory, 10)){
				categoryName=getElementText(lst_ExpenseCategory);
				clickElement(lst_ExpenseCategory);
				clickElement(btn_DeleteExpenseCategory);
				verifyDeleteExpenseCategoryConfirmationPopUp(categoryName);
				clickElement(GenericPage.btn_DeleteYes);
			}
			FrameworkReporter.info("Deleted all "+categoriesCount+" categories");
		}
		else{
			categoriesCount=Integer.parseInt(count);
			for(int i=1;i<=categoriesCount;i++){
				categoryName=getElementText(lst_ExpenseCategory);
				clickElement(lst_ExpenseCategory);
				clickElement(btn_DeleteExpenseCategory);
				verifyDeleteExpenseCategoryConfirmationPopUp(categoryName);
				clickElement(GenericPage.btn_DeleteYes);
			}
			FrameworkReporter.info("Deleted "+count+" categories");
		}
	}	
	
	/**
	 * @Function verifyExpenseTypeDisabled
	 * @Description Verify expense type is disabled in the edit page
	 * @author Gayathri_Anand
	 * @date 24-09-2016
	 */
	public void verifyExpenseTypeDisabled(){
		switchToWebContext();
		List<WebElement> elements=getDriver().findElements(getLocatorsType(btn_ExpenseTypeDisabled));
		for (WebElement element:elements){
			if(!element.isEnabled()){
				FrameworkReporter.pass("Expense type "+element.getAttribute("value")+" is disabled");
			}
			else{
				FrameworkReporter.fail("Expense type "+element.getAttribute("value")+" is not disabled");
			}
		}
	}
	/**
	 * @Function verifyDeleteExpenseCategoryConfirmationPopUp
	 * @Description Verify delete expense category confirmation message pop up
	 * @author Gayathri_Anand
	 * @date 03-10-2016
	 */
	public void verifyDeleteExpenseCategoryConfirmationPopUp(String categoryName){
		switchToWebContext();
		if(isElementPresent(replaceDynamicText(lbl_DeleteCategoryConfirmation, categoryName))){
			FrameworkReporter.pass("Confirmation message to delete category "+categoryName+" is displayed");
		}
		else{
			FrameworkReporter.fail("Confirmation message to delete category "+categoryName+" is not displayed");
		}
	}
	
	/**
	 * @Function verifySetupExpenseCategoriesOnboardingWorkFlow
	 * @Description Verify setup expenses on boarding work flow is displayed
	 * @author Gayathri_Anand
	 * @date 03-10-2016
	 */
	public void verifySetupExpenseCategoriesOnboardingWorkFlow(){
		switchToWebContext();
		if(isElementPresent(lbl_SetUpExpenseCategoriesWF)){
			FrameworkReporter.pass("Setup expenses onboarding work flow is displayed");
		}
		else{
			FrameworkReporter.fail("Setup expenses onboarding work flow is not displayed");
		}
		storeValue("SetupExpenseOnboarding", true);
	}
	/**
	 * @Function swipeToSetupExpenses
	 * @Description Swipe to setup expenses
	 * @author Gayathri_Anand
	 * @date 03-10-2016
	 */
	public void swipeToSetupExpenses(){
		//swipeScreenInHorizontal(8, 2);
		swipeScreenInHorizontal(8, 2);
	}
	
	
	
	/**
	 * @Function verifyNumberOfCategories
	 * @Description Verify number of categories in the list
	 * @author Parvathy
	 * @date 18-10-2016
	 */
	public void verifyNumberOfCategories(String strCount){
		switchToWebContext();		
				
		if(getElementCount(lbl_Expense) == Integer.parseInt(strCount)){			
				FrameworkReporter.pass("Number of expense categories are dispalyed correctly as expected. count: "+ strCount);
			}
			else{
				FrameworkReporter.fail("Number of expense categpried are not displayed correctly as expected. count: "+ strCount);
			}
		
	}	
	
	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/

	public String[] getObject(String[] parentObject)
	{
		
		String[] childClassObject =null;
		String brand =ConfigFile.getProperty("brand").toString().toLowerCase().trim();
		switch (brand) {
				case "iphone":				
					//childClassObject= new IOSExpenseCategoriesPage().findChildObject(parentObject[2]);	
					break;
				case "ipad":	
					childClassObject = new IOSTabletExpenseCategoriesPage().findChildObject(parentObject[2]);	
					break;
				case "android":
					childClassObject = new AndroidExpenseCategoriesPage().findChildObject(parentObject[2]);					
					break;
				case "android tablet":
					break;
					
				case "desktop":
					break;
				default:
					break;
				}
			
			if(null!=childClassObject){
				return childClassObject;}
				
	return parentObject;
	}
}
