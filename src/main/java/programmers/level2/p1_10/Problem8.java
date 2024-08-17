package programmers.level2;
import java.util.*;
public class Problem8 {
    static class Solution {
        public int solution(int n, int k, int[] enemy) {
            int answer = 0;
            int i;
            Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(i = 0; i < enemy.length; i++){
                pq.add(enemy[i]);
                answer += enemy[i];
                if(answer > n){
                    if(k > 0 && !pq.isEmpty()){
                        answer -= pq.poll();
                        k--;
                    }else{
                        break;
                    }
                }
            }

            return i;
        }
    }
}
