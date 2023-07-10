package Generic_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * reduce the coding 
 * @author priyanka
 *
 */
public class Excel_Utility {
	public String getDataFromExcel(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1 = new FileInputStream(new File("./src/test/resources/vtigerExcelData.xlsx"));
		Workbook excel = WorkbookFactory.create(fis1);
		Sheet sheet1 = excel.getSheet(sheetName);
		String cel = sheet1.getRow(rowNo).getCell(cellNo).toString();
		return cel;
	
	}
	
	public String getDataFromExcelUsingDataFormatter(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis1 = new FileInputStream(new File("./src/test/resources/vtigerExcelData.xlsx"));
		Workbook excel = WorkbookFactory.create(fis1);
		Sheet sheet1 = excel.getSheet(sheetName);
		Cell cel = sheet1.getRow(rowNo).getCell(cellNo);

		DataFormatter df = new DataFormatter();
		String val = df.formatCellValue(cel);		
		return val;
		
	}
	
	public String getData2FromExcel(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1 = new FileInputStream(new File("./src/test/resources/invoice.xlsx"));
		Workbook excel = WorkbookFactory.create(fis1);
		Sheet sheet1 = excel.getSheet(sheetName);
		String cel = sheet1.getRow(rowNo).getCell(cellNo).toString();
		return cel;
	
	}
	
	public String getData2FromExcelUsingDataFormatter(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis1 = new FileInputStream(new File("./src/test/resources/invoice.xlsx"));
		Workbook excel = WorkbookFactory.create(fis1);
		Sheet sheet1 = excel.getSheet(sheetName);
		Cell cel = sheet1.getRow(rowNo).getCell(cellNo);
		DataFormatter df = new DataFormatter();
		return df.formatCellValue(cel);		
		
	}
	public String getData3FromExcelUsingDataFormatter(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(new File("./src/test/resources/scenarios.xlsx"));
		Workbook excel = WorkbookFactory.create(fis);
		Sheet sheet = excel.getSheet(sheetName);
		Cell cel = sheet.getRow(rowNo).getCell(cellNo);
		DataFormatter df = new DataFormatter();
		return df.formatCellValue(cel);		
		
	}

	public String getData3FromExcel(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1 = new FileInputStream(new File("./src/test/resources/scenarios.xlsx"));
		Workbook excel = WorkbookFactory.create(fis1);
		Sheet sheet1 = excel.getSheet(sheetName);
		String cel = sheet1.getRow(rowNo).getCell(cellNo).toString();
		return cel;
	
	}
//	public String getExcel4Data(String sheetName,int rowNum,int cellNum) throws Throwable
//	{
//		//  FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
//		FileInputStream fes=new FileInputStream("./src/test/resources/newscene.xlsx");
//		
//	        Workbook book = WorkbookFactory.create(fes);
//	        Sheet sheet = book.getSheet(sheetName);
//	         org.apache.poi.ss.usermodel.Row row = sheet.getRow(rowNum);
//	        Cell cell = row.getCell(cellNum);
//	        String value = cell.getStringCellValue();
//		    return value;
//	}

	public Object[][] getMultipleData(String srcFile,String sheetName) throws Exception, Exception{
		FileInputStream fis = new FileInputStream(srcFile);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		DataFormatter db = new DataFormatter ();
		int lastRow=sheet.getPhysicalNumberOfRows();
		int lastCol=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("RowCount: "+lastRow);
		System.out.println("ColumnCount: "+lastCol);

		Object[][] obj= new Object[lastRow][lastCol];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCol;j++) {			
				obj[i][j]=	db.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		return obj;
	}


}
