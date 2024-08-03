package Code;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TallyConnector {
    public void sendRequest(String xmlData) throws IOException {
        URL url = new URL("http://localhost:9000");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/xml");

        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(xmlData.getBytes());
        outputStream.flush();
        outputStream.close();

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            System.out.println("Data sent successfully");
        } else {
            System.out.println("Failed to send data. HTTP response code: " + responseCode);
        }

        connection.disconnect();
    }
}
