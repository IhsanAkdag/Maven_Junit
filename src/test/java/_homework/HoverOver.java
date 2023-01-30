package _homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class HoverOver extends TestBase {
    @Test
    public void test01() {
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement hover1 = driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        hoverOverOnElementActions(hover1);

        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();

        //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun
        scrollDownActions();
        driver.findElement(By.xpath("//*[@id='click-box']")).click();
        clickAndHold();
        waitFor(2);

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.xpath("//*[@id='click-box']")).getText());

        //8. "Double click me" butonunu cift tiklayin
        doubleClick(driver.findElement(By.xpath("//*[text()='Double Click Me!']")));

        //9. "Double click me" butonunun renk değiştridiğini doğrulayın
        assert driver.findElement(By.xpath("//*[@class='div-double-click double']")).isDisplayed();
    }

}
