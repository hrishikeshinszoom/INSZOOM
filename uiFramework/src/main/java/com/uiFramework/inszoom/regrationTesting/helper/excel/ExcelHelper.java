package com.uiFramework.inszoom.regrationTesting.helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.uiFramework.inszoom.regrationTesting.helper.Resource.ResourceHelper;
import com.uiFramework.inszoom.regrationTesting.helper.logger.LoggerHelper;

public class ExcelHelper {
	
//	private Logger log = LoggerHelper.getLogger(ExcelHelper.class);

	public Object[][] getExcelData(String excelLocation) {

		try {
			Object dataSets[][] = null;
			FileInputStream file = new FileInputStream(new File(excelLocation));
			
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheetAt(0);

			int totalRow = sheet.getLastRowNum();
			
			int totalColumn = sheet.getRow(0).getLastCellNum();
 
			dataSets = new Object [totalRow][totalColumn];

			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;
			while (rowIterator.hasNext()) {
				i++;
				Row row = rowIterator.next();
				 
				    Iterator<Cell> cellIterator = row.cellIterator();
				    int j = 0;
				    while (cellIterator.hasNext()) {
					
					Cell cell = cellIterator.next();
					
					switch (cell.getCellTypeEnum()) {
					case STRING:
						dataSets[i-1][j] = cell.getStringCellValue();
						System.out.println(cell.getStringCellValue());
						break;
					case NUMERIC:
						dataSets[i-1][j] = cell.getNumericCellValue();
						System.out.println(cell.getNumericCellValue());
						break;
					case BOOLEAN:
						dataSets[i-1][j] = cell.getBooleanCellValue();
						System.out.println(cell.getBooleanCellValue());
					default:
						System.out.println("no matching enum date type found");
						break;
					}
				}
			}
			return dataSets;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	/*public void updateResult(String excelLocation, String sheetName, String testCaseName, String testStatus){
		try{
			FileInputStream file = new FileInputStream(new File(excelLocation));
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheet(sheetName);
			int totalRow = sheet.getLastRowNum()+1;
			for(int i =1; i<totalRow; i++){
				XSSFRow r = sheet.getRow(i);
				String ce = r.getCell(0).getStringCellValue();
				if(ce.contains(testCaseName)){
					r.createCell(1).setCellValue(testStatus);
					file.close();
					log.info("result updated..");
					FileOutputStream out = new FileOutputStream(new File(excelLocation));
					workbook.write(out);
					out.close();
					break;
				}
			}
		}
		catch(Exception e){
			
		}
	}*/
	
	public static void main(String[] args) throws IOException{
	 String excelLocation = "/Users/RISHIKESH/Desktop/New Microsoft Excel Worksheet.xlsx";
	 ExcelHelper excel = new ExcelHelper();
	 Object [][] data = excel.getExcelData(excelLocation);
//	 String excelLocation = ResourceHelper.getResourcePath("C:/Users/RISHIKESH/Desktop/testData.xlsx");
	
	 System.out.println(data);
	}
}
