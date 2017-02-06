import org.apache.poi.hssf.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class Reading {
    void read(String file) throws IOException {
        HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(file));
        HSSFSheet sheet = book.getSheet("bdays");
        HSSFRow row = sheet.getRow(0);

        checkString(row.getCell(0));
        checkDate(row.getCell(1));
    }

    private void checkString(HSSFCell cell) {
        if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
            String name = cell.getStringCellValue();
            System.out.println("name is " + name);
        }
    }

    private void checkDate(HSSFCell cell) {
        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            Date birthDate = cell.getDateCellValue();
            System.out.println("bday is " + birthDate);
        }

    }
}
