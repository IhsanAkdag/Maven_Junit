package _practice.extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class ExtentReportTB {

    protected static WebDriver driver;

    protected ExtentReports extentReports;//Raporlamayı başlatırız
    protected ExtentHtmlReporter extentHtmlReporter;//Raporumu HTLM formatında düzenler
    protected ExtentTest extentTest; //Test aşamalarına extentTest objesi ile bilgi ekleriz

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //----------------------------------------------------------------
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "test-output/Reports/Reportshtmlreport"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);
        //Raporda gözükmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Ihsan");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Test Sonucu");
        extentTest = extentReports.createTest("Extent Tests","Test Raporu");
    }

    @After
    public void tearDown() {
        extentReports.flush();
        driver.quit();
    }


}
