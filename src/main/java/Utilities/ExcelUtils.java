package Utilities;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    public FileInputStream fis;
    public FileOutputStream fos;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public CellStyle style;
    String path;

    public ExcelUtils (String path) {
        this.path = path;
    }

    public int getRowCount(String sheetName) throws IOException {
        fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getPhysicalNumberOfRows();
        workbook.close();
        fis.close();
        return rowCount;
    }

    public int getCellCount(String sheetName, int rowNum) throws IOException {
        fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        int cellCount = sheet.getRow(rowNum).getLastCellNum();
        workbook.close();
        fis.close();
        return cellCount;
    }

    public static void main(String[] args) throws IOException {

        String path = System.getProperty("user.dir")+"/testdata/testinput.xlsx";
        ExcelUtils excelutilities = new ExcelUtils(path);
        int rowCount = excelutilities.getRowCount("Sheet1");
        int colCount = excelutilities.getCellCount( "Sheet1", 1);
        System.out.println("Row Count: "+rowCount);
        System.out.println("Column Count: "+colCount);
    }

    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
        fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);
        String cellData;
        DataFormatter formatter = new DataFormatter();
        try
        {
            cellData = formatter.formatCellValue(cell);
        }
        catch (Exception e)
        {
            cellData = "";
        }
        workbook.close();
        fis.close();
        return cellData;
    }

    public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            workbook = new XSSFWorkbook(fis);
            fos = new FileOutputStream(path);
            workbook.write(fos);
        }

        fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        if (workbook.getSheetIndex(sheetName) == -1) {
            workbook.createSheet(sheetName);
        }
        sheet = workbook.getSheet(sheetName);
        if (sheet.getRow(rowNum) == null) {
            sheet.createRow(rowNum);
        }

        row = sheet.getRow(rowNum);
        cell = row.createCell(colNum);
        cell.setCellValue(data);
        fos = new FileOutputStream(path);
        workbook.write(fos);
        workbook.close();
        fos.close();
    }


}
