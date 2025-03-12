package basePackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public enum BrowserTypes {
		CHROME,
		FIREFOX;
	}
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	@BeforeSuite
	public void initialSetUp() {
		
	}
	
	@Parameters({"browserName"})
	@BeforeMethod
	public void setUp(String browserName) {
		BrowserTypes browser = BrowserTypes.valueOf(browserName.toUpperCase());
		try {
		switch(browser) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			break;
		default:
			Reporter.log("Invalid browser name provided");
			throw new IllegalArgumentException();
			
		}
		getDriver().get("https://www.google.com");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		}
		catch(Exception e) {
			Reporter.log("Exception encountered during browser and application launch"+e.getMessage());
		}
	}
	
	@AfterMethod
	public void cleanUp() {
		if(getDriver()!=null) {
			getDriver().quit();
			driver.remove();
		}
	}

}
