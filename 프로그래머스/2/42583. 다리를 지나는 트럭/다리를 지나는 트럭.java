import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<int[]> bridge = new LinkedList<>();
        
        int tindex = 0;
        int tweight = truck_weights[tindex];
        int turn = 1;
        bridge.offer(new int[]{truck_weights[tindex++], 1 + bridge_length});
        turn++;
        
        while(tindex < truck_weights.length){
            
            if(!bridge.isEmpty() && bridge.peek()[1] <= turn){ 
                int[] node = bridge.poll();
                tweight -= node[0];
            }
            
            if(bridge.size() < bridge_length && tweight + truck_weights[tindex] <= weight){
                bridge.add(new int[]{truck_weights[tindex], turn + bridge_length});
                tweight += truck_weights[tindex];
                tindex++;
            }
            
            turn++;
        }
        
        while(!bridge.isEmpty()){
            int[] node = bridge.poll();
            turn = node[1];
        }
        
        
        return turn;
    }
}