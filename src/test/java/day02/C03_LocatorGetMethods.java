package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_LocatorGetMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasina gideleim
        driver.get("https://amazon.com");

        //Search bolumunu locate edelim
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

        //Search bolumunde iphone aratalim
        aramaKutusu.sendKeys("iphone", Keys.ENTER);

        //Arama sonuc yazisini locate edip konsola yazdirin
        WebElement aramaSonucYaz=driver.findElement(By.className("sg-col-inner"));
        System.out.println("arama Sonuc = " + aramaSonucYaz.getText());

        //Sayfayi kapatalim
        driver.close();
    }
}
