package _practice.cookie;

import org.junit.Test;
import utilities.TestBase;

import java.util.Set;

public class Cookie extends TestBase {
    /*
                                    Cookies(Çerezler)
        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.
    Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
    daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
    kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.
     */
        //Techproeducation adresine gidiniz
        //Sayfadaki cookie lerin sayısını yazdırınız
        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
        //Yeni bir cookie ekleyiniz
        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
        //Oluşturduğumuz cookie'i silelim
        //Tüm cookieleri silelim


    @Test
    public void test01() throws InterruptedException {
        //Techproeducation adresine gidiniz
        driver.get("https://techproeducation.com");
        Thread.sleep(5000);

        //Sayfadaki cookie lerin sayısını yazdırınız
        Set<org.openqa.selenium.Cookie> cookies = driver.manage().getCookies();
        System.out.println("Cookilerin Sayısı = "+cookies.size());

        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
        for (org.openqa.selenium.Cookie c:cookies) {
            System.out.println(c.getName()+":"+c.getValue());
        }

        //Yeni bir cookie ekleyiniz
        org.openqa.selenium.Cookie myCookie = new org.openqa.selenium.Cookie("myCookie","123456789");
        driver.manage().addCookie(myCookie);

        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
        Set<org.openqa.selenium.Cookie> cookies2 = driver.manage().getCookies();
        System.out.println("Cookilerin Sayısı = "+cookies2.size());
        for (org.openqa.selenium.Cookie w:cookies2) {
            System.out.println(w.getName() + ":" + w.getValue());
        }
        //Oluşturduğumuz cookie'i silelim
        driver.manage().deleteCookie(myCookie);

        //Tüm cookieleri silelim
        driver.manage().deleteAllCookies();
        Set<org.openqa.selenium.Cookie> cookies3 = driver.manage().getCookies();
        System.out.println(cookies3.size());
    }
}
