package uitlities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DatadrivenUtlits {

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {

        String path = System.getProperty("user.dir") + "/testData/LoginData.xlsx";

        ExcelUtils excel = new ExcelUtils(path);

        int rows = excel.getRowCount("Sheet1");
        int cols = excel.getCellCount("Sheet1", 1);

        String[][] data = new String[rows][cols];

        for (int i = 1; i <= rows; i++) {       // start from row 1 (skip header)
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = excel.getCellData("Sheet1", i, j);
            }
        }

        excel.close();   // ✅ CLOSE ONLY ONCE

        return data;
    }
}
