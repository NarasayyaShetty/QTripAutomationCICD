package Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static Util.DriverSingleTon.*;

public class BaseTest {
	
	public WebDriver driver;
	@BeforeTest(alwaysRun=true)
	@Parameters({"browserName"})
	public void setup(String browserName) {
		driver=getDriver(browserName);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		launchUrl(driver,"https://qtripdynamic-qa-frontend.vercel.app/");
		
	}

}
