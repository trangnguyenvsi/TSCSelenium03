package com.vsii.tsc.TSCSelenium03.tranglt;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Unit test for simple App.
 */
public class RegisterTest extends TestBase
{
	  @Test
	  public void testregisSucc(){
	    driver.get(urlBase + "/");
	    driver.findElement(By.linkText("REGISTER")).click();
	    driver.findElement(By.name("firstName")).clear();
	    driver.findElement(By.name("firstName")).sendKeys("Trang");
	    driver.findElement(By.name("lastName")).clear();
	    driver.findElement(By.name("lastName")).sendKeys("Le");
	    driver.findElement(By.name("phone")).clear();
	    driver.findElement(By.name("phone")).sendKeys("123456");
	    driver.findElement(By.id("userName")).clear();
	    driver.findElement(By.id("userName")).sendKeys("trang@gmail.com");
	    driver.findElement(By.name("address1")).clear();
	    driver.findElement(By.name("address1")).sendKeys("1234");
	    driver.findElement(By.name("address2")).clear();
	    driver.findElement(By.name("address2")).sendKeys("567");
	    driver.findElement(By.name("city")).clear();
	    driver.findElement(By.name("city")).sendKeys("Ha Noi");
	    new Select(driver.findElement(By.name("country"))).selectByVisibleText("VIETNAM");
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("trang123");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("123");
	    driver.findElement(By.name("confirmPassword")).clear();
	    driver.findElement(By.name("confirmPassword")).sendKeys("123");
	    driver.findElement(By.name("register")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    System.out.println(driver.findElement(By.xpath(".//*[contains(font,'Thank you for registering')]")).getText());
	    Assert.assertTrue(driver.findElement(By.xpath(".//*[contains(font,'Thank you for registering')]")).getText().equals("Thank you for registering. You may now sign-in using the user name and password you've just entered."));
	  }
	 
}
