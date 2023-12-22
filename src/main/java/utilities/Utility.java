package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utility {
	public static WebDriver driver;
	public Properties prop;
	// develop a functionality for browser selection

	public WebDriver initialization() throws IOException {
		// use the properties from data.properties
		prop = new Properties();
		// path to property
		String propath = System.getProperty("user.dir")
				+ "/Users/thirumalaivasanperumal/eclipse-workspace/PomFrameWorkDevelopment/src/main/java/resources/Data.properties";
		FileInputStream fis = new FileInputStream(propath);
		prop.load(fis);
		String browserchoice = prop.getProperty("browser");
		if (browserchoice.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserchoice.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserchoice.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Invalid Browser Selection");
			System.exit(1);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return null;

	}

	// Add Functionality to capture ScreenShot
	public String TakeScreenShot(String testname, WebDriver driver) throws IOException {
		File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshot = System.getProperty("user.dir") + "\\Screenshot\\" + testname + ".png";
		FileUtils.copyFile(srcScreenshot, new File(screenshot));
		return screenshot;

	}

	public static void SwitchWindow() {
		String ParentWindow = driver.getWindowHandle();
		Set<String> windowhandle = driver.getWindowHandles();
		for (String childwindow : windowhandle) {
			if (!childwindow.contentEquals(ParentWindow)) {
				driver.switchTo().window(childwindow);
			}

		}
	}

	public static WebElement waitforElementTobeClickable(By locator, int timeoutSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

}
