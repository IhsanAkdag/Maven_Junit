package _homework;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Webtables extends TestBase {

    //https://www.way2automation.com/angularjs-protractor/webtables/
    //tüm E-mail leri yazdırın
    //Tüm E-maillerin "@" işareti içerdiğini doğrulayin


    @Test
    public void test01() {
        driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");

        for (int i = 1; i < 8; i++) {
        String mail =driver.findElement(By.xpath("//table[@class='smart-table table table-striped']//tbody//tr[" + i + "]//td[7]")).getText();
            System.out.println("mail = " + mail);
            assert mail.contains("@");
        }



    }
}
