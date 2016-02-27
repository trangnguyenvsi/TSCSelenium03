package com.vsii.tsc.TSCSelenium03.lannt;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;


public class BaseMethod {
	protected Properties p;
	protected WebDriver driver;
	protected String baseUrl;
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
		p = Original.readConfig();
		String browser = p.getProperty("browserName");
		baseUrl=p.getProperty("base_url");
		if (browser.equals("firefox") || browser.equals("Firefox")){
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		else if (browser.equals("chrome") || browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\LANNT\\Setup\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if (browser.equals("ie") || browser.equals("IE") || browser.equals("Ie")) {
			System.setProperty("webdriver.ie.driver", "D:\\Tài Liệu Dự Án\\Selenium\\Setup\\IEDriverServer_Win32_2.52.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	
	public void login(String name, String password) {
		driver.get(baseUrl+ "/mercurysignon.php");
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys(name);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
	}
	public void flightFinder() {

		login("lannt01", "12345");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@type='radio' and @value='oneway']")).click();
		new Select(driver.findElement(By.name("passCount"))).selectByVisibleText("3");
		numberPass = Integer.parseInt(driver.findElement(By.name("passCount")).getAttribute("value"));
		setNumberPass(numberPass-1);
		new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("London");
		new Select(driver.findElement(By.name("fromMonth"))).selectByVisibleText("March");
		new Select(driver.findElement(By.name("fromDay"))).selectByVisibleText("10");
		new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("New York");
		new Select(driver.findElement(By.name("toMonth"))).selectByVisibleText("March");
		new Select(driver.findElement(By.name("toDay"))).selectByVisibleText("20");
		driver.findElement(By.xpath(".//*[@type='radio' and @value='First']")).click();
		new Select(driver.findElement(By.name("airline"))).selectByVisibleText("Blue Skies Airlines");
		driver.findElement(By.name("findFlights")).click();
	}
	
	@DataProvider
	public Object[][] getData1() {
		return new Object[][]{{"5", "five"}, {"6", "six"}};
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		String[][] object = new String[4][2];
		FileInputStream fileInputStream = new FileInputStream("D:\\LANNT\\Data123.xls");
        POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
        HSSFWorkbook workBook2 = new HSSFWorkbook(fsFileSystem);
        HSSFSheet sheet = workBook2.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();
        int i=0;
        int j=0;
        while (iterator.hasNext()) {
        	
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
             
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                object[i][j]=cell.getStringCellValue();
                j=j+1;
                }
            i=i+1; 
            j=0;
            }
        workBook2.close();
        return object;
	}
	
	@AfterSuite
	public void tearDown() throws Exception {
		driver.quit();
	}

}

