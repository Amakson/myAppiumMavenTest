package com.uom.excelSheetObject;

public class ManageInventoryListObject {

	public String strScriptName;
	public String strUserName;
	public String strPassword;
	public String strLocation1Name;
	public String strItem1Name;
	public String strListName1;
	public String strSupplierName;
	public String strPhoneNumber;
	public String strAddress;
	public String strContactInformation;
	public String strEmailAddress;
	public String strNotes;
	public String strProduct1Name;
	public String strProduct1NickName;
	public String strProduct1Brand;
	public String strProduct1Id;
	public String strProduct1Pack;
	public String strProduct1Size;
	public String strProduct1Weight;
	public String strProduct1Price;
	public String strExpenseCategory;
	public String strItem1Qty;
	public String strLocation2Name;
	public String strItem2Name;
	public String strProduct2Name;
	public String strProduct2NickName;
	public String strProduct2Brand;
	public String strProduct2Id;
	public String strProduct2Pack;
	public String strProduct2Size;
	public String strProduct2Weight;
	public String strProduct2Price;
	public String strLocation3Name;
	public String strExpenseCategory2;
	public String strLocationNames;
	public String strLocationTypes;
	public String strAssignLocations;
	public String strLocation1Type;
	public String strLocation2Type;
	public String strItem1UOM;
	public String strCategoryNames;
	public String strCategoryTypes;
	public String strItemUPCID;
	
	public ManageInventoryListObject[][] getTestData(String[][] MethodArray){
		
		ManageInventoryListObject sheetObjArray[][] =new ManageInventoryListObject[MethodArray.length][1];
		
		for(int i= 0;i<MethodArray.length;i++)
		{
			ManageInventoryListObject sheetObj = new ManageInventoryListObject();
			int j=0;
			sheetObj.strScriptName= MethodArray[i][j++];
			sheetObj.strUserName= MethodArray[i][j++];
			sheetObj.strPassword= MethodArray[i][j++];
			sheetObj.strLocation1Name= MethodArray[i][j++];
			sheetObj.strItem1Name= MethodArray[i][j++];
			sheetObj.strListName1= MethodArray[i][j++];
			sheetObj.strSupplierName= MethodArray[i][j++];
			sheetObj.strPhoneNumber= MethodArray[i][j++];
			sheetObj.strAddress= MethodArray[i][j++];
			sheetObj.strContactInformation= MethodArray[i][j++];
			sheetObj.strEmailAddress= MethodArray[i][j++];
			sheetObj.strNotes= MethodArray[i][j++];
			sheetObj.strProduct1Name= MethodArray[i][j++];
			sheetObj.strProduct1NickName= MethodArray[i][j++];
			sheetObj.strProduct1Brand= MethodArray[i][j++];
			sheetObj.strProduct1Id= MethodArray[i][j++];
			sheetObj.strProduct1Pack= MethodArray[i][j++];
			sheetObj.strProduct1Size= MethodArray[i][j++];
			sheetObj.strProduct1Weight= MethodArray[i][j++];
			sheetObj.strProduct1Price= MethodArray[i][j++];
			sheetObj.strExpenseCategory= MethodArray[i][j++];
			sheetObj.strItem1Qty= MethodArray[i][j++];
			sheetObj.strLocation2Name= MethodArray[i][j++];
			sheetObj.strItem2Name= MethodArray[i][j++];
			sheetObj.strProduct2Name= MethodArray[i][j++];
			sheetObj.strProduct2NickName= MethodArray[i][j++];
			sheetObj.strProduct2Brand= MethodArray[i][j++];
			sheetObj.strProduct2Id= MethodArray[i][j++];
			sheetObj.strProduct2Pack= MethodArray[i][j++];
			sheetObj.strProduct2Size= MethodArray[i][j++];
			sheetObj.strProduct2Weight= MethodArray[i][j++];
			sheetObj.strProduct2Price= MethodArray[i][j++];
			sheetObj.strLocation3Name=MethodArray[i][j++];
			sheetObj.strExpenseCategory2=MethodArray[i][j++];
			sheetObj.strLocationNames=MethodArray[i][j++];
			sheetObj.strLocationTypes=MethodArray[i][j++];
			sheetObj.strAssignLocations=MethodArray[i][j++];
			sheetObj.strLocation1Type=MethodArray[i][j++];
			sheetObj.strLocation2Type=MethodArray[i][j++];
			sheetObj.strItem1UOM=MethodArray[i][j++];
			sheetObj.strCategoryNames=MethodArray[i][j++];
			sheetObj.strCategoryTypes=MethodArray[i][j++];
			sheetObj.strItemUPCID=MethodArray[i][j];
			
			sheetObjArray[i][0]= sheetObj;			
		}
		return sheetObjArray;
		}
		
	}
	

