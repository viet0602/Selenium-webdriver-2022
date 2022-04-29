import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebElement {
	WebDriver driver;
	By emailLocator = By.cssSelector("[id='mail']");
	By under18Locator = By.cssSelector("[id='under_18']");
	By educationLocator = By.cssSelector("[id='edu']");
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "D:/Selenium/SeleniumWebdriver2022/Viet_SeleniumWebdriver2022/browserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_isDisplay() {	
		driver.get("https://automationfc.github.io/basic-form/index.html");
		Assert.assertTrue(driver.findElement(emailLocator).isDisplayed());
		driver.findElement(emailLocator).sendKeys("afsdfasfd@gmail.com");
		Assert.assertTrue(driver.findElement(under18Locator).isDisplayed());
		driver.findElement(under18Locator).click();
		Assert.assertTrue(driver.findElement(educationLocator).isDisplayed());
		driver.findElement(educationLocator).sendKeys("Hanu university");
	}

}
