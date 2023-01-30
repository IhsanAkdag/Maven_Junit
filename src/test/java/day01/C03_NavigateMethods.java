package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_NavigateMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        //istedigiiz siteye gitmenin 2. yolu
        driver.navigate().to("https://www.techproeducation.com");

        //bir onceki sayfaya donmek
        Thread.sleep(3000);
        driver.navigate().back();

        //onceki sayfaya gider
        Thread.sleep(3000);
        driver.navigate().forward();

        //sayfayi yeniler
        Thread.sleep(3000);
        driver.navigate().refresh();

        //sayfayi kapatalim
        driver.close();
    }
}
