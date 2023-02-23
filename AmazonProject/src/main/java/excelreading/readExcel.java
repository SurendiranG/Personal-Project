package excelreading;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import reusable.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class readExcel  {
    public static CharSequence ReadExcel;
    static FileInputStream fileInputStream;
     static File file;
     static String value = null;

    public static String ReadExcel(String sheetname, int row, int column)  {
        try {
            String path = System.getProperty("user.dir");
            file = new File(path +"/src/main/resources/TestDataSheet/DataRead.xlsx");
          fileInputStream =  new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheet(sheetname);
           value = sheet.getRow(row).getCell(column).getStringCellValue();

        }
        catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }
        catch ( IOException e){
            throw new RuntimeException(e);
        }
        return value;
    }
}
