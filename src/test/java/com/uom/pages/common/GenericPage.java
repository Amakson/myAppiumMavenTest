package com.uom.pages.common;

import com.framework.configuration.ConfigFile;
import com.framework.frameworkFunctions.LibraryPage;
import com.framework.reporting.FrameworkReporter;

import com.uom.pages.androidPhone.AndroidGenericPage;
import com.uom.pages.iOSTablet.IOSTabletGenericPage;
import com.uom.yaml.AccountNumber;
import io.appium.java_client.AppiumDriver;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
//import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GenericPage extends LibraryPage{
	static Field[] declaredMemberVariables;
	static{
		declaredMemberVariables = GenericPage.class.getDeclaredFields();
	}


	//native elements
	//public static final String[] btn_Add= {"//UIAWebView[1]/UIAButton[4]",XPATH,"btn_Add"};
	public static final String[] btn_Add= {"//UIAWebView[1]/UIAButton[3]",XPATH,"btn_Add"};
	public static final String[] btn_Add_ListPage= {"//UIAWebView[1]/UIAButton[4]",XPATH,"btn_Add_ListPage"};
	public static final String[] btn_Back= {"//UIAWebView[1]/UIAButton[2]",XPATH,"btn_Back"};
	public static final String[] btn_Done= {"//UIAWebView[1]/UIAButton[@name='Done']",XPATH,"btn_Done"};
	//public static final String[] btn_Done= {"//a[@id='done-nav']",XPATH,"btn_Done"};
	public static final String[] btn_Done_Web= {"//*[contains(text(),'Done')]",XPATH,"btn_Done_Web"};
	public static final String[] lbl_Header= {"//span[@class='navbar-brand']",XPATH,"btn_Done_Web"};
	public static final String[] btn_NativeList_Done= {"(//UIAButton[@name='Done'])[2]",XPATH,"btn_NativeList_Done"};
	public static final String[] btn_Cancel= {"//UIAButton[@name='Cancel']",XPATH,"btn_Cancel"};
	public static final String[] btn_Edit= {"//UIAButton[@name='Edit']",XPATH,"btn_Edit"};
	//public static final String[] btn_Edit= {"//a[@id='edit-nav']/ancestor::ul",XPATH,"btn_Edit"};
	//

	public static final String[] btn_Close= {"//UIAWebView[1]/UIAButton[2]",XPATH,"btn_Close"};
	//public static final String[] btn_Close= {"//a[@id='close-nav']",XPATH,"btn_Close"};

	public static final String[] btn_DeleteYes={"yes-button",ID,"btn_DeleteYes"};
	public static final String[] btn_NoCancel={"no-button",ID,"btn_NoCancel"};

	public static final String[] lst_nativeList= {"//UIAPicker[1]/UIAPickerWheel[1]",XPATH,"lst_nativeList"};

