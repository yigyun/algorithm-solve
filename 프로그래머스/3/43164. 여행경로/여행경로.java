import java.util.*;

class Solution {
    
    static String[] answer;
    
    public String[] solution(String[][] tickets) {
        
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        
        for(String[] ticket : tickets){
            map.putIfAbsent(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).offer(ticket[1]);
        }
        
        List<String> result = new ArrayList<>();
        
        dfs(map, "ICN", result);
        
        Collections.reverse(result);
        
        String[] answer = new String[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    static void dfs(Map<String, PriorityQueue<String>> map, String cur, List<String> result){
        PriorityQueue<String> next = map.get(cur);
        
        while(next != null && !next.isEmpty()){
            dfs(map, next.poll(), result);
        }
        
        result.add(cur);
    }
}