import java.util.*;

class Solution {
    
    static class Task{
        int p;
        int s;
        Task(int p, int s){
            this.p = p;
            this.s = s;
        }
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
        Queue<Task> que = new LinkedList<>();
        int n = progresses.length;
        
        for(int i = 0; i < n; i++){
            que.offer(new Task(progresses[i], speeds[i]));
        }
        
        while(!que.isEmpty()){
            Task cur = que.poll();
            int t = (100 - cur.p) / cur.s;
            t = (100 - cur.p) % cur.s != 0 ? t + 1 : t;
            int count = 1;
            
            while(!que.isEmpty() && 100 <= que.peek().p + (que.peek().s * t)){
                count++;
                que.poll();
            }
            list.add(count);
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}