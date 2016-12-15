package com.uom.excelSheetObject;

public class NonSyscoPrepItemObject {

	public String strScriptName;
	public String strUserName;
	public String strPassword;
	public String strSupplierName1;
	public String strProductName1;
	public String strNickName1;
	public String strProductBrand1;
	public String strProductId1;
	public String strPack1;
	public String strSize1;
	public String strWeight1;
	public String strPrice1;
	public String strCategoryName1;
	public String strCategoryType1;
	public String strLocationName1;
	public String strLocationType1;
	public String strSupplierName2;
	public String strSupplierName3;
	public String strCategoryName2;
	public String strCategoryName3;
	public String strLocationName2;
	public String strLocationName3;
	public String strPhoneNumber;
	public String strAddress;
	public String strContactInfo;
	public String strEmail;
	public String strQty1;
	public String strUOMAttribute1;
	public String strQty2;
	public String strUOMAttribute2;
	public String[] strLocations;
	public String[] strLocationQty;
	public String[] strLocationQtyUOMAttr;
	public String strLocationNames;
	public String strLocationTypes;
	public String strCategoryNames;
	public String strCategoryTypes;
	public String strListName1;
	public String strListName2;

	
	public NonSyscoPrepItemObject[][] getTestData(String[][] MethodArray){
		
		NonSyscoPrepItemObject sheetObjArray[][] =new NonSyscoPrepItemObject[MethodArray.length][1];
		
		for(int i= 0;i<MethodArray.length;i++)
		{
			NonSyscoPrepItemObject sheetObj = new NonSyscoPrepItemObject();
			int j=0;
			sheetObj.strScriptName= MethodArray[i][j++];
			sheetObj.strUserName= MethodArray[i][j++];
			sheetObj.strPassword= MethodArray[i][j++];
			sheetObj.strSupplierName1=MethodArray[i][j++];
			sheetObj.strProductName1=MethodArray[i][j++];
			sheetObj.strNickName1=MethodArray[i][j++];
			sheetObj.strProductBrand1=MethodArray[i][j++];
			sheetObj.strProductId1=MethodArray[i][j++];
			sheetObj.strPack1=MethodArray[i][j++];
			sheetObj.strSize1=MethodArray[i][j++];
			sheetObj.strWeight1=MethodArray[i][j++];
			sheetObj.strPrice1=MethodArray[i][j++];
			sheetObj.strCategoryName1=MethodArray[i][j++];
			sheetObj.strCategoryType1=MethodArray[i][j++];
			sheetObj.strLocationName1=MethodArray[i][j++];
			sheetObj.strLocationType1=MethodArray[i][j++];
			sheetObj.strSupplierName2=MethodArray[i][j++];
			sheetObj.strSupplierName3=MethodArray[i][j++];
			sheetObj.strCategoryName2=MethodArray[i][j++];
			sheetObj.strCategoryName3=MethodArray[i][j++];
			sheetObj.strLocationName2=MethodArray[i][j++];
			sheetObj.strLocationName3=MethodArray[i][j++];	
			sheetObj.strPhoneNumber=MethodArray[i][j++];
			sheetObj.strAddress=MethodArray[i][j++];
			sheetObj.strContactInfo=MethodArray[i][j++];	
			sheetObj.strEmail=MethodArray[i][j++];
			sheetObj.strQty1=MethodArray[i][j++];	
			sheetObj.strUOMAttribute1=MethodArray[i][j++];	
			sheetObj.strQty2=MethodArray[i][j++];	
			sheetObj.strUOMAttribute2=MethodArray[i][j++];
			sheetObj.strLocations=MethodArray[i][j++].split(",");	
			sheetObj.strLocationQty=MethodArray[i][j++].split(",");	
			sheetObj.strLocationQtyUOMAttr=MethodArray[i][j++].split(",");
			sheetObj.strLocationNames=MethodArray[i][j++];	
			sheetObj.strLocationTypes=MethodArray[i][j++];	
			sheetObj.strCategoryNames=MethodArray[i][j++];	
			sheetObj.strCategoryTypes=MethodArray[i][j++];			
			sheetObj.strListName1=MethodArray[i][j++];	
			sheetObj.strListName2=MethodArray[i][j];
			
			sheetObjArray[i][0]= sheetObj;	
		}
		return sheetObjArray;
	}
}
