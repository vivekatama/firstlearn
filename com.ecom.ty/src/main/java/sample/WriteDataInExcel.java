package sample;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInExcel {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream
				("C:\\selenium\\book1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet1");
		sh.createRow(7).createCell(4).setCellValue("Welcome raja ji");
		FileOutputStream fos = new FileOutputStream
				("C:\\\\selenium\\\\book1.xlsx");
		book.write(fos);
	}
}
