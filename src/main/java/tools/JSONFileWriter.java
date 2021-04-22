package tools;

import org.json.JSONObject;

import java.io.*;

public class JSONFileWriter {
    private final String path;

    public JSONFileWriter(String path) {
        this.path = path;
    }

    public void writeJSON(JSONObject object) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(new File(path)));
            writer.println(object.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
