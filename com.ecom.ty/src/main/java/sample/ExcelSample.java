package sample;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSample {
	/**
	 * this method is use to fetch single data from excel
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("C:\\selenium\\book2.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet2");
		Row r =	sh.getRow(1);
		Cell c = r.getCell(1);
		String value = c.getStringCellValue();
		System.out.println(value);
		System.out.println("---------------------------------------------------------");

		// this method is use to fetch integer data from excel 
		DataFormatter dff = new DataFormatter();
		String s = dff.formatCellValue(sh.getRow(3).getCell(3));	
		System.out.println(s);

		System.out.println("*********************************************************");
		/**
		 * this method is use to fetch multiple data from excel 
		 */
		FileInputStream fis1 = new FileInputStream("C:\\selenium\\book2.xlsx");
		Workbook book1 = WorkbookFactory.create(fis1);
		Sheet sh1 = book.getSheet("Sheet2");
		DataFormatter df = new DataFormatter();
		for(int i=1; i<=sh1.getLastRowNum(); i++) {
			Row r1 = sh1.getRow(i);
			for(int j=0; j<=r1.getLastCellNum();j++) {
				String v = df.formatCellValue(r1.getCell(j));
				System.out.println(v);
			}
		}

	}
}


