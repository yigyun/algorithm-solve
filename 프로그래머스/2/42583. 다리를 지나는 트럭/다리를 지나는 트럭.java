import java.util.*;

class Solution {
    
    static class Truck{
        int w;
        int t;
        int i;
        Truck(int w, int t, int i){
            this.w = w;
            this.t = t;
            this.i = i;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int bw = 0;
        int index = 0;
        int n = truck_weights.length;
        int d = 0;
        Queue<Truck> que = new LinkedList<>();
        
        while(index < n){
            d++;
            
            while(!que.isEmpty() && d - que.peek().t >= bridge_length){
                Truck tr = que.poll();
                bw -= tr.w;
            }
            
            if(bw + truck_weights[index] <= weight && que.size() + 1 <= bridge_length){
                que.offer(new Truck(truck_weights[index], d, index));
                bw += truck_weights[index];
                index++;
            }
        }
        
        while(!que.isEmpty()){
            d = que.poll().t + bridge_length;
        }
        
        return d;
    }
}