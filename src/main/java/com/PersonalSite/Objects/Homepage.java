package com.PersonalSite.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.PersonalSite.Base.Base;

public class Homepage extends Base
{

	
	public static void openURL(WebDriver driver)
	{	
		
		driver.get(prop.getProperty("websiteURLKey"));
		
	}
	
	public static WebElement getAboutMe(WebDriver driver)
	{
		
		return driver.findElement(By.className("top_30"));
		
	}
	
	public static void scrollUntilProduct(WebDriver driver)
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement productElement = driver.findElement(By.xpath("//*[contains(text(),'Product')]"));
		je.executeScript("arguments[0].scrollIntoView(true);",productElement);	
	}
	
	public static WebElement clickAddToChromeBtn(WebDriver driver) throws InterruptedException
	{	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"awards\"]/section[2]/ul/button")));
		return driver.findElement(By.xpath("//*[@id=\"awards\"]/section[2]/ul/button"));
	}
	
	public static void hoverTheProfilePic(WebDriver driver)
	{
        Actions action = new Actions(driver);

        WebElement hoverProfile = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[2]"));  
        WebElement hoverAboutMe = driver.findElement(By.xpath("//*[@id=\"home\"]/div[1]/section/div/h2")); 
        
        action.moveToElement(hoverProfile).build().perform();
        action.moveToElement(hoverAboutMe).build().perform();
        action.moveToElement(hoverProfile).build().perform();
        action.moveToElement(hoverAboutMe).build().perform();
	}
	
	public static WebElement clickGithubIcon(WebDriver driver) 
	{
		return driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[3]/a[1]"));
	}
	
	public static void closePage(WebDriver driver)
	{
		driver.close();
	}
	
	
}
