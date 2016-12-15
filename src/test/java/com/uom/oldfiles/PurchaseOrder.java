package com.uom.oldfiles;

import java.lang.reflect.Method;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.DataRead.Excel;
import com.framework.Starter;
import com.framework.configuration.ConfigFile;

import com.framework.utils.UOMTestNGListener;

import com.framework.utils.RetryAnalyzer;
import com.uom.excelSheetObject.PurchaseOrderObject;
import com.uom.pageFactory.PageFactory;

@Listeners(value = UOMTestNGListener.class)
public class PurchaseOrder extends PageFactory {

	public static String[][] completeArray = null;	
   	Starter starter = new Starter();
   	
      
    @BeforeClass(alwaysRun=true)
	public void getData() throws Exception
	{		

		Excel newExcel =new Excel();		
		completeArray=newExcel.read("test-data/TestData.xls","PurchaseOrder");
	}
    @BeforeMethod(alwaysRun=true)
    public void initiate() throws Exception
    {
    	
    	startup();
    }
    @AfterMethod
   	public void clean()
   	{
       	cleanUp();
   	}

	 @DataProvider(name = "DP2",parallel =false)
	    public Object[][] getData(Method method) throws Exception{
		 	Excel newExcel =new Excel();	
		 	PurchaseOrderObject sheetObj = new PurchaseOrderObject();
	        System.out.println(method.getName());
	        String[][] MethodArray=newExcel.getMethodData(completeArray, method.getName());
	        Object[][] retObjArr= sheetObj.getTestData(MethodArray);
	        return(retObjArr);
	    }
	 
