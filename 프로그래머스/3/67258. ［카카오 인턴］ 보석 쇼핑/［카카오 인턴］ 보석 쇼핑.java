import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        Set<String> gemList = new HashSet<>(Arrays.asList(gems));
        int size = gemList.size();
        
        Map<String, Integer> gem = new HashMap<>();
        int start = 0;
        int end = 0;
        int min = gems.length + 1;
        int[] answer = new int[]{0, 0};
        
        while(end < gems.length){
            gem.put(gems[end], gem.getOrDefault(gems[end], 0) + 1);
            end++;
            
            while(gem.size() == size){
                if(end - start < min){
                    min = end - start;
                    answer[0] = start + 1;
                    answer[1] = end;
                }
                
                gem.put(gems[start], gem.getOrDefault(gems[start], 0) - 1);
                if(gem.get(gems[start]) == 0){
                    gem.remove(gems[start]);
                }
                start++;
            }
        }
        
        return answer;
    }
}