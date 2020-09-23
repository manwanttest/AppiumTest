package Utilities;

import java.io.FileInputStream;
import org.testng.annotations.DataProvider;

import Helpers.LoggerHelper;
import jxl.Sheet;
import jxl.Workbook;

public class ReadDatafromExcel {

	static String[][] arrayExcelData = null;

	public static String[][] getExcelData(String fileName, String sheetName) {
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);
			LoggerHelper.log("Workbook Object: " + wb);
			LoggerHelper.log("Sheet Object: " + sh);
			int totalNoOfCols = sh.getColumns();
			LoggerHelper.log("Total No. of Columns: " + totalNoOfCols);
			int totalNoOfRows = sh.getRows();
			LoggerHelper.log("Total No. of Rows: " + totalNoOfRows);
			int Excludingheading = totalNoOfRows - 1;
			LoggerHelper.log("After excluding Heading: " + Excludingheading);
			arrayExcelData = new String[Excludingheading][totalNoOfCols];
			for (int i = 1; i < totalNoOfRows; i++) {
				for (int j = 0; j < totalNoOfCols; j++) {
					LoggerHelper.log("Value of j: " + j);
					LoggerHelper.log("Value of i: " + i);
					String content = sh.getCell(j, i).getContents();
					LoggerHelper.log("Content coming is: " + content);
					LoggerHelper.log("arrayExcelData[i-1] coming is: " + arrayExcelData[i - 1]);
					arrayExcelData[i - 1][j] = content;
					LoggerHelper.log("Final arrayExcelData[i-1] coming is: " + arrayExcelData[i - 1][j]);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		LoggerHelper.log("arrayExcelData before returning: " + arrayExcelData);
		return arrayExcelData;
	}

	@DataProvider(name = "shopname")
	public static Object[][] loginData() {
		Object[][] arrayObject = getExcelData(System.getProperty("user.dir")+"\\src\\main\\java\\Utilities\\Data.xls", "Sheet1");
		LoggerHelper.log("arrayObject: " + arrayObject.length);
		return arrayObject;
	}

}
