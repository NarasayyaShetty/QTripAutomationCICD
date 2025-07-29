package Util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtil {
	
	public static boolean validateText(WebElement element, String expected) {
		boolean flag=false;
		try {
			if(element.getText().equalsIgnoreCase(expected)) {
				System.out.println(element.getText());
				flag=true;
			}
			
		}catch(Exception e) {
			System.out.println("Exception occured during the validating the text");
			flag=false;
		}
		return flag;
	}
	
	public static void elementClick(WebDriver driver,WebElement element) {
		try {
			Actions action=new Actions(driver);
			action.moveToElement(element).click(element).perform();
				element.click();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception is occured durin the element click");
		}
	}
	
	public static void passTextOnTextField(WebElement element, String text) {
		try {
			element.clear();
			element.sendKeys(text);
		}catch(Exception e) {
			System.out.println("Exception occured during the sending the keys : "+text);
		}
	}

}
