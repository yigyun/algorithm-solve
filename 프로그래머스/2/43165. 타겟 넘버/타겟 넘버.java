import java.util.*;

class Solution {
    
    static int count;
    static int n;
        
    public int solution(int[] numbers, int target) {
        int answer = 0;
        count = 0;
        n = target;
        // target으로 만들기
        
        boolean[] visited = new boolean[numbers.length];
        
        dfs(numbers, visited, 0, 0, numbers.length, 0);
        
        return count;
    }
    
    static void dfs(int[] numbers, boolean[] visited, int index, int depth, int limit, int num){
        if(depth == limit){
            if(num == n) count++;
            return;
        }
        
        for(int i = index; i < limit; i++){
            dfs(numbers, visited, i + 1, depth + 1, limit, num + numbers[i]);
            dfs(numbers, visited, i + 1, depth + 1, limit, num + (numbers[i] * -1));
        }
    }
}