package com.framework.frameworkFunctions;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.crypto.agreement.srp.SRP6Server;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.yaml.snakeyaml.Yaml;

import com.framework.*;
import com.framework.configuration.ConfigFile;
import com.framework.reporting.*;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import sun.misc.JavaSecurityProtectionDomainAccess;

public class LibraryPage  {

	
	public static final String XPATH = "xpath";
    public static final String ID = "id";
    public static final String CLASSNAME = "className";
    public static final String CSSLOCATORS = "cssSelector";
    public static final String LINKTEXT = "linkText";
    public static final String PARTIALLINKTEXT = "partialLinkText";
    public static final String NAME = "name";
    public static final String TAGNAME = "tagName";

    public static Integer TIMEOUT = 10;
    public static final String ENABLEBTNCOLOR = "C5B84";
    public static final String DISABLEBTNCOLOR = "FFFFFF";

    public static HashMap<String, Object> mapObj = new HashMap<>();
    public static Map<String, String> locItemMap = new HashMap<String, String>();

    private static WebDriver driver;
    public static boolean isNative = true;

    public void Starter()
    {
        if(ConfigFile.getProperty("brand").equalsIgnoreCase("android"))
        {
            TIMEOUT =20;
        }
        else
        {
            TIMEOUT =5;
        }
        System.out.println(TIMEOUT);
    }

    public static WebDriver getDriver(){
        return Starter.getWebDriver();
    }



    /**
     * @function clickElement
     * @author SyscoAutomation
     * @description Click on UI Elements
     * @param stringVal - Locators value
     * @date 15-09-2016
     */

    public Boolean clickElement(String[] stringVal){
        //

        try{
            if(waitForElementToBeClickable(stringVal)!=null){
                //Actions action = new Actions(getDriver());
                //action.moveToElement(waitForElementToBeClickable(stringVal)).clickAndHold().build().perform();
                waitForElementToBeClickable(stringVal).click();
            }else{
                consolePrint("Element " + stringVal[2] + "With value " + stringVal[0]+  " is not clickable");
                FrameworkReporter.fail("Element " + stringVal[2] + " is not clickable");
            }
        }catch (Exception e) {
            e.printStackTrace();
            FrameworkReporter.fail("Element "+ stringVal[2] + " is not clickable ,locator value: " + stringVal[0]);
        }
        return true;

    }


    /**
     * @function clear
     * @author SyscoAutomation
     * @description Clear text from web element
     * @param stringVal - Locators value
     * @date 15-09-2016
     */

    public Boolean clear(String[] stringVal){

        try{
            if(clickElement(stringVal)){
                waitForElementToBeClickable(stringVal).clear();
            }else{
                consolePrint("Issue while clearing text from Element " + stringVal[2] + " With value " + stringVal[0]);
                FrameworkReporter.fail("Issue while clearing text from an element " + stringVal[2] );
            }
        }catch (Exception e) {
            FrameworkReporter.fail("Issue while clearning text from an element "+ stringVal[2]);
            e.printStackTrace();
        }
        return true;

    }

    /**
     * @function sendText
     * @author Sysco Automation
     * @description Send text to web element
     * @param stringVal - Locators value, textVal - Text value
     * @date 20-09-2016
     */

    public Boolean sendText(String[] stringVal,String textVal){
        WebElement element= waitForElementToBeClickable(stringVal);
        try{
            Boolean bool = false;
            if(element!=null){
                element.click();
                element.clear();
                element.sendKeys(textVal);

            }else{
                consolePrint("Issue while entering text to an element  " + stringVal[2] + "With value " + stringVal[0]);
                FrameworkReporter.fail("Issue while entering text to an element  " + stringVal[2] );
            }

        }catch (Exception e) {
            FrameworkReporter.fail("Issue while entering text to an element "+ stringVal[2]);
            e.printStackTrace();
        }
        return true;

    }

    /**
     * @function waitFor
     * @author SyscoAutomation
     * @description Wait for some time - for synchronization
     * @param  iSecValue- Number of seconds to wait
     * @date 15-09-2016
     */

