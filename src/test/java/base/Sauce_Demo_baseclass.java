package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import page.Sauce_Home_Page;
import page.Sauce_demo_Login_Page;

public class Sauce_Demo_baseclass {
public static WebDriver driver;
public static  Sauce_demo_Login_Page logn;
public  static Sauce_Home_Page shp;
public static ExtentSparkReporter reporter;
public static ExtentTest test;
public static ExtentReports extent;
@BeforeTest
public void openBrowser()
{
	reporter=new ExtentSparkReporter("./Reports/SpauseReport.html");
	reporter.config().setDocumentTitle("Automation Report");
	reporter.config().setReportName("Functional Test");
	reporter.config().setTheme(Theme.DARK);
	
	extent=new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("hostname", "localhost");
	extent.setSystemInfo("os", "windows 10");
	extent.setSystemInfo("testername", "Giridhar");
	extent.setSystemInfo("Browser Name", "chrome");
	
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--incognito");
	driver= new ChromeDriver(options);
	driver.get("https://www.saucedemo.com/");
	driver.manage().window().maximize();
}


@BeforeMethod
public void beforemthd()
{
 logn=new Sauce_demo_Login_Page(driver);
 shp=new Sauce_Home_Page(driver);

}
@AfterMethod
public void browserclose( ITestResult result) throws  IOException
{
	if(result.getStatus()==ITestResult.FAILURE)
	{
		test.log(Status.FAIL,"Test is failed is: "+result.getName());
		test.log(Status.FAIL,"Test is failed is: "+result.getThrowable());
	}
	else if(result.getStatus()==ITestResult.SKIP)
	{
		test.log(Status.SKIP,"Test is Skipped is: "+result.getName());
	}
	else if(result.getStatus()==ITestResult.SUCCESS)
	{
		test.log(Status.PASS,"Test is Passed is: "+result.getName());
	}
}
@AfterTest
public void tearDown()
{
	extent.flush();
}


}
