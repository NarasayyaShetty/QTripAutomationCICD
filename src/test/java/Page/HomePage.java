package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Util.SeleniumUtil.*;

import java.time.Duration;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
	}
	
	private final String HOME_PAGE_END_POINTS="https://qtripdynamic-qa-frontend.vercel.app/";
	
	@FindBy(tagName="h1")
	private WebElement welComeText;
	
	@FindBy(linkText ="Register")
	private WebElement registerButton;
	
	public boolean homePageValidation() {
		boolean flag=false;
		
		if(validateText(welComeText,"Welcome to QTrip")) {
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}
	
	public boolean clickOnRegistarButton() {
		boolean flag=false;
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		try {
			registerButton.click();
			flag=true;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception is occured during the clicking on register button");
			flag=false;
		}
		return flag;
	}

}