    public static void waitFor(int iSecValue){
        try{
            Thread.sleep(iSecValue*1000);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * @function waitForElementPresent
     * @author SyscoAutomation
     * @description Wait for an element to be present - until maximum timeout unit
     * @param stringVal - Locators value
     * @date 15-09-2016
     */

    public WebElement waitForElementPresent(String[] stringVal){
        Boolean boolVal =false ;
        WebElement element=null;

        try{

            for(int i= 1 ; i<=TIMEOUT*10; i++){
                Thread.sleep(100);
                if(getDriver().findElements(getLocatorsType(stringVal)).size()!=0){
                    boolVal = true;
                    break;
                }

            }
            if(boolVal){
                element = getDriver().findElement(getLocatorsType(stringVal));
                if(element.isDisplayed()){
                    return element;
                }else{
                    consolePrint("Element "+ stringVal[2]+ " is not present with value "+ stringVal[0]);
                    return null;
                }
            }

        }catch (Exception e) {
            FrameworkReporter.fail("Element with "+ stringVal[2]+ "and value "+ stringVal[0] + "is not present");
            e.printStackTrace();
        }
        return element;


    }


    /**
     * @function waitForElementToBeClickable
     * @author SyscoAutomation
     * @description Wait for an element to be clickable - until maximum timeout unit
     * @param stringVal - Locators value
     * @date 15-09-2016
     */

    public WebElement waitForElementToBeClickable(String[] stringVal){
        Boolean boolVal =false ;
        WebElement element =null;

        try{

            for(int i= 1 ; i<=TIMEOUT*10; i++){
                Thread.sleep(100);
                if(getDriver().findElements(getLocatorsType(stringVal)).size()!=0){
                    boolVal = true;
                    break;
                }

            }
            if(boolVal){
                element = getDriver().findElement(getLocatorsType(stringVal));
                if(element.isDisplayed() && element.isEnabled()){
                    return element;
                }else{
                    consolePrint("Element "+ stringVal[2]+ " is not clickable with value "+ stringVal[0]);
                    return null;
                }
            }

        }catch (Exception e) {
            FrameworkReporter.fail("Element with "+ stringVal[2]+ "and value "+ stringVal[0] + "is not clickable");
            e.printStackTrace();
        }

        return element;
    }

    /**
     * @function waitForElementPresent
     * @author SyscoAutomation
     * @description Wait for an element to present - until specified amount of timeUnit
     * @param stringVal - Locators value, iTimeUnit - Number of seconds to wait
     * @date 15-09-2016
     */

    public WebElement waitForElementPresent(String[] stringVal, int iTimeUnit){
        Boolean boolVal =false ;
        WebElement element=null;

        try{

            for(int i= 1 ; i<=iTimeUnit*10; i++){
                Thread.sleep(100);
                if(getDriver().findElements(getLocatorsType(stringVal)).size()!=0){
                    element = getDriver().findElement(getLocatorsType(stringVal));
                    boolVal = true;
                    break;
                }

            }
            if(boolVal){
                if(element.isDisplayed()){
                    return element;
                }else{
                    consolePrint("Element "+ stringVal[2]+ " is not present with value "+ stringVal[0]);
                    return null;
                }
            }

        }catch (Exception e) {
            FrameworkReporter.fail("Element with "+ stringVal[2]+ "and value "+ stringVal[0] + "is not present");
            e.printStackTrace();
        }

        return element;
    }

    /**
     * @function waitForElementToBeClickable
     * @author SyscoAutomation
     * @description Wait for an element to be clickable - Specify amount of time
     * @param stringVal - Locators value, iTimeUnit - Number of seconds to wait
     * @date 15-09-2016
     */

    public WebElement waitForElementToBeClickable(String[] stringVal, int iTimeUnit){
        Boolean boolVal =false ;
        WebElement element =null ;

        try{

            for(int i= 1 ; i<=iTimeUnit*10; i++){
                Thread.sleep(100);
                if(getDriver().findElements(getLocatorsType(stringVal)).size()!=0){
                    boolVal = true;
                    break;
                }

            }
            if(boolVal){
                FrameworkReporter.pass("Element"+ stringVal[0]+ "Present");
                element = getDriver().findElement(getLocatorsType(stringVal));
                if(element.isDisplayed() && element.isEnabled()){
                    return element;
                }
                else{
                    consolePrint("Element "+ stringVal[2]+ " is not clickable with value "+ stringVal[0]);
                    return null;
                }
            }

        }catch (Exception e) {
            FrameworkReporter.fail("Element with "+ stringVal[2]+ "and value "+ stringVal[0] + "is not present");
            e.printStackTrace();
        }

        return element;
    }

    /**
     * @function isElementPresent
     * @author SyscoAutomation
     * @description Check whether an element is present or not, return true if an element present else return false.
     * @param stringVal - Locators value
     * @date 15-09-2016
     */

    public Boolean isElementPresent(String[] stringVal){

        Boolean boolVal =false ;
        try{

            if(getDriver().findElements(getLocatorsType(stringVal)).size()!=0){
                if(getDriver().findElement(getLocatorsType(stringVal)).isDisplayed()){
                    //FrameworkReporter.pass("Element with "+ stringVal[0]+ "is displayed");
                    boolVal = true;
                }else{
                    //	FrameworkReporter.fail("Element with "+ stringVal[0]+ "is not displayed");
                    consolePrint("Element with "+ stringVal[2]+ "and value "+ stringVal[0] + "is not displayed");
                    boolVal = false;
                }
            }
        }catch (Exception e) {
            FrameworkReporter.fail("Element with "+ stringVal[2]+ "and value "+ stringVal[0] + "is not present");
            e.printStackTrace();
        }

        return boolVal;
    }


    /**
     * @function isElementPresentAfterWait
     * @author SyscoAutomation
     * @description Check whether an element is present or not after waiting for specify amount of time, return true if an element present else return false.
     * @param stringVal - Locators value, iSec - Time unit for specified amount of time
     * @date 15-09-2016
     */

    public Boolean isElementPresentAfterWait(String[] stringVal, int iSec){

        Boolean boolVal =false ;

        for(int i=1; i<=iSec*10; i++){

            try {
                Thread.sleep(100);
                if(getDriver().findElements(getLocatorsType(stringVal)).size()!=0){
                    if(getDriver().findElement(getLocatorsType(stringVal)).isDisplayed()){
                        //FrameworkReporter.pass("Element with "+ stringVal[0]+ "is displayed");
                        boolVal = true;
                    }else{
                        consolePrint("Element with "+ stringVal[2]+ "and value "+ stringVal[0] + "is not displayed");
                        //	FrameworkReporter.fail("Element with "+ stringVal[0]+ "is not displayed");
                        boolVal = false;
                    }
                    break;
                }
				/*else{
					FrameworkReporter.fail("Element with "+ stringVal[0]+ "is not Present");
				}*/
            }catch (Exception e) {
                e.printStackTrace();
                FrameworkReporter.fail("Element with "+ stringVal[2]+ "and value "+ stringVal[0] + "is not present");
            }

        }

        return boolVal;
    }


    /**
     * @function isElementClickable
     * @author SyscoAutomation
     * @description Check whether an element is clickable or not, return true if an element present else return false.
     * @param stringVal - Locators value
     * @date 15-09-2016
     */

    public Boolean isElementClickable(String[] stringVal){

        Boolean boolVal =false ;
        WebElement element;

        try{
            element = getDriver().findElement(getLocatorsType(stringVal));
            if(element.isDisplayed() && element.isEnabled()){
                boolVal = true;
            }
            else{
                consolePrint("Element with "+ stringVal[2]+ "and value "+ stringVal[0] + "is not clickable");
                boolVal = false;
            }
        }catch (Exception e) {
            FrameworkReporter.fail("Element with "+ stringVal[2]+ "and value "+ stringVal[0] + "is not present");
            e.printStackTrace();
        }

        return boolVal;
    }


    /**
     * @function isElementClickableAfterWait
     * @author SyscoAutomation
     * @description Check whether an element is clickable or not after waiting for specify amount of time, return true if an element present else return false.
     * @param stringVal - Locators value, iSec - Number of seconds to wait
     * @date 15-09-2016
     */

    public Boolean isElementClickableAfterWait(String[] stringVal, int iSec){

        Boolean boolVal =false ;
        WebElement element;

        for(int i=1; i<=iSec*10; i++){

            try {
                Thread.sleep(100);
                if(getDriver().findElements(getLocatorsType(stringVal)).size()!=0){
                    element = getDriver().findElement(getLocatorsType(stringVal));
                    if(element.isDisplayed() && element.isEnabled()){
                        boolVal = true;
                    }
                    else{
                        consolePrint("Element with "+ stringVal[2]+ "and value "+ stringVal[0] + "is not clickable");
                        boolVal = false;
                    }
                    break;
                }
            }catch (Exception e) {
                FrameworkReporter.fail("Element with "+ stringVal[2]+ "and value "+ stringVal[0] + "is not present");
                e.printStackTrace();
            }

        }

        return boolVal;
    }


    /**
     * @function getElementText
     * @author SyscoAutomation
     * @description get the text value or content form an element
     * @param stringVal - Locators value
     * @date 15-09-2016
     */

    public String getElementText(String[] stringVal){
        String strReturnValue ="";
        try{
            if(waitForElementPresent(stringVal).getText()!=null){
                strReturnValue = waitForElementPresent(stringVal).getText();
            }
        }catch(Exception e){

        }
        return strReturnValue;
    }



    /**
     * @function getLocatorsType
     * @author SyscoAutomation
     * @description get Locators type before identifying an element
     * @param stringVal - Locators value as array of strings with locators type
     * @date 15-09-2016
     */
    public By getLocatorsType(String[] str){

        String strType = str[1];
        String strVal = str[0];
        By byValue = null;

        switch(strType){

            case "xpath":
                byValue = By.xpath(strVal);
                break;
            case "id":
                byValue = By.id(strVal);
                break;
            case "className":
                byValue = By.className(strVal);
                break;
            case "cssSelector":
                byValue = By.cssSelector(strVal);
                break;
            case "linkText":
                byValue = By.linkText(strVal);
                break;
            case "partialLinkText":
                byValue = By.partialLinkText(strVal);
                break;
            case "name":
                byValue = By.name(strVal);
                break;
            case "tagName":
                byValue = By.tagName(strVal);
                break;
            default:
                Reporter.log("Enter the correct locators type");

        }
        return byValue;
    }

    /**
     * @function switchToWebContext
     * @author SyscoAutomation
     * @description switch to web context before perform any action on webview elements
     * @date 15-09-2016
     */
    public  void switchToWebContext(){
        // consolePrint(isNative+"");
        if(isNative)
        {

            AppiumDriver<WebElement> appiumDriver = (AppiumDriver<WebElement>) getDriver();
            Set<String> contextNames1 = appiumDriver.getContextHandles();
            System.out.println(appiumDriver.getContext().toString());
            if(appiumDriver.getContext().contains("WEBVIEW_")){
                //System.out.println(appiumDriver.getContext().toString());
                isNative =false;
                // Dont do anything if the current context is webview

            }else{
                for (String contextName : contextNames1){
                    //System.out.println(contextName);
                    if(contextName.contains("WEBVIEW_")){
                        consolePrint("Switch to web context");
                        appiumDriver.context(contextName);
                        isNative =false;
                        break;
                    }
                }
            }
        }

    }

    /**
     * @function switchToNativeContext
     * @author SyscoAutomation
     * @description switch to native context before perform any action on native elements
     * @date 15-09-2016
     */
    public  void switchToNativeContext(){

        //System.out.println("Native value in native context" + isNative);
        //consolePrint(isNative+"");
        if(!isNative)
        {
            AppiumDriver<WebElement> appiumDriver = (AppiumDriver<WebElement>) getDriver();
            //	System.out.println(appiumDriver.getContext().toString());
            //if(!(appiumDriver.getContext().contains("NATIVE_APP"))){
            //consolePrint(appiumDriver.getContext().toString());
            appiumDriver.context("NATIVE_APP");
            consolePrint("Switch to native context");
            isNative =true;
            //}

        }
    }

    /**
     * @function replaceDynamicText
     * @author SyscoAutomation
     * @description To replace the dynamic text with the value send it in parameter
     * @param strArray - Locators, strDynamicVal - Values to be used in locators
     * @date 23-09-2016
     */
    public String[] replaceDynamicText(String strArray[], String ...strDynamicVal){
        String[] strArrayValue = new String[3];

        System.arraycopy(strArray, 0, strArrayValue, 0, 3);
        //	strArrayValue.clone();
        //	strArrayValue =strArray;


        if(strArrayValue[0].contains("{dynamic1}")){
            strArrayValue[0] = strArrayValue[0].replace("{dynamic1}", strDynamicVal[0]);
        }

        if(strArrayValue[0].contains("{dynamic2}")){
            strArrayValue[0] = strArrayValue[0].replace("{dynamic2}", strDynamicVal[1]);
        }


        //add more if its really needed, else ignore it
        return strArrayValue;
    }

    /**
     * @function getElementAttributeValue
     * @author SyscoAutomation
     * @description Get the attribute value of an element
     * @param stringVal - Locators value, attribute - Attribute value
     * @date 23-09-2016
     */

    public String getElementAttributeValue(String[] stringVal,String attribute){
//        try {
            return waitForElementPresent(stringVal).getAttribute(attribute);
//        }
//        catch (Exception e){
//
//        }
//
//        return null;
    }

    /**
     * @function getElementCount
     * @author SyscoAutomation
     * @description Get the count of element with the same locator value
     * @param stringVal - Locators value
     * @date 24-09-2016
     */

    public int getElementCount(String[] stringVal){
        waitForElementPresent(stringVal);
        return getDriver().findElements(getLocatorsType(stringVal)).size();

    }


    /**
     * @function getElementCount
     * @author SyscoAutomation
     * @description Get the count of element with the same locator value
     * @param stringVal - Locators value
     * @date 24-09-2016
     */

    public java.util.List<WebElement> getElements(String[] stringVal){
        //waitForElementPresent(stringVal);
        return getDriver().findElements(getLocatorsType(stringVal));

    }

    /**
     * @function retreiveStoreValue
     * @author SyscoAutomation
     * @description Retrieve the stored value
     * @param strKey - Key to retrieve the value from stored key value pair.
     * @dependency storeValue()
     * @date 24-09-2016
     */

    public Object retreiveStoredValue(String strKey){
        if(mapObj.containsKey(strKey)){
            return mapObj.get(strKey);}
        else{
            return "null";
        }

    }



    /**
     * @function storeValue
     * @author SyscoAutomation
     * @description Store key value pair in hash map to retrieve it for validation purpose
     * @param stringVal - Locators value
     * @date 24-09-2016
     */

    public void storeValue(String strKey, Object strValue){
        mapObj.put(strKey, strValue);

    }


    /**
     * @function consolePrint
     * @author SyscoAutomation
     * @description To dispaly sysout message in console based on the indicator passed from test.property
     * @param str - Indicator value either ON r OFF
     * @date 24-09-2016
     */

    public static void consolePrint(String str){
        if(ConfigFile.getProperty("ConsolePrint").equalsIgnoreCase("ON")){
            System.out.println(str);		}
    }

    /**
     * @function isElementEnabled
     * @author SyscoAutomation
     * @description Check whether an element is enabled or not
     * @param stringVal - Locators value
     * @date 26-09-2016
     */

    public boolean isElementEnabled(String[] stringVal){
        return (getDriver().findElement(getLocatorsType(stringVal)).isEnabled());
    }
    /**
     * @function tapOnElement
     * @author SyscoAutomation
     * @description Perform tap on UI Elements
     * @param stringVal - Locators value
     * @date 27-09-2016
     */

    public Boolean tapOnElement(String[] stringVal){

        try{
            if(waitForElementToBeClickable(stringVal)!=null){
                WebElement ele = waitForElementToBeClickable(stringVal);
                Point loc = ele.getLocation();
                int x = loc.getX();
                int y = loc.getY();
                ((AppiumDriver<WebElement>)driver).tap(x, ele, y);

            }else{
                consolePrint("Element " + stringVal[2] + "With value " + stringVal[0]+  " is not clickable");
                FrameworkReporter.fail("Element " + stringVal[2] + " is not clickable");
            }
        }catch (Exception e) {
            e.printStackTrace();
            FrameworkReporter.fail("Element "+ stringVal[2] + " is not clickable");
        }
        return true;
    }
/*
	 * @function getElementCSSValue
	 * @author SyscoAutomation
	 * @description Get the css value of an element
	 * @param stringVal - Locators value, attribute - CSS Attribute value
	 * @date 23-09-2016
	 */

    public String getElementCSSValue(String[] stringVal,String attribute){
        return waitForElementPresent(stringVal).getCssValue(attribute);

    }
    /**
     * @Function getSelectedOptionTextInDropDown
     * @Description To get the selected option text in dropdown
     * @author SyscoAutomation
     * @date 27-09-2016
     */
    public String getSelectedOptionTextInDropDown(String[] stringVal,int optionsCount){
        String selectedValue=null;
        for (int i=0;i<optionsCount;i++){
            if(getElementAttributeValue(replaceDynamicText(stringVal, Integer.toString(i)), "checked").equals("true")){
                selectedValue=getElementAttributeValue(replaceDynamicText(stringVal, Integer.toString(i)), "text");
                break;
            }

        }
        return selectedValue;

    }




    /**
     * @Function swipeScreenInHorizontal
     * @Description To go back to previous screen using driver instance
     * @author SyscoAutomation
     * @date 29-09-2016
     */
    public void swipeScreenInVertical(int start, int end){

        if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){

            try{
                //WebElement ele = waitForElementToBeClickable(strLocator);

                AndroidDriver<WebElement> driver1 = (AndroidDriver<WebElement>)getDriver();
                switchToNativeContext();

                System.out.println(getDriver().manage().window().getSize());
                org.openqa.selenium.Dimension dimension = driver1.manage().window().getSize();
                int iHeight = dimension.getHeight();
                int iWidth = dimension.getWidth();
                System.out.println();
                //give y axis as mid of screen
                //int y = iHeight/2;
                //int startX = (int) (iWidth*.80);
                //int endX = (int) (iWidth*.20);
                int x = iWidth/2;

                System.out.println(""+ start*.1);

                int startY = (int) (iHeight*(start*.1));    // Start Y value - High for up to down and low for down to up
                int endY = (int) (iHeight* (end*.1));		//  End Y value - Low for up to down and high for low to up
                //TouchActions action = new TouchActions(getDriver());

                driver1.swipe(x, startY, x, endY, 200);
                waitFor(2);

                System.out.println("StartY: "+ startY + "  endY: "+ endY + " Common X: "+ x);



                //action.longPress(ele).move(startX, endX).release().build().perform();
                //switchToWebContext();

            }catch(Exception e){

            }
        }
        else{
            try{

                IOSDriver<WebElement> driver1 = (IOSDriver<WebElement>)getDriver();
                switchToNativeContext();
                System.out.println(getDriver().manage().window().getSize());
                org.openqa.selenium.Dimension dimension = driver1.manage().window().getSize();
                int iHeight = dimension.getHeight();
                int iWidth = dimension.getWidth();
                System.out.println();
                int x = iWidth/2;
                System.out.println(""+ start*.1);
                int startY = (int) (iHeight*(start*.1));    // Start Y value - High for up to down and low for down to up
                int endY = (int) (iHeight* (end*.1));		//  End Y value - Low for up to down and high for low to up

                driver1.swipe(x, startY, x, endY, 200);
                waitFor(2);

                System.out.println("StartY: "+ startY + "  endY: "+ endY + " Common X: "+ x);


            }
            catch(Exception e){

            }
        }
    }


    /**
     * @Function swipeScreenInHorizontal
     * @Description To go back to previous screen using driver instance
     * @author SyscoAutomation
     * @date 29-09-2016
     */
    public void swipeScreenInHorizontal(int start, int end){

        try{
            //WebElement ele = waitForElementToBeClickable(strLocator);

            AppiumDriver<WebElement> driver1 = (AppiumDriver<WebElement>)getDriver();
            switchToNativeContext();

            System.out.println(getDriver().manage().window().getSize()+ "");
            org.openqa.selenium.Dimension dimension = driver1.manage().window().getSize();
            int iHeight = dimension.getHeight();
            int iWidth = dimension.getWidth();

            //give y axis as mid of screen
            int y = iHeight/2;
            int startX = (int) (iWidth*(start*.1));   // specify startx axis value ( higher for right to left and lower for left to right )
            int endX = (int) (iWidth* (end*.1));      //specify startY axis value  ( lower for right to left and higher for left to right )

            driver1.swipe(startX, y, endX, y, 200);
            waitFor(2);



            System.out.println("StartX: "+ startX + "  endX: "+ endX + " Common Y: " +y);
/*
			JavascriptExecutor executor =  (JavascriptExecutor) getDriver();

			HashMap<String, Double> mapObj = new HashMap<String,Double>();

			mapObj.put("startX", 800.0);
			mapObj.put("startY", 9.0);
			mapObj.put("endX", 250.0);
			mapObj.put("endY", 1000.0);
			mapObj.put("duration", 2.0);

			executor.executeScript("mobile :swipe", mapObj);*/


			/*TouchActions action = new TouchActions(getDriver());
			action.P*/

            //TouchActions action = new TouchActions((AndroidDriver<WebElement>)driver1);

            //for(int i=1 ; i <=12; i++){		  //testing purpose

            //((AppiumDriver<WebElement>) driver1) .swipe(startX, y, endX, y, 200);
            //	waitFor(2);
            //driver1.swipe(startX, y, endX, y, 4);
            //	((AppiumDriver<WebElement>) driver1) .swipe(500, y, 270, y, 100);    // Don't delet this line. Working line of code. Will be useful for reference

            //}

	/*		WebElement ele = getDriver().findElement(By.xpath("(//h3)[2]"));
			TouchActions action = new TouchActions(driver1);
			action.longPress(ele).move(500,270).release().build().perform();*/

            //action.longPress(ele).move(startX, endX).release().build().perform();
            //switchToWebContext();

        }catch(Exception e){

        }

    }

    /**
     * @Function swipeScreenDown
     * @Description To go back to previous screen using driver instance
     * @author SyscoAutomation
     * @date 30-09-2016
     */
    public void swipeScreenDown(String[] strLocator){
        if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){
            try{
                WebElement ele = waitForElementToBeClickable(strLocator);

                AppiumDriver<WebElement> driver1 = (AppiumDriver<WebElement>)getDriver();
                System.out.println(getDriver().manage().window().getSize());
                org.openqa.selenium.Dimension dimension = driver1.manage().window().getSize();
                int iHeight = dimension.getHeight();
                int iWidth = dimension.getWidth();
                //Get the current location of the element
                org.openqa.selenium.Point point1 = ele.getLocation();

                consolePrint("1."+iHeight);
                consolePrint("2."+iWidth);
                int X = point1.x;
                int Y = (int) (iWidth*.15);
                consolePrint("3."+X);
                consolePrint("4."+point1.y);
                consolePrint("3."+Y);

                TouchActions action = new TouchActions(getDriver());
                //action.longPress(ele).move(X, Y).release().build().perform();
                //action.scroll(ele, X, Y).release().build().perform();

                //action.scroll(X, Y);
                consolePrint("dsdsds");
                action.scroll(X,iHeight);
                consolePrint("ewew");
                action.flick(400,700);
                //action.

            }catch(Exception e){

            }

        }
    }

