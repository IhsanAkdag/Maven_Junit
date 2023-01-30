package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CssSelector {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String arananKelime = "Spend less";
        if (actualTitle.contains(arananKelime)){
            System.out.println("Title Testi PASSED");
        }else System.out.println("Title Testi FAILED");

        //Gift Cards sekmesine basin (css ile sectik)
        WebElement giftCardButton =  driver.findElement(By.cssSelector("a[href='/gift-cards/b/?ie=UTF8&node=2238192011&ref_=nav_cs_gc']"));
        giftCardButton.click();

        //Birthday butonuna basin
        WebElement birthdayBut=driver.findElement(By.cssSelector("img[alt='Birthday']"));
        birthdayBut.click();

        //Best Seller bolumunden ilk urunu tiklayin
        WebElement bestSeller=driver.findElement(By.cssSelector("a[href='/gp/bestsellers/gift-cards/?ie=UTF8&ref_=sv_gc_sv_main_1']"));
        bestSeller.click();

        WebElement ilkurun=driver.findElement(By.cssSelector("img[alt='Amazon.com Gift Card in a Premium Holiday Gift Box (Various Designs)']"));
        ilkurun.click();

        //Gift card details’den 75 $’i secin
        driver.findElement(By.cssSelector("a[id='a-autoid-12-announce']")).click();

        WebElement price= driver.findElement(By.cssSelector("span[class='a-price a-text-price a-size-medium apexPriceToPay']"));
        if(price.getText().equals("$75.00")){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED ===>"+price.getText());









        driver.close();


    }
}
