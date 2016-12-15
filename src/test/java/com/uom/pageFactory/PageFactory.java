package com.uom.pageFactory;

import java.awt.Component;

import com.framework.Starter;
import com.uom.components.Components;
import com.uom.pages.common.AccountsPage;
import com.uom.pages.common.ExpenseCategoriesPage;
import com.uom.pages.common.FoodCostPage;
import com.uom.pages.common.GenericPage;
import com.uom.pages.common.HomePage;
import com.uom.pages.common.LocationsPage;
import com.uom.pages.common.LoginPage;
import com.uom.pages.common.NonSyscoPrepItemPage;
import com.uom.pages.common.ProductPage;
import com.uom.pages.common.PurchasePage;
import com.uom.pages.common.SuppliersPage;
import com.uom.pages.common.SetupInventoryPage;

public class PageFactory extends Starter{
	
	public static LoginPage login()
	{		
		return new LoginPage();
			
	}
	public ExpenseCategoriesPage expenseCat()
	{
		return new ExpenseCategoriesPage();
	}
	public GenericPage generic()
	{
		return new GenericPage();
	}
	public HomePage home()
	{
		return new HomePage();
	}
	public LocationsPage locations()
	{
		return new LocationsPage();
	}
	public NonSyscoPrepItemPage nonSyscoPrepItem()
	{
		return new NonSyscoPrepItemPage();
	}
	public ProductPage product()
	{
		return new ProductPage();
	}
	public SuppliersPage supplier()
	{
		return new SuppliersPage();
	}
	public Components component()
	{
		return new Components();
	}
	public SetupInventoryPage setupInventory()
	{
		return new SetupInventoryPage();
	}
	public PurchasePage purchase()
	{
		return new PurchasePage();
	}
	public FoodCostPage foodCost()
	{
		return new FoodCostPage();
	}
}
