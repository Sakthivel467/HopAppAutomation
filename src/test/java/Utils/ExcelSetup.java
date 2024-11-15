package Utils;

import extentReport.Constants;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

import static DriverSetup.BaseTest.testcase;



public class ExcelSetup extends ReadProperties {
    public String getTestData(String columnNameToRead) throws Exception {
        String testCaseNameToRead =testcase;  // Specify the test case name you want to read

        FileInputStream fileInputStream = new FileInputStream(Constants.TEST_DATA_PATH);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet("Sheet1"); // Replace with your sheet name

        int rowCount = sheet.getLastRowNum();
        String cellValue = null;
        // Find the column index based on the column name
        int columnIndexToRead = -1;
        Row headerRow = sheet.getRow(0); // Assuming the header row is in the first row
        int lastCellIndex = headerRow.getLastCellNum();
        for (int cellIndex = 0; cellIndex < lastCellIndex; cellIndex++) {
            Cell cell = headerRow.getCell(cellIndex);
            if (cell != null && cell.toString().equals(columnNameToRead)) {
                columnIndexToRead = cellIndex;
                break;
            }
        }

        if (columnIndexToRead == -1) {
            throw new IllegalArgumentException("Column name not found: " + columnNameToRead);
        }
        for (int i = 1; i <= rowCount; i++) { // Start from 1 to skip the header row
            Row row = sheet.getRow(i);

            // Get the test case name from the first column
            Cell testCaseNameCell = row.getCell(0);
            if (testCaseNameCell != null) {
                String testCaseName = testCaseNameCell.toString();

                // Check if the row's test case name matches the desired test case
                if (testCaseName.equals(testCaseNameToRead)) {
                    // Get data from the specified column
                    Cell cell = row.getCell(columnIndexToRead);
                    if (cell != null) {
                        cellValue = cell.toString();
                        // Process the cell value (e.g., print it or use it in your test logic)
                       // System.out.println("Test Case: " + testCaseNameToRead);
                       // System.out.println("Data from " + columnNameToRead + ": " + cellValue);
                    }
                }
            }
        }
        workbook.close();
        return cellValue;
    }
}

