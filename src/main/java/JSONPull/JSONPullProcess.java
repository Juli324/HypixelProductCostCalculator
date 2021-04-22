package JSONPull;

import org.json.JSONObject;
import tools.JSONFileWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONPullProcess {

    private final String URL, path;

    public JSONPullProcess(String path, String URL) {
        this.URL = URL;
        this.path = path;
    }

    public void run() {
        try {
            java.net.URL url = new URL(URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            JSONFileWriter writer = new JSONFileWriter(path);
            writer.writeJSON(new JSONObject(new JSONBuilder().buildFromConnection(connection)));
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JSONPullProcess process = new JSONPullProcess("data/test.json", "https://api.hypixel.net/skyblock/bazaar");
        process.run();
    }
}
