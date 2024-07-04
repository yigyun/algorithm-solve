package leetcode.hashmap.easy;

import java.util.*;

public class ContainsDuplicate2_219 {
    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                if(!map.containsKey(nums[i])){
                    map.put(nums[i], i);
                }else{
                    int index = map.get(nums[i]);
                    int result = (int)Math.abs(i - index);
                    map.put(nums[i], i);
                    if(result <= k) return true;
                }
            }

            return false;
        }
    }
}
