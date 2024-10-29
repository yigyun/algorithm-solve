import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int day = -1;
        List<Integer> list = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++){
            int num = 100 - progresses[i];
            int num2 = num / speeds[i];
            if(num % speeds[i] > 0) num2++;
            que.offer(num2);
        }
        
        day = que.poll();
        int count = 1;
        
        while(!que.isEmpty()){
            if(que.peek() <= day){
                que.poll();
                count++;
            }else{
                list.add(count);
                count = 1;
                day = que.poll();
            }
        }
        
        list.add(count);
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}