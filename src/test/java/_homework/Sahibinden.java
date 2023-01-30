package _homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Sahibinden extends TestBase {

    @Test
    public void test01()  {

//sahibinden.com a gidin
        driver.get("https://www.sahibinden.com/");

//anasayfada oldugunuzu dogrulayin
        assert driver.findElement(By.xpath("//*[@class='logo']")).isDisplayed();

//detayli arama tiklayin
        driver.findElement(By.xpath("//*[@title='Detaylı Arama']")).click();

//detayli arama sayfasina geldiginizi dogrulatin
        assert driver.findElement(By.xpath("(//*[text()='Detaylı Arama'])[2]")).getText().equals("Detaylı Arama");

//emlak-konut-satilik seceneklerini secip
        driver.findElement(By.xpath("//*[text()='Emlak']")).click();
        driver.findElement(By.xpath("//*[text()='Konut']")).click();
        driver.findElement(By.xpath("//*[text()='Satılık']")).click();

//altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin
        driver.findElement(By.xpath("//*[@data-address='city']")).click();
        driver.findElement(By.xpath("(//*[@class='js-address-filter'])[2]")).sendKeys("iz"+Keys.ARROW_DOWN+Keys.ENTER);
        waitFor(1);

        driver.findElement(By.xpath("//*[@data-address='town']")).click();
        driver.findElement(By.xpath("(//*[@class='js-address-filter'])[3]")).sendKeys("bayr"+Keys.ARROW_DOWN+Keys.ENTER+Keys.ESCAPE);
        waitFor(1);

        driver.findElement(By.xpath("//*[@data-address='quarter']")).click();
        driver.findElement(By.xpath("(//*[@class='js-address-filter'])[4]")).sendKeys("adalet"+Keys.ARROW_DOWN+Keys.ARROW_DOWN+Keys.ENTER+Keys.ESCAPE);
        waitFor(1);

        scrollDownActions();
        scrollDownActions();
        scrollDownActions();
        driver.findElement(By.xpath("//*[@class='btn mtdef']")).click();

        waitFor(2);



//filtreler için sağıdakilere benzer methodlar oluşturun

//        detayli_Arama_Adres("izmir", "bayrakli", "adalet mah.");
//        detayli_Arama_Fiyat("4.000","4.000.000","USD");
//        detayli_Arama_Brut("180","400");
//        detayli_Arama_Oda_Sayisi("10 Üzeri");//0-43 arasi

//cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin
    }
}
