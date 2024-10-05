import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        // 할인하는 제품은 하루에 하나씩 구매
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < want.length; i++){
            map.put(want[i], i);
        }
        
        for(int start = 0; start <= discount.length - 10; start++){
            int[] tempNumber= number.clone();
            int count = 0;
            
            for(int i = start; i < start + 10; i++){
                if(map.containsKey(discount[i])){
                    int index = map.get(discount[i]);
                    tempNumber[index]--;
                }
            }
            
            boolean check = true;
            for(int i = 0; i < tempNumber.length; i++){
                if(tempNumber[i] > 0){
                    check = false;
                    break;
                }
            }
            
            if(check) answer++;
        }
        
        return answer;
    }
}