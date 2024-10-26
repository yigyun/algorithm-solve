import java.util.*;

class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(char ch : after.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for(char ch : before.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) - 1);
        }
        
        for(char ch : after.toCharArray()){
            if(map.get(ch) != 0) return 0;
        }        
        return 1;
    }
}