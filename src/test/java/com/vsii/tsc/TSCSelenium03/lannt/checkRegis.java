package com.vsii.tsc.TSCSelenium03.lannt;

import org.testng.annotations.Test;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
@SuppressWarnings("unused")

public class checkRegis extends BaseMethod  {
	@Test
	public void testregisSucc(){
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("REGISTER")).click();
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("lannt01");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("12345");
	    driver.findElement(By.name("confirmPassword")).clear();
	    driver.findElement(By.name("confirmPassword")).sendKeys("12345");
	    driver.findElement(By.name("register")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    Assert.assertTrue(driver.findElement(By.xpath(".//*[contains(text(),'Thank you for registering')]")).getText().equals("Thank you for registering. You may now sign-in using the user name and password you've just entered."));
	    driver.findElement(By.xpath("//*[contains(text(),'Thank you for registering')]"));
}
}