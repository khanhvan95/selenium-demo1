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

public class BTVN2 {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testLovateElements() throws InterruptedException {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("ABC");
		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys("HN");
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("ctyabc@gmail.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("123456");
		WebElement submitBtn = driver.findElement(By.xpath("//button[@value='Submit']"));
		submitBtn.click();
		Thread.sleep(5000);
		System.out.println("✅ Test locate element thành công");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
