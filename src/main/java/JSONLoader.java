import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class JSONLoader {
    public static ArrayList<BazaarItem> getBazaarList(JSONObject file) {
        ArrayList<BazaarItem> b = new ArrayList<>();
        JSONObject products = file.getJSONObject("products");
        Iterator<String> items = products.keys();
        while (items.hasNext()) {
            JSONObject c = products.getJSONObject(items.next());
            b.add(new BazaarItem(c.getJSONObject("quick_status")));
        }
        return b;
    }

    public static JSONObject getBazaarJSON() {
        StringBuffer content = new StringBuffer();
        try {
            int bufferSize = 640 * 1024;
            URL url = new URL("https://api.hypixel.net/skyblock/bazaar");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            if (connection.getResponseCode() == 200) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()), bufferSize);
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine + "\n");
                }
                in.close();
            }
            connection.disconnect();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./data/bazaar.json"));
            bufferedWriter.write(content.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONObject(content.toString());
    }
}
