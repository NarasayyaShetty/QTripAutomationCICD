package Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleTon {
	
	private static WebDriver driver=null;
	
	private DriverSingleTon() {}
	
	public static WebDriver getDriver(String browserName) {
		if(driver==null) {
			switch(browserName) {
			case "chrome":
				ChromeOptions option=new ChromeOptions();
				option.addArguments("--incognito");
				driver=new ChromeDriver(option);
				break;
			case "firefox":
				driver=new FirefoxDriver();
				break;
				
			default:
				throw new IllegalArgumentException("Please enter correct browser name...");
			}
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void launchUrl(WebDriver driver, String url) {
		if(driver.getCurrentUrl()!=url) {
			driver.get(url);
		}
	}

}
