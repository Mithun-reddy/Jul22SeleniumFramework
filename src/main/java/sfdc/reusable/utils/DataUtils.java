package sfdc.reusable.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import sfdc.com.ExtentReportDemo;

public class DataUtils {
	
	private static Logger logger = LogManager.getLogger(DataUtils.class);

	public static String readPropertiesFile(String filename, String key) throws IOException {

		Properties p = new Properties();
		FileReader prop = new FileReader(System.getProperty("user.dir")+ "\\src\\main\\java\\testdata\\"+filename+".properties");
		p.load(prop);
		String value= p.getProperty(key);
		return value;
	}

	public static void writeToPropertiesfile() {

	}

	public static String readExcel(String fileName, int rowNumber, int cellNumber) throws IOException {
//		.xlsx
		String filepathXLSX = System.getProperty("user.dir")+ "\\src\\main\\java\\testdata\\"+fileName+".xlsx";
		FileInputStream fis = new FileInputStream(filepathXLSX);
		XSSFWorkbook testData = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = testData.getSheetAt(0);
		String data = sheet1.getRow(rowNumber).getCell(cellNumber).toString();
		String pass ="";
		
//		for(int rownum = 0; rownum<sheet1.getLastRowNum(); rownum++) {
//			for (int coloumn=0; coloumn<sheet1.getRow(rownum).getLastCellNum(); coloumn++) {
//				String value = sheet1.getRow(rownum).getCell(coloumn).toString();
//			}
//		}
//		Map<String, String> loginCreds = new HashedMap<>();
//		loginCreds.put(data, pass)
		return data;
	}
	
	public void writeToExcel(String filename) throws IOException {
		
		String filepathXLSX = System.getProperty("user.dir")+ "\\src\\main\\java\\testdata\\"+filename+".xlsx";

		XSSFWorkbook workbook =  new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(filepathXLSX);
		XSSFRow row0 = sheet.createRow(0);
		row0.createCell(0).setCellValue("");
		FileOutputStream fout = new FileOutputStream("");
		workbook.write(fout);
		fout.close();
		
	}
}
