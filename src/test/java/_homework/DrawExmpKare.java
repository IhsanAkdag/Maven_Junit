package _homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class DrawExmpKare extends TestBase {
    @Test
    public void test01() {
        Actions builder = new Actions(driver);
        driver.get("https://szimek.github.io/signature_pad/");
        WebElement board = driver.findElement(By.xpath("//*[@class='signature-pad--body']"));
        WebElement clearButton = driver.findElement(By.xpath("//*[text()='Clear']"));

        for (int i = 0; i <51; i++) {
            builder.moveToElement(board, i, -50+i).perform();
            builder.click().perform();
        }

        for (int i = 0; i <51; i++) {
            builder.moveToElement(board, 50-i, i).perform();
            builder.click().perform();
        }

        for (int i = 0; i <51; i++) {
            builder.moveToElement(board, -1*i, 50-i).perform();
            builder.click().perform();
        }

        for (int i = 0; i <51; i++) {
            builder.moveToElement(board, -50+i, -1*i).perform();
            builder.click().perform();
        }






    }

}
