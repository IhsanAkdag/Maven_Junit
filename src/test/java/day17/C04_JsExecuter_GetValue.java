package day17;

import org.junit.Test;
import utilities.TestBase;

public class C04_JsExecuter_GetValue extends TestBase {

    @Test
    public void test01() {
        //  https://www.priceline.com/ a git
        driver.get("https://www.priceline.com/");

        //  Tarih kısmındaki Yazili metinleri al ve yazdır
        getValueByJS("hotelDates");

    }





}
