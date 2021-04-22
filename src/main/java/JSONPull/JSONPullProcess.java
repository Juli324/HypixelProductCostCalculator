package JSONPull;

import tools.JSONFileReader;
import tools.JSONFileWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONPullProcess {

    private final String URL, path;

    public JSONPullProcess(String path, String url) {
        this.URL = url;
        this.path = path;
    }

    public void run() {
        StringBuilder content = new StringBuilder();
        try {
            java.net.URL url = new URL("https://api.hypixel.net/skyblock/bazaar");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            if (connection.getResponseCode() == 200) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()), 640 * 1024);
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine + "\n");
                }
                in.close();
            }
            connection.disconnect();
            JSONFileWriter writer = new JSONFileWriter(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
