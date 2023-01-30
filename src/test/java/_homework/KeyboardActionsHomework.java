package _homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class KeyboardActionsHomework extends TestBase {

//    Yeni Class olusturun ActionsClassHomeWork

    @Test
    public void test01() {
//    1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
//    2- Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"))).perform();
        waitFor(3);

//    Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[text()='Link 1'])[1]")).click();

//    Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

//    Popup'i tamam diyerek kapatin
        driver.switchTo().alert().dismiss();

//    “Click and hold" kutusuna basili tutun
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN);
        actions.clickAndHold(driver.findElement(By.xpath("//*[@id='click-box']"))).perform();
        waitFor(2);

//    7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.xpath("//*[@id='click-box']")).getText());

//    8- “Double click me" butonunu cift tiklayin
        doubleClick(driver.findElement(By.xpath("//*[@id='double-click']")));
    }

}
