package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSExecutor_Scroll extends TestBase {

    //scrollIntoViewTest metotu olustur
    @Test
    public void scrollIntoViewTest() {

    //Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        waitFor(3);

//    We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al
//        1. Elementi bul
        WebElement weOffer = driver.findElement(By.xpath("//*[text()='we offer']"));

//        2.JS executer objesi olustur
        JavascriptExecutor js = (JavascriptExecutor) driver;

//        3.Yapmak istedigim islemi js.executerScript methodu ile yap
//        scrollIntoView(true) methodu belirli bir elemente scroll yapmak icin kullanilir
//        arguments[0] --> ilk parametredeki eleman
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);
        waitFor(3);
        takeScreenShotOfPage();


//        Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(driver.findElement(By.xpath("//span[.='Enroll Free Course']")));
        waitFor(3);
        takeScreenShotOfPage();

//        Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(driver.findElement(By.xpath("//h3[.='WHY US?']")));
        waitFor(3);
        takeScreenShotOfPage();

//        Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(driver.findElement(By.xpath("//span[.='Enroll Free Course']")));
        waitFor(3);
        takeScreenShotOfPage();

        //En ust
        scrollTopJS();

        //En alt
        scrollEndJS();
    }
}
