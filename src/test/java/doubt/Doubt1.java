package doubt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Doubt1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String filepath = "./src/test/resources/newscene.xlsx";
		FileInputStream fis= new FileInputStream(filepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("psheet");
		//Sheet sheetname = sheet.getSheet(filepath);
		System.out.println(sheet.toString());
		String cell = sheet.getRow(4).getCell(0).toString();
		System.out.println(cell);
		

	}

}
