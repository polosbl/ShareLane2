package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShareLaneTest {
    // 1. Open browser, site https://www.sharelane.com/cgi-bin/register.py
    // 2. Enter value to ZIP code
    // 3. Click Continue button

    @Test
    public void fillZipCodeFieldTest() {
        int randomIntNumber;
        do {
            randomIntNumber = (int) (Math.random() * 100000);
        } while (randomIntNumber <= 9999);
        String randomNumber = Integer.toString(randomIntNumber);
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys(randomNumber);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='Continue']")).isDisplayed(),
                "Button 'Continue' is not displayed");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        driver.quit();
    }

    @Test
    public void clickRegisterButtonTest() {
        int randomIntNumber;
        do {
            randomIntNumber = (int) (Math.random() * 100000);
        } while (randomIntNumber <= 9999);
        String randomNumber = Integer.toString(randomIntNumber);
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys(randomNumber);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='Continue']")).isDisplayed(),
                "Button 'Continue' is not displayed");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='Register']")).isDisplayed(),
                "Button 'Register' is not displayed");
        driver.findElement(By.xpath("//*[@value='Register']")).click();
        WebElement element = driver.findElement(By.className("error_message"));
        Assert.assertEquals(element.getText(),
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Error text is incorrect");
        driver.quit();
    }

    @Test
    public void SignUpTest() {
        int randomIntNumber;
        do {
            randomIntNumber = (int) (Math.random() * 100000);
        } while (randomIntNumber <= 9999);
        String randomNumber = Integer.toString(randomIntNumber);
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys(randomNumber);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='Continue']")).isDisplayed(),
                "Button 'Continue' is not displayed");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        driver.findElement(By.name("first_name")).sendKeys("test");
        driver.findElement(By.name("last_name")).sendKeys("test");
        driver.findElement(By.name("email")).sendKeys("test" + randomNumber + "@test.com");
        driver.findElement(By.name("password1")).sendKeys("pass" + randomNumber);
        driver.findElement(By.name("password2")).sendKeys("pass" + randomNumber);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='Register']")).isDisplayed(),
                "Button 'Register' is not displayed");
        driver.findElement(By.xpath("//*[@value='Register']")).click();
        WebElement element = driver.findElement(By.className("confirmation_message"));
        Assert.assertEquals(element.getText(),
                "Account is created!",
                "Confirmation text is incorrect");
        driver.quit();
    }

    @Test
    public void typeSpacesOnly() {
        int randomIntNumber;
        do {
            randomIntNumber = (int) (Math.random() * 100000);
        } while (randomIntNumber <= 9999);
        String randomNumber = Integer.toString(randomIntNumber);
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys(randomNumber);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='Continue']")).isDisplayed(),
                "Button 'Continue' is not displayed");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        driver.findElement(By.name("first_name")).sendKeys(" ");
        driver.findElement(By.name("last_name")).sendKeys(" ");
        driver.findElement(By.name("email")).sendKeys(" ");
        driver.findElement(By.name("password1")).sendKeys(" ");
        driver.findElement(By.name("password2")).sendKeys(" ");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='Register']")).isDisplayed(),
                "Button 'Register' is not displayed");
        driver.findElement(By.xpath("//*[@value='Register']")).click();
        WebElement element = driver.findElement(By.className("error_message"));
        Assert.assertEquals(element.getText(),
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Error text is incorrect");
        driver.quit();
    }

    @Test
    public void enterIncorrectPassConfirmation() {
        int randomIntNumber;
        do {
            randomIntNumber = (int) (Math.random() * 100000);
        } while (randomIntNumber <= 9999);
        String randomNumber = Integer.toString(randomIntNumber);
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys(randomNumber);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='Continue']")).isDisplayed(),
                "Button 'Continue' is not displayed");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        driver.findElement(By.name("first_name")).sendKeys("test");
        driver.findElement(By.name("last_name")).sendKeys("test");
        driver.findElement(By.name("email")).sendKeys("test" + randomNumber + "@test.com");
        driver.findElement(By.name("password1")).sendKeys("pass" + randomNumber);
        driver.findElement(By.name("password2")).sendKeys("1pass" + randomNumber);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='Register']")).isDisplayed(),
                "Button 'Register' is not displayed");
        driver.findElement(By.xpath("//*[@value='Register']")).click();
        WebElement element = driver.findElement(By.className("error_message"));
        Assert.assertEquals(element.getText(),
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Error text is incorrect");
        driver.quit();
    }

    @Test
    public void enterIncorrectEmail() {
        int randomIntNumber;
        do {
            randomIntNumber = (int) (Math.random() * 100000);
        } while (randomIntNumber <= 9999);
        String randomNumber = Integer.toString(randomIntNumber);
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys(randomNumber);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='Continue']")).isDisplayed(),
                "Button 'Continue' is not displayed");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        driver.findElement(By.name("first_name")).sendKeys("test");
        driver.findElement(By.name("last_name")).sendKeys("test");
        driver.findElement(By.name("email")).sendKeys("test" + randomNumber + "@");
        driver.findElement(By.name("password1")).sendKeys("pass" + randomNumber);
        driver.findElement(By.name("password2")).sendKeys("pass" + randomNumber);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='Register']")).isDisplayed(),
                "Button 'Register' is not displayed");
        driver.findElement(By.xpath("//*[@value='Register']")).click();
        WebElement element = driver.findElement(By.className("error_message"));
        Assert.assertEquals(element.getText(),
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Error text is incorrect");
        driver.quit();
    }
}
