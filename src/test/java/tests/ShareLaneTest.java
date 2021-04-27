package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShareLaneTest {
    // 1. Open browser, site https://www.sharelane.com/cgi-bin/register.py
    // 2. Enter value to ZIP code
    // 3. Click Continue button

    @Test
    public void fillZipCodeFieldTest() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys(Integer.toString((int) (Math.random() * 1000000)));
        driver.findElement(By.xpath("//*[@value='Continue']")).click();

//        driver.quit();
    }

    @Test
    public void clickRegisterButtonTest() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys(Integer.toString((int) (Math.random() * 1000000)));
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        driver.findElement(By.xpath("//*[@value='Register']")).click();
// тут надо проверить сообщение об ошибке
//        driver.quit();
    }

    @Test
    public void SignUpTest() {
        String randomNumber = Integer.toString((int) (Math.random() * 100000));
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys(Integer.toString((int) (Math.random() * 100000)));
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        driver.findElement(By.name("first_name")).sendKeys("test");
        driver.findElement(By.name("last_name")).sendKeys("test");
        driver.findElement(By.name("email")).sendKeys("test" + randomNumber + "@test.com");
        driver.findElement(By.name("password1")).sendKeys("pass" + randomNumber);
        driver.findElement(By.name("password2")).sendKeys("pass" + randomNumber);
        driver.findElement(By.xpath("//*[@value='Register']")).click();
// тут надо проверить результат111
        // feature_lesson5
        // Added comment12
//        driver.quit();
    }
}
