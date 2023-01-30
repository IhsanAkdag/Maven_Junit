package _automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test02 {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://automationexercise.com");
    }

    //Click on 'Signup / Login' button -----------------(method)------------------
    public void clickSignup(){
        driver.findElement(By.xpath("//*[@href='/login']")).click();
    }

    //Enter correct email address and password and login -----------------(method)------------------
    public void enterEmailPass(){
        WebElement email = driver.findElement(By.xpath("//*[@data-qa='login-email']"));
        email.sendKeys("akdagihsan66@gmail.com");
        WebElement password = driver.findElement(By.xpath("//*[@data-qa='login-password']"));
        password.sendKeys("ihsan.85");
    }

    //click login button -----------------(method)------------------
    public void clickLoginButton(){
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();
    }

    //Click 'Delete Account' button  -----------------(method)------------------
    public void clickDeleteButton(){
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
    }

    //Verify that home page is visible successfully
    @Test
    public void verifyHomePage() {
        WebElement logo = driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());
    }

    // Verify 'Login to your account' is visible
    @Test
    public void verifSingup() {
        clickSignup();

        WebElement loginVisible = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(loginVisible.isDisplayed());
    }

    //Verify that 'Logged in as username' is visible
    @Test
    public void verifyLogged(){
        clickSignup();
        enterEmailPass();
        clickLoginButton();

        WebElement looggedInAs = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        WebElement username = driver.findElement(By.xpath("//*[text()='ihsn']"));
        Assert.assertTrue(looggedInAs.isDisplayed() & username.isDisplayed());
    }

    //Verify that 'ACCOUNT DELETED!' is visible
    @Test
    public void verifyAccoundDeleted(){
        clickSignup();
        enterEmailPass();
        clickDeleteButton();

        //Verify that 'ACCOUNT DELETED!' is visible
        WebElement accountText=driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        Assert.assertTrue((accountText.isDisplayed()));
    }

    @After
    public void tearDown(){
        driver.close();
    }
}


