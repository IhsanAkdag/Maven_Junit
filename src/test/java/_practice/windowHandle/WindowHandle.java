package _practice.windowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class WindowHandle extends TestBase {

    @Test
    public void test01() {
        //Amazon anasayfa adresine gidin.
        driver.get("https://amazon.com");

        //Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindow = driver.getWindowHandle();

        //Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitle = driver.getTitle();
        String arananKelime = "Amazon";
        Assert.assertTrue(actualTitle.contains(arananKelime));

        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin

        driver.switchTo().newWindow(WindowType.TAB); // Yeni bir sekme açmış olduk
        driver.get("https://techproeducation.com");

        //Sayfa title’nin “TECHPROEDUCATION” icerip içermediğini test edin
        String actualTechProTitle = driver.getTitle();
        String istenenKelime = "TECHPROEDUCATION";
        Assert.assertFalse(actualTechProTitle.contains(istenenKelime));

        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin

        driver.switchTo().newWindow(WindowType.WINDOW); // Yeni bir window açmış olduk
        driver.get("https://walmart.com");

        //Sayfa title’nin “Walmart” icerip içermediğini test edin
        String actualWalmartTitle = driver.getTitle();
        String beklenenKelime = "Walmart";
        Assert.assertTrue(actualWalmartTitle.contains(beklenenKelime));

        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindow);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";
        Assert.assertEquals(expectedUrl,actualUrl);

    }
}
