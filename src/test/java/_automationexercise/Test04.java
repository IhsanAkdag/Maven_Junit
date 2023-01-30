package _automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;


public class Test04 extends TestBase {


    @Test
    public void test01(){
driver.get("http://automationexercise.com");

// 3. Ana sayfanın başarıyla göründüğünü doğrulayın
String title = driver.getTitle();
Assert.assertTrue(driver.getTitle().equals(title));

// 4. 'Kaydol / Giriş Yap' düğmesine tıklayın
driver.findElement(By.xpath(" //*[text()=' Signup / Login']")).click();;

// 5. "Login to your account"ın göründüğünü doğrulayın
String textLogin = driver.findElement(By.xpath("//*[.='Login to your account']")).getText();
Assert.assertEquals("Login to your account", textLogin);
    
// 6. Doğru e-posta adresini ve şifreyi girin
driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("akdagihsan66@gmail.com");
driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys("12345");

// 7. 'Giriş' düğmesine tıklayın
driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();

// 8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
String textLogged= driver.findElement(By.xpath("//*[text()=' Logged in as ']")).getText();
Assert.assertEquals("Logged in as ihsn", textLogged);

// 9. 'Çıkış' düğmesini tıklayın
driver.findElement(By.xpath("//*[text()=' Logout']")).click();

// 10. Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın
Assert.assertEquals("Login to your account", textLogin);
    
    }
}
