package com.uom.excelSheetObject;

public class ExpenseCategoriesObject {

	public String strScriptName;
	public String strUserName;
	public String strPassword;
	public String strCategoryName1;
	public String strCategoryType1;
	public String strCategoryName2;
	public String strCategoryType2;
	public String strCategoryName3;
	public String strCategoryType3;
	public String strCategoryName4;
	public String strCategoryType4;
	public String strCategoryName5;
	public String strCategoryType5;
	public String strCategoryName6;
	public String strCategoryType6;
	public String strCategoryNames;
	public String strCategoryTypes;
	public String strLocationName1;
	
	public ExpenseCategoriesObject[][] getTestData(String[][] MethodArray){
		
		ExpenseCategoriesObject sheetObjArray[][] =new ExpenseCategoriesObject[MethodArray.length][1];
		
		for(int i= 0;i<MethodArray.length;i++)
		{
			ExpenseCategoriesObject sheetObj = new ExpenseCategoriesObject();
			int j=0;
			sheetObj.strScriptName= MethodArray[i][j++];
			sheetObj.strUserName= MethodArray[i][j++];
			sheetObj.strPassword= MethodArray[i][j++];
			sheetObj.strCategoryName1=MethodArray[i][j++];
			sheetObj.strCategoryType1=MethodArray[i][j++];
			sheetObj.strCategoryName2=MethodArray[i][j++];
			sheetObj.strCategoryType2=MethodArray[i][j++];
			sheetObj.strCategoryName3=MethodArray[i][j++];

			sheetObj.strCategoryType3=MethodArray[i][j++];
			sheetObj.strCategoryName4=MethodArray[i][j++];
			sheetObj.strCategoryType4=MethodArray[i][j++];
			sheetObj.strCategoryName5=MethodArray[i][j++];
			sheetObj.strCategoryType5=MethodArray[i][j++];
			sheetObj.strCategoryName6=MethodArray[i][j++];
			sheetObj.strCategoryType6=MethodArray[i][j++];
			sheetObj.strCategoryNames=MethodArray[i][j++];
			sheetObj.strCategoryTypes=MethodArray[i][j++];
			sheetObj.strLocationName1=MethodArray[i][j];
			sheetObjArray[i][0]= sheetObj;	
		}
		return sheetObjArray;
	}
}
