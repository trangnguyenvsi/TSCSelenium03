package tsc.com.selenium.diuttm1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
 
public class DataproviderClass {
 
        @DataProvider(name="SearchProvider")
 
        public static Object[][] getDataFromDataprovider(){
 
            return new Object[][] {
 
                    { "diuttm", "123" },
 
                { "", "" },
 
              
                };
        }
@DataProvider(name= "ExcelProvider")
public Object[][] getData() throws IOException{
    String[][] object = new String[4][2];
    FileInputStream fileInputStream = new FileInputStream("C:\\Users\\diuttm\\workspace\\Copy of Day3\\test-output\\diuttm2.xls");
    POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
    HSSFWorkbook workBook2 = new HSSFWorkbook(fsFileSystem);
    HSSFSheet sheet = workBook2.getSheetAt(0);
   Iterator<Row> iterator = sheet.iterator();
    int i=0;
    int j=0;
   while (iterator.hasNext()) {
    
        Row nextRow = iterator.next();
        Iterator<Cell> cellIterator = nextRow.cellIterator();
        
       while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            object[i][j]=cell.getStringCellValue();
            j=j+1;
           }
      i=i+1; 
        j=0;
       }
   workBook2.close();
    return object;
}

}
