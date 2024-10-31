import java.util.*;

class Solution {
        
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                answer++;
                dfs(i, computers, visited);
            }
        }
        return answer;
    }
    
    static void dfs(int index, int[][] computers, boolean[] visited){
                
        for(int i = 0; i < computers[index].length; i++){
            if(!visited[i] && computers[index][i] == 1){
                visited[i] = true;
                if(i != index)
                    dfs(i, computers, visited);
            }
        }
    }
}