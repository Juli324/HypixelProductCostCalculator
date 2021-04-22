package JSONPull;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

public class JSONBuilder {
    public JSONObject buildFromConnection(HttpURLConnection connection) throws IOException {
        StringBuilder content = new StringBuilder();
        connection.setRequestMethod("GET");
        connection.connect();
        if (connection.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()), 640 * 1024);
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
        }
        return new JSONObject(content.toString());
    }
}
