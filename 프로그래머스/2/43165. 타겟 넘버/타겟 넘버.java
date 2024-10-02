import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
            
        // 해당 숫자들로 타켓 숫자를 만들어야 함. 그리디하게 할까 아니면 모든 경우를 따질까
        // 큐에 담기는 거는 0번째는 인덱스, 1번째는 합
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, numbers[0]});
        que.offer(new int[]{0, numbers[0] * -1});
                
        while(!que.isEmpty()){
            int[] temp = que.poll();
            if(temp[0] == numbers.length-1){
                if(temp[1] == target) answer++;
                continue;
            }
            que.offer(new int[]{temp[0] + 1, temp[1] + (numbers[temp[0] + 1])});
            que.offer(new int[]{temp[0] + 1, temp[1] + (numbers[temp[0] + 1] * -1)});
        }
        
        
        
        return answer;
    }
}