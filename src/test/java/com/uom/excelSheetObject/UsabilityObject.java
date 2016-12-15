package com.uom.excelSheetObject;

public class UsabilityObject {

	public String strScriptName;
	public String strUserName;
	public String strPassword;
	public String strLocationName1;
	public String strLocationName2;
	public String strLocationName3;
	public String strLocationType1;
	public String strLocationType2;
	public String strLocationType3;
	public String strCategoryName1;
	public String strCategoryName2;
	public String strCategoryName3;
	public String strCategoryType1;
	public String strCategoryType2;
	public String strCategoryType3;
	public String strQty1;
	public String strQty2;
	public String strQty3;
	public String strUOMAttribute1;
	public String strUOMAttribute2;
	public String strUOMAttribute3;
	public String strIndex1;
	public String strIndex2;
	public String strIndex3;
	public String strProductName1;
	public String strProductName2;
	public String strProductName3;
	public String strProductNames;
	public String strNickName1;
	public String strProductBrand1;
	public String strProductId1;
	public String strPrice1;
	public String strPrice2;
	public String strPrice3;
	public String strPrice4;
	public String strInvoiceTotal;
	public String strLineItemType;
	public String strLineItemQuantity;
	public String strExpectedInvTotal;
	public String strTotalPurchase;

	
	public UsabilityObject[][] getTestData(String[][] MethodArray){
		
		UsabilityObject sheetObjArray[][] =new UsabilityObject[MethodArray.length][1];
		
		for(int i= 0;i<MethodArray.length;i++)
		{
			UsabilityObject sheetObj = new UsabilityObject();
			int j=0;
			sheetObj.strScriptName= MethodArray[i][j++];
			sheetObj.strUserName= MethodArray[i][j++];
			sheetObj.strPassword= MethodArray[i][j++];
			sheetObj.strLocationName1= MethodArray[i][j++];
			sheetObj.strLocationName2= MethodArray[i][j++];
			sheetObj.strLocationName3= MethodArray[i][j++];
			sheetObj.strLocationType1= MethodArray[i][j++];
			sheetObj.strLocationType2= MethodArray[i][j++];
			sheetObj.strLocationType3= MethodArray[i][j++];
			sheetObj.strCategoryName1= MethodArray[i][j++];
			sheetObj.strCategoryName2= MethodArray[i][j++];
			sheetObj.strCategoryName3= MethodArray[i][j++];
			sheetObj.strCategoryType1= MethodArray[i][j++];
			sheetObj.strCategoryType2= MethodArray[i][j++];
			sheetObj.strCategoryType3= MethodArray[i][j++];
			sheetObj.strQty1= MethodArray[i][j++];
			sheetObj.strQty2= MethodArray[i][j++];
			sheetObj.strQty3= MethodArray[i][j++];
			sheetObj.strUOMAttribute1= MethodArray[i][j++];
			sheetObj.strUOMAttribute2= MethodArray[i][j++];
			sheetObj.strUOMAttribute3= MethodArray[i][j++];
			sheetObj.strIndex1= MethodArray[i][j++];
			sheetObj.strIndex2= MethodArray[i][j++];
			sheetObj.strIndex3= MethodArray[i][j++];
			sheetObj.strProductName1= MethodArray[i][j++];
			sheetObj.strProductName2= MethodArray[i][j++];
			sheetObj.strProductName3= MethodArray[i][j++];
			sheetObj.strProductNames= MethodArray[i][j++];			
			sheetObj.strNickName1= MethodArray[i][j++];
			sheetObj.strProductBrand1= MethodArray[i][j++];
			sheetObj.strProductId1= MethodArray[i][j++];
			sheetObj.strPrice1= MethodArray[i][j++];
			sheetObj.strPrice2= MethodArray[i][j++];
			sheetObj.strPrice3= MethodArray[i][j++];
			sheetObj.strPrice4= MethodArray[i][j++];
			sheetObj.strInvoiceTotal= MethodArray[i][j++];
			sheetObj.strLineItemType= MethodArray[i][j++];
			sheetObj.strLineItemQuantity= MethodArray[i][j++];
			sheetObj.strExpectedInvTotal= MethodArray[i][j++];
			sheetObj.strTotalPurchase= MethodArray[i][j];
	
			sheetObjArray[i][0]= sheetObj;	
		}
		return sheetObjArray;
		}
		
	}
	

