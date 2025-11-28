package genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	
	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook book;
	public XSSFSheet sh;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path = null;
	
	public XLUtility(String path) {
		
		this.path = path;
	}
	
	public int getRowCount(String sheetName)throws IOException {
		fis=new FileInputStream(path);
		book=new XSSFWorkbook(fis);
		sh=book.getSheet(sheetName);
		int rowcount=sh.getLastRowNum();
		book.close();
		fis.close();
		return rowcount;		
	}
	public int getCellCount(String sheetName, int rownum)throws IOException {
		fis=new FileInputStream(path);
		book=new XSSFWorkbook(fis);
		sh=book.getSheet(sheetName);
		row=sh.getRow(rownum);
		int cellcount=row.getLastCellNum();
		book.close();
		fis.close();
		return cellcount;		
	}
	public String getCellData(String sheetName, int rownum, int colnum)throws IOException {
		fis=new FileInputStream(path);
		book=new XSSFWorkbook(fis);
		sh=book.getSheet(sheetName);
		row=sh.getRow(rownum);
		cell=row.getCell(colnum);
		DataFormatter df = new DataFormatter();
		String data;
		try {
			data = df.formatCellValue(cell);//returns the formatted value of cell as a string 
		}
		catch(Exception e) {
			data="";
		}
		book.close();
		fis.close();
		return data;
			
	}
	
	public void setCellData(String sheetName, int rownum, int colnum, String formattedDateTime  )throws IOException {
		fis=new FileInputStream(path);
		book=new XSSFWorkbook(fis);
		sh=book.getSheet(sheetName);
		
		row=sh.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(formattedDateTime);
		//cell.setCellValue(ldt);
		fos=new FileOutputStream(path);
		book.write(fos);
		book.close();
		fis.close();
		fos.close();
	}

	public void setCellData(String sheetName, int r, int i, String pDetails, int j, String pPrice) throws IOException {
		// TODO Auto-generated method stub
		fis=new FileInputStream(path);
		book=new XSSFWorkbook(fis);
		sh=book.getSheet(sheetName);
		row=sh.getRow(r);
		cell=row.createCell(i);
		cell.setCellValue(pDetails);
		cell=row.createCell(j);
		cell.setCellValue(pPrice);
		fos=new FileOutputStream(path);
		book.write(fos);
		book.close();
		fis.close();
		fos.close();
		
	}

	

}
