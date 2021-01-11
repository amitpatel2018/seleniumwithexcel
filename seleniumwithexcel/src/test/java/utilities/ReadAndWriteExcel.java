package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAndWriteExcel {
	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	
	public ReadAndWriteExcel(String excelPath, String sheetName) {
		try {
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void getNumberOfRows() {
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println(rowCount);
	}
	public String getCellData(int rowNum, int colNum) {
			String data = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			// sheet.getRow(1).getCell(2).getNumericCellValue();
			return data;
	}
}
