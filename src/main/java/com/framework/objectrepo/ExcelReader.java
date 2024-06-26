package com.framework.objectrepo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private String filepath;
	private XSSFWorkbook workbook;
	private Sheet sheet;
	private Row row;
	private Cell cell;

	public ExcelReader(String filepath) throws IOException {
		this.filepath = filepath;
		FileInputStream fis = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fis);
	}

	public Sheet getSheet(String type, String value) {
		if (type.equalsIgnoreCase("sheetname")) {
			sheet = workbook.getSheet(value);
		} else if (type.equalsIgnoreCase("sheetname")) {
			int index = Integer.parseInt(value);
			sheet = workbook.getSheetAt(index);

		} else {
			System.out.println("Workbook pointing to null");
		}
		return sheet;
	}

	public String getcellData(String type, String value, int rowNum, int cellnum) {
		sheet = getSheet(type, value);
		if (sheet != null) {
			row = sheet.getRow(rowNum);
			if (row != null) {
				cell = row.getCell(cellnum);
				if (cell != null) {
					if (cell.getCellType() == CellType.STRING) {
						value = cell.getStringCellValue();
					} else if (cell.getCellType() == CellType.NUMERIC) {
						value = cell.getNumericCellValue() + "";
					}
				}
			}
			
		}
		return value;
	}
}
