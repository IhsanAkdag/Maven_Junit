package _homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class AmazonIphone extends TestBase {
    @Test
    public void test01() {
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone 13 512"+ Keys.ENTER);
        scrollDownActions();
        scrollDownActions();
        driver.findElement(By.xpath("(//*[@class='a-size-base-plus a-color-base a-text-normal'])[5]")).click();
        String phoneInfo = driver.findElement(By.xpath("(//*[@class='a-size-base po-break-word'])[2]")).getText();
        String phonePrize = driver.findElement(By.xpath("//*[@class='a-price aok-align-center']")).getText();
        String stock = driver.findElement(By.xpath("//*[@class='a-size-medium a-color-success']")).getText();
        String phoneName = phoneInfo.split(" ")[0]+" "+phoneInfo.split(" ")[1];
        String size = phoneInfo.split(" ")[2]+" "+phoneInfo.split(" ")[3];
        String color = phoneInfo.split(" ")[4]+" "+phoneInfo.split(" ")[5];

        System.out.println("Phone Name = " + phoneName);
        System.out.println("Size = " + size);
        System.out.println("Color = " + color);
        System.out.println("prize = " + phonePrize);
        System.out.println("stock = " + stock);

    }
}
