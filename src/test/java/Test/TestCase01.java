package Test;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Page.HomePage;
import Page.LoginPage;
import Page.RegistarPage;
import Util.DataBaseConnection;
import Util.DataBaseConnection1;



public class TestCase01 extends BaseTest{
	
	String email;
	String password;
	HomePage hp;
	RegistarPage rp;
	LoginPage lp;
	
	
	@BeforeClass(alwaysRun=true)
	public void getUserData() {
		DataBaseConnection1 db=new DataBaseConnection1();
		try {
			hp=new HomePage(driver);
			rp=new RegistarPage(driver);
			lp=new LoginPage(driver);
			db.setData();
			email=db.getData("email");
			System.out.println(email);
			password=db.getData("password");
			System.out.println(password);
		}catch(Exception e) {
			System.out.println("Exception occured during the fetching user data");
		}
	}
	
	@Test(description="Login to the application",priority=1)
	public void regstration()  {
		boolean status=false;
		System.out.println("Testcase01 start");
		status=hp.clickOnRegistarButton();
		Assert.assertTrue(status,"Unable to click on Register button");
		status=rp.validateRegisterPage();
		Assert.assertTrue(status,"Register field is not visible");
		
		//New registration
		status=rp.makeNewRegstration(email, password);
		Assert.assertTrue(status,"New registration is failed");
		
		//Login with existing credentials
		status=lp.validateLoginPage();
		Assert.assertTrue(status,"Login page navigation is failed");
		status=lp.makeLogin(email, password);
		Assert.assertTrue(status,"Login is failed");
		
		
	}

}
