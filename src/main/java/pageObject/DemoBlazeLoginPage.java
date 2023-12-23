package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoBlazeLoginPage {
	public WebDriver driver;

	public DemoBlazeLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='signin2']")
	private WebElement signup;

	@FindBy(xpath = "//input[@id='sign-username']")
	private WebElement signInusername;

	@FindBy(xpath = "//input[@id='sign-password']")
	private WebElement signInPassword;

	@FindBy(xpath = "//input[@id='loginusername']")
	private WebElement loginusername;

	@FindBy(xpath = "//input[@id='loginpassword']")
	private WebElement loginPassword;

	@FindBy(xpath = "//button[text()='Sign up']")
	private WebElement signupButton;

	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement loginButton;

	@FindBy(xpath = "//a[text()='Log in']")
	private WebElement loginPage;

	@FindBy(xpath = "//a[@id='nameofuser']")
	private WebElement nameUserText;

	public void clicksignupPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(signup));
	}

	public void inputSigninUserName(String username) {
		signInusername.sendKeys(username);
	}

	public void inputSigninPassword(String password) {
		signInPassword.sendKeys(password);
	}

	public void clicksignupButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(signupButton));
	}

	public void clickLoginPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(loginPage));
	}

	public void inputLoginUserName(String username) {
		loginusername.sendKeys(username);
	}

	public void inputLoginPassword(String password) {
		loginPassword.sendKeys(password);
	}

	public void clickLoginButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(signupButton));
	}

	public String getUserNameText() {
		String text = nameUserText.getText();
		return text;
	}

}
