package _homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class IframeOdev extends TestBase {
//    Bir class olusturun: IframeOdev

    @Test
    public void test01() throws InterruptedException {
//    https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

//    sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> iframeCount =driver.findElements(By.xpath("//iframe"));
        System.out.println(iframeCount.size());

//    Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).getText().contains("Editor"));

//    Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        driver.findElement(By.id("tinymce")).clear();
        Thread.sleep(3000);

//    Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        driver.findElement(By.id("tinymce")).sendKeys("iframein icindeyim");
        Thread.sleep(3000);

//    Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().defaultContent();
        WebElement textElemental = driver.findElement(By.xpath("//*[.='Elemental Selenium']"));
        Assert.assertTrue(textElemental.getText().contains("Elemental Selenium"));
    }
}


