package uitlities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

    private FileInputStream fi;
    private FileOutputStream fo;
    private XSSFWorkbook wb;
    private XSSFSheet sheet;
    private String path;

    private static DataFormatter formatter = new DataFormatter();

    // ---------- CONSTRUCTOR ----------
    public ExcelUtils(String path) throws IOException {
        this.path = path;
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
    }

    // ---------- GET ROW COUNT ----------
    public int getRowCount(String sheetName) {
        sheet = wb.getSheet(sheetName);
        return (sheet == null) ? 0 : sheet.getLastRowNum();
    }

    // ---------- GET CELL COUNT ----------
    public int getCellCount(String sheetName, int rowNum) {
        sheet = wb.getSheet(sheetName);
        if (sheet == null) return 0;

        XSSFRow row = sheet.getRow(rowNum);
        return (row == null) ? 0 : row.getLastCellNum();
    }

    // ---------- READ CELL DATA ----------
    public String getCellData(String sheetName, int rowNum, int colNum) {
        sheet = wb.getSheet(sheetName);
        if (sheet == null) return "";

        XSSFRow row = sheet.getRow(rowNum);
        if (row == null) return "";

        XSSFCell cell = row.getCell(colNum);
        if (cell == null) return "";

        return formatter.formatCellValue(cell);
    }

    // ---------- WRITE CELL DATA ----------
    public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {

        sheet = wb.getSheet(sheetName);
        if (sheet == null)
            sheet = wb.createSheet(sheetName);

        XSSFRow row = sheet.getRow(rowNum);
        if (row == null)
            row = sheet.createRow(rowNum);

        XSSFCell cell = row.createCell(colNum);
        cell.setCellValue(data);

        fo = new FileOutputStream(path);
        wb.write(fo);
        fo.close();
    }

    // ---------- CLOSE EXCEL ----------
    public void close() throws IOException {
        if (wb != null) wb.close();
        if (fi != null) fi.close();
    }
}