    /**
     * @Function waitForPageLoadAndroid
     * @Description Wait for particular time for the page to load
     * @author SyscoAutomation
     * @date 11-10-2016
     */

    public static void waitForPageLoadAndroid(int secVal){
        if(ConfigFile.getProperty("platformType").equalsIgnoreCase("android")){
            try{
                Thread.sleep(secVal*1000);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }


    /**
     * @function moveToElement
     * @author SyscoAutomation
     * @description Move to an element when an element is not visible
     * @param stringVal - Locators value
     * @date 11-10-2016
     */

    public void moveToElement(String[] stringVal){
//        try {
            WebElement ele = waitForElementPresent(stringVal);
            Actions action = new Actions(getDriver());
            System.out.println(ele);
            action.moveToElement(ele).build().perform();
//        }
//        catch (Exception e) {
//
//        }
    }



    /**
     * @function verifyBackGroundColor
     * @author SyscoAutomation
     * @description Move to an element when an element is not visible
     * @param stringVal - Locators value
     * @date 11-10-2016
     */
    public void verifyBackGroundColor(String[] stringVal, String strExpectedValue){
        WebElement ele = waitForElementPresent(stringVal);
        String strBGColor = ele.getCssValue("background-color");
        String[] str =strBGColor.split(",");

        String r = Integer.toHexString(Integer.parseInt(str[0].replace("rgba(", "")));
        String g = Integer.toHexString(Integer.parseInt(str[1].replace(" ", "").trim()));
        String b = Integer.toHexString(Integer.parseInt(str[2].replace(" ", "").trim()));
        //System.out.println(r + " " + g + " "+ b + "");
        String strActualText = (r.concat(g.concat(b))).toUpperCase();
        consolePrint("Actual Value: " + strActualText);

        if(strExpectedValue.equalsIgnoreCase(strActualText)){
            FrameworkReporter.pass("Background color for an element "+ stringVal[2] + " is displayed as expected, value: " + strActualText);
        }else{
            FrameworkReporter.pass("Background color for an element "+ stringVal[2] + " is displayed as expected, Actual value: " + strActualText + " Expected value: " + strExpectedValue);
            //needs to be updated
        }


    }

    /**
     * @function readYaml
     * @author SyscoAutomation
     * @description To read data from a yaml file
     * @param stringVal - Locators value
     * @throws FileNotFoundException
     * @date 17-10-2016
     */

    public static String readYaml(String key, String file) throws FileNotFoundException {
        Yaml ymal = new Yaml();
        Map map = (Map) ymal.load(new FileReader(file));
        System.out.println(map.get(key));
        return map.get(key).toString();
    }

    /**
     * @Function scrollToNativeValue
     * @author SyscoAutomation
     * @description	Scroll to a native element by passing the element text
     * @date 18-10-2016
     */
    public void scrollToNativeValue(String strText){
        AppiumDriver<WebElement> driver1 = (AppiumDriver<WebElement>)getDriver();
        //TouchAction action = new TouchAction(driver1);
        driver1.scrollTo(strText);

    }
    
    /**
     * @function verifyTextColor
     * @author SyscoAutomation
     * @description Verify text color of an element
     * @param stringVal - Locators value
     * @date 11-10-2016
     */
    public void verifyTextColor(String[] stringVal, String strExpectedValue){
        WebElement ele = waitForElementPresent(stringVal);
        String strTextColor = ele.getCssValue("color");
        String[] str =strTextColor.split(",");

        String r = Integer.toHexString(Integer.parseInt(str[0].replace("rgba(", "")));
        String g = Integer.toHexString(Integer.parseInt(str[1].replace(" ", "").trim()));
        String b = Integer.toHexString(Integer.parseInt(str[2].replace(" ", "").trim()));
        //System.out.println(r + " " + g + " "+ b + "");
        String strActualText = (r.concat(g.concat(b))).toUpperCase();
        consolePrint("Actual Value: " + strActualText);

        if(strExpectedValue.equalsIgnoreCase(strActualText)){
            FrameworkReporter.pass("Text color for an element "+ stringVal[2] + " is displayed as expected, value: " + strActualText);
        }else{
            FrameworkReporter.pass("Text color for an element "+ stringVal[2] + " is displayed as expected, Actual value: " + strActualText + " Expected value: " + strExpectedValue);
            //needs to be updated
        }


    }
}