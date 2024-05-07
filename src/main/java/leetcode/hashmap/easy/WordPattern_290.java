package leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern_290 {

    static class Solution {
        public boolean wordPattern(String pattern, String s) {

            Map<Character, String> map = new HashMap<>();

            String[] str = s.split(" ");

            if(str.length != pattern.length()) return false;

            for(int i = 0; i < pattern.length(); i++){
                char ch = pattern.charAt(i);
                if(!map.containsKey(ch)){
                    if(map.containsValue(str[i])) return false;
                    map.put(ch, str[i]);
                }else{
                    if(!str[i].equals(map.get(ch)))
                        return false;
                }
            }

            return true;
        }
    }
}
