package com.uom.excelSheetObject;

public class PurchaseOrderObject {
	public String strScriptName;
	public String strUserName;
	public String strPassword;
	public String strLocationName;
	public String strProductName1;
	public String strQuantity1;
	public String strSupplierName;
	public String strInvoiceTotal;
	public String strLineItemType;
	public String strLineItemQuantity;
	public String strSupplierNameNew;
	
	public PurchaseOrderObject[][] getTestData(String[][] MethodArray){
		
		PurchaseOrderObject sheetObjArray[][] =new PurchaseOrderObject[MethodArray.length][1];
		
		for(int i= 0;i<MethodArray.length;i++)
		{
			PurchaseOrderObject sheetObj = new PurchaseOrderObject();
			int j=0;
			sheetObj.strScriptName= MethodArray[i][j++];
			sheetObj.strUserName= MethodArray[i][j++];
			sheetObj.strPassword= MethodArray[i][j++];
			sheetObj.strLocationName= MethodArray[i][j++];
			sheetObj.strProductName1= MethodArray[i][j++];
			sheetObj.strQuantity1= MethodArray[i][j++];
			sheetObj.strSupplierName=MethodArray[i][j++];
			sheetObj.strInvoiceTotal=MethodArray[i][j++];
			sheetObj.strLineItemType=MethodArray[i][j++];
			sheetObj.strLineItemQuantity=MethodArray[i][j++];
			
			sheetObjArray[i][0]= sheetObj;	
		}
		return sheetObjArray;
		}
		
}
