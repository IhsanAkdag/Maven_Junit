package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class C01_Selenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

    }
}
