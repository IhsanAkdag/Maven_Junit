package _automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test10 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());

//        4. Scroll down to footer
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        Thread.sleep(2000);

//        5. Verify text 'SUBSCRIPTION'
        String textSub= driver.findElement(By.xpath("//*[text()='Subscription']")).getText();
        Assert.assertEquals("SUBSCRIPTION",textSub);
        Thread.sleep(2000);

//        6. Enter email address in input and click arrow button
        driver.findElement(By.xpath("//*[@id='susbscribe_email']")).sendKeys("abc@gmail.com", Keys.ENTER);
        Thread.sleep(2000);

//        7. Verify success message 'You have been successfully subscribed!' is visible
        String textSucces= driver.findElement(By.xpath("//*[@class='alert-success alert']")).getText();
        Assert.assertEquals("You have been successfully subscribed!",textSucces);
        Thread.sleep(2000);

    }
}
