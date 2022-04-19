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
		driver.findElement(By.xpath("//button[@type='submit' and text()='ĐĂNG KÝ']")).click();
		String firstNameError = driver.findElement(By.id("txtFirstname-error")).getText();
		Assert.assertEquals(firstNameError, "Vui lòng nhập họ tên");
		String txtEmailError = driver.findElement(By.id("txtEmail-error")).getText();
		Assert.assertEquals(txtEmailError, "Vui lòng nhập email");
		String txtCEmailError = driver.findElement(By.id("txtCEmail-error")).getText();
		Assert.assertEquals(txtCEmailError, "Vui lòng nhập lại địa chỉ email");
		String txtPasswordError = driver.findElement(By.id("txtPassword-error")).getText();
		Assert.assertEquals(txtPasswordError, "Vui lòng nhập mật khẩu");
		String txtCPasswordError = driver.findElement(By.id("txtCPassword-error")).getText();
		Assert.assertEquals(txtCPasswordError, "Vui lòng nhập lại mật khẩu");
		String txtPhoneError = driver.findElement(By.id("txtPhone-error")).getText();
		Assert.assertEquals(txtPhoneError, "Vui lòng nhập số điện thoại.");
	}


	public void TC_01_ValidatePageTitle() {
		// Login Page URL matching
		String loginPageTitle = driver.getTitle();
		Assert.assertEquals(loginPageTitle, "Guru99 Bank Home Page");
	}

	
	public void afterClass() {
		driver.quit();
	}
}
