package utilities;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	
	@DataProvider(name = "ElementsTextboxTestData")
	public static Object[][] getData() {
		String projectPath = System.getProperty("user.dir");
		String excelPath = projectPath + "/testdata.xlsx";
		String sheetName = "Sheet1";
		Object[][] data = getExcelData(excelPath, sheetName);
		return data;
	}
	
	public static Object[][] getExcelData(String excelPath, String sheetName) {
		ExcelUtilsDP excelUtils = new ExcelUtilsDP(excelPath, sheetName);
		int rowCount = excelUtils.getRowCount();
		int colCount = excelUtils.getColumnCount();
		Object[][] data = new Object[rowCount-1][colCount];
		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				String cellData = excelUtils.getCellData(i, j);
				data[i-1][j] = cellData;
				// System.out.print(data[i-1][j] + " | ");
			}
			// System.out.println();
		}
		return data;
	}
}
