package com.vsii.tsc.TSCSelenium03.tranglt;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	protected Properties p;
	protected WebDriver driver;
	protected String urlBase;
	private int numberPass;

	public int getNumberPass() {
		return numberPass;
	}

	public void setNumberPass(int numberPass) {
		this.numberPass = numberPass;
	}

	@BeforeSuite
	public void beforeClass() throws IOException {

		// Read config file
		p = Utility.readConfig();
		String browser = p.getProperty("browserName");
		urlBase=p.getProperty("base_url");
		if (browser.equals("firefox") || browser.equals("Firefox")){
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		else if (browser.equals("chrome") || browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if (browser.equals("ie") || browser.equals("IE") || browser.equals("Ie")) {
			System.setProperty("webdriver.ie.driver", "F:\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}
	
	public void login(String name, String password) {
		driver.get(urlBase+ "/mercurysignon.php");
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys(name);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
	}
	public void flightFinder() {
		login("trang123", "123");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@type='radio' and @value='oneway']")).click();
		new Select(driver.findElement(By.name("passCount"))).selectByVisibleText("3");
		numberPass = Integer.parseInt(driver.findElement(By.name("passCount")).getAttribute("value"));
		setNumberPass(numberPass-1);
		new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("Zurich");
		new Select(driver.findElement(By.name("fromMonth"))).selectByVisibleText("June");
		new Select(driver.findElement(By.name("fromDay"))).selectByVisibleText("11");
		new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("Paris");
		new Select(driver.findElement(By.name("toMonth"))).selectByVisibleText("August");
		new Select(driver.findElement(By.name("toDay"))).selectByVisibleText("25");
		driver.findElement(By.xpath(".//*[@type='radio' and @value='First']")).click();
		new Select(driver.findElement(By.name("airline"))).selectByVisibleText("Blue Skies Airlines");
		driver.findElement(By.name("findFlights")).click();
	}
	
	@AfterSuite
	public void tearDown() throws Exception {
		driver.quit();
	}

}
