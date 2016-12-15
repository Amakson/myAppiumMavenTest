package com.uom.excelSheetObject;

public class ManageLocationObject {

	public String strScriptName;
	public String strUserName;
	public String strPassword;
	public String strLocationType1;
	public String strLocationType2;
	public String strLocationType3;
	public String strItemID1;
	public String strItemID2;
	public String strLocationName1;
	public String strLocationName2;
	public String strLocationName3;
	public String strItemsCount;
	public String strNumberOfLocations;
	public String strLocationsWithCount1;
	public String strLocationsWithCount2;
	public String strLocationsWithCount3;
	public String strLocationName4;
	public String strLocationName5;
	public String strLocationNames;
	public String strLocationTypes;
	public String strCategoryNames;
	public String strCategoryTypes;
	public String strCategoryNames1;
	public String strCategoryNames2;
	public String strCategoryNames3;
	public String strListName1;
	public String strListName2;
	public String strProductName;
	
	

	
	public ManageLocationObject[][] getTestData(String[][] MethodArray){
		
		ManageLocationObject sheetObjArray[][] =new ManageLocationObject[MethodArray.length][1];
		
		for(int i= 0;i<MethodArray.length;i++)
		{
			ManageLocationObject sheetObj = new ManageLocationObject();
			int j=0;
			sheetObj.strScriptName= MethodArray[i][j++];
			sheetObj.strUserName= MethodArray[i][j++];
			sheetObj.strPassword= MethodArray[i][j++];
			sheetObj.strLocationType1= MethodArray[i][j++];
			sheetObj.strLocationType2= MethodArray[i][j++];
			sheetObj.strLocationType3= MethodArray[i][j++];
			sheetObj.strItemID1= MethodArray[i][j++];
			sheetObj.strItemID2= MethodArray[i][j++];
			sheetObj.strLocationName1= MethodArray[i][j++];
			sheetObj.strLocationName2= MethodArray[i][j++];	
			sheetObj.strLocationName3= MethodArray[i][j++];
			sheetObj.strItemsCount= MethodArray[i][j++];
			sheetObj.strNumberOfLocations= MethodArray[i][j++];
			sheetObj.strLocationsWithCount1= MethodArray[i][j++];	
			sheetObj.strLocationsWithCount2= MethodArray[i][j++];
			sheetObj.strLocationsWithCount3= MethodArray[i][j++];
			sheetObj.strLocationName4= MethodArray[i][j++];
			sheetObj.strLocationName5= MethodArray[i][j++];	
			sheetObj.strLocationNames= MethodArray[i][j++];
			sheetObj.strLocationTypes= MethodArray[i][j++];	
			sheetObj.strCategoryNames= MethodArray[i][j++];
			sheetObj.strCategoryTypes= MethodArray[i][j++];	
			sheetObj.strCategoryNames1= MethodArray[i][j++];	
			sheetObj.strCategoryNames2= MethodArray[i][j++];	
			sheetObj.strCategoryNames3= MethodArray[i][j++];
			sheetObj.strListName1= MethodArray[i][j++];	
			sheetObj.strListName2= MethodArray[i][j++];
			sheetObj.strProductName= MethodArray[i][j];
			
			sheetObjArray[i][0]= sheetObj;	
		}
		return sheetObjArray;
		}
		
	}
	

