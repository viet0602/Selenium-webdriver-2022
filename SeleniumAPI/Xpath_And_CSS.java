import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Xpath_And_CSS {
	WebDriver driver;

	String invalidEmail = "safsdf@email@email";
	String fullName = "Lam Testing";
	String validEmail = "testing233@mailcreator.com";
	String validPassword = "123456";
	String validPhone = "0987123456";

	By fullNameTextBox = By.id("txtFirstname");
	By fullNameErrorText = By.id("txtFirstname-error");
	By emailTextBox = By.id("txtEmail");
	By emailTextErrorText = By.id("txtEmail-error");
	By emailConfirmTextBox = By.id("txtCEmail");
	By emailAgainErrorText = By.id("txtCEmail-error");
	By passwordTextBox = By.id("txtPassword");
	By passwordErrorText = By.id("txtPassword-error");
	By passwprdConfirmTextBox = By.id("txtCPassword");
	By passwprdConfirmErrorText = By.id("txtCPassword-error");
	By phoneTextBox = By.id("txtPhone");
	By phoneTextErrorText = By.id("txtPhone-error");
	By registerButton = By.xpath("//button[@type='submit' and text()='ĐĂNG KÝ']");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"D:/Selenium/SeleniumWebdriver2022/Viet_SeleniumWebdriver2022/browserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_RegisterWithEmptyData() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(registerButton).click();
		String firstNameError = driver.findElement(fullNameErrorText).getText();
		Assert.assertEquals(firstNameError, "Vui lòng nhập họ tên");
		String txtEmailError = driver.findElement(emailTextErrorText).getText();
		Assert.assertEquals(txtEmailError, "Vui lòng nhập email");
		String txtCEmailError = driver.findElement(emailAgainErrorText).getText();
		Assert.assertEquals(txtCEmailError, "Vui lòng nhập lại địa chỉ email");
		String txtPasswordError = driver.findElement(passwordErrorText).getText();
		Assert.assertEquals(txtPasswordError, "Vui lòng nhập mật khẩu");
		String txtCPasswordError = driver.findElement(passwprdConfirmErrorText).getText();
		Assert.assertEquals(txtCPasswordError, "Vui lòng nhập lại mật khẩu");
		String txtPhoneError = driver.findElement(phoneTextErrorText).getText();
		Assert.assertEquals(txtPhoneError, "Vui lòng nhập số điện thoại.");
	}

	@Test
	public void TC_02_RegisterWithInvalidEmail() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(fullNameTextBox).sendKeys(fullName);
		driver.findElement(emailTextBox).sendKeys("hihihi@gmail@789");
		driver.findElement(emailConfirmTextBox).sendKeys("hihihi@gmail@789");
		driver.findElement(passwordTextBox).sendKeys(validPassword);
		driver.findElement(passwprdConfirmTextBox).sendKeys(validPassword);
		driver.findElement(phoneTextBox).sendKeys(validPhone);
		driver.findElement(registerButton).click();
		String emailInvalidError = driver.findElement(emailTextErrorText).getText();
		String emailInvalidAgainError = driver.findElement(emailAgainErrorText).getText();
		Assert.assertEquals(emailInvalidError, "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(emailInvalidAgainError, "Email nhập lại không đúng");
	}

	@Test
	public void TC_03_RegisterWithInCorrectConfirmEmail() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(fullNameTextBox).sendKeys(fullName);
		driver.findElement(emailTextBox).sendKeys(validEmail);
		driver.findElement(emailConfirmTextBox).sendKeys("hihihi@gmail.com");
		driver.findElement(passwordTextBox).sendKeys(validPassword);
		driver.findElement(passwprdConfirmTextBox).sendKeys(validPassword);
		driver.findElement(phoneTextBox).sendKeys(validPhone);
		driver.findElement(registerButton).click();
		String emailInvalidConfirmError = driver.findElement(emailAgainErrorText).getText();
		Assert.assertEquals(emailInvalidConfirmError, "Email nhập lại không đúng");
	}

	@Test
	public void TC_04_RegisterWithPassWordLessthan6Chars() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(fullNameTextBox).sendKeys(fullName);
		driver.findElement(emailTextBox).sendKeys(validEmail);
		driver.findElement(emailConfirmTextBox).sendKeys(validEmail);
		driver.findElement(passwordTextBox).sendKeys("12345");
		driver.findElement(passwprdConfirmTextBox).sendKeys("12345");
		driver.findElement(phoneTextBox).sendKeys(validPhone);
		driver.findElement(registerButton).click();
		String passWordInvalidError = driver.findElement(passwordErrorText).getText();
		Assert.assertEquals(passWordInvalidError, "Mật khẩu phải có ít nhất 6 ký tự");
		String passWordConfirmInvalidError = driver.findElement(passwprdConfirmErrorText).getText();
		Assert.assertEquals(passWordConfirmInvalidError, "Mật khẩu phải có ít nhất 6 ký tự");
	}

	@Test
	public void TC_05_RegisterWithIncorrectConfirmPassWord() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(fullNameTextBox).sendKeys(fullName);
		driver.findElement(emailTextBox).sendKeys(validEmail);
		driver.findElement(emailConfirmTextBox).sendKeys(validEmail);
		driver.findElement(passwordTextBox).sendKeys("12345678");
		driver.findElement(passwprdConfirmTextBox).sendKeys("12345876");
		driver.findElement(phoneTextBox).sendKeys(validPhone);
		driver.findElement(registerButton).click();
		String passWordConfirmInvalidError = driver.findElement(passwprdConfirmErrorText).getText();
		Assert.assertEquals(passWordConfirmInvalidError, "Mật khẩu bạn nhập không khớp");
	}

	@Test
	public void TC_06_RegisterWithInValidPhoneNumber() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(fullNameTextBox).sendKeys(fullName);
		driver.findElement(emailTextBox).sendKeys(validEmail);
		driver.findElement(emailConfirmTextBox).sendKeys(validEmail);
		driver.findElement(passwordTextBox).sendKeys(validPassword);
		driver.findElement(passwprdConfirmTextBox).sendKeys(validPassword);
		driver.findElement(phoneTextBox).sendKeys("1236547");
		driver.findElement(registerButton).click();
		String phoneNumberInvalidError = driver.findElement(phoneTextErrorText).getText();
		Assert.assertEquals(phoneNumberInvalidError, "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