//	public static final String[] btn_Next={"//android.widget.Button[@resource-id='next-nav']",XPATH,"btn_Next"};

	public static final String[] lst_CompleteNativeList= {"//android.widget.ListView[1]",XPATH,"lst_CompleteNativeList"};
	public static final String[] lst_NativeAndroidIpadList= {"//android.widget.ListView[1]//android.widget.CheckedTextView[@text='{dynamic1}']",XPATH,"lst_NativeAndroidIpadList"};
	//public static final String[] lst_IPadList= {"//UIAPopover[1]//UIAStaticText[@value='{dynamic1}']",XPATH,"lst_IPadList"};

	public static final String[] lnk_Close = {"//*[contains(@class,'mm-o-icon icon-cross')]",XPATH,"lnk_Close"};
	public static final String[] btn_Next = {"//button[contains(text(),'Next')]",XPATH,"btn_Next"};
	public static final String[] btn_Save = {"//button[contains(text(),'Save')]",XPATH,"btn_Save"};
	public static final String[] btn_Previous = {"//button[contains(text(),'Previous')]",XPATH,"btn_Previous"};
	public static final String[] btn_DoneButton = {"//button[contains(text(),'Done')]",XPATH,"btn_DoneButton"};

	public static final String[] btn_NextDisabled = {"//button[contains(text(),'Next') and @disabled]",XPATH,"btn_NextDisabled"};
	public static final String[] btn_SaveDisabled = {"//button[contains(text(),'Save') and @disabled]",XPATH,"btn_SaveDisabled"};
	public static final String[] btn_DoneDisabled = {"//button[contains(text(),'Done') and @disabled]",XPATH,"btn_DoneDisabled"};

	public static final String[] txt_Search_Native= {"//UIAWebView[1]/UIATextField[1]",XPATH,"txt_Search_Native"};
	public static final String[] lnk_Next = {"//UIAButton[@name='Next']",XPATH,"lnk_Next"};

	public static final String[] lnk_Toggle = {"//i[@class='mm-o-icon icon-arrow-left']",XPATH,"lnk_Toggle"};
	public static final String[] txt_MonthYear = {"//span[@id='period']",XPATH,"txt_MonthYear"};



	public static final String[] lst_ExpCat= {"//select[@name='expense']",XPATH,"lst_CompleteNativeList"};

	public static final String[] lbl_PopUpErrorMessageHeader={"//div[@class='panel-heading']//h4",XPATH,"lbl_PopUpErrorMessageHeader"};
	public static final String[] lbl_PopUpErrorMessgaeBody={"message",ID,"lbl_PopUpErrorMessgaeBody"};
	public static final String[] lnk_CloseErrorMessage={"close-button",ID,"lnk_CloseErrorMessage"};

	public static final String[] btn_NextNative = {"//UIAButton[@name='Next']",XPATH,"btn_NextNative"};


	/**
	 * @function tapAdd
	 * @author Periyasamy Nainar
	 * @description Tap on Add button ( + ) - Native element
	 * @date 23-09-2016
	 */

	public void tapAdd(){
		switchToNativeContext();
		clickElement(getObject(btn_Add));
		FrameworkReporter.info("Tapped on Add(+) button");
		}

	/**
	 * @function tapBack
	 * @author Periyasamy Nainar
	 * @description Tap on Back button ( < ) - Native element
	 * @date 23-09-2016
	 */

	public void tapBack(){
		switchToWebContext();
		moveToElement(lbl_Header);
		switchToNativeContext();
		waitForElementToBeClickable(btn_Back);
		clickElement(getObject(btn_Back));
		FrameworkReporter.info("Tapped on Back(<) button");

	}

	/**
	 * @function tapDone
	 * @author Periyasamy Nainar
	 * @description Tap on Done button  - Native element
	 * @date 23-09-2016
	 */

	public void tapDone(boolean... swipeReq){
		if(swipeReq.length==0){
		switchToNativeContext();
		swipeScreenInVertical(2, 8);
		switchToWebContext();
		moveToElement(btn_Done_Web);
		clickElement(btn_Done_Web);}
		/*clickElement(getObject(btn_Done));
		LibraryPage.waitForPageLoadAndroid(4);*/
		if(ConfigFile.getProperty("brand").equalsIgnoreCase("android"))
		{

			//moveToElement(ProductPage.img_Product);
		
			switchToNativeContext();
			clickElement(getObject(btn_Done));
			waitForPageToLoad(4);
			/*if(isElementPresentAfterWait(btn_Done, 5)){    // not working -
				clickElement(getObject(btn_Done));
				consolePrint("Tapped on done button again - 2nd attempt");
			}*/

		}else{
			//span[@class='navbar-brand']
			moveToElement(lbl_Header);			
			switchToNativeContext();
			if(isElementClickable(getObject(btn_Done)))
			{
			clickElement(getObject(btn_Done));
			}
			else
			{
				clickElement(getObject(btn_NativeList_Done));
			}
		}
		LibraryPage.waitForPageLoadAndroid(4);
		FrameworkReporter.info("Tapped on Done button");

	}

	/**
	 * @function tapCancel
	 * @author Periyasamy Nainar
	 * @description Tap on Cancel button  - Native element
	 * @date 23-09-2016
	 */

	public void tapCancel(){
		switchToNativeContext();
		clickElement(getObject(btn_Cancel));
		FrameworkReporter.info("Tapped on Cancel button");

	}


	/**
	 * @function tapEdit
	 * @author Periyasamy Nainar
	 * @description Tap on Edit button  - Native element
	 * @date 23-09-2016
	 */

	public void tapEdit(){
		switchToNativeContext();
		waitFor(5);
		clickElement(getObject(btn_Edit));
		FrameworkReporter.info("Tapped on Edit button");
		}


	/**
	 * @function closeApp
	 * @author Periyasamy Nainar
	 * @description Close an application
	 * @date 23-09-2016
	 */

	public void closeApp(){
		getDriver().quit();
		//getDriver().close();
		FrameworkReporter.info("Closed application by closing web driver");

	}

