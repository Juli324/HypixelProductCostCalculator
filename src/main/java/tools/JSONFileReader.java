package tools;

import org.json.JSONObject;

import java.io.*;

public class JSONFileReader {
    private final String path;

    private JSONFileReader(String path) {
        this.path = path;
    }

    public JSONObject readObject() {
        String content = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
            content = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONObject(content);
    }
}
