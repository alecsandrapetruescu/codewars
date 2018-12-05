package kyu7;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> entries;

    public Dictionary(){
        entries = new HashMap<>();
    }

    public void newEntry(String key, String value){
        entries.put(key, value);
    }

    public String look(String key){
        return entries.getOrDefault(key, String.format("Cant find entry for %s", key));
    }

}
