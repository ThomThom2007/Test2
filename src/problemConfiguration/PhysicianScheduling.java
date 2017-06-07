package problemConfiguration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PhysicianScheduling {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {
		System.out.println("Hello World");
		testStream(); 
//		testExcelAPI();
	}
	
	private static void testExcelAPI() throws EncryptedDocumentException, InvalidFormatException, IOException{
		
//Reading and Rewriting Excel content
		InputStream inp = new FileInputStream("C:/a/test.xls");
	    Workbook wb = WorkbookFactory.create(inp);
	    Sheet sheet = wb.getSheetAt(0);
	    Row row = sheet.getRow(0);
	    Cell cell = row.getCell(0);
	    if (cell == null)
	        cell = row.createCell(1);
	    cell.setCellType(CellType.STRING);
	    cell.setCellValue("a test");
		
//Write output to the Excel file
		FileOutputStream oup = new FileOutputStream("test.xlsx");
		wb.write(oup);
		oup.close();
	}
	
	private static void testStream() throws IOException{
		InputStream inp = new FileInputStream("C:/a/test.txt");
		char a; 
		while(inp.available() != 0){
			a = (char) inp.read();
			System.out.print(a);
		}
		inp.close();
	}

}
