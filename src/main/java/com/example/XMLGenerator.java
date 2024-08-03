package Code;
public class XMLGenerator {
    public static String generateXML(Transaction transaction) {
        return "<ENVELOPE>" +
                "<HEADER>" +
                "<TALLYREQUEST>Import Data</TALLYREQUEST>" +
                "</HEADER>" +
                "<BODY>" +
                "<IMPORTDATA>" +
                "<REQUESTDESC>" +
                "<REPORTNAME>All Masters</REPORTNAME>" +
                "</REQUESTDESC>" +
                "<REQUESTDATA>" +
                "<TALLYMESSAGE xmlns:UDF=\"TallyUDF\">" +
                "<VOUCHER>" +
                "<DATE>" + transaction.date + "</DATE>" +
                "<NARRATION>" + transaction.narration + "</NARRATION>" +
                "<VOUCHERTYPENAME>Receipt</VOUCHERTYPENAME>" +
                "<PARTYLEDGERNAME>HDFC BANK</PARTYLEDGERNAME>" +
                "<ALLLEDGERENTRIES.LIST>" +
                "<LEDGERNAME>DRAWING</LEDGERNAME>" +
                "<AMOUNT>" + (-transaction.withdrawalAmount) + "</AMOUNT>" +
                "</ALLLEDGERENTRIES.LIST>" +
                "</VOUCHER>" +
                "</TALLYMESSAGE>" +
                "</REQUESTDATA>" +
                "</IMPORTDATA>" +
                "</BODY>" +
                "</ENVELOPE>";
    }
}
