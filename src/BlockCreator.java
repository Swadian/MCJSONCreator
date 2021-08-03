import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;

public class BlockCreator {
     public static void createBlock(String Mod_ID,String BlockName)
    {
        createBlockStates(Mod_ID,BlockName);
        createBlockModel(Mod_ID,BlockName);
        createItemModel(Mod_ID, BlockName);
        createLootTable(Mod_ID, BlockName);
        }
   static  void  createBlockStates(String Mod_ID,String BlockName)
    {
        JSONObject blockState = new JSONObject();
        JSONObject variants = new JSONObject();
        JSONObject model = new JSONObject();
        model.put("model",Mod_ID+":block/"+BlockName);
        variants.put("",model);
        blockState.put("variants",variants);
        {
            try{

                String filename = "./assets/" + Mod_ID + "/blockstates/";
                File dir = new File(filename);
                dir.mkdirs();
                File tmp = new File(dir, BlockName+".json");
                tmp.createNewFile();
                FileWriter states = new FileWriter(tmp);
                states.write(blockState.toJSONString());
                states.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    static void createBlockModel(String Mod_ID,String BlockName)
    {
        JSONObject model = new JSONObject();
        model.put("parent","block/cube_all");
        JSONObject textures = new JSONObject();
        textures.put("all",Mod_ID+":blocks/"+BlockName);
        model.put("textures",textures);
        {
            try{

                String filename = "./assets/" + Mod_ID + "/models/block/";
                File dir = new File(filename);
                dir.mkdirs();
                File tmp = new File(dir, BlockName+".json");
                tmp.createNewFile();
                FileWriter states = new FileWriter(tmp);
                states.write(model.toJSONString());
                states.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    static void createItemModel(String Mod_ID, String BlockName)
    {
        JSONObject model = new JSONObject();
        model.put("parent",Mod_ID+":block/"+BlockName);
        {
            try{

                String filename = "./assets/" + Mod_ID + "/models/item/";
                File dir = new File(filename);
                dir.mkdirs();
                File tmp = new File(dir, BlockName+".json");
                tmp.createNewFile();
                FileWriter states = new FileWriter(tmp);
                states.write(model.toJSONString());
                states.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    static void createLootTable(String Mod_ID,String BlockName) {
        JSONObject table = new JSONObject();
        table.put("type", "minecraft:block");
        //table
        JSONObject entry = new JSONObject();
        entry.put("type","minecraft.item");
        entry.put("name",Mod_ID+':'+BlockName);
        //entry
        JSONArray entries = new JSONArray();
        entries.add(entry);
        //entry array
        JSONObject pool = new JSONObject();
        pool.put("rolls",1);
        pool.put("entries",entries);
        //pool
        JSONArray pools = new JSONArray();
        pools.add(pool);
        //pool array
        table.put("pools",pools);
        //add pools
        {
            try{

                String filename = "./data/" + Mod_ID + "/loot_tables/blocks/";
                File dir = new File(filename);
                dir.mkdirs();
                File tmp = new File(dir, BlockName+".json");
                tmp.createNewFile();
                FileWriter states = new FileWriter(tmp);
                states.write(table.toJSONString());
                states.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
