import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        
        List<Integer> points = new ArrayList<>();
        
        for(int i = 0; i < cards.length; i++){
            cards[i] -= 1;
        }
        
        boolean[] visited = new boolean[cards.length];
        
        for(int i = 0; i < cards.length; i++){
            if(!visited[i]){
                Queue<Integer> que = new LinkedList<>();
                que.offer(cards[i]);
                visited[i] = true;
                int count = 1;
                
                while(!que.isEmpty()){
                    int num = que.poll();
                    if(!visited[num]){
                        que.offer(cards[num]);
                        visited[num] = true;
                        count++;
                    }
                }
                points.add(count);
            }
        }
        
        if(points.size() <= 1) return 0;
        
        Collections.sort(points, (o1, o2) -> {return o2 - o1;});
        
        answer = points.get(0) * points.get(1);
        
        return answer;
    }
}