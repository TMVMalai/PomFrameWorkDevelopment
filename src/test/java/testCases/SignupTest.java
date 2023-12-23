package testCases;

import org.testng.annotations.Test;

import baseAndCommonFunctions.BaseClass;
import pageObject.SignupPage;


public class SignupTest extends BaseClass{
	
	@Test
	public void signup() {
		SignupPage signup = new SignupPage(driver);
		signup.userName(prop.getProperty("userName"));
		signup.password(prop.getProperty("password"));
		signup.loginButton();
	}

}