/**
	 * @function tapClose
	 * @author Gayathri Anand
	 * @description Tap on Close(X) button  - Native element
	 * @date 24-09-2016
	 */

	public void tapClose(){
		waitFor(6);
		switchToNativeContext();
		clickElement(getObject(btn_Close));
		//clickElement(btn_Close);
		FrameworkReporter.info("Tapped on Close(X) button");


	}

	/**
	 * @function tapNext
	 * @author Asha
	 * @description Tap on Next button  - Native element
	 * @date 28-09-2016
	 *//*

	public void tapNext(){
		switchToNativeContext();
		clickElement(getObject(btn_NextNative));
		FrameworkReporter.info("Tapped on Next button");


	}*/

	/**
	 * @Function tapYesDelete
	 * @author Periyasamy Nainar
	 * @description	Tap on yes delete button from confirmation modal
	 * @date 21-09-2016
	 */
	public void tapYesDelete(){
		switchToWebContext();
		clickElement(btn_DeleteYes);
		FrameworkReporter.info("Tapped on Yes button in confirmation modal");
		waitFor(6);

	}

	/**
	 * @Function tapCancelInModal
	 * @author Parvathy_P
	 * @description	Tap on Cancel button in Confirmation Modal
	 * @date 24-09-2016
	 */
	public void tapCancelInModal(){
		switchToWebContext();
		clickElement(btn_Cancel);
		FrameworkReporter.info("Tapped on Cancel in Confirmation Modal");
	}
	/**
	 * @function tapAddFromListPage
	 * @author Parvathy
	 * @description Tap on Add button ( + ) from list page (Product List)- Native element
	 * @date 26-09-2016
	 */

	public void tapAddFromListPage(){
		switchToNativeContext();
		clickElement(getObject(btn_Add_ListPage));
		FrameworkReporter.info("Tapped on Add(+) button");

		}

	/**
	 * @function selectValueFromDropdown
	 * @author Parvathy
	 * @description Select value from device drop down- Native element
	 * @params strName - Value to be selected , strPass - Pass message to be displayed , strFail - Fail message to be displayed
	 * @date 27-09-2016
	 */
	// PLease do not modify this function - Working fine for both android ios devices. Please check with Parvathy before making any changes on this files.
	public void selectValueFromDropdown( String strName, String strMessage){
		switchToNativeContext();
		String strBrand = ConfigFile.getProperty("brand");
		if((strBrand.equalsIgnoreCase("android") || (strBrand.equalsIgnoreCase("ipad")))){
			//scrollToNativeValue(strName);
			waitForPageLoadAndroid(1);
			clickElement(replaceDynamicText(getObject(lst_NativeAndroidIpadList),strName));
			waitForPageLoadAndroid(1);
			FrameworkReporter.pass(strMessage);
		}else{
			sendText(getObject(lst_nativeList), strName);
			FrameworkReporter.pass(strMessage);
			clickElement(getObject(btn_NativeList_Done));
		}

		//tapDone();
	}


	/**
	 * @function verifyValueInDropdown
	 * @author Periyasamy_Nainar
	 * @description Select value from device drop down- Native element
	 * @params strName - Value to be selected , strPass - Pass message to be displayed , strFail - Fail message to be displayed
	 * @date 27-09-2016
	 */

	// PLease do not modify this function - Working fine for both android ios devices. Please check with Parvathy before making any changes on this files.
	public void verifyValueInDropdown( String strName, String strDropdownName,boolean bIsPresent){
		switchToNativeContext();

		if((ConfigFile.getProperty("platformType").equalsIgnoreCase("android")) || (ConfigFile.getProperty("brand").equalsIgnoreCase("ipad"))){			
		/*// For android verification  
			if(bIsPresent){	*/

		//if((ConfigFile.getProperty("platformType").equalsIgnoreCase("android")) || (ConfigFile.getProperty("platformType").equalsIgnoreCase("ipad"))){
		// For android verification
			if(bIsPresent){
			scrollToNativeValue(strName);
			}
			Boolean boolActualVal = isElementPresent(replaceDynamicText(getObject(lst_NativeAndroidIpadList),strName));
			if(bIsPresent){
				if(boolActualVal){
					FrameworkReporter.pass(strName+ " is displayed in " + strDropdownName);
				}else{
					FrameworkReporter.fail(strName+ " is not displayed in " + strDropdownName);
			}
			}else{
				if(!(boolActualVal)){
					FrameworkReporter.pass(strName+ " is not displayed" + strDropdownName + "from product page");
				}else{
					FrameworkReporter.fail(strName+ " is displayed" + strDropdownName + "from product page");
					}
			}
		}
			else{
		//iOS devices ~Parvathy
			boolean isPresent =false;
            //FrameworkReporter.pass(strName+" is displayed in "+strDropdownName);
//FrameworkReporter.fail(strName+" is not displayed in "+strDropdownName);
            isPresent = waitForElementPresent(lst_nativeList).getAttribute("values").contains(strName);
			if(bIsPresent)
			{
				if(isPresent)
				{
					FrameworkReporter.pass(strName+" is displayed in "+strDropdownName);
				}
				else
				{
					FrameworkReporter.fail(strName+" is not displayed in "+strDropdownName);
				}

			}
			else
			{
				if(!isPresent)
				{
					FrameworkReporter.pass(strName+" is not displayed in "+strDropdownName);
				}
				else
				{
					FrameworkReporter.fail(strName+" is displayed in "+strDropdownName);
				}
			}


		}


		//tapDone();
	}



	/**
	 * @function verifyDropDownDisplay
	 * @author Periyasamy_Nainar
	 * @description verify location/supplier/category drop down is display or not in picker view
	 * @date 27-09-2016
	 */

	public void verifyDropDownDisplay(String strMessage){
		switchToNativeContext();
		if((ConfigFile.getProperty("brand").equalsIgnoreCase("android"))){
			if(isElementPresent(lst_CompleteNativeList)){
				FrameworkReporter.pass(strMessage + " Drop down is displayed");
			}else{
				FrameworkReporter.fail(strMessage + " Drop down is not displayed");
			}
		}else{

			if(isElementPresent(lst_nativeList)){
				FrameworkReporter.pass(strMessage + " Drop down is displayed");
			}else{
				FrameworkReporter.fail(strMessage + " Drop down is not displayed");
			}
		}

	}

	/**
	 * @function waitForPageToLoad
	 * @author Parvathy
	 * @description Waits for specified time for the page to load
	 * @params iTime - time in seconds
	 * @date 28-09-2016
	 */

	public void waitForPageToLoad( int iTime){
		waitFor(iTime);
	}

	/**
	 * @function hideAndroidNativeKeyboard
	 * @author Periyasamy_Nainar
	 * @description Waits for specified time for the page to load
	 * @params iTime - time in seconds
	 * @date 28-09-2016
	 */

	public void hideAndroidNativeKeyboard( ){
		switchToWebContext();
		AppiumDriver<WebElement> driver1 = (AppiumDriver<WebElement>)getDriver();
		driver1.hideKeyboard();
	}



	/**
	 * @function tapXButton
	 * @author Periyasamy Nainar
	 * @description Tap on X button
	 * @date 22-09-2016
	 */
	public void tapXButton(){
		switchToWebContext();
		clickElement(lnk_Close);
		FrameworkReporter.info("Tapped on X button");
	}



	/**
	 * @function tapNextButton
	 * @author Periyasamy Nainar
	 * @description Tap on Next button
	 * @date 23-09-2016
	 */
	public void tapNextButton(){
		switchToWebContext();
		clickElement(btn_Next);
		FrameworkReporter.info("Tapped on Next button");
	}


	/**
	 * @function tapPreviousButton
	 * @author Periyasamy Nainar
	 * @description Tap on Previous button
	 * @date 23-09-2016
	 */
	public void tapPreviousButton(){
		switchToWebContext();
		clickElement(btn_Previous);
		FrameworkReporter.info("Tapped on Previous button");
	}

	/**
	 * @function tapSaveButton
	 * @author Periyasamy Nainar
	 * @description Tap on Save button
	 * @date 23-09-2016
	 */
	public void tapSaveButton(){
		switchToWebContext();
		clickElement(btn_Save);
		FrameworkReporter.info("Tapped on Save button");
	}

	/**
	 * @function tapDoneButton
	 * @author Periyasamy Nainar
	 * @description Tap on Done button
	 * @date 29-09-2016
	 */

	public void tapDoneButton(){
		switchToWebContext();
		clickElement(btn_DoneButton);
		FrameworkReporter.info("Tapped on Done button");
	}

	/**
	 * @function verifySaveButtonStatus
	 * @author Periyasamy Nainar
	 * @description verify save button is enabled or disable based on the boolean value true or false
	 * @param boolVal - True to validate enable and false to validation disable
	 * @date 30-09-2016
	 */
	public void verifySaveButtonStatus(Boolean boolVal){
		switchToWebContext();
		Boolean boolEnable = isElementPresentAfterWait(btn_Save, 4);
		Boolean boolDisable = isElementPresentAfterWait(btn_SaveDisabled, 4);

		if(boolVal){
			if(boolEnable && (!boolDisable)){
				FrameworkReporter.pass("Save button is enabled");
			}else{
				FrameworkReporter.fail("Save button is not enabled");
			}
		}else{
			if(boolDisable){
				FrameworkReporter.pass("Save button is disbled");
			}else{
				FrameworkReporter.fail("Save button is  not disbled");
			}
		}

	}

	/**
	 * @function verifyNextButtonStatus
	 * @author Periyasamy Nainar
	 * @description verify Next button is enabled or disable based on the boolean value true or false
	 * @param boolVal - True to validate enable and false to validation disable
	 * @date 30-09-2016
	 */
	public void verifyNextButtonStatus(Boolean boolVal, String...strings){
		switchToWebContext();

		if(boolVal){
			if(isElementPresentAfterWait(btn_Next, 4) && (!(isElementPresentAfterWait(btn_NextDisabled, 4)))){
				FrameworkReporter.pass("Next button is enabled");
			}else{
				FrameworkReporter.fail("Next button is not enabled");
			}
			if(strings.length!=0 ){
				if(strings[0].equalsIgnoreCase("bgcolor")){
						verifyBackGroundColor(btn_Next, "18AD1");  // background color in hex value for enable next button
				}
			}
		}else{
			if(isElementPresentAfterWait(btn_NextDisabled, 4)){
				FrameworkReporter.pass("Next button is disabled");
			}else{
				FrameworkReporter.fail("Next button is  not disabled");
			}
			if(strings.length!=0 ){
				if(strings[0].equalsIgnoreCase("bgcolor")){
						verifyBackGroundColor(btn_NextDisabled, "c4e4f4");  // background color in hex value for disable next button
				}
			}
		}

	}

	/**
	 * @function verifyDoneButtonStatus
	 * @author Periyasamy Nainar
	 * @description verify Done button is enabled or disabled based on the boolean value true or false
	 * @param boolVal - True to validate enable and false to validation disable
	 * @date 30-09-2016
	 */
	public void verifyDoneButtonStatus(Boolean boolVal){
		switchToWebContext();
		Boolean boolEnable = isElementPresentAfterWait(btn_DoneButton, 3);
		Boolean boolDisable = isElementPresentAfterWait(btn_DoneDisabled, 3);

		if(boolVal){
			if(boolEnable && (!boolDisable)){
				FrameworkReporter.pass("Done button is enabled");
			}else{
				FrameworkReporter.fail("Done button is not enabled");
			}
		}else{
			if(boolDisable){
				FrameworkReporter.pass("Done button is disbled");
			}else{
				FrameworkReporter.fail("Done button is  not disbled");
			}
		}

	}

	/**
	 * @function tapDoneAfterSearch
	 * @author Parvathy
	 * @description Tap on Done button after search  - Native element
	 * @date 05-10-2016
	 */

	public void tapDoneAfterSearch(){
		switchToNativeContext();
		//AppiumDriver<WebElement> driver1 = (AppiumDriver<WebElement>) getDriver();
		//getDriver().findElement(By.xpath(txt_Search[0])).sendKeys(Keys.RETURN);
		clickElement(btn_NativeList_Done);
		FrameworkReporter.info("Tapped on Done button");


	}

	/**
	 * @function tapSearch
	 * @author Parvathy
	 * @description Tap on Search text box
	 * @date 05-10-2016
	 */

	public void tapSearch(){

		switchToWebContext();
		//AppiumDriver<WebElement> driver1 = (AppiumDriver<WebElement>) getDriver();
		//getDriver().findElement(By.xpath(txt_Search[0])).sendKeys(Keys.RETURN);
		tapOnElement(getObject(txt_Search_Native));
		//clickElement(LocationsPage.lbl_AddItemFrom);
		FrameworkReporter.info("Tapped on Done button");

	}
	/**
	 * @function tapOnNextLinkInCustomListsPage
	 * @author Reshma S Farook
	 * @description tap on Next link in Custom locations page in Setup inventory module
	 * @date 05-10-2016
	 */
	public void tapOnNextLinkInCustomListsPage(){
		switchToNativeContext();
		clickElement(getObject(lnk_Next));
		FrameworkReporter.info("Tapped on Next link on Custom Lists page");
		waitFor(5);
	}

	/**
	 * @Function goBack
	 * @Description To go back to previous screen using driver instance - in progress
	 * @author Periyasamy Nainar
	 * @date 29-09-2016
	 */
	public void goBack(){
		try{
			if((ConfigFile.getProperty("platformType").equalsIgnoreCase("android"))){
			AppiumDriver<WebElement> driver1 = (AppiumDriver<WebElement>)getDriver();
			driver1.navigate().back();
				}else{
					swipeScreenInHorizontal(8, 2);
				}
		}catch(Exception e){
			FrameworkReporter.fail("Error while navigating back to previous screen");
		}
	}


	/**
	 * @Function toggleBack
	 * @Description To toggle back to previous screen
	 * @author Sampada Dalai
	 * @date 14-10-2016
	 */
	public void toggleBack(){
		switchToWebContext();
		clickElement(lnk_Toggle);
		FrameworkReporter.info("Clicked on Toggle button");

	}
	/**
	 * @Function Toggle back
	 * @Description To return current ,previous and future month
	 * @author Sampada Dalai
	 * @date 14-10-2016
	 */
	public String getDate(int iMonths,String strDateFormat){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH ,+iMonths);
		String strConvertedMonthYear  = new SimpleDateFormat(strDateFormat).format(cal.getTime());
        consolePrint(strConvertedMonthYear);
        return strConvertedMonthYear;
	}

	/**
	 * @Function Toggle back
	 * @Description Validate date,month,year
	 * @author Sampada Dalai
	 * @date 14-10-2016
	 */
	public void validateDate(int iMonths,String strDateFormat){
		switchToWebContext();
		String strMonthYear=getDate(iMonths,strDateFormat);
		FrameworkReporter.info("Current date is :"+strMonthYear);
		waitForElementPresent(txt_MonthYear, 20);
		String strActualMonthYear=getElementText(txt_MonthYear);
		FrameworkReporter.info("Month and year is displayed as :"+strActualMonthYear);
		if(strMonthYear.equals(strActualMonthYear)){
			FrameworkReporter.pass("Month-Year is validated as expected :"+strActualMonthYear);
		}else{
			FrameworkReporter.fail("Month-Year is not validated as expected and '"+strActualMonthYear+"' is displayed instead of "+strMonthYear);
		}
	}

	// PLease do not modify this function - Working fine for both android ios devices. Please check with Parvathy before making any changes on this files.
		public void verifyValueInDropdownWeb( String strName, String strDropdownName,boolean bIsPresent){
			switchToWebContext();
			if((ConfigFile.getProperty("platformType").equalsIgnoreCase("android"))){
				Boolean boolActualVal = getElementText(lst_ExpCat).contains(strName);
				if(bIsPresent){
					if(boolActualVal){
						FrameworkReporter.pass(strName+ " is displayed in " + strDropdownName);
					}else{
						FrameworkReporter.fail(strName+ " is not displayed in " + strDropdownName);
				}
				}else{
					if(!(boolActualVal)){
						FrameworkReporter.pass(strName+ " is not displayed" + strDropdownName + "from product page");
					}else{
						FrameworkReporter.fail(strName+ " is displayed" + strDropdownName + "from product page");
						}
				}
			}

		}




		/**
		 * @function verifyAddButton
		 * @author Periyasamy Nainar
		 * @description Verify add button is displayed or not ( + ) - Native element
		 * @date 18-10-2016
		 */

		public void verifyAddButton(){
			switchToNativeContext();
				if(isElementPresentAfterWait(getObject(btn_Add), 5)){
					FrameworkReporter.pass("Add button is displayed");
				}else{
					FrameworkReporter.fail("Add button is not displayed");
				}
			}

		/**
		 * @function verifyBackButton
		 * @author Periyasamy Nainar
		 * @description Verify back button is displayed or not ( + ) - Native element
		 * @date 18-10-2016
		 */

		public void verifyBackButton(){
			switchToNativeContext();
			if(isElementPresentAfterWait(getObject(btn_Back), 5)){
				FrameworkReporter.pass("Back button is displayed");
			}else{
				FrameworkReporter.fail("Back button is not displayed");
			}

		}


		/**
		 * @function verifyEditButton
		 * @author Periyasamy Nainar
		 * @description Verify Edit button is displayed or not ( + ) - Native element
		 * @date 18-10-2016
		 */

		public void verifyEditButton(){
			switchToNativeContext();
			if(isElementPresentAfterWait(getObject(btn_Edit), 5)){
				FrameworkReporter.pass("Edit button is displayed");
			}else{
				FrameworkReporter.fail("Edit button is not displayed");
			}

		}


		/**
		 * @Function tapNoCancel
		 * @author Periyasamy Nainar
		 * @description	Tap on no cancel button from confirmation modal
		 * @date 18-10-2016
		 */
		public void tapNoCancel(){
			switchToWebContext();
			clickElement(btn_NoCancel);
			FrameworkReporter.info("Tapped on Yes button in confirmation modal");
			waitFor(6);

		}


		/**
		 * @Function verifyErrorMessageForDuplicateName
		 * @Description To verify the error message when the user tries to create supplier/location/category with existing name
		 * @author Periyasamy Nainar
		 * @date 20-10-2016
		 */
		public void verifyErrorMessageForDuplicateName(String strHeadrMsg, String strBodyMsg, String strType){
			switchToWebContext();

				if(getElementText(lbl_PopUpErrorMessageHeader).equalsIgnoreCase(strHeadrMsg)){
					FrameworkReporter.pass("'"+strHeadrMsg+ "' error message is displayed in"+ strType + "page");
				}
				else{
					FrameworkReporter.fail("'"+strHeadrMsg+ "' error message is not displayed in"+ strType + "page");
				}

				if(getElementText(lbl_PopUpErrorMessgaeBody).equalsIgnoreCase(strBodyMsg)){
					FrameworkReporter.pass("'"+strBodyMsg+ "' error message is displayed in"+ strType + "page");
				}
				else{
					FrameworkReporter.fail("'"+strBodyMsg+ "' error message is displayed in"+ strType + "page");
				}


				if(isElementPresentAfterWait(lnk_CloseErrorMessage, 2)){
					FrameworkReporter.pass("'Close' button is displayed with error message in "+ strType + "page");
				}
				else{
					FrameworkReporter.fail("'Close' button is not displayed with error message in "+ strType + "page");
				}

		}


		/**
		 * @Function tapOnCloseErrorMessage
		 * @Description To tap on close button in error message pop up
		 * @author Periyasamy Nainar
		 * @date 20-10-2016
		 */
		public void tapOnCloseErrorMessage(){
			switchToWebContext();
			clickElement(lnk_CloseErrorMessage);
			FrameworkReporter.info("Tapped on close button in error message pop up");

		}

		/**
		 * @Function userCleanUp
		 * @Description Clean up the user before execution
		 * @author Parvathy
		 * @throws IOException
		 * @throws ClientProtocolException
		 * @date 21-10-2016
		 */
		public void userCleanUp(String userName){

			if(ConfigFile.getProperty("userCleanUp").equalsIgnoreCase("on"))
			{
				if(ConfigFile.getProperty("madMobileCleanUp").equalsIgnoreCase("on")) {
					try
					{
						String madmCleanupUrl = ConfigFile.getProperty("madMobileCleanUpUrl");
						consolePrint("madm curl url: "+madmCleanupUrl);
                        String accountNumber =AccountNumber.getAccountNumber(userName).replace(" ", "").trim();
                        //ProcessBuilder pb1 = new ProcessBuilder("/usr/bin/curl", "-X", "DELETE", "https://onlineapi-dev.cloud.sysco.com/tasks/reset", "-H", "Authorization: Bearer 056|"+accountNumber+"|"+userName);
                        ProcessBuilder pb1 = new ProcessBuilder("/usr/bin/curl", "-X", "DELETE", madmCleanupUrl, "-H", "Authorization: Bearer 056|"+accountNumber+"|"+userName);

						Process p = pb1.start();
						BufferedReader reader =  new BufferedReader(new InputStreamReader(p.getInputStream()));
						StringBuilder builder = new StringBuilder();
						String line = null;
						while ( (line = reader.readLine()) != null) {
							builder.append(line);
						}
						String madmResult = builder.toString();
                        consolePrint("madm curl connection: "+madmResult);                  
					}
					catch (IOException e)
					{   System.out.print("error");
						e.printStackTrace();
					}
				}
				else
				{
                    StringBuffer result = new StringBuffer();
                    System.out.println("");
                    String line = "";
                    String accountNumber =AccountNumber.getAccountNumber(userName).replace(" ", "").trim();
                    HttpClient httpClient = HttpClientBuilder.create().build();
                    HttpPost post = new HttpPost("http://uom-qa.na.sysco.net:8081/tasks/cleanupDataForAccount?opCo=056&customerId="+accountNumber);
                    try{
                    HttpResponse response = httpClient.execute(post);
                    BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                    while ((line = br.readLine()) != null) {
                        result.append(line);
                    }
                    consolePrint(result.toString());
                    waitFor(3);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }

				}
			}
        }
		
		/**
		 * @function tapDoneFromEdit
		 * @author Parathy
		 * @description Tap on Done button  - Native element
		 * @date 01-11-2016
		 */

		public void tapDoneFromEdit(){
			if(ConfigFile.getProperty("brand").equalsIgnoreCase("android"))
			{
				
				//moveToElement(ProductPage.img_Product);
				swipeScreenInVertical(2, 8);
				switchToWebContext();
				moveToElement(btn_Done_Web);
				clickElement(btn_Done_Web);
				switchToNativeContext();
				clickElement(getObject(btn_Done));
				waitForPageToLoad(4);
							
			}else{
				switchToNativeContext();
				clickElement(getObject(btn_Done));
			}
			LibraryPage.waitForPageLoadAndroid(4);
			FrameworkReporter.info("Tapped on Done button");
			
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
					//childClassObject= new IOSGenericPage().findChildObject(parentObject[2]);	
					break;
				case "ipad":	
					childClassObject = new IOSTabletGenericPage().findChildObject(parentObject[2]);	
					break;
				case "android":
					childClassObject = new AndroidGenericPage().findChildObject(parentObject[2]);					
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
