package com.PersonalSite.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.PersonalSite.Base.Base;
import com.PersonalSite.Objects.Homepage;
import com.PersonalSite.Objects.WebStorePage;


public class HomePageTest extends Base
{

	WebDriver driver;

	@BeforeTest()
	public WebDriver setup()	{
		driver=invokeBrowser("chrome");
		return driver;
	}
	
	@Test(priority = 1)
	public void vertifyTitle()
	{
		Homepage.openURL(driver);
		assertEquals("Kishore Kumar", driver.getTitle());
	}
	
	@Test(priority = 2)
	public void getAboutMeMessage()
	{
		String abtMsg= Homepage.getAboutMe(driver).getText();
		System.out.println(abtMsg);
	}
	
	@Test(priority = 3)
	public void hoverProfileImage()
	{
		Homepage.hoverTheProfilePic(driver);
	}
	
	@Test(priority = 4)
	public void verifyGithubIcon()
	{
		Homepage.clickGithubIcon(driver).click();
	}
	

	public void verifyAddToChrome() throws InterruptedException
	{
		Homepage.scrollUntilProduct(driver);
		Homepage.clickAddToChromeBtn(driver).click();
	}
	
	public void verifyChromeExtensionPage()
	{
		assertEquals("Chrome Web Store - Extensions", driver.getTitle());
		WebStorePage.backToHomePage(driver);
	}
	
	

	public void tearDown()
	{
		Homepage.closePage(driver);
	}
	

	

	
}
