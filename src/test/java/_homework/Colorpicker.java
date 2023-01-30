package _homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Colorpicker extends TestBase {
    @Test
    public void test01() {
        Actions actions = new Actions(driver);
        driver.get("https://jqueryui.com/slider/#colorpicker");
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='demo-frame']")));


        WebElement red = driver.findElement(By.xpath("(//span[@tabindex='0'])[1]"));
        actions.moveToElement(red).clickAndHold().perform();
                    for (int i = 0; i < 20; i++) {
                        actions.moveByOffset(-1*i,0).perform();
                    }
                    actions.release();

        WebElement green = driver.findElement(By.xpath("(//span[@tabindex='0'])[2]"));
        actions.moveToElement(green).clickAndHold().perform();
                    for (int i = 0; i < 20; i++) {
                         actions.moveByOffset(i,0).perform();
                    }
                    actions.release();

        WebElement blue = driver.findElement(By.xpath("(//span[@tabindex='0'])[3]"));
        actions.moveToElement(blue).clickAndHold().perform();
                    for (int i = 0; i < 20; i++) {
                         actions.moveByOffset(i,0).perform();
                    }



    }
}
