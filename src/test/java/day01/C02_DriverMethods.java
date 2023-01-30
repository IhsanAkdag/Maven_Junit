package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techproeducation.com");
        System.out.println("getTitle = " + driver.getTitle());
        System.out.println("getCurrentUrl = " + driver.getCurrentUrl());
        System.out.println("getPageSource = " + driver.getPageSource());
        System.out.println("getWindowHandle = " + driver.getWindowHandle());  //driver.getWindowHandle() pencerenin hash degerini verir bu degeri alip sayfalar arasi gecis yapabiliriz


    }
}
