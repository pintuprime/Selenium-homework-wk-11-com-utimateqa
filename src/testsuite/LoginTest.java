package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    static String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        WebElement signLink = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        signLink.click();
        String expectedText = "Welcome Back!";
        WebElement actualTextelement = driver.findElement(By.xpath("//h2[@class='page__heading']"));
        String actualText = actualTextelement.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessage() {
        WebElement signLink = driver.findElement(By.linkText("Sign In"));
        signLink.click();
        WebElement userName = driver.findElement(By.name("user[email]"));
        userName.sendKeys("Ab@2gmail");
        WebElement password = driver.findElement(By.id("user[password]"));
        password.sendKeys("223444");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        String expectedText = "Please enter a valid email address";
        WebElement actualTextElement = driver.findElement(By.xpath("//p[@aria-live='polite']"));
        String actualText = actualTextElement.getText();
        //verify expected and actual text
        Assert.assertEquals(expectedText, actualText);
    }
    @After
    public void tearDown() {
         driver.quit();
    }
}
