package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait extends TestBase {
    /*
    https://the-internet.herokuapp.com/dynamic_loading/1
    Start buttonuna tıkla
    Hello World! Yazının sitede oldugunu test et
     */
    @Test
    public void explicitWaitTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//        Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
//        WebElement helloWorldElement = driver.findElement(By.xpath("//div[@id='finish']//h4"));
//        Assert.assertEquals("Hello World!",helloWorldElement.getText());
//        IMPLICIT WAIT ILE TEST CASE CALISMADI.
//        COZUM EXPLICIT WAITDE

//        1. WebDriverWait objesini olustur
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

//        2. wait objesini kullanarak bekleme problemini cozmeye calis
        WebElement helloWorldElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        String helloWorldText = helloWorldElement.getText();
        Assert.assertEquals("Hello World!",helloWorldText);

//        3. wait methodu kullanarak bekleme problemini cozmeye calis (method testBase calss inda)
//        WebElement helloWorldElement2 = waitForVisibility(driver.findElement(By.xpath("//div[@id='finish']//h4")),30);
//        String helloWorldText2 = helloWorldElement2.getText();
//        Assert.assertEquals("Hello World!",helloWorldText2);

    }

}
