package test;

import org.testng.annotations.Test;

import base.Sauce_Demo_baseclass;
import page.Sauce_demo_Login_Page;

public class Sauce_Login_test extends Sauce_Demo_baseclass {
@Test
public void login()
{
	test=extent.createTest("login");
	logn.setvalues("standard_user", "secret_sauce");
	logn.loginClick();
}
}
