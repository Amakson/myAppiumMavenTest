package com.uom.pages.common;

import java.lang.reflect.Field;

import com.framework.configuration.ConfigFile;
import com.framework.frameworkFunctions.LibraryPage;
import com.framework.reporting.FrameworkReporter;
import com.uom.pages.androidPhone.AndroidFoodCostPage;
import com.uom.pages.iOSTablet.IOSTabletFoodCostPage;

public class FoodCostPage extends LibraryPage{
	static Field[] declaredMemberVariables;
	static{
		declaredMemberVariables = FoodCostPage.class.getDeclaredFields();
	}
	
	public static final String[] lbl_FoodCostCalculatorEmptyPage={"//h1[text()='YOUR FOOD COST CALCULATOR ']/span[text()='IS EMPTY']",XPATH,"lbl_FoodCostCalculatorEmptyPage"};
	public static final String[] lbl_FoodCostCalculatorEmptyMessage={"//*[@class='mm-c-help__content']",XPATH,"lbl_FoodCostCalculatorEmptyMessage"};
	public static final String[] lbl_FoodCostPage={"//h3[text()='Food Costs']",XPATH,"lbl_FoodCostPage"};
	public static final String[] lbl_InventoryPeriod={"period",ID,"lbl_InventoryPeriod"};
	public static final String[] lbl_BeginningInventory={"//div[contains(text(),'Beginning Inventory')]/parent::*/div[3]",XPATH,"lbl_BeginningInventory"};
	public static final String[] lbl_EndingInventory={"//div[contains(text(),'Ending Inventory')]/parent::*/div[3]/span",XPATH,"lbl_EndingInventory"};
	public static final String[] lbl_COGS={"//div[contains(text(),'Cost of Goods Sold')]/parent::*/div[3]",XPATH,"lbl_COGS"};
	public static final String[] lbl_TotalPurchases={"//div[contains(text(),'Total Purchases')]/parent::*/div[3]/span",XPATH,"lbl_TotalPurchases"};
	public static final String[] lnk_ConsolidatedView={"summaryView",ID,"lnk_ConsolidatedView"};
	public static final String[] lnk_CategorizedView={"itemizedView",ID,"lnk_CategorizedView"};
	public static final String[] lbl_Categories={"//*[@id='food-costs-grid']//div[contains(@class,'food-cost__name')]",XPATH,"lbl_Categories"};
	public static final String[] lbl_CategoryPurchase={"//div[contains(@class,'food-cost__name') and text()='{dynamic1}']/parent::*//div[contains(@class,'food-cost__subtotal')]/span",XPATH,"lbl_CategoryPurchase"};
	public static final String[] txt_TotalFoodSales={"//div[contains(text(),'Total Food Sales')]/parent::*//input",XPATH,"txt_TotalFoodSales"};
	public static final String[] lbl_FoodCost={"//div[contains(@class,'mm-c-food-cost__percentage_number row')]/div",XPATH,"lbl_FoodCost"};
	public static final String[] lnk_LeftArrow={"//i[@class='mm-o-icon icon-arrow-left']",XPATH,"lnk_LeftArrow"};
	
	/**
	 * @function verifyFoodCostCalculatorEmptyPage
	 * @author Gayathri Anand
	 * @description Verify Food Cost Calculator Empty page is displayed
	 * @date 16-10-2016
	 */

