import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for(int i = 0; i < works.length; i++){
            que.offer(works[i]);
        }
        
        for(int i = 0; i < n; i++){
            int num = que.poll();
            if(num == 0) break;
            que.offer(num - 1);
        }
        
        while(!que.isEmpty()){
            answer += (int)Math.pow(que.poll(), 2);
        }
        return answer;
    }
}