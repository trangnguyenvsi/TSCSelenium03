package com.vsii.tsc.TSCSelenium03.tranglt;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class BookFlightTest extends TestBase{

	@Test
	public void bookSucc() throws Exception {
		flightFinder();
		driver.findElement(By.name("reserveFlights")).click();
		driver.findElement(By.name("passFirst0")).clear();
		driver.findElement(By.name("passFirst0")).sendKeys("trang");
		driver.findElement(By.name("passLast0")).clear();
		driver.findElement(By.name("passLast0")).sendKeys("Le");
		driver.findElement(By.name("creditnumber")).clear();
		driver.findElement(By.name("creditnumber")).sendKeys("12345");
		driver.findElement(By.name("buyFlights")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[contains(font,'itinerary has been booked!')]"));
		Assert.assertEquals(driver.findElement(By.xpath(".//*[contains(font,'itinerary has been booked!')]")).getText(), "Your itinerary has been booked!\n\n"
		
				+"Please print a copy of this screen for your records. Thank you for choosing Mercury Tours.");
	}
	
	@Test
	public void verifyPass() throws Exception {
		flightFinder();
		driver.findElement(By.name("reserveFlights")).click();
		Assert.assertTrue(existsElement("passLast"+getNumberPass()));
		driver.quit();
	}
	
	
	private boolean existsElement(String name) {
	    try {
	        driver.findElement(By.name(name));
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	    return true;
	}

}
