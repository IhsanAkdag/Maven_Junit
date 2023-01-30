package _homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class DrawExmpDaire extends TestBase {
    @Test
    public void test01() {
        Actions builder = new Actions(driver);
        driver.get("https://szimek.github.io/signature_pad/");
        WebElement board = driver.findElement(By.xpath("//*[@class='signature-pad--body']"));
        WebElement clearButton = driver.findElement(By.xpath("//*[text()='Clear']"));

        for (int i = 0; i <51; i++) {
            builder.moveToElement(board, i, (int) Math.sqrt(2500-(i*i))).perform();
            builder.click().perform();
        }

        for (int i = 0; i <20; i++) {
            builder.moveToElement(board, (int) Math.sqrt(2500-(i*i)),i).perform();
            builder.click().perform();
        }

        for (int i = 0; i <51; i++) {
            builder.moveToElement(board, i, -1*(int) Math.sqrt(2500-(i*i))).perform();
            builder.click().perform();
        }

        for (int i = 0; i <20; i++) {
            builder.moveToElement(board,  (int) Math.sqrt(2500-(i*i)),-1*i).perform();
            builder.click().perform();
        }

        for (int i = 0; i <51; i++) {
            builder.moveToElement(board, -1*i, (int) Math.sqrt(2500-(i*i))).perform();
            builder.click().perform();
        }

        for (int i = 0; i <20; i++) {
            builder.moveToElement(board,-1*(int) Math.sqrt(2500-(i*i)),i).perform();
            builder.click().perform();
        }

        for (int i = 0; i <51; i++) {
            builder.moveToElement(board, -1*i, -1*(int) Math.sqrt(2500-(i*i))).perform();
            builder.click().perform();
        }

        for (int i = 0; i <20; i++) {
            builder.moveToElement(board, -1*(int) Math.sqrt(2500-(i*i)),-1*i ).perform();
            builder.click().perform();
        }

    }

}
