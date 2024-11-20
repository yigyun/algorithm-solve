class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups){
        
        long dis = 0;
        for(int i = n - 1; i >= 0;){
            if(deliveries[i] == 0 && pickups[i] == 0){
                i--; continue;
            }
            
            int cur = cap;
            int index = i;
            
            while(index >= 0){
                if(cur >= deliveries[index]){
                    cur -= deliveries[index];
                    deliveries[index--] = 0;
                }else{
                    deliveries[index] -= cur;
                    break;
                }
            }
            
            index = i;
            cur = cap;
            while(index >= 0){
                if(cur >= pickups[index]){
                    cur -= pickups[index];
                    pickups[index--] = 0;
                } else {
                    pickups[index] -= cur;
                    break;
                }
            }
            
            dis += (i + 1) * 2;
        }
        
        return dis;
    }
}