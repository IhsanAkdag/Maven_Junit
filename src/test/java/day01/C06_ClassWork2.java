package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_ClassWork2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//bu method sayfadaki herbir element icin max bekleme suresini belirler

        //ChormeDriver kullanarak facebook sayfasina gidin ve sayfa basliginin "facebook" oldugunu dogrulayin
        //degilse dogru basligi yazdirin
        driver.get("https://facebook.com");
        String sayfaBAsligi = driver.getTitle();
        if(sayfaBAsligi.contains("facebook")){
            System.out.println("title test PASSED");
        }else System.out.println("title test FAILED ====>"+sayfaBAsligi);

        //sayfa url sinin "facebook" kelimesi icerdigini dogrulayin
        //icermiyorsa actual url yi yazdirin
        String sayfaUrl= driver.getCurrentUrl();
        if(sayfaUrl.contains("facebook")){
            System.out.println("url test PASSED");
        }else System.out.println("url test FAILED ====>"+sayfaUrl);

        //https://walmart.com sayfasina gidin
        driver.get("https://walmart.com");
        //sayfa basliginin Walmart.com icerdigini dogrulayin
        String actualSayfaBas=driver.getTitle();
        String expectedsayfaBas="Walmart.com";
        if(actualSayfaBas.contains(expectedsayfaBas)){
            System.out.println("title test PASSED");
        }else System.out.println("title test FAILED");

        //tekrar facebook sayfasina donun
        driver.navigate().back();

        //sayfayi yenilyin
        driver.navigate().refresh();

        //browser i kapatin
        driver.close();





        driver.get("https://www.techproeducation.com");
    }
}
