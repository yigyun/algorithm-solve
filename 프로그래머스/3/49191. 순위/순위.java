import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        Set<Integer>[] wins = new HashSet[n+1];
        Set<Integer>[] losers = new HashSet[n+1];
        for(int i = 1; i <= n; i++){
            wins[i] = new HashSet<>();
            losers[i] = new HashSet<>();
        }
        
        for(int i = 0; i < results.length; i++){
            wins[results[i][0]].add(results[i][1]);
            losers[results[i][1]].add(results[i][0]);
        }
        
        for(int i = 1; i <= n; i++){
            Set<Integer> set = new HashSet<>();
            set.add(i);
            Queue<Integer> que = new LinkedList<>();
            que.offer(i);
            while(!que.isEmpty()){
                int index = que.poll();
                for(int num : wins[index]){
                    if(set.contains(num)) continue;
                    set.add(num);
                    que.add(num);
                }
            }
            que.offer(i);
            while(!que.isEmpty()){
                int index = que.poll();
                for(int num : losers[index]){
                    if(set.contains(num)) continue;
                    set.add(num);
                    que.add(num);
                }
            }
            if(set.size() == n){
                answer++;
            }
        }
        
        return answer;
    }
}