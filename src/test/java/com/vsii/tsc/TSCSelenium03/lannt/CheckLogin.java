package com.vsii.tsc.TSCSelenium03.lannt;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;


public class CheckLogin extends BaseMethod {
	
	@Test(dataProvider="getData")
	public void loginFail(String username, String password) throws Exception {
//		System.out.println("ndjfdk");
		login(username, password);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[contains(text(),'Enter your user information to access')]"));
		Assert.assertEquals(driver.findElement(By.xpath(".//*[contains(text(),'Enter your user information to access')]")).getText(), "Welcome back to Mercury Tours! Enter your user information to access the member-only areas of this site. If you don't have a log-in, please fill out the registration form.");
	}

	//@Test
	public void loginSucc() throws Exception {
		login("tutorial", "tutorial");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[contains(text(),'Use our Flight Finder')]"));
		Assert.assertEquals(driver.findElement(By.xpath(".//*[contains(text(),'Use our Flight Finder')]")).getText(), "Use our Flight Finder to search for the lowest fare on participating airlines. Once you've booked your flight, don't forget to visit the Mercury Tours Hotel Finder to reserve lodging in your destination city.");
	}
}
