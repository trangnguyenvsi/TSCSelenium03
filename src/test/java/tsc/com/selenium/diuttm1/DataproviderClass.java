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

}


