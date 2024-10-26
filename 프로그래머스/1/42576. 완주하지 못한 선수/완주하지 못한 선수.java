import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> comple = new HashMap<>();
        
        for(String str : completion){
            comple.put(str, comple.getOrDefault(str, 0) + 1);
        }
        
        for(String str : participant){
            if(!comple.containsKey(str)) return str;
            else{
                if(comple.get(str) == 0) return str;
                comple.put(str, comple.getOrDefault(str, 0) - 1);
            }
        }
        
        return answer;
    }
}