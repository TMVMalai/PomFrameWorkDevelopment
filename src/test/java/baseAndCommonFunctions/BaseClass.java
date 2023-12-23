package baseAndCommonFunctions;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.UtilityClass;

public class BaseClass extends UtilityClass {
	//write code for starting and closing of the browser
	
	@BeforeMethod
	public void startup() throws IOException {
		driver = initialization();
		driver.get(prop.getProperty("url"));
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}

}
