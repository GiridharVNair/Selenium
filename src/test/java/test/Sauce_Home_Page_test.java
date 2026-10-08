package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Sauce_Demo_baseclass;

public class Sauce_Home_Page_test  extends Sauce_Demo_baseclass  {
	
	@Test(priority = 1)
	public  void vertifyText()
	{   
		test= extent.createTest("vertifyText");
		String text=shp.verifytext();
		Assert.assertEquals(text, "Products");
		System.out.println("Text is Matched");
	}
	
	@Test(priority = 2)
	public void dropDown()
	{
		test= extent.createTest("dropDown");
		shp.hpdropDown();
		
	}
	
	@Test(priority = 3)
	public void addToCart()
	{
		test= extent.createTest("addToCart");
		shp.addtoCart();
	}
	
	@Test (priority = 4)
	public void cartIcon()
	{
		test= extent.createTest("cartIcon");
		shp.addtocartIcon();
	}
	
	@Test(priority = 5)
	public void cartTitle()
	{
		test= extent.createTest("cartTitle");
		String cTitle=shp.verifyCartTitle();
		Assert.assertEquals(cTitle, "Your Cart");
		System.out.println("Title is Matched");
	}
	
	@Test(priority = 6)
	public void checkBtnEnable()
	{
		test= extent.createTest("checkBtnEnable");
		shp.btnEnable();
	}
	
	@Test(priority = 7)
	public void checkoutButtonClick()
	{
		test= extent.createTest("checkoutButtonClick");
		shp.checkoutBtnClick();
	}
	
	@Test(priority = 8)
	public void checkOutTitle()
	{
		test= extent.createTest("checkOutTitle");
		shp.checkoutTitle();
	}
	
	@Test(priority = 9)
	public void checkOutDetails()
	{
		test= extent.createTest("checkOutDetails");
		shp.chechoutDetails("Giridhar", "V", 686014);
	}
	
	@Test(priority = 10)
	public void checkOutBtn()
	{
		test= extent.createTest("checkOutBtn");
		shp.checkoutContinuebtn();
	}
	
	@Test(priority = 11)
	public void finishButton()
	{
		test= extent.createTest("finishButton");
		shp.finishBtn();
	}
}
