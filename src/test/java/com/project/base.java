package com.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	static WebDriver driver;

	public static void Browerlunach() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public static void lunachurl(String url) {
		driver.get(url);

	}

	public static void windowsmax() {
		driver.manage().window().maximize();
	}

	public static void passTXt(WebElement traget, String text) {
		traget.sendKeys(text);

	}

	public static void getAttribut(WebElement traget) {

		String t = traget.getAttribute("value");

		System.out.println("Attribute =" + t);

	}

	public static String getcurrenttittel() {
		String title = driver.getTitle();
		return title;

	}

	public static void closed() {
		driver.close();

	}

	public static void click(WebElement cli) {
		cli.click();
	}

	public static void close() {
		close();
	}

	private static String Excelread(int rowdata, int celldata) throws IOException {

		File f = new File("C:\\Users\\91866\\Documents\\workpase\\BalaTest\\ExcalSheert\\Book1.xlsx");

		FileInputStream fis = new FileInputStream(f);

		Workbook b = new XSSFWorkbook(fis);

		Sheet h = b.getSheet("Sheet1");

		Row row = h.getRow(rowdata);

		Cell cell = row.getCell(celldata);

		int v = cell.getCellType();
		String hh = "";
		// string cell
		if (v == 1) {
			hh = cell.getStringCellValue();
			System.out.println(hh);

		}

		else if (DateUtil.isCellDateFormatted(cell)) {
			Date value = cell.getDateCellValue();
			SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");
			hh = d.format(value);
			System.out.println(hh);

		}

		else {
			double numer = cell.getNumericCellValue();
			long l = (long) numer;
			hh = String.valueOf(1);
			System.out.println(hh);

		}

		return hh;
	}

}
