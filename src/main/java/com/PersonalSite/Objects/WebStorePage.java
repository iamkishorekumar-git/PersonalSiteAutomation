package com.PersonalSite.Objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class WebStorePage 
{
	public static void backToHomePage(WebDriver driver)
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.history.go(-1)");
	}
	
}
