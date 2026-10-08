package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sauce_Home_Page {

    WebDriver driver;

    By homepagetitle = By.xpath("//span[@class='title']");
    By hpdropdown = By.xpath("//select[@aria-label='Sort products']");
    By addtocart = By.xpath("//button[text()='Add to cart']");
    By addtocarticon=By.xpath("//a[@class='shopping_cart_link']");
    By carttitle=By.xpath("//span[@class='title']");
    By continueshoppingbtn=By.xpath("//button[@id='continue-shopping']");
    By checkoutbtn=By.xpath("//button[@id='checkout']");
    By checkouttitle=By.xpath("//span[@class='title']");
    By chechoutfirstnamefield=By.xpath("//input[@id='first-name']");
    By checkoutlastnamefield=By.xpath("//input[@id='last-name']");
    By checkoutpinfield=By.xpath("//input[@id='postal-code']");
    By checkoutcontinuebtn= By.xpath("//input[@id='continue']");
    By finishbtn=By.xpath("//button[@id='finish']");
    
    
    
    public Sauce_Home_Page (WebDriver driver)
    {
    	this.driver=driver;
    }
    
    public String verifytext() {
        return driver.findElement(homepagetitle).getText();
    }

    public void hpdropDown() {
        WebElement dd = driver.findElement(hpdropdown);
        Select dropdown = new Select(dd);
        dropdown.selectByVisibleText("Price (low to high)");
        
		
    }

    public void addtoCart() {
        List<WebElement> products = driver.findElements(addtocart);
        for (int i = 0; i < 6; i++) {
            products.get(i).click();
        }
        
    }
    
    public void addtocartIcon()
    {
    	driver.findElement(addtocarticon).click();
    }
    
    public String verifyCartTitle()
    {
    	return driver.findElement(carttitle).getText();
    }
    
    public void btnEnable()
    {
    	 driver.findElement(continueshoppingbtn).isEnabled();
    	 driver.findElement(checkoutbtn).isEnabled();
    }
    
    public void checkoutBtnClick()
    {
    	driver.findElement(checkoutbtn).click();
    	
    }
    
    public String checkoutTitle()
    {
    	return driver.findElement(checkouttitle).getText();
    }
    
    public void chechoutDetails(String firstname, String lastname, int pin)
    {
    	driver.findElement(chechoutfirstnamefield).sendKeys(firstname);
    	driver.findElement(checkoutlastnamefield).sendKeys(lastname);
    	driver.findElement(checkoutpinfield).sendKeys(String.valueOf(pin));
    }
    public void checkoutContinuebtn()
    {
    	driver.findElement(checkoutcontinuebtn).click();
    }
    
    public void finishBtn()
    {
    	driver.findElement(finishbtn).click();
    }
}
