package BrowserLaunch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class DDTReadFromExcelArray {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis= new FileInputStream(new File("./src/test/resources/dataArray.xlsx"));
		
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		
		int rowc = sh.getPhysicalNumberOfRows();
		int colc = sh.getRow(1).getPhysicalNumberOfCells();
		
		String arr;
		
		for(int i=0;i<rowc;i++)
		{
			for(int j=0;j<colc;j++) {
				arr= sh.getRow(i).getCell(j).toString();
				
						if((i==0 &&j==0)||(i==0&&j==1))
						{
							System.out.println(arr);
						}			
				}
			System.out.println("\n");
		}

	}

}
