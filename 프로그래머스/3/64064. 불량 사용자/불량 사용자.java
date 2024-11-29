import java.util.*;

class Solution {
    
    static int n;
    static int m;
    static int answer;
    static Set<String> set;
    
    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        n = user_id.length;
        m = banned_id.length;
        boolean[] visited = new boolean[n];
        dfs(user_id, banned_id, 0, banned_id.length, visited);
        return set.size();
    }
    
    static void dfs(String[] user_id, String[] banned_id, int depth, int limit, boolean[] visited){
        if(depth == limit){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++){
                if(visited[i]) sb.append(i);
            }
            set.add(sb.toString());
            return;
        }
        
        for(int i = 0; i < n; i++){
            boolean check = true;
            if(!visited[i] && banned_id[depth].length() == user_id[i].length()){
                for(int j = 0; j < user_id[i].length(); j++){
                    if(banned_id[depth].charAt(j) != user_id[i].charAt(j) && banned_id[depth].charAt(j) != '*'){
                        check = false;
                        break;
                    }
                }
                if(!check) continue;
                visited[i] = true;
                dfs(user_id, banned_id, depth + 1, limit, visited);
                visited[i] = false;
            } 
        }
    }
}