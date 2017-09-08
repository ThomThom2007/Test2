package problemConfiguration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PhysicianScheduling {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {

		Data data = new Data("11-15_Modell_modified.xlsm");
		
		data.readInPersonen();
		data.readInTage();
		data.readInDienste();
		data.readInParameter();
		
//		System.out.println("Hallo: " + data.sizeOfPersonen());
//		for(Person p : data.Personen){
//			System.out.println("Name: "+ data.Personen.indexOf(p) + "\t" + p.name);
//		}
//		for(Tag t : data.Tage){
//			System.out.println("Tag: "+ data.Tage.indexOf(t) + "\t" + t.weekday);
//		}
//		data.fillIn();
//		Model m = new Model("a");
//		for(String str :m.sets){
//			System.out.println(str);
//		}
//		System.out.println("0 " + m.sets.get(0)+"\n");
//		for(String str : m.constraints){
//			System.out.println(str);
//		}
	}
	
	private static void testAusgabe(){
		Model m = new Model("m");
		System.out.println(m.getCName() + "[" );
	}
	
	private static void testReadIn() throws EncryptedDocumentException, InvalidFormatException, IOException{
		Workbook wbIn = new XSSFWorkbook("11-15_Modell_modified.xlsm");
		Sheet sheet = wbIn.getSheet("Personal");
		String pName;
		
		Row row = sheet.getRow(9);
		Cell cell = row.getCell(1);
		
		System.out.println("Cell 9:1" + cell.getStringCellValue());
		
//		double lsRow = clIn.getNumericCellValue();
//		int ilsRow = (int)(lsRow);
//		for(int i = 1;i <= ilsRow; i++){
//			rwIn = shIn.getRow(i);
//			clIn = rwIn.getCell(0);
//			pName = clIn.toString();
//			System.out.println(pName);
//		}
	}
	
	private static void testExcelAPI() throws EncryptedDocumentException, InvalidFormatException, IOException{
        Workbook wb = new XSSFWorkbook();

        Sheet sheet = wb.createSheet();
        Row row = sheet.createRow((short) 2);
        row.setHeightInPoints(30);

        createCell(wb, row, (short) 0, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_BOTTOM);
        createCell(wb, row, (short) 1, CellStyle.ALIGN_CENTER_SELECTION, CellStyle.VERTICAL_BOTTOM);
        createCell(wb, row, (short) 2, CellStyle.ALIGN_FILL, CellStyle.VERTICAL_CENTER);
        createCell(wb, row, (short) 3, CellStyle.ALIGN_GENERAL, CellStyle.VERTICAL_CENTER);
        createCell(wb, row, (short) 4, CellStyle.ALIGN_JUSTIFY, CellStyle.VERTICAL_JUSTIFY);
        createCell(wb, row, (short) 5, CellStyle.ALIGN_LEFT, CellStyle.VERTICAL_TOP);
        createCell(wb, row, (short) 6, CellStyle.ALIGN_RIGHT, CellStyle.VERTICAL_TOP);

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("xssf-align.xlsx");
        wb.write(fileOut);
        fileOut.close();
		
	}
	
	private static void createCell(Workbook wb, Row row, short column, short halign, short valign) {
        Cell cell = row.createCell(column);
        cell.setCellValue("Align It");
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
        cell.setCellStyle(cellStyle);
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
