package _homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class DrawExmpStar extends TestBase {
    @Test
    public void test01() {
        Actions builder = new Actions(driver);
        driver.get("https://szimek.github.io/signature_pad/");
        WebElement board = driver.findElement(By.xpath("//*[@class='signature-pad--body']"));
        WebElement clearButton = driver.findElement(By.xpath("//*[text()='Clear']"));


        for (int i=0 ; i<101 ; i=i+10 ){
            builder.moveToElement(board,0,0).perform();
            builder.clickAndHold().perform();
            builder.moveByOffset(100-i, 0+i).perform();
        }
        for (int i=0 ; i<101 ; i=i+10 ){
            builder.moveToElement(board,0,0).perform();
            builder.clickAndHold().perform();
            builder.moveByOffset(0-i, 100-i).perform();
        }
        for (int i=0 ; i<101 ; i=i+10 ){
            builder.moveToElement(board,0,0).perform();
            builder.clickAndHold().perform();
            builder.moveByOffset(-100+i, 0-i).perform();
        }
        for (int i=0 ; i<101 ; i=i+10 ){
            builder.moveToElement(board,0,0).perform();
            builder.clickAndHold().perform();
            builder.moveByOffset(0+i, -100+i).perform();
        }


    }

}
