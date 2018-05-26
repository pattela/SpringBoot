package com.springApplication.springBoot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static void main(String[] args) throws IOException {
		try {
			FileInputStream inputFile = new FileInputStream("");
			Workbook workbook = new XSSFWorkbook("inputFile");
			Sheet sheet = workbook.getSheet("");
			Iterator<Row>  rowIterator = sheet.iterator();
			while(rowIterator.hasNext()) {
				Row currentRow = rowIterator.next();
				Iterator<Cell> cell = currentRow.iterator();
				 while(cell.hasNext()) {
					 Cell currentCell = cell.next();
					 if(currentCell.getCellTypeEnum() == CellType.STRING) {
						 System.out.print(currentCell.getStringCellValue() + "|");
					 } else if(currentCell.getCellTypeEnum() == CellType.NUMERIC){
						 System.out.print(currentCell.getNumericCellValue() + "|");
					 }
				 }
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