	public void verifyFoodCostCalculatorEmptyPage(){
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_FoodCostCalculatorEmptyPage, 5)){
			FrameworkReporter.pass("Food Cost Calculator Empty page is displayed");
		}else{
			FrameworkReporter.fail("Food Cost Calculator Empty page is not displayed");
		}
	}
	/**
	 * @function verifyFoodCostCalculatorEmptyMessage
	 * @author Gayathri Anand
	 * @description Verify Food Cost Calculator Empty message is displayed
	 * @date 16-10-2016
	 */

	public void verifyFoodCostCalculatorEmptyMessage(){
		switchToWebContext();
		String expectedMsg="Calculations for cost of goods sold is based on beginning and ending inventory. You will see food cost calculations once you've completed two inventory periods.";
		if(getElementText(lbl_FoodCostCalculatorEmptyMessage).equals(expectedMsg)){
			FrameworkReporter.pass("Food Cost Calculator Empty message is displayed as expected");
		}else{
			FrameworkReporter.fail("Food Cost Calculator Empty message is not displayed as expected");
		}
	}
	/**
	 * @Function swipeFoodCostEmptyScreen
	 * @Description Swipe on Food Cost Empty screen
	 * @author Gayathri_Anand
	 * @date 17-10-2016
	 */
	public void swipeFoodCostEmptyScreen(){
		swipeScreenInHorizontal(8, 2);
	}
	/**
	 * @function verifyFoodCostPage
	 * @author Gayathri Anand
	 * @description Verify Food Cost page is displayed
	 * @date 17-10-2016
	 */

	public void verifyFoodCostPage(){
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_FoodCostPage, 5)){
			FrameworkReporter.pass("Food Cost page is displayed");
		}else{
			FrameworkReporter.fail("Food Cost page is not displayed");
		}
	}
	/**
	 * @function verifyFoodCostDetails
	 * @author Gayathri Anand
	 * @description Verify Food Cost details
	 * @param period - inventory period number, withPurchase- boolean value for with or without purchase
	 * @date 17-10-2016
	 */

	public void verifyFoodCostDetails(int period,boolean withPurchase){
		switchToWebContext();
		String inventoryStartDate=retreiveStoredValue("BeginningDate_Period"+period).toString();
		String inventoryEndDate=retreiveStoredValue("EndingDate_Period"+period).toString();
		String beginningInventory=retreiveStoredValue("BeginningInventory_Period"+period).toString();
		String endingInventory=retreiveStoredValue("EndingInventory_Period"+period).toString();
		String purchases=retreiveStoredValue("PurchaseValue"+period).toString();
		//verifying inventory period date is displayed
		if(getElementText(lbl_InventoryPeriod).equals(inventoryStartDate+" - "+inventoryEndDate)){
			FrameworkReporter.pass("Inventory period is displayed as expected");
		}
		else{
			FrameworkReporter.fail("Inventory period is not displayed as expected");
		}
		//verifying beginning inventory
		if(getElementText(lbl_BeginningInventory).replace("$", "").equals(beginningInventory)){
			FrameworkReporter.pass("Beginning inventory is displayed as expected");
		}
		else{
			FrameworkReporter.fail("Beginning inventory is not displayed as expected");
		}
		//verifying ending inventory
		if(getElementText(lbl_EndingInventory).replace("$", "").equals(endingInventory)){
			FrameworkReporter.pass("Ending inventory is displayed as expected");
		}
		else{
			FrameworkReporter.fail("Ending inventory is not displayed as expected");
		}
		//verify purchase
		if(withPurchase){
			if(getElementText(lbl_TotalPurchases).replace("$", "").equals(purchases)){
				FrameworkReporter.pass("Total Purchases is displayed as expected");
			}
			else{
				FrameworkReporter.fail("Total Purchases is not displayed as expected");
			}
		}
	}
	/**
	 * @function verifyCOGS
	 * @author Gayathri Anand
	 * @description Verify Cost of Goods Sold
	 * @date 17-10-2016
	 */

	public void verifyCOGS(int period){
		double beginningInventory=Double.parseDouble(retreiveStoredValue("BeginningInventory_Period"+period).toString());
		double foodPurchases=0;
		double endingInventory=Double.parseDouble(retreiveStoredValue("EndingInventory_Period"+period).toString());
		double expectedCOGS=0;
		if(!retreiveStoredValue("PurchaseValue"+period).equals("null")){
			foodPurchases=Double.parseDouble(retreiveStoredValue("PurchaseValue"+period).toString());
		}
		expectedCOGS = beginningInventory+foodPurchases-endingInventory;
		if(getElementText(lbl_COGS).replace("$", "").equals(Double.toString(expectedCOGS))){
			FrameworkReporter.pass("COGS is displayed as expected");
		}
		else{
			FrameworkReporter.fail("COGS is not displayed as expected");
		}
	}
	
	/**
	 * @function verifyFoodCostViews
	 * @author Gayathri Anand
	 * @description Verify 2 views are available for food cost
	 * @date 18-10-2016
	 */

	public void verifyFoodCostViews(){
		if(isElementPresent(lnk_ConsolidatedView)&&isElementPresent(lnk_CategorizedView)){
			FrameworkReporter.pass("Both Consolidated View and Categorized view are available for food cost");
		}
		else{
			FrameworkReporter.fail("Consolidated View and Categorized view are not available for food cost");
		}
	}
	
	/**
	 * @function verifyConsolidatedView
	 * @author Gayathri Anand
	 * @description Verify in consolidated view, the Purchase would only contain one line item "Total Purchase"
	 * @date 18-10-2016
	 */

	public void verifyConsolidatedView(){
		if(getElementAttributeValue(lnk_ConsolidatedView, "class").equals("active")){
			FrameworkReporter.pass("Consolidated view is active");
		}
		else{
			FrameworkReporter.fail("Consolidated View is not active");
		}
		if(isElementPresent(lbl_TotalPurchases)&&!isElementPresent(lbl_Categories)){
			FrameworkReporter.pass("Only Total Purchases is displayed as the line item in consolidated view");
		}
		else{
			FrameworkReporter.fail("Total purchases is not displayed in consolidated view");
		}
	}
	

	/**
	 * @function verifyCategorizedView
	 * @author Gayathri Anand
	 * @description Verify in categorized view, the Purchase would be expanded all the categories would be displayed with appropriate purchase split up
	 * @date 18-10-2016
	 */

	public void verifyCategorizedView(int period){
		String foodCategories=retreiveStoredValue("FoodCategories").toString();
		String categoryName, categoryPurchase="";
		if(getElementAttributeValue(lnk_CategorizedView, "class").equals("active")){
			FrameworkReporter.pass("Categorized view is active");
		}
		else{
			FrameworkReporter.fail("Categorized View is not active");
		}
		int categoriesCount=getElementCount(lbl_Categories);
		if(categoriesCount==foodCategories.split("/").length){
			FrameworkReporter.pass("All food categoires are displayed in categorized view");
		}
		else{
			FrameworkReporter.fail("All food categoires are not displayed in categorized view");
		}
		for(int i=0;i<foodCategories.split("/").length;i++){
			categoryName=foodCategories.split("/")[i];
			if(!retreiveStoredValue(categoryName+"_Purchase"+period).toString().equals("null")){
				categoryPurchase=retreiveStoredValue(categoryName+"_Purchase"+period).toString();
			}
			else{
				categoryPurchase="0.00";
			}
			if(getElementText(replaceDynamicText(lbl_CategoryPurchase, categoryName)).replace("$", "").equals(categoryPurchase)){
				FrameworkReporter.pass(categoryName+" is displayed with expected purchase value "+categoryPurchase);
			}
			else{
				FrameworkReporter.fail(categoryName+" is not displayed with expected purchase value");
			}
		}
	}
	/**
	 * @function tapOnCategorizedView
	 * @author Gayathri Anand
	 * @description Tap on categorized view
	 * @date 18-10-2016
	 */

	public void tapOnCategorizedView(){
		clickElement(lnk_CategorizedView);
		FrameworkReporter.info("Tapped on Categorized view");
	}
	/**
	 * @function tapOnConsolidatedView
	 * @author Gayathri Anand
	 * @description Tap on consolidated view
	 * @date 18-10-2016
	 */

	public void tapOnConsolidatedView(){
		clickElement(lnk_ConsolidatedView);
		FrameworkReporter.info("Tapped on Consolidated view");
	}
	/**
	 * @function enterFoodSales
	 * @author Gayathri Anand
	 * @description Enter food sales amount
	 * @date 18-10-2016
	 */

	public void enterFoodSales(String strFoodSales){
		moveToElement(txt_TotalFoodSales);
		clear(txt_TotalFoodSales);
		sendText(txt_TotalFoodSales, strFoodSales);
		FrameworkReporter.info("Entered food sales amount");
	}
	/**
	 * @function verifyFoodCostCalculation
	 * @author Gayathri Anand
	 * @description Verify Food Cost Calculation
	 * @date 18-10-2016
	 */

	public void verifyFoodCostCalculation(String strFoodSales){
		double cogs=Double.parseDouble(getElementText(lbl_COGS).replace("$", ""));
		double foodSales=Double.parseDouble(strFoodSales.replace("$", ""));
		long expectedFoodCost=Math.round(cogs/foodSales*100);
		moveToElement(lbl_FoodCost);
		if(getElementText(lbl_FoodCost).equals(expectedFoodCost+"%")){
			FrameworkReporter.pass("Food Cost% is displayed as expected");
		}
		else{
			FrameworkReporter.fail("Food Cost% is not displayed as expected");
		}
	}
	
	/**
	 * @function tapOnLeftArrow
	 * @author Gayathri Anand
	 * @description Tap on left arrow
	 * @date 20-10-2016
	 */

	public void tapOnLeftArrow(){
		clickElement(lnk_LeftArrow);
		FrameworkReporter.info("Tapped on left arrow to view previous period food cost");
	}
	
	/**
	 * @function verifyTotalFoodSalesAmount
	 * @author Periysamy Nainar
	 * @description Verify total food sales amount is displayed with/without decimal values
	 * @param strFoodSales - expected fc amount 
	 * @date 23-10-2016
	 */

	public void verifyTotalFoodSalesAmount(String strFoodSales){
		consolePrint(getElementAttributeValue(txt_TotalFoodSales,"placeholder"));
		consolePrint(strFoodSales);
		if(getElementAttributeValue(txt_TotalFoodSales,"placeholder").equalsIgnoreCase(strFoodSales)){
			FrameworkReporter.pass("Food cost amount is displayed in food costs page as expected with the value :" + strFoodSales);
		}
		else{
			FrameworkReporter.fail("Food cost amount is not displayed in food costs page as expected with the value :" + strFoodSales);
		}
	}
	
	/**
	 * @function verifyFoodSalesAmountForHotShedulesCustomer
	 * @author Gayathri Anand
	 * @description Verify food sales amount
	 * @date 18-10-2016
	 */

	public void verifyFoodSalesAmountForHotShedulesCustomer(String strFoodSales){
		if(!isElementEnabled(txt_TotalFoodSales)){
			FrameworkReporter.pass("Food sales field is disabled");
		}
		else{
			FrameworkReporter.fail("Food sales field is not disabled");
		}
		if(getElementAttributeValue(txt_TotalFoodSales,"placeholder").equals(strFoodSales)){
			FrameworkReporter.pass("Food sales is dispalyed as expected");
		}
		else{
			FrameworkReporter.fail("Food sales is not dispalyed as expected");
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
					break;
				case "ipad":	
					childClassObject = new IOSTabletFoodCostPage().findChildObject(parentObject[2]);	
					break;
				case "android":
					childClassObject = new AndroidFoodCostPage().findChildObject(parentObject[2]);
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
