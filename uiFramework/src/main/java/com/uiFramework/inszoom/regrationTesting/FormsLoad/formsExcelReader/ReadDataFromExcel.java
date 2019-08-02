package com.uiFramework.inszoom.regrationTesting.FormsLoad.formsExcelReader;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public Object[][] getExcelData(String excelLocation) {

		try {
			Object dataSets[][] = null;

			FileInputStream file = new FileInputStream(excelLocation);
			XSSFWorkbook wkbook = new XSSFWorkbook(file);
			XSSFSheet sheet = wkbook.getSheetAt(0);

			int totalRow = sheet.getLastRowNum();
			int totalColumn = sheet.getRow(0).getLastCellNum();

			dataSets = new Object[totalRow][totalColumn];

			for (int i = 0; i <= totalRow; i++) {
				String cellvalue = sheet.getRow(i).getCell(0).getStringCellValue();
				System.out.println(cellvalue);
				wkbook.close();
			}

			return dataSets;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		String filePath = ".\\src\\main\\resources\\excel\\TestData.xlsx";
		ReadDataFromExcel excel = new ReadDataFromExcel();
		Object[][] data = excel.getExcelData(filePath);
	}
}
