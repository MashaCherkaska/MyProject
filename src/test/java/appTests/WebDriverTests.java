package appTests;

import amazonDriverManagers.WebDriverCash;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class WebDriverTests {

    private static WebDriver driver;

    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();

    }

    @BeforeEach
    public void zooming() {
        driver.manage().window().maximize();
    }

    @Test
    public void unsuccessfulLogin() {
        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//*[@id='nav-link-accountList']")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement email = driver.findElement(By.xpath("//input[@id='ap_email']"));
        email.sendKeys("hi@gb.com");
        Assertions.assertTrue(email.isDisplayed());
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        String expected = "Amazon Sign-In";
        Assertions.assertEquals(expected,driver.getTitle());

    }

    @Test
    public void searchFields() {
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement searchField = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchField.click();
        searchField.sendKeys("hi");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        Assertions.assertFalse(driver.getCurrentUrl().contains("https://www.amazon.com/cart/"));
    }

    @Test
    public void addToCart() {
        driver.get("https://www.amazon.com/Solution-Exfoliating-Chemical-Exfoliant-Wrinkle-1/dp/B0BTCP5Q32/ref=sr_1_1_sspa?keywords=ordinary+aha+30+bha+2+peeling+solution+30ml&qid=1681497955&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUE1M05BWDZZU0dWS0ImZW5jcnlwdGVkSWQ9QTA1Mjk3MzcyMENPWDlUTDRCUTVaJmVuY3J5cHRlZEFkSWQ9QTAwNzIxNzcxMk04MjE1Qk5ENVlLJndpZGdldE5hbWU9c3BfYXRmJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ==");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.amazon.com/cart/smart-wagon"));
    }

    @AfterAll
    public static void driverQuit() {
        driver.quit();
    }
}












