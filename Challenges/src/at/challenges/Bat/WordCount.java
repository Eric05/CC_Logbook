package at.challenges.Bat;

import java.util.HashMap;
import java.util.Map;

public class WordCount {

    public static Map<String,Integer> getWordCount(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        int counter = 1;

        for (String s : strings){
            if (map.containsKey(s)){
                counter = map.get(s) + 1;
                map.put(s, counter );
            } else {
                map.put(s,1);
            }
        }
        return map;
    }
}
