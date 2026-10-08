package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sauce_demo_Login_Page {
WebDriver driver;
By usernamefield=By.xpath("//input[@id='user-name']");
By passwordfield=By.xpath("//input[@id='password']");
By loginbtn=By.xpath("//input[@id='login-button']");
	
public Sauce_demo_Login_Page (WebDriver driver)
{
	this.driver=driver;
	System.out.println("driver="+driver);
}

public void setvalues(String username, String password)
{
	driver.findElement(usernamefield).sendKeys(username);
	driver.findElement(passwordfield).sendKeys(password);
	
}
public void loginClick()
{
	driver.findElement(loginbtn).click();
	
WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
}



}
