import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login_Xpath_CSS {
	WebDriver driver;

	String invalidEmail = "123434234@12312.123123123";
	String validPassWord = "123456";
	String validEmail = "automation@gmail.com";
	String registerEmail = "automationtesting_vic@gmail.com";
	String firstName = "Automation";
	String lastName = "Testing";

	// By MyAccount_Footer = By.xpath("//div[@class='footer-container']//a[@title='My Account']");
	By MyAccount_Footer_Link_Text = By.cssSelector("[class='footer-container'] [title='My Account']");
	By Email_TextBox = By.id("email");
	By PassWord_TextBox = By.id("pass");
	By Login_Button = By.id("send2");
	By Email_Error_Text = By.id("advice-required-entry-email");
	By PassWord_Error_Text = By.id("advice-required-entry-pass");
	By Error_Message_Text = By.xpath("//li[@class='error-msg' ]//li");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "D:/Selenium/SeleniumWebdriver2022/Viet_SeleniumWebdriver2022/browserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test
	public void TC_01_LoginWithEmptyEmailAndPassWord() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(MyAccount_Footer_Link_Text).click();
		driver.findElement(Email_TextBox).sendKeys("");
		driver.findElement(PassWord_TextBox).sendKeys("");
		driver.findElement(Login_Button).click();
		Assert.assertTrue(driver.findElement(Email_Error_Text).isDisplayed(), "This is a required field.");
		Assert.assertTrue(driver.findElement(PassWord_Error_Text).isDisplayed(), "This is a required field.");
	}
	@Test
	public void TC_02_LoginWithInvalidEmail() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(MyAccount_Footer_Link_Text).click();
		driver.findElement(Email_TextBox).sendKeys(invalidEmail);
		driver.findElement(PassWord_TextBox).sendKeys(validPassWord);
		driver.findElement(Login_Button).click();
		Assert.assertTrue(driver.findElement(By.id("advice-validate-email-email")).isDisplayed(), "Please enter a valid email address. For example johndoe@domain.com.");

	}
	@Test
	public void TC_03_LoginWithPassWordLessThan6Chars() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(MyAccount_Footer_Link_Text).click();
		driver.findElement(Email_TextBox).sendKeys(validEmail);
		driver.findElement(PassWord_TextBox).sendKeys("123");
		driver.findElement(Login_Button).click();
		Assert.assertTrue(driver.findElement(By.id("advice-validate-password-pass")).isDisplayed(), "Please enter 6 or more characters without leading or trailing spaces.");

	}

	@Test
	public void TC_04_LoginWithIncorrectEmailAndPassWord() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(MyAccount_Footer_Link_Text).click();
		driver.findElement(Email_TextBox).sendKeys(validEmail);
		driver.findElement(PassWord_TextBox).sendKeys("123123123");
		driver.findElement(Login_Button).click();
		Assert.assertEquals(driver.findElement(Error_Message_Text).getText(), "Invalid login or password.");

	}

	public void TC_05_CreateANewAccount() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(MyAccount_Footer_Link_Text).click();
		driver.findElement(By.cssSelector("[title='Create an Account']"));
		driver.findElement(By.id("firstname")).sendKeys("Automation");
		driver.findElement(By.id("middlename")).sendKeys("Thi");
		driver.findElement(By.id("lastname")).sendKeys("Testing");
		driver.findElement(By.id("email_address")).sendKeys(registerEmail);
		driver.findElement(By.id("password")).sendKeys(validPassWord);
		driver.findElement(By.id("confirmation")).sendKeys(validPassWord);
		driver.findElement(By.id(""));
	}

	public void TC_06_LoginWithValidEmailAndPassword() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	public int random() {
		Random rand = new Random();
		return rand.nextInt(999999);
		
	}
}
