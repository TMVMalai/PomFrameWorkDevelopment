package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {
	public WebDriver driver;
	
	public SignupPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='email']")
	private WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement passWord;
	
	@FindBy(xpath="//a[@id='login-btn']")
	private WebElement loginButton;
	//a[text()='Sign up']
	
	public void userName(String userName) {
		username.sendKeys(userName);
	}
	
	public void password(String Password) {
		passWord.sendKeys(Password);
	}
	public void loginButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
	}
	

}
