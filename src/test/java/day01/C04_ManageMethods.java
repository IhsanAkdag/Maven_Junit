package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_ManageMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techproeducation.com");

        //sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Sayfanin konumu: "+driver.manage().window().getPosition());
        System.out.println("Sayfanin boyutunu yazdiriniz: "+driver.manage().window().getSize());

        //sayfayi simge durumuna getiriniz
        driver.manage().window().minimize();

        //simge durumunda 3 sn bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //sayfanin konumunu ve boyutlerini maximize durumunda yazdirin
        System.out.println("Sayfanin konumu: "+driver.manage().window().getPosition());
        System.out.println("Sayfanin boyutunu yazdiriniz: "+driver.manage().window().getSize());

        //sayfayi fullscreen yapin
        Thread.sleep(3000);
        driver.manage().window().fullscreen();

        //sayfanin konumunu ve boyutlarini fullscreen modunda yazdirin
        System.out.println("Sayfanin konumu: "+driver.manage().window().getPosition());
        System.out.println("Sayfanin boyutunu yazdiriniz: "+driver.manage().window().getSize());

        Thread.sleep(3000);
        driver.close();


    }
}
