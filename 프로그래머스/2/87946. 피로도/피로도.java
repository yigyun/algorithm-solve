import java.util.*;
import java.io.*;

class Solution {
    
    /**
    피로도 시스템, 던전을 탐색하면 피로도 감소.
    최소 필요 피로도는 던전을 탐험하기 위해 가져야 하는 최소한의 피로도
    소모 피로도는 던전 탐색 후 감소
    유저가 탐험 가능한 최대 던전 수
    **/
    
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        
        for(int i = 0; i < dungeons.length; i++){
            boolean[] visited = new boolean[dungeons.length];
            if(k - dungeons[i][0] >= 0){
                visited[i] = true;
                dfs(dungeons, visited, 1, k - dungeons[i][1]);
            }
        }
        
        return answer;
    }
    
    static void dfs(int[][] dungeons, boolean[] visited, int depth, int piro){
        if(depth > dungeons.length){
            answer = Math.max(answer, depth);
            return;
        }
        if(piro <= 0){
            answer = Math.max(answer, depth);
            return;
        }
        answer = Math.max(answer, depth);
        
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && piro - dungeons[i][0] >= 0){
                visited[i] = true;
                dfs(dungeons, visited, depth + 1, piro - dungeons[i][1]);
                visited[i] = false;
            }
        }
    }
}