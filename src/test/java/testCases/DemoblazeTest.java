package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import baseAndCommonFunctions.BaseClass;
import pageObject.DemoBlazeLoginPage;

public class DemoblazeTest extends BaseClass {

	@Test
	public void DemoblazeTest() {
		DemoBlazeLoginPage Demoblazepage = new DemoBlazeLoginPage(driver);
		Demoblazepage.clicksignupPage();
		Demoblazepage.inputSigninUserName(prop.getProperty("userName"));
		Demoblazepage.inputSigninPassword(prop.getProperty("password"));
		Demoblazepage.clicksignupButton();
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		alert.accept();
		assertEquals(message, "Sign up successful.");
		Demoblazepage.clickLoginPage();
		Demoblazepage.inputLoginUserName(prop.getProperty("userName"));
		Demoblazepage.inputLoginPassword(prop.getProperty("password"));
		Demoblazepage.clickLoginButton();
		assertEquals(Demoblazepage.getUserNameText(), "Welcome" + prop.getProperty("userName"));
	}

}
