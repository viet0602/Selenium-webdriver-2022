
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebBrowserElement {
	WebDriver driver;
	By MyAccount_Footer_Link_Text = By.cssSelector("[class='footer-container'] [title='My Account']");
	By Create_An_Account_Button = By.cssSelector("[title='Create an Account']");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "D:/Selenium/SeleniumWebdriver2022/Viet_SeleniumWebdriver2022/browserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_VerifyUrl() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(MyAccount_Footer_Link_Text).click();
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
		driver.findElement(Create_An_Account_Button).click();
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
	}

	@Test
	public void TC_02_VerifyTitle() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(MyAccount_Footer_Link_Text).click();
		Assert.assertEquals(driver.getTitle(), "Customer Login");
		driver.findElement(Create_An_Account_Button).click();
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	}

	@Test
	public void TC_03_NavigateFunction() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(MyAccount_Footer_Link_Text).click();
		driver.findElement(Create_An_Account_Button).click();
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
		driver.navigate().back();
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
		driver.navigate().forward();
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
