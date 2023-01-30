package _practice.jsExecuter;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class JsExecuter extends TestBase {
        /*
                                -- JavascriptExecutor --
        -- ID'si ILE LOCATE
        WebElement element = (WebElement)
          js.executeScript("return document.getElementById('twotabsearchtextbox');");

        -- XPATH ILE LOCATE
        WebElement element = (WebElement) js.executeScript
                ("return document.evaluate(\"//*[@id='twotabsearchtextbox']\", " + "document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null ).singleNodeValue;");

        --CSS SELECTOR ILE LOCATE
        WebElement element = (WebElement)
                js.executeScript("return document.querySelector('input[id=twotabsearchtextbox]');");
        */

    @Test
    public void test01() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        -- Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

//        -- Arama bölümünde selenium aratınız
        WebElement searchBox = (WebElement) js.executeScript("return document.querySelector('input[id=twotabsearchtextbox]');");
        js.executeScript("arguments[0].value='selenium'",searchBox);
        searchBox.submit();

//        -- Back to top bölümüne kadar scroll yapınız
        WebElement backToTop = (WebElement) js.executeScript("return document.getElementsByClassName('navFooterBackToTopText')[0];");
        js.executeScript("arguments[0].scrollIntoView(true);",backToTop);

//        -- Back to top bölümüne tıklayınız
        try {
            backToTop.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();",backToTop);
        }

    }



}
