package leetcode.hashmap.easy;

import java.util.HashMap;
import java.util.Map;

public class HappyNumber_202 {

    static class Solution {
        public boolean isHappy(int n) {
            Map<Integer, Integer> map = new HashMap<>();
            boolean check = true;
            while(check){
                int sum = 0;
                String str = String.valueOf(n);
                for(int i = 0; i < str.length(); i++){
                    sum += Math.pow(Integer.parseInt(str.substring(i, i+1)), 2);
                }
                if(sum == 1){
                    break;
                }
                if(map.containsKey(n)){
                    return false;
                }
                map.put(n, sum);
                n = sum;
            }

            return check;
        }
    }
}
