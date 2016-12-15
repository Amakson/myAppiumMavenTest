package com.uom.excelSheetObject;

public class TrackInventoryObject {

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
	public String strSearchKeyword;
	public String strLocationName1;
	public String strLocationName2;
	public String strLocationName3;
	public String strLocationType1;
	public String strLocationType2;
	public String strLocationType3;
	public String strCategoryName1;
	public String strCategoryName2;
	public String strCategoryName3;
	public String strListName1;
	public String strLocationNames;
	public String strLocationTypes;
	public String strListName2;
	public String strAssignLocation;
	public String strCategoryNames;
	public String strCategoryTypes;
	public String strAssignCategory;
	public String strItemNames;
	public String strItemsInCustomCat1;	
	public String strItemsInCustomCat2;	
	public String strItemsInFrozen	;				
	public String strItemsInPoultry;
	public String strItemsInSeafood;
	public String strItemsInMeat;
	public String strItemsInDairy;
	public String strUncategorizedItems;
	
	public String strSupplierName1;
	public String strNickName1;
	public String strProductBrand1;
	public String strProductID1;
	public String strPack1;
	public String strSize1;
	public String strWeight1;
	public String strPrice1;

	
	
	public TrackInventoryObject[][] getTestData(String[][] MethodArray){
		
		TrackInventoryObject sheetObjArray[][] =new TrackInventoryObject[MethodArray.length][1];
		
		for(int i= 0;i<MethodArray.length;i++)
		{
			TrackInventoryObject sheetObj = new TrackInventoryObject();
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
			sheetObj.strSearchKeyword= MethodArray[i][j++];
			sheetObj.strLocationName1= MethodArray[i][j++];
			sheetObj.strLocationName2= MethodArray[i][j++];
			sheetObj.strLocationName3= MethodArray[i][j++];
			sheetObj.strLocationType1= MethodArray[i][j++];
			sheetObj.strLocationType2= MethodArray[i][j++];
			sheetObj.strLocationType3= MethodArray[i][j++];
			sheetObj.strCategoryName1= MethodArray[i][j++];
			sheetObj.strCategoryName2= MethodArray[i][j++];
			sheetObj.strCategoryName3= MethodArray[i][j++];
			sheetObj.strListName1=MethodArray[i][j++];
			sheetObj.strLocationNames= MethodArray[i][j++];
			sheetObj.strLocationTypes= MethodArray[i][j++];
			sheetObj.strListName2=MethodArray[i][j++];
			sheetObj.strAssignLocation=MethodArray[i][j++];
			sheetObj.strCategoryNames=MethodArray[i][j++];
			sheetObj.strCategoryTypes=MethodArray[i][j++];
			sheetObj.strAssignCategory=MethodArray[i][j++];
			sheetObj.strItemNames=MethodArray[i][j++];
			sheetObj.strItemsInCustomCat1=MethodArray[i][j++];	
			sheetObj.strItemsInCustomCat2=MethodArray[i][j++];	
			sheetObj.strItemsInFrozen=MethodArray[i][j++]	;				
			sheetObj.strItemsInPoultry=MethodArray[i][j++];
			sheetObj.strItemsInSeafood=MethodArray[i][j++];
			sheetObj.strItemsInMeat=MethodArray[i][j++];
			sheetObj.strItemsInDairy=MethodArray[i][j++];
			sheetObj.strUncategorizedItems=MethodArray[i][j++];
			
			sheetObj.strSupplierName1=MethodArray[i][j++];
			sheetObj.strNickName1=MethodArray[i][j++];
			sheetObj.strProductBrand1=MethodArray[i][j++];
			sheetObj.strProductID1=MethodArray[i][j++];
			sheetObj.strPack1=MethodArray[i][j++];
			sheetObj.strSize1=MethodArray[i][j++];
			sheetObj.strWeight1=MethodArray[i][j++];
			sheetObj.strPrice1=MethodArray[i][j++];

			
			sheetObjArray[i][0]= sheetObj;	
		}
		return sheetObjArray;
		}
		
	}
	


