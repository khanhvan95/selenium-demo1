package Bai8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class B1Test {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        // webdrivermanager sẽ tự download driver phù hợp
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLocateElements() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.className("submit-button"));
        loginBtn.click();

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

