package com.uom.excelSheetObject;

public class FoodCostObject {
	
	public String strScriptName;
	public String strUserName;
	public String strPassword;
	public String strLocationName;
	public String strProductName1;
	public String strQuantity1;
	public String strProductName2;
	public String strQuantity2;
	public String strProductName3;
	public String strQuantity3;
	public String strLocationNames;
	public String strLocationTypes;
	public String strCategoryNames;
	public String strCategoryTypes;
	public String strSupplierName1;
	public String strInvoiceTotal;
	public String strLineItemType;
	public String strLineItemPrice;
	public String strFoodSales;
	public String strLineItemType1;
	public String strLineItemPrice1;
	
public FoodCostObject[][] getTestData(String[][] MethodArray){
		
	FoodCostObject sheetObjArray[][] =new FoodCostObject[MethodArray.length][1];
		
		for(int i= 0;i<MethodArray.length;i++)
		{
			FoodCostObject sheetObj = new FoodCostObject();
			int j=0;
			sheetObj.strScriptName= MethodArray[i][j++];
			sheetObj.strUserName= MethodArray[i][j++];
			sheetObj.strPassword= MethodArray[i][j++];
			sheetObj.strLocationName= MethodArray[i][j++];
			sheetObj.strProductName1= MethodArray[i][j++];
			sheetObj.strQuantity1= MethodArray[i][j++];
			sheetObj.strProductName2= MethodArray[i][j++];
			sheetObj.strQuantity2= MethodArray[i][j++];
			sheetObj.strProductName3= MethodArray[i][j++];
			sheetObj.strQuantity3= MethodArray[i][j++];
			sheetObj.strLocationNames= MethodArray[i][j++];
			sheetObj.strLocationTypes= MethodArray[i][j++];
			sheetObj.strCategoryNames=MethodArray[i][j++];
			sheetObj.strCategoryTypes=MethodArray[i][j++];
			sheetObj.strSupplierName1=MethodArray[i][j++];
			sheetObj.strInvoiceTotal=MethodArray[i][j++];
			sheetObj.strLineItemType=MethodArray[i][j++];
			sheetObj.strLineItemPrice=MethodArray[i][j++];
			sheetObj.strFoodSales=MethodArray[i][j++];
			sheetObj.strLineItemType1=MethodArray[i][j++];
			sheetObj.strLineItemPrice1=MethodArray[i][j++];
			sheetObjArray[i][0]= sheetObj;	
		}
		return sheetObjArray;
	}
}
