package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private static Workbook workbook;

    public static void openExcel(String path) throws IOException{
        FileInputStream fis=new FileInputStream(path);
        workbook=new XSSFWorkbook(fis);
    }
    public static String getCellData(String sheetName,int rowIndex, int colIndex) {
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowIndex);
        Cell cell = row.getCell(colIndex);
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> String.valueOf((long) cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            default -> cell.toString();
        };
    }
    public static int getRowCount(String sheetName) {
        return workbook.getSheet(sheetName).getLastRowNum() + 1;
    }

}
