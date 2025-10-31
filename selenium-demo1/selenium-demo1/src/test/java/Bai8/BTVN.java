package Bai8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class BTVN {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testLovateElements() throws InterruptedException {
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement userEmail = driver.findElement(By.name("email"));
		userEmail.sendKeys("ABC");
		WebElement password = driver.findElement(By.name("Password"));
		password.sendKeys("123456");
		WebElement company = driver.findElement(By.name("company"));
		company.sendKeys("ctyabc");
		WebElement mobileNumber = driver.findElement(By.name("mobile number"));
		mobileNumber.sendKeys("0985552012");
		WebElement country = driver.findElement(By.xpath("//label[normalize-space()='Country']//input[@type='text']"));
		country.sendKeys("0985552012");
		WebElement submitBtn = driver.findElement(By.xpath("//button[@value='Submit']"));
		submitBtn.click();
		Thread.sleep(2000);
		System.out.println("✅ Test locate element thành công");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
