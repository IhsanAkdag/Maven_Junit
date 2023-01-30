package _homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class WindowsHandle extends TestBase {
    @Test
    public void test01() throws InterruptedException {
// https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

// Title in 'Windows' oldugunu test edin
        Assert.assertTrue(driver.getTitle().contains("Windows"));

// Click here a tiklayin
        driver.findElement(By.linkText("Click Here")).click();

// Sonra açılan sayfadaki title in 'New Window' oldugunu dogrulayin
        switchToWindow("New Window");
        Assert.assertTrue(driver.getTitle().contains("New Window"));
        Thread.sleep(3000);
    }
}

