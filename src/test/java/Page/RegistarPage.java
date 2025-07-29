package Page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static Util.SeleniumUtil.*;

public class RegistarPage {
	
	WebDriver driver;
	
	public RegistarPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
	}
	
	@FindBy(css="h2.formtitle")
	private WebElement registerTextElement;
	
	@FindBy(id="floatingInput")
	private WebElement emailField;
	
	@FindBy(name="password")
	private WebElement passwordField;
	
	@FindBy(name="confirmpassword")
	private WebElement confirmPasswordField;
	
	@FindBy (xpath="//button[normalize-space(text())='Register Now']")
	private WebElement registerButton;
	
	public boolean validateRegisterPage() {
		boolean flag=false;
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.urlContains("/register"));
			wait.until(ExpectedConditions.visibilityOf(registerTextElement));
			flag=validateText(registerTextElement,"Register");
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured during validateRegisterPage");
			flag=false;
		}
		return flag;
	}
	public boolean makeNewRegstration(String email,String password) {
		boolean flag=false;
		try {
			passTextOnTextField(emailField,email);
			passTextOnTextField(passwordField,password);
			passTextOnTextField(confirmPasswordField,password);
			elementClick(driver,registerButton);
			flag=true;
			
		}catch(Exception e) {
			System.out.println("Exception occured during making new regstration");
			flag=false;
		}
		return flag;
	}

}
