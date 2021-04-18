import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
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
            URL url = new URL("https://api.hypixel.net/skyblock/bazaar");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            if (connection.getResponseCode() == 200) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
            }
            connection.disconnect();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./data/bazaar.json"));
            bufferedWriter.write(content.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONObject(content.toString());
    }
}
