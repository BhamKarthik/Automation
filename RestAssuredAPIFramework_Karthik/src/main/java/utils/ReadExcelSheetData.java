package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

//@Test()
public class ReadExcelSheetData{
	public static Map<String, String> dataMap = new HashMap<String, String>();

	public Map<String, Object> setMapData(String sheetname) throws IOException {
		try {
			String path = System.getProperty("user.dir") + "/inputs/TestData.xlsx";
			FileInputStream fis = new FileInputStream(path);
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet(sheetname);
			int lastRow = sheet.getLastRowNum();
			for (int i = 0; i <= lastRow; i++) {
				Row row = sheet.getRow(i);
				Cell keyCell = (Cell) row.getCell(0);
				Cell valueCell = (Cell) row.getCell(1);
				String key = keyCell.getStringCellValue().trim();
				String value = valueCell.getStringCellValue().trim();
				System.out.println("key=" + key + " ,value=" + value);
				dataMap.put(key, value);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}