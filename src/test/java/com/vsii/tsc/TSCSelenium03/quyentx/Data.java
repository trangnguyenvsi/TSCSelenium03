package com.vsii.tsc.TSCSelenium03.quyentx;

public class Data {

	static String loginURL = "http://newtours.demoaut.com/mercurysignon.php";
	static String loginExpectedTitle = "Welcome: Mercury Tours";
	static String loginSuccessExpectedURL = "http://newtours.demoaut.com/mercuryreservation.php";
	static String loginUnsuccessExpectedURL = "http://newtours.demoaut.com/mercurysignon.php";

	static String regSuccessURL = "http://newtours.demoaut.com/create_account_success.php";
	static String regUnsuccessURL = "http://newtours.demoaut.com/mercuryregister.php";
	
	static String findSuccessURL = "http://newtours.demoaut.com/mercuryreservation2.php";
	static String findUnsuccessURL = "http://newtours.demoaut.com/mercuryreservation.php";

	static String selectSuccessExpectedTitle = "Select a Flight: Mercury Tours";
	static String selectSuccessExpectedURL = "http://newtours.demoaut.com/mercurypurchase.php";

	static String bookSuccessExpectedURL = "http://newtours.demoaut.com/mercurypurchase2.php";
	
	static String bookUnsuccessExpectedURL = "http://newtours.demoaut.com/mercurypurchase.php";
}
