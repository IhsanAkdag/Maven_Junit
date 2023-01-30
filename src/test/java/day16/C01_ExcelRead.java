package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {
    @Test
    public void readExcelTest() throws IOException {
//  WORKBOOK > WORKSHEET/SHEET (SAYFA) > ROW (SATIR) > CELL (VERI HUCRESI)
        String path = "./src/resources/documents/Capitals.xlsx";

//        DOSYAYI AC
        FileInputStream fileInputStream = new FileInputStream(path);

//        EXCEL DOSYASINI AC /WORKBOOK AC
        Workbook workbook = WorkbookFactory.create(fileInputStream);

//        SAYFAYI AC / Sheet1
        Sheet sheet1 = workbook.getSheet("Sheet1"); //isim ile acariz
        // Sheet sheet1 = workbook.getSheetAt(0); //index sifirdan baslar

//        ILK SATIRA GIT / Row
        Row row1 = sheet1.getRow(0); //ilk satir

//        INK SATIRDAKI ILK VERIYI AL
        Cell cell1 = row1.getCell(0); // ilk hucredeki datayi aldik

//        O VERIYI YAZDIR
        System.out.println("cell-1 = " + cell1);

//        KISACA YAZDIRALIM
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(0));

//        1.SATIR 2.SUTUN
        Cell cell2 = sheet1.getRow(0).getCell(1);
        System.out.println(cell2);

//        3.SATIR 1.SUTUN
        String cell31 = sheet1.getRow(2).getCell(0).toString();
        System.out.println(cell31);
        Assert.assertEquals("France",cell31);

//        EXCEL DEKI TOPLAM KULLANILAN SATIR SAYISINI BUL
        int toplamSatirSayisi = sheet1.getLastRowNum()+1; //son satir numarasi.
        //index sayisi sifirdan basladigi icin +1 ekleyecegiz
        System.out.println("toplamSatirSayisi = " + toplamSatirSayisi);

//        KULLANILAN TOPLAM SATIR SAYISI (boslari saymayacak)
        int kullanilanSatirSayisi= sheet1.getPhysicalNumberOfRows(); //birden basliyor
        System.out.println("kullanilanSatirSayisi = " + kullanilanSatirSayisi);

//        COUNTRY , CAPITALS key ve valualari map a alip print et
//        {{USA,D.C},{FRANCE,PARIS},...}

//        Variable olusturalim. Bu variable exceldeki country,capital verilerini tutacak
        Map<String,String> ulkeBaskentleri = new HashMap<>();


        for (int satirSayisi=1;satirSayisi<toplamSatirSayisi;satirSayisi++){
            String country = sheet1.getRow(satirSayisi).getCell(0).toString();
            String capital = sheet1.getRow(satirSayisi).getCell(1).toString();
            ulkeBaskentleri.put(country,capital);
//            ulkeBaskentleri.put(sheet1.getRow(satirSayisi).getCell(0).toString(),sheet1.getRow(satirSayisi).getCell(1).toString());
        }
        System.out.println(ulkeBaskentleri);

    }

}
