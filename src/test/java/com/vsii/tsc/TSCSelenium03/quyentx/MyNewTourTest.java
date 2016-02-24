package com.vsii.tsc.TSCSelenium03.quyentx;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

@Test
public class MyNewTourTest {
	
	 WebDriver driver;
	 WebDriverWait wait;
	 String baseURL = "http://newtours.demoaut.com";
	
	//Locators for Login
	private By byLoginName = By.name("userName");
	private By byLoginPass = By.name("password");
	private By byLoginButton = By.name("login");
	
  @Test(dataProvider = "login")
  public void checkLogin(String userName, String password) {
		String expectedTitle = Data.loginExpectedTitle;
		driver.get(baseURL);
		String actualTitle = driver.getTitle();
		if (actualTitle.contentEquals(expectedTitle)) {

			driver.findElement(byLoginName).sendKeys(userName);
			driver.findElement(byLoginPass).sendKeys(password);
			
			new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(byLoginButton));
			driver.findElement(byLoginButton).click();
		}
		
		Assert.assertEquals(driver.getCurrentUrl(), baseURL+"/mercurysignon.php");	
	}
  
  @Test
  public void checkLoginValid() {
	  	login();
		Assert.assertEquals(driver.getCurrentUrl(), baseURL+"/mercuryreservation.php");	
	}
  @Test
  public void checkRegisterValid () {
	  
		String expectedTitle = "Register: Mercury Tours";
		String actualTitle = "";
		driver.get(baseURL + "/mercuryregister.php");

		actualTitle = driver.getTitle();

		if (actualTitle.contentEquals(expectedTitle)) {
		 	driver.findElement(byRegFName).sendKeys("Quyen");
		    driver.findElement(byRegLName).sendKeys("Ta");
		    driver.findElement(byRegPhone).sendKeys("0987654321");
		    driver.findElement(byRegEmail).sendKeys("test@gmail.com");
		    driver.findElement(byRegAddress).sendKeys("123 Lincold Street");
		    driver.findElement(byRegCity).sendKeys("NewYork");
		    driver.findElement(byRegState).sendKeys("New Jersey");
		    driver.findElement(byRegPsCode).sendKeys("700123");
		    driver.findElement(byRegCountry).sendKeys("United States");
		    driver.findElement(byRegUsername).sendKeys("quyentx");
		    driver.findElement(byRegPass).sendKeys("password1");
		    driver.findElement(byRegConfirmPass).sendKeys("password1");
		    driver.findElement(byRegButton).click();
		}
		Assert.assertEquals(driver.getCurrentUrl(), baseURL+"/create_account_success.php");		
	}
  
  @Test
  public void checkFindFlightValid(){
	  findFlight();
	  Assert.assertEquals(driver.getCurrentUrl(), baseURL+"/mercuryreservation2.php");
  }
  
  @Test
  public void checkSelectFlightValid(){
	  selectFlight();
	  Assert.assertEquals(driver.getCurrentUrl(), baseURL+"/mercurypurchase.php");
  }
  @Test
  public void checkBookFlightValid(){
	  String expectedTitle = "Book a Flight: Mercury Tours";
		String actualTitle = "";
		selectFlight();
		actualTitle = driver.getTitle();
		
		if (actualTitle.equals(expectedTitle)) {
			driver.findElement(By.name("passFirst0")).sendKeys("Quyen");
			driver.findElement(By.name("passLast0")).sendKeys("Ta");
			new Select(driver.findElement(By.name("pass.0.meal"))).selectByVisibleText("Bland");
			new Select(driver.findElement(By.name("creditCard"))).selectByVisibleText("Visa");
			driver.findElement(By.name("creditnumber")).sendKeys("0987654321");
			new Select(driver.findElement(By.name("cc_exp_dt_mn"))).selectByVisibleText("06");
			new Select(driver.findElement(By.name("cc_exp_dt_yr"))).selectByVisibleText("2010");
			driver.findElement(By.name("cc_frst_name")).sendKeys("Quyen");
			driver.findElement(By.name("cc_mid_name")).sendKeys("Xuan");
			driver.findElement(By.name("cc_last_name")).sendKeys("Ta");
			driver.findElement(By.name("billAddress1")).sendKeys("123 Lincold Street");
			driver.findElement(By.name("billCity")).sendKeys("NewYork");
			driver.findElement(By.name("billState")).sendKeys("New Jersey");
			driver.findElement(By.name("billZip")).sendKeys("700123");
			driver.findElement(By.name("delAddress1")).sendKeys("123 Lincold Street");
			driver.findElement(By.name("delCity")).sendKeys("NewYork");
			driver.findElement(By.name("delState")).sendKeys("New Jersey");
			driver.findElement(By.name("delZip")).sendKeys("700123");
			driver.findElement(By.name("buyFlights")).click();
		}
		Assert.assertEquals(driver.getCurrentUrl(), baseURL+"/mercurypurchase2.php");
  }
  
  //Locator for Register
	private By byRegFName = By.name("firstName");
	private By byRegLName = By.name("lastName");
	private By byRegPhone = By.name("phone");
	private By byRegEmail = By.id("userName");
	private By byRegAddress = By.name("address1");
	private By byRegCity = By.name("city");
	private By byRegState = By.name("state");
	private By byRegPsCode = By.name("postalCode");
	private By byRegCountry = By.name("country");
	private By byRegUsername = By.id("email");
	private By byRegPass = By.name("password");
	private By byRegConfirmPass = By.name("confirmPassword");
	private By byRegButton = By.name("register");

  @Test(dataProvider = "reg")
  public void checkRegister (
		  String firstName, 
		  String lastName,
		  String phone,
		  String username,
		  String address,
		  String city,
		  String state,
		  String postalCode,
		  String country,
		  String email,
		  String password,
		  String confirmPassword) {
	  
		String expectedTitle = "Register: Mercury Tours";
		String actualTitle = "";
		driver.get(baseURL + "/mercuryregister.php");

		actualTitle = driver.getTitle();

		if (actualTitle.contentEquals(expectedTitle)) {
		 	driver.findElement(byRegFName).sendKeys(firstName);
		    driver.findElement(byRegLName).sendKeys(lastName);
		    driver.findElement(byRegPhone).sendKeys(phone);
		    driver.findElement(byRegEmail).sendKeys(username);
		    driver.findElement(byRegAddress).sendKeys(address);
		    driver.findElement(byRegCity).sendKeys(city);
		    driver.findElement(byRegState).sendKeys(state);
		    driver.findElement(byRegPsCode).sendKeys(postalCode);
		    driver.findElement(byRegCountry).sendKeys(country);
		    driver.findElement(byRegUsername).sendKeys(email);
		    driver.findElement(byRegPass).sendKeys(password);
		    driver.findElement(byRegConfirmPass).sendKeys(confirmPassword);
		    driver.findElement(byRegButton).click();
		}
		Assert.assertEquals(driver.getCurrentUrl(), baseURL+"/mercuryregister.php");	
		
	}
  
  //Locator for FindFlight
  private By byOneWayRdbt = By.name("tripType");
  private By byPassCount = By.name("passCount");
  private By byFromPort = By.name("fromPort");
  private By byFromDay = By.name("fromDay");
  private By byFromMonth = By.name("fromMonth");
  private By byToPort = By.name("toPort");
  private By byToMonth = By.name("toMonth");
  private By byToDay = By.name("toDay");
  private By byBusinessClass = By.name("servClass");
  private By FindFlightBtn = By.name("findFlights");
    
  @Test(dataProvider = "find")
  public void checkFindFlight(
		  String passCount, 
		  String fromPort, 
		  String fromDay, 
		  String fromMonth, 
		  String toPort, 
		  String toMonth, 
		  String toDay) {

		String expectedTitle = "Find a Flight: Mercury Tours:";
		String actualTitle = "";
		//Login
		login();
		actualTitle = driver.getTitle();
		
		if (actualTitle.contentEquals(expectedTitle)) {
			if (!driver.findElement(byOneWayRdbt).isSelected()) {
				driver.findElement(byOneWayRdbt).click();
			}
			
			new Select(driver.findElement(byPassCount)).selectByVisibleText(passCount);
			new Select(driver.findElement(byFromPort)).selectByVisibleText(fromPort);
			new Select(driver.findElement(byFromDay)).selectByVisibleText(fromDay);
			new Select(driver.findElement(byFromMonth)).selectByVisibleText(fromMonth);
			new Select(driver.findElement(byToPort)).selectByVisibleText(toPort);
			new Select(driver.findElement(byToMonth)).selectByVisibleText(toMonth);
			new Select(driver.findElement(byToDay)).selectByVisibleText(toDay);
			driver.findElement(byBusinessClass).click();
			driver.findElement(FindFlightBtn).click();
		}
		Assert.assertEquals(driver.getCurrentUrl(), baseURL+"/mercuryreservation.php");
  }
  
  
  @Test(dataProvider = "book", description = "checkBook")
	public void checkBookFlight(
			String passFirst0,
			String passLast0,
			String meal,
			String card,
			String cardNum,
			String cc_exp_dt_mn,
			String cc_exp_dt_yr,
			String cc_frst_name,
			String cc_mid_name,
			String cc_last_name,
			String billAddress1,
			String billCity,
			String billState,
			String billZip,
			String delAddress1,
			String delCity,
			String delState,
			String delZip) {
	  
		String expectedTitle = "Book a Flight: Mercury Tours";
		String actualTitle = "";
		selectFlight();
		actualTitle = driver.getTitle();
		
		if (actualTitle.equals(expectedTitle)) {
			driver.findElement(By.name("passFirst0")).sendKeys(passFirst0);
			driver.findElement(By.name("passLast0")).sendKeys(passLast0);
			new Select(driver.findElement(By.name("pass.0.meal"))).selectByVisibleText(meal);
			new Select(driver.findElement(By.name("creditCard"))).selectByVisibleText(card);
			driver.findElement(By.name("creditnumber")).sendKeys(cardNum);
			new Select(driver.findElement(By.name("cc_exp_dt_mn"))).selectByVisibleText(cc_exp_dt_mn);
			new Select(driver.findElement(By.name("cc_exp_dt_yr"))).selectByVisibleText(cc_exp_dt_yr);
			driver.findElement(By.name("cc_frst_name")).sendKeys(cc_frst_name);
			driver.findElement(By.name("cc_mid_name")).sendKeys(cc_mid_name);
			driver.findElement(By.name("cc_last_name")).sendKeys(cc_last_name);
			driver.findElement(By.name("billAddress1")).sendKeys(billAddress1);
			driver.findElement(By.name("billCity")).sendKeys(billCity);
			driver.findElement(By.name("billState")).sendKeys(billState);
			driver.findElement(By.name("billZip")).sendKeys(billZip);
			driver.findElement(By.name("delAddress1")).sendKeys(delAddress1);
			driver.findElement(By.name("delCity")).sendKeys(delCity);
			driver.findElement(By.name("delState")).sendKeys(delState);
			driver.findElement(By.name("delZip")).sendKeys(delZip);
			driver.findElement(By.name("buyFlights")).click();
		}

		Assert.assertEquals(driver.getCurrentUrl(), baseURL+"/mercurypurchase.php");
	}
	
	
	@DataProvider(name="login")
	public Object[][] loginData(){
		Object[][] arrayObject = getExcelData("D:\\Data.xls","Login");
		return arrayObject;
	}
	
	@DataProvider(name="reg")
	public Object[][] regData(){
		Object[][] arrayObject = getExcelData("D:\\Data.xls","Register");
		return arrayObject;
	}
	
	@DataProvider (name = "find")
	public Object[][] findData(){
		Object[][] arrayObject = getExcelData("D:\\Data.xls","FindFlight");
		return arrayObject;
	}
	
	@DataProvider (name = "book")
	public Object[][] bookData(){
		Object[][] arrayObject = getExcelData("D:\\Data.xls","BookFlight");
		return arrayObject;
	}
	
	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getRow(0).getLastCellNum();
			int totalNoOfRows = sh.getPhysicalNumberOfRows();
			
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			Iterator<Row> rowIterator = sh.iterator();
			for (int i= 1 ; i < totalNoOfRows; i++) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				for (int j=0; j < totalNoOfCols; j++) {
					Cell cell = cellIterator.next();
					//Get String only, need to convert into other types???
					arrayExcelData[i-1][j] = cell.getStringCellValue();

				}

			}
			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		}
		return arrayExcelData;
	}
  
  @BeforeMethod(description = "checkBook")
  public void beforeMethod() {
  }

  @AfterMethod(description = "checkBook")
  public void afterMethod() {
	  new WebDriverWait(driver, 5);
  }

  @BeforeClass
  public void testSetup() {
		driver=new FirefoxDriver();
		driver.manage().window().maximize();

	}

  @AfterClass
  public void afterClass() {
	  System.out.println("Class execution finished!");
	  driver.close();
  }
  
  public void login() {
		String expectedTitle = Data.loginExpectedTitle;
		driver.get(baseURL);
		String actualTitle = driver.getTitle();
		if (actualTitle.contentEquals(expectedTitle)) {

			driver.findElement(byLoginName).sendKeys("tutorial");
			driver.findElement(byLoginPass).sendKeys("tutorial");
			
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(byLoginButton));
			driver.findElement(byLoginButton).click();
		}
	}
  
  public void findFlight() {

		String expectedTitle = "Find a Flight: Mercury Tours:";
		String actualTitle = "";
		//Login
		login();
		actualTitle = driver.getTitle();
		
		if (actualTitle.contentEquals(expectedTitle)) {
			if (!driver.findElement(byOneWayRdbt).isSelected()) {
				driver.findElement(byOneWayRdbt).click();
			}
			
			new Select(driver.findElement(byPassCount)).selectByVisibleText("1");
			new Select(driver.findElement(byFromPort)).selectByVisibleText("London");
			new Select(driver.findElement(byFromDay)).selectByVisibleText("20");
			new Select(driver.findElement(byFromMonth)).selectByVisibleText("February");
			new Select(driver.findElement(byToPort)).selectByVisibleText("Portland");
			new Select(driver.findElement(byToMonth)).selectByVisibleText("May");
			new Select(driver.findElement(byToDay)).selectByVisibleText("15");
			driver.findElement(byBusinessClass).click();
			driver.findElement(FindFlightBtn).click();
		}
	}
  
  public void selectFlight() {
		String expectedTitle = Data.selectSuccessExpectedTitle;
		String actualTitle = "";
		//login
		//FindFlight
		findFlight();
		actualTitle = driver.getTitle();
		if (actualTitle.contentEquals(expectedTitle)) {
			driver.findElement(By.xpath("(//*[@name='outFlight'])[2]")).click();
			driver.findElement(By.xpath("(//*[@name='inFlight'])[3]")).click();
			driver.findElement(By.name("reserveFlights")).click();
		}
	}

}
