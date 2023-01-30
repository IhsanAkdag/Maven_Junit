package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_FileUpload extends TestBase {

//    Tests packagenin altina bir class oluşturun : C05_UploadFile
//    https://the-internet.herokuapp.com/upload adresine gidelim
    @Test
    public void fileUploadTest(){
        driver.get("https://the-internet.herokuapp.com/upload");
//    chooseFile butonuna basalim
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
//    Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = System.getProperty("user.home")+"/Desktop/logo.jpeg";
        /*
        chooseFileButton una yuklemek istedigim dosyanin path ini gondererek dosyayi secdim
         */
        chooseFileButton.sendKeys(dosyaYolu);
        waitFor(5);

//    Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

//    “File Uploaded!” textinin goruntulendigini test edelim.
        String uploadedYazisi = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("File Uploaded!",uploadedYazisi);
        waitFor(5);

    }

}
