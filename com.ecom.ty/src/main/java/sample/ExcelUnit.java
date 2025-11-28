package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUnit {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("C:\\selenium\\OrangeHrmTestDataM5.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sample");
		//Row r = sh.getRow(13);
		//Cell c = r.getCell(1);
		//String s = sh.getRow(13).getCell(1).getStringCellValue();
		//String s = c.getStringCellValue();
		
		DataFormatter df = new DataFormatter();
		String s = df.formatCellValue(sh.getRow(5).getCell(1));	
		System.out.println(s);
	}
}
