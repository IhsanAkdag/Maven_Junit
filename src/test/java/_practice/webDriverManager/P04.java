package _practice;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P04 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to website  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Under the  ORIGINAL CONTENTS click on Alerts
        driver.findElement(By.xpath("//*[@id='alerts']")).click();

        // print the URL
        System.out.println("CurrentUrl = " + driver.getCurrentUrl());

        // navigate back
        driver.navigate().back();

        // print the URL
        System.out.println("getCurrentUrl = " + driver.getCurrentUrl());


        // Click on Basic Ajax
        driver.findElement(By.xpath("//*[@id='basicajax']")).click();

        // print the URL
        System.out.println("CurrentUrl() = " + driver.getCurrentUrl());

        // enter value-> 20 and Enter
        driver.findElement(By.id("lteq30")).sendKeys("20", Keys.ENTER);

        // and then verify Submitted Values is displayed open page
        WebElement submided= driver.findElement(By.xpath("//*[text()='Submitted Values']"));
        if (submided.isDisplayed()){
            System.out.println("testpassed");
        }else {
            System.out.println("test failed");
        }
        // close driver
        driver.close();
    }

}
