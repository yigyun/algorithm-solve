import java.util.*;

class Solution {
    
    static Map<String, Integer> strs;
    static Map<Integer, Integer> set;
    
    public String[] solution(String[] orders, int[] course) {        
        List<String> list = new ArrayList<>();
        
        strs = new HashMap<>();
        set = new HashMap<>();
        
        for(int num : course){
            set.put(num, 0);
        }
        
        for(int i = 0; i < orders.length; i++){
            dfs("", orders[i], 0, 0, orders[i].length());
        }
        
        for(int key : set.keySet()){
            int size = set.get(key);
            if(size < 2) continue;
            for(String str : strs.keySet()){
                if(str.length() == key && strs.get(str) == size){
                    list.add(str);
                }
            }
        }
        
        Collections.sort(list);
        
        String[] answer = new String[list.size()];

        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        
        
        return answer;
    }
    
    static void dfs(String str, String ori, int index, int depth, int limit){
        if(set.containsKey(depth)){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String newTemp = new String(temp);
            
            strs.put(newTemp, strs.getOrDefault(newTemp, 0) + 1);
            if(strs.get(newTemp) > set.get(depth)) set.put(depth, strs.get(newTemp));
        }
        
        for(int i = index; i < limit; i++){
            dfs(str + ori.substring(i, i+1), ori, i + 1, depth + 1, limit);
        }
    }
    
    
}