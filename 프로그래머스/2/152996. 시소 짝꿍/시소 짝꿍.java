import java.util.*;

/**
    2, 3, 4
    
**/

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Map<Integer, Integer> weightMap = new HashMap<>();
        
        for(int i = 0; i < weights.length; i++){
            weightMap.put(weights[i], weightMap.getOrDefault(weights[i], 0) + 1);
        }
        
        List<Integer> uniqueWeights = new ArrayList<>(weightMap.keySet());
        Collections.sort(uniqueWeights);
        
        for (int i = 0; i < uniqueWeights.size(); i++) {
            int weight1 = uniqueWeights.get(i);
            for (int j = i + 1; j < uniqueWeights.size(); j++) {
                int weight2 = uniqueWeights.get(j);
                
                if (siso(weight1, weight2)) {
                    answer += (long) weightMap.get(weight1) * weightMap.get(weight2);
                }
            }
        }
        
        for (int count : weightMap.values()) {
            if (count > 1) {
                answer += (long) count * (count - 1) / 2;
            }
        }
        
        return answer;
    }
    
    static boolean siso(int n1, int n2){
        Set<Integer> set = new HashSet<>();
        for(int i = 2; i <= 4; i++){
            set.add(n1 * i);
        }
        
        for(int i = 2; i <= 4; i++){
            if(set.contains(n2 * i)){
                return true;
            }
        }
        return false;
    }
    
}