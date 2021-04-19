import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

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
            FileWriter wrt = new FileWriter("./data/bazaar.json");
            if (connection.getResponseCode() == 200) {
                Scanner in = new Scanner(connection.getInputStream());
                while (in.hasNext()) {
                    String next = in.next();
                    wrt.write(next);
                    content.append(next);
                }
                in.close();
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONObject(content);
    }
}
