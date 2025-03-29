package com.qa.ctf.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * The {@code ExcelReader} class provides utility methods to read data from Excel files.
 * <p>
 * This class supports reading data from sheets by name or index and returns a list of maps,
 * where each map represents a row with column headers as keys and corresponding cell values
 * as values.
 * </p>
 *
 * <p>Features:
 * <ul>
 *   <li>Read Excel data into a structured list of maps.</li>
 *   <li>Support for both string and numeric data.</li>
 *   <li>Handles empty rows and missing values gracefully.</li>
 * </ul>
 *
 * <p>Exception Handling:
 * <ul>
 *   <li>Throws {@code IndexOutOfBoundsException} if the sheet index is invalid.</li>
 *   <li>Custom exceptions are thrown in case of invalid file paths, unsupported file
 *        formats, or errors while reading the data.</li>
 *   <li>Detailed logging is provided for successful data extraction and error
 *       scenarios.</li>
 *   <li>Handles IO exceptions when working with files.</li>
 * </ul>
 *
 * <p>Example Usage:
 * <pre>
 * {@code
 * try (ExcelReader excelReader = new ExcelReader("data.xlsx")) {
 *     List<Map<String, String>> sheetData = excelReader.getData("Sheet1");
 *     for (Map<String, String> row : sheetData) {
 *         System.out.println(row);
 *     }
 * }
 * }
 * </pre>
 *
 * @author Jagatheshwaran N
 * @version 1.0
 */
public class ExcelReader implements Closeable {

    // Logger instance for the ExcelReader class to enable logging during the execution
    private static final Logger log = LogManager.getLogger(ExcelReader.class);

    // Workbook to represent the Excel workbook object
    private final Workbook workbook;

    /**
     * Constructs an ExcelReader instance for the specified file.
     *
     * @param filePath path to the Excel file (.xlsx or .xls).
     * @throws IllegalArgumentException         if filePath is null or empty.
     * @throws ExceptionHub.ConfigTypeException If the file is not found or cannot
     *                                          be loaded.
     */
    public ExcelReader(String filePath) {
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }
        try {
            this.workbook = WorkbookFactory.create(new File(filePath));
        } catch (FileNotFoundException ex) {
            log.error("The excel file was not found at the given path: '{}'", filePath, ex);
            throw new ExceptionHub.ConfigTypeException(filePath, ex);
        } catch (IOException ex) {
            log.error("Error occurred while loading the excel file from path: '{}'", filePath, ex);
            throw new ExceptionHub.ConfigTypeException(filePath, ex);
        }
    }

    /**
     * Reads data from the specified sheet by name.
     *
     * @param sheetName name of the sheet to read.
     * @return List of maps representing rows (key=column header, value=cell content).
     * @throws ExceptionHub.ExcelException If sheetName is null or sheet doesn't exist.
     */
    public List<Map<String, String>> getData(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new ExceptionHub.ExcelException(
                    String.format("Sheet '%s' not found in workbook.", sheetName));
        }
        return readSheet(sheet);
    }

    /**
     * Reads data from the sheet at the specified index (0-based).
     *
     * @param sheetIndex Index of the sheet to read.
     * @return List of maps representing rows (key=column header, value=cell content).
     * @throws IndexOutOfBoundsException If sheetIndex is invalid.
     * @throws ExceptionHub.ExcelException  If the sheet is not found.
     */
    public List<Map<String, String>> getData(int sheetIndex) {
        if (sheetIndex < 0 || sheetIndex >= workbook.getNumberOfSheets()) {
            throw new IndexOutOfBoundsException("Invalid sheet index: " + sheetIndex);
        }
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        if (sheet == null) {
            throw new ExceptionHub.ExcelException(
                    String.format("Sheet at index '%d' not found in workbook.", sheetIndex));
        }
        return readSheet(sheet);
    }

    /**
     * Reads data from the given sheet and converts it into a list of maps.
     *
     * @param sheet The sheet to read.
     * @return A list of maps representing the sheet row data.
     */
    private List<Map<String, String>> readSheet(Sheet sheet) {
        List<Map<String, String>> excelRows = new ArrayList<>();
        int headerRowNum = getHeaderRowNum(sheet);

        if (headerRowNum == -1) {
            return excelRows; // No headers found
        }

        Row headerRow = sheet.getRow(headerRowNum);
        int totalColumns = headerRow.getLastCellNum();

        for (int rowNum = headerRowNum + 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            Row currentRow = sheet.getRow(rowNum);
            if (currentRow == null) continue; // Skip empty rows

            Map<String, String> rowData = new HashMap<>();
            for (int colNum = 0; colNum < totalColumns; colNum++) {
                String header = getCellValueAsString(headerRow.getCell(colNum));
                String cellValue = getCellValueAsString(currentRow.getCell(colNum));
                rowData.put(header, cellValue);
            }
            excelRows.add(rowData);
        }
        return excelRows;
    }

    /**
     * Identifies the first non-empty row as the header row.
     *
     * @param sheet The sheet to analyze.
     * @return The header row number, or -1 if no headers are found.
     */
    private int getHeaderRowNum(Sheet sheet) {
        for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
            Row row = sheet.getRow(rowNum);
            if (row != null && !isRowEmpty(row)) {
                return rowNum;
            }
        }
        return -1;
    }

    /**
     * Checks if a row is completely empty.
     *
     * @param row The row to check.
     * @return {@code true} if all cells of the row is empty, otherwise {@code false}.
     */
    private boolean isRowEmpty(Row row) {
        for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {
            Cell cell = row.getCell(cellNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            if (cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

    /**
     * Converts a cell value to a string representation.
     *
     * @param cell The cell to convert.
     * @return The string value of the cell, or empty string for null/blanks.
     */
    private String getCellValueAsString(Cell cell) {
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> NumberToTextConverter.toText(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case ERROR -> String.valueOf(cell.getErrorCellValue());
            default -> "";
        };
    }

    /**
     * Closes the workbook and releases resources.
     *
     * @throws IOException If an error occurs while closing the workbook.
     */
    public void close() throws IOException {
        if (workbook != null) {
            workbook.close();
        }
    }

}
