package UtilityLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SpreadSheetsUtils {
	private XSSFWorkbook workbook;
	private String filePath;
	private FileInputStream fis;

	public SpreadSheetsUtils(String filePath) throws IOException {
		this.filePath = filePath;
		fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
	}

	/**
	 * This Keyword is to export a data from the scripts to the Excel file
	 * 
	 * @param fileName  is the name of the excel file where the data has to be exported
	 * @param sheetName is the name of the sheet from the excel file where the data has to be exported.
	 * @param rowNum    is the int value of row where the data has to be exported
	 * @param column    is the name of the column where the data has to be exported
	 * @param output    is value that needs to be exported
	 * @throws IOException
	 */
	public void writeData(String sheetName, int rowNum, String column, String output) throws IOException {
		int lastCell = workbook.getSheet(sheetName).getRow(0).getLastCellNum();
		int colIndex = 0;
		for (int colNum = 0; colNum < lastCell; colNum++) {
			String header = workbook.getSheet(sheetName).getRow(0).getCell(colNum).getStringCellValue();
			if (header.equalsIgnoreCase(column)) {
				colIndex = colNum;
				break;
			}
		}
		FileOutputStream fos = new FileOutputStream(filePath);
		workbook.getSheet(sheetName).getRow(rowNum).createCell(colIndex).setCellValue(output);
		workbook.write(fos);
		workbook.close();
	}

	/**
	 * This Keyword is to get the exported data from the scripts to the Excel file
	 * @param fileName  is the name of the excel file where the data has exported
	 * @param sheetName is the name of the sheet from the excel file where the data has exported
	 * @param rowNum    is the int value of row where the data has exported
	 * @param column    is the name of the column where the data has exported
	 * @return String
	 * @throws IOException
	 */
	public String getData(String sheetName, int rowNum, String column) throws IOException {
		int lastCell = workbook.getSheet(sheetName).getRow(0).getLastCellNum();

		int colIndex = 0;
		for (int colNum = 0; colNum < lastCell; colNum++) {
			String header = workbook.getSheet(sheetName).getRow(0).getCell(colNum).getStringCellValue();
			if (header.equalsIgnoreCase(column)) {
				colIndex = colNum;
				break;
			}
		}
		String exportedData = workbook.getSheet(sheetName).getRow(rowNum).getCell(colIndex).getStringCellValue();
		workbook.close();
		return exportedData;
	}

	public Map<String, Integer> getAllColumn() throws IOException {
		Map<String, Integer> columnData = new LinkedHashMap<String, Integer>();
		int columnNum = workbook.getSheet("CandidateData").getRow(0).getLastCellNum();
		for (int cellNum = 0; cellNum < columnNum; cellNum++) {
			columnData.put(workbook.getSheet("CandidateData").getRow(0).getCell(cellNum).getStringCellValue(), cellNum);
		}
		workbook.close();
		return columnData;
	}

	public List<String> getAllColumnNames() throws IOException {
		List<String> columnData = new LinkedList<String>();
		int columnNum = workbook.getSheet("CandidateData").getRow(0).getLastCellNum();
		for (int cellNum = 0; cellNum < columnNum; cellNum++) {
			columnData.add(workbook.getSheet("CandidateData").getRow(0).getCell(cellNum).getStringCellValue());
		}
		workbook.close();
		return columnData;
	}

	public String getStringValue(String sheetName, String columnName, int rowIndex) throws IOException {
		String value = null;
		if (getAllColumn().containsKey(columnName)) {
			value = workbook.getSheet(sheetName).getRow(rowIndex).getCell(getAllColumn().get(columnName))
					.getStringCellValue();
		} else {
			System.err.println("There is no data available");
		}
		return value;
	}

	public String getStringValue(String sheetName, String columnName, String refName) throws IOException {
		String value = null;
		int index = 0;
		int rowNum = workbook.getSheet(sheetName).getLastRowNum();
		for (index = 0; index < rowNum; index++) {
			if (workbook.getSheet(sheetName).getRow(index).getCell(0).getStringCellValue().equalsIgnoreCase(refName)) {
				break;
			}
		}
		if (getAllColumn().containsKey(columnName)) {
			value = workbook.getSheet(sheetName).getRow(index).getCell(getAllColumn().get(columnName))
					.getStringCellValue();
		}
		return value;
	}

	public int getIndexOf(String sheetName, String refName) {
		int index = 0;
		int rowNum = workbook.getSheet(sheetName).getLastRowNum();
		for (index = 0; index < rowNum; index++) {
			if (workbook.getSheet(sheetName).getRow(index).getCell(0).getStringCellValue().equalsIgnoreCase(refName)) {
				break;
			}
		}
		return index;
	}

	public Map<String, String> getDataCollection(String sheetName, String columnName, String refName) {
		Map<String, String> data = new LinkedHashMap<String, String>();
		int rowNum;
		int colNum;
		int lastRow = workbook.getSheet(sheetName).getLastRowNum();
		int lastCol = workbook.getSheet(sheetName).getRow(0).getLastCellNum();
		for (rowNum = 1; rowNum < lastRow; rowNum++) {
			if (workbook.getSheet(sheetName).getRow(rowNum).getCell(0).getStringCellValue().equalsIgnoreCase(refName)) {
				break;
			}
		}
		for (colNum = 0; colNum < lastCol; colNum++) {
			try {
				if (workbook.getSheet(sheetName).getRow(0).getCell(colNum).getCellType() == CellType.STRING) {
					data.put(workbook.getSheet(sheetName).getRow(0).getCell(colNum).getStringCellValue(),workbook.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue());
				} else if (workbook.getSheet(sheetName).getRow(0).getCell(colNum).getCellType() == CellType.NUMERIC) {
					String value = Double.toString(workbook.getSheet(sheetName).getRow(rowNum).getCell(colNum).getNumericCellValue());
					data.put(workbook.getSheet(sheetName).getRow(0).getCell(colNum).getStringCellValue(),value);
				}
			} catch (NullPointerException i) {
				data.put(workbook.getSheet(sheetName).getRow(0).getCell(colNum).getStringCellValue(), null);
			}
		}
		return data;
	}
	
	// New method added
	public Map<String, String> getMapData(String sheetName, String refName) {
		Map<String, String> data = new LinkedHashMap<String, String>();
		int rowNum;
		int colNum;
		int lastRow = workbook.getSheet(sheetName).getLastRowNum();
		int lastCol = workbook.getSheet(sheetName).getRow(0).getLastCellNum();
		for (rowNum = 1; rowNum < lastRow; rowNum++) {
			if (workbook.getSheet(sheetName).getRow(rowNum).getCell(0).getStringCellValue().equalsIgnoreCase(refName)) {
				break;
			}
		}
		for (colNum = 0; colNum < lastCol; colNum++) {
			try {
				if (workbook.getSheet(sheetName).getRow(0).getCell(colNum).getCellType() == CellType.STRING) {
					data.put(workbook.getSheet(sheetName).getRow(0).getCell(colNum).getStringCellValue(),workbook.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue());
				} else if (workbook.getSheet(sheetName).getRow(0).getCell(colNum).getCellType() == CellType.NUMERIC) {
					String value = Double.toString(workbook.getSheet(sheetName).getRow(rowNum).getCell(colNum).getNumericCellValue());
					data.put(workbook.getSheet(sheetName).getRow(0).getCell(colNum).getStringCellValue(),value);
				}
			} catch (NullPointerException i) {
				data.put(workbook.getSheet(sheetName).getRow(0).getCell(colNum).getStringCellValue(), null);
			}
		}
		return data;
	}
}
