import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebElement {
	WebDriver driver;
	By emailLocator = By.cssSelector("[id='mail']");
	By under18Locator = By.cssSelector("[id='under_18']");
	By educationLocator = By.cssSelector("[id='edu']");
	By image5HoverText = By.xpath("//img[@alt='User Avatar 05']/parent::div//h5[text()='Name: User5']");
	By jobRol1 = By.cssSelector("[id='job1']");
	By jobRol2 = By.cssSelector("[id='job2']");
	By developmentCheckBox = By.cssSelector("[id='development']");
	By slide1 = By.cssSelector("[id='slider-1']");

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
		Assert.assertFalse(driver.findElement(image5HoverText).isDisplayed());
	}

	@Test
	public void TC_02_isEnable() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		Assert.assertTrue(driver.findElement(emailLocator).isEnabled());
		Assert.assertTrue(driver.findElement(under18Locator).isEnabled());
		Assert.assertTrue(driver.findElement(educationLocator).isEnabled());
		Assert.assertTrue(driver.findElement(jobRol1).isEnabled());
		Assert.assertTrue(driver.findElement(jobRol2).isEnabled());
		Assert.assertTrue(driver.findElement(developmentCheckBox).isEnabled());
		Assert.assertTrue(driver.findElement(slide1).isEnabled());
	}
	
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
