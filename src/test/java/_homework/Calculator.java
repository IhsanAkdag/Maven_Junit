package _homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class Calculator extends TestBase {
    //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
    //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
    //Sonucu konsola yazdırıp
    //Sonucun doğrulamasını yapalım


    @Test
    public void test01() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        List<WebElement> sayilar = driver.findElements(By.xpath("//*[@class='btn btn-outline-primary']"));
        List<WebElement> islem = driver.findElements(By.xpath("//*[@class='operator btn btn-outline-success']"));

        String sayi=" ";
        int rdm ;

        for (int i = 0; i < 2; i++) {
            rdm = (int) (Math.random()*8);
            sayilar.get(rdm).click();
            sayi = sayi + sayilar.get(rdm).getText();
        }
        String birincisayi= sayi;

        rdm = (int) (Math.random()*4);
        islem.get(rdm).click();
        String islemText = islem.get(rdm).getText();


        sayi = "";
        for (int i = 0; i < 2; i++) {
            rdm = (int) (Math.random()*8);
            sayilar.get(rdm).click();
            sayi = sayi + sayilar.get(rdm).getText();
        }
        String ikincisayi= sayi;

        driver.findElement(By.xpath("//*[@class='btn btn-outline-warning']")).click(); //esittire bas



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement loading= driver.findElement(By.xpath("//*[@class='spinner-border']"));
        wait.until(ExpectedConditions.invisibilityOf(loading));

        WebElement sonuc = driver.findElement(By.xpath("//*[@class='screen']"));


        assert sonuc.isDisplayed();

        System.out.println(birincisayi + islemText + ikincisayi + "=" + sonuc.getText());

        waitFor(3);


    }
}
