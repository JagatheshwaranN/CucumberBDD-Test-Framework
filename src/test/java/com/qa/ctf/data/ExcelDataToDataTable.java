package com.qa.ctf.data;

import com.qa.ctf.factory.DriverFactory;
import io.cucumber.core.backend.ParameterInfo;
import io.cucumber.cucumberexpressions.Transformer;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableTypeRegistry;
import io.cucumber.datatable.DataTableTypeRegistryTableConverter;

import java.lang.reflect.Type;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;


public class ExcelDataToDataTable  {

    public static DataTable convertToDataTable(String sheetName) {
        List<Map<String, String>> dataFromExcel = DriverFactory.excelReader.getData(sheetName);

        System.out.println(dataFromExcel);

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

        // Create an empty DataTableTypeRegistry (Cucumber requires one)
        DataTableTypeRegistry registry = new DataTableTypeRegistry(Locale.getDefault());

        // Create a TableConverter using the registry
        DataTableTypeRegistryTableConverter tableConverter = new DataTableTypeRegistryTableConverter(registry);

        return DataTable.create(tableData, tableConverter);
    }

}
