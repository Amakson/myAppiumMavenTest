package com.uom.excelSheetObject;

public class SetupInventoryObject {


	public String strScriptName;
	public String strUserName;
	public String strPassword;
	public String strCustomList1;
	public String strCustomList2;
	public String strCustomList3;
	public String strLocationNames;
	public String strLocationTypes;
	public String strLocationTapped;
	public String strCategoryNames;
	public String strCategoryTypes;	
	public String strAddLocationName;
	public String strAddCategoryName;
	public String strNewLocation;
	public String strNewCategory;



	public SetupInventoryObject[][] getTestData(String[][] MethodArray){

		SetupInventoryObject sheetObjArray[][] =new SetupInventoryObject[MethodArray.length][1];

		for(int i= 0;i<MethodArray.length;i++)
		{
			SetupInventoryObject sheetObj = new SetupInventoryObject();
			int j=0;
			sheetObj.strScriptName= MethodArray[i][j++];
			sheetObj.strUserName= MethodArray[i][j++];
			sheetObj.strPassword= MethodArray[i][j++];
			sheetObj.strCustomList1=MethodArray[i][j++];
			sheetObj.strCustomList2=MethodArray[i][j++];
			sheetObj.strCustomList3=MethodArray[i][j++];
			sheetObj.strLocationNames= MethodArray[i][j++];
			sheetObj.strLocationTypes= MethodArray[i][j++];
			sheetObj.strLocationTapped= MethodArray[i][j++];
			sheetObj.strCategoryNames= MethodArray[i][j++];
			sheetObj.strCategoryTypes= MethodArray[i][j++];			
			sheetObj.strAddLocationName= MethodArray[i][j++];
			sheetObj.strAddCategoryName= MethodArray[i][j++];
			sheetObj.strNewLocation= MethodArray[i][j++];
			sheetObj.strNewCategory= MethodArray[i][j];			
			sheetObjArray[i][0]= sheetObj;	
		}
		return sheetObjArray;
	}













}
