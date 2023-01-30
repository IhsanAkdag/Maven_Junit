package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TestBase {
//    TestBase i abstract yapmamizin sebebi bu sinifin objesini olusturmak istemiyorum
//    TestBase testBase = new TestBase(); -> YAPILAMAZ
//    Amacim bu sinifi extend etmek ve icindeki hazir metodlari kullanmak
//    driver objesini olustur. Driver ya public yada protected olmali.
//    Sebepi child classlarda gorulebilir olmasi
    protected static WebDriver driver;

//    ======================= BEFORE (SETUP) ==========================
    @Before
    public void setup()  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver=WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//20 SANIYEYE KADAR BEKLE.SELENIUM
    }
//    ======================= AFTER (TEARDOWN) =======================
    @After
    public void tearDown(){
        waitFor(5);
        driver.quit();
    }

//    ********************************************* MULTIPLE WINDOW *********************************************
//   Gecis Yapmak Istedigim sayfanin Title
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;//CIK. break;
            }
        }
        driver.switchTo().window(origin);
    }

//    windowNumber sıfır (0)'dan başlıyor. index numarasini parametre olarak alir
    public static void switchToWindow(int windowNumber){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }

//  ********************************************* ACTIONS *********************************************
//    ======================= ACTIONS_RIGHT CLICK =======================
    public static void rightClickOnElementActions(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }
//    ======================= ACTIONS_DOUBLE CLICK =======================
    public static void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }
//    ======================= ACTIONS_HOVER_OVER =======================
    public static void hoverOverOnElementActions(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }
//    ======================= ACTIONS_SCROLL_DOWN =======================
    public static void scrollDownActions() {
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    }

//    ======================= ACTIONS_SCROLL_UP =======================
    public static void scrollUpActions() {
        new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
    }

//    ======================= ACTIONS_SCROLL_RIGHT =======================
    public static void scrollRightActions(){
        new Actions(driver).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
    }
//    ======================= ACTIONS_SCROLL_LEFT =======================
    public static void scrollLeftActions(){
        new Actions(driver).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).perform();
    }
//    ======================= ACTIONS_DRAG_AND_DROP =======================
    public static void dragAndDropActions(WebElement source, WebElement target) {
        new Actions(driver).dragAndDrop(source,target).perform();
    }
//    ======================= ACTIONS_DRAG_AND_DROP_BY =======================
    public static void dragAndDropActions(WebElement source, int x, int y) {
        new Actions(driver).dragAndDropBy(source,x,y).perform();
    }
//    ======================= CLICK_AND_HOLD =======================
    public static void clickAndHold(){
        new Actions(driver).clickAndHold();
    }


//********************************************* WAIT *********************************************

    //   ======================= HARD WAIT: =======================
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//   ======================= DYNAMIC SELENIUM WAITS: =======================

//===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

//================= WAIT COK KULLANILMAZ =================

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

    //    This can be used when a new page opens. Yeni sagfaya gecislerde kullanilabilir
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }

    //   ================= FLUENT WAIT =====================

    // params : xpath of teh element , max timeout in seconds, polling in second
    public static WebElement fluentWait(String xpath, int withTimeout, int pollingEvery) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(withTimeout))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(pollingEvery))//Check for the element every 1 second
                .withMessage("Ignoring No Such Element Exception")
                .ignoring(NoSuchElementException.class);


        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }

    //   ********************************************* SCREENSHOTS *********************************************
    //    ================= SCREENSHOT (PAGE) =================
    public void takeScreenShotOfPage() {
//        1. Take screenshot
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

//       2. Save screenshot
//        getting the current time as string to use in teh screenshot name, previous screenshots will be kept
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

//        Path of screenshot save folder               folder / folder    /file name
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";

        try {
            FileUtils.copyFile(image,new File(path)); // exception atmasin diye try and catch yaptik
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //   ================= SCREENSHOT (WebElement) =================
    public void takeScreenshotOfElement(WebElement element){
//        1. take screenshot
        File image = element.getScreenshotAs(OutputType.FILE);
//        2. save screenshot
//        path
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        try {
            FileUtils.copyFile(image,new File(path)); // exception atmasin diye try and catch yaptik
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//    ********************************************* JS EXECUTER **************************************************

//    ================= SCROLLINTOVIEWS =================
    public void scrollIntoViewJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

//    ================= SCROLLEND =======================
    public void scrollEndJS() {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        }

//    ================= SCROLLEND =======================
    public void scrollTopJS() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

//    ================= CLICKBYJS =======================
    public void clickByJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",element);
    }

//    ================= TYPEWITHJS =======================
//   gitmis oldugum metni elemente yazdirir  bu method sendKeys metotuna bir alternatifdir.
    public void typeWithJS(WebElement element, String metin){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value','"+metin+"')",element);
    }

//    ================= GETVALUEBYJS =======================
//   Belirli bir WebElement'in id değerini String olarak alır ve value attribute değerini String olarak döndürür
//    document HTML'E GIT
//    .getElementById('" + idOfElement + "') ID'si VERILEN ELEMENTI BUL
//        NOT: document.querySelector("p").value;  -> TAG KULLANILABILIR
//             document.querySelector(".example").value; -> CSS DEGERI KULLANILABILIR
//             document.querySelector("#example").value; -> CSS DEGERI KULLANILABILIR
    public void getValueByJS(String idOfElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String text = js.executeScript("return document.getElementById('" + idOfElement + "').value").toString();
        System.out.println("Kutudaki value: " + text);
    }

}
