import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

 class Writing {
    void write(String file, String name, LocalDate date) throws IOException {
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("bdays");
        Row row = sheet.createRow(0);

        Cell nameCell = row.createCell(0);
        nameCell.setCellValue(name);

        Cell bdCell = row.createCell(1);
        makeStyle(bdCell, book);

        bdCell.setCellValue(String.valueOf(date));

        sheet.autoSizeColumn(1);

        book.write(new FileOutputStream(file));
    }

    private void makeStyle(Cell cell, Workbook book) {
        DataFormat format = book.createDataFormat();
        CellStyle dateStyle = book.createCellStyle();

        dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
        cell.setCellStyle(dateStyle);
    }

}