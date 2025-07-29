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
public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
	}
	
	@FindBy(css="h2.formtitle")
	private WebElement loginTextField;
	
	@FindBy(name="email")
	private WebElement emailField;
	
	@FindBy(name="password")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[normalize-space(text())='Login to QTrip']")
	private WebElement loginButton;
	
	public boolean validateLoginPage() {
		boolean flag=false;
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlContains("/pages/login"));
		wait.until(ExpectedConditions.visibilityOf(loginTextField));
		try {
			
			flag=validateText(loginTextField,"Login");
		}catch(Exception e) {
			System.out.println("Exception occured during the login text");
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
	
	public boolean makeLogin(String email,String password) {
		boolean flag=false;
		try {
			passTextOnTextField(emailField, email);
			passTextOnTextField(passwordField,password);
			elementClick(driver,loginButton);
			flag=true;
			
		}catch(Exception e) {
			System.out.println("Exception is occured during login");
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
	

}
