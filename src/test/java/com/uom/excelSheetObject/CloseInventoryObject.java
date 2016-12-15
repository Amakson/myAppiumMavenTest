package com.uom.excelSheetObject;

public class CloseInventoryObject {
	
	public String strScriptName;
	public String strUserName;
	public String strPassword;
	public String strLocationNames;
	public String strLocationTypes;
	public String strLocationName1;
	public String strCategoryNames;
	public String strCategoryTypes;
	public String strListName1;
	public String strListName2;
	
	public CloseInventoryObject[][] getTestData(String[][] MethodArray){
		CloseInventoryObject sheetObjArray[][] =new CloseInventoryObject[MethodArray.length][1];
		for(int i= 0;i<MethodArray.length;i++)
		{
			CloseInventoryObject sheetObj = new CloseInventoryObject();
			int j=0;
			sheetObj.strScriptName= MethodArray[i][j++];
			sheetObj.strUserName= MethodArray[i][j++];
			sheetObj.strPassword= MethodArray[i][j++];
			sheetObj.strLocationNames= MethodArray[i][j++];
			sheetObj.strLocationTypes= MethodArray[i][j++];
			sheetObj.strLocationName1= MethodArray[i][j++];
			sheetObj.strCategoryNames= MethodArray[i][j++];
			sheetObj.strCategoryTypes= MethodArray[i][j++];
			sheetObj.strListName1= MethodArray[i][j++];
			sheetObj.strListName2= MethodArray[i][j];
			
			sheetObjArray[i][0]= sheetObj;	
		}
		return sheetObjArray;
	}

}
