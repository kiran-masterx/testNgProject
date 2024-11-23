package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataReader {

	@DataProvider(name = "cogmentoData")
	public Object[][] excelDataProvider() throws FileNotFoundException {
		Object[][] arr = getExcelData(
				"C:\\Users\\Lenovo\\git\\Framework-MasterX\\src\\main\\java\\TestData\\CogmentoTestData.xlsx",
				"Sheet1");
		return arr;

	}

	public String[][] getExcelData(String fileName, String sheetName) throws FileNotFoundException {
		String[][] data = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(0);
			int noOfRows = sheet.getPhysicalNumberOfRows();
			int noOfCols = row.getLastCellNum();
			Cell cell;
		
			data = new String[noOfRows - 1][noOfCols];
		
			for (int i = 1; i < noOfRows; i++) {
				for (int j = 0; j < noOfCols; j++) {
					row = sheet.getRow(i);
					cell = row.getCell(j);
					data[i - 1][j] = cell.getStringCellValue();
				}
			}
		}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			return data;
		
		}

}
