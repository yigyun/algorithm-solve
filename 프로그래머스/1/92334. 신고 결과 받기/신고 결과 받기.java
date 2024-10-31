import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] result = new int[id_list.length];
        
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> link = new HashMap<>();
        for(int i = 0; i < id_list.length; i++){
            link.put(id_list[i], i);
        }
        
        for(String str : report){
            String[] strs = str.split(" ");
            if(!map.containsKey(strs[0])){
                Set<String> set = new HashSet<>();
                set.add(strs[1]);
                map.put(strs[0], set);
                int index = link.get(strs[1]);
                answer[index]++;
            }else{
                Set<String> set = map.get(strs[0]);
                if(!set.contains(strs[1])){
                    int index = link.get(strs[1]);
                    answer[index]++;
                    set.add(strs[1]);
                }
            }
        }
        
        for(int i = 0; i < answer.length; i++){
            if(answer[i] >= k){
                for(String key : map.keySet()){
                    Set<String> set = map.get(key);
                    if(set.contains(id_list[i])){
                        int index = link.get(key);
                        result[index]++;
                    }
                }
            }
        }
        
        return result;
    }
}