package com.uom.yaml;

import java.io.FileNotFoundException;

import com.framework.frameworkFunctions.LibraryPage;
import com.uom.pageFactory.PageFactory;

public class AccountNumber extends LibraryPage{

	public static String accountNumber;
	
  
	public static String getAccountNumber(String userName) {
		try{
		accountNumber=readYaml(userName,"dataPool/AccountNumbers.yaml");
		if(accountNumber.length()==5){
			accountNumber = "0"+ accountNumber;
		}
		return accountNumber;
		}
		catch(FileNotFoundException e)
		{
			return "";
		}
	}

    
    
}
