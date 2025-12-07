package FileReaderJava;

import java.nio.file.Files;
import java.nio.file.Path;
import org.json.JSONObject;

public class ReadJSON {
    public static void main(String[] args) throws Exception {
        String json = Files.readString(Path.of("data.json"));
        JSONObject obj = new JSONObject(json);
        System.out.println(obj.getString("name"));
    }
}
