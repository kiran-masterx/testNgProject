package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	public static void readExcelFile(String filePath) {
		try {
			FileInputStream fileInputStream = new FileInputStream(new File(filePath));
			workbook = new XSSFWorkbook(fileInputStream);
			sheet = workbook.getSheetAt(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getData(int row, int column) {
		XSSFRow xssfRow = sheet.getRow(row);
		XSSFCell xssfCell = xssfRow.getCell(column);
		return xssfCell.getStringCellValue();
	}

	public static String getData(String key) {
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell cell = row.getCell(0); // Assuming the key is in the first column
			if (cell.getStringCellValue().equals(key)) {
				XSSFCell valueCell = row.getCell(1); // Assuming the value is in the second column
				return valueCell.getStringCellValue();
			}
		}
		return "Check the key name"; // Return null if the key is not found
	}

	public static void printValuesForKey(String key) {
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell cell = row.getCell(0); // Assuming the key is in the first column
			if (cell.getStringCellValue().equals(key)) {
				System.out.println("Values for key '" + key + "':");
				for (int j = 1; j <= row.getLastCellNum(); j++) {
					XSSFCell valueCell = row.getCell(j);
					if (valueCell != null) {
						System.out.print(valueCell.getStringCellValue() + " | ");
					}
				}
				System.out.println();
			}
		}
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
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return data;

	}

}
