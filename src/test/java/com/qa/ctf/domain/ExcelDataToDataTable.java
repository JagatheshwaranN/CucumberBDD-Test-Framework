package com.qa.ctf.domain;

import com.qa.ctf.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableTypeRegistry;
import io.cucumber.datatable.DataTableTypeRegistryTableConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Utility class for converting Excel data into a {@link DataTable} for use in Cucumber
 * tests.
 * <p>
 * This class provides a method to convert a specific sheet's data from an Excel file
 * into a {@link DataTable}, which is useful for parameterizing Cucumber scenarios with
 * data read from Excel files.
 * </p>
 *
 * @author Jagatheshwaran N
 * @version 1.0
 */
public class ExcelDataToDataTable {

    /**
     * Converts the data from an Excel sheet into a {@link DataTable}.
     * <p>
     * This method reads the data from an Excel sheet, extracts the headers, and
     * then constructs a DataTable that can be used in Cucumber tests. It ensures
     * that the data from the Excel sheet is correctly mapped
     * to the DataTable format.
     * </p>
     *
     * @param sheetName The name of the sheet in the Excel file from which the data
     *                  is to be read.
     * @return A {@link DataTable} containing the data from the Excel sheet.
     * @throws IllegalArgumentException If the Excel sheet is empty or no data is found.
     */
    public static DataTable convertToDataTable(String sheetName) {
        List<Map<String, String>> dataFromExcel = DriverFactory.excelReader.getData(sheetName);
        if(dataFromExcel.isEmpty()){
            throw new IllegalArgumentException("Excel data is empty, cannot convert to DataTable");
        }
        List<String> headers = new ArrayList<>(dataFromExcel.getFirst().keySet());
        List<List<String>> tableData = new ArrayList<>();
        tableData.add(headers);
        for(Map<String, String> row: dataFromExcel) {
            List<String> rowData = new ArrayList<>();
            for(String header : headers) {
                rowData.add(row.getOrDefault(header, ""));
            }
            tableData.add(rowData);
        }
        DataTableTypeRegistry registry = new DataTableTypeRegistry(Locale.getDefault());
        DataTableTypeRegistryTableConverter tableConverter = new DataTableTypeRegistryTableConverter(registry);
        return DataTable.create(tableData, tableConverter);
    }

}
