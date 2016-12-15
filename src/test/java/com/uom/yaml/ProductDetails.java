package com.uom.yaml;

import java.io.FileNotFoundException;

import com.framework.frameworkFunctions.LibraryPage;
import com.uom.pageFactory.PageFactory;

public class ProductDetails extends LibraryPage{

	public static String productName;
	public static String productPrice;
	
  
	public static String getPrice(String item) throws FileNotFoundException{
		productName=item;
		productPrice=readYaml(item,"dataPool/ProductPrices.yaml");
		return productPrice;
	}

    
    
}