	 /******************************************************************************************
	  * Name : INV_PUR_001_Toggle_And_Verify_Puchase
	  * 
	  * Description : MM 7841,MM 7944 & MM 7943 also covered
	  * 
	  * Manual Test cases :INV_PUR_001 
	  * 
	  * Author : Sampada Dalai
	  * 
	  * Date : 10/13/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP2",groups={"Purchase"}, description = "Verify purchase present and past purchase details")
	 public void INV_PUR_001_Toggle_And_Verify_Puchase(PurchaseOrderObject data) throws Exception {	

		 //Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory with default location
		 component().setupInventorywithOGDefaultLocDefaultCat();
		 //create supplier
		 component().createSupplier( data.strSupplierName, "111111111", "test", "test", "test@test.com","test");
		//navigate to Setup inventory
		 home().tapPurchases();
		 //verify purchases page is displayed
		 purchase().verifyPurchasePage();
		 //Verify default month year(Current month year) is displayed
		 generic().validateDate(0, "MMMM YYYY");
		 //Toggle back
		 generic().toggleBack();
		//Verify past one month year wrt Current month year is displayed
		 generic().validateDate(-1, "MMMM YYYY");
		//Toggle back
		 generic().toggleBack();
		//Verify past 2nd month year wrt Current month year is displayed
		 generic().validateDate(-2, "MMMM YYYY");
		//Toggle back
		 generic().toggleBack();
		//Verify past 3rd month year wrt Current month year is displayed
		 generic().validateDate(-3, "MMMM YYYY");
		//Create new purchase
		 component().createNewPurchaseAndAddLineItem(data.strSupplierName,"INV_PUR_001_Toggle_And_Verify_Puchase",data.strInvoiceTotal,data.strLineItemType,data.strLineItemQuantity,1,1);
		//Click on first purchase line
		 purchase().clickOnPurchaseLine("1");
		 //Verify Purchase information
		 purchase().verifyValidatePurchaseInformation(data.strSupplierName,"","",false);
		//close app
		 generic().closeApp();
		 
		
	 }
	 
	 /******************************************************************************************
	  * Name : INV_PUR_003_And_Verify_Puchase
	  * 
	  * Description : Verify when a user is viewing purchase details there is at least one line item existing the user will see a total of all line items in the purchase at the bottom of the view - Non-Sysco Purchase
	  * 
	  * Manual Test cases :INV_PUR_003 
	  * 
	  * Author : Sampada Dalai
	  * 
	  * Date : 10/13/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP2",groups={"Purchase"}, description = "Verify when a user is viewing purchase details there is at least one line item existing the user will see a total of all line items in the purchase at the bottom of the view - Non-Sysco Purchase")
	 public void INV_PUR_003_And_Verify_Puchase(PurchaseOrderObject data) throws Exception {	

		 //Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory with default location
		 component().setupInventorywithOGDefaultLocDefaultCat();
		 //Create supplier
		 component().createSupplier(data.strSupplierName, "", "", "", "", "");
		//navigate to Setup inventory
		 home().tapPurchases();
		 //verify purchases page is displayed
		 purchase().verifyPurchasePage();
		 //Verify default month year(Current month year) is displayed
		 generic().validateDate(0, "MMMM YYYY");
		//Create new purchase
		 component().createNewPurchaseAndAddLineItem(data.strSupplierName,"INV_PUR_003_And_Verify_Puchase",data.strInvoiceTotal,data.strLineItemType,data.strLineItemQuantity,1,1);
		//Click on first purchase line
		 purchase().clickOnPurchaseLine("1");
		 //Verify Purchase information
		 purchase().verifyValidatePurchaseInformation(data.strSupplierName,"","",false);
		 //Get sum of every line item price and validate it with invoice total
		 purchase().addLineAmountAndValidate();
		//close app
		 generic().closeApp();
		 
		
	 }
	 
	 /******************************************************************************************
	  * Name : INV_PUR_004_006_VerifyLineItemTotal_And_Verify_Puchase
	  * 
	  * Description : Verify when a user is viewing purchase details if there are too many line items to display on the screen at one time the line item total is fixed at the bottom and items scroll under it - Non-Sysco Purchase
	  * 
	  * Manual Test cases :INV_PUR_004, INV_PUR_005,INV_PUR_006
	  * 
	  * Author : Sampada Dalai
	  * 
	  * Date : 10/13/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP2",groups={"Purchase"}, description = "Verify when a user is viewing purchase details if there are too many line items to display on the screen at one time the line item total is fixed at the bottom and items scroll under it - Non-Sysco Purchase")
	 public void INV_PUR_004_006_VerifyLineItemTotal_And_Verify_Puchase(PurchaseOrderObject data) throws Exception {	

		 //Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory with default location
		 component().setupInventorywithOGDefaultLocSugg12Cat();
		 //Create supplier
		 component().createSupplier(data.strSupplierName, "", "", "", "", "");
		//navigate to Setup inventory
		 home().tapPurchases();
		 //verify purchases page is displayed
		 purchase().verifyPurchasePage();
		 //Verify default month year(Current month year) is displayed
		 generic().validateDate(0, "MMMM YYYY");
		 //Create new purchase
		 component().createNewPurchaseAndAddLineItem(data.strSupplierName,"INV_PUR_004_005_VerifyLineItemTotal_And_Verify_Puchase",data.strInvoiceTotal,data.strLineItemType,data.strLineItemQuantity,7,1);
		//Click on first purchase line
		 purchase().clickOnPurchaseLine("1");
		 //Verify Purchase information
		 purchase().verifyValidatePurchaseInformation(data.strSupplierName,"","",false);
		 //Get sum of every line item price and validate it with invoice total
		 purchase().addLineAmountAndValidate();
		//Verify if swipe is possible for top to button line item
		 purchase().verifySwipeTopToButton();
		//close app
		 generic().closeApp();
		 
		
	 }
	 
	 
	 /******************************************************************************************
	  * Name : INV_PUR_011_021_Create_Puchas_UpdateSamePurchase
	  * 
	  * Description :"Given When Then a user is creating/editing a purchase the user wants to add a line item to the purchase the user will have a call-to-action to add the new line item - Creating a non-Sysco Purchase" 
	  * 
	  * Manual Test cases :INV_PUR_011,INV_PUR_021
	  * 
	  * Author : Sampada Dalai
	  * 
	  * Date : 10/13/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP2",groups={"Purchase"}, description = "Given When Then a user is creating/editing a purchase the user wants to add a line item to the purchase the user will have a call-to-action to add the new line item - Creating a non-Sysco Purchase")
	 public void INV_PUR_011_021_Create_Puchas_UpdateSamePurchase(PurchaseOrderObject data) throws Exception {	

		 
		//Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory with default location
		 component().setupInventorywithOGDefaultLocDefaultCat();
		 //Create supplier
		 component().createSupplier(data.strSupplierName, "", "", "", "", "");
		//navigate to Setup inventory
		 home().tapPurchases();
		 //verify purchases page is displayed
		 purchase().verifyPurchasePage();
		 //Verify default month year(Current month year) is displayed
		 generic().validateDate(0, "MMMM YYYY");
		 //Create new purchase
		 component().createNewPurchaseAndAddLineItem(data.strSupplierName,"INV_PUR_011_021_Create_Puchas_UpdateSamePurchase",data.strInvoiceTotal,data.strLineItemType,data.strLineItemQuantity,1,1);
		//Click on first purchase line
		 purchase().clickOnPurchaseLine("1");
		 //Verify Purchase information
		 purchase().verifyValidatePurchaseInformation(data.strSupplierName,"","",false);
		//Merging INV_PUR_021
		 //Tap on edit button
		 generic().tapEdit();
		 //Update the same purchase 
		//Click on add line item(+) and enter the details and verify 
		 purchase().clickAddLineItemAndAddItemDetails(data.strLineItemQuantity);
		 //Select item type from dropdown
		 generic().selectValueFromDropdown(data.strLineItemType,data.strLineItemType+" option is selected");
		//Tap on done button
		 generic().tapDone();
		 //Verify updated Purchase information
		 purchase().verifyValidatePurchaseInformation(data.strSupplierName,"","",false);
		//close app
		 generic().closeApp();
	 }
	 
	 
	 /******************************************************************************************
	  * Name : INV_PUR_012_Create_Puchase
	  * 
	  * Description :"Given When Then there are too many line items to be viewed on the screen at once a new line item action is selected the new empty line is added to the bottom of the view, extra line items scroll up, under the purchase header so the user can see the new line item - Creating a non-Sysco Purchase"
	  * 
	  * Manual Test cases :INV_PUR_012,INV_PUR_022,INV_PUR_023
	  * 
	  * Author : Sampada Dalai
	  * 
	  * Date : 10/13/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP2",groups={"Purchase"}, description = "Given When Then there are too many line items to be viewed on the screen at once a new line item action is selected the new empty line is added to the bottom of the view, extra line items scroll up, under the purchase header so the user can see the new line item - Creating a non-Sysco Purchase")
	 public void INV_PUR_012_022_023_Create_Puchase_UpdatePurchase(PurchaseOrderObject data) throws Exception {	

		 
		//Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory with default location
		 component().setupInventorywithOGDefaultLocDefaultCat();
		 //Create supplier
		 component().createSupplier(data.strSupplierName, "", "", "", "", "");	
		 //navigate to Setup inventory
	
		 home().tapPurchases();
		 //verify purchases page is displayed
		 purchase().verifyPurchasePage();
		 //Verify default month year(Current month year) is displayed
		 generic().validateDate(0, "MMMM YYYY");
		 //Create new purchase
		 component().createNewPurchaseAndAddLineItem(data.strSupplierName,"INV_PUR_012_022_023_Create_Puchase_UpdatePurchase",data.strInvoiceTotal,data.strLineItemType,data.strLineItemQuantity,7,1);
		//Click on first purchase line
		 purchase().clickOnPurchaseLine("1");
		 //Verify Purchase information
		 purchase().verifyValidatePurchaseInformation(data.strSupplierName,"","",false);
		//Verify if swipe is possible for top to button line item
		 purchase().verifySwipeTopToButton();
		//Merging INV_PUR_022
		 //Tap on edit button
		 generic().tapEdit();
		 //Update the same purchase 
		//Click on add line item(+) and enter the details and verify 
		 purchase().clickAddLineItemAndAddItemDetails(data.strLineItemQuantity.split("/")[0]);
		 //Select item type from dropdown
		 generic().selectValueFromDropdown(data.strLineItemType.split("/")[0],data.strLineItemType.split("/")[0]+" option is selected");
		//Tap on done button
		 generic().tapDone();
		 //Verify updated Purchase information
		 purchase().verifyValidatePurchaseInformation(data.strSupplierName,"","",false);
		//Verify if swipe is possible for top to button line item after updating one more line item
		 purchase().verifySwipeTopToButton();
		 //tap close
		 generic().tapClose();
		//Click on first purchase line
		 purchase().clickOnPurchaseLine("1");
		//Merging INV_PUR_023
		//Tap on edit button
		 generic().tapEdit();
		 //click on delete item link
		 purchase().clickOnDeleteItemLink("1");
		//click on delete item button
		 purchase().clickOnDeleteItemButton();
		//Tap on done button
		 generic().tapDone();
		//Verify updated Purchase information
		 purchase().verifyValidatePurchaseInformation(data.strSupplierName,"","",false);
		//close app
		 generic().closeApp();
		 
	 }
	 
	 
	 /******************************************************************************************
	  * Name : INV_PUR_012_Create_Puchase
	  * 
	  * Description :"Given When Then user is creating/editing a purchase the user wants to add a line item to the purchase the user will have a call-to-action to add the new line item - Creating a non-Sysco Purchase"
	  * 
	  * Manual Test cases :INV_PUR_013
	  * 
	  * Author : Sampada Dalai
	  * 
	  * Date : 10/13/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP2",groups={"Purchase"}, description = "Given When Then user is creating/editing a purchase the user wants to add a line item to the purchase the user will have a call-to-action to add the new line item - Creating a non-Sysco Purchase")
	 public void INV_PUR_013_Create_Puchase(PurchaseOrderObject data) throws Exception {	

		 
		//Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory with default location
		 component().setupInventorywithOGDefaultLocDefaultCat();
		 //Create supplier
		 component().createSupplier(data.strSupplierName, "", "", "", "", "");
		//navigate to Setup inventory
		 home().tapPurchases();	
		 //verify purchases page is displayed
		 purchase().verifyPurchasePage();
		 //Verify default month year(Current month year) is displayed
		 generic().validateDate(0, "MMMM YYYY");
		 //Create new purchase
		 component().createNewPurchaseAndAddLineItem(data.strSupplierName,"INV_PUR_013_Create_Puchase",data.strInvoiceTotal,data.strLineItemType,data.strLineItemQuantity,1,1);
		//Click on first purchase line
		 purchase().clickOnPurchaseLine("1");
		 //Verify Purchase information
		 purchase().verifyValidatePurchaseInformation(data.strSupplierName,"","",false);
		//Verify if swipe is possible for top to button line item
		 purchase().verifySwipeTopToButton();
		//Tap close window
		 generic().tapClose();
		//close app
		 generic().closeApp();
		 
	 }
	 
	 /******************************************************************************************
	  * Name : INV_PUR_014_Verify_ModalPopup
	  * 
	  * Description :As a user I want to be alerted with a pop up Modal when I create a purchase with no line items so that I know that it will not count against food costs until I have at least one valid categorized line item included
	  * 
	  * Manual Test cases :INV_PUR_014
	  * 
	  * Author : Sampada Dalai
	  * 
	  * Date : 10/13/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP2",groups={"Purchase"}, description = "As a user I want to be alerted with a pop up Modal when I create a purchase with no line items so that I know that it will not count against food costs until I have at least one valid categorized line item included")
	 public void INV_PUR_014_Verify_ModalPopup(PurchaseOrderObject data) throws Exception {	

		 String strRandomInvoiceNumber=RandomStringUtils.randomAlphanumeric(5);
		//Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory with default location
		 component().setupInventorywithOGDefaultLocDefaultCat();
		 //Create supplier
		 component().createSupplier(data.strSupplierName, "", "", "", "", "");
		//navigate to Setup inventory
		 home().tapPurchases();	
		 //verify purchases page is displayed
		 purchase().verifyPurchasePage();
		 //Verify default month year(Current month year) is displayed
		 generic().validateDate(0, "MMMM YYYY");
		 //Tap add(+)
		 generic().tapAdd();	
		 //Verify purchase details page
		 purchase().verifyPurchaseDetailsPage();
		 //Click on supplier which will display dropdown
		 purchase().tapSelectSupplier();
		 //Verify Sysco supplier should not be displayed in supplier type
		 generic().verifyValueInDropdown("sysco", "in Supplier ", false);
		 //Select option from dropdown
		 generic().selectValueFromDropdown(data.strSupplierName,data.strSupplierName+" option is selected");
		 //Enter invoice number and invoice total
		 purchase().enterInvoiceNumberAndInvoiceTotal("INV_PUR_014_Verify_ModalPopup", data.strInvoiceTotal,strRandomInvoiceNumber);
		 //Tap on done button
		generic().tapDone();
		 //Verify modal popup is displayed if no line itesm added
		 purchase().verifyModalPopUpIfNoItemAdded();
		 //click on confirm
		 purchase().clickOnConfirm();
		//Click on first purchase line
		 purchase().clickOnPurchaseLine("1");
		 //Verify Purchase information
		 purchase().verifyValidatePurchaseInformation(data.strSupplierName,"","",false);
		//close app
		 generic().closeApp();
		 
	 }
	 
	 /******************************************************************************************
	  * Name : INV_PUR_015_Verify_ModalPopup
	  * 
	  * Description :As a user I want to be alerted with a pop up Modal when I create a purchase with no line items so that I know that it will not count against food costs until I have at least one valid categorized line item included
	  * 
	  * Manual Test cases :INV_PUR_015
	  * 
	  * Author : Sampada Dalai
	  * 
	  * Date : 10/13/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP2",groups={"Purchase"}, description = "As a user I want to be alerted with a pop up Modal when I create a purchase with no line items so that I know that it will not count against food costs until I have at least one valid categorized line item included")
	 public void INV_PUR_015_Verify_ModalPopup_ClickCancel(PurchaseOrderObject data) throws Exception {	

		 String strRandomInvoiceNumber=RandomStringUtils.randomAlphanumeric(5);
		//Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory with default location
		 component().setupInventorywithOGDefaultLocDefaultCat();
		 //Create supplier
		 component().createSupplier(data.strSupplierName, "", "", "", "", "");
		//navigate to Setup inventory
		 home().tapPurchases();	
		 //verify purchases page is displayed
		 purchase().verifyPurchasePage();
		 //Verify default month year(Current month year) is displayed
		 generic().validateDate(0, "MMMM YYYY");
		 //Tap add(+)
		 generic().tapAdd();	
		 //Verify purchase details page
		 purchase().verifyPurchaseDetailsPage();
		 //Click on supplier which will display dropdown
		 purchase().tapSelectSupplier();
		 //Verify Sysco supplier should not be displayed in supplier type
		 generic().verifyValueInDropdown("sysco", "in Supplier ", false);
		 //Select option from dropdown
		 generic().selectValueFromDropdown(data.strSupplierName,data.strSupplierName+" option is selected");
		 //Enter invoice number and invoice total
		 purchase().enterInvoiceNumberAndInvoiceTotal("INV_PUR_015_Verify_ModalPopup", data.strInvoiceTotal,strRandomInvoiceNumber);
		 //Tap on done button
	     generic().tapDone();
		 //Verify modal popup is displayed if no line itesm added
		 purchase().verifyModalPopUpIfNoItemAdded();
		 //click on cancel
		 purchase().clickOnCancelPurChase();
		 //Verify purchase details page after click on cancel
		 purchase().verifyPurchaseDetailsPage();
		//close app
		 generic().closeApp();
		 
	 }
	 
	 /******************************************************************************************
	  * Name : INV_PUR_05_Verify_Value_WithNoItem
	  * 
	  * Description :As a user I want to be alerted with a pop up Modal when I create a purchase with no line items so that I know that it will not count against food costs until I have at least one valid categorized line item included
	  * 
	  * Manual Test cases :INV_PUR_005
	  * 
	  * Author : Sampada Dalai
	  * 
	  * Date : 10/13/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP2",groups={"Purchase"}, description = "As a user I want to be alerted with a pop up Modal when I create a purchase with no line items so that I know that it will not count against food costs until I have at least one valid categorized line item included")
	 public void INV_PUR_005_Verify_Value_WithNoItem(PurchaseOrderObject data) throws Exception {	

		
		//Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory with default location
		 component().setupInventorywithOGDefaultLocDefaultCat();
		//navigate to Setup inventory
		 home().tapPurchases();	
		 //verify purchases page is displayed
		 purchase().verifyPurchasePage();
		 //Verify default month year(Current month year) is displayed
		 generic().validateDate(0, "MMMM YYYY");
		// validate total purchase value $0.00
		 purchase().validateTotalPurchases("$0.00");
		 //Tap add(+)
		 generic().tapAdd();	
		 //Verify purchase details page
		 purchase().verifyPurchaseDetailsPage();
		//validate line item total
		 purchase().validateLineTitemTotal("$0.00");
		//Close app
		 generic().closeApp();
		 
	 }
	 
	 /******************************************************************************************
	  * Name : INV_PUR_016_MA_User_Purchase
	  * 
	  * Description :As a MA user, I do not want to be able to see non-sysco purchases made. Verify that purchases should not appear under the invoices list.
	  * 
	  * Manual Test cases :INV_PUR_016
	  * 
	  * Author : Sampada Dalai
	  * 
	  * Date : 10/13/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP2",groups={"Purchase"}, description = "As a MA user, I do not want to be able to see non-sysco purchases made. Verify that purchases should not appear under the invoices list.")
	 public void INV_PUR_016_MA_User_Purchase(PurchaseOrderObject data) throws Exception {	

		 //User clean up should be off for this TC
		 String strRandomInvoiceNumber=RandomStringUtils.randomAlphanumeric(5);
		//Login to app
		 component().login(data.strUserName, data.strPassword,false);
		 //Select account
		 purchase().selectAccountForMAUser();
		//navigate to Setup inventory
		 home().tapPurchases();	
		 //verify purchases page is displayed
		 purchase().verifyPurchasePage();
		 //Tap add(+)
		 generic().tapAdd();	
		 //Verify purchase details page
		 purchase().verifyPurchaseDetailsPage();
		 //Click on supplier which will display dropdown
		 purchase().tapSelectSupplier();
		 //Select option from dropdown
		 generic().selectValueFromDropdown(data.strSupplierName,data.strSupplierName+" option is selected");
		 //Enter invoice number and invoice total
		 purchase().enterInvoiceNumberAndInvoiceTotal("INV_PUR_016_MA_User_Purchase", data.strInvoiceTotal,strRandomInvoiceNumber);
		//Click on add line item(+) and enter the details and verify 
		 purchase().clickAddLineItemAndAddItemDetails(data.strLineItemQuantity);
		 //Select item type from dropdown
		 generic().selectValueFromDropdown(data.strLineItemType,data.strLineItemType+" option is selected");
		 //Tap on done button
	     generic().tapDone();
		 //Verify modal popup is displayed if no line itesm added
		 purchase().verifyModalPopUpIfNoItemAdded();
		 //click on cancel
		 purchase().clickOnCancelPurChase();
		 //Verify purchase line should not be created for MA user
		 purchase().verifyPurchaseLine("1");
		//close app
		 generic().closeApp();
		 
	 }
}
