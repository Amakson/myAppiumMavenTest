
package com.uom.tests;


import java.io.IOException;
import java.lang.reflect.Method;

import com.DataRead.Excel;
import com.framework.*;
import com.framework.configuration.ConfigFile;
import com.framework.frameworkFunctions.LibraryPage;
import com.framework.utils.RetryAnalyzer;
import com.framework.utils.UOMTestNGListener;
import com.google.common.base.Supplier;
import com.uom.excelSheetObject.SuppliersObject;
import com.uom.pageFactory.PageFactory;
import com.uom.pages.common.*;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

@Listeners(value = UOMTestNGListener.class)
public class Suppliers extends PageFactory{

	public static String[][] completeArray = null;	
     	
      
    @BeforeClass(alwaysRun=true)
	public void getData() throws Exception
	{		
		String strDataFilePath;
		Excel newExcel =new Excel();		
		completeArray=newExcel.read("test-data/TestData.xls","Suppliers");
	}
    @BeforeMethod(alwaysRun=true)
    public void initiate() throws Exception
    {
    	
    	startup();
    }
	
	 @DataProvider(name = "DP1",parallel =true)
	  public Object[][] getData(Method method) throws Exception{
		 	Excel newExcel =new Excel();	
		 	SuppliersObject sheetObj = new SuppliersObject();
	        System.out.println(method.getName());
	        String[][] MethodArray=newExcel.getMethodData(completeArray, method.getName());
	        Object[][] retObjArr= sheetObj.getTestData(MethodArray);
	        return(retObjArr);
	    }
	 @AfterMethod
		public void clean()
		{
	    	cleanUp();
		}
	 /******************************************************************************************
	  * Name : INV_MS_001_002_003_004_006_View_Add_DeleteSupplier
	  * 
	  * Description : User should be able to add,view details and delete a supplier(). Also verify the cancel button's functionality in the add suppliers page
	  * 
	  * Manual Test cases : INV_MS_001,INV_MS_002,INV_MS_003,INV_MS_004,INV_MS_006 
	  * 
	  * Author : Parvathy P
	  * 
	  * Date : 9/23/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Suppliers"}, description = "Add,View and Delete a Supplier")
	 public void INV_MS_001_002_003_004_006_View_Add_DeleteSupplier(SuppliersObject data) throws Exception {	
		
		 //Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory -  Can plug it in once the set inventory screens are stable
		 component().setupInventorywithOGDefaultLocDefaultCat();
		 //Tap Suppliers
		 home().tapSuppliers();
		 //verify the Suppliers page is loaded
		 supplier().verifySuppliersPage();
		 //Click on +
		 generic().tapAdd();
		 //Verify Add suppliers page is loaded
		 supplier().verifyAddSupplierPage(); 		 
		 //verify supplier details page info - all fields
		 supplier().verifyAddSupplierPageFieldsInfo();		 
		 //Enter supplier details
		 supplier().enterSupplierDetails(data.strSupplierName, data.strPhoneNumber, data.strAddress, data.strContactInformation, data.strEmailAddress, data.strNotes);
		// generic().hideAndroidNativeKeyboard();
		 //tap done
		 generic().tapDone();
		// LibraryPage.goBack();
		 //tap back
		// generic().tapBack();
		 generic().tapClose();
		 //verify the Suppliers page is loaded
		 supplier().verifySuppliersPage();
		 //verify newly created supplier is added in the list
		 supplier().verifySupplierInSupplierList(data.strSupplierName, true);
		 //Verify if Sysco is displayed as supplier at the top of the list
		 supplier().verifySyscoSupplierTopInTheList();
		 //Tap the newly created supplier
		 supplier().tapSupplierFromList(data.strSupplierName);
		 //Verify the supplier details page is loaded
		 supplier().verifySupplierDetailsPage();
		 //Verify the supplier details
		 supplier().verifySupplierDetails(data.strSupplierName, data.strPhoneNumber, data.strAddress, data.strContactInformation, data.strEmailAddress, data.strNotes);
		 //Verify the Delete this supplier button
		 supplier().verifyDeleteSupplier(true);
		 //Click on Yes Delete button in the popup
		 supplier().tapDeleteSupplier();
		 //tap yes on delete modal
		 generic().tapYesDelete();
		 //Verify the Suppliers page loaded
		 supplier().verifySuppliersPage();
		 //Verify if the deleted supplier is removed from the list
		 supplier().verifySupplierInSupplierList(data.strSupplierName, false);
		 //Click on +
		 generic().tapAdd();
		 //Verify Add suppliers page is loaded
		 supplier().verifyAddSupplierPage();
		 //Enter Supplier name
		 supplier().enterSupplierDetails(data.strSupplierName, data.strPhoneNumber, data.strAddress, data.strContactInformation, data.strEmailAddress, data.strNotes);
		// generic().hideAndroidNativeKeyboard();
		 //tap cancel
		 generic().tapCancel();
		 //verify the Suppliers page is loaded
		 supplier().verifySuppliersPage();
		//Verify if the canceled supplier is not available in the list
		 supplier().verifySupplierInSupplierList(data.strSupplierName, false);
		 //close app
		 generic().closeApp();
	 }
	 
	 /******************************************************************************************
	  * Name : INV_MS_005_View_Delete_SyscoSupplier
	  * 
	  * Description : Verify whether 1) user is allowed to view Sysco in supplier list. 2) user is not allowed to delete Sysco from supplier list
	  * 
	  * Manual Test cases : INV_MS_005 
	  * 
	  * Author : Parvathy P
	  * 
	  * Date : 9/23/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Suppliers","CriticalBatchAndroid"},priority=1, description = "View, Delete Sysco from supplier list")
	 public void INV_MS_005_View_Delete_SyscoSupplier(SuppliersObject data) throws Exception {

		 //Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory -  Can plug it in once the set inventory screens are stable
		 component().setupInventorywithOGDefaultLocDefaultCat();
		 //Tap Suppliers
		 home().tapSuppliers();
		 //verify the Suppliers page is loaded
		 supplier().verifySuppliersPage();
		 //Verify if Sysco is displayed as supplier in the list
		 supplier().verifySyscoSupplierTopInTheList();
		 //Tap on Sysco
		 supplier().tapSupplierFromList(data.strSupplierName);
		 //Verify the supplier details page is loaded
		 supplier().verifySupplierDetailsPage();
		 //Click on edit button
		 generic().tapEdit();
		 //Verify name field is non editable
		 supplier().verifySupplierNameEditable(false);
		 //Enter details for other fields
		 supplier().enterSupplierDetails("", data.strPhoneNumber, data.strAddress, data.strContactInformation, data.strEmailAddress, data.strNotes);
		 //Tap Done
		 generic().tapDone();
		 //Tap back
		// generic().tapBack();
		 generic().tapClose();
		 //verify the Suppliers page is loaded
		 supplier().verifySuppliersPage();
		 //Verify if Sysco is displayed as supplier in the list
		 supplier().verifySyscoSupplierTopInTheList();
		 //Tap on Sysco
		 supplier().tapSupplierFromList(data.strSupplierName);
		 //Verify the details
		 supplier().verifySupplierDetails(data.strSupplierName, data.strPhoneNumber, data.strAddress, data.strContactInformation, data.strEmailAddress, data.strNotes);
		 //close app
		 generic().closeApp();

	 }


	 
	 /******************************************************************************************
	  * Name : INV_MS_007_008_VerifyDuplicate_ErrorMessage_AddNewSupplier_EditSupplier_SameName
	  * 
	  * Description : Verify whether 
	  * 			1) user is not allowed to add new supplier with existing supplier name. An error message should be displayed.
	  * .			2) user is not allowed to edit supplier name with existing supplier name. An error message should be displayed.
	  * 
	  * Manual Test cases : INV_MS_007 , INV_MS_008
	  * 
	  * Author : Periyasamy Nainar
	  * 
	  * Date : 10/20/2016
	  * 
	  * Notes : NA
	  * 
	  * Modification Log
	  * Date						Author						Description
	  * -----------------------------------------------------------------------------------------
	  *  
	  ******************************************************************************************/
	 @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"Suppliers","CriticalBatchAndroid"},priority=1, description = "View, Delete Sysco from supplier list")
	 public void INV_MS_007_008_VerifyDuplicate_ErrorMessage_AddNewSupplier_EditSupplier_SameName(SuppliersObject data) throws Exception {

		 //Login to app
		 component().login(data.strUserName, data.strPassword);
		 //Set up Inventory -  Can plug it in once the set inventory screens are stable
		 component().setupInventorywithOGDefaultLocDefaultCat();
		 //create supplier from suppliers page
		 component().createSupplier(data.strSupplierName, data.strPhoneNumber, data.strAddress, data.strContactInformation, data.strEmailAddress, data.strNotes);
	     //Tap Suppliers
		 home().tapSuppliers();
		 //verify the Suppliers page is loaded
		 supplier().verifySuppliersPage();
		 //verify supplier name is dispalyed in supplier list page
		 supplier().verifySupplierInSupplierList(data.strSupplierName, true);
		 generic().tapAdd();
		 //Verify Add suppliers page is loaded
		 supplier().verifyAddSupplierPage();
		 //Enter supplier details
		 supplier().enterSupplierDetails(data.strSupplierName, data.strPhoneNumber, data.strAddress, data.strContactInformation, data.strEmailAddress, data.strNotes);
		 //tap done
		 generic().tapDone();
		 //verify error message when the user is creating new supplier with existing supplier name.
		 generic().verifyErrorMessageForDuplicateName("Could not add supplier","Duplicate supplier names are not allowed.","Supplier");
		 //tap on close button
		 generic().tapOnCloseErrorMessage();
		 //tap on cancel button
		 generic().tapCancel();
		 //verify number of suppliers displayed in suppliers page -1
		 supplier().verifyNumberOfSuppliers("2");
		 //tap on back
		 generic().tapBack();
		 //create one more supplier from suppliers page
		 component().createSupplier(data.strSupplierName1, data.strPhoneNumber1, data.strAddress1, data.strContactInformation, data.strEmailAddress, data.strNotes);
		//Tap Suppliers
		 home().tapSuppliers();
		 //verify the Suppliers page is loaded
		 supplier().verifySuppliersPage();
		 //verify supplier name is displayed in supplier list page
		 supplier().verifySupplierInSupplierList(data.strSupplierName, true);
		 supplier().verifySupplierInSupplierList(data.strSupplierName1, true);
		//verify number of suppliers displayed in suppliers page  -  2
		 supplier().verifyNumberOfSuppliers("3");
		//Tap on supplier name
		 supplier().tapSupplierFromList(data.strSupplierName1);
		 //Verify the supplier details page is loaded
		 supplier().verifySupplierDetailsPage();
		 //Click on edit button
		 generic().tapEdit();
		//Enter supplier details - existing supplier name
		 supplier().enterSupplierDetails(data.strSupplierName, "", "", "", "", "");
		 //tap done
		 generic().tapDone();
		 //verify error message when the user is creating new supplier with existing supplier name.
		 generic().verifyErrorMessageForDuplicateName("Could not save supplier","Duplicate supplier names are not allowed.","Supplier");
		//tap on close button
		 generic().tapOnCloseErrorMessage();
		 //tap on cancel button
		 generic().tapCancel();
		 //tap on close button
		 generic().tapClose();
		//verify number of suppliers displayed in suppliers page  -  2
		 supplier().verifyNumberOfSuppliers("3");
		 //close app
		 generic().closeApp();

	 }
}



