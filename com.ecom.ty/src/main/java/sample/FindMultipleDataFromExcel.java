package sample;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FindMultipleDataFromExcel {
	public static void main(String[] args)throws Exception {
		FileInputStream fis = new FileInputStream ("C:\\\\selenium\\\\OrangeHrmTestDataM5.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Multiple");
		DataFormatter df = new DataFormatter();
		for(int i=0; i<=sh.getLastRowNum(); i++){
			Row r= sh.getRow(i);
			for(int j=1; j<r.getLastCellNum(); j++) {
				System.out.println(df.formatCellValue(r.getCell(j)));
			}
		}
	
	}
}
