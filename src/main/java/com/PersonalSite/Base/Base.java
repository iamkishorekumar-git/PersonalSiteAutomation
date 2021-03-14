package com.PersonalSite.Base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{


	public WebDriver driver;
	public static Properties prop;

	/**
	 * @return 
	 * @Author : Kishore Kumar S
	 * @Date :8/03/2021
	 * @Description: This function implements the multiple broswers get the value
	 *               from Test file as paramaters
	 */
	public WebDriver invokeBrowser(String browserName) {


		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);

		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\resources\\ObjectRepo\\config.properties");
				prop.load(file);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return driver;
	}
	
	
}
