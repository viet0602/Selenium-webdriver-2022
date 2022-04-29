import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Check_Environment {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
		        "D:/Selenium/SeleniumWebdriver2022/Viet_SeleniumWebdriver2022/browserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}//
	@Test
	public void TC_01_ValidateCurrentUrl() {
		//Login Page URL matching
		String loginPageURL = driver.getCurrentUrl();
		Assert.assertEquals(loginPageURL, "https://demo.guru99.com/v4/");
	}
	@Test
	public void TC_01_ValidatePageTitle() {
		//Login Page URL matching
		String loginPageTitle = driver.getTitle();
		Assert.assertEquals(loginPageTitle, "Guru99 Bank Home Page");
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
