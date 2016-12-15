package com.uom.excelSheetObject;

public class SuppliersObject {

	public String strScriptName;
	public String strUserName;
	public String strPassword;
	public String strSupplierName;
	public String strPhoneNumber;
	public String strAddress;
	public String strContactInformation;
	public String strEmailAddress;
	public String strNotes;
	public String strSupplierName1;
	public String strSupplierName2;
	public String strPhoneNumber1;
	public String strAddress1;

	
	public SuppliersObject[][] getTestData(String[][] MethodArray){
		
		SuppliersObject sheetObjArray[][] =new SuppliersObject[MethodArray.length][1];
		
		for(int i= 0;i<MethodArray.length;i++)
		{
			SuppliersObject sheetObj = new SuppliersObject();
			int j=0;
			sheetObj.strScriptName= MethodArray[i][j++];
			sheetObj.strUserName= MethodArray[i][j++];
			sheetObj.strPassword= MethodArray[i][j++];
			sheetObj.strSupplierName= MethodArray[i][j++];
			sheetObj.strPhoneNumber= MethodArray[i][j++];
			sheetObj.strAddress= MethodArray[i][j++];
			sheetObj.strContactInformation= MethodArray[i][j++];
			sheetObj.strEmailAddress= MethodArray[i][j++];
			sheetObj.strNotes= MethodArray[i][j++];
			sheetObj.strSupplierName1= MethodArray[i][j++];
			sheetObj.strSupplierName2= MethodArray[i][j++];
			sheetObj.strPhoneNumber1= MethodArray[i][j++];
			sheetObj.strAddress1= MethodArray[i][j];
			sheetObjArray[i][0]= sheetObj;	
		}
		return sheetObjArray;
		}
		
	}
	

