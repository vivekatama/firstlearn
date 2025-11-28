package GenericLibraryOrUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * this is a generic method to fetch data from single sheet in excel 
	 * @param sheetName
	 * @param startRowNum
	 * @param startCellNum
	 * @return
	 * @throws Exception
	 */

	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Exception{
		FileInputStream fis = new FileInputStream(IconstantUtility.excelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh= book.getSheet(sheetName);
		DataFormatter df = new DataFormatter();
		String value = df.formatCellValue(sh.getRow(rowNum).getCell(cellNum));
		return value;
	}


	/**
	 * this is a generic method to fetch multiple data from excel
	 * @param sheetName
	 * @param startRowNum
	 * @param startCellNum
	 * @return
	 * @throws Exception
	 */	
	public String getMultipleDataFromExcel(String sheetName, int startRowNum, int startCellNum) throws Exception{
		String value =null;
		FileInputStream fis = new FileInputStream(IconstantUtility.excelPath);
		Workbook book = WorkbookFactory.create(fis);

		Sheet sh = book.getSheet(sheetName);
		DataFormatter df= new DataFormatter();

		for(int i=startRowNum; i<sh.getLastRowNum(); i++ ) {
			Row r=sh.getRow(i);

			for(int j=startCellNum; j<r.getLastCellNum(); j++) {
				value=df.formatCellValue(r.getCell(j));
			}
		}
		return value;
	}
	
//	/**
//	 * this is the generic method to read multiple data from excel
//	 * @param sheetName
//	 * @param firsttRowNum
//	 * @param firstCellNum
//	 * @throws Exception
//	 */
//
//	public void readMultipleDataFromExcel(String sheetName, int firsttRowNum, int firstCellNum) throws Exception{
//		//String value =null;
//		FileInputStream fis = new FileInputStream(IconstantUtility.excelPath);
//		Workbook book = WorkbookFactory.create(fis);
//
//		Sheet sh = book.getSheet(sheetName);
//		DataFormatter df= new DataFormatter();
//
//		for(int i=firsttRowNum; i<sh.getLastRowNum(); i++ ) {
//			Row r=sh.getRow(i);
//
//			for(int j=firstCellNum; j<r.getLastCellNum(); j++) {
//			String	value=df.formatCellValue(r.getCell(j));
//			System.out.println(value);
//			}
//		}
//	}


	/**
	 * 	it is a generic method to write data in excel
	 * @param sheetName 
	 * @param rowNum
	 * @param cellNum
	 * @param cellValue
	 * @throws exception
	 * 
	 */

	public void writeDataInExcel(String sheetName, int rowNum, int cellNum, 
			String cellValue) throws Exception{
		FileInputStream fis = new FileInputStream(IconstantUtility.excelPath);
		Workbook book = WorkbookFactory.create(fis);

		Sheet sh = book.getSheet(sheetName);
		sh.createRow(rowNum).createCell(cellNum).setCellValue(cellValue);

		FileOutputStream fos = new FileOutputStream(IconstantUtility.excelPath);
		book.write(fos);
		//fos.flush(); optional
	}
}



