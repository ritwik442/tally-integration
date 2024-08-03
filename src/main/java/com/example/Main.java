package Code;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "D:\\Vijay Shubham work\\Book1.xlsx";
        ExcelReader excelReader = new ExcelReader();
        TallyConnector tallyConnector = new TallyConnector();

        try {
            List<Transaction> transactions = excelReader.readExcel(filePath);

            for (Transaction transaction : transactions) {
                if (transaction.withdrawalAmount < 1000) {
                    String xmlData = XMLGenerator.generateXML(transaction);
                    tallyConnector.sendRequest(xmlData);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
