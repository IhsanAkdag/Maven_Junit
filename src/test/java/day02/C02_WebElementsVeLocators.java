package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_WebElementsVeLocators {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasina gideleim
        driver.get("https://amazon.com");

        //Search bolumunu locate edelim
        //WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
          WebElement aramaKutusu=driver.findElement(By.name("field-keywords")); //name ile aynisini yaptik

        //Search bolumunde iphone aratalim
          aramaKutusu.sendKeys("iphone", Keys.ENTER);

         /*
        Eğer bir webelementi (Web sayfasındaki herbir buton yada text/yazı) locate (konumunu belirleme)
        etmek istersek önce manuel olarak web sayfasını açıp sayfa üzerinde sağ click yapıp incele'ye tıklarız.
        Karşımıza çıkan HTML kodlarından locater'lardan (konum belirleyiciler) eşsiz olanı seçeriz.
        Genellikle id Attribute'u kullanılır. Seçtiğimiz attribute değerini findelement() metodu içine
        findelement(By.id("atribute değeri")) şeklinde yazarız.
         */

        //amazon sayfasindaki <input> ve <a> tag larinin sayisini yazdirin
        List<WebElement> inputTags= driver.findElements(By.tagName("input"));
        System.out.println(" inputTags size = " + inputTags.size());

        List<WebElement> linkList= driver.findElements(By.tagName("a"));
        System.out.println(" Link size = " + linkList.size());



    }
}















