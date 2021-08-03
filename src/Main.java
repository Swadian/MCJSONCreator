import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;


public class Main {
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        {
            try {
                JSONObject data;
                data = (JSONObject) parser.parse(new FileReader("src/input.json"));
                String MOD_ID = (String)data.get("ID");
                JSONArray blocks = (JSONArray)data.get("Block List");
                for (String block : (Iterable<String>) blocks) {
                    BlockCreator.createBlock(MOD_ID, block);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
