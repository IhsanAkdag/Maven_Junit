package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_ClassWork {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techproeducation.com");

        //sayfa basligini yazdiralim
        System.out.println("Sayfa basligi: "+driver.getTitle());

        //sayfa basliginda Techpro varmi test edelim
        String sayfaBasligi= driver.getTitle();
        if(sayfaBasligi.contains("Techpro")){
            System.out.println("title test PASSED");
        }else System.out.println("title test FAILED");

        //sayfa adresini yazdirin
        System.out.println("Sayfa adresi: "+driver.getCurrentUrl());

        //sayfa url nin techpro icerdigini test edin
        String sayfaUrl=driver.getCurrentUrl();
        if(sayfaBasligi.contains("techpro")){
            System.out.println("url test PASSED");
        }else System.out.println("url test FAILED");

        //sayfa handle degerini yazdirin
        System.out.println("WindowHandle = " + driver.getWindowHandle());

        //sayfa html kodlarinda Geteway kelimesi gectigini test edin
        String sayfaKodlari= driver.getPageSource();
        if(sayfaKodlari.contains("Geteway")){
            System.out.println("source code test PASSED");
        }else System.out.println("source code test FAILED");

        //sayfayi kapayin
        driver.close();

    }
}







