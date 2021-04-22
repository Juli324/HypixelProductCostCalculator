package tools;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class JSONFileWriter {
    private final String path;

    public JSONFileWriter(String path) {
        this.path = path;
    }

    public void writeJSON(JSONObject object) {
        try {
            PrintWriter writer = new PrintWriter(new File(path));
            writer.println(object.toString());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
