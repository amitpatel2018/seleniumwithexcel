package utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilsDP {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public ExcelUtilsDP (String excelPath, String sheetName) {
		try {
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getRowCount() {
		int rowCount = sheet.getPhysicalNumberOfRows();
		// System.out.println(rowCount);
		return rowCount;
	}
	
	public int getColumnCount() {
		int colCount = sheet.getRow(1).getPhysicalNumberOfCells();
		// System.out.println(colCount);
		return colCount;
	}
	
	public String getCellData(int rowNum, int colNum) {
		XSSFCell cell = sheet.getRow(rowNum).getCell(colNum);
		DataFormatter dataFormatter = new DataFormatter();
		String cellValue = dataFormatter.formatCellValue(cell);
		return cellValue;
	}
}
