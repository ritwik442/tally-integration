package Code;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    public List<Transaction> readExcel(String filePath) throws IOException {
        List<Transaction> transactions = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int x=0;
        for (Row row : sheet) {
            

            String date = row.getCell(0).toString();
            String narration = row.getCell(1).toString();
            double withdrawalAmount = row.getCell(2).getNumericCellValue();
            double depositAmount = row.getCell(3).getNumericCellValue();
            double closingBalance = row.getCell(4).getNumericCellValue();

            transactions.add(new Transaction(date, narration, withdrawalAmount, depositAmount, closingBalance));
            x=x+1;
            if (x>13) {
            	break;
            }
        }

        workbook.close();
        fileInputStream.close();

        return transactions;
    }
}

class Transaction {
    String date;
    String narration;
    double withdrawalAmount;
    double depositAmount;
    double closingBalance;

    public Transaction(String date, String narration, double withdrawalAmount, double depositAmount, double closingBalance) {
        this.date = date;
        this.narration = narration;
        this.withdrawalAmount = withdrawalAmount;
        this.depositAmount = depositAmount;
        this.closingBalance = closingBalance;
    }
}
